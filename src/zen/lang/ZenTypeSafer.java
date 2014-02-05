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

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassDeclNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZLetNode;
import zen.ast.ZListNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewArrayNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.parser.ZGenerator;
import zen.parser.ZNameSpace;
import zen.parser.ZUtils;
import zen.parser.ZVariable;
import zen.type.ZFuncType;
import zen.type.ZGreekType;
import zen.type.ZType;
import zen.type.ZTypeChecker;
import zen.type.ZTypeFlag;
import zen.type.ZTypePool;
import zen.type.ZVarScope;
import zen.type.ZVarType;

public class ZenTypeSafer extends ZTypeChecker {

	@Field private ZFunctionNode CurrentFunctionNode = null;

	public ZenTypeSafer(ZGenerator Generator) {
		super(Generator);
	}

	public final boolean IsTopLevel() {
		return (this.CurrentFunctionNode == null);
	}

	public final boolean InFunctionScope() {
		return (this.CurrentFunctionNode != null);
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		ZType Type = this.GetContextType();
		this.TypedNode(Node, Type);
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.TypedNode(Node, ZType.BooleanType);
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.TypedNode(Node, ZType.IntType);
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.TypedNode(Node, ZType.FloatType);
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.TypedNode(Node, ZType.StringType);
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		//		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		@Var ZType ArrayType = this.GetContextType();
		@Var ZType ElementType = ZType.VarType;
		if(ArrayType.IsArrayType()) {
			ElementType = ArrayType.GetParamType(0);
		}
		@Var boolean AllTyped = true;
		@Var int i = 0;
		while(i < Node.GetListSize()) {
			ZNode SubNode = Node.GetListAt(i);
			SubNode = this.CheckType(SubNode, ElementType);
			Node.SetListAt(i, SubNode);
			if(SubNode.IsVarType()) {
				AllTyped = false;
				ArrayType = ZType.VarType;
			}
			else {
				if(ElementType.IsVarType()) {
					ElementType = SubNode.Type;
				}
			}
			i = i + 1;
		}
		if( AllTyped && !ElementType.IsVarType()) {
			ArrayType = ZTypePool.GetGenericType1(ZType.ArrayType, ElementType);
		}
		this.TypedNode(Node, ArrayType);
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		//		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		//		@Var ZType ContextType = this.GetContextType();
		//		@Var int i = 0;
		//		while(i < Node.NodeList.size()) {
		//			@Var ZNode SubNode = Node.NodeList.get(i);
		//			if(SubNode instanceof ZGetNameNode) {
		//				SubNode = ((ZGetNameNode)SubNode).ToStringNode();
		//			}
		//			SubNode = this.CheckType(SubNode, NameSpace, ZType.StringType);
		//			Node.NodeList.set(i, SubNode);
		//			i = i + 2;
		//		}
		//		@Var boolean AllTyped = true;
		//		if(ContextType instanceof ZenClassType) {
		//			@Var ZenClassType ClassType = (ZenClassType)ContextType;
		//			i = 0;
		//			while(i < Node.NodeList.size()) {
		//				@Var ZStringNode KeyNode = (ZStringNode)Node.NodeList.get(i);
		//				@Var ZType FieldType = ClassType.GetFieldType(KeyNode.StringValue, null);
		//				if(FieldType == null) {
		//					this.Return(ZenError.UndefinedName(KeyNode, KeyNode.StringValue));
		//				}
		//				else {
		//					@Var ZNode SubNode = Node.NodeList.get(i+1);
		//					SubNode = this.CheckType(SubNode, NameSpace, FieldType);
		//					Node.NodeList.set(i+1, SubNode);
		//					if(SubNode.IsVarType()) {
		//						AllTyped = false;
		//						ContextType = ZType.VarType;
		//					}
		//				}
		//				i = i + 2;
		//			}
		//		}
		//		else if(ContextType.IsMapType()) {
		//			@Var ZType ElementType = ContextType.GetParamType(0);
		//			i = 1;
		//			while(i < Node.NodeList.size()) {
		//				@Var ZNode SubNode = Node.NodeList.get(i);
		//				SubNode = this.CheckType(SubNode, NameSpace, ElementType);
		//				Node.NodeList.set(i, SubNode);
		//				if(SubNode.IsVarType()) {
		//					AllTyped = false;
		//					ContextType = ZType.VarType;
		//				}
		//				i = i + 2;
		//			}
		//		}
		//		else {
		//			ContextType = ZType.VarType;
		//			AllTyped = false;
		//		}
		//		this.TypedNode(Node, ContextType);
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		this.Todo(Node);
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		@Var ZVariable VarInfo = NameSpace.GetLocalVariable(Node.VarName);
		if(VarInfo != null) {
			Node.VarName = VarInfo.VarName;
			Node.VarIndex = VarInfo.VarUniqueIndex;
			Node.IsCaptured = VarInfo.IsCaptured(this.CurrentFunctionNode);
			this.TypedNode(Node, VarInfo.VarType);
		}
		else {
			@Var ZNode ConstNode = NameSpace.GetSymbolNode(Node.VarName);
			if(ConstNode != null) {
				this.Return(ConstNode);
			}
			else {
				this.Logger.ReportWarning(Node.SourceToken, "undefined variable: " + Node.VarName);
				this.TypedNode(Node, ZType.VarType);
			}
		}
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		ZNameSpace NameSpace = Node.GetNameSpace();
		ZVariable VarInfo = NameSpace.GetLocalVariable(Node.VarName);
		if(VarInfo == null) {
			this.Return(ZenError.UndefinedName(Node, Node.VarName));
		}
		else {
			Node.VarName = VarInfo.VarName;
			Node.VarIndex = VarInfo.VarUniqueIndex;
			Node.IsCaptured = VarInfo.IsCaptured(this.CurrentFunctionNode);
			if(Node.IsCaptured) {
				this.Return(ZenError.ReadOnlyLocalVariable(Node, Node.VarName));
			}
			else {
				Node.AST[ZSetNameNode.Expr] = this.CheckType(Node.AST[ZSetNameNode.Expr], VarInfo.VarType);
				this.TypedNodeIf(Node, ZType.VoidType, Node.AST[ZSetNameNode.Expr]);
			}
		}
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		ZNameSpace NameSpace = Node.GetNameSpace();
		Node.AST[ZGetterNode.Recv] = this.CheckType(Node.AST[ZGetterNode.Recv], ZType.VarType);
		Node.AST[ZGetIndexNode.Index] = this.CheckType(Node.AST[ZGetIndexNode.Index], ZenGamma.GetIndexType(NameSpace, Node.AST[ZGetterNode.Recv].Type));
		this.TypedNodeIf2(Node, ZenGamma.GetElementType(NameSpace, Node.AST[ZGetterNode.Recv].Type), Node.AST[ZGetterNode.Recv], Node.AST[ZGetIndexNode.Index]);
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		ZNameSpace NameSpace = Node.GetNameSpace();
		Node.AST[ZGetterNode.Recv] = this.CheckType(Node.AST[ZGetterNode.Recv], ZType.VarType);
		Node.AST[ZSetIndexNode.Index] = this.CheckType(Node.AST[ZSetIndexNode.Index], ZenGamma.GetIndexType(NameSpace, Node.AST[ZGetterNode.Recv].Type));
		Node.AST[ZSetIndexNode.Expr] = this.CheckType(Node.AST[ZSetIndexNode.Expr], ZenGamma.GetElementType(NameSpace, Node.AST[ZGetterNode.Recv].Type));
		this.TypedNodeIf3(Node, ZType.VoidType,  Node.AST[ZGetterNode.Recv], Node.AST[ZSetIndexNode.Index], Node.AST[ZSetIndexNode.Expr]);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		Node.AST[ZGetterNode.Recv].Accept(this); // this is shortcut
		this.TypedNode(Node, Node.AST[ZGetterNode.Recv].Type);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		//		@Var ZType ContextType = this.GetContextType();
		Node.AST[ZGetterNode.Recv] = this.CheckType(Node.AST[ZGetterNode.Recv], ZType.VarType);
		ZType FieldType = ZenGamma.GetFieldType(NameSpace, Node.AST[ZGetterNode.Recv].Type, Node.FieldName);
		//		if(FieldType.IsVarType() && ContextType.IsInferrableType()) {
		//			ZenGamma.InferFieldType(NameSpace, Node.AST[ZGetterNode.Recv].Type, Node.FieldName, ContextType, Node.SourceToken);
		//		}
		if(FieldType.IsVoidType() && !Node.AST[ZGetterNode.Recv].IsVarType()) {
			this.Return(ZenError.UndefinedName(Node, Node.AST[ZGetterNode.Recv].Type.StringfyClassMember(Node.FieldName)));
			return;
		}
		this.TypedNodeIf(Node, FieldType, Node.AST[ZGetterNode.Recv]);
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		Node.AST[ZGetterNode.Recv] = this.CheckType(Node.AST[ZGetterNode.Recv], ZType.VarType);
		@Var ZType FieldType = ZenGamma.GetSetterType(NameSpace, Node.AST[ZGetterNode.Recv].Type, Node.FieldName);
		if(FieldType.IsVoidType()) {
			this.Return(ZenError.ReadOnlyName(Node, Node.AST[ZGetterNode.Recv].Type, Node.FieldName));
			return;
		}
		Node.AST[ZSetterNode.Expr] = this.CheckType(Node.AST[ZSetterNode.Expr], FieldType);
		//		if(FieldType.IsVarType()) {
		//			ZenGamma.InferFieldType(NameSpace, Node.AST[ZGetterNode.Recv].Type, Node.FieldName, Node.ValueNode.Type, Node.SourceToken);
		//		}
		this.TypedNodeIf2(Node, ZType.VoidType, Node.AST[ZGetterNode.Recv], Node.AST[ZSetterNode.Expr]);
	}

