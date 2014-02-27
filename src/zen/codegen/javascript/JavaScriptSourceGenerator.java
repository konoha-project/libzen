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

import zen.ast.ZBinaryNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGlobalNameNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZLetNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.ast.ZParamNode;
import zen.ast.ZStupidCastErrorNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.lang.ZenTypeSafer;
import zen.parser.ZLogger;
import zen.parser.ZSourceEngine;
import zen.parser.ZSourceGenerator;
import zen.type.ZGenericType;
import zen.type.ZType;

public class JavaScriptSourceGenerator extends ZSourceGenerator {
	private static boolean UseExtend;

	public JavaScriptSourceGenerator() {
		super("js", "JavaScript-1.4");
		this.TopType = "Object";
		this.SetNativeType(ZType.BooleanType, "Boolean");
		this.SetNativeType(ZType.IntType, "Number");
		this.SetNativeType(ZType.FloatType, "Number");
		this.SetNativeType(ZType.StringType, "String");


		this.SetReservedName("this", "self");

		this.SetMacro("assert", "console.assert($[0], $[1])", ZType.VoidType, ZType.BooleanType, ZType.StringType);
		this.SetMacro("print", "console.log($[0])", ZType.VoidType, ZType.StringType);
		this.SetMacro("println", "console.log($[0])", ZType.VoidType, ZType.StringType);

		this.SetMacro("size", "($[0]).length", ZType.IntType, ZGenericType._ArrayType);
		this.SetMacro("add", "$[0].push($[1])", ZType.VoidType, ZGenericType._ArrayType, ZType.VarType);

		this.SetConverterMacro("$[0]", ZType.FloatType, ZType.IntType);
		this.SetConverterMacro("($[0] | 0)", ZType.IntType, ZType.FloatType);
		this.SetConverterMacro("($[0]).toString()", ZType.StringType, ZType.IntType);
		this.SetConverterMacro("($[0]).toString()", ZType.StringType, ZType.FloatType);
		JavaScriptSourceGenerator.UseExtend = false;
	}

	@Override public ZSourceEngine GetEngine() {
		return new ZSourceEngine(new ZenTypeSafer(this), this);
	}

