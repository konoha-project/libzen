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
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZLetNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZNewArrayNode;
import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarNode;
import zen.deps.LibZen;
import zen.deps.Var;
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

	//@Override
	//public void VisitBlockNode(ZBlockNode Node) {
	//this.CurrentBuilder.Append("{");
	//this.CurrentBuilder.Indent();
	//throw new RuntimeException("FIXME: Don't use for statement");
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
	//}

	@Override public void VisitCastNode(ZCastNode Node) {
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
		this.CurrentBuilder.Append("throw");
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateCode(null, Node.AST[ZThrowNode._Expr]);
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(null, Node.AST[ZTryNode._Try]);
		//for (ZenNode CatchNode : Node.CatchList) {
		//	this.GenerateCode(CatchNode);
		//}
		this.GenerateCode(null, Node.AST[ZTryNode._Catch]);
		if (Node.AST[ZTryNode._Finally] != null) {
			this.CurrentBuilder.Append("finally");
			this.GenerateCode(null, Node.AST[ZTryNode._Finally]);
		}
	}

	@Override
	public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("catch ");
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.GenerateCode(null, Node.AST[ZCatchNode._Block]);
	}

	@Override
	public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.AppendToken("var");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node);
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		//ZReturnNode ReturnNode = Node.AST[ZFunctionNode._Block].ToReturnNode();
		//this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append("function");
		this.CurrentBuilder.AppendWhiteSpace();
		if(Node.FuncName != null) {
			this.CurrentBuilder.Append(Node.FuncName);
		}
		this.VisitListNode("(", Node, ")");
		this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
		//		if(ReturnNode != null && ReturnNode.AST[ZReturnNode._Expr] != null) {
		//			this.CurrentBuilder.Append("{ return ");
		//			this.GenerateCode(ReturnNode.AST[ZReturnNode._Expr]);
		//			this.CurrentBuilder.Append("; }");
		//		}
		//		else {
		//			this.GenerateCode(Node.AST[ZFunctionNode._Block]);
		//		}
		//this.CurrentBuilder.Append(")");
	}


	//	@Override
	//	public void VisitFuncDeclNode(ZFunctionNode/ Node) {
	//		this.CurrentBuilder.Append("function ");
	//		this.CurrentBuilder.Append(Node.FuncName);
	//		this.VisitListNode("(", Node.ParamList, ")");
	//		this.GenerateCode(Node.BodyNode);
	//	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		// TODO
		//		this.CurrentBuilder.Append("let");
		//		this.CurrentBuilder.AppendWhiteSpace();
		//		this.CurrentBuilder.Append(Node.GlobalName);
		//		this.CurrentBuilder.AppendToken("=");
		//		this.GenerateCode(Node.AST[ZLetNode._InitValue]);
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		/* var ClassName = (function(_super) {
		 *  __extends(ClassName, _super);
		 * 	function ClassName(params) {
		 * 		_super.call(this, params);
		 * 	}
		 * 	ClassName.prototype.MethodName = function(){ };
		 * 	return ClassName;
		 * })(_super);
		 */
		this.CurrentBuilder.Append("var");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.ClassName);
		this.CurrentBuilder.Append("=");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append("(function(");
		if(Node.SuperType != null) {
			this.CurrentBuilder.Append("_super) {");
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("__extends(");
			this.CurrentBuilder.Append(Node.ClassName);
			this.CurrentBuilder.Append(")");
		} else {
			this.CurrentBuilder.Append(") {");
			this.CurrentBuilder.AppendIndent();
		}
		@Var int i = 0;
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("this.");
			this.CurrentBuilder.Append(FieldNode.FieldName);
			this.CurrentBuilder.AppendWhiteSpace();
			this.CurrentBuilder.AppendToken("=");
			this.CurrentBuilder.AppendWhiteSpace();
			this.GenerateCode(null, FieldNode.AST[ZFieldNode._InitValue]);
			this.CurrentBuilder.Append(this.SemiColon);
			i = i + 1;
		}
		//this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("}");

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("return");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.ClassName);
		this.CurrentBuilder.Append(this.SemiColon);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append("})(");
		if(Node.SuperType != null) {
			this.CurrentBuilder.Append(Node.SuperType.ShortName);
		}
		this.CurrentBuilder.Append(")");
		this.CurrentBuilder.Append(this.SemiColon);
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.Logger.ReportError(Node.SourceToken, Node.ErrorMessage);
		this.CurrentBuilder.Append("new");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append("Error");
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(LibZen._QuoteString(Node.ErrorMessage));
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitExtendedNode(ZNode Node) {
		//TODO
	}


}