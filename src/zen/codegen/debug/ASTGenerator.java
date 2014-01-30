// ***************************************************************************
// Copyright (c) 2014, JST/CREST DEOS project authors. All rights reserved.
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
package zen.codegen.debug;

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassDeclNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZConstPoolNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetLocalNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewArrayNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetLocalNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZSymbolNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.parser.ZSourceGenerator;
import zen.type.ZType;

public class ASTGenerator extends ZSourceGenerator {

	public ASTGenerator() {
		super("ast", "1");
		this.LineFeed = "\n";
		this.Tab = "\t";
		this.Camma = ", ";
		this.SemiColon = ";";

		this.TrueLiteral  = "true";
		this.FalseLiteral = "false";
		this.NullLiteral  = "null";

		this.TopType = "object";
		this.SetNativeType(ZType.BooleanType, "int");
		this.SetNativeType(ZType.IntType, "int");
		this.SetNativeType(ZType.FloatType, "double");
		this.SetNativeType(ZType.StringType, "string");
	}

	@Override
	public void VisitNullNode(ZNullNode Node) {
		this.CurrentBuilder.Append("(null)");
	}

	@Override
	public void VisitBooleanNode(ZBooleanNode Node) {
		this.CurrentBuilder.Append("(" + Node.GetValue() + ")");
	}

	@Override
	public void VisitIntNode(ZIntNode Node) {
		this.CurrentBuilder.Append("(" + Node.GetValue() + ")");
	}

	@Override
	public void VisitFloatNode(ZFloatNode Node) {
		this.CurrentBuilder.Append("(" + Node.GetValue() + ")");
	}

	@Override
	public void VisitStringNode(ZStringNode Node) {
		this.CurrentBuilder.Append("(" + Node.GetValue() + ")");
	}

	@Override
	public void VisitConstPoolNode(ZConstPoolNode Node) {
		this.CurrentBuilder.Append("(" + Node.GetValue() + ")");
	}

