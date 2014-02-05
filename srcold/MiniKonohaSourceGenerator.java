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
import parser.ast.ZenAndNode;
import parser.ast.ZenApplyFunctionObjectNode;
import parser.ast.ZenApplyOverridedMethodNode;
import parser.ast.ZenApplySymbolNode;
import parser.ast.ZenArrayLiteralNode;
import parser.ast.ZenBinaryNode;
import parser.ast.ZenBreakNode;
import parser.ast.ZenCastNode;
import parser.ast.ZenCommandNode;
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
import parser.ast.ZenReturnNode;
import parser.ast.ZenSetLocalNode;
import parser.ast.ZenSetterNode;
import parser.ast.ZenSliceNode;
import parser.ast.ZenSwitchNode;
import parser.ast.ZenThrowNode;
import parser.ast.ZenTrinaryNode;
import parser.ast.ZenTryNode;
import parser.ast.ZenUnaryNode;
import parser.ast.ZenVarDeclNode;
import parser.ast.ZenWhileNode;
import parser.deps.LibZen;

public class MiniKonohaSourceGenerator extends ZenSourceGenerator {
	@Field private ArrayList<String> UsedLibrary;
	
	public MiniKonohaSourceGenerator(String TargetCode, String OutputFile, int GeneratorFlag) {
		super(TargetCode, OutputFile, GeneratorFlag);
		this.UsedLibrary = new ArrayList<String>();
	}

	@Override
	public void GenerateFunc(ZenFunc Func, ArrayList<String> ParamNameList, ZenNode Body) {
		String MethodName = Func.GetNativeFuncName();
		ZenSourceBuilder Builder = this.NewSourceBuilder();
		Builder.IndentAndAppend(this.ConvertToNativeTypeName(Func.GetReturnType()));
		Builder.AppendToken(MethodName);
		Builder.Append("(");
		@Var int i = 0;
		@Var int size = LibZen.ListSize(ParamNameList);
		while(i < size) {
			if(i != 0) {
				Builder.Append(this.Camma);
			}
			Builder.Append(this.ConvertToNativeTypeName(Func.GetFuncParamType(i)));
			Builder.AppendToken(ParamNameList.get(i));
			i += 1;
		}
		Builder.Append(")");
		ZenSourceBuilder PushedBuilder = this.CurrentBuilder;
		this.CurrentBuilder = Builder;
		this.VisitIndentBlock("{", Body, "}");
		this.CurrentBuilder.AppendLine("");
		this.CurrentBuilder = PushedBuilder;
	}

	private void AddUseLibrary(String Library) {
		if(this.UsedLibrary.indexOf(Library) == (-1)) {
			this.UsedLibrary.add(Library);
		}
		return;
	}
	
