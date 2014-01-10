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
//		/*local*/ZenToken Token = TokenContext.Next();
//		/*local*/Object ConstValue = NameSpace.GetSymbol(Token.ParsedText);
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
//		return Gamma.Generator.CreateErrorNode(ZenStaticTable.VoidType, ParsedTree);
//	}
//
//	public static ZenSyntaxTree ParseEmpty(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return new ZenSyntaxTree(Pattern, NameSpace, TokenContext.GetBeforeToken(), null);
//	}
//
//	public static ZenNode TypeEmpty(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType Type) {
//		return Gamma.Generator.CreateEmptyNode(ZenStaticTable.VoidType);
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
//			/*local*/ZenToken Token = TokenContext.Next();
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
//		/*local*/ZenToken Token = TokenContext.Next();
//		/*local*/String PackageName = LibZen.UnquoteString(Token.ParsedText);
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
//		/*local*/ZenSyntaxTree ImportTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "import");
//		/*local*/String PackageName = KonohaGrammar.ParseJoinedName(TokenContext);
//		ImportTree.ParsedValue = PackageName;
//		return ImportTree;
//	}
//
//	public static ZenNode TypeImport(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType Type) {
//		/*local*/Object Value = LibNative.ImportNativeObject(Gamma.NameSpace, (/*cast*/String)ParsedTree.ParsedValue);
//		if(Value == null) {
//			return Gamma.CreateSyntaxErrorNode(ParsedTree, "cannot import: " + ParsedTree.ParsedValue);
//		}
//		return Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.GuessType(Value), ParsedTree, Value);
//	}


