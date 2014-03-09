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

import zen.ast.ZCastNode;
import zen.ast.ZClassNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGlobalNameNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZLetNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.ast.ZParamNode;
import zen.ast.ZStupidCastErrorNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarNode;
import zen.lang.zen.ZenTypeSafer;
import zen.parser.ZLogger;
import zen.parser.ZSourceEngine;
import zen.parser.ZSourceGenerator;
import zen.type.ZClassType;
import zen.type.ZGenericType;
import zen.type.ZType;
import zen.util.LibZen;
import zen.util.Var;

public class JavaScriptGenerator extends ZSourceGenerator {
	private static boolean UseExtend;

	public JavaScriptGenerator() {
		super("js", "JavaScript-1.4");
		this.TopType = "Object";
		this.SetNativeType(ZType.BooleanType, "Boolean");
		this.SetNativeType(ZType.IntType, "Number");
		this.SetNativeType(ZType.FloatType, "Number");
		this.SetNativeType(ZType.StringType, "String");
		this.SetNativeType(ZType.VarType, "Object");

		this.SetReservedName("this", "self");

		JavaScriptGenerator.UseExtend = false;
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

	@Override public String NameLocalVariable(String Name, int Index) {
		// FIXME: Because of some unknown reasons, original SafeName dosen't work well. I use SafeName instead of SafeName temporary.
		if(Index == 0) {
			@Var String SafeName = this.ReservedNameMap.GetOrNull(Name);
			if(SafeName == null) {
				SafeName = Name;
			}
			return SafeName;
		}
		return Name;
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.GenerateCode(null, Node.ExprNode());
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.CurrentBuilder.Append("(");
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.Append(").constructor.name == (");
		this.GenerateTypeName(Node.TargetType);
		this.CurrentBuilder.Append(").name");
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("throw ");
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateCode(null, Node.ExprNode());
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(null, Node.TryBlockNode());
		this.GenerateCode(null, Node.CatchBlockNode());
		if (Node.FinallyBlockNode() != null) {
			this.CurrentBuilder.Append("finally");
			this.GenerateCode(null, Node.FinallyBlockNode());
		}
	}

	//	@Override public void VisitCatchNode(ZCatchNode Node) {
	//		this.CurrentBuilder.Append("catch");
	//		this.CurrentBuilder.AppendWhiteSpace();
	//		this.CurrentBuilder.Append(Node.GivenName);
	//		this.GenerateCode(null, Node.AST[ZCatchNode._Block]);
	//	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.AppendToken("var");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.GetName(), Node.VarIndex));
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.InitValueNode());
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node);
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.GetName(), Node.ParamIndex));
	}

	private boolean IsUserDefinedType(ZType SelfType){
		return SelfType != ZType.BooleanType &&
				SelfType != ZType.IntType &&
				SelfType != ZType.FloatType &&
				SelfType != ZType.StringType &&
				SelfType != ZType.VoidType &&
				SelfType != ZType.TypeType &&
				//SelfType != ZType.VarType &&
				SelfType.GetBaseType() != ZGenericType._ArrayType &&
				SelfType.GetBaseType() != ZGenericType._MapType;
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		@Var boolean IsLambda = (Node.FuncName() == null);
		@Var boolean IsInstanceMethod = (!IsLambda && Node.AST.length > 1 && Node.AST[1/*first param*/] instanceof ZParamNode);
		@Var ZType SelfType = IsInstanceMethod ? Node.AST[1/*first param*/].Type : null;
		@Var boolean IsConstructor = IsInstanceMethod && SelfType.ShortName.equals(Node.FuncName());

		if(IsConstructor){
			@Var ZNode Block = Node.BlockNode();
			Block.AST[Block.AST.length - 1].AST[0] = Node.AST[1];
		}
		if(IsLambda) {
			this.CurrentBuilder.Append("(function");
		}else{
			this.CurrentBuilder.Append("function ");
			if(!Node.Type.IsVoidType()) {
				@Var String FuncName = Node.GetUniqueName(this);
				this.CurrentBuilder.Append(FuncName);
			}
			else {
				this.CurrentBuilder.Append(Node.GetSignature());
			}
		}
		this.VisitListNode("(", Node, ")");
		this.GenerateCode(null, Node.BlockNode());
		if(IsLambda) {
			this.CurrentBuilder.Append(")");
		}else{
			this.CurrentBuilder.Append(this.SemiColon);
			if(IsInstanceMethod) {
				if(this.IsUserDefinedType(SelfType) && !IsConstructor){
					this.CurrentBuilder.AppendLineFeed();
					this.CurrentBuilder.Append(SelfType.ShortName); //FIXME must use typing in param
					this.CurrentBuilder.Append(".prototype.");
					this.CurrentBuilder.Append(Node.FuncName());
					this.CurrentBuilder.Append("__ = ");
					this.CurrentBuilder.Append(Node.GetSignature());

					this.CurrentBuilder.AppendLineFeed();
					this.CurrentBuilder.Append(SelfType.ShortName); //FIXME must use typing in param
					this.CurrentBuilder.Append(".prototype.");
					this.CurrentBuilder.Append(Node.FuncName());
					this.CurrentBuilder.Append(" = (function(){ Array.prototype.unshift.call(arguments, this); return this.");
					this.CurrentBuilder.Append(Node.FuncName());
					this.CurrentBuilder.Append("__.apply(this, arguments); })");

					this.CurrentBuilder.Append(this.SemiColon);
					this.CurrentBuilder.AppendLineFeed();
					this.CurrentBuilder.Append("function ");
					this.CurrentBuilder.Append(SelfType.ShortName); //FIXME must use typing in param
					this.CurrentBuilder.Append("_");
					this.CurrentBuilder.Append(Node.FuncName());
					this.VisitListNode("(", Node, ")");
					this.CurrentBuilder.Append("{ return ");
					this.CurrentBuilder.Append(Node.GetSignature());
					this.VisitListNode("(", Node, "); ");
					this.CurrentBuilder.Append("}");
				}
			}
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendLineFeed();
		}
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		//this.GenerateCode(null, Node.FuncNameNode());
		@Var ZType FuncType = Node.GetFuncType();
		if(FuncType != null){
			@Var ZType RecvType = Node.GetFuncType().GetRecvType();
			if(this.IsUserDefinedType(RecvType) &&  !RecvType.ShortName.equals(Node.GetStaticFuncName())){
				this.CurrentBuilder.Append("(");
				this.GenerateCode(null, Node.FuncNameNode());
				if(Node.FuncNameNode() instanceof ZGetterNode){
					this.CurrentBuilder.Append("__ || ");
				}else{
					this.CurrentBuilder.Append(" || ");
				}
				this.CurrentBuilder.Append(RecvType.ShortName);
				this.CurrentBuilder.Append("_");
				this.CurrentBuilder.Append(Node.GetStaticFuncName());
				this.CurrentBuilder.Append(")");
			}else{
				this.GenerateCode(null, Node.FuncNameNode());
			}
		}else{
			this.GenerateCode(null, Node.FuncNameNode());
		}
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		// (recv.method || Type_method)(...)
		@Var ZNode RecvNode = Node.RecvNode();

		if(this.IsUserDefinedType(RecvNode.Type)){
			this.CurrentBuilder.Append("(");
			this.GenerateSurroundCode(RecvNode);
			this.CurrentBuilder.Append(".");
			this.CurrentBuilder.Append(Node.MethodName());
			this.CurrentBuilder.Append("__ || ");
			this.CurrentBuilder.Append(RecvNode.Type.ShortName);
			this.CurrentBuilder.Append("_");
			this.CurrentBuilder.Append(Node.MethodName());
			this.CurrentBuilder.Append(")");
		}else{
			this.GenerateSurroundCode(RecvNode);
			this.CurrentBuilder.Append(".");
			this.CurrentBuilder.Append(Node.MethodName());
		}
		//this.GenerateSurroundCode(Node.RecvNode());
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.CurrentBuilder.Append("{");
		@Var int i = 0;
		while(i < Node.GetListSize()) {
			@Var ZNode KeyNode = Node.GetListAt(i);
			if (i > 0) {
				this.CurrentBuilder.Append(", ");
			}
			this.GenerateCode(null, KeyNode);
			this.CurrentBuilder.Append(": ");
			i = i + 1;
			if(i < Node.GetListSize()){
				@Var ZNode ValueNode = Node.GetListAt(i);
				this.GenerateCode(null, ValueNode);
				i = i + 1;
			}else{
				this.CurrentBuilder.Append("null");
			}
		}
		this.CurrentBuilder.Append("}");
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		this.CurrentBuilder.AppendNewLine("var ", Node.GlobalName, " = ");
		this.GenerateCode(null, Node.InitValueNode());
		this.CurrentBuilder.Append(this.SemiColon);
		Node.GetNameSpace().SetLocalSymbol(Node.GetName(), Node.ToGlobalNameNode());
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
		if(!Node.SuperType.Equals(ZClassType._ObjectType) && !JavaScriptGenerator.UseExtend) {
			JavaScriptGenerator.UseExtend = true;
			this.GenerateExtendCode(Node);
		}
		this.CurrentBuilder.AppendNewLine("var ", Node.ClassName, " = ");
		this.CurrentBuilder.Append("(function(");
		if(!Node.SuperType.Equals(ZClassType._ObjectType)) {
			this.CurrentBuilder.OpenIndent("_super) {");
			this.CurrentBuilder.AppendNewLine("__extends(", Node.ClassName, this.Camma);
			this.CurrentBuilder.Append("_super)", this.SemiColon);
		} else {
			this.CurrentBuilder.OpenIndent(") {");
		}
		this.CurrentBuilder.AppendNewLine("function", Node.ClassName);
		this.CurrentBuilder.OpenIndent("() {");
		if(!Node.SuperType.Equals(ZClassType._ObjectType)) {
			this.CurrentBuilder.AppendNewLine("_super.call(this)", this.SemiColon);
		}

		@Var int i = 0;
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			@Var ZNode ValueNode = FieldNode.InitValueNode();
			if(!(ValueNode instanceof ZNullNode)) {
				this.CurrentBuilder.AppendNewLine("this.");
				this.CurrentBuilder.Append(FieldNode.GetName());
				this.CurrentBuilder.Append(" = ");
				this.GenerateCode(null, FieldNode.InitValueNode());
				this.CurrentBuilder.Append(this.SemiColon);
			}
			i = i + 1;
		}
		this.CurrentBuilder.CloseIndent("}");

		this.CurrentBuilder.AppendNewLine("return ", Node.ClassName, this.SemiColon);
		this.CurrentBuilder.CloseIndent("})(");
		if(Node.SuperType != null) {
			this.CurrentBuilder.Append(Node.SuperType.GetName());
		}
		this.CurrentBuilder.Append(")", this.SemiColon);
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

}
