package zen.lang;

import java.util.ArrayList;

import zen.ast.ZenErrorNode;
import zen.ast.ZenNode;
import zen.parser.ZenLogger;
import zen.parser.ZenNameSpace;
import zen.parser.ZenToken;
import zen.parser.ZenUtils;
import zen.parser.ZenVisitor;

public abstract class ZenTypeChecker implements ZenVisitor {
	public final static int DefaultTypeCheckPolicy			= 0;
	public final static int NoCheckPolicy                   = 1;
	public final static int CastPolicy                      = (1 << 1);
	public final static int IgnoreEmptyPolicy               = (1 << 2);
	public final static int AllowEmptyPolicy                = (1 << 3);
	public final static int AllowVoidPolicy                 = (1 << 4);
	public final static int AllowCoercionPolicy             = (1 << 5);
	public final static int OnlyConstPolicy                 = (1 << 6);
	public final static int NullablePolicy                  = (1 << 8);
	public final static int BlockPolicy                     = (1 << 7);

	/*field*/private ZenNameSpace NameSpace_;
	/*field*/private ZenType ContextType_;
	/*field*/private ZenNode TypedNode_;

	/*field*/public ZenLogger Logger;
	/*field*/private boolean StoppedVisitor;

	public ZenTypeChecker(ZenLogger Logger) {
		this.Logger = Logger;
		this.NameSpace_ = null;
		this.ContextType_ = null;
		this.TypedNode_ = null;
		this.StoppedVisitor = false;
	}

	@Override public final void EnableVisitor() {
		this.StoppedVisitor = false;
	}

	@Override public final void StopVisitor() {
		this.StoppedVisitor = true;
	}

	@Override public final boolean IsVisitable() {
		return !this.StoppedVisitor;
	}

	public final ZenNameSpace GetNameSpace() {
		return this.NameSpace_;
	}

	public final ZenType GetContextType() {
		return this.ContextType_;
	}

	public final void TypedNode(ZenNode Node, ZenType Type) {
		Node.Type = Type;
		if(this.IsVisitable()) {
			this.TypedNode_ = Node;
		}
	}

	public final void Todo(ZenNode Node) {
		this.Logger.ReportWarning(Node.SourceToken, "TODO: unimplemented type checker node: " + Node.getClass().getSimpleName());
		Node.Type = ZenSystem.AnyType;
		if(this.IsVisitable()) {
			this.TypedNode_ = Node;
		}
	}

	public final void CheckErrorNode(ZenNode Node) {
		if(Node.IsErrorNode()) {
			this.TypedNode_ = Node;
			this.StopVisitor();
		}
	}

