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

import zen.ast.ZenAndNode;
import zen.ast.ZenArrayLiteralNode;
import zen.ast.ZenBinaryNode;
import zen.ast.ZenBlockNode;
import zen.ast.ZenBooleanNode;
import zen.ast.ZenBreakNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenConstPoolNode;
import zen.ast.ZenEmptyNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFloatNode;
import zen.ast.ZenFuncCallNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionLiteralNode;
import zen.ast.ZenGetIndexNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenGetterNode;
import zen.ast.ZenGroupNode;
import zen.ast.ZenIfNode;
import zen.ast.ZenInstanceOfNode;
import zen.ast.ZenIntNode;
import zen.ast.ZenMapLiteralNode;
import zen.ast.ZenMethodCallNode;
import zen.ast.ZenNewArrayNode;
import zen.ast.ZenNewObjectNode;
import zen.ast.ZenNode;
import zen.ast.ZenNotNode;
import zen.ast.ZenNullNode;
import zen.ast.ZenOrNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenSetIndexNode;
import zen.ast.ZenSetLocalNode;
import zen.ast.ZenSetterNode;
import zen.ast.ZenStringNode;
import zen.ast.ZenSymbolNode;
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenUnaryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast.ZenWhileNode;
import zen.deps.LibZen;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.parser.ZenLogger;
import zen.parser.ZenNameSpace;
import zen.parser.ZenNodeUtils;

public class ZenTypeInfer extends ZenTypeChecker {

	public ZenTypeInfer(ZenLogger Logger) {
		super(Logger);
	}

