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
import zen.ast.ZenFunctionLiteralNode;
import zen.ast.ZenMethodCallNode;
import zen.ast.ZenNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenStupidCastNode;
import zen.deps.Constructor;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.parser.ZenLogger;
import zen.parser.ZenNameSpace;
import zen.parser.ZenToken;
import zen.parser.ZenUtils;
import zen.parser.ZenVisitor;

class FuncContext {
	@Field FuncContext Parent;
	@Field public ZenFunc DefinedFunc;
	@Field public ZenType ReturnType;
	@Field public String PredefinedSignature;
	@Field boolean IsInferredReturn;
	@Field ArrayList<ZenVarType> VarTypeList;
	@Field public int VarIndex;
	@Field public int CountOfUnknownTypeNode;

	@Constructor FuncContext(FuncContext Parent, ZenFunc DefinedFunc) {
		this.Parent = Parent;
		this.DefinedFunc = DefinedFunc;
		if(this.DefinedFunc == null) {
			this.ReturnType = null;
			this.PredefinedSignature = "";
		}
		else {
			this.ReturnType = DefinedFunc.GetReturnType().GetRealType();
			this.PredefinedSignature = DefinedFunc.GetSignature();
		}
		this.IsInferredReturn = false;
		this.VarTypeList = new ArrayList<ZenVarType>();
		this.VarIndex = 0;
		this.CountOfUnknownTypeNode = 0;
	}

	public void InferReturnType(ZenType InferredType) {
		if(this.ReturnType.IsVarType()) {
			this.ReturnType = InferredType.GetRealType();
			this.IsInferredReturn = true;
		}
	}

	public ZenFuncType CheckFuncType(ZenFunctionLiteralNode FuncNode) {
		@Var ZenFuncType FuncType = this.DefinedFunc.FuncType;
		if(!FuncType.IsCompleteType()) {
			@Var ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
			if(this.ReturnType.IsVarType() && !this.IsInferredReturn) {
				this.ReturnType = ZenSystem.VoidType;
			}
			FuncNode.ReturnType = this.ReturnType.GetRealType();
			TypeList.add(FuncNode.ReturnType);
			@Var int i = 0;
			while(i < FuncNode.ArgumentList.size()) {
				@Var ZenParamNode ParamNode = (ZenParamNode)FuncNode.ArgumentList.get(i);
				ParamNode.Type = ParamNode.Type.GetRealType();
				TypeList.add(ParamNode.Type);
				i = i + 1;
			}
			FuncType = ZenSystem.LookupFuncType(TypeList);
			this.DefinedFunc.FuncType = FuncType;
			if(!LibZen.EqualsString(this.PredefinedSignature, FuncType.StringfySignature(this.DefinedFunc.FuncName))) {

			}
		}
		return FuncType;
	}

	public void UpdateFuncType(ZenNameSpace NameSpace, ZenFunctionLiteralNode FuncNode) {
		@Var ZenFuncType FuncType = this.DefinedFunc.FuncType;
		@Var String Signature = FuncType.StringfySignature(this.DefinedFunc.FuncName);
		System.err.println("debug defined: " + Signature + ": " + FuncType);
		if(!LibZen.EqualsString(this.PredefinedSignature, Signature)) {
			System.err.println("debug new signature: " + Signature);
			NameSpace.SetSymbol(Signature, this.DefinedFunc, null);
			NameSpace.SetSymbol(this.PredefinedSignature, null, null);
		}
	}


	public int GetVarSize() {
		@Var int count = 0;
		@Var int i = 0;
		while(i < this.VarTypeList.size()) {
			@Var ZenVarType VarType = this.VarTypeList.get(i);
			if(VarType.IsVarType()) {
				count = count + 1;
			}
			i = i + 1;
		}
		return count;
	}

	public void Dump() {
		@Var int i = 0;
		System.err.println("debug returning type: " + this.ReturnType);
		while(i < this.VarTypeList.size()) {
			@Var ZenVarType VarType = this.VarTypeList.get(i);
			System.err.println("debug type inference: " + VarType.ShortName + ": " + VarType.GetRealType());
			i = i + 1;
		}
		System.err.println("debug unknown type count = " + this.CountOfUnknownTypeNode);
		this.VarTypeList.clear();
	}

