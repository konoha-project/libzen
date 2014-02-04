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
import java.util.ArrayList;

import zen.ast.ZEmptyNode;
import zen.ast.ZErrorNode;
import zen.ast.ZNode;
import zen.ast.ZTypeNode;
import zen.deps.Field;
import zen.deps.Init;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.lang.ZSystem;
import zen.type.ZType;

public final class ZTokenContext {

	public final static int	    MismatchedPosition		= -1;
	public final static boolean     Required2          = true;
	public final static boolean     Optional2          = false;
	public final static boolean     AllowSkipIndent2   = true;
	public final static boolean     NotAllowSkipIndent2   = false;
	public final static boolean     AllowNewLine   = true;
	public final static boolean     MoveNext       = true;

	@Field @Init public ZGenerator Generator;
	@Field @Init public ZNameSpace NameSpace;
	@Field public ZSource Source;
	@Field public ArrayList<ZToken> TokenList = new ArrayList<ZToken>();

	@Field @Init public long ParsingLine;
	@Field private final int ParsingPosition = 0;

	@Field private int CurrentPosition = 0;

	@Field private boolean IsAllowSkipIndent = false;
	@Field public ZToken LatestToken = null;
	@Field private ZSyntaxPattern ApplyingPattern = null;

	public ZTokenContext(ZGenerator Generator, ZNameSpace NameSpace, String FileName, int LineNumber, String SourceText) {
		this.Generator = Generator;
		this.NameSpace = NameSpace;
		this.ParsingLine = LineNumber;
		this.Source = new ZSource(FileName, LineNumber, SourceText, this);
	}

	private boolean Tokenize2(ZSource Source) {
		@Var int TokenSize = this.TokenList.size();
		@Var int CheckPosition = Source.CurrentPosition;
		while(Source.HasChar()) {
			@Var int CharCode = Source.GetCharCode();
			@Var ZTokenFunc TokenFunc = this.NameSpace.GetTokenFunc(CharCode);
			this.Source.ApplyTokenFunc(TokenFunc);
			if(this.TokenList.size() > TokenSize) {
				break;
			}
			if(Source.CurrentPosition == CheckPosition) {
				LibNative.println("Buggy TokenFunc: " + TokenFunc);
				Source.MoveNext();
			}
		}
		//this.Dump();
		if(this.TokenList.size() > TokenSize) {
			return true;
		}
		return false;
	}

	public boolean SetParseFlag(boolean AllowSkipIndent) {
		boolean OldFlag = this.IsAllowSkipIndent;
		//		if(this.IsAllowSkipIndent != AllowSkipIndent) {
		//			LibNative.Debug("switching " + this.IsAllowSkipIndent + " => " + AllowSkipIndent);
		//		}
		this.IsAllowSkipIndent = AllowSkipIndent;
		return OldFlag;
	}

	public void SkipErrorStatement() {
		@Var ZToken LeastRecentToken = this.LatestToken;
		while(this.HasNext()) {
			@Var ZToken T = this.GetToken();
			if(T.EqualsText(";") || T.EqualsText("}")) {
				break;
			}
			this.Generator.Logger.ReportDebug(T, "skipping: " + T.GetText());
			this.GetTokenAndMoveForward();
		}
		this.LatestToken = LeastRecentToken;
	}

	private ZToken GetBeforeToken() {
		@Var int MovingPos = this.CurrentPosition - 1;
		while(MovingPos >= 0 && MovingPos < this.TokenList.size()) {
			@Var ZToken Token = this.TokenList.get(MovingPos);
			if(!Token.IsIndent()) {
				return Token;
			}
			MovingPos = MovingPos - 1;
		}
		return this.LatestToken;
	}

	public ZNode CreateExpectedErrorNode(ZToken SourceToken, String ExpectedTokenText) {
		if(SourceToken == null || SourceToken.IsNull()) {
			SourceToken = this.GetBeforeToken();
			SourceToken = new ZToken(SourceToken.Source, SourceToken.EndIndex, SourceToken.EndIndex);
			return new ZErrorNode(null, SourceToken, ExpectedTokenText + " is expected");
		}
		return new ZErrorNode(null, SourceToken, ExpectedTokenText + " is expected");
	}

