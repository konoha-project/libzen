// ***************************************************************************
// Copyright (c) 2013, JST/CREST DEOS project authors. All rights reserved.
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

package zen.codegen.clisp;

import zen.ast.ZAndNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGlobalNameNode;
import zen.ast.ZIfNode;
import zen.ast.ZNode;
import zen.ast.ZOrNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.parser.ZSourceGenerator;
import zen.type.ZFuncType;
import zen.parser.ZToken;
import zen.type.ZType;
import zen.util.Var;

public class CommonLispGenerator extends ZSourceGenerator {

	public CommonLispGenerator() {
		super("cl", "CommonLisp");

		this.LineComment = "#"; // if not, set null
		this.BeginComment = null; //"'''";
		this.EndComment = null; //"'''";
		this.Camma = " ";
		this.SemiColon = "";

		this.TrueLiteral = "t";
		this.FalseLiteral = "nil";
		this.NullLiteral = "nil";

		this.AndOperator = "and";
		this.OrOperator = "or";
		this.NotOperator = "not ";

		this.TopType = "object";
		this.SetNativeType(ZType.BooleanType, "bool");
		this.SetNativeType(ZType.IntType, "int");
		this.SetNativeType(ZType.FloatType, "float");
		this.SetNativeType(ZType.StringType, "str");

		// FIXME: lib/cl/common.zen
		//		this.SetMacro("assert", "assert $[0], $[1]", ZType.VoidType, ZType.BooleanType, ZType.StringType);
		//		this.SetMacro("print", "print $[0],", ZType.VoidType, ZType.StringType);
		//		this.SetMacro("println", "print $[0]", ZType.VoidType, ZType.StringType);
		//
		//		// Converter
		//		this.SetConverterMacro("float($[0])", ZType.FloatType, ZType.IntType);
		//		this.SetConverterMacro("int($[0])", ZType.IntType, ZType.FloatType);
		//		this.SetConverterMacro("('true' if $[0] else 'false')", ZType.StringType, ZType.BooleanType);
		//		this.SetConverterMacro("str($[0])", ZType.StringType, ZType.IntType);
		//		this.SetConverterMacro("str($[0])", ZType.StringType, ZType.FloatType);
		//
		//		// String
		//		this.SetMacro("size", "len($[0])", ZType.IntType, ZType.StringType);
		//		this.SetMacro("substring", "$[0][$[1]:]", ZType.StringType, ZType.StringType, ZType.IntType);
		//		this.SetMacro("substring", "$[0][$[1]:$[2]]", ZType.StringType, ZType.StringType, ZType.IntType, ZType.IntType);
		//		this.SetMacro("indexOf", "$[0].find($[1])", ZType.IntType, ZType.StringType, ZType.StringType);
		//		this.SetMacro("indexOf", "$[0].find($[1], $[2])", ZType.IntType, ZType.StringType, ZType.StringType, ZType.IntType);
		//		this.SetMacro("equals", "$[0] == $[1]", ZType.BooleanType, ZType.StringType, ZType.StringType);
		//		this.SetMacro("startsWith", "$[0].startswith($[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);
		//		this.SetMacro("endsWith", "$[0].endswith($[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);
		//
		//		// Array
		//		this.SetMacro("size", "len($[0])", ZType.IntType, ZGenericType._ArrayType);
		//		this.SetMacro("clear", "LibZen_ArrayClear($[0], $[1])", ZType.VoidType, ZGenericType._ArrayType, ZType.IntType);
		//		this.SetMacro("add", "$[0].append($[1])", ZType.VoidType, ZGenericType._ArrayType, ZType.VarType);

	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append("(setq  " + this.NameLocalVariable(Node.GetName(), Node.VarIndex));
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.ExprNode());
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.RecvNode());
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.RightNode());
		this.CurrentBuilder.Append(")");
	}

	private String GetBinaryOperator(ZToken Token) {
		if(Token.EqualsText("!=")) {
			return "/=";
		}
		return Token.GetText();
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(GetBinaryOperator(Node.SourceToken));
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.RightNode());
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.CurrentBuilder.Append("(and ");
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.RightNode());
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		this.CurrentBuilder.Append("(or ");
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.RightNode());
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.Append("(progn ");
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node);
		this.CurrentBuilder.Append(")");
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
	}

	//
	// Visitor API
	//
	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.CurrentBuilder.Append("(loop while ");
		this.GenerateCode(null, Node.CondNode());
		this.CurrentBuilder.AppendNewLine();
		this.CurrentBuilder.Append("do");
		this.CurrentBuilder.AppendNewLine();
		this.GenerateCode(null, Node.BlockNode());
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.Append("(let (", this.NameLocalVariable(Node.GetName(), Node.VarIndex) + ")");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendNewLine();
		this.CurrentBuilder.Append("(setf  ", this.NameLocalVariable(Node.GetName(), Node.VarIndex), " ");
		this.GenerateCode(null, Node.InitValueNode());
		this.CurrentBuilder.Append(")");
		this.VisitStmtList(Node);
		this.CurrentBuilder.Append(")");
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendNewLine();
	}

	//	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
	//		this.CurrentBuilder.Append("(if  ");
	//		Node.AST[ZIfNode.Cond].Accept(this);
	//		this.CurrentBuilder.Append(" ");
	//		Node.AST[ZIfNode.Then].Accept(this);
	//		this.CurrentBuilder.Append(" ");
	//		Node.AST[ZIfNode.Else].Accept(this);
	//		this.CurrentBuilder.Append(")");
	//	}

	@Override public void VisitIfNode(ZIfNode Node) {
		this.CurrentBuilder.Append("(if  ");
		this.GenerateCode(null, Node.CondNode());
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.ThenNode());
		this.CurrentBuilder.Append(" ");
		if(Node.HasElseNode()) {
			this.GenerateCode(null, Node.ElseNode());
		}
		else {
			this.CurrentBuilder.Append("nil");
		}
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		ZGlobalNameNode GNode = Node.FuncNameNode();
		if (GNode != null) {
			String FuncName = GNode.GlobalName;
			this.CurrentBuilder.Append("(");
			this.CurrentBuilder.Append(FuncName);
			this.VisitListNode(" ", Node, " ");
			this.CurrentBuilder.Append(")");
		} else { // lambda
		}
	}

	private ZFunctionNode LookupFunctionNode(ZNode Node) {
		while(Node != null) {
			if(Node instanceof ZFunctionNode) {
				return (ZFunctionNode)Node;
			}
			Node = Node.ParentNode;
		}
		return null;
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		@Var ZFunctionNode FuncNode = this.LookupFunctionNode(Node);
		if(FuncNode != null) {
			this.CurrentBuilder.Append("(return-from ", FuncNode.GetSignature(), " ");
		}
		else {
			this.CurrentBuilder.Append("(return ");
		}
		if(Node.HasReturnExpr()) {
			this.GenerateCode(null, Node.ExprNode());
		}
		else {
			this.CurrentBuilder.Append("nil");
		}
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.GetName(), Node.ParamIndex));
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(!Node.IsTopLevelDefineFunction()) {
			this.CurrentBuilder.Append("#'(lambda ");
			this.VisitListNode("(", Node, ")");
			this.GenerateCode(null, Node.BlockNode());
			this.CurrentBuilder.Append(")");
		}
		else {
			@Var ZFuncType FuncType = Node.GetFuncType();
			this.CurrentBuilder.Append("(defun ");
			this.CurrentBuilder.Append(Node.GetSignature());
			this.VisitListNode(" (", Node, ")");
			this.GenerateCode(null, Node.BlockNode());
			this.CurrentBuilder.Append(")");
			if(Node.IsExport) {
				//				this.CurrentBuilder.Append(Node.FuncName, " = ", FuncType.StringfySignature(Node.FuncName));
				//				this.CurrentBuilder.AppendLineFeed();
				//				if(Node.FuncName.equals("main")) {
				//					this.HasMainFunction = true;
				//				}
			}
			if(this.IsMethod(Node.FuncName(), FuncType)) {
				//				this.CurrentBuilder.Append(this.NameMethod(FuncType.GetRecvType(), Node.FuncName));
				//				this.CurrentBuilder.Append(" = ", FuncType.StringfySignature(Node.FuncName));
				//				this.CurrentBuilder.AppendLineFeed();
			}
		}
	}


	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.CurrentBuilder.Append("(error ");
		this.CurrentBuilder.Append(Node.ErrorMessage);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("(unwind-protect ");
		this.CurrentBuilder.Append("(handler-case ");
		this.GenerateCode(null, Node.TryBlockNode());
		if(Node.HasCatchBlockNode()) {
			@Var String VarName = this.NameUniqueSymbol("e");
			this.CurrentBuilder.AppendNewLine("(error (", VarName, ")");
			this.VisitStmtList(Node.CatchBlockNode());
			this.CurrentBuilder.AppendNewLine(")");
		}
		this.CurrentBuilder.Append(")");
		if(Node.HasFinallyBlockNode()) {
			this.GenerateCode(null, Node.FinallyBlockNode());
		}
		this.CurrentBuilder.Append(")");
	}
}
