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
package zen.deps;
import libzen.grammar.AndPattern;
import libzen.grammar.AnnotationPattern;
import libzen.grammar.ApplyPattern;
import libzen.grammar.ArrayLiteralPattern;
import libzen.grammar.BinaryPattern;
import libzen.grammar.BlockComment;
import libzen.grammar.BlockPattern;
import libzen.grammar.BreakPattern;
import libzen.grammar.CastPattern;
import libzen.grammar.CatchPattern;
import libzen.grammar.ClassPattern;
import libzen.grammar.ComparatorPattern;
import libzen.grammar.ExpressionPattern;
import libzen.grammar.FalsePattern;
import libzen.grammar.FieldPattern;
import libzen.grammar.FloatLiteralPattern;
import libzen.grammar.FunctionPattern;
import libzen.grammar.GetterPattern;
import libzen.grammar.GroupPattern;
import libzen.grammar.IfPattern;
import libzen.grammar.ImportPattern;
import libzen.grammar.IndexerPattern;
import libzen.grammar.InstanceOfPattern;
import libzen.grammar.IntLiteralPattern;
import libzen.grammar.LetPattern;
import libzen.grammar.MapEntryPattern;
import libzen.grammar.MapLiteralPattern;
import libzen.grammar.NamePattern;
import libzen.grammar.NameToken;
import libzen.grammar.NewLineToken;
import libzen.grammar.NewObjectPattern;
import libzen.grammar.NotPattern;
import libzen.grammar.NullPattern;
import libzen.grammar.NumberLiteralToken;
import libzen.grammar.OperatorToken;
import libzen.grammar.OrPattern;
import libzen.grammar.ParamPattern;
import libzen.grammar.PathPattern;
import libzen.grammar.ReturnPattern;
import libzen.grammar.StatementEndPattern;
import libzen.grammar.StatementPattern;
import libzen.grammar.StringLiteralPattern;
import libzen.grammar.StringLiteralToken;
import libzen.grammar.SuffixExpressionPattern;
import libzen.grammar.SymbolExpressionPattern;
import libzen.grammar.SymbolStatementPattern;
import libzen.grammar.ThrowPattern;
import libzen.grammar.TruePattern;
import libzen.grammar.TryPattern;
import libzen.grammar.TypeAnnotationPattern;
import libzen.grammar.TypePattern;
import libzen.grammar.TypeSuffixPattern;
import libzen.grammar.UnaryPattern;
import libzen.grammar.VarPattern;
import libzen.grammar.WhilePattern;
import libzen.grammar.WhiteSpaceToken;
import zen.lang.ZenPrecedence;
import zen.parser.ZNameSpace;
import zen.parser.ZParserConst;
import zen.type.ZType;

