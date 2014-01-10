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
package org.GreenTeaScript;
import java.util.ArrayList;

import parser.GreenTeaConsts;
import parser.GreenTeaUtils;
import parser.ZenClassField;
import parser.ZenFieldInfo;
import parser.ZenFunc;
import parser.ZenNameSpace;
import parser.ZenStaticTable;
import parser.ZenSyntaxTree;
import parser.ZenType;
import parser.ast.ZenAndNode;
import parser.ast.ZenApplySymbolNode;
import parser.ast.ZenBinaryNode;
import parser.ast.ZenBreakNode;
import parser.ast.ZenCommandNode;
import parser.ast.ZenErrorNode;
import parser.ast.ZenForEachNode;
import parser.ast.ZenForNode;
import parser.ast.ZenGetIndexNode;
import parser.ast.ZenGetLocalNode;
import parser.ast.ZenGetterNode;
import parser.ast.ZenIfNode;
import parser.ast.ZenNode;
import parser.ast.ZenNullNode;
import parser.ast.ZenOrNode;
import parser.ast.ZenReturnNode;
import parser.ast.ZenSetLocalNode;
import parser.ast.ZenSwitchNode;
import parser.ast.ZenThrowNode;
import parser.ast.ZenTrinaryNode;
import parser.ast.ZenTryNode;
import parser.ast.ZenUnaryNode;
import parser.ast.ZenVarDeclNode;
import parser.ast.ZenWhileNode;
import parser.deps.LibGreenTea;
//endif VAJA

//GreenTea Generator should be written in each language.

public class BashSourceGenerator extends SourceGenerator {
	/*field*/boolean inFunc = false;
	/*field*/boolean inMainFunc = false;

	public BashSourceGenerator/*constructor*/(String TargetCode, String OutputFile, int GeneratorFlag) {
		super(TargetCode, OutputFile, GeneratorFlag);
		this.TrueLiteral  = "0";
		this.FalseLiteral = "1";
		this.NullLiteral = LibGreenTea.QuoteString("__NULL__");
		this.MemberAccessOperator = "__MEMBER__";
		this.LineComment = "##";
		this.ParameterBegin = " ";
		this.ParameterEnd = "";
		this.ParameterDelimiter = "";
	}

	@Override public void InitContext(ZenNameSpace Context) {
		super.InitContext(Context);
		this.WriteLineHeader("#!/bin/bash");
		this.WriteLineCode(this.LineFeed + "source $GREENTEA_HOME/include/bash/GreenTeaPlus.sh" + this.LineFeed);
	}

	@Override public String VisitBlockWithIndent(ZenNode Node, boolean NeedBlock) {
		return this.VisitBlockWithOption(Node, true, NeedBlock, false);	//actually NeedBlock -> allowDummyBlock
	}

	private String VisitBlockWithReplaceBreak(ZenNode Node, boolean allowDummyBlock) {
		return this.VisitBlockWithOption(Node, true, allowDummyBlock, true);
	}

	private String VisitBlockWithoutIndent(ZenNode Node, boolean allowDummyBlock) {
		return this.VisitBlockWithOption(Node, false, allowDummyBlock, false);
	}

	private String VisitBlockWithOption(ZenNode Node, boolean inBlock, boolean allowDummyBlock, boolean replaceBreak) {
		/*local*/String Code = "";
		/*local*/boolean isBreakReplaced = false;
		if(inBlock) {
			this.Indent();
		}
		/*local*/ZenNode CurrentNode = Node;
		if(this.IsEmptyBlock(Node) && allowDummyBlock) {
			Code += this.GetIndentString() + "echo dummy block!! &> /dev/zero" + this.LineFeed;
		}
		while(!this.IsEmptyBlock(CurrentNode)) {
			/*local*/String poppedCode = this.VisitNode(CurrentNode);
			if(replaceBreak && CurrentNode instanceof ZenBreakNode) {
				isBreakReplaced = true;
				poppedCode = ";;";
			}
			if(!LibGreenTea.EqualsString(poppedCode, "")) {
				Code += this.GetIndentString() + poppedCode + this.LineFeed;
			}
			CurrentNode = CurrentNode.NextNode;
		}
		if(replaceBreak && !isBreakReplaced) {
			Code += this.GetIndentString() + ";&" + this.LineFeed;
		}
		if(inBlock) {
			this.UnIndent();
			Code += this.GetIndentString();
		}
		else {
			if(Code.length() > 0) {
				Code = LibGreenTea.SubString(Code, 0, Code.length() - 1);
			}
		}
		return Code;
	}