	@Override public void VisitEmptyNode(ZenEmptyNode Node) {
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitNullNode(ZenNullNode Node) {
		ZenType Type = this.GetContextType();
		this.TypedNode(Node, Type);
	}

	@Override public void VisitBooleanNode(ZenBooleanNode Node) {
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitIntNode(ZenIntNode Node) {
		this.TypedNode(Node, ZenSystem.IntType);
	}

	@Override public void VisitFloatNode(ZenFloatNode Node) {
		this.TypedNode(Node, ZenSystem.FloatType);
	}

	@Override public void VisitStringNode(ZenStringNode Node) {
		this.TypedNode(Node, ZenSystem.StringType);
	}

	@Override public void VisitConstPoolNode(ZenConstPoolNode Node) {
		this.TypedNode(Node, ZenSystem.GuessType(Node.ConstValue));
	}

	@Override public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
		this.Todo(Node);
	}

	@Override public void VisitMapLiteralNode(ZenMapLiteralNode Node) {
		this.Todo(Node);
	}

	@Override public void VisitNewArrayNode(ZenNewArrayNode Node) {
		this.Todo(Node);
	}

	@Override public void VisitNewObjectNode(ZenNewObjectNode Node) {
		this.Todo(Node);
	}

	@Override public void VisitSymbolNode(ZenSymbolNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		@Var Object Value = NameSpace.GetSymbol(Node.GivenName);
		if(Value != null) {
			@Var ZenNode NewNode = ZenNodeUtils.CreateConstNode(Node.SourceToken, Value);
			NewNode = this.TypeCheck(NewNode, NameSpace, ZenSystem.VarType, 0);
			this.TypedNode(NewNode, NewNode.Type);
		}
	}

	@Override public void VisitGetLocalNode(ZenGetLocalNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		@Var ZenVariable VarInfo = this.GetLocalVariable(NameSpace, Node.VarName);
		if(VarInfo != null) {
			@Var ZenType VarType = ZenSystem.VarType;
			Node.VarName = VarInfo.VarName;
			Node.VarIndex = VarInfo.VarUniqueIndex;
			VarType = VarInfo.VarType;
			Node.IsCaptured = VarInfo.IsCaptured(NameSpace);
			this.TypedNode(Node, VarType);
		}
		else {
			@Var ZenNode NewNode = new ZenSymbolNode(ZenSystem.VarType, Node.SourceToken, Node.VarName, Node.VarName);
			NewNode = this.TypeCheck(NewNode, NameSpace, ZenSystem.VarType, 0);
			this.TypedNode(NewNode, NewNode.Type);
		}
	}

	@Override public void VisitSetLocalNode(ZenSetLocalNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenVariable VarInfo = this.GetLocalVariable(NameSpace, Node.VarName);
		if(VarInfo == null) {
			this.CheckErrorNode(this.CreateUndefinedVarErrorNode(Node, Node.VarName));
		}
		else {
			Node.VarName = VarInfo.VarName;
			Node.VarIndex = VarInfo.VarUniqueIndex;
			Node.IsCaptured = VarInfo.IsCaptured(NameSpace);
			Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, VarInfo.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
			this.TypedNodeIf(Node, ZenSystem.VoidType, Node.ValueNode);
		}
	}

	@Override public void VisitGetIndexNode(ZenGetIndexNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.IndexNode = this.TypeCheck(Node.IndexNode, NameSpace, this.GetIndexType(NameSpace, Node.RecvNode.Type), ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, this.GetElementType(NameSpace, Node.RecvNode.Type), Node.RecvNode, Node.IndexNode);
	}

	@Override public void VisitSetIndexNode(ZenSetIndexNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.IndexNode = this.TypeCheck(Node.IndexNode, NameSpace, this.GetIndexType(NameSpace, Node.RecvNode.Type), ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, this.GetElementType(NameSpace, Node.RecvNode.Type), ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf3(Node, ZenSystem.VoidType,  Node.RecvNode, Node.IndexNode, Node.ValueNode);
	}

	@Override public void VisitGroupNode(ZenGroupNode Node) {
		Node.RecvNode.Accept(this); // this is shortcut
		this.TypedNode(Node, Node.RecvNode.Type);
	}

	@Override public void VisitGetterNode(ZenGetterNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		@Var ZenType ContextType = this.GetContextType();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		ZenType FieldType = this.GetFieldType(NameSpace, Node.RecvNode.Type, Node.NativeName);
		this.TypedCastNode(Node, ContextType, Node.RecvNode.Type);
		this.InferFieldType(NameSpace, Node.RecvNode.Type, Node.NativeName, ContextType, Node.SourceToken);
		this.TypedNodeIf(Node, FieldType, Node.RecvNode);
	}

	@Override public void VisitSetterNode(ZenSetterNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		@Var ZenType FieldType = this.GetSetterType(NameSpace, Node.RecvNode.Type, Node.NativeName);
		if(FieldType.IsVoidType()) {
			this.CheckErrorNode(this.CreateReadOnlyErrorNode(Node, Node.RecvNode.Type, Node.NativeName));
			return;
		}
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, FieldType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(FieldType.IsVarType()) {
			this.InferFieldType(NameSpace, Node.RecvNode.Type, Node.NativeName, Node.ValueNode.Type, Node.SourceToken);
		}
		this.TypedNodeIf2(Node, ZenSystem.VoidType, Node.RecvNode, Node.ValueNode);
	}

	private ZenType GuessFuncTypeFromContext(ZenType ContextType, @Nullable ZenType RecvType, ArrayList<ZenNode> ParamList) {
		if(ContextType.IsVarType() || ContextType.IsVoidType()) {
			return ZenSystem.VarType;
		}
		if(RecvType != null && RecvType.IsVarType()) {
			return ZenSystem.VarType;
		}
		ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
		TypeList.add(ContextType.GetRealType());
		if(RecvType != null) {
			TypeList.add(RecvType.GetRealType());
		}
		@Var int i = 0;
		while(i < ParamList.size()) {
			ZenNode SubNode = ParamList.get(i);
			ZenType ParamType = SubNode.Type.GetRealType();
			if(ParamType.IsVarType() || ParamType.IsVoidType()) {
				return ZenSystem.VarType;
			}
			TypeList.add(ParamType);
			i = i + 1;
		}
		return ZenSystem.LookupFuncType(TypeList);
	}

	@Override public void VisitMethodCallNode(ZenMethodCallNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		@Var ZenType ContextType = this.GetContextType();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypeCheckNodeList(NameSpace, Node.ParamList);
		if(this.IsVisitable()) {
			@Var ZenType FuncType = this.GuessFuncTypeFromContext(ContextType, Node.RecvNode.Type, Node.ParamList);
			FuncType = this.GuessMethodFuncType(NameSpace, Node.MethodName, Node, FuncType);
			@Var ZenType ReturnType = this.TypeCheckFuncParam(NameSpace, Node.ParamList, FuncType, 2);
			this.TypedCastNode(Node, ContextType, ReturnType);
		}
	}

	@Override public void VisitFuncCallNode(ZenFuncCallNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		@Var ZenType ContextType = this.GetContextType();
		this.TypeCheckNodeList(NameSpace, Node.ParamList);
		@Var ZenType FuncType = this.GuessFuncTypeFromContext(ContextType, null, Node.ParamList);
		@Var boolean IsFuncObject = true;
		if(Node.FuncNode.IsUntyped() && Node.FuncNode instanceof ZenGetLocalNode) {
			@Var ZenGetLocalNode VarNode = (ZenGetLocalNode)Node.FuncNode;
			@Var ZenVariable VarInfo = this.GetLocalVariable(NameSpace, VarNode.VarName);
			if(VarInfo == null) {
				FuncType = this.GuessFuncType2(NameSpace, VarNode.VarName, Node, FuncType);
				if(FuncType instanceof ZenFuncType && FuncType.HasCallableSignature()) {
					Node.FuncNode.Type = FuncType;
					VarNode.VarName = FuncType.StringfySignature(VarNode.VarName);
				}
				IsFuncObject = false;
			}
		}
		if(IsFuncObject) {
			Node.FuncNode = this.TypeCheck(Node.FuncNode, NameSpace, FuncType, ZenTypeChecker.NoCheckPolicy);
			FuncType = Node.FuncNode.Type;
		}
		if(!FuncType.IsFuncType() && !FuncType.IsVarType()) {
			this.CheckErrorNode(new ZenErrorNode(Node.SourceToken, "not function: given = " + FuncType));
		}
		else {
			ZenType ReturnType = this.TypeCheckFuncParam(NameSpace, Node.ParamList, FuncType, 1);
			this.TypedCastNode(Node, ContextType, ReturnType);
		}
	}

	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, Node.RecvNode.Type);
	}

