// ***************************************************************************
// Copyright (c) 2013-2014, Konoha project authors. All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// *  Redistributions of source code must retain the above copyright notice,
//    this list of conditions and the following disclaimer.
// *  Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
// PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
// CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
// OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
// WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
// OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
// ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// **************************************************************************

//ifdef JAVA

package zen.lang;

import java.util.ArrayList;

import zen.ast.ZenApplyNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenNode;
import zen.ast.ZenParamNode;
import zen.deps.Field;
import zen.deps.Var;
import zen.parser.ZenLogger;
import zen.parser.ZenNameSpace;
import zen.parser.ZenToken;
import zen.parser.ZenUtils;
import zen.parser.ZenVisitor;

public abstract class ZenTypeChecker implements ZenVisitor {
	public final static int DefaultTypeCheckPolicy			= 0;
	public final static int NoCheckPolicy                   = 1;
	//	public final static int CastPolicy                      = (1 << 1);
	//	public final static int IgnoreEmptyPolicy               = (1 << 2);
	//	public final static int AllowEmptyPolicy                = (1 << 3);
	//	public final static int AllowVoidPolicy                 = (1 << 4);
	//	public final static int AllowCoercionPolicy             = (1 << 5);
	//	public final static int OnlyConstPolicy                 = (1 << 6);
	//	public final static int NullablePolicy                  = (1 << 8);
	//	public final static int BlockPolicy                     = (1 << 7);

	@Field private ZenNameSpace StackedNameSpace;
	@Field private ZenType StackedContextType;
	@Field private ZenNode StackedTypedNode;

	@Field public ZenLogger Logger;
	@Field private boolean StoppedVisitor;

	@Field ArrayList<ZenVarType> VarTypeList;

	public ZenTypeChecker(ZenLogger Logger) {
		this.Logger = Logger;
		this.StackedNameSpace = null;
		this.StackedContextType = null;
		this.StackedTypedNode = null;
		this.StoppedVisitor = false;
		this.VarTypeList = new ArrayList<ZenVarType>();
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
		return this.StackedNameSpace;
	}

	public final ZenType GetContextType() {
		return this.StackedContextType;
	}

	protected final ZenType VarType(String Name) {
		ZenVarType VarType = new ZenVarType(Name);
		this.VarTypeList.add(VarType);
		return VarType;
	}

	public final void TypedNode(ZenNode Node, ZenType Type) {
		Node.Type = Type;
		if(this.IsVisitable()) {
			this.StackedTypedNode = Node;
		}
	}

	public final void Todo(ZenNode Node) {
		this.Logger.ReportWarning(Node.SourceToken, "TODO: unimplemented type checker node: " + Node.getClass().getSimpleName());
		Node.Type = ZenSystem.VarType;
		if(this.IsVisitable()) {
			this.StackedTypedNode = Node;
		}
	}

	public final void CheckErrorNode(ZenNode Node) {
		if(Node.IsErrorNode()) {
			this.StackedTypedNode = Node;
			this.StopVisitor();
		}
	}

