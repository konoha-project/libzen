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
import zen.ast.ZCatchNode;
import zen.ast.ZClassNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZConstNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZListNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewArrayNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.parser.ZSourceGenerator;
import zen.type.ZClassType;
import zen.type.ZFuncType;
import zen.type.ZGeneric1Type;
import zen.type.ZType;

class LLVMSourceWriter {
	private int IndentLebel;
	private int VarCodeIndex;
	private int TempLocalSymbolNumber;
	private boolean IsBlockTerminated;
	private String CurrentLabel;
	private final ArrayList<String> BreakLabelStack = new ArrayList<String>();
	private final ArrayList<String> LocalSymbolList = new ArrayList<String>();
	private final ArrayList<String> LocalVarList = new ArrayList<String>();
	private final ArrayList<String> CodeBufferStack = new ArrayList<String>();
	private final ArrayList<String> HeaderCodeList = new ArrayList<String>();
	private final ArrayList<String> BodyCodeList = new ArrayList<String>();

	public LLVMSourceWriter() {
		this.clear();
	}

	private void clear() {
		this.IndentLebel = 0;
		this.VarCodeIndex = 2;
		this.TempLocalSymbolNumber = 0;
		this.IsBlockTerminated = false;
		this.CurrentLabel = null;
		this.BreakLabelStack.clear();
		this.LocalSymbolList.clear();
		this.LocalVarList.clear();
		this.CodeBufferStack.clear();
		this.HeaderCodeList.clear();
		this.BodyCodeList.clear();
	}
	private String GetCurrentIndentString() {
		return this.GetIndentString(this.IndentLebel);
	}
	private String GetIndentString(int Level) {
		return LibZen._JoinStrings("\t", Level);
	}
	public void IncreaseIndent() {
		++this.IndentLebel;
	}
	public void DecreaseIndent() {
		--this.IndentLebel;
	}

	public String CreateTempLocalSymbol() {
		return "%Temp__" + this.TempLocalSymbolNumber++;
	}
	public int GetTempLabelNumber() {
		return this.TempLocalSymbolNumber++;
	}

	public void TerminateBlock() {
		this.IsBlockTerminated = true;
	}
	public boolean IsBlockTerminated() {
		return this.IsBlockTerminated;
	}
	public String GetCurrentLabel() {
		return this.CurrentLabel;
	}
	public void PushBreakLabel(String Label) {
		this.BreakLabelStack.add(Label);
	}
	public String PopBreakLabel() {
		int Size = this.BreakLabelStack.size();
		return this.BreakLabelStack.remove(Size-1);
	}
	public String PeekBreakLabel() {
		int Size = this.BreakLabelStack.size();
		return this.BreakLabelStack.get(Size-1);
	}

	public void DefineLocalSymbol(String Symbol) {
		this.LocalSymbolList.add(Symbol);
	}
	public void DefineLocalVar(String VarName) {
		this.LocalVarList.add(VarName);
		this.DefineLocalSymbol(VarName);
	}
	public boolean IsUserDefinedSymbol(String Symbol) {
		return this.LocalSymbolList.contains(Symbol);
	}
	public boolean IsUserDefinedVar(String Symbol) {
		return this.LocalVarList.contains(Symbol);
	}

	public void PushNewBuffer(String Text) {
		this.CodeBufferStack.add(Text);
	}
	public void AddCodeToCurrentBuffer(String NewText) {
		int Size = this.CodeBufferStack.size();
		if(Size <= 0) {
			this.CodeBufferStack.add(NewText);
		}
		else {
			String OldText = this.CodeBufferStack.remove(Size-1);
			this.CodeBufferStack.add(OldText + NewText);
		}
	}
	public String PopCurrentBuffer() {
		int Size = this.CodeBufferStack.size();
		if(Size > 0) {
			return this.CodeBufferStack.remove(Size-1);
		}
		return null;
	}
	public void AppendLine(String Text) {
		this.BodyCodeList.add(this.GetCurrentIndentString() + Text + "\n");
	}
	public void AppendBufferAsNewLine() {
		this.AppendLine(this.PopCurrentBuffer());
	}
	public void AppendBufferAsHeaderLine() {
		this.HeaderCodeList.add(this.PopCurrentBuffer() + "\n");
	}
	public void AppendBufferAsVarLine() {
		assert(this.BodyCodeList.size() > 2);
		this.BodyCodeList.add(this.VarCodeIndex++, this.GetCurrentIndentString() + this.PopCurrentBuffer() + "\n");
	}
	public void AppendLabel(String Label) {
		this.BodyCodeList.add(Label + ": \n");
		this.IsBlockTerminated = false;
		this.CurrentLabel = Label;
	}

	public String Write() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.HeaderCodeList.size(); ++i) {
			sb.append(this.HeaderCodeList.get(i));
		}
		this.HeaderCodeList.clear();
		for(int i = 0; i < this.BodyCodeList.size(); ++i) {
			sb.append(this.BodyCodeList.get(i));
		}
		this.clear();
		return sb.toString();
	}

}

