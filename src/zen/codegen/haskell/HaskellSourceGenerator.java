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
package zen.codegen.haskell;

import java.util.ArrayList;

import zen.ast.ZenBinaryNode;
import zen.ast.ZenBlockNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
import zen.ast.ZenFuncCallNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionLiteralNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenSetLocalNode;
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast.ZenWhileNode;
import zen.deps.Constructor;
import zen.deps.LibZen;
import zen.lang.ZenSystem;
import zen.parser.ZenSourceBuilder;
import zen.parser.ZenSourceGenerator;

public class HaskellSourceGenerator extends ZenSourceGenerator {
	public ArrayList <String> Variables;
	private static int IndentLevel = 0;

	@Constructor public HaskellSourceGenerator() {
		super("haskell", "7.6.3");
		this.LineFeed = "\n";
		this.Tab = "\t";
		this.LineComment = "#"; // if not, set null
		this.BeginComment = "{-";
		this.EndComment = "-}";
		this.Camma = ",";
		this.SemiColon = "";

		this.TrueLiteral = "True";
		this.FalseLiteral = "False";
		this.NullLiteral = "None";

		this.AndOperator = "&&";
		this.OrOperator = "||";
		this.NotOperator = "not ";

		this.TopType = "object";
		this.SetNativeType(ZenSystem.BooleanType, "Bool");
		this.SetNativeType(ZenSystem.IntType, "Int");
		this.SetNativeType(ZenSystem.FloatType, "Float");
		this.SetNativeType(ZenSystem.StringType, "String");
	}

	private void Indent(ZenSourceBuilder builder) {
		IndentLevel = IndentLevel + 1;
		builder.Indent();
	}

	private void UnIndent(ZenSourceBuilder builder) {
		IndentLevel--;
		builder.UnIndent();
	}

