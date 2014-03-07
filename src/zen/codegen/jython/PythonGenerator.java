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
import zen.ast.ZClassNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZLetNode;
import zen.ast.ZListNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.ast.ZStupidCastErrorNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarNode;
import zen.lang.ZenTypeSafer;
import zen.parser.ZLogger;
import zen.parser.ZSourceEngine;
import zen.parser.ZSourceGenerator;
import zen.type.ZClassField;
import zen.type.ZClassType;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZenMethod;

//Zen Generator should be written in each language.

public class PythonGenerator extends ZSourceGenerator {

	@Field boolean HasMainFunction = false;

	public PythonGenerator() {
		super("py", "Python-2.7.1");
		this.LineComment = "#"; // if not, set null
		this.BeginComment = null; //"'''";
		this.EndComment = null; //"'''";
		this.Camma = ", ";
		this.SemiColon = "";
		this.StringLiteralPrefix = "";

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

		this.HeaderBuilder.Append("#! /usr/bin/env python");
		this.HeaderBuilder.AppendNewLine("# -*- coding: utf-8 -*-");
		this.HeaderBuilder.AppendNewLine("def zstr(s) : return str(s) if s != None else \'null\'");
		this.CurrentBuilder.AppendNewLine("## end of header", this.LineFeed);

	}

	@Override public ZSourceEngine GetEngine() {
		return new ZSourceEngine(new ZenTypeSafer(this), this);
	}

	@Override protected void GenerateImportLibrary(String LibName) {
		if(LibName.startsWith("def ")) {
			this.HeaderBuilder.AppendNewLine(LibName);
		}
		else {
			this.HeaderBuilder.AppendNewLine("import ", LibName);
		}
	}

	@Override @ZenMethod protected void Finish(String FileName) {
		if(this.HasMainFunction) {
			this.CurrentBuilder.AppendNewLine("if __name__ == \"__main__\":\n\tmain()");
			this.CurrentBuilder.AppendLineFeed();
		}
	}