//	// While Statement
//	public static ZenSyntaxTree ParseWhile(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree WhileTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "while");
//		WhileTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "(", GreenTeaConsts.Required | GreenTeaConsts.OpenSkipIndent);
//		WhileTree.SetMatchedPatternAt(GreenTeaConsts.WhileCond, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//		WhileTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ")", GreenTeaConsts.Required | GreenTeaConsts.CloseSkipIndent);
//		WhileTree.SetMatchedPatternAt(GreenTeaConsts.WhileBody, NameSpace, TokenContext, "$StmtBlock$", GreenTeaConsts.Required);
//		return WhileTree;
//	}
//
//	public static ZenNode TypeWhile(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenNode CondNode = ParsedTree.TypeCheckAt(GreenTeaConsts.WhileCond, Gamma, ZenStaticTable.BooleanType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		/*local*/ZenNode BodyNode =  ParsedTree.TypeCheckAt(GreenTeaConsts.WhileBody, Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		return Gamma.Generator.CreateWhileNode(BodyNode.Type, ParsedTree, CondNode, BodyNode);
//	}
//
//	// DoWhile Statement
//	public static ZenSyntaxTree ParseDoWhile(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "do");
//		Tree.SetMatchedPatternAt(GreenTeaConsts.WhileBody, NameSpace, TokenContext, "$StmtBlock$", GreenTeaConsts.Required);
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "while", GreenTeaConsts.Required);
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "(", GreenTeaConsts.Required | GreenTeaConsts.OpenSkipIndent);
//		Tree.SetMatchedPatternAt(GreenTeaConsts.WhileCond, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ")", GreenTeaConsts.Required | GreenTeaConsts.CloseSkipIndent);
//		return Tree;
//	}
//
//	public static ZenNode TypeDoWhile(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenNode CondNode = ParsedTree.TypeCheckAt(GreenTeaConsts.WhileCond, Gamma, ZenStaticTable.BooleanType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		/*local*/ZenNode BodyNode =  ParsedTree.TypeCheckAt(GreenTeaConsts.WhileBody, Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		return Gamma.Generator.CreateDoWhileNode(BodyNode.Type, ParsedTree, CondNode, BodyNode);
//	}
//
//	// For Statement
//	public static ZenSyntaxTree ParseFor(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "for");
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "(", GreenTeaConsts.Required | GreenTeaConsts.OpenSkipIndent);
//		Tree.SetMatchedPatternAt(GreenTeaConsts.ForInit, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Optional);
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ";", GreenTeaConsts.Required);
//		Tree.SetMatchedPatternAt(GreenTeaConsts.ForCond, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Optional);
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ";", GreenTeaConsts.Required);
//		Tree.SetMatchedPatternAt(GreenTeaConsts.ForIteration, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Optional);
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ")", GreenTeaConsts.Required | GreenTeaConsts.CloseSkipIndent);
//		Tree.SetMatchedPatternAt(GreenTeaConsts.ForBody, NameSpace, TokenContext, "$StmtBlock$", GreenTeaConsts.Required);
//		return Tree;
//	}
//
//	public static ZenNode TypeFor(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenNode InitNode = null;
//		/*local*/ZenNode CondNode = null;
//		/*local*/ZenNode IterNode = null;
//		if(ParsedTree.HasNodeAt(GreenTeaConsts.ForInit)) {
//			InitNode =  ParsedTree.TypeCheckAt(GreenTeaConsts.ForInit, Gamma, ZenStaticTable.VarType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		}
//		if(ParsedTree.HasNodeAt(GreenTeaConsts.ForCond)) {
//			CondNode =  ParsedTree.TypeCheckAt(GreenTeaConsts.ForCond, Gamma, ZenStaticTable.BooleanType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		}
//		if(ParsedTree.HasNodeAt(GreenTeaConsts.ForIteration)) {
//			IterNode =  ParsedTree.TypeCheckAt(GreenTeaConsts.ForIteration, Gamma, ZenStaticTable.VarType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		}
//		/*local*/ZenNode BodyNode =  ParsedTree.TypeCheckAt(GreenTeaConsts.ForBody, Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		/*local*/ZenNode ForNode = Gamma.Generator.CreateForNode(BodyNode.Type, ParsedTree, CondNode, IterNode, BodyNode);
//		if(InitNode != null) {
//			if(InitNode instanceof ZenVarDeclNode) {
//				((/*cast*/ZenVarDeclNode)InitNode).BlockNode = ForNode;
//			}
//			else {
//				InitNode = GreenTeaUtils.LinkNode(InitNode, ForNode);
//			}
//			return InitNode;
//		}
//		return ForNode;
//	}
//
//	// ForEach Statement
//	public static ZenSyntaxTree ParseForEach(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "for");
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "(", GreenTeaConsts.Required | GreenTeaConsts.OpenSkipIndent);
//		Tree.SetMatchedPatternAt(GreenTeaConsts.ForEachType, NameSpace, TokenContext, "$Type$", GreenTeaConsts.Optional);
//		Tree.SetMatchedPatternAt(GreenTeaConsts.ForEachName, NameSpace, TokenContext, "$Variable$", GreenTeaConsts.Required);
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "in", GreenTeaConsts.Required);
//		Tree.SetMatchedPatternAt(GreenTeaConsts.ForEachIter, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//		Tree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ")", GreenTeaConsts.Required | GreenTeaConsts.CloseSkipIndent);
//		Tree.SetMatchedPatternAt(GreenTeaConsts.ForEachBody, NameSpace, TokenContext, "$StmtBlock$", GreenTeaConsts.Required);
//		return Tree;
//	}
//
//	public static ZenNode TypeForEach(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenNode IterNode =  ParsedTree.TypeCheckAt(GreenTeaConsts.ForEachIter, Gamma, ZenStaticTable.VarType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		if(IterNode.IsErrorNode()) {
//			return IterNode;
//		}
//		if(!IterNode.Type.IsIteratorType()) {
//			/*local*/ZenFuncSet FuncSet = Gamma.NameSpace.GetMethod(IterNode.Type, GreenTeaUtils.FuncSymbol(".."), true);
//			/*local*/ZenFunc Func = FuncSet.ResolveUnaryMethod(Gamma, IterNode.Type);
//			if(Func == null) {
//				return Gamma.CreateSyntaxErrorNode(ParsedTree, "for/in takes an iterator, but given = " + IterNode.Type);
//			}
//			Gamma.CheckFunc("operator", Func, ParsedTree.KeyToken);
//			ZenNode ApplyNode = Gamma.Generator.CreateApplySymbolNode(Func.GetReturnType(), ParsedTree, GreenTeaUtils.FuncSymbol(".."), Func);
//			ApplyNode.Append(IterNode);
//			IterNode = ApplyNode;
//		}
//		/*local*/ZenVariableInfo VarInfo = null;
//		/*local*/String VarName = ParsedTree.GetSyntaxTreeAt(GreenTeaConsts.ForEachName).KeyToken.ParsedText;
//		/*local*/ZenType VarType = null;
//		if(ParsedTree.HasNodeAt(GreenTeaConsts.ForEachType)) {
//			VarType = ParsedTree.GetSyntaxTreeAt(GreenTeaConsts.ForEachType).GetParsedType();
//			if(VarType.IsVarType()) {
//				VarType = IterNode.Type.TypeParams[0];
//				Gamma.ReportTypeInference(ParsedTree.GetSyntaxTreeAt(GreenTeaConsts.ForEachName).KeyToken, VarName, VarType);
//			}
//			VarInfo = Gamma.AppendDeclaredVariable(0, VarType, VarName, null, null);
//		}
//		else {
//			/*local*/ZenVariableInfo VarDefInfo = Gamma.LookupDeclaredVariable(VarName);
//			if(VarDefInfo == null) {
//				return Gamma.CreateSyntaxErrorNode(ParsedTree, "undefined symbol: " + VarName);
//			}
//			VarType = VarDefInfo.Type;
//		}
//		if(IterNode.Type.TypeParams[0] != VarType) {
//			return Gamma.CreateSyntaxErrorNode(ParsedTree, "mismatched iterator: " + VarType + " " + VarName + " in " + IterNode.Type);
//		}
//		/*local*/ZenVariableInfo VarIterInfo = Gamma.AppendDeclaredVariable(0, IterNode.Type, "iter", null, null);
//		/*local*/ZenNode WhileNode = Gamma.ParseTypedNode("while(iter.hasHext()) { " + VarName + " = iter.next(); }", ParsedTree.KeyToken.FileLine, ZenStaticTable.VoidType);
//		if(!WhileNode.IsErrorNode()) {
//			/*local*/ZenNode BodyNode =  ParsedTree.TypeCheckAt(GreenTeaConsts.ForEachBody, Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//			/*local*/ZenWhileNode WhileNode2 = (/*cast*/ZenWhileNode)WhileNode;
//			GreenTeaUtils.LinkNode(WhileNode2.BodyNode, BodyNode);
//		}
//		/*local*/ZenNode Node = Gamma.Generator.CreateVarDeclNode(IterNode.Type, ParsedTree, IterNode.Type, VarIterInfo.NativeName, IterNode, WhileNode);
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
//		return Gamma.Generator.CreateBreakNode(ZenStaticTable.VoidType, ParsedTree, "");
//	}
//
//	public static ZenSyntaxTree ParseContinue(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "continue");
//	}
//
//	public static ZenNode TypeContinue(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		return Gamma.Generator.CreateContinueNode(ZenStaticTable.VoidType, ParsedTree, "");
//	}

