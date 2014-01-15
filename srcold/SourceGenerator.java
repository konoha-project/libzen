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
package org.ZenScript;
import java.util.ArrayList;
//endif VAJA


import parser.ZenFunc;
import parser.ZenGenerator;
import parser.ZenNameSpace;
import parser.ZenType;
import parser.ast.ZenAllocateNode;
import parser.ast.ZenAndNode;
import parser.ast.ZenApplySymbolNode;
import parser.ast.ZenBinaryNode;
import parser.ast.ZenBreakNode;
import parser.ast.ZenConstPoolNode;
import parser.ast.ZenConstructorNode;
import parser.ast.ZenContinueNode;
import parser.ast.ZenEmptyNode;
import parser.ast.ZenGetLocalNode;
import parser.ast.ZenGetterNode;
import parser.ast.ZenInstanceOfNode;
import parser.ast.ZenNewArrayNode;
import parser.ast.ZenNode;
import parser.ast.ZenNullNode;
import parser.ast.ZenOrNode;
import parser.ast.ZenReturnNode;
import parser.ast.ZenSetLocalNode;
import parser.ast.ZenSetterNode;
import parser.ast.ZenSwitchNode;
import parser.ast.ZenTrinaryNode;
import parser.ast.ZenUnaryNode;
import parser.deps.ZenEnum;
import parser.deps.LibZen;
import parser.deps.LibNative;

@Deprecated
public class SourceGenerator extends ZenGenerator {
	@Field protected String    HeaderSource;
	@Field protected String    BodySource;

	@Field protected String    Tab;
	@Field protected String    LineFeed;
	@Field protected int       IndentLevel;
	@Field protected String    CurrentLevelIndentString;

	@Field protected boolean   HasLabelSupport;
	@Field protected String    LogicalOrOperator;
	@Field protected String    LogicalAndOperator;
	@Field protected String    MemberAccessOperator;
	@Field protected String    TrueLiteral;
	@Field protected String    FalseLiteral;
	@Field protected String    NullLiteral;
	@Field protected String    LineComment;
	@Field protected String    BreakKeyword;
	@Field protected String    ContinueKeyword;
	@Field protected String    ParameterBegin;
	@Field protected String    ParameterEnd;
	@Field protected String    ParameterDelimiter;
	@Field protected String    SemiColon;
	@Field protected String    BlockBegin;
	@Field protected String    BlockEnd;

	public SourceGenerator/*constructor*/(String TargetCode, String OutputFile, int GeneratorFlag) {
		super(TargetCode, OutputFile, GeneratorFlag);
		this.LineFeed = "\n";
		this.IndentLevel = 0;
		this.Tab = "   ";
		this.CurrentLevelIndentString = null;
		this.HeaderSource = "";
		this.BodySource = "";
		this.HasLabelSupport = false;
		this.LogicalOrOperator  = "||";
		this.LogicalAndOperator = "&&";
		this.MemberAccessOperator = ".";
		this.TrueLiteral  = "true";
		this.FalseLiteral = "false";
		this.NullLiteral  = "null";
		this.BreakKeyword = "break";
		this.ContinueKeyword = "continue";
		this.LineComment  = "//";
		this.ParameterBegin = "(";
		this.ParameterEnd = ")";
		this.ParameterDelimiter = ",";
		this.SemiColon = ";";
		this.BlockBegin = "{";
		this.BlockEnd = "}";
	}

	@Override public void InitContext(ZenNameSpace Context) {
		super.InitContext(Context);
		this.HeaderSource = "";
		this.BodySource = "";
	}

	public final void WriteHeader(String Text) {
		this.HeaderSource += Text;
	}

	public final void WriteLineHeader(String Text) {
		this.HeaderSource += Text + this.LineFeed;
	}

	public final void WriteCode(String Text) {
		this.BodySource += Text;
	}

	public final void WriteLineCode(String Text) {
		this.BodySource += Text + this.LineFeed;
	}

	public final void WriteLineComment(String Text) {
		this.BodySource += this.LineComment + " " + Text + this.LineFeed;
	}

	public final void FlushErrorReport() {
		this.WriteLineCode("");
		@Var String[] Reports = this.Context.GetReportedErrors();
		@Var int i = 0;
		while(i < Reports.length) {
			this.WriteLineComment(Reports[i]);
			i = i + 1;
		}
		this.WriteLineCode("");		
	}

	@Override public void FlushBuffer() {
		LibZen.WriteCode(this.OutputFile, this.HeaderSource + this.BodySource);			
		this.HeaderSource = "";
		this.BodySource = "";
	}

	/* GeneratorUtils */

	public final void Indent() {
		this.IndentLevel += 1;
		this.CurrentLevelIndentString = null;
	}

