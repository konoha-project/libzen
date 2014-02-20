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


import parser.ZenClassField;
import parser.ZenFieldInfo;
import parser.ZenFunc;
import parser.ZenSourceBuilder;
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
import parser.ast.ZenBreakNode;
import parser.ast.ZenCastNode;
import parser.ast.ZenCatchNode;
import parser.ast.ZenCommandNode;
import parser.ast.ZenConstPoolNode;
import parser.ast.ZenConstructorNode;
import parser.ast.ZenContinueNode;
import parser.ast.ZenDoWhileNode;
import parser.ast.ZenEmptyNode;
import parser.ast.ZenErrorNode;
import parser.ast.ZenForEachNode;
import parser.ast.ZenForNode;
import parser.ast.ZenFunctionNode;
import parser.ast.ZenGetLocalNode;
import parser.ast.ZenGetterNode;
import parser.ast.ZenIfNode;
import parser.ast.ZenInstanceOfNode;
import parser.ast.ZenNewArrayNode;
import parser.ast.ZenNode;
import parser.ast.ZenNullNode;
import parser.ast.ZenOrNode;
import parser.ast.ZenPrefixDeclNode;
import parser.ast.ZenPrefixInclNode;
import parser.ast.ZenReturnNode;
import parser.ast.ZenSetLocalNode;
import parser.ast.ZenSetterNode;
import parser.ast.ZenSliceNode;
import parser.ast.ZenRightDeclNode;
import parser.ast.ZenRightInclNode;
import parser.ast.ZenSwitchNode;
import parser.ast.ZenThrowNode;
import parser.ast.ZenTrinaryNode;
import parser.ast.ZenTryNode;
import parser.ast.ZenUnaryNode;
import parser.ast.ZenVarNode;
import parser.ast.ZenWhileNode;
import parser.deps.LibZen;

public class JavaScriptSourceGenerator extends ZenSourceGenerator {
//	@Field private boolean UseLetKeyword = false;
//	@Field private boolean IsForNodeJS = false;

	public JavaScriptSourceGenerator(String TargetCode, String OutputFile, int GeneratorFlag) {
		super(TargetCode, OutputFile, GeneratorFlag);
	}
	