	private String ConvertToNativeFuncName(ZenFunc Func) {
		if(Func.FuncName.equals("assert")) {
			return "assert";
		}
		return Func.GetNativeFuncName();
	}
	private String ConvertToNativeTypeName(ZenType Type) {
		if(Type.IsIntType()) {
			return "int";
		}
		else if(Type.IsFloatType()) {
			this.AddUseLibrary("Type.Float");
			return "float";
		}
		else if(Type.IsBooleanType()) {
			return "boolean";
		}
		else if(Type.IsStringType()) {
			return "String";
		}
		else if(Type.IsArrayType()){
			this.AddUseLibrary("JavaScript.Array");
			return this.ConvertToNativeTypeName(Type.TypeParams[0])+ "[]";
		}
		return Type.ShortName;
	}
	private void VisitBlockWithoutIndent(ZenNode Node) {
		@Var ZenNode CurrentNode = Node;
		while(CurrentNode != null) {
			if(!this.IsEmptyBlock(CurrentNode)) {
				this.CurrentBuilder.AppendIndent();
				CurrentNode.Accept(this);
				this.CurrentBuilder.AppendLine(this.SemiColon);
			}
			CurrentNode = CurrentNode.NextNode;
		}
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
	
	private String GetHeaderCode() {
		String HeaderCode = "";
		for(String Library : this.UsedLibrary) {
			HeaderCode += "import(\"" + Library + "\")\n";
		}
		HeaderCode += "\n";
		return HeaderCode;
	}

	@Override public String GetSourceCode() {		
		return this.GetHeaderCode() + super.GetSourceCode();
	}

//	@Override public void FlushBuffer() {
//		if(this.OutputFile.equals("-")) {
//			LibZen.WriteCode(this.OutputFile, this.GetHeaderCode());
//			super.FlushBuffer();			
//		}
//		else {
//			String PushedSourceCode = this.GetSourceCode();
//			super.FlushBuffer();
//			LibZen.WriteCode(this.OutputFile, PushedSourceCode);
//		}
//	}

	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {
		this.AddUseLibrary("Syntax.JavaStyleClass");
		this.CurrentBuilder = this.NewSourceBuilder();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("class ");
		this.CurrentBuilder.Append(Type.ShortName);
		//if(Type.SuperType != null){
		if(!Type.SuperType.ShortName.equals("Top")){
			this.CurrentBuilder.AppendToken("extends");
			this.CurrentBuilder.Append(Type.SuperType.ShortName);
		}
		this.CurrentBuilder.AppendLine(" {");
		this.CurrentBuilder.Indent();
		
		@Var int i = 0;
		@Var int size = LibZen.ListSize(ClassField.FieldList);
		while(i < size) {
			@Var ZenFieldInfo FieldInfo = ClassField.GetFieldNode(i);
			@Var String InitValue = this.StringifyConstValue(FieldInfo.InitValue);
			if(!FieldInfo.Type.IsNativeType()) {
				this.AddUseLibrary("Syntax.Null");
				InitValue = this.NullLiteral;
			}
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append(this.ConvertToNativeTypeName(FieldInfo.Type));
			this.CurrentBuilder.AppendToken(FieldInfo.NativeName);
			this.CurrentBuilder.Append("= ");
			this.CurrentBuilder.Append(InitValue);
			this.CurrentBuilder.AppendLine(this.SemiColon);
			i += 1;
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.AppendLine("}");
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
	}

	@Override public void VisitEmptyNode(ZenEmptyNode EmptyNode) {
		LibZen.DebugP("empty node: " + EmptyNode.SourceToken.GetText());
	}
	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		this.AddUseLibrary("JavaStyle.Object");
		Node.ExprNode.Accept(this);
		this.CurrentBuilder.AppendToken("instanceof");
		this.CurrentBuilder.Append(Node.TypeInfo.GetNativeName());
	}
	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
		this.CurrentBuilder.Append("if(");
		Node.AST[ZIfNode.Cond].Accept(this);
		this.CurrentBuilder.Append(") {");
		Node.AST[ZIfNode.Then].Accept(this);
		this.CurrentBuilder.Append("} ");
		if(this.DoesNodeExist(Node.AST[ZIfNode.Else])){
			this.CurrentBuilder.Append("else {");
			Node.AST[ZIfNode.Else].Accept(this);
			this.CurrentBuilder.Append("}");
		}
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
//	@Override public void VisitSuffixNode(ZenSuffixNode Node) {
//		this.DebugAppendNode(Node);
//	}
	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		Node.AST[ZGetterNode.Recv].Accept(this);
	}
//	@Override public void VisitIndexerNode(ZenGetterNode Node) {
//		this.AddUseLibrary("JavaScript.String");
//		this.VisitingBuilder.Append("[");
//		Node.AST[ZGetterNode.Recv].Accept(this);
//		this.VisitingBuilder.Append("]");
//	}
	@Override public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
		this.AddUseLibrary("JavaScript.Array");
		@Var int size = LibZen.ListSize(Node.NodeList);
		@Var int i = 0;
		this.CurrentBuilder.Append("[");
		while(i < size) {
			if(i != 0) {
				this.CurrentBuilder.Append(", ");
			}   
			Node.NodeList.get(i).Accept(this);
			i += 1;
		}   
		this.CurrentBuilder.Append("]");
	}
	@Override public void VisitNewArrayNode(ZenNewArrayNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitWhileNode(ZenWhileNode Node) {
		this.AddUseLibrary("Syntax.CStyleWhile");
		this.CurrentBuilder.Append("while(");
		Node.AST[ZIfNode.Cond].Accept(this);
		this.CurrentBuilder.Append(") ");
		this.VisitIndentBlock("{", Node.BodyNode, "}");
		this.CurrentBuilder.AppendLine("");
	}
	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
		this.AddUseLibrary("Syntax.CStyleWhile");
		this.CurrentBuilder.Append("do ");
		this.VisitIndentBlock("{", Node.BodyNode, "}");
		this.CurrentBuilder.Append(" while(");
		Node.AST[ZIfNode.Cond].Accept(this);
		this.CurrentBuilder.AppendLine(");");
	}

	@Override public void VisitForNode(ZenForNode Node) {
		this.AddUseLibrary("Syntax.CStyleFor");
		this.CurrentBuilder.Append("for(");
		this.CurrentBuilder.Append("; ");
		Node.AST[ZIfNode.Cond].Accept(this);
		this.CurrentBuilder.Append("; ");
		Node.IterNode.Accept(this);
		this.CurrentBuilder.Append(") ");
		this.VisitIndentBlock("{", Node.BodyNode, "}");
		this.CurrentBuilder.AppendLine("");
	}
	private boolean IsInForExpr(ZenNode Node) {
		if(Node.ParentNode instanceof ZenForNode){
			ZenForNode Parent = (ZenForNode) Node.ParentNode;
			if(Node == Parent.AST[ZIfNode.Cond]) return true;
			if(Node == Parent.IterNode) return true;
		}
		return false;
	}

	@Override public void VisitForEachNode(ZenForEachNode Node) {
		this.DebugAppendNode(Node);
	}
