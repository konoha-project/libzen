//// ***************************************************************************
//// Copyright (c) 2013, JST/CREST DEOS project authors. All rights reserved.
//// Redistribution and use in source and binary forms, with or without
//// modification, are permitted provided that the following conditions are met:
////
//// *  Redistributions of source code must retain the above copyright notice,
////    this list of conditions and the following disclaimer.
//// *  Redistributions in binary form must reproduce the above copyright
////    notice, this list of conditions and the following disclaimer in the
////    documentation and/or other materials provided with the distribution.
////
//// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
//// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
//// TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
//// PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
//// CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
//// EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
//// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
//// OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
//// WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
//// OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
//// ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//// **************************************************************************
//
////ifdef  JAVA
//package org.ZenScript;
//import java.util.ArrayList;
//
//
//import parser.ZenClassField;
//import parser.ZenFieldInfo;
//import parser.ZenFunc;
//import parser.ZenSyntaxTree;
//import parser.ZenType;
//import parser.ast.ZenCatchNode;
//import parser.ast.ZenContinueNode;
//import parser.ast.ZenDoWhileNode;
//import parser.ast.ZenErrorNode;
//import parser.ast.ZenForNode;
//import parser.ast.ZenGetterNode;
//import parser.ast.ZenIfNode;
//import parser.ast.ZenNode;
//import parser.ast.ZenThrowNode;
//import parser.ast.ZenTryNode;
//import parser.ast.ZenVarNode;
//import parser.ast.ZenWhileNode;
//
////Zen Generator should be written in each language.
//
//public class ScalaSourceGenerator extends SourceGenerator {
//	@Field String OutFileName;
//	ScalaSourceGenerator(String TargetCode, String OutputFile, int GeneratorFlag) {
//		super(TargetCode, OutputFile, GeneratorFlag);
//		this.OutFileName = OutputFile;
//		if(LibZen.EqualsString(this.OutFileName, "-")) {
//			this.OutFileName = "Zen";
//		} else {
//			this.OutFileName = this.OutFileName.replace("/", "_").replace(".", "_").replace("-", "_");
//		}
//	}
//
//	private String LocalTypeName(ZenType Type) {
//		if(Type.IsDynamicType() || Type.IsNativeType()) {
//			if(Type.IsVoidType()) {
//				return "Unit";
//			}
//			if(Type.IsIntType()) {
//				return "Int";
//			}
//			if(Type.IsFloatType()) {
//				return "Double";
//			}
//			if(Type.IsBooleanType()) {
//				return "Boolean";
//			}
//		}
//		return Type.ShortName;
//	}
//
//	// copied from PythonSourceGenerator
//	@Override public void VisitForNode(ZenForNode Node) {
//		/* for(; COND; ITER) BLOCK1; continue; BLOCK2;
//		 * => while COND:
//		 * 		BLOCK1;
//		 * 		ITER;continue;
//		 * 		BLOCK2;
//		 * 		ITER
//		 */
//		@Var String Program = "while(" + this.VisitNode(Node.AST[ZIfNode.Cond]) + ")" + this.LineFeed;
//		Program += this.GetIndentString() + "{";
//		this.Indent();
//		Program += this.VisitBlockWithIndent(Node.BodyNode, false);
//		Program += this.VisitBlockWithIndent(Node.IterNode, false);
//		Program += this.GetIndentString() + "}";
//		this.UnIndent();
//		this.PushSourceCode(Program);
//	}
//
//	@Override public void VisitContinueNode(ZenContinueNode Node) {
//		@Var String Code = "";
//		@Var ZenForNode Parent = this.FindParentForNode(Node);
//		if(Parent != null) {
//			@Var ZenNode IterNode = Parent.IterNode;
//			if(IterNode != null) {
//				Code += this.VisitNode(IterNode) + this.LineFeed + this.GetIndentString();
//			}
//		}
//		Code += this.ContinueKeyword;
//		if(this.HasLabelSupport) {
//			@Var String Label = Node.Label;
//			if(Label != null) {
//				Code += " " + Label;
//			}
//		}
//		this.PushSourceCode(Code);
//		this.StopVisitor(Node);
//	}
//	
//	@Override public void VisitWhileNode(ZenWhileNode Node) {
//		@Var String Program = "while(" + this.VisitNode(Node.AST[ZIfNode.Cond]) + ")";
//		Program += this.VisitBlockWithIndent(Node.BodyNode, true);
//		this.PushSourceCode(Program);
//	}
//
//	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
//		@Var String Program = "do" + this.VisitBlockWithIndent(Node.BodyNode, true);
//		Program += " while(" + this.VisitNode(Node.AST[ZIfNode.Cond]) + ")";
//		this.PushSourceCode(Program);
//	}
//
//	@Override public void VisitGetterNode(ZenGetterNode Node) {
//		@Var String Program = this.VisitNode(Node.AST[ZGetterNode.Recv]);
//		@Var String FieldName = Node.ResolvedFunc.FuncName;
//		Program = Program + "." + FieldName;
//		this.PushSourceCode(Program);
//	}
//
//	@Override public void VisitVarNode(ZenVarNode Node) {
//		@Var String Type = this.LocalTypeName(Node.DeclType);
//		@Var String VarName = Node.NativeName;
//		@Var String Code = "var " + VarName + " : " + Type + " ";
//		@Var boolean CreateNewScope = true;
//		if(Node.InitNode != null) {
//			Code += " = " + this.VisitNode(Node.InitNode);
//		}
//		Code += ";" + this.LineFeed;
//		if(CreateNewScope) {
//			Code += this.GetIndentString();
//		}
//		Code += this.VisitBlockWithIndent(Node.BlockNode, CreateNewScope);
//		this.PushSourceCode(Code + this.PopSourceCode());
//	}
//
//	@Override public void VisitIfNode(ZenIfNode Node) {
//		@Var String CondNode = this.VisitNode(Node.AST[ZIfNode.Cond]);
//		@Var String ThenBlock = this.VisitBlockWithIndent(Node.AST[ZIfNode.Then], true);
//		@Var String Code = "if(" + CondNode + ") " + ThenBlock;
//		if(Node.AST[ZIfNode.Else] != null) {
//			Code += " else " + this.VisitBlockWithIndent(Node.AST[ZIfNode.Else], true);
//		}
//		this.PushSourceCode(Code);
//	}
//
//	@Override public void VisitTryNode(ZenTryNode Node) {
//		@Var String Code = "try ";
//		Code += this.VisitBlockWithIndent(Node.AST[ZTryNode.Try], true);
//		for (int i = 0; i < LibZen.ListSize(Node.CatchList); i++) {
//			ZenCatchNode Catch = (ZenCatchNode) Node.CatchList.get(i);
//			Code += " catch (" + Catch.ExceptionType + " " + Catch.ExceptionName + ") ";
//			Code += this.VisitBlockWithIndent(Catch.BodyNode, true);
//		}
//		if(Node.AST[ZTryNode.Finally] != null) {
//			Code += " finally " + this.VisitBlockWithIndent(Node.AST[ZTryNode.Finally], true);
//		}
//		this.PushSourceCode(Code);
//	}
//
//
//	@Override public void VisitThrowNode(ZenThrowNode Node) {
//		@Var String Code = "throw " + this.VisitNode(Node.ValueNode);
//		this.PushSourceCode(Code);
//	}
//
//	@Override public void VisitErrorNode(ZenErrorNode Node) {
//		@Var String Code = "throw RuntimeError(\"" + Node.SourceToken.GetText() + "\")";
//		this.PushSourceCode(Code);
//	}
//
////	@Override public Object Eval(ZenNode Node) {
////		@Var String Code = this.VisitBlockWithIndent(Node, false);
////		if(LibZen.EqualsString(Code, ";" + this.LineFeed)) {
////			return "";
////		}
////		this.WriteLineCode(Code);
////		return Code;
////	}
//
//	@Override public void GenerateFunc(ZenFunc Func, ArrayList<String> ParamNameList, ZenNode Body) {
//		this.FlushErrorReport();
//		@Var String Function = "def ";
//		Function += Func.GetNativeFuncName() + "(";
//		@Var int i = 0;
//		@Var int size = ParamNameList.size();
//		while(i < size) {
//			if(i > 0) {
//				Function += ", ";
//			}
//			@Var String ParamTy = this.LocalTypeName(Func.GetFuncParamType(i));
//			Function += ParamNameList.get(i) + " : " + ParamTy;
//			i = i + 1;
//		}
//		@Var String Block = this.VisitBlockWithIndent(Body, true);
//		Function += ") : " + this.LocalTypeName(Func.GetReturnType()) + " = " + this.LineFeed + Block + this.LineFeed;
//		this.WriteLineCode(Function);
//	}
//
//	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {
//		@Var String TypeName = this.LocalTypeName(Type);
//		@Var String Program = this.GetIndentString() + "class " + TypeName;
////		if(Type.SuperType != null) {
////			Program += " extends " + Type.SuperType;
////		}
//		Program += " {" + this.LineFeed;
//		this.Indent();
//		@Var int i = ClassField.ThisClassIndex;
//		while(i < ClassField.GetParamSize()) {
//			@Var ZenFieldInfo FieldInfo = ClassField.GetFieldNode(i);
//			@Var ZenType VarType = FieldInfo.Type;
//			@Var String VarName = FieldInfo.NativeName;
//			Program += this.GetIndentString() + "var " + VarName + " : ";
//			Program += this.LocalTypeName(VarType) + " = _/*default value*/;" + this.LineFeed;
//			i = i + 1;
//		}
//		this.UnIndent();
//		Program += this.GetIndentString() + "};" + this.LineFeed;
//		Program += this.GetIndentString() + "def constructor(self : " + TypeName + ") : " + this.LocalTypeName(Type);
//		Program += " = {" + this.LineFeed;
//		this.Indent();
//		i = 0;
////		Program += this.GetIndentString() + "var " + this.GetRecvName() + " : " + this.LocalTypeName(Type);
////		Program += " = new " + this.LocalTypeName(Type) + "();" + this.LineFeed;
//		while(i < ClassField.GetParamSize()) {
//			@Var ZenFieldInfo FieldInfo = ClassField.GetFieldNode(i);
//			@Var String VarName = FieldInfo.NativeName;
//			@Var String InitValue = this.StringifyConstValue(FieldInfo.InitValue);
//			if(!FieldInfo.Type.IsNativeType()) {
//				InitValue = this.NullLiteral;
//			}
//			Program += this.GetIndentString() + this.GetRecvName() + "." + VarName + " = " + InitValue + ";" + this.LineFeed;
//			i = i + 1;
//		}
//		Program += this.GetIndentString() + "return " + this.GetRecvName() + ";" + this.LineFeed;
//		this.UnIndent();
//		Program += this.GetIndentString() + "};";
//		
//		this.WriteLineCode(Program);
//	}
//
////	@Override public void StartCompilationUnit() {
////		this.WriteLineCode("object " + this.OutFileName + " {");
////	}
////
////	@Override public void FinishCompilationUnit() {
////		this.WriteLineCode("}");
////	}
//	@Override public void InvokeMainFunc(String MainFuncName) {
//		this.WriteLineCode("def main(args: Array[String]) {");
//		this.WriteLineCode(this.Tab + MainFuncName + "()");
//		this.WriteLineCode("}");
//	}
//
//	@Override public String GetRecvName() {
//		return "self";
//	}
//}