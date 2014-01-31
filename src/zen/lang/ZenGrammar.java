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

import zen.ast.ZAndNode;
import zen.ast.ZAnnotationNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassDeclNode;
import zen.ast.ZComparatorNode;
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
import zen.ast.ZImportNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZTypeNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.parser.ZNameSpace;
import zen.parser.ZNodeUtils;
import zen.parser.ZParserConst;
import zen.parser.ZSyntaxPattern;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.type.ZType;
import zen.type.ZTypePool;

//endif VAJA

public class ZenGrammar {
	// Token
	public static long WhiteSpaceToken(ZTokenContext TokenContext, String SourceText, long pos) {
		TokenContext.FoundWhiteSpace();
		for(; pos < SourceText.length(); pos += 1) {
			@Var char ch = LibZen.CharAt(SourceText, pos);
			if(ch == '\n' || !LibZen.IsWhitespace(SourceText, pos)) {
				break;
			}
		}
		return pos;
	}

	public static long IndentToken(ZTokenContext TokenContext, String SourceText, long pos) {
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
		TokenContext.AppendParsedToken(Text, ZParserConst.IndentTokenFlag, null);
		return pos;
	}

	public static long SemiColonToken(ZTokenContext TokenContext, String SourceText, long pos) {
		TokenContext.AppendParsedToken(LibZen.SubString(SourceText, pos, (pos+1)), ZParserConst.DelimTokenFlag, null);
		return pos+1;
	}

	public static long SymbolToken(ZTokenContext TokenContext, String SourceText, long pos) {
		@Var long start = pos;
		@Var String PresetPattern = null;
		for(; pos < SourceText.length(); pos += 1) {
			if(!LibZen.IsVariableName(SourceText, pos) && !LibZen.IsDigit(SourceText, pos)) {
				break;
			}
		}
		TokenContext.AppendParsedToken(LibZen.SubString(SourceText, start, pos), ZParserConst.NameSymbolTokenFlag, PresetPattern);
		return pos;
	}

