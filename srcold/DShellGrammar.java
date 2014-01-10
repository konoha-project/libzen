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
package org.GreenTeaScript;
import grammar.KonohaGrammar;

import java.io.File;
import java.lang.reflect.Method;

import org.GreenTeaScript.DShell.DFault;
import org.GreenTeaScript.DShell.RecAPI;

import parser.GreenTeaUtils;
import parser.ZenFunc;
import parser.ZenNameSpace;
import parser.ZenParserContext;
import parser.ZenFuncSet;
import parser.ZenStaticTable;
import parser.ZenSyntaxPattern;
import parser.ZenSyntaxTree;
import parser.ZenToken;
import parser.ZenTokenContext;
import parser.ZenType;
import parser.ZenTypeEnv;
import parser.ast.ZenApplySymbolNode;
import parser.ast.ZenConstPoolNode;
import parser.ast.ZenNode;
import parser.deps.LibGreenTea;
import parser.deps.LibNative;
//endif VAJA

public class DShellGrammar extends GreenTeaUtils {
	// LibDShell
	public final static String GetEnv(String Key) {
		@Var String ret = "";
//ifdef JAVA
		ret = System.getenv(Key);
//endif VAJA
		return ret;
	}
//ifdef JAVA
	public final static boolean IsUnixCommand(String cmd) {
		String[] path = GetEnv("PATH").split(":");
		int i = 0;
		while(i < path.length) {
			if(LibGreenTea.HasFile(path[i] + "/" + cmd)) {
				return true;
			}
			i = i + 1;
		}
		return false;
	}

	public final static boolean IsFile(String Path) {
		return new File(Path).isFile();
	}

	public final static boolean IsDirectory(String Path) {
		return new File(Path).isDirectory();
	}

	public final static boolean IsFileExists(String Path) {
		return new File(Path).exists();
	}

	public final static boolean IsFileReadable(String Path) {
		return new File(Path).canRead();
	}

	public final static boolean IsFileWritable(String Path) {
		return new File(Path).canWrite();
	}

	public final static boolean IsFileExecutable(String Path) {
		return new File(Path).canExecute();
	}

	public final static String[] ExpandPath(String Path) {
		@Var int Index = Path.indexOf("*");
		@Var String NewPath = LibGreenTea.SubString(Path, 0, Index);
		@Var String[] ExpanddedPaths = new File(NewPath).list();
		if(ExpanddedPaths != null) {
			return ExpanddedPaths;
		}
		return new String[0];
	}
//endif VAJA
	@Field private static String ErrorMessage = "no error reported";

	public static void SetErrorMessage(String Message) {
		DShellGrammar.ErrorMessage = Message;
	}

	private static Object GetErrorMessage() {
		return DShellGrammar.ErrorMessage;
	}
//ifdef JAVA
	public final static DFault CreateFault(ZenNameSpace NameSpace, String DCaseNode, String FaultInfo, String ErrorInfo) {
		if(FaultInfo == null) {
			FaultInfo = NameSpace.GetSymbolText("AssumedFault");
		}
		DFault Fault = new DFault(NameSpace.GetSymbolText("Location"), FaultInfo, ErrorInfo);
		return Fault.UpdateDCaseReference(NameSpace.GetSymbolText("DCaseURL"), DCaseNode);
	}

	public final static DFault CreateExceptionFault(ZenNameSpace NameSpace, String DCaseNode, Exception e) {
		// TODO: Dispatch Fault by type of Exception e
		// default fault is set to UnexpectedFault
		return DShellGrammar.CreateFault(NameSpace, DCaseNode, "UnexpectedFault", e.toString());
	}

	public final static DFault ExecAction(ZenNameSpace NameSpace, String DCaseNode, ZenFunc Action) {
		DFault Fault = null;

		try {
			Fault = (DFault)((Method)Action.FuncBody).invoke(null);
		}
		catch (Exception e) {
			Fault = CreateExceptionFault(NameSpace, DCaseNode, e);
		}

		String RECServerURL = NameSpace.GetSymbolText("RECServerURL");
		String Location = NameSpace.GetSymbolText("Location");
		String Context = Action.FuncName;   // FIXME: change context format to json
		String AuthId = NameSpace.GetSymbolText("AuthId");

		if(AuthId == null) {
			// TODO: output warning
		}

		RecAPI.PushRawData(RECServerURL, DCaseNode, Location, Fault, AuthId, Context);

		return Fault;
	}
//endif VAJA

	// Grammar
	private static String CommandSymbol(String Symbol) {
		return "__$" + Symbol;
	}