	public final void TypeCheckNodeList(ZenNameSpace NameSpace, ArrayList<ZenNode> ParamList) {
		if(this.IsVisitable()) {
			@Var int i = 0;
			while(i < ParamList.size()) {
				ZenNode SubNode = ParamList.get(i);
				SubNode = this.TypeCheck(SubNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
				ParamList.set(i, SubNode);
				i = i + 1;
			}
		}
	}

	private void DumpFuncList(ArrayList<ZenFunc> FuncList, int StartIdx, int EndIdx) {
		@Var int i = StartIdx;
		while(i < EndIdx) {
			@Var ZenFunc Func = FuncList.get(i);
			System.err.println("["+i+"] " + Func);
			i = i + 1;
		}
		System.err.println("" + StartIdx + " ===> " + EndIdx);
	}

	private int FilterFuncParamType(ArrayList<ZenFunc> FuncList, int StartIdx, int EndIdx, int ParamIdx, ZenType ParamType) {
		@Var int StartFuncSize = FuncList.size();
		@Var int i = StartIdx;
		while(i < EndIdx) {
			@Var ZenFunc Func = FuncList.get(i);
			if(Func.GetFuncParamType(ParamIdx) == ParamType) {
				FuncList.add(Func);
			}
			i = i + 1;
		}
		return FuncList.size() - StartFuncSize;
	}

	private ZenType GuessFuncTypeMatchedParam(ZenNameSpace NameSpace, ArrayList<ZenFunc> FuncList, ZenApplyNode Node, int ResolvedSize) {
		@Var int StartIdx = 0;
		@Var int NextIdx = FuncList.size();
		@Var int FuncParamSize = Node.ParamList.size();
		while(ResolvedSize < FuncParamSize) {
			@Var ZenNode SubNode = this.TypeCheck(Node.ParamList.get(ResolvedSize), NameSpace, ZenSystem.VarType, 0);
			if(SubNode.Type.IsVarType()) {
				return ZenSystem.VarType; // unspecified
			}
			@Var int Count = this.FilterFuncParamType(FuncList, StartIdx, NextIdx, ResolvedSize, SubNode.Type);
			if(Count == 1) {
				Node.ResolvedFunc = FuncList.get(FuncList.size()-1);
				return Node.ResolvedFunc.ZenType;
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
		@Var int i = 0;
		while(i < ParamList.size()) {
			@Var ZenType FuncType = Func.GetFuncParamType(i);
			@Var ZenType ParamType = ParamList.get(i).Type;
			if(Func.GetFuncParamType(i) != ParamList.get(i).Type) {
				if(FuncType != ParamType && !FuncType.Accept(ParamType)) {
					return false;
				}
			}
			i = i + 1;
		}
		return true;
	}

	protected ZenType GuessFuncType(ZenNameSpace NameSpace, String FuncName, ZenApplyNode Node) {
		@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
		@Var int FuncParamSize = Node.ParamList.size();
		NameSpace.RetrieveFuncList(FuncList, null, FuncName, FuncParamSize);
		@Var int BaseSize = FuncList.size();
		if(BaseSize == 1) {
			Node.ResolvedFunc = FuncList.get(0);
			return Node.ResolvedFunc.ZenType;
		}
		this.DumpFuncList(FuncList, 0, BaseSize);
		if(BaseSize > 1 && FuncParamSize > 0) {
			@Var ZenType GuessedType = this.GuessFuncTypeMatchedParam(NameSpace, FuncList, Node, 0);
			if(GuessedType == null) {
				GuessedType = ZenSystem.VarType;
				@Var int i = 0;
				while(i < BaseSize) {
					@Var ZenFunc Func = FuncList.get(i);
					if(this.IsAcceptFunc(Func, Node.ParamList)) {
						Node.ResolvedFunc = FuncList.get(0);
						GuessedType = Func.ZenType;
						break;
					}
					i = i + 1;
				}
			}
			return GuessedType;
		}
		return ZenSystem.VarType; // unspecified
	}

	protected ZenType GuessMethodFuncType(ZenNameSpace NameSpace, ZenNode RecvNode, String FuncName, ZenApplyNode Node) {
		@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
		@Var int FuncParamSize = Node.ParamList.size() + 1;
		@Var ZenType ClassType = RecvNode.Type;
		while(ClassType != null) {
			NameSpace.RetrieveFuncList(FuncList, ClassType, FuncName, FuncParamSize);
			ClassType = ClassType.GetSuperType();
		}
		@Var int BaseSize = FuncList.size();
		if(BaseSize == 1) {
			Node.ResolvedFunc = FuncList.get(0);
			return Node.ResolvedFunc.ZenType;
		}
		if(BaseSize > 1 && FuncParamSize > 1) {
			Node.ParamList.add(0, RecvNode);
			@Var ZenType GuessedType = this.GuessFuncTypeMatchedParam(NameSpace, FuncList, Node, 1);
			if(GuessedType == null) {
				GuessedType = ZenSystem.VarType;
				@Var int i = 0;
				while(i < BaseSize) {
					@Var ZenFunc Func = FuncList.get(i);
					if(this.IsAcceptFunc(Func, Node.ParamList)) {
						Node.ResolvedFunc = Func;
						GuessedType = Func.ZenType;
						break;
					}
					i = i + 1;
				}
			}
			Node.ParamList.remove(0);
			return GuessedType;
		}
		return ZenSystem.VarType; // unspecified
	}

	public final ZenType TypeCheckFuncParam(ZenNameSpace NameSpace, ArrayList<ZenNode> ParamList, ZenType ContextType, int ParamIdx /* 1: Func 2: Method*/) {
		System.err.println("debug TypeCheckFuncParam: " + ContextType);
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
			ZenNameSpace NameSpace_ = this.StackedNameSpace;
			ZenType ContextType_ = this.StackedContextType;
			ZenNode TypedNode_ = this.StackedTypedNode;
			this.StackedNameSpace = NameSpace;
			this.StackedContextType = ContextType;
			if(Node.Type == null || Node.Type.IsVarType()) {
				Node.Accept(this);
				Node = this.StackedTypedNode;
			}
			Node = this.TypeCheckImpl(Node, ContextType, TypeCheckPolicy);
			this.StackedNameSpace = NameSpace_;
			this.StackedContextType = ContextType_;
			this.StackedTypedNode = TypedNode_;
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
		if(Node.Type == ContextType || ContextType.IsVarType() || ContextType.Accept(Node.Type) || ZenUtils.IsFlag(TypeCheckPolicy, NoCheckPolicy)) {
			return Node;
		}
		if(ContextType.IsVoidType() && !Node.Type.IsVoidType()) {
			return new ZenCastNode(ZenSystem.VoidType, Node);
		}

		//		System.err.println("**** " + Node.getClass());
		//		@Var Object ConstValue = Node.ToConstValue(this.Context, IsFlag(TypeCheckPolicy, OnlyConstPolicy));
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
		@Var ZenFunc Func1 = this.GetCoercionFunc(Node.Type, ContextType);
		if(Func1 != null) {

		}
		//System.err.println("node="+ LibZen.GetClassName(Node) + "type error: requested = " + Type + ", given = " + Node.Type);
		return new ZenErrorNode(Node.SourceToken, "type error: requested = " + ContextType + ", given = " + Node.Type);
	}

	private ZenFunc GetCoercionFunc(ZenType Type, ZenType ContextType) {
		return null;
	}

	protected ZenType GetIndexType(ZenNameSpace NameSpace, ZenType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsStringType()) {
			return ZenSystem.IntType;
		}
		if(RecvType.IsMapType()) {
			return ZenSystem.StringType;
		}
		return ZenSystem.VarType;
	}

	protected ZenType GetElementType(ZenNameSpace NameSpace, ZenType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsMapType()) {
			return RecvType.GetParamType(0);
		}
		if(RecvType.IsStringType()) {
			return ZenSystem.StringType;
		}
		return ZenSystem.VarType;
	}

	protected final ZenType GetFieldType(ZenNameSpace NameSpace, ZenType BaseType, String Name) {
		return NameSpace.Generator.GetFieldType(BaseType, Name);
	}

	protected final ZenType GetSetterType(ZenNameSpace NameSpace, ZenType BaseType, String Name) {
		return NameSpace.Generator.GetSetterType(BaseType, Name);
	}

	protected void InferFieldType(ZenNameSpace NameSpace, ZenType ClassType, String FieldName, ZenType ValueType) {
		//TODO
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
		@Var Object VarInfo = NameSpace.GetSymbol(VarName);
		if(VarInfo instanceof ZenVarInfo) {
			return (ZenVarInfo)VarInfo;
		}
		return null;
	}

	protected void SetVarInfo(ZenNameSpace NameSpace, ZenType VarType, String VarName, ZenToken SourceToken) {
		@Var ZenVarInfo VarInfo = new ZenVarInfo(NameSpace.GetDefiningFunc(), 0, VarType, VarName, SourceToken);
		NameSpace.SetSymbol(VarName, VarInfo, SourceToken);
	}

	protected ZenFuncType LookupTypeFunc(ZenType ReturnType, ArrayList<ZenNode> NodeList) {
		@Var ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
		TypeList.add(ReturnType);
		@Var int i = 0;
		while(i < NodeList.size()) {
			ZenParamNode Node = (ZenParamNode)NodeList.get(i);
			if(Node.Type == null) {
				Node.Type = ZenSystem.VarType; //this.VarType(Node.Name);
			}
			TypeList.add(Node.Type);
			i = i + 1;
		}
		return ZenSystem.LookupFuncType(TypeList);
	}

	public ZenFuncType CheckFuncType(ZenFuncType FuncType, ZenType ContextType) {
		if(ContextType.IsFuncType()) {
			// TODO
		}
		return FuncType;
	}

	protected ZenNode CanDefineFunc(ZenNameSpace NameSpace, String FuncName, ZenFuncType FuncType, ZenFuncDeclNode Node) {
		return Node;
	}

	public ZenFunc DefineFunc(ZenNameSpace NameSpace, String FuncName, ZenFuncType FuncType, ZenToken SourceToken) {
		ZenFunc Func = new ZenFunc(0, FuncName, FuncType);
		NameSpace.AppendFuncName(Func, SourceToken);
		return Func;
	}

	public ZenFunc PopFuncParamType(ZenNameSpace NameSpace, ZenFunc DefinedFunc, ArrayList<ZenNode> ArgumentList) {
		@Var ZenFunc UpperDefiningFunc = NameSpace.GetDefiningFunc();
		NameSpace.SetDefiningFunc(DefinedFunc);
		@Var int i = 0;
		while(i < ArgumentList.size()) {
			ZenParamNode Node = (ZenParamNode)ArgumentList.get(i);
			this.SetVarInfo(NameSpace, Node.Type, Node.Name, Node.SourceToken);
			i = i + 1;
		}
		return UpperDefiningFunc;
	}

	public void PopFunc(ZenNameSpace NameSpace, ZenFunc UpperDefiningFunc) {
		NameSpace.SetDefiningFunc(UpperDefiningFunc);
	}

	public void UpdateParamType() {
		// TODO Auto-generated method stub
	}

	public void TypeSync(ZenType VarType, ZenNode ValueNode) {
		// TODO Auto-generated method stub
	}


}