public class KonohaGrammar {
	// Token
	//	public static boolean WhiteSpaceToken(ZSourceContext SourceContext) {
	//		SourceContext.SkipWhiteSpace();
	//		return true;
	//	}
	//
	//	public static boolean IndentToken(ZSourceContext SourceContext) {
	//		@Var int StartIndex = SourceContext.GetPosition() + 1;
	//		SourceContext.MoveNext();
	//		SourceContext.SkipWhiteSpace();
	//		SourceContext.FoundIndent(StartIndex, SourceContext.GetPosition());
	//		return true;
	//	}
	//
	//	public static boolean OperatorToken(ZSourceContext SourceContext) {
	//		SourceContext.TokenizeDefinedSymbol(SourceContext.GetPosition());
	//		return true;
	//	}
	//
	//	public static boolean SymbolToken(ZSourceContext SourceContext) {
	//		@Var int StartIndex = SourceContext.GetPosition();
	//		while(SourceContext.HasChar()) {
	//			@Var char ch = SourceContext.ParseChar();
	//			if(!LibZen.IsSymbol(ch) && !LibZen.IsDigit(ch)) {
	//				break;
	//			}
	//			SourceContext.MoveNext();
	//		}
	//		SourceContext.Tokenize(StartIndex, SourceContext.GetPosition());
	//		return true;
	//	}
	//
	//	public static boolean NumberLiteralToken(ZSourceContext SourceContext) {
	//		@Var int StartIndex = SourceContext.GetPosition();
	//		@Var char ch = 0;
	//		while(SourceContext.HasChar()) {
	//			ch = SourceContext.ParseChar();
	//			if(!LibZen.IsDigit(ch)) {
	//				break;
	//			}
	//			SourceContext.MoveNext();
	//		}
	//		if(ch == '.') {
	//			while(SourceContext.HasChar()) {
	//				ch = SourceContext.ParseChar();
	//				if(!LibZen.IsDigit(ch)) {
	//					break;
	//				}
	//				SourceContext.MoveNext();
	//			}
	//			SourceContext.Tokenize("$FloatLiteral$", StartIndex, SourceContext.GetPosition());
	//		}
	//		else {
	//			SourceContext.Tokenize("$IntegerLiteral$", StartIndex, SourceContext.GetPosition());
	//		}
	//		return true;
	//	}
	//
	//	public static boolean StringLiteralToken(ZSourceContext SourceContext) {
	//		@Var int StartIndex = SourceContext.GetPosition() + 1;
	//		SourceContext.MoveNext();
	//		while(SourceContext.HasChar()) {
	//			@Var char ch = SourceContext.ParseChar();
	//			if(ch == '\"') {
	//				SourceContext.Tokenize("$StringLiteral$", StartIndex, SourceContext.GetPosition());
	//				SourceContext.MoveNext();
	//				return true;
	//			}
	//			if(ch == '\n') {
	//				break;
	//			}
	//			if(ch == '\\') {
	//				SourceContext.MoveNext();
	//			}
	//			SourceContext.MoveNext();
	//		}
	//		SourceContext.Warning(StartIndex-1, "unclosed \"");
	//		SourceContext.Tokenize("$StringLiteral$", StartIndex, SourceContext.GetPosition());
	//		return false;
	//	}
	//
	//	public static boolean CommentToken(ZSourceContext SourceContext) {
	//		@Var int StartIndex = SourceContext.GetPosition();
	//		@Var char NextChar = SourceContext.ParseChar(+1);
	//		if(NextChar != '/' && NextChar != '*') {
	//			return false;  // another tokenizer
	//		}
	//		if(NextChar == '/') { // SingleLineComment
	//			while(SourceContext.HasChar()) {
	//				@Var char ch = SourceContext.ParseChar();
	//				if(ch == '\n') {
	//					break;
	//				}
	//				SourceContext.MoveNext();
	//			}
	//			return true;
	//		}
	//		@Var int Level = 1;
	//		@Var char PrevChar = '\0';
	//		while(SourceContext.HasChar()) {
	//			NextChar = SourceContext.ParseChar();
	//			if(NextChar == '/' && PrevChar == '*') {
	//				if(Level == 1) {
	//					SourceContext.MoveNext();
	//					return true;
	//				}
	//				Level = Level - 1;
	//			}
	//			if(Level > 0) {
	//				if(NextChar == '*' && PrevChar == '/') {
	//					Level = Level + 1;
	//				}
	//			}
	//			SourceContext.MoveNext();
	//			PrevChar = NextChar;
	//		}
	//		SourceContext.Warning(StartIndex, "unfound */");
	//		return true;
	//	}

	// Match
	//	public static ZNode MatchNull(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		return new ZNullNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
	//	}