	@Override public void VisitStmtList(ZListNode BlockNode) {
		@Var int i = 0;
		while (i < BlockNode.GetListSize()) {
			ZNode SubNode = BlockNode.GetListAt(i);
			this.CurrentBuilder.AppendNewLine();
			this.GenerateCode(null, SubNode);
			this.CurrentBuilder.Append(this.SemiColon);
			i = i + 1;
		}
		if (i == 0) {
			this.CurrentBuilder.AppendNewLine();
			this.CurrentBuilder.Append("pass");
		}
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.Append(":");
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendNewLine();
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.CurrentBuilder.Append(this.NameClass(Node.Type));
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		// this.CurrentBuilder.Append("(");
		// this.VisitType(Node.Type);
		// this.CurrentBuilder.Append(") ");
		//this.CurrentBuilder.AppendBlockComment("as " + this.GetNativeTypeName(Node.Type));
		this.GenerateCode(null, Node.AST[ZCastNode._Expr]);
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		@Var ZType RecvType = Node.GetAstType(ZGetIndexNode._Recv);
		if(RecvType.IsMapType()) {
			this.ImportLibrary("def zGetMap(m,k): return m[k] if m.has_key(k) else None");
			this.GenerateCode(null, "zGetMap(", Node.AST[ZGetIndexNode._Recv], ", ");
			this.GenerateCode(null, "", Node.AST[ZGetIndexNode._Index], ")");
		}
		else {
			this.GenerateCode(null, Node.AST[ZGetIndexNode._Recv]);
			this.GenerateCode(null, "[", Node.AST[ZGetIndexNode._Index], "]");
		}
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.CurrentBuilder.Append("isinstance(");
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		if(Node.TargetType instanceof ZClassType) {
			this.CurrentBuilder.Append(this.Camma, this.NameClass(Node.TargetType), ")");
		}
		else {
			this.CurrentBuilder.Append(this.Camma);
			this.GenerateTypeName(Node.TargetType);
			this.CurrentBuilder.Append(")");
		}
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.NativeName, Node.VarIndex));
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);
		this.VisitStmtList(Node);
		this.CurrentBuilder.AppendNewLine();
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		this.CurrentBuilder.Append("if ");
		this.GenerateCode(null, Node.AST[ZIfNode._Cond]);
		this.GenerateCode(null, Node.AST[ZIfNode._Then]);
		if (Node.HasAst(ZIfNode._Else)) {
			ZNode ElseNode = Node.AST[ZIfNode._Else];
			if(ElseNode instanceof ZIfNode) {
				this.CurrentBuilder.Append("el");
			}
			else {
				this.CurrentBuilder.Append("else");
			}
			this.GenerateCode(null, Node.AST[ZIfNode._Else]);
		}
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		if(this.ReadableCode || !Node.IsConstValue()) {
			this.CurrentBuilder.Append(Node.GlobalName);
			this.CurrentBuilder.Append(" = ");
			this.GenerateCode(null, Node.AST[ZLetNode._InitValue]);
			Node.GetNameSpace().SetLocalSymbol(Node.Symbol, Node.ToGlobalNameNode());
		}
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.Name, Node.ParamIndex));
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

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(!Node.Type.IsVoidType()) {
			if(Node.FuncName == null) {
				Node.FuncName = "f";
			}
			@Var String FuncName = Node.FuncName + this.GetUniqueNumber();
			this.CurrentBuilder = this.InsertNewSourceBuilder();
			this.CurrentBuilder.Append("def ");
			this.CurrentBuilder.Append(FuncName);
			this.VisitListNode("(", Node, ")");
			this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder = this.CurrentBuilder.Pop();
			this.CurrentBuilder.Append(FuncName);
		}
		else {
			@Var ZFuncType FuncType = Node.GetFuncType(null);
			this.CurrentBuilder.Append("def ");
			this.CurrentBuilder.Append(Node.GetSignature(this));
			this.VisitListNode("(", Node, ")");
			this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
			this.CurrentBuilder.AppendLineFeed();
			if(Node.IsExport) {
				this.CurrentBuilder.Append(Node.FuncName, " = ", FuncType.StringfySignature(Node.FuncName));
				this.CurrentBuilder.AppendLineFeed();
				if(Node.FuncName.equals("main")) {
					this.HasMainFunction = true;
				}
			}
			if(this.IsMethod(Node.FuncName, FuncType)) {
				this.CurrentBuilder.Append(this.NameMethod(FuncType.GetRecvType(), Node.FuncName));
				this.CurrentBuilder.Append(" = ", FuncType.StringfySignature(Node.FuncName));
				this.CurrentBuilder.AppendLineFeed();
			}
		}
	}

	private void GenerateMethodVariables(ZClassNode Node) {
		@Var int i = 0;
		while (i < Node.ClassType.GetFieldSize()) {
			@Var ZClassField ClassField = Node.ClassType.GetFieldAt(i);
			if(ClassField.FieldType.IsFuncType()) {
				this.CurrentBuilder.AppendNewLine();
				this.CurrentBuilder.Append(this.NameMethod(Node.ClassType, ClassField.FieldName));
				this.CurrentBuilder.Append(" = ", this.NullLiteral);
			}
			i = i + 1;
		}
		this.CurrentBuilder.AppendNewLine();
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		@Var ZType SuperType = Node.ClassType.GetSuperType();
		this.GenerateMethodVariables(Node);
		this.CurrentBuilder.Append("class ");
		this.CurrentBuilder.Append(this.NameClass(Node.ClassType));
		if(!SuperType.IsVarType()) {
			this.CurrentBuilder.Append("(");
			this.CurrentBuilder.Append(this.NameClass(SuperType));
			this.CurrentBuilder.Append(")");
		}
		this.CurrentBuilder.Append(":");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendNewLine();
		this.CurrentBuilder.Append("def __init__(self):");
		this.CurrentBuilder.Indent();
		if(!SuperType.IsVarType()) {
			this.CurrentBuilder.AppendNewLine();
			this.CurrentBuilder.Append(this.NameClass(SuperType));
			this.CurrentBuilder.Append(".__init__(self)");
		}
		@Var int i = 0;
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			if(!FieldNode.DeclType.IsFuncType()) {
				this.CurrentBuilder.AppendNewLine();
				this.CurrentBuilder.Append("self." + FieldNode.FieldName + " = ");
				this.GenerateCode(null, FieldNode.AST[ZFieldNode._InitValue]);
			}
			this.CurrentBuilder.Append(this.SemiColon);
			i = i + 1;
		}

		i = 0;
		while (i < Node.ClassType.GetFieldSize()) {
			@Var ZClassField ClassField = Node.ClassType.GetFieldAt(i);
			if(ClassField.FieldType.IsFuncType()) {
				this.CurrentBuilder.AppendNewLine();
				this.CurrentBuilder.Append("self." + ClassField.FieldName);
				this.CurrentBuilder.Append(" = _" + this.NameClass(Node.ClassType) + "_" + ClassField.FieldName);
			}
			i = i + 1;
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.UnIndent();
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

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("raise ");
		this.GenerateCode(null, Node.AST[ZThrowNode._Expr]);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
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


}