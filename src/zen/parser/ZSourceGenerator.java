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
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassNode;
import zen.ast.ZComparatorNode;
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
import zen.ast.ZSugarNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.deps.ZArray;
import zen.deps.ZenMap;
import zen.deps.ZenMethod;
import zen.lang.ZenTypeSafer;
import zen.type.ZClassType;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypePool;

public class ZSourceGenerator extends ZGenerator {

	@Field public ZenMap<String> NativeTypeMap = new ZenMap<String>(null);
	@Field public ZenMap<String> ReservedNameMap = new ZenMap<String>(null);

	@Field private final ZArray<ZSourceBuilder> BuilderList = new ZArray<ZSourceBuilder>(new ZSourceBuilder[4]);
	@Field protected ZSourceBuilder HeaderBuilder;
	@Field protected ZSourceBuilder CurrentBuilder;

	@Field public String Tab;
	@Field public String LineFeed;
	@Field public String LineComment;
	@Field public String BeginComment;
	@Field public String EndComment;
	@Field public String SemiColon;
	@Field public String Camma;

	@Field public String TrueLiteral;
	@Field public String FalseLiteral;
	@Field public String NullLiteral;

	@Field public String NotOperator;
	@Field public String AndOperator;
	@Field public String OrOperator;

	@Field public String TopType;

	public ZSourceGenerator(String TargetCode, String TargetVersion) {
		super(TargetCode, TargetVersion);
		this.InitBuilderList();
		this.LineFeed = "\n";
		this.Tab = "   ";
		this.LineComment = "//"; // if not, set null
		this.BeginComment = "/*";
		this.EndComment = "*/";
		this.Camma = ", ";
		this.SemiColon = ";";
		this.TrueLiteral = "true";
		this.FalseLiteral = "false";
		this.NullLiteral = "null";
		this.AndOperator = "&&";
		this.OrOperator = "||";
		this.NotOperator = "!";
		this.TopType = "var";
	}

	@ZenMethod protected void InitBuilderList() {
		this.CurrentBuilder = null;
		this.BuilderList.clear(0);
		this.HeaderBuilder = this.AppendNewSourceBuilder();
		this.CurrentBuilder = this.AppendNewSourceBuilder();
	}

