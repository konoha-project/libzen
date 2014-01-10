package zen.lang;

import java.util.ArrayList;

import zen.ast.ZenErrorNode;
import zen.ast.ZenGetLocalNode;
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
			for(int i = 0; i < ParamList.size(); i = i + 1) {
				ZenNode SubNode = ParamList.get(i);
				SubNode = this.TypeCheck(SubNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
				ParamList.set(i, SubNode);
			}
		}
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

	public void UntypedNameNode(String nativeName, ZenGetLocalNode node) {
		// TODO Auto-generated method stub

	}


	public ZenNode CanDefineFunc(ZenNameSpace nameSpace, String FuncName, ZenFuncType funcType) {
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