	private static void AppendCommand(ZenNameSpace NameSpace, String CommandPath, ZenToken SourceToken) {
		if(CommandPath.length() > 0) {
			@Var int loc = CommandPath.lastIndexOf('/');
			@Var String Command = CommandPath;
			if(loc != -1) {
//ifdef JAVA
				if(!IsFileExecutable(CommandPath)) {
					NameSpace.Context.ReportError_OLD(GreenTeaConsts.ErrorLevel, SourceToken, "not executable: " + CommandPath);
				}
				else {
//endif VAJA
					Command = CommandPath.substring(loc+1);
					NameSpace.SetSymbol(Command, NameSpace.GetSyntaxPattern("$DShell2$"), SourceToken);
					NameSpace.SetSymbol(DShellGrammar.CommandSymbol(Command), CommandPath, null);
//ifdef JAVA
				}
//endif VAJA
			}
			else {
//ifdef JAVA
				if(IsUnixCommand(CommandPath)) {
//endif VAJA
					NameSpace.SetSymbol(Command, NameSpace.GetSyntaxPattern("$DShell2$"), SourceToken);
					NameSpace.SetSymbol(DShellGrammar.CommandSymbol(Command), CommandPath, null);
//ifdef JAVA
				}
				else {
					NameSpace.Context.ReportError_OLD(GreenTeaConsts.ErrorLevel, SourceToken, "unknown command: " + CommandPath);
				}
//endif VAJA
			}
		}
	}

