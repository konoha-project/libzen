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
import java.util.ArrayList;

import zen.ast.ZenAndNode;
import zen.ast.ZenAnnotationNode;
import zen.ast.ZenApplyNode;
import zen.ast.ZenArrayLiteralNode;
import zen.ast.ZenBinaryNode;
import zen.ast.ZenBlockNode;
import zen.ast.ZenBooleanNode;
import zen.ast.ZenBreakNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenConstNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFloatNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionLiteralNode;
import zen.ast.ZenGetIndexNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenGetterNode;
import zen.ast.ZenGroupNode;
import zen.ast.ZenIfNode;
import zen.ast.ZenInstanceOfNode;
import zen.ast.ZenIntNode;
import zen.ast.ZenMapLiteralNode;
import zen.ast.ZenMethodCallNode;
import zen.ast.ZenNode;
import zen.ast.ZenNotNode;
import zen.ast.ZenNullNode;
import zen.ast.ZenOrNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenSetIndexNode;
import zen.ast.ZenSetterNode;
import zen.ast.ZenStringNode;
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenTypeNode;
import zen.ast.ZenUnaryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast.ZenWhileNode;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.parser.ZenLogger;
import zen.parser.ZenNameSpace;
import zen.parser.ZenNodeUtils;
import zen.parser.ZenParserConst;
import zen.parser.ZenSyntaxPattern;
import zen.parser.ZenToken;
import zen.parser.ZenTokenContext;

//endif VAJA

