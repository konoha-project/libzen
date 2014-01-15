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
package zen.lang;
import zen.parser.ZenNameSpace;

//endif VAJA

public class ZenClassGrammar {
//	public static ZenNode MatchConst(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
//		@Var ZenToken Token = TokenContext.Next();
//		@Var Object ConstValue = NameSpace.GetSymbol(Token.ParsedText);
//		if(ConstValue != null) {
//			return NameSpace.Generator.CreateConstNode(Token, ConstValue);
//		}
//		return null; // Not Matched
//	}
	
//	public static ZenSyntaxTree ParseError(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return new ZenSyntaxTree(Pattern, NameSpace, TokenContext.GetToken(), null);
//	}
//
//	public static ZenNode TypeError(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType Type) {
//		return Gamma.Generator.CreateErrorNode(ZenSystem.VoidType, ParsedTree);
//	}
//
//	public static ZenSyntaxTree ParseEmpty(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return new ZenSyntaxTree(Pattern, NameSpace, TokenContext.GetBeforeToken(), null);
//	}
//
//	public static ZenNode TypeEmpty(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType Type) {
//		return Gamma.Generator.CreateEmptyNode(ZenSystem.VoidType);
//	}
//
//	public static ZenSyntaxTree ParseSemiColon(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		if(TokenContext.IsAllowedBackTrack()) {
//			return null;
//		}
//		else {
//			return TokenContext.ReportTokenError2(TokenContext.GetToken(), "unexpected ;", false);
//		}
//	}
//
//	public static ZenSyntaxTree ParseRequire(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		TokenContext.Next(); // skipped first token "require";
//		while(TokenContext.HasNext()) {
//			@Var ZenToken Token = TokenContext.Next();
//			if(Token.IsIndent() || Token.IsDelim()) {
//				break;
//			}
//			if(Token.IsNameSymbol()) {
//				if(!NameSpace.LoadRequiredLib(Token.ParsedText)) {
//					return TokenContext.NewErrorSyntaxTree(Token, "failed to load required library: " + Token.ParsedText);
//				}
//			}
//			if(TokenContext.MatchToken(",")) {
//				continue;
//			}
//		}
//		return KonohaGrammar.ParseEmpty(NameSpace, TokenContext, LeftNode, Pattern);
//	}
//
//	private static String ParseJoinedName(ZenTokenContext TokenContext) {
//		@Var ZenToken Token = TokenContext.Next();
//		@Var String PackageName = LibZen.UnquoteString(Token.ParsedText);
//		while(TokenContext.HasNext()) {
//			Token = TokenContext.Next();
//			if(Token.IsNameSymbol() || LibZen.EqualsString(Token.ParsedText, ".")) {
//				PackageName += Token.ParsedText;
//				continue;
//			}
//			break;
//		}
//		return PackageName;
//	}
//
//	public static ZenSyntaxTree ParseImport(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree ImportTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "import");
//		@Var String PackageName = KonohaGrammar.ParseJoinedName(TokenContext);
//		ImportTree.ParsedValue = PackageName;
//		return ImportTree;
//	}
//
//	public static ZenNode TypeImport(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType Type) {
//		@Var Object Value = LibNative.ImportNativeObject(Gamma.NameSpace, (/*cast*/String)ParsedTree.ParsedValue);
//		if(Value == null) {
//			return Gamma.CreateSyntaxErrorNode(ParsedTree, "cannot import: " + ParsedTree.ParsedValue);
//		}
//		return Gamma.Generator.CreateConstNode_OLD(ZenSystem.GuessType(Value), ParsedTree, Value);
//	}


//	// While Statement
//	public static ZenSyntaxTree ParseWhile(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree WhileTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "while");
//		WhileTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "(", ZenConsts.Required | ZenConsts.OpenSkipIndent);
//		WhileTree.SetMatchedPatternAt(ZenConsts.WhileCond, NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//		WhileTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ")", ZenConsts.Required | ZenConsts.CloseSkipIndent);
//		WhileTree.SetMatchedPatternAt(ZenConsts.WhileBody, NameSpace, TokenContext, "$StmtBlock$", ZenConsts.Required);
//		return WhileTree;
//	}
//
//	public static ZenNode TypeWhile(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenNode CondNode = ParsedTree.TypeCheckAt(ZenConsts.WhileCond, Gamma, ZenSystem.BooleanType, ZenConsts.DefaultTypeCheckPolicy);
//		@Var ZenNode BodyNode =  ParsedTree.TypeCheckAt(ZenConsts.WhileBody, Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//		return Gamma.Generator.CreateWhileNode(BodyNode.Type, ParsedTree, CondNode, BodyNode);
//	}
//
//	// DoWhile Statement
//	public static ZenSyntaxTree ParseDoWhile(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "do");
//		Tree.SetMatchedPatternAt(ZenConsts.WhileBody, NameSpace, TokenContext, "$StmtBlock$", ZenConsts.Required);
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "while", ZenConsts.Required);
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "(", ZenConsts.Required | ZenConsts.OpenSkipIndent);
//		Tree.SetMatchedPatternAt(ZenConsts.WhileCond, NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ")", ZenConsts.Required | ZenConsts.CloseSkipIndent);
//		return Tree;
//	}
//
//	public static ZenNode TypeDoWhile(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenNode CondNode = ParsedTree.TypeCheckAt(ZenConsts.WhileCond, Gamma, ZenSystem.BooleanType, ZenConsts.DefaultTypeCheckPolicy);
//		@Var ZenNode BodyNode =  ParsedTree.TypeCheckAt(ZenConsts.WhileBody, Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//		return Gamma.Generator.CreateDoWhileNode(BodyNode.Type, ParsedTree, CondNode, BodyNode);
//	}
//
//	// For Statement
//	public static ZenSyntaxTree ParseFor(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "for");
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "(", ZenConsts.Required | ZenConsts.OpenSkipIndent);
//		Tree.SetMatchedPatternAt(ZenConsts.ForInit, NameSpace, TokenContext, "$Expression$", ZenConsts.Optional);
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ";", ZenConsts.Required);
//		Tree.SetMatchedPatternAt(ZenConsts.ForCond, NameSpace, TokenContext, "$Expression$", ZenConsts.Optional);
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ";", ZenConsts.Required);
//		Tree.SetMatchedPatternAt(ZenConsts.ForIteration, NameSpace, TokenContext, "$Expression$", ZenConsts.Optional);
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ")", ZenConsts.Required | ZenConsts.CloseSkipIndent);
//		Tree.SetMatchedPatternAt(ZenConsts.ForBody, NameSpace, TokenContext, "$StmtBlock$", ZenConsts.Required);
//		return Tree;
//	}
//
//	public static ZenNode TypeFor(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenNode InitNode = null;
//		@Var ZenNode CondNode = null;
//		@Var ZenNode IterNode = null;
//		if(ParsedTree.HasNodeAt(ZenConsts.ForInit)) {
//			InitNode =  ParsedTree.TypeCheckAt(ZenConsts.ForInit, Gamma, ZenSystem.VarType, ZenConsts.DefaultTypeCheckPolicy);
//		}
//		if(ParsedTree.HasNodeAt(ZenConsts.ForCond)) {
//			CondNode =  ParsedTree.TypeCheckAt(ZenConsts.ForCond, Gamma, ZenSystem.BooleanType, ZenConsts.DefaultTypeCheckPolicy);
//		}
//		if(ParsedTree.HasNodeAt(ZenConsts.ForIteration)) {
//			IterNode =  ParsedTree.TypeCheckAt(ZenConsts.ForIteration, Gamma, ZenSystem.VarType, ZenConsts.DefaultTypeCheckPolicy);
//		}
//		@Var ZenNode BodyNode =  ParsedTree.TypeCheckAt(ZenConsts.ForBody, Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//		@Var ZenNode ForNode = Gamma.Generator.CreateForNode(BodyNode.Type, ParsedTree, CondNode, IterNode, BodyNode);
//		if(InitNode != null) {
//			if(InitNode instanceof ZenVarDeclNode) {
//				((/*cast*/ZenVarDeclNode)InitNode).BlockNode = ForNode;
//			}
//			else {
//				InitNode = ZenUtils.LinkNode(InitNode, ForNode);
//			}
//			return InitNode;
//		}
//		return ForNode;
//	}
//
//	// ForEach Statement
//	public static ZenSyntaxTree ParseForEach(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "for");
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "(", ZenConsts.Required | ZenConsts.OpenSkipIndent);
//		Tree.SetMatchedPatternAt(ZenConsts.ForEachType, NameSpace, TokenContext, "$Type$", ZenConsts.Optional);
//		Tree.SetMatchedPatternAt(ZenConsts.ForEachName, NameSpace, TokenContext, "$Variable$", ZenConsts.Required);
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "in", ZenConsts.Required);
//		Tree.SetMatchedPatternAt(ZenConsts.ForEachIter, NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//		Tree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ")", ZenConsts.Required | ZenConsts.CloseSkipIndent);
//		Tree.SetMatchedPatternAt(ZenConsts.ForEachBody, NameSpace, TokenContext, "$StmtBlock$", ZenConsts.Required);
//		return Tree;
//	}
//
//	public static ZenNode TypeForEach(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenNode IterNode =  ParsedTree.TypeCheckAt(ZenConsts.ForEachIter, Gamma, ZenSystem.VarType, ZenConsts.DefaultTypeCheckPolicy);
//		if(IterNode.IsErrorNode()) {
//			return IterNode;
//		}
//		if(!IterNode.Type.IsIteratorType()) {
//			@Var ZenFuncSet FuncSet = Gamma.NameSpace.GetMethod(IterNode.Type, ZenUtils.FuncSymbol(".."), true);
//			@Var ZenFunc Func = FuncSet.ResolveUnaryMethod(Gamma, IterNode.Type);
//			if(Func == null) {
//				return Gamma.CreateSyntaxErrorNode(ParsedTree, "for/in takes an iterator, but given = " + IterNode.Type);
//			}
//			Gamma.CheckFunc("operator", Func, ParsedTree.KeyToken);
//			ZenNode ApplyNode = Gamma.Generator.CreateApplySymbolNode(Func.GetReturnType(), ParsedTree, ZenUtils.FuncSymbol(".."), Func);
//			ApplyNode.Append(IterNode);
//			IterNode = ApplyNode;
//		}
//		@Var ZenVariableInfo VarInfo = null;
//		@Var String VarName = ParsedTree.GetSyntaxTreeAt(ZenConsts.ForEachName).KeyToken.ParsedText;
//		@Var ZenType VarType = null;
//		if(ParsedTree.HasNodeAt(ZenConsts.ForEachType)) {
//			VarType = ParsedTree.GetSyntaxTreeAt(ZenConsts.ForEachType).GetParsedType();
//			if(VarType.IsVarType()) {
//				VarType = IterNode.Type.TypeParams[0];
//				Gamma.ReportTypeInference(ParsedTree.GetSyntaxTreeAt(ZenConsts.ForEachName).KeyToken, VarName, VarType);
//			}
//			VarInfo = Gamma.AppendDeclaredVariable(0, VarType, VarName, null, null);
//		}
//		else {
//			@Var ZenVariableInfo VarDefInfo = Gamma.LookupDeclaredVariable(VarName);
//			if(VarDefInfo == null) {
//				return Gamma.CreateSyntaxErrorNode(ParsedTree, "undefined symbol: " + VarName);
//			}
//			VarType = VarDefInfo.Type;
//		}
//		if(IterNode.Type.TypeParams[0] != VarType) {
//			return Gamma.CreateSyntaxErrorNode(ParsedTree, "mismatched iterator: " + VarType + " " + VarName + " in " + IterNode.Type);
//		}
//		@Var ZenVariableInfo VarIterInfo = Gamma.AppendDeclaredVariable(0, IterNode.Type, "iter", null, null);
//		@Var ZenNode WhileNode = Gamma.ParseTypedNode("while(iter.hasHext()) { " + VarName + " = iter.next(); }", ParsedTree.KeyToken.FileLine, ZenSystem.VoidType);
//		if(!WhileNode.IsErrorNode()) {
//			@Var ZenNode BodyNode =  ParsedTree.TypeCheckAt(ZenConsts.ForEachBody, Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//			@Var ZenWhileNode WhileNode2 = (/*cast*/ZenWhileNode)WhileNode;
//			ZenUtils.LinkNode(WhileNode2.BodyNode, BodyNode);
//		}
//		@Var ZenNode Node = Gamma.Generator.CreateVarDeclNode(IterNode.Type, ParsedTree, IterNode.Type, VarIterInfo.NativeName, IterNode, WhileNode);
//		if(VarInfo != null) {
//			Node = Gamma.Generator.CreateVarDeclNode(VarInfo.Type, ParsedTree, VarInfo.Type, VarInfo.NativeName, Gamma.CreateDefaultValue(ParsedTree, VarInfo.Type), Node);
//		}
//		return Node;
//	}
//
//	// Break/Continue Statement
//	public static ZenSyntaxTree ParseBreak(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "break");
//	}
//
//	public static ZenNode TypeBreak(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		return Gamma.Generator.CreateBreakNode(ZenSystem.VoidType, ParsedTree, "");
//	}
//
//	public static ZenSyntaxTree ParseContinue(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "continue");
//	}
//
//	public static ZenNode TypeContinue(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		return Gamma.Generator.CreateContinueNode(ZenSystem.VoidType, ParsedTree, "");
//	}