	public static long OperatorToken(ZTokenContext TokenContext, String SourceText, long pos) {
		@Var long NextPos = pos + 1;
		for(; NextPos < SourceText.length(); NextPos += 1) {
			if(LibZen.IsWhitespace(SourceText, NextPos) || LibZen.IsLetter(SourceText, NextPos) || LibZen.IsDigit(SourceText, NextPos)) {
				break;
			}
		}
		@Var boolean Matched = false;
		while(NextPos > pos) {
			@Var String Sub = LibZen.SubString(SourceText, pos, NextPos);
			@Var ZSyntaxPattern Pattern = TokenContext.TopLevelNameSpace.GetSuffixSyntaxPattern(Sub);
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

	public static long CommentToken(ZTokenContext TokenContext, String SourceText, long pos) {
		@Var long NextPos = pos + 1;
		@Var char NextChar = LibZen.CharAt(SourceText, NextPos);
		if(NextChar != '/' && NextChar != '*') {
			return ZTokenContext.MismatchedPosition;
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
		return ZTokenContext.MismatchedPosition;
	}

	public static long NumberLiteralToken(ZTokenContext TokenContext, String SourceText, long pos) {
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
	//				TokenContext.AddNewToken(LibZen.SubString(SourceText, start, (pos + 1)), ZenConsts.QuotedTokenFlag, "$CharLiteral$");
	//				return pos + 1;
	//			}
	//			if(ch == '\n') {
	//				TokenContext.ReportTokenError1(ZenConsts.ErrorLevel, "expected ' to close the charctor literal", LibZen.SubString(SourceText, start, pos));
	//				TokenContext.FoundLineFeed(1);
	//				return pos;
	//			}
	//			prev = ch;
	//		}
	//		TokenContext.ReportTokenError1(ZenConsts.ErrorLevel, "expected ' to close the charctor literal", LibZen.SubString(SourceText, start, pos));
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

	public static long StringLiteralToken(ZTokenContext TokenContext, String SourceText, long pos) {
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
			if(ch == '\"') {
				TokenContext.AppendParsedToken(LibZen.SubString(SourceText, start, (pos + 1)), ZParserConst.QuotedTokenFlag, "$StringLiteral$");
				return pos + 1;
			}
			if(ch == '\n') {
				//TokenContext.ReportTokenError1(ZLogger.ErrorLevel, "expected \" to close the string literal", LibZen.SubString(SourceText, start, pos));
				TokenContext.FoundLineFeed(1);
				return pos;
			}
		}
		//TokenContext.ReportTokenError1(ZLogger.ErrorLevel, "expected \" to close the string literal", LibZen.SubString(SourceText, start, pos));
		return pos;
	}

	// Match

	public static ZNode MatchNull(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZNullNode(TokenContext.GetTokenAndMoveForward());
	}

	public static ZNode MatchTrue(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZBooleanNode(TokenContext.GetTokenAndMoveForward(), true);
	}

	public static ZNode MatchFalse(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZBooleanNode(TokenContext.GetTokenAndMoveForward(), false);
	}

	public static ZNode MatchIntLiteral(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward();
		return new ZIntNode(Token, LibZen.ParseInt(Token.ParsedText));
	}

	public static ZNode MatchFloatLiteral(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward();
		return new ZFloatNode(Token, LibZen.ParseFloat(Token.ParsedText));
	}

	public static ZNode MatchStringLiteral(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward();
		return new ZStringNode(Token, LibZen.UnquoteString(Token.ParsedText));
	}

	public static ZNode MatchArrayLiteral(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZArrayLiteralNode();
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward(); /* "[" */
		LiteralNode.SourceToken = Token;
		if(!TokenContext.MatchToken("]")) {
			while(TokenContext.HasNext()) {
				LiteralNode = TokenContext.AppendMatchedPattern(LiteralNode, NameSpace, "$Expression$", ZTokenContext.Required2);
				if(LiteralNode.IsErrorNode() || TokenContext.MatchToken("]")) {
					break;
				}
				LiteralNode = TokenContext.MatchNodeToken(LiteralNode, NameSpace, ",", ZTokenContext.Required2);
				if(LiteralNode.IsErrorNode() || TokenContext.MatchToken("]")) {
					break;
				}
			}
		}
		return LiteralNode;
	}

	public static ZNode MatchMapLiteral(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZMapLiteralNode();
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward(); /* "{" */
		LiteralNode.SourceToken = Token;
		if(!TokenContext.MatchToken("}")) {
			while(TokenContext.HasNext()) {
				LiteralNode = TokenContext.AppendMatchedPattern(LiteralNode, NameSpace, "$Expression$", ZTokenContext.Required2);
				LiteralNode = TokenContext.MatchNodeToken(LiteralNode, NameSpace, ":", ZTokenContext.Required2);
				LiteralNode = TokenContext.AppendMatchedPattern(LiteralNode, NameSpace, "$Expression$", ZTokenContext.Required2);
				if(LiteralNode.IsErrorNode() || TokenContext.MatchToken("}")) {
					break;
				}
				LiteralNode = TokenContext.MatchNodeToken(LiteralNode, NameSpace, ",", ZTokenContext.Required2);
				if(LiteralNode.IsErrorNode() || TokenContext.MatchToken("}")) {
					break;
				}
			}
		}
		return LiteralNode;
	}

	public static ZNode MatchType(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward();
		@Var ZTypeNode TypeNode = NameSpace.GetTypeNode(Token.ParsedText, Token);
		if(TypeNode != null) {
			return TokenContext.ParsePatternAfter(NameSpace, TypeNode, "$TypeSuffix$", ZTokenContext.Optional2);
		}
		return null; // Not Matched
	}

	public static ZNode MatchTypeSuffix(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode TypeNode) {
		@Var ZToken SourceToken = TokenContext.GetToken();
		if(TypeNode.Type.GetParamSize() > 0) {
			if(TokenContext.MatchToken("<")) {  // Generics
				@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
				while(!TokenContext.StartsWithToken(">")) {
					if(TypeList.size() > 0 && !TokenContext.MatchToken(",")) {
						return null;
					}
					@Var ZTypeNode ParamTypeNode = (ZTypeNode) TokenContext.ParsePattern(NameSpace, "$Type$", ZTokenContext.Optional2);
					if(ParamTypeNode == null) {
						return TypeNode;
					}
					TypeList.add(ParamTypeNode.Type);
				}
				TypeNode = new ZTypeNode(SourceToken, ZTypePool.GetGenericType(TypeNode.Type, 0, TypeList, true));
			}
		}
		while(TokenContext.MatchToken("[")) {  // Array
			if(!TokenContext.MatchToken("]")) {
				return null;
			}
			TypeNode = new ZTypeNode(SourceToken, ZTypePool.GetGenericType1(ZType.ArrayType, TypeNode.Type, true));
		}
		return TypeNode;
	}

	public static ZNode MatchSymbol(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken NameToken = TokenContext.GetTokenAndMoveForward();
		if(!NameToken.IsNameSymbol()) {
			return TokenContext.CreateExpectedErrorNode(NameToken, "identifier");
		}
		@Var ZNode AssignedNode = null;
		if(TokenContext.MatchToken("=")) {
			AssignedNode = TokenContext.ParsePattern(NameSpace, "$Expression$", ZTokenContext.Required2);
			if(AssignedNode.IsErrorNode()) {
				return AssignedNode;
			}
		}
		return ZNodeUtils.CreateSymbolNode(NameToken, ZType.VarType, NameToken.ParsedText, AssignedNode);
	}

	// PatternName: "("  (1)
	public static ZNode MatchGroup(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode GroupNode = new ZGroupNode();
		GroupNode = TokenContext.MatchNodeToken(GroupNode, NameSpace, "(", ZTokenContext.Required2);
		GroupNode = TokenContext.AppendMatchedPattern(GroupNode, NameSpace, "$Expression$", ZTokenContext.Required2);
		GroupNode = TokenContext.MatchNodeToken(GroupNode, NameSpace, ")", ZTokenContext.Required2);
		return GroupNode;
	}

	public static ZNode MatchCast(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode CastNode = new ZCastNode(ZType.VarType, null);
		CastNode = TokenContext.MatchNodeToken(CastNode, NameSpace, "(", ZTokenContext.Required2);
		CastNode = TokenContext.AppendMatchedPattern(CastNode, NameSpace, "$Type$", ZTokenContext.Required2);
		CastNode = TokenContext.MatchNodeToken(CastNode, NameSpace, ")", ZTokenContext.Required2);
		CastNode = TokenContext.AppendMatchedPattern(CastNode, NameSpace, "$SuffixExpression$", ZTokenContext.Required2);
		return CastNode;
	}

	public static ZNode MatchGetter(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		TokenContext.MatchToken(".");
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward();
		if(!Token.IsNameSymbol()) {
			return TokenContext.CreateExpectedErrorNode(Token, "field name");
		}
		if(TokenContext.MatchToken("(")) {  // method call
			@Var ZNode MethodCallNode = new ZMethodCallNode(Token, LeftNode, Token.ParsedText);
			if(!TokenContext.MatchToken(")")) {
				while(!MethodCallNode.IsErrorNode()) {
					MethodCallNode = TokenContext.AppendMatchedPattern(MethodCallNode, NameSpace, "$Expression$", ZTokenContext.Required2);
					if(TokenContext.MatchToken(")")) {
						break;
					}
					MethodCallNode = TokenContext.MatchNodeToken(MethodCallNode, NameSpace, ",", ZTokenContext.Required2);
				}
			}
			return MethodCallNode;
		}
		if(TokenContext.MatchToken("=")) {
			ZNode SetterNode = new ZSetterNode(Token, LeftNode, Token.ParsedText);
			SetterNode = TokenContext.AppendMatchedPattern(SetterNode, NameSpace, "$Expression$", ZTokenContext.Required2);
			return SetterNode;
		}
		else {
			return new ZGetterNode(Token, LeftNode, Token.ParsedText);
		}
	}

	public static ZNode MatchApply(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ApplyNode = new ZFuncCallNode(LeftNode);
		ApplyNode = TokenContext.MatchNodeToken(ApplyNode, NameSpace, "(", ZTokenContext.Required2);
		if(!TokenContext.MatchToken(")")) {
			while(!ApplyNode.IsErrorNode()) {
				ApplyNode = TokenContext.AppendMatchedPattern(ApplyNode, NameSpace, "$Expression$", ZTokenContext.Required2);
				if(TokenContext.MatchToken(")")) {
					break;
				}
				ApplyNode = TokenContext.MatchNodeToken(ApplyNode, NameSpace, ",", ZTokenContext.Required2);
			}
		}
		return ApplyNode;
	}

	public static ZNode MatchIndexer(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IndexerNode = new ZGetIndexNode(LeftNode);
		IndexerNode = TokenContext.MatchNodeToken(IndexerNode, NameSpace, "[", ZTokenContext.Required2);
		IndexerNode = TokenContext.AppendMatchedPattern(IndexerNode, NameSpace, "$Expression$", ZTokenContext.Required2);
		IndexerNode = TokenContext.MatchNodeToken(IndexerNode, NameSpace, "]", ZTokenContext.Required2);
		if(TokenContext.MatchToken("=") && !IndexerNode.IsErrorNode()) {
			IndexerNode = new ZSetIndexNode((ZGetIndexNode)IndexerNode);
			IndexerNode = TokenContext.AppendMatchedPattern(IndexerNode, NameSpace, "$Expression$", ZTokenContext.Required2);
		}
		return IndexerNode;
	}

	public static ZNode MatchUnary(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode UnaryNode = new ZUnaryNode(TokenContext.GetTokenAndMoveForward());
		return TokenContext.AppendMatchedPattern(UnaryNode, NameSpace, "$SuffixExpression$", ZTokenContext.Required2);
	}

	public static ZNode MatchNot(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode UnaryNode = new ZNotNode(TokenContext.GetTokenAndMoveForward());
		UnaryNode = TokenContext.AppendMatchedPattern(UnaryNode, NameSpace, "$SuffixExpression$", ZTokenContext.Required2);
		return UnaryNode;
	}

	public static ZNode MatchBinary(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward();
		@Var ZBinaryNode BinaryNode = new ZBinaryNode(Token, LeftNode, NameSpace.GetSuffixSyntaxPattern(Token.ParsedText));
		return BinaryNode.AppendParsedRightNode(NameSpace, TokenContext);
	}

	public static ZNode MatchComparator(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward();
		@Var ZBinaryNode BinaryNode = new ZComparatorNode(Token, LeftNode, NameSpace.GetSuffixSyntaxPattern(Token.ParsedText));
		return BinaryNode.AppendParsedRightNode(NameSpace, TokenContext);
	}

	public static ZNode MatchAnd(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZBinaryNode BinaryNode = new ZAndNode(TokenContext.GetTokenAndMoveForward(), LeftNode, NameSpace.GetSuffixSyntaxPattern("&&"));
		return BinaryNode.AppendParsedRightNode(NameSpace, TokenContext);
	}

	public static ZNode MatchOr(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZBinaryNode BinaryNode = new ZOrNode(TokenContext.GetTokenAndMoveForward(), LeftNode, NameSpace.GetSuffixSyntaxPattern("||"));
		return BinaryNode.AppendParsedRightNode(NameSpace, TokenContext);
	}

	public static ZNode MatchInstanceOf(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BinaryNode = new ZInstanceOfNode(TokenContext.GetTokenAndMoveForward(), LeftNode, NameSpace.GetSyntaxPattern("instanceof"));
		BinaryNode = TokenContext.AppendMatchedPattern(BinaryNode, NameSpace, "$Type$", ZTokenContext.Required2);
		return BinaryNode;
	}


	private static ZNode MatchFirstExpression(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken();
		@Var ZSyntaxPattern Pattern = null;
		if(Token.PresetPattern != null) {
			Pattern = Token.PresetPattern;
		}
		else {
			Pattern = NameSpace.GetSyntaxPattern(Token.ParsedText);
		}
		if(Pattern != null) {
			LeftNode = TokenContext.ApplyMatchPattern(NameSpace, LeftNode, Pattern, ZTokenContext.Required2);
		}
		else {
			Pattern = NameSpace.GetSyntaxPattern("$Symbol$");
			LeftNode = TokenContext.ApplyMatchPattern(NameSpace, LeftNode, Pattern, ZTokenContext.Optional2);
			if(LeftNode == null) {
				LeftNode = TokenContext.CreateExpectedErrorNode(Token, "an expression");
			}
		}
		return LeftNode;
	}

	private static ZSyntaxPattern GetSuffixPattern(ZNameSpace NameSpace, ZTokenContext TokenContext) {
		@Var ZToken Token = TokenContext.GetToken();
		if(Token != ZToken.NullToken) {
			@Var ZSyntaxPattern Pattern = NameSpace.GetSuffixSyntaxPattern(Token.ParsedText);
			return Pattern;
		}
		return null;
	}

	public static ZNode MatchExpression(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		LeftNode = ZenGrammar.MatchFirstExpression(NameSpace, TokenContext, LeftNode);
		while(LeftNode != null && !LeftNode.IsErrorNode()) {
			@Var ZSyntaxPattern SuffixPattern = ZenGrammar.GetSuffixPattern(NameSpace, TokenContext);
			if(SuffixPattern == null) {
				break;
			}
			LeftNode = TokenContext.ApplyMatchPattern(NameSpace, LeftNode, SuffixPattern, ZTokenContext.Required2);
		}
		return LeftNode;
	}

	public static ZNode MatchSuffixExpression(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		LeftNode = ZenGrammar.MatchFirstExpression(NameSpace, TokenContext, LeftNode);
		while(LeftNode != null && !LeftNode.IsErrorNode()) {
			@Var ZSyntaxPattern SuffixPattern = ZenGrammar.GetSuffixPattern(NameSpace, TokenContext);
			if(SuffixPattern == null || SuffixPattern.IsBinaryOperator()) {
				break;
			}
			LeftNode = TokenContext.ApplyMatchPattern(NameSpace, LeftNode, SuffixPattern, ZTokenContext.Required2);
		}
		return LeftNode;
	}

	public static ZNode MatchIf(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IfNode = new ZIfNode();
		IfNode = TokenContext.MatchNodeToken(IfNode, NameSpace, "if", ZTokenContext.Required2);
		IfNode = TokenContext.MatchNodeToken(IfNode, NameSpace, "(", ZTokenContext.Required2);
		IfNode = TokenContext.AppendMatchedPattern(IfNode, NameSpace, "$Expression$", ZTokenContext.Required2);
		IfNode = TokenContext.MatchNodeToken(IfNode, NameSpace, ")", ZTokenContext.Required2);
		IfNode = TokenContext.AppendMatchedPattern(IfNode, NameSpace, "$Block$", ZTokenContext.Required2);
		if(TokenContext.MatchNewLineToken("else")) {
			String PatternName = "$Block$";
			if(TokenContext.IsNewLineToken("if")) {
				PatternName = "if";
			}
			IfNode = TokenContext.AppendMatchedPattern(IfNode, NameSpace, PatternName, ZTokenContext.Required2);
		}
		return IfNode;
	}

	public static ZNode MatchReturn(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ReturnNode = new ZReturnNode();
		ReturnNode = TokenContext.MatchNodeToken(ReturnNode, NameSpace, "return", ZTokenContext.Required2);
		ReturnNode = TokenContext.AppendMatchedPattern(ReturnNode, NameSpace, "$Expression$", ZTokenContext.Optional2);
		return ReturnNode;
	}

	public static ZNode MatchWhile(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode WhileNode = new ZWhileNode();
		WhileNode = TokenContext.MatchNodeToken(WhileNode, NameSpace, "while", ZTokenContext.Required2);
		WhileNode = TokenContext.MatchNodeToken(WhileNode, NameSpace, "(", ZTokenContext.Required2);
		WhileNode = TokenContext.AppendMatchedPattern(WhileNode, NameSpace, "$Expression$", ZTokenContext.Required2);
		WhileNode = TokenContext.MatchNodeToken(WhileNode, NameSpace, ")", ZTokenContext.Required2);
		WhileNode = TokenContext.AppendMatchedPattern(WhileNode, NameSpace, "$Block$", ZTokenContext.Required2);
		return WhileNode;
	}

	public static ZNode MatchBreak(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BreakNode = new ZBreakNode();
		BreakNode = TokenContext.MatchNodeToken(BreakNode, NameSpace, "break", ZTokenContext.Required2);
		return BreakNode;
	}

	public static ZNode MatchCatch(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode CatchNode = new ZCatchNode();
		CatchNode = TokenContext.MatchNodeToken(CatchNode, NameSpace, "catch", ZTokenContext.Required2);
		CatchNode = TokenContext.MatchNodeToken(CatchNode, NameSpace, "(", ZTokenContext.Required2);
		CatchNode = TokenContext.AppendMatchedPattern(CatchNode, NameSpace, "$Identifier$", ZTokenContext.Required2);
		//		CatchNode = TokenContext.AppendMatchedPattern(CatchNode, NameSpace, "$TypeAnnotation$", ZenParserConst.Optional2);
		CatchNode = TokenContext.MatchNodeToken(CatchNode, NameSpace, ")", ZTokenContext.Required2);
		CatchNode = TokenContext.AppendMatchedPattern(CatchNode, NameSpace, "$Block$", ZTokenContext.Required2);
		return CatchNode;
	}

	public static ZNode MatchTry(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode TryNode = new ZTryNode();
		TryNode = TokenContext.MatchNodeToken(TryNode, NameSpace, "try", ZTokenContext.Required2);
		TryNode = TokenContext.AppendMatchedPattern(TryNode, NameSpace, "$Block$", ZTokenContext.Required2);
		int count = 0;
		if(TokenContext.IsNewLineToken("catch")) {
			TryNode = TokenContext.AppendMatchedPattern(TryNode, NameSpace, "$Catch$", ZTokenContext.Required2);
			count = count + 1;
		}
		if(TokenContext.MatchNewLineToken("finally")) {
			TryNode = TokenContext.AppendMatchedPattern(TryNode, NameSpace, "$Block$", ZTokenContext.Required2);
			count = count + 1;
		}
		if(count == 0 && !TryNode.IsErrorNode()) {
			return ((ZTryNode)TryNode).TryNode; // no catch and finally
		}
		return TryNode;

	}

	public static ZNode MatchThrow(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ThrowNode = new ZThrowNode();
		ThrowNode = TokenContext.MatchNodeToken(ThrowNode, NameSpace, "throw", ZTokenContext.Required2);
		ThrowNode = TokenContext.AppendMatchedPattern(ThrowNode, NameSpace, "$Expression$", ZTokenContext.Required2);
		return ThrowNode;
	}

	public static ZNode MatchLetDecl(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		//		@Var ZToken SourceToken = TokenContext.GetTokenAndMoveForward(); /* let */
		//		@Var ZToken SymbolToken = TokenContext.GetTokenAndMoveForward(); /* name */
		//		@Var String SymbolName = SymbolToken.ParsedText;
		//		if(TokenContext.MatchToken(".")) {
		//			@Var String ClassName = SymbolToken.ParsedText;
		//			@Var ZType SymbolClass = NameSpace.GetType(ClassName, SymbolToken);
		//			if(SymbolClass == null) {
		//				return new ZErrorNode(SymbolToken, ClassName + " is not type");
		//			}
		//			SymbolToken = TokenContext.GetTokenAndMoveForward(); /* class name */
		//			SymbolName = ZNameSpace.StringfyClassStaticSymbol(SymbolClass, SymbolName);
		//			SourceToken.AddTypeInfoToErrorMessage(SymbolClass);
		//		}
		//		@Var ZType SymbolType = TokenContext.ParseType(NameSpace, "$TypeAnnotation$", ZType.VarType);
		//		if(!TokenContext.MatchToken("=")) {
		//			return TokenContext.CreateExpectedErrorNode(SymbolToken, "=");
		//		}
		//		@Var ZNode ValueNode = TokenContext.ParsePattern(NameSpace, "$Expression$", ZTokenContext.Required2);
		//		if(ValueNode instanceof ZStringNode && SymbolType.IsFuncType()) {
		//			@Var ZMacro MacroFunc = new ZMacro(0, SymbolName, (ZFuncType)SymbolType, ((ZStringNode)ValueNode).StringValue);
		//			//			NameSpace.AppendFuncName(MacroFunc, SourceToken);
		//			return ValueNode.Done();
		//		}
		//		if(ValueNode.IsErrorNode()) {
		//			return ValueNode;
		//		}
		//		//ValueNode = NameSpace.TypeCheck(ValueNode, NameSpace.GetSymbolType(ConstName), ZenParserConst.DefaultTypeCheckPolicy);
		//		ZConstNode ConstNode = ValueNode.ToConstNode(true);
		//		if(!ConstNode.IsErrorNode()) {
		//			NameSpace.SetSymbol(SymbolName, ConstNode.GetValue(), SourceToken);
		//			return ConstNode.Done();
		//		}
		//		return ConstNode;
		return null;
	}

	public static ZNode MatchIdentifier(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetTokenAndMoveForward();
		if(LibZen.IsVariableName(Token.ParsedText, 0)) {
			return new ZGetNameNode(Token, Token.ParsedText);
		}
		return new ZErrorNode(Token, "illegal name:" + Token.ParsedText);
	}

	public static ZNode MatchTypeAnnotation(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		if(TokenContext.MatchToken(":")) {
			return TokenContext.ParsePattern(NameSpace, "$Type$", ZTokenContext.Required2);
		}
		return null;
	}

	// "var" $Identifier [: $Type$] "=" $Expression$
	public static ZNode MatchVarDecl(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode VarNode = new ZVarDeclNode(NameSpace.CreateSubNameSpace());
		VarNode = TokenContext.MatchNodeToken(VarNode, NameSpace, "var", ZTokenContext.Required2);
		VarNode = TokenContext.AppendMatchedPattern(VarNode, NameSpace, "$Identifier$", ZTokenContext.Required2);
		VarNode = TokenContext.AppendMatchedPattern(VarNode, NameSpace, "$TypeAnnotation$", ZTokenContext.Optional2);
		VarNode = TokenContext.MatchNodeToken(VarNode, NameSpace, "=", ZTokenContext.Required2);
		VarNode = TokenContext.AppendMatchedPattern(VarNode, NameSpace, "$Expression$", ZTokenContext.Required2);
		return VarNode;
	}

	// FuncDecl
	public static ZNode MatchParam(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken NameToken = TokenContext.GetTokenAndMoveForward();
		if(!NameToken.IsNameSymbol()) {
			return TokenContext.CreateExpectedErrorNode(NameToken, "parameter name");
		}
		@Var ZNode VarNode = new ZParamNode(ZType.VarType, NameToken, NameToken.ParsedText);
		VarNode = TokenContext.AppendMatchedPattern(VarNode, NameSpace, "$TypeAnnotation$", ZTokenContext.Optional2);
		return VarNode;
	}

	public static ZNode MatchFunction(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode FuncNode = new ZFunctionNode(NameSpace);
		FuncNode = TokenContext.MatchNodeToken(FuncNode, NameSpace, "function", ZTokenContext.Required2);
		FuncNode = TokenContext.AppendMatchedPattern(FuncNode, NameSpace, "$Identifier$", ZTokenContext.Optional2);
		FuncNode = TokenContext.MatchNodeToken(FuncNode,  NameSpace, "(", ZTokenContext.Required2);
		if(!TokenContext.MatchToken(")")) {
			while(!FuncNode.IsErrorNode()) {
				FuncNode = TokenContext.AppendMatchedPattern(FuncNode, NameSpace, "$Param$", ZTokenContext.Required2);
				if(TokenContext.MatchToken(")")) {
					break;
				}
				FuncNode = TokenContext.MatchNodeToken(FuncNode,  NameSpace, ",", ZTokenContext.Required2);
			}
		}
		FuncNode = TokenContext.AppendMatchedPattern(FuncNode, NameSpace, "$TypeAnnotation$", ZTokenContext.Optional2);
		FuncNode = TokenContext.AppendMatchedPattern(FuncNode, NameSpace, "$Block$", ZTokenContext.Required2);
		return FuncNode;
	}

	public static ZNode MatchAnnotation(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZenMap<Object> Anno = null;
		@Var ZToken Token = null;
		while(TokenContext.MatchToken("@")) {
			Token = TokenContext.GetTokenAndMoveForward();
			if(Anno == null) {
				Anno = new ZenMap<Object>(null);
			}
			Anno.put(Token.ParsedText, Token);
			TokenContext.SkipIndent();
		}
		if(Anno != null) {
			return new ZAnnotationNode(Token, Anno);
		}
		return null;
	}

	public static ZNode MatchStatement(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZAnnotationNode AnnotationNode = (ZAnnotationNode)TokenContext.ParsePattern(NameSpace, "$Annotation$", ZTokenContext.Optional2);
		@Var ZNode ParsedNode = TokenContext.ParsePattern(NameSpace, "$Expression$", ZTokenContext.Required2);
		if(!ParsedNode.IsErrorNode() && TokenContext.HasNext()) {
			ZToken Token = TokenContext.GetToken(); //AndMoveForward();
			if(!Token.IsDelim() && !Token.IsIndent() && !Token.EqualsText("}")) {
				/* }  is added because function f(x) { x } is parsed */
				return TokenContext.CreateExpectedErrorNode(Token, ";");
			}
		}
		if(AnnotationNode != null) {
			AnnotationNode.Append(ParsedNode);
			ParsedNode = AnnotationNode;
		}
		return ParsedNode;
	}

	public static ZNode MatchBlock(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		if(TokenContext.IsNewLineToken("{")) {
			TokenContext.SetParseFlag(0);
			@Var ZToken IndentToken = TokenContext.GetCurrentIndentToken();
			@Var ZNameSpace BlockNameSpace = NameSpace.CreateSubNameSpace();
			@Var ZBlockNode BlockNode = new ZBlockNode(TokenContext.GetTokenAndMoveForward(), BlockNameSpace);
			@Var ZNode ResultNode = BlockNode;
			while(TokenContext.HasNext()) {
				TokenContext.SkipEmptyStatement();
				if(TokenContext.MatchToken("}")) {
					break;
				}
				@Var ZNode ParsedNode = TokenContext.ParsePattern(BlockNameSpace, "$Statement$", ZTokenContext.Required2);
				BlockNode.Append(ParsedNode);
				if(ParsedNode.IsErrorNode()) {
					TokenContext.SkipUntilIndent(IndentToken);
					TokenContext.MatchToken("}");
					break;
				}
				/* VarDecl is defined as BlockNode to speficy its scope */
				if(ParsedNode.GetStatementNode() instanceof ZBlockNode) {
					BlockNode = (ZBlockNode)ParsedNode.GetStatementNode();
					BlockNameSpace = BlockNode.NameSpace;
				}
			}
			return ResultNode;
		}
		return TokenContext.CreateExpectedErrorNode(TokenContext.GetToken(), "block");
	}

	public static ZNode MatchError(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		// FIXME this method is not suitable with "zen" mind.
		ZToken Token = TokenContext.GetTokenAndMoveForward();
		return new ZErrorNode(Token, Token.ParsedText);
	}

	// "var" $Identifier [: $Type$] "=" $Expression$
	public static ZNode MatchFieldDecl(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode ClassNode) {
		@Var ZNode FieldNode = new ZFieldNode(null);
		FieldNode = TokenContext.MatchNodeToken(FieldNode, NameSpace, "field", ZTokenContext.Required2);
		FieldNode = TokenContext.AppendMatchedPattern(FieldNode, NameSpace, "$Identifier$", ZTokenContext.Required2);
		FieldNode = TokenContext.AppendMatchedPattern(FieldNode, NameSpace, "$TypeAnnotation$", ZTokenContext.Optional2);
		if(TokenContext.MatchToken("=")) {
			FieldNode = TokenContext.AppendMatchedPattern(FieldNode, NameSpace, "$Expression$", ZTokenContext.Required2);
		}
		return FieldNode;
	}

	public static ZNode MatchClassDecl(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ClassNode = new ZClassDeclNode(NameSpace);
		ClassNode = TokenContext.MatchNodeToken(ClassNode, NameSpace, "class", ZTokenContext.Required2);
		ClassNode = TokenContext.AppendMatchedPattern(ClassNode, NameSpace, "$Identifier$", ZTokenContext.Required2);
		if(TokenContext.MatchNewLineToken("extends")) {
			ClassNode = TokenContext.AppendMatchedPattern(ClassNode, NameSpace, "$Type$", ZTokenContext.Required2);
		}
		if(!ClassNode.IsErrorNode() && TokenContext.MatchNewLineToken("{")) {
			TokenContext.SetParseFlag(0);
			while(!ClassNode.IsErrorNode() && TokenContext.HasNext()) {
				TokenContext.SkipEmptyStatement();
				if(TokenContext.MatchToken("}")) {
					break;
				}
				ClassNode = TokenContext.AppendMatchedPattern(ClassNode, NameSpace, "$FieldDecl$", ZTokenContext.Required2);
			}
		}
		return ClassNode;
	}

	public static ZNode MatchPath(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.ParseLargeToken();
		//		System.err.println("debug '" + Token.ParsedText + "'");
		return new ZGetNameNode(Token, Token.ParsedText);
	}

	public static ZNode MatchImport(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ImportNode = NameSpace.Generator.CreateImportNode(NameSpace.GetRootNameSpace());
		ImportNode = TokenContext.MatchNodeToken(ImportNode, NameSpace, "import", ZTokenContext.Required2);
		ImportNode = TokenContext.AppendMatchedPattern(ImportNode, NameSpace, "$Path$", ZTokenContext.Required2);
		if(ImportNode instanceof ZImportNode) {
			return ((ZImportNode)ImportNode).Import();
		}
		return ImportNode;
	}

	public static void ImportGrammar(ZNameSpace NameSpace, Class<?> Grammar) {
		// defined type system
		NameSpace.SetTypeName(ZType.VoidType,  null);
		NameSpace.SetTypeName(ZType.BooleanType, null);
		NameSpace.SetTypeName(ZType.IntType, null);
		NameSpace.SetTypeName(ZType.FloatType, null);
		NameSpace.SetTypeName(ZType.StringType, null);
		NameSpace.SetTypeName(ZType.TypeType, null);
		NameSpace.SetTypeName(ZType.ArrayType, null);
		NameSpace.SetTypeName(ZType.MapType, null);
		NameSpace.SetTypeName(ZType.FuncType, null);

		NameSpace.AppendTokenFunc(" \t", LibNative.LoadTokenFunc(Grammar, "WhiteSpaceToken"));
		NameSpace.AppendTokenFunc("\n",  LibNative.LoadTokenFunc(Grammar, "IndentToken"));
		NameSpace.AppendTokenFunc(";", LibNative.LoadTokenFunc(Grammar, "SemiColonToken"));
		NameSpace.AppendTokenFunc("{}()[]<>.,?:+-*/%=&|!@~^$", LibNative.LoadTokenFunc(Grammar, "OperatorToken"));
		NameSpace.AppendTokenFunc("/", LibNative.LoadTokenFunc(Grammar, "CommentToken"));  // overloading
		NameSpace.AppendTokenFunc("Aa_", LibNative.LoadTokenFunc(Grammar, "SymbolToken"));

		NameSpace.AppendTokenFunc("\"", LibNative.LoadTokenFunc(Grammar, "StringLiteralToken"));
		NameSpace.AppendTokenFunc("1",  LibNative.LoadTokenFunc(Grammar, "NumberLiteralToken"));

		@Var ZFunc MatchUnary     = LibNative.LoadMatchFunc(Grammar, "MatchUnary");
		@Var ZFunc MatchBinary    = LibNative.LoadMatchFunc(Grammar, "MatchBinary");
		@Var ZFunc MatchComparator    = LibNative.LoadMatchFunc(Grammar, "MatchComparator");

		NameSpace.DefineSyntax("null", LibNative.LoadMatchFunc(Grammar, "MatchNull"));
		NameSpace.DefineSyntax("true", LibNative.LoadMatchFunc(Grammar, "MatchTrue"));
		NameSpace.DefineSyntax("false", LibNative.LoadMatchFunc(Grammar, "MatchFalse"));

		NameSpace.DefineSyntax("+", MatchUnary);
		NameSpace.DefineSyntax("-", MatchUnary);
		NameSpace.DefineSyntax("~", MatchUnary);
		NameSpace.DefineSyntax("!", LibNative.LoadMatchFunc(Grammar, "MatchNot"));
		//		NameSpace.AppendSyntax("++ --", LibNative.LoadMatchFunc(Grammar, "MatchIncl"));

		NameSpace.DefineSuffixSyntax("* / %", ZenPrecedence.CStyleMUL, MatchBinary);
		NameSpace.DefineSuffixSyntax("+ -", ZenPrecedence.CStyleADD, MatchBinary);

		NameSpace.DefineSuffixSyntax("< <= > >=", ZenPrecedence.CStyleCOMPARE, MatchComparator);
		NameSpace.DefineSuffixSyntax("== !=", ZenPrecedence.CStyleEquals, MatchComparator);

		NameSpace.DefineSuffixSyntax("<< >>", ZenPrecedence.CStyleSHIFT, MatchBinary);
		NameSpace.DefineSuffixSyntax("&", ZenPrecedence.CStyleBITAND, MatchBinary);
		NameSpace.DefineSuffixSyntax("|", ZenPrecedence.CStyleBITOR, MatchBinary);
		NameSpace.DefineSuffixSyntax("^", ZenPrecedence.CStyleBITXOR, MatchBinary);

		NameSpace.DefineSuffixSyntax("=", ZenPrecedence.CStyleAssign | ZParserConst.LeftJoin, MatchBinary);
		//		NameSpace.AppendSuffixSyntax("+= -= *= /= %= <<= >>= &= |= ^=", ZenPrecedence.CStyleAssign, MatchBinary);
		//		NameSpace.AppendExtendedSyntax("++ --", 0, LibNative.LoadMatchFunc(Grammar, "MatchIncl"));

		NameSpace.DefineSuffixSyntax("&&", ZenPrecedence.CStyleAND, LibNative.LoadMatchFunc(Grammar, "MatchAnd"));
		NameSpace.DefineSuffixSyntax("||", ZenPrecedence.CStyleOR, LibNative.LoadMatchFunc(Grammar, "MatchOr"));

		//		NameSpace.AppendExtendedSyntax("?", 0, LibNative.LoadMatchFunc(Grammar, "MatchTrinary"));

		NameSpace.DefineSyntax("$Error$", LibNative.LoadMatchFunc(Grammar, "MatchError"));
		NameSpace.DefineSyntax("$Symbol$", LibNative.LoadMatchFunc(Grammar, "MatchSymbol"));
		NameSpace.DefineSyntax("$Type$",LibNative.LoadMatchFunc(Grammar, "MatchType"));
		NameSpace.DefineSyntax("$TypeSuffix$", LibNative.LoadMatchFunc(Grammar, "MatchTypeSuffix"));
		NameSpace.DefineSyntax("$TypeAnnotation$", LibNative.LoadMatchFunc(Grammar, "MatchTypeAnnotation"));

		NameSpace.DefineSyntax("$StringLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchStringLiteral"));
		NameSpace.DefineSyntax("$IntegerLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchIntLiteral"));
		NameSpace.DefineSyntax("$FloatLiteral$", LibNative.LoadMatchFunc(Grammar, "MatchFloatLiteral"));

		NameSpace.DefineSuffixSyntax(".", 0, LibNative.LoadMatchFunc(Grammar, "MatchGetter"));

		NameSpace.DefineSyntax("(", LibNative.LoadMatchFunc(Grammar, "MatchGroup"));
		NameSpace.DefineSyntax("(", LibNative.LoadMatchFunc(Grammar, "MatchCast"));
		NameSpace.DefineSuffixSyntax("(", 0, LibNative.LoadMatchFunc(Grammar, "MatchApply"));

		NameSpace.DefineSuffixSyntax("[", 0, LibNative.LoadMatchFunc(Grammar, "MatchIndexer"));
		NameSpace.DefineSyntax("[", LibNative.LoadMatchFunc(Grammar, "MatchArrayLiteral"));
		NameSpace.DefineSyntax("{", LibNative.LoadMatchFunc(Grammar, "MatchMapLiteral"));

		NameSpace.DefineSyntax("$Block$", LibNative.LoadMatchFunc(Grammar, "MatchBlock"));
		NameSpace.DefineSyntax("$Annotation$", LibNative.LoadMatchFunc(Grammar, "MatchAnnotation"));
		NameSpace.DefineSyntax("$Statement$", LibNative.LoadMatchFunc(Grammar, "MatchStatement"));
		NameSpace.DefineSyntax("$Expression$", LibNative.LoadMatchFunc(Grammar, "MatchExpression"));
		NameSpace.DefineSyntax("$SuffixExpression$", LibNative.LoadMatchFunc(Grammar, "MatchSuffixExpression"));

		NameSpace.DefineSyntax("if", LibNative.LoadMatchFunc(Grammar, "MatchIf"));
		NameSpace.DefineSyntax("return", LibNative.LoadMatchFunc(Grammar, "MatchReturn"));
		NameSpace.DefineSyntax("while", LibNative.LoadMatchFunc(Grammar, "MatchWhile"));
		NameSpace.DefineSyntax("break", LibNative.LoadMatchFunc(Grammar, "MatchBreak"));

		NameSpace.DefineSyntax("$Identifier$", LibNative.LoadMatchFunc(Grammar, "MatchIdentifier"));
		NameSpace.DefineSyntax("var",  LibNative.LoadMatchFunc(Grammar, "MatchVarDecl"));
		NameSpace.DefineSyntax("$Param$", LibNative.LoadMatchFunc(Grammar, "MatchParam"));
		NameSpace.DefineSyntax("function", LibNative.LoadMatchFunc(Grammar, "MatchFunction"));
		NameSpace.DefineSyntax("let", LibNative.LoadMatchFunc(Grammar, "MatchLetDecl"));
		NameSpace.Generator.AppendGrammarInfo("zen-0.1");

		NameSpace.DefineSyntax("try", LibNative.LoadMatchFunc(Grammar, "MatchTry"));
		NameSpace.DefineSyntax("$Catch$", LibNative.LoadMatchFunc(Grammar, "MatchCatch"));
		NameSpace.DefineSyntax("throw", LibNative.LoadMatchFunc(Grammar, "MatchThrow"));
		NameSpace.Generator.AppendGrammarInfo("zen-trycatch-0.1");

		NameSpace.DefineSuffixSyntax("instanceof", ZenPrecedence.Instanceof, LibNative.LoadMatchFunc(Grammar, "MatchInstanceOf"));
		NameSpace.DefineSyntax("class", LibNative.LoadMatchFunc(Grammar, "MatchClassDecl"));
		NameSpace.DefineSyntax("$FieldDecl$", LibNative.LoadMatchFunc(Grammar, "MatchFieldDecl"));
		NameSpace.DefineSyntax("import", LibNative.LoadMatchFunc(Grammar, "MatchImport"));
		NameSpace.DefineSyntax("$Path$", LibNative.LoadMatchFunc(Grammar, "MatchPath"));

		NameSpace.Generator.AppendGrammarInfo("zen-class-0.1");
	}

}