	public static ZenSyntaxTree ParseCommand(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenSyntaxTree CommandTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "command");
		@Var String Command = "";
		@Var ZenToken SourceToken = null;
		while(TokenContext.HasNext()) {
			@Var ZenToken Token = TokenContext.Next();
			if(Token.EqualsText(",")) {
				Token.ParsedText = "";
			}
			if(Token.EqualsText("~")) {
				Token.ParsedText = DShellGrammar.GetEnv("HOME");
			}
			if(Token.IsDelim() || Token.IsIndent()) {
				break;
			}
			SourceToken = Token;
			Command += Token.ParsedText;
			if(Token.IsNextWhiteSpace()) {
				DShellGrammar.AppendCommand(NameSpace, Command, SourceToken);
				Command = "";
				if(SourceToken.IsError()) {
					CommandTree.ToError(SourceToken);
				}
			}
		}
		DShellGrammar.AppendCommand(NameSpace, Command, SourceToken);
		if(SourceToken.IsError()) {
			CommandTree.ToError(SourceToken);
		}
		return CommandTree;
	}

	public static long ShellCommentToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		if(LibGreenTea.CharAt(SourceText, pos) == '#') { // shell style SingleLineComment
			@Var long NextPos = pos + 1;
			while(NextPos < SourceText.length()) {
				@Var char NextChar = LibGreenTea.CharAt(SourceText, NextPos);
				if(NextChar == '\n') {
					break;
				}
				NextPos = NextPos + 1;
			}
			return KonohaGrammar.IndentToken(TokenContext, SourceText, NextPos);
		}
		return MismatchedPosition;
	}

	public static ZenSyntaxTree ParseEnv(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenSyntaxTree CommandTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "letenv");
		@Var ZenToken Token = TokenContext.Next();
		if(!LibGreenTea.IsVariableName(Token.ParsedText, 0)) {
			return TokenContext.ReportExpectedMessage(Token, "name", true);
		}
		@Var String Name = Token.ParsedText;
		@Var String Env  = DShellGrammar.GetEnv(Name);
		if(TokenContext.MatchToken("=")) {
			@Var ZenSyntaxTree ConstTree = TokenContext.ParsePattern_OLD(NameSpace, "$Expression$", Required);
			if(GreenTeaUtils.IsMismatchedOrError(ConstTree)) {
				return ConstTree;
			}
			if(Env == null) {
				@Var ZenTypeEnv Gamma = new ZenTypeEnv(NameSpace);
				@Var ZenNode ConstNode = ConstTree.TypeCheck(Gamma, ZenStaticTable.StringType, DefaultTypeCheckPolicy);
				Env = (/*cast*/String)ConstNode.ToConstValue(Gamma.Context, true);
			}
		}
		if(Env == null) {
			NameSpace.Context.ReportError_OLD(GreenTeaConsts.ErrorLevel, Token, "undefined environment variable: " + Name);
			CommandTree.ToError(Token);
		}
		else {
			NameSpace.SetSymbol(Name, Env, Token);
			CommandTree.ToConstTree(Env);
		}
		return CommandTree;
	}

	@Field private final static String FileOperators = "-d -e -f -r -w -x";
	@Field private final static String StopTokens = ";,)]}&&||";

	public static ZenSyntaxTree ParseFilePath(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenToken Token = TokenContext.GetToken();
		@Var boolean HasStringExpr = false;
		@Var String Path = null;
		if(Token.IsIndent() || DShellGrammar.StopTokens.indexOf(Token.ParsedText) != -1) {
			return null;
		}
		else if(Token.IsQuoted()) {
			Path = LibGreenTea.UnquoteString(Token.ParsedText);
			if(Path.indexOf("${") != -1) {
				HasStringExpr = true;
			}
			TokenContext.Next();
		}
		if(Path == null) {
			@Var boolean FoundOpen = false;
			Path = "";
			while(TokenContext.HasNext()) {
				Token = TokenContext.GetToken();
				@Var String ParsedText = Token.ParsedText;
				if(Token.IsIndent() || (!FoundOpen && DShellGrammar.StopTokens.indexOf(Token.ParsedText) != -1)) {
					break;
				}
				TokenContext.Next();
				if(Token.EqualsText("$")) {   // $HOME/hoge
					@Var ZenToken Token2 = TokenContext.GetToken();
					if(LibGreenTea.IsVariableName(Token2.ParsedText, 0)) {
						Path += "${" + Token2.ParsedText + "}";
						HasStringExpr = true;
						TokenContext.Next();
						if(Token2.IsNextWhiteSpace()) {
							break;
						}
						continue;
					}
				}
				if(Token.EqualsText("{")) {
					HasStringExpr = true;
					FoundOpen = true;
				}
				if(Token.EqualsText("}")) {
					FoundOpen = false;
				}
				if(Token.EqualsText("~")) {
					ParsedText = DShellGrammar.GetEnv("HOME");
				}
				Path += ParsedText;
				if(!FoundOpen && Token.IsNextWhiteSpace()) {
					break;
				}
			}
		}
		if(!HasStringExpr) {
			@Var ZenSyntaxTree PathTree = new ZenSyntaxTree(Pattern, NameSpace, Token, null);
			PathTree.ToConstTree(Path);
//			System.err.println("debug: " + Path + " ...");
			return PathTree;
		}
		else {
//			System.err.println("debug: " + Path);
			Path = "\"" + Path + "\"";
			Path = Path.replaceAll("\\$\\{", "\" + (");
			Path = Path.replaceAll("\\}", ") + \"");
//			System.err.println("debug: " + Path);
			@Var ZenTokenContext LocalContext = new ZenTokenContext(NameSpace, Path, Token.FileLine);
			return LocalContext.ParsePattern_OLD(NameSpace, "$Expression$", Required);
		}
	}

	public static ZenSyntaxTree ParseFileOperator(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenToken Token = TokenContext.Next();   // "-"
		@Var ZenToken Token2 = TokenContext.Next();  // "f"
		if(!Token.IsNextWhiteSpace()) {
			if(DShellGrammar.FileOperators.indexOf(Token2.ParsedText) != -1) {
				Token.ParsedText += Token2.ParsedText;  // join to "-f";
				@Var ZenSyntaxTree Tree = new ZenSyntaxTree(Pattern, NameSpace, Token, null);
				Tree.SetMatchedPatternAt(UnaryTerm, NameSpace, TokenContext, "$FilePath$", Required);
				return Tree;
			}
		}
		return null;
	}

	public static ZenNode TypeFileOperator(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
		@Var ZenNode PathNode = ParsedTree.TypeCheckAt(UnaryTerm, Gamma, ZenStaticTable.StringType, DefaultTypeCheckPolicy);
		if(!PathNode.IsErrorNode()) {
			@Var String OperatorSymbol = ZenNameSpace.FuncSymbol(ParsedTree.KeyToken.ParsedText);
			@Var ZenFuncSet FuncSet = Gamma.NameSpace.GetMethod(ZenStaticTable.StringType, OperatorSymbol, true);
			@Var ZenFunc ResolvedFunc = FuncSet.ResolveUnaryMethod(Gamma, PathNode.Type);
			LibNative.Assert(ResolvedFunc != null);
			@Var ZenNode ApplyNode =  Gamma.Generator.CreateApplySymbolNode(ResolvedFunc.GetReturnType(), ParsedTree, OperatorSymbol, ResolvedFunc);
			ApplyNode.Append(Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.VarType, ParsedTree, ResolvedFunc));
			ApplyNode.Append(PathNode);
			return ApplyNode;
		}
		return PathNode;
	}

	private static void IncreasePos(ZenTokenContext TokenContext, int time, boolean allowIncrement) {
		if(allowIncrement) {
			for(@Var int i = 0; i < time; i++) {
				TokenContext.Next();
			}
		}
	}

	// >, >>, >&, 1>, 2>, 1>>, 2>>, &>, &>>, 1>&1, 1>&2, 2>&1, 2>&2, >&1, >&2
	private static String FindRedirectSymbol(ZenTokenContext TokenContext, boolean allowIncrement) {
		@Var ZenToken Token = TokenContext.GetToken();
		@Var int CurrentPos = TokenContext.GetPosition(0);
		@Var int NextLen = 0;
		@Var String RedirectSymbol = Token.ParsedText;
		if(Token.EqualsText(">>")) {
			DShellGrammar.IncreasePos(TokenContext, 1, allowIncrement);
			return RedirectSymbol;
		}
		else if(Token.EqualsText(">")) {
			NextLen = 2;
		}
		else if(Token.EqualsText("1") || Token.EqualsText("2") || Token.EqualsText("&")) {
			NextLen = 3;
		}
		
		@Var ZenToken[] NextTokens = new ZenToken[NextLen];
		for(@Var int i = 0; i < NextLen; i++) {
			TokenContext.Next();
			NextTokens[i] = TokenContext.GetToken();
		}
		TokenContext.RollbackPosition(CurrentPos, 0);

		if(NextLen == 2) {
			if(!Token.IsNextWhiteSpace() && NextTokens[0].EqualsText("&")) {
				RedirectSymbol += NextTokens[0].ParsedText;
				if(!NextTokens[0].IsNextWhiteSpace()) {
					if(NextTokens[1].EqualsText("1") || NextTokens[1].EqualsText("2")) {
						RedirectSymbol += NextTokens[1].ParsedText;
						DShellGrammar.IncreasePos(TokenContext, 3, allowIncrement);
						return RedirectSymbol;
					}
				}
				DShellGrammar.IncreasePos(TokenContext, 2, allowIncrement);
				return RedirectSymbol;
			}
			DShellGrammar.IncreasePos(TokenContext, 1, allowIncrement);
			return RedirectSymbol;
		}
		else if(NextLen == 3) {
			if(!Token.IsNextWhiteSpace() && (NextTokens[0].EqualsText(">") || NextTokens[0].EqualsText(">>"))) {
				RedirectSymbol += NextTokens[0].ParsedText;
				if(!NextTokens[0].IsNextWhiteSpace() &&
						(LibGreenTea.EqualsString(RedirectSymbol, "1>") || LibGreenTea.EqualsString(RedirectSymbol, "2>"))) {
					if(NextTokens[1].EqualsText("&") && !NextTokens[1].IsNextWhiteSpace()) {
						if(NextTokens[2].EqualsText("1") || NextTokens[2].EqualsText("2")) {
							RedirectSymbol += NextTokens[1].ParsedText + NextTokens[2].ParsedText;
							DShellGrammar.IncreasePos(TokenContext, 4, allowIncrement);
							return RedirectSymbol;
						}
					}
				}
				DShellGrammar.IncreasePos(TokenContext, 2, allowIncrement);
				return RedirectSymbol;
			}
		}
		return null;
	}

	public static ZenSyntaxTree ParseDShell2(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenSyntaxTree CommandTree = TokenContext.CreateSyntaxTree(NameSpace, Pattern, null);
		@Var ZenToken CommandToken = TokenContext.GetToken();
		@Var String RedirectSymbol = DShellGrammar.FindRedirectSymbol(TokenContext, true);
		if(RedirectSymbol != null) {
			CommandTree.AppendParsedTree2(CommandTree.CreateConstTree(RedirectSymbol));
		}
		else {
			@Var String Command = (/*cast*/String)NameSpace.GetSymbol(DShellGrammar.CommandSymbol(CommandToken.ParsedText));
			if(Command != null) {
				CommandTree.AppendParsedTree2(CommandTree.CreateConstTree(Command));
				TokenContext.Next();
			}
			else {
				CommandTree.AppendMatchedPattern(NameSpace, TokenContext, "$FilePath$", Required);
			}
		}
		TokenContext.SetBackTrack(false);
		while(TokenContext.HasNext() && CommandTree.IsValidSyntax()) {
			@Var ZenToken Token = TokenContext.GetToken();
			if(Token.IsIndent() || DShellGrammar.StopTokens.indexOf(Token.ParsedText) != -1) {
				if(!Token.EqualsText("|") && !Token.EqualsText("&")) {
					break;
				}
			}
			if(Token.EqualsText("||") || Token.EqualsText("&&")) {
				@Var ZenSyntaxPattern ExtendedPattern = TokenContext.GetExtendedPattern(NameSpace);
				return GreenTeaUtils.ApplySyntaxPattern_OLD(NameSpace, TokenContext, CommandTree, ExtendedPattern);
			}
			if(Token.EqualsText("|")) {
				TokenContext.Next();
				@Var ZenSyntaxTree PipedTree = TokenContext.ParsePattern_OLD(NameSpace, "$DShell2$", Required);
				if(PipedTree.IsError()) {
					return PipedTree;
				}
				CommandTree.AppendParsedTree2(PipedTree);
				return CommandTree;
			}
			if(Token.EqualsText("&")) {	// set background job
				@Var ZenSyntaxTree OptionTree = TokenContext.CreateSyntaxTree(NameSpace, Pattern, null);
				OptionTree.AppendParsedTree2(OptionTree.CreateConstTree(Token.ParsedText));
				CommandTree.AppendParsedTree2(OptionTree);
				TokenContext.Next();
				return CommandTree;
			}
			if(DShellGrammar.FindRedirectSymbol(TokenContext, false) != null) {
				@Var ZenSyntaxTree RedirectTree = TokenContext.ParsePattern_OLD(NameSpace, "$DShell2$", Required);
				if(RedirectTree.IsError()) {
					return RedirectTree;
				}
				CommandTree.AppendParsedTree2(RedirectTree);
				return CommandTree;
			}
			CommandTree.AppendMatchedPattern(NameSpace, TokenContext, "$FilePath$", Required);
		}
		return CommandTree;
	}

	public static ZenNode TypeDShell2(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
		@Var ZenType Type = null;
		if(ContextType.IsStringType() || ContextType.IsBooleanType()) {
			Type = ContextType;
		}
		else if(ContextType.IsVoidType()) {
			Type = ZenStaticTable.VoidType;
		}
		else {
			Type = ParsedTree.NameSpace.GetType("Task");
			LibNative.Assert(Type != null);
		}
		@Var ZenNode PipedNode = null;
		@Var int Index = 0;
		@Var int ArgumentSize = LibZen.ListSize(ParsedTree.SubTreeList);
		while(Index < ArgumentSize) {
			@Var ZenSyntaxTree SubTree = ParsedTree.SubTreeList.get(Index);
			if(SubTree.Pattern.EqualsName("$DShell2$")) {
				PipedNode = DShellGrammar.TypeDShell2(Gamma, SubTree, ContextType);
				ArgumentSize = Index;
				break;
			}
			Index += 1;
		}
		@Var ZenNode Node = Gamma.Generator.CreateCommandNode(Type, ParsedTree, PipedNode);
		Index = 0;
		while(Index < ArgumentSize) {
			@Var ZenNode ArgumentNode = ParsedTree.TypeCheckAt(Index, Gamma, ZenStaticTable.StringType, DefaultTypeCheckPolicy);
			if(ArgumentNode.IsErrorNode()) {
				return ArgumentNode;
			}
			Node.Append(ArgumentNode);
			Index += 1;
		}
		return Node;
	}

	@Field private final static int AtomicTarget   = 0;
	@Field private final static int AtomicBody     = 1;
	@Field private final static int AtomicExcept   = 2;
	@Field private final static int AtomicRollback = 3;
	@Field private final static int AtomicClear    = 4;
	@Field private static int checkpointCount = -1;

	public static ZenSyntaxTree ParseAtomic(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenSyntaxTree AtomicTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "atomic");
		@Var ZenSyntaxTree TargetTree = TokenContext.ParsePattern_OLD(NameSpace, "$FilePath$", Required);

		@Var String TargetPath = LibGreenTea.QuoteString((/*cast*/String)TargetTree.ParsedValue);
		DShellGrammar.checkpointCount += 1;
		@Var String CheckPointName = "___def_check_point__" + DShellGrammar.checkpointCount;

		@Var String NewCheckPoint = "var " + CheckPointName + " = new CheckPoint(" + TargetPath + ");";
		@Var ZenTokenContext CheckPointContext = new ZenTokenContext(NameSpace, NewCheckPoint, TokenContext.ParsingLine);
		AtomicTree.SetMatchedPatternAt(DShellGrammar.AtomicTarget, NameSpace, CheckPointContext, "$VarDecl$", Required);

		TokenContext.SkipEmptyStatement();
		AtomicTree.SetMatchedPatternAt(DShellGrammar.AtomicBody, NameSpace, TokenContext, "$Block$", Required);

		@Var String NewExcept = "DShellException e";
		@Var ZenTokenContext ExceptContext = new ZenTokenContext(NameSpace, NewExcept, TokenContext.ParsingLine);
		AtomicTree.SetMatchedPatternAt(DShellGrammar.AtomicExcept , NameSpace, ExceptContext, "$VarDecl$", Required);

		@Var String NewRollback = "{ " + CheckPointName + ".rollback(); }";
		@Var ZenTokenContext RollbackContext = new ZenTokenContext(NameSpace, NewRollback, TokenContext.ParsingLine);
		AtomicTree.SetMatchedPatternAt(DShellGrammar.AtomicRollback, NameSpace, RollbackContext, "$Block$", Required);

		@Var String NewClear = "{ " + CheckPointName + ".clear(); }";
		@Var ZenTokenContext ClearContext = new ZenTokenContext(NameSpace, NewClear, TokenContext.ParsingLine);
		AtomicTree.SetMatchedPatternAt(DShellGrammar.AtomicClear, NameSpace, ClearContext, "$Block$", Required);
		return AtomicTree;
	}

	public static ZenNode TypeAtomic(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
		@Var ZenNameSpace NameSpace = Gamma.NameSpace;
		@Var ZenSyntaxPattern TryPattern = NameSpace.GetSyntaxPattern("try");
		@Var ZenSyntaxTree TryTree = new ZenSyntaxTree(TryPattern, NameSpace, new ZenToken("try", ParsedTree.KeyToken.FileLine), null);
		TryTree.SetSyntaxTreeAt(TryBody, ParsedTree.GetSyntaxTreeAt(DShellGrammar.AtomicBody));
		TryTree.SetSyntaxTreeAt(CatchVariable, ParsedTree.GetSyntaxTreeAt(DShellGrammar.AtomicExcept));
		TryTree.SetSyntaxTreeAt(CatchBody, ParsedTree.GetSyntaxTreeAt(DShellGrammar.AtomicRollback));
		TryTree.SetSyntaxTreeAt(FinallyBody, ParsedTree.GetSyntaxTreeAt(DShellGrammar.AtomicClear));
		@Var ZenSyntaxTree TargetDeclTree = ParsedTree.GetSyntaxTreeAt(DShellGrammar.AtomicTarget);
		TargetDeclTree.ParentTree = ParsedTree.ParentTree;
		TargetDeclTree.PrevTree = ParsedTree.PrevTree;
		TargetDeclTree.NextTree = TryTree;
		TryTree.NextTree = ParsedTree.NextTree;
		ParsedTree = TargetDeclTree;
		return KonohaGrammar.TypeVarDecl(Gamma, ParsedTree, ContextType);
	}

	public static ZenSyntaxTree ParseShell(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		TokenContext.Next();
		return TokenContext.ParsePattern_OLD(NameSpace, "$DShell2$", Required);
	}

	// dlog $Expr
	private static ZenNode CreateDCaseNode(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree) {
		@Var String ContextualFuncName = "Admin";
		if(Gamma.FuncBlock.DefinedFunc != null) {
			ContextualFuncName = Gamma.FuncBlock.DefinedFunc.FuncName;
		}
		return Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.StringType, ParsedTree, ContextualFuncName);
	}

	public static ZenSyntaxTree ParseDLog(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "dlog");
		Tree.SetMatchedPatternAt(UnaryTerm, NameSpace, TokenContext, "$Expression$", Required);
		return Tree;
	}

	// dlog FunctionName => ExecAction(NameSpace, ContextualFuncName, Action);
	public static ZenNode TypeDLog(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
		ContextType = LibNative.GetNativeType(DFault.class);
		@Var ZenNode ActionNode = ParsedTree.TypeCheckAt(UnaryTerm, Gamma, ContextType, DefaultTypeCheckPolicy);
		if(ActionNode.IsErrorNode()) {
			return ActionNode;
		}
		if(ActionNode instanceof ZenApplySymbolNode) {
			if(Gamma.NameSpace.GetSymbol("RECServerURL") == null) {
				return Gamma.CreateSyntaxErrorNode(ParsedTree, "constant variable 'RECServerURL' is not defined");
			}
			if(Gamma.NameSpace.GetSymbol("Location") == null) {
				return Gamma.CreateSyntaxErrorNode(ParsedTree, "constant variable 'Location' is not defined");
			}

			@Var ZenFunc ActionFunc = ((/*cast*/ZenApplySymbolNode)ActionNode).ResolvedFunc;
			if(ActionFunc.GetFuncParamSize() == 0) {
				@Var ZenFunc ReportFunc = (/*cast*/ZenFunc)Gamma.NameSpace.GetSymbol("$ReportBuiltInFunc");
				@Var ZenNode ApplyNode = Gamma.Generator.CreateApplySymbolNode(ContextType, ParsedTree, "$ReportBuiltInFunc", ReportFunc);
				ApplyNode.Append(Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.VarType, ParsedTree, ReportFunc));
				ApplyNode.Append(Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.VarType, ParsedTree, Gamma.NameSpace));
				ApplyNode.Append(DShellGrammar.CreateDCaseNode(Gamma, ParsedTree));
				ApplyNode.Append(Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.VarType, ParsedTree, ActionFunc));
				return ApplyNode;
			}
		}
		return Gamma.CreateSyntaxErrorNode(ParsedTree, "action must be Func<DFault, void>");
	}
	
	// Raise Expression
	@Field public final static int ErrorTerm = 0;
	@Field public final static int FaultTerm = 1;
	
	public static ZenSyntaxTree ParseFault(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenSyntaxTree FaultTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "fault");
		if(TokenContext.MatchToken("(")) {
			FaultTree.SetMatchedPatternAt(DShellGrammar.ErrorTerm, NameSpace, TokenContext, "$Expression$", Required);
			if(TokenContext.MatchToken(",")) {
				FaultTree.SetMatchedPatternAt(DShellGrammar.FaultTerm, NameSpace, TokenContext, "$Variable$", Required);
			}
			FaultTree.SetMatchedTokenAt(NoWhere, NameSpace, TokenContext, ")", Required);
		}
		return FaultTree;
	}

	public static ZenNode TypeFault(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
		@Var ZenFunc CreateFunc = (/*cast*/ZenFunc)Gamma.NameSpace.GetSymbol("$CreateFaultBuiltInFunc");
		@Var ZenNode ApplyNode = Gamma.Generator.CreateApplySymbolNode(ContextType, ParsedTree, "$CreateFaultBuiltInFunc", CreateFunc);
		ApplyNode.Append(Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.VarType, ParsedTree, CreateFunc));
		ApplyNode.Append(Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.VarType, ParsedTree, Gamma.NameSpace));
		ApplyNode.Append(DShellGrammar.CreateDCaseNode(Gamma, ParsedTree));
		@Var String FaultInfo;
		if(ParsedTree.HasNodeAt(DShellGrammar.FaultTerm)) {
			FaultInfo = ParsedTree.GetSyntaxTreeAt(DShellGrammar.FaultTerm).KeyToken.ParsedText;
		}
		else {
			FaultInfo = Gamma.NameSpace.GetSymbolText("AssumedFault");
			if(FaultInfo == null) {
				FaultInfo = "UnexpectedFault";
			}
		}
		ApplyNode.Append(Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.VarType, ParsedTree, FaultInfo));
		@Var ZenNode ErrorInfoNode = null;
		if(ParsedTree.HasNodeAt(DShellGrammar.ErrorTerm)) {
			ErrorInfoNode = ParsedTree.TypeCheckAt(DShellGrammar.ErrorTerm, Gamma, ZenStaticTable.StringType, DefaultTypeCheckPolicy);
		}
		else {
			ErrorInfoNode = Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.VarType, ParsedTree, DShellGrammar.GetErrorMessage());
		}
		ApplyNode.Append(ErrorInfoNode);
		return ApplyNode;
	}

	private static final ZenNode CreateConstNode(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, Object ConstValue) {
		return Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.GuessType(ConstValue), ParsedTree, ConstValue);
	}

	// dexec CallAdmin() 
	// D-exec Expression
	// dexec FunctionName
	public static ZenSyntaxTree ParseDexec(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "dexec");
		Tree.SetMatchedPatternAt(UnaryTerm, NameSpace, TokenContext, "$Variable$", Required);
		return Tree;
	}

	// dexec FunctionName
	// => ReportAction(FunctionName(), "FunctionName", CurrentFuncName, DCaseRevision)
	public static ZenNode TypeDexec(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
		@Var Object ConstValue = ParsedTree.NameSpace.GetSymbol("DCaseRevision");
		if(ConstValue == null) {
			return Gamma.CreateSyntaxErrorNode(ParsedTree, "constant variable DCaseRevision is not defined in this context");
		}
		@Var ZenType DFaultType = (/*cast*/ZenType) ParsedTree.NameSpace.GetSymbol("DFault");
		if(DFaultType == null) {
			return Gamma.CreateSyntaxErrorNode(ParsedTree, "DFault type is not defined in this context");
		}

		@Var ZenNode ApplyNode = KonohaGrammar.TypeApply(Gamma, ParsedTree, DFaultType);
		if(ApplyNode.IsErrorNode()) {
			return ApplyNode;
		}

		// create UpdateFaultInfomation(FunctionName(), "FunctionName", CurrentFuncName, DCaseRevision);
		@Var ZenNode Revision = DShellGrammar.CreateConstNode(Gamma, ParsedTree, ConstValue);
		@Var String FunctionName = ParsedTree.GetSyntaxTreeAt(UnaryTerm).KeyToken.ParsedText;
		@Var String CurrentFuncName = Gamma.FuncBlock.DefinedFunc.GetNativeFuncName();

		@Var ZenNode FuncNameNode = DShellGrammar.CreateConstNode(Gamma, ParsedTree, FunctionName);
		@Var ZenNode CurFuncNameNode = DShellGrammar.CreateConstNode(Gamma, ParsedTree, CurrentFuncName);
		
		ConstValue = ParsedTree.NameSpace.GetSymbol("Location");
		if(ConstValue == null || !(ConstValue instanceof String)) {
			return Gamma.CreateSyntaxErrorNode(ParsedTree, "Location is not defined in this context");
		}
		@Var ZenNode LocationNode = DShellGrammar.CreateConstNode(Gamma, ParsedTree, ConstValue);
		ConstValue = ParsedTree.NameSpace.GetSymbol("RecServer");
		if(ConstValue == null || !(ConstValue instanceof String)) {
			return Gamma.CreateSyntaxErrorNode(ParsedTree, "RecServer is not defined in this context");
		}
		@Var ZenNode RecServerNode = DShellGrammar.CreateConstNode(Gamma, ParsedTree, ConstValue);
		ConstValue = ParsedTree.NameSpace.GetSymbol("ReportAction");
		if(!(ConstValue instanceof ZenFunc)) {
			return Gamma.CreateSyntaxErrorNode(ParsedTree, "ReportAction is not defined in this context");
		}
		@Var ZenFunc Func = (/*cast*/ZenFunc) ConstValue;
		@Var ZenNode ApplyNode2 = Gamma.Generator.CreateApplySymbolNode(Func.GetReturnType(), ParsedTree, "ReportAction", Func);
		ApplyNode2.Append(DShellGrammar.CreateConstNode(Gamma, ParsedTree, Func));
		ApplyNode2.Append(ApplyNode);
		ApplyNode2.Append(FuncNameNode);
		ApplyNode2.Append(CurFuncNameNode);
		ApplyNode2.Append(Revision);
		ApplyNode2.Append(LocationNode);
		ApplyNode2.Append(RecServerNode);
		return ApplyNode2;
	}

	// Raise Expression
	public static ZenSyntaxTree ParseRaise(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenSyntaxTree ReturnTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "raise");
		ReturnTree.SetMatchedPatternAt(UnaryTerm, NameSpace, TokenContext, "$Type$", Required);
		return ReturnTree;
	}

	public static ZenNode TypeRaise(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
		if(Gamma.IsTopLevel() || Gamma.FuncBlock.DefinedFunc == null) {
			return Gamma.UnsupportedTopLevelError(ParsedTree);
		}
		@Var ZenNode Expr = ParsedTree.TypeCheckAt(UnaryTerm, Gamma, ZenStaticTable.TypeType, DefaultTypeCheckPolicy);
		if(Expr.IsConstNode() && Expr.Type.IsTypeType()) {
			@Var ZenType ObjectType = (/*cast*/ZenType)((/*cast*/ZenConstPoolNode)Expr).ConstValue;
			Expr = Gamma.Generator.CreateAllocateNode(ObjectType, ParsedTree);
			//Expr = KonohaGrammar.TypeApply(Gamma, ParsedTree, ObjectType);
		}
		return Gamma.Generator.CreateReturnNode(Expr.Type, ParsedTree, Expr);
	}

	public static DFault UpdateFaultInfomation(DFault Fault, String CalledFuncName, String CurrentFuncName, long DCaseRevision, String Location, String RecServer) {
		if(Fault == null) {
			return null;
		}
//		Fault.UpdateFaultInfomation(CalledFuncName, CurrentFuncName, DCaseRevision);
		return Fault;
	}