	//	public static ZNode MatchTrue(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		return new ZBooleanNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), true);
	//	}
	//
	//	public static ZNode MatchFalse(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		return new ZBooleanNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), false);
	//	}
	//
	//	public static ZNode MatchIntLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		return new ZIntNode(ParentNode, Token, LibZen.ParseInt(Token.GetText()));
	//	}
	//
	//	public static ZNode MatchFloatLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		return new ZFloatNode(ParentNode, Token, LibZen.ParseFloat(Token.GetText()));
	//	}
	//
	//	public static ZNode MatchStringLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		return new ZStringNode(ParentNode, Token, LibZen.UnquoteString(Token.GetText()));
	//	}
	//
	//	public static ZNode MatchArrayLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode LiteralNode = new ZArrayLiteralNode(ParentNode);
	//		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "[", "$Expression$", ",", "]");
	//		return LiteralNode;
	//	}
	//
	//	public static ZNode MatchMapEntry(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode LiteralNode = new ZMapEntryNode(ParentNode);
	//		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZMapEntryNode.Key, "$Expression$", ZTokenContext.Required);
	//		LiteralNode = TokenContext.MatchToken(LiteralNode, ":", ZTokenContext.Required);
	//		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZMapEntryNode.Value, "$Expression$", ZTokenContext.Required);
	//		return LiteralNode;
	//	}
	//
	//	public static ZNode MatchMapLiteral(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode LiteralNode = new ZMapLiteralNode(ParentNode);
	//		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "{", "$MapEntry$", ",", "}");
	//		return LiteralNode;
	//	}
	//
	//	public static ZNode MatchNewObject(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode LiteralNode = new ZNewObjectNode(ParentNode);
	//		LiteralNode = TokenContext.MatchToken(LiteralNode, "new", ZTokenContext.Required);
	//		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZNode.TypeInfo, "$Type$", ZTokenContext.Optional);
	//		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "(", "$Expression$", ",", ")");
	//		return LiteralNode;
	//	}
	//
	//	public static ZNode MatchType(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		@Var ZTypeNode TypeNode = ParentNode.GetNameSpace().GetTypeNode(Token.GetText(), Token);
	//		if(TypeNode != null) {
	//			return TokenContext.ParsePatternAfter(ParentNode, TypeNode, "$TypeSuffix$", ZTokenContext.Optional);
	//		}
	//		return null; // Not Matched
	//	}
	//
	//	public static ZNode MatchTypeSuffix(ZNode ParentNode, ZTokenContext TokenContext, ZNode TypeNode) {
	//		@Var ZToken SourceToken = TokenContext.GetToken();
	//		if(TypeNode.Type.GetParamSize() > 0) {
	//			if(TokenContext.MatchToken("<")) {  // Generics
	//				@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
	//				while(!TokenContext.StartsWithToken(">")) {
	//					if(TypeList.size() > 0 && !TokenContext.MatchToken(",")) {
	//						return null;
	//					}
	//					@Var ZTypeNode ParamTypeNode = (ZTypeNode) TokenContext.ParsePattern(ParentNode, "$Type$", ZTokenContext.Optional);
	//					if(ParamTypeNode == null) {
	//						return TypeNode;
	//					}
	//					TypeList.add(ParamTypeNode.Type);
	//				}
	//				TypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool.GetGenericType(TypeNode.Type, 0, TypeList, true));
	//			}
	//		}
	//		while(TokenContext.MatchToken("[")) {  // Array
	//			if(!TokenContext.MatchToken("]")) {
	//				return null;
	//			}
	//			TypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool.GetGenericType1(ZType.ArrayType, TypeNode.Type));
	//		}
	//		return TypeNode;
	//	}
	//
	//	// PatternName: "("  (1)
	//	public static ZNode MatchGroup(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode GroupNode = new ZGroupNode(ParentNode);
	//		GroupNode = TokenContext.MatchToken(GroupNode, "(", ZTokenContext.Required);
	//		GroupNode = TokenContext.MatchPattern(GroupNode, ZGroupNode.Expr, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
	//		GroupNode = TokenContext.MatchToken(GroupNode, ")", ZTokenContext.Required);
	//		return GroupNode;
	//	}
	//
	//	public static ZNode MatchCast(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode CastNode = new ZCastNode(ParentNode, ZType.VarType, null);
	//		CastNode = TokenContext.MatchToken(CastNode, "(", ZTokenContext.Required);
	//		CastNode = TokenContext.MatchPattern(CastNode, ZNode.TypeInfo, "$Type$", ZTokenContext.Required);
	//		CastNode = TokenContext.MatchToken(CastNode, ")", ZTokenContext.Required);
	//		CastNode = TokenContext.MatchPattern(CastNode, ZCastNode.Expr, "$SuffixExpression$", ZTokenContext.Required);
	//		return CastNode;
	//	}
	//
	//	public static ZNode MatchGetter(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		TokenContext.MatchToken(".");
	//		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		if(!Token.IsNameSymbol()) {
	//			return TokenContext.CreateExpectedErrorNode(Token, "field name");
	//		}
	//		if(TokenContext.IsToken("(")) {  // method call
	//			@Var ZNode MethodCallNode = new ZMethodCallNode(ParentNode, Token, LeftNode, Token.GetText());
	//			MethodCallNode = TokenContext.MatchNtimes(MethodCallNode, "(", "$Expression$", ",", ")");
	//			return MethodCallNode;
	//		}
	//		if(TokenContext.MatchToken("=")) {
	//			ZNode SetterNode = new ZSetterNode(ParentNode, Token, LeftNode, Token.GetText());
	//			SetterNode = TokenContext.MatchPattern(SetterNode, ZSetterNode.Expr, "$Expression$", ZTokenContext.Required);
	//			return SetterNode;
	//		}
	//		else {
	//			return new ZGetterNode(ParentNode, Token, LeftNode, Token.GetText());
	//		}
	//	}
	//
	//	public static ZNode MatchApply(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode ApplyNode = new ZFuncCallNode(ParentNode, LeftNode);
	//		ApplyNode = TokenContext.MatchNtimes(ApplyNode, "(", "$Expression$", ",", ")");
	//		return ApplyNode;
	//	}
	//
	//	public static ZNode MatchIndexer(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode IndexerNode = new ZGetIndexNode(ParentNode, LeftNode);
	//		IndexerNode = TokenContext.MatchToken(IndexerNode, "[", ZTokenContext.Required);
	//		IndexerNode = TokenContext.MatchPattern(IndexerNode, ZGetIndexNode.Index, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
	//		IndexerNode = TokenContext.MatchToken(IndexerNode, "]", ZTokenContext.Required);
	//		if(TokenContext.MatchToken("=") && !IndexerNode.IsErrorNode()) {
	//			IndexerNode = new ZSetIndexNode((ZGetIndexNode)IndexerNode);
	//			IndexerNode = TokenContext.MatchPattern(IndexerNode, ZSetIndexNode.Expr, "$Expression$", ZTokenContext.Required);
	//		}
	//		return IndexerNode;
	//	}
	//
	//	public static ZNode MatchUnary(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode UnaryNode = new ZUnaryNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
	//		return TokenContext.MatchPattern(UnaryNode, ZUnaryNode.Recv, "$SuffixExpression$", ZTokenContext.Required);
	//	}
	//
	//	public static ZNode MatchNot(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode UnaryNode = new ZNotNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
	//		UnaryNode = TokenContext.MatchPattern(UnaryNode, ZUnaryNode.Recv, "$SuffixExpression$", ZTokenContext.Required);
	//		return UnaryNode;
	//	}
	//
	//	public static ZNode MatchBinary(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		@Var ZBinaryNode BinaryNode = new ZBinaryNode(ParentNode, Token, LeftNode, TokenContext.GetApplyingSyntax());
	//		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	//	}
	//
	//	public static ZNode MatchComparator(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		@Var ZBinaryNode BinaryNode = new ZComparatorNode(ParentNode, Token, LeftNode, TokenContext.GetApplyingSyntax());
	//		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	//	}
	//
	//	public static ZNode MatchAnd(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZBinaryNode BinaryNode = new ZAndNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), LeftNode, TokenContext.GetApplyingSyntax());
	//		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	//	}
	//
	//	public static ZNode MatchOr(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZBinaryNode BinaryNode = new ZOrNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), LeftNode, TokenContext.GetApplyingSyntax());
	//		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	//	}
	//
	//	public static ZNode MatchInstanceOf(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode BinaryNode = new ZInstanceOfNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), LeftNode, TokenContext.GetApplyingSyntax());
	//		BinaryNode = TokenContext.MatchPattern(BinaryNode, ZBinaryNode.Right, "$Type$", ZTokenContext.Required);
	//		return BinaryNode;
	//	}
	//
	//
	//	public static ZNode MatchSymbolStatement(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken NameToken = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		if(TokenContext.MatchToken("=")) {
	//			@Var ZNode AssignedNode = new ZSetNameNode(ParentNode, NameToken, NameToken.GetText());
	//			AssignedNode = TokenContext.MatchPattern(AssignedNode, ZSetNameNode.Expr, "$Expression$", ZTokenContext.Required);
	//			return AssignedNode;
	//		}
	//		else {
	//			return new ZGetNameNode(ParentNode, NameToken, NameToken.GetText());
	//		}
	//	}
	//
	//	public static ZNode MatchSymbolExpression(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken NameToken = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		if(TokenContext.IsToken("=")) {
	//			return new ZErrorNode(ParentNode, TokenContext.GetToken(), "assignment is not en expression");
	//		}
	//		else {
	//			return new ZGetNameNode(ParentNode, NameToken, NameToken.GetText());
	//		}
	//	}
	//	public static ZNode MatchExpression(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		return ZenGrammar.DispatchPattern(ParentNode, TokenContext, LeftNode, false, true);
	//	}
	//
	//	public static ZNode MatchSuffixExpression(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		return ZenGrammar.DispatchPattern(ParentNode, TokenContext, LeftNode, false, false);
	//	}
	//
	//	public static ZNode MatchStatement(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var boolean Rememberd = TokenContext.SetParseFlag(ZTokenContext.AllowSkipIndent);
	//		//		@Var ZAnnotationNode AnnotationNode = (ZAnnotationNode)TokenContext.ParsePattern(ParentNode, "$Annotation$", ZTokenContext.Optional2);
	//		TokenContext.SetParseFlag(ZTokenContext.NotAllowSkipIndent);
	//		@Var ZNode StmtNode = ZenGrammar.DispatchPattern(ParentNode, TokenContext, null, true, true);
	//		StmtNode = TokenContext.MatchPattern(StmtNode, ZNode.Nop, ";", ZTokenContext.Required);
	//		//		if(AnnotationNode != null) {
	//		//			AnnotationNode.Append(StmtNode);
	//		//			StmtNode = AnnotationNode;
	//		//		}
	//		TokenContext.SetParseFlag(Rememberd);
	//		return StmtNode;
	//	}
	//
	//	public static ZNode MatchBlock(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode BlockNode = new ZBlockNode(ParentNode, 0);
	//		@Var ZToken SkipToken = TokenContext.GetToken();
	//		BlockNode = TokenContext.MatchToken(BlockNode, "{", ZTokenContext.Required);
	//		if(!BlockNode.IsErrorNode()) {
	//			@Var boolean Remembered = TokenContext.SetParseFlag(ZTokenContext.AllowSkipIndent); // init
	//			@Var ZNode NestedBlockNode = BlockNode;
	//			while(TokenContext.HasNext()) {
	//				//System.out.println("Token :" + TokenContext.GetToken());
	//				if(TokenContext.MatchToken("}")) {
	//					break;
	//				}
	//				@Var ZNode StmtNode = TokenContext.MatchPattern(NestedBlockNode, ZNode.AppendIndex, "$Statement$", ZTokenContext.Required);
	//				if(StmtNode.IsErrorNode()) {
	//					NestedBlockNode.Set(ZNode.AppendIndex, StmtNode);
	//					TokenContext.SkipError(SkipToken);
	//					TokenContext.MatchToken("}");
	//					break;
	//				}
	//				/* VarDecl is defined as BlockNode to speficy its scope */
	//				if(StmtNode instanceof ZBlockNode) {
	//					//System.out.println("nesting scope " + ParsedNode);
	//					NestedBlockNode = StmtNode;
	//				}
	//			}
	//			TokenContext.SetParseFlag(Remembered);
	//		}
	//		return BlockNode;
	//	}
	//
	//	public static ZNode MatchIf(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode IfNode = new ZIfNode(ParentNode);
	//		IfNode = TokenContext.MatchToken(IfNode, "if", ZTokenContext.Required);
	//		IfNode = TokenContext.MatchToken(IfNode, "(", ZTokenContext.Required);
	//		IfNode = TokenContext.MatchPattern(IfNode, ZIfNode.Cond, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowNewLine);
	//		IfNode = TokenContext.MatchToken(IfNode, ")", ZTokenContext.Required);
	//		IfNode = TokenContext.MatchPattern(IfNode, ZIfNode.Then, "$Block$", ZTokenContext.Required);
	//		if(TokenContext.MatchNewLineToken("else")) {
	//			String PatternName = "$Block$";
	//			if(TokenContext.IsNewLineToken("if")) {
	//				PatternName = "if";
	//			}
	//			IfNode = TokenContext.MatchPattern(IfNode, ZIfNode.Else, PatternName, ZTokenContext.Required);
	//		}
	//		return IfNode;
	//	}
	//
	//	public static ZNode MatchReturn(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode ReturnNode = new ZReturnNode(ParentNode);
	//		ReturnNode = TokenContext.MatchToken(ReturnNode, "return", ZTokenContext.Required);
	//		ReturnNode = TokenContext.MatchPattern(ReturnNode, ZReturnNode.Expr, "$Expression$", ZTokenContext.Optional);
	//		return ReturnNode;
	//	}
	//
	//	public static ZNode MatchWhile(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode WhileNode = new ZWhileNode(ParentNode);
	//		WhileNode = TokenContext.MatchToken(WhileNode, "while", ZTokenContext.Required);
	//		WhileNode = TokenContext.MatchToken(WhileNode, "(", ZTokenContext.Required);
	//		WhileNode = TokenContext.MatchPattern(WhileNode, ZWhileNode.Cond, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
	//		WhileNode = TokenContext.MatchToken(WhileNode, ")", ZTokenContext.Required);
	//		WhileNode = TokenContext.MatchPattern(WhileNode, ZWhileNode.Block, "$Block$", ZTokenContext.Required);
	//		return WhileNode;
	//	}
	//
	//	public static ZNode MatchBreak(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode BreakNode = new ZBreakNode(ParentNode);
	//		BreakNode = TokenContext.MatchToken(BreakNode, "break", ZTokenContext.Required);
	//		return BreakNode;
	//	}
	//
	//	public static ZNode MatchCatch(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode CatchNode = new ZCatchNode(ParentNode);
	//		CatchNode = TokenContext.MatchToken(CatchNode, "catch", ZTokenContext.Required);
	//		CatchNode = TokenContext.MatchToken(CatchNode, "(", ZTokenContext.Required);
	//		CatchNode = TokenContext.MatchPattern(CatchNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
	//		CatchNode = TokenContext.MatchToken(CatchNode, ")", ZTokenContext.Required);
	//		CatchNode = TokenContext.MatchPattern(CatchNode, ZCatchNode.Block, "$Block$", ZTokenContext.Required);
	//		return CatchNode;
	//	}
	//
	//	public static ZNode MatchTry(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode TryNode = new ZTryNode(ParentNode);
	//		TryNode = TokenContext.MatchToken(TryNode, "try", ZTokenContext.Required);
	//		TryNode = TokenContext.MatchPattern(TryNode, ZTryNode.Try, "$Block$", ZTokenContext.Required);
	//		int count = 0;
	//		if(TokenContext.IsNewLineToken("catch")) {
	//			TryNode = TokenContext.MatchPattern(TryNode, ZTryNode.Catch, "$Catch$", ZTokenContext.Required);
	//			count = count + 1;
	//		}
	//		if(TokenContext.MatchNewLineToken("finally")) {
	//			TryNode = TokenContext.MatchPattern(TryNode, ZTryNode.Finally, "$Block$", ZTokenContext.Required);
	//			count = count + 1;
	//		}
	//		if(count == 0 && !TryNode.IsErrorNode()) {
	//			return TryNode.AST[ZTryNode.Try]; // no catch and finally
	//		}
	//		return TryNode;
	//
	//	}
	//
	//	public static ZNode MatchThrow(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode ThrowNode = new ZThrowNode(ParentNode);
	//		ThrowNode = TokenContext.MatchToken(ThrowNode, "throw", ZTokenContext.Required);
	//		ThrowNode = TokenContext.MatchPattern(ThrowNode, ZThrowNode.Expr, "$Expression$", ZTokenContext.Required);
	//		return ThrowNode;
	//	}
	//
	//	public static ZNode MatchLetDecl(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode LetNode = new ZLetNode(ParentNode);
	//		LetNode = TokenContext.MatchToken(LetNode, "let", ZTokenContext.Required);
	//		LetNode = TokenContext.MatchPattern(LetNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
	//		//		if(TokenContext.MatchToken(".")) {
	//		//			LetNode = TokenContext.MatchPattern(LetNode, "$Name$", ZTokenContext.Required);
	//		//		}
	//		LetNode = TokenContext.MatchPattern(LetNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
	//		LetNode = TokenContext.MatchToken(LetNode, "=", ZTokenContext.Required);
	//		LetNode = TokenContext.MatchPattern(LetNode, ZLetNode.InitValue, "$Expression$", ZTokenContext.Required);
	//		return LetNode;
	//	}
	//
	//	public static ZNode MatchName(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
	//		if(LibZen.IsVariableName(Token.GetText(), 0)) {
	//			return new ZGetNameNode(ParentNode, Token, Token.GetText());
	//		}
	//		return new ZErrorNode(ParentNode, Token, "illegal name: '" + Token.GetText() + "'");
	//	}
	//
	//	public static ZNode MatchTypeAnnotation(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		if(TokenContext.MatchToken(":")) {
	//			return TokenContext.ParsePattern(ParentNode, "$Type$", ZTokenContext.Required);
	//		}
	//		return null;
	//	}
	//
	//	// "var" $Name [: $Type$] "=" $Expression$
	//	public static ZNode MatchVarDecl(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode VarNode = new ZVarDeclNode(ParentNode);
	//		VarNode = TokenContext.MatchToken(VarNode, "var", ZTokenContext.Required);
	//		VarNode = TokenContext.MatchPattern(VarNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
	//		VarNode = TokenContext.MatchPattern(VarNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
	//		VarNode = TokenContext.MatchToken(VarNode, "=", ZTokenContext.Required);
	//		VarNode = TokenContext.MatchPattern(VarNode, ZVarDeclNode.InitValue, "$Expression$", ZTokenContext.Required);
	//		return VarNode;
	//	}
	//
	//	// FuncDecl
	//	public static ZNode MatchParam(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode ParamNode = new ZParamNode(ParentNode);
	//		ParamNode = TokenContext.MatchPattern(ParamNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
	//		ParamNode = TokenContext.MatchPattern(ParamNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
	//		return ParamNode;
	//	}
	//
	//	public static ZNode MatchFunction(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode FuncNode = new ZFunctionNode(ParentNode);
	//		FuncNode = TokenContext.MatchToken(FuncNode, "function", ZTokenContext.Required);
	//		FuncNode = TokenContext.MatchPattern(FuncNode, ZNode.NameInfo, "$Name$", ZTokenContext.Optional);
	//		FuncNode = TokenContext.MatchNtimes(FuncNode, "(", "$Param$", ",", ")");
	//		FuncNode = TokenContext.MatchPattern(FuncNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
	//		FuncNode = TokenContext.MatchPattern(FuncNode, ZFunctionNode.Block, "$Block$", ZTokenContext.Required);
	//		return FuncNode;
	//	}
	//
	//	public static ZNode MatchAnnotation(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZenMap<Object> Anno = null;
	//		@Var ZToken Token = null;
	//		while(TokenContext.MatchToken("@")) {
	//			Token = TokenContext.GetToken(ZTokenContext.MoveNext);
	//			if(Anno == null) {
	//				Anno = new ZenMap<Object>(null);
	//			}
	//			Anno.put(Token.GetText(), Token);
	//			TokenContext.SkipIndent();
	//		}
	//		if(Anno != null) {
	//			return new ZAnnotationNode(ParentNode, Token, Anno);
	//		}
	//		return null;
	//	}
	//
	//	public static ZNode MatchEndOfStatement(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var boolean ContextAllowance = TokenContext.SetParseFlag(false);
	//		@Var ZToken Token = null;
	//		if(TokenContext.HasNext()) {
	//			Token = TokenContext.GetToken();
	//			if(!Token.EqualsText(';') && !Token.IsIndent()) {
	//				TokenContext.SetParseFlag(ContextAllowance);
	//				return TokenContext.CreateExpectedErrorNode(Token, ";");
	//			}
	//			TokenContext.MoveNext();
	//			while(TokenContext.HasNext()) {
	//				Token = TokenContext.GetToken();
	//				if(!Token.EqualsText(';') && !Token.IsIndent()) {
	//					break;
	//				}
	//				TokenContext.MoveNext();
	//			}
	//		}
	//		TokenContext.SetParseFlag(ContextAllowance);
	//		return new ZEmptyNode(ParentNode, Token);
	//	}
	//
	//	// "var" $Name [: $Type$] "=" $Expression$
	//	public static ZNode MatchFieldDecl(ZNode ParentNode, ZTokenContext TokenContext, ZNode ClassNode) {
	//		@Var boolean Rememberd = TokenContext.SetParseFlag(false);
	//		@Var ZNode FieldNode = new ZFieldNode(ParentNode);
	//		FieldNode = TokenContext.MatchToken(FieldNode, "field", ZTokenContext.Required);
	//		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
	//		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
	//		if(TokenContext.MatchToken("=")) {
	//			FieldNode = TokenContext.MatchPattern(FieldNode, ZFieldNode.InitValue, "$Expression$", ZTokenContext.Required);
	//		}
	//		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode.Nop, ";", ZTokenContext.Required);
	//		TokenContext.SetParseFlag(Rememberd);
	//		return FieldNode;
	//	}
	//
	//	public static ZNode MatchClassDecl(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode ClassNode = new ZClassDeclNode(ParentNode);
	//		ClassNode = TokenContext.MatchToken(ClassNode, "class", ZTokenContext.Required);
	//		ClassNode = TokenContext.MatchPattern(ClassNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
	//		if(TokenContext.MatchNewLineToken("extends")) {
	//			ClassNode = TokenContext.MatchPattern(ClassNode, ZNode.TypeInfo, "$Type$", ZTokenContext.Required);
	//		}
	//		ClassNode = TokenContext.MatchNtimes(ClassNode, "{", "$FieldDecl$", null, "}");
	//		return ClassNode;
	//	}
	//
	//	public static ZNode MatchPath(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZToken Token = TokenContext.ParseLargeToken();
	//		return new ZGetNameNode(ParentNode, Token, Token.GetText());
	//	}
	//
	//	public static ZNode MatchImport(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
	//		@Var ZNode ImportNode = TokenContext.Generator.CreateImportNode(ParentNode);
	//		ImportNode = TokenContext.MatchToken(ImportNode, "import", ZTokenContext.Required);
	//		ImportNode = TokenContext.MatchPattern(ImportNode, ZNode.NameInfo, "$Path$", ZTokenContext.Required);
	//		if(ImportNode instanceof ZImportNode) {
	//			return ((ZImportNode)ImportNode).Import();
	//		}
	//		return ImportNode;
	//	}

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