	private ZFuncType GuessFuncTypeFromContext(ZType ReturnType, @Nullable ZType RecvType, ZListNode List) {
		if(ReturnType.IsVoidType()) {
			ReturnType = ZType.VarType;
		}
		ArrayList<ZType> TypeList = new ArrayList<ZType>();
		TypeList.add(ReturnType.GetRealType());
		if(RecvType != null) {
			TypeList.add(RecvType.GetRealType());
		}
		@Var int i = 0;
		while(i < List.GetListSize()) {
			ZNode SubNode = List.GetListAt(i);
			ZType ParamType = SubNode.Type.GetRealType();
			TypeList.add(ParamType);
			i = i + 1;
		}
		return ZTypePool.LookupFuncType(TypeList);
	}

	private void TypeCheckFuncCall(ZFuncCallNode FuncNode, ZFuncType FuncType) {
		@Var int i = 0;
		@Var boolean IsAllTyped = true;
		@Var ZType[] Greek = ZGreekType.NewGreekTypes(null);
		while(i < FuncNode.GetListSize()) {
			@Var ZNode SubNode = FuncNode.GetListAt(i);
			@Var ZType ParamType =  FuncType.GetParamType(i+1);
			SubNode = this.TryType(SubNode, ParamType);
			if(SubNode.IsUntyped()) {
				IsAllTyped = false;
			}
			if(!ParamType.AcceptValueType(SubNode.Type, false, Greek)) {
				SubNode = ZenError.FuncCallTypeError(ParamType.GetRealType(Greek), FuncNode, i+1, SubNode.Type);
			}
			FuncNode.SetListAt(i, SubNode);
			i = i + 1;
		}
		if(!FuncType.IsVarType() && IsAllTyped) {
			this.TypedNode(FuncNode, FuncType.GetReturnType().GetRealType(Greek));
		}
		else {
			this.TypedNode(FuncNode, ZType.VarType);
		}
	}