public class LLVMSourceGenerator extends ZSourceGenerator {
	private int TempGlobalSymbolNumber;
	private final ArrayList<String> GlobalSymbolList;
	private final HashMap<String, ZClassNode> ClassFieldMap;
	private LLVMSourceWriter Writer;

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

		this.TempGlobalSymbolNumber = 0;
		this.GlobalSymbolList = new ArrayList<String>();
		this.ClassFieldMap = new HashMap<String, ZClassNode>();
		this.Writer = new LLVMSourceWriter();
		//this.EngineManager = new ScriptEngineManager();
		//this.Engine = this.EngineManager.getEngineByName("js");
	}

	private String CreateTempGlobalSymbol() {
		return "@Temp__" + this.TempGlobalSymbolNumber++;
	}

	private void DefineGlobalSymbol(String Symbol) {
		this.GlobalSymbolList.add(Symbol);
	}
	private void DefineClass(String ClassName, ZClassNode Node) {
		this.ClassFieldMap.put(ClassName, Node);
	}
	private String GetIdentifierAttachedSymbol(String Symbol) {
		if(this.Writer.IsUserDefinedSymbol(Symbol)) {
			return "%" + Symbol;
		}
		else if(this.ClassFieldMap.containsKey(Symbol)) {
			return "%Class." + Symbol;
		}
		else if(this.GlobalSymbolList.contains(Symbol)) {
			return "@" + Symbol;
		}
		else {
			return null;
		}
	}
	private boolean IsUserDefinedClass(String ClassName) {
		return this.ClassFieldMap.containsKey(ClassName);
	}

	private boolean IsPrimitiveType(ZType Type) {
		if(Type.IsBooleanType()) {
			return true;
		}
		else if(Type.IsFloatType()) {
			return true;
		}
		else if(Type.IsIntType()) {
			return true;
		}
		return false;
	}
	private String GetTypeExpr(ZType Type) {
		if(Type.IsVarType()) {
			return "opaque";
		}
		else if(Type instanceof ZFuncType) {
			ZFuncType FuncType = (ZFuncType)Type;
			int Size = FuncType.GetFuncParamSize();
			LibZen._Assert(Size >= 0);

			String FuncTypeString = this.GetTypeExpr(FuncType.GetReturnType())+ " (";
			for(int i = 0; i < Size; ++i) {
				if(i > 0) {
					FuncTypeString += ", ";
				}
				FuncTypeString += this.GetTypeExpr(FuncType.GetFuncParamType(i));
			}
			FuncTypeString += ")*";
			return FuncTypeString;
		}
		else if(Type.IsArrayType()) {
			return this.GetNativeType(((ZGeneric1Type)Type).ParamType.GetRealType()) + "*";
		}
		else if(Type instanceof ZClassType && this.IsUserDefinedClass(Type.ShortName)) {
			return "%Class." + Type.ShortName + "*";
		}
		else {
			return this.GetNativeType(Type.GetRealType());
		}
	}
	private String GetTypeExprForNewOperator(ZType Type) {
		if(Type.IsArrayType()) {
			return this.GetNativeType(((ZGeneric1Type)Type).ParamType.GetRealType());
		}
		else if(Type instanceof ZClassType && this.IsUserDefinedClass(Type.ShortName)) {
			return "%Class." + Type.ShortName;
		}
		else {
			return this.GetTypeExpr(Type);
		}
	}

	private String GetBinaryOpcode(ZBinaryNode Node) {
		if(Node.IsUntyped()) {
			throw new RuntimeException("Binary is untyped");
		}
		String Binary = Node.SourceToken.GetText();
		if(Binary.equals("+")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "add";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "fadd";
			}
		}
		else if(Binary.equals("-")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "sub";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "fsub";
			}
		}
		else if(Binary.equals("*")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "mul";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "fmul";
			}
		}
		else if(Binary.equals("/")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "sdiv";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "fdiv";
			}
		}
		else if(Binary.equals("%")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "srem";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "frem";
			}
		}
		throw new RuntimeException("Can't use this binary\"" + Binary + "\"");
	}
	private String GetCompareOpCodeAndCondition(ZComparatorNode Node) {
		if(Node.IsUntyped()) {
			throw new RuntimeException("Comparator is untyped");
		}
		String Comparator = Node.SourceToken.GetText();
		if(Comparator.equals("==")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "icmp eq";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "fcmp oeq";
			}
		}
		else if(Comparator.equals("!=")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "icmp ne";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "fcmp one";
			}
		}
		else if(Comparator.equals("<")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "icmp slt";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "fcmp olt";
			}
		}
		else if(Comparator.equals("<=")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "icmp sle";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "fcmp ole";
			}
		}
		else if(Comparator.equals(">")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "icmp sgt";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
				return "fcmp ogt";
			}
		}
		else if(Comparator.equals(">=")) {
			if(Node.AST[ZBinaryNode._Left].Type.IsIntType() && Node.AST[ZBinaryNode._Right].Type.IsIntType()) {
				return "icmp sge";
			}
			else if(Node.AST[ZBinaryNode._Left].Type.IsFloatType() && Node.AST[ZBinaryNode._Right].Type.IsFloatType()) {
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
		if (AllowLazy && Node.IsUntyped()) {
			//if(IsInteractive) {
			Node.Accept(this);
			//LibNative.println("---");
			LibZen._PrintLine(this.Writer.Write());
			//LibNative.println("---");
			//}
			return false;
		}
		Node.Accept(this);
		//if(IsInteractive) {
		//LibNative.println("---");
		LibZen._PrintLine(this.Writer.Write());
		//LibNative.println("---");
		//}
		return true;
	}

	@Override
	public void VisitAndNode(ZAndNode Node) {
		int LabelNum = this.Writer.GetTempLabelNumber();
		String RightLabel = "And__" + LabelNum + ".Right";
		String EndLabel = "And__" + LabelNum + ".End";

		this.Writer.PushNewBuffer("br i1 ");
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + RightLabel + ", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + EndLabel);
		this.Writer.AppendBufferAsNewLine();
		String LeftLabel = this.Writer.GetCurrentLabel();

		this.Writer.AppendLabel(RightLabel);
		this.Writer.PushNewBuffer("");
		this.GenerateCode(Node.AST[ZBinaryNode._Right]);
		String RightResult = this.Writer.PopCurrentBuffer();
		this.Writer.AppendLine("br label %" + EndLabel);
		RightLabel = this.Writer.GetCurrentLabel();

		this.Writer.AppendLabel(EndLabel);
		String AllResult = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(AllResult);
		this.Writer.AddCodeToCurrentBuffer(" = phi i1 ");
		this.Writer.AddCodeToCurrentBuffer("[ false, %" + LeftLabel + " ], ");
		this.Writer.AddCodeToCurrentBuffer("[ " + RightResult + ", %" + RightLabel + " ]");
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(AllResult);
	}

	@Override
	public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		String GlobalConst = this.CreateTempGlobalSymbol();
		this.Writer.PushNewBuffer(GlobalConst);
		this.Writer.AddCodeToCurrentBuffer(" = private constant ");
		int ArraySize = Node.GetListSize();
		String ElementType = this.GetTypeExpr(((ZGeneric1Type)Node.Type).ParamType);
		String ArrayType = "[" + ArraySize + " x " + ElementType + "]";
		this.Writer.AddCodeToCurrentBuffer(ArrayType);

		this.Writer.AddCodeToCurrentBuffer(" [");
		for(int i = 0; i < ArraySize; ++i) {
			if (i > 0) {
				this.Writer.AddCodeToCurrentBuffer(", ");
			}
			ZNode SubNode = Node.GetListAt(i);
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(SubNode.Type));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(SubNode);
		}
		this.Writer.AddCodeToCurrentBuffer("]");
		this.Writer.AppendBufferAsHeaderLine();

		this.Writer.AddCodeToCurrentBuffer("bitcast (");
		this.Writer.AddCodeToCurrentBuffer(ArrayType + "* ");
		this.Writer.AddCodeToCurrentBuffer(GlobalConst);
		this.Writer.AddCodeToCurrentBuffer(" to ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type));
		this.Writer.AddCodeToCurrentBuffer(")");
	}

	@Override
	public void VisitBinaryNode(ZBinaryNode Node) {
		String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = ");
		this.Writer.AddCodeToCurrentBuffer(this.GetBinaryOpcode(Node));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZBinaryNode._Left].Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.GenerateCode(Node.AST[ZBinaryNode._Right]);
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitBreakNode(ZBreakNode Node) {
		this.Writer.AppendLine("br label %" + this.Writer.PeekBreakLabel());
		this.Writer.TerminateBlock();
	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		this.VisitStmtList(Node);
	}

	@Override
	public void VisitBooleanNode(ZBooleanNode Node) {
		if (Node.BooleanValue) {
			this.Writer.AddCodeToCurrentBuffer(this.TrueLiteral);
		} else {
			this.Writer.AddCodeToCurrentBuffer(this.FalseLiteral);
		}
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		/*FIXME*/
		ZType BeforeType = Node.AST[ZCastNode._Expr].Type;
		ZType AfterType = Node.Type;
		if(BeforeType == AfterType) {
			this.GenerateCode(Node.AST[ZCastNode._Expr]);
		}
		else if(!(BeforeType.IsVoidType()) && AfterType.IsVoidType()) {
			this.GenerateCode(Node.AST[ZCastNode._Expr]);
			this.Writer.PopCurrentBuffer();
		}
		else {
			String TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = ");
			this.Writer.AddCodeToCurrentBuffer(this.GetCastOpCode(BeforeType, AfterType));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(BeforeType));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateSurroundCode(Node.AST[ZCastNode._Expr]);
			this.Writer.AddCodeToCurrentBuffer(" to ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(AfterType));
			this.Writer.AppendBufferAsNewLine();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
	}

	@Override
	public void VisitCatchNode(ZCatchNode Node) {
		// TODO
	}

	@Override
	public void VisitClassNode(ZClassNode Node) {
		this.DefineClass(Node.ClassName, Node);
		String ClassSymbol = "%Class." + Node.ClassName;
		this.Writer.PushNewBuffer(ClassSymbol);
		this.Writer.AddCodeToCurrentBuffer(" = type { ");
		if(Node.SuperType != null) {
			this.Writer.AddCodeToCurrentBuffer("%Class." + Node.SuperType.ShortName);
		}
		else {
			this.Writer.AddCodeToCurrentBuffer("i8*");
		}
		@Var int i = 0;
		while (i < Node.GetListSize()) {
			this.Writer.AddCodeToCurrentBuffer(", ");
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(FieldNode.DeclType));
			//this.GenerateCode(FieldNode.InitNode);
			i = i + 1;
		}
		this.Writer.AddCodeToCurrentBuffer(" }");
		this.Writer.AppendBufferAsHeaderLine();

		String ProtoSymbol = "@" + Node.ClassName + ".Proto";
		this.Writer.PushNewBuffer(ProtoSymbol);
		this.Writer.AddCodeToCurrentBuffer(" = private constant ");
		this.Writer.AddCodeToCurrentBuffer(ClassSymbol);
		this.Writer.AddCodeToCurrentBuffer(" ");
		if(Node.SuperType != null) {
			this.VisitFieldList("i8* bitcast (%Class." + Node.SuperType.ShortName + "* @" + Node.SuperType.ShortName + ".Proto to i8*)", Node);
		}
		else {
			this.VisitFieldList("i8* null", Node);
		}
		this.Writer.AppendBufferAsHeaderLine();
	}

	@Override
	public void VisitComparatorNode(ZComparatorNode Node) {
		String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = ");
		this.Writer.AddCodeToCurrentBuffer(this.GetCompareOpCodeAndCondition(Node));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZBinaryNode._Left].Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.GenerateCode(Node.AST[ZBinaryNode._Right]);
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitErrorNode(ZErrorNode Node) {
		// TODO
	}

	@Override
	public void VisitFloatNode(ZFloatNode Node) {
		this.Writer.AddCodeToCurrentBuffer("" + Node.FloatValue);
	}

	@Override
	public void VisitFuncCallNode(ZFuncCallNode Node) {
		if(Node.ResolvedFuncName != null && Node.ResolvedFunc != null) {
			@Var ZFuncType FuncType = Node.ResolvedFunc.GetFuncType();
			ZType ReturnType = FuncType.TypeParams[0];
			String TempVar = "";
			this.Writer.PushNewBuffer("");
			if(!ReturnType.IsVoidType()) {
				TempVar = this.Writer.CreateTempLocalSymbol();
				this.Writer.AddCodeToCurrentBuffer(TempVar);
				this.Writer.AddCodeToCurrentBuffer(" = ");
			}
			this.Writer.AddCodeToCurrentBuffer("call ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(FuncType));
			this.Writer.AddCodeToCurrentBuffer(" " + this.GetIdentifierAttachedSymbol(Node.ResolvedFuncName));
			//this.GenerateCode(Node.AST[ZFuncCallNode.Func]);
			this.VisitListNode(" (", Node, ", ", ")");
			this.Writer.AppendBufferAsNewLine();
			if(!ReturnType.IsVoidType()) {
				this.Writer.AddCodeToCurrentBuffer(TempVar);
			}
		}
		else {
			/* FIXME */
			ZType ReturnType = Node.AST[ZFuncCallNode._Func].Type;
			String TempVar = "";
			this.Writer.PushNewBuffer("");
			if(!ReturnType.IsVoidType()) {
				TempVar = this.Writer.CreateTempLocalSymbol();
				this.Writer.AddCodeToCurrentBuffer(TempVar);
				this.Writer.AddCodeToCurrentBuffer(" = ");
			}
			this.Writer.AddCodeToCurrentBuffer("call ");
			//this.VisitFuncTypeAsPointer(Node.FuncNode.Type);
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type) + "*");
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(Node.AST[ZFuncCallNode._Func]);
			this.VisitListNode(" (", Node, ", ", ")");
			this.Writer.AppendBufferAsNewLine();
			if(!ReturnType.IsVoidType()) {
				this.Writer.AddCodeToCurrentBuffer(TempVar);
			}
		}
	}

	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		LLVMSourceWriter PushedWriter = this.Writer;
		if(Node.ParentFunctionNode != null) {
			this.Writer = new LLVMSourceWriter();
		}

		this.Writer.PushNewBuffer("define ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.ReturnType));
		String FuncName;
		if(Node.FuncName == null) {
			FuncName = this.CreateTempGlobalSymbol();
		}
		else {
			this.DefineGlobalSymbol(Node.FuncName);
			FuncName = this.GetIdentifierAttachedSymbol(Node.FuncName);
		}
		this.Writer.AddCodeToCurrentBuffer(" " + FuncName + " ");
		//If I use "VisitNodeList", get an error. Is ZParamNode a ZNode?
		this.VisitListNode("(", Node, ", ", ") {");
		this.Writer.AppendBufferAsNewLine();

		this.Writer.IncreaseIndent();
		this.Writer.AppendLabel("Entry");
		this.GenerateCode(Node.AST[ZFunctionNode._Block]);
		if(!this.Writer.IsBlockTerminated()) {
			this.AppendDefaultReturn(Node.ReturnType);
		}
		this.Writer.DecreaseIndent();

		this.Writer.AppendLine("}");
		if(Node.ParentFunctionNode != null) {
			LibZen._PrintLine(this.Writer.Write());
			this.Writer = PushedWriter;
			this.Writer.AddCodeToCurrentBuffer(FuncName);
		}
	}

	@Override
	public void VisitGetIndexNode(ZGetIndexNode Node) {
		String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = load ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GetArrayElementPointer(Node.AST[ZGetIndexNode._Recv], Node.AST[ZGetIndexNode._Index]);
		this.Writer.AddCodeToCurrentBuffer(" ;gcread");
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitGetNameNode(ZGetNameNode Node) {
		String VarSymbol = this.GetIdentifierAttachedSymbol(Node.VarName);
		if(this.Writer.IsUserDefinedVar(Node.VarName)) {
			String TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = load ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type) + "*");
			this.Writer.AddCodeToCurrentBuffer(" " + VarSymbol);
			if(!this.IsPrimitiveType(Node.Type)) {
				this.Writer.AddCodeToCurrentBuffer(" ;gcread");
			}
			this.Writer.AppendBufferAsNewLine();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
		else {
			this.Writer.AddCodeToCurrentBuffer(VarSymbol);
		}
	}

	@Override
	public void VisitGetterNode(ZGetterNode Node) {
		String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = load ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GetObjectElementPointer(Node.AST[ZGetterNode._Recv], Node.FieldName);
		this.Writer.AddCodeToCurrentBuffer(" ;gcread");
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitGroupNode(ZGroupNode Node) {
		this.GenerateCode(Node.AST[ZGroupNode._Expr]);
	}

	@Override
	public void VisitIfNode(ZIfNode Node) {
		int LabelNum = this.Writer.GetTempLabelNumber();
		String ThenLabel = "If__" + LabelNum + ".Then";
		String ElseLabel = "If__" + LabelNum + ".Else";
		String EndLabel = "If__" + LabelNum + ".End";
		boolean IsEndReachable = false;

		this.Writer.PushNewBuffer("br i1 ");
		this.GenerateCode(Node.AST[ZIfNode._Cond]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + ThenLabel + ", ");
		if(Node.AST[ZIfNode._Else] != null) {
			this.Writer.AddCodeToCurrentBuffer("label %" + ElseLabel);
		}
		else {
			this.Writer.AddCodeToCurrentBuffer("label %" + EndLabel);
			IsEndReachable = true;
		}
		this.Writer.AppendBufferAsNewLine();

		this.Writer.AppendLabel(ThenLabel);
		this.GenerateCode(Node.AST[ZIfNode._Then]);
		if(!this.Writer.IsBlockTerminated()) {
			this.Writer.AppendLine("br label %" + EndLabel);
			IsEndReachable = true;
		}

		if(Node.AST[ZIfNode._Else] != null) {
			this.Writer.AppendLabel(ElseLabel);
			this.GenerateCode(Node.AST[ZIfNode._Else]);
			if(!this.Writer.IsBlockTerminated()) {
				this.Writer.AppendLine("br label %" + EndLabel);
				IsEndReachable = true;
			}
		}
		if(IsEndReachable) {
			this.Writer.AppendLabel(EndLabel);
		}
	}

	@Override
	public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		// TODO
	}

	@Override
	public void VisitIntNode(ZIntNode Node) {
		this.Writer.AddCodeToCurrentBuffer("" + Node.IntValue);
	}

	@Override
	public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		/*FIXME*/
		//		this.AddCodeToCurrentBuffer("{ ");
		//		int ListSize = Node.NodeList.size();
		//		for(int i = 0; i < ListSize; i = i + 2) {
		//			if (i > 0) {
		//				this.AddCodeToCurrentBuffer(", ");
		//			}
		//			ZNode ParamNode = Node.NodeList.get(i + 1);
		//			this.VisitType(ParamNode.Type);
		//			this.AddCodeToCurrentBuffer(" ");
		//			this.GenerateCode(ParamNode);
		//		}
		//		this.AddCodeToCurrentBuffer(" }");
	}

	@Override
	public void VisitMethodCallNode(ZMethodCallNode Node) {
		// TODO
	}

	@Override
	public void VisitNewArrayNode(ZNewArrayNode Node) {
		// TODO
	}

	@Override
	public void VisitNewObjectNode(ZNewObjectNode Node) {
		if(Node.Type instanceof ZClassType) {
			String TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = alloca ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExprForNewOperator(Node.Type));
			this.Writer.AddCodeToCurrentBuffer(" ;malloc");
			this.Writer.AppendBufferAsNewLine();
			//Node.ParamList
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
		else if(Node.Type.IsStringType()) {
			// FIXME
		}
	}

	@Override
	public void VisitNotNode(ZNotNode Node) {
		String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = ");
		this.Writer.AddCodeToCurrentBuffer("xor");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZNotNode._Recv].Type));
		this.Writer.AddCodeToCurrentBuffer(" 1, ");
		this.GenerateSurroundCode(Node.AST[ZNotNode._Recv]);
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitNullNode(ZNullNode Node) {
		this.Writer.AddCodeToCurrentBuffer(this.NullLiteral);
	}

	@Override
	public void VisitOrNode(ZOrNode Node) {
		int LabelNum = this.Writer.GetTempLabelNumber();
		String RightLabel = "Or__" + LabelNum + ".Right";
		String EndLabel = "Or__" + LabelNum + ".End";

		this.Writer.PushNewBuffer("br i1 ");
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + EndLabel + ", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + RightLabel);
		this.Writer.AppendBufferAsNewLine();
		String LeftLabel = this.Writer.GetCurrentLabel();

		this.Writer.AppendLabel(RightLabel);
		this.Writer.PushNewBuffer("");
		this.GenerateCode(Node.AST[ZBinaryNode._Right]);
		String RightResult = this.Writer.PopCurrentBuffer();
		this.Writer.AppendLine("br label %" + EndLabel);
		RightLabel = this.Writer.GetCurrentLabel();

		this.Writer.AppendLabel(EndLabel);
		String AllResult = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(AllResult);
		this.Writer.AddCodeToCurrentBuffer(" = phi i1 ");
		this.Writer.AddCodeToCurrentBuffer("[ true, %" + LeftLabel + " ], ");
		this.Writer.AddCodeToCurrentBuffer("[ " + RightResult + ", %" + RightLabel + " ]");
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(AllResult);
	}

	@Override
	public void VisitParamNode(ZParamNode Node) {
		this.Writer.DefineLocalSymbol(Node.Name);
		this.Writer.AddCodeToCurrentBuffer(this.GetIdentifierAttachedSymbol(Node.Name));
	}

	@Override
	public void VisitReturnNode(ZReturnNode Node) {
		this.Writer.PushNewBuffer("ret ");
		if (Node.AST[ZReturnNode._Expr] != null) {
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZReturnNode._Expr].Type));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(Node.AST[ZReturnNode._Expr]);
		}
		else {
			this.Writer.AddCodeToCurrentBuffer("void");
		}
		this.Writer.AppendBufferAsNewLine();
		this.Writer.TerminateBlock();
	}

	@Override
	public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.Writer.PushNewBuffer("store ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZSetIndexNode._Expr].Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.AST[ZSetIndexNode._Expr]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZSetIndexNode._Expr].Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GetArrayElementPointer(Node.AST[ZSetIndexNode._Recv], Node.AST[ZSetIndexNode._Index]);
		this.Writer.AddCodeToCurrentBuffer(" ;gcwrite");
		this.Writer.AppendBufferAsNewLine();
	}

	@Override
	public void VisitSetNameNode(ZSetNameNode Node) {
		if(!this.Writer.IsUserDefinedVar(Node.VarName)) {
			throw new RuntimeException("Can't assign to argument");
		}
		this.Writer.PushNewBuffer("store ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZSetNameNode._Expr].Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.AST[ZSetNameNode._Expr]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZSetNameNode._Expr].Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.Writer.AddCodeToCurrentBuffer(this.GetIdentifierAttachedSymbol(Node.VarName));
		if(!this.IsPrimitiveType(Node.AST[ZSetNameNode._Expr].Type)) {
			this.Writer.AddCodeToCurrentBuffer(" ;gcwrite");
		}
		this.Writer.AppendBufferAsNewLine();
	}

	@Override
	public void VisitStringNode(ZStringNode Node) {
		String StringConst = this.CreateTempGlobalSymbol();
		this.Writer.PushNewBuffer(StringConst);
		this.Writer.AddCodeToCurrentBuffer(" = private constant ");
		String StringValue = this.ConvertLLVMString(Node.StringValue);
		int StrLen = this.GetLLVMStringLen(StringValue);
		String StringType = "[" + StrLen + " x i8]";
		this.Writer.AddCodeToCurrentBuffer(StringType);

		this.Writer.AddCodeToCurrentBuffer(" c\"" + StringValue + "\"");
		this.Writer.AppendBufferAsHeaderLine();

		this.Writer.AddCodeToCurrentBuffer("bitcast (");
		this.Writer.AddCodeToCurrentBuffer(StringType + "* ");
		this.Writer.AddCodeToCurrentBuffer(StringConst);
		this.Writer.AddCodeToCurrentBuffer(" to ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type));
		this.Writer.AddCodeToCurrentBuffer(")");
	}

	@Override
	public void VisitSetterNode(ZSetterNode Node) {
		this.Writer.PushNewBuffer("store ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZSetterNode._Expr].Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.AST[ZSetterNode._Expr]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZSetterNode._Expr].Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GetObjectElementPointer(Node.AST[ZSetterNode._Recv], Node.FieldName);
		this.Writer.AddCodeToCurrentBuffer(" ;gcwrite");
		this.Writer.AppendBufferAsNewLine();
	}

	@Override
	public void VisitThrowNode(ZThrowNode Node) {
		// TODO
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		// TODO
	}

	@Override
	public void VisitUnaryNode(ZUnaryNode Node) {
		if(Node.SourceToken.EqualsText('+')) {
			this.GenerateCode(Node.AST[ZUnaryNode._Recv]);
		}
		else if(Node.SourceToken.EqualsText('-')){
			if(Node.AST[ZUnaryNode._Recv] instanceof ZConstNode) {
				this.Writer.AddCodeToCurrentBuffer("-");
				this.GenerateCode(Node.AST[ZUnaryNode._Recv]);
			}
			else {
				String TempVar = this.Writer.CreateTempLocalSymbol();
				this.Writer.PushNewBuffer(TempVar);
				this.Writer.AddCodeToCurrentBuffer(" = ");
				if(Node.AST[ZUnaryNode._Recv].IsUntyped()) {
					throw new RuntimeException("Comparator is untyped");
				}
				else if(Node.AST[ZUnaryNode._Recv].Type.IsIntType()) {
					this.Writer.AddCodeToCurrentBuffer("sub");
				}
				else if(Node.AST[ZUnaryNode._Recv].Type.IsFloatType()) {
					this.Writer.AddCodeToCurrentBuffer("fsub");
				}
				else {
					throw new RuntimeException("Can't use this Unary\"-\"");
				}
				this.Writer.AddCodeToCurrentBuffer(" ");
				this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZUnaryNode._Recv].Type));
				this.Writer.AddCodeToCurrentBuffer(" 0, ");
				this.GenerateCode(Node.AST[ZUnaryNode._Recv]);
				this.Writer.AppendBufferAsNewLine();
				this.Writer.AddCodeToCurrentBuffer(TempVar);
			}
		}
		else {
			throw new RuntimeException("Can't use this Unary\"" + Node.SourceToken.GetText() + "\"");
		}
	}

	@Override
	public void VisitVarNode(ZVarNode Node) {
		assert(Node.AST[ZVarNode._InitValue] != null); //must be set initial value
		this.Writer.DefineLocalVar(Node.NativeName);
		String VarSymbol = this.GetIdentifierAttachedSymbol(Node.NativeName);
		this.Writer.PushNewBuffer(VarSymbol);
		this.Writer.AddCodeToCurrentBuffer(" = alloca ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.DeclType));
		this.Writer.AppendBufferAsVarLine();
		if(!this.IsPrimitiveType(Node.DeclType)) {
			this.Writer.PushNewBuffer(";gcroot");
			this.Writer.AppendBufferAsVarLine();
		}

		this.Writer.PushNewBuffer("store ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[ZVarNode._InitValue].Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(Node.AST[ZVarNode._InitValue]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.DeclType) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.Writer.AddCodeToCurrentBuffer(VarSymbol);
		if(!this.IsPrimitiveType(Node.AST[ZVarNode._InitValue].Type)) {
			this.Writer.AddCodeToCurrentBuffer(" ;gcwrite");
		}
		this.Writer.AppendBufferAsNewLine();
		this.VisitStmtList(Node);
	}


	@Override
	public void VisitWhileNode(ZWhileNode Node) {
		int LabelNum = this.Writer.GetTempLabelNumber();
		String CondLabel = "While__" + LabelNum + ".Cond";
		String BodyLabel = "While__" + LabelNum + ".Body";
		String EndLabel = "While__" + LabelNum + ".End";

		this.Writer.AppendLine("br label %" + CondLabel);

		this.Writer.AppendLabel(CondLabel);
		this.Writer.PushNewBuffer("br i1 ");
		this.GenerateCode(Node.AST[ZWhileNode._Cond]);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + BodyLabel + ", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + EndLabel);
		this.Writer.AppendBufferAsNewLine();

		this.Writer.AppendLabel(BodyLabel);
		this.Writer.PushBreakLabel(EndLabel);
		this.GenerateCode(Node.AST[ZWhileNode._Block]);
		if(!this.Writer.IsBlockTerminated()) {
			this.Writer.AppendLine("br label %" + CondLabel);
		}
		this.Writer.PopBreakLabel();

		this.Writer.AppendLabel(EndLabel);
	}

	@Override
	protected void GenerateSurroundCode(ZNode Node) {
		if(this.IsNeededSurroud(Node)) {
			//this.Writer.AddCodeToCurrentBuffer("(");
			this.GenerateCode(Node);
			//this.Writer.AddCodeToCurrentBuffer(")");
		}
		else {
			this.GenerateCode(Node);
		}
	}

	@Override
	public void VisitStmtList(ZBlockNode BlockNode) {
		@Var int i = 0;
		while (i < BlockNode.GetListSize()) {
			@Var ZNode SubNode = BlockNode.GetListAt(i);
			this.GenerateCode(SubNode);
			i = i + 1;
		}
	}

	private void VisitFieldList(String FirstElement, ZClassNode ClassNode) {
		this.Writer.AddCodeToCurrentBuffer("{ ");
		if(ClassNode.SuperType == null) {
			this.Writer.AddCodeToCurrentBuffer(FirstElement);
		}
		else {
			ZClassNode SuperClassNode = this.ClassFieldMap.get(ClassNode.SuperType.ShortName);
			this.Writer.AddCodeToCurrentBuffer("%Class." + ClassNode.SuperType.ShortName);
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.VisitFieldList(FirstElement, SuperClassNode);
		}
		@Var int i = 0;
		while(i < ClassNode.GetListSize()) {
			@Var ZFieldNode FieldNode = ClassNode.GetFieldNode(i);
			this.Writer.AddCodeToCurrentBuffer(", ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(FieldNode.DeclType));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(FieldNode.AST[ZFieldNode._InitValue]);
			i = i + 1;
		}
		this.Writer.AddCodeToCurrentBuffer(" }");
	}

	@Override
	protected void VisitListNode(String OpenToken, ZListNode VargNode, String DelimToken, String CloseToken) {
		this.Writer.AddCodeToCurrentBuffer(OpenToken);
		@Var int i = 0;
		while(i < VargNode.GetListSize()) {
			@Var ZNode ParamNode = VargNode.GetListAt(i);
			if (i > 0) {
				this.Writer.AddCodeToCurrentBuffer(DelimToken);
			}
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(ParamNode.Type));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(ParamNode);
			i = i + 1;
		}
		this.Writer.AddCodeToCurrentBuffer(CloseToken);
	}

	private void GetArrayElementPointer(ZNode RecvNode, ZNode IndexNode) {
		String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = getelementptr ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(RecvNode.Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(RecvNode);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(IndexNode.Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(IndexNode);
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}
	private void GetObjectElementPointer(ZNode RecvNode, String FieldName) {
		String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = getelementptr ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(RecvNode.Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(RecvNode);
		this.Writer.AddCodeToCurrentBuffer(", i64 0");
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.GetObjectElementOffset(RecvNode.Type, FieldName);
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}
	private void GetObjectElementOffset(ZType Type, String FieldName) {
		String ClassName = Type.ShortName;
		ZClassNode ClassNode = this.ClassFieldMap.get(ClassName);
		if(ClassNode != null) {
			int Size = ClassNode.GetListSize();
			for(int i = 0; i < Size; ++i) {
				if(ClassNode.GetFieldNode(i).FieldName.equals(FieldName)) {
					this.Writer.AddCodeToCurrentBuffer("i32 " + (i+1));
					return;
				}
			}
		}
		if(Type.RefType != null) {
			this.Writer.AddCodeToCurrentBuffer("i32 0, ");
			this.GetObjectElementOffset(Type.RefType, FieldName);
			return;
		}
		this.Writer.AddCodeToCurrentBuffer("i32 -1");
	}


	private void AppendDefaultReturn(ZType ReturnType) {
		this.Writer.PushNewBuffer("ret ");
		if(!ReturnType.IsVoidType()) {
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(ReturnType));
			this.Writer.AddCodeToCurrentBuffer(" ");
			if(ReturnType.IsFloatType()) {
				this.Writer.AddCodeToCurrentBuffer("" + 0.0);
			}
			else if(ReturnType.IsBooleanType()) {
				this.Writer.AddCodeToCurrentBuffer(this.FalseLiteral);
			}
			else {
				this.Writer.AddCodeToCurrentBuffer("" + 0);
			}
		}
		else {
			this.Writer.AddCodeToCurrentBuffer("void");
		}
		this.Writer.AppendBufferAsNewLine();
	}
}