		NameSpace.AppendTokenFunc(" \t", new WhiteSpaceToken());
		NameSpace.AppendTokenFunc("\n",  new NewLineToken());
		NameSpace.AppendTokenFunc("{}()[]<>.,;?:+-*/%=&|!@~^$", new OperatorToken());
		NameSpace.AppendTokenFunc("/", new BlockComment());  // overloading
		NameSpace.AppendTokenFunc("Aa_", new NameToken());

		NameSpace.AppendTokenFunc("\"", new StringLiteralToken());
		NameSpace.AppendTokenFunc("1",  new NumberLiteralToken());

		@Var ZMatchFunction MatchUnary     = new UnaryPattern();
		@Var ZMatchFunction MatchBinary    = new BinaryPattern();
		@Var ZMatchFunction MatchComparator    = new ComparatorPattern();

		NameSpace.DefineSyntax("null", new NullPattern());
		NameSpace.DefineSyntax("true", new TruePattern());
		NameSpace.DefineSyntax("false", new FalsePattern());

		NameSpace.DefineSyntax("+", MatchUnary);
		NameSpace.DefineSyntax("-", MatchUnary);
		NameSpace.DefineSyntax("~", MatchUnary);
		NameSpace.DefineSyntax("!", new NotPattern());
		//		NameSpace.AppendSyntax("++ --", new Incl"));

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
		//		NameSpace.AppendExtendedSyntax("++ --", 0, new Incl"));