	@Override
	public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.CurrentBuilder.Append("(array " + this.LineFeed);
		this.CurrentBuilder.Indent();
		for (int i = 0; i < Node.NodeList.size(); i++) {
			Node.NodeList.get(i).Accept(this);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.CurrentBuilder.Append("(map " + this.LineFeed);
		this.CurrentBuilder.Indent();
		for (int i = 0; i < Node.NodeList.size(); i+= 2) {
			Node.NodeList.get(i+0).Accept(this);
			this.AppendCode(":");
			Node.NodeList.get(i+1).Accept(this);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitNewArrayNode(ZNewArrayNode Node) {
		this.CurrentBuilder.Append("(newarray ");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		for (int i = 0; i < Node.NodeList.size(); i++) {
			Node.NodeList.get(i).Accept(this);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.CurrentBuilder.Append("(new " + Node.Type);
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		for (int i = 0; i < Node.ParamList.size(); i++) {
			Node.ParamList.get(i).Accept(this);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitSymbolNode(ZSymbolNode Node) {
		this.CurrentBuilder.Append("(symbol " + Node.Type + " " + Node.ReferenceName + ")");
	}

	@Override
	public void VisitGetLocalNode(ZGetLocalNode Node) {
		this.CurrentBuilder.Append("(get-local " + Node.Type + " " + Node.VarName + ")");
	}

	@Override
	public void VisitSetLocalNode(ZSetLocalNode Node) {
		this.CurrentBuilder.Append("(set-local " + Node.Type + " " + Node.VarName);
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitGroupNode(ZGroupNode Node) {
		Node.RecvNode.Accept(this);
	}

	@Override
	public void VisitGetterNode(ZGetterNode Node) {
		this.CurrentBuilder.Append("(get-field " + Node.Type + " " + Node.FieldName + " ");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitSetterNode(ZSetterNode Node) {
		this.CurrentBuilder.Append("(set-field " + Node.Type + " " + Node.FieldName + " ");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.CurrentBuilder.Append("(get-index " + Node.Type + " ");
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.IndexNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.CurrentBuilder.Append("(get-index " + Node.Type + " ");
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.IndexNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.CurrentBuilder.Append("(method-call " + Node.Type + " " + Node.MethodName);
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.AppendParamList(Node.ParamList, 0, Node.ParamList.size());
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.CurrentBuilder.Append("(method-call " + Node.Type);
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		Node.FuncNode.Accept(this);
		this.CurrentBuilder.AppendParamList(Node.ParamList, 0, Node.ParamList.size());
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitUnaryNode(ZUnaryNode Node) {
		this.CurrentBuilder.Append("(" + Node.SourceToken.ParsedText + " " + Node.Type + " ");
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitNotNode(ZNotNode Node) {
		this.CurrentBuilder.Append("(" + Node.SourceToken.ParsedText + " " + Node.Type + " ");
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitCastNode(ZCastNode Node) {
		this.CurrentBuilder.Append("(cast to:" + Node.Type + " ");
		Node.ExprNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.CurrentBuilder.Append("(instanceof ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitBinaryNode(ZBinaryNode Node) {
		this.CurrentBuilder.Append("(" + Node.SourceToken.ParsedText + " ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitComparatorNode(ZComparatorNode Node) {
		this.CurrentBuilder.Append("(" + Node.SourceToken.ParsedText + " ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitAndNode(ZAndNode Node) {
		this.CurrentBuilder.Append("(" + Node.SourceToken.ParsedText + " ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitOrNode(ZOrNode Node) {
		this.CurrentBuilder.Append("(" + Node.SourceToken.ParsedText + " ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.Append("(block");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendParamList(Node.StmtList, 0, Node.StmtList.size());
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitVarDeclNode(ZVarDeclNode Node) {
		this.CurrentBuilder.Append("(var-decl " + Node.NativeName);
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append("(");
		Node.InitNode.Accept(this);
		this.CurrentBuilder.Append(")");
		for (int i = 0; i < Node.StmtList.size(); i++) {
			Node.StmtList.get(i).Accept(this);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitIfNode(ZIfNode Node) {
		this.CurrentBuilder.Append("(if ");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		Node.CondNode.Accept(this);
		Node.ThenNode.Accept(this);
		if(Node.ElseNode != null) {
			Node.ElseNode.Accept(this);
		} else {
			this.CurrentBuilder.Append("()");
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitReturnNode(ZReturnNode Node) {
		this.CurrentBuilder.Append("(return ");
		if(Node.ValueNode != null) {
			Node.ValueNode.Accept(this);
		}
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitWhileNode(ZWhileNode Node) {
		this.CurrentBuilder.Append("(while ");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		Node.CondNode.Accept(this);
		Node.BodyNode.Accept(this);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitBreakNode(ZBreakNode Node) {
		this.CurrentBuilder.Append("(break)");

	}

	@Override
	public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("(throw ");
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("(try ");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		Node.TryNode.Accept(this);
		Node.CatchNode.Accept(this);
		if(Node.FinallyNode != null) {
			Node.FinallyNode.Accept(this);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("(catch " + Node.ExceptionType + " " + Node.ExceptionName );
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		Node.BodyNode.Accept(this);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append("(" + Node.Name + ":" + Node.Type + ")");
	}

	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		this.CurrentBuilder.Append("(func ");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append("(");
		for (int i = 0; i < Node.ParamList.size(); i++) {
			Node.ParamList.get(i).Accept(this);
		}
		this.CurrentBuilder.Append(")");
		Node.BodyNode.Accept(this);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	//	@Override
	//	public void VisitFuncDeclNode(ZFunctionNode/*Decl*/ Node) {
	//		this.CurrentBuilder.Append("(func-decl " + Node.FuncName);
	//		this.CurrentBuilder.AppendLineFeed();
	//		this.CurrentBuilder.Indent();
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.Append("(");
	//		this.CurrentBuilder.AppendParamList(Node.ParamList, 0, Node.ParamList.size());
	//		this.CurrentBuilder.Append(")");
	//		this.CurrentBuilder.AppendLineFeed();
	//		this.CurrentBuilder.AppendIndent();
	//		Node.BodyNode.Accept(this);
	//		this.CurrentBuilder.UnIndent();
	//		this.CurrentBuilder.Append(")");
	//	}

	@Override
	public void VisitClassDeclNode(ZClassDeclNode Node) {
		this.CurrentBuilder.Append("(class-decl " + Node.ClassName);
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Indent();
		for (int i = 0; i < Node.FieldList.size(); i++) {
			this.CurrentBuilder.AppendIndent();
			this.VisitClassField(Node.FieldList.get(i));
			this.CurrentBuilder.AppendLineFeed();
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	private void VisitClassField(ZFieldNode Node) {
		this.CurrentBuilder.Append("(field-decl " + Node.DeclType + " " + Node.FieldName + " ");
		if(Node.InitNode != null) {
			this.CurrentBuilder.Append("(");
			Node.InitNode.Accept(this);
			this.CurrentBuilder.Append(")");
		}
		else {
			this.CurrentBuilder.Append(")");
		}
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitErrorNode(ZErrorNode Node) {
		this.CurrentBuilder.Append("(error " + Node.ErrorMessage + ")");
	}
}
