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
import zen.ast.ZEmptyNode;
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
import zen.ast.ZLetNode;
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
import zen.parser.ZParserConst;
import zen.parser.ZPatternToken;
import zen.parser.ZSource;
import zen.parser.ZSyntaxPattern;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.type.ZType;
import zen.type.ZTypePool;

public class ZenGrammar {

	// Token
	public static boolean WhiteSpaceToken(ZSource Source) {
		Source.SkipWhiteSpace();
		return true;
	}

	public static boolean IndentToken(ZSource Source) {
		@Var int StartIndex = Source.GetPosition() + 1;
		Source.MoveNext();
		Source.SkipWhiteSpace();
		Source.FoundIndent(StartIndex, Source.GetPosition());
		return true;
	}

	public static boolean OperatorToken(ZSource Source) {
		Source.Tokenize();
		return true;
	}

	public static boolean SymbolToken(ZSource Source) {
		@Var int StartIndex = Source.GetPosition();
		while(Source.HasChar()) {
			@Var char ch = Source.ParseChar();
			if(!LibZen.IsSymbol(ch) && !LibZen.IsDigit(ch)) {
				break;
			}
			Source.MoveNext();
		}
		Source.Tokenize(StartIndex, Source.GetPosition());
		return true;
	}

	public static boolean NumberLiteralToken(ZSource Source) {
		@Var int StartIndex = Source.GetPosition();
		@Var char ch = 0;
		while(Source.HasChar()) {
			ch = Source.ParseChar();
			if(!LibZen.IsDigit(ch)) {
				break;
			}
			Source.MoveNext();
		}
		if(ch == '.') {
			while(Source.HasChar()) {
				ch = Source.ParseChar();
				if(!LibZen.IsDigit(ch)) {
					break;
				}
				Source.MoveNext();
			}
			Source.Tokenize("$FloatLiteral$", StartIndex, Source.GetPosition());
		}
		else {
			Source.Tokenize("$IntegerLiteral$", StartIndex, Source.GetPosition());
		}
		return true;
	}

	public static boolean StringLiteralToken(ZSource Source) {
		@Var int StartIndex = Source.GetPosition() + 1;
		Source.MoveNext();
		while(Source.HasChar()) {
			@Var char ch = Source.ParseChar();
			if(ch == '\"') {
				Source.Tokenize("$StringLiteral$", StartIndex, Source.GetPosition());
				Source.MoveNext();
				return true;
			}
			if(ch == '\n') {
				break;
			}
			if(ch == '\\') {
				Source.MoveNext();
			}
			Source.MoveNext();
		}
		Source.Warning(StartIndex-1, "unclosed \"");
		Source.Tokenize("$StringLiteral$", StartIndex, Source.GetPosition());
		return false;
	}

	public static boolean CommentToken(ZSource Source) {
		@Var int StartIndex = Source.GetPosition();
		@Var char NextChar = Source.ParseChar(+1);
		if(NextChar != '/' && NextChar != '*') {
			return false;  // another tokenizer
		}
		if(NextChar == '/') { // SingleLineComment
			while(Source.HasChar()) {
				@Var char ch = Source.ParseChar();
				if(ch == '\n') {
					break;
				}
				Source.MoveNext();
			}
			return true;
		}
		@Var int Level = 1;
		@Var char PrevChar = '\0';
		while(Source.HasChar()) {
			NextChar = Source.ParseChar();
			if(NextChar == '/' && PrevChar == '*') {
				if(Level == 1) {
					Source.MoveNext();
					return true;
				}
				Level = Level - 1;
			}
			if(Level > 0) {
				if(NextChar == '*' && PrevChar == '/') {
					Level = Level + 1;
				}
			}
			Source.MoveNext();
			PrevChar = NextChar;
		}
		Source.Warning(StartIndex, "unfound */");
		return true;
	}

	// Match
	public static ZNode MatchNull(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZNullNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
	}