	@Override public void GenerateFunc(ZenFunc Func, ArrayList<String> ParamNameList, ZenNode Body) {
		@Var String MethodName = Func.GetNativeFuncName();
		@Var ZenSourceBuilder Builder = new ZenSourceBuilder(this);
		Builder.IndentAndAppend("function ");
		Builder.AppendToken(MethodName);
		Builder.Append("(");
		@Var int i = 0;
		@Var int size = LibZen.ListSize(ParamNameList);
		while(i < size) {
			if(i != 0) {
				Builder.Append(this.Camma);
			}
			Builder.Append(ParamNameList.get(i));
			i += 1;
		}
		Builder.Append(")");
		@Var ZenSourceBuilder PushedBuilder = this.CurrentBuilder;
		this.CurrentBuilder = Builder;
		this.VisitIndentBlock("{", Body, "}");
		this.CurrentBuilder = PushedBuilder;
		System.out.println(Builder);
	}
	
/**
JavaScript code to be generated:

var CLASS = (function (_super) {
	    __extends(CLASS, _super);                                // Derived class only.
	    function CLASS(param) {                                   // Constructor.
	        _super.call(this, param);
	        this.FIELD = param;                                      // Field definition and initialization.
	    };
	    CLASS.STATIC_FIELD = "value";                      // Static fields
    
	    CLASS.prototype.METHOD = function () {    // Methods.
	    };
	    CLASS.STATIC_METHOD = function () {         // Static methods.
	    };
	    return CLASS;
})(SUPERCLASS);
 */
	
	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {
		this.CurrentBuilder = this.NewSourceBuilder();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("var  ");
		this.CurrentBuilder.Append(Type.ShortName);
		this.CurrentBuilder.AppendLine(" = (function(_super) {");
		this.CurrentBuilder.Indent();
		
		if(Type.SuperType != null){
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("__extends(");
			this.CurrentBuilder.Append(Type.ShortName);
			this.CurrentBuilder.AppendLine(", _super);");
		}
		
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("function ");
		this.CurrentBuilder.Append(Type.ShortName);
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.AppendLine(") {");
		this.CurrentBuilder.Indent();
		
		@Var int i = 0;
		@Var int size = LibZen.ListSize(ClassField.FieldList);
		while(i < size) {
			@Var ZenFieldInfo FieldInfo = ClassField.GetFieldNode(i);
			@Var String InitValue = this.StringifyConstValue(FieldInfo.InitValue);
			if(!FieldInfo.Type.IsNativeType()) {
				InitValue = this.NullLiteral;
			}
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("this.");
			this.CurrentBuilder.Append(FieldInfo.NativeName);
			this.CurrentBuilder.Append(" = ");
			this.CurrentBuilder.Append(InitValue);
			this.CurrentBuilder.AppendLine(this.SemiColon);
			i += 1;
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendLine("};");
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("return  ");
		this.CurrentBuilder.Append(Type.ShortName);
		this.CurrentBuilder.AppendLine(";");
		this.CurrentBuilder.Append("})");
		if(Type.SuperType != null){
			this.CurrentBuilder.Append("(");
			this.CurrentBuilder.Append(Type.SuperType.ShortName);
			this.CurrentBuilder.Append(")");
		}
		this.CurrentBuilder.AppendLine(";");
	}

	@Override public void InvokeMainFunc(String MainFuncName) {
		this.CurrentBuilder = this.NewSourceBuilder();
		this.CurrentBuilder.Append(MainFuncName);
		this.CurrentBuilder.AppendLine("();");
	}
	
	private final boolean DoesNodeExist(ZenNode Node){
		return Node != null && !(Node instanceof ZenEmptyNode);
	}
	
	private final void DebugAppendNode(ZenNode Node){
		this.CurrentBuilder.Append("/* ");
		this.CurrentBuilder.Append(Node.getClass().getSimpleName());
		this.CurrentBuilder.Append(" */");
		if(Node.NextNode != null){
			Node.NextNode.Accept(this); 
		}
	}

	@Override public void VisitEmptyNode(ZenEmptyNode EmptyNode) {
		LibZen._PrintDebug("empty node: " + EmptyNode.SourceToken.GetText());
	}
	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		/*extention*/
	}
//	@Override public void VisitSelfAssignNode(ZenSelfAssignNode Node) {
//		Node.AST[ZBinaryNode.Left].Accept(this);
//		this.VisitingBuilder.Append(Node.SourceToken.GetText());
//		Node.AST[ZBinaryNode.Right].Accept(this);
//	}
	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
		Node.AST[ZIfNode.Cond].Accept(this);
		this.CurrentBuilder.Append(" ? ");
		Node.AST[ZIfNode.Then].Accept(this);
		this.CurrentBuilder.Append(" : ");
		Node.AST[ZIfNode.Else].Accept(this);
	}
