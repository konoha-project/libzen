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
import zen.deps.Var;
import zen.parser.ZGenerator;
import zen.parser.ZLogger;
import zen.parser.ZVisitor;
import zen.type.ZTypeChecker;

public class ZenScriptEngine extends ZVisitor {
	private boolean IsVisitable = true;
	protected Object EvaledValue = null;
	protected ZGenerator Generator;
	private final ArrayList<ZNode> LazyNodeList = new ArrayList<ZNode>();
	public ZLogger Logger;

	public ZenScriptEngine(ZTypeChecker TypeChecker, ZGenerator Generator) {
		this.Generator = Generator;
		this.Logger = Generator.Logger;
	}

	public final Object Exec(ZNode Node, boolean IsInteractive) {
		this.EnableVisitor();
		return this.Eval(Node);
	}

	public final void LazyNode(ZNode Node) {
		this.LazyNodeList.add(Node);
	}

	public final void Sync() {
		@Var int i = 0;
		while(i < this.LazyNodeList.size()) {
			@Var ZNode Node = this.LazyNodeList.get(i);
			this.Generator.DoCodeGeneration(null, Node);
		}
	}

	@Override public boolean IsVisitable() {
		return this.IsVisitable;
	}

	@Override public void EnableVisitor() {
		this.EvaledValue = null;
		this.IsVisitable = true;
	}

	@Override public void StopVisitor() {
		this.EvaledValue = null;
		this.IsVisitable = false;
	}

	//	protected void FoundError(Object ErrorInfo) {
	//		this.EvaledValue = ErrorInfo;
	//		this.IsVisitable = false;
	//	}

	protected void Unsupported(ZNode Node, String Message) {
		this.Logger.ReportError(Node.SourceToken, "unsupported " + Message + " (at the top level)");
		this.EvaledValue = null; //"unsupported node: " + Node.getClass().getSimpleName();
		this.IsVisitable = false;
	}

	protected final Object Eval(ZNode Node) {
		if(this.IsVisitable()) {
			Node.Accept(this);
		}
		return this.EvaledValue;
	}

	@Override public void VisitEmptyNode(ZEmptyNode Node) {
		this.StopVisitor();
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.EvaledValue = null;
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.EvaledValue = Node.BooleanValue;
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.EvaledValue = Node.IntValue;
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.EvaledValue = Node.FloatValue;
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.EvaledValue = Node.StringValue;
	}

	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
		this.EvaledValue = Node.ConstValue;
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.Unsupported(Node, "array literal");
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.Unsupported(Node, "map literal");
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		this.Unsupported(Node, "new");
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.Unsupported(Node, "new");
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {
		this.Unsupported(Node, "symbol " + Node.ReferenceName);
	}

	@Override public void VisitGetLocalNode(ZGetLocalNode Node) {
		this.Unsupported(Node, "local variable");
	}

	@Override public void VisitSetLocalNode(ZSetLocalNode Node) {
		this.Unsupported(Node, "local variable");
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.EvaledValue = this.Eval(Node.RecvNode);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.Unsupported(Node, "field accessor");
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		this.Unsupported(Node, "field accessor");
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.Unsupported(Node, "indexer");
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.Unsupported(Node, "indexer");
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.Unsupported(Node, "method call");
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.Unsupported(Node, "function call");
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.Unsupported(Node, "unary " + Node.SourceToken.ParsedText);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		this.Unsupported(Node, "unary " + Node.SourceToken.ParsedText);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		if(Node.Type.IsVoidType()) {
			this.EvaledValue = this.Eval(Node.ExprNode);
			Node.Type = Node.ExprNode.Type;
		}
		else {
			this.Unsupported(Node, "cast");
		}
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.Unsupported(Node, "<:");
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		this.Unsupported(Node, "binary " + Node.SourceToken.ParsedText);
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.Unsupported(Node, "binary " + Node.SourceToken.ParsedText);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		@Var Object BooleanValue = this.Eval(Node.LeftNode);
		if(BooleanValue instanceof Boolean) {
			if((Boolean)BooleanValue) {
				this.EvaledValue = this.Eval(Node.RightNode);
			}
			else {
				this.EvaledValue = false;
			}
		}
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		@Var Object BooleanValue = this.Eval(Node.LeftNode);
		if(BooleanValue instanceof Boolean) {
			if(!(Boolean)BooleanValue) {
				this.EvaledValue = this.Eval(Node.RightNode);
			}
			else {
				this.EvaledValue = true;
			}
		}
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		@Var int i = 1;
		while(i < Node.StmtList.size() && this.IsVisitable()) {
			ZNode StmtNode = Node.StmtList.get(i).GetStatementNode();
			this.Eval(StmtNode);
			if(StmtNode.IsBreakingBlock()) {
				break;
			}
		}
		this.EvaledValue = null;
	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		this.Unsupported(Node, "variable declaration");
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Object BooleanValue = this.Eval(Node.CondNode);
		if(BooleanValue instanceof Boolean) {
			if((Boolean)BooleanValue) {
				this.Eval(Node.ThenNode);
			}
			else if(Node.ElseNode != null) {
				this.Eval(Node.ThenNode);
			}
		}
		this.EvaledValue = null;
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.Unsupported(Node, "return");
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.Unsupported(Node, "while");
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.Unsupported(Node, "break");
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.Unsupported(Node, "throw");
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.Unsupported(Node, "try");
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		this.Unsupported(Node, "catch");
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		this.Unsupported(Node, "function");
	}

	@Override public void VisitFuncDeclNode(ZFuncDeclNode Node) {
		this.Unsupported(Node, "Function");
	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
		this.Unsupported(Node, "function");
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.Logger.ReportError(Node.SourceToken, Node.ErrorMessage);
		//this.FoundError(Node.ErrorMessage);
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		// TODO Auto-generated method stub

	}


}
