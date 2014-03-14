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
import zen.ast.ZLocalDefinedNode;
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
import zen.parser.ZLogger;
import zen.parser.ZSourceBuilder;
import zen.parser.ZSourceGenerator;
import zen.parser.ZVariable;
import zen.type.ZClassType;
import zen.type.ZFuncType;
import zen.type.ZGenericType;
import zen.type.ZType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;

class LLVMScope {
	@Field private int TempLocalSymbolNumber;
	@Field private boolean IsBlockTerminated;
	@Field private String CurrentLabel;
	@Field private final ArrayList<String> ValueStack = new ArrayList<String>();
	@Field private final ArrayList<String> BreakLabelStack = new ArrayList<String>();
	@Field private final ArrayList<String> LocalSymbolList = new ArrayList<String>();
	@Field private final ArrayList<String> LocalVarList = new ArrayList<String>();

	public LLVMScope() {
		this.TempLocalSymbolNumber = 0;
		this.IsBlockTerminated = false;
		this.CurrentLabel = null;
		this.ValueStack.clear();
		this.BreakLabelStack.clear();
		this.LocalSymbolList.clear();
		this.LocalVarList.clear();
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

	public void SetLabel(String Label) {
		this.IsBlockTerminated = false;
		this.CurrentLabel = Label;
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

	private void PushStrStack(ArrayList<String> Stack, String Label) {
		Stack.add(Label);
	}
	private String PopStrStack(ArrayList<String> Stack) {
		@Var int Size = Stack.size();
		return Stack.remove(Size-1);
	}
	private String PeekStrStack(ArrayList<String> Stack) {
		@Var int Size = Stack.size();
		return Stack.get(Size-1);
	}

	public void PushBreakLabel(String Label) {
		this.PushStrStack(this.BreakLabelStack, Label);
	}
	public String PopBreakLabel() {
		return this.PopStrStack(this.BreakLabelStack);
	}
	public String PeekBreakLabel() {
		return this.PeekStrStack(this.BreakLabelStack);
	}

	public void PushValue(String Value) {
		this.PushStrStack(this.ValueStack, Value);
	}
	public String PopValue() {
		return this.PopStrStack(this.ValueStack);
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
}

public class LLVMSourceGenerator extends ZSourceGenerator {
	@Field private int TempGlobalSymbolNumber;
	@Field private final ArrayList<String> GlobalSymbolList;
	@Field private final ArrayList<String> ExternalStructList;
	@Field private final HashMap<String, String> ExternalFunctionMap;
	@Field private final HashMap<String, ZClassNode> ClassFieldMap;
	@Field private LLVMScope CurrentScope;

	private static final boolean WithInitValue = true;

	public LLVMSourceGenerator() {
		super("ll", "LLVM3.1");
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

		this.TempGlobalSymbolNumber = 0;
		this.GlobalSymbolList = new ArrayList<String>();
		this.ExternalStructList = new ArrayList<String>();
		this.ExternalFunctionMap = new HashMap<String, String>();
		this.ClassFieldMap = new HashMap<String, ZClassNode>();
		this.CurrentScope = null;
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
		if(this.CurrentScope.IsUserDefinedSymbol(Symbol)) {
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
	public void VisitAndNode(ZAndNode Node) {
		@Var int LabelNum = this.CurrentScope.GetTempLabelNumber();
		@Var String RightLabel = "And__" + LabelNum + ".Right";
		@Var String EndLabel = "And__" + LabelNum + ".End";

		this.GenerateCode(null, Node.LeftNode());
		@Var String LeftResult = this.CurrentScope.PopValue();

		this.CurrentBuilder.AppendNewLine("br i1 ");
		this.CurrentBuilder.Append(LeftResult);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append("label %" + RightLabel + ", ");
		this.CurrentBuilder.Append("label %" + EndLabel);
		@Var String LeftLabel = this.CurrentScope.GetCurrentLabel();

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append(RightLabel + ":");
		this.CurrentScope.SetLabel(RightLabel);
		this.GenerateCode(null, Node.RightNode());
		@Var String RightResult = this.CurrentScope.PopValue();
		this.CurrentBuilder.AppendNewLine("br label %" + EndLabel);
		RightLabel = this.CurrentScope.GetCurrentLabel();

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append(EndLabel + ":");
		this.CurrentScope.SetLabel(EndLabel);
		@Var String AllResult = this.CurrentScope.CreateTempLocalSymbol();
		this.CurrentBuilder.AppendNewLine(AllResult);
		this.CurrentBuilder.Append(" = phi i1 ");
		this.CurrentBuilder.Append("[ false, %" + LeftLabel + " ], ");
		this.CurrentBuilder.Append("[ " + RightResult + ", %" + RightLabel + " ]");

		this.CurrentScope.PushValue(AllResult);
	}

	@Override
	public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		@Var StringBuilder sb = new StringBuilder();
		@Var String GlobalConst = this.CreateTempGlobalSymbol();
		sb.append(GlobalConst);
		sb.append(" = private constant ");
		int ArraySize = Node.GetListSize();
		@Var String ElementType = this.GetTypeExpr(((ZGenericType)Node.Type).ParamType);
		@Var String ArrayType = "[" + ArraySize + " x " + ElementType + "]";
		sb.append(ArrayType);

		sb.append(" [");
		@Var int i = 0;
		while(i < ArraySize) {
			if (i > 0) {
				sb.append(", ");
			}
			@Var ZNode SubNode = Node.GetListAt(i);
			sb.append(this.GetTypeExpr(SubNode.Type));
			sb.append(" ");
			this.GenerateCode(null, SubNode);
			sb.append(this.CurrentScope.PopValue());
			i = i + 1;
		}
		sb.append("]");
		this.HeaderBuilder.AppendNewLine(sb.toString());

		this.CurrentScope.PushValue("bitcast (" + ArrayType + "* " + GlobalConst + " to " + this.GetTypeExpr(Node.Type) + ")");
	}

	@Override
	public void VisitBinaryNode(ZBinaryNode Node) {
		this.GenerateCode(null, Node.LeftNode());
		@Var String Left = this.CurrentScope.PopValue();
		this.GenerateCode(null, Node.RightNode());
		@Var String Right = this.CurrentScope.PopValue();

		if(this.IsPrimitiveType(Node.LeftNode().Type)) {
			@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.AppendNewLine(TempVar);
			this.CurrentBuilder.Append(" = ");
			this.CurrentBuilder.Append(this.GetBinaryOpcode(Node));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.LeftNode().Type));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(Left);
			this.CurrentBuilder.Append(", ");
			this.CurrentBuilder.Append(Right);

			this.CurrentScope.PushValue(TempVar);
		}
		else if(Node.LeftNode().Type.IsStringType()) {
			if(Node.SourceToken.EqualsText('+') && Node.RightNode().Type.IsStringType()) {
				this.DeclareExtrnalFunction("ZString_StrCat", "%ZString*", "(%ZString*, %ZString*)");
				this.CallExternalFunction("ZString_StrCat", "(" + this.GetTypeExpr(Node.LeftNode().Type) + " " + Left + ", " + this.GetTypeExpr(Node.RightNode().Type) + " " + Right + ")");
			}
		}
		else {
			ZLogger._LogError(Node.SourceToken, "Unknown binary \"" + Node.SourceToken.GetText() + "\" for this type");
		}
	}

	@Override
	public void VisitBreakNode(ZBreakNode Node) {
		this.CurrentBuilder.AppendNewLine("br label %" + this.CurrentScope.PeekBreakLabel());
		this.CurrentScope.TerminateBlock();
	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		this.VisitStmtList(Node);
	}

	@Override
	public void VisitBooleanNode(ZBooleanNode Node) {
		if (Node.BooleanValue) {
			this.CurrentScope.PushValue(this.TrueLiteral);
		} else {
			this.CurrentScope.PushValue(this.FalseLiteral);
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
			this.CurrentScope.PopValue();
		}
		else {
			this.GenerateSurroundCode(Node.ExprNode());
			@Var String Expr = this.CurrentScope.PopValue();

			@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.AppendNewLine(TempVar);
			this.CurrentBuilder.Append(" = ");
			this.CurrentBuilder.Append(this.GetCastOpCode(BeforeType, AfterType));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(this.GetTypeExpr(BeforeType));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(Expr);
			this.CurrentBuilder.Append(" to ");
			this.CurrentBuilder.Append(this.GetTypeExpr(AfterType));

			this.CurrentScope.PushValue(TempVar);
		}
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		@Var LLVMScope PushedScope = this.CurrentScope;
		this.CurrentScope = new LLVMScope();

		this.CurrentBuilder = this.AppendNewSourceBuilder();

		this.DefineClass(Node.ClassName(), Node);
		@Var String ClassSymbol = this.ToClassSymbol(Node.ClassName());
		this.CurrentBuilder.AppendNewLine(ClassSymbol);
		this.CurrentBuilder.OpenIndent(" = type {");
		this.CurrentBuilder.AppendNewLine("i8*");
		this.VisitFieldList(Node, !WithInitValue);
		this.CurrentBuilder.CloseIndent("}");

		@Var String ProtoSymbol = "@" + Node.ClassName() + ".Proto";
		this.CurrentBuilder.AppendNewLine(ProtoSymbol);
		this.CurrentBuilder.Append(" = private constant ");
		this.CurrentBuilder.Append(ClassSymbol);
		this.CurrentBuilder.OpenIndent(" {");
		if(!Node.SuperType().Equals(ZClassType._ObjectType)) {
			this.CurrentBuilder.AppendNewLine("i8* bitcast (");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.SuperType()));
			this.CurrentBuilder.Append(" @" + Node.SuperType().ShortName + ".Proto");
			this.CurrentBuilder.Append(" to i8*)");
		}
		else {
			this.CurrentBuilder.AppendNewLine("i8* null");
		}
		this.VisitFieldList(Node, WithInitValue);
		this.CurrentBuilder.CloseIndent("}");

		this.CurrentScope = PushedScope;
	}

