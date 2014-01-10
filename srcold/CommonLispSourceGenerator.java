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

package org.GreenTeaScript;

import java.util.ArrayList;

import parser.ZenClassField;
import parser.ZenFieldInfo;
import parser.ZenFunc;
import parser.ZenSourceBuilder;
import parser.ZenSourceGenerator;
import parser.ZenSyntaxTree;
import parser.ZenType;
import parser.ast.ZenAndNode;
import parser.ast.ZenBinaryNode;
import parser.ast.ZenBooleanNode;
import parser.ast.ZenConstPoolNode;
import parser.ast.ZenDoWhileNode;
import parser.ast.ZenEmptyNode;
import parser.ast.ZenErrorNode;
import parser.ast.ZenForNode;
import parser.ast.ZenGetLocalNode;
import parser.ast.ZenIfNode;
import parser.ast.ZenIntNode;
import parser.ast.ZenNode;
import parser.ast.ZenNullNode;
import parser.ast.ZenOrNode;
import parser.ast.ZenReturnNode;
import parser.ast.ZenSetLocalNode;
import parser.ast.ZenStringNode;
import parser.ast.ZenTrinaryNode;
import parser.ast.ZenUnaryNode;
import parser.ast.ZenVarDeclNode;
import parser.ast.ZenWhileNode;
import parser.deps.LibGreenTea;

public class CommonLispSourceGenerator extends ZenSourceGenerator {

	public CommonLispSourceGenerator(String TargetCode, String OutputFile, int GeneratorFlag) {
		super(TargetCode, OutputFile, GeneratorFlag);
	}

	@Override public void VisitGetLocalNode(ZenGetLocalNode Node) {
		this.CurrentBuilder.Append(Node.Token.ParsedText);
	}
	
	@Override public void VisitBooleanNode(ZenBooleanNode Node) {
		if(Node.Value) {
			this.CurrentBuilder.Append("t");
		}
		else {
			this.CurrentBuilder.Append("nil");
		}
	}
	@Override public void VisitIntNode(ZenIntNode Node) {
		this.CurrentBuilder.Append(Node.Token.ParsedText);
	}

	@Override public void VisitStringNode(ZenStringNode Node) {
		this.CurrentBuilder.Append(Node.Token.ParsedText);
	}
	@Override public void VisitConstPoolNode(ZenConstPoolNode Node) {
		if(Node.ConstValue == null) {
			this.CurrentBuilder.Append("nil");
		}
		else {
			this.CurrentBuilder.Append(Node.Token.ParsedText);
		}
	}

	private final boolean DoesNodeExist(ZenNode Node){
		return Node != null && !(Node instanceof ZenEmptyNode);
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		if (this.DoesNodeExist(Node.ValueNode)) {
			Node.ValueNode.Accept(this);
		}
	}

	@Override public void VisitNullNode(ZenNullNode Node) {
		this.CurrentBuilder.Append("nil");
	}

	@Override
	public void VisitIndentBlock(String BeginBlock, ZenNode Node, String EndBlock) {
		//this.VisitingBuilder.AppendLine(BeginBlock);
		this.CurrentBuilder.Indent();
		/*local*/ZenNode CurrentNode = Node;
		while(CurrentNode != null) {
			if(!this.IsEmptyBlock(CurrentNode)) {
				this.CurrentBuilder.AppendIndent();
				CurrentNode.Accept(this);
				this.CurrentBuilder.AppendLine("");
			}
			CurrentNode = CurrentNode.NextNode;
		}
		this.CurrentBuilder.UnIndent();
		if(EndBlock != null) {
			//this.VisitingBuilder.IndentAndAppend(EndBlock);
		}
	}