	public final void TypeCheckNodeList(ZenNameSpace NameSpace, ArrayList<ZenNode> ParamList) {
		if(this.IsVisitable()) {
			int i = 0;
			while(i < ParamList.size()) {
				ZenNode SubNode = ParamList.get(i);
				SubNode = this.TypeCheck(SubNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
				ParamList.set(i, SubNode);
				i = i + 1;
			}
		}
	}

	private int FilterFuncParamType(ArrayList<ZenFunc> FuncList, int StartIdx, int EndIdx, int ParamIdx, ZenType ParamType) {
		int StartFuncSize = FuncList.size();
		int i = StartIdx;
		while(i < EndIdx) {
			ZenFunc Func = FuncList.get(i);
			if(Func.GetFuncParamType(ParamIdx) == ParamType) {
				FuncList.add(Func);
			}
			i = i + 1;
		}
		return FuncList.size() - StartFuncSize;
	}

	private ZenType GuessFuncTypeMatchedParam(ZenNameSpace NameSpace, ArrayList<ZenFunc> FuncList, ArrayList<ZenNode> ParamList, int ResolvedSize) {
		int StartIdx = 0;
		int NextIdx = FuncList.size();
		int FuncParamSize = ParamList.size();
		while(ResolvedSize < FuncParamSize) {
			ZenNode SubNode = this.TypeCheck(ParamList.get(ResolvedSize), NameSpace, ZenSystem.VarType, 0);
			if(SubNode.Type.IsVarType()) {
				return ZenSystem.VarType; // unspecified
			}
			int Count = this.FilterFuncParamType(FuncList, StartIdx, NextIdx, ResolvedSize, SubNode.Type);
			if(Count == 1) {
				return FuncList.get(FuncList.size()-1).ZenType;
			}
			if(Count == 0) {
				return ZenSystem.VarType;
			}
			StartIdx = NextIdx;
			NextIdx = FuncList.size();
		}
		return null;
	}

	private boolean IsAcceptFunc(ZenFunc Func, ArrayList<ZenNode> ParamList) {
		int i = 0;
		while(i < ParamList.size()) {
			ZenType FuncType = Func.GetFuncParamType(i);
			ZenType ParamType = ParamList.get(i).Type;
			if(Func.GetFuncParamType(i) != ParamList.get(i).Type) {
				if(FuncType != ParamType && !FuncType.Accept(ParamType)) {
					return false;
				}
			}
			i = i + 1;
		}
		return true;
	}

	protected ZenType GuessFuncType(ZenNameSpace NameSpace, String FuncName, ArrayList<ZenNode> ParamList) {
		ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
		int FuncParamSize = ParamList.size();
		NameSpace.RetrieveFuncList(FuncList, null, FuncName, FuncParamSize);
		int BaseSize = FuncList.size();
		if(BaseSize > 1 && FuncParamSize > 0) {
			ZenType GuessedType = this.GuessFuncTypeMatchedParam(NameSpace, FuncList, ParamList, 0);
			if(GuessedType != null) {
				return GuessedType;
			}
			int i = 0;
			while(i < BaseSize) {
				ZenFunc Func = FuncList.get(i);
				if(this.IsAcceptFunc(Func, ParamList)) {
					return Func.ZenType;
				}
				i = i + 1;
			}
		}
		return ZenSystem.VarType; // unspecified
	}

	protected ZenType GuessMethodFuncType(ZenNameSpace NameSpace, ZenNode RecvNode, String FuncName, ArrayList<ZenNode> ParamList) {
		ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
		int FuncParamSize = ParamList.size() + 1;
		ZenType ClassType = RecvNode.Type;
		while(ClassType != null) {
			NameSpace.RetrieveFuncList(FuncList, ClassType, FuncName, FuncParamSize);
			ClassType = ClassType.GetSuperType();
		}
		int BaseSize = FuncList.size();
		if(BaseSize > 1 && FuncParamSize > 1) {
			ParamList.add(0, RecvNode);
			ZenType GuessedType = this.GuessFuncTypeMatchedParam(NameSpace, FuncList, ParamList, 1);
			if(GuessedType == null) {
				GuessedType = ZenSystem.VarType;
				int i = 0;
				while(i < BaseSize) {
					ZenFunc Func = FuncList.get(i);
					if(this.IsAcceptFunc(Func, ParamList)) {
						GuessedType = Func.ZenType;
						break;
					}
					i = i + 1;
				}
			}
			ParamList.remove(0);
			return GuessedType;
		}
		return ZenSystem.VarType; // unspecified
	}

	public final ZenType TypeCheckFuncParam(ZenNameSpace NameSpace, ArrayList<ZenNode> ParamList, ZenType ContextType, int ParamIdx /* 1: Func 2: Method*/) {
		if(this.IsVisitable() && ContextType.IsFuncType()) {
			ZenFuncType FuncType = (ZenFuncType)ContextType;
			if(FuncType.GetParamSize() == ParamList.size() + ParamIdx) {
				int i = 0;
				while(i < ParamList.size()) {
					ZenNode SubNode = ParamList.get(i);
					SubNode = this.TypeCheck(SubNode, NameSpace, FuncType.GetParamType(i+ParamIdx), ZenTypeChecker.DefaultTypeCheckPolicy);
					ParamList.set(i, SubNode);
					i = i + 1;
				}
				return FuncType.GetReturnType();
			}
		}
		this.TypeCheckNodeList(NameSpace, ParamList);
		return ZenSystem.VarType;
	}

	public final ZenNode TypeCheck(ZenNode Node, ZenNameSpace NameSpace, ZenType ContextType, int TypeCheckPolicy) {
		if(this.IsVisitable()) {
			ZenNode ParentNode = Node.ParentNode;
			ZenNameSpace NameSpace_ = this.NameSpace_;
			ZenType ContextType_ = this.ContextType_;
			ZenNode TypedNode_ = this.TypedNode_;
			this.NameSpace_ = NameSpace;
			this.ContextType_ = ContextType;
			if(Node.Type == null || Node.Type.IsVarType()) {
				Node.Accept(this);
				Node = this.TypedNode_;
			}
			Node = this.TypeCheckImpl(Node, ContextType, TypeCheckPolicy);
			this.NameSpace_ = NameSpace_;
			this.ContextType_ = ContextType_;
			this.TypedNode_ = TypedNode_;
			if(ParentNode != Node.ParentNode && ParentNode != null) {
				ParentNode.SetChild(Node);
			}
		}
		this.CheckErrorNode(Node);
		return Node;
	}

	private final ZenNode TypeCheckImpl(ZenNode Node, ZenType ContextType, int TypeCheckPolicy) {
		if(Node.IsErrorNode()) {
			return Node;
		}
		//		if(Node.Type.IsUnrevealedType()) {
		//			/*local*/ZenFunc Func = ParsedTree.NameSpace.GetConverterFunc(Node.Type, Node.Type.BaseType, true);
		//			Node = this.Generator.CreateCoercionNode(Func.GetReturnType(), ParsedTree.NameSpace, Func, Node);
		//		}
		//		System.err.println("**** " + Node.getClass());
		//		/*local*/Object ConstValue = Node.ToConstValue(this.Context, IsFlag(TypeCheckPolicy, OnlyConstPolicy));
		//		if(ConstValue != null && !(Node.IsConstNode())) {  // recreated
		//			Node = this.Generator.CreateConstNode_OLD(Node.Type, ParsedTree, ConstValue);
		//		}
		//		if(IsFlag(TypeCheckPolicy, OnlyConstPolicy) && ConstValue == null) {
		//			if(IsFlag(TypeCheckPolicy, NullablePolicy) && Node.IsNullNode()) { // OK
		//			}
		//			else {
		//				return this.CreateSyntaxErrorNode(ParsedTree, "value must be const");
		//			}
		//		}
		if(ZenUtils.IsFlag(TypeCheckPolicy, ZenTypeChecker.AllowVoidPolicy) || Node.Type.IsVoidType()) {
			return Node;
		}
		if(Node.Type == ContextType || ContextType.IsVarType() || ContextType.Accept(Node.Type)) {
			return Node;
		}
		//		/*local*/ZenFunc Func1 = this.GetConverterFunc(Node.Type, ContextType, true);
		//		if(Func1 != null && (Func1.Is(CoercionFunc) || IsFlag(TypeCheckPolicy, CastPolicy))) {
		//			return this.Generator.CreateCoercionNode(Type, ParsedTree.NameSpace, Func1, Node);
		//		}
		//System.err.println("node="+ LibZen.GetClassName(Node) + "type error: requested = " + Type + ", given = " + Node.Type);
		return new ZenErrorNode(Node.SourceToken, "type error: requested = " + ContextType + ", given = " + Node.Type);
	}

	protected final ZenType GetFieldType(ZenNameSpace NameSpace, ZenType BaseType, String Name) {
		return NameSpace.Generator.GetFieldType(BaseType, Name);
	}

	protected final ZenType GetSetterType(ZenNameSpace NameSpace, ZenType BaseType, String Name) {
		return NameSpace.Generator.GetSetterType(BaseType, Name);
	}

	protected ZenType GetReturnType(ZenNameSpace NameSpace) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void InferReturnType(ZenNameSpace NameSpace, ZenType InferredType) {
		// TODO Auto-generated method stub
	}

	protected ZenNode CreateDefaultValueNode(ZenType Type) {
		// TODO Auto-generated method stub
		return null;
	}

	protected ZenNode CreateReadOnlyErrorNode(ZenNode Node, ZenType ClassType, String VarName) {
		return new ZenErrorNode(Node.SourceToken, "readonly: " + VarName);
	}

	protected ZenNode CreateUndefinedVarErrorNode(ZenNode Node, String VarName) {
		return new ZenErrorNode(Node.SourceToken, "undefined name: " + VarName);
	}

	protected ZenVarInfo GetVarInfo(ZenNameSpace NameSpace, String VarName) {
		Object VarInfo = NameSpace.GetSymbol(VarName);
		if(VarInfo instanceof ZenVarInfo) {
			return (ZenVarInfo)VarInfo;
		}
		return null;
	}

	protected void SetVarInfo(ZenNameSpace NameSpace, ZenType VarType, String VarName, ZenToken SourceToken) {
		ZenVarInfo VarInfo = new ZenVarInfo(NameSpace.GetDefiningFunc(), 0, VarType, VarName, SourceToken);
		NameSpace.SetSymbol(VarName, VarInfo, SourceToken);
		//		return VarInfo;
	}

	//	public int RetrieveFuncList(ZenNameSpace NameSpace, String FuncName, ArrayList<ZenFunc> FuncList, int StartIdx, ArrayList<ZenType> TypeList, int ResolvedSize, int FuncParamSize) {
	//		if(ResolvedSize == 0) {
	//			NameSpace.RetrieveFuncList(FuncList, null, FuncName, FuncParamSize);
	//		}
	//		if(ResolvedSize > 0) {
	//			int i = StartIdx;
	//			int FuncListSize = FuncList.size();
	//			while(i < FuncListSize) {
	//				ZenFunc Func = FuncList.get(i);
	//				if(Func.GetFuncParamType(ResolvedSize-1) == TypeList.get(ResolvedSize-1)) {
	//					FuncList.add(Func);
	//				}
	//				i = i + 1;
	//			}
	//			return FuncList.size() - FuncListSize;
	//		}
	//		return FuncList.size();
	//	}




	public ZenNode CanDefineFunc(ZenNameSpace NameSpace, String FuncName, ZenFuncType funcType) {
		// TODO Auto-generated method stub
		return null;
	}

	public ZenFunc Define(ZenNameSpace nameSpace, String funcName,
			ZenFuncType funcType) {
		// TODO Auto-generated method stub
		return null;
	}

	public ZenFunc SetFuncParamType(ZenNameSpace NameSpace, ZenFunc DefinedFunc, ArrayList<ZenNode> ArgumentList) {
		// TODO Auto-generated method stub
		return null;
	}

	public void PopFunc(ZenFunc upperFunc) {
		// TODO Auto-generated method stub

	}

	public ZenFuncType CheckFunctionType(ZenFuncType funcType,
			ZenType contextType) {
		// TODO Auto-generated method stub
		return null;
	}

	public void UpdateParamType() {
		// TODO Auto-generated method stub

	}

	public void TypeSync(ZenType varType, ZenNode valueNode) {
		// TODO Auto-generated method stub

	}

}