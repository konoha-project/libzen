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
package zen.codegen.llvm;

import java.util.ArrayList;
import java.util.HashMap;

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZClassDeclNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZIntNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZStringNode;
import zen.ast.ZSymbolNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.lang.ZenClassType;
import zen.parser.ZSourceGenerator;
import zen.type.ZFuncType;
import zen.type.ZGeneric1Type;
import zen.type.ZType;
//TODO
//import zen.ast.ZCatchNode;
//import zen.ast.ZConstPoolNode;
//import zen.ast.ZEmptyNode;
//import zen.ast.ZErrorNode;
//TODO
//import zen.ast.ZGetterNode; //TODO
//import zen.ast.ZInstanceOfNode;
//TODO
//import zen.ast.ZMethodCallNode; //TODO
//import zen.ast.ZNewArrayNode; //TODO
//import zen.ast.ZNewObjectNode; //TODO
//import zen.ast.ZSetterNode; //TODO
//import zen.ast.ZThrowNode;
//import zen.ast.ZTryNode;


public class LLVMSourceGenerator extends ZSourceGenerator {
	private int TempSymbolNumber;
	private boolean IsBlockTerminated;
	private String CurrentLabel;
	private final ArrayList<String> GlobalSymbolList;
	private final ArrayList<String> LocalSymbolList;
	private final ArrayList<String> LocalVarList;
	private final HashMap<String, ArrayList<ZFieldNode>> ClassFieldMap;
	private final ArrayList<String> BreakLabelStack;
	private final ArrayList<String> CodeBufferList;

	//private final ScriptEngineManager EngineManager;
	//private final ScriptEngine Engine;

	public LLVMSourceGenerator() {
		super("LLVM", "3.1");
		this.LineFeed = "\n";
		this.Tab = "\t";
		this.LineComment = ";"; // if not, set null
		this.BeginComment = null; //"'''";
		this.EndComment = null; //"'''";
		this.Camma = ", ";
		this.SemiColon = "";

		this.TrueLiteral = "true";
		this.FalseLiteral = "false";
		this.NullLiteral = "null";
		this.TopType = "opaque";
		this.SetNativeType(ZType.VoidType, "void");
		this.SetNativeType(ZType.BooleanType, "i1");
		this.SetNativeType(ZType.IntType, "i64");
		this.SetNativeType(ZType.FloatType, "double");
		this.SetNativeType(ZType.StringType, "i8*");

		this.TempSymbolNumber = 0;
		this.IsBlockTerminated = false;
		this.CurrentLabel = null;
		this.GlobalSymbolList = new ArrayList<String>();
		this.LocalSymbolList = new ArrayList<String>();
		this.LocalVarList = new ArrayList<String>();
		this.ClassFieldMap = new HashMap<String, ArrayList<ZFieldNode>>();
		this.BreakLabelStack = new ArrayList<String>();
		this.CodeBufferList = new ArrayList<String>();
		//this.EngineManager = new ScriptEngineManager();
		//this.Engine = this.EngineManager.getEngineByName("js");
	}

	private String CreateTempVar() {
		String TempVar = "temp__" + this.TempSymbolNumber++;
		this.PutLocalSymbol(TempVar);
		return this.GetIdentifierAttachedSymbol(TempVar);
	}
	private String CreateGlobalConst() {
		String TempVar = "global__" + this.TempSymbolNumber++;
		this.PutGlobalSymbol(TempVar);
		return this.GetIdentifierAttachedSymbol(TempVar);
	}
	private int GetTempLabelNumber() {
		return this.TempSymbolNumber++;
	}

	private void PutGlobalSymbol(String Symbol) {
		this.GlobalSymbolList.add(Symbol);
	}
	private void PutLocalSymbol(String Symbol) {
		this.LocalSymbolList.add(Symbol);
	}
	private void ResetLocalSymbol() {
		this.LocalSymbolList.clear();
		this.LocalVarList.clear();
	}
	private void DefineLocalVar(String VarName) {
		this.LocalVarList.add(VarName);
		this.PutLocalSymbol(VarName);
	}
	private void DefineClass(String ClassName, ArrayList<ZFieldNode> FieldList) {
		this.ClassFieldMap.put(ClassName, FieldList);
	}
	private String GetIdentifierAttachedSymbol(String Symbol) {
		if(this.LocalSymbolList.contains(Symbol)) {
			return "%" + Symbol;
		}
		else if(this.GlobalSymbolList.contains(Symbol)) {
			return "@" + Symbol;
		}
		else {
			return null;
		}
	}
	private boolean IsUserDefinedVar(String Symbol) {
		return this.LocalVarList.contains(Symbol);
	}
	private boolean IsUserDefinedClass(String ClassName) {
		return this.ClassFieldMap.containsKey(ClassName);
	}
	private void PushBreakLabel(String Label) {
		this.BreakLabelStack.add(Label);
	}
	private String PopBreakLabel() {
		int Size = this.BreakLabelStack.size();
		return this.BreakLabelStack.remove(Size-1);
	}
	private String PeekBreakLabel() {
		int Size = this.BreakLabelStack.size();
		return this.BreakLabelStack.get(Size-1);
	}