//	// Return Statement
//	public static ZenSyntaxTree ParseReturn(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree ReturnTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "return");
//		ReturnTree.SetMatchedPatternAt(ZenConsts.ReturnExpr, NameSpace, TokenContext, "$Expression$", ZenConsts.Optional);
//		return ReturnTree;
//	}
//
//	public static ZenNode TypeReturn(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		ParsedTree.NextTree = null; // stop typing of next trees
//		if(Gamma.IsTopLevel()) {
//			return Gamma.UnsupportedTopLevelError(ParsedTree);
//		}
//		@Var ZenType ReturnType = Gamma.FuncBlock.DefinedFunc.GetReturnType();
//		if(ParsedTree.HasNodeAt(ZenConsts.ReturnExpr)) {
//			@Var ZenNode Expr = ParsedTree.TypeCheckAt(ZenConsts.ReturnExpr, Gamma, ReturnType, ZenConsts.DefaultTypeCheckPolicy);
//			if(ReturnType.IsVarType() && !Expr.IsErrorNode()) {
//				Gamma.FuncBlock.DefinedFunc.Types[0] = Expr.Type;
//				Gamma.ReportTypeInference(ParsedTree.KeyToken, "return value of " + Gamma.FuncBlock.DefinedFunc.FuncName, Expr.Type);
//			}
//			if(ReturnType.IsVoidType()) {
//				Gamma.Context.ReportError(ZenConsts.WarningLevel, ParsedTree.KeyToken, "ignored return value");
//				return Gamma.Generator.CreateReturnNode(ReturnType, ParsedTree, null);
//			}
//			return Gamma.Generator.CreateReturnNode(Expr.Type, ParsedTree, Expr);
//		}
//		else {
//			if(ReturnType.IsVarType()) {
//				Gamma.FuncBlock.DefinedFunc.Types[0] = ZenSystem.VoidType;
//				Gamma.ReportTypeInference(ParsedTree.KeyToken, "return value of " + Gamma.FuncBlock.DefinedFunc.FuncName, ZenSystem.VoidType);
//			}
//			if(Gamma.FuncBlock.DefinedFunc.Is(ZenConsts.ConstructorFunc)) {
//				@Var ZenNode ThisNode = Gamma.CreateLocalNode(ParsedTree, Gamma.Generator.GetRecvName());
//				return Gamma.Generator.CreateReturnNode(ThisNode.Type, ParsedTree, ThisNode);
//			}
//			if(!ReturnType.IsVoidType()) {
//				Gamma.Context.ReportError(ZenConsts.WarningLevel, ParsedTree.KeyToken, "returning default value of " + ReturnType);
//				return Gamma.Generator.CreateReturnNode(ReturnType, ParsedTree, Gamma.CreateDefaultValue(ParsedTree, ReturnType));
//			}
//			return Gamma.Generator.CreateReturnNode(ReturnType, ParsedTree, null);
//		}
//	}

