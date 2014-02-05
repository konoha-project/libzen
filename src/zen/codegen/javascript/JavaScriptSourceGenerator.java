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
package zen.codegen.javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarDeclNode;
import zen.parser.ZSourceGenerator;
import zen.type.ZType;

public class JavaScriptSourceGenerator extends ZSourceGenerator {

	private final ScriptEngineManager EngineManager;
	private final ScriptEngine Engine;

	public JavaScriptSourceGenerator() {
		super("JavaScript", "1.8");
		this.LineFeed = "\n";
		this.Tab = "\t";
		this.LineComment = "//"; // if not, set null
		this.BeginComment = null; //"'''";
		this.EndComment = null; //"'''";
		this.Camma = ", ";
		this.SemiColon = ";";

		this.TrueLiteral = "true";
		this.FalseLiteral = "false";
		this.NullLiteral = "null";
		this.TopType = "Object";
		this.SetNativeType(ZType.BooleanType, "Boolean");
		this.SetNativeType(ZType.IntType, "Number");
		this.SetNativeType(ZType.FloatType, "Number");
		this.SetNativeType(ZType.StringType, "String");

		this.EngineManager = new ScriptEngineManager();
		this.Engine = this.EngineManager.getEngineByName("js");
	}

	//	@Override
	//	public Object EvalTopLevelNode(ZNode Node) {
	//		String Code = this.CurrentBuilder.toString() + ";";
	//		System.out.println(Code);
	//		this.CurrentBuilder.Clear();
	//		try {
	//			return ((Compilable)this.Engine).compile(Code).eval();
	//		} catch (ScriptException ex) {
	//			ex.printStackTrace();
	//		}
	//		return null;
	//	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Indent();
		throw new RuntimeException("FIXME: Don't use for statement");
		//		for (ZNode SubNode : Node.StmtList) {
		//			this.CurrentBuilder.AppendLineFeed();
		//			this.CurrentBuilder.AppendIndent();
		//			this.GenerateCode(SubNode);
		//			this.CurrentBuilder.Append(this.SemiColon);
		//		}
		//		this.CurrentBuilder.UnIndent();
		//		this.CurrentBuilder.AppendLineFeed();
		//		this.CurrentBuilder.AppendIndent();
		//		this.CurrentBuilder.Append("}");
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.GenerateCode(Node.AST[ZCastNode.Expr]);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.CurrentBuilder.Append("isinstance(");
		this.GenerateCode(Node.AST[ZBinaryNode.Left]);
		this.CurrentBuilder.Append(this.Camma);
		this.VisitType(Node.AST[ZBinaryNode.Right].Type);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("throw ");
		this.GenerateCode(Node.AST[ZThrowNode.Expr]);
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(Node.AST[ZTryNode.Try]);
		//for (ZenNode CatchNode : Node.CatchList) {
		//	this.GenerateCode(CatchNode);
		//}
		this.GenerateCode(Node.AST[ZTryNode.Catch]);
		if (Node.AST[ZTryNode.Finally] != null) {
			this.CurrentBuilder.Append("finally");
			this.GenerateCode(Node.AST[ZTryNode.Finally]);
		}
	}

	@Override
	public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("catch ");
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.GenerateCode(Node.AST[ZCatchNode.Block]);
	}

	@Override
	public void VisitVarDeclNode(ZVarDeclNode Node) {
		this.CurrentBuilder.AppendToken("var ");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZVarDeclNode.InitValue]);
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		ZReturnNode ReturnNode = Node.AST[ZFunctionNode.Block].ToReturnNode();
		this.CurrentBuilder.Append("(function");
		if(Node.FuncName != null) {
			this.CurrentBuilder.Append(Node.GlobalName);
		}
		this.VisitListNode("(", Node, ")");
		if(ReturnNode != null && ReturnNode.AST[ZReturnNode.Expr] != null) {
			this.CurrentBuilder.Append("{ return ");
			this.GenerateCode(ReturnNode.AST[ZReturnNode.Expr]);
			this.CurrentBuilder.Append("; }");
		}
		else {
			this.GenerateCode(Node.AST[ZFunctionNode.Block]);
		}
		this.CurrentBuilder.Append(")");
	}

	//	@Override
	//	public void VisitFuncDeclNode(ZFunctionNode/*Decl*/ Node) {
	//		this.CurrentBuilder.Append("function ");
	//		this.CurrentBuilder.Append(Node.FuncName);
	//		this.VisitListNode("(", Node.ParamList, ")");
	//		this.GenerateCode(Node.BodyNode);
	//	}

}