	private void PushNewBuffer(String Text) {
		this.CodeBufferList.add(Text);
	}
	private void AddCodeToCurrentBuffer(String NewText) {
		int Size = this.CodeBufferList.size();
		if(Size <= 0) {
			this.CodeBufferList.add(NewText);
		}
		else {
			String OldText = this.CodeBufferList.remove(Size-1);
			this.CodeBufferList.add(OldText + NewText);
		}
	}
	private String PopCurrentBuffer() {
		int Size = this.CodeBufferList.size();
		if(Size > 0) {
			return this.CodeBufferList.remove(Size-1);
		}
		return null;
	}
	private void AppendBufferAsNewLine() {
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append(this.PopCurrentBuffer());
		this.CurrentBuilder.AppendLineFeed();
	}
	private void AppendOneLine(String Text) {
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append(Text);
		this.CurrentBuilder.AppendLineFeed();
	}
	private void AppendBufferAsHedderLine() {
		this.CurrentBuilder.SourceList.add(0, this.PopCurrentBuffer() + "\n");
	}
	private void AppendLabel(String Label) {
		this.CurrentBuilder.UnIndent();
		this.AppendOneLine(Label + ": ");
		this.CurrentBuilder.Indent();
		this.IsBlockTerminated = false;
		this.CurrentLabel = Label;
	}