	@Override public ZSourceEngine GetEngine() {
		LibZen._PrintLine("FIXME: Overide GetEngine in each generator!!");
		return new ZSourceEngine(new ZenTypeSafer(this), this);
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

	public final String SafeName(String Name, int Index) {
		if(Index == 0) {
			@Var String SafeName = this.ReservedNameMap.GetOrNull(Name);
			if(SafeName == null) {
				SafeName = Name;
			}
			return SafeName;
		}
		return Name + "__" + Index;
	}

	public final void SetMacro(String FuncName, String Macro, ZType ReturnType) {
		@Var ZFuncType FuncType = ZTypePool._LookupFuncType(ReturnType);
		this.SetDefinedFunc(new ZSourceMacro(FuncName, FuncType, Macro));
	}

	public final void SetMacro(String FuncName, String Macro, ZType ReturnType, ZType P1) {
		@Var ZFuncType FuncType = ZTypePool._LookupFuncType(ReturnType, P1);
		this.SetDefinedFunc(new ZSourceMacro(FuncName, FuncType, Macro));
	}

	public final void SetMacro(String FuncName, String Macro, ZType ReturnType, ZType P1, ZType P2) {
		@Var ZFuncType FuncType = ZTypePool._LookupFuncType(ReturnType, P1, P2);
		this.SetDefinedFunc(new ZSourceMacro(FuncName, FuncType, Macro));
	}

	public final void SetMacro(String FuncName, String Macro, ZType ReturnType, ZType P1, ZType P2, ZType P3) {
		@Var ZFuncType FuncType = ZTypePool._LookupFuncType(ReturnType, P1, P2, P3);
		this.SetDefinedFunc(new ZSourceMacro(FuncName, FuncType, Macro));
	}

	public final void SetConverterMacro(String Macro, ZType ReturnType, ZType P1) {
		@Var ZFuncType FuncType = ZTypePool._LookupFuncType(ReturnType, P1);
		this.SetConverterFunc(P1, ReturnType, new ZSourceMacro("to" + this.NameClass(ReturnType), FuncType, Macro));
	}

	@Override public final void WriteTo(@Nullable String FileName) {
		LibZen._WriteTo(this.NameOutputFile(FileName), this.BuilderList);
		this.InitBuilderList();
	}

	@Override public final String GetSourceText() {
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

	@Override public boolean StartCodeGeneration(ZNode Node, boolean IsInteractive) {
		Node.Accept(this);
		if(IsInteractive) {
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
		return true;
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


	@ZenMethod protected void GenerateCode(ZType ContextType, ZNode Node) {
		Node.Accept(this);
	}

	final protected boolean IsNeededSurroud(ZNode Node) {
		if(Node instanceof ZBinaryNode) {
			return true;
		}
		return false;
	}

	protected void GenerateSurroundCode(ZNode Node) {
		if(this.IsNeededSurroud(Node)) {
			this.CurrentBuilder.Append("(");
			this.GenerateCode(null, Node);
			this.CurrentBuilder.Append(")");
		}
		else {
			this.GenerateCode(null, Node);
		}
	}

	public void AppendCode(String RawSource) {
		this.CurrentBuilder.Append(RawSource);
	}

	public void VisitStmtList(ZBlockNode BlockNode) {
		@Var int i = 0;
		while (i < BlockNode.GetListSize()) {
			@Var ZNode SubNode = BlockNode.GetListAt(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.GenerateCode(null, SubNode);
			i = i + 1;
			if(i  < BlockNode.GetListSize()) {
				this.CurrentBuilder.Append(this.SemiColon);
			}
		}
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node);
		if(Node.GetListSize()>0) {
			this.CurrentBuilder.Append(this.SemiColon);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("}");
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
		this.CurrentBuilder.Append(String.valueOf(Node.IntValue));
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.CurrentBuilder.Append(String.valueOf(Node.FloatValue));
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.CurrentBuilder.Append(LibZen._QuoteString(Node.StringValue));
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.VisitListNode("[", Node, "]");
		// TODO Auto-generated method stub
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.CurrentBuilder.Append("new");
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateTypeName(Node.Type);
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.CurrentBuilder.Append("(");
		this.GenerateCode(null, Node.AST[ZGroupNode._Expr]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.GenerateCode(null, Node.AST[ZGetIndexNode._Recv]);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(null, Node.AST[ZGetIndexNode._Index]);
		this.CurrentBuilder.Append("]");
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.GenerateCode(null, Node.AST[ZSetIndexNode._Recv]);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(null, Node.AST[ZSetIndexNode._Index]);
		this.CurrentBuilder.Append("]");
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZSetIndexNode._Expr]);
	}

	@Override public void VisitGlobalNameNode(ZGlobalNameNode Node) {
		if(Node.IsUntyped()) {
			ZLogger._LogError(Node.SourceToken, "undefined symbol: " + Node.GlobalName);
		}
		if(Node.IsStaticFuncName) {
			this.CurrentBuilder.Append(Node.Type.StringfySignature(Node.GlobalName));
		}
		else {
			this.CurrentBuilder.Append(Node.GlobalName);
		}
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.Append(this.SafeName(Node.VarName, Node.VarIndex));
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append(this.SafeName(Node.VarName, Node.VarIndex));
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZSetNameNode._Expr]);
	}


	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.GenerateSurroundCode(Node.AST[ZGetterNode._Recv]);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.FieldName);
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		this.GenerateSurroundCode(Node.AST[ZSetterNode._Recv]);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.FieldName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZSetterNode._Expr]);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.GenerateSurroundCode(Node.AST[ZMethodCallNode._Recv]);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.MethodName);
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
			if(Node.HasAst(Index)) {
				this.GenerateCode(FuncType.GetFuncParamType(Index), Node.AST[Index]);
			}
			fromIndex = EndNum + 1;
			BeginNum = Macro.indexOf("$[", fromIndex);
		}
		this.CurrentBuilder.Append(Macro.substring(fromIndex));
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.GenerateCode(null, Node.AST[ZFuncCallNode._Func]);
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		this.GenerateCode(null, Node.AST[ZUnaryNode._Recv]);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		this.CurrentBuilder.Append(this.NotOperator);
		this.GenerateSurroundCode(Node.AST[ZUnaryNode._Recv]);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.CurrentBuilder.Append("(");
		this.GenerateTypeName(Node.Type);
		this.CurrentBuilder.Append(")");
		this.GenerateSurroundCode(Node.AST[ZCastNode._Expr]);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken("instanceof");
		this.GenerateTypeName(Node.AST[ZBinaryNode._Right].Type);
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append("(");
		}
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken(Node.SourceToken.GetText());
		this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append(")");
		}
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken(Node.SourceToken.GetText());
		this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken(this.AndOperator);
		this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken(this.OrOperator);
		this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		this.CurrentBuilder.Append("if (");
		this.GenerateCode(null, Node.AST[ZIfNode._Cond]);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(null, Node.AST[ZIfNode._Then]);
		if (Node.AST[ZIfNode._Else] != null) {
			this.CurrentBuilder.AppendToken("else");
			this.GenerateCode(null, Node.AST[ZIfNode._Else]);
		}
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.CurrentBuilder.Append("return");
		if (Node.AST[ZReturnNode._Expr] != null) {
			this.CurrentBuilder.AppendWhiteSpace();
			this.GenerateCode(null, Node.AST[ZReturnNode._Expr]);
		}
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.CurrentBuilder.Append("while (");
		this.GenerateCode(null, Node.AST[ZWhileNode._Cond]);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(null, Node.AST[ZWhileNode._Block]);
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.CurrentBuilder.Append("break");
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("throw");
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateCode(null, Node.AST[ZThrowNode._Expr]);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(null, Node.AST[ZTryNode._Try]);
		if(Node.AST[ZTryNode._Catch] != null) {
			this.GenerateCode(null, Node.AST[ZTryNode._Catch]);
		}
		if (Node.AST[ZTryNode._Finally] != null) {
			this.CurrentBuilder.Append("finally");
			this.GenerateCode(null, Node.AST[ZTryNode._Finally]);
		}
	}

	public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("catch (");
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.VisitTypeAnnotation(Node.ExceptionType);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(null, Node.AST[ZCatchNode._Block]);
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.Append("var");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(this.SafeName(Node.NativeName, Node.VarIndex));
		this.VisitTypeAnnotation(Node.DeclType);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node);
	}

	protected void VisitTypeAnnotation(ZType Type) {
		this.CurrentBuilder.Append(": ");
		this.GenerateTypeName(Type);
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		this.CurrentBuilder.Append("let");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.GlobalName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZLetNode._InitValue]);
	}

	public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(this.SafeName(Node.Name, Node.ParamIndex));
		this.VisitTypeAnnotation(Node.Type);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		this.CurrentBuilder.Append("function");
		this.CurrentBuilder.AppendWhiteSpace();
		if(Node.FuncName != null) {
			this.CurrentBuilder.Append(Node.FuncName);
		}
		this.VisitListNode("(", Node, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		this.CurrentBuilder.Append("class");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.ClassName);
		if(Node.SuperType != null) {
			this.CurrentBuilder.AppendToken("extends");
			this.GenerateTypeName(Node.SuperType);
		}
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Indent();
		@Var int i = 0;
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("var");
			this.CurrentBuilder.AppendWhiteSpace();
			this.CurrentBuilder.Append(FieldNode.FieldName);
			this.VisitTypeAnnotation(FieldNode.DeclType);
			if(FieldNode.HasAst(ZFieldNode._InitValue)) {
				this.CurrentBuilder.AppendToken("=");
				this.GenerateCode(null, FieldNode.AST[ZFieldNode._InitValue]);
			}
			this.CurrentBuilder.Append(this.SemiColon);
			i = i + 1;
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("}");
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		ZLogger._LogError(Node.SourceToken, Node.ErrorMessage);
		this.CurrentBuilder.Append("ThrowError(");
		this.CurrentBuilder.Append(LibZen._QuoteString(Node.ErrorMessage));
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitExtendedNode(ZNode Node) {
		if(Node instanceof ZParamNode) {
			this.VisitParamNode((ZParamNode)Node);
		}
		else {
			@Var ZSugarNode SugarNode = Node.DeSugar(this);
			this.VisitSugarNode(SugarNode);
		}
	}

	@Override public void VisitSugarNode(ZSugarNode Node) {
		this.GenerateCode(null, Node.AST[ZSugarNode._DeSugar]);
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
		this.VisitListNode(OpenToken, VargNode, ", ", CloseToken);
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