	@Override public ZenNode CreateDoWhileNode(ZenType Type, ZenSyntaxTree ParsedTree, ZenNode Cond, ZenNode Block) {
		/*
		 * do { Block } while(Cond)
		 * => boolean firstCond = true; while(firstCond || Cond) {firstCond = false; Block; }
		 *
		 */
		/*local*/ZenType BoolType = ZenStaticTable.BooleanType;
		/*local*/String VarName = "FirstCond";
		/*local*/ZenNode TrueNode = this.CreateBooleanNode(BoolType, ParsedTree, true);
		/*local*/ZenNode FalseNode = this.CreateBooleanNode(BoolType, ParsedTree, false);

		/*local*/ZenNode FirstCond = this.CreateGetLocalNode(BoolType, ParsedTree, VarName);
		/*local*/ZenNode NewCond = this.CreateOrNode(BoolType, ParsedTree, FirstCond, Cond);
		/*local*/ZenNode BodyNode = this.CreateSetLocalNode(BoolType, ParsedTree, VarName, FalseNode);

		ZenNode.LinkNode(BodyNode.MoveTailNode(), Block);
		/*local*/ZenNode NewWhileNode = this.CreateWhileNode(Type, ParsedTree, NewCond, BodyNode);
		return this.CreateVarDeclNode(BoolType, ParsedTree, BoolType, VarName, TrueNode, NewWhileNode);
	}

	private String ResolveCondition(ZenNode Node) {
		/*local*/String Cond = this.VisitNode(Node);
		if(LibGreenTea.EqualsString(Cond, this.TrueLiteral)) {
			Cond = "((1 == 1))";
		}
		else if(LibGreenTea.EqualsString(Cond, this.FalseLiteral)) {
			Cond = "((1 != 1))";
		}
		else {
			if(Node instanceof ZenGetLocalNode) {
				Cond = "((0 == " + this.ResolveValueType(Node, false) + "))";
			}
		}
		return Cond;
	}

	@Override public void VisitWhileNode(ZenWhileNode Node) {
		/*local*/String Program = "while " + this.ResolveCondition(Node.CondNode) + " ;do" + this.LineFeed;
		Program += this.VisitBlockWithIndent(Node.BodyNode, true) + "done";
		this.PushSourceCode(Program);
	}

	@Override public void VisitForNode(ZenForNode Node) {
		/*local*/String Cond = this.ResolveCondition(Node.CondNode);
		/*local*/String Iter = this.VisitNode(Node.IterNode);
		/*local*/String Program = "for((; " + Cond  + "; " + Iter + " )) ;do" + this.LineFeed;
		Program += this.VisitBlockWithIndent(Node.BodyNode, true) + "done";
		this.PushSourceCode(Program);
	}

	@Override public void VisitForEachNode(ZenForEachNode Node) {
		/*local*/String Variable = this.VisitNode(Node.Variable);
		/*local*/String Iter = this.VisitNode(Node.IterNode);
		/*local*/String Program = "for " + Variable + " in " + "${" + Iter + "[@]} ;do" + this.LineFeed;
		Program += this.VisitBlockWithIndent(Node.BodyNode, true) + "done";
		this.PushSourceCode(Program);
	}

	private String[] MakeParamCode(ArrayList<ZenNode> ParamList, boolean isAssert) {
		/*local*/int Size = LibZen.ListSize(ParamList);
		/*local*/String[] ParamCode = new String[Size];
		/*local*/int i = 0;
		while(i < Size) {
			/*local*/ZenNode ParamNode = ParamList.get(i);
			if(isAssert) {
				ParamCode[i] = this.ResolveCondition(ParamNode);
			}
			else {
				ParamCode[i] = this.ResolveValueType(ParamNode, false);
			}
			i = i + 1;
		}
		return ParamCode;
	}