//	// Return Statement
//	public static ZenSyntaxTree ParseReturn(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree ReturnTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "return");
//		ReturnTree.SetMatchedPatternAt(GreenTeaConsts.ReturnExpr, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Optional);
//		return ReturnTree;
//	}
//
//	public static ZenNode TypeReturn(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		ParsedTree.NextTree = null; // stop typing of next trees
//		if(Gamma.IsTopLevel()) {
//			return Gamma.UnsupportedTopLevelError(ParsedTree);
//		}
//		/*local*/ZenType ReturnType = Gamma.FuncBlock.DefinedFunc.GetReturnType();
//		if(ParsedTree.HasNodeAt(GreenTeaConsts.ReturnExpr)) {
//			/*local*/ZenNode Expr = ParsedTree.TypeCheckAt(GreenTeaConsts.ReturnExpr, Gamma, ReturnType, GreenTeaConsts.DefaultTypeCheckPolicy);
//			if(ReturnType.IsVarType() && !Expr.IsErrorNode()) {
//				Gamma.FuncBlock.DefinedFunc.Types[0] = Expr.Type;
//				Gamma.ReportTypeInference(ParsedTree.KeyToken, "return value of " + Gamma.FuncBlock.DefinedFunc.FuncName, Expr.Type);
//			}
//			if(ReturnType.IsVoidType()) {
//				Gamma.Context.ReportError(GreenTeaConsts.WarningLevel, ParsedTree.KeyToken, "ignored return value");
//				return Gamma.Generator.CreateReturnNode(ReturnType, ParsedTree, null);
//			}
//			return Gamma.Generator.CreateReturnNode(Expr.Type, ParsedTree, Expr);
//		}
//		else {
//			if(ReturnType.IsVarType()) {
//				Gamma.FuncBlock.DefinedFunc.Types[0] = ZenStaticTable.VoidType;
//				Gamma.ReportTypeInference(ParsedTree.KeyToken, "return value of " + Gamma.FuncBlock.DefinedFunc.FuncName, ZenStaticTable.VoidType);
//			}
//			if(Gamma.FuncBlock.DefinedFunc.Is(GreenTeaConsts.ConstructorFunc)) {
//				/*local*/ZenNode ThisNode = Gamma.CreateLocalNode(ParsedTree, Gamma.Generator.GetRecvName());
//				return Gamma.Generator.CreateReturnNode(ThisNode.Type, ParsedTree, ThisNode);
//			}
//			if(!ReturnType.IsVoidType()) {
//				Gamma.Context.ReportError(GreenTeaConsts.WarningLevel, ParsedTree.KeyToken, "returning default value of " + ReturnType);
//				return Gamma.Generator.CreateReturnNode(ReturnType, ParsedTree, Gamma.CreateDefaultValue(ParsedTree, ReturnType));
//			}
//			return Gamma.Generator.CreateReturnNode(ReturnType, ParsedTree, null);
//		}
//	}