	@Override
	public void VisitComparatorNode(ZComparatorNode Node) {
		this.GenerateCode(null, Node.LeftNode());
		@Var String Left = this.CurrentScope.PopValue();
		this.GenerateCode(null, Node.RightNode());
		@Var String Right = this.CurrentScope.PopValue();

		@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
		if(this.IsPrimitiveType(Node.LeftNode().Type)) {
			this.CurrentBuilder.AppendNewLine(TempVar);
			this.CurrentBuilder.Append(" = ");
			this.CurrentBuilder.Append(this.GetCompareOpCodeAndCondition(Node));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.LeftNode().Type));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(Left);
			this.CurrentBuilder.Append(", ");
			this.CurrentBuilder.Append(Right);
		}
		else {
			@Var String LeftAddress = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.AppendNewLine(LeftAddress);
			this.CurrentBuilder.Append(" = ptrtoint ");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.LeftNode().Type));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(Left);
			this.CurrentBuilder.Append(" to i64");

			@Var String RightAddress = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.AppendNewLine(RightAddress);
			this.CurrentBuilder.Append(" = ptrtoint ");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.RightNode().Type));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(Right);
			this.CurrentBuilder.Append(" to i64");

			this.CurrentBuilder.AppendNewLine(TempVar);
			this.CurrentBuilder.Append(" = ");
			this.CurrentBuilder.Append(this.GetCompareOpCodeAndCondition(Node));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(this.GetTypeExpr(ZType.IntType));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(LeftAddress);
			this.CurrentBuilder.Append(", ");
			this.CurrentBuilder.Append(RightAddress);
		}
		this.CurrentScope.PushValue(TempVar);
	}

	@Override
	public void VisitErrorNode(ZErrorNode Node) {
	}

	@Override
	public void VisitFloatNode(ZFloatNode Node) {
		this.CurrentScope.PushValue("" + Node.FloatValue);
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

		this.GenerateCode(null, Node.FunctionNode());
		@Var String CallFunc = this.CurrentScope.PopValue();
		this.VisitListNode(" (", Node, ", ", ")");
		@Var String Args = this.CurrentScope.PopValue();

		@Var String TempVar = "";
		this.CurrentBuilder.AppendNewLine("");
		if(!ReturnType.IsVoidType()) {
			TempVar = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.Append(TempVar);
			this.CurrentBuilder.Append(" = ");
		}
		this.CurrentBuilder.Append("call ");
		this.CurrentBuilder.Append(this.GetTypeExpr(FuncType));
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(CallFunc);
		this.CurrentBuilder.Append(Args);

		if(!ReturnType.IsVoidType()) {
			this.CurrentScope.PushValue(TempVar);
		}
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		@Var LLVMScope PushedScope = this.CurrentScope;
		this.CurrentScope = new LLVMScope();

		this.CurrentBuilder = this.AppendNewSourceBuilder();

		this.CurrentBuilder.AppendNewLine("define ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.ReturnType()));
		@Var String FuncName;
		if(Node.FuncName() == null) {
			FuncName = this.CreateTempFuncName(Node.ResolvedFuncType);
		}
		else if(Node.FuncName().equals("main")) {
			FuncName = "@main";
		}
		else {
			@Var String StringifiedName = Node.ResolvedFuncType.StringfySignature(Node.FuncName());
			this.DefineGlobalSymbol(StringifiedName);
			FuncName = this.ToGlobalSymbol(StringifiedName);
		}
		this.CurrentBuilder.Append(" " + FuncName + " ");
		this.VisitListNode("(", Node, ", ", ") {");
		this.CurrentBuilder.OpenIndent(this.CurrentScope.PopValue());
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append("Entry:");
		this.CurrentScope.SetLabel("Entry");

		this.CurrentBuilder = this.AppendNewSourceBuilder();
		this.CurrentBuilder.Indent();
		this.GenerateCode(null, Node.BlockNode());
		if(!this.CurrentScope.IsBlockTerminated()) {
			this.AppendDefaultReturn(Node.ReturnType());
		}
		this.CurrentBuilder.CloseIndent("}");

		this.CurrentScope = PushedScope;
		//Node.ParentFunctionNode != null
		if(Node.FuncName() == null) {
			this.CurrentScope.PushValue(FuncName);
		}
	}

	@Override
	public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.GetArrayElementPointer(Node.RecvNode(), Node.IndexNode());
		@Var String Element = this.CurrentScope.PopValue();

		@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
		this.CurrentBuilder.AppendNewLine(TempVar);
		this.CurrentBuilder.Append(" = load ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.Type) + "*");
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Element);
		//@llvm.gcread

		this.CurrentScope.PushValue(TempVar);
	}

	@Override
	public void VisitGetNameNode(ZGetNameNode Node) {
		@Var ZVariable Var = Node.GetNameSpace().GetLocalVariable(Node.GetName());
		@Var String VarName = Var.VarName + "__" + Var.VarUniqueIndex;
		if(this.CurrentScope.IsUserDefinedVar(VarName)) {
			@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.AppendNewLine(TempVar);
			this.CurrentBuilder.Append(" = load ");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.Type) + "*");
			this.CurrentBuilder.Append(" " + this.ToLocalSymbol(VarName));
			//if(!this.IsPrimitiveType(Node.Type)) {
			//@llvm.gcread
			//}
			this.CurrentScope.PushValue(TempVar);
		}
		else {
			this.CurrentScope.PushValue(this.ToLocalSymbol(Node.GetName()));
		}
	}

	@Override
	public void VisitGetterNode(ZGetterNode Node) {
		this.GetObjectElementPointer(Node.RecvNode(), Node.GetName());
		@Var String Element = this.CurrentScope.PopValue();

		@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
		this.CurrentBuilder.AppendNewLine(TempVar);
		this.CurrentBuilder.Append(" = load ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.Type) + "*");
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Element);
		//@llvm.gcread
		this.CurrentScope.PushValue(TempVar);
	}

	@Override
	public void VisitGlobalNameNode(ZGlobalNameNode Node) {
		if(Node.IsUntyped()) {
			ZLogger._LogError(Node.SourceToken, "undefined symbol: " + Node.GlobalName);
		}
		if(Node.IsFuncNameNode()) {
			this.CurrentScope.PushValue(this.ToGlobalSymbol(Node.Type.StringfySignature(Node.GlobalName)));
		}
		//else if(!this.IsPrimitiveType(Node.Type)) {
		//	this.Writer.PushValue(this.ToGlobalSymbol(Node.GlobalName));
		//}
		else {
			@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.AppendNewLine(TempVar);
			this.CurrentBuilder.Append(" = load ");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.Type) + "*");
			this.CurrentBuilder.Append(" " + this.ToGlobalSymbol(Node.GlobalName));

			this.CurrentScope.PushValue(TempVar);
		}
	}

	@Override
	public void VisitGroupNode(ZGroupNode Node) {
		this.GenerateCode(null, Node.ExprNode());
	}

	@Override
	public void VisitIfNode(ZIfNode Node) {
		@Var int LabelNum = this.CurrentScope.GetTempLabelNumber();
		@Var String ThenLabel = "If__" + LabelNum + ".Then";
		@Var String ElseLabel = "If__" + LabelNum + ".Else";
		@Var String EndLabel = "If__" + LabelNum + ".End";
		@Var boolean IsEndReachable = false;

		this.GenerateCode(null, Node.CondNode());
		@Var String Cond = this.CurrentScope.PopValue();

		this.CurrentBuilder.AppendNewLine("br i1 ");
		this.CurrentBuilder.Append(Cond);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append("label %" + ThenLabel + ", ");
		if(Node.ElseNode() != null) {
			this.CurrentBuilder.Append("label %" + ElseLabel);
		}
		else {
			this.CurrentBuilder.Append("label %" + EndLabel);
			IsEndReachable = true;
		}

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append(ThenLabel + ":");
		this.CurrentScope.SetLabel(ThenLabel);
		this.GenerateCode(null, Node.ThenNode());
		if(!this.CurrentScope.IsBlockTerminated()) {
			this.CurrentBuilder.AppendNewLine("br label %" + EndLabel);
			IsEndReachable = true;
		}

		if(Node.ElseNode() != null) {
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.Append(ElseLabel + ":");
			this.CurrentScope.SetLabel(ElseLabel);
			this.GenerateCode(null, Node.ElseNode());
			if(!this.CurrentScope.IsBlockTerminated()) {
				this.CurrentBuilder.AppendNewLine("br label %" + EndLabel);
				IsEndReachable = true;
			}
		}
		if(IsEndReachable) {
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.Append(EndLabel + ":");
			this.CurrentScope.SetLabel(EndLabel);
		}
	}

	@Override
	public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		// TODO
	}

	@Override
	public void VisitIntNode(ZIntNode Node) {
		this.CurrentScope.PushValue("" + Node.IntValue);
	}

	@Override
	public void VisitLetNode(ZLetNode Node) {
		@Var LLVMScope PushedScope = this.CurrentScope;
		this.CurrentScope = new LLVMScope();

		this.GenerateCode(null, Node.InitValueNode());
		@Var String Init = this.CurrentScope.PopValue();

		this.DefineGlobalSymbol(Node.GlobalName);
		this.HeaderBuilder.AppendNewLine(this.ToGlobalSymbol(Node.GlobalName));
		this.HeaderBuilder.Append(" = private constant ");
		this.HeaderBuilder.Append(this.GetTypeExpr(Node.DeclType()));
		this.HeaderBuilder.Append(" ");
		this.HeaderBuilder.Append(Init);

		this.CurrentScope = PushedScope;
		//this.Writer.PushValue(this.ToGlobalSymbol(Node.GlobalName));
	}

	@Override public void VisitMacroNode(ZMacroNode Node) {
		@Var StringBuilder sb = new StringBuilder();

		@Var String TempVar = "";
		@Var String Macro = Node.GetMacroText();
		@Var ZFuncType FuncType = Node.GetFuncType();
		if(!FuncType.GetReturnType().IsVoidType()) {
			TempVar = this.CurrentScope.CreateTempLocalSymbol();
			sb.append(TempVar);
			sb.append(" = ");
		}
		@Var int fromIndex = 0;
		@Var int BeginNum = Macro.indexOf("$[", fromIndex);
		while(BeginNum != -1) {
			@Var int EndNum = Macro.indexOf("]", BeginNum + 2);
			if(EndNum == -1) {
				break;
			}
			sb.append(Macro.substring(fromIndex, BeginNum));
			@Var int Index = (int)LibZen._ParseInt(Macro.substring(BeginNum+2, EndNum));
			if(Node.AST[Index] != null) {
				sb.append(this.GetTypeExpr(Node.AST[Index].Type));
				sb.append(" ");
				this.GenerateCode(FuncType.GetFuncParamType(Index), Node.AST[Index]);
				sb.append(this.CurrentScope.PopValue());
			}
			fromIndex = EndNum + 1;
			BeginNum = Macro.indexOf("$[", fromIndex);
		}
		sb.append(Macro.substring(fromIndex));
		this.CurrentBuilder.AppendNewLine(sb.toString());

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
			this.CurrentScope.PushValue(TempVar);
		}
	}

	@Override
	public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		// TODO
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
			this.CallExternalFunction("GC_malloc", "(i64 " + AllocateSize + ")");
			@Var String AllocatedAddress = this.CurrentScope.PopValue();

			this.CallExternalFunction("memcpy", "(i8* " + AllocatedAddress + ", i8* bitcast (" + this.GetTypeExpr(Node.Type) + " @" + Node.Type.ShortName + ".Proto to i8*), i64 " + AllocateSize + ")");

			@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.AppendNewLine(TempVar);
			this.CurrentBuilder.Append(" = bitcast i8* ");
			this.CurrentBuilder.Append(AllocatedAddress);
			this.CurrentBuilder.Append(" to ");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.Type));

			/* if(this.IsUserDefinedGlobalSymbol(Node.Type.ShortName)) {
				@Var StringBuilder sb = new StringBuilder();
				sb.append("call void ");
				sb.append(this.ToConstructorSymbol(Node.Type.ShortName));
				sb.append(" (");
				sb.append(this.GetTypeExpr(Node.Type));
				sb.append(" " + TempVar);
				if(Node.GetListSize() > 0) {
					this.VisitListNode(", ", Node, ", ", ")");
					sb.append(this.Writer.PopValue());
				}
				else {
					sb.append(")");
				}
				this.CurrentBuilder.AppendNewLine(sb.toString());
			} */
			this.CurrentScope.PushValue(TempVar);
		}
		else if(Node.Type.IsStringType()) {
			// FIXME
		}
	}

	@Override
	public void VisitNotNode(ZNotNode Node) {
		this.GenerateSurroundCode(Node.AST[ZNotNode._Recv]);
		@Var String Recv = this.CurrentScope.PopValue();

		@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
		this.CurrentBuilder.AppendNewLine(TempVar);
		this.CurrentBuilder.Append(" = ");
		this.CurrentBuilder.Append("xor");
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.AST[ZNotNode._Recv].Type));
		this.CurrentBuilder.Append(" 1, ");
		this.CurrentBuilder.Append(Recv);

		this.CurrentScope.PushValue(TempVar);
	}

	@Override
	public void VisitNullNode(ZNullNode Node) {
		this.CurrentScope.PushValue(this.NullLiteral);
	}

	@Override
	public void VisitOrNode(ZOrNode Node) {
		@Var int LabelNum = this.CurrentScope.GetTempLabelNumber();
		@Var String RightLabel = "Or__" + LabelNum + ".Right";
		@Var String EndLabel = "Or__" + LabelNum + ".End";

		this.GenerateCode(null, Node.LeftNode());
		@Var String LeftResult = this.CurrentScope.PopValue();

		this.CurrentBuilder.AppendNewLine("br i1 ");
		this.CurrentBuilder.Append(LeftResult);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append("label %" + EndLabel + ", ");
		this.CurrentBuilder.Append("label %" + RightLabel);
		@Var String LeftLabel = this.CurrentScope.GetCurrentLabel();

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append(RightLabel + ":");
		this.CurrentScope.SetLabel(RightLabel);
		this.GenerateCode(null, Node.RightNode());
		@Var String RightResult = this.CurrentScope.PopValue();
		this.CurrentBuilder.AppendNewLine("br label %" + EndLabel);
		RightLabel = this.CurrentScope.GetCurrentLabel();

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append(EndLabel + ":");
		this.CurrentScope.SetLabel(EndLabel);
		@Var String AllResult = this.CurrentScope.CreateTempLocalSymbol();
		this.CurrentBuilder.AppendNewLine(AllResult);
		this.CurrentBuilder.Append(" = phi i1 ");
		this.CurrentBuilder.Append("[ true, %" + LeftLabel + " ], ");
		this.CurrentBuilder.Append("[ " + RightResult + ", %" + RightLabel + " ]");

		this.CurrentScope.PushValue(AllResult);
	}

	/* @Override
	public void VisitParamNode(ZParamNode Node) {
		this.Writer.DefineLocalSymbol(Node.Name);
		this.Writer.PushValue(this.ToLocalSymbol(Node.Name));
	} */

	@Override
	public void VisitReturnNode(ZReturnNode Node) {
		if (Node.HasReturnExpr()) {
			this.GenerateCode(null, Node.ExprNode());
			@Var String Expr = this.CurrentScope.PopValue();

			this.CurrentBuilder.AppendNewLine("ret ");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.ExprNode().Type));
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(Expr);
		}
		else {
			this.CurrentBuilder.AppendNewLine("ret void");
		}
		this.CurrentScope.TerminateBlock();
	}

	@Override
	public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.GenerateCode(null, Node.ExprNode());
		@Var String Expr = this.CurrentScope.PopValue();
		this.GetArrayElementPointer(Node.RecvNode(), Node.IndexNode());
		@Var String Element = this.CurrentScope.PopValue();

		this.CurrentBuilder.AppendNewLine("store ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.ExprNode().Type));
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Expr);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.ExprNode().Type) + "*");
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Element);
		//@llvm.gcwrite
	}

	@Override
	public void VisitSetNameNode(ZSetNameNode Node) {
		@Var ZVariable Var = Node.GetNameSpace().GetLocalVariable(Node.GetName());
		@Var String VarName = Var.VarName + "__" + Var.VarUniqueIndex;
		if(!this.CurrentScope.IsUserDefinedVar(VarName)) {
			throw new RuntimeException("Can't assign to argument");
		}

		this.GenerateCode(null, Node.ExprNode());
		@Var String Expr = this.CurrentScope.PopValue();

		this.CurrentBuilder.AppendNewLine("store ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.ExprNode().Type));
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Expr);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.ExprNode().Type) + "*");
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(this.ToLocalSymbol(VarName));
		//if(!this.IsPrimitiveType(Node.ExprNode().Type)) {
		//@llvm.gcwrite
		//}
	}

	@Override
	public void VisitStringNode(ZStringNode Node) {
		@Var String StringConst = this.CreateTempGlobalSymbol();
		this.HeaderBuilder.AppendNewLine(StringConst);
		this.HeaderBuilder.Append(" = private constant ");
		@Var String StringValue = this.ConvertLLVMString(Node.StringValue);
		@Var int StrLen = this.GetLLVMStringLen(StringValue);
		@Var String StringType = "[" + StrLen + " x i8]";
		this.HeaderBuilder.Append(StringType);
		this.HeaderBuilder.Append(" c\"" + StringValue + "\"");

		this.DeclareExtrnalFunction("ZString_Create", "%ZString*", "(i8*, i64)");
		this.CallExternalFunction("ZString_Create", "(i8* bitcast (" + StringType + "* " + StringConst + " to i8*), i64 " + (StrLen-1) + ")");
	}

	@Override
	public void VisitSetterNode(ZSetterNode Node) {
		this.GenerateCode(null, Node.ExprNode());
		@Var String Expr = this.CurrentScope.PopValue();
		this.GetObjectElementPointer(Node.RecvNode(), Node.GetName());
		@Var String Element = this.CurrentScope.PopValue();

		this.CurrentBuilder.AppendNewLine("store ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.ExprNode().Type));
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Expr);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.ExprNode().Type) + "*");
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Element);
		//@llvm.gcwrite
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
		this.GenerateCode(null, Node.RecvNode());
		@Var String Recv = this.CurrentScope.PopValue();

		if(Node.SourceToken.EqualsText('+')) {
			this.CurrentScope.PushValue(Recv);
		}
		else if(Node.SourceToken.EqualsText('-')){
			if(Node.RecvNode() instanceof ZConstNode) {
				this.CurrentBuilder.Append("-");
				this.CurrentBuilder.Append(Recv);
			}
			else {
				@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
				this.CurrentBuilder.AppendNewLine(TempVar);
				this.CurrentBuilder.Append(" = ");
				if(Node.RecvNode().IsUntyped()) {
					ZLogger._LogError(Node.SourceToken, "Unary \"-\" is untyped");
				}
				else if(Node.RecvNode().Type.IsIntType()) {
					this.CurrentBuilder.Append("sub");
				}
				else if(Node.RecvNode().Type.IsFloatType()) {
					this.CurrentBuilder.Append("fsub");
				}
				else {
					ZLogger._LogError(Node.SourceToken, "Unknown unary \"-\" for this type");
				}
				this.CurrentBuilder.Append(" ");
				this.CurrentBuilder.Append(this.GetTypeExpr(Node.RecvNode().Type));
				this.CurrentBuilder.Append(" 0, ");
				this.CurrentBuilder.Append(Recv);

				this.CurrentScope.PushValue(TempVar);
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

			@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.AppendNewLine(TempVar);
			this.CurrentBuilder.Append(" = xor ");
			this.CurrentBuilder.Append(this.GetTypeExpr(Node.RecvNode().Type));
			this.CurrentBuilder.Append(" -1, ");
			this.CurrentBuilder.Append(Recv);

			this.CurrentScope.PushValue(TempVar);
		}
		else {
			ZLogger._LogError(Node.SourceToken, "Unknown unary \"" + Node.SourceToken.GetText() + "\" for this type");
		}
	}

	@Override
	public void VisitVarNode(ZVarNode Node) {
		assert(Node.InitValueNode() != null); //must be set initial value
		@Var ZSourceBuilder EntryBlockBuilder = this.CurrentBuilder.Pop();

		@Var ZVariable Var = Node.GetNameSpace().GetLocalVariable(Node.GetName());
		@Var String VarName = Var.VarName + "__" + Var.VarUniqueIndex;
		this.CurrentScope.DefineLocalVar(VarName);
		@Var String VarSymbol = this.ToLocalSymbol(VarName);
		EntryBlockBuilder.AppendNewLine(VarSymbol);
		EntryBlockBuilder.Append(" = alloca ");
		EntryBlockBuilder.Append(this.GetTypeExpr(Node.DeclType()));
		//if(!this.IsPrimitiveType(Node.DeclType())) {
		//@llvm.gcroot
		//}

		this.GenerateCode(null, Node.InitValueNode());
		@Var String Init = this.CurrentScope.PopValue();

		this.CurrentBuilder.AppendNewLine("store ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.InitValueNode().Type));
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Init);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append(this.GetTypeExpr(Node.DeclType()) + "*");
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(VarSymbol);
		//if(!this.IsPrimitiveType(Node.InitValueNode().Type)) {
		//@llvm.gcwrite
		//}
		this.VisitStmtList(Node);
	}

	@Override
	public void VisitWhileNode(ZWhileNode Node) {
		@Var int LabelNum = this.CurrentScope.GetTempLabelNumber();
		@Var String CondLabel = "While__" + LabelNum + ".Cond";
		@Var String BodyLabel = "While__" + LabelNum + ".Body";
		@Var String EndLabel = "While__" + LabelNum + ".End";

		this.CurrentBuilder.AppendNewLine("br label %" + CondLabel);

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append(CondLabel + ":");
		this.CurrentScope.SetLabel(CondLabel);
		this.GenerateCode(null, Node.CondNode());
		@Var String Cond = this.CurrentScope.PopValue();

		this.CurrentBuilder.AppendNewLine("br i1 ");
		this.CurrentBuilder.Append(Cond);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append("label %" + BodyLabel + ", ");
		this.CurrentBuilder.Append("label %" + EndLabel);

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append(BodyLabel + ":");
		this.CurrentScope.SetLabel(BodyLabel);
		this.CurrentScope.PushBreakLabel(EndLabel);
		this.GenerateCode(null, Node.BlockNode());
		if(!this.CurrentScope.IsBlockTerminated()) {
			this.CurrentBuilder.AppendNewLine("br label %" + CondLabel);
		}
		this.CurrentScope.PopBreakLabel();

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Append(EndLabel + ":");
		this.CurrentScope.SetLabel(EndLabel);
	}

	@Override
	public void VisitLocalDefinedNode(ZLocalDefinedNode Node) {
		if(Node instanceof ZParamNode) {
			@Var String SymbolName = ((ZParamNode)Node).GetName();
			this.CurrentScope.DefineLocalSymbol(SymbolName);
			this.CurrentScope.PushValue(this.ToLocalSymbol(SymbolName));
		}
	}

	@Override
	protected void GenerateSurroundCode(ZNode Node) {
		if(this.IsNeededSurroud(Node)) {
			//this.CurrentBuilder.Append("(");
			this.GenerateCode(null, Node);
			//this.CurrentBuilder.Append(")");
		}
		else {
			this.GenerateCode(null, Node);
		}
	}

	private void DefineExternalStruct(String TypeName) {
		if(!this.ExternalStructList.contains(TypeName)) {
			this.HeaderBuilder.AppendNewLine("%" + TypeName + " = type opaque");
			this.ExternalStructList.add(TypeName);
		}
	}

	private void DeclareExtrnalFunction(String FuncName, String ReturnType, String ParamType) {
		if(!this.ExternalFunctionMap.containsKey(FuncName)) {
			this.ExternalFunctionMap.put(FuncName, ReturnType + " " + ParamType + "*");
			this.HeaderBuilder.AppendNewLine("declare ");
			this.HeaderBuilder.Append(ReturnType);
			this.HeaderBuilder.Append(" @" + FuncName);
			this.HeaderBuilder.Append(" " + ParamType);
		}
	}
	private void CallExternalFunction(String FuncName, String Param) {
		@Var String FuncType = this.ExternalFunctionMap.get(FuncName);
		if(FuncType == null) {
			return;
		}
		@Var String TempVar = "";
		this.CurrentBuilder.AppendNewLine("");
		if(!FuncType.startsWith("void")) {
			TempVar = this.CurrentScope.CreateTempLocalSymbol();
			this.CurrentBuilder.Append(TempVar);
			this.CurrentBuilder.Append(" = ");
		}
		this.CurrentBuilder.Append("call ");
		this.CurrentBuilder.Append(FuncType);
		this.CurrentBuilder.Append(" @" + FuncName);
		this.CurrentBuilder.Append(" " + Param);

		if(!FuncType.startsWith("void")) {
			this.CurrentScope.PushValue(TempVar);
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

	private void VisitFieldList(ZClassNode ClassNode, boolean WithInitValue) {
		if(ClassNode.SuperType() != ZClassType._ObjectType) {
			ZClassNode SuperClassNode = this.ClassFieldMap.get(ClassNode.SuperType().ShortName);
			this.VisitFieldList(SuperClassNode, WithInitValue);
		}
		@Var int i = 0;
		while(i < ClassNode.GetListSize()) {
			@Var ZFieldNode FieldNode = ClassNode.GetFieldNode(i);
			this.CurrentBuilder.Append(",");
			this.CurrentBuilder.AppendNewLine(this.GetTypeExpr(FieldNode.DeclType()));
			if(WithInitValue) {
				this.CurrentBuilder.Append(" ");
				this.GenerateCode(null, FieldNode.InitValueNode());
				this.CurrentBuilder.Append(this.CurrentScope.PopValue());
			}
			i = i + 1;
		}
	}

	@Override
	protected void VisitListNode(String OpenToken, ZListNode VargNode, String DelimToken, String CloseToken) {
		@Var StringBuilder sb = new StringBuilder();
		sb.append(OpenToken);
		@Var int i = 0;
		while(i < VargNode.GetListSize()) {
			@Var ZNode ParamNode = VargNode.GetListAt(i);
			if (i > 0) {
				sb.append(DelimToken);
			}
			sb.append(this.GetTypeExpr(ParamNode.Type));
			sb.append(" ");
			this.GenerateCode(null, ParamNode);
			sb.append(this.CurrentScope.PopValue());
			i = i + 1;
		}
		sb.append(CloseToken);
		this.CurrentScope.PushValue(sb.toString());
	}

	private void GetArrayElementPointer(ZNode RecvNode, ZNode IndexNode) {
		this.GenerateCode(null, RecvNode);
		@Var String Recv = this.CurrentScope.PopValue();
		this.GenerateCode(null, IndexNode);
		@Var String Index = this.CurrentScope.PopValue();

		@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
		this.CurrentBuilder.AppendNewLine(TempVar);
		this.CurrentBuilder.Append(" = getelementptr ");
		this.CurrentBuilder.Append(this.GetTypeExpr(RecvNode.Type));
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Recv);
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append(this.GetTypeExpr(IndexNode.Type));
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Index);

		this.CurrentScope.PushValue(TempVar);
	}
	private void GetObjectElementPointer(ZNode RecvNode, String FieldName) {
		this.GenerateCode(null, RecvNode);
		@Var String Recv = this.CurrentScope.PopValue();
		this.GetObjectElementOffset(RecvNode.Type, FieldName);
		@Var String Field = this.CurrentScope.PopValue();

		@Var String TempVar = this.CurrentScope.CreateTempLocalSymbol();
		this.CurrentBuilder.AppendNewLine(TempVar);
		this.CurrentBuilder.Append(" = getelementptr ");
		this.CurrentBuilder.Append(this.GetTypeExpr(RecvNode.Type));
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Recv);
		this.CurrentBuilder.Append(", i64 0");
		this.CurrentBuilder.Append(", ");
		this.CurrentBuilder.Append(Field);

		this.CurrentScope.PushValue(TempVar);
	}
	private void GetObjectElementOffset(ZType Type, String FieldName) {
		@Var String ClassName = Type.ShortName;
		@Var ZClassNode ClassNode = this.ClassFieldMap.get(ClassName);
		if(ClassNode != null) {
			@Var int Size = ClassNode.GetListSize();
			@Var int i = 0;
			while(i < Size) {
				if(ClassNode.GetFieldNode(i).GetName().equals(FieldName)) {
					@Var int Offset = i + this.GetClassFieldSize(Type.RefType);
					this.CurrentScope.PushValue("i32 " + Offset);
					return;
				}
				i = i + 1;
			}
		}
		if(Type.RefType != null) {
			this.GetObjectElementOffset(Type.RefType, FieldName);
			return;
		}
		this.CurrentScope.PushValue("i32 -1");
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
		this.CurrentBuilder.AppendNewLine("ret ");
		if(!ReturnType.IsVoidType()) {
			this.CurrentBuilder.Append(this.GetTypeExpr(ReturnType));
			this.CurrentBuilder.Append(" ");
			if(ReturnType.IsFloatType()) {
				this.CurrentBuilder.Append("" + 0.0);
			}
			else if(ReturnType.IsBooleanType()) {
				this.CurrentBuilder.Append(this.FalseLiteral);
			}
			else {
				this.CurrentBuilder.Append("" + 0);
			}
		}
		else {
			this.CurrentBuilder.Append("void");
		}

	}
}
