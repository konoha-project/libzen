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
import zen.ast.ZGlobalNameNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZLetNode;
import zen.ast.ZListNode;
import zen.ast.ZMacroNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
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
import zen.ast.sugar.ZLocalDefinedNode;
import zen.lang.zen.ZenTypeSafer;
import zen.parser.ZLogger;
import zen.parser.ZSourceEngine;
import zen.parser.ZSourceGenerator;
import zen.parser.ZVariable;
import zen.type.ZClassType;
import zen.type.ZFuncType;
import zen.type.ZGenericType;
import zen.type.ZType;
import zen.util.LibZen;
import zen.util.Var;

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
		this.IndentLebel = this.IndentLebel + 1;
	}
	public void DecreaseIndent() {
		this.IndentLebel = this.IndentLebel - 1;
	}

	public String CreateTempLocalSymbol() {
		@Var int ReturnNumber = this.TempLocalSymbolNumber;
		this.TempLocalSymbolNumber = this.TempLocalSymbolNumber + 1;
		return "%Temp__" + ReturnNumber;
	}
	public int GetTempLabelNumber() {
		@Var int ReturnNumber = this.TempLocalSymbolNumber;
		this.TempLocalSymbolNumber = this.TempLocalSymbolNumber + 1;
		return ReturnNumber;
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
		@Var int Size = this.BreakLabelStack.size();
		return this.BreakLabelStack.remove(Size-1);
	}
	public String PeekBreakLabel() {
		@Var int Size = this.BreakLabelStack.size();
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
		@Var int Size = this.CodeBufferStack.size();
		if(Size <= 0) {
			this.CodeBufferStack.add(NewText);
		}
		else {
			@Var String OldText = this.CodeBufferStack.remove(Size-1);
			this.CodeBufferStack.add(OldText + NewText);
		}
	}
	public String PopCurrentBuffer() {
		@Var int Size = this.CodeBufferStack.size();
		if(Size > 0) {
			return this.CodeBufferStack.remove(Size-1);
		}
		return null;
	}
	public void AppendLine(String Text) {
		this.BodyCodeList.add(this.GetCurrentIndentString() + Text + "\n");
	}
	public void AppendHeaderLine(String Text) {
		this.HeaderCodeList.add(Text + "\n");
	}
	public void AppendBufferAsNewLine() {
		this.AppendLine(this.PopCurrentBuffer());
	}
	public void AppendBufferAsHeaderLine() {
		this.AppendHeaderLine(this.PopCurrentBuffer());
	}
	public void AppendBufferAsVarLine() {
		assert(this.BodyCodeList.size() > 2);
		@Var int VarCodePosition = this.VarCodeIndex;
		this.VarCodeIndex = this.VarCodeIndex + 1;
		this.BodyCodeList.add(VarCodePosition, this.GetCurrentIndentString() + this.PopCurrentBuffer() + "\n");
	}
	public void AppendLabel(String Label) {
		this.BodyCodeList.add(Label + ": \n");
		this.IsBlockTerminated = false;
		this.CurrentLabel = Label;
	}

	public String Write() {
		@Var StringBuilder sb = new StringBuilder();
		@Var int i = 0;
		while(i < this.HeaderCodeList.size()) {
			sb.append(this.HeaderCodeList.get(i));
			i = i + 1;
		}
		this.HeaderCodeList.clear();
		i = 0;
		while(i < this.BodyCodeList.size()) {
			sb.append(this.BodyCodeList.get(i));
			i = i + 1;
		}
		sb.append("\n");
		this.clear();
		return sb.toString();
	}

}

public class LLVMSourceGenerator extends ZSourceGenerator {
	private int TempGlobalSymbolNumber;
	private final ArrayList<String> GlobalSymbolList;
	private final ArrayList<String> ExternalStructList;
	private final HashMap<String, String> ExternalFunctionMap;
	private final HashMap<String, ZClassNode> ClassFieldMap;
	private LLVMSourceWriter Writer;

	private static final boolean WithInitValue = true;

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

		// FIXME: lib/llvm/common.zen
		//		this.SetMacro("print", "call void (%ZString*)* @ZString_println ($[0])", ZType.VoidType, ZType.StringType);
		//		this.SetMacro("strcat", "call %ZString*  (%ZString*, %ZString*)* @ZString_StrCat ($[0], $[1])", ZType.StringType, ZType.StringType, ZType.StringType);
		//		this.SetMacro("toString", "call %ZString* (i64)* @ZString_int_toString ($[0])", ZType.StringType, ZType.IntType);
		//		this.SetConverterMacro("call %ZString* (i64)* @ZString_int_toString ($[0])", ZType.StringType, ZType.IntType);