	public void Vacume() {
	}


	public ZToken GetToken(boolean IsMoveNext) {
		while(true) {
			if(!(this.CurrentPosition < this.TokenList.size())) {
				if(!this.Tokenize2(this.Source)) {
					break;
				}
			}
			@Var ZToken Token = this.TokenList.get(this.CurrentPosition);
			if((this.IsAllowSkipIndent) && Token.IsIndent()) {
				this.CurrentPosition = this.CurrentPosition + 1;
			}
			else {
				this.LatestToken = Token;
				if(IsMoveNext) {
					this.CurrentPosition = this.CurrentPosition + 1;
				}
				return Token;
			}
		}
		return ZToken.NullToken;
	}

	public ZToken GetToken() {
		return this.GetToken(false);
	}

	public boolean HasNext() {
		return (this.GetToken() != ZToken.NullToken);
	}

	public ZToken GetTokenAndMoveForward() {
		@Var ZToken Token = this.GetToken();
		this.CurrentPosition += 1;
		return Token;
	}

	public void SkipIndent() {
		@Var ZToken Token = this.GetToken();
		while(Token.IsIndent()) {
			this.CurrentPosition = this.CurrentPosition + 1;
			Token = this.GetToken();
		}
	}

	public ZToken GetCurrentIndentToken() {
		for(@Var int i = this.CurrentPosition - 1; i >= 0; i -= 1) {
			@Var ZToken Token = this.TokenList.get(i);
			if(Token.IsIndent()) {
				return Token;
			}
		}
		return null;
	}

	public void SkipUntilIndent(ZToken IndentToken) {
		//		while(this.HasNext()) {
		//			@Var ZToken Token = this.GetToken();
		//			if(Token.IsIndent() && Token.CompareIndent(IndentToken) == 0) {
		//				return;
		//			}
		//			this.CurrentPosition = this.CurrentPosition + 1;
		//		}
	}

	public ZToken ParseLargeToken() {
		@Var ZToken Token = this.GetTokenAndMoveForward();
		if(Token.IsNextWhiteSpace()) {
			return Token;
		}
		@Var int StartIndex = Token.StartIndex;
		@Var int EndIndex = Token.EndIndex;
		while(this.HasNext() && !Token.IsNextWhiteSpace()) {
			@Var int RollbackPosition = this.CurrentPosition;
			Token = this.GetTokenAndMoveForward();
			if(Token.IsIndent() || Token.EqualsText(";") || Token.EqualsText(",")) {
				this.CurrentPosition = RollbackPosition;
				break;
			}
			EndIndex = Token.EndIndex;
		}
		return new ZToken(Token.Source, StartIndex, EndIndex);
	}

	public final boolean IsToken(String TokenText) {
		@Var ZToken Token = this.GetToken();
		if(Token.EqualsText(TokenText)) {
			return true;
		}
		return false;
	}

	public final boolean IsNewLineToken(String TokenText) {
		@Var int RollbackPos = this.CurrentPosition;
		this.SkipIndent();
		@Var ZToken Token = this.GetToken();
		if(Token.EqualsText(TokenText)) {
			return true;
		}
		this.CurrentPosition = RollbackPos;
		return false;
	}

	public final boolean MatchToken(String TokenText) {
		@Var int RollbackPos = this.CurrentPosition;
		@Var ZToken Token = this.GetTokenAndMoveForward();
		if(Token.EqualsText(TokenText)) {
			return true;
		}
		this.CurrentPosition = RollbackPos;
		return false;
	}

	public final boolean MatchNewLineToken(String TokenText) {
		@Var int RollbackPos = this.CurrentPosition;
		this.SkipIndent();
		@Var ZToken Token = this.GetTokenAndMoveForward();
		if(Token.EqualsText(TokenText)) {
			return true;
		}
		this.CurrentPosition = RollbackPos;
		return false;
	}

	public ZNode MatchNodeToken(ZNode ParentNode, String TokenText, boolean IsRequired) {
		if(!ParentNode.IsErrorNode()) {
			@Var int RollbackPosition = this.CurrentPosition;
			@Var ZToken Token = this.GetTokenAndMoveForward();
			if(Token.GetText().equals(TokenText)) {
				if(ParentNode.SourceToken == null) {
					ParentNode.SourceToken = Token;
				}
			}
			else {
				if(IsRequired) {
					return this.CreateExpectedErrorNode(Token, TokenText);
				}
				else {
					this.CurrentPosition = RollbackPosition;
				}
			}
		}
		return ParentNode;
	}

