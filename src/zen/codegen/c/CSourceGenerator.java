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
package zen.codegen.c;

import zen.ast.ZenCastNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionNode;
import zen.ast.ZenInstanceOfNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenVarDeclNode;
import zen.lang.ZSystem;
import zen.parser.ZenSourceGenerator;
//endif VAJA

//Zen Generator should be written in each language.

public class CSourceGenerator extends ZenSourceGenerator {

	public CSourceGenerator/* constructor */() {
		super("C", "99");
		this.LineFeed = "\n";
		this.Tab = "\t";
		this.Camma = ", ";
		this.SemiColon = ";";

		this.TrueLiteral  = "1/*true*/";
		this.FalseLiteral = "0/*false*/";
		this.NullLiteral  = "NULL";

		this.TopType = "void*";
		this.SetNativeType(ZSystem.BooleanType, "int");
		this.SetNativeType(ZSystem.IntType, "long long int");
		this.SetNativeType(ZSystem.FloatType, "double");
		this.SetNativeType(ZSystem.StringType, "char*");
	}

	@Override public void VisitCastNode(ZenCastNode Node) {
		this.CurrentBuilder.Append("(");
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.ExprNode);
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		this.CurrentBuilder.Append("isinstance(");
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.Append(this.Camma);
		this.VisitType(Node.RightNode.Type);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.InitNode);
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node.StmtList);
	}

	@Override public void VisitParamNode(ZenParamNode Node) {
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Node.Name);
	}

	@Override public void VisitFunctionNode(ZenFunctionNode Node) {
		this.VisitType(Node.ReturnType);
		this.CurrentBuilder.Append(" ");

		this.CurrentBuilder.Append("function ");
		this.VisitParamList("(", Node.ArgumentList, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		this.GenerateCode(Node.BodyNode);
	}

	@Override public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
		this.VisitType(Node.ReturnType);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Node.FuncName);
		this.VisitParamList("(", Node.ArgumentList, ")");
		if (Node.BodyNode == null) {
			this.CurrentBuilder.Append(this.SemiColon);
		} else {
			this.GenerateCode(Node.BodyNode);
		}
	}

}