//	// try
//	public static ZenSyntaxTree ParseTry(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree TryTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "try");
//		TryTree.SetMatchedPatternAt(GreenTeaConsts.TryBody, NameSpace, TokenContext, "$Block$", GreenTeaConsts.Required);
//		TokenContext.SkipEmptyStatement();
//		if(TokenContext.MatchToken("catch")) {
//			TryTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "(", GreenTeaConsts.Required | GreenTeaConsts.OpenSkipIndent);
//			TryTree.SetMatchedPatternAt(GreenTeaConsts.CatchVariable, NameSpace, TokenContext, "$VarDecl$", GreenTeaConsts.Required);
//			TryTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ")", GreenTeaConsts.Required | GreenTeaConsts.CloseSkipIndent);
//			TryTree.SetMatchedPatternAt(GreenTeaConsts.CatchBody, NameSpace, TokenContext, "$Block$", GreenTeaConsts.Required);
//		}
//		TokenContext.SkipEmptyStatement();
//		if(TokenContext.MatchToken("finally")) {
//			TryTree.SetMatchedPatternAt(GreenTeaConsts.FinallyBody, NameSpace, TokenContext, "$Block$", GreenTeaConsts.Required);
//		}
//		return TryTree;
//	}
//
//	public static ZenNode TypeTry(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenNode TryNode = ParsedTree.TypeCheckAt(GreenTeaConsts.TryBody, Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		/*local*/ZenNode FinallyNode = ParsedTree.TypeCheckAt(GreenTeaConsts.FinallyBody, Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		ZenNode Node = Gamma.Generator.CreateTryNode(TryNode.Type, ParsedTree, TryNode, FinallyNode);
//		if(ParsedTree.HasNodeAt(GreenTeaConsts.CatchVariable)) {
//			ZenSyntaxTree CatchTree = ParsedTree.GetSyntaxTreeAt(GreenTeaConsts.CatchVariable);
//			/*local*/String CatchName = CatchTree.GetSyntaxTreeAt(GreenTeaConsts.VarDeclName).KeyToken.ParsedText;
//			/*local*/ZenType CatchType = CatchTree.GetSyntaxTreeAt(GreenTeaConsts.VarDeclType).GetParsedType();
//			//FIXME we need to add CatchName into LocalVariable
//			/*local*/ZenNode BodyNode = ParsedTree.TypeCheckAt(GreenTeaConsts.CatchBody, Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//			Node.Append(Gamma.Generator.CreateCatchNode(ZenStaticTable.VoidType, ParsedTree, CatchType, CatchName, BodyNode));
//		}
//		return Node;
//	}

//	// throw $Expr$
//	public static ZenSyntaxTree ParseThrow(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree ThrowTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "throw");
//		ThrowTree.SetMatchedPatternAt(GreenTeaConsts.ReturnExpr, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//		return ThrowTree;
//	}
//
//	public static ZenNode TypeThrow(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		ParsedTree.NextTree = null;
//		/*local*/ZenType FaultType = ContextType; // FIXME Gamma.FaultType;
//		/*local*/ZenNode ExprNode = ParsedTree.TypeCheckAt(GreenTeaConsts.ReturnExpr, Gamma, FaultType, GreenTeaConsts.DefaultTypeCheckPolicy);
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
//		return Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.StringType, ParsedTree, ZenStaticTable.FormatFileLineNumber(ParsedTree.KeyToken.FileLine));
//	}
//
//	public static ZenSyntaxTree ParseSymbols(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		return TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "__").ToConstTree(NameSpace);
//	}

//	public static ZenSyntaxTree ParseSuper(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree Tree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "super");
//		/*local*/int ParseFlag = TokenContext.SetSkipIndent(true);
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
//		/*local*/ZenSyntaxTree NewTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "new");
//		NewTree.SetMatchedPatternAt(0, NameSpace, TokenContext, "$Type$", GreenTeaConsts.Optional);
//		if(!NewTree.HasNodeAt(0)) {
//			NewTree.SetSyntaxTreeAt(0, NewTree.CreateConstTree(ZenStaticTable.VarType)); // TODO
//		}
//		/*local*/int ParseFlag = TokenContext.SetSkipIndent(true);
//		NewTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "(", GreenTeaConsts.Required);
//		if(!TokenContext.MatchToken(")")) {
//			while(!NewTree.IsMismatchedOrError()) {
//				NewTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//				if(TokenContext.MatchToken(")")) {
//					break;
//				}
//				NewTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ",", GreenTeaConsts.Required);
//			}
//		}
//		TokenContext.SetRememberFlag(ParseFlag);
//		return NewTree;
//	}