//	// try
//	public static ZenSyntaxTree ParseTry(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree TryTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "try");
//		TryTree.SetMatchedPatternAt(ZenConsts.TryBody, NameSpace, TokenContext, "$Block$", ZenConsts.Required);
//		TokenContext.SkipEmptyStatement();
//		if(TokenContext.MatchToken("catch")) {
//			TryTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "(", ZenConsts.Required | ZenConsts.OpenSkipIndent);
//			TryTree.SetMatchedPatternAt(ZenConsts.CatchVariable, NameSpace, TokenContext, "$VarDecl$", ZenConsts.Required);
//			TryTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ")", ZenConsts.Required | ZenConsts.CloseSkipIndent);
//			TryTree.SetMatchedPatternAt(ZenConsts.CatchBody, NameSpace, TokenContext, "$Block$", ZenConsts.Required);
//		}
//		TokenContext.SkipEmptyStatement();
//		if(TokenContext.MatchToken("finally")) {
//			TryTree.SetMatchedPatternAt(ZenConsts.FinallyBody, NameSpace, TokenContext, "$Block$", ZenConsts.Required);
//		}
//		return TryTree;
//	}
//
//	public static ZenNode TypeTry(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenNode TryNode = ParsedTree.TypeCheckAt(ZenConsts.TryBody, Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//		@Var ZenNode FinallyNode = ParsedTree.TypeCheckAt(ZenConsts.FinallyBody, Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//		ZenNode Node = Gamma.Generator.CreateTryNode(TryNode.Type, ParsedTree, TryNode, FinallyNode);
//		if(ParsedTree.HasNodeAt(ZenConsts.CatchVariable)) {
//			ZenSyntaxTree CatchTree = ParsedTree.GetSyntaxTreeAt(ZenConsts.CatchVariable);
//			@Var String CatchName = CatchTree.GetSyntaxTreeAt(ZenConsts.VarDeclName).KeyToken.ParsedText;
//			@Var ZenType CatchType = CatchTree.GetSyntaxTreeAt(ZenConsts.VarDeclType).GetParsedType();
//			//FIXME we need to add CatchName into LocalVariable
//			@Var ZenNode BodyNode = ParsedTree.TypeCheckAt(ZenConsts.CatchBody, Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//			Node.Append(Gamma.Generator.CreateCatchNode(ZenSystem.VoidType, ParsedTree, CatchType, CatchName, BodyNode));
//		}
//		return Node;
//	}

//	// throw $Expr$
//	public static ZenSyntaxTree ParseThrow(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree ThrowTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "throw");
//		ThrowTree.SetMatchedPatternAt(ZenConsts.ReturnExpr, NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//		return ThrowTree;
//	}
//
//	public static ZenNode TypeThrow(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		ParsedTree.NextTree = null;
//		@Var ZenType FaultType = ContextType; // FIXME Gamma.FaultType;
//		@Var ZenNode ExprNode = ParsedTree.TypeCheckAt(ZenConsts.ReturnExpr, Gamma, FaultType, ZenConsts.DefaultTypeCheckPolicy);
//		return Gamma.Generator.CreateThrowNode(ExprNode.Type, ParsedTree, ExprNode);
//	}

//	public static ZenSyntaxTree ParseThis(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "this");
//	}
//
//	public static ZenNode TypeThis(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		return Gamma.CreateLocalNode(ParsedTree, Gamma.Generator.GetRecvName());
//	}
//
//	public static ZenSyntaxTree ParseLine(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "__line__");
//	}
//
//	public static ZenNode TypeLine(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		return Gamma.Generator.CreateConstNode_OLD(ZenSystem.StringType, ParsedTree, ZenSystem.FormatFileLineNumber(ParsedTree.KeyToken.FileLine));
//	}
//
//	public static ZenSyntaxTree ParseSymbols(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "__").ToConstTree(NameSpace);
//	}

//	public static ZenSyntaxTree ParseSuper(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "super");
//		@Var int ParseFlag = TokenContext.SetSkipIndent(true);
//		Tree.SetSyntaxTreeAt(0, new ZenSyntaxTree(NameSpace.GetSyntaxPattern("$Variable$"), NameSpace, Token, null));
//		Tree.SetSyntaxTreeAt(1,  new ZenSyntaxTree(NameSpace.GetSyntaxPattern("this"), NameSpace, new ZenToken("this", 0), null));
//		TokenContext.MatchToken("(");
//		if(!TokenContext.MatchToken(")")) {
//			while(!Tree.IsMismatchedOrError()) {
//				Tree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", Required);
//				if(TokenContext.MatchToken(")")) {
//					break;
//				}
//				Tree.SetMatchedTokenAt(NoWhere, NameSpace, TokenContext, ",", Required);
//			}
//		}
//		TokenContext.ParseFlag = ParseFlag;
//		if(!Tree.IsMismatchedOrError()) {
//			// translate '$super$(this, $Params$)' => 'super(this, $Params$)'
//			Tree.Pattern = NameSpace.GetExtendedSyntaxPattern("(");
//			return Tree;
//		}
//		return Tree;
//	}

