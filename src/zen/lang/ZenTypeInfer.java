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
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenUnaryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast.ZenWhileNode;
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
		if(Type.IsVarType()) {
			Type = ZenSystem.AnyType;  // TODO:
		}
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

	@Override public void VisitGetLocalNode(ZenGetLocalNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		@Var ZenType VarType = ZenSystem.VarType;
		@Var ZenVariable VarInfo = this.GetLocalVariable(NameSpace, Node.VarName);
		if(VarInfo != null) {
			Node.VarName = VarInfo.VarName;
			Node.VarIndex = VarInfo.VarUniqueIndex;
			VarType = VarInfo.VarType;
			Node.IsCaptured = VarInfo.IsCaptured(NameSpace);
		}
		@Var Object Value = NameSpace.GetSymbol(Node.VarName);
		if(Value != null) {
			@Var ZenNode NewNode = ZenNodeUtils.CreateConstNode(Node.SourceToken, Value);
			NewNode = this.TypeCheck(NewNode, NameSpace, ZenSystem.VarType, 0);
			this.TypedNode(NewNode, NewNode.Type);
		}
		this.TypedNode(Node, VarType);
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
			this.TypeSync(VarInfo.VarType, Node.ValueNode);
			this.TypedNode(Node, ZenSystem.VoidType);
		}
	}

	@Override public void VisitGetIndexNode(ZenGetIndexNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.IndexNode = this.TypeCheck(Node.IndexNode, NameSpace, this.GetIndexType(NameSpace, Node.RecvNode.Type), ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, this.GetElementType(NameSpace, Node.RecvNode.Type));
	}

	@Override public void VisitSetIndexNode(ZenSetIndexNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.IndexNode = this.TypeCheck(Node.IndexNode, NameSpace, this.GetIndexType(NameSpace, Node.RecvNode.Type), ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, this.GetElementType(NameSpace, Node.RecvNode.Type), ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitGroupNode(ZenGroupNode Node) {
		Node.Accept(this); // this is shortcut
	}

	@Override public void VisitGetterNode(ZenGetterNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		ZenType FieldType = this.GetFieldType(NameSpace, Node.RecvNode.Type, Node.NativeName);
		this.TypedNode(Node, FieldType);
	}

	@Override public void VisitSetterNode(ZenSetterNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		ZenType FieldType = this.GetSetterType(NameSpace, Node.RecvNode.Type, Node.NativeName);
		if(FieldType.IsVoidType()) {
			this.CheckErrorNode(this.CreateReadOnlyErrorNode(Node, Node.RecvNode.Type, Node.NativeName));
		}
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, FieldType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.InferFieldType(NameSpace, Node.RecvNode.Type, Node.NativeName, Node.ValueNode.Type);
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitMethodCallNode(ZenMethodCallNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(this.IsVisitable()) {
			ZenType FuncType = this.GuessMethodFuncType(NameSpace, Node.RecvNode, Node.MethodName, Node);
			ZenType ReturnType = this.TypeCheckFuncParam(NameSpace, Node.ParamList, FuncType, 2);
			this.TypedNode(Node, ReturnType);
		}
	}

	@Override public void VisitFuncCallNode(ZenFuncCallNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		if(Node.FuncNode instanceof ZenGetLocalNode) {
			@Var ZenGetLocalNode VarNode = (ZenGetLocalNode)Node.FuncNode;
			@Var ZenVariable VarInfo = this.GetLocalVariable(NameSpace, VarNode.VarName);
			if(VarInfo != null) {
				VarNode.Type = VarInfo.VarType;
			}
			else {
				VarNode.Type = this.GuessFuncType(NameSpace, VarNode.VarName, Node);
			}
		}
		else {
			Node.FuncNode = this.TypeCheck(Node.FuncNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		ZenType FuncType = Node.FuncNode.Type;
		ZenType ReturnType = this.TypeCheckFuncParam(NameSpace, Node.ParamList, FuncType, 1);
		this.TypedNode(Node, ReturnType);
	}

	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, Node.Type);
	}

	@Override public void VisitNotNode(ZenNotNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitCastNode(ZenCastNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.ExprNode = this.TypeCheck(Node.ExprNode, NameSpace, Node.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, Node.Type);
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(Node.LeftNode.IsErrorNode()) {
			this.Todo(Node.LeftNode);
		}
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	private ZenType UnifyType(ZenNameSpace NameSpace, ZenBinaryNode Node, ZenType Type) {
		if(Node.LeftNode.Type.Equals(Type)) {
			Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, Type, 0);
			return Type;
		}
		else if(Node.RightNode.Type.Equals(Type)) {
			Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, Type, 0);
			return Type;
		}
		return null;
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, Node.LeftNode.Type, ZenTypeChecker.NoCheckPolicy);
		this.UnifyType(NameSpace, Node, ZenSystem.StringType);
		this.UnifyType(NameSpace, Node, ZenSystem.FloatType);
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, Node.RightNode.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, Node.LeftNode.Type);
	}

	@Override public void VisitComparatorNode(ZenComparatorNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, Node.LeftNode.Type, ZenTypeChecker.NoCheckPolicy);
		this.UnifyType(NameSpace, Node, ZenSystem.FloatType);
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitOrNode(ZenOrNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitBlockNode(ZenBlockNode Node) {
		if(this.IsVisitable()) {
			int i = 0;
			while(i < Node.StmtList.size()) {
				ZenNode SubNode = Node.StmtList.get(i);
				SubNode = this.TypeCheck(SubNode, Node.NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
				Node.StmtList.set(i, SubNode);
				if(SubNode.IsBreakingBlock()) {
					break;
				}
				i = i + 1;
			}
			this.EnableVisitor();
			this.TypedNode(Node, ZenSystem.VoidType);
		}
	}

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.DeclType = this.NewVarType(Node.DeclType, Node.NativeName, Node.SourceToken);
		Node.InitNode = this.TypeCheck(Node.InitNode, NameSpace, Node.DeclType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(this.IsVisitable()) {
			this.SetLocalVariable(NameSpace, Node.DeclType, Node.NativeName, Node.SourceToken);
			this.VisitBlockNode(Node);
		}
	}

	@Override public void VisitIfNode(ZenIfNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.CondNode = this.TypeCheck(Node.CondNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.ThenNode = this.TypeCheck(Node.ThenNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(Node.ElseNode != null) {
			Node.ElseNode = this.TypeCheck(Node.ElseNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenType ReturnType = this.GetReturnType();
		if(Node.ValueNode != null) {
			Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ReturnType, ZenTypeChecker.DefaultTypeCheckPolicy);
			if(Node.ValueNode.IsErrorNode()) {
				this.Todo(Node.ValueNode);
			}
		}
		if(ReturnType.IsVarType()) {
			if(Node.ValueNode == null) {
				this.InferReturnType(ZenSystem.VoidType);
			}
			else {
				this.InferReturnType(Node.ValueNode.Type);
			}
		}
		else if(ReturnType.IsVoidType()) {
			if(Node.ValueNode != null) {
				Node.ValueNode = null;
			}
		}
		else {
			if(Node.ValueNode == null) {
				Node.ValueNode = this.CreateDefaultValueNode(ReturnType);
			}
		}
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitWhileNode(ZenWhileNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.CondNode = this.TypeCheck(Node.CondNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.BodyNode = this.TypeCheck(Node.BodyNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitBreakNode(ZenBreakNode Node) {
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override
	public void VisitThrowNode(ZenThrowNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.VoidType);
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

	@Override
	public void VisitCatchNode(ZenCatchNode Node) {
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
		ZenFunc DefinedFunc = this.DefineFunc(NameSpace, "", FuncType, Node.SourceToken);
		this.PushFuncScope(NameSpace, DefinedFunc, Node.ArgumentList);
		Node.BodyNode = this.TypeCheck(Node.BodyNode, NameSpace, ZenSystem.VoidType, 0);
		this.TypedNode(Node, this.PopFuncScope(NameSpace, Node));
	}

	@Override public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
		@Var ZenNameSpace NameSpace = this.GetNameSpace();
		@Var ZenFuncType FuncType = this.LookupTypeFunc(Node.ReturnType, Node.ArgumentList);
		this.CheckErrorNode(this.CanDefineFunc(NameSpace, Node.FuncName, FuncType, Node));
		if(this.IsVisitable()) {
			ZenFunc DefiningFunc = this.DefineFunc(NameSpace, Node.FuncName, FuncType, Node.SourceToken);
			if(!DefiningFunc.IsLazyDef() && Node.BodyNode != null) {
				this.PushFuncScope(Node.NameSpace, DefiningFunc, Node.ArgumentList);
				Node.BodyNode = this.TypeCheckFuncBody(Node.NameSpace, Node.BodyNode);
				this.PopFuncScope(Node.NameSpace, Node);
			}
		}
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitErrorNode(ZenErrorNode Node) {
		this.CheckErrorNode(Node);
	}
}

