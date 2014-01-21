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

import java.util.ArrayList;

import zen.ast.ZenBlockNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionNode;
import zen.ast.ZenInstanceOfNode;
import zen.ast.ZenNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenVarDeclNode;
import zen.lang.ZSystem;
import zen.parser.ZenSourceGenerator;
//endif VAJA

//Zen Generator should be written in each language.

public class PythonSourceGenerator extends ZenSourceGenerator {

	public PythonSourceGenerator/* constructor */() {
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
		this.SetNativeType(ZSystem.BooleanType, "bool");
		this.SetNativeType(ZSystem.IntType, "int");
		this.SetNativeType(ZSystem.FloatType, "float");
		this.SetNativeType(ZSystem.StringType, "str");
	}

	@Override public void VisitStmtList(ArrayList<ZenNode> StmtList) {
		int i = 0;
		while (i < StmtList.size()) {
			ZenNode SubNode = StmtList.get(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.GenerateCode(SubNode);
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
	public void VisitBlockNode(ZenBlockNode Node) {
		this.CurrentBuilder.Append(":");
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node.StmtList);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("#");
	}

	@Override public void VisitCastNode(ZenCastNode Node) {
		// this.CurrentBuilder.Append("(");
		// this.VisitType(Node.Type);
		// this.CurrentBuilder.Append(") ");
		this.CurrentBuilder.AppendBlockComment("as " + this.GetNativeType(Node.Type));
		this.GenerateCode(Node.ExprNode);
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		this.CurrentBuilder.Append("isinstance(");
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.Append(this.Camma);
		this.VisitType(Node.RightNode.Type);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitThrowNode(ZenThrowNode Node) {
		this.CurrentBuilder.Append("raise ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitTryNode(ZenTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(Node.TryNode);
		if (Node.CatchNode != null) {
			this.GenerateCode(Node.CatchNode);
		}
		if (Node.FinallyNode != null) {
			this.CurrentBuilder.Append("finally");
			this.GenerateCode(Node.FinallyNode);
		}
	}

	@Override public void VisitCatchNode(ZenCatchNode Node) {
		this.CurrentBuilder.Append("except:");
		//		this.VisitType(Node.ExceptionType);
		//		this.CurrentBuilder.AppendToken("as");
		//		this.CurrentBuilder.Append(Node.ExceptionName);
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitVarDeclNode(ZenVarDeclNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.InitNode);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();

		// copied from VisitBlock(ZenBlockNode)
		this.VisitStmtList(Node.StmtList);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
	}

	@Override
	public void VisitParamNode(ZenParamNode Node) {
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
	public void VisitFunctionNode(ZenFunctionNode Node) {
		ZenReturnNode ReturnNode = Node.BodyNode.ToReturnNode();
		if(ReturnNode != null && ReturnNode.ValueNode != null) {
			this.CurrentBuilder.Append("lambda");
			this.VisitParamList(" ", Node.ArgumentList, ": ");
			this.GenerateCode(ReturnNode.ValueNode);
		}
		else {
			this.CurrentBuilder.Append("def");
			this.CurrentBuilder.AppendToken("lambda");
			this.VisitParamList("(", Node.ArgumentList, ")");
			this.GenerateCode(Node.BodyNode);
		}
	}

	@Override
	public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
		this.CurrentBuilder.Append("def ");
		this.CurrentBuilder.Append(Node.FuncName);
		this.VisitParamList("(", Node.ArgumentList, ")");
		if (Node.BodyNode == null) {
			this.CurrentBuilder.Append(": pass");
		} else {
			this.GenerateCode(Node.BodyNode);
		}
	}

}