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

import zen.ast.ZenErrorNode;
import zen.ast.ZenNode;
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
	public final static int CastPolicy                      = (1 << 1);
	public final static int IgnoreEmptyPolicy               = (1 << 2);
	public final static int AllowEmptyPolicy                = (1 << 3);
	public final static int AllowVoidPolicy                 = (1 << 4);
	public final static int AllowCoercionPolicy             = (1 << 5);
	public final static int OnlyConstPolicy                 = (1 << 6);
	public final static int NullablePolicy                  = (1 << 8);
	public final static int BlockPolicy                     = (1 << 7);

	@Field private ZenNameSpace NameSpace_;
	@Field private ZenType ContextType_;
	@Field private ZenNode TypedNode_;

	@Field public ZenLogger Logger;
	@Field private boolean StoppedVisitor;

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
			@Var int i = 0;
			while(i < ParamList.size()) {
				ZenNode SubNode = ParamList.get(i);
				SubNode = this.TypeCheck(SubNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
				ParamList.set(i, SubNode);
				i = i + 1;
			}
		}
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

	private ZenType GuessFuncTypeMatchedParam(ZenNameSpace NameSpace, ArrayList<ZenFunc> FuncList, ArrayList<ZenNode> ParamList, int ResolvedSize) {
		@Var int StartIdx = 0;
		@Var int NextIdx = FuncList.size();
		@Var int FuncParamSize = ParamList.size();
		while(ResolvedSize < FuncParamSize) {
			@Var ZenNode SubNode = this.TypeCheck(ParamList.get(ResolvedSize), NameSpace, ZenSystem.VarType, 0);
			if(SubNode.Type.IsVarType()) {
				return ZenSystem.VarType; // unspecified
			}
			@Var int Count = this.FilterFuncParamType(FuncList, StartIdx, NextIdx, ResolvedSize, SubNode.Type);
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

	protected ZenType GuessFuncType(ZenNameSpace NameSpace, String FuncName, ArrayList<ZenNode> ParamList) {
		@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
		@Var int FuncParamSize = ParamList.size();
		NameSpace.RetrieveFuncList(FuncList, null, FuncName, FuncParamSize);
		@Var int BaseSize = FuncList.size();
		if(BaseSize > 1 && FuncParamSize > 0) {
			@Var ZenType GuessedType = this.GuessFuncTypeMatchedParam(NameSpace, FuncList, ParamList, 0);
			if(GuessedType == null) {
				GuessedType = ZenSystem.VarType;
				@Var int i = 0;
				while(i < BaseSize) {
					@Var ZenFunc Func = FuncList.get(i);
					if(this.IsAcceptFunc(Func, ParamList)) {
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

	protected ZenType GuessMethodFuncType(ZenNameSpace NameSpace, ZenNode RecvNode, String FuncName, ArrayList<ZenNode> ParamList) {
		@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
		@Var int FuncParamSize = ParamList.size() + 1;
		@Var ZenType ClassType = RecvNode.Type;
		while(ClassType != null) {
			NameSpace.RetrieveFuncList(FuncList, ClassType, FuncName, FuncParamSize);
			ClassType = ClassType.GetSuperType();
		}
		@Var int BaseSize = FuncList.size();
		if(BaseSize > 1 && FuncParamSize > 1) {
			ParamList.add(0, RecvNode);
			@Var ZenType GuessedType = this.GuessFuncTypeMatchedParam(NameSpace, FuncList, ParamList, 1);
			if(GuessedType == null) {
				GuessedType = ZenSystem.VarType;
				@Var int i = 0;
				while(i < BaseSize) {
					@Var ZenFunc Func = FuncList.get(i);
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
		//			@Var ZenFunc Func = ParsedTree.NameSpace.GetConverterFunc(Node.Type, Node.Type.BaseType, true);
		//			Node = this.Generator.CreateCoercionNode(Func.GetReturnType(), ParsedTree.NameSpace, Func, Node);
		//		}
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
		if(ZenUtils.IsFlag(TypeCheckPolicy, ZenTypeChecker.AllowVoidPolicy) || Node.Type.IsVoidType()) {
			return Node;
		}
		if(Node.Type == ContextType || ContextType.IsVarType() || ContextType.Accept(Node.Type)) {
			return Node;
		}
		//		@Var ZenFunc Func1 = this.GetConverterFunc(Node.Type, ContextType, true);
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

	public ZenNode CanDefineFunc(ZenNameSpace NameSpace, String FuncName, ZenFuncType FuncType) {
		// TODO Auto-generated method stub
		return null;
	}

	public ZenFunc Define(ZenNameSpace NameSpace, String FuncName, ZenFuncType FuncType) {
		// TODO Auto-generated method stub
		return null;
	}

	public ZenFunc SetFuncParamType(ZenNameSpace NameSpace, ZenFunc DefinedFunc, ArrayList<ZenNode> ArgumentList) {
		// TODO Auto-generated method stub
		return null;
	}

	public void PopFunc(ZenFunc UpperFunc) {
		// TODO Auto-generated method stub

	}

	public ZenFuncType CheckFunctionType(ZenFuncType FuncType, ZenType ContextType) {
		// TODO Auto-generated method stub
		return null;
	}

	public void UpdateParamType() {
		// TODO Auto-generated method stub
	}

	public void TypeSync(ZenType VarType, ZenNode ValueNode) {
		// TODO Auto-generated method stub
	}

}