	public static ZNode MatchTrue(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZBooleanNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), true);
	}

	public static ZNode MatchFalse(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZBooleanNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), false);
	}

	public static ZNode MatchIntLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		return new ZIntNode(ParentNode, Token, LibZen.ParseInt(Token.GetText()));
	}

	public static ZNode MatchFloatLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		return new ZFloatNode(ParentNode, Token, LibZen.ParseFloat(Token.GetText()));
	}

	public static ZNode MatchStringLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		return new ZStringNode(ParentNode, Token, LibZen.UnquoteString(Token.GetText()));
	}

	public static ZNode MatchArrayLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZArrayLiteralNode(ParentNode);
		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "[", "$Expression$", ",", "]");
		return LiteralNode;
	}

	public static ZNode MatchMapEntry(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZMapEntryNode(ParentNode);
		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZMapEntryNode.Key, "$Expression$", ZTokenContext.Required);
		LiteralNode = TokenContext.MatchToken(LiteralNode, ":", ZTokenContext.Required);
		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZMapEntryNode.Value, "$Expression$", ZTokenContext.Required);
		return LiteralNode;
	}

	public static ZNode MatchMapLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZMapLiteralNode(ParentNode);
		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "{", "$MapEntry$", ",", "}");
		return LiteralNode;
	}

	public static ZNode MatchNewObject(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZNewObjectNode(ParentNode);
		LiteralNode = TokenContext.MatchToken(LiteralNode, "new", ZTokenContext.Required);
		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZNode.TypeInfo, "$Type$", ZTokenContext.Optional);
		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "(", "$Expression$", ",", ")");
		return LiteralNode;
	}

	public static ZNode MatchType(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		@Var ZTypeNode TypeNode = ParentNode.GetNameSpace().GetTypeNode(Token.GetText(), Token);
		if(TypeNode != null) {
			return TokenContext.ParsePatternAfter(ParentNode, TypeNode, "$TypeSuffix$", ZTokenContext.Optional);
		}
		return null; // Not Matched
	}

	public static ZNode MatchTypeSuffix(ZNode ParentNode, ZTokenContext TokenContext, ZNode TypeNode) {
		@Var ZToken SourceToken = TokenContext.GetToken();
		if(TypeNode.Type.GetParamSize() > 0) {
			if(TokenContext.MatchToken("<")) {  // Generics
				@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
				while(!TokenContext.StartsWithToken(">")) {
					if(TypeList.size() > 0 && !TokenContext.MatchToken(",")) {
						return null;
					}
					@Var ZTypeNode ParamTypeNode = (ZTypeNode) TokenContext.ParsePattern(ParentNode, "$Type$", ZTokenContext.Optional);
					if(ParamTypeNode == null) {
						return TypeNode;
					}
					TypeList.add(ParamTypeNode.Type);
				}
				TypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool.GetGenericType(TypeNode.Type, 0, TypeList, true));
			}
		}
		while(TokenContext.MatchToken("[")) {  // Array
			if(!TokenContext.MatchToken("]")) {
				return null;
			}
			TypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool.GetGenericType1(ZType.ArrayType, TypeNode.Type));
		}
		return TypeNode;
	}

	// PatternName: "("  (1)
	public static ZNode MatchGroup(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode GroupNode = new ZGroupNode(ParentNode);
		GroupNode = TokenContext.MatchToken(GroupNode, "(", ZTokenContext.Required);
		GroupNode = TokenContext.MatchPattern(GroupNode, ZGroupNode.Expr, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
		GroupNode = TokenContext.MatchToken(GroupNode, ")", ZTokenContext.Required);
		return GroupNode;
	}

	public static ZNode MatchCast(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode CastNode = new ZCastNode(ParentNode, ZType.VarType, null);
		CastNode = TokenContext.MatchToken(CastNode, "(", ZTokenContext.Required);
		CastNode = TokenContext.MatchPattern(CastNode, ZNode.TypeInfo, "$Type$", ZTokenContext.Required);
		CastNode = TokenContext.MatchToken(CastNode, ")", ZTokenContext.Required);
		CastNode = TokenContext.MatchPattern(CastNode, ZCastNode.Expr, "$SuffixExpression$", ZTokenContext.Required);
		return CastNode;
	}

	public static ZNode MatchGetter(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		TokenContext.MatchToken(".");
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		if(!Token.IsNameSymbol()) {
			return TokenContext.CreateExpectedErrorNode(Token, "field name");
		}
		if(TokenContext.IsToken("(")) {  // method call
			@Var ZNode MethodCallNode = new ZMethodCallNode(ParentNode, Token, LeftNode, Token.GetText());
			MethodCallNode = TokenContext.MatchNtimes(MethodCallNode, "(", "$Expression$", ",", ")");
			return MethodCallNode;
		}
		if(TokenContext.MatchToken("=")) {
			ZNode SetterNode = new ZSetterNode(ParentNode, Token, LeftNode, Token.GetText());
			SetterNode = TokenContext.MatchPattern(SetterNode, ZSetterNode.Expr, "$Expression$", ZTokenContext.Required);
			return SetterNode;
		}
		else {
			return new ZGetterNode(ParentNode, Token, LeftNode, Token.GetText());
		}
	}

	public static ZNode MatchApply(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ApplyNode = new ZFuncCallNode(ParentNode, LeftNode);
		ApplyNode = TokenContext.MatchNtimes(ApplyNode, "(", "$Expression$", ",", ")");
		return ApplyNode;
	}

	public static ZNode MatchIndexer(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IndexerNode = new ZGetIndexNode(ParentNode, LeftNode);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "[", ZTokenContext.Required);
		IndexerNode = TokenContext.MatchPattern(IndexerNode, ZGetIndexNode.Index, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "]", ZTokenContext.Required);
		if(TokenContext.MatchToken("=") && !IndexerNode.IsErrorNode()) {
			IndexerNode = new ZSetIndexNode((ZGetIndexNode)IndexerNode);
			IndexerNode = TokenContext.MatchPattern(IndexerNode, ZSetIndexNode.Expr, "$Expression$", ZTokenContext.Required);
		}
		return IndexerNode;
	}

	public static ZNode MatchUnary(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode UnaryNode = new ZUnaryNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
		return TokenContext.MatchPattern(UnaryNode, ZUnaryNode.Recv, "$SuffixExpression$", ZTokenContext.Required);
	}

	public static ZNode MatchNot(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode UnaryNode = new ZNotNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
		UnaryNode = TokenContext.MatchPattern(UnaryNode, ZUnaryNode.Recv, "$SuffixExpression$", ZTokenContext.Required);
		return UnaryNode;
	}

	public static ZNode MatchBinary(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		@Var ZBinaryNode BinaryNode = new ZBinaryNode(ParentNode, Token, LeftNode, TokenContext.GetApplyingSyntax());
		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	}

	public static ZNode MatchComparator(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		@Var ZBinaryNode BinaryNode = new ZComparatorNode(ParentNode, Token, LeftNode, TokenContext.GetApplyingSyntax());
		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	}

	public static ZNode MatchAnd(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZBinaryNode BinaryNode = new ZAndNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), LeftNode, TokenContext.GetApplyingSyntax());
		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	}

	public static ZNode MatchOr(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZBinaryNode BinaryNode = new ZOrNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), LeftNode, TokenContext.GetApplyingSyntax());
		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	}

	public static ZNode MatchInstanceOf(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BinaryNode = new ZInstanceOfNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), LeftNode, TokenContext.GetApplyingSyntax());
		BinaryNode = TokenContext.MatchPattern(BinaryNode, ZBinaryNode.Right, "$Type$", ZTokenContext.Required);
		return BinaryNode;
	}

	private static ZSyntaxPattern GetSuffixPattern(ZNameSpace NameSpace, ZTokenContext TokenContext) {
		@Var ZToken Token = TokenContext.GetToken();
		if(Token != ZToken.NullToken) {
			@Var ZSyntaxPattern Pattern = NameSpace.GetSuffixSyntaxPattern(Token.GetText());
			return Pattern;
		}
		return null;
	}

	public static ZNode MatchSymbolStatement(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken NameToken = TokenContext.GetToken(ZTokenContext.MoveNext);
		if(TokenContext.MatchToken("=")) {
			@Var ZNode AssignedNode = new ZSetNameNode(ParentNode, NameToken, NameToken.GetText());
			AssignedNode = TokenContext.MatchPattern(AssignedNode, ZSetNameNode.Expr, "$Expression$", ZTokenContext.Required);
			return AssignedNode;
		}
		else {
			return new ZGetNameNode(ParentNode, NameToken, NameToken.GetText());
		}
	}

	public static ZNode MatchSymbolExpression(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken NameToken = TokenContext.GetToken(ZTokenContext.MoveNext);
		if(TokenContext.IsToken("=")) {
			return new ZErrorNode(ParentNode, TokenContext.GetToken(), "assignment is not en expression");
		}
		else {
			return new ZGetNameNode(ParentNode, NameToken, NameToken.GetText());
		}
	}

	private static ZNode DispatchPattern(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode, boolean AllowStatement, boolean AllowBinary) {
		@Var ZToken Token = TokenContext.GetToken();
		@Var ZSyntaxPattern Pattern = null;
		@Var ZNameSpace NameSpace = ParentNode.GetNameSpace();
		if(Token instanceof ZPatternToken) {
			Pattern = ((ZPatternToken)Token).PresetPattern;
		}
		else {
			Pattern = NameSpace.GetSyntaxPattern(Token.GetText());
		}
		//System.out.println("Pattern=" + Pattern + " by '" + Token.GetText() + "'");
		if(Pattern != null) {
			if(Pattern.IsStatement && !AllowStatement) {
				return new ZErrorNode(ParentNode, Token, Token.GetText() + " statement is not here");
			}
			LeftNode = TokenContext.ApplyMatchPattern(ParentNode, LeftNode, Pattern, ZTokenContext.Required);
		}
		else {
			if(Token.IsNameSymbol()) {
				if(AllowStatement) {
					Pattern = NameSpace.GetSyntaxPattern("$SymbolStatement$");
				}
				else {
					Pattern = NameSpace.GetSyntaxPattern("$SymbolExpression$");
				}
				LeftNode = TokenContext.ApplyMatchPattern(ParentNode, LeftNode, Pattern, ZTokenContext.Required);
			}
			else {
				if(AllowStatement) {
					return TokenContext.CreateExpectedErrorNode(Token, "statement");
				}
				else {
					return TokenContext.CreateExpectedErrorNode(Token, "expression");
				}
			}
		}
		if(!Pattern.IsStatement) {
			while(LeftNode != null && !LeftNode.IsErrorNode()) {
				@Var ZSyntaxPattern SuffixPattern = ZenGrammar.GetSuffixPattern(NameSpace, TokenContext);
				if(SuffixPattern == null) {
					break;
				}
				if(!AllowBinary && SuffixPattern.IsBinaryOperator()) {
					break;
				}
				LeftNode = TokenContext.ApplyMatchPattern(ParentNode, LeftNode, SuffixPattern, ZTokenContext.Required);
			}
		}
		return LeftNode;
	}


	public static ZNode MatchExpression(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return ZenGrammar.DispatchPattern(ParentNode, TokenContext, LeftNode, false, true);
	}

	public static ZNode MatchSuffixExpression(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return ZenGrammar.DispatchPattern(ParentNode, TokenContext, LeftNode, false, false);
	}

	public static ZNode MatchStatement(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var boolean Rememberd = TokenContext.SetParseFlag(ZTokenContext.AllowSkipIndent);
		//		@Var ZAnnotationNode AnnotationNode = (ZAnnotationNode)TokenContext.ParsePattern(ParentNode, "$Annotation$", ZTokenContext.Optional2);
		TokenContext.SetParseFlag(ZTokenContext.NotAllowSkipIndent);
		@Var ZNode StmtNode = ZenGrammar.DispatchPattern(ParentNode, TokenContext, null, true, true);
		StmtNode = TokenContext.MatchPattern(StmtNode, ZNode.Nop, ";", ZTokenContext.Required);
		//		if(AnnotationNode != null) {
		//			AnnotationNode.Append(StmtNode);
		//			StmtNode = AnnotationNode;
		//		}
		TokenContext.SetParseFlag(Rememberd);
		return StmtNode;
	}

	public static ZNode MatchBlock(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BlockNode = new ZBlockNode(ParentNode, 0);
		@Var ZToken SkipToken = TokenContext.GetToken();
		BlockNode = TokenContext.MatchToken(BlockNode, "{", ZTokenContext.Required);
		if(!BlockNode.IsErrorNode()) {
			@Var boolean Remembered = TokenContext.SetParseFlag(ZTokenContext.AllowSkipIndent); // init
			@Var ZNode NestedBlockNode = BlockNode;
			while(TokenContext.HasNext()) {
				//System.out.println("Token :" + TokenContext.GetToken());
				if(TokenContext.MatchToken("}")) {
					break;
				}
				@Var ZNode StmtNode = TokenContext.MatchPattern(NestedBlockNode, ZNode.AppendIndex, "$Statement$", ZTokenContext.Required);
				if(StmtNode.IsErrorNode()) {
					NestedBlockNode.Set(ZNode.AppendIndex, StmtNode);
					TokenContext.SkipError(SkipToken);
					TokenContext.MatchToken("}");
					break;
				}
				/* VarDecl is defined as BlockNode to speficy its scope */
				if(StmtNode instanceof ZBlockNode) {
					//System.out.println("nesting scope " + ParsedNode);
					NestedBlockNode = StmtNode;
				}
			}
			TokenContext.SetParseFlag(Remembered);
		}
		return BlockNode;
	}

	public static ZNode MatchIf(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IfNode = new ZIfNode(ParentNode);
		IfNode = TokenContext.MatchToken(IfNode, "if", ZTokenContext.Required);
		IfNode = TokenContext.MatchToken(IfNode, "(", ZTokenContext.Required);
		IfNode = TokenContext.MatchPattern(IfNode, ZIfNode.Cond, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowNewLine);
		IfNode = TokenContext.MatchToken(IfNode, ")", ZTokenContext.Required);
		IfNode = TokenContext.MatchPattern(IfNode, ZIfNode.Then, "$Block$", ZTokenContext.Required);
		if(TokenContext.MatchNewLineToken("else")) {
			String PatternName = "$Block$";
			if(TokenContext.IsNewLineToken("if")) {
				PatternName = "if";
			}
			IfNode = TokenContext.MatchPattern(IfNode, ZIfNode.Else, PatternName, ZTokenContext.Required);
		}
		return IfNode;
	}

	public static ZNode MatchReturn(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ReturnNode = new ZReturnNode(ParentNode);
		ReturnNode = TokenContext.MatchToken(ReturnNode, "return", ZTokenContext.Required);
		ReturnNode = TokenContext.MatchPattern(ReturnNode, ZReturnNode.Expr, "$Expression$", ZTokenContext.Optional);
		return ReturnNode;
	}

	public static ZNode MatchWhile(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode WhileNode = new ZWhileNode(ParentNode);
		WhileNode = TokenContext.MatchToken(WhileNode, "while", ZTokenContext.Required);
		WhileNode = TokenContext.MatchToken(WhileNode, "(", ZTokenContext.Required);
		WhileNode = TokenContext.MatchPattern(WhileNode, ZWhileNode.Cond, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
		WhileNode = TokenContext.MatchToken(WhileNode, ")", ZTokenContext.Required);
		WhileNode = TokenContext.MatchPattern(WhileNode, ZWhileNode.Block, "$Block$", ZTokenContext.Required);
		return WhileNode;
	}

	public static ZNode MatchBreak(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BreakNode = new ZBreakNode(ParentNode);
		BreakNode = TokenContext.MatchToken(BreakNode, "break", ZTokenContext.Required);
		return BreakNode;
	}

	public static ZNode MatchCatch(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode CatchNode = new ZCatchNode(ParentNode);
		CatchNode = TokenContext.MatchToken(CatchNode, "catch", ZTokenContext.Required);
		CatchNode = TokenContext.MatchToken(CatchNode, "(", ZTokenContext.Required);
		CatchNode = TokenContext.MatchPattern(CatchNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		CatchNode = TokenContext.MatchToken(CatchNode, ")", ZTokenContext.Required);
		CatchNode = TokenContext.MatchPattern(CatchNode, ZCatchNode.Block, "$Block$", ZTokenContext.Required);
		return CatchNode;
	}

	public static ZNode MatchTry(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode TryNode = new ZTryNode(ParentNode);
		TryNode = TokenContext.MatchToken(TryNode, "try", ZTokenContext.Required);
		TryNode = TokenContext.MatchPattern(TryNode, ZTryNode.Try, "$Block$", ZTokenContext.Required);
		int count = 0;
		if(TokenContext.IsNewLineToken("catch")) {
			TryNode = TokenContext.MatchPattern(TryNode, ZTryNode.Catch, "$Catch$", ZTokenContext.Required);
			count = count + 1;
		}
		if(TokenContext.MatchNewLineToken("finally")) {
			TryNode = TokenContext.MatchPattern(TryNode, ZTryNode.Finally, "$Block$", ZTokenContext.Required);
			count = count + 1;
		}
		if(count == 0 && !TryNode.IsErrorNode()) {
			return TryNode.AST[ZTryNode.Try]; // no catch and finally
		}
		return TryNode;

	}

	public static ZNode MatchThrow(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ThrowNode = new ZThrowNode(ParentNode);
		ThrowNode = TokenContext.MatchToken(ThrowNode, "throw", ZTokenContext.Required);
		ThrowNode = TokenContext.MatchPattern(ThrowNode, ZThrowNode.Expr, "$Expression$", ZTokenContext.Required);
		return ThrowNode;
	}

	public static ZNode MatchLetDecl(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LetNode = new ZLetNode(ParentNode);
		LetNode = TokenContext.MatchToken(LetNode, "let", ZTokenContext.Required);
		LetNode = TokenContext.MatchPattern(LetNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		//		if(TokenContext.MatchToken(".")) {
		//			LetNode = TokenContext.MatchPattern(LetNode, "$Name$", ZTokenContext.Required);
		//		}
		LetNode = TokenContext.MatchPattern(LetNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		LetNode = TokenContext.MatchToken(LetNode, "=", ZTokenContext.Required);
		LetNode = TokenContext.MatchPattern(LetNode, ZLetNode.InitValue, "$Expression$", ZTokenContext.Required);
		return LetNode;
	}

	public static ZNode MatchName(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		if(LibZen.IsVariableName(Token.GetText(), 0)) {
			return new ZGetNameNode(ParentNode, Token, Token.GetText());
		}
		return new ZErrorNode(ParentNode, Token, "illegal name: '" + Token.GetText() + "'");
	}

	public static ZNode MatchTypeAnnotation(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		if(TokenContext.MatchToken(":")) {
			return TokenContext.ParsePattern(ParentNode, "$Type$", ZTokenContext.Required);
		}
		return null;
	}

	// "var" $Name [: $Type$] "=" $Expression$
	public static ZNode MatchVarDecl(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode VarNode = new ZVarDeclNode(ParentNode);
		VarNode = TokenContext.MatchToken(VarNode, "var", ZTokenContext.Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		VarNode = TokenContext.MatchToken(VarNode, "=", ZTokenContext.Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZVarDeclNode.InitValue, "$Expression$", ZTokenContext.Required);
		return VarNode;
	}

	// FuncDecl
	public static ZNode MatchParam(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ParamNode = new ZParamNode(ParentNode);
		ParamNode = TokenContext.MatchPattern(ParamNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		ParamNode = TokenContext.MatchPattern(ParamNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		return ParamNode;
	}

	public static ZNode MatchFunction(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode FuncNode = new ZFunctionNode(ParentNode);
		FuncNode = TokenContext.MatchToken(FuncNode, "function", ZTokenContext.Required);
		FuncNode = TokenContext.MatchPattern(FuncNode, ZNode.NameInfo, "$Name$", ZTokenContext.Optional);
		FuncNode = TokenContext.MatchNtimes(FuncNode, "(", "$Param$", ",", ")");
		FuncNode = TokenContext.MatchPattern(FuncNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		FuncNode = TokenContext.MatchPattern(FuncNode, ZFunctionNode.Block, "$Block$", ZTokenContext.Required);
		return FuncNode;
	}

	public static ZNode MatchAnnotation(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZenMap<Object> Anno = null;
		@Var ZToken Token = null;
		while(TokenContext.MatchToken("@")) {
			Token = TokenContext.GetToken(ZTokenContext.MoveNext);
			if(Anno == null) {
				Anno = new ZenMap<Object>(null);
			}
			Anno.put(Token.GetText(), Token);
			TokenContext.SkipIndent();
		}
		if(Anno != null) {
			return new ZAnnotationNode(ParentNode, Token, Anno);
		}
		return null;
	}

	public static ZNode MatchEndOfStatement(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var boolean ContextAllowance = TokenContext.SetParseFlag(false);
		@Var ZToken Token = null;
		if(TokenContext.HasNext()) {
			Token = TokenContext.GetToken();
			if(!Token.EqualsText(';') && !Token.IsIndent()) {
				TokenContext.SetParseFlag(ContextAllowance);
				return TokenContext.CreateExpectedErrorNode(Token, ";");
			}
			TokenContext.MoveNext();
			while(TokenContext.HasNext()) {
				Token = TokenContext.GetToken();
				if(!Token.EqualsText(';') && !Token.IsIndent()) {
					break;
				}
				TokenContext.MoveNext();
			}
		}
		TokenContext.SetParseFlag(ContextAllowance);
		return new ZEmptyNode(ParentNode, Token);
	}

	// "var" $Name [: $Type$] "=" $Expression$
	public static ZNode MatchFieldDecl(ZNode ParentNode, ZTokenContext TokenContext, ZNode ClassNode) {
		@Var boolean Rememberd = TokenContext.SetParseFlag(false);
		@Var ZNode FieldNode = new ZFieldNode(ParentNode);
		FieldNode = TokenContext.MatchToken(FieldNode, "field", ZTokenContext.Required);
		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		if(TokenContext.MatchToken("=")) {
			FieldNode = TokenContext.MatchPattern(FieldNode, ZFieldNode.InitValue, "$Expression$", ZTokenContext.Required);
		}
		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode.Nop, ";", ZTokenContext.Required);
		TokenContext.SetParseFlag(Rememberd);
		return FieldNode;
	}

	public static ZNode MatchClassDecl(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ClassNode = new ZClassDeclNode(ParentNode);
		ClassNode = TokenContext.MatchToken(ClassNode, "class", ZTokenContext.Required);
		ClassNode = TokenContext.MatchPattern(ClassNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		if(TokenContext.MatchNewLineToken("extends")) {
			ClassNode = TokenContext.MatchPattern(ClassNode, ZNode.TypeInfo, "$Type$", ZTokenContext.Required);
		}
		ClassNode = TokenContext.MatchNtimes(ClassNode, "{", "$FieldDecl$", null, "}");
		return ClassNode;
	}

	public static ZNode MatchPath(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.ParseLargeToken();
		return new ZGetNameNode(ParentNode, Token, Token.GetText());
	}

	public static ZNode MatchImport(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ImportNode = TokenContext.Generator.CreateImportNode(ParentNode);
		ImportNode = TokenContext.MatchToken(ImportNode, "import", ZTokenContext.Required);
		ImportNode = TokenContext.MatchPattern(ImportNode, ZNode.NameInfo, "$Path$", ZTokenContext.Required);
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
		NameSpace.AppendTokenFunc("{}()[]<>.,;?:+-*/%=&|!@~^$", LibNative.LoadTokenFunc(Grammar, "OperatorToken"));
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

		//		NameSpace.DefineSyntax("$Error$", LibNative.LoadMatchFunc(Grammar, "MatchError"));
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
		NameSpace.DefineSyntax("$MapEntry$", LibNative.LoadMatchFunc(Grammar, "MatchMapEntry"));
		NameSpace.DefineSyntax("{", LibNative.LoadMatchFunc(Grammar, "MatchMapLiteral"));
		NameSpace.DefineSyntax("new", LibNative.LoadMatchFunc(Grammar, "MatchNewObject"));

		NameSpace.DefineStatement(";", LibNative.LoadMatchFunc(Grammar, "MatchEndOfStatement"));
		NameSpace.DefineSyntax("$Block$", LibNative.LoadMatchFunc(Grammar, "MatchBlock"));
		NameSpace.DefineSyntax("$Annotation$", LibNative.LoadMatchFunc(Grammar, "MatchAnnotation"));
		NameSpace.DefineSyntax("$SymbolExpression$", LibNative.LoadMatchFunc(Grammar, "MatchSymbolExpression"));
		// don't change DefineStatement for $SymbolStatement$
		NameSpace.DefineSyntax("$SymbolStatement$", LibNative.LoadMatchFunc(Grammar, "MatchSymbolStatement"));
		NameSpace.DefineSyntax("$Statement$", LibNative.LoadMatchFunc(Grammar, "MatchStatement"));
		NameSpace.DefineSyntax("$Expression$", LibNative.LoadMatchFunc(Grammar, "MatchExpression"));
		NameSpace.DefineSyntax("$SuffixExpression$", LibNative.LoadMatchFunc(Grammar, "MatchSuffixExpression"));

		NameSpace.DefineStatement("if", LibNative.LoadMatchFunc(Grammar, "MatchIf"));
		NameSpace.DefineStatement("return", LibNative.LoadMatchFunc(Grammar, "MatchReturn"));
		NameSpace.DefineStatement("while", LibNative.LoadMatchFunc(Grammar, "MatchWhile"));
		NameSpace.DefineStatement("break", LibNative.LoadMatchFunc(Grammar, "MatchBreak"));

		NameSpace.DefineSyntax("$Name$", LibNative.LoadMatchFunc(Grammar, "MatchName"));
		NameSpace.DefineStatement("var",  LibNative.LoadMatchFunc(Grammar, "MatchVarDecl"));
		NameSpace.DefineSyntax("$Param$", LibNative.LoadMatchFunc(Grammar, "MatchParam"));
		NameSpace.DefineSyntax("function", LibNative.LoadMatchFunc(Grammar, "MatchFunction"));
		NameSpace.DefineStatement("let", LibNative.LoadMatchFunc(Grammar, "MatchLetDecl"));
		NameSpace.Generator.AppendGrammarInfo("zen-0.1");

		NameSpace.DefineStatement("try", LibNative.LoadMatchFunc(Grammar, "MatchTry"));
		NameSpace.DefineSyntax("$Catch$", LibNative.LoadMatchFunc(Grammar, "MatchCatch"));
		NameSpace.DefineStatement("throw", LibNative.LoadMatchFunc(Grammar, "MatchThrow"));
		NameSpace.Generator.AppendGrammarInfo("zen-trycatch-0.1");

		NameSpace.DefineSuffixSyntax("instanceof", ZenPrecedence.Instanceof, LibNative.LoadMatchFunc(Grammar, "MatchInstanceOf"));
		NameSpace.DefineStatement("class", LibNative.LoadMatchFunc(Grammar, "MatchClassDecl"));
		NameSpace.DefineSyntax("$FieldDecl$", LibNative.LoadMatchFunc(Grammar, "MatchFieldDecl"));
		NameSpace.DefineStatement("import", LibNative.LoadMatchFunc(Grammar, "MatchImport"));
		NameSpace.DefineSyntax("$Path$", LibNative.LoadMatchFunc(Grammar, "MatchPath"));

		NameSpace.Generator.AppendGrammarInfo("zen-class-0.1");
	}

}
