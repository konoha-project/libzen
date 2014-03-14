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
import zen.ast.ZComparatorNode;
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
import zen.parser.ZNodeUtils;
import zen.parser.ZSourceBuilder;
import zen.parser.ZSourceGenerator;
import zen.type.ZType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;

public class HaskellSourceGenerator extends ZSourceGenerator {
	@Field public ArrayList <String> Variables;
	private static int IndentLevel = 0;

	public HaskellSourceGenerator() {
		super("hs", "Haskell-7.6.3");
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

		this.ImportLibrary("Data.IORef");
	}

	@Override protected void GenerateImportLibrary(String LibName) {
		this.HeaderBuilder.AppendNewLine("import ", LibName, this.SemiColon);
	}

	private void Indent(ZSourceBuilder builder) {
		IndentLevel = IndentLevel + 1;
		builder.Indent();
	}

	private void UnIndent(ZSourceBuilder builder) {
		IndentLevel = IndentLevel - 1;
		builder.UnIndent();
	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		@Var int count = 0;

		this.Indent(this.CurrentBuilder);
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("do ");

		@Var int limit = Node.GetListSize();
		for (@Var int i = 0; i < limit; i++) {
			ZNode SubNode = Node.GetListAt(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();

			// Last Statement in function definition
			if (IndentLevel == 1 && i == limit - 1) {
				this.CurrentBuilder.Append("return (");
			}

			this.GenerateCode(null, SubNode);
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
		this.GenerateCode(null, Node.ExprNode());
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		// See: http://d.hatena.ne.jp/kazu-yamamoto/20090819/1250660658
		this.GenerateCode(null, Node.TryBlockNode());
		this.CurrentBuilder.Append(" `catch` ");
		if (Node.CatchBlockNode() != null) {
			this.GenerateCode(null, Node.CatchBlockNode());
		}
		if (Node.FinallyBlockNode() != null) {
			this.GenerateCode(null, Node.FinallyBlockNode());
		}
	}


	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.Append(Node.GetName() + " <- readIORef ");
		this.CurrentBuilder.Append(Node.GetName() + "_ref");
		this.GenerateCode(null, Node.InitValueNode());
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(Node.GetName());
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		this.Variables = new ArrayList<String>();
		if(Node.FuncName().equals("main")){
			this.CurrentBuilder.Append("main");
		}else{
			this.CurrentBuilder.Append(Node.GetSignature());
		}
		this.VisitListNode(" ", Node, " ", " ");

		this.CurrentBuilder.Append(" = do");
		this.CurrentBuilder.AppendLineFeed();

		this.Indent(this.CurrentBuilder);

		for (int i = 0; i < Node.GetListSize(); i++) {
			ZParamNode Param = Node.GetParamNode(i);
			this.Variables.add(Param.GetName());

			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append(Param.GetName()
					+ "_ref <- newIORef "
					+ Param.GetName());
			this.CurrentBuilder.AppendLineFeed();
		}

		for (int i = 0; i < Node.GetListSize(); i++) {
			ZParamNode node1 = Node.GetParamNode(i);

			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append(node1.GetName()
					+ " <- readIORef "
					+ node1.GetName() + "_ref");
			this.CurrentBuilder.AppendLineFeed();
		}
		this.UnIndent(this.CurrentBuilder);

		ZReturnNode ReturnNode = ZNodeUtils._CheckIfSingleReturnNode(Node);
		if(ReturnNode != null && ReturnNode.HasReturnExpr()) {
			this.Indent(this.CurrentBuilder);

			String Indentation = LibZen._JoinStrings("\t", IndentLevel);
			this.CurrentBuilder.Append(Indentation);
			this.CurrentBuilder.Append("return ");
			this.GenerateCode(null, ReturnNode.ExprNode());
			this.UnIndent(this.CurrentBuilder);
		} else {
			this.GenerateCode(null, Node.BlockNode());
		}
	}

	@Override
	public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.Append(Node.GetName());
	}

	@Override
	public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append("writeIORef ");
		this.CurrentBuilder.Append(Node.GetName() + "_ref ");
		this.GenerateCode(null, Node.ExprNode());
		this.CurrentBuilder.AppendLineFeed();

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append(Node.GetName());
		this.CurrentBuilder.Append(" <- readIORef ");
		this.CurrentBuilder.Append(Node.GetName() + "_ref");
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override
	public void VisitReturnNode(ZReturnNode Node) {
		if (Node.HasReturnExpr()) {
			this.GenerateCode(null, Node.ExprNode());
		}
	}

	private String ZenOpToHaskellOp(String OpCode) {
		if(OpCode.equals("/")) {
			return "`div`";
		}
		if(OpCode.equals("%")) {
			return "`mod`";
		}
		if(OpCode.equals("!=")) {
			return "/=";
		}
		return OpCode;
	}

	@Override
	public void VisitBinaryNode(ZBinaryNode Node) {
		String Op = this.ZenOpToHaskellOp(Node.SourceToken.GetText());

		this.CurrentBuilder.Append("(");
		Node.LeftNode().Accept(this);
		this.CurrentBuilder.Append(" " + Op + " ");
		Node.RightNode().Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		String Op = this.ZenOpToHaskellOp(Node.SourceToken.GetText());

		this.CurrentBuilder.Append("(");
		Node.LeftNode().Accept(this);
		this.CurrentBuilder.Append(" " + Op + " ");
		Node.RightNode().Accept(this);
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
		Node.CondNode().Accept(this);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("then");
		this.CurrentBuilder.AppendLineFeed();

		// XXX Is this correct node type ?
		ZNode LoopNode = new ZGetNameNode(Node, null, "__loop");
		Node.BlockNode().SetNode(ZNode._AppendIndex, LoopNode);
		Node.BlockNode().Accept(this);

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
		this.GenerateCode(null, Node.FunctionNode());
		this.VisitListNode(" ", Node, " ", " ");
	}
}