	public int GetVarIndex() {
		int Index = this.VarIndex;
		this.VarIndex = this.VarIndex + 1;
		return Index;
	}

	public void CountUnknownTypeNode(ZenNode Node) {
		this.CountOfUnknownTypeNode = this.CountOfUnknownTypeNode + 1;
	}

}

public abstract class ZenTypeChecker implements ZenVisitor {

	protected void println(String string) {
		System.err.println("debug " + string);
	}

	public final static int DefaultTypeCheckPolicy			= 0;
	public final static int NoCheckPolicy                   = 1;
	public final static int EnforceCoercion                 = (1 << 1);
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

	@Field private FuncContext FuncScope;

	public ZenTypeChecker(ZenLogger Logger) {
		this.Logger = Logger;
		this.StackedNameSpace = null;
		this.StackedContextType = null;
		this.StackedTypedNode = null;
		this.StoppedVisitor = false;
		this.FuncScope = new FuncContext(null, null);
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

	public final void TypedNode(ZenNode Node, ZenType Type) {
		Node.Type = Type;
		if(this.IsVisitable()) {
			this.StackedTypedNode = Node;
		}
	}

	public final void TypedCastNode(ZenNode Node, ZenType ContextType, ZenType NodeType) {
		if(NodeType.IsVarType() && !ContextType.IsVarType() && !(Node.ParentNode instanceof ZenCastNode)) {
			this.TypedNode(new ZenCastNode(ContextType, Node), ContextType);
		}
		else {
			this.TypedNode(Node, NodeType);
		}
	}

	public final void TypedNodeIf(ZenNode Node, ZenType Type, ZenNode P1) {
		if(P1.Type.IsVarType()) {
			Node.Type = ZenSystem.VarType;
		}
		else {
			Node.Type = Type;
		}
		if(this.IsVisitable()) {
			this.StackedTypedNode = Node;
		}
	}

	public final void TypedNodeIf2(ZenNode Node, ZenType Type, ZenNode P1, ZenNode P2) {
		if(P1.Type.IsVarType() || P2.Type.IsVarType()) {
			Node.Type = ZenSystem.VarType;
		}
		else {
			Node.Type = Type;
		}
		if(this.IsVisitable()) {
			this.StackedTypedNode = Node;
		}
	}

	public final void TypedNodeIf3(ZenNode Node, ZenType Type, ZenNode P1, ZenNode P2, ZenNode P3) {
		if(P1.Type.IsVarType() || P2.Type.IsVarType() || P3.Type.IsVarType()) {
			Node.Type = ZenSystem.VarType;
		}
		else {
			Node.Type = Type;
		}
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
			Node.Type = ZenSystem.VoidType;
			this.StackedTypedNode = Node;
			this.StopVisitor();
		}
	}