//	@Override public void VisitConstNode(ZenConstNode Node) {
//		this.VisitingBuilder.Append(Node.SourceToken.GetText());
//	}
//	@Override public void VisitNewNode(ZenAllocateNode Node) {
//		this.VisitingBuilder.Append("new ");
//		this.VisitingBuilder.Append(this.ConvertToNativeTypeName(Node.Type));
//		this.VisitingBuilder.Append("(");
//		this.VisitingBuilder.Append(")");
//	}
	@Override public void VisitConstructorNode(ZenConstructorNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitNullNode(ZenNullNode Node) {
		this.AddUseLibrary("Syntax.Null");
		this.CurrentBuilder.Append(this.NullLiteral);
	}
	@Override public void VisitGetNameNode(ZenGetLocalNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
	}
	@Override public void VisitGetterNode(ZenGetterNode Node) {
		Node.AST[ZGetterNode.Recv].Accept(this);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
	}
	@Override public void VisitSetterNode(ZenSetterNode Node) {
		Node.AST[ZGetterNode.Recv].Accept(this);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		this.CurrentBuilder.AppendToken("=");
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.Append(";");
		if(!this.IsInForExpr(Node)) this.CurrentBuilder.AppendLine("");
	}
	@Override public void VisitApplySymbolNode(ZenApplySymbolNode Node) {
		this.CurrentBuilder.Append(ConvertToNativeFuncName(Node.ResolvedFunc));
		this.CurrentBuilder.Append("(");
		for(@Var int i = 0; i < LibZen.ListSize(Node.ParamList); i++){
			if(i != 0) this.CurrentBuilder.Append(", ");
			Node.GetParam(i).Accept(this);
		}
		this.CurrentBuilder.Append(")");
	}
	@Override public void VisitApplyOverridedMethodNode(ZenApplyOverridedMethodNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitApplyFunctionObjectNode(ZenApplyFunctionObjectNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		Node.AST[ZBinaryNode.Left].Accept(this);
		this.CurrentBuilder.AppendToken(Node.SourceToken.GetText());
		Node.AST[ZBinaryNode.Right].Accept(this);
	}
	@Override public void VisitAndNode(ZenAndNode Node) {
		Node.AST[ZBinaryNode.Left].Accept(this);
		this.CurrentBuilder.AppendToken("&&");
		Node.AST[ZBinaryNode.Right].Accept(this);
	}
	@Override public void VisitOrNode(ZenOrNode Node) {
		Node.AST[ZBinaryNode.Left].Accept(this);
		this.CurrentBuilder.AppendToken("||");
		Node.AST[ZBinaryNode.Right].Accept(this);
	}
	@Override public void VisitSetNameNode(ZenSetLocalNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.Append(";");
		if(!this.IsInForExpr(Node)) this.CurrentBuilder.AppendLine("");
	}
	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		this.CurrentBuilder.Append(this.ConvertToNativeTypeName(Node.DeclType));
		String VarName = Node.SourceToken.GetText();
		this.CurrentBuilder.AppendToken(VarName);
		//if(this.DoesNodeExist(Node.InitNode)){ //FIXME: Always true
		if(Node.InitNode.SourceToken.GetText() != VarName){
			this.CurrentBuilder.AppendToken("=");
			Node.InitNode.Accept(this);
		}
		this.CurrentBuilder.AppendLine(";");
		this.VisitBlockWithoutIndent(Node.BlockNode);
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
		this.DebugAppendNode(Node);
	}
	@Override public void VisitThrowNode(ZenThrowNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitFunctionNode(ZenFunctionNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitErrorNode(ZenErrorNode Node) {
		this.DebugAppendNode(Node);
	}
	@Override public void VisitCommandNode(ZenCommandNode Node) {
		this.DebugAppendNode(Node);
	}
}