public class ZenGrammar {
	// Token
	public static long WhiteSpaceToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		TokenContext.FoundWhiteSpace();
		for(; pos < SourceText.length(); pos += 1) {
			@Var char ch = LibZen.CharAt(SourceText, pos);
			if(ch == '\n' || !LibZen.IsWhitespace(SourceText, pos)) {
				break;
			}
		}
		return pos;
	}

	public static long IndentToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		@Var long LineStart = pos + 1;
		TokenContext.FoundLineFeed(1);
		for(pos = pos + 1; pos < SourceText.length(); pos += 1) {
			if(!LibZen.IsWhitespace(SourceText, pos)) {
				break;
			}
			if(LibZen.CharAt(SourceText, pos) == '\n') {
				TokenContext.FoundLineFeed(1);
			}
		}
		@Var String Text = "";
		if(LineStart < pos) {
			Text = LibZen.SubString(SourceText, LineStart, pos);
		}
		TokenContext.AppendParsedToken(Text, ZenParserConst.IndentTokenFlag, null);
		return pos;
	}

	public static long SemiColonToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		TokenContext.AppendParsedToken(LibZen.SubString(SourceText, pos, (pos+1)), ZenParserConst.DelimTokenFlag, null);
		return pos+1;
	}

	public static long SymbolToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		@Var long start = pos;
		@Var String PresetPattern = null;
		for(; pos < SourceText.length(); pos += 1) {
			if(!LibZen.IsVariableName(SourceText, pos) && !LibZen.IsDigit(SourceText, pos)) {
				break;
			}
		}
		TokenContext.AppendParsedToken(LibZen.SubString(SourceText, start, pos), ZenParserConst.NameSymbolTokenFlag, PresetPattern);
		return pos;
	}

	public static long OperatorToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		@Var long NextPos = pos + 1;
		for(; NextPos < SourceText.length(); NextPos += 1) {
			if(LibZen.IsWhitespace(SourceText, NextPos) || LibZen.IsLetter(SourceText, NextPos) || LibZen.IsDigit(SourceText, NextPos)) {
				break;
			}
		}
		@Var boolean Matched = false;
		while(NextPos > pos) {
			@Var String Sub = LibZen.SubString(SourceText, pos, NextPos);
			@Var ZenSyntaxPattern Pattern = TokenContext.TopLevelNameSpace.GetExtendedSyntaxPattern(Sub);
			if(Pattern != null) {
				Matched = true;
				break;
			}
			NextPos -= 1;
		}
		// FIXME
		if(Matched == false) {
			NextPos = pos + 1;
		}
		TokenContext.AppendParsedToken(LibZen.SubString(SourceText, pos, NextPos), 0, null);
		return NextPos;
	}

	public static long CommentToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		@Var long NextPos = pos + 1;
		@Var char NextChar = LibZen.CharAt(SourceText, NextPos);
		if(NextChar != '/' && NextChar != '*') {
			return ZenParserConst.MismatchedPosition;
		}
		if(NextChar == '*') { // MultiLineComment
			// SourceMap ${file:line}
			if(LibZen.CharAt(SourceText, NextPos+1) == '$' && LibZen.CharAt(SourceText, NextPos+2) == '{') {
				@Var long StartPos = NextPos + 3;
				NextPos += 3;
				while(NextChar != 0) {
					NextChar = LibZen.CharAt(SourceText, NextPos);
					if(NextChar == '}') {
						TokenContext.SetSourceMap(LibZen.SubString(SourceText, StartPos, NextPos));
						break;
					}
					if(NextChar == '\n' || NextChar == '*') {
						break;  // stop
					}
					NextPos += 1;
				}
			}
			@Var int Level = 1;
			@Var char PrevChar = '0';
			for(; NextPos < SourceText.length(); NextPos += 1) {
				NextChar = LibZen.CharAt(SourceText, NextPos);
				if(NextChar == '/' && PrevChar == '*') {
					if(Level == 1) {
						return NextPos + 1;
					}
					Level = Level - 1;
				}
				if(Level > 0) {
					if(NextChar == '*' && PrevChar == '/') {
						Level = Level + 1;
					}
				}
				PrevChar = NextChar;
			}
		}
		else if(NextChar == '/') { // SingleLineComment
			for(; NextPos < SourceText.length(); NextPos += 1) {
				NextChar = LibZen.CharAt(SourceText, NextPos);
				if(NextChar == '\n') {
					break;
				}
			}
			return ZenGrammar.IndentToken(TokenContext, SourceText, NextPos);
		}
		return ZenParserConst.MismatchedPosition;
	}

	public static long NumberLiteralToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		@Var long start = pos;
		@Var long LastMatchedPos = pos;
		for(; pos < SourceText.length(); pos += 1) {
			if(!LibZen.IsDigit(SourceText, pos)) {
				break;
			}
		}
		LastMatchedPos = pos;
		@Var char ch = LibZen.CharAt(SourceText, pos);
		if(ch != '.' && ch != 'e' && ch != 'E') {
			TokenContext.AppendParsedToken(LibZen.SubString(SourceText, start, pos), 0, "$IntegerLiteral$");
			return pos;
		}
		if(ch == '.') {
			pos += 1;
			for(; pos < SourceText.length(); pos += 1) {
				if(!LibZen.IsDigit(SourceText, pos)) {
					break;
				}
			}
		}
		ch = LibZen.CharAt(SourceText, pos);
		if(ch == 'e' || ch == 'E') {
			pos += 1;
			ch = LibZen.CharAt(SourceText, pos);
			if(ch == '+' || ch == '-') {
				pos += 1;
				ch = LibZen.CharAt(SourceText, pos);
			}
			@Var long saved = pos;
			for(; pos < SourceText.length(); pos += 1) {
				if(!LibZen.IsDigit(SourceText, pos)) {
					break;
				}
			}
			if(saved == pos) {
				pos = LastMatchedPos;
			}
		}
		TokenContext.AppendParsedToken(LibZen.SubString(SourceText, start, pos), 0, "$FloatLiteral$");
		return pos;
	}

	//	public static long CharLiteralToken(ZenTokenContext TokenContext, String SourceText, long pos) {
	//		@Var long start = pos;
	//		@Var char prev = '\'';
	//		pos = pos + 1; // eat "\'"
	//		for(; pos < SourceText.length(); pos += 1) {
	//			@Var char ch = LibZen.CharAt(SourceText, pos);
	//			if(ch == '\'' && prev != '\\') {
	//				TokenContext.AddNewToken(LibZen.SubString(SourceText, start, (pos + 1)), GreenTeaConsts.QuotedTokenFlag, "$CharLiteral$");
	//				return pos + 1;
	//			}
	//			if(ch == '\n') {
	//				TokenContext.ReportTokenError1(GreenTeaConsts.ErrorLevel, "expected ' to close the charctor literal", LibZen.SubString(SourceText, start, pos));
	//				TokenContext.FoundLineFeed(1);
	//				return pos;
	//			}
	//			prev = ch;
	//		}
	//		TokenContext.ReportTokenError1(GreenTeaConsts.ErrorLevel, "expected ' to close the charctor literal", LibZen.SubString(SourceText, start, pos));
	//		return pos;
	//	}

	private static long SkipBackSlashOrNewLineOrDoubleQuote( String SourceText, long pos) {
		for(; pos < SourceText.length(); pos += 1) {
			@Var char ch = LibZen.CharAt(SourceText, pos);
			if(ch == '\\' || ch == '\n' || ch == '"') {
				return pos;
			}
		}
		return pos;
	}

	public static long StringLiteralToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		@Var long start = pos;
		pos = pos + 1; // eat "\""
		for(; pos < SourceText.length(); pos += 1) {
			pos = ZenGrammar.SkipBackSlashOrNewLineOrDoubleQuote(SourceText, pos);
			@Var char ch = LibZen.CharAt(SourceText, pos);
			if(ch == '\\') {
				if(pos + 1 < SourceText.length()) {
					@Var char NextChar = LibZen.CharAt(SourceText, pos + 1);
					if(NextChar == 'u') { // \u12345
						pos += 2; // skip "\\" "u"
						for(; pos < SourceText.length(); pos += 1) {
							if(!LibZen.IsDigit(SourceText, pos)) {
								break;
							}
						}
						ch = LibZen.CharAt(SourceText, pos);
					}
					else {
						pos += 1; // skip "\\"
					}
				}
			}
			if(ch == '"') {
				TokenContext.AppendParsedToken(LibZen.SubString(SourceText, start, (pos + 1)), ZenParserConst.QuotedTokenFlag, "$StringLiteral$");
				return pos + 1;
			}
			if(ch == '\n') {
				TokenContext.ReportTokenError1(ZenLogger.ErrorLevel, "expected \" to close the string literal", LibZen.SubString(SourceText, start, pos));
				TokenContext.FoundLineFeed(1);
				return pos;
			}
		}
		TokenContext.ReportTokenError1(ZenLogger.ErrorLevel, "expected \" to close the string literal", LibZen.SubString(SourceText, start, pos));
		return pos;
	}

	// Match

	public static ZenNode MatchNull(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		return new ZenNullNode(TokenContext.GetTokenAndMoveForward());
	}

	public static ZenNode MatchTrue(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		return new ZenBooleanNode(TokenContext.GetTokenAndMoveForward(), true);
	}

	public static ZenNode MatchFalse(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		return new ZenBooleanNode(TokenContext.GetTokenAndMoveForward(), false);
	}

	public static ZenNode MatchIntLiteral(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward();
		return new ZenIntNode(Token, LibZen.ParseInt(Token.ParsedText));
	}

	public static ZenNode MatchFloatLiteral(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward();
		return new ZenFloatNode(Token, LibZen.ParseFloat(Token.ParsedText));
	}

	public static ZenNode MatchStringLiteral(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward();
		return new ZenStringNode(Token, LibZen.UnquoteString(Token.ParsedText));
	}

	public static ZenNode MatchArrayLiteral(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode LiteralNode = new ZenArrayLiteralNode();
		if(!TokenContext.MatchToken("]")) {
			while(TokenContext.HasNext()) {
				LiteralNode = TokenContext.AppendMatchedPattern(LiteralNode, NameSpace, "$Expression$", ZenParserConst.Required);
				if(LiteralNode.IsErrorNode() || TokenContext.MatchToken("]")) {
					break;
				}
				LiteralNode = TokenContext.MatchNodeToken(LiteralNode, NameSpace, ",", ZenParserConst.Required);
				if(LiteralNode.IsErrorNode() || TokenContext.MatchToken("]")) {
					break;
				}
			}
		}
		return LiteralNode;
	}

	public static ZenNode MatchMapLiteral(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode LiteralNode = new ZenMapLiteralNode();
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward(); /* "{" */
		LiteralNode.SourceToken = Token;
		if(!TokenContext.MatchToken("}")) {
			while(TokenContext.HasNext()) {
				LiteralNode = TokenContext.AppendMatchedPattern(LiteralNode, NameSpace, "$Expression$", ZenParserConst.Required);
				LiteralNode = TokenContext.MatchNodeToken(LiteralNode, NameSpace, ":", ZenParserConst.Required);
				LiteralNode = TokenContext.AppendMatchedPattern(LiteralNode, NameSpace, "$Expression$", ZenParserConst.Required);
				if(LiteralNode.IsErrorNode() || TokenContext.MatchToken("}")) {
					break;
				}
				LiteralNode = TokenContext.MatchNodeToken(LiteralNode, NameSpace, ",", ZenParserConst.Required);
				if(LiteralNode.IsErrorNode() || TokenContext.MatchToken("}")) {
					break;
				}
			}
		}
		return LiteralNode;
	}

	public static ZenNode MatchType(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward();
		@Var ZenType Type = NameSpace.GetType(Token.ParsedText);
		if(Type != null) {
			ZenNode TypeNode = new ZenTypeNode(Token, Type);
			assert(TypeNode.Type != null);
			return TokenContext.ParsePatternAfter(NameSpace, TypeNode, "$TypeSuffix$", ZenParserConst.Optional);
		}
		return null; // Not Matched
	}

	public static ZenNode MatchTypeSuffix(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode TypeNode) {
		if(TypeNode.Type.GetParamSize() > 0) {
			if(TokenContext.MatchToken("<")) {  // Generics
				@Var ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
				while(!TokenContext.StartsWithToken(">")) {
					if(TypeList.size() > 0 && !TokenContext.MatchToken(",")) {
						return null;
					}
					@Var ZenTypeNode ParamTypeNode = (ZenTypeNode) TokenContext.ParsePattern(NameSpace, "$Type$", ZenParserConst.Optional);
					if(ParamTypeNode == null) {
						return TypeNode;
					}
					TypeList.add(ParamTypeNode.Type);
				}
				TypeNode.Type = ZenSystem.GetGenericType(TypeNode.Type, 0, TypeList, true);
			}
		}
		while(TokenContext.MatchToken("[")) {  // Array
			if(!TokenContext.MatchToken("]")) {
				return null;
			}
			TypeNode.Type = ZenSystem.GetGenericType1(ZenSystem.ArrayType, TypeNode.Type, true);
		}
		return TypeNode;
	}

	public static ZenNode MatchSymbol(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward();
		if(!Token.IsNameSymbol()) {
			return TokenContext.CreateExpectedErrorNode(Token, "identifier");
		}
		@Var ZenNode AssignedNode = null;
		if(TokenContext.MatchToken("=")) {
			AssignedNode = TokenContext.ParsePattern(NameSpace, "$Expression$", ZenParserConst.Required);
			if(AssignedNode.IsErrorNode()) {
				return AssignedNode;
			}
		}
		@Var Object ConstValue = NameSpace.GetSymbol(Token.ParsedText);
		if(ConstValue instanceof ZenVarInfo) {
			ZenVarInfo Var = (ZenVarInfo) ConstValue;
			return NameSpace.Generator.CreateSymbolNode(Token, Var.VarType, Var.NativeName, AssignedNode);
		}
		if(ConstValue != null) {
			if(AssignedNode != null) {
				return new ZenErrorNode(Token, "cannot be assigned");
			}
			return ZenNodeUtils.CreateConstNode(Token, ConstValue);
		}
		return NameSpace.Generator.CreateSymbolNode(Token, ZenSystem.VarType, Token.ParsedText, AssignedNode);
	}

	// PatternName: "("  (1)
	public static ZenNode MatchGroup(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode GroupNode = new ZenGroupNode();
		GroupNode = TokenContext.MatchNodeToken(GroupNode, NameSpace, "(", ZenParserConst.Required | ZenParserConst.AllowSkipIndent);
		GroupNode = TokenContext.AppendMatchedPattern(GroupNode, NameSpace, "$Expression$", ZenParserConst.Required);
		GroupNode = TokenContext.MatchNodeToken(GroupNode, NameSpace, ")", ZenParserConst.Required | ZenParserConst.DisallowSkipIndent);
		return GroupNode;
	}

	public static ZenNode MatchCast(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode CastNode = new ZenCastNode(ZenSystem.VarType, null);
		CastNode = TokenContext.MatchNodeToken(CastNode, NameSpace, "(", ZenParserConst.Required | ZenParserConst.AllowSkipIndent);
		CastNode = TokenContext.AppendMatchedPattern(CastNode, NameSpace, "$Type$", ZenParserConst.Required);
		CastNode = TokenContext.MatchNodeToken(CastNode, NameSpace, ")", ZenParserConst.Required  | ZenParserConst.DisallowSkipIndent);
		CastNode = TokenContext.AppendMatchedPattern(CastNode, NameSpace, "$SuffixExpression$", ZenParserConst.Required);
		return CastNode;
	}

	public static ZenNode MatchGetter(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		TokenContext.MatchToken(".");
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward();
		if(!Token.IsNameSymbol()) {
			return TokenContext.CreateExpectedErrorNode(Token, "field name");
		}
		if(TokenContext.MatchToken("(")) {  // method call
			@Var ZenNode MethodCallNode = new ZenMethodCallNode(Token, LeftNode, Token.ParsedText);
			if(!TokenContext.MatchToken(")")) {
				while(!MethodCallNode.IsErrorNode()) {
					MethodCallNode = TokenContext.AppendMatchedPattern(MethodCallNode, NameSpace, "$Expression$", ZenParserConst.Required);
					if(TokenContext.MatchToken(")")) {
						break;
					}
					MethodCallNode = TokenContext.MatchNodeToken(MethodCallNode, NameSpace, ",", ZenParserConst.Required | ZenParserConst.DisallowSkipIndent);
				}
			}
			return MethodCallNode;
		}
		if(TokenContext.MatchToken("=")) {
			ZenNode SetterNode = new ZenSetterNode(Token, LeftNode, Token.ParsedText);
			SetterNode = TokenContext.AppendMatchedPattern(SetterNode, NameSpace, "$Expression$", ZenParserConst.Required);
			return SetterNode;
		}
		else {
			return new ZenGetterNode(Token, LeftNode, Token.ParsedText);
		}
	}

	public static ZenNode MatchApply(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode ApplyNode = new ZenApplyNode(LeftNode);
		ApplyNode = TokenContext.MatchNodeToken(ApplyNode, NameSpace, "(", ZenParserConst.Required | ZenParserConst.AllowSkipIndent);
		if(!TokenContext.MatchToken(")")) {
			while(!ApplyNode.IsErrorNode()) {
				ApplyNode = TokenContext.AppendMatchedPattern(ApplyNode, NameSpace, "$Expression$", ZenParserConst.Required);
				if(TokenContext.MatchToken(")")) {
					break;
				}
				ApplyNode = TokenContext.MatchNodeToken(ApplyNode, NameSpace, ",", ZenParserConst.Required | ZenParserConst.DisallowSkipIndent);
			}
		}
		return ApplyNode;
	}

	public static ZenNode MatchIndexer(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode IndexerNode = new ZenGetIndexNode(LeftNode);
		IndexerNode = TokenContext.MatchNodeToken(IndexerNode, NameSpace, "[", ZenParserConst.Required);
		IndexerNode = TokenContext.AppendMatchedPattern(IndexerNode, NameSpace, "$Expression$", ZenParserConst.Required);
		IndexerNode = TokenContext.MatchNodeToken(IndexerNode, NameSpace, "]", ZenParserConst.Required);
		if(TokenContext.MatchToken("=") && !IndexerNode.IsErrorNode()) {
			IndexerNode = new ZenSetIndexNode((ZenGetIndexNode)IndexerNode);
			IndexerNode = TokenContext.AppendMatchedPattern(IndexerNode, NameSpace, "$Expression$", ZenParserConst.Required);
		}
		return IndexerNode;
	}

	public static ZenNode MatchUnary(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode UnaryNode = new ZenUnaryNode(TokenContext.GetTokenAndMoveForward());
		return TokenContext.AppendMatchedPattern(UnaryNode, NameSpace, "$SuffixExpression$", ZenParserConst.Required);
	}

	public static ZenNode MatchNot(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode UnaryNode = new ZenNotNode(TokenContext.GetTokenAndMoveForward());
		UnaryNode = TokenContext.AppendMatchedPattern(UnaryNode, NameSpace, "$SuffixExpression$", ZenParserConst.Required);
		return UnaryNode;
	}

	public static ZenNode MatchBinary(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward();
		@Var ZenBinaryNode BinaryNode = new ZenBinaryNode(Token, LeftNode, NameSpace.GetExtendedSyntaxPattern(Token.ParsedText));
		return BinaryNode.AppendParsedRightNode(NameSpace, TokenContext);
	}

	public static ZenNode MatchComparator(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward();
		@Var ZenBinaryNode BinaryNode = new ZenComparatorNode(Token, LeftNode, NameSpace.GetExtendedSyntaxPattern(Token.ParsedText));
		return BinaryNode.AppendParsedRightNode(NameSpace, TokenContext);
	}

	public static ZenNode MatchSuffixExpression(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		ZenSyntaxPattern Pattern = TokenContext.GetFirstPattern(NameSpace);
		LeftNode = TokenContext.ApplyMatchPattern(NameSpace, LeftNode, Pattern);
		while(LeftNode != null) {
			@Var ZenSyntaxPattern SuffixPattern = TokenContext.GetSuffixPattern(NameSpace);
			if(SuffixPattern == null || SuffixPattern.IsBinaryOperator()) {
				break;
			}
			LeftNode = TokenContext.ApplyMatchPattern(NameSpace, LeftNode, SuffixPattern);
		}
		return LeftNode;
	}

	public static ZenNode MatchAnd(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenBinaryNode BinaryNode = new ZenAndNode(TokenContext.GetTokenAndMoveForward(), LeftNode, NameSpace.GetExtendedSyntaxPattern("&&"));
		return BinaryNode.AppendParsedRightNode(NameSpace, TokenContext);
	}

	public static ZenNode MatchOr(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenBinaryNode BinaryNode = new ZenOrNode(TokenContext.GetTokenAndMoveForward(), LeftNode, NameSpace.GetExtendedSyntaxPattern("||"));
		return BinaryNode.AppendParsedRightNode(NameSpace, TokenContext);
	}

	public static ZenNode MatchInstanceOf(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode BinaryNode = new ZenInstanceOfNode(TokenContext.GetTokenAndMoveForward(), LeftNode, NameSpace.GetSyntaxPattern("instanceof"));
		BinaryNode = TokenContext.AppendMatchedPattern(BinaryNode, NameSpace, "$Type$", ZenParserConst.Required);
		return BinaryNode;
	}

	public static ZenNode MatchExpression(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		ZenSyntaxPattern Pattern = TokenContext.GetFirstPattern(NameSpace);
		LeftNode = TokenContext.ApplyMatchPattern(NameSpace, LeftNode, Pattern);
		while(LeftNode != null) {
			@Var ZenSyntaxPattern SuffixPattern = TokenContext.GetSuffixPattern(NameSpace);
			if(SuffixPattern == null) {
				break;
			}
			LeftNode = TokenContext.ApplyMatchPattern(NameSpace, LeftNode, SuffixPattern);
		}
		return LeftNode;
	}

	public static ZenNode MatchIf(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode IfNode = new ZenIfNode();
		IfNode = TokenContext.MatchNodeToken(IfNode, NameSpace, "if", ZenParserConst.Required);
		IfNode = TokenContext.MatchNodeToken(IfNode, NameSpace, "(", ZenParserConst.Required | ZenParserConst.AllowSkipIndent);
		IfNode = TokenContext.AppendMatchedPattern(IfNode, NameSpace, "$Expression$", ZenParserConst.Required);
		IfNode = TokenContext.MatchNodeToken(IfNode, NameSpace, ")", ZenParserConst.Required | ZenParserConst.DisallowSkipIndent);
		IfNode = TokenContext.AppendMatchedPattern(IfNode, NameSpace, "$Block$", ZenParserConst.Required);
		if(TokenContext.MatchNewLineToken("else")) {
			String PatternName = "$Block$";
			if(TokenContext.IsNewLineToken("if")) {
				PatternName = "if";
			}
			IfNode = TokenContext.AppendMatchedPattern(IfNode, NameSpace, PatternName, ZenParserConst.Required);
		}
		return IfNode;
	}

	public static ZenNode MatchReturn(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode ReturnNode = new ZenReturnNode();
		ReturnNode = TokenContext.MatchNodeToken(ReturnNode, NameSpace, "return", ZenParserConst.Required);
		ReturnNode = TokenContext.AppendMatchedPattern(ReturnNode, NameSpace, "$Expression$", ZenParserConst.Optional);
		return ReturnNode;
	}

	public static ZenNode MatchWhile(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode WhileNode = new ZenWhileNode();
		WhileNode = TokenContext.MatchNodeToken(WhileNode, NameSpace, "while", ZenParserConst.Required);
		WhileNode = TokenContext.MatchNodeToken(WhileNode, NameSpace, "(", ZenParserConst.Required | ZenParserConst.AllowSkipIndent);
		WhileNode = TokenContext.AppendMatchedPattern(WhileNode, NameSpace, "$Expression$", ZenParserConst.Required);
		WhileNode = TokenContext.MatchNodeToken(WhileNode, NameSpace, ")", ZenParserConst.Required | ZenParserConst.DisallowSkipIndent);
		WhileNode = TokenContext.AppendMatchedPattern(WhileNode, NameSpace, "$Block$", ZenParserConst.Required);
		return WhileNode;
	}

	public static ZenNode MatchBreak(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode BreakNode = new ZenBreakNode();
		BreakNode = TokenContext.MatchNodeToken(BreakNode, NameSpace, "break", ZenParserConst.Required);
		return BreakNode;
	}

	public static ZenNode MatchCatch(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode CatchNode = new ZenCatchNode();
		CatchNode = TokenContext.MatchNodeToken(CatchNode, NameSpace, "catch", ZenParserConst.Required);
		CatchNode = TokenContext.MatchNodeToken(CatchNode, NameSpace, "(", ZenParserConst.Required | ZenParserConst.AllowSkipIndent);
		CatchNode = TokenContext.AppendMatchedPattern(CatchNode, NameSpace, "$Identifier$", ZenParserConst.Required);
		//		CatchNode = TokenContext.AppendMatchedPattern(CatchNode, NameSpace, "$TypeAnnotation$", ZenParserConst.Optional);
		CatchNode = TokenContext.MatchNodeToken(CatchNode, NameSpace, ")", ZenParserConst.Required | ZenParserConst.DisallowSkipIndent);
		CatchNode = TokenContext.AppendMatchedPattern(CatchNode, NameSpace, "$Block$", ZenParserConst.Required);
		return CatchNode;
	}

	public static ZenNode MatchTry(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode TryNode = new ZenTryNode();
		TryNode = TokenContext.MatchNodeToken(TryNode, NameSpace, "try", ZenParserConst.Required);
		TryNode = TokenContext.AppendMatchedPattern(TryNode, NameSpace, "$Block$", ZenParserConst.Required);
		int count = 0;
		if(TokenContext.IsNewLineToken("catch")) {
			TryNode = TokenContext.AppendMatchedPattern(TryNode, NameSpace, "$Catch$", ZenParserConst.Required);
			count = count + 1;
		}
		if(TokenContext.MatchNewLineToken("finally")) {
			TryNode = TokenContext.AppendMatchedPattern(TryNode, NameSpace, "$Block$", ZenParserConst.Required);
			count = count + 1;
		}
		if(count == 0 && !TryNode.IsErrorNode()) {
			return ((ZenTryNode)TryNode).TryNode; // no catch and finally
		}
		return TryNode;

	}

	public static ZenNode MatchThrow(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode ThrowNode = new ZenThrowNode();
		ThrowNode = TokenContext.MatchNodeToken(ThrowNode, NameSpace, "throw", ZenParserConst.Required);
		ThrowNode = TokenContext.AppendMatchedPattern(ThrowNode, NameSpace, "$Expression$", ZenParserConst.Required);
		return ThrowNode;
	}

	public static ZenNode MatchLetDecl(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		ZenToken SourceToken = TokenContext.GetTokenAndMoveForward(); /* let */
		ZenToken SymbolToken = TokenContext.GetTokenAndMoveForward(); /* name */
		@Var ZenType ConstClass = null;
		if(TokenContext.MatchToken(".")) {
			@Var String ClassName = SymbolToken.ParsedText;
			ConstClass = NameSpace.GetType(ClassName);
			if(ConstClass == null) {
				return new ZenErrorNode(SymbolToken, "unknown type: " + ClassName);
			}
			SymbolToken = TokenContext.GetTokenAndMoveForward(); /* class name */
		}
		if(!TokenContext.MatchToken("=")) {
			return TokenContext.CreateExpectedErrorNode(SymbolToken, "=");
		}
		ZenNode ValueNode = TokenContext.ParsePattern(NameSpace, "$Expression$", ZenParserConst.Required);
		if(ValueNode.IsErrorNode()) {
			return ValueNode;
		}
		@Var String ConstName = SymbolToken.ParsedText;
		if(ConstClass != null) {
			ConstName = ZenNameSpace.ClassStaticSymbol(ConstClass, ConstName);
			SourceToken.AddTypeInfoToErrorMessage(ConstClass);
		}
		//ValueNode = NameSpace.TypeCheck(ValueNode, NameSpace.GetSymbolType(ConstName), ZenParserConst.DefaultTypeCheckPolicy);
		ZenConstNode ConstNode = ValueNode.ToConstNode(true);
		if(!ConstNode.IsErrorNode()) {
			//@Var int NameSpaceFlag = KonohaGrammar.ParseNameSpaceFlag(0, TokenContext.ParsingAnnotation);
			//@Var ZenNameSpace StoreNameSpace = NameSpace.GetNameSpace(NameSpaceFlag);
			NameSpace.SetSymbol(ConstName, ConstNode.GetValue(), SourceToken);
			return ConstNode.Done();
		}
		return ConstNode;
	}

	public static ZenNode MatchIdentifier(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken Token = TokenContext.GetTokenAndMoveForward();
		if(LibZen.IsVariableName(Token.ParsedText, 0)) {
			return new ZenGetLocalNode(Token, Token.ParsedText);
		}
		return new ZenErrorNode(Token, "illegal name:" + Token.ParsedText);
	}

	public static ZenNode MatchTypeAnnotation(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		if(TokenContext.MatchToken(":")) {
			return TokenContext.ParsePattern(NameSpace, "$Type$", ZenParserConst.Required);
		}
		return null;
	}

	// "var" $Identifier [: $Type$] "=" $Expression$
	public static ZenNode MatchVarDecl(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenNode VarNode = new ZenVarDeclNode();
		VarNode = TokenContext.MatchNodeToken(VarNode, NameSpace, "var", ZenParserConst.Required);
		VarNode = TokenContext.AppendMatchedPattern(VarNode, NameSpace, "$Identifier$", ZenParserConst.Required);
		VarNode = TokenContext.AppendMatchedPattern(VarNode, NameSpace, "$TypeAnnotation$", ZenParserConst.Optional);
		VarNode = TokenContext.MatchNodeToken(VarNode, NameSpace, "=", ZenParserConst.Required);
		VarNode = TokenContext.AppendMatchedPattern(VarNode, NameSpace, "$Expression$", ZenParserConst.Required);
		return VarNode;
	}

	// FuncDecl
	public static ZenNode MatchParam(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken NameToken = TokenContext.GetTokenAndMoveForward();
		if(!NameToken.IsNameSymbol()) {
			return TokenContext.CreateExpectedErrorNode(NameToken, "parameter name");
		}
		ZenNode VarNode = new ZenParamNode(ZenSystem.VarType, NameToken, NameToken.ParsedText);
		VarNode = TokenContext.AppendMatchedPattern(VarNode, NameSpace, "$TypeAnnotation$", ZenParserConst.Optional);
		return VarNode;
	}

	public static ZenNode MatchFunction(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenToken FuncToken = TokenContext.GetTokenAndMoveForward(); /* function*/
		@Var ZenNode FuncNode;
		if(TokenContext.IsToken("(")) {
			FuncNode = new ZenFunctionLiteralNode(FuncToken);
		}
		else {
			@Var ZenToken NameToken = TokenContext.GetTokenAndMoveForward();
			FuncNode = new ZenFuncDeclNode(FuncToken, NameSpace, NameToken.ParsedText);
		}
		FuncNode = TokenContext.MatchNodeToken(FuncNode,  NameSpace, "(", ZenParserConst.Required | ZenParserConst.AllowSkipIndent);
		if(!TokenContext.MatchToken(")")) {
			while(!FuncNode.IsErrorNode()) {
				FuncNode = TokenContext.AppendMatchedPattern(FuncNode, NameSpace, "$Param$", ZenParserConst.Required);
				if(TokenContext.MatchToken(")")) {
					break;
				}
				FuncNode = TokenContext.MatchNodeToken(FuncNode,  NameSpace, ",", ZenParserConst.Required);
			}
		}
		FuncNode = TokenContext.AppendMatchedPattern(FuncNode, NameSpace, "$TypeAnnotation$", ZenParserConst.Optional);
		FuncNode = TokenContext.AppendMatchedPattern(FuncNode, NameSpace, "$Block$", ZenParserConst.Optional);
		return FuncNode;
	}

	public static ZenNode MatchAnnotation(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		ZenMap<Object> Anno = null;
		@Var ZenToken Token = null;
		while(TokenContext.MatchToken("@")) {
			Token = TokenContext.GetTokenAndMoveForward();
			if(Anno == null) {
				Anno = new ZenMap<Object>(null);
			}
			Anno.put(Token.ParsedText, Token);
			TokenContext.SkipIndent();
		}
		if(Anno != null) {
			return new ZenAnnotationNode(Token, Anno);
		}
		return null;
	}

	public static ZenNode MatchStatement(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		@Var ZenAnnotationNode AnnotationNode = (ZenAnnotationNode)TokenContext.ParsePattern(NameSpace, "$Annotation$", ZenParserConst.Optional);
		@Var ZenNode ParsedNode = TokenContext.ParsePattern(NameSpace, "$Expression$", ZenParserConst.Required);
		if(!ParsedNode.IsErrorNode() && TokenContext.HasNext()) {
			ZenToken Token = TokenContext.GetTokenAndMoveForward();
			if(!Token.IsDelim() && !Token.IsIndent()) {
				return TokenContext.CreateExpectedErrorNode(Token, ";");
			}
		}
		if(AnnotationNode != null) {
			AnnotationNode.Append(ParsedNode);
			ParsedNode = AnnotationNode;
		}
		return ParsedNode;
	}

	public static ZenNode MatchBlock(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		if(TokenContext.IsNewLineToken("{")) {
			TokenContext.SetParseFlag(0);
			@Var ZenToken IndentToken = TokenContext.GetCurrentIndentToken();
			@Var ZenNameSpace BlockNameSpace = NameSpace.CreateSubNameSpace();
			@Var ZenBlockNode BlockNode = new ZenBlockNode(TokenContext.GetTokenAndMoveForward(), BlockNameSpace);
			@Var ZenNode ResultNode = BlockNode;
			while(TokenContext.HasNext()) {
				TokenContext.SkipEmptyStatement();
				if(TokenContext.MatchToken("}")) {
					break;
				}
				@Var ZenNode ParsedNode = TokenContext.ParsePattern(BlockNameSpace, "$Statement$", ZenParserConst.Required);
				BlockNode.Append(ParsedNode);
				if(ParsedNode.IsErrorNode()) {
					TokenContext.SkipUntilIndent(IndentToken);
					TokenContext.MatchToken("}");
					break;
				}
				/* VarDecl is defined as BlockNode to speficy its scope */
				if(ParsedNode.GetStatementNode() instanceof ZenBlockNode) {
					BlockNode = (ZenBlockNode)ParsedNode.GetStatementNode();
				}
			}
			return ResultNode;
		}
		return TokenContext.CreateExpectedErrorNode(TokenContext.GetToken(), "block");
	}

	public static ZenNode MatchError(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		// FIXME this method is not suitable with "zen" mind.
		ZenToken Token = TokenContext.GetTokenAndMoveForward();
		return new ZenErrorNode(Token, Token.ParsedText);
	}

	public static void ImportGrammar(ZenNameSpace NameSpace, Class<?> Grammar) {
		NameSpace.AppendTokenFunc(" \t", LibNative.LoadTokenFunc(Grammar, "WhiteSpaceToken"));
		NameSpace.AppendTokenFunc("\n",  LibNative.LoadTokenFunc(Grammar, "IndentToken"));
		NameSpace.AppendTokenFunc(";", LibNative.LoadTokenFunc(Grammar, "SemiColonToken"));
		NameSpace.AppendTokenFunc("{}()[]<>.,?:+-*/%=&|!@~^$", LibNative.LoadTokenFunc(Grammar, "OperatorToken"));
		NameSpace.AppendTokenFunc("/", LibNative.LoadTokenFunc(Grammar, "CommentToken"));  // overloading
		NameSpace.AppendTokenFunc("Aa_", LibNative.LoadTokenFunc(Grammar, "SymbolToken"));

		NameSpace.AppendTokenFunc("\"", LibNative.LoadTokenFunc(Grammar, "StringLiteralToken"));
		NameSpace.AppendTokenFunc("1",  LibNative.LoadTokenFunc(Grammar, "NumberLiteralToken"));

		@Var ZenFunc MatchUnary     = LibNative.LoadMatchFunc(Grammar, "MatchUnary");
		@Var ZenFunc MatchBinary    = LibNative.LoadMatchFunc(Grammar, "MatchBinary");
		@Var ZenFunc MatchComparator    = LibNative.LoadMatchFunc(Grammar, "MatchComparator");

		NameSpace.AppendSyntax("null", LibNative.LoadMatchFunc(Grammar, "MatchNull"));
		NameSpace.AppendSyntax("true", LibNative.LoadMatchFunc(Grammar, "MatchTrue"));
		NameSpace.AppendSyntax("false", LibNative.LoadMatchFunc(Grammar, "MatchFalse"));

		NameSpace.AppendSyntax("+", MatchUnary);
		NameSpace.AppendSyntax("-", MatchUnary);
		NameSpace.AppendSyntax("~", MatchUnary);
		NameSpace.AppendSyntax("!", LibNative.LoadMatchFunc(Grammar, "MatchNot"));
		//		NameSpace.AppendSyntax("++ --", LibNative.LoadMatchFunc(Grammar, "MatchIncl"));

		NameSpace.AppendSuffixSyntax("* / %", ZenPrecedence.CStyleMUL, MatchBinary);
		NameSpace.AppendSuffixSyntax("+ -", ZenPrecedence.CStyleADD, MatchBinary);

		NameSpace.AppendSuffixSyntax("< <= > >=", ZenPrecedence.CStyleCOMPARE, MatchComparator);
		NameSpace.AppendSuffixSyntax("== !=", ZenPrecedence.CStyleEquals, MatchComparator);

		NameSpace.AppendSuffixSyntax("<< >>", ZenPrecedence.CStyleSHIFT, MatchBinary);
		NameSpace.AppendSuffixSyntax("&", ZenPrecedence.CStyleBITAND, MatchBinary);
		NameSpace.AppendSuffixSyntax("|", ZenPrecedence.CStyleBITOR, MatchBinary);
		NameSpace.AppendSuffixSyntax("^", ZenPrecedence.CStyleBITXOR, MatchBinary);

		NameSpace.AppendSuffixSyntax("=", ZenPrecedence.CStyleAssign | ZenParserConst.LeftJoin, MatchBinary);
		//		NameSpace.AppendSuffixSyntax("+= -= *= /= %= <<= >>= &= |= ^=", ZenPrecedence.CStyleAssign, MatchBinary);
		//		NameSpace.AppendExtendedSyntax("++ --", 0, LibNative.LoadMatchFunc(Grammar, "MatchIncl"));

		NameSpace.AppendSuffixSyntax("&&", ZenPrecedence.CStyleAND, LibNative.LoadMatchFunc(Grammar, "MatchAnd"));
		NameSpace.AppendSuffixSyntax("||", ZenPrecedence.CStyleOR, LibNative.LoadMatchFunc(Grammar, "MatchOr"));
		NameSpace.AppendSuffixSyntax("instanceof", ZenPrecedence.Instanceof, LibNative.LoadMatchFunc(Grammar, "MatchInstanceOf"));

		//		NameSpace.AppendExtendedSyntax("?", 0, LibNative.LoadMatchFunc(Grammar, "MatchTrinary"));

		NameSpace.AppendSyntax("$Error$", LibNative.LoadMatchFunc(Grammar, "MatchError"));
		//		NameSpace.AppendSyntax("$Empty$", LibNative.LoadMatchFunc(Grammar, "MatchEmpty"));
		NameSpace.AppendSyntax("$Symbol$", LibNative.LoadMatchFunc(Grammar, "MatchSymbol"));
		NameSpace.AppendSyntax("$Type$",LibNative.LoadMatchFunc(Grammar, "MatchType"));
		NameSpace.AppendSyntax("$TypeSuffix$", LibNative.LoadMatchFunc(Grammar, "MatchTypeSuffix"));
		NameSpace.AppendSyntax("$TypeAnnotation$", LibNative.LoadMatchFunc(Grammar, "MatchTypeAnnotation"));

		NameSpace.AppendSyntax("$StringLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchStringLiteral"));
		NameSpace.AppendSyntax("$IntegerLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchIntLiteral"));
		NameSpace.AppendSyntax("$FloatLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchFloatLiteral"));

		NameSpace.AppendSuffixSyntax(".", 0, LibNative.LoadMatchFunc(Grammar, "MatchGetter"));

		NameSpace.AppendSyntax("(", LibNative.LoadMatchFunc(Grammar, "MatchGroup"));
		NameSpace.AppendSyntax("(", LibNative.LoadMatchFunc(Grammar, "MatchCast"));
		NameSpace.AppendSuffixSyntax("(", 0, LibNative.LoadMatchFunc(Grammar, "MatchApply"));

		NameSpace.AppendSuffixSyntax("[", 0, LibNative.LoadMatchFunc(Grammar, "MatchIndexer"));
		NameSpace.AppendSyntax("[", LibNative.LoadMatchFunc(Grammar, "MatchArrayLiteral"));
		NameSpace.AppendSyntax("{", LibNative.LoadMatchFunc(Grammar, "MatchMapLiteral"));

		NameSpace.AppendSyntax("$Block$", LibNative.LoadMatchFunc(Grammar, "MatchBlock"));
		NameSpace.AppendSyntax("$Annotation$", LibNative.LoadMatchFunc(Grammar, "MatchAnnotation"));
		NameSpace.AppendSyntax("$Statement$", LibNative.LoadMatchFunc(Grammar, "MatchStatement"));
		NameSpace.AppendSyntax("$Expression$", LibNative.LoadMatchFunc(Grammar, "MatchExpression"));
		NameSpace.AppendSyntax("$SuffixExpression$", LibNative.LoadMatchFunc(Grammar, "MatchSuffixExpression"));

		NameSpace.AppendSyntax("if", LibNative.LoadMatchFunc(Grammar, "MatchIf"));
		NameSpace.AppendSyntax("return", LibNative.LoadMatchFunc(Grammar, "MatchReturn"));
		NameSpace.AppendSyntax("while", LibNative.LoadMatchFunc(Grammar, "MatchWhile"));
		NameSpace.AppendSyntax("break", LibNative.LoadMatchFunc(Grammar, "MatchBreak"));
		NameSpace.AppendSyntax("try", LibNative.LoadMatchFunc(Grammar, "MatchTry"));
		NameSpace.AppendSyntax("$Catch$", LibNative.LoadMatchFunc(Grammar, "MatchCatch"));
		NameSpace.AppendSyntax("throw", LibNative.LoadMatchFunc(Grammar, "MatchThrow"));

		NameSpace.AppendSyntax("$Identifier$", LibNative.LoadMatchFunc(Grammar, "MatchIdentifier"));
		NameSpace.AppendSyntax("var",  LibNative.LoadMatchFunc(Grammar, "MatchVarDecl"));
		NameSpace.AppendSyntax("$Param$", LibNative.LoadMatchFunc(Grammar, "MatchParam"));
		NameSpace.AppendSyntax("function", LibNative.LoadMatchFunc(Grammar, "MatchFunction"));
		NameSpace.AppendSyntax("let", LibNative.LoadMatchFunc(Grammar, "MatchLetDecl"));
		NameSpace.Generator.SetGrammarInfo("zen0.1");
	}

}