	public final boolean TypeCheckNodeList(ZenNameSpace NameSpace, ArrayList<ZenNode> ParamList) {
		if(this.IsVisitable()) {
			@Var boolean AllTyped = true;
			@Var int i = 0;
			while(i < ParamList.size()) {
				ZenNode SubNode = ParamList.get(i);
				SubNode = this.TypeCheck(SubNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
				ParamList.set(i, SubNode);
				if(SubNode.Type.IsVarType()) {
					AllTyped = false;
				}
				i = i + 1;
			}
			return AllTyped;
		}
		return false;
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

	private void GuessFuncTypeAcceptedParam(ArrayList<ZenFunc> FuncList, ZenApplyNode Node, int BaseSize) {
		@Var int i = 0;
		while(i < BaseSize) {
			@Var ZenFunc Func = FuncList.get(i);
			if(this.IsAcceptFunc(Func, Node.ParamList)) {
				Node.ResolvedFunc = FuncList.get(0);
			}
			i = i + 1;
		}
	}


	private ZenFunc NewPhantomFunc(ZenNameSpace NameSpace, String FuncName, ZenType ContextType) {
		return null;
	}

	protected ZenType GuessFuncType2(ZenNameSpace NameSpace, String FuncName, ZenApplyNode Node, ZenType ContextType) {
		if(Node.ResolvedFunc == null) {
			@Var int FuncParamSize = Node.ParamList.size();
			@Var ZenType RecvType = Node.GetRecvType();
			@Var String Key = ZenFunc.StringfySignature(FuncName, FuncParamSize, RecvType);
			@Var Object Func = NameSpace.GetSymbol(Key);
			if(Func instanceof ZenFunc) {
				Node.ResolvedFunc = ((ZenFunc)Func);
			}
			else {
				@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
				if(Node instanceof ZenMethodCallNode) {
					@Var ZenType ClassType = RecvType;
					while(ClassType != null) {
						NameSpace.RetrieveFuncList(FuncList, ClassType, FuncName, FuncParamSize);
						ClassType = ClassType.GetSuperType();
					}
				}
				else {
					NameSpace.RetrieveFuncList(FuncList, null, FuncName, FuncParamSize);
				}
				@Var int BaseSize = FuncList.size();
				if(BaseSize == 1) {
					Node.ResolvedFunc = FuncList.get(0);
					return Node.ResolvedFunc.FuncType;
				}
				this.DumpFuncList(FuncList, 0, BaseSize);
				if(BaseSize > 1 && FuncParamSize > 0) {
					this.GuessFuncTypeAcceptedParam(FuncList, Node, BaseSize);
					if(Node.ResolvedFunc == null && ContextType.IsFuncType()) {
						Node.ResolvedFunc = this.NewPhantomFunc(NameSpace, FuncName, ContextType);
					}
				}
			}
		}
		if(Node.ResolvedFunc == null) {
			return ZenSystem.VarType; // unspecified
		}
		return Node.ResolvedFunc.FuncType;
	}

	protected ZenType GuessMethodFuncType(ZenNameSpace NameSpace, String FuncName, ZenMethodCallNode Node, ZenType ContextType) {
		if(Node.ResolvedFunc == null) {
			Node.ParamList.add(0, Node.RecvNode);
			this.GuessFuncType2(NameSpace, FuncName, Node, ContextType);
			Node.ParamList.remove(0);
		}
		if(Node.ResolvedFunc == null) {
			return ZenSystem.VarType; // unspecified
		}
		return Node.ResolvedFunc.FuncType;
	}

	//
	//	private int FilterFuncParamType(ArrayList<ZenFunc> FuncList, int StartIdx, int EndIdx, int ParamIdx, ZenType ParamType) {
	//		@Var int StartFuncSize = FuncList.size();
	//		@Var int i = StartIdx;
	//		while(i < EndIdx) {
	//			@Var ZenFunc Func = FuncList.get(i);
	//			if(Func.GetFuncParamType(ParamIdx) == ParamType) {
	//				FuncList.add(Func);
	//			}
	//			i = i + 1;
	//		}
	//		return FuncList.size() - StartFuncSize;
	//	}
	//
	//	private ZenType GuessFuncTypeMatchedParam(ZenNameSpace NameSpace, ArrayList<ZenFunc> FuncList, ZenApplyNode Node, int ResolvedSize) {
	//		@Var int StartIdx = 0;
	//		@Var int BaseSize = FuncList.size();
	//		@Var int NextIdx = FuncList.size();
	//		@Var int FuncParamSize = Node.ParamList.size();
	//		while(ResolvedSize < FuncParamSize) {
	//			@Var ZenNode SubNode = this.TypeCheck(Node.ParamList.get(ResolvedSize), NameSpace, ZenSystem.VarType, 0);
	//			if(SubNode.Type.IsVarType()) {
	//				return ZenSystem.VarType; // unspecified
	//			}
	//			@Var int Count = this.FilterFuncParamType(FuncList, StartIdx, NextIdx, ResolvedSize, SubNode.Type);
	//			if(Count == 1) {
	//				Node.ResolvedFunc = FuncList.get(FuncList.size()-1);
	//				return Node.ResolvedFunc.FuncType;
	//			}
	//			if(Count == 0) {
	//				return null;
	//			}
	//			StartIdx = NextIdx;
	//			NextIdx = FuncList.size();
	//		}
	//		return this.GuessFuncTypeAcceptedParam(FuncList, Node, BaseSize);
	//	}
	//
	//	protected ZenType GuessFuncType(ZenNameSpace NameSpace, String FuncName, ZenApplyNode Node) {
	//		@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
	//		@Var int FuncParamSize = Node.ParamList.size();
	//		NameSpace.RetrieveFuncList(FuncList, null, FuncName, FuncParamSize);
	//		@Var int BaseSize = FuncList.size();
	//		if(BaseSize == 1) {
	//			Node.ResolvedFunc = FuncList.get(0);
	//			return Node.ResolvedFunc.FuncType;
	//		}
	//		this.DumpFuncList(FuncList, 0, BaseSize);
	//		if(BaseSize > 1 && FuncParamSize > 0) {
	//			@Var ZenType GuessedType = this.GuessFuncTypeMatchedParam(NameSpace, FuncList, Node, 0);
	//			if(GuessedType == null) {
	//				Node.ResolvedFunc = this.NewPhantomFunc(NameSpace, FuncName, Node.ParamList);
	//				if(Node.ResolvedFunc != null) {
	//					return Node.ResolvedFunc.GetFuncType();
	//				}
	//			}
	//		}
	//		return ZenSystem.VarType; // unspecified
	//	}

	public final ZenType TypeCheckFuncParam(ZenNameSpace NameSpace, ArrayList<ZenNode> ParamList, ZenType ContextType, int ParamIdx /* 1: Func 2: Method*/) {
		this.println("TypeCheck FuncType: " + ContextType);
		if(this.IsVisitable() && ContextType.IsFuncType()) {
			@Var ZenFuncType FuncType = (ZenFuncType)ContextType;
			@Var int i = 0;
			while(i < ParamList.size()) {
				@Var ZenNode SubNode = ParamList.get(i);
				SubNode = this.TypeCheck(SubNode, NameSpace, FuncType.GetParamType(i+ParamIdx), ZenTypeChecker.DefaultTypeCheckPolicy);
				ParamList.set(i, SubNode);
				i = i + 1;
			}
			if(FuncType.IsCompleteType()) {
				return FuncType.GetReturnType();   // Return
			}
		}
		//		this.TypeCheckNodeList(NameSpace, ParamList);
		return ZenSystem.VarType;
	}

	public final ZenNode TypeCheck(ZenNode Node, ZenNameSpace NameSpace, ZenType ContextType, int TypeCheckPolicy) {
		if(this.IsVisitable()) {
			if(Node.IsUntyped()) {
				ZenNode ParentNode = Node.ParentNode;
				ZenNameSpace NameSpace_ = this.StackedNameSpace;
				ZenType ContextType_ = this.StackedContextType;
				this.StackedNameSpace = NameSpace;
				this.StackedContextType = ContextType;
				Node.Accept(this);
				Node = this.TypeCheckImpl(this.StackedTypedNode, NameSpace, ContextType, TypeCheckPolicy);
				this.StackedTypedNode = Node;
				this.StackedNameSpace = NameSpace_;
				this.StackedContextType = ContextType_;
				if(ParentNode != Node.ParentNode && ParentNode != null) {
					ParentNode.SetChild(Node);
				}
			}
			else {
				Node = this.TypeCheckImpl(Node, NameSpace, ContextType, TypeCheckPolicy);
				this.StackedTypedNode = Node;
			}
		}
		this.CheckErrorNode(Node);
		return Node;
	}

	private final ZenNode InferType(ZenType ContextType, ZenNode Node) {
		//System.err.println("debug ContextType="+ContextType + ", Node.Type="+ Node.Type);
		if(ContextType.IsInferrableType() && Node.Type instanceof ZenVarType) {
			((ZenVarType)Node.Type).Infer(ContextType, Node.SourceToken);
			Node.Type = ContextType;
			return Node;
		}
		if(ContextType instanceof ZenVarType && !Node.Type.IsVarType()) {
			((ZenVarType)ContextType).Infer(Node.Type, Node.SourceToken);
			return Node;
		}
		return Node;
	}

	private final ZenNode TypeCheckImpl(ZenNode Node, ZenNameSpace NameSpace, ZenType ContextType, int TypeCheckPolicy) {
		if(Node.IsErrorNode()) {
			return Node;
		}
		if(Node.Type.IsVarType()) {
			this.FuncScope.CountUnknownTypeNode(Node);
			return this.InferType(ContextType, Node);
		}
		if(Node.Type == ContextType || ContextType.IsVarType() || ContextType.Accept(Node.Type) || ZenUtils.IsFlag(TypeCheckPolicy, NoCheckPolicy)) {
			return this.InferType(ContextType, Node);
		}
		if(ContextType.IsVoidType() && !Node.Type.IsVoidType()) {
			return new ZenCastNode(ZenSystem.VoidType, Node);
		}
		@Var ZenFunc CoercionFunc = NameSpace.GetCoercionFunc(Node.Type, ContextType);
		if(CoercionFunc != null) {

		}
		if(ContextType.IsFloatType() && Node.Type.IsIntType()) {
			return this.InferType(ContextType, new ZenCastNode(ContextType, Node));
		}
		if(ZenUtils.IsFlag(TypeCheckPolicy, EnforceCoercion) && ContextType.IsStringType()) {
			return this.InferType(ContextType, new ZenCastNode(ContextType, Node));
		}
		//System.err.println("node="+ LibZen.GetClassName(Node) + "type error: requested = " + Type + ", given = " + Node.Type);
		return new ZenStupidCastNode(ContextType, Node);
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

	private void SetClassField(ZenNameSpace NameSpace, ZenType ClassType, String FieldName, ZenType FieldType, ZenToken SourceToken) {
		ZenField Field = new ZenField(ClassType, FieldName, FieldType, SourceToken);
		NameSpace.SetSymbol(ZenNameSpace.StringfyClassSymbol(ClassType, FieldName), Field, SourceToken);
	}

	protected final ZenType GetFieldType(ZenNameSpace NameSpace, ZenType ClassType, String FieldName) {
		Object Field = NameSpace.GetClassSymbol(ClassType, FieldName, true);
		if(Field instanceof ZenField) {
			return ((ZenField)Field).FieldType;
		}
		return NameSpace.Generator.GetFieldType(ClassType, FieldName);
	}

	protected final ZenType GetSetterType(ZenNameSpace NameSpace, ZenType ClassType, String FieldName) {
		Object Field = NameSpace.GetClassSymbol(ClassType, FieldName, true);
		if(Field instanceof ZenField) {
			return ((ZenField)Field).FieldType;
		}
		return NameSpace.Generator.GetSetterType(ClassType, FieldName);
	}

	protected ZenType InferFieldType(ZenNameSpace NameSpace, ZenType ClassType, String FieldName, ZenType InferredType, ZenToken SourceToken) {
		System.err.println("debug inferrence " + ClassType + "." + FieldName + ": " + InferredType);
		if(ClassType.IsVarType() || !InferredType.IsInferrableType()) {
			return ZenSystem.VarType;
		}
		if(ClassType.IsOpenType()) {
			this.SetClassField(NameSpace, ClassType, FieldName, InferredType, SourceToken);
		}
		return InferredType;
	}

	protected ZenType GetReturnType() {
		return this.FuncScope.ReturnType;
	}

	protected void InferReturnType(ZenType InferredType) {
		this.FuncScope.InferReturnType(InferredType);
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

	protected final ZenType NewVarType(ZenType VarType, String Name, ZenToken SourceToken) {
		if(!(VarType instanceof ZenVarType) && VarType.IsVarType()) {
			ZenVarType VarType1 = new ZenVarType(Name, SourceToken);
			this.FuncScope.VarTypeList.add(VarType1);
			VarType = VarType1;
		}
		return VarType;
	}

	protected ZenVariable GetLocalVariable(ZenNameSpace NameSpace, String VarName) {
		@Var Object VarInfo = NameSpace.GetSymbol(VarName);
		if(VarInfo instanceof ZenVariable) {
			return (ZenVariable)VarInfo;
		}
		return null;
	}

	protected void SetLocalVariable(ZenNameSpace NameSpace, ZenType VarType, String VarName, ZenToken SourceToken) {
		@Var ZenVariable VarInfo = new ZenVariable(NameSpace.GetDefiningFunc(), 0, VarType, VarName, this.FuncScope.GetVarIndex(), SourceToken);
		NameSpace.SetSymbol(VarName, VarInfo, SourceToken);
	}

	protected ZenFuncType LookupTypeFunc(ZenType ReturnType, ArrayList<ZenNode> NodeList, @Nullable ZenType ContextType) {
		@Var ZenFuncType FuncType = null;
		if(ContextType instanceof ZenFuncType) {
			FuncType = (ZenFuncType)ContextType;
		}
		@Var ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
		if(ReturnType.IsVarType() && FuncType != null) {
			ReturnType = FuncType.GetParamType(0);
		}
		TypeList.add(ReturnType.GetRealType());
		@Var int i = 0;
		while(i < NodeList.size()) {
			@Var ZenParamNode Node = (ZenParamNode)NodeList.get(i);
			@Var ZenType ParamType = Node.Type.GetRealType();
			if(ParamType.IsVarType() && FuncType != null) {
				ParamType = FuncType.GetParamType(i+1);
			}
			TypeList.add(ParamType);
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

	//	protected ZenNode CanDefineFunc(ZenNameSpace NameSpace, String FuncName, ZenFuncType FuncType, ZenFuncDeclNode Node) {
	//		System.out.println("debug signature: " + FuncType.StringfySignature(FuncName));
	//		ZenFunc Func = NameSpace.GetSymbol(FuncType.StringfySignature(FuncName));
	//		return Node;
	//	}

	public ZenFunc DefineFunc(ZenNameSpace NameSpace, String FuncName, ZenFuncType FuncType, ZenToken SourceToken) {
		@Var ZenFunc Func = new ZenFunc(0, FuncName, FuncType);
		if(FuncName != null) {
			@Var String Signature = FuncType.StringfySignature(FuncName);
			System.err.println("debug signature: " + Signature);
			@Var Object FuncObject = NameSpace.GetSymbol(Signature);
			if(FuncObject instanceof ZenFunc) {
				@Var ZenFunc PreDefined = (ZenFunc)FuncObject;
				System.err.println("predefined func: " + PreDefined);
			}
			NameSpace.SetSymbol(Signature, Func, SourceToken);
			NameSpace.AppendFuncName(Func, SourceToken);
		}
		return Func;
	}

	public void PushFuncScope(ZenNameSpace NameSpace, ZenFunc DefinedFunc, ArrayList<ZenNode> ArgumentList) {
		NameSpace.SetDefiningFunc(DefinedFunc);
		this.FuncScope = new FuncContext(this.FuncScope, DefinedFunc);
		@Var int i = 0;
		while(i < ArgumentList.size()) {
			@Var ZenParamNode Node = (ZenParamNode)ArgumentList.get(i);
			Node.Type = this.NewVarType(Node.Type, Node.Name, Node.SourceToken);
			this.SetLocalVariable(NameSpace, Node.Type, Node.Name, Node.SourceToken);
			i = i + 1;
		}
	}

	public final ZenNode TypeCheckFuncBody(ZenNameSpace NameSpace, ZenNode BodyNode) {
		@Var int Stopper = Integer.MAX_VALUE;
		while(this.IsVisitable()) {
			this.FuncScope.CountOfUnknownTypeNode = 0;
			BodyNode = this.TypeCheck(BodyNode, NameSpace, ZenSystem.VoidType, 0);
			int UntypedSize = this.FuncScope.GetVarSize();
			this.println("untyped node=" + this.FuncScope.CountOfUnknownTypeNode + ", var=" + UntypedSize);
			if(this.FuncScope.CountOfUnknownTypeNode == 0 || Stopper == this.FuncScope.CountOfUnknownTypeNode) {
				break;
			}
			Stopper = this.FuncScope.CountOfUnknownTypeNode;
		}
		return BodyNode;
	}

	public ZenFuncType PopFuncScope(ZenNameSpace NameSpace, ZenFunctionLiteralNode FuncNode, ZenToken SourceToken) {
		NameSpace.SetDefiningFunc(null);
		ZenFuncType FuncType = this.FuncScope.CheckFuncType(FuncNode);
		if(FuncNode instanceof ZenFuncDeclNode) {
			this.FuncScope.UpdateFuncType(NameSpace, FuncNode);
		}
		this.FuncScope.Dump();
		this.FuncScope = this.FuncScope.Parent;
		return FuncType;
	}
	//
	//	public void UpdateParamType() {
	//		// TODO Auto-generated method stub
	//	}
	//
	//	public void TypeSync(ZenType VarType, ZenNode ValueNode) {
	//		// TODO Auto-generated method stub
	//	}
	//

}