	public final void UnIndent() {
		this.IndentLevel -= 1;
		this.CurrentLevelIndentString = null;
		LibNative.Assert(this.IndentLevel >= 0);
	}

	public final String GetIndentString() {
		if(this.CurrentLevelIndentString == null) {
			this.CurrentLevelIndentString = JoinStrings(this.Tab, this.IndentLevel);
		}
		return this.CurrentLevelIndentString;
	}

	public String VisitBlockWithIndent(ZenNode Node, boolean NeedBlock) {
		@Var String Code = "";
		if(NeedBlock) {
			Code += this.BlockBegin + this.LineFeed;
			this.Indent();
		}
		@Var ZenNode CurrentNode = Node;
		while(CurrentNode != null) {
			if(!this.IsEmptyBlock(CurrentNode)) {
				@Var String Stmt = this.VisitNode(CurrentNode);
				if(!LibZen.EqualsString(Stmt, "")) {
					Code += this.GetIndentString() + Stmt + this.SemiColon + this.LineFeed;
				}
			}
			CurrentNode = CurrentNode.NextNode;
		}
		if(NeedBlock) {
			this.UnIndent();
			Code += this.GetIndentString() + this.BlockEnd;
		}
//		else if(Code.length() > 0) {
//			Code = Code.substring(0, Code.length() - 1);
//		}
		return Code;
	}

	protected String StringifyConstValue(Object ConstValue) {
		if(ConstValue == null) {
			return this.NullLiteral;
		}
		if(ConstValue instanceof Boolean) {
			if(ConstValue.equals(true)) {
				return this.TrueLiteral;
			}
			else {
				return this.FalseLiteral;
			}
		}
		if(ConstValue instanceof String) {
			return LibZen.QuoteString((/*cast*/String)ConstValue);
		}
		if(ConstValue instanceof ZenEnum) {
			return "" + ((/*cast*/ZenEnum) ConstValue).EnumValue;
		}
		return ConstValue.toString();
	}

	protected String GetNewOperator(ZenType Type) {
		return "new " + Type.ShortName + "()";
	}

	protected final void PushSourceCode(String Code) {
		this.PushCode(Code);
	}

	protected final String PopSourceCode() {
		return (/*cast*/String) this.PopCode();
	}

	public final String VisitNode(ZenNode Node) {
		Node.Accept(this);
		return this.PopSourceCode();
	}

	public final String JoinCode(String BeginCode, int BeginIdx, String[] ParamCode, String EndCode, String Delim) {
		@Var String JoinedCode = BeginCode;
		@Var int i = BeginIdx;
		while(i < ParamCode.length) {
			@Var String P = ParamCode[i];
			if(i != BeginIdx) {
				JoinedCode += Delim;
			}
			JoinedCode += P;
			i = i + 1;
		}
		return JoinedCode + EndCode;
	}

	public final static String GenerateApplyFunc1(ZenFunc Func, String FuncName, boolean IsSuffixOp, String Arg1) {
		@Var String Macro = null;
		if(Func != null) {
			FuncName = Func.GetNativeFuncName();
			if(IsFlag(Func.FuncFlag, NativeMacroFunc)) {
				Macro = Func.GetNativeMacro();
			}
		}
		if(Macro == null) {
			if(IsSuffixOp) {
				Macro = "$1 " + FuncName;
			}
			else {
				Macro = FuncName + " $1";
			}
		}
		return Macro.replace("$1", Arg1);
	}

	public final static String GenerateApplyFunc2(ZenFunc Func, String FuncName, String Arg1, String Arg2) {
		@Var String Macro = null;
		if(Func != null) {
			FuncName = Func.GetNativeFuncName();
			if(IsFlag(Func.FuncFlag, NativeMacroFunc)) {
				Macro = Func.GetNativeMacro();
			}
		}
		if(Macro == null) {
			Macro = "$1 " + FuncName + " $2";
		}
		return Macro.replace("$1", Arg1).replace("$2", Arg2);
	}

	public String GenerateFuncTemplate(int ParamSize, ZenFunc Func) {
		@Var int BeginIdx = 0;
		@Var String Template = "";
		@Var boolean IsNative = false;
		if(Func == null) {
			Template = "$1";
			BeginIdx += 1;
		}
		else if(Func.Is(NativeFunc)) {
			Template = "$1" + this.MemberAccessOperator + Func.FuncName;
			BeginIdx += 1;
		}
		else if(Func.Is(NativeMacroFunc)) {
			Template = Func.GetNativeMacro();
			IsNative = true;
		}
		else {
			Template = Func.GetNativeFuncName();
		}

		if(Func.Is(ConverterFunc)) {
			// T1 converter(FromType, ToType, Value);
			BeginIdx += 1;
		}
		@Var int i = BeginIdx;
		if(IsNative == false) {
			Template += this.ParameterBegin;
			while(i < ParamSize) {
				if(i != BeginIdx) {
					Template += this.ParameterDelimiter + " ";
				}
				Template += "$" + (i + 1);
				i = i + 1;
			}
			Template += this.ParameterEnd;
		}
		return Template;
	}