//	// switch
//	public static ZenSyntaxTree ParseEnum(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/String EnumTypeName = null;
//		/*local*/ZenType NewEnumType = null;
//		/*local*/ZenMap EnumMap = new ZenMap();
//		/*local*/ZenSyntaxTree EnumTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "enum");
//		EnumTree.SetMatchedPatternAt(GreenTeaConsts.EnumNameTreeIndex, NameSpace, TokenContext, "$FuncName$", GreenTeaConsts.Required);  // $ClassName$ is better
//		if(!EnumTree.IsMismatchedOrError()) {
//			EnumTypeName = EnumTree.GetSyntaxTreeAt(GreenTeaConsts.EnumNameTreeIndex).KeyToken.ParsedText;
//			NewEnumType = ZenStaticTable.EnumBaseType.CreateSubType(GreenTeaConsts.EnumType, EnumTypeName, null, EnumMap);
//		}
//		EnumTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "{", GreenTeaConsts.Required);
//		/*local*/int EnumValue = 0;
//		/*local*/ArrayList<ZenToken> NameList = new ArrayList<ZenToken>();
//		while(!EnumTree.IsMismatchedOrError()) {
//			TokenContext.SkipIndent();
//			if(TokenContext.MatchToken(",")) {
//				continue;
//			}
//			if(TokenContext.MatchToken("}")) {
//				break;
//			}
//			/*local*/ZenToken Token = TokenContext.Next();
//			if(LibZen.IsVariableName(Token.ParsedText, 0)) {
//				if(EnumMap.GetOrNull(Token.ParsedText) != null) {
//					NameSpace.Context.ReportError(GreenTeaConsts.ErrorLevel, Token, "duplicated name: " + Token.ParsedText);
//					continue;
//				}
//				NameList.add(Token);
//				EnumMap.put(Token.ParsedText, new GreenTeaEnum(NewEnumType, EnumValue, Token.ParsedText));
//				EnumValue += 1;
//				continue;
//			}
//		}
//		if(!EnumTree.IsMismatchedOrError()) {
//			/*local*/ZenNameSpace StoreNameSpace = NameSpace.GetNameSpace(KonohaGrammar.ParseNameSpaceFlag(0, TokenContext.ParsingAnnotation));
//			StoreNameSpace.AppendTypeName(NewEnumType, EnumTree.GetSyntaxTreeAt(GreenTeaConsts.EnumNameTreeIndex).KeyToken);
//			for(/*local*/int i = 0; i < LibZen.ListSize(NameList); i = i + 1) {
//				/*local*/String Key = NameList.get(i).ParsedText;
//				StoreNameSpace.SetSymbol(GreenTeaUtils.ClassStaticSymbol(NewEnumType, Key), EnumMap.GetOrNull(Key), NameList.get(i));
//			}
//			EnumTree.ParsedValue = NewEnumType;
//		}
//		return EnumTree;
//	}
//
//	public static ZenNode TypeEnum(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/Object EnumType = ParsedTree.ParsedValue;
//		return Gamma.Generator.CreateConstNode_OLD(ZenStaticTable.GuessType(EnumType), ParsedTree, EnumType);
//	}
//
//	public static ZenSyntaxTree ParseCaseBlock(ZenNameSpace ParentNameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree PrevTree = null;
//		/*local*/ZenNameSpace NameSpace = ParentNameSpace.CreateSubNameSpace();
//		/*local*/boolean IsCaseBlock = TokenContext.MatchToken("{"); // case EXPR : {}
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
//			/*local*/ZenMap Annotation = TokenContext.SkipAndGetAnnotation(true);
//			/*local*/ZenSyntaxTree CurrentTree = TokenContext.ParsePattern_OLD(NameSpace, "$Expression$", GreenTeaConsts.Required);
//			if(GreenTeaUtils.IsMismatchedOrError(CurrentTree)) {
//				return CurrentTree;
//			}
//			CurrentTree.SetAnnotation(Annotation);
//			PrevTree = GreenTeaUtils.LinkTree(PrevTree, CurrentTree);
//		}
//		if(PrevTree == null) {
//			return TokenContext.ParsePattern_OLD(NameSpace, "$Empty$", GreenTeaConsts.Required);
//		}
//		return GreenTeaUtils.TreeHead(PrevTree);
//	}
//
//	public static ZenSyntaxTree ParseSwitch(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree SwitchTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "switch");
//		SwitchTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "(", GreenTeaConsts.Required | GreenTeaConsts.OpenSkipIndent);
//		SwitchTree.SetMatchedPatternAt(GreenTeaConsts.SwitchCaseCondExpr, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//		SwitchTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ")", GreenTeaConsts.Required | GreenTeaConsts.CloseSkipIndent);
//		SwitchTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "{", GreenTeaConsts.Required);
//
//		/*local*/int CaseIndex = GreenTeaConsts.SwitchCaseCaseIndex;
//		/*local*/int ParseFlag = TokenContext.SetSkipIndent(true);
//		while(!SwitchTree.IsMismatchedOrError() && !TokenContext.MatchToken("}")) {
//			if(TokenContext.MatchToken("case")) {
//				SwitchTree.SetMatchedPatternAt(CaseIndex, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//				SwitchTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ":", GreenTeaConsts.Required);
//				SwitchTree.SetMatchedPatternAt(CaseIndex + 1, NameSpace, TokenContext, "$CaseBlock$", GreenTeaConsts.Required);
//				CaseIndex += 2;
//				continue;
//			}
//			if(TokenContext.MatchToken("default")) {
//				SwitchTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ":", GreenTeaConsts.Required);
//				SwitchTree.SetMatchedPatternAt(GreenTeaConsts.SwitchCaseDefaultBlock, NameSpace, TokenContext, "$CaseBlock$", GreenTeaConsts.Required);
//			}
//		}
//		TokenContext.SetRememberFlag(ParseFlag);
//		return SwitchTree;
//	}
//
//	public static ZenNode TypeSwitch(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenNode CondNode = ParsedTree.TypeCheckAt(GreenTeaConsts.IfCond, Gamma, ZenStaticTable.VarType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		/*local*/ZenNode DefaultNode = null;
//		if(ParsedTree.HasNodeAt(GreenTeaConsts.SwitchCaseDefaultBlock)) {
//			DefaultNode = ParsedTree.TypeCheckAt(GreenTeaConsts.SwitchCaseDefaultBlock, Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		}
//		/*local*/ZenNode Node = Gamma.Generator.CreateSwitchNode(ZenStaticTable.VoidType, ParsedTree, CondNode, DefaultNode);
//		for(/*local*/int CaseIndex = GreenTeaConsts.SwitchCaseCaseIndex; CaseIndex < ParsedTree.SubTreeList.size(); CaseIndex += 2) {
//			/*local*/ZenNode CaseExpr  = ParsedTree.TypeCheckAt(CaseIndex, Gamma, CondNode.Type, GreenTeaConsts.DefaultTypeCheckPolicy);
//			/*local*/ZenNode CaseBlock = null;
//			if(ParsedTree.HasNodeAt(CaseIndex+1)) {
//				CaseBlock = ParsedTree.TypeCheckAt(CaseIndex+1, Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//			}
//			Node.Append(CaseExpr);
//			Node.Append(CaseBlock);
//		}
//		return Node;
//	}