	private boolean FindAssert(ZenFunc Func) {
		/*local*/boolean isAssert = false;
		if(Func != null && Func.Is(GreenTeaConsts.NativeMacroFunc)) {
			if(LibGreenTea.EqualsString(Func.FuncName, "assert")) {
				isAssert = true;
			}
		}
		return isAssert;
	}

	@Override public void VisitApplySymbolNode(ZenApplySymbolNode Node) {
		/*local*/int ParamSize = LibZen.ListSize(Node.ParamList);
		/*local*/String Template = this.GenerateFuncTemplate(ParamSize, Node.ResolvedFunc);
		/*local*/boolean isAssert = this.FindAssert(Node.ResolvedFunc);
		if(isAssert) {
			Template = "assert " + LibGreenTea.QuoteString("$1");
		}
		/*local*/String[] ParamCode = this.MakeParamCode(Node.ParamList, isAssert);
		this.PushSourceCode(this.ApplyMacro2(Template, ParamCode));
	}

	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		/*local*/String FuncName = Node.SourceToken.ParsedText;
		/*local*/ZenFunc Func = Node.ResolvedFunc;
		/*local*/String Expr = this.ResolveValueType(Node.RecvNode, false);	//TODO: support ++ --
		/*local*/String Macro = null;
		if(Func != null) {
			FuncName = Func.GetNativeFuncName();
			if(GreenTeaUtils.IsFlag(Func.FuncFlag, GreenTeaConsts.NativeMacroFunc)) {
				Macro = Func.GetNativeMacro();
			}
		}
		if(Macro == null) {
			Macro = "((" + FuncName + " $1))";
		}
		this.PushSourceCode(Macro.replace("$1", Expr));
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		/*local*/String FuncName = Node.SourceToken.ParsedText;
		/*local*/ZenFunc Func = Node.ResolvedFunc;
		/*local*/String Left = this.ResolveValueType(Node.LeftNode, false);
		/*local*/String Right = this.ResolveValueType(Node.RightNode, false);
		/*local*/String Macro = null;
		if(Func != null) {
			FuncName = Func.GetNativeFuncName();
			if(GreenTeaUtils.IsFlag(Func.FuncFlag, GreenTeaConsts.NativeMacroFunc)) {
				Macro = Func.GetNativeMacro();
			}
		}
		if(Macro == null) {
			Macro = "(($1 " + FuncName + " $2))";
		}
		this.PushSourceCode(Macro.replace("$1", Left).replace("$2", Right));
	}

	private String GetMemberIndex(ZenType ClassType, String MemberName) {
		return "$" + ClassType.ShortName + this.MemberAccessOperator + MemberName;
	}

	private boolean IsNativeType(ZenType Type) {
		if(Type != null && Type.IsNativeType()) {
			return true;
		}
		return false;
	}

	@Override public void VisitGetterNode(ZenGetterNode Node) {
		this.PushSourceCode(this.VisitNode(Node.RecvNode) + "[" + this.GetMemberIndex(Node.RecvNode.Type, Node.ResolvedFunc.FuncName) + "]");
	}

	@Override public void VisitGetIndexNode(ZenGetIndexNode Node) {
		this.PushSourceCode(this.VisitNode(Node.RecvNode) + "[" + this.ResolveValueType(Node.GetAt(0), false) + "]");
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		this.PushSourceCode("(" + this.ResolveCondition(Node.LeftNode) + " && " + this.ResolveCondition(Node.RightNode) + ")");
	}

	@Override public void VisitOrNode(ZenOrNode Node) {
		this.PushSourceCode("(" + this.ResolveCondition(Node.LeftNode) + " || " + this.ResolveCondition(Node.RightNode) + ")");
	}

	@Override public void VisitSetLocalNode(ZenSetLocalNode Node) {
		this.PushSourceCode(Node.NativeName + "=" + this.ResolveValueType(Node.ValueNode, true));
	}

