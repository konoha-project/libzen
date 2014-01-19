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

//ifdef  JAVA
package org.ZenScript;
import java.util.ArrayList;

import parser.ZenClassField;
import parser.ZenFieldInfo;
import parser.ZenFunc;
import parser.ZenNameSpace;
import parser.ZenSourceGenerator;
import parser.ZenSyntaxTree;
import parser.ZenType;
import parser.ast.ZenAllocateNode;
import parser.ast.ZenAndNode;
import parser.ast.ZenApplyFunctionObjectNode;
import parser.ast.ZenApplyOverridedMethodNode;
import parser.ast.ZenApplySymbolNode;
import parser.ast.ZenArrayLiteralNode;
import parser.ast.ZenBinaryNode;
import parser.ast.ZenBooleanNode;
import parser.ast.ZenBreakNode;
import parser.ast.ZenCaseNode;
import parser.ast.ZenCastNode;
import parser.ast.ZenCatchNode;
import parser.ast.ZenCommandNode;
import parser.ast.ZenConstructorNode;
import parser.ast.ZenContinueNode;
import parser.ast.ZenDoWhileNode;
import parser.ast.ZenErrorNode;
import parser.ast.ZenFloatNode;
import parser.ast.ZenForEachNode;
import parser.ast.ZenForNode;
import parser.ast.ZenGetCapturedNode;
import parser.ast.ZenGetIndexNode;
import parser.ast.ZenGetLocalNode;
import parser.ast.ZenGetterNode;
import parser.ast.ZenIfNode;
import parser.ast.ZenInstanceOfNode;
import parser.ast.ZenIntNode;
import parser.ast.ZenNewArrayNode;
import parser.ast.ZenNode;
import parser.ast.ZenNullNode;
import parser.ast.ZenOrNode;
import parser.ast.ZenParamNode;
import parser.ast.ZenPrefixDeclNode;
import parser.ast.ZenPrefixInclNode;
import parser.ast.ZenReturnNode;
import parser.ast.ZenSetCapturedNode;
import parser.ast.ZenSetIndexNode;
import parser.ast.ZenSetLocalNode;
import parser.ast.ZenSetterNode;
import parser.ast.ZenSliceNode;
import parser.ast.ZenStatementNode;
import parser.ast.ZenStringNode;
import parser.ast.ZenSuffixDeclNode;
import parser.ast.ZenSuffixInclNode;
import parser.ast.ZenSwitchNode;
import parser.ast.ZenThrowNode;
import parser.ast.ZenTrinaryNode;
import parser.ast.ZenTryNode;
import parser.ast.ZenUnaryNode;
import parser.ast.ZenUsingNode;
import parser.ast.ZenVarDeclNode;
import parser.ast.ZenWhileNode;
import parser.ast.ZenYieldNode;
import parser.deps.LibZen;
//endif VAJA

//Zen Generator should be written in each language.

public class PerlSourceGenerator extends ZenSourceGenerator {
	public PerlSourceGenerator/*constructor*/(String TargetCode, String OutputFile, int GeneratorFlag) {
		super("perl", OutputFile, GeneratorFlag);
		this.TrueLiteral  = "1";
		this.FalseLiteral = "0";
		this.NullLiteral = "undef";
		this.LineComment = "##";
	}

	@Override public void InitContext(ZenNameSpace Context) {
		super.InitContext(Context);
		this.HeaderBuilder.AppendLine("use strict;");
		this.HeaderBuilder.AppendLine("use warnings;");
		this.HeaderBuilder.AppendLine("use Error qw(:try);");
	}

	@Override public String GetRecvName() {
		return "self";
	}

	private String GetLocalType(ZenType Type, boolean IsPointer) {
		if(Type.IsDynamicType() || Type.IsNativeType()) {
			if(Type.IsBooleanType()) {
				return "int";
			}
			return Type.ShortName;
		}
		@Var String TypeName = "struct " + Type.ShortName;
		if(IsPointer) {
			TypeName += "*";
		}
		return TypeName;

	}
	public String NativeTypeName(ZenType Type) {
		return this.GetLocalType(Type, false);
	}