	private void TypeCheckNativeMethodCall(ZNode Node, ZType RecvType, String MethodName, ZListNode List) {
		ZFuncType FuncType = this.Generator.GetMethodFuncType(RecvType, MethodName, List);
		if(FuncType != null) {
			@Var int i = 0;
			@Var boolean IsAllTyped = true;
			@Var int StaticShift = FuncType.GetParamSize() - List.GetListSize();
			while(i < List.GetListSize()) {
				@Var ZNode SubNode = List.GetListAt(i);
				SubNode = this.CheckType(SubNode, FuncType.GetParamType(i+StaticShift));
				List.SetListAt(i, SubNode);
				if(SubNode.IsUntyped()) {
					IsAllTyped = false;
				}
				i = i + 1;
			}
			if(IsAllTyped) {
				this.TypedNode(Node, FuncType.GetReturnType());
				return;
			}
		}
		this.Return(Node);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		this.CheckTypeAt(Node, ZMethodCallNode.Recv, ZType.VarType);
		if(!Node.AST[ZGetterNode.Recv].IsVarType()) {
			ZType FieldType = ZenGamma.GetFieldType(NameSpace, Node.AST[ZGetterNode.Recv].Type, Node.MethodName);
			if(FieldType.IsFuncType()) {
				ZFuncCallNode FuncCall = Node.ToGetterFuncCall();
				this.TypeCheckFuncCall(FuncCall, (ZFuncType)FieldType);
				return;
			}
		}
		@Var int FuncParamSize = Node.GetListSize() + 1;
		@Var ZFunc Func = ZenGamma.LookupFunc(NameSpace, Node.MethodName, Node.AST[ZGetterNode.Recv].Type, FuncParamSize);
		if(Func != null) {
			ZFuncCallNode FuncCall = Node.ToStaticFuncCall(Func);
			this.TypeCheckFuncCall(FuncCall, Func.GetFuncType());
			return;
		}
		this.TypeCheckNodeList(Node);
		this.TypeCheckNativeMethodCall(Node, Node.AST[ZGetterNode.Recv].Type, Node.MethodName, Node);
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		@Var ZType ContextType = this.GetContextType();
		this.TypeCheckNodeList(Node);
		if(Node.Type.IsVarType()) {
			if(ContextType.IsVarType()) {
				this.Return(Node);
				return;
			}
			Node.Type = ContextType;
		}
		@Var int FuncParamSize = Node.GetListSize() + 1;
		@Var ZFunc Func = ZenGamma.LookupFunc(NameSpace, Node.Type.GetUniqueName(), Node.Type, FuncParamSize);
		if(Func != null) {
			ZFuncCallNode FuncCall = Node.ToStaticFuncCall(Func);
			this.TypeCheckFuncCall(FuncCall, Func.GetFuncType());
			return;
		}
		this.TypeCheckNativeMethodCall(Node, Node.Type, null, Node);
	}

