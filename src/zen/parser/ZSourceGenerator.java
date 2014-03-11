// ***************************************************************************
// Copyright (c) 2013-2014, Konoha project authors. All rights reserved.
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
package zen.parser;

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZAsmNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZClassNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZDesugarNode;
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
import zen.ast.ZMapEntryNode;
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
import zen.ast.ZSugarNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTopLevelNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.lang.zen.ZenTypeSafer;
import zen.type.ZClassType;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Nullable;
import zen.util.Var;
import zen.util.ZArray;
import zen.util.ZMap;
import zen.util.ZenMethod;

public class ZSourceGenerator extends ZGenerator {

	@Field public ZMap<String> NativeTypeMap = new ZMap<String>(null);
	@Field public ZMap<String> ReservedNameMap = new ZMap<String>(null);

	@Field private final ZArray<ZSourceBuilder> BuilderList = new ZArray<ZSourceBuilder>(new ZSourceBuilder[4]);
	@Field protected ZSourceBuilder HeaderBuilder;
	@Field protected ZSourceBuilder CurrentBuilder;

	@Field public boolean IsDynamicLanguage = false;
	@Field public String Tab = "   ";
	@Field public String LineFeed = "\n";
	@Field public String LineComment = "//";
	@Field public String BeginComment = "/*";
	@Field public String EndComment = "*/";
	@Field public String SemiColon = ";";
	@Field public String Camma = ", ";

	@Field public String StringLiteralPrefix = "";
	@Field public String IntLiteralSuffix = "";

	@Field public String TrueLiteral = "true";
	@Field public String FalseLiteral = "false";
	@Field public String NullLiteral = "null";

	@Field public String NotOperator = "!";
	@Field public String AndOperator = "&&";
	@Field public String OrOperator = "||";

	@Field public String TopType = "var";
	@Field public String ErrorFunc = "perror";

	@Field public boolean ReadableCode = true;

	public ZSourceGenerator(String Extension, String LangVersion) {
		super(new ZLangInfo(LangVersion, Extension));
		this.InitBuilderList();
		this.SetTypeChecker(new ZenTypeSafer(this));
	}

	@ZenMethod protected void InitBuilderList() {
		this.CurrentBuilder = null;
		this.BuilderList.clear(0);
		this.HeaderBuilder = this.AppendNewSourceBuilder();
		this.CurrentBuilder = this.AppendNewSourceBuilder();
	}

	@ZenMethod protected void Finish(String FileName) {

	}

	protected final ZSourceBuilder AppendNewSourceBuilder() {
		@Var ZSourceBuilder Builder = new ZSourceBuilder(this, this.CurrentBuilder);
		this.BuilderList.add(Builder);
		return Builder;
	}

	protected final ZSourceBuilder InsertNewSourceBuilder() {
		@Var ZSourceBuilder Builder = new ZSourceBuilder(this, this.CurrentBuilder);
		@Var int i = 0;
		while(i < this.BuilderList.size()) {
			if(this.BuilderList.ArrayValues[i] == this.CurrentBuilder) {
				this.BuilderList.add(i, Builder);
				return Builder;
			}
			i = i + 1;
		}
		this.BuilderList.add(Builder);
		return Builder;
	}

	@Override protected void GenerateImportLibrary(String LibName) {
		this.HeaderBuilder.AppendNewLine("require ", LibName, this.SemiColon);
	}

	protected void SetNativeType(ZType Type, String TypeName) {
		@Var String Key = "" + Type.TypeId;
		this.NativeTypeMap.put(Key, TypeName);
	}

	protected String GetNativeTypeName(ZType Type) {
		@Var String Key = "" + Type.TypeId;
		@Var String TypeName = this.NativeTypeMap.GetOrNull(Key);
		if (TypeName == null) {
			return Type.ShortName;
		}
		return TypeName;
	}

	public final void SetReservedName(String Keyword, @Nullable String AnotherName) {
		if(AnotherName == null) {
			AnotherName = "_" + Keyword;
		}
		this.ReservedNameMap.put(Keyword, AnotherName);
	}

	public String NameLocalVariable(String Name, int Index) {
		if(Index == 0) {
			@Var String SafeName = this.ReservedNameMap.GetOrNull(Name);
			if(SafeName == null) {
				SafeName = Name;
			}
			return SafeName;
		}
		return Name + "__" + Index;
	}