	private String GetBinaryOpcode(ZBinaryNode Node) {
		String Binary = Node.SourceToken.GetText();
		if(Binary.equals("+")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "add";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fadd";
			}
		}
		else if(Binary.equals("-")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "sub";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fsub";
			}
		}
		else if(Binary.equals("*")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "mul";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fmul";
			}
		}
		else if(Binary.equals("/")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "sdiv";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fdiv";
			}
		}
		else if(Binary.equals("%")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "srem";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "frem";
			}
		}
		throw new RuntimeException("Can't use this binary\"" + Binary + "\"");
	}
	private String GetCompareOpCodeAndCondition(ZComparatorNode Node) {
		String Comparator = Node.SourceToken.GetText();
		if(Comparator.equals("==")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "icmp eq";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fcmp oeq";
			}
		}
		else if(Comparator.equals("!=")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "icmp ne";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fcmp one";
			}
		}
		else if(Comparator.equals("<")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "icmp slt";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fcmp olt";
			}
		}
		else if(Comparator.equals("<=")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "icmp sle";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fcmp ole";
			}
		}
		else if(Comparator.equals(">")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "icmp sgt";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fcmp ogt";
			}
		}
		else if(Comparator.equals(">=")) {
			if(Node.LeftNode.Type.IsIntType() && Node.RightNode.Type.IsIntType()) {
				return "icmp sge";
			}
			else if(Node.LeftNode.Type.IsFloatType() && Node.RightNode.Type.IsFloatType()) {
				return "fcmp oge";
			}
		}
		throw new RuntimeException("Can't use this comparator\"" + Comparator + "\"");
	}
	private String GetCastOpCode(ZType BeforeType, ZType AfterType) {
		if(BeforeType.IsIntType()) {
			if(AfterType.IsFloatType()) {
				return "sitofp";
			}
		}
		else if(BeforeType.IsFloatType()) {
			if(AfterType.IsIntType()) {
				return "fptosi";
			}
		}
		throw new RuntimeException("Can't use this cast " + BeforeType.ShortName + " to " + AfterType.ShortName);
	}

	private String ConvertLLVMString(String StringValue) {
		char[] CharArray = StringValue.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < CharArray.length; ++i) {
			char ch = CharArray[i];
			if(ch == '\n') {
				sb.append("\\0A");
			}
			else if(ch == '\t') {
				sb.append("\\09");
			}
			else if(ch == '"') {
				sb.append("\\22");
			}
			else if(ch == '\\') {
				sb.append("\\5C");
			}
			else {
				sb.append(ch);
			}
		}
		sb.append("\\00");
		return sb.toString();
	}

	private int GetLLVMStringLen(String FormedString) {
		char[] CharArray = FormedString.toCharArray();
		int i = 0;
		int Len = 0;
		while(i < CharArray.length) {
			char ch = CharArray[i];
			if(ch == '\\') {
				i = i + 3;
			}
			else {
				++i;
			}
			++Len;
		}
		return Len;
	}

	@Override
	public boolean StartCodeGeneration(ZNode Node, boolean AllowLazy, boolean IsInteractive) {
		if (AllowLazy && Node.IsVarType()) {
			return false;
		}
		Node.Accept(this);
		//if(IsInteractive) {
		String Code = this.CurrentBuilder.toString();
		LibNative.println(Code);
		this.CurrentBuilder.Clear();
		//}
		return true;
	}

	@Override
	public void VisitAndNode(ZAndNode Node) {
		int LabelNum = this.GetTempLabelNumber();
		String LeftLabel = "AndLeft__" + LabelNum;
		String RightLabel = "AndRight__" + LabelNum;
		String EndLabel = "AndEnd__" + LabelNum;

		this.AppendOneLine("br label %" + LeftLabel);

		this.AppendLabel(LeftLabel);
		this.PushNewBuffer("br i1 ");
		this.GenerateCode(Node.LeftNode);
		this.AddCodeToCurrentBuffer(", ");
		this.AddCodeToCurrentBuffer("label %" + RightLabel + ", ");
		this.AddCodeToCurrentBuffer("label %" + EndLabel);
		this.AppendBufferAsNewLine();
		LeftLabel = this.CurrentLabel;

		this.AppendLabel(RightLabel);
		this.PushNewBuffer("");
		this.GenerateCode(Node.RightNode);
		String RightResult = this.PopCurrentBuffer();
		this.AppendOneLine("br label %" + EndLabel);
		RightLabel = this.CurrentLabel;

		this.AppendLabel(EndLabel);
		String AllResult = this.CreateTempVar();
		this.PushNewBuffer(AllResult);
		this.AddCodeToCurrentBuffer(" = phi i1 ");
		this.AddCodeToCurrentBuffer("[ false, %" + LeftLabel + " ], ");
		this.AddCodeToCurrentBuffer("[ " + RightResult + ", %" + RightLabel + " ]");
		this.AppendBufferAsNewLine();
		this.AddCodeToCurrentBuffer(AllResult);
	}

	@Override
	public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		String GlobalConst = this.CreateGlobalConst();
		this.PushNewBuffer(GlobalConst);
		this.AddCodeToCurrentBuffer(" = private constant ");
		int ListSize = Node.NodeList.size();
		this.VisitArrayType(ListSize, Node.Type);

		this.AddCodeToCurrentBuffer(" [");
		for(int i = 0; i < ListSize; ++i) {
			if (i > 0) {
				this.AddCodeToCurrentBuffer(", ");
			}
			ZNode SubNode = Node.NodeList.get(i);
			this.VisitType(SubNode.Type);
			this.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(SubNode);
		}
		this.AddCodeToCurrentBuffer("]");
		this.AppendBufferAsHedderLine();

		String TempVar = this.CreateTempVar();
		this.PushNewBuffer(TempVar);
		this.AddCodeToCurrentBuffer(" = getelementptr ");
		this.VisitArrayTypeAsPointer(ListSize, Node.Type);
		this.AddCodeToCurrentBuffer(" " + GlobalConst);
		this.AddCodeToCurrentBuffer(", i64 0, i64 0");
		this.AppendBufferAsNewLine();
		this.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitBinaryNode(ZBinaryNode Node) {
		String TempVar = this.CreateTempVar();
		this.PushNewBuffer(TempVar);
		this.AddCodeToCurrentBuffer(" = ");
		this.AddCodeToCurrentBuffer(this.GetBinaryOpcode(Node));
		this.AddCodeToCurrentBuffer(" ");
		this.VisitType(Node.LeftNode.Type);
		this.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.LeftNode);
		this.AddCodeToCurrentBuffer(", ");
		this.GenerateCode(Node.RightNode);
		this.AppendBufferAsNewLine();
		this.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitBreakNode(ZBreakNode Node) {
		this.AppendOneLine("br label %" + this.PeekBreakLabel());
		this.IsBlockTerminated = true;
	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		this.VisitStmtList(Node.StmtList);
	}

	@Override
	public void VisitBooleanNode(ZBooleanNode Node) {
		if (Node.BooleanValue) {
			this.AddCodeToCurrentBuffer(this.TrueLiteral);
		} else {
			this.AddCodeToCurrentBuffer(this.FalseLiteral);
		}
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		/*FIXME*/
		ZType BeforeType = Node.ExprNode.Type;
		ZType AfterType = Node.Type;
		if(BeforeType == AfterType) {
			this.GenerateCode(Node.ExprNode);
		}
		//		else if(Node instanceof ZStupidCastNode) {
		//			this.PushNewBuffer(";");
		//			this.AddCodeToCurrentBuffer("stupid cast ");
		//			this.AddCodeToCurrentBuffer(BeforeType.ShortName);
		//			this.AddCodeToCurrentBuffer(" to ");
		//			this.AddCodeToCurrentBuffer(AfterType.ShortName);
		//			this.AppendBufferAsNewLine();
		//			this.GenerateSurroundCode(Node.ExprNode);
		//		}
		else if(!(BeforeType.IsVoidType()) && AfterType.IsVoidType()) {
			this.GenerateCode(Node.ExprNode);
			this.PopCurrentBuffer();
		}
		else {
			String TempVar = this.CreateTempVar();
			this.PushNewBuffer(TempVar);
			this.AddCodeToCurrentBuffer(" = ");
			this.AddCodeToCurrentBuffer(this.GetCastOpCode(BeforeType, AfterType));
			this.AddCodeToCurrentBuffer(" ");
			this.VisitType(BeforeType);
			this.AddCodeToCurrentBuffer(" ");
			this.GenerateSurroundCode(Node.ExprNode);
			this.AddCodeToCurrentBuffer(" to ");
			this.VisitType(AfterType);
			this.AppendBufferAsNewLine();
			this.AddCodeToCurrentBuffer(TempVar);
		}
	}

	@Override
	public void VisitClassDeclNode(ZClassDeclNode Node) {
		this.DefineClass(Node.ClassName, Node.FieldList);
		if(Node.SuperType != null) {
			throw new RuntimeException("Not implemented class extend");
			//(Node.SuperType);
		}
		this.PushNewBuffer("%Class__");
		this.AddCodeToCurrentBuffer(Node.ClassName);
		this.AddCodeToCurrentBuffer(" = type { ");
		@Var int i = 0;
		while (i < Node.FieldList.size()) {
			if(i > 0) {
				this.AddCodeToCurrentBuffer(", ");
			}
			@Var ZFieldNode FieldNode = Node.FieldList.get(i);
			this.VisitType(FieldNode.DeclType);
			this.AddCodeToCurrentBuffer(" ");
			//this.GenerateCode(FieldNode.InitNode);
			i = i + 1;
		}
		this.AddCodeToCurrentBuffer("}");
		this.AppendBufferAsNewLine();
	}

	@Override
	public void VisitComparatorNode(ZComparatorNode Node) {
		String TempVar = this.CreateTempVar();
		this.PushNewBuffer(TempVar);
		this.AddCodeToCurrentBuffer(" = ");
		this.AddCodeToCurrentBuffer(this.GetCompareOpCodeAndCondition(Node));
		this.AddCodeToCurrentBuffer(" ");
		this.VisitType(Node.LeftNode.Type);
		this.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.LeftNode);
		this.AddCodeToCurrentBuffer(", ");
		this.GenerateCode(Node.RightNode);
		this.AppendBufferAsNewLine();
		this.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitFloatNode(ZFloatNode Node) {
		this.AddCodeToCurrentBuffer("" + Node.FloatValue);
	}

	@Override
	public void VisitFuncCallNode(ZFuncCallNode Node) {
		if(Node.ResolvedFuncName != null && Node.ResolvedFuncType != null) {
			ZType ReturnType = Node.ResolvedFuncType.TypeParams[0];
			String TempVar = "";
			this.PushNewBuffer("");
			if(!ReturnType.IsVoidType()) {
				TempVar = this.CreateTempVar();
				this.AddCodeToCurrentBuffer(TempVar);
				this.AddCodeToCurrentBuffer(" = ");
			}
			this.AddCodeToCurrentBuffer("call ");
			this.VisitFuncTypeAsPointer(Node.ResolvedFuncType);
			this.AddCodeToCurrentBuffer(" " + this.GetIdentifierAttachedSymbol(Node.ResolvedFuncName));
			//this.GenerateCode(Node.FuncNode);
			this.VisitNodeList(" (", Node.ParamList, ")");
			this.AppendBufferAsNewLine();
			if(!ReturnType.IsVoidType()) {
				this.AddCodeToCurrentBuffer(TempVar);
			}
		}
		else {
			throw new RuntimeException("Function object is not implemented");
		}
	}

	public void VisitFuncDeclNode(ZFunctionNode Node) {
		this.PushNewBuffer("define ");
		this.VisitType(Node.ReturnType);
		this.PutGlobalSymbol(Node.FuncName);
		this.AddCodeToCurrentBuffer(" " + this.GetIdentifierAttachedSymbol(Node.FuncName) + " ");
		this.VisitParamList("(", Node.ParamList, ") {");
		this.AppendBufferAsNewLine();

		this.CurrentBuilder.Indent();
		this.AppendLabel("FirstLabel");
		this.GenerateCode(Node.FuncBlock);
		if(!this.IsBlockTerminated) {
			this.AppendDefaultReturn(Node.ReturnType);
		}
		this.CurrentBuilder.UnIndent();

		this.AppendOneLine("}");
		this.ResetLocalSymbol();
	}

	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		/*FIXME*/
		/*this.CurrentBuilder.Append("function");
		this.CurrentBuilder.AppendWhiteSpace();
		this.VisitParamList("(", Node.ArgumentList, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		this.GenerateCode(Node.BodyNode);*/
	}

	@Override
	public void VisitGetIndexNode(ZGetIndexNode Node) {
		String TempVar = this.CreateTempVar();
		this.PushNewBuffer(TempVar);
		this.AddCodeToCurrentBuffer(" = load ");
		this.VisitTypeAsPointer(Node.Type);
		this.AddCodeToCurrentBuffer(" ");
		this.GetArrayElementPointer(Node.RecvNode, Node.IndexNode);
		this.AppendBufferAsNewLine();
		this.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitGetNameNode(ZGetNameNode Node) {
		String VarSymbol = this.GetIdentifierAttachedSymbol(Node.VarName);
		if(this.IsUserDefinedVar(Node.VarName)) {
			String TempVar = this.CreateTempVar();
			this.PushNewBuffer(TempVar);
			this.AddCodeToCurrentBuffer(" = load ");
			this.VisitTypeAsPointer(Node.Type);
			this.AddCodeToCurrentBuffer(" " + VarSymbol);
			this.AppendBufferAsNewLine();
			this.AddCodeToCurrentBuffer(TempVar);
		}
		else {
			this.AddCodeToCurrentBuffer(VarSymbol);
		}
	}

	@Override
	public void VisitGroupNode(ZGroupNode Node) {
		this.GenerateCode(Node.RecvNode);
	}

	@Override
	public void VisitIfNode(ZIfNode Node) {
		int LabelNum = this.GetTempLabelNumber();
		String ThenLabel = "IfThen__" + LabelNum;
		String ElseLabel = "IfElse__" + LabelNum;
		String EndLabel = "IfEnd__" + LabelNum;
		boolean IsEndReachable = false;

		this.PushNewBuffer("br i1 ");
		this.GenerateCode(Node.CondNode);
		this.AddCodeToCurrentBuffer(", ");
		this.AddCodeToCurrentBuffer("label %" + ThenLabel + ", ");
		if(Node.ElseNode != null) {
			this.AddCodeToCurrentBuffer("label %" + ElseLabel);
		}
		else {
			this.AddCodeToCurrentBuffer("label %" + EndLabel);
			IsEndReachable = true;
		}
		this.AppendBufferAsNewLine();

		this.AppendLabel(ThenLabel);
		this.GenerateCode(Node.ThenNode);
		if(!this.IsBlockTerminated) {
			this.AppendOneLine("br label %" + EndLabel);
			IsEndReachable = true;
		}

		if(Node.ElseNode != null) {
			this.AppendLabel(ElseLabel);
			this.GenerateCode(Node.ElseNode);
			if(!this.IsBlockTerminated) {
				this.AppendOneLine("br label %" + EndLabel);
				IsEndReachable = true;
			}
		}
		if(IsEndReachable) {
			this.AppendLabel(EndLabel);
		}
	}

	@Override
	public void VisitIntNode(ZIntNode Node) {
		this.AddCodeToCurrentBuffer("" + Node.IntValue);
	}

	@Override
	public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		/*FIXME*/
		this.AddCodeToCurrentBuffer("{ ");
		int ListSize = Node.NodeList.size();
		for(int i = 0; i < ListSize; i = i + 2) {
			if (i > 0) {
				this.AddCodeToCurrentBuffer(", ");
			}
			ZNode ParamNode = Node.NodeList.get(i + 1);
			this.VisitType(ParamNode.Type);
			this.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(ParamNode);
		}
		this.AddCodeToCurrentBuffer(" }");
	}

	@Override
	public void VisitNotNode(ZNotNode Node) {
		String TempVar = this.CreateTempVar();
		this.PushNewBuffer(TempVar);
		this.AddCodeToCurrentBuffer(" = ");
		this.AddCodeToCurrentBuffer("xor");
		this.AddCodeToCurrentBuffer(" ");
		this.VisitType(Node.RecvNode.Type);
		this.AddCodeToCurrentBuffer(" 1, ");
		this.GenerateSurroundCode(Node.RecvNode);
		this.AppendBufferAsNewLine();
		this.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitNullNode(ZNullNode Node) {
		//this.AddCodeToCurrentBuffer(this.NullLiteral);
	}

	@Override
	public void VisitOrNode(ZOrNode Node) {
		int LabelNum = this.GetTempLabelNumber();
		String LeftLabel = "OrLeft__" + LabelNum;
		String RightLabel = "OrRight__" + LabelNum;
		String EndLabel = "OrEnd__" + LabelNum;

		this.AppendOneLine("br label %" + LeftLabel);

		this.AppendLabel(LeftLabel);
		this.PushNewBuffer("br i1 ");
		this.GenerateCode(Node.LeftNode);
		this.AddCodeToCurrentBuffer(", ");
		this.AddCodeToCurrentBuffer("label %" + EndLabel + ", ");
		this.AddCodeToCurrentBuffer("label %" + RightLabel);
		this.AppendBufferAsNewLine();
		LeftLabel = this.CurrentLabel;

		this.AppendLabel(RightLabel);
		this.PushNewBuffer("");
		this.GenerateCode(Node.RightNode);
		String RightResult = this.PopCurrentBuffer();
		this.AppendOneLine("br label %" + EndLabel);
		RightLabel = this.CurrentLabel;

		this.AppendLabel(EndLabel);
		String AllResult = this.CreateTempVar();
		this.PushNewBuffer(AllResult);
		this.AddCodeToCurrentBuffer(" = phi i1 ");
		this.AddCodeToCurrentBuffer("[ true, %" + LeftLabel + " ], ");
		this.AddCodeToCurrentBuffer("[ " + RightResult + ", %" + RightLabel + " ]");
		this.AppendBufferAsNewLine();
		this.AddCodeToCurrentBuffer(AllResult);
	}

	@Override
	public void VisitParamNode(ZParamNode Node) {
		this.PutLocalSymbol(Node.Name);
		this.AddCodeToCurrentBuffer(this.GetIdentifierAttachedSymbol(Node.Name));
	}

	@Override
	public void VisitReturnNode(ZReturnNode Node) {
		this.PushNewBuffer("ret ");
		if (Node.ValueNode != null) {
			this.VisitType(Node.ValueNode.Type);
			this.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(Node.ValueNode);
		}
		else {
			this.AddCodeToCurrentBuffer("void");
		}
		this.AppendBufferAsNewLine();
		this.IsBlockTerminated = true;
	}

	@Override
	public void VisitSetIndexNode(ZSetIndexNode Node) {
		if(Node.RecvNode instanceof ZGetNameNode) {
			String VarName = ((ZGetNameNode)Node.RecvNode).VarName;
			if(!this.IsUserDefinedVar(VarName)) {
				throw new RuntimeException("Can't assign to argument");
			}
		}
		else if(Node.RecvNode instanceof ZArrayLiteralNode) {
			throw new RuntimeException("Can't assign to constant");
		}
		this.PushNewBuffer("store ");
		this.VisitType(Node.ValueNode.Type);
		this.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.ValueNode);
		this.AddCodeToCurrentBuffer(", ");
		this.VisitTypeAsPointer(Node.ValueNode.Type);
		this.AddCodeToCurrentBuffer(" ");
		this.GetArrayElementPointer(Node.RecvNode, Node.IndexNode);
		this.AppendBufferAsNewLine();
	}

	@Override
	public void VisitSetNameNode(ZSetNameNode Node) {
		if(!this.IsUserDefinedVar(Node.VarName)) {
			throw new RuntimeException("Can't assign to argument");
		}
		this.PushNewBuffer("store ");
		this.VisitType(Node.ValueNode.Type);
		this.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.ValueNode);
		this.AddCodeToCurrentBuffer(", ");
		this.VisitTypeAsPointer(Node.ValueNode.Type);
		this.AddCodeToCurrentBuffer(" ");
		this.AddCodeToCurrentBuffer(this.GetIdentifierAttachedSymbol(Node.VarName));
		this.AppendBufferAsNewLine();
	}

	@Override
	public void VisitStringNode(ZStringNode Node) {
		String StringConst = this.CreateGlobalConst();
		this.PushNewBuffer(StringConst);
		this.AddCodeToCurrentBuffer(" = private constant ");
		String StringValue = this.ConvertLLVMString(Node.StringValue);
		int StrLen = this.GetLLVMStringLen(StringValue);
		String StringType = "[" + StrLen + " x i8]";
		this.AddCodeToCurrentBuffer(StringType);

		this.AddCodeToCurrentBuffer(" c\"" + StringValue + "\"");
		this.AppendBufferAsHedderLine();

		String TempVar = this.CreateTempVar();
		this.PushNewBuffer(TempVar);
		this.AddCodeToCurrentBuffer(" = getelementptr ");
		this.AddCodeToCurrentBuffer(StringType + "*");
		this.AddCodeToCurrentBuffer(" " + StringConst);
		this.AddCodeToCurrentBuffer(", i64 0, i64 0");
		this.AppendBufferAsNewLine();
		this.AddCodeToCurrentBuffer(TempVar);

	}

	@Override
	public void VisitSymbolNode(ZSymbolNode Node) {
		this.AddCodeToCurrentBuffer(this.GetIdentifierAttachedSymbol(Node.GivenName));
	}

	@Override
	public void VisitUnaryNode(ZUnaryNode Node) {
		if(Node.SourceToken.GetText().equals("+")) {
			this.GenerateCode(Node.RecvNode);
		}
		else if(Node.SourceToken.GetText().equals("-")){
			String TempVar = this.CreateTempVar();
			this.PushNewBuffer(TempVar);
			this.AddCodeToCurrentBuffer(" = ");
			if(Node.RecvNode.Type.IsIntType()) {
				this.AddCodeToCurrentBuffer("sub");
			}
			else if(Node.RecvNode.Type.IsFloatType()) {
				this.AddCodeToCurrentBuffer("fsub");
			}
			else {
				throw new RuntimeException("Can't use this Unary\"-\"");
			}
			this.AddCodeToCurrentBuffer(" ");
			this.VisitType(Node.RecvNode.Type);
			this.AddCodeToCurrentBuffer(" 0, ");
			this.GenerateCode(Node.RecvNode);
			this.AppendBufferAsNewLine();
			this.AddCodeToCurrentBuffer(TempVar);
		}
		else {
			throw new RuntimeException("Can't use this Unary\"" + Node.SourceToken.GetText() + "\"");
		}
	}

	@Override
	public void VisitVarDeclNode(ZVarDeclNode Node) {
		assert(Node.InitNode != null); //must be set initial value
		this.DefineLocalVar(Node.NativeName);
		String VarSymbol = this.GetIdentifierAttachedSymbol(Node.NativeName);
		this.PushNewBuffer(VarSymbol);
		this.AddCodeToCurrentBuffer(" = alloca ");
		this.VisitType(Node.DeclType);
		this.AppendBufferAsNewLine();

		if(!(Node.InitNode instanceof ZNullNode)) {
			this.PushNewBuffer("store ");
			this.VisitType(Node.InitNode.Type);
			this.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(Node.InitNode);
			this.AddCodeToCurrentBuffer(", ");
			this.VisitTypeAsPointer(Node.DeclType);
			this.AddCodeToCurrentBuffer(" ");
			this.AddCodeToCurrentBuffer(VarSymbol);
			this.AppendBufferAsNewLine();
		}
		this.VisitStmtList(Node.StmtList);
	}


	@Override
	public void VisitWhileNode(ZWhileNode Node) {
		int LabelNum = this.GetTempLabelNumber();
		String CondLabel = "WhileCond__" + LabelNum;
		String BodyLabel = "WhileBody__" + LabelNum;
		String EndLabel = "WhileEnd__" + LabelNum;

		this.AppendOneLine("br label %" + CondLabel);

		this.AppendLabel(CondLabel);
		this.PushNewBuffer("br i1 ");
		this.GenerateCode(Node.CondNode);
		this.AddCodeToCurrentBuffer(", ");
		this.AddCodeToCurrentBuffer("label %" + BodyLabel + ", ");
		this.AddCodeToCurrentBuffer("label %" + EndLabel);
		this.AppendBufferAsNewLine();

		this.AppendLabel(BodyLabel);
		this.PushBreakLabel(EndLabel);
		this.GenerateCode(Node.BodyNode);
		if(!this.IsBlockTerminated) {
			this.AppendOneLine("br label %" + CondLabel);
		}
		this.PopBreakLabel();

		this.AppendLabel(EndLabel);
	}

	@Override
	protected void GenerateSurroundCode(ZNode Node) {
		if(this.IsNeededSurroud(Node)) {
			//this.AddCodeToCurrentBuffer("(");
			this.GenerateCode(Node);
			//this.AddCodeToCurrentBuffer(")");
		}
		else {
			this.GenerateCode(Node);
		}
	}

	@Override
	public void VisitStmtList(ArrayList<ZNode> StmtList) {
		@Var int i = 0;
		while (i < StmtList.size()) {
			@Var ZNode SubNode = StmtList.get(i);
			this.GenerateCode(SubNode);
			i = i + 1;
		}
	}

	@Override
	protected void VisitParamList(String OpenToken, ArrayList<ZParamNode> ParamList, String CloseToken) {
		this.AddCodeToCurrentBuffer(OpenToken);
		@Var int i = 0;
		while(i < ParamList.size()) {
			@Var ZNode ParamNode = ParamList.get(i);
			if (i > 0) {
				this.AddCodeToCurrentBuffer(", ");
			}
			this.VisitType(ParamNode.Type);
			this.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(ParamNode);
			i = i + 1;
		}
		this.AddCodeToCurrentBuffer(CloseToken);
	}

	private void GetArrayElementPointer(ZNode RecvNode, ZNode IndexNode) {
		String TempVar = this.CreateTempVar();
		this.PushNewBuffer(TempVar);
		this.AddCodeToCurrentBuffer(" = getelementptr ");
		this.VisitType(RecvNode.Type);
		this.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(RecvNode);
		this.AddCodeToCurrentBuffer(", ");
		this.VisitType(IndexNode.Type);
		this.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(IndexNode);
		this.AppendBufferAsNewLine();
		this.AddCodeToCurrentBuffer(TempVar);
	}

	private void AppendDefaultReturn(ZType ReturnType) {
		this.PushNewBuffer("ret ");
		if(!ReturnType.IsVoidType()) {
			this.VisitType(ReturnType);
			this.AddCodeToCurrentBuffer(" ");
			if(ReturnType.IsFloatType()) {
				this.AddCodeToCurrentBuffer("" + 0.0);
			}
			else if(ReturnType.IsBooleanType()) {
				this.AddCodeToCurrentBuffer(this.FalseLiteral);
			}
			else {
				this.AddCodeToCurrentBuffer("" + 0);
			}
		}
		else {
			this.AddCodeToCurrentBuffer("void");
		}
		this.AppendBufferAsNewLine();
	}

	@Override
	protected void VisitType(ZType Type) {
		if(Type instanceof ZFuncType) {
			this.VisitFuncTypeAsPointer((ZFuncType)Type);
		}
		else if(Type.IsArrayType()) {
			//this.VisitArrayType(0, Type);
			this.AddCodeToCurrentBuffer(this.GetNativeType(((ZGeneric1Type)Type).ParamType.GetRealType()) + "*");
		}
		else if(Type instanceof ZenClassType && this.IsUserDefinedClass(Type.ShortName)) {
			this.AddCodeToCurrentBuffer("%Class__" + Type.ShortName);
		}
		else {
			this.AddCodeToCurrentBuffer(this.GetNativeType(Type.GetRealType()));
		}
	}
	private void VisitTypeAsPointer(ZType Type) {
		this.VisitType(Type);
		this.AddCodeToCurrentBuffer("*");
	}

	private void VisitArrayType(int Size, ZType Type) {
		assert(Type instanceof ZGeneric1Type);
		this.AddCodeToCurrentBuffer("[" + Size + " x ");
		this.VisitType(((ZGeneric1Type)Type).ParamType);
		this.AddCodeToCurrentBuffer("]");
	}
	private void VisitArrayTypeAsPointer(int Size, ZType Type) {
		this.VisitArrayType(Size, Type);
		this.AddCodeToCurrentBuffer("*");
	}

	private void VisitFuncTypeAsPointer(ZFuncType Type) {
		ZType[] Types = Type.TypeParams;
		int Size = Types.length;
		LibNative.Assert(Size > 0);

		this.VisitType(Types[0]);
		this.AddCodeToCurrentBuffer(" (");
		for(int i = 1; i < Size; ++i) {
			if(i > 1) {
				this.AddCodeToCurrentBuffer(", ");
			}
			this.VisitType(Types[i]);
		}
		this.AddCodeToCurrentBuffer(")*");
	}
}