	@Override public void VisitGlobalNameNode(ZGlobalNameNode Node) {
		//		if(Node.IsUntyped()) {
		//			this.CurrentBuilder.Append(Node.GlobalName);
		//		}
		if(Node.IsStaticFuncName) {
			if(Node.GlobalName.startsWith("LibZen")){
				this.CurrentBuilder.Append(Node.GlobalName.replace('_', '.'));
			}else{
				this.CurrentBuilder.Append(Node.Type.StringfySignature(Node.GlobalName));
			}
		}else{
			this.CurrentBuilder.Append(Node.GlobalName);
		}
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.GenerateCode(null, Node.AST[ZCastNode._Expr]);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.CurrentBuilder.Append("(");
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.Append(").constructor.name == (");
		this.GenerateTypeName(Node.TargetType);
		this.CurrentBuilder.Append(").name");
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("throw ");
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateCode(null, Node.AST[ZThrowNode._Expr]);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(null, Node.AST[ZTryNode._Try]);
		this.GenerateCode(null, Node.AST[ZTryNode._Catch]);
		if (Node.AST[ZTryNode._Finally] != null) {
			this.CurrentBuilder.Append("finally");
			this.GenerateCode(null, Node.AST[ZTryNode._Finally]);
		}
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("catch");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.GenerateCode(null, Node.AST[ZCatchNode._Block]);
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.AppendToken("var");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(this.SafeName(Node.NativeName, Node.VarIndex));
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node);
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(this.SafeName(Node.Name, Node.ParamIndex));
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(!Node.Type.IsVoidType()) {
			if(Node.FuncName == null) {
				Node.FuncName = "f";
			}
			@Var String FuncName = Node.FuncName + this.GetUniqueNumber();
			this.CurrentBuilder.Append("(function ");
			this.CurrentBuilder.Append(FuncName);
			this.VisitListNode("(", Node, ")");
			this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
			this.CurrentBuilder.Append(")");
		}
		else {
			this.CurrentBuilder.Append("var ");
			this.CurrentBuilder.Append(Node.GetSignature(this));
			this.CurrentBuilder.Append(" = (function ");
			this.VisitListNode("(", Node, ")");
			this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
			this.CurrentBuilder.Append(");");
			@Var ZNode FirstParamNode = Node.AST[1/*first param*/];
			if(Node.AST.length > 1 && FirstParamNode instanceof ZParamNode) {
				if(!(FirstParamNode.Type instanceof ZGenericType)){
					this.CurrentBuilder.AppendLineFeed();
					this.CurrentBuilder.Append(Node.AST[1/*first param*/].Type.ShortName); //FIXME must use typing in param
					this.CurrentBuilder.Append(".prototype.");
					this.CurrentBuilder.Append(Node.FuncName);
					this.CurrentBuilder.Append(" = ");
					this.CurrentBuilder.Append(Node.GetSignature(this));
					this.CurrentBuilder.Append(this.SemiColon);
				}
			}
		}
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		@Var ZType ParamType = Node.Type.GetParamType(0);
		this.CurrentBuilder.Append("LibZen.NewMap(");
		this.CurrentBuilder.Append(String.valueOf(Node.GetListSize()));
		if(Node.GetListSize() > 0) {
			this.CurrentBuilder.Append(this.Camma);
		}
		this.VisitListNode("", Node, ")");
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		this.CurrentBuilder.Append("var");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.GlobalName);
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.Append(this.SemiColon);
		this.CurrentBuilder.AppendLineFeed();
	}

	private void GenerateExtendCode(ZClassNode Node) {
		this.CurrentBuilder.Append("var __extends = this.__extends || function (d, b) {");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("function __() { this.constructor = d; }");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("__.prototype = b.prototype;");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("d.prototype = new __();");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append("};");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.UnIndent();
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
		if(Node.SuperType != null && !JavaScriptSourceGenerator.UseExtend) {
			JavaScriptSourceGenerator.UseExtend = true;
			this.GenerateExtendCode(Node);
		}
		this.CurrentBuilder.Append("var ");
		this.CurrentBuilder.Append(Node.ClassName);
		this.CurrentBuilder.Append(" = ");
		this.CurrentBuilder.Append("(function(");
		if(Node.SuperType != null) {
			this.CurrentBuilder.Append("_super) {");
			this.CurrentBuilder.Indent();
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("__extends(");
			this.CurrentBuilder.Append(Node.ClassName);
			this.CurrentBuilder.Append(this.Camma);
			this.CurrentBuilder.Append("_super)");
			this.CurrentBuilder.Append(this.SemiColon);
		} else {
			this.CurrentBuilder.Append(") {");
			this.CurrentBuilder.Indent();
		}
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("function");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.ClassName);
		this.CurrentBuilder.Append("(){");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Indent();
		if(Node.SuperType != null) {
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("_super.call(this)");
			this.CurrentBuilder.Append(this.SemiColon);
			this.CurrentBuilder.AppendLineFeed();
		}

		@Var int i = 0;
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			@Var ZNode ValueNode = FieldNode.AST[ZFieldNode._InitValue];
			if(!(ValueNode instanceof ZNullNode)) {
				this.CurrentBuilder.AppendIndent();
				this.CurrentBuilder.Append("this.");
				this.CurrentBuilder.Append(FieldNode.FieldName);
				this.CurrentBuilder.Append(" = ");

				this.GenerateCode(null, FieldNode.AST[ZFieldNode._InitValue]);
				this.CurrentBuilder.Append(this.SemiColon);
				this.CurrentBuilder.AppendLineFeed();
			}
			i = i + 1;
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("}");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("return");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.ClassName);
		this.CurrentBuilder.Append(this.SemiColon);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append("})(");
		if(Node.SuperType != null) {
			this.CurrentBuilder.Append(Node.SuperType.ShortName);
		}
		this.CurrentBuilder.Append(")");
		this.CurrentBuilder.Append(this.SemiColon);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		if(Node instanceof ZStupidCastErrorNode) {
			@Var ZStupidCastErrorNode ErrorNode = (ZStupidCastErrorNode)Node;
			this.GenerateCode(null, ErrorNode.ErrorNode);
		}
		else {
			@Var String Message = ZLogger._LogError(Node.SourceToken, Node.ErrorMessage);
			this.CurrentBuilder.AppendWhiteSpace();
			this.CurrentBuilder.Append("LibZen.ThrowError(");
			this.CurrentBuilder.Append(LibZen._QuoteString(Message));
			this.CurrentBuilder.Append(")");
		}
	}

	//	@Override public ZFuncType GetConstructorFuncType(ZType ClassType, ZListNode List) {
	//		return ZType.VarType;
	//	}
	//
	//	@Override public ZFuncType GetMethodFuncType(ZType RecvType, String MethodName, ZListNode List) {
	//		return ZType.VarType;
	//	}

}
