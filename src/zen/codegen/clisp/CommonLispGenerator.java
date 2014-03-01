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
import zen.ast.ZErrorNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZIfNode;
import zen.ast.ZNode;
import zen.ast.ZOrNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.parser.ZSourceGenerator;
import zen.type.ZFuncType;
import zen.type.ZGenericType;
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

		this.SetMacro("assert", "assert $[0], $[1]", ZType.VoidType, ZType.BooleanType, ZType.StringType);
		this.SetMacro("print", "print $[0],", ZType.VoidType, ZType.StringType);
		this.SetMacro("println", "print $[0]", ZType.VoidType, ZType.StringType);

		// Converter
		this.SetConverterMacro("float($[0])", ZType.FloatType, ZType.IntType);
		this.SetConverterMacro("int($[0])", ZType.IntType, ZType.FloatType);
		this.SetConverterMacro("('true' if $[0] else 'false')", ZType.StringType, ZType.BooleanType);
		this.SetConverterMacro("str($[0])", ZType.StringType, ZType.IntType);
		this.SetConverterMacro("str($[0])", ZType.StringType, ZType.FloatType);

		// String
		this.SetMacro("size", "len($[0])", ZType.IntType, ZType.StringType);
		this.SetMacro("substring", "$[0][$[1]:]", ZType.StringType, ZType.StringType, ZType.IntType);
		this.SetMacro("substring", "$[0][$[1]:$[2]]", ZType.StringType, ZType.StringType, ZType.IntType, ZType.IntType);
		this.SetMacro("indexOf", "$[0].find($[1])", ZType.IntType, ZType.StringType, ZType.StringType);
		this.SetMacro("indexOf", "$[0].find($[1], $[2])", ZType.IntType, ZType.StringType, ZType.StringType, ZType.IntType);
		this.SetMacro("equals", "$[0] == $[1]", ZType.BooleanType, ZType.StringType, ZType.StringType);
		this.SetMacro("startsWith", "$[0].startswith($[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);
		this.SetMacro("endsWith", "$[0].endswith($[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);

		// Array
		this.SetMacro("size", "len($[0])", ZType.IntType, ZGenericType._ArrayType);
		this.SetMacro("clear", "LibZen_ArrayClear($[0], $[1])", ZType.VoidType, ZGenericType._ArrayType, ZType.IntType);
		this.SetMacro("add", "$[0].append($[1])", ZType.VoidType, ZGenericType._ArrayType, ZType.VarType);

	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append("(setq  " + this.SafeName(Node.VarName, Node.VarIndex));
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.AST[ZSetNameNode._Expr]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.AST[ZUnaryNode._Recv]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.CurrentBuilder.Append("(and ");
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		this.CurrentBuilder.Append("(or ");
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
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
		this.CurrentBuilder.Append("(while ");
		this.GenerateCode(null, Node.AST[ZWhileNode._Cond]);
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.AST[ZWhileNode._Block]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.Append("(let (", this.SafeName(Node.NativeName, Node.VarIndex) + ")");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeedIndent();
		this.CurrentBuilder.Append("(setf  ", this.SafeName(Node.NativeName, Node.VarIndex), " ");
		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.Append(")");
		this.VisitStmtList(Node);
		this.CurrentBuilder.Append(")");
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeedIndent();
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
		this.GenerateCode(null, Node.AST[ZIfNode._Cond]);
		this.CurrentBuilder.Append(" ");
		this.GenerateCode(null, Node.AST[ZIfNode._Then]);
		this.CurrentBuilder.Append(" ");
		if(Node.HasAst(ZIfNode._Else)) {
			this.GenerateCode(null, Node.AST[ZIfNode._Else]);
		}
		else {
			this.CurrentBuilder.Append("nil");
		}
		this.CurrentBuilder.Append(")");
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
			this.CurrentBuilder.Append("(return-from ", FuncNode.GetSignature(this), " ");
		}
		else {
			this.CurrentBuilder.Append("(return ");
		}
		if(Node.HasAst(ZReturnNode._Expr)) {
			this.GenerateCode(null, Node.AST[ZReturnNode._Expr]);
		}
		else {
			this.CurrentBuilder.Append("nil");
		}
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(this.SafeName(Node.Name, Node.ParamIndex));
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(!Node.Type.IsVoidType()) {
			this.CurrentBuilder.Append("`#(lambda ");
			this.VisitListNode("(", Node, ")");
			this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
			this.CurrentBuilder.Append(")");
		}
		else {
			@Var ZFuncType FuncType = Node.GetFuncType(null);
			this.CurrentBuilder.Append("(defun ");
			this.CurrentBuilder.Append(Node.GetSignature(this));
			this.VisitListNode(" (", Node, ")");
			this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
			this.CurrentBuilder.Append(")");
			if(Node.IsExport) {
				//				this.CurrentBuilder.Append(Node.FuncName, " = ", FuncType.StringfySignature(Node.FuncName));
				//				this.CurrentBuilder.AppendLineFeed();
				//				if(Node.FuncName.equals("main")) {
				//					this.HasMainFunction = true;
				//				}
			}
			if(this.IsMethod(Node.FuncName, FuncType)) {
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



}