	public String LocalTypeName(ZenType Type) {
		return this.GetLocalType(Type, true);
	}

	public String ZenTypeName(ZenType Type) {
		return Type.ShortName;
	}

	@Override public void VisitNullNode(ZenNullNode Node) {
		this.CurrentBuilder.Append(this.NullLiteral);
	}

	@Override public void VisitBooleanNode(ZenBooleanNode Node) {
		if(Node.Value) {
			this.CurrentBuilder.Append(this.TrueLiteral);
		}
		else {
			this.CurrentBuilder.Append(this.FalseLiteral);
		}
	}

	@Override public void VisitIntNode(ZenIntNode Node) {
		this.CurrentBuilder.Append(Long.toString(Node.Value));
	}

	@Override public void VisitFloatNode(ZenFloatNode Node) {
		this.CurrentBuilder.Append(Double.toString(Node.Value));
	}

	@Override public void VisitStringNode(ZenStringNode Node) {
		this.CurrentBuilder.Append(LibZen.QuoteString(Node.Value));
	}

	//FIXME Need to Implement
//	@Override public void VisitRegexNode(ZenRegexNode Node) {
//		this.VisitingBuilder.Append("");
//	}
//
//	@Override public void VisitConstPoolNode(ZenConstPoolNode Node) {
//		this.VisitingBuilder.Append("");
//	}
//
	@Override public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
		this.CurrentBuilder.Append("{");
		for (int i = 0; i < LibZen.ListSize(Node.NodeList); i++) {
			if(i != 0) {
				this.CurrentBuilder.Append(", ");
			}
			Node.NodeList.get(i).Accept(this);
		}
		this.CurrentBuilder.Append("}");
	}

//	@Override public void VisitMapLiteralNode(ZenMapLiteralNode Node) {
//		this.VisitingBuilder.Append("");
//	}

	@Override public void VisitParamNode(ZenParamNode Node) {
		this.CurrentBuilder.Append("");
	}

