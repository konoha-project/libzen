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

import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.deps.LibZen;
import zen.parser.ZSourceBuilder;
import zen.parser.ZSourceGenerator;
import zen.type.ZType;

public class HaskellSourceGenerator extends ZSourceGenerator {
	public ArrayList <String> Variables;
	private static int IndentLevel = 0;

	public HaskellSourceGenerator() {
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
		this.SetNativeType(ZType.BooleanType, "Bool");
		this.SetNativeType(ZType.IntType, "Int");
		this.SetNativeType(ZType.FloatType, "Float");
		this.SetNativeType(ZType.StringType, "String");
	}

	private void Indent(ZSourceBuilder builder) {
		IndentLevel = IndentLevel + 1;
		builder.Indent();
	}

	private void UnIndent(ZSourceBuilder builder) {
		IndentLevel--;
		builder.UnIndent();
	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		int count = 0;

		this.Indent(this.CurrentBuilder);
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("do ");

		int limit = Node.GetListSize();
		for (int i = 0; i < limit; i++) {
			ZNode SubNode = Node.GetListAt(i);
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
	public void VisitCastNode(ZCastNode Node) {
	}

	@Override
	public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("raise ");
		this.GenerateCode(Node.AST[ZThrowNode._Expr]);
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		// See: http://d.hatena.ne.jp/kazu-yamamoto/20090819/1250660658
		this.GenerateCode(Node.AST[ZTryNode._Try]);
		this.CurrentBuilder.Append(" `catch` ");
		if (Node.AST[ZTryNode._Catch] != null) {
			this.GenerateCode(Node.AST[ZTryNode._Catch]);
		}
		if (Node.AST[ZTryNode._Finally] != null) {
			this.GenerateCode(Node.AST[ZTryNode._Finally]);
		}
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		this.GenerateCode(Node.AST[ZCatchNode._Block]);
	}

	@Override
	public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.Append(Node.NativeName + " <- readIORef ");
		this.CurrentBuilder.Append(Node.NativeName + "_ref");
		this.GenerateCode(Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		ZReturnNode ReturnNode = Node.AST[ZFunctionNode._Block].ToReturnNode();
		if(ReturnNode != null && ReturnNode.AST[ZReturnNode._Expr] != null) {
			this.CurrentBuilder.Append("\\");
			this.VisitListNode(" ", Node, " ", " ");
			this.CurrentBuilder.Append("");
			this.GenerateCode(ReturnNode.AST[ZReturnNode._Expr]);
		}
		else {
			this.CurrentBuilder.Append("\\");
			this.VisitListNode(" ", Node, " ", " -> ");
			this.GenerateCode(Node.AST[ZFunctionNode._Block]);
		}
	}

	//	@Override
	//	public void VisitFuncDeclNode(ZFunctionNode/*Decl*/ Node) {
	//		this.Variables = new ArrayList<String>();
	//
	//		this.CurrentBuilder.Append(Node.FuncName);
	//		this.VisitListNode(" ", Node.ParamList, " = do");
	//		this.CurrentBuilder.AppendLineFeed();
	//
	//		this.Indent(this.CurrentBuilder);
	//		// Argument variable declarations as IORef
	//		for (ZNode node : Node.ParamList) {
	//			ZParamNode node1 = (ZParamNode)node;
	//
	//			this.Variables.add(node1.Name);
	//
	//			this.CurrentBuilder.AppendIndent();
	//			this.CurrentBuilder.Append(node1.Name + "_ref <- newIORef " + node1.Name);
	//			this.CurrentBuilder.AppendLineFeed();
	//		}
	//
	//		for (ZNode node : Node.ParamList) {
	//			ZParamNode node1 = (ZParamNode)node;
	//			this.CurrentBuilder.AppendIndent();
	//			this.CurrentBuilder.Append(node1.Name + " <- readIORef " + node1.Name + "_ref");
	//			this.CurrentBuilder.AppendLineFeed();
	//		}
	//		this.UnIndent(this.CurrentBuilder);
	//
	//		if (Node.BodyNode == null) {
	//			// XXX Can we define empty function in Haskell ?
	//		} else {
	//			this.GenerateCode(Node.BodyNode);
	//		}
	//	}

	@Override
	public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
	}

	@Override
	public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append("writeIORef ");
		this.CurrentBuilder.Append(Node.VarName + "_ref ");
		this.GenerateCode(Node.AST[ZSetNameNode._Expr]);
		this.CurrentBuilder.AppendLineFeed();

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append(Node.VarName);
		this.CurrentBuilder.Append(" <- readIORef ");
		this.CurrentBuilder.Append(Node.VarName + "_ref");
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override
	public void VisitReturnNode(ZReturnNode Node) {
		this.GenerateCode(Node.AST[ZReturnNode._Expr]);
	}

	private String ZenOpToHaskellOp(String OpCode) {
		if(LibZen._EqualsString(OpCode, "/")) {
			return "`div`";
		}
		if(LibZen._EqualsString(OpCode, "%")) {
			return "`mod`";
		}
		return OpCode;
	}

	@Override
	public void VisitBinaryNode(ZBinaryNode Node) {
		String Op = this.ZenOpToHaskellOp(Node.SourceToken.GetText());

		this.CurrentBuilder.Append("(");
		Node.AST[ZBinaryNode._Left].Accept(this);
		this.CurrentBuilder.Append(" " + Op + " ");
		Node.AST[ZBinaryNode._Right].Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitWhileNode(ZWhileNode Node) {
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
		Node.AST[ZWhileNode._Cond].Accept(this);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("then");
		this.CurrentBuilder.AppendLineFeed();

		// XXX Is this correct node type ?
		ZNode LoopNode = new ZGetNameNode(Node, null, "__loop");
		Node.AST[ZWhileNode._Block].Set(ZNode._AppendIndex, LoopNode);
		Node.AST[ZWhileNode._Block].Accept(this);

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

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.GenerateCode(Node.AST[ZFuncCallNode._Func]);
		this.VisitListNode(" ", Node, " ");
	}
}