	@Override public final void WriteTo(@Nullable String FileName) {
		this.Finish(FileName);
		this.Logger.OutputErrorsToStdErr();
		LibZen._WriteTo(this.LangInfo.NameOutputFile(FileName), this.BuilderList);
		this.InitBuilderList();
	}

	@Override public final String GetSourceText() {
		this.Finish(null);
		@Var ZSourceBuilder sb = new ZSourceBuilder(this, null);
		@Var int i = 0;
		while(i < this.BuilderList.size()) {
			@Var ZSourceBuilder Builder = this.BuilderList.ArrayValues[i];
			sb.Append(Builder.toString());
			Builder.Clear();
			sb.AppendLineFeed();
			sb.AppendLineFeed();
			i = i + 1;
		}
		this.InitBuilderList();
		return LibZen._SourceBuilderToString(sb);
	}

	//	@Override public boolean StartCodeGeneration(ZNode Node, boolean IsInteractive) {
	//		this.CurrentBuilder.AppendNewLine();
	//		Node.Accept(this);
	//		if(IsInteractive) {
	//			@Var int i = 0;
	//			LibZen._PrintLine("---");
	//			while(i < this.BuilderList.size()) {
	//				@Var ZSourceBuilder Builder = this.BuilderList.ArrayValues[i];
	//				LibZen._PrintLine(Builder.toString());
	//				Builder.Clear();
	//				i = i + 1;
	//			}
	//			this.InitBuilderList();
	//		}
	//		return true;
	//	}

	@Override public void Perform() {
		@Var int i = 0;
		LibZen._PrintLine("---");
		while(i < this.BuilderList.size()) {
			@Var ZSourceBuilder Builder = this.BuilderList.ArrayValues[i];
			LibZen._PrintLine(Builder.toString());
			Builder.Clear();
			i = i + 1;
		}
		this.InitBuilderList();
	}

	//	public final void FlushErrorReport() {
	//		@Var ZenSourceBuilder Builder = this.NewSourceBuilder();
	//		@Var String[] Reports = this.Logger.GetReportedErrors();
	//		Builder.AppendLine("");
	//		for(@Var int i = 0; i < Reports.length; i = i + 1) {
	//			Builder.AppendCommentLine(Reports[i]);
	//		}
	//		Builder.AppendLine("");
	//	}

	@Override public void GenerateStatement(ZNode Node) {
		this.CurrentBuilder.AppendNewLine();
		if(Node instanceof ZCastNode) {
			if(Node.Type == ZType.VoidType) {
				Node.AST[0].Accept(this);
				return;
			}
		}
		Node.Accept(this);
	}

	protected final void GenerateCode2(String Pre, ZType ContextType, ZNode Node, String Post) {
		if(Pre != null && Pre.length() > 0) {
			this.CurrentBuilder.Append(Pre);
		}
		this.GenerateCode(ContextType, Node);
		if(Post != null && Post.length() > 0) {
			this.CurrentBuilder.Append(Post);
		}
	}

	protected final void GenerateCode2(String Pre, ZType ContextType, ZNode Node, String Delim, ZType ContextType2, ZNode Node2, String Post) {
		if(Pre != null && Pre.length() > 0) {
			this.CurrentBuilder.Append(Pre);
		}
		this.GenerateCode(ContextType, Node);
		if(Delim != null && Delim.length() > 0) {
			this.CurrentBuilder.Append(Delim);
		}
		this.GenerateCode(ContextType2, Node2);
		if(Post != null && Post.length() > 0) {
			this.CurrentBuilder.Append(Post);
		}
	}

	protected final void GenerateCode2(String Pre, ZNode Node, String Delim, ZNode Node2, String Post) {
		this.GenerateCode2(Pre, null, Node, Delim, null, Node2, Post);
	}

	final protected boolean IsNeededSurroud(ZNode Node) {
		if(Node instanceof ZBinaryNode) {
			return true;
		}
		return false;
	}

	protected void GenerateSurroundCode(ZNode Node) {
		if(this.IsNeededSurroud(Node)) {
			this.GenerateCode2("(", null, Node, ")");
		}
		else {
			this.GenerateCode(null, Node);
		}
	}

