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
import zen.ast.ZBooleanNode;
import zen.ast.ZErrorNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZIfNode;
import zen.ast.ZIntNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZStringNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.parser.ZSourceGenerator;

public class CommonLispSourceGenerator extends ZSourceGenerator {

	public CommonLispSourceGenerator() {
		super("CommonLisp", "0.0");
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		if(Node.BooleanValue) {
			this.CurrentBuilder.Append("t");
		}
		else {
			this.CurrentBuilder.Append("nil");
		}
	}
	@Override public void VisitIntNode(ZIntNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		if (Node.ValueNode != null) {
			Node.ValueNode.Accept(this);
		}
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.CurrentBuilder.Append("nil");
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node.StmtList);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
	}

	//	@Override
	//	public void GenerateFunc(ZenFunc Func, ArrayList<String> ParamNameList, ZenNode Body) {
	//		String MethodName = Func.GetNativeFuncName();
	//		ZenSourceBuilder Builder = new ZenSourceBuilder(this);
	//		ZenSourceBuilder PushedBuilder = this.CurrentBuilder;
	//		this.CurrentBuilder = Builder;
	//		Builder.Append("(defun ");
	//		Builder.AppendToken(MethodName);
	//
	//		Builder.Append("(");
	//
	//		@Var int i = 0;
	//		@Var int size = LibZen.ListSize(ParamNameList);
	//		while (i < size) {
	//			if(i != 0) {
	//				Builder.Append(" ");
	//			}
	//			Builder.Append(ParamNameList.get(i));
	//			i += 1;
	//		}
	//		Builder.AppendLine(")");
	//
	//		this.CurrentBuilder = Builder;
	//		this.VisitIndentBlock("", Body, "");
	//
	//		this.CurrentBuilder = PushedBuilder;
	//		Builder.AppendLine(")");
	//
	//		// for debug
	//		System.out.println(Builder.toString());
	//	}

	//
	// Visitor API
	//
	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.CurrentBuilder.Append("(while ");

		Node.CondNode.Accept(this);

		this.CurrentBuilder.AppendLineFeed();
		Node.BodyNode.Accept(this);
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append(")");
	}

	//	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
	//		this.CurrentBuilder.AppendLine("(loop initially");
	//
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.AppendIndent();
	//
	//		this.CurrentBuilder.AppendLine("(progn");
	//		this.VisitIndentBlock("", Node.BodyNode, "");
	//
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.AppendLine(")");
	//
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.AppendIndent();
	//
	//		this.CurrentBuilder.Append("while ");
	//		Node.CondNode.Accept(this);
	//		this.CurrentBuilder.AppendLine("");
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.AppendIndent();
	//
	//		this.CurrentBuilder.AppendLine("do (progn");
	//		this.VisitIndentBlock("", Node.BodyNode, "");
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.Append(")");
	//		this.CurrentBuilder.Append(")");
	//	}

	//	@Override public void VisitForNode(ZenForNode Node) {
	//		this.CurrentBuilder.Append("(loop while ");
	//		Node.CondNode.Accept(this);
	//		this.CurrentBuilder.AppendLine("");
	//
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.AppendLine("do (progn");
	//		this.VisitIndentBlock("", Node.BodyNode, "");
	//
	//		this.CurrentBuilder.AppendIndent();
	//		this.CurrentBuilder.AppendIndent();
	//		Node.IterNode.Accept(this);
	//		this.CurrentBuilder.Append(")");
	//
	//		this.CurrentBuilder.Append(")");
	//	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		this.CurrentBuilder.Append("(setq  ");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" ");

		if (Node.InitNode != null) {
			Node.InitNode.Accept(this);
		} else {
			this.CurrentBuilder.Append("nil");
		}

		this.CurrentBuilder.AppendToken(")");
	}

	//	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
	//		this.CurrentBuilder.Append("(if  ");
	//		Node.CondNode.Accept(this);
	//		this.CurrentBuilder.Append(" ");
	//		Node.ThenNode.Accept(this);
	//		this.CurrentBuilder.Append(" ");
	//		Node.ElseNode.Accept(this);
	//		this.CurrentBuilder.Append(")");
	//	}

	@Override public void VisitIfNode(ZIfNode Node) {
		this.CurrentBuilder.Append("(if  ");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();

		this.CurrentBuilder.Append("(progn ");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		Node.ThenNode.Accept(this);
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append(")");

		if(Node.ElseNode != null) {
			this.CurrentBuilder.Indent();
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.Append("(progn ");
			Node.ElseNode.Accept(this);
			this.CurrentBuilder.UnIndent();
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.Append(")");
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.CurrentBuilder.Append("(error ");
		Node.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	//	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {
	//		ZenSourceBuilder Builder = new ZenSourceBuilder(this);
	//
	//		Builder.Append("(defclass ");
	//		Builder.Append(Type.ShortName);
	//		Builder.Append(" " + "()");
	//
	//		Builder.Append(" " + "(");
	//		for (ZenFieldInfo FieldInfo : ClassField.FieldList) {
	//			String InitValue = this.StringifyConstValue(FieldInfo.InitValue);
	//
	//			Builder.Append("(");
	//			Builder.Append(FieldInfo.NativeName);
	//			Builder.Append(" :initarg :" + FieldInfo.NativeName);
	//
	//			if (!FieldInfo.Type.IsNativeType()) {
	//				InitValue = "nil";
	//			}
	//
	//			Builder.Append(" :initform " + InitValue);
	//			Builder.Append(")");
	//		}
	//		Builder.Append("))");
	//
	//		// for debug
	//		System.out.println(Builder.toString());
	//	}

	//	@Override public void InvokeMainFunc(String MainFuncName) {
	//		this.CurrentBuilder = this.NewSourceBuilder();
	//		this.CurrentBuilder.Append("(");
	//		this.CurrentBuilder.Append(MainFuncName);
	//		this.CurrentBuilder.AppendLine(")");
	//	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		Node.RecvNode.Accept(this);
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		this.CurrentBuilder.Append(" ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.CurrentBuilder.Append("(and ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}
	@Override public void VisitOrNode(ZOrNode Node) {
		this.CurrentBuilder.Append("(or ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append("(setq  " + Node.VarName);
		this.CurrentBuilder.Append(" ");
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	// TODO function call

	// XXX
	//@Override public void VisitSwitchNode(ZenSwitchNode Node) {
	//}

	// XXX
	//@Override public void VisitSelfAssignNode(ZenSelfAssignNode Node) {
	//}

}