		NameSpace.DefineSuffixSyntax("&&", ZenPrecedence.CStyleAND, new AndPattern());
		NameSpace.DefineSuffixSyntax("||", ZenPrecedence.CStyleOR, new OrPattern());

		//		NameSpace.AppendExtendedSyntax("?", 0, new TrinaryPattern());

		//		NameSpace.DefineSyntax("$Error$", new ErrorPattern());
		NameSpace.DefineSyntax("$Type$",new TypePattern());
		NameSpace.DefineSyntax("$TypeSuffix$", new TypeSuffixPattern());
		NameSpace.DefineSyntax("$TypeAnnotation$", new TypeAnnotationPattern());

		NameSpace.DefineSyntax("$StringLiteral$", new StringLiteralPattern());
		NameSpace.DefineSyntax("$IntegerLiteral$", new IntLiteralPattern());
		NameSpace.DefineSyntax("$FloatLiteral$", new FloatLiteralPattern());

		NameSpace.DefineSuffixSyntax(".", 0, new GetterPattern());

		NameSpace.DefineSyntax("(", new GroupPattern());
		NameSpace.DefineSyntax("(", new CastPattern());
		NameSpace.DefineSuffixSyntax("(", 0, new ApplyPattern());

		NameSpace.DefineSuffixSyntax("[", 0, new IndexerPattern());
		NameSpace.DefineSyntax("[", new ArrayLiteralPattern());
		NameSpace.DefineSyntax("$MapEntry$", new MapEntryPattern());
		NameSpace.DefineSyntax("{", new MapLiteralPattern());
		NameSpace.DefineSyntax("new", new NewObjectPattern());