	public void VisitStmtList(ZListNode BlockNode) {
		@Var int i = 0;
		while (i < BlockNode.GetListSize()) {
			@Var ZNode SubNode = BlockNode.GetListAt(i);
			this.GenerateStatement(SubNode);
			i = i + 1;
			if(i  < BlockNode.GetListSize()) {
				this.CurrentBuilder.Append(this.SemiColon);
			}
		}
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.OpenIndent("{");
		this.VisitStmtList(Node);
		if(!this.CurrentBuilder.EndsWith("}")) {
			this.CurrentBuilder.Append(this.SemiColon);
		}
		this.CurrentBuilder.CloseIndent("}");
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.CurrentBuilder.Append(this.NullLiteral);
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		if (Node.BooleanValue) {
			this.CurrentBuilder.Append(this.TrueLiteral);
		} else {
			this.CurrentBuilder.Append(this.FalseLiteral);
		}
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.CurrentBuilder.Append(String.valueOf(Node.IntValue), this.IntLiteralSuffix);
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.CurrentBuilder.Append(String.valueOf(Node.FloatValue));
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.CurrentBuilder.Append(this.StringLiteralPrefix, LibZen._QuoteString(Node.StringValue));
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.VisitListNode("[", Node, "]");
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.CurrentBuilder.Append("{");
		@Var int i = 0;
		while(i < Node.GetListSize()) {
			@Var ZMapEntryNode Entry = Node.GetMapEntryNode(i);
			this.GenerateCode2("", Entry.KeyNode(), ": ", Entry.ValueNode(), ",");
			i = i + 1;
		}
		this.CurrentBuilder.Append("} ");  // space is needed to distinguish block
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.CurrentBuilder.Append("new ");
		this.GenerateTypeName(Node.Type);
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.GenerateCode2("(", null, Node.ExprNode(), ")");
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.GenerateCode(null, Node.RecvNode());
		this.GenerateCode2("[", null, Node.IndexNode(), "]");
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.GenerateCode(null, Node.RecvNode());
		this.GenerateCode2("[", null, Node.IndexNode(), "] = ");
		this.GenerateCode(null, Node.ExprNode());
	}