//	// Array
//	public static ZenSyntaxTree ParseNewArray(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree ArrayTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "new");
//		ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Type$", GreenTeaConsts.Required);
//		while(TokenContext.HasNext() && ArrayTree.IsValidSyntax()) {
//			ArrayTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "[", GreenTeaConsts.Required);
//			ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//			ArrayTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "]", GreenTeaConsts.Required);
//			if(!TokenContext.IsToken("[")) {
//				break;
//			}
//		}
//		return ArrayTree;
//	}
//
//	public static ZenNode TypeNewArray(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenType ArrayType = ParsedTree.GetSyntaxTreeAt(0).GetParsedType();
//		/*local*/ZenNode ArrayNode = Gamma.Generator.CreateNewArrayNode(ZenStaticTable.ArrayType, ParsedTree);
//		for(/*local*/int i = 1; i < LibZen.ListSize(ParsedTree.SubTreeList); i = i + 1) {
//			/*local*/ZenNode Node = ParsedTree.TypeCheckAt(i, Gamma, ZenStaticTable.IntType, GreenTeaConsts.DefaultTypeCheckPolicy);
//			if(Node.IsErrorNode()) {
//				return Node;
//			}
//			ArrayType = ZenStaticTable.GetGenericType1(ZenStaticTable.ArrayType, ArrayType, true);
//			ArrayNode.Append(Node);
//		}
//		ArrayNode.Type = ArrayType;
//		return ArrayNode;
//	}
//
//	public static ZenSyntaxTree ParseArray(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/int OldFlag = TokenContext.SetSkipIndent(true);
//		/*local*/ZenSyntaxTree ArrayTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "[");
//		while(TokenContext.HasNext() && ArrayTree.IsValidSyntax()) {
//			if(TokenContext.MatchToken("]")) {
//				break;
//			}
//			if(TokenContext.MatchToken(",")) {
//				continue;
//			}
//			ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//		}
//		TokenContext.SetRememberFlag(OldFlag);
//		return ArrayTree;
//	}
//
//	public static ZenNode TypeArray(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenNode ArrayNode = Gamma.Generator.CreateArrayLiteralNode(ZenStaticTable.ArrayType, ParsedTree);
//		/*local*/ZenType ElemType = ZenStaticTable.VarType;
//		if(ContextType.IsArrayType()) {
//			ElemType = ContextType.TypeParams[0];
//			ArrayNode.Type = ContextType;
//		}
//		for(/*local*/int i = 0; i < LibZen.ListSize(ParsedTree.SubTreeList); i = i + 1) {
//			/*local*/ZenNode Node = ParsedTree.TypeCheckAt(i, Gamma, ElemType, GreenTeaConsts.DefaultTypeCheckPolicy);
//			if(Node.IsErrorNode()) {
//				return Node;
//			}
//			if(ElemType.IsVarType()) {
//				ElemType = Node.Type;
//				ArrayNode.Type = ZenStaticTable.GetGenericType1(ZenStaticTable.ArrayType, ElemType, true);
//			}
//			ArrayNode.Append(Node);
//		}
//		if(ElemType.IsVarType()) {
//			ArrayNode.Type = ZenStaticTable.GetGenericType1(ZenStaticTable.ArrayType, ZenStaticTable.AnyType, true);
//		}
//		return ArrayNode;
//	}
//
//	public static ZenSyntaxTree ParseSize(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree ArrayTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "|");
//		ArrayTree.SetMatchedPatternAt(GreenTeaConsts.UnaryTerm, NameSpace, TokenContext, "$SuffixExpression$", GreenTeaConsts.Required);
//		ArrayTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "|", GreenTeaConsts.Required);
//		return ArrayTree;
//	}
//
//	public static ZenNode TypeSize(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenNode ExprNode = ParsedTree.TypeCheckAt(GreenTeaConsts.UnaryTerm, Gamma, ZenStaticTable.VarType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		if(ExprNode.IsErrorNode()) {
//			return ExprNode;
//		}
//		/*local*/ZenFuncSet FuncSet = Gamma.NameSpace.GetMethod(ExprNode.Type, GreenTeaUtils.FuncSymbol("||"), true);
//		//System.err.println("polyfunc: " + FuncSet);
//		/*local*/ZenFunc Func = FuncSet.ResolveUnaryMethod(Gamma, ExprNode.Type);
//		LibZen.Assert(Func != null);  // any has ||
//		Gamma.CheckFunc("operator", Func, ParsedTree.KeyToken);
//		ZenNode Node = Gamma.Generator.CreateApplySymbolNode(Func.GetReturnType(), ParsedTree, GreenTeaUtils.FuncSymbol("||"), Func);
//		Node.Append(ExprNode);
//		if(Node instanceof ZenSymbolNode) {
//			((/*cast*/ZenSymbolNode)Node).ResolvedFunc = Func;
//		}
//		return Node;
//	}
//
//	public static ZenSyntaxTree ParseIndexer(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree ArrayTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "[");
//		ArrayTree.AppendParsedTree2(LeftNode);
//		/*local*/int OldFlag = TokenContext.SetSkipIndent(true);
//		do {
//			ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//		}
//		while(!ArrayTree.IsMismatchedOrError() && TokenContext.MatchToken(","));
//		ArrayTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "]", GreenTeaConsts.Required);
//		TokenContext.SetRememberFlag(OldFlag);
//		/*local*/String OperatorSymbol = "[]";
//		if(TokenContext.MatchToken("=")) {
//			ArrayTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Required);
//			OperatorSymbol = "[]=";
//		}
//		if(ArrayTree.IsValidSyntax()) {
//			ArrayTree.KeyToken.ParsedText = OperatorSymbol;
//		}
//		return ArrayTree;
//	}
//
//	public static ZenNode TypeIndexer(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType Type) {
//		/*local*/ZenNode RecvNode = ParsedTree.TypeCheckAt(GreenTeaConsts.LeftHandTerm, Gamma, ZenStaticTable.VarType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		if(!RecvNode.IsErrorNode()) {
//			/*local*/String MethodName = ParsedTree.KeyToken.ParsedText;
//			/*local*/ZenResolvedFunc ResolvedFunc = null;
//			/*local*/ZenFuncSet FuncSet = ParsedTree.NameSpace.GetMethod(RecvNode.Type, GreenTeaUtils.FuncSymbol(MethodName), true);
//			//System.err.println("polyfunc: " + FuncSet);
//			/*local*/ArrayList<ZenNode> ParamList = new ArrayList<ZenNode>();
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
//		/*local*/ZenSyntaxTree SliceTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "[");
//		SliceTree.AppendParsedTree2(LeftNode);
//		SliceTree.SetMatchedPatternAt(1, NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Optional);
//		if(!SliceTree.HasNodeAt(1)) {
//			SliceTree.SetSyntaxTreeAt(1, SliceTree.CreateConstTree(0L)); // s[:x]
//		}
//		SliceTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, ":", GreenTeaConsts.Required);
//		SliceTree.AppendMatchedPattern(NameSpace, TokenContext, "$Expression$", GreenTeaConsts.Optional);
//		SliceTree.SetMatchedTokenAt(GreenTeaConsts.NoWhere, NameSpace, TokenContext, "]", GreenTeaConsts.Required);
//		return SliceTree;
//	}
//
//	public static ZenNode TypeSlice(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
//		/*local*/ZenNode RecvNode = ParsedTree.TypeCheckAt(GreenTeaConsts.LeftHandTerm, Gamma, ZenStaticTable.VarType, GreenTeaConsts.DefaultTypeCheckPolicy);
//		if(!RecvNode.IsErrorNode()) {
//			return KonohaGrammar.TypeMethodNameCall(Gamma, ParsedTree, RecvNode, "[:]", ContextType);
//		}
//		return RecvNode;
//	}

	// ClassDecl