	@Override
	public void VisitBlockNode(ZenBlockNode Node) {
		int count = 0;

		this.Indent(this.CurrentBuilder);
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("do ");

		int limit = Node.StmtList.size();
		for (int i = 0; i < limit; i++) {
			ZenNode SubNode = Node.StmtList.get(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();

			// Last Statement in function definition
			if (IndentLevel == 1 && i == limit - 1) {
				this.CurrentBuilder.Append("return (");
			}

			this.GenerateCode(SubNode);
			this.CurrentBuilder.Append(this.SemiColon);

			if (IndentLevel == 1 && i == limit - 1) {
				this.CurrentBuilder.Append(")");
			}

			count = count + 1;
		}
		if (count == 0) {
			this.CurrentBuilder.Append("return ()");
		}

		this.UnIndent(this.CurrentBuilder);
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override
	public void VisitCastNode(ZenCastNode Node) {
	}

	@Override
	public void VisitThrowNode(ZenThrowNode Node) {
		this.CurrentBuilder.Append("raise ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitTryNode(ZenTryNode Node) {
		// See: http://d.hatena.ne.jp/kazu-yamamoto/20090819/1250660658
		this.GenerateCode(Node.TryNode);
		this.CurrentBuilder.Append(" `catch` ");
		if (Node.CatchNode != null) {
			this.GenerateCode(Node.CatchNode);
		}
		if (Node.FinallyNode != null) {
			this.GenerateCode(Node.FinallyNode);
		}
	}

	@Override public void VisitCatchNode(ZenCatchNode Node) {
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitVarDeclNode(ZenVarDeclNode Node) {
		this.CurrentBuilder.Append(Node.NativeName + " <- readIORef ");
		this.CurrentBuilder.Append(Node.NativeName + "_ref");
		this.GenerateCode(Node.InitNode);
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override
	public void VisitParamNode(ZenParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
	}

	@Override
	public void VisitFunctionLiteralNode(ZenFunctionLiteralNode Node) {
		ZenReturnNode ReturnNode = Node.BodyNode.ToReturnNode();
		if(ReturnNode != null && ReturnNode.ValueNode != null) {
			this.CurrentBuilder.Append("\\");
			this.VisitParamList(" ", Node.ArgumentList, " ");
			this.CurrentBuilder.Append("");
			this.GenerateCode(ReturnNode.ValueNode);
		}
		else {
			this.CurrentBuilder.Append("\\");
			this.VisitParamList(" ", Node.ArgumentList, " -> ");
			this.GenerateCode(Node.BodyNode);
		}
	}

	@Override
	protected void VisitParamList(String OpenToken, ArrayList<ZenNode> ParamList, String CloseToken) {
		this.CurrentBuilder.Append(OpenToken);
		for (int i = 0; i < ParamList.size(); i++) {
			ZenNode ParamNode = ParamList.get(i);
			if (i > 0) {
				this.CurrentBuilder.Append(" ");
			}
			this.GenerateCode(ParamNode);
		}
		this.CurrentBuilder.Append(CloseToken);
	}

	@Override
	public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
		this.Variables = new ArrayList<String>();

		this.CurrentBuilder.Append(Node.FuncName);
		this.VisitParamList(" ", Node.ArgumentList, " = do");
		this.CurrentBuilder.AppendLineFeed();

		this.Indent(this.CurrentBuilder);
		// Argument variable declarations as IORef
		for (ZenNode node : Node.ArgumentList) {
			ZenParamNode node1 = (ZenParamNode)node;

			this.Variables.add(node1.Name);

			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append(node1.Name + "_ref <- newIORef " + node1.Name);
			this.CurrentBuilder.AppendLineFeed();
		}

		for (ZenNode node : Node.ArgumentList) {
			ZenParamNode node1 = (ZenParamNode)node;
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append(node1.Name + " <- readIORef " + node1.Name + "_ref");
			this.CurrentBuilder.AppendLineFeed();
		}
		this.UnIndent(this.CurrentBuilder);

		if (Node.BodyNode == null) {
			// XXX Can we define empty function in Haskell ?
		} else {
			this.GenerateCode(Node.BodyNode);
		}
	}

	@Override
	public void VisitGetLocalNode(ZenGetLocalNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
	}

	@Override
	public void VisitSetLocalNode(ZenSetLocalNode Node) {
		this.CurrentBuilder.Append("writeIORef ");
		this.CurrentBuilder.Append(Node.VarName + "_ref ");
		this.GenerateCode(Node.ValueNode);
		this.CurrentBuilder.AppendLineFeed();

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append(Node.VarName);
		this.CurrentBuilder.Append(" <- readIORef ");
		this.CurrentBuilder.Append(Node.VarName + "_ref");
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override
	public void VisitReturnNode(ZenReturnNode Node) {
		this.GenerateCode(Node.ValueNode);
	}

	private String ZenOpToHaskellOp(String OpCode) {
		if(LibZen.EqualsString(OpCode, "/")) {
			return "`div`";
		}
		if(LibZen.EqualsString(OpCode, "%")) {
			return "`mod`";
		}
		return OpCode;
	}

	@Override
	public void VisitBinaryNode(ZenBinaryNode Node) {
		String Op = this.ZenOpToHaskellOp(Node.SourceToken.ParsedText);

		this.CurrentBuilder.Append("(");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" " + Op + " ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitWhileNode(ZenWhileNode Node) {
		this.CurrentBuilder.Append("let __loop = do");
		this.CurrentBuilder.AppendLineFeed();

		this.Indent(this.CurrentBuilder);

		for (String var : this.Variables) {
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append(var + " <- ");
			this.CurrentBuilder.Append("readIORef " + var + "_ref");
			this.CurrentBuilder.AppendLineFeed();
		}

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("if ");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("then");
		this.CurrentBuilder.AppendLineFeed();

		// XXX Is this correct node type ?
		ZenNode LoopNode = new ZenGetLocalNode(null, "__loop");
		Node.BodyNode.Append(LoopNode);
		Node.BodyNode.Accept(this);

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("else");

		this.Indent(this.CurrentBuilder);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("return ()");
		this.CurrentBuilder.AppendLineFeed();
		this.UnIndent(this.CurrentBuilder);

		this.UnIndent(this.CurrentBuilder);

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("__loop");
		this.CurrentBuilder.AppendLineFeed();

		for (String var : this.Variables) {
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append(var + " <- ");
			this.CurrentBuilder.Append("readIORef " + var + "_ref");
			this.CurrentBuilder.AppendLineFeed();
		}
	}

	@Override
	public void VisitFuncCallNode(ZenFuncCallNode Node) {
		this.GenerateCode(Node.FuncNode);
		this.VisitParamList(" ", Node.ParamList, " ");
	}
}