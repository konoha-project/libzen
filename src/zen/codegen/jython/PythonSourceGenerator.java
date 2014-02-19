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

//ifdef JAVA
package zen.codegen.jython;

import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarNode;
import zen.parser.ZSourceGenerator;
import zen.type.ZType;

//Zen Generator should be written in each language.

public class PythonSourceGenerator extends ZSourceGenerator {

	public PythonSourceGenerator() {
		super("Python", "2.0");
		this.LineFeed = "\n";
		this.Tab = "\t";
		this.LineComment = "#"; // if not, set null
		this.BeginComment = null; //"'''";
		this.EndComment = null; //"'''";
		this.Camma = ", ";
		this.SemiColon = "";

		this.TrueLiteral = "True";
		this.FalseLiteral = "False";
		this.NullLiteral = "None";

		this.AndOperator = "and";
		this.OrOperator = "or";
		this.NotOperator = "not ";

		this.TopType = "object";
		this.SetNativeType(ZType.BooleanType, "bool");
		this.SetNativeType(ZType.IntType, "int");
		this.SetNativeType(ZType.FloatType, "float");
		this.SetNativeType(ZType.StringType, "str");
	}

	@Override public void VisitStmtList(ZBlockNode BlockNode) {
		int i = 0;
		while (i < BlockNode.GetListSize()) {
			ZNode SubNode = BlockNode.GetListAt(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.GenerateCode(null, SubNode);
			this.CurrentBuilder.Append(this.SemiColon);
			i = i + 1;
		}
		if (i == 0) {
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("pass");
		}
	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.Append(":");
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("#");
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		// this.CurrentBuilder.Append("(");
		// this.VisitType(Node.Type);
		// this.CurrentBuilder.Append(") ");
		this.CurrentBuilder.AppendBlockComment("as " + this.GetNativeType(Node.Type));
		this.GenerateCode(null, Node.AST[ZCastNode._Expr]);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.CurrentBuilder.Append("isinstance(");
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.Append(this.Camma);
		this.GenerateTypeName(Node.AST[ZBinaryNode._Right].Type);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("raise ");
		this.GenerateCode(null, Node.AST[ZThrowNode._Expr]);
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(null, Node.AST[ZTryNode._Try]);
		if (Node.AST[ZTryNode._Catch] != null) {
			this.GenerateCode(null, Node.AST[ZTryNode._Catch]);
		}
		if (Node.AST[ZTryNode._Finally] != null) {
			this.CurrentBuilder.Append("finally");
			this.GenerateCode(null, Node.AST[ZTryNode._Finally]);
		}
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("except:");
		//		this.VisitType(Node.ExceptionType);
		//		this.CurrentBuilder.AppendToken("as");
		//		this.CurrentBuilder.Append(Node.ExceptionName);
		this.GenerateCode(null, Node.AST[ZCatchNode._Block]);
	}

	@Override
	public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();

		// copied from VisitBlock(ZenBlockNode)
		this.VisitStmtList(Node);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
	}

	@Override
	public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
	}

	/**
	>>> def f(x):
		...   def g(y):
		...     return x + y
		...   return g
		...
		>>> f(1)(3)
		4
	 **/
	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		ZReturnNode ReturnNode = Node.AST[ZFunctionNode._Block].ToReturnNode();
		if(ReturnNode != null && ReturnNode.AST[ZReturnNode._Expr] != null) {
			this.CurrentBuilder.Append("lambda");
			this.VisitListNode(" ", Node, ": ");
			this.GenerateCode(null, ReturnNode.AST[ZReturnNode._Expr]);
		}
		else {
			this.CurrentBuilder.Append("def");
			this.CurrentBuilder.AppendToken("lambda");
			this.VisitListNode("(", Node, ")");
			this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
		}
	}

	//	public void VisitFuncDeclNode(ZFunctionNode Node) {
	//		this.CurrentBuilder.Append("def ");
	//		this.CurrentBuilder.Append(Node.FuncName);
	//		this.VisitListNode("(", Node, ")");
	//		if (Node.AST[ZFunctionNode._Block] == null) {
	//			this.CurrentBuilder.Append(": pass");
	//		} else {
	//			this.GenerateCode(Node.AST[ZFunctionNode._Block]);
	//		}
	//	}

}