	public final ZSyntaxPattern GetApplyingSyntax() {
		return this.ApplyingPattern;
	}

	public final ZNode ApplyMatchPattern(ZNode ParentNode, ZNode LeftNode, ZSyntaxPattern Pattern, boolean IsRequired) {
		@Var int RollbackPosition = this.CurrentPosition;
		@Var ZSyntaxPattern CurrentPattern = Pattern;
		@Var ZToken TopToken = this.GetToken();
		@Var ZNode ParsedNode = null;
		while(CurrentPattern != null) {
			@Var boolean Remembered = this.IsAllowSkipIndent;
			this.CurrentPosition = RollbackPosition;
			this.ApplyingPattern  = CurrentPattern;
			ParsedNode = LibNative.ApplyMatchFunc(CurrentPattern.MatchFunc, ParentNode, this, LeftNode);
			this.ApplyingPattern  = null;
			this.IsAllowSkipIndent = Remembered;
			if(ParsedNode != null && !ParsedNode.IsErrorNode()) {
				return ParsedNode;
			}
			CurrentPattern = CurrentPattern.ParentPattern;
		}
		if(!IsRequired) {
			this.CurrentPosition = RollbackPosition;
			return null;
		}
		this.SkipErrorStatement();
		if(ParsedNode == null) {
			ParsedNode = this.CreateExpectedErrorNode(TopToken, Pattern.PatternName);
		}
		return ParsedNode;
	}

	public final ZNode ParsePatternAfter(ZNode ParentNode, ZNode LeftNode, String PatternName, boolean IsRequired) {
		@Var ZSyntaxPattern Pattern = this.NameSpace.GetSyntaxPattern(PatternName);
		@Var ZNode ParsedNode = this.ApplyMatchPattern(ParentNode, LeftNode, Pattern, IsRequired);
		return ParsedNode;
	}

	public final ZNode ParsePattern(ZNode ParentNode, String PatternName, boolean IsRequired) {
		return this.ParsePatternAfter(ParentNode, null, PatternName, IsRequired);
	}

	public ZNode AppendMatchedPattern(ZNode ParentNode, String PatternName, boolean IsRequired, boolean AllowSkipIndent) {
		if(!ParentNode.IsErrorNode()) {
			@Var boolean Rememberd = this.SetParseFlag(AllowSkipIndent);
			@Var ZNode ParsedNode = this.ParsePattern(ParentNode, PatternName, IsRequired);
			this.SetParseFlag(Rememberd);
			if(ParsedNode != null) {
				if(ParsedNode.IsErrorNode()) {
					return ParsedNode;
				}
				if(!(ParsedNode instanceof ZEmptyNode)) {
					ParentNode.Append(ParsedNode);
				}
			}
		}
		return ParentNode;
	}

	public ZNode AppendMatchedPattern(ZNode ParentNode, String PatternName, boolean IsRequired) {
		return this.AppendMatchedPattern(ParentNode, PatternName, IsRequired, false);
	}

	public ZNode AppendMatchedPatternNtimes(ZNode ParentNode, String PatternName, String DelimToken, boolean AllowSkipIndent) {
		@Var boolean Rememberd = this.SetParseFlag(AllowSkipIndent);
		while(!ParentNode.IsErrorNode()) {
			//this.IsAllowSkipIndent = AllowSkipIndent;
			@Var ZNode ParsedNode = this.ParsePattern(ParentNode, PatternName, ZTokenContext.Optional2);
			if(ParsedNode == null) {
				break;
			}
			ParentNode.Append(ParsedNode);
			if(DelimToken != null) {
				//this.IsAllowSkipIndent = AllowSkipIndent;
				if(!this.MatchToken(DelimToken)) {
					break;
				}
			}
		}
		this.SetParseFlag(Rememberd);
		return ParentNode;
	}

