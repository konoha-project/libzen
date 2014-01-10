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
//package org.GreenTeaScript;
//import java.util.ArrayList;
////endif VAJA
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
//import parser.ast.ZenVarDeclNode;
//import parser.ast.ZenWhileNode;
//
////GreenTea Generator should be written in each language.
//
//public class ScalaSourceGenerator extends SourceGenerator {
//	/*field*/String OutFileName;
//	ScalaSourceGenerator/*constructor*/(String TargetCode, String OutputFile, int GeneratorFlag) {
//		super(TargetCode, OutputFile, GeneratorFlag);
//		this.OutFileName = OutputFile;
//		if(LibGreenTea.EqualsString(this.OutFileName, "-")) {
//			this.OutFileName = "GreenTea";
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
//		/*local*/String Program = "while(" + this.VisitNode(Node.CondNode) + ")" + this.LineFeed;
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
//		/*local*/String Code = "";
//		/*local*/ZenForNode Parent = this.FindParentForNode(Node);
//		if(Parent != null) {
//			/*local*/ZenNode IterNode = Parent.IterNode;
//			if(IterNode != null) {
//				Code += this.VisitNode(IterNode) + this.LineFeed + this.GetIndentString();
//			}
//		}
//		Code += this.ContinueKeyword;
//		if(this.HasLabelSupport) {
//			/*local*/String Label = Node.Label;
//			if(Label != null) {
//				Code += " " + Label;
//			}
//		}
//		this.PushSourceCode(Code);
//		this.StopVisitor(Node);
//	}
//	
//	@Override public void VisitWhileNode(ZenWhileNode Node) {
//		/*local*/String Program = "while(" + this.VisitNode(Node.CondNode) + ")";
//		Program += this.VisitBlockWithIndent(Node.BodyNode, true);
//		this.PushSourceCode(Program);
//	}
//
//	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
//		/*local*/String Program = "do" + this.VisitBlockWithIndent(Node.BodyNode, true);
//		Program += " while(" + this.VisitNode(Node.CondNode) + ")";
//		this.PushSourceCode(Program);
//	}
//
//	@Override public void VisitGetterNode(ZenGetterNode Node) {
//		/*local*/String Program = this.VisitNode(Node.RecvNode);
//		/*local*/String FieldName = Node.ResolvedFunc.FuncName;
//		Program = Program + "." + FieldName;
//		this.PushSourceCode(Program);
//	}
//
//	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
//		/*local*/String Type = this.LocalTypeName(Node.DeclType);
//		/*local*/String VarName = Node.NativeName;
//		/*local*/String Code = "var " + VarName + " : " + Type + " ";
//		/*local*/boolean CreateNewScope = true;
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
//		/*local*/String CondNode = this.VisitNode(Node.CondNode);
//		/*local*/String ThenBlock = this.VisitBlockWithIndent(Node.ThenNode, true);
//		/*local*/String Code = "if(" + CondNode + ") " + ThenBlock;
//		if(Node.ElseNode != null) {
//			Code += " else " + this.VisitBlockWithIndent(Node.ElseNode, true);
//		}
//		this.PushSourceCode(Code);
//	}
//
//	@Override public void VisitTryNode(ZenTryNode Node) {
//		/*local*/String Code = "try ";
//		Code += this.VisitBlockWithIndent(Node.TryNode, true);
//		for (int i = 0; i < LibGreenTea.ListSize(Node.CatchList); i++) {
//			ZenCatchNode Catch = (/*cast*/ZenCatchNode) Node.CatchList.get(i);
//			Code += " catch (" + Catch.ExceptionType + " " + Catch.ExceptionName + ") ";
//			Code += this.VisitBlockWithIndent(Catch.BodyNode, true);
//		}
//		if(Node.FinallyNode != null) {
//			Code += " finally " + this.VisitBlockWithIndent(Node.FinallyNode, true);
//		}
//		this.PushSourceCode(Code);
//	}
//
//
//	@Override public void VisitThrowNode(ZenThrowNode Node) {
//		/*local*/String Code = "throw " + this.VisitNode(Node.ValueNode);
//		this.PushSourceCode(Code);
//	}
//
//	@Override public void VisitErrorNode(ZenErrorNode Node) {
//		/*local*/String Code = "throw RuntimeError(\"" + Node.Token.ParsedText + "\")";
//		this.PushSourceCode(Code);
//	}
//
////	@Override public Object Eval(ZenNode Node) {
////		/*local*/String Code = this.VisitBlockWithIndent(Node, false);
////		if(LibGreenTea.EqualsString(Code, ";" + this.LineFeed)) {
////			return "";
////		}
////		this.WriteLineCode(Code);
////		return Code;
////	}
//
//	@Override public void GenerateFunc(ZenFunc Func, ArrayList<String> ParamNameList, ZenNode Body) {
//		this.FlushErrorReport();
//		/*local*/String Function = "def ";
//		Function += Func.GetNativeFuncName() + "(";
//		/*local*/int i = 0;
//		/*local*/int size = ParamNameList.size();
//		while(i < size) {
//			if(i > 0) {
//				Function += ", ";
//			}
//			/*local*/String ParamTy = this.LocalTypeName(Func.GetFuncParamType(i));
//			Function += ParamNameList.get(i) + " : " + ParamTy;
//			i = i + 1;
//		}
//		/*local*/String Block = this.VisitBlockWithIndent(Body, true);
//		Function += ") : " + this.LocalTypeName(Func.GetReturnType()) + " = " + this.LineFeed + Block + this.LineFeed;
//		this.WriteLineCode(Function);
//	}
//
//	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {
//		/*local*/String TypeName = this.LocalTypeName(Type);
//		/*local*/String Program = this.GetIndentString() + "class " + TypeName;
////		if(Type.SuperType != null) {
////			Program += " extends " + Type.SuperType;
////		}
//		Program += " {" + this.LineFeed;
//		this.Indent();
//		/*local*/int i = ClassField.ThisClassIndex;
//		while(i < ClassField.FieldList.size()) {
//			/*local*/ZenFieldInfo FieldInfo = ClassField.FieldList.get(i);
//			/*local*/ZenType VarType = FieldInfo.Type;
//			/*local*/String VarName = FieldInfo.NativeName;
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
//		while(i < ClassField.FieldList.size()) {
//			/*local*/ZenFieldInfo FieldInfo = ClassField.FieldList.get(i);
//			/*local*/String VarName = FieldInfo.NativeName;
//			/*local*/String InitValue = this.StringifyConstValue(FieldInfo.InitValue);
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