	@Override public void VisitNotNode(ZenNotNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf(Node, ZenSystem.BooleanType, Node.RecvNode);
	}

	@Override public void VisitCastNode(ZenCastNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.ExprNode = this.TypeCheck(Node.ExprNode, NameSpace, Node.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, Node.Type);
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf(Node, ZenSystem.BooleanType, Node.LeftNode);
	}

	private ZenType GetBinaryLeftType(String Op, ZenType ContextType) {
		if(LibZen.EqualsString(Op, "|") || LibZen.EqualsString(Op, "&") || LibZen.EqualsString(Op, "<<") || LibZen.EqualsString(Op, ">>") || LibZen.EqualsString(Op,  "^")) {
			return ZenSystem.IntType;
		}
		if(LibZen.EqualsString(Op, "*") || LibZen.EqualsString(Op, "-") || LibZen.EqualsString(Op, "/") || LibZen.EqualsString(Op, "%")) {
			if(ContextType.IsNumberType()) {
				return ContextType;
			}
		}
		return ZenSystem.VarType;
	}

	private ZenType GetBinaryRightType(String Op, ZenType ContextType) {
		if(LibZen.EqualsString(Op, "|") || LibZen.EqualsString(Op, "&") || LibZen.EqualsString(Op, "<<") || LibZen.EqualsString(Op, ">>") || LibZen.EqualsString(Op,  "^")) {
			return ZenSystem.IntType;
		}
		if(LibZen.EqualsString(Op, "*") || LibZen.EqualsString(Op, "-") || LibZen.EqualsString(Op, "/") || LibZen.EqualsString(Op, "%")) {
			if(ContextType.IsNumberType()) {
				return ContextType;
			}
		}
		return ZenSystem.VarType;
	}