	public ZNode AppendMatchedPatternNtimes(ZNode ParentNode, String StartToken, String PatternName, String DelimToken, String StopToken) {
		@Var boolean Rememberd = this.SetParseFlag(true);
		@Var boolean IsRequired =   ZTokenContext.Optional2;
		if(StartToken != null) {
			ParentNode = this.MatchNodeToken(ParentNode, StartToken, ZTokenContext.Required2);
		}
		while(!ParentNode.IsErrorNode()) {
			if(StopToken != null) {
				@Var ZToken Token = this.GetToken();
				if(Token.EqualsText(StopToken)) {
					break;
				}
				IsRequired = ZTokenContext.Required2;
			}
			@Var ZNode ParsedNode = this.ParsePattern(ParentNode, PatternName, IsRequired);
			if(ParsedNode == null) {
				break;
			}
			if(ParsedNode.IsErrorNode()) {
				return ParsedNode;
			}
			if(!(ParsedNode instanceof ZEmptyNode)) {
				ParentNode.Append(ParsedNode);
			}
			if(DelimToken != null) {
				if(!this.MatchToken(DelimToken)) {
					break;
				}
			}
		}
		if(StopToken != null) {
			ParentNode = this.MatchNodeToken(ParentNode, StopToken, ZTokenContext.Required2);
		}
		this.SetParseFlag(Rememberd);
		return ParentNode;
	}

	public final boolean StartsWithToken(String TokenText) {
		@Var ZToken Token = this.GetToken();
		if(Token.EqualsText(TokenText)) {
			this.CurrentPosition += 1;
			return true;
		}
		if(Token.StartsWith(TokenText)) {
			Token = new ZToken(Token.Source, Token.StartIndex + TokenText.length(), Token.EndIndex);
			this.CurrentPosition += 1;
			this.TokenList.add(this.CurrentPosition, Token);
			return true;
		}
		return false;
	}

	public final ZType ParseType(ZNode ParentNode, String PatternName, ZType DefaultType) {
		ZTypeNode TypeNode = (ZTypeNode)this.ParsePatternAfter(ParentNode, null, PatternName, Optional2);
		if(TypeNode != null) {
			return TypeNode.Type;
		}
		return DefaultType;
	}

	public final void SkipEmptyStatement() {
		while(this.HasNext()) {
			@Var ZToken Token = this.GetToken();
			if(Token.IsIndent() || Token.EqualsText(";")) {
				this.CurrentPosition += 1;
				continue;
			}
			break;
		}
	}

	public final String Stringfy(String PreText, int BeginIdx, int EndIdx) {
		@Var String Buffer = PreText;
		for(@Var int Position = BeginIdx; Position < EndIdx; Position += 1) {
			@Var ZToken Token = this.TokenList.get(Position);
			if(Token.IsIndent()) {
				Buffer += "\n";
			}
			Buffer += Token.GetText();
			if(Token.IsNextWhiteSpace()) {
				Buffer += " ";
			}
		}
		return Buffer;
	}

	public final void SetSourceMap(String SourceMap) {
		@Var int Index = SourceMap.lastIndexOf(":");
		if(Index != -1) {
			@Var String FileName = SourceMap.substring(0, Index);
			@Var int Line = (int)LibZen.ParseInt(SourceMap.substring(Index+1));
			this.ParsingLine = ZSystem.GetFileLine(FileName, Line);
		}
	}

	public final void DumpPosition() {
		@Var int Position = this.CurrentPosition;
		if(Position < this.TokenList.size()) {
			@Var ZToken Token = this.TokenList.get(Position);
			LibZen.DebugP("Position="+Position+" " + Token);
		}
		else {
			LibZen.DebugP("Position="+Position+" EOF");
		}
	}

	public final void Dump() {
		for(@Var int Position = this.CurrentPosition; Position < this.TokenList.size(); Position += 1) {
			@Var ZToken Token = this.TokenList.get(Position);
			@Var String DumpedToken = this.CurrentPosition == Position ? "*[" : "[";
			DumpedToken = DumpedToken + Position+"] " + Token.toString();
			LibZen.DebugP(DumpedToken);
			//			ZenLogger.VerboseLog(ZenLogger.VerboseToken,  DumpedToken);
		}
	}

	public final void MoveNext() {
		this.CurrentPosition = this.CurrentPosition + 1;
	}


}