		this.TempGlobalSymbolNumber = 0;
		this.GlobalSymbolList = new ArrayList<String>();
		this.ExternalStructList = new ArrayList<String>();
		this.ExternalFunctionMap = new HashMap<String, String>();
		this.ClassFieldMap = new HashMap<String, ZClassNode>();
		this.Writer = new LLVMSourceWriter();
		//this.EngineManager = new ScriptEngineManager();
		//this.Engine = this.EngineManager.getEngineByName("js");
	}

	private String CreateTempFuncName(ZFuncType FuncType) {
		@Var int ReturnNumber = this.TempGlobalSymbolNumber;
		this.TempGlobalSymbolNumber = this.TempGlobalSymbolNumber + 1;
		return "@" + FuncType.StringfySignature("f" + ReturnNumber);
	}
	private String CreateTempGlobalSymbol() {
		@Var int ReturnNumber = this.TempGlobalSymbolNumber;
		this.TempGlobalSymbolNumber = this.TempGlobalSymbolNumber + 1;
		return "@Temp__" + ReturnNumber;
	}

	private void DefineGlobalSymbol(String Symbol) {
		this.GlobalSymbolList.add(Symbol);
	}
	private void DefineClass(String ClassName, ZClassNode Node) {
		this.ClassFieldMap.put(ClassName, Node);
	}
	private String ToLocalSymbol(String Symbol) {
		if(this.Writer.IsUserDefinedSymbol(Symbol)) {
			return "%" + Symbol;
		}
		else {
			return null;
		}
	}
	private String ToGlobalSymbol(String Symbol) {
		if(this.IsUserDefinedGlobalSymbol(Symbol)) {
			return "@" + Symbol;
		}
		else {
			return null;
		}
	}
	private String ToClassSymbol(String Symbol) {
		if(this.IsUserDefinedClass(Symbol)) {
			return "%Class." + Symbol;
		}
		else {
			return null;
		}
	}
	public boolean IsUserDefinedGlobalSymbol(String Symbol) {
		return this.GlobalSymbolList.contains(Symbol);
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
			@Var ZFuncType FuncType = (ZFuncType)Type;
			return this.GetTypeExpr(FuncType.GetReturnType())+ " " + this.GetFuncParamTypeExpr(FuncType) + "*";
		}
		else if(Type.IsArrayType()) {
			return this.GetNativeTypeName(((ZGenericType)Type).ParamType.GetRealType()) + "*";
		}
		else if(Type.IsStringType()) {
			this.DefineExternalStruct("ZString");
			return "%ZString*";
		}
		else if(Type instanceof ZClassType) {
			return this.ToClassSymbol(Type.ShortName) + "*";
		}
		else {
			return this.GetNativeTypeName(Type.GetRealType());
		}
	}
	private String GetFuncParamTypeExpr(ZFuncType FuncType) {
		@Var int Size = FuncType.GetFuncParamSize();
		LibZen._Assert(Size >= 0);

		@Var StringBuilder sb = new StringBuilder();
		sb.append("(");
		@Var int i = 0;
		while(i < Size) {
			if(i > 0) {
				sb.append(", ");
			}
			sb.append(this.GetTypeExpr(FuncType.GetFuncParamType(i)));
			i = i + 1;
		}
		sb.append(")");
		return sb.toString();
	}

	private String GetBinaryOpcode(ZBinaryNode Node) {
		if(Node.IsUntyped()) {
			ZLogger._LogError(Node.SourceToken, "Binary is untyped");
			return null;
		}
		@Var String Binary = Node.SourceToken.GetText();
		if(Binary.equals("+")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "add";
			}
			else if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fadd";
			}
		}
		else if(Binary.equals("-")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "sub";
			}
			else if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fsub";
			}
		}
		else if(Binary.equals("*")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "mul";
			}
			else if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fmul";
			}
		}
		else if(Binary.equals("/")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "sdiv";
			}
			else if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fdiv";
			}
		}
		else if(Binary.equals("%")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "srem";
			}
			else if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "frem";
			}
		}
		else if(Binary.equals("|")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "or";
			}
		}
		else if(Binary.equals("&")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "and";
			}
		}
		else if(Binary.equals("<<")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "shl";
			}
		}
		else if(Binary.equals(">>")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "ashr"; //arithmetic
				//return "lshr"; //logical
			}
		}
		else if(Binary.equals("^")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "xor";
			}
		}
		ZLogger._LogError(Node.SourceToken, "Unknown binary \"" + Binary + "\" for this type");
		return null;
	}
	private String GetCompareOpCodeAndCondition(ZComparatorNode Node) {
		if(Node.IsUntyped()) {
			ZLogger._LogError(Node.SourceToken, "Comparator is untyped");
			return null;
		}
		@Var String Comparator = Node.SourceToken.GetText();
		if(Comparator.equals("==")) {
			if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fcmp oeq";
			}
			else {
				return "icmp eq";
			}
		}
		else if(Comparator.equals("!=")) {
			if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fcmp one";
			}
			else {
				return "icmp ne";
			}
		}
		else if(Comparator.equals("<")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "icmp slt";
			}
			else if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fcmp olt";
			}
		}
		else if(Comparator.equals("<=")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "icmp sle";
			}
			else if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fcmp ole";
			}
		}
		else if(Comparator.equals(">")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "icmp sgt";
			}
			else if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fcmp ogt";
			}
		}
		else if(Comparator.equals(">=")) {
			if(Node.LeftNode().Type.IsIntType() && Node.RightNode().Type.IsIntType()) {
				return "icmp sge";
			}
			else if(Node.LeftNode().Type.IsFloatType() && Node.RightNode().Type.IsFloatType()) {
				return "fcmp oge";
			}
		}
		ZLogger._LogError(Node.SourceToken, "Unknown comparator \"" + Comparator + "\" for this type");
		return null;
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
	private String GetSizeOfType(ZType Type) {
		if(this.IsPrimitiveType(Type)) {
			return "ptrtoint (" + this.GetTypeExpr(Type) + "* getelementptr (" + this.GetTypeExpr(Type) + "* null, i64 1) to i64)";
		}
		else if(Type instanceof ZClassType) {
			return "ptrtoint (" + this.GetTypeExpr(Type) + " getelementptr (" + this.GetTypeExpr(Type) + " null, i64 1) to i64)";
		}
		else {
			return null;
		}
	}

	private String ConvertLLVMString(String StringValue) {
		@Var char[] CharArray = StringValue.toCharArray();
		@Var StringBuilder sb = new StringBuilder();
		@Var int i = 0;
		while(i < CharArray.length) {
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
			i = i + 1;
		}
		sb.append("\\00");
		return sb.toString();
	}

	private int GetLLVMStringLen(String FormedString) {
		@Var char[] CharArray = FormedString.toCharArray();
		@Var int i = 0;
		@Var int Len = 0;
		while(i < CharArray.length) {
			char ch = CharArray[i];
			if(ch == '\\') {
				i = i + 3;
			}
			else {
				i = i + 1;
			}
			Len = Len + 1;
		}
		return Len;
	}

	@Override
	public ZSourceEngine GetEngine() {
		/*FIXME*/
		return new ZSourceEngine(new ZenTypeSafer(this), this);
	}

	@Override
	public boolean StartCodeGeneration(ZNode Node, boolean IsInteractive) {
		Node.Accept(this);
		//if(IsInteractive) {
		//LibNative.println("---");
		this.CurrentBuilder.Append(this.Writer.Write());
		//LibNative.println("---");
		//}
		return true;
	}

	@Override
	public void VisitAndNode(ZAndNode Node) {
		@Var int LabelNum = this.Writer.GetTempLabelNumber();
		@Var String RightLabel = "And__" + LabelNum + ".Right";
		@Var String EndLabel = "And__" + LabelNum + ".End";

		this.Writer.PushNewBuffer("br i1 ");
		this.GenerateCode(null, Node.LeftNode());
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + RightLabel + ", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + EndLabel);
		this.Writer.AppendBufferAsNewLine();
		@Var String LeftLabel = this.Writer.GetCurrentLabel();

		this.Writer.AppendLabel(RightLabel);
		this.Writer.PushNewBuffer("");
		this.GenerateCode(null, Node.RightNode());
		@Var String RightResult = this.Writer.PopCurrentBuffer();
		this.Writer.AppendLine("br label %" + EndLabel);
		RightLabel = this.Writer.GetCurrentLabel();

		this.Writer.AppendLabel(EndLabel);
		@Var String AllResult = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(AllResult);
		this.Writer.AddCodeToCurrentBuffer(" = phi i1 ");
		this.Writer.AddCodeToCurrentBuffer("[ false, %" + LeftLabel + " ], ");
		this.Writer.AddCodeToCurrentBuffer("[ " + RightResult + ", %" + RightLabel + " ]");
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(AllResult);
	}

	@Override
	public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		@Var String GlobalConst = this.CreateTempGlobalSymbol();
		this.Writer.PushNewBuffer(GlobalConst);
		this.Writer.AddCodeToCurrentBuffer(" = private constant ");
		int ArraySize = Node.GetListSize();
		@Var String ElementType = this.GetTypeExpr(((ZGenericType)Node.Type).ParamType);
		@Var String ArrayType = "[" + ArraySize + " x " + ElementType + "]";
		this.Writer.AddCodeToCurrentBuffer(ArrayType);

		this.Writer.AddCodeToCurrentBuffer(" [");
		@Var int i = 0;
		while(i < ArraySize) {
			if (i > 0) {
				this.Writer.AddCodeToCurrentBuffer(", ");
			}
			@Var ZNode SubNode = Node.GetListAt(i);
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(SubNode.Type));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(null, SubNode);
			i = i + 1;
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
		if(this.IsPrimitiveType(Node.LeftNode().Type)) {
			@Var String TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = ");
			this.Writer.AddCodeToCurrentBuffer(this.GetBinaryOpcode(Node));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.LeftNode().Type));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(null, Node.LeftNode());
			this.Writer.AddCodeToCurrentBuffer(", ");
			this.GenerateCode(null, Node.RightNode());
			this.Writer.AppendBufferAsNewLine();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
		else if(Node.LeftNode().Type.IsStringType()) {
			if(Node.SourceToken.EqualsText('+') && Node.RightNode().Type.IsStringType()) {
				this.DeclareExtrnalFunction("ZString_StrCat", "%ZString*", "(%ZString*, %ZString*)");
				this.Writer.PushNewBuffer("");
				this.GenerateCode(null, Node.LeftNode());
				@Var String LeftResult = this.Writer.PopCurrentBuffer();
				this.Writer.PushNewBuffer("");
				this.GenerateCode(null, Node.RightNode());
				@Var String RightResult = this.Writer.PopCurrentBuffer();
				this.CallExternalFunction("ZString_StrCat", "(" + this.GetTypeExpr(Node.LeftNode().Type) + " " + LeftResult + ", " + this.GetTypeExpr(Node.RightNode().Type) + " " + RightResult + ")");
			}
		}
		else {
			ZLogger._LogError(Node.SourceToken, "Unknown binary \"" + Node.SourceToken.GetText() + "\" for this type");
		}
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
		@Var ZType BeforeType = Node.ExprNode().Type;
		@Var ZType AfterType = Node.Type;
		if(BeforeType == AfterType || BeforeType.IsVarType()) {
			this.GenerateCode(null, Node.ExprNode());
		}
		else if(!(BeforeType.IsVoidType()) && AfterType.IsVoidType()) {
			this.GenerateCode(null, Node.ExprNode());
			this.Writer.PopCurrentBuffer();
		}
		else {
			@Var String TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = ");
			this.Writer.AddCodeToCurrentBuffer(this.GetCastOpCode(BeforeType, AfterType));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(BeforeType));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateSurroundCode(Node.ExprNode());
			this.Writer.AddCodeToCurrentBuffer(" to ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(AfterType));
			this.Writer.AppendBufferAsNewLine();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
	}


	@Override
	public void VisitClassNode(ZClassNode Node) {
		this.DefineClass(Node.ClassName, Node);
		@Var String ClassSymbol = this.ToClassSymbol(Node.ClassName);
		this.Writer.PushNewBuffer(ClassSymbol);
		this.Writer.AddCodeToCurrentBuffer(" = type { ");
		this.VisitFieldList("i8*", Node, !WithInitValue);
		this.Writer.AddCodeToCurrentBuffer(" }");
		this.Writer.AppendBufferAsHeaderLine();

		@Var String ProtoSymbol = "@" + Node.ClassName + ".Proto";
		this.Writer.PushNewBuffer(ProtoSymbol);
		this.Writer.AddCodeToCurrentBuffer(" = private constant ");
		this.Writer.AddCodeToCurrentBuffer(ClassSymbol);
		this.Writer.AddCodeToCurrentBuffer(" { ");
		@Var String HeaderValue;
		if(Node.SuperType != null) {
			HeaderValue = "i8* bitcast (" + this.GetTypeExpr(Node.SuperType) + " @" + Node.SuperType.ShortName + ".Proto to i8*)";
		}
		else {
			HeaderValue = "i8* null";
		}
		this.VisitFieldList(HeaderValue, Node, WithInitValue);
		this.Writer.AddCodeToCurrentBuffer(" }");
		this.Writer.AppendBufferAsHeaderLine();
	}

	@Override
	public void VisitComparatorNode(ZComparatorNode Node) {
		@Var String TempVar = this.Writer.CreateTempLocalSymbol();
		if(this.IsPrimitiveType(Node.LeftNode().Type)) {
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = ");
			this.Writer.AddCodeToCurrentBuffer(this.GetCompareOpCodeAndCondition(Node));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.LeftNode().Type));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(null, Node.LeftNode());
			this.Writer.AddCodeToCurrentBuffer(", ");
			this.GenerateCode(null, Node.RightNode());
			this.Writer.AppendBufferAsNewLine();
		}
		else {
			@Var String LeftAddress = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(LeftAddress);
			this.Writer.AddCodeToCurrentBuffer(" = ptrtoint ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.LeftNode().Type));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(null, Node.LeftNode());
			this.Writer.AddCodeToCurrentBuffer(" to i64");
			this.Writer.AppendBufferAsNewLine();

			@Var String RightAddress = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(RightAddress);
			this.Writer.AddCodeToCurrentBuffer(" = ptrtoint ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.RightNode().Type));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(null, Node.RightNode());
			this.Writer.AddCodeToCurrentBuffer(" to i64");
			this.Writer.AppendBufferAsNewLine();

			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = ");
			this.Writer.AddCodeToCurrentBuffer(this.GetCompareOpCodeAndCondition(Node));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(ZType.IntType));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.Writer.AddCodeToCurrentBuffer(LeftAddress);
			this.Writer.AddCodeToCurrentBuffer(", ");
			this.Writer.AddCodeToCurrentBuffer(RightAddress);
			this.Writer.AppendBufferAsNewLine();
		}
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitErrorNode(ZErrorNode Node) {
	}

	@Override
	public void VisitFloatNode(ZFloatNode Node) {
		this.Writer.AddCodeToCurrentBuffer("" + Node.FloatValue);
	}

	@Override
	public void VisitFuncCallNode(ZFuncCallNode Node) {
		// Kimio refatored with new interface of ZFuncCallNode
		//		@Var ZFuncType FuncType;
		//		if(Node.ResolvedFuncName != null && Node.ResolvedFunc != null) {
		//			FuncType = Node.ResolvedFunc.GetFuncType();
		//		}
		//		else if(Node.FuncNameNode().Type instanceof ZFuncType) {
		//			FuncType = (ZFuncType)Node.FuncNameNode().Type;
		//		}
		//		else {
		//			ZLogger._LogError(Node.SourceToken, "Can't interpret this function call");
		//			return;
		//		}
		@Var ZFuncType FuncType = Node.GetFuncType();
		if(FuncType == null) {
			ZLogger._LogError(Node.SourceToken, "Can't interpret this function call");
			return;
		}
		@Var ZType ReturnType = FuncType.GetReturnType();
		@Var String TempVar = "";
		this.Writer.PushNewBuffer("");
		if(!ReturnType.IsVoidType()) {
			TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = ");
		}
		this.Writer.AddCodeToCurrentBuffer("call ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(FuncType));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(null, Node.FuncNameNode());
		this.VisitListNode(" (", Node, ", ", ")");
		this.Writer.AppendBufferAsNewLine();
		if(!ReturnType.IsVoidType()) {
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
	}

	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		@Var LLVMSourceWriter PushedWriter = this.Writer;
		//Node.ParentFunctionNode != null
		if(!Node.Type.IsVoidType()) {
			this.Writer = new LLVMSourceWriter();
		}

		this.Writer.PushNewBuffer("define ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.ReturnType));
		@Var String FuncName;
		if(Node.FuncName == null) {
			FuncName = this.CreateTempFuncName(Node.ResolvedFuncType);
		}
		else if(Node.FuncName.equals("main")) {
			FuncName = "@main";
		}
		else {
			@Var String StringifiedName = Node.ResolvedFuncType.StringfySignature(Node.FuncName);
			this.DefineGlobalSymbol(StringifiedName);
			FuncName = this.ToGlobalSymbol(StringifiedName);
		}
		this.Writer.AddCodeToCurrentBuffer(" " + FuncName + " ");
		this.VisitListNode("(", Node, ", ", ") {");
		this.Writer.AppendBufferAsNewLine();

		this.Writer.IncreaseIndent();
		this.Writer.AppendLabel("Entry");
		this.GenerateCode(null, Node.BlockNode());
		if(!this.Writer.IsBlockTerminated()) {
			this.AppendDefaultReturn(Node.ReturnType);
		}
		this.Writer.DecreaseIndent();

		this.Writer.AppendLine("}");
		if(!Node.Type.IsVoidType()) {
			String FunctionDefine = this.Writer.Write();
			this.Writer = PushedWriter;
			this.Writer.AppendHeaderLine(FunctionDefine);
			this.Writer.AddCodeToCurrentBuffer(FuncName);
		}
	}

	@Override
	public void VisitGetIndexNode(ZGetIndexNode Node) {
		@Var String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = load ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GetArrayElementPointer(Node.RecvNode(), Node.IndexNode());
		//@llvm.gcread
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitGetNameNode(ZGetNameNode Node) {
		@Var ZVariable Var = Node.GetNameSpace().GetLocalVariable(Node.VarName);
		@Var String VarName = Var.VarName + "__" + Var.VarUniqueIndex;
		if(this.Writer.IsUserDefinedVar(VarName)) {
			@Var String TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = load ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type) + "*");
			this.Writer.AddCodeToCurrentBuffer(" " + this.ToLocalSymbol(VarName));
			//if(!this.IsPrimitiveType(Node.Type)) {
			//@llvm.gcread
			//}
			this.Writer.AppendBufferAsNewLine();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
		else {
			this.Writer.AddCodeToCurrentBuffer(this.ToLocalSymbol(Node.VarName));
		}
	}

	@Override
	public void VisitGetterNode(ZGetterNode Node) {
		@Var String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = load ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GetObjectElementPointer(Node.RecvNode(), Node.FieldName);
		//@llvm.gcread
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}

	@Override
	public void VisitGlobalNameNode(ZGlobalNameNode Node) {
		if(Node.IsUntyped()) {
			ZLogger._LogError(Node.SourceToken, "undefined symbol: " + Node.GlobalName);
		}
		if(Node.IsStaticFuncName) {
			this.Writer.AddCodeToCurrentBuffer(this.ToGlobalSymbol(Node.Type.StringfySignature(Node.GlobalName)));
		}
		//else if(!this.IsPrimitiveType(Node.Type)) {
		//	this.Writer.AddCodeToCurrentBuffer(this.ToGlobalSymbol(Node.GlobalName));
		//}
		else {
			@Var String TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = load ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type) + "*");
			this.Writer.AddCodeToCurrentBuffer(" " + this.ToGlobalSymbol(Node.GlobalName));
			this.Writer.AppendBufferAsNewLine();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
	}

	@Override
	public void VisitGroupNode(ZGroupNode Node) {
		this.GenerateCode(null, Node.ExprNode());
	}

	@Override
	public void VisitIfNode(ZIfNode Node) {
		@Var int LabelNum = this.Writer.GetTempLabelNumber();
		@Var String ThenLabel = "If__" + LabelNum + ".Then";
		@Var String ElseLabel = "If__" + LabelNum + ".Else";
		@Var String EndLabel = "If__" + LabelNum + ".End";
		@Var boolean IsEndReachable = false;

		this.Writer.PushNewBuffer("br i1 ");
		this.GenerateCode(null, Node.CondNode());
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + ThenLabel + ", ");
		if(Node.ElseNode() != null) {
			this.Writer.AddCodeToCurrentBuffer("label %" + ElseLabel);
		}
		else {
			this.Writer.AddCodeToCurrentBuffer("label %" + EndLabel);
			IsEndReachable = true;
		}
		this.Writer.AppendBufferAsNewLine();

		this.Writer.AppendLabel(ThenLabel);
		this.GenerateCode(null, Node.ThenNode());
		if(!this.Writer.IsBlockTerminated()) {
			this.Writer.AppendLine("br label %" + EndLabel);
			IsEndReachable = true;
		}

		if(Node.ElseNode() != null) {
			this.Writer.AppendLabel(ElseLabel);
			this.GenerateCode(null, Node.ElseNode());
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
	public void VisitLetNode(ZLetNode Node) {
		this.DefineGlobalSymbol(Node.GlobalName);
		this.Writer.PushNewBuffer(this.ToGlobalSymbol(Node.GlobalName));
		this.Writer.AddCodeToCurrentBuffer(" = private constant ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.SymbolType));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(null, Node.InitValueNode());
		this.Writer.AppendBufferAsHeaderLine();
		//this.Writer.AddCodeToCurrentBuffer(this.ToGlobalSymbol(Node.GlobalName));
		Node.GetNameSpace().SetLocalSymbol(Node.Symbol, Node.ToGlobalNameNode());
	}

	@Override
	public void VisitMacroNode(ZMacroNode Node) {
		@Var String TempVar = "";
		this.Writer.PushNewBuffer("");
		@Var String Macro = Node.GetMacroText();
		@Var ZFuncType FuncType = Node.GetFuncType();
		if(!FuncType.GetReturnType().IsVoidType()) {
			TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = ");
		}
		@Var int fromIndex = 0;
		@Var int BeginNum = Macro.indexOf("$[", fromIndex);
		while(BeginNum != -1) {
			@Var int EndNum = Macro.indexOf("]", BeginNum + 2);
			if(EndNum == -1) {
				break;
			}
			this.Writer.AddCodeToCurrentBuffer(Macro.substring(fromIndex, BeginNum));
			@Var int Index = (int)LibZen._ParseInt(Macro.substring(BeginNum+2, EndNum));
			if(Node.HasAst(Index)) {
				this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.AST[Index].Type));
				this.Writer.AddCodeToCurrentBuffer(" ");
				this.GenerateCode(FuncType.GetFuncParamType(Index), Node.AST[Index]);
			}
			fromIndex = EndNum + 1;
			BeginNum = Macro.indexOf("$[", fromIndex);
		}
		this.Writer.AddCodeToCurrentBuffer(Macro.substring(fromIndex));
		this.Writer.AppendBufferAsNewLine();

		BeginNum = Macro.indexOf("call ");
		while(BeginNum != -1) {
			@Var int EndNum = Macro.indexOf("(", BeginNum + 5);
			if(EndNum == -1) {
				break;
			}
			@Var String ReturnType = Macro.substring(BeginNum + 5, EndNum - 1);

			BeginNum = EndNum;
			EndNum = Macro.indexOf(")", BeginNum + 1);
			if(EndNum == -1) {
				break;
			}
			@Var String ParamType = Macro.substring(BeginNum, EndNum + 1);

			BeginNum = Macro.indexOf("@", EndNum + 1);
			if(BeginNum == -1) {
				break;
			}
			EndNum = Macro.indexOf(" ", BeginNum + 1);
			if(EndNum == -1) {
				break;
			}
			@Var String FuncName = Macro.substring(BeginNum + 1, EndNum);
			this.DeclareExtrnalFunction(FuncName, ReturnType, ParamType);

			BeginNum = Macro.indexOf("call ", EndNum + 1);
		}

		if(!FuncType.GetReturnType().IsVoidType()) {
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
	}

	@Override
	public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		/*FIXME*/
		//		this.AddCodeToCurrentBuffer("{ ");
		//		@Var int ListSize = Node.NodeList.size();
		//		@Var int i = 0;
		//		while(i < ListSize) {
		//			if (i > 0) {
		//				this.AddCodeToCurrentBuffer(", ");
		//			}
		//			@Var ZNode ParamNode = Node.NodeList.get(i + 1);
		//			this.VisitType(ParamNode.Type);
		//			this.AddCodeToCurrentBuffer(" ");
		//			this.GenerateCode(ParamNode);
		//			i = i + 2;
		//		}
		//		this.AddCodeToCurrentBuffer(" }");
	}

	@Override
	public void VisitMethodCallNode(ZMethodCallNode Node) {
		// TODO
	}

	@Override
	public void VisitNewObjectNode(ZNewObjectNode Node) {
		if(Node.Type instanceof ZClassType) {
			this.DeclareExtrnalFunction("GC_malloc", "i8*", "(i64)");
			//this.DeclareExtrnalFunction("free", "void", "(i8*)");
			this.DeclareExtrnalFunction("memcpy", "void", "(i8*, i8*, i64)");

			@Var String AllocateSize = this.GetSizeOfType(Node.Type);
			this.Writer.PushNewBuffer("");
			this.CallExternalFunction("GC_malloc", "(i64 " + AllocateSize + ")");
			@Var String AllocatedAddress = this.Writer.PopCurrentBuffer();

			this.CallExternalFunction("memcpy", "(i8* " + AllocatedAddress + ", i8* bitcast (" + this.GetTypeExpr(Node.Type) + " @" + Node.Type.ShortName + ".Proto to i8*), i64 " + AllocateSize + ")");

			@Var String TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = bitcast i8* ");
			this.Writer.AddCodeToCurrentBuffer(AllocatedAddress);
			this.Writer.AddCodeToCurrentBuffer(" to ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type));
			this.Writer.AppendBufferAsNewLine();

			/* if(this.IsUserDefinedGlobalSymbol(Node.Type.ShortName)) {
				this.Writer.PushNewBuffer("call void ");
				this.Writer.AddCodeToCurrentBuffer(this.ToConstructorSymbol(Node.Type.ShortName));
				this.Writer.AddCodeToCurrentBuffer(" (");
				this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.Type));
				this.Writer.AddCodeToCurrentBuffer(" " + TempVar);
				if(Node.GetListSize() > 0) {
					this.VisitListNode(", ", Node, ", ", ")");
				}
				else {
					this.Writer.AddCodeToCurrentBuffer(")");
				}
				this.Writer.AppendBufferAsNewLine();
			} */

			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
		else if(Node.Type.IsStringType()) {
			// FIXME
		}
	}

	@Override
	public void VisitNotNode(ZNotNode Node) {
		@Var String TempVar = this.Writer.CreateTempLocalSymbol();
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
		@Var int LabelNum = this.Writer.GetTempLabelNumber();
		@Var String RightLabel = "Or__" + LabelNum + ".Right";
		@Var String EndLabel = "Or__" + LabelNum + ".End";

		this.Writer.PushNewBuffer("br i1 ");
		this.GenerateCode(null, Node.LeftNode());
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + EndLabel + ", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + RightLabel);
		this.Writer.AppendBufferAsNewLine();
		@Var String LeftLabel = this.Writer.GetCurrentLabel();

		this.Writer.AppendLabel(RightLabel);
		this.Writer.PushNewBuffer("");
		this.GenerateCode(null, Node.RightNode());
		@Var String RightResult = this.Writer.PopCurrentBuffer();
		this.Writer.AppendLine("br label %" + EndLabel);
		RightLabel = this.Writer.GetCurrentLabel();

		this.Writer.AppendLabel(EndLabel);
		@Var String AllResult = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(AllResult);
		this.Writer.AddCodeToCurrentBuffer(" = phi i1 ");
		this.Writer.AddCodeToCurrentBuffer("[ true, %" + LeftLabel + " ], ");
		this.Writer.AddCodeToCurrentBuffer("[ " + RightResult + ", %" + RightLabel + " ]");
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(AllResult);
	}

	/* @Override
	public void VisitParamNode(ZParamNode Node) {
		this.Writer.DefineLocalSymbol(Node.Name);
		this.Writer.AddCodeToCurrentBuffer(this.ToLocalSymbol(Node.Name));
	} */

	@Override
	public void VisitReturnNode(ZReturnNode Node) {
		this.Writer.PushNewBuffer("ret ");
		if (Node.HasReturnExpr()) {
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.ExprNode().Type));
			this.Writer.AddCodeToCurrentBuffer(" ");
			this.GenerateCode(null, Node.ExprNode());
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
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.ExprNode().Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(null, Node.ExprNode());
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.ExprNode().Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GetArrayElementPointer(Node.RecvNode(), Node.IndexNode());
		//@llvm.gcwrite
		this.Writer.AppendBufferAsNewLine();
	}

	@Override
	public void VisitSetNameNode(ZSetNameNode Node) {
		@Var ZVariable Var = Node.GetNameSpace().GetLocalVariable(Node.VarName);
		@Var String VarName = Var.VarName + "__" + Var.VarUniqueIndex;
		if(!this.Writer.IsUserDefinedVar(VarName)) {
			throw new RuntimeException("Can't assign to argument");
		}
		this.Writer.PushNewBuffer("store ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.ExprNode().Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(null, Node.ExprNode());
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.ExprNode().Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.Writer.AddCodeToCurrentBuffer(this.ToLocalSymbol(VarName));
		//if(!this.IsPrimitiveType(Node.ExprNode().Type)) {
		//@llvm.gcwrite
		//}
		this.Writer.AppendBufferAsNewLine();
	}

	@Override
	public void VisitStringNode(ZStringNode Node) {
		@Var String StringConst = this.CreateTempGlobalSymbol();
		this.Writer.PushNewBuffer(StringConst);
		this.Writer.AddCodeToCurrentBuffer(" = private constant ");
		@Var String StringValue = this.ConvertLLVMString(Node.StringValue);
		@Var int StrLen = this.GetLLVMStringLen(StringValue);
		@Var String StringType = "[" + StrLen + " x i8]";
		this.Writer.AddCodeToCurrentBuffer(StringType);

		this.Writer.AddCodeToCurrentBuffer(" c\"" + StringValue + "\"");
		this.Writer.AppendBufferAsHeaderLine();

		this.DeclareExtrnalFunction("ZString_Create", "%ZString*", "(i8*, i64)");
		this.CallExternalFunction("ZString_Create", "(i8* bitcast (" + StringType + "* " + StringConst + " to i8*), i64 " + (StrLen-1) + ")");
	}

	@Override
	public void VisitSetterNode(ZSetterNode Node) {
		this.Writer.PushNewBuffer("store ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.ExprNode().Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(null, Node.ExprNode());
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.ExprNode().Type) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GetObjectElementPointer(Node.RecvNode(), Node.FieldName);
		//@llvm.gcwrite
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
			this.GenerateCode(null, Node.RecvNode());
		}
		else if(Node.SourceToken.EqualsText('-')){
			if(Node.RecvNode() instanceof ZConstNode) {
				this.Writer.AddCodeToCurrentBuffer("-");
				this.GenerateCode(null, Node.RecvNode());
			}
			else {
				@Var String TempVar = this.Writer.CreateTempLocalSymbol();
				this.Writer.PushNewBuffer(TempVar);
				this.Writer.AddCodeToCurrentBuffer(" = ");
				if(Node.RecvNode().IsUntyped()) {
					ZLogger._LogError(Node.SourceToken, "Unary \"-\" is untyped");
				}
				else if(Node.RecvNode().Type.IsIntType()) {
					this.Writer.AddCodeToCurrentBuffer("sub");
				}
				else if(Node.RecvNode().Type.IsFloatType()) {
					this.Writer.AddCodeToCurrentBuffer("fsub");
				}
				else {
					ZLogger._LogError(Node.SourceToken, "Unknown unary \"-\" for this type");
				}
				this.Writer.AddCodeToCurrentBuffer(" ");
				this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.RecvNode().Type));
				this.Writer.AddCodeToCurrentBuffer(" 0, ");
				this.GenerateCode(null, Node.RecvNode());
				this.Writer.AppendBufferAsNewLine();
				this.Writer.AddCodeToCurrentBuffer(TempVar);
			}
		}
		else if(Node.SourceToken.EqualsText('~')){
			if(Node.RecvNode().IsUntyped()) {
				ZLogger._LogError(Node.SourceToken, "Unary \"~\" is untyped");
				return;
			}
			else if(!Node.RecvNode().Type.IsIntType()){
				ZLogger._LogError(Node.SourceToken, "Unknown unary \"~\" for this type");
				return;
			}
			@Var String TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.PushNewBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = xor ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.RecvNode().Type));
			this.Writer.AddCodeToCurrentBuffer(" -1, ");
			this.GenerateCode(null, Node.RecvNode());
			this.Writer.AppendBufferAsNewLine();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
		else {
			ZLogger._LogError(Node.SourceToken, "Unknown unary \"" + Node.SourceToken.GetText() + "\" for this type");
		}
	}

	@Override
	public void VisitVarNode(ZVarNode Node) {
		assert(Node.InitValueNode() != null); //must be set initial value

		@Var ZVariable Var = Node.GetNameSpace().GetLocalVariable(Node.NativeName);
		@Var String VarName = Var.VarName + "__" + Var.VarUniqueIndex;
		this.Writer.DefineLocalVar(VarName);
		@Var String VarSymbol = this.ToLocalSymbol(VarName);
		this.Writer.PushNewBuffer(VarSymbol);
		this.Writer.AddCodeToCurrentBuffer(" = alloca ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.DeclType));
		this.Writer.AppendBufferAsVarLine();
		//if(!this.IsPrimitiveType(Node.DeclType)) {
		//@llvm.gcroot
		//}

		this.Writer.PushNewBuffer("store ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.InitValueNode().Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(null, Node.InitValueNode());
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(Node.DeclType) + "*");
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.Writer.AddCodeToCurrentBuffer(VarSymbol);
		//if(!this.IsPrimitiveType(Node.InitValueNode().Type)) {
		//@llvm.gcwrite
		//}
		this.Writer.AppendBufferAsNewLine();
		this.VisitStmtList(Node);
	}


	@Override
	public void VisitWhileNode(ZWhileNode Node) {
		@Var int LabelNum = this.Writer.GetTempLabelNumber();
		@Var String CondLabel = "While__" + LabelNum + ".Cond";
		@Var String BodyLabel = "While__" + LabelNum + ".Body";
		@Var String EndLabel = "While__" + LabelNum + ".End";

		this.Writer.AppendLine("br label %" + CondLabel);

		this.Writer.AppendLabel(CondLabel);
		this.Writer.PushNewBuffer("br i1 ");
		this.GenerateCode(null, Node.CondNode());
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + BodyLabel + ", ");
		this.Writer.AddCodeToCurrentBuffer("label %" + EndLabel);
		this.Writer.AppendBufferAsNewLine();

		this.Writer.AppendLabel(BodyLabel);
		this.Writer.PushBreakLabel(EndLabel);
		this.GenerateCode(null, Node.BlockNode());
		if(!this.Writer.IsBlockTerminated()) {
			this.Writer.AppendLine("br label %" + CondLabel);
		}
		this.Writer.PopBreakLabel();

		this.Writer.AppendLabel(EndLabel);
	}

	@Override
	public void VisitLocalDefinedNode(ZLocalDefinedNode Node) {
		if(Node instanceof ZParamNode) {
			@Var String SymbolName = ((ZParamNode)Node).Name;
			this.Writer.DefineLocalSymbol(SymbolName);
			this.Writer.AddCodeToCurrentBuffer(this.ToLocalSymbol(SymbolName));
		}
	}

	@Override
	protected void GenerateSurroundCode(ZNode Node) {
		if(this.IsNeededSurroud(Node)) {
			//this.Writer.AddCodeToCurrentBuffer("(");
			this.GenerateCode(null, Node);
			//this.Writer.AddCodeToCurrentBuffer(")");
		}
		else {
			this.GenerateCode(null, Node);
		}
	}

	private void DefineExternalStruct(String TypeName) {
		if(!this.ExternalStructList.contains(TypeName)) {
			this.Writer.AppendHeaderLine("%" + TypeName + " = type opaque");
			this.ExternalStructList.add(TypeName);
		}
	}

	private void DeclareExtrnalFunction(String FuncName, String ReturnType, String ParamType) {
		if(!this.ExternalFunctionMap.containsKey(FuncName)) {
			this.ExternalFunctionMap.put(FuncName, ReturnType + " " + ParamType + "*");

			this.Writer.PushNewBuffer("declare ");
			this.Writer.AddCodeToCurrentBuffer(ReturnType);
			this.Writer.AddCodeToCurrentBuffer(" @" + FuncName);
			this.Writer.AddCodeToCurrentBuffer(" " + ParamType);
			this.Writer.AppendBufferAsHeaderLine();
		}
	}
	private void CallExternalFunction(String FuncName, String Param) {
		@Var String FuncType = this.ExternalFunctionMap.get(FuncName);
		if(FuncType == null) {
			return;
		}
		@Var String TempVar = "";
		this.Writer.PushNewBuffer("");
		if(!FuncType.startsWith("void")) {
			TempVar = this.Writer.CreateTempLocalSymbol();
			this.Writer.AddCodeToCurrentBuffer(TempVar);
			this.Writer.AddCodeToCurrentBuffer(" = ");
		}
		this.Writer.AddCodeToCurrentBuffer("call ");
		this.Writer.AddCodeToCurrentBuffer(FuncType);
		this.Writer.AddCodeToCurrentBuffer(" @" + FuncName);
		this.Writer.AddCodeToCurrentBuffer(" " + Param);
		this.Writer.AppendBufferAsNewLine();
		if(!FuncType.startsWith("void")) {
			this.Writer.AddCodeToCurrentBuffer(TempVar);
		}
	}

	@Override
	public void VisitStmtList(ZListNode BlockNode) {
		@Var int i = 0;
		while (i < BlockNode.GetListSize()) {
			@Var ZNode SubNode = BlockNode.GetListAt(i);
			this.GenerateCode(null, SubNode);
			i = i + 1;
		}
	}

	private void VisitFieldList(String HeaderElement, ZClassNode ClassNode, boolean WithInitValue) {
		if(ClassNode.SuperType == null) {
			this.Writer.AddCodeToCurrentBuffer(HeaderElement);
		}
		else {
			ZClassNode SuperClassNode = this.ClassFieldMap.get(ClassNode.SuperType.ShortName);
			this.VisitFieldList(HeaderElement, SuperClassNode, WithInitValue);
		}
		@Var int i = 0;
		while(i < ClassNode.GetListSize()) {
			@Var ZFieldNode FieldNode = ClassNode.GetFieldNode(i);
			this.Writer.AddCodeToCurrentBuffer(", ");
			this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(FieldNode.DeclType));
			if(WithInitValue) {
				this.Writer.AddCodeToCurrentBuffer(" ");
				this.GenerateCode(null, FieldNode.InitValueNode());
			}
			i = i + 1;
		}
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
			this.GenerateCode(null, ParamNode);
			i = i + 1;
		}
		this.Writer.AddCodeToCurrentBuffer(CloseToken);
	}

	private void GetArrayElementPointer(ZNode RecvNode, ZNode IndexNode) {
		@Var String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = getelementptr ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(RecvNode.Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(null, RecvNode);
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(IndexNode.Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(null, IndexNode);
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}
	private void GetObjectElementPointer(ZNode RecvNode, String FieldName) {
		@Var String TempVar = this.Writer.CreateTempLocalSymbol();
		this.Writer.PushNewBuffer(TempVar);
		this.Writer.AddCodeToCurrentBuffer(" = getelementptr ");
		this.Writer.AddCodeToCurrentBuffer(this.GetTypeExpr(RecvNode.Type));
		this.Writer.AddCodeToCurrentBuffer(" ");
		this.GenerateCode(null, RecvNode);
		this.Writer.AddCodeToCurrentBuffer(", i64 0");
		this.Writer.AddCodeToCurrentBuffer(", ");
		this.GetObjectElementOffset(RecvNode.Type, FieldName);
		this.Writer.AppendBufferAsNewLine();
		this.Writer.AddCodeToCurrentBuffer(TempVar);
	}
	private void GetObjectElementOffset(ZType Type, String FieldName) {
		@Var String ClassName = Type.ShortName;
		@Var ZClassNode ClassNode = this.ClassFieldMap.get(ClassName);
		if(ClassNode != null) {
			@Var int Size = ClassNode.GetListSize();
			@Var int i = 0;
			while(i < Size) {
				if(ClassNode.GetFieldNode(i).FieldName.equals(FieldName)) {
					@Var int Offset = i + this.GetClassFieldSize(Type.RefType);
					this.Writer.AddCodeToCurrentBuffer("i32 " + Offset);
					return;
				}
				i = i + 1;
			}
		}
		if(Type.RefType != null) {
			this.GetObjectElementOffset(Type.RefType, FieldName);
			return;
		}
		this.Writer.AddCodeToCurrentBuffer("i32 -1");
	}
	private int GetClassFieldSize(ZType Type) {
		if(Type != null) {
			@Var String ClassName = Type.ShortName;
			@Var ZClassNode ClassNode = this.ClassFieldMap.get(ClassName);
			if(ClassNode != null) {
				return ClassNode.GetListSize() + this.GetClassFieldSize(Type.RefType);
			}
		}
		return 1/*Element size of object header*/;
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