//	@Override public void VisitExistsNode(ZenExistsNode Node) {
//		this.DebugAppendNode(Node);
//	}
	@Override public void VisitCastNode(ZenCastNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitSliceNode(ZenSliceNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitRightInclNode(ZenRightInclNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitRightDeclNode(ZenRightDeclNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitPrefixInclNode(ZenPrefixInclNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitPrefixDeclNode(ZenPrefixDeclNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		Node.AST[ZGetterNode.Recv].Accept(this);
	}
//	@Override public void VisitIndexerNode(ZenIndexerNode Node) {
//		this.VisitingBuilder.Append("[");
//		Node.Expr.Accept(this);
//		this.VisitingBuilder.Append("]");
//	}
	@Override public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitNewArrayNode(ZenNewArrayNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitWhileNode(ZenWhileNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitForNode(ZenForNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitForEachNode(ZenForEachNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitConstPoolNode(ZenConstPoolNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
	}
	@Override public void VisitAllocateNode(ZenAllocateNode Node) {
		this.CurrentBuilder.Append("new ");
		this.CurrentBuilder.Append(Node.Type.ShortName);
		this.CurrentBuilder.Append("()");
	}
	@Override public void VisitConstructorNode(ZenConstructorNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitNullNode(ZenNullNode Node) {
		this.CurrentBuilder.Append(this.NullLiteral);
	}
	@Override public void VisitGetNameNode(ZenGetLocalNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
	}
	@Override public void VisitGetterNode(ZenGetterNode Node) {
		Node.AST[ZGetterNode.Recv].Accept(this);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.NativeName);
	}
	@Override public void VisitSetterNode(ZenSetterNode Node) {
		Node.AST[ZGetterNode.Recv].Accept(this);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" = ");
		Node.ValueNode.Accept(this);
	}
	@Override public void VisitApplySymbolNode(ZenApplySymbolNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append("(");
		for(@Var int i = 0; i < LibZen.ListSize(Node.ParamList); i++){
			if(i > 0){
				this.CurrentBuilder.Append(", ");
			}
			Node.GetParam(i).Accept(this);
		}
		this.CurrentBuilder.Append(")");
	}
	@Override public void VisitApplyOverridedMethodNode(ZenApplyOverridedMethodNode Node) {
		this.CurrentBuilder.Append(Node.Func.GetNativeFuncName());
		this.CurrentBuilder.Append("(");
		for(@Var int i = 0; i < LibZen.ListSize(Node.ParamList); i++){
			if(i > 0){
				this.CurrentBuilder.Append(", ");
			}
			Node.GetParam(i).Accept(this);
		}
		this.CurrentBuilder.Append(")");
	}
	
	// e. g  (function(...){...})(...)
	@Override public void VisitApplyFunctionObjectNode(ZenApplyFunctionObjectNode Node) {
		this.CurrentBuilder.Append("(");
		Node.FuncNode.Accept(this);
		this.CurrentBuilder.Append(")");
		this.CurrentBuilder.Append("(");
		for(@Var int i = 0; i < LibZen.ListSize(Node.ParamList); i++){
			if(i > 0){
				this.CurrentBuilder.Append(", ");
			}
			Node.GetParam(i).Accept(this);
		}
		this.CurrentBuilder.Append(")");
	}
	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		Node.AST[ZBinaryNode.Left].Accept(this);
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		Node.AST[ZBinaryNode.Right].Accept(this);
	}
	@Override public void VisitAndNode(ZenAndNode Node) {
		Node.AST[ZBinaryNode.Left].Accept(this);
		this.CurrentBuilder.Append("&&");
		Node.AST[ZBinaryNode.Right].Accept(this);
	}
	@Override public void VisitOrNode(ZenOrNode Node) {
		Node.AST[ZBinaryNode.Left].Accept(this);
		this.CurrentBuilder.Append("||");
		Node.AST[ZBinaryNode.Right].Accept(this);
	}
	@Override public void VisitSetNameNode(ZenSetLocalNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" = ");
		Node.ValueNode.Accept(this);
	}
	@Override public void VisitVarNode(ZenVarNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" = ");
		Node.InitNode.Accept(this);
		Node.BlockNode.Accept(this);
	}
	@Override public void VisitIfNode(ZenIfNode Node) {
		this.CurrentBuilder.Append("if(");
		Node.AST[ZIfNode.Cond].Accept(this);
		this.CurrentBuilder.Append(")");
		this.VisitIndentBlock("{", Node.AST[ZIfNode.Then], "}");
		if(this.DoesNodeExist(Node.AST[ZIfNode.Else])){
			this.CurrentBuilder.Append("else");
			this.VisitIndentBlock("{", Node.AST[ZIfNode.Else], "}");
		}
	}
	@Override public void VisitSwitchNode(ZenSwitchNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitReturnNode(ZenReturnNode Node) {
		this.CurrentBuilder.Append("return");
		if(this.DoesNodeExist(Node.ValueNode)){
			this.CurrentBuilder.Append(" ");
			Node.ValueNode.Accept(this);
		}
	}
	@Override public void VisitBreakNode(ZenBreakNode Node) {
		this.CurrentBuilder.Append("break");
	}
	@Override public void VisitContinueNode(ZenContinueNode Node) {
		this.CurrentBuilder.Append("continue");
	}
	@Override public void VisitTryNode(ZenTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.VisitIndentBlock("{", Node.AST[ZTryNode.Try], "}");
		assert(LibZen.ListSize(Node.CatchList) <= 1);
		for (int i = 0; i < LibZen.ListSize(Node.CatchList); i++) {
			ZenCatchNode Catch = (ZenCatchNode) Node.CatchList.get(i);
			this.CurrentBuilder.Append("catch(" + Catch.ExceptionName + ")");
			this.VisitIndentBlock("{", Catch.BodyNode, "}");
		}
		this.CurrentBuilder.Append("finally");
		this.VisitIndentBlock("{", Node.AST[ZTryNode.Finally], "}");
	}
	@Override public void VisitThrowNode(ZenThrowNode Node) {
		this.CurrentBuilder.Append("throw ");
		Node.ValueNode.Accept(this);
	}
	@Override public void VisitFunctionNode(ZenFunctionNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitErrorNode(ZenErrorNode Node) {
		this.CurrentBuilder.Append("(function(){ throw new Error('");
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		this.CurrentBuilder.Append("'); })()");
	}
	@Override public void VisitCommandNode(ZenCommandNode Node) {
		this.DebugAppendNode(Node);
	}

	
//
//	JavaScriptSourceGenerator(String TargetCode, String OutputFile, int GeneratorFlag) {
//		super(TargetCode, OutputFile, GeneratorFlag);
//		this.IsNodeJS = LibZen.EqualsString(TargetCode, "nodejs");
//		this.HasLabelSupport= false;
//		this.LogicalAndOperator = "&&";
//		this.LogicalOrOperator = "||";
//		this.MemberAccessOperator = ".";
//		this.TrueLiteral = "true";
//		this.FalseLiteral = "false";
//		this.NullLiteral = "null";
//		this.LineComment = "//";
//		this.BreakKeyword = "break";
//		this.ContinueKeyword = "continue";
//		this.ParameterBegin = "(";
//		this.ParameterEnd = ")";
//		this.ParameterDelimiter = ",";
//		this.SemiColon = ";";
//		this.BlockBegin = "{";
//		this.BlockEnd = "}";
//	}
//
//	
//	public String VisitBlockJS(ZenNode Node) {
//		@Var String Code = "";
//		@Var ZenNode CurrentNode = Node;
//		while(CurrentNode != null) {
//			@Var String Statement = this.VisitNode(CurrentNode);
//			if(Statement.trim().length() >0) {
//				Code += this.GetIndentString() + Statement + ";" + this.LineFeed;
//			}
//			CurrentNode = CurrentNode.NextNode;
//		}
//		return Code;
//	}
//
//	public String VisitBlockJSWithIndent(ZenNode Node) {
//		@Var String Code = "";
//		Code += "{" + this.LineFeed;
//		this.Indent();
//		Code += this.VisitBlockJS(Node);
//		this.UnIndent();
//		Code += this.GetIndentString() + "}";
//		return Code;
//	}
//
//	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
//		@Var String FuncName = Node.SourceToken.GetText();
//		@Var String Left = this.VisitNode(Node.AST[ZBinaryNode.Left]);
//		@Var String Right = this.VisitNode(Node.AST[ZBinaryNode.Right]);
//		@Var String Source = "(" + SourceGenerator.GenerateApplyFunc2(Node.Func, FuncName, Left, Right) + ")";
//		@Var String operator = Node.SourceToken.GetText();
//		if(LibZen.EqualsString(operator, "/") /*&& Node.Type == Context.IntType*/ ) {
//			Source = "(" + Source + " | 0)";
//		}
//		this.PushSourceCode(Source);
//	}
//
//	@Override public void VisitVarNode(ZenVarNode Node) {
//		@Var String VarName = Node.NativeName;
//		@Var String Source = (this.UseLetKeyword ? "let " : "var ") + " " + VarName;
//		if(Node.InitNode != null) {
//			Node.InitNode.Accept(this);
//			Source += " = " + this.PopSourceCode();
//		}
//		Source +=  ";";
//		Source += this.VisitBlockJSWithIndent(Node.BlockNode);
//		this.PushSourceCode(Source);
//	}
//
//	@Override public void VisitIfNode(ZenIfNode Node) {
//		@Var String ThenBlock = this.VisitBlockJSWithIndent(Node.AST[ZIfNode.Then]);
//		@Var String CondExpr = this.VisitNode(Node.CondExpr);
//		@Var String Source = "if(" + CondExpr + ") " + ThenBlock;
//		if(Node.AST[ZIfNode.Else] != null) {
//			Source = Source + " else " + this.VisitBlockJSWithIndent(Node.AST[ZIfNode.Else]);
//		}
//		this.PushSourceCode(Source);
//	}
//
//	@Override public void VisitWhileNode(ZenWhileNode Node) {
//		@Var String LoopBody = this.VisitBlockJSWithIndent(Node.LoopBody);
//		@Var String CondExpr = this.VisitNode(Node.CondExpr);
//		this.PushSourceCode("while(" + CondExpr + ") {" + LoopBody + "}");
//	}
//
//	@Override public void VisitForNode(ZenForNode Node) {
//		@Var String LoopBody = this.VisitBlockJSWithIndent(Node.LoopBody);
//		@Var String IterExpr = this.VisitNode(Node.IterExpr);
//		@Var String CondExpr = this.VisitNode(Node.CondExpr);
//		this.PushSourceCode("for(;" + CondExpr + "; " + IterExpr + ") {" + LoopBody + "}");
//	}
//
//	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
//		@Var String LoopBody = this.VisitBlockJSWithIndent(Node.LoopBody);
//		@Var String CondExpr = this.VisitNode(Node.CondExpr);
//		this.PushSourceCode("do {" + LoopBody + "} while(" + CondExpr + ");");
//	}
//
//	@Override public void VisitTryNode(ZenTryNode Node) {
//		@Var String Code = "try ";
//		Code += this.VisitBlockJSWithIndent(Node.TryBlock);
//		if(Node.CatchExpr != null) {
//			@Var ZenVarNode Val = (ZenVarNode) Node.CatchExpr;
//			Code += " catch (" + Val.Type.toString() + " " + Val.NativeName + ") ";
//			Code += this.VisitBlockJSWithIndent(Node.CatchBlock);
//		}
//		if(Node.FinallyBlock != null) {
//			Code += " finally " + this.VisitBlockJSWithIndent(Node.FinallyBlock);
//		}
//		this.PushSourceCode(Code);
//	}
//
//	@Override public void VisitThrowNode(ZenThrowNode Node) {
//		@Var String Expr = this.VisitNode(Node.Expr);
//		this.PushSourceCode("throw " + Expr);
//	}
//
//	@Override public void VisitErrorNode(ZenErrorNode Node) {
//		@Var String Expr = Node.SourceToken.GetText();
//		this.PushSourceCode("(function() {throw new Error(\"" + Expr + "\") })()");
//	}
//
//	@Override public void GenerateFunc(ZenFunc Func, ArrayList<String> NameList, ZenNode Body) {
//		this.FlushErrorReport();
//		@Var int ArgCount = Func.Types.length - 1;
//		@Var String Code = "var " + Func.GetNativeFuncName() + " = (function(";
//		@Var int i = 0;
//		while(i < ArgCount) {
//			if(i > 0) {
//				Code = Code + ", ";
//			}
//			Code = Code + NameList.get(i);
//			i = i + 1;
//		}
//		Code = Code + ") " + this.VisitBlockJSWithIndent(Body) + ");";
//		this.WriteLineCode(Code);
//	}
//
///**
//JavaScript code to be generated:
//
//var CLASS = (function (_super) {
//    __extends(CLASS, _super);                                // Derived class only.
//    function CLASS(param) {                                   // Constructor.
//        _super.call(this, param);
//        this.FIELD = param;                                      // Field definition and initialization.
//    };
//    CLASS.STATIC_FIELD = "value";                      // Static fields
//    
//    CLASS.prototype.METHOD = function () {    // Methods.
//    };
//    CLASS.STATIC_METHOD = function () {         // Static methods.
//    };
//    return CLASS;
//})(SUPERCLASS);
// */
//	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {
//		@Var String TypeName = Type.ShortName;
//		@Var String Program = this.GetIndentString() + "var " + TypeName + " = (function() {" + this.LineFeed;
////		if(Type.SuperType != null) {
////			Program += "(" + Type.SuperType.ShortClassName + ")";
////		}
//		this.Indent();
//		Program += this.GetIndentString() + "function " + TypeName + "() {" + this.LineFeed;
//		this.Indent();
//		@Var int i = 0;
//		while(i < ClassField.GetParamSize()) {
//			@Var ZenFieldInfo FieldInfo = ClassField.GetFieldNode(i);
//			@Var String InitValue = this.StringifyConstValue(FieldInfo.InitValue);
//			if(!FieldInfo.Type.IsNativeType()) {
//				InitValue = this.NullLiteral;
//			}
//			Program += this.GetIndentString() + "this" + "." + FieldInfo.NativeName + " = " + InitValue + ";" + this.LineFeed;
//			i = i + 1;
//		}
//		this.UnIndent();
//		Program += this.GetIndentString() + "};" + this.LineFeed;
//		Program += this.GetIndentString() + "return " + TypeName + ";" + this.LineFeed;
//		this.UnIndent();
//		Program += this.GetIndentString() + "})();" + this.LineFeed;
//		this.WriteLineCode(Program);
//	}
//	@Override public Object Eval(ZenNode Node) {
//		@Var String ret = this.VisitBlockJS(Node);
//		this.WriteLineCode(ret);
//		return ret;
//	}
//
//	@Override public void StartCompilationUnit() {
//		if(this.IsNodeJS) {
//			this.WriteLineCode("var assert = require('assert');");
//		}
//		else {			
//			this.WriteLineCode("var assert = console.assert;");
//		}
//	}
//
//	@Override public void InvokeMainFunc(String MainFuncName) {
//		this.WriteLineCode(MainFuncName + "();");
//	}
//	@Override public String GetRecvName() {
//		return "$__this";
//	}
}