	public final String ApplyMacro(String Template, ArrayList<ZenNode> NodeList) {
		@Var int ParamSize = LibZen.ListSize(NodeList);
		@Var int ParamIndex = 0;
		while(ParamIndex < ParamSize) {
			@Var String Param = this.VisitNode(NodeList.get(ParamIndex));
			Template = Template.replace("$" + (ParamIndex + 1), Param);
			ParamIndex = ParamIndex  + 1;
		}
		return Template;
	}
	public final String ApplyMacro2(String Template, String[] ParamList) {
		@Var int ParamSize = ParamList.length;
		@Var int ParamIndex = 0;
		while(ParamIndex < ParamSize) {
			@Var String Param = ParamList[ParamIndex];
			Template = Template.replace("$" + (ParamIndex + 1), Param);
			ParamIndex = ParamIndex + 1;
		}
		return Template;
	}

	public final String GenerateApplyFunc(ZenApplySymbolNode Node) {
		@Var int ParamSize = LibZen.ListSize(Node.ParamList);
		@Var String Template = this.GenerateFuncTemplate(ParamSize, Node.ResolvedFunc);
		return this.ApplyMacro(Template, Node.ParamList);
	}

	// Visitor API
	@Override public void VisitEmptyNode(ZenEmptyNode Node) {
		this.PushSourceCode("");
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		this.PushSourceCode(this.VisitNode(Node.ExprNode) + " instanceof " + Node.TypeInfo);
	}

	@Override public final void VisitConstPoolNode(ZenConstPoolNode Node) {
		this.PushSourceCode(this.StringifyConstValue(Node.ConstValue));
	}

	@Override public final void VisitNullNode(ZenNullNode Node) {
		this.PushSourceCode(this.NullLiteral);
	}

	@Override public void VisitGetLocalNode(ZenGetLocalNode Node) {
		this.PushSourceCode(Node.NativeName);
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		@Var String Code = "return";
		if(Node.ValueNode != null) {
			Code += " " + this.VisitNode(Node.ValueNode);
		}
		this.PushSourceCode(Code);
		this.StopVisitor(Node);
	}

//	@Override public void VisitIndexerNode(ZenIndexerNode Node) {
//		this.PushSourceCode(this.VisitNode(Node.Expr) + "[" + this.VisitNode(Node.GetAt(0)) + "]"); // FIXME: Multi
//	}

	@Override public final void VisitConstructorNode(ZenConstructorNode Node) {
		@Var int ParamSize = LibZen.ListSize(Node.ParamList);
		@Var String Template = this.GenerateFuncTemplate(ParamSize, Node.Func);
		this.PushSourceCode(this.ApplyMacro(Template, Node.ParamList));
	}

	@Override public void VisitAllocateNode(ZenAllocateNode Node) {
		this.PushSourceCode(this.GetNewOperator(Node.Type));
	}

