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

import zen.ast.GtBlockNode;
import zen.ast.GtCastNode;
import zen.ast.GtInstanceOfNode;
import zen.ast.GtNode;
import zen.lang.ZenSystem;
import zen.parser.ZenSourceGenerator;
//endif VAJA

//GreenTea Generator should be written in each language.

public class PythonSourceGenerator extends ZenSourceGenerator {

	public PythonSourceGenerator/* constructor */() {
		super("python", "2.0");
		this.LineFeed = "\n";
		this.Tab = "\t";
		this.LineComment = "#"; // if not, set null
		this.BeginComment = null; //"'''";
		this.EndComment = null; //"'''";
		this.Camma = ", ";
		this.SemiColon = "";

		this.TrueLiteral = "True";
		this.FalseLiteral = "False";
		this.NullLiteral = "None";
		this.TopType = "object";
		this.SetNativeType(ZenSystem.BooleanType, "bool");
		this.SetNativeType(ZenSystem.IntType, "int");
		this.SetNativeType(ZenSystem.FloatType, "float");
		this.SetNativeType(ZenSystem.StringType, "str");
	}

	@Override
	public boolean VisitBlockNode(GtBlockNode Node) {
		int count = 0;
		this.CurrentBuilder.Append(":");
		this.CurrentBuilder.Indent();
		for (int i = 0; i < Node.NodeList.size(); i++) {
			GtNode SubNode = Node.NodeList.get(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			if (!this.GenerateCode(SubNode)) {
				return false;
			}
			this.CurrentBuilder.Append(this.SemiColon);
			count = count + 1;
		}
		if (count == 0) {
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("pass");
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("#");
		return true;
	}

	@Override public boolean VisitCastNode(GtCastNode Node) {
		// this.CurrentBuilder.Append("(");
		// this.VisitType(Node.Type);
		// this.CurrentBuilder.Append(") ");
		this.CurrentBuilder.AppendBlockComment("as " + this.GetNativeType(Node.Type));
		this.GenerateCode(Node.ExprNode);
		return true;
	}

	@Override public boolean VisitInstanceOfNode(GtInstanceOfNode Node) {
		this.CurrentBuilder.Append("isinstance(");
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.Append(this.Camma);
		this.VisitType(Node.RightNode.Type);
		this.CurrentBuilder.Append(")");
		return true;
	}

}