	@Override
	public void GenerateFunc(ZenFunc Func, ArrayList<String> ParamNameList, ZenNode Body) {
		String MethodName = Func.GetNativeFuncName();
		ZenSourceBuilder Builder = new ZenSourceBuilder(this);
		ZenSourceBuilder PushedBuilder = this.CurrentBuilder;
		this.CurrentBuilder = Builder;
		Builder.Append("(defun ");
		Builder.SpaceAppendSpace(MethodName);

		Builder.Append("(");

		/*local*/int i = 0;
		/*local*/int size = LibGreenTea.ListSize(ParamNameList);
		while (i < size) {
			if(i != 0) {
				Builder.Append(" ");
			}
			Builder.Append(ParamNameList.get(i));
			i += 1;
		}
		Builder.AppendLine(")");

		this.CurrentBuilder = Builder;
		this.VisitIndentBlock("", Body, "");

		this.CurrentBuilder = PushedBuilder;
		Builder.AppendLine(")");

		// for debug
		System.out.println(Builder.toString());
	}

	//
	// Visitor API
	//
	@Override public void VisitWhileNode(ZenWhileNode Node) {
		this.CurrentBuilder.Append("(while ");

		Node.CondNode.Accept(this);

		this.CurrentBuilder.AppendLine("");
		this.VisitIndentBlock("", Node.BodyNode, "");
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
		this.CurrentBuilder.AppendLine("(loop initially");

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendIndent();

		this.CurrentBuilder.AppendLine("(progn");
		this.VisitIndentBlock("", Node.BodyNode, "");

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendLine(")");

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendIndent();

		this.CurrentBuilder.Append("while ");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.AppendLine("");
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendIndent();

		this.CurrentBuilder.AppendLine("do (progn");
		this.VisitIndentBlock("", Node.BodyNode, "");
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append(")");
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitForNode(ZenForNode Node) {
		this.CurrentBuilder.Append("(loop while ");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.AppendLine("");

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendLine("do (progn");
		this.VisitIndentBlock("", Node.BodyNode, "");

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendIndent();
		Node.IterNode.Accept(this);
		this.CurrentBuilder.Append(")");

		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		this.CurrentBuilder.Append("(setq  ");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" ");

		if (Node.InitNode != null) {
			Node.InitNode.Accept(this);
		} else {
			this.CurrentBuilder.Append("nil");
		}

		this.CurrentBuilder.AppendLine(")");
	}

	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
		this.CurrentBuilder.Append("(if  ");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.ThenNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.ElseNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitIfNode(ZenIfNode Node) {
		this.CurrentBuilder.Append("(if  ");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.AppendLine("");

		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendLine("(progn ");
		this.VisitIndentBlock("", Node.ThenNode, "");
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendLine(")");

		if (!this.IsEmptyBlock(Node.ElseNode)) {
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.AppendLine("(progn ");
			this.VisitIndentBlock("", Node.ElseNode, "");
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append(")");
		}

		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitErrorNode(ZenErrorNode Node) {
		this.CurrentBuilder.Append("(error ");
		Node.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {
		ZenSourceBuilder Builder = new ZenSourceBuilder(this);

		Builder.Append("(defclass ");
		Builder.Append(Type.ShortName);
		Builder.Append(" " + "()");

		Builder.Append(" " + "(");
		for (ZenFieldInfo FieldInfo : ClassField.FieldList) {
			String InitValue = this.StringifyConstValue(FieldInfo.InitValue);

			Builder.Append("(");
			Builder.Append(FieldInfo.NativeName);
			Builder.Append(" :initarg :" + FieldInfo.NativeName);

			if (!FieldInfo.Type.IsNativeType()) {
				InitValue = "nil";
			}

			Builder.Append(" :initform " + InitValue);
			Builder.Append(")");
		}
		Builder.Append("))");

		// for debug
		System.out.println(Builder.toString());
	}

	@Override public void InvokeMainFunc(String MainFuncName) {
		this.CurrentBuilder = this.NewSourceBuilder();
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(MainFuncName);
		this.CurrentBuilder.AppendLine(")");
	}

	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		this.CurrentBuilder.Append(Node.Token.ParsedText);
		Node.RecvNode.Accept(this);
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(Node.Token.ParsedText);
		this.CurrentBuilder.Append(" ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		this.CurrentBuilder.Append("(and ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}
	@Override public void VisitOrNode(ZenOrNode Node) {
		this.CurrentBuilder.Append("(or ");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitSetLocalNode(ZenSetLocalNode Node) {
		this.CurrentBuilder.Append("(setq  " + Node.NativeName);
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