//	@Override public void VisitFunctionNode(ZenFunctionNode Node) {
//		this.VisitingBuilder.Append("");
//	}

	@Override public void VisitGetLocalNode(ZenGetLocalNode Node) {
		this.CurrentBuilder.Append("$" + Node.NativeName);
	}

	@Override public void VisitSetLocalNode(ZenSetLocalNode Node) {
		this.CurrentBuilder.Append(Node.NativeName + " = ");
		Node.ValueNode.Accept(this);
	}

	@Override public void VisitGetCapturedNode(ZenGetCapturedNode Node) {
		this.CurrentBuilder.Append("__env->" + Node.NativeName);
	}

	@Override public void VisitSetCapturedNode(ZenSetCapturedNode Node) {
		this.CurrentBuilder.Append("__env->" + Node.NativeName + " = ");
		Node.ValueNode.Accept(this);
	}

	@Override public void VisitGetterNode(ZenGetterNode Node) {
		@Var String FieldName = Node.NativeName;
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append("->{'" + FieldName + "'}");
	}

	@Override public void VisitSetterNode(ZenSetterNode Node) {
		@Var String FieldName = Node.NativeName;
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append("->{'" + FieldName + "'} = ");
		Node.ValueNode.Accept(this);
	}

	@Override public void VisitApplySymbolNode(ZenApplySymbolNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append("(");
		for(@Var int i = 0; i < LibZen.ListSize(Node.ParamList); i++){
			if(i > 0){
				this.CurrentBuilder.Append(", ");
			}
			Node.ParamList.get(i).Accept(this);
		}
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitApplyFunctionObjectNode(ZenApplyFunctionObjectNode Node) {
		//FIXME
		Node.FuncNode.Accept(this);
		this.CurrentBuilder.Append("(");
		for(@Var int i = 0; i < LibZen.ListSize(Node.ParamList); i++){
			if(i > 0){
				this.CurrentBuilder.Append(", ");
			}
			Node.ParamList.get(i).Accept(this);
		}
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitApplyOverridedMethodNode(ZenApplyOverridedMethodNode Node) {
		//FIXME
		this.CurrentBuilder.Append(Node.Func.FuncName);
		this.CurrentBuilder.Append("(");
		for(@Var int i = 0; i < LibZen.ListSize(Node.ParamList); i++){
			if(i > 0){
				this.CurrentBuilder.Append(", ");
			}
			Node.ParamList.get(i).Accept(this);
		}
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitGetIndexNode(ZenGetIndexNode Node) {
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append("[");
		Node.IndexNode.Accept(this);
		this.CurrentBuilder.Append("]");
	}

	@Override public void VisitSetIndexNode(ZenSetIndexNode Node) {
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append("[");
		Node.IndexNode.Accept(this);
		this.CurrentBuilder.Append("] = ");
		Node.ValueNode.Accept(this);
	}

	@Override public void VisitSliceNode(ZenSliceNode Node) {
		this.CurrentBuilder.Append("GT_Slice(");
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append(", ");
		Node.Index1.Accept(this);
		this.CurrentBuilder.Append(", ");
		Node.Index2.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		this.CurrentBuilder.Append("(");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" && ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitOrNode(ZenOrNode Node) {
		this.CurrentBuilder.Append("(");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" || ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(Node.NativeName);
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitPrefixInclNode(ZenPrefixInclNode Node) {
		this.CurrentBuilder.Append("(++");
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitPrefixDeclNode(ZenPrefixDeclNode Node) {
		this.CurrentBuilder.Append("(--");
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitSuffixInclNode(ZenSuffixInclNode Node) {
		this.CurrentBuilder.Append("(");
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append("++)");
	}

	@Override public void VisitSuffixDeclNode(ZenSuffixDeclNode Node) {
		this.CurrentBuilder.Append("(");
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append("--)");
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		this.CurrentBuilder.Append("(");
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append(" " + Node.NativeName + " ");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
		this.CurrentBuilder.Append("(");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append(") ? (");
		Node.ThenNode.Accept(this);
		this.CurrentBuilder.Append(") : (");
		Node.ElseNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitConstructorNode(ZenConstructorNode Node) {
		this.CurrentBuilder.Append(Node.Func.FuncName);
		this.CurrentBuilder.Append("(");
		for(@Var int i = 0; i < LibZen.ListSize(Node.ParamList); i++){
			if(i > 0){
				this.CurrentBuilder.Append(", ");
			}
			Node.ParamList.get(i).Accept(this);
		}
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitAllocateNode(ZenAllocateNode Node) {
		this.CurrentBuilder.Append(GetLocalType(Node.Type, false) + "->new()");
	}

	@Override public void VisitNewArrayNode(ZenNewArrayNode Node) {
		throw new RuntimeException("NOT Implemented");
//		this.VisitingBuilder.Append("NEWARRAY_" + GetLocalType(Node.Type, false) + "(");
//		for (int i = 0; i < LibZen.ListSize(Node.NodeList); i++) {
//			if(i > 0) {
//				this.VisitingBuilder.Append(", ");
//			}
//			Node.NodeList.get(i).Accept(this);
//		}
//		this.VisitingBuilder.Append(")");
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		this.CurrentBuilder.Append("InstanceOf(");
		Node.ExprNode.Accept(this);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append(GetLocalType(Node.TypeInfo, false).toString());
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitCastNode(ZenCastNode Node) {
		this.CurrentBuilder.Append("Cast(");
		Node.Expr.Accept(this);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append(GetLocalType(Node.CastType, false).toString());
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		@Var String VarName = Node.NativeName;
		this.CurrentBuilder.Append("my $" + VarName);
		if(Node.InitNode != null) {
			this.CurrentBuilder.Append(" = ");
			Node.InitNode.Accept(this);
		}
		this.CurrentBuilder.AppendLine(this.SemiColon);
		this.CurrentBuilder.AppendIndent();
		this.VisitIndentBlock("{", Node.BlockNode, "}");
	}

	@Override public void VisitUsingNode(ZenUsingNode Node) {
		throw new RuntimeException("FIXME");
	}

	@Override public void VisitIfNode(ZenIfNode Node) {
		this.CurrentBuilder.Append("if(");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append(")");
		this.VisitIndentBlock("{", Node.ThenNode, "}");
		if(Node.ElseNode != null) {
			this.CurrentBuilder.Append("else");
			this.VisitIndentBlock("{", Node.ElseNode, "}");
		}
	}

	@Override public void VisitWhileNode(ZenWhileNode Node) {
		this.CurrentBuilder.Append("while(");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append(")");
		this.VisitIndentBlock("{", Node.BodyNode, "}");
	}

	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
		this.CurrentBuilder.Append("do ");
		this.VisitIndentBlock("{", Node.BodyNode, "}");
		this.CurrentBuilder.Append("while(");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitForNode(ZenForNode Node) {
		this.CurrentBuilder.Append("for(;");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append(";");
		Node.IterNode.Accept(this);
		this.CurrentBuilder.Append(") ");
		this.VisitIndentBlock("{", Node.BodyNode, "}");
	}

	@Override public void VisitForEachNode(ZenForEachNode Node) {
		Node.Variable.Accept(this);
		this.CurrentBuilder.Append("while(");
		Node.IterNode.Accept(this);
		this.CurrentBuilder.Append(")");
		this.VisitIndentBlock("{", Node.BodyNode, "}");	}

	@Override public void VisitContinueNode(ZenContinueNode Node) {
		this.CurrentBuilder.Append("next");
		if(Node.Label != null) {
			this.CurrentBuilder.Append(" " + Node.Label);
		}
	}

	@Override public void VisitBreakNode(ZenBreakNode Node) {
		this.CurrentBuilder.Append("last");
		if(Node.Label != null) {
			this.CurrentBuilder.Append(" " + Node.Label);
		}
	}

	@Override public void VisitStatementNode(ZenStatementNode Node) {
		Node.ValueNode.Accept(this);
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		this.CurrentBuilder.Append("return ");
		if(Node.ValueNode != null) {
			Node.ValueNode.Accept(this);
		}
		this.StopVisitor(Node);
	}

	@Override public void VisitYieldNode(ZenYieldNode Node) {
		this.CurrentBuilder.Append("yield ");
		Node.ValueNode.Accept(this);
		this.StopVisitor(Node);
	}

	@Override public void VisitThrowNode(ZenThrowNode Node) {
		this.CurrentBuilder.Append("throw ");
		Node.ValueNode.Accept(this);
		this.StopVisitor(Node);
	}

	@Override public void VisitTryNode(ZenTryNode Node) {
		this.CurrentBuilder.Append("try ");
		this.VisitIndentBlock("{", Node.TryNode, "}");
		for (int i = 0; i < LibZen.ListSize(Node.CatchList); i++) {
			Node.CatchList.get(i).Accept(this);
		}
		if(Node.FinallyNode != null) {
			this.CurrentBuilder.Append("finally ");
			this.VisitIndentBlock("{", Node.FinallyNode, "}");
		}
	}

	@Override public void VisitCatchNode(ZenCatchNode Node) {
		this.CurrentBuilder.AppendLine(" catch " + Node.ExceptionType + " with {");
		this.CurrentBuilder.AppendLine(" my $" + Node.ExceptionName + " = shift;");
		this.VisitIndentBlock("{", Node.BodyNode, "}");
		this.CurrentBuilder.AppendLine("}");
	}

	@Override public void VisitSwitchNode(ZenSwitchNode Node) {
		this.CurrentBuilder.Append("switch (");
		Node.MatchNode.Accept(this);
		this.CurrentBuilder.AppendLine(") {");
		for (@Var int i = 0; i < LibZen.ListSize(Node.CaseList); i++) {
			Node.CaseList.get(i).Accept(this);
		}
		this.CurrentBuilder.AppendLine("}");
	}

	@Override public void VisitCaseNode(ZenCaseNode Node) {
		this.CurrentBuilder.Append("case ");
		Node.CaseNode.Accept(this);
		this.CurrentBuilder.Append(" : ");
		this.VisitIndentBlock("{", Node.BodyNode, "}");
	}

	@Override public void VisitCommandNode(ZenCommandNode Node) {
		this.CurrentBuilder.Append("String __Command = ");
		for(@Var int i = 0; i < LibZen.ListSize(Node.ArgumentList); i += 1) {
			@Var ZenNode Param = Node.ArgumentList.get(i);
			if(i != 0) {
				this.CurrentBuilder.Append(" . ");
			}
			this.CurrentBuilder.Append("(");
			Param.Accept(this);
			this.CurrentBuilder.Append(")");
		}
		this.CurrentBuilder.AppendLine(this.SemiColon);
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("system(__Command)");
	}

	@Override public void VisitErrorNode(ZenErrorNode Node) {
		@Var String Code = "throw Error(\"" + Node.SourceToken.ParsedText + "\")";
		this.CurrentBuilder.Append(Code);
		this.StopVisitor(Node);
	}

	@Override public void GenerateFunc(ZenFunc Func, ArrayList<String> ParamNameList, ZenNode Body) {
		this.FlushErrorReport();
		@Var String FuncName = Func.GetNativeFuncName();
		this.CurrentBuilder.AppendLine("sub " + FuncName + " {");
		this.CurrentBuilder.Indent();
		for(@Var int i = 0; i < LibZen.ListSize(ParamNameList); i += 1) {
			this.CurrentBuilder.AppendLine("my $" + ParamNameList.get(i) + " = $_[" + i + "];");
		}
		this.CurrentBuilder.UnIndent();
		this.VisitIndentBlock("", Body, "");
	}

	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {
		@Var String TypeName = Type.ShortName;
		this.CurrentBuilder.AppendLine("package " + TypeName + this.SemiColon);
		if(Type.SuperType != null) {
			this.CurrentBuilder.AppendLine("# our @ISA = ('" + Type.SuperType.ShortName + "');" + this.SemiColon);
		}
		this.CurrentBuilder.AppendLine("sub new {");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLine("my $class = shift" + this.SemiColon);
		this.CurrentBuilder.AppendLine("my $" + this.GetRecvName() + " = {}" + this.SemiColon);
		for(@Var int i = 0; i < LibZen.ListSize(ClassField.FieldList); i += 1) {
			@Var ZenFieldInfo FieldInfo = ClassField.FieldList.get(i);
			@Var String InitValue = this.StringifyConstValue(FieldInfo.InitValue);
			if(!FieldInfo.Type.IsNativeType()) {
				InitValue = this.NullLiteral;
			}
			this.CurrentBuilder.AppendLine("$" + this.GetRecvName() + "->{'" + FieldInfo.NativeName + "'} = " + InitValue + this.SemiColon);
		}
		this.CurrentBuilder.AppendLine("return bless $" + this.GetRecvName() + ", $class");
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLine("}");
		this.CurrentBuilder.AppendLine("package main;");
	}

	@Override public void InvokeMainFunc(String MainFuncName) {
		this.CurrentBuilder = this.NewSourceBuilder();
		this.CurrentBuilder.Append(MainFuncName);
		this.CurrentBuilder.AppendLine("();");
	}
}