	private void UnifyBinaryNodeType(ZenNameSpace NameSpace, ZenBinaryNode Node, ZenType Type, int Policy) {
		if(Node.LeftNode.Type.Equals(Type)) {
			Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, Type, Policy);
			return;
		}
		if(Node.RightNode.Type.Equals(Type)) {
			Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, Type,  Policy);
		}
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenType ContextType = this.GetContextType();
		ZenType LeftType = this.GetBinaryLeftType(Node.SourceToken.ParsedText, ContextType);
		ZenType RightType = this.GetBinaryRightType(Node.SourceToken.ParsedText, ContextType);
		//System.err.println("debug left=" + LeftType + ", right=" + RightType);
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, LeftType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, RightType, ZenTypeChecker.DefaultTypeCheckPolicy);
		//System.err.println("debug left=" + Node.LeftNode.Type + ", right=" + Node.RightNode.Type);
		if(!Node.LeftNode.Type.Equals(Node.RightNode.Type)) {
			if(Node.SourceToken.EqualsText("+")) {
				this.UnifyBinaryNodeType(NameSpace, Node, ZenSystem.StringType, ZenTypeChecker.EnforceCoercion);
			}
			this.UnifyBinaryNodeType(NameSpace, Node, ZenSystem.FloatType, ZenTypeChecker.DefaultTypeCheckPolicy);
			Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, Node.RightNode.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		this.TypedNodeIf(Node, Node.LeftNode.Type, Node.RightNode);
	}

	@Override public void VisitComparatorNode(ZenComparatorNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, Node.LeftNode.Type, ZenTypeChecker.NoCheckPolicy);
		this.UnifyBinaryNodeType(NameSpace, Node, ZenSystem.FloatType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, Node.LeftNode.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, ZenSystem.BooleanType, Node.LeftNode, Node.RightNode);
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, ZenSystem.BooleanType, Node.LeftNode, Node.RightNode);
	}

	@Override public void VisitOrNode(ZenOrNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, ZenSystem.BooleanType, Node.LeftNode, Node.RightNode);
	}

	@Override public void VisitBlockNode(ZenBlockNode Node) {
		if(this.IsVisitable()) {
			int i = 0;
			ZenType BlockType = ZenSystem.VoidType;
			while(i < Node.StmtList.size()) {
				ZenNode SubNode = Node.StmtList.get(i).GetStatementNode();  // without annotation
				SubNode = this.TypeCheck(SubNode, Node.NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
				Node.StmtList.set(i, SubNode);
				if(SubNode.Type.IsVarType()) {
					BlockType = ZenSystem.VarType;
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

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		if(!(Node.DeclType instanceof ZenVarType)) {
			Node.DeclType = this.NewVarType(Node.DeclType, Node.NativeName, Node.SourceToken);
			this.SetLocalVariable(Node.NameSpace, Node.DeclType, Node.NativeName, Node.SourceToken);
		}
		Node.InitNode = this.TypeCheck(Node.InitNode, NameSpace, Node.DeclType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.VisitBlockNode(Node);
		this.TypedNodeIf2(Node, ZenSystem.VoidType, Node.InitNode, Node);
	}

	@Override public void VisitIfNode(ZenIfNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.CondNode = this.TypeCheck(Node.CondNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.ThenNode = this.TypeCheck(Node.ThenNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(Node.ElseNode != null) {
			Node.ElseNode = this.TypeCheck(Node.ElseNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
			this.TypedNodeIf3(Node, ZenSystem.VoidType, Node.CondNode, Node.ThenNode, Node.ElseNode);
		}
		else {
			this.TypedNodeIf2(Node, ZenSystem.VoidType, Node.CondNode, Node.ThenNode);
		}
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenType ReturnType = this.GetReturnType();
		if(ReturnType.IsVoidType() && Node.ValueNode != null) {
			Node.ValueNode = null;
		}
		else if(!ReturnType.IsVoidType() && Node.ValueNode == null) {
			Node.ValueNode = this.CreateDefaultValueNode(ReturnType);
		}
		if(Node.ValueNode != null) {
			Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ReturnType, ZenTypeChecker.DefaultTypeCheckPolicy);
			if(ReturnType.IsVarType()) {
				this.InferReturnType(Node.ValueNode.Type);
			}
			this.TypedNodeIf(Node, ZenSystem.VoidType, Node.ValueNode);
		}
		else {
			this.TypedNode(Node, ZenSystem.VoidType);
		}
	}

	@Override public void VisitWhileNode(ZenWhileNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.CondNode = this.TypeCheck(Node.CondNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.BodyNode = this.TypeCheck(Node.BodyNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf2(Node, ZenSystem.VoidType, Node.CondNode, Node.BodyNode);
	}

	@Override public void VisitBreakNode(ZenBreakNode Node) {
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitThrowNode(ZenThrowNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNodeIf(Node, ZenSystem.VoidType, Node.ValueNode);
	}

	@Override
	public void VisitTryNode(ZenTryNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.TryNode = this.TypeCheck(Node.TryNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(Node.CatchNode != null) {
			Node.CatchNode = this.TypeCheck(Node.CatchNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		if(Node.FinallyNode != null) {
			Node.FinallyNode = this.TypeCheck(Node.FinallyNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitCatchNode(ZenCatchNode Node) {
		// TODO Auto-generated method stub
		this.Todo(Node);
	}

	@Override public void VisitParamNode(ZenParamNode Node) {
		// TODO Auto-generated method stub
		this.Todo(Node);
	}

	@Override public void VisitFunctionLiteralNode(ZenFunctionLiteralNode Node) {
		ZenType ContextType = this.GetContextType();
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenFuncType FuncType = this.LookupTypeFunc(Node.ReturnType, Node.ArgumentList);
		if(ContextType instanceof ZenFuncType) {
			FuncType = this.CheckFuncType(FuncType, ContextType);
			if(FuncType == null) {
				//TODO Error;
			}
		}
		ZenFunc DefinedFunc = this.DefineFunc(NameSpace, null, FuncType, Node.SourceToken);
		this.PushFuncScope(NameSpace, DefinedFunc, Node.ArgumentList);
		Node.BodyNode = this.TypeCheck(Node.BodyNode, NameSpace, ZenSystem.VoidType, 0);
		this.TypedNode(Node, this.PopFuncScope(NameSpace, Node, Node.SourceToken).GetReturnType());
	}

	@Override public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		@Var ZenFuncType FuncType = this.LookupTypeFunc(Node.ReturnType, Node.ArgumentList);
		if(Node.BodyNode != null) {
			@Var ZenFunc DefinedFunc = this.DefineFunc(NameSpace, Node.FuncName, FuncType, Node.SourceToken);
			this.PushFuncScope(Node.NameSpace, DefinedFunc, Node.ArgumentList);
			Node.BodyNode = this.TypeCheckFuncBody(Node.NameSpace, Node.BodyNode);
			FuncType = this.PopFuncScope(NameSpace, Node, Node.SourceToken);
			if(FuncType.HasCallableSignature()) {
				Node.FuncName = FuncType.StringfySignature(Node.FuncName);
			}
		}
		else {
			//TODO;
		}
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitErrorNode(ZenErrorNode Node) {
		this.CheckErrorNode(Node);
	}
}