//	private static boolean TypeFieldDecl(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenClassField ClassField) {
//		/*local*/int    FieldFlag = KonohaGrammar.ParseVarFlag(0, ParsedTree.Annotation);
//		/*local*/ZenType DeclType = ParsedTree.GetSyntaxTreeAt(GreenTeaConsts.VarDeclType).GetParsedType();
//		/*local*/String FieldName = ParsedTree.GetSyntaxTreeAt(GreenTeaConsts.VarDeclName).KeyToken.ParsedText;
//		/*local*/ZenNode InitValueNode = null;
//		/*local*/Object InitValue = null;
//		if(ParsedTree.HasNodeAt(GreenTeaConsts.VarDeclValue)) {
//			InitValueNode = ParsedTree.TypeCheckAt(GreenTeaConsts.VarDeclValue, Gamma, DeclType, GreenTeaConsts.OnlyConstPolicy | GreenTeaConsts.NullablePolicy);
//			if(InitValueNode.IsErrorNode()) {
//				return false;
//			}
//			InitValue = InitValueNode.ToConstValue(Gamma.Context, true);
//		}
//		if(GreenTeaConsts.UseLangStat) {
//			Gamma.Context.Stat.VarDecl += 1;
//		}/*EndOfStat*/
//		if(DeclType.IsVarType()) {
//			if(InitValueNode == null) {
//				DeclType = ZenStaticTable.AnyType;
//			}
//			else {
//				DeclType = InitValueNode.Type;
//			}
//			Gamma.ReportTypeInference(ParsedTree.KeyToken, FieldName, DeclType);
//			if(GreenTeaConsts.UseLangStat) {
//				Gamma.Context.Stat.VarDeclInfer += 1;
//				if(DeclType.IsAnyType()) {
//					Gamma.Context.Stat.VarDeclInferAny += 1;
//				}
//			}/*EndOfStat*/
//		}
//		if(GreenTeaConsts.UseLangStat) {
//			if(DeclType.IsAnyType()) {
//				Gamma.Context.Stat.VarDeclAny += 1;
//			}
//		}/*EndOfStat*/
//		if(InitValueNode == null) {
//			InitValue = DeclType.DefaultNullValue;
//		}
//		ClassField.CreateField(FieldFlag, DeclType, FieldName, ParsedTree.GetSyntaxTreeAt(GreenTeaConsts.VarDeclName).KeyToken, InitValue);
//		return true;
//	}
//
//	public static ZenSyntaxTree ParseClassDecl2(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
//		/*local*/ZenSyntaxTree ClassDeclTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "class");
//		ClassDeclTree.SetMatchedPatternAt(GreenTeaConsts.ClassDeclName, NameSpace, TokenContext, "$FuncName$", GreenTeaConsts.Required); //$ClassName$ is better
//		if(TokenContext.MatchToken("extends")) {
//			ClassDeclTree.SetMatchedPatternAt(GreenTeaConsts.ClassDeclSuperType, NameSpace, TokenContext, "$Type$", GreenTeaConsts.Required);
//		}
//		if(ClassDeclTree.IsMismatchedOrError()) {
//			return ClassDeclTree;
//		}
//		// define new class
//		/*local*/ZenNameSpace ClassNameSpace = new ZenNameSpace(NameSpace.Context, NameSpace);
//		/*local*/ZenToken NameToken = ClassDeclTree.GetSyntaxTreeAt(GreenTeaConsts.ClassDeclName).KeyToken;
//		/*local*/ZenType SuperType = ZenStaticTable.TopType;
//		if(ClassDeclTree.HasNodeAt(GreenTeaConsts.ClassDeclSuperType)) {
//			SuperType = ClassDeclTree.GetSyntaxTreeAt(GreenTeaConsts.ClassDeclSuperType).GetParsedType();
//		}
//		/*local*/int ClassFlag = KonohaGrammar.ParseClassFlag(0, TokenContext.ParsingAnnotation);
//		/*local*/String ClassName = NameToken.ParsedText;
//		/*local*/ZenType DefinedType = NameSpace.GetType(ClassName);
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
//		ClassDeclTree.SetMatchedPatternAt(GreenTeaConsts.ClassDeclBlock, ClassNameSpace, TokenContext, "$Block$", GreenTeaConsts.Optional);
//		if(ClassDeclTree.HasNodeAt(GreenTeaConsts.ClassDeclBlock)) {
//			/*local*/ZenClassField ClassField = new ZenClassField(DefinedType, NameSpace);
//			/*local*/ZenTypeEnv Gamma = new ZenTypeEnv(ClassNameSpace);
//			/*local*/ZenSyntaxTree SubTree = ClassDeclTree.GetSyntaxTreeAt(GreenTeaConsts.ClassDeclBlock);
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
//		/*local*/ZenClassField ClassField = (/*cast*/ZenClassField)ParsedTree.ParsedValue;
//		if(ClassField != null) {
//			/*local*/ZenType DefinedType = ClassField.DefinedType;
//			DefinedType.SetClassField(ClassField);
//			Gamma.Generator.OpenClassField(ParsedTree, DefinedType, ClassField);
//			/*local*/ZenSyntaxTree SubTree = ParsedTree.GetSyntaxTreeAt(GreenTeaConsts.ClassDeclBlock);
//			/*local*/ArrayList<ZenFunc> MemberList = new ArrayList<ZenFunc>();
//			while(SubTree != null) {
//				if(SubTree.Pattern.EqualsName("$FuncDecl$") || SubTree.Pattern.EqualsName("$Constructor2$")) {
//					MemberList.add((/*cast*/ZenFunc)SubTree.ParsedValue);
//				}
//				if(!SubTree.Pattern.EqualsName("$VarDecl$")) {
//					SubTree.TypeCheck(Gamma, ZenStaticTable.VoidType, GreenTeaConsts.DefaultTypeCheckPolicy);
//				}
//				SubTree = SubTree.NextTree;
//			}
//			Gamma.Generator.CloseClassField(DefinedType, MemberList);
//		}
//		return Gamma.Generator.CreateEmptyNode(ZenStaticTable.VoidType);
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
//		/*local*/ZenFunc MatchUnary     = LibNative.LoadMatchFunc(Grammar, "MatchUnary");
//		/*local*/ZenFunc MatchBinary    = LibNative.LoadMatchFunc(Grammar, "MatchBinary");
////		/*local*/ZenFunc  MatchConst      = LibNative.LoadMatchFunc(Grammar, "MatchConst");
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
//		NameSpace.AppendExtendedSyntax("=", ZenPrecedence.CStyleAssign | GreenTeaConsts.LeftJoin, MatchBinary);
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
