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

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZClassNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZConstNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGlobalNameNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZLetNode;
import zen.ast.ZListNode;
import zen.ast.ZMacroNode;
import zen.ast.ZMapEntryNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
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
import zen.ast.ZTypeNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.parser.ZGenerator;
import zen.parser.ZLogger;
import zen.parser.ZMacroFunc;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.parser.ZTypeChecker;
import zen.parser.ZVariable;
import zen.type.ZClassType;
import zen.type.ZFunc;
import zen.type.ZFuncType;
import zen.type.ZGenericType;
import zen.type.ZGreekType;
import zen.type.ZPrototype;
import zen.type.ZType;
import zen.type.ZTypePool;
import zen.type.ZVarScope;
import zen.type.ZVarType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;

public class ZenTypeSafer extends ZTypeChecker {

	@Field protected ZFunctionNode CurrentFunctionNode = null;

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
		@Var ZType Type = this.GetContextType();
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
		@Var ZType ArrayType = this.GetContextType();
		if(ArrayType.IsMapType() && Node.GetListSize() == 0) {
			/* this is exceptional treatment for map literal */
			this.TypedNode(new ZMapLiteralNode(Node.ParentNode), ArrayType);
			return;
		}
		@Var ZType ElementType = ZType.VarType;
		if(ArrayType.IsArrayType()) {
			ElementType = ArrayType.GetParamType(0);
		}
		@Var int i = 0;
		while(i < Node.GetListSize()) {
			@Var ZNode SubNode = Node.GetListAt(i);
			SubNode = this.CheckType(SubNode, ElementType);
			Node.SetListAt(i, SubNode);
			if(ElementType.IsVarType()) {
				ElementType = SubNode.Type;
			}
			i = i + 1;
		}
		if(!ElementType.IsVarType()) {
			this.TypedNode(Node,ZTypePool._GetGenericType1(ZGenericType._ArrayType, ElementType));
		}
		else {
			this.TypedNode(Node, ZType.VarType);
		}
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		@Var ZType ContextType = this.GetContextType();
		@Var ZType EntryType = ZType.VarType;
		if(ContextType.IsMapType()) {
			EntryType = ContextType.GetParamType(0);
		}
		@Var int i = 0;
		while(i < Node.GetListSize()) {
			@Var ZMapEntryNode EntryNode = Node.GetMapEntryNode(i);
			if(EntryNode.Name == null) {
				EntryNode.Name = EntryNode.AST[ZMapEntryNode._Key].SourceToken.GetText();
			}
			if(EntryNode.IsUntyped()) {
				this.CheckTypeAt(EntryNode, ZMapEntryNode._Value, EntryType);
				if(EntryType.IsVarType()) {
					EntryType = EntryNode.GetAstType(ZMapEntryNode._Value);
				}
			}
			i = i + 1;
		}
		if(!EntryType.IsVarType()) {
			this.TypedNode(Node, ZTypePool._GetGenericType1(ZGenericType._MapType, EntryType));
			return;
		}
		else {
			this.TypedNode(Node, ZType.VarType);
		}
	}

	//	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
	//		this.Todo(Node);
	//	}

	@Override public void VisitGlobalNameNode(ZGlobalNameNode Node) {
		this.Return(Node);
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
			@Var ZNode SymbolNode = NameSpace.GetSymbolNode(Node.VarName);
			if(SymbolNode == null) {
				SymbolNode = Node.ToGlobalNameNode();
			}
			this.TypedNode(SymbolNode, SymbolNode.Type);
		}
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		@Var ZVariable VarInfo = NameSpace.GetLocalVariable(Node.VarName);
		if(VarInfo == null) {
			this.ReturnErrorNode(Node, Node.SourceToken, "undefined variable");
			return;
		}
		Node.VarName = VarInfo.VarName;
		Node.VarIndex = VarInfo.VarUniqueIndex;
		Node.IsCaptured = VarInfo.IsCaptured(this.CurrentFunctionNode);
		if(Node.IsCaptured) {
			this.ReturnErrorNode(Node, Node.SourceToken, "readonly variable");
			return;
		}
		this.CheckTypeAt(Node, ZSetNameNode._Expr, VarInfo.VarType);
		this.TypedNode(Node, ZType.VoidType);
	}

	private ZType GetIndexType(ZNameSpace NameSpace, ZType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsStringType()) {
			return ZType.IntType;
		}
		if(RecvType.IsMapType()) {
			return ZType.StringType;
		}
		return ZType.VarType;
	}

	private ZType GetElementType(ZNameSpace NameSpace, ZType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsMapType()) {
			return RecvType.GetParamType(0);
		}
		if(RecvType.IsStringType()) {
			return ZType.StringType;
		}
		return ZType.VarType;
	}


	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		this.CheckTypeAt(Node, ZGetIndexNode._Recv, ZType.VarType);
		this.CheckTypeAt(Node, ZGetIndexNode._Index, this.GetIndexType(NameSpace, Node.AST[ZGetIndexNode._Recv].Type));
		this.TypedNode(Node, this.GetElementType(NameSpace, Node.AST[ZGetIndexNode._Recv].Type));
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		this.CheckTypeAt(Node, ZSetIndexNode._Recv, ZType.VarType);
		this.CheckTypeAt(Node, ZSetIndexNode._Index, this.GetIndexType(NameSpace, Node.AST[ZSetIndexNode._Recv].Type));
		this.CheckTypeAt(Node, ZSetIndexNode._Expr, this.GetElementType(NameSpace, Node.AST[ZSetIndexNode._Recv].Type));
		this.TypedNode(Node, ZType.VoidType);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		@Var ZType ContextType = this.GetContextType();
		this.CheckTypeAt(Node, ZGroupNode._Expr, ContextType);
		this.TypedNode(Node, Node.GetAstType(ZGroupNode._Expr));
	}

	private void VisitListNodeAsFuncCall(ZListNode FuncNode, ZFuncType FuncType) {
		@Var int i = 0;
		@Var ZType[] Greek = ZGreekType._NewGreekTypes(null);
		while(i < FuncNode.GetListSize()) {
			@Var ZNode SubNode = FuncNode.GetListAt(i);
			@Var ZType ParamType =  FuncType.GetParamType(i+1);
			SubNode = this.TryType(SubNode, ParamType);
			if(!SubNode.IsUntyped() || !ParamType.IsVarType()) {
				if(!ParamType.AcceptValueType(SubNode.Type, false, Greek)) {
					SubNode = this.CreateStupidCastNode(ParamType.GetGreekRealType(Greek), SubNode);
				}
			}
			FuncNode.SetListAt(i, SubNode);
			i = i + 1;
		}
		this.TypedNode(FuncNode, FuncType.GetReturnType().GetGreekRealType(Greek));
		//		//		if(FuncNode.IsUntyped()) {
		//		System.err.println("untyped: " + FuncType + ", node=" + FuncNode);
		//		//		}
	}

	@Override public void VisitMacroNode(ZMacroNode FuncNode) {
		this.VisitListNodeAsFuncCall(FuncNode, FuncNode.GetFuncType());
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		this.TypeCheckNodeList(Node);
		this.CheckTypeAt(Node, ZFuncCallNode._Func, ZType.VarType);
		@Var ZNode FuncNode = Node.AST[ZFuncCallNode._Func];
		@Var ZType FuncNodeType = Node.GetAstType(ZFuncCallNode._Func);
		if(FuncNodeType instanceof ZFuncType) {
			this.VisitListNodeAsFuncCall(Node, (ZFuncType)FuncNodeType);
		}
		else if(FuncNode instanceof ZTypeNode) {
			@Var String FuncName = FuncNode.Type.ShortName;
			@Var ZFunc Func = this.LookupFunc(NameSpace, FuncName, FuncNode.Type, Node.GetListSize());
			if(Func != null) {
				Node.Set(ZFuncCallNode._Func, new ZGlobalNameNode(Node, FuncNode.SourceToken, Func.GetFuncType(), FuncName, true));
				this.VisitListNodeAsFuncCall(Node, Func.GetFuncType());
				return;
			}
		}
		else if(FuncNodeType.IsVarType()) {
			@Var String FuncName = Node.GetFuncName();
			if(FuncName != null) {
				@Var ZFunc Func = this.LookupFunc(NameSpace, FuncName, Node.GetRecvType(), Node.GetListSize());
				if(Func instanceof ZMacroFunc) {
					@Var ZMacroNode MacroNode = Node.ToMacroNode((ZMacroFunc)Func);
					this.VisitListNodeAsFuncCall(MacroNode, Func.GetFuncType());
					return;
				}
				else if(Func != null) {
					@Var ZGlobalNameNode NameNode = (ZGlobalNameNode)Node.AST[ZFuncCallNode._Func];
					NameNode.Type = Func.GetFuncType();
					NameNode.IsStaticFuncName = true;
					this.VisitListNodeAsFuncCall(Node, Func.GetFuncType());
					return;
				}
			}
			this.TypedNode(Node, ZType.VarType);
		}
		else {
			this.Return(new ZErrorNode(Node, "not function: " + FuncNodeType + " of node " + Node.AST[ZFuncCallNode._Func]));
		}
	}

	private ZType LookupFieldType(ZNameSpace NameSpace, ZType ClassType, String FieldName) {
		ClassType = ClassType.GetRealType();
		if(ClassType instanceof ZClassType) {
			return ((ZClassType)ClassType).GetFieldType(FieldName, ZType.VoidType);
		}
		return NameSpace.Generator.GetFieldType(ClassType, FieldName);
	}

	private ZType LookupSetterType(ZNameSpace NameSpace, ZType ClassType, String FieldName) {
		ClassType = ClassType.GetRealType();
		if(ClassType instanceof ZClassType) {
			return ((ZClassType)ClassType).GetFieldType(FieldName, ZType.VoidType);
		}
		return NameSpace.Generator.GetSetterType(ClassType, FieldName);
	}

	private ZNode UndefinedFieldNode(ZNode Node, String Name) {
		return new ZErrorNode(Node, "undefined field: " + Name + " of " + Node.GetAstType(ZGetterNode._Recv));
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		this.CheckTypeAt(Node, ZGetterNode._Recv, ZType.VarType);
		if(!Node.AST[ZSetterNode._Recv].IsUntyped()) {
			@Var ZType FieldType = this.LookupFieldType(NameSpace, Node.GetAstType(ZGetterNode._Recv), Node.FieldName);
			if(FieldType.IsVoidType()) {
				this.Return(this.UndefinedFieldNode(Node, Node.FieldName));
				return;
			}
			this.TypedNode(Node, FieldType);
		}
		else {
			this.TypedNode(Node, ZType.VarType);
		}
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		this.CheckTypeAt(Node, ZSetterNode._Recv, ZType.VarType);
		if(!Node.AST[ZSetterNode._Recv].IsUntyped()) {
			@Var ZType FieldType = this.LookupSetterType(NameSpace, Node.GetAstType(ZSetterNode._Recv), Node.FieldName);
			if(FieldType.IsVoidType()) {
				this.Return(this.UndefinedFieldNode(Node, Node.FieldName));
				return;
			}
			this.CheckTypeAt(Node, ZSetterNode._Expr, FieldType);
			this.TypedNode(Node, ZType.VoidType);
		}
		else {
			/* if Recv is Var, type should not be decided */
			this.TypedNode(Node, ZType.VarType);
		}
	}

	private void VisitListAsNativeMethod(ZNode Node, ZType RecvType, String MethodName, ZListNode List) {
		@Var ZFuncType FuncType = this.Generator.GetMethodFuncType(RecvType, MethodName, List);
		if(FuncType != null) {
			if(!FuncType.IsVarType()) {
				@Var int i = 0;
				@Var int StaticShift = FuncType.GetParamSize() - List.GetListSize();
				while(i < List.GetListSize()) {
					@Var ZNode SubNode = List.GetListAt(i);
					SubNode = this.CheckType(SubNode, FuncType.GetParamType(i+StaticShift));
					List.SetListAt(i, SubNode);
					i = i + 1;
				}
			}
			this.TypedNode(Node, FuncType.GetReturnType());
			return;
		}
		@Var String Message = null;
		if(MethodName == null) {
			Message = "undefined constructor: " + RecvType;
		}
		else {
			Message = "undefined method: " + MethodName + " of " + RecvType;
		}
		this.ReturnErrorNode(Node, null, Message);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		this.CheckTypeAt(Node, ZMethodCallNode._Recv, ZType.VarType);
		if(!Node.AST[ZMethodCallNode._Recv].IsUntyped()) {
			@Var ZType FieldType = this.LookupFieldType(NameSpace, Node.GetAstType(ZMethodCallNode._Recv), Node.MethodName);
			if(FieldType instanceof ZFuncType) {
				@Var ZFuncCallNode FuncCall = Node.ToGetterFuncCall();
				this.VisitListNodeAsFuncCall(FuncCall, (ZFuncType)FieldType);
				return;
			}
			@Var int FuncParamSize = Node.GetListSize() + 1;
			@Var ZFunc Func = this.LookupFunc(NameSpace, Node.MethodName, Node.GetAstType(ZMethodCallNode._Recv), FuncParamSize);
			if(Func != null) {
				@Var ZListNode FuncCall = Node.ToFuncCallNode(Func);
				this.VisitListNodeAsFuncCall(FuncCall, Func.GetFuncType());
			}
			else {
				this.VisitListAsNativeMethod(Node, Node.GetAstType(ZMethodCallNode._Recv), Node.MethodName, Node);
			}
		}
		else {
			this.TypeCheckNodeList(Node);
			this.TypedNode(Node, ZType.VarType);
		}
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		@Var ZType ContextType = this.GetContextType();
		this.TypeCheckNodeList(Node);
		if(Node.Type.IsVarType()) {
			if(ContextType.IsVarType()) {
				this.TypedNode(Node, ZType.VarType);
				return;
			}
			Node.Type = ContextType;
		}
		@Var int FuncParamSize = Node.GetListSize() + 1;
		@Var ZFunc Func = this.LookupFunc(NameSpace, Node.Type.ShortName, Node.Type, FuncParamSize);
		if(Func != null) {
			@Var ZListNode FuncCall = Node.ToFuncCallNode(Func);
			this.VisitListNodeAsFuncCall(FuncCall, Func.GetFuncType());
			return;
		}
		this.VisitListAsNativeMethod(Node, Node.Type, null, Node);
	}



	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.CheckTypeAt(Node, ZUnaryNode._Recv, ZType.VarType);
		this.TypedNode(Node, Node.AST[ZUnaryNode._Recv].Type);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		this.CheckTypeAt(Node, ZNotNode._Recv, ZType.BooleanType);
		this.TypedNode(Node, ZType.BooleanType);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.TryTypeAt(Node, ZCastNode._Expr, Node.Type);
		@Var ZType ExprType = Node.AST[ZCastNode._Expr].Type;
		if(ExprType.Equals(Node.Type)) {
			this.Return(Node.AST[ZCastNode._Expr]);
		}
		@Var ZFunc Func = this.Generator.LookupConverterFunc(ExprType, Node.Type);
		if(Func != null) {
			this.TypedNode(Node.ToFuncCallNode(Func), Node.Type);
		}
		this.TypedNode(Node, Node.Type);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.CheckTypeAt(Node, ZBinaryNode._Left, ZType.VarType);
		this.TypedNode(Node, ZType.BooleanType);
	}

	private ZType GuessBinaryLeftType(ZToken Op, ZType ContextType) {
		if(Op.EqualsText('|') || Op.EqualsText('&') || Op.EqualsText("<<") || Op.EqualsText(">>") || Op.EqualsText('^')) {
			return ZType.IntType;
		}
		if(Op.EqualsText('+') || Op.EqualsText('-') || Op.EqualsText('*') || Op.EqualsText('/') || Op.EqualsText('%')) {
			if(ContextType.IsNumberType()) {
				return ContextType;
			}
		}
		return ZType.VarType;
	}

	private void UnifyBinaryNodeType(ZBinaryNode Node, ZType Type) {
		if(Node.GetAstType(ZBinaryNode._Left).Equals(Type)) {
			this.CheckTypeAt(Node, ZBinaryNode._Right, Type);
			return;
		}
		if(Node.GetAstType(ZBinaryNode._Right).Equals(Type)) {
			this.CheckTypeAt(Node, ZBinaryNode._Left, Type);
		}
	}

	private void UnifyBinaryEnforcedType(ZBinaryNode Node, ZType Type) {
		if(Node.GetAstType(ZBinaryNode._Left).Equals(Type)) {
			Node.Set(ZBinaryNode._Right, this.EnforceNodeType(Node.AST[ZBinaryNode._Right], Type));
			return;
		}
		if(Node.GetAstType(ZBinaryNode._Right).Equals(Type)) {
			Node.Set(ZBinaryNode._Left, this.EnforceNodeType(Node.AST[ZBinaryNode._Left], Type));
		}
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		@Var ZType ContextType = this.GetContextType();
		@Var ZType LeftType = this.GuessBinaryLeftType(Node.SourceToken, ContextType);
		@Var ZType RightType = this.GuessBinaryLeftType(Node.SourceToken, ContextType);
		this.CheckTypeAt(Node, ZBinaryNode._Left, LeftType);
		this.CheckTypeAt(Node, ZBinaryNode._Right, RightType);
		//System.err.println("debug left=" + Node.AST[ZBinaryNode.Left].Type + ", right=" + Node.AST[ZBinaryNode.Right].Type);
		if(!Node.GetAstType(ZBinaryNode._Left).Equals(Node.GetAstType(ZBinaryNode._Right))) {
			if(Node.SourceToken.EqualsText('+')) {
				this.UnifyBinaryEnforcedType(Node, ZType.StringType);
			}
			this.UnifyBinaryNodeType(Node, ZType.FloatType);
			this.CheckTypeAt(Node, ZBinaryNode._Left, Node.GetAstType(ZBinaryNode._Right));
		}
		this.TypedNode(Node.TryMacroNode(this.Generator), Node.GetAstType(ZBinaryNode._Left));
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.CheckTypeAt(Node, ZBinaryNode._Left, ZType.VarType);
		this.TryTypeAt(Node, ZBinaryNode._Right, Node.GetAstType(ZBinaryNode._Left));
		this.UnifyBinaryNodeType(Node, ZType.FloatType);
		//this.CheckTypeAt(Node, ZBinaryNode._Right, Node.GetAstType(ZBinaryNode._Left));
		this.TypedNode(Node, ZType.BooleanType);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.CheckTypeAt(Node, ZBinaryNode._Left, ZType.BooleanType);
		this.CheckTypeAt(Node, ZBinaryNode._Right, ZType.BooleanType);
		this.TypedNode(Node, ZType.BooleanType);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		this.CheckTypeAt(Node, ZBinaryNode._Left, ZType.BooleanType);
		this.CheckTypeAt(Node, ZBinaryNode._Right, ZType.BooleanType);
		this.TypedNode(Node, ZType.BooleanType);
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		@Var int i = 0;
		while(i < Node.GetListSize()) {
			@Var ZNode SubNode = Node.GetListAt(i);  // without annotation
			SubNode = this.CheckType(SubNode, ZType.VoidType);
			Node.SetListAt(i, SubNode);
			if(SubNode.IsBreakingBlock()) {
				Node.ClearListAfter(i+1);
				break;
			}
			i = i + 1;
		}
		this.TypedNode(Node, ZType.VoidType);
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		if(!this.InFunctionScope()) {
			this.ReturnErrorNode(Node, Node.SourceToken, "only available inside function");
			return;
		}
		this.CheckTypeAt(Node, ZVarNode._InitValue, Node.DeclType);
		if(Node.DeclType.IsVarType()) {
			Node.DeclType = Node.GetAstType(ZVarNode._InitValue);
		}
		if(Node.VarIndex == -1) {
			Node.DeclType = this.VarScope.NewVarType(Node.DeclType, Node.NativeName, Node.SourceToken);
			Node.VarIndex = Node.NameSpace.SetLocalVariable(this.CurrentFunctionNode, Node.DeclType, Node.NativeName, Node.SourceToken);
		}
		this.VisitBlockNode(Node);
		if(Node.GetListSize() == 0) {
			ZLogger._LogWarning(Node.SourceToken, "unused variable: " + Node.NativeName);
		}
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		this.CheckTypeAt(Node, ZIfNode._Cond, ZType.BooleanType);
		this.CheckTypeAt(Node, ZIfNode._Then, ZType.VoidType);
		if(Node.HasAst(ZIfNode._Else)) {
			this.CheckTypeAt(Node, ZIfNode._Else, ZType.VoidType);
		}
		this.TypedNode(Node, ZType.VoidType);
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		if(!this.InFunctionScope()) {
			this.ReturnErrorNode(Node, Node.SourceToken, "only available inside function");
			return;
		}
		@Var ZType ReturnType = this.CurrentFunctionNode.ReturnType;
		if(Node.HasAst(ZReturnNode._Expr) && ReturnType.IsVoidType()) {
			Node.AST[ZReturnNode._Expr] = null;
		}
		else if(!Node.HasAst(ZReturnNode._Expr) && !ReturnType.IsVarType() && !ReturnType.IsVoidType()) {
			ZLogger._LogWarning(Node.SourceToken, "returning default value of " + ReturnType);
			Node.Set(ZReturnNode._Expr, ZConstNode._CreateDefaultValueNode(Node, ReturnType, null));
		}
		if(Node.HasAst(ZReturnNode._Expr)) {
			this.CheckTypeAt(Node, ZReturnNode._Expr, ReturnType);
		}
		else {
			if(ReturnType instanceof ZVarType) {
				((ZVarType)ReturnType).Infer(ZType.VoidType, Node.SourceToken);
			}
		}
		this.TypedNode(Node, ZType.VoidType);
	}


	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.CheckTypeAt(Node, ZWhileNode._Cond, ZType.BooleanType);
		this.CheckTypeAt(Node, ZWhileNode._Block, ZType.VoidType);
		this.TypedNode(Node, ZType.VoidType);
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.TypedNode(Node, ZType.VoidType);
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.CheckTypeAt(Node, ZThrowNode._Expr, ZType.VarType);
		this.TypedNode(Node, ZType.VoidType);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.CheckTypeAt(Node, ZTryNode._Try, ZType.VoidType);
		if(Node.HasAst(ZTryNode._Catch)) {
			this.CheckTypeAt(Node, ZTryNode._Catch, ZType.VoidType);
		}
		if(Node.HasAst(ZTryNode._Finally)) {
			this.CheckTypeAt(Node, ZTryNode._Finally, ZType.VoidType);
		}
		this.TypedNode(Node, ZType.VoidType);
	}


	@Override public void VisitLetNode(ZLetNode Node) {
		this.CheckTypeAt(Node, ZLetNode._InitValue, Node.SymbolType);
		if(!Node.GetAstType(ZLetNode._InitValue).IsVarType()) {
			Node.GlobalName = this.Generator.NameGlobalSymbol(Node.Symbol);
			Node.GetNameSpace().SetLocalSymbol(Node.Symbol, Node.AST[ZLetNode._InitValue]);
		}
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
			@Var ZIfNode IfNode = (ZIfNode)Node;
			if(IfNode.HasAst(ZIfNode._Else)) {
				return this.HasReturn(IfNode.AST[ZIfNode._Then]) && this.HasReturn(IfNode.AST[ZIfNode._Else]);
			}
			return false;
		}
		if(Node instanceof ZBlockNode) {
			return this.HasReturn(Node);
		}
		return false;
	}

	@Override public void DefineFunction(ZFunctionNode FunctionNode, boolean Enforced) {
		if(FunctionNode.FuncName != null && FunctionNode.ResolvedFuncType == null) {
			@Var ZFuncType FuncType = FunctionNode.GetFuncType(null);
			//System.out.println("debug guessing " + FuncType);
			if(Enforced || !FuncType.IsVarType()) {
				@Var ZNameSpace NameSpace = FunctionNode.GetNameSpace();
				@Var ZPrototype Func = NameSpace.Generator.SetPrototype(FunctionNode, FunctionNode.FuncName, FuncType);
				if(Func != null) {
					Func.Defined();
					if(Func.DefinedCount > 1) {
						ZLogger._LogError(FunctionNode.SourceToken, "redefinition of function: " + Func);
					}
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
			ParamNode.ParamIndex = i;
			ParamNode.Type = this.VarScope.NewVarType(ParamNode.Type, ParamNode.Name, ParamNode.SourceToken);
			if(FuncType != null) {
				this.VarScope.InferType(FuncType.GetParamType(i+1), ParamNode);
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
		//LibZen._PrintDebug("name="+Node.FuncName+ ", Type=" + Node.Type + ", IsTopLevel=" + this.IsTopLevel());
		@Var ZNameSpace NameSpace = Node.AST[ZFunctionNode._Block].GetNameSpace();
		@Var ZType ContextType = this.GetContextType();
		if(Node.IsUntyped()) {
			Node.Type = ContextType;  // funcdecl is requested with VoidType
		}
		if(Node.Type.IsVoidType()) {
			if(Node.FuncName == null) {   // function() object
				Node.Type = ZType.VarType;
			}
			if(!this.IsTopLevel()) {
				/* function f() {} ==> var f = function() {} */
				@Var ZVarNode VarNode = new ZVarNode(Node.ParentNode);
				VarNode.SetNameInfo(null, Node.FuncName);
				VarNode.Set(ZVarNode._InitValue, Node);
				@Var ZBlockNode Block = Node.GetScopeBlockNode();
				@Var int Index = Block.IndexOf(Node);
				Block.CopyTo(Index+1, VarNode);
				Block.ClearListAfter(Index+1);   // Block[Index] is set to VarNode
				this.VisitVarNode(VarNode);
				return;
			}
		}
		if(!this.HasReturn(Node.AST[ZFunctionNode._Block])) {
			Node.AST[ZFunctionNode._Block].Set(ZNode._AppendIndex, new ZReturnNode(Node));
		}
		this.PushFunctionNode(NameSpace, Node, ContextType);
		this.VarScope.TypeCheckFuncBlock(this, Node);
		this.PopFunctionNode(NameSpace);
		if(!Node.Type.IsVoidType()) {
			Node.Type = Node.GetFuncType(ContextType);
		}
		this.Return(Node);
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		@Var ZNameSpace NameSpace = Node.GetNameSpace();
		@Var ZType ClassType = NameSpace.GetType(Node.ClassName, Node.SourceToken);
		if(ClassType instanceof ZClassType) {
			if(!ClassType.IsOpenType()) {
				this.Return(new ZErrorNode(Node, Node.ClassName + " has been defined."));
				return;
			}
			Node.ClassType = (ZClassType)ClassType;
		}
		else {
			this.Return(new ZErrorNode(Node, Node.ClassName + " is not a Zen class."));
			return;
		}
		//System.out.println(" B NodeClass.ToOpen="+Node.ClassType+", IsOpenType="+Node.ClassType.IsOpenType());
		if(Node.SuperType != null) {
			if(Node.SuperType instanceof ZClassType && !Node.SuperType.IsOpenType()) {
				Node.ClassType.ResetSuperType((ZClassType)Node.SuperType);
			}
			else {
				this.Return(new ZErrorNode(Node.ParentNode, Node.SuperToken, "" + Node.SuperType + " cannot be extended."));
				return;
			}
		}
		@Var int i = 0;
		while(i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			if(!FieldNode.HasAst(ZFieldNode._InitValue)) {
				FieldNode.Set(ZFieldNode._InitValue, ZConstNode._CreateDefaultValueNode(FieldNode, FieldNode.DeclType, FieldNode.FieldName));
			}
			if(!Node.ClassType.HasField(FieldNode.FieldName)) {
				FieldNode.ClassType = Node.ClassType;
				this.CheckTypeAt(FieldNode, ZFieldNode._InitValue, FieldNode.DeclType);
				if(FieldNode.DeclType.IsVarType()) {
					FieldNode.DeclType = FieldNode.AST[ZFieldNode._InitValue].Type;
				}
				if(FieldNode.DeclType.IsVarType()) {
					ZLogger._LogError(FieldNode.SourceToken, "type of " + FieldNode.FieldName + " is unspecific");
				}
				else {
					Node.ClassType.AppendField(FieldNode.DeclType, FieldNode.FieldName, FieldNode.SourceToken);
				}
			}
			else {
				ZLogger._LogError(FieldNode.SourceToken, "duplicated field: " + FieldNode.FieldName);
			}
			FieldNode.Type = ZType.VoidType;
			i = i + 1;
		}
		Node.ClassType.TypeFlag = LibZen._UnsetFlag(Node.ClassType.TypeFlag, ZType.OpenTypeFlag);
		//System.out.println(" E NodeClass.ToOpen="+Node.ClassType+", IsOpenType="+Node.ClassType.IsOpenType());
		this.TypedNode(Node, ZType.VoidType);
	}

	// utils

	private ZFunc LookupFunc(ZNameSpace NameSpace, String FuncName, ZType RecvType, int FuncParamSize) {
		@Var String Signature = ZFunc._StringfySignature(FuncName, FuncParamSize, RecvType);
		@Var ZFunc Func = this.Generator.GetDefinedFunc(Signature);
		if(Func != null) {
			return Func;
		}
		if(RecvType.IsIntType()) {
			Signature = ZFunc._StringfySignature(FuncName, FuncParamSize, ZType.FloatType);
			Func = this.Generator.GetDefinedFunc(Signature);
			if(Func != null) {
				return Func;
			}
		}
		if(RecvType.IsFloatType()) {
			Signature = ZFunc._StringfySignature(FuncName, FuncParamSize, ZType.IntType);
			Func = this.Generator.GetDefinedFunc(Signature);
			if(Func != null) {
				return Func;
			}
		}
		RecvType = RecvType.GetSuperType();
		while(RecvType != null) {
			Signature = ZFunc._StringfySignature(FuncName, FuncParamSize, RecvType);
			Func = this.Generator.GetDefinedFunc(Signature);
			if(Func != null) {
				return Func;
			}
			if(RecvType.IsVarType()) {
				break;
			}
			RecvType = RecvType.GetSuperType();
		}
		//		if(Func == null) {
		//			System.err.println("Unfound: " + FuncName + ", " + RecvType + ", " + FuncParamSize);
		//		}
		return null;
	}

	//	private ZFunc LookupFunc2(ZNameSpace NameSpace, String FuncName, ZType RecvType, int FuncParamSize) {
	//		@Var ZFunc Func = this.Generator.LookupFunc(FuncName, RecvType, FuncParamSize);
	//		if(Func == null && RecvType.IsIntType()) {
	//			Func = this.Generator.GetDefinedFunc(FuncName, ZType.FloatType, FuncParamSize);
	//		}
	//		if(Func == null && RecvType.IsFloatType()) {
	//			Func = this.Generator.GetDefinedFunc(FuncName, ZType.IntType, FuncParamSize);
	//		}
	//		if(Func == null) {
	//			System.err.println("Unfound: " + FuncName + ", " + RecvType + ", " + FuncParamSize);
	//		}
	//		return null;
	//	}

}