	private boolean IsFuncName(ZFuncCallNode FuncCallNode, ZNameSpace NameSpace) {
		if(FuncCallNode.AST[ZFuncCallNode.Func] instanceof ZGetNameNode && FuncCallNode.AST[ZFuncCallNode.Func].IsVarType()) {
			@Var ZGetNameNode Node = (ZGetNameNode)FuncCallNode.AST[ZFuncCallNode.Func];
			@Var ZVariable VarInfo = NameSpace.GetLocalVariable(Node.VarName);
			if(VarInfo == null || !VarInfo.VarType.IsVarType() || !VarInfo.VarType.IsFuncType()) {
				FuncCallNode.ResolvedFuncName = Node.VarName;
			}
			if(FuncCallNode.ResolvedFuncName != null) {
				if(FuncCallNode.ResolvedFuncType == null) {
					@Var int FuncParamSize = FuncCallNode.GetListSize();
					@Var ZType RecvType = FuncCallNode.GetRecvType();
					@Var ZFunc Func = ZenGamma.LookupFunc(NameSpace, FuncCallNode.ResolvedFuncName, RecvType, FuncParamSize);
					if(Func != null) {
						FuncCallNode.ResolvedFuncType = Func.GetFuncType();
					}
					else {
						this.VarScope.FoundUnresolvedSymbol(FuncCallNode.ResolvedFuncName);
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		@Var ZType ContextType = this.GetContextType();
		this.TypeCheckNodeList(Node);
		@Var ZFuncType PartialFuncType = this.GuessFuncTypeFromContext(ContextType, null, Node);
		if(this.IsFuncName(Node, NameSpace)) {
			if(Node.ResolvedFuncType != null) {
				this.TypeCheckFuncCall(Node, Node.ResolvedFuncType);
				return;
			}
		}
		else {
			Node.AST[ZFuncCallNode.Func] = this.TryType(Node.AST[ZFuncCallNode.Func], PartialFuncType);
			@Var ZType FuncNodeType = Node.AST[ZFuncCallNode.Func].Type;
			if(!FuncNodeType.IsFuncType() && !FuncNodeType.IsVarType()) {
				this.Return(new ZErrorNode(Node, "not function: given = " + FuncNodeType));
				return;
			}
			if(FuncNodeType.IsFuncType()) {
				this.TypeCheckFuncCall(Node, (ZFuncType)FuncNodeType);
				return;
			}
		}
		this.TypedNode(Node, ZType.VarType);
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		Node.AST[ZGetterNode.Recv] = this.CheckType(Node.AST[ZGetterNode.Recv], ZType.VarType);
		this.TypedNode(Node, Node.AST[ZGetterNode.Recv].Type);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		Node.AST[ZGetterNode.Recv] = this.CheckType(Node.AST[ZGetterNode.Recv], ZType.BooleanType);
		this.TypedNodeIf(Node, ZType.BooleanType, Node.AST[ZGetterNode.Recv]);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		Node.AST[ZCastNode.Expr] = this.CheckType(Node.AST[ZCastNode.Expr], Node.Type);
		this.TypedNode(Node, Node.Type);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		Node.AST[ZBinaryNode.Left] = this.CheckType(Node.AST[ZBinaryNode.Left], ZType.VarType);
		this.TypedNodeIf(Node, ZType.BooleanType, Node.AST[ZBinaryNode.Left]);
	}

	private ZType GetBinaryLeftType(String Op, ZType ContextType) {
		if(LibZen.EqualsString(Op, "|") || LibZen.EqualsString(Op, "&") || LibZen.EqualsString(Op, "<<") || LibZen.EqualsString(Op, ">>") || LibZen.EqualsString(Op,  "^")) {
			return ZType.IntType;
		}
		if(LibZen.EqualsString(Op, "*") || LibZen.EqualsString(Op, "-") || LibZen.EqualsString(Op, "/") || LibZen.EqualsString(Op, "%")) {
			if(ContextType.IsNumberType()) {
				return ContextType;
			}
		}
		return ZType.VarType;
	}

	private ZType GetBinaryRightType(String Op, ZType ContextType) {
		if(LibZen.EqualsString(Op, "|") || LibZen.EqualsString(Op, "&") || LibZen.EqualsString(Op, "<<") || LibZen.EqualsString(Op, ">>") || LibZen.EqualsString(Op,  "^")) {
			return ZType.IntType;
		}
		if(LibZen.EqualsString(Op, "*") || LibZen.EqualsString(Op, "-") || LibZen.EqualsString(Op, "/") || LibZen.EqualsString(Op, "%")) {
			if(ContextType.IsNumberType()) {
				return ContextType;
			}
		}
		return ZType.VarType;
	}

	private void UnifyBinaryNodeType(ZBinaryNode Node, ZType Type) {
		if(Node.AST[ZBinaryNode.Left].Type.Equals(Type)) {
			Node.AST[ZBinaryNode.Right] = this.CheckType(Node.AST[ZBinaryNode.Right], Type);
			return;
		}
		if(Node.AST[ZBinaryNode.Right].Type.Equals(Type)) {
			Node.AST[ZBinaryNode.Left] = this.CheckType(Node.AST[ZBinaryNode.Left], Type);
		}
	}

	private void UnifyBinaryEnforcedType(ZBinaryNode Node, ZType Type) {
		if(Node.AST[ZBinaryNode.Left].Type.Equals(Type)) {
			Node.AST[ZBinaryNode.Right] = this.EnforceType(Node.AST[ZBinaryNode.Right], Type);
			return;
		}
		if(Node.AST[ZBinaryNode.Right].Type.Equals(Type)) {
			Node.AST[ZBinaryNode.Left] = this.EnforceType(Node.AST[ZBinaryNode.Left], Type);
		}
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		ZType ContextType = this.GetContextType();
		ZType LeftType = this.GetBinaryLeftType(Node.SourceToken.GetText(), ContextType);
		ZType RightType = this.GetBinaryRightType(Node.SourceToken.GetText(), ContextType);
		//System.err.println("debug left=" + LeftType + ", right=" + RightType);
		Node.AST[ZBinaryNode.Left] = this.CheckType(Node.AST[ZBinaryNode.Left], LeftType);
		Node.AST[ZBinaryNode.Right] = this.CheckType(Node.AST[ZBinaryNode.Right], RightType);
		//System.err.println("debug left=" + Node.AST[ZBinaryNode.Left].Type + ", right=" + Node.AST[ZBinaryNode.Right].Type);
		if(!Node.AST[ZBinaryNode.Left].Type.Equals(Node.AST[ZBinaryNode.Right].Type)) {
			if(Node.SourceToken.EqualsText('+')) {
				this.UnifyBinaryEnforcedType(Node, ZType.StringType);
			}
			this.UnifyBinaryNodeType(Node, ZType.FloatType);
			Node.AST[ZBinaryNode.Left] = this.CheckType(Node.AST[ZBinaryNode.Left], Node.AST[ZBinaryNode.Right].Type);
		}
		this.TypedNodeIf(Node, Node.AST[ZBinaryNode.Left].Type, Node.AST[ZBinaryNode.Right]);
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		Node.AST[ZBinaryNode.Left] = this.CheckType(Node.AST[ZBinaryNode.Left], ZType.VarType);
		Node.AST[ZBinaryNode.Right] = this.TryType(Node.AST[ZBinaryNode.Right], Node.AST[ZBinaryNode.Left].Type);
		this.UnifyBinaryNodeType(Node, ZType.FloatType);
		Node.AST[ZBinaryNode.Right] = this.CheckType(Node.AST[ZBinaryNode.Right], Node.AST[ZBinaryNode.Left].Type);
		this.TypedNodeIf2(Node, ZType.BooleanType, Node.AST[ZBinaryNode.Left], Node.AST[ZBinaryNode.Right]);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		Node.AST[ZBinaryNode.Left] = this.CheckType(Node.AST[ZBinaryNode.Left], ZType.BooleanType);
		Node.AST[ZBinaryNode.Right] = this.CheckType(Node.AST[ZBinaryNode.Right], ZType.BooleanType);
		this.TypedNodeIf2(Node, ZType.BooleanType, Node.AST[ZBinaryNode.Left], Node.AST[ZBinaryNode.Right]);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		Node.AST[ZBinaryNode.Left] = this.CheckType(Node.AST[ZBinaryNode.Left], ZType.BooleanType);
		Node.AST[ZBinaryNode.Right] = this.CheckType(Node.AST[ZBinaryNode.Right], ZType.BooleanType);
		this.TypedNodeIf2(Node, ZType.BooleanType, Node.AST[ZBinaryNode.Left], Node.AST[ZBinaryNode.Right]);
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		@Var int i = 0;
		ZType BlockType = ZType.VoidType;
		while(i < Node.GetListSize()) {
			ZNode SubNode = Node.GetListAt(i);  // without annotation
			SubNode = this.CheckType(SubNode, ZType.VoidType);
			Node.SetListAt(i, SubNode);
			if(SubNode.IsVarType()) {
				BlockType = ZType.VarType;
			}
			if(SubNode.IsBreakingBlock()) {
				break;
			}
			i = i + 1;
		}
		this.TypedNode(Node, BlockType);
	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		Node.AST[ZVarDeclNode.InitValue] = this.CheckType(Node.AST[ZVarDeclNode.InitValue], Node.DeclType);
		if(!(Node.DeclType instanceof ZVarType)) {
			Node.DeclType = this.VarScope.NewVarType(Node.DeclType, Node.NativeName, Node.SourceToken);
			Node.NameSpace.SetLocalVariable(this.CurrentFunctionNode, Node.DeclType, Node.NativeName, Node.SourceToken);
		}
		this.VisitBlockNode(Node);
		this.TypedNodeIf2(Node, ZType.VoidType, Node.AST[ZVarDeclNode.InitValue], Node);
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Node.AST[ZIfNode.Cond] = this.CheckType(Node.AST[ZIfNode.Cond], ZType.BooleanType);
		Node.AST[ZIfNode.Then] = this.CheckType(Node.AST[ZIfNode.Then], ZType.VoidType);
		if(Node.AST[ZIfNode.Else] != null) {
			Node.AST[ZIfNode.Else] = this.CheckType(Node.AST[ZIfNode.Else], ZType.VoidType);
			this.TypedNodeIf3(Node, ZType.VoidType, Node.AST[ZIfNode.Cond], Node.AST[ZIfNode.Then], Node.AST[ZIfNode.Else]);
		}
		else {
			this.TypedNodeIf2(Node, ZType.VoidType, Node.AST[ZIfNode.Cond], Node.AST[ZIfNode.Then]);
		}
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		if(!this.InFunctionScope()) {
			this.Return(ZenError.NeedFunctionScope(Node, "return"));
			return;
		}
		@Var ZType ReturnType = this.CurrentFunctionNode.ReturnType;
		if(Node.AST[ZReturnNode.Expr] != null && ReturnType.IsVoidType()) {
			Node.AST[ZReturnNode.Expr] = null;
		}
		else if(Node.AST[ZReturnNode.Expr] == null && !ReturnType.IsVarType() && !ReturnType.IsVoidType()) {
			this.Logger.ReportWarning(Node.SourceToken, "returning default value of " + ReturnType);
			Node.AST[ZReturnNode.Expr] = ZenGamma.CreateDefaultValueNode(Node, ReturnType, null);
		}
		if(Node.AST[ZReturnNode.Expr] != null) {
			Node.AST[ZReturnNode.Expr] = this.CheckType(Node.AST[ZReturnNode.Expr], ReturnType);
			this.TypedNodeIf(Node, ZType.VoidType, Node.AST[ZReturnNode.Expr]);
		}
		else {
			if(ReturnType instanceof ZVarType) {
				((ZVarType)ReturnType).Infer(ZType.VoidType, Node.SourceToken);
			}
			this.TypedNode(Node, ZType.VoidType);
		}
	}


	@Override public void VisitWhileNode(ZWhileNode Node) {
		Node.AST[ZWhileNode.Cond] = this.CheckType(Node.AST[ZWhileNode.Cond], ZType.BooleanType);
		Node.AST[ZWhileNode.Block] = this.CheckType(Node.AST[ZWhileNode.Block], ZType.VoidType);
		this.TypedNodeIf2(Node, ZType.VoidType, Node.AST[ZWhileNode.Cond], Node.AST[ZWhileNode.Block]);
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.TypedNode(Node, ZType.VoidType);
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		Node.AST[ZThrowNode.Expr] = this.CheckType(Node.AST[ZThrowNode.Expr], ZType.VarType);
		this.TypedNodeIf(Node, ZType.VoidType, Node.AST[ZThrowNode.Expr]);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		Node.AST[ZTryNode.Try] = this.CheckType(Node.AST[ZTryNode.Try], ZType.VoidType);
		if(Node.AST[ZTryNode.Catch] != null) {
			Node.AST[ZTryNode.Catch] = this.CheckType(Node.AST[ZTryNode.Catch], ZType.VoidType);
		}
		if(Node.AST[ZTryNode.Finally] != null) {
			Node.AST[ZTryNode.Finally] = this.CheckType(Node.AST[ZTryNode.Finally], ZType.VoidType);
		}
		this.TypedNode(Node, ZType.VoidType);
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		// TODO Auto-generated method stub
		this.Todo(Node);
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		Node.GlobalName = this.Generator.GetGlobalName(Node.Symbol);
		Node.AST[ZLetNode.InitValue] = this.CheckType(Node.AST[ZLetNode.InitValue], Node.SymbolType);
		this.TypedNode(Node, ZType.VoidType);
	}

	private boolean HasReturn(ZNode Node) {
		if(Node instanceof ZBlockNode) {
			@Var ZBlockNode BlockNode = (ZBlockNode)Node;
			@Var int i = 0;
			@Var ZNode StmtNode = null;
			while(i < BlockNode.GetListSize()) {
				StmtNode = BlockNode.GetListAt(i);
				if(StmtNode instanceof ZReturnNode) {
					return true;
				}
				i = i + 1;
			}
			Node = StmtNode;
		}
		if(Node instanceof ZReturnNode) {
			return true;
		}
		if(Node instanceof ZIfNode) {
			ZIfNode IfNode = (ZIfNode)Node;
			if(IfNode.AST[ZIfNode.Else] != null) {
				return this.HasReturn(IfNode.AST[ZIfNode.Then]) && this.HasReturn(IfNode.AST[ZIfNode.Else]);
			}
			return false;
		}
		if(Node instanceof ZBlockNode) {
			return this.HasReturn(Node);
		}
		return false;
	}

	@Override public void DefineFunction(ZFunctionNode FunctionNode, boolean Enforced) {
		if(FunctionNode.FuncName != null && FunctionNode.GlobalName == null) {
			@Var ZFuncType FuncType = FunctionNode.GetFuncType(null);
			//System.out.println("debug guessing " + FuncType);
			if(Enforced || !FuncType.IsVarType()) {
				@Var ZNameSpace NameSpace = FunctionNode.GetNameSpace();
				@Var ZFunc Func = ZenGamma.GetFunc(NameSpace, FunctionNode.FuncName, FuncType, null);
				if(Func != null) {
					this.Logger.ReportError(FunctionNode.SourceToken, "redefinition of function: " + Func);
				}
				else {
					Func = new ZSignature(0, FunctionNode.FuncName, FuncType, FunctionNode.SourceToken);
					ZenGamma.DefineFunc(NameSpace, Func);
					FunctionNode.GlobalName = Func.GetSignature();
				}
			}
		}
	}

	private void PushFunctionNode(ZNameSpace NameSpace, ZFunctionNode FunctionNode, ZType ContextType) {
		@Var ZFuncType FuncType = null;
		if(ContextType instanceof ZFuncType) {
			FuncType = (ZFuncType)ContextType;
		}
		this.CurrentFunctionNode = FunctionNode.Push(this.CurrentFunctionNode);
		this.VarScope = new ZVarScope(this.VarScope, this.Logger, null);
		@Var int i = 0;
		while(i < FunctionNode.GetListSize()) {
			@Var ZParamNode ParamNode = FunctionNode.GetParamNode(i);
			ParamNode.Type = this.VarScope.NewVarType(ParamNode.Type, ParamNode.Name, ParamNode.SourceToken);
			if(FuncType != null) {
				ParamNode.Type.Maybe(FuncType.GetParamType(i+1), null);
			}
			NameSpace.SetLocalVariable(this.CurrentFunctionNode, ParamNode.Type, ParamNode.Name, null);
			i = i + 1;
		}
		FunctionNode.ReturnType = this.VarScope.NewVarType(FunctionNode.ReturnType, "return", FunctionNode.SourceToken);
		if(FuncType != null) {
			FunctionNode.Type.Maybe(FuncType.GetParamType(0), null);
		}
	}

	private void PopFunctionNode(ZNameSpace NameSpace) {
		this.CurrentFunctionNode = this.CurrentFunctionNode.Pop();
		this.VarScope = this.VarScope.Parent;
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		@Var ZNameSpace NameSpace = Node.AST[ZFunctionNode.Block].GetNameSpace();
		@Var ZType ContextType = this.GetContextType();
		if(!this.HasReturn(Node.AST[ZFunctionNode.Block])) {
			Node.AST[ZFunctionNode.Block].Set(ZNode.AppendIndex, new ZReturnNode(Node));
		}
		this.PushFunctionNode(NameSpace, Node, ContextType);
		this.VarScope.TypeCheckFuncBlock(this, Node);
		this.PopFunctionNode(NameSpace);
		@Var ZFuncType FuncType = Node.GetFuncType(ContextType);
		if(this.IsTopLevel() && !FuncType.IsVarType()) {
			this.TypedNode(Node, ZType.VoidType);
		}
		else {
			this.TypedNode(Node, FuncType);
		}
	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		@Var ZType ClassType = NameSpace.GetType(Node.ClassName, Node.SourceToken);
		if(ClassType instanceof ZenClassType) {
			if(!ClassType.IsOpenType()) {
				this.Return(new ZErrorNode(Node, Node.ClassName + " has been defined."));
				return;
			}
			Node.ClassType = (ZenClassType)ClassType;
		}
		else {
			this.Return(new ZErrorNode(Node, Node.ClassName + " is not a Zen class."));
			return;
		}
		if(Node.SuperType != null) {
			if(Node.SuperType instanceof ZenClassType && !Node.SuperType.IsOpenType()) {
				Node.ClassType.ResetSuperType((ZenClassType)Node.SuperType);
			}
			else {
				this.Return(new ZErrorNode(Node, "" + Node.SuperType + " cannot be extended."));
				return;
			}
		}
		@Var int i = 0;
		while(i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			FieldNode.ClassType = Node.ClassType;
			if(FieldNode.AST[ZFieldNode.InitValue] == null) {
				FieldNode.AST[ZFieldNode.InitValue] = ZenGamma.CreateDefaultValueNode(FieldNode, FieldNode.DeclType, FieldNode.FieldName);
			}
			FieldNode.AST[ZFieldNode.InitValue] = this.CheckType(FieldNode.AST[ZFieldNode.InitValue], FieldNode.DeclType);
			if(FieldNode.DeclType.IsVarType()) {
				FieldNode.DeclType = FieldNode.AST[ZFieldNode.InitValue].Type;
				if(FieldNode.DeclType.IsVarType()) {
					this.Return(new ZErrorNode(FieldNode, "type of " + FieldNode.FieldName + " is unspecific"));
					return;
				}
			}
			Node.ClassType.AppendField(FieldNode.DeclType, FieldNode.FieldName, FieldNode.SourceToken);
			i = i + 1;
		}
		Node.ClassType.TypeFlag = ZUtils.UnsetFlag(Node.ClassType.TypeFlag, ZTypeFlag.OpenType);
		this.Return(Node.ClassType.CheckAllFields(NameSpace));
		this.TypedNode(Node, ZType.VoidType);
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.Return(Node);
	}

}

