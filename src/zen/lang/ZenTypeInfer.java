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
import zen.ast.ZConstPoolNode;
import zen.ast.ZEmptyNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFuncDeclNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetLocalNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
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
import zen.ast.ZSetLocalNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZSymbolNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.deps.LibZen;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.parser.ZLogger;
import zen.parser.ZNameSpace;
import zen.parser.ZNodeUtils;
import zen.parser.ZToken;
import zen.parser.ZUtils;

public class ZenTypeInfer extends ZenTypeChecker {

	public ZenTypeInfer(ZLogger Logger) {
		super(Logger);
	}

	@Override public void VisitEmptyNode(ZEmptyNode Node) {
		this.TypedNode(Node, ZSystem.VoidType);
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		ZType Type = this.GetContextType();
		this.TypedNode(Node, Type);
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.TypedNode(Node, ZSystem.BooleanType);
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.TypedNode(Node, ZSystem.IntType);
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.TypedNode(Node, ZSystem.FloatType);
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.TypedNode(Node, ZSystem.StringType);
	}

	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
		this.TypedNode(Node, ZSystem.GuessType(Node.ConstValue));
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.Todo(Node);
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.Todo(Node);
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		this.Todo(Node);
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.Todo(Node);
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		@Var ZType FuncType = this.GetContextType();
		if(Node.ParentNode instanceof ZFuncCallNode) {
			//			this.println("1 ContextualTyping .." + FuncType);
			FuncType = this.GuessFuncType(NameSpace, Node.GivenName, (ZFuncCallNode)Node.ParentNode, FuncType);
			//			this.println("2 ContextualTyping .." + FuncType);
			if(FuncType.HasCallableSignature()) {
				Node.ReferenceName = FuncType.StringfySignature(Node.GivenName);
			}
			if(!FuncType.IsCompleteFunc(false)) {
				FuncType = ZSystem.VarType;
			}
			this.TypedNode(Node, FuncType);
			return;
		}
		if(FuncType.HasCallableSignature()) {
			Node.ReferenceName = FuncType.StringfySignature(Node.GivenName);
			@Var Object Func = NameSpace.GetSymbol(Node.ReferenceName);
			if(Func instanceof ZFunc) {
				((ZFunc)Func).Used();
				FuncType = ((ZFunc)Func).GetFuncType();
			}
			else {
				this.InferFuncType(NameSpace, Node.GivenName, FuncType, Node.SourceToken);
			}
			this.TypedNode(Node, FuncType);
			return;
		}
		@Var Object Value = NameSpace.GetSymbol(Node.GivenName);
		if(Value != null) {
			@Var ZNode NewNode = ZNodeUtils.CreateConstNode(Node.SourceToken, Value);
			NewNode = this.TypeCheck(NewNode, NameSpace, ZSystem.VarType, 0);
			this.TypedNode(NewNode, NewNode.Type);
		}
		else {
			this.TypedNode(Node, ZSystem.VarType);
		}
	}

	@Override public void VisitGetLocalNode(ZGetLocalNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		@Var ZType ContextType = this.GetContextType();
		@Var ZenVariable VarInfo = this.GetLocalVariable(NameSpace, Node.VarName);
		if(VarInfo != null) {
			@Var ZType VarType = ZSystem.VarType;
			Node.VarName = VarInfo.VarName;
			Node.VarIndex = VarInfo.VarUniqueIndex;
			VarType = VarInfo.VarType;
			Node.IsCaptured = VarInfo.IsCaptured(NameSpace);
			this.TypedNode(Node, VarType);
		}
		else {
			@Var ZNode NewNode = new ZSymbolNode(ZSystem.VarType, Node.SourceToken, Node.VarName, Node.VarName);
			NewNode.ParentNode = Node.ParentNode;
			NewNode = this.TypeCheck(NewNode, NameSpace, ContextType, 0);
			this.TypedNode(NewNode, NewNode.Type);
		}
	}

	@Override public void VisitSetLocalNode(ZSetLocalNode Node) {
		ZNameSpace NameSpace = this.GetNameSpace();
		ZenVariable VarInfo = this.GetLocalVariable(NameSpace, Node.VarName);
		if(VarInfo == null) {
			this.CheckErrorNode(this.UndefinedName(Node, Node.VarName));
		}
		else {
			Node.VarName = VarInfo.VarName;
			Node.VarIndex = VarInfo.VarUniqueIndex;
			Node.IsCaptured = VarInfo.IsCaptured(NameSpace);
			Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, VarInfo.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
			this.TypedNodeIf(Node, ZSystem.VoidType, Node.ValueNode);
		}
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		ZNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.IndexNode = this.TypeCheck(Node.IndexNode, NameSpace, this.GetIndexType(NameSpace, Node.RecvNode.Type), ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, this.GetElementType(NameSpace, Node.RecvNode.Type), Node.RecvNode, Node.IndexNode);
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		ZNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.IndexNode = this.TypeCheck(Node.IndexNode, NameSpace, this.GetIndexType(NameSpace, Node.RecvNode.Type), ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, this.GetElementType(NameSpace, Node.RecvNode.Type), ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf3(Node, ZSystem.VoidType,  Node.RecvNode, Node.IndexNode, Node.ValueNode);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		Node.RecvNode.Accept(this); // this is shortcut
		this.TypedNode(Node, Node.RecvNode.Type);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		@Var ZType ContextType = this.GetContextType();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		ZType FieldType = this.GetFieldType(NameSpace, Node.RecvNode.Type, Node.FieldName);
		if(FieldType.IsVarType() && ContextType.IsInferrableType()) {
			this.InferFieldType(NameSpace, Node.RecvNode.Type, Node.FieldName, ContextType, Node.SourceToken);
		}
		if(FieldType.IsVoidType() && !Node.RecvNode.Type.IsVarType()) {
			this.CheckErrorNode(this.UndefinedName(Node, Node.RecvNode.Type.StringfyClassMember(Node.FieldName)));
			return;
		}
		this.TypedNodeIf(Node, FieldType, Node.RecvNode);
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		@Var ZType FieldType = this.GetSetterType(NameSpace, Node.RecvNode.Type, Node.FieldName);
		if(FieldType.IsVoidType()) {
			this.CheckErrorNode(this.ReadOnlyName(Node, Node.RecvNode.Type, Node.FieldName));
			return;
		}
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, FieldType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(FieldType.IsVarType()) {
			this.InferFieldType(NameSpace, Node.RecvNode.Type, Node.FieldName, Node.ValueNode.Type, Node.SourceToken);
		}
		this.TypedNodeIf2(Node, ZSystem.VoidType, Node.RecvNode, Node.ValueNode);
	}

	private ZenFuncType GuessFuncTypeFromContext(ZType ReturnType, @Nullable ZType RecvType, ArrayList<ZNode> ParamList) {
		if(ReturnType.IsVoidType()) {
			ReturnType = ZSystem.VarType;
		}
		ArrayList<ZType> TypeList = new ArrayList<ZType>();
		TypeList.add(ReturnType.GetRealType());
		if(RecvType != null) {
			TypeList.add(RecvType.GetRealType());
		}
		@Var int i = 0;
		while(i < ParamList.size()) {
			ZNode SubNode = ParamList.get(i);
			ZType ParamType = SubNode.Type.GetRealType();
			TypeList.add(ParamType);
			i = i + 1;
		}
		return ZSystem.LookupFuncType(TypeList);
	}

	private ZType TypeCheckFuncParam(ZNameSpace NameSpace, ArrayList<ZNode> ParamList, ZType ContextType, int ParamIdx /* 1: Func 2: Method*/) {
		//this.println("TypeCheck FuncType: " + ContextType);
		if(this.IsVisitable() && ContextType.IsFuncType()) {
			@Var ZenFuncType FuncType = (ZenFuncType)ContextType;
			@Var int i = 0;
			while(i < ParamList.size()) {
				@Var ZNode SubNode = ParamList.get(i);
				SubNode = this.TypeCheck(SubNode, NameSpace, FuncType.GetParamType(i+ParamIdx), ZenTypeChecker.DefaultTypeCheckPolicy);
				ParamList.set(i, SubNode);
				i = i + 1;
			}
			if(FuncType.IsCompleteFunc(false)) {
				return FuncType.GetReturnType();   // Return
			}
		}
		return ZSystem.VarType;
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		@Var ZType ContextType = this.GetContextType();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypeCheckNodeList(NameSpace, Node.ParamList);
		if(this.IsVisitable()) {
			@Var ZType FuncType = this.GuessFuncTypeFromContext(ContextType, Node.RecvNode.Type, Node.ParamList);
			FuncType = this.GuessMethodFuncType(NameSpace, Node.MethodName, Node, FuncType);
			@Var ZType ReturnType = this.TypeCheckFuncParam(NameSpace, Node.ParamList, FuncType, 2);
			this.TypedCastNode(Node, ContextType, ReturnType);
		}
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		@Var ZType ContextType = this.GetContextType();
		this.TypeCheckNodeList(NameSpace, Node.ParamList);
		@Var ZenFuncType PartialFuncType = this.GuessFuncTypeFromContext(ContextType, null, Node.ParamList);
		Node.FuncNode = this.TypeCheck(Node.FuncNode, NameSpace, PartialFuncType, ZenTypeChecker.NoCheckPolicy);
		@Var ZType FuncType = Node.FuncNode.Type;
		if(!FuncType.IsFuncType() && !FuncType.IsVarType()) {
			this.CheckErrorNode(new ZErrorNode(Node.SourceToken, "not function: given = " + FuncType));
		}
		else {
			if(FuncType.IsVarType()) {
				FuncType = PartialFuncType;
			}
			ZType ReturnType = this.TypeCheckFuncParam(NameSpace, Node.ParamList, FuncType, 1);
			this.TypedCastNode(Node, ContextType, ReturnType);
		}
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, Node.RecvNode.Type);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf(Node, ZSystem.BooleanType, Node.RecvNode);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		Node.ExprNode = this.TypeCheck(Node.ExprNode, NameSpace, Node.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, Node.Type);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf(Node, ZSystem.BooleanType, Node.LeftNode);
	}

	private ZType GetBinaryLeftType(String Op, ZType ContextType) {
		if(LibZen.EqualsString(Op, "|") || LibZen.EqualsString(Op, "&") || LibZen.EqualsString(Op, "<<") || LibZen.EqualsString(Op, ">>") || LibZen.EqualsString(Op,  "^")) {
			return ZSystem.IntType;
		}
		if(LibZen.EqualsString(Op, "*") || LibZen.EqualsString(Op, "-") || LibZen.EqualsString(Op, "/") || LibZen.EqualsString(Op, "%")) {
			if(ContextType.IsNumberType()) {
				return ContextType;
			}
		}
		return ZSystem.VarType;
	}

	private ZType GetBinaryRightType(String Op, ZType ContextType) {
		if(LibZen.EqualsString(Op, "|") || LibZen.EqualsString(Op, "&") || LibZen.EqualsString(Op, "<<") || LibZen.EqualsString(Op, ">>") || LibZen.EqualsString(Op,  "^")) {
			return ZSystem.IntType;
		}
		if(LibZen.EqualsString(Op, "*") || LibZen.EqualsString(Op, "-") || LibZen.EqualsString(Op, "/") || LibZen.EqualsString(Op, "%")) {
			if(ContextType.IsNumberType()) {
				return ContextType;
			}
		}
		return ZSystem.VarType;
	}

	private void UnifyBinaryNodeType(ZNameSpace NameSpace, ZBinaryNode Node, ZType Type, int Policy) {
		if(Node.LeftNode.Type.Equals(Type)) {
			Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, Type, Policy);
			return;
		}
		if(Node.RightNode.Type.Equals(Type)) {
			Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, Type,  Policy);
		}
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		ZNameSpace NameSpace = this.GetNameSpace();
		ZType ContextType = this.GetContextType();
		ZType LeftType = this.GetBinaryLeftType(Node.SourceToken.ParsedText, ContextType);
		ZType RightType = this.GetBinaryRightType(Node.SourceToken.ParsedText, ContextType);
		//System.err.println("debug left=" + LeftType + ", right=" + RightType);
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, LeftType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, RightType, ZenTypeChecker.DefaultTypeCheckPolicy);
		//System.err.println("debug left=" + Node.LeftNode.Type + ", right=" + Node.RightNode.Type);
		if(!Node.LeftNode.Type.Equals(Node.RightNode.Type)) {
			if(Node.SourceToken.EqualsText("+")) {
				this.UnifyBinaryNodeType(NameSpace, Node, ZSystem.StringType, ZenTypeChecker.EnforceCoercion);
			}
			this.UnifyBinaryNodeType(NameSpace, Node, ZSystem.FloatType, ZenTypeChecker.DefaultTypeCheckPolicy);
			Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, Node.RightNode.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		this.TypedNodeIf(Node, Node.LeftNode.Type, Node.RightNode);
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		ZNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, Node.LeftNode.Type, ZenTypeChecker.NoCheckPolicy);
		this.UnifyBinaryNodeType(NameSpace, Node, ZSystem.FloatType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, Node.LeftNode.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, ZSystem.BooleanType, Node.LeftNode, Node.RightNode);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		ZNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, ZSystem.BooleanType, Node.LeftNode, Node.RightNode);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		ZNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, ZSystem.BooleanType, Node.LeftNode, Node.RightNode);
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		if(this.IsVisitable()) {
			int i = 0;
			ZType BlockType = ZSystem.VoidType;
			while(i < Node.StmtList.size()) {
				ZNode SubNode = Node.StmtList.get(i).GetStatementNode();  // without annotation
				SubNode = this.TypeCheck(SubNode, Node.NameSpace, ZSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
				Node.StmtList.set(i, SubNode);
				if(SubNode.Type.IsVarType()) {
					BlockType = ZSystem.VarType;
				}
				if(SubNode.IsBreakingBlock()) {
					break;
				}
				i = i + 1;
			}
			this.EnableVisitor();
			this.TypedNode(Node, BlockType);
		}
	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		if(!(Node.DeclType instanceof ZenVarType)) {
			Node.DeclType = this.NewVarType(Node.DeclType, Node.NativeName, Node.SourceToken);
			this.SetLocalVariable(Node.NameSpace, Node.DeclType, Node.NativeName, Node.SourceToken);
		}
		Node.InitNode = this.TypeCheck(Node.InitNode, NameSpace, Node.DeclType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.VisitBlockNode(Node);
		this.TypedNodeIf2(Node, ZSystem.VoidType, Node.InitNode, Node);
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		Node.CondNode = this.TypeCheck(Node.CondNode, NameSpace, ZSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.ThenNode = this.TypeCheck(Node.ThenNode, NameSpace, ZSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(Node.ElseNode != null) {
			Node.ElseNode = this.TypeCheck(Node.ElseNode, NameSpace, ZSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
			this.TypedNodeIf3(Node, ZSystem.VoidType, Node.CondNode, Node.ThenNode, Node.ElseNode);
		}
		else {
			this.TypedNodeIf2(Node, ZSystem.VoidType, Node.CondNode, Node.ThenNode);
		}
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		@Var ZType ReturnType = this.FuncScope.GetReturnType();
		if(Node.ValueNode != null && ReturnType.IsVoidType()) {
			Node.ValueNode = null;
		}
		else if(Node.ValueNode == null && !ReturnType.IsVoidType() && !ReturnType.IsVoidType()) {
			this.Logger.ReportWarning(Node.SourceToken, "returning default value of " + ReturnType);
			Node.ValueNode = this.CreateDefaultValueNode(ReturnType, null);
		}
		if(Node.ValueNode != null) {
			Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ReturnType, ZenTypeChecker.DefaultTypeCheckPolicy);
			this.TypedNodeIf(Node, ZSystem.VoidType, Node.ValueNode);
		}
		else {
			if(ReturnType instanceof ZenVarType) {
				((ZenVarType)ReturnType).Infer(ZSystem.VoidType, Node.SourceToken);
			}
			this.TypedNode(Node, ZSystem.VoidType);
		}
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		Node.CondNode = this.TypeCheck(Node.CondNode, NameSpace, ZSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.BodyNode = this.TypeCheck(Node.BodyNode, NameSpace, ZSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, ZSystem.VoidType, Node.CondNode, Node.BodyNode);
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.TypedNode(Node, ZSystem.VoidType);
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf(Node, ZSystem.VoidType, Node.ValueNode);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		Node.TryNode = this.TypeCheck(Node.TryNode, NameSpace, ZSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(Node.CatchNode != null) {
			Node.CatchNode = this.TypeCheck(Node.CatchNode, NameSpace, ZSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		if(Node.FinallyNode != null) {
			Node.FinallyNode = this.TypeCheck(Node.FinallyNode, NameSpace, ZSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		this.TypedNode(Node, ZSystem.VoidType);
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		// TODO Auto-generated method stub
		this.Todo(Node);
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		// TODO Auto-generated method stub
		this.Todo(Node);
	}

	public ZFunc DefineFunc(ZNameSpace NameSpace, String FuncName, ZenFuncType FuncType, ZToken SourceToken) {
		if(FuncName != null && FuncType.HasCallableSignature()) {
			@Var String Signature = FuncType.StringfySignature(FuncName);
			@Var Object FuncObject = NameSpace.GetSymbol(Signature);
			if(FuncObject instanceof ZFunc) {
				@Var ZFunc PreDefined = (ZFunc)FuncObject;
				if(PreDefined.FuncType.MatchFunc(FuncType)) {
					PreDefined.Defined();
					return PreDefined;
				}
				else {
					this.CheckErrorNode(new ZErrorNode(SourceToken, "overloaded functions:\n\tPrevious: " + PreDefined + "\n\tPresent:" + FuncName + ": " + FuncType));
				}
				this.println("redefined func: " + PreDefined);
			}
			@Var ZFunc Func = new ZenSigFunc(0, FuncName, FuncType, SourceToken);
			NameSpace.SetSymbol(Signature, Func, SourceToken);
			return Func;
		}
		return null;
	}

	public void PushFuncNode(ZNameSpace NameSpace, ZFunctionNode FuncNode, ZenFuncType FuncType) {
		NameSpace.SetDefiningFunc(FuncNode);
		this.FuncScope = new ZFuncContext(this.FuncScope, this.Logger, FuncNode, FuncType);
		@Var int i = 0;
		while(i < FuncNode.ArgumentList.size()) {
			@Var ZParamNode ParamNode = (ZParamNode)FuncNode.ArgumentList.get(i);
			ParamNode.Type = this.NewVarType(ParamNode.Type, ParamNode.Name, ParamNode.SourceToken);
			this.SetLocalVariable(NameSpace, ParamNode.Type, ParamNode.Name, null);
			i = i + 1;
		}
		FuncNode.ReturnType = this.NewVarType(FuncNode.ReturnType, "return", FuncNode.SourceToken);
	}

	public final void TypeCheckFuncBody(ZNameSpace NameSpace, ZFuncDeclNode FuncNode) {
		@Var int Stopper = Integer.MAX_VALUE;
		while(this.IsVisitable()) {
			this.FuncScope.CountOfUnknownTypeNode = 0;
			FuncNode.BodyNode = this.TypeCheck(FuncNode.BodyNode, NameSpace, ZSystem.VoidType, 0);
			ZenFuncType RenewalFuncType = this.FuncScope.RecheckCompleteFuncType(FuncNode);
			if(RenewalFuncType != null) {
				this.DefineFunc(NameSpace, FuncNode.FuncName, RenewalFuncType, FuncNode.SourceToken);
			}
			//			int UntypedSize = this.FuncScope.GetVarSize();
			this.println("untyped node=" + this.FuncScope.CountOfUnknownTypeNode);
			if(this.FuncScope.CountOfUnknownTypeNode == 0 || Stopper == this.FuncScope.CountOfUnknownTypeNode) {
				break;
			}
			Stopper = this.FuncScope.CountOfUnknownTypeNode;
		}
	}

	public ZenFuncType PopFuncNode(ZNameSpace NameSpace, ZFunctionNode FuncNode) {
		NameSpace.SetDefiningFunc(null);
		this.FuncScope.Dump();
		ZenFuncType FuncType = this.FuncScope.FuncType;
		this.FuncScope = this.FuncScope.Parent;
		return FuncType;
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		@Var ZType ContextType = this.GetContextType();
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		@Var ZenFuncType FuncType = Node.GetFuncType(ContextType);
		this.DefineFunc(NameSpace, null, FuncType, Node.SourceToken);
		this.PushFuncNode(NameSpace, Node, FuncType);
		Node.BodyNode = this.TypeCheck(Node.BodyNode, NameSpace, ZSystem.VoidType, 0);
		FuncType = this.PopFuncNode(NameSpace, Node);
		this.TypedNode(Node, FuncType);
	}

	@Override public void VisitFuncDeclNode(ZFuncDeclNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		@Var ZenFuncType FuncType = Node.GetFuncType(null);
		assert(Node.BodyNode != null);
		this.DefineFunc(NameSpace, Node.FuncName, FuncType, Node.SourceToken);
		this.PushFuncNode(Node.NameSpace, Node, FuncType);
		this.TypeCheckFuncBody(Node.NameSpace, Node);
		FuncType = this.PopFuncNode(Node.NameSpace, Node);
		Node.ReferenceName = FuncType.StringfySignature(Node.FuncName);
		this.TypedNode(Node, ZSystem.VoidType);
	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
		@Var ZNameSpace NameSpace = this.GetNameSpace();
		this.CheckErrorNode(Node.CheckClassName(NameSpace));
		if(this.IsVisitable()) {
			@Var ZenClassType ClassType = (ZenClassType)Node.ClassType;
			@Var int i = 0;
			while(this.IsVisitable() && i < Node.FieldList.size()) {
				@Var ZFieldNode FieldNode = Node.FieldList.get(i);
				if(FieldNode.InitNode == null) {
					FieldNode.InitNode = this.CreateDefaultValueNode(FieldNode.DeclType, FieldNode.FieldName);
				}
				FieldNode.InitNode = this.TypeCheck(FieldNode.InitNode, NameSpace, FieldNode.DeclType, ZenTypeChecker.DefaultTypeCheckPolicy);
				if(FieldNode.DeclType.IsVarType()) {
					FieldNode.DeclType = FieldNode.InitNode.Type;
					this.CheckErrorNode(FieldNode.CheckFieldType());
				}
				ClassType.AppendField(FieldNode.DeclType, FieldNode.FieldName, FieldNode.SourceToken);
				i = i + 1;
			}
			ClassType.TypeFlag = ZUtils.UnsetFlag(ClassType.TypeFlag, ZTypeFlag.OpenType);
			this.CheckErrorNode(ClassType.CheckAllFields(NameSpace));
		}
		this.TypedNode(Node, ZSystem.VoidType);
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.CheckErrorNode(Node);
	}
}