//	// new $Type ( $Expr$ [, $Expr$] )
//	public static ZenSyntaxTree ParseNew(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree NewTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "new");
//		NewTree.SetMatchedPatternAt(0, NameSpace, TokenContext, "$Type$", ZenConsts.Optional);
//		if(!NewTree.HasNodeAt(0)) {
//			NewTree.SetSyntaxTreeAt(0, NewTree.CreateConstTree(ZenSystem.VarType)); // TODO
//		}
//		@Var int ParseFlag = TokenContext.SetSkipIndent(true);
//		NewTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "(", ZenConsts.Required);
//		if(!TokenContext.MatchToken(")")) {
//			while(!NewTree.IsMismatchedOrError()) {
//				NewTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//				if(TokenContext.MatchToken(")")) {
//					break;
//				}
//				NewTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ",", ZenConsts.Required);
//			}
//		}
//		TokenContext.SetRememberFlag(ParseFlag);
//		return NewTree;
//	}

//	// switch
//	public static ZenSyntaxTree ParseEnum(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var String EnumTypeName = null;
//		@Var ZenType NewEnumType = null;
//		@Var ZenMap EnumMap = new ZenMap();
//		@Var ZenSyntaxTree EnumTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "enum");
//		EnumTree.SetMatchedPatternAt(ZenConsts.EnumNameTreeIndex, NameSpace, TokenContext, "$FuncName$", ZenConsts.Required);  // $ClassName$ is better
//		if(!EnumTree.IsMismatchedOrError()) {
//			EnumTypeName = EnumTree.GetSyntaxTreeAt(ZenConsts.EnumNameTreeIndex).KeyToken.ParsedText;
//			NewEnumType = ZenSystem.EnumBaseType.CreateSubType(ZenConsts.EnumType, EnumTypeName, null, EnumMap);
//		}
//		EnumTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "{", ZenConsts.Required);
//		@Var int EnumValue = 0;
//		@Var ArrayList<ZenToken> NameList = new ArrayList<ZenToken>();
//		while(!EnumTree.IsMismatchedOrError()) {
//			TokenContext.SkipIndent();
//			if(TokenContext.MatchToken(",")) {
//				continue;
//			}
//			if(TokenContext.MatchToken("}")) {
//				break;
//			}
//			@Var ZenToken Token = TokenContext.Next();
//			if(LibZen.IsVariableName(Token.ParsedText, 0)) {
//				if(EnumMap.GetOrNull(Token.ParsedText) != null) {
//					NameSpace.Context.ReportError(ZenConsts.ErrorLevel, Token, "duplicated name: " + Token.ParsedText);
//					continue;
//				}
//				NameList.add(Token);
//				EnumMap.put(Token.ParsedText, new ZenEnum(NewEnumType, EnumValue, Token.ParsedText));
//				EnumValue += 1;
//				continue;
//			}
//		}
//		if(!EnumTree.IsMismatchedOrError()) {
//			@Var ZenNameSpace StoreNameSpace = NameSpace.GetNameSpace(KonohaGrammar.ParseNameSpaceFlag(0, TokenContext.ParsingAnnotation));
//			StoreNameSpace.AppendTypeName(NewEnumType, EnumTree.GetSyntaxTreeAt(ZenConsts.EnumNameTreeIndex).KeyToken);
//			for(@Var int i = 0; i < LibZen.ListSize(NameList); i = i + 1) {
//				@Var String Key = NameList.get(i).ParsedText;
//				StoreNameSpace.SetSymbol(ZenUtils.ClassStaticSymbol(NewEnumType, Key), EnumMap.GetOrNull(Key), NameList.get(i));
//			}
//			EnumTree.ParsedValue = NewEnumType;
//		}
//		return EnumTree;
//	}
//
//	public static ZenNode TypeEnum(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var Object EnumType = ParsedTree.ParsedValue;
//		return Gamma.Generator.CreateConstNode_OLD(ZenSystem.GuessType(EnumType), ParsedTree, EnumType);
//	}
//
//	public static ZenSyntaxTree ParseCaseBlock(ZenNameSpace ParentNameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree PrevTree = null;
//		@Var ZenNameSpace NameSpace = ParentNameSpace.CreateSubNameSpace();
//		@Var boolean IsCaseBlock = TokenContext.MatchToken("{"); // case EXPR : {}
//		while(TokenContext.HasNext()) {
//			TokenContext.SkipEmptyStatement();
//			if(TokenContext.IsToken("case")) {
//				break;
//			}
//			if(TokenContext.IsToken("default")) {
//				break;
//			}
//			if(TokenContext.IsToken("}")) {
//				if(!IsCaseBlock) {
//				}
//				break;
//			}
//			@Var ZenMap Annotation = TokenContext.SkipAndGetAnnotation(true);
//			@Var ZenSyntaxTree CurrentTree = TokenContext.ParsePattern_OLD(NameSpace, "$Expression$", ZenConsts.Required);
//			if(ZenUtils.IsMismatchedOrError(CurrentTree)) {
//				return CurrentTree;
//			}
//			CurrentTree.SetAnnotation(Annotation);
//			PrevTree = ZenUtils.LinkTree(PrevTree, CurrentTree);
//		}
//		if(PrevTree == null) {
//			return TokenContext.ParsePattern_OLD(NameSpace, "$Empty$", ZenConsts.Required);
//		}
//		return ZenUtils.TreeHead(PrevTree);
//	}
//
//	public static ZenSyntaxTree ParseSwitch(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree SwitchTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "switch");
//		SwitchTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "(", ZenConsts.Required | ZenConsts.OpenSkipIndent);
//		SwitchTree.SetMatchedPatternAt(ZenConsts.SwitchCaseCondExpr, NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//		SwitchTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ")", ZenConsts.Required | ZenConsts.CloseSkipIndent);
//		SwitchTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "{", ZenConsts.Required);
//
//		@Var int CaseIndex = ZenConsts.SwitchCaseCaseIndex;
//		@Var int ParseFlag = TokenContext.SetSkipIndent(true);
//		while(!SwitchTree.IsMismatchedOrError() && !TokenContext.MatchToken("}")) {
//			if(TokenContext.MatchToken("case")) {
//				SwitchTree.SetMatchedPatternAt(CaseIndex, NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//				SwitchTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ":", ZenConsts.Required);
//				SwitchTree.SetMatchedPatternAt(CaseIndex + 1, NameSpace, TokenContext, "$CaseBlock$", ZenConsts.Required);
//				CaseIndex += 2;
//				continue;
//			}
//			if(TokenContext.MatchToken("default")) {
//				SwitchTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ":", ZenConsts.Required);
//				SwitchTree.SetMatchedPatternAt(ZenConsts.SwitchCaseDefaultBlock, NameSpace, TokenContext, "$CaseBlock$", ZenConsts.Required);
//			}
//		}
//		TokenContext.SetRememberFlag(ParseFlag);
//		return SwitchTree;
//	}
//
//	public static ZenNode TypeSwitch(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenNode CondNode = ParsedTree.TypeCheckAt(ZenConsts.IfCond, Gamma, ZenSystem.VarType, ZenConsts.DefaultTypeCheckPolicy);
//		@Var ZenNode DefaultNode = null;
//		if(ParsedTree.HasNodeAt(ZenConsts.SwitchCaseDefaultBlock)) {
//			DefaultNode = ParsedTree.TypeCheckAt(ZenConsts.SwitchCaseDefaultBlock, Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//		}
//		@Var ZenNode Node = Gamma.Generator.CreateSwitchNode(ZenSystem.VoidType, ParsedTree, CondNode, DefaultNode);
//		for(@Var int CaseIndex = ZenConsts.SwitchCaseCaseIndex; CaseIndex < ParsedTree.SubTreeList.size(); CaseIndex += 2) {
//			@Var ZenNode CaseExpr  = ParsedTree.TypeCheckAt(CaseIndex, Gamma, CondNode.Type, ZenConsts.DefaultTypeCheckPolicy);
//			@Var ZenNode CaseBlock = null;
//			if(ParsedTree.HasNodeAt(CaseIndex+1)) {
//				CaseBlock = ParsedTree.TypeCheckAt(CaseIndex+1, Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//			}
//			Node.Append(CaseExpr);
//			Node.Append(CaseBlock);
//		}
//		return Node;
//	}



