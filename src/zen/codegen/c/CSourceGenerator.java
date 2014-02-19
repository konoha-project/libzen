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

import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZLetNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewArrayNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZSetterNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.parser.ZSourceGenerator;
import zen.type.ZType;

public class CSourceGenerator extends ZSourceGenerator {

	public CSourceGenerator() {
		super("C", "99");
		this.LineFeed = "\n";
		this.Tab = "\t";
		this.Camma = ", ";
		this.SemiColon = ";";

		this.TrueLiteral  = "1/*true*/";
		this.FalseLiteral = "0/*false*/";
		this.NullLiteral  = "NULL";

		this.TopType = "void*";
		this.SetNativeType(ZType.BooleanType, "int");
		this.SetNativeType(ZType.IntType, "long long int");
		this.SetNativeType(ZType.FloatType, "double");
		this.SetNativeType(ZType.StringType, "char*");
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.VisitListNode("[", Node, "]");
		// TODO Auto-generated method stub
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void GenerateCode(ZNode Node) {
		if(Node.IsUntyped()) {
			this.CurrentBuilder.Append(this.NullLiteral + "/*untyped*/");
			this.Logger.ReportError2(Node, "untyped error");
		}
		else {
			Node.Accept(this);
		}
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.CurrentBuilder.Append("New"+Node.Type.GetAsciiName());
		this.VisitListNode("(", Node, ")");
	}

	private String BaseName(ZType RecvType) {
		return RecvType.GetAsciiName(); // FIXME
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.CurrentBuilder.Append(this.BaseName(Node.GetAstType(ZGetIndexNode._Recv)) + "GetIndex");
		this.CurrentBuilder.Append("(");
		this.GenerateCode(Node.AST[ZGetIndexNode._Index]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.CurrentBuilder.Append(this.BaseName(Node.GetAstType(ZGetIndexNode._Recv)) + "SetIndex");
		this.CurrentBuilder.Append("(");
		this.GenerateCode(Node.AST[ZSetIndexNode._Index]);
		this.CurrentBuilder.AppendToken(", ");
		this.GenerateCode(Node.AST[ZSetIndexNode._Expr]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZSetNameNode._Expr]);
	}


	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.GenerateSurroundCode(Node.AST[ZGetterNode._Recv]);
		this.CurrentBuilder.Append("->");
		this.CurrentBuilder.Append(Node.FieldName);
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		this.GenerateSurroundCode(Node.AST[ZSetterNode._Recv]);
		this.CurrentBuilder.Append("->");
		this.CurrentBuilder.Append(Node.FieldName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZSetterNode._Expr]);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		//		this.GenerateSurroundCode(Node.AST[ZMethodCallNode._Recv]);
		//		this.CurrentBuilder.Append(".");
		//		this.CurrentBuilder.Append(Node.MethodName);
		//		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.GenerateCode(Node.AST[ZFuncCallNode._Func]);
		this.VisitListNode("(", Node, ")");
	}

	//	@Override public void VisitCastNode(ZCastNode Node) {
	//		this.CurrentBuilder.Append("(");
	//		this.VisitType(Node.Type);
	//		this.CurrentBuilder.Append(")");
	//		this.GenerateSurroundCode(Node.AST[ZCastNode._Expr]);
	//	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("longjump(1)");
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateCode(Node.AST[ZThrowNode._Expr]);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		//		this.CurrentBuilder.Append("try");
		//		this.GenerateCode(Node.AST[ZTryNode._Try]);
		//		if(Node.AST[ZTryNode._Catch] != null) {
		//			this.GenerateCode(Node.AST[ZTryNode._Catch]);
		//		}
		//		if (Node.AST[ZTryNode._Finally] != null) {
		//			this.CurrentBuilder.Append("finally");
		//			this.GenerateCode(Node.AST[ZTryNode._Finally]);
		//		}
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		//		this.CurrentBuilder.Append("catch (");
		//		this.CurrentBuilder.Append(Node.ExceptionName);
		//		this.VisitTypeAnnotation(Node.ExceptionType);
		//		this.CurrentBuilder.Append(")");
		//		this.GenerateCode(Node.AST[ZCatchNode._Block]);
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		this.CurrentBuilder.Append("struct");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.ClassName);
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Indent();
		@Var int i = 0;
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.VisitType(FieldNode.DeclType);
			this.CurrentBuilder.AppendWhiteSpace();
			this.CurrentBuilder.Append(FieldNode.FieldName);
			//			this.CurrentBuilder.AppendToken("=");
			//			this.GenerateCode(FieldNode.AST[ZFieldNode._InitValue]);
			this.CurrentBuilder.Append(this.SemiColon);
			i = i + 1;
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("}");
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.CurrentBuilder.Append("(");
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.AST[ZCastNode._Expr]);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.CurrentBuilder.Append("isinstance(");
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.Append(this.Camma);
		this.VisitType(Node.AST[ZBinaryNode._Right].Type);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node);
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		this.CurrentBuilder = this.InsertNewSourceBuilder();
		this.CurrentBuilder.Append(Node.GlobalName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZLetNode._InitValue]);
		this.CurrentBuilder = this.CurrentBuilder.Pop();
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Node.Name);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		this.VisitType(Node.ReturnType);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Node.FuncName);
		this.VisitListNode("(", Node, ")");
		this.GenerateCode(Node.AST[ZFunctionNode._Block]);
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.Logger.ReportError(Node.SourceToken, Node.ErrorMessage);
		this.CurrentBuilder.Append("ThrowError(");
		this.CurrentBuilder.Append(LibZen._QuoteString(Node.ErrorMessage));
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitExtendedNode(ZNode Node) {

	}




}