	@Override public void VisitApplySymbolNode(ZenApplySymbolNode Node) {
		@Var String Program = this.GenerateApplyFunc(Node);
		this.PushSourceCode(Program);
	}

//	@Override public void VisitSuffixNode(ZenSuffixNode Node) {
//		@Var String FuncName = Node.SourceToken.ParsedText;
//		@Var String Expr = this.VisitNode(Node.Expr);
//		if(LibZen.EqualsString(FuncName, "++")) {
//		}
//		else if(LibZen.EqualsString(FuncName, "--")) {
//		}
//		else {
//			LibZen.DebugP(FuncName + " is not supported suffix operator!!");
//		}
//		this.PushSourceCode("(" + SourceGenerator.GenerateApplyFunc1(Node.Func, FuncName, true, Expr) + ")");
//	}

//	@Override public void VisitSelfAssignNode(ZenSelfAssignNode Node) {
//		@Var String FuncName = Node.SourceToken.ParsedText;
//		@Var String Left = this.VisitNode(Node.LeftNode);
//		@Var String Right = this.VisitNode(Node.RightNode);
//		this.PushSourceCode(Left + " = " + SourceGenerator.GenerateApplyFunc2(Node.Func, FuncName, Left, Right));
//	}

	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		@Var String FuncName = Node.SourceToken.ParsedText;
		@Var String Expr = this.VisitNode(Node.RecvNode);
		this.PushSourceCode("(" + SourceGenerator.GenerateApplyFunc1(Node.ResolvedFunc, FuncName, false, Expr) + ")");
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		@Var String FuncName = Node.SourceToken.ParsedText;
		@Var String Left = this.VisitNode(Node.LeftNode);
		@Var String Right = this.VisitNode(Node.RightNode);
		this.PushSourceCode("(" + SourceGenerator.GenerateApplyFunc2(Node.ResolvedFunc, FuncName, Left, Right) + ")");
	}

	@Override public void VisitGetterNode(ZenGetterNode Node) {
		this.PushSourceCode(this.VisitNode(Node.RecvNode) + this.MemberAccessOperator + Node.ResolvedFunc.FuncName);
	}
	@Override public void VisitSetLocalNode(ZenSetLocalNode Node) {
		this.PushSourceCode(Node.NativeName + " = " + this.VisitNode(Node.ValueNode));
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		@Var String Left = this.VisitNode(Node.LeftNode);
		@Var String Right = this.VisitNode(Node.RightNode);
		this.PushSourceCode("(" + Left + " " + this.LogicalAndOperator +" " + Right + ")");
	}

	@Override public void VisitOrNode(ZenOrNode Node) {
		@Var String Left = this.VisitNode(Node.LeftNode);
		@Var String Right = this.VisitNode(Node.RightNode);
		this.PushSourceCode("(" + Left + " " + this.LogicalOrOperator +" " + Right + ")");
	}

	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
		@Var String CondExpr = this.VisitNode(Node.CondNode);
		@Var String ThenExpr = this.VisitNode(Node.ThenNode);
		@Var String ElseExpr = this.VisitNode(Node.ElseNode);
		this.PushSourceCode("((" + CondExpr + ")? " + ThenExpr + " : " + ElseExpr + ")");
	}

	@Override public void VisitBreakNode(ZenBreakNode Node) {
		@Var String Code = this.BreakKeyword;
		if(this.HasLabelSupport) {
			@Var String Label = Node.Label;
			if(Label != null) {
				Code += " " + Label;
			}
		}
		this.PushSourceCode(Code);
		this.StopVisitor(Node);
	}

	@Override public void VisitContinueNode(ZenContinueNode Node) {
		@Var String Code = this.ContinueKeyword;
		if(this.HasLabelSupport) {
			@Var String Label = Node.Label;
			if(Label != null) {
				Code += " " + Label;
			}
		}
		this.PushSourceCode(Code);
		this.StopVisitor(Node);
	}

	@Override public void VisitSwitchNode(ZenSwitchNode Node) {
		@Var String Code = "switch (" + this.VisitNode(Node.MatchNode) + ") {" + this.LineFeed;
		@Var int i = 0;
		while(i < Node.CaseList.size()) {
			@Var ZenNode Case  = Node.CaseList.get(i);
			@Var ZenNode Block = Node.CaseList.get(i+1);
			Code += this.GetIndentString() + "case " + this.VisitNode(Case) + ":";
			if(this.IsEmptyBlock(Block)) {
				this.Indent();
				Code += this.LineFeed + this.GetIndentString() + "/* fall-through */" + this.LineFeed;
				this.UnIndent();
			}
			else {
				Code += this.VisitBlockWithIndent(Block, true) + this.LineFeed;
			}
			i = i + 2;
		}
		if(Node.DefaultBlock != null) {
			Code += this.GetIndentString() + "default: ";
			Code += this.VisitBlockWithIndent(Node.DefaultBlock, true) + this.LineFeed;
		}
		Code += this.GetIndentString() + "}";
		this.PushSourceCode(Code);
	}

	// EnforceConst API
	@Override public Object EvalAllocateNode(ZenAllocateNode Node, boolean EnforceConst) {
		if(EnforceConst) {
			this.VisitAllocateNode(Node);
			return this.PopSourceCode();
		}
		return null;
	}

	@Override public Object EvalNewArrayNode(ZenNewArrayNode Node, boolean EnforceConst) {
		if(EnforceConst) {
			this.VisitNewArrayNode(Node);
			return this.PopSourceCode();
		}
		return null;
	}

	public Object EvalGetterNode(ZenGetterNode Node, boolean EnforceConst) {
		if(EnforceConst) {
			this.VisitGetterNode(Node);
			return this.PopSourceCode();
		}
		return null;
	}

	public Object EvalSetterNode(ZenSetterNode Node, boolean EnforceConst) {
		if(EnforceConst) {
			this.VisitSetterNode(Node);
			return this.PopSourceCode();
		}
		return null;
	}

	@Override public Object EvalApplySymbolNode(ZenApplySymbolNode ApplyNode, boolean EnforceConst) {
		if((EnforceConst || ApplyNode.ResolvedFunc.Is(ConstFunc)) /*&& ApplyNode.Func.FuncBody instanceof Method */) {
			this.VisitApplySymbolNode(ApplyNode);
			return this.PopSourceCode();
		}
		return null;
	}
}