	@Override public void VisitGlobalNameNode(ZGlobalNameNode Node) {
		if(Node.IsUntyped() && !this.IsDynamicLanguage) {
			ZLogger._LogError(Node.SourceToken, "undefined symbol: " + Node.GlobalName);
		}
		if(Node.IsFuncNameNode()) {
			this.CurrentBuilder.Append(Node.Type.StringfySignature(Node.GlobalName));
		}
		else {
			this.CurrentBuilder.Append(Node.GlobalName);
		}
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.GetName(), Node.VarIndex));
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.GetName(), Node.VarIndex), " = ");
		this.GenerateCode(null, Node.ExprNode());
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.GenerateSurroundCode(Node.RecvNode());
		this.CurrentBuilder.Append(".", Node.GetName());
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		this.GenerateSurroundCode(Node.RecvNode());
		this.CurrentBuilder.Append(".", Node.GetName(), " = ");
		this.GenerateCode(null, Node.ExprNode());
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.GenerateSurroundCode(Node.RecvNode());
		this.CurrentBuilder.Append(".", Node.MethodName());
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitMacroNode(ZMacroNode Node) {
		@Var String Macro = Node.GetMacroText();
		@Var ZFuncType FuncType = Node.GetFuncType();
		@Var int fromIndex = 0;
		@Var int BeginNum = Macro.indexOf("$[", fromIndex);
		while(BeginNum != -1) {
			@Var int EndNum = Macro.indexOf("]", BeginNum + 2);
			if(EndNum == -1) {
				break;
			}
			this.CurrentBuilder.Append(Macro.substring(fromIndex, BeginNum));
			@Var int Index = (int)LibZen._ParseInt(Macro.substring(BeginNum+2, EndNum));
			if(Node.AST[Index] != null) {
				this.GenerateCode(FuncType.GetFuncParamType(Index), Node.AST[Index]);
			}
			fromIndex = EndNum + 1;
			BeginNum = Macro.indexOf("$[", fromIndex);
		}
		this.CurrentBuilder.Append(Macro.substring(fromIndex));
		if(Node.MacroFunc.RequiredLibrary != null) {
			this.ImportLibrary(Node.MacroFunc.RequiredLibrary);
		}
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.GenerateCode(null, Node.FunctionNode());
		this.VisitListNode("(", Node, ")");
	}

	@ZenMethod protected String GetUnaryOperator(ZType Type, ZToken Token) {
		if(Token.EqualsText('-')) {
			return "-";
		}
		if(Token.EqualsText('+')) {
			return "+";
		}
		return Token.GetText();
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.CurrentBuilder.Append(this.GetUnaryOperator(Node.Type, Node.SourceToken));
		this.GenerateCode(null, Node.RecvNode());
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		this.CurrentBuilder.Append(this.NotOperator);
		this.GenerateSurroundCode(Node.RecvNode());
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		if(Node.Type.IsVoidType()) {
			this.GenerateCode(null, Node.ExprNode());
		}
		else {
			this.CurrentBuilder.Append("(");
			this.GenerateTypeName(Node.Type);
			this.CurrentBuilder.Append(")");
			this.GenerateSurroundCode(Node.ExprNode());
		}
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.Append(" instanceof ");
		this.GenerateTypeName(Node.TargetType());
	}

	@ZenMethod protected String GetBinaryOperator(ZType Type, ZToken Token) {
		if(Token.EqualsText('+')) {
			return "+";
		}
		if(Token.EqualsText('-')) {
			return "-";
		}
		return Token.GetText();
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append("(");
		}
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.AppendToken(this.GetBinaryOperator(Node.Type, Node.SourceToken));
		this.GenerateCode(null, Node.RightNode());
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append(")");
		}
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.AppendToken(this.GetBinaryOperator(Node.Type, Node.SourceToken));
		this.GenerateCode(null, Node.RightNode());
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.AppendToken(this.AndOperator);
		this.GenerateCode(null, Node.RightNode());
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		this.GenerateCode(null, Node.LeftNode());
		this.CurrentBuilder.AppendToken(this.OrOperator);
		this.GenerateCode(null, Node.RightNode());
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		this.GenerateCode2("if (", null, Node.CondNode(), ")");
		this.GenerateCode(null, Node.ThenNode());
		if (Node.HasElseNode()) {
			this.CurrentBuilder.AppendNewLine();
			this.CurrentBuilder.Append("else ");
			this.GenerateCode(null, Node.ElseNode());
		}
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.CurrentBuilder.Append("return");
		if (Node.HasReturnExpr()) {
			this.CurrentBuilder.Append(" ");
			this.GenerateCode(null, Node.ExprNode());
		}
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.GenerateCode2("while (", null, Node.CondNode(),")");
		this.GenerateCode(null, Node.BlockNode());
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.CurrentBuilder.Append("break");
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("throw ");
		this.GenerateCode(null, Node.ExprNode());
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(null, Node.TryBlockNode());
		if(Node.HasCatchBlockNode()) {
			this.CurrentBuilder.AppendNewLine("catch (", Node.ExceptionName());
			this.CurrentBuilder.Append(") ");
			this.GenerateCode(null, Node.CatchBlockNode());
		}
		if (Node.HasFinallyBlockNode()) {
			this.CurrentBuilder.AppendNewLine("finally ");
			this.GenerateCode(null, Node.FinallyBlockNode());
		}
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.Append("var ", this.NameLocalVariable(Node.GetName(), Node.VarIndex));
		this.GenerateTypeAnnotation(Node.DeclType());
		this.GenerateCode2(" = ", null, Node.InitValueNode(), this.SemiColon);
		this.VisitStmtList(Node);
	}

	protected void GenerateTypeAnnotation(ZType Type) {
		if(!Type.IsVarType()) {
			this.CurrentBuilder.Append(": ");
			this.GenerateTypeName(Type);
		}
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		this.CurrentBuilder.AppendNewLine("let ", Node.GetName());
		this.GenerateTypeAnnotation(Node.DeclType());
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(null, Node.InitValueNode());
	}

	public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.GetName(), Node.ParamIndex));
		this.GenerateTypeAnnotation(Node.Type);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(Node.IsExport) {
			this.CurrentBuilder.Append("export ");
		}
		this.CurrentBuilder.Append("function ");
		if(Node.FuncName() != null) {
			this.CurrentBuilder.Append(Node.FuncName());
		}
		this.VisitListNode("(", Node, ")");
		this.GenerateTypeAnnotation(Node.ReturnType());
		this.GenerateCode(null, Node.BlockNode());
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		this.CurrentBuilder.AppendNewLine("class ", Node.ClassName());
		if(Node.SuperType() != null) {
			this.CurrentBuilder.Append(" extends ");
			this.GenerateTypeName(Node.SuperType());
		}
		this.CurrentBuilder.OpenIndent(" {");
		@Var int i = 0;
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.CurrentBuilder.AppendNewLine("var ", FieldNode.GetName());
			this.GenerateTypeAnnotation(FieldNode.DeclType());
			this.CurrentBuilder.AppendToken("=");
			this.GenerateCode(null, FieldNode.InitValueNode());
			this.CurrentBuilder.Append(this.SemiColon);
			i = i + 1;
		}
		this.CurrentBuilder.CloseIndent("}");
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		@Var String Message = ZLogger._LogError(Node.SourceToken, Node.ErrorMessage);
		this.CurrentBuilder.Append(this.ErrorFunc, "(");
		this.CurrentBuilder.Append(LibZen._QuoteString(Message));
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitAsmNode(ZAsmNode Node) {
		this.CurrentBuilder.AppendCode(Node.GetMacroText());
	}

	@Override public void VisitLocalDefinedNode(ZLocalDefinedNode Node) {
		if(Node instanceof ZParamNode) {
			this.VisitParamNode((ZParamNode)Node);
		}
		else {
			this.VisitUndefinedNode(Node);
		}
	}

	@Override public void VisitTopLevelNode(ZTopLevelNode Node) {
		this.VisitUndefinedNode(Node);
	}

	@Override public void VisitSugarNode(ZSugarNode Node) {
		@Var ZDesugarNode DesugarNode = Node.DeSugar(this, this.TypeChecker);
		this.GenerateCode(null, DesugarNode.AST[0]);
		@Var int i = 1;
		while(i < DesugarNode.GetAstSize()) {
			this.CurrentBuilder.Append(this.SemiColon);
			this.CurrentBuilder.AppendNewLine();
			this.GenerateCode(null, DesugarNode.AST[i]);
			i = i + 1;
		}
	}

	// Utils
	protected void GenerateTypeName(ZType Type) {
		this.CurrentBuilder.Append(this.GetNativeTypeName(Type.GetRealType()));
	}

	protected void VisitListNode(String OpenToken, ZListNode VargNode, String DelimToken, String CloseToken) {
		this.CurrentBuilder.Append(OpenToken);
		@Var int i = 0;
		while(i < VargNode.GetListSize()) {
			@Var ZNode ParamNode = VargNode.GetListAt(i);
			if (i > 0) {
				this.CurrentBuilder.Append(DelimToken);
			}
			this.GenerateCode(null, ParamNode);
			i = i + 1;
		}
		this.CurrentBuilder.Append(CloseToken);
	}

	protected void VisitListNode(String OpenToken, ZListNode VargNode, String CloseToken) {
		this.VisitListNode(OpenToken, VargNode, this.Camma, CloseToken);
	}

	protected void GenerateWrapperCall(String OpenToken, ZFunctionNode FuncNode, String CloseToken) {
		this.CurrentBuilder.Append(OpenToken);
		@Var int i = 0;
		while(i < FuncNode.GetListSize()) {
			@Var ZParamNode ParamNode = FuncNode.GetParamNode(i);
			if (i > 0) {
				this.CurrentBuilder.Append(this.Camma);
			}
			this.CurrentBuilder.Append(this.NameLocalVariable(ParamNode.GetName(), ParamNode.ParamIndex));
			i = i + 1;
		}
		this.CurrentBuilder.Append(CloseToken);
	}

	protected final String NameMethod(ZType ClassType, String MethodName) {
		return "_" + this.NameClass(ClassType) + "_" + MethodName;
	}

	protected final boolean IsMethod(String FuncName, ZFuncType FuncType) {
		@Var ZType RecvType = FuncType.GetRecvType();
		if(RecvType instanceof ZClassType && FuncName != null) {
			@Var ZClassType ClassType = (ZClassType)RecvType;
			@Var ZType FieldType = ClassType.GetFieldType(FuncName, null);
			if(FieldType == null || !FieldType.IsFuncType()) {
				FuncName = LibZen._AnotherName(FuncName);
				FieldType = ClassType.GetFieldType(FuncName, null);
				if(FieldType == null || !FieldType.IsFuncType()) {
					return false;
				}
			}
			if(FieldType instanceof ZFuncType) {
				if(((ZFuncType)FieldType).AcceptAsFieldFunc(FuncType)) {
					return true;
				}
			}
		}
		return false;
	}
}