		NameSpace.DefineStatement(";", new StatementEndPattern());
		NameSpace.DefineSyntax("$Block$", new BlockPattern());
		NameSpace.DefineSyntax("$Annotation$", new AnnotationPattern());
		NameSpace.DefineSyntax("$SymbolExpression$", new SymbolExpressionPattern());
		// don't change DefineStatement for $SymbolStatement$
		NameSpace.DefineSyntax("$SymbolStatement$", new SymbolStatementPattern());
		NameSpace.DefineSyntax("$Statement$", new StatementPattern());
		NameSpace.DefineSyntax("$Expression$", new ExpressionPattern());
		NameSpace.DefineSyntax("$SuffixExpression$", new SuffixExpressionPattern());

		NameSpace.DefineStatement("if", new IfPattern());
		NameSpace.DefineStatement("return", new ReturnPattern());
		NameSpace.DefineStatement("while", new WhilePattern());
		NameSpace.DefineStatement("break", new BreakPattern());

		NameSpace.DefineSyntax("$Name$", new NamePattern());
		NameSpace.DefineStatement("var",  new VarPattern());
		NameSpace.DefineSyntax("$Param$", new ParamPattern());
		NameSpace.DefineSyntax("function", new FunctionPattern());
		NameSpace.DefineStatement("let", new LetPattern());
		NameSpace.Generator.AppendGrammarInfo("zen-0.1");

		NameSpace.DefineStatement("try", new TryPattern());
		NameSpace.DefineSyntax("$Catch$", new CatchPattern());
		NameSpace.DefineStatement("throw", new ThrowPattern());
		NameSpace.Generator.AppendGrammarInfo("zen-trycatch-0.1");

		NameSpace.DefineSuffixSyntax("instanceof", ZenPrecedence.Instanceof, new InstanceOfPattern());
		NameSpace.DefineStatement("class", new ClassPattern());
		NameSpace.DefineSyntax("$FieldDecl$", new FieldPattern());
		NameSpace.DefineStatement("import", new ImportPattern());
		NameSpace.DefineSyntax("$Path$", new PathPattern());

		NameSpace.Generator.AppendGrammarInfo("zen-class-0.1");
	}

}