//ifdef JAVA
	// this is a new interface used in ImportNativeObject
	public static void ImportGrammar(ZenNameSpace NameSpace, Class<?> GrammarClass) {
		@Var ZenParserContext ParserContext = NameSpace.Context;
		NameSpace.AppendTokenFunc("#", LoadTokenFunc(GrammarClass, "ShellCommentToken")); 
		
		NameSpace.AppendSyntax_OLD("letenv", LoadParseFunc2(GrammarClass, "ParseEnv"), null);
		NameSpace.AppendSyntax_OLD("command", LoadParseFunc2(GrammarClass, "ParseCommand"), null);
		NameSpace.AppendSyntax_OLD("-", LoadParseFunc2(GrammarClass, "ParseFileOperator"), LoadTypeFunc2(GrammarClass, "TypeFileOperator"));
		NameSpace.AppendSyntax_OLD("$FilePath$", LoadParseFunc2(GrammarClass, "ParseFilePath"), null);
		NameSpace.AppendSyntax_OLD("$DShell2$", LoadParseFunc2(GrammarClass, "ParseDShell2"), LoadTypeFunc2(GrammarClass, "TypeDShell2"));
		NameSpace.AppendSyntax_OLD("shell", LoadParseFunc2(GrammarClass, "ParseShell"), null);
		NameSpace.AppendSyntax_OLD("atomic", LoadParseFunc2(GrammarClass, "ParseAtomic"), LoadTypeFunc2(GrammarClass, "TypeAtomic"));
		
		// builtin command
		// timeout
		@Var String timeout = "timeout";
		NameSpace.SetSymbol(timeout, NameSpace.GetSyntaxPattern("$DShell2$"), new ZenToken(timeout, 0));
		NameSpace.SetSymbol(DShellGrammar.CommandSymbol(timeout), timeout, null);
		// infer
		@Var String trace = "trace";
		NameSpace.SetSymbol(trace, NameSpace.GetSyntaxPattern("$DShell2$"), new ZenToken(trace, 0));
		NameSpace.SetSymbol(DShellGrammar.CommandSymbol(trace), trace, null);

		NameSpace.SetSymbol("$CreateFaultBuiltInFunc", LibNative.ImportNativeObject(NameSpace, "DShellGrammar.CreateFault"), null);
		NameSpace.SetSymbol("$ReportBuiltInFunc", LibNative.ImportNativeObject(NameSpace, "DShellGrammar.ExecAction"), null);
		NameSpace.AppendSyntax_OLD("dlog", LoadParseFunc2(GrammarClass, "ParseDLog"), LoadTypeFunc2(GrammarClass, "TypeDLog"));
		NameSpace.AppendSyntax_OLD("fault", LoadParseFunc2(GrammarClass, "ParseFault"), LoadTypeFunc2(GrammarClass, "TypeFault"));
		
		NameSpace.AppendSyntax_OLD("raise", LoadParseFunc2(GrammarClass, "ParseRaise"), LoadTypeFunc2(GrammarClass, "TypeRaise"));
		NameSpace.AppendSyntax_OLD("dexec", LoadParseFunc2(GrammarClass, "ParseDexec"), LoadTypeFunc2(GrammarClass, "TypeDexec"));

	}
//endif VAJA
}