//	// Array
//	public static ZenSyntaxTree ParseNewArray(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree ArrayTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "new");
//		ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Type$", ZenConsts.Required);
//		while(TokenContext.HasNext() && ArrayTree.IsValidSyntax()) {
//			ArrayTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "[", ZenConsts.Required);
//			ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//			ArrayTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "]", ZenConsts.Required);
//			if(!TokenContext.IsToken("[")) {
//				break;
//			}
//		}
//		return ArrayTree;
//	}
//
//	public static ZenNode TypeNewArray(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenType ArrayType = ParsedTree.GetSyntaxTreeAt(0).GetParsedType();
//		@Var ZenNode ArrayNode = Gamma.Generator.CreateNewArrayNode(ZenSystem.ArrayType, ParsedTree);
//		for(@Var int i = 1; i < LibZen.ListSize(ParsedTree.SubTreeList); i = i + 1) {
//			@Var ZenNode Node = ParsedTree.TypeCheckAt(i, Gamma, ZenSystem.IntType, ZenConsts.DefaultTypeCheckPolicy);
//			if(Node.IsErrorNode()) {
//				return Node;
//			}
//			ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ArrayType, true);
//			ArrayNode.Append(Node);
//		}
//		ArrayNode.Type = ArrayType;
//		return ArrayNode;
//	}
//
//	public static ZenSyntaxTree ParseArray(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var int OldFlag = TokenContext.SetSkipIndent(true);
//		@Var ZenSyntaxTree ArrayTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "[");
//		while(TokenContext.HasNext() && ArrayTree.IsValidSyntax()) {
//			if(TokenContext.MatchToken("]")) {
//				break;
//			}
//			if(TokenContext.MatchToken(",")) {
//				continue;
//			}
//			ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//		}
//		TokenContext.SetRememberFlag(OldFlag);
//		return ArrayTree;
//	}
//
//	public static ZenNode TypeArray(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenNode ArrayNode = Gamma.Generator.CreateArrayLiteralNode(ZenSystem.ArrayType, ParsedTree);
//		@Var ZenType ElemType = ZenSystem.VarType;
//		if(ContextType.IsArrayType()) {
//			ElemType = ContextType.TypeParams[0];
//			ArrayNode.Type = ContextType;
//		}
//		for(@Var int i = 0; i < LibZen.ListSize(ParsedTree.SubTreeList); i = i + 1) {
//			@Var ZenNode Node = ParsedTree.TypeCheckAt(i, Gamma, ElemType, ZenConsts.DefaultTypeCheckPolicy);
//			if(Node.IsErrorNode()) {
//				return Node;
//			}
//			if(ElemType.IsVarType()) {
//				ElemType = Node.Type;
//				ArrayNode.Type = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ElemType, true);
//			}
//			ArrayNode.Append(Node);
//		}
//		if(ElemType.IsVarType()) {
//			ArrayNode.Type = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ZenSystem.AnyType, true);
//		}
//		return ArrayNode;
//	}
//
//	public static ZenSyntaxTree ParseSize(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree ArrayTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "|");
//		ArrayTree.SetMatchedPatternAt(ZenConsts.UnaryTerm, NameSpace, TokenContext, "$SuffixExpression$", ZenConsts.Required);
//		ArrayTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "|", ZenConsts.Required);
//		return ArrayTree;
//	}
//
//	public static ZenNode TypeSize(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenNode ExprNode = ParsedTree.TypeCheckAt(ZenConsts.UnaryTerm, Gamma, ZenSystem.VarType, ZenConsts.DefaultTypeCheckPolicy);
//		if(ExprNode.IsErrorNode()) {
//			return ExprNode;
//		}
//		@Var ZenFuncSet FuncSet = Gamma.NameSpace.GetMethod(ExprNode.Type, ZenUtils.FuncSymbol("||"), true);
//		//System.err.println("polyfunc: " + FuncSet);
//		@Var ZenFunc Func = FuncSet.ResolveUnaryMethod(Gamma, ExprNode.Type);
//		LibZen.Assert(Func != null);  // any has ||
//		Gamma.CheckFunc("operator", Func, ParsedTree.KeyToken);
//		ZenNode Node = Gamma.Generator.CreateApplySymbolNode(Func.GetReturnType(), ParsedTree, ZenUtils.FuncSymbol("||"), Func);
//		Node.Append(ExprNode);
//		if(Node instanceof ZenSymbolNode) {
//			((/*cast*/ZenSymbolNode)Node).ResolvedFunc = Func;
//		}
//		return Node;
//	}
//
//	public static ZenSyntaxTree ParseIndexer(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree ArrayTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "[");
//		ArrayTree.AppendParsedTree2(LeftNode);
//		@Var int OldFlag = TokenContext.SetSkipIndent(true);
//		do {
//			ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//		}
//		while(!ArrayTree.IsMismatchedOrError() && TokenContext.MatchToken(","));
//		ArrayTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "]", ZenConsts.Required);
//		TokenContext.SetRememberFlag(OldFlag);
//		@Var String OperatorSymbol = "[]";
//		if(TokenContext.MatchToken("=")) {
//			ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", ZenConsts.Required);
//			OperatorSymbol = "[]=";
//		}
//		if(ArrayTree.IsValidSyntax()) {
//			ArrayTree.KeyToken.ParsedText = OperatorSymbol;
//		}
//		return ArrayTree;
//	}
//
//	public static ZenNode TypeIndexer(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType Type) {
//		@Var ZenNode RecvNode = ParsedTree.TypeCheckAt(ZenConsts.LeftHandTerm, Gamma, ZenSystem.VarType, ZenConsts.DefaultTypeCheckPolicy);
//		if(!RecvNode.IsErrorNode()) {
//			@Var String MethodName = ParsedTree.KeyToken.ParsedText;
//			@Var ZenResolvedFunc ResolvedFunc = null;
//			@Var ZenFuncSet FuncSet = ParsedTree.NameSpace.GetMethod(RecvNode.Type, ZenUtils.FuncSymbol(MethodName), true);
//			//System.err.println("polyfunc: " + FuncSet);
//			@Var ArrayList<ZenNode> ParamList = new ArrayList<ZenNode>();
//			ParamList.add(RecvNode);
//			ResolvedFunc = FuncSet.ResolveFunc(Gamma, ParsedTree, 1, ParamList);
//			if(ResolvedFunc.Func == null) {
//				return Gamma.CreateSyntaxErrorNode(ParsedTree, "undefined: " + MethodName + " of " + RecvNode.Type);
//			}
//			if(LibZen.EqualsString(ParsedTree.KeyToken.ParsedText, "[]")) {
//				return Gamma.Generator.CreateGetIndexNode(ResolvedFunc.ReturnType, ParsedTree, RecvNode, ResolvedFunc.Func, ParamList.get(1));
//			}
//			else {
//				return Gamma.Generator.CreateSetIndexNode(ResolvedFunc.ReturnType, ParsedTree, RecvNode, ResolvedFunc.Func, ParamList.get(1), ParamList.get(2));
//			}
//		}
//		return RecvNode;
//	}
//
//	public static ZenSyntaxTree ParseSlice(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree SliceTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "[");
//		SliceTree.AppendParsedTree2(LeftNode);
//		SliceTree.SetMatchedPatternAt(1, NameSpace, TokenContext, "$Expression$", ZenConsts.Optional);
//		if(!SliceTree.HasNodeAt(1)) {
//			SliceTree.SetSyntaxTreeAt(1, SliceTree.CreateConstTree(0L)); // s[:x]
//		}
//		SliceTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, ":", ZenConsts.Required);
//		SliceTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", ZenConsts.Optional);
//		SliceTree.SetMatchedTokenAt(ZenConsts.NoWhere, NameSpace, TokenContext, "]", ZenConsts.Required);
//		return SliceTree;
//	}
//
//	public static ZenNode TypeSlice(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenNode RecvNode = ParsedTree.TypeCheckAt(ZenConsts.LeftHandTerm, Gamma, ZenSystem.VarType, ZenConsts.DefaultTypeCheckPolicy);
//		if(!RecvNode.IsErrorNode()) {
//			return KonohaGrammar.TypeMethodNameCall(Gamma, ParsedTree, RecvNode, "[:]", ContextType);
//		}
//		return RecvNode;
//	}

	// ClassDecl