//	@Override public void VisitSelfAssignNode(ZenSelfAssignNode Node) {
//		/*local*/String FuncName = Node.SourceToken.ParsedText;
//		/*local*/ZenFunc Func = Node.Func;
//		/*local*/String Left = this.VisitNode(Node.LeftNode);
//		/*local*/String Right = this.ResolveValueType(Node.RightNode, false);
//		/*local*/String Macro = null;
//		if(Func != null) {
//			FuncName = Func.GetNativeFuncName();
//			if(IsFlag(Func.FuncFlag, NativeMacroFunc)) {
//				Macro = Func.GetNativeMacro();
//			}
//		}
//		if(Macro == null) {
//			Macro = "(($1 " + FuncName + " $2))";
//		}
//		this.PushSourceCode(Macro.replace("$1", Left).replace("$2", Right));
//	}

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		/*local*/String VarName = Node.NativeName;
		/*local*/String Declare = "declare ";
		/*local*/String Option = "";
		if(this.inFunc) {
			Declare = "local ";
		}
		if(!this.IsNativeType(Node.DeclType)) {
			Option = "-a ";
		}

		/*local*/String Code = Declare + Option + VarName + this.LineFeed;
		Code += this.GetIndentString() + VarName;
		if(Node.InitNode != null) {
			Code += "=" + this.ResolveValueType(Node.InitNode, true);
		}
		Code +=  this.LineFeed;
		this.PushSourceCode(Code + this.VisitBlockWithoutIndent(Node.BlockNode, false));
	}

	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
		/*local*/String CondNode = this.ResolveCondition(Node.CondNode);
		/*local*/String Then = this.ResolveValueType(Node.ThenNode, false);
		/*local*/String Else = this.ResolveValueType(Node.ElseNode, false);
		this.PushSourceCode("((" + CondNode + " ? " + Then + " : " + Else + "))");
	}

	@Override public void VisitIfNode(ZenIfNode Node) {
		/*local*/String CondNode = this.ResolveCondition(Node.CondNode);
		/*local*/String ThenBlock = this.VisitBlockWithIndent(Node.ThenNode, true);
		/*local*/String Code = "if " + CondNode + " ;then" + this.LineFeed + ThenBlock;
		if(!this.IsEmptyBlock(Node.ElseNode)) {
			Code += "else" + this.LineFeed + this.VisitBlockWithIndent(Node.ElseNode, false);
		}
		Code += "fi";
		this.PushSourceCode(Code);
	}

	@Override public void VisitSwitchNode(ZenSwitchNode Node) {
		/*local*/String Match = this.ResolveValueType(Node.MatchNode, false);
		/*local*/String Code = "case " + Match + " in" + this.LineFeed + this.GetIndentString();
		/*local*/int i = 0;
		while(i < LibZen.ListSize(Node.CaseList)) {
			/*local*/ZenNode Case  = Node.CaseList.get(i);
			/*local*/ZenNode Block = Node.CaseList.get(i+1);
			Code += this.VisitNode(Case) + ")" + this.LineFeed;
			Code += this.VisitBlockWithReplaceBreak(Block, true);
			i = i + 2;
		}
		if(Node.DefaultBlock != null) {
			Code += "*)" + this.LineFeed;
			Code += this.VisitBlockWithReplaceBreak(Node.DefaultBlock, false);
		}
		Code += "esac";
		this.PushSourceCode(Code);
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		if(!this.inFunc) {
			return;
		}

		if(Node.ValueNode != null) {
			/*local*/String Ret = this.ResolveValueType(Node.ValueNode, false);
			if(Node.Type.IsBooleanType() || (Node.Type.IsIntType() && this.inMainFunc)) {
				this.PushSourceCode("return " + Ret);
				return;
			}
			this.PushSourceCode("echo " + Ret + this.LineFeed + this.GetIndentString() + "return 0");
			return;
		}
		this.PushSourceCode("return 0");
	}

	@Override public void VisitTryNode(ZenTryNode Node) {
		throw new RuntimeException("FIXME support Try-catch @ BashSourceGenerator");
//		/*local*/ZenNode TrueNode = new ZenConstPoolNode(ZenStaticTable.BooleanType, null, true);
//		/*local*/String Code = "trap ";
//		/*local*/String Try = this.VisitNode(new ZenIfNode(null, null, TrueNode, Node.TryNode, null));
//		/*local*/String Catch = this.VisitNode(new ZenIfNode(null, null, TrueNode, Node.CatchBlock, null));
//		Code += LibGreenTea.QuoteString(Catch) + " ERR" + this.LineFeed;
//		Code += this.GetIndentString() + Try + this.LineFeed + this.GetIndentString() + "trap ERR";
//		if(Node.FinallyNode != null) {
//			/*local*/String Finally = this.VisitNode(new ZenIfNode(null, null, TrueNode, Node.FinallyNode, null));
//			Code += this.LineFeed + this.GetIndentString() + Finally;
//		}
//		this.PushSourceCode(Code);
	}

	@Override public void VisitThrowNode(ZenThrowNode Node) {
		this.PushSourceCode("kill &> /dev/zero");
	}

	@Override public void VisitErrorNode(ZenErrorNode Node) {
		this.PushSourceCode("echo " + LibGreenTea.QuoteString(Node.SourceToken.ParsedText) + " >&2");
	}

	@Override public void VisitCommandNode(ZenCommandNode Node) {
		/*local*/String Code = "";
		/*local*/int count = 0;
		/*local*/ZenType Type = Node.Type;
		/*local*/ZenCommandNode CurrentNode = Node;
		while(CurrentNode != null) {
			if(count > 0) {
				Code += " | ";
			}
			Code += this.AppendCommand(CurrentNode);
			CurrentNode = (/*cast*/ZenCommandNode) CurrentNode.PipedNextNode;
			count += 1;
		}

		if(Type.IsStringType()) {
			Code = "execCommadString " + LibGreenTea.QuoteString(Code);
		}
		else if(Type.IsBooleanType()) {
			Code = "execCommadBool " + LibGreenTea.QuoteString(Code);
		}
		this.PushSourceCode(Code);
	}

	private String AppendCommand(ZenCommandNode CurrentNode) {
		/*local*/String Code = "";
		/*local*/int size = LibZen.ListSize(CurrentNode.ArgumentList);
		/*local*/int i = 0;
		while(i < size) {
			Code += this.ResolveValueType(CurrentNode.ArgumentList.get(i), false) + " ";
			i = i + 1;
		}
		return Code;
	}

	private boolean CheckConstFolding(ZenNode TargetNode) {
		if(TargetNode.IsConstNode()) {
			return true;
		}
		else if(TargetNode instanceof ZenUnaryNode) {
			/*local*/ZenUnaryNode Unary = (/*cast*/ZenUnaryNode) TargetNode;
			return this.CheckConstFolding(Unary.RecvNode);
		}
		else if(TargetNode instanceof ZenBinaryNode) {
			/*local*/ZenBinaryNode Binary = (/*cast*/ZenBinaryNode) TargetNode;
			if(this.CheckConstFolding(Binary.LeftNode) && this.CheckConstFolding(Binary.RightNode)) {
				return true;
			}
		}
		return false;
	}

	private String ResolveValueType(ZenNode TargetNode, boolean isAssign) {
		/*local*/String ResolvedValue;
		/*local*/String Value = this.VisitNode(TargetNode);
		/*local*/ZenType Type = TargetNode.Type;

		// resolve constant folding
		if(this.CheckConstFolding(TargetNode)) {
			return Value;
		}

		// resolve boolean function
		if(Type != null && Type.IsBooleanType()) {
//			if(TargetNode instanceof ZenApplyNode || TargetNode instanceof ZenUnaryNode ||
//					TargetNode instanceof ZenCommandNode || TargetNode instanceof ZenBinaryNode) {
//				return "$(valueOfBool " + LibGreenTea.QuoteString(Value) + ")";
//			}
		}

		if(TargetNode.IsConstNode() || TargetNode instanceof ZenNullNode) {
			return Value;
		}
		else if(TargetNode instanceof ZenGetIndexNode || TargetNode instanceof ZenGetterNode) {
			ResolvedValue = "${" + Value + "}";
		}
//		else if(TargetNode instanceof ZenApplyNode || TargetNode instanceof ZenCommandNode || TargetNode instanceof ZenConstructorNode) {
//			ResolvedValue = "$(" + Value + ")";
//		}
		else if(TargetNode instanceof ZenGetLocalNode && !this.IsNativeType(Type)) {
			/*local*/ZenGetLocalNode Local = (/*cast*/ZenGetLocalNode) TargetNode;
			/*local*/String Name = Local.NativeName;
			ResolvedValue = "${" + Value + "[@]}";
			if(Name.length() == 1 && LibGreenTea.IsDigit(Name, 0)) {
				ResolvedValue = "$" + Value;
			}
		}
		else {
			ResolvedValue = "$" + Value;
		}

		// resolve assigned object
		if(isAssign) {
			if(!this.IsNativeType(Type)) {
				ResolvedValue = "(" + ResolvedValue + ")";
				return ResolvedValue;
			}
		}

		// resolve string and object value
		if(Type != null) {
			if(Type.IsStringType() || !this.IsNativeType(Type)) {
				ResolvedValue = LibGreenTea.QuoteString(ResolvedValue);
			}
		}
		return ResolvedValue;
	}

	@Override public void GenerateFunc(ZenFunc Func, ArrayList<String> ParamNameList, ZenNode Body) {
		this.FlushErrorReport();
		/*local*/String Function = "";
		/*local*/String FuncName = Func.GetNativeFuncName();
		this.inFunc = true;
		if(LibGreenTea.EqualsString(FuncName, "main")) {
			this.inMainFunc = true;
		}
		Function += FuncName + "() {" + this.LineFeed;
		this.Indent();

		/*local*/int i = 0;
		while(i < ParamNameList.size()) {
			/*local*/ZenType ParamType = Func.GetFuncParamType(i);
			// "local -a x"
			Function += this.GetIndentString() + "local ";
			if(!this.IsNativeType(ParamType)) {
				Function += "-a ";
			}
			Function += ParamNameList.get(i) + ";" + this.LineFeed + this.GetIndentString();
			// "x = $1"
			Function += ParamNameList.get(i) + "=$" + (i + 1) + ";" + this.LineFeed;
			i = i + 1;
		}

		Function += this.VisitBlockWithoutIndent(Body, true) + this.LineFeed;
		this.UnIndent();
		Function += this.GetIndentString() + "}" + this.LineFeed;
		this.WriteLineCode(Function);
		this.inFunc = false;
		this.inMainFunc = false;
	}

	@Override protected String GetNewOperator(ZenType Type) {
		return LibGreenTea.QuoteString("$(__NEW__" + Type.ShortName + ")");
	}

	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {	//TODO: support super
		/*local*/String Program = "__NEW__" + Type.ShortName + "() {" + this.LineFeed;
		this.WriteLineCode("#### define class " + Type.ShortName + " ####");
		this.Indent();
		Program += this.GetIndentString() + "local -a " + this.GetRecvName() + this.LineFeed;

		/*local*/int i = 0;
		while(i < LibZen.ListSize(ClassField.FieldList)) {
			/*local*/ZenFieldInfo FieldInfo = ClassField.FieldList.get(i);
			/*local*/String InitValue = this.StringifyConstValue(FieldInfo.InitValue);
			if(!FieldInfo.Type.IsNativeType()) {
				InitValue = "NULL";
			}
			this.WriteLineCode(Type.ShortName + this.MemberAccessOperator + FieldInfo.NativeName + "=" + i);

			Program += this.GetIndentString() + this.GetRecvName();
			Program += "[" + this.GetMemberIndex(Type, FieldInfo.NativeName) + "]=" + InitValue + this.LineFeed;
			i = i + 1;
		}
		Program += this.GetIndentString() + "echo ";
		Program += LibGreenTea.QuoteString("${" + this.GetRecvName() + "[@]}") + this.LineFeed;
		this.UnIndent();
		Program += "}";

		this.WriteLineCode(this.LineFeed + Program);
	}

	@Override public void InvokeMainFunc(String MainFuncName) {
		this.WriteLineCode(MainFuncName);
	}
}