//	private static boolean TypeFieldDecl(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenClassField ClassField) {
//		@Var int    FieldFlag = KonohaGrammar.ParseVarFlag(0, ParsedTree.Annotation);
//		@Var ZenType DeclType = ParsedTree.GetSyntaxTreeAt(ZenConsts.VarDeclType).GetParsedType();
//		@Var String FieldName = ParsedTree.GetSyntaxTreeAt(ZenConsts.VarDeclName).KeyToken.ParsedText;
//		@Var ZenNode InitValueNode = null;
//		@Var Object InitValue = null;
//		if(ParsedTree.HasNodeAt(ZenConsts.VarDeclValue)) {
//			InitValueNode = ParsedTree.TypeCheckAt(ZenConsts.VarDeclValue, Gamma, DeclType, ZenConsts.OnlyConstPolicy | ZenConsts.NullablePolicy);
//			if(InitValueNode.IsErrorNode()) {
//				return false;
//			}
//			InitValue = InitValueNode.ToConstValue(Gamma.Context, true);
//		}
//		if(ZenConsts.UseLangStat) {
//			Gamma.Context.Stat.VarDecl += 1;
//		}/*EndOfStat*/
//		if(DeclType.IsVarType()) {
//			if(InitValueNode == null) {
//				DeclType = ZenSystem.AnyType;
//			}
//			else {
//				DeclType = InitValueNode.Type;
//			}
//			Gamma.ReportTypeInference(ParsedTree.KeyToken, FieldName, DeclType);
//			if(ZenConsts.UseLangStat) {
//				Gamma.Context.Stat.VarDeclInfer += 1;
//				if(DeclType.IsAnyType()) {
//					Gamma.Context.Stat.VarDeclInferAny += 1;
//				}
//			}/*EndOfStat*/
//		}
//		if(ZenConsts.UseLangStat) {
//			if(DeclType.IsAnyType()) {
//				Gamma.Context.Stat.VarDeclAny += 1;
//			}
//		}/*EndOfStat*/
//		if(InitValueNode == null) {
//			InitValue = DeclType.DefaultNullValue;
//		}
//		ClassField.CreateField(FieldFlag, DeclType, FieldName, ParsedTree.GetSyntaxTreeAt(ZenConsts.VarDeclName).KeyToken, InitValue);
//		return true;
//	}
//
//	public static ZenSyntaxTree ParseClassDecl2(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		@Var ZenSyntaxTree ClassDeclTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "class");
//		ClassDeclTree.SetMatchedPatternAt(ZenConsts.ClassDeclName, NameSpace, TokenContext, "$FuncName$", ZenConsts.Required); //$ClassName$ is better
//		if(TokenContext.MatchToken("extends")) {
//			ClassDeclTree.SetMatchedPatternAt(ZenConsts.ClassDeclSuperType, NameSpace, TokenContext, "$Type$", ZenConsts.Required);
//		}
//		if(ClassDeclTree.IsMismatchedOrError()) {
//			return ClassDeclTree;
//		}
//		// define new class
//		@Var ZenNameSpace ClassNameSpace = new ZenNameSpace(NameSpace.Context, NameSpace);
//		@Var ZenToken NameToken = ClassDeclTree.GetSyntaxTreeAt(ZenConsts.ClassDeclName).KeyToken;
//		@Var ZenType SuperType = ZenSystem.TopType;
//		if(ClassDeclTree.HasNodeAt(ZenConsts.ClassDeclSuperType)) {
//			SuperType = ClassDeclTree.GetSyntaxTreeAt(ZenConsts.ClassDeclSuperType).GetParsedType();
//		}
//		@Var int ClassFlag = KonohaGrammar.ParseClassFlag(0, TokenContext.ParsingAnnotation);
//		@Var String ClassName = NameToken.ParsedText;
//		@Var ZenType DefinedType = NameSpace.GetType(ClassName);
//		if(DefinedType != null && DefinedType.IsAbstractType()) {
//			DefinedType.TypeFlag = ClassFlag;
//			DefinedType.SuperType = SuperType;
//			NameToken = null; // preventing duplicated symbol message at (A)
//		}
//		else {
//			DefinedType = SuperType.CreateSubType(ClassFlag, ClassName, null, null);
//			ClassNameSpace.AppendTypeName(DefinedType, NameToken);  // temporary
//		}
//		ClassNameSpace.SetSymbol("This", DefinedType, NameToken);
//		ClassDeclTree.SetMatchedPatternAt(ZenConsts.ClassDeclBlock, ClassNameSpace, TokenContext, "$Block$", ZenConsts.Optional);
//		if(ClassDeclTree.HasNodeAt(ZenConsts.ClassDeclBlock)) {
//			@Var ZenClassField ClassField = new ZenClassField(DefinedType, NameSpace);
//			@Var ZenTypeEnv Gamma = new ZenTypeEnv(ClassNameSpace);
//			@Var ZenSyntaxTree SubTree = ClassDeclTree.GetSyntaxTreeAt(ZenConsts.ClassDeclBlock);
//			while(SubTree != null) {
//				if(SubTree.Pattern.EqualsName("$VarDecl$")) {
//					KonohaGrammar.TypeFieldDecl(Gamma, SubTree, ClassField);
//				}
//				SubTree = SubTree.NextTree;
//			}
//			ClassDeclTree.ParsedValue = ClassField;
//		}
//		if(ClassDeclTree.IsValidSyntax()) {
//			NameSpace.AppendTypeName(DefinedType, NameToken);   /* (A) */
//		}
//		return ClassDeclTree;
//	}
//
//	public static ZenNode TypeClassDecl2(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		@Var ZenClassField ClassField = (/*cast*/ZenClassField)ParsedTree.ParsedValue;
//		if(ClassField != null) {
//			@Var ZenType DefinedType = ClassField.DefinedType;
//			DefinedType.SetClassField(ClassField);
//			Gamma.Generator.OpenClassField(ParsedTree, DefinedType, ClassField);
//			@Var ZenSyntaxTree SubTree = ParsedTree.GetSyntaxTreeAt(ZenConsts.ClassDeclBlock);
//			@Var ArrayList<ZenFunc> MemberList = new ArrayList<ZenFunc>();
//			while(SubTree != null) {
//				if(SubTree.Pattern.EqualsName("$FuncDecl$") || SubTree.Pattern.EqualsName("$Constructor2$")) {
//					MemberList.add((/*cast*/ZenFunc)SubTree.ParsedValue);
//				}
//				if(!SubTree.Pattern.EqualsName("$VarDecl$")) {
//					SubTree.TypeCheck(Gamma, ZenSystem.VoidType, ZenConsts.DefaultTypeCheckPolicy);
//				}
//				SubTree = SubTree.NextTree;
//			}
//			Gamma.Generator.CloseClassField(DefinedType, MemberList);
//		}
//		return Gamma.Generator.CreateEmptyNode(ZenSystem.VoidType);
//	}
	
	public static void ImportGrammar(ZenNameSpace NameSpace, Class<?> Grammar) {
////		NameSpace.AppendTokenFunc(" \t", LibNative.LoadTokenFunc(Grammar, "WhiteSpaceToken"));
//		NameSpace.AppendTokenFunc("\n",  LibNative.LoadTokenFunc(Grammar, "IndentToken"));
//		NameSpace.AppendTokenFunc(";", LibNative.LoadTokenFunc(Grammar, "SemiColonToken"));
//		NameSpace.AppendTokenFunc("{}()[]<>.,?:+-*/%=&|!@~^$", LibNative.LoadTokenFunc(Grammar, "OperatorToken"));
//		NameSpace.AppendTokenFunc("/", LibNative.LoadTokenFunc(Grammar, "CommentToken"));  // overloading
//		NameSpace.AppendTokenFunc("Aa_", LibNative.LoadTokenFunc(Grammar, "SymbolToken"));
//
//		NameSpace.AppendTokenFunc("\"", LibNative.LoadTokenFunc(Grammar, "StringLiteralToken"));
//		//NameSpace.AppendTokenFunc("\"", ZenGrammar.LoadTokenFunc(ParserContext, this, "StringLiteralToken_StringInterpolation"));
////		NameSpace.AppendTokenFunc("'", LibNative.LoadTokenFunc(Grammar, "CharLiteralToken"));
//		NameSpace.AppendTokenFunc("1",  LibNative.LoadTokenFunc(Grammar, "NumberLiteralToken"));
//
//		@Var ZenFunc MatchUnary     = LibNative.LoadMatchFunc(Grammar, "MatchUnary");
//		@Var ZenFunc MatchBinary    = LibNative.LoadMatchFunc(Grammar, "MatchBinary");
////		@Var ZenFunc  MatchConst      = LibNative.LoadMatchFunc(Grammar, "MatchConst");
//
////		NameSpace.AppendSyntax("null", LibNative.LoadMatchFunc(Grammar, "MatchNull"));
//		NameSpace.AppendSyntax("true", LibNative.LoadMatchFunc(Grammar, "MatchTrue"));
//		NameSpace.AppendSyntax("false", LibNative.LoadMatchFunc(Grammar, "MatchFalse"));
//
//		NameSpace.AppendSyntax("+", MatchUnary);
//		NameSpace.AppendSyntax("-", MatchUnary);
//		NameSpace.AppendSyntax("~", MatchUnary);
//		NameSpace.AppendSyntax("! not", LibNative.LoadMatchFunc(Grammar, "MatchNot"));
////		NameSpace.AppendSyntax("++ --", LibNative.LoadMatchFunc(Grammar, "MatchIncl"));
//
//		NameSpace.AppendExtendedSyntax("* / %", ZenPrecedence.CStyleMUL, MatchBinary);
//		NameSpace.AppendExtendedSyntax("+ -", ZenPrecedence.CStyleADD, MatchBinary);
//
//		NameSpace.AppendExtendedSyntax("< <= > >=", ZenPrecedence.CStyleCOMPARE, MatchBinary);
//		NameSpace.AppendExtendedSyntax("== !=", ZenPrecedence.CStyleEquals, MatchBinary);
//
//		NameSpace.AppendExtendedSyntax("<< >>", ZenPrecedence.CStyleSHIFT, MatchBinary);
//		NameSpace.AppendExtendedSyntax("&", ZenPrecedence.CStyleBITAND, MatchBinary);
//		NameSpace.AppendExtendedSyntax("|", ZenPrecedence.CStyleBITOR, MatchBinary);
//		NameSpace.AppendExtendedSyntax("^", ZenPrecedence.CStyleBITXOR, MatchBinary);
//
//		NameSpace.AppendExtendedSyntax("=", ZenPrecedence.CStyleAssign | ZenConsts.LeftJoin, MatchBinary);
//		NameSpace.AppendExtendedSyntax("+= -= *= /= %= <<= >>= &= |= ^=", ZenPrecedence.CStyleAssign, MatchBinary);
////		NameSpace.AppendExtendedSyntax("++ --", 0, LibNative.LoadMatchFunc(Grammar, "MatchIncl"));
//
//		NameSpace.AppendExtendedSyntax("&& and", ZenPrecedence.CStyleAND, LibNative.LoadMatchFunc(Grammar, "MatchAnd"));
//		NameSpace.AppendExtendedSyntax("|| or", ZenPrecedence.CStyleOR, LibNative.LoadMatchFunc(Grammar, "MatchOr"));
//		NameSpace.AppendExtendedSyntax("<: instanceof", ZenPrecedence.Instanceof, MatchBinary);
//
////		NameSpace.AppendExtendedSyntax("?", 0, LibNative.LoadMatchFunc(Grammar, "MatchTrinary"));
//
////		NameSpace.AppendSyntax("$Error$", LibNative.LoadMatchFunc(Grammar, "MatchError"));
////		NameSpace.AppendSyntax("$Empty$", LibNative.LoadMatchFunc(Grammar, "MatchEmpty"));
////		NameSpace.AppendSyntax(";", LibNative.LoadMatchFunc(Grammar, "MatchSemiColon"));
//		NameSpace.AppendSyntax("$Symbol$", LibNative.LoadMatchFunc(Grammar, "MatchSymbol"));
//		NameSpace.AppendSyntax("$Type$",LibNative.LoadMatchFunc(Grammar, "MatchType"));
//		NameSpace.AppendSyntax("$TypeSuffix$", LibNative.LoadMatchFunc(Grammar, "MatchTypeSuffix"));
//		NameSpace.AppendSyntax("$TypeAnnotation$", LibNative.LoadMatchFunc(Grammar, "MatchTypeSuffix"));
//		
////		NameSpace.AppendSyntax("<", LibNative.LoadMatchFunc(Grammar, "MatchGenericFuncDecl"));
////		NameSpace.AppendSyntax("$Variable$", LibNative.LoadMatchFunc(Grammar, "MatchVariable"));
////		NameSpace.AppendSyntax("$Const$", LibNative.LoadMatchFunc(Grammar, "MatchConst"));
////		NameSpace.AppendSyntax("$CharLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchCharLiteral"));
//		NameSpace.AppendSyntax("$StringLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchStringLiteral"));
//		NameSpace.AppendSyntax("$IntegerLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchIntLiteral"));
//		NameSpace.AppendSyntax("$FloatLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchFloatLiteral"));
//
//		NameSpace.AppendExtendedSyntax(".", 0, LibNative.LoadMatchFunc(Grammar, "MatchGetter"));
//
//		NameSpace.AppendSyntax("(", LibNative.LoadMatchFunc(Grammar, "MatchGroup"));
//		NameSpace.AppendSyntax("(", LibNative.LoadMatchFunc(Grammar, "MatchCast"));
//		NameSpace.AppendExtendedSyntax("(", 0, LibNative.LoadMatchFunc(Grammar, "MatchApply"));
////		NameSpace.AppendSyntax("[", LibNative.LoadMatchFunc(Grammar, "MatchArray"), LibNative.LoadMatchFunc(Grammar, "MatchArray"));
////		NameSpace.AppendExtendedSyntax("[", 0, LibNative.LoadMatchFunc(Grammar, "MatchIndexer"), LibNative.LoadMatchFunc(Grammar, "MatchIndexer"));
////		NameSpace.AppendExtendedSyntax("[", 0, LibNative.LoadMatchFunc(Grammar, "MatchSlice"), LibNative.LoadMatchFunc(Grammar, "MatchSlice"));
////		NameSpace.AppendSyntax("|", LibNative.LoadMatchFunc(Grammar, "MatchSize"), LibNative.LoadMatchFunc(Grammar, "MatchSize"));
//
//		NameSpace.AppendSyntax("$Block$", LibNative.LoadMatchFunc(Grammar, "MatchBlock"));
//		NameSpace.AppendSyntax("$Expression$", LibNative.LoadMatchFunc(Grammar, "MatchExpression"));
//		NameSpace.AppendSyntax("$SuffixExpression$", LibNative.LoadMatchFunc(Grammar, "MatchSuffixExpression"));
//
//		NameSpace.AppendSyntax("if", LibNative.LoadMatchFunc(Grammar, "MatchIf"));
//		NameSpace.AppendSyntax("return", LibNative.LoadMatchFunc(Grammar, "MatchReturn"));
//
//		NameSpace.AppendSyntax("$Identifier$", LibNative.LoadMatchFunc(Grammar, "MatchIdentifier"));
//		NameSpace.AppendSyntax("var",  LibNative.LoadMatchFunc(Grammar, "MatchVarDecl"));
//		NameSpace.AppendSyntax("$Param$", LibNative.LoadMatchFunc(Grammar, "MatchParam"));
//		NameSpace.AppendSyntax("function", LibNative.LoadMatchFunc(Grammar, "MatchFunction"));
//		NameSpace.AppendSyntax("let", LibNative.LoadMatchFunc(Grammar, "MatchLetDecl"));
		
//		NameSpace.AppendSyntax("require", LibNative.LoadMatchFunc(Grammar, "MatchRequire"));
//		NameSpace.AppendSyntax("import", LibNative.LoadMatchFunc(Grammar, "MatchImport"));


//		NameSpace.AppendSyntax("while", LibNative.LoadMatchFunc(Grammar, "MatchWhile"));
//		NameSpace.AppendSyntax("do", LibNative.LoadMatchFunc(Grammar, "MatchDoWhile"));
//		NameSpace.AppendSyntax("for", LibNative.LoadMatchFunc(Grammar, "MatchFor"));
//		NameSpace.AppendSyntax("for", LibNative.LoadMatchFunc(Grammar, "MatchForEach"));
//		NameSpace.AppendSyntax("continue", LibNative.LoadMatchFunc(Grammar, "MatchContinue"));
//		NameSpace.AppendSyntax("break", LibNative.LoadMatchFunc(Grammar, "MatchBreak"));

//		NameSpace.AppendSyntax("try", LibNative.LoadMatchFunc(Grammar, "MatchTry"));
//		NameSpace.AppendSyntax("throw", LibNative.LoadMatchFunc(Grammar, "MatchThrow"));

//		NameSpace.AppendSyntax("class", LibNative.LoadMatchFunc(Grammar, "MatchClassDecl2"));
//		NameSpace.AppendSyntax("constructor", LibNative.LoadMatchFunc(Grammar, "MatchConstructor2"));
//		NameSpace.AppendSyntax("super", LibNative.LoadMatchFunc(Grammar, "MatchSuper"));
//		NameSpace.AppendSyntax("this", LibNative.LoadMatchFunc(Grammar, "MatchThis"));
//		NameSpace.AppendSyntax("new", LibNative.LoadMatchFunc(Grammar, "MatchNew"));
//		NameSpace.AppendSyntax("new", LibNative.LoadMatchFunc(Grammar, "MatchNewArray"));

//		NameSpace.AppendSyntax("enum", LibNative.LoadMatchFunc(Grammar, "MatchEnum"));
//		NameSpace.AppendSyntax("switch", LibNative.LoadMatchFunc(Grammar, "MatchSwitch"));
//		NameSpace.AppendSyntax("$CaseBlock$", LibNative.LoadMatchFunc(Grammar, "MatchCaseBlock"));

//		// expermental
//		NameSpace.AppendSyntax("__line__", LibNative.LoadMatchFunc(Grammar, "MatchLine"));
//		NameSpace.AppendSyntax("__", LibNative.LoadMatchFunc(Grammar, "MatchSymbols"));

		
	}

}
