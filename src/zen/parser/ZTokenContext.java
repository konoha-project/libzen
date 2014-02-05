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
import zen.deps.Field;
import zen.deps.Init;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;

public final class ZTokenContext {
	public final static boolean     Required          = true;
	public final static boolean     Optional          = false;
	public final static boolean     AllowSkipIndent   = true;
	public final static boolean     NotAllowSkipIndent   = false;
	public final static boolean     AllowNewLine   = true;
	public final static boolean     MoveNext       = true;

	@Field @Init public ZGenerator Generator;
	@Field @Init public ZNameSpace NameSpace;
	@Field public ZSource Source;
	@Field public ArrayList<ZToken> TokenList = new ArrayList<ZToken>();

	@Field private int CurrentPosition = 0;
	@Field private boolean IsAllowSkipIndent = false;
	@Field public ZToken LatestToken = null;
	@Field private ZSyntaxPattern ApplyingPattern = null;

	public ZTokenContext(ZGenerator Generator, ZNameSpace NameSpace, String FileName, int LineNumber, String SourceText) {
		this.Generator = Generator;
		this.NameSpace = NameSpace;
		this.Source = new ZSource(FileName, LineNumber, SourceText, this);
	}

	private boolean Tokenize(ZSource Source) {
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
		this.IsAllowSkipIndent = AllowSkipIndent;
		return OldFlag;
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

	//	public final void MoveNext() {
	//		this.CurrentPosition = this.CurrentPosition + 1;
	//	}

	public final void MoveNext() {
		this.CurrentPosition = this.CurrentPosition + 1;
	}

	public ZToken GetToken(boolean EnforceMoveNext) {
		while(true) {
			if(!(this.CurrentPosition < this.TokenList.size())) {
				if(!this.Tokenize(this.Source)) {
					break;
				}
			}
			@Var ZToken Token = this.TokenList.get(this.CurrentPosition);
			if((this.IsAllowSkipIndent) && Token.IsIndent()) {
				this.CurrentPosition = this.CurrentPosition + 1;
			}
			else {
				this.LatestToken = Token;
				if(EnforceMoveNext) {
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

	public void SkipIndent() {
		@Var ZToken Token = this.GetToken();
		while(Token.IsIndent()) {
			this.CurrentPosition = this.CurrentPosition + 1;
			Token = this.GetToken();
		}
	}

	public void SkipError(ZToken ErrorToken) {
		@Var int StartIndex = ErrorToken.StartIndex;
		@Var int EndIndex = ErrorToken.EndIndex;
		@Var int length = ErrorToken.GetIndentSize();
		while(this.HasNext()) {
			@Var ZToken Token = this.GetToken();
			EndIndex = Token.EndIndex;
			this.CurrentPosition = this.CurrentPosition + 1;
			if(Token instanceof ZIndentToken) {
				@Var int ilength = Token.GetIndentSize();
				if(ilength <= length) {
					break;
				}
			}
		}
		if(StartIndex < EndIndex) {
			LibZen.DebugP("StartIdx="+StartIndex+", EndIndex="+EndIndex);
			LibZen.DebugP("skipped: \t" + ErrorToken.Source.SourceText.subSequence(StartIndex, EndIndex));
		}
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
		@Var ZToken Token = this.GetToken(ZTokenContext.MoveNext);
		if(Token.EqualsText(TokenText)) {
			return true;
		}
		this.CurrentPosition = RollbackPos;
		return false;
	}

	public final boolean MatchNewLineToken(String TokenText) {
		@Var int RollbackPos = this.CurrentPosition;
		this.SkipIndent();
		@Var ZToken Token = this.GetToken(ZTokenContext.MoveNext);
		if(Token.EqualsText(TokenText)) {
			return true;
		}
		this.CurrentPosition = RollbackPos;
		return false;
	}

	public ZToken ParseLargeToken() {
		@Var ZToken Token = this.GetToken(ZTokenContext.MoveNext);
		if(Token.IsNextWhiteSpace()) {
			return Token;
		}
		@Var int StartIndex = Token.StartIndex;
		@Var int EndIndex = Token.EndIndex;
		while(this.HasNext() && !Token.IsNextWhiteSpace()) {
			@Var int RollbackPosition = this.CurrentPosition;
			Token = this.GetToken(ZTokenContext.MoveNext);
			if(Token.IsIndent() || Token.EqualsText(';') || Token.EqualsText(',')) {
				this.CurrentPosition = RollbackPosition;
				break;
			}
			EndIndex = Token.EndIndex;
		}
		return new ZToken(Token.Source, StartIndex, EndIndex);
	}

	public ZNode MatchToken(ZNode ParentNode, String TokenText, boolean IsRequired) {
		if(!ParentNode.IsErrorNode()) {
			@Var int RollbackPosition = this.CurrentPosition;
			@Var ZToken Token = this.GetToken(ZTokenContext.MoveNext);
			if(Token.EqualsText(TokenText)) {
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
			//			System.out.println("B "+Pattern + "," + ParentNode);
			ParsedNode = LibNative.ApplyMatchFunc(CurrentPattern.MatchFunc, ParentNode, this, LeftNode);
			assert(ParsedNode != ParentNode);
			//			System.out.println("E "+ ParsedNode);
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

	public ZNode MatchPattern(ZNode ParentNode, int Index, String PatternName, boolean IsRequired, boolean AllowSkipIndent) {
		if(!ParentNode.IsErrorNode()) {
			@Var boolean Rememberd = this.SetParseFlag(AllowSkipIndent);
			@Var ZNode ParsedNode = this.ParsePattern(ParentNode, PatternName, IsRequired);
			this.SetParseFlag(Rememberd);
			if(ParsedNode != null) {
				if(ParsedNode.IsErrorNode()) {
					return ParsedNode;
				}
				if(!(ParsedNode instanceof ZEmptyNode)) {
					ParentNode.Set(Index, ParsedNode);
				}
			}
		}
		return ParentNode;
	}

	public ZNode MatchPattern(ZNode ParentNode, int Index, String PatternName, boolean IsRequired) {
		return this.MatchPattern(ParentNode, Index, PatternName, IsRequired, ZTokenContext.NotAllowSkipIndent);
	}

	public ZNode MatchOptionaPattern(ZNode ParentNode, int Index, boolean AllowNewLine, String TokenText, String PatternName) {
		if(!ParentNode.IsErrorNode()) {
			if(this.MatchToken(TokenText)) {
				return this.MatchPattern(ParentNode, Index, PatternName, ZTokenContext.Optional, ZTokenContext.NotAllowSkipIndent);
			}
		}
		return ParentNode;
	}

	public ZNode MatchNtimes(ZNode ParentNode, String StartToken, String PatternName, String DelimToken, String StopToken) {
		@Var boolean Rememberd = this.SetParseFlag(true);
		@Var boolean IsRequired =   ZTokenContext.Optional;
		if(StartToken != null) {
			ParentNode = this.MatchToken(ParentNode, StartToken, ZTokenContext.Required);
		}
		while(!ParentNode.IsErrorNode()) {
			if(StopToken != null) {
				@Var ZToken Token = this.GetToken();
				if(Token.EqualsText(StopToken)) {
					break;
				}
				IsRequired = ZTokenContext.Required;
			}
			@Var ZNode ParsedNode = this.ParsePattern(ParentNode, PatternName, IsRequired);
			if(ParsedNode == null) {
				break;
			}
			if(ParsedNode.IsErrorNode()) {
				return ParsedNode;
			}
			if(!(ParsedNode instanceof ZEmptyNode)) {
				ParentNode.Set(ZNode.AppendIndex, ParsedNode);
			}
			if(DelimToken != null) {
				if(!this.MatchToken(DelimToken)) {
					break;
				}
			}
		}
		if(StopToken != null) {
			ParentNode = this.MatchToken(ParentNode, StopToken, ZTokenContext.Required);
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

	public final void SkipEmptyStatement() {
		while(this.HasNext()) {
			@Var ZToken Token = this.GetToken();
			if(Token.IsIndent() || Token.EqualsText(';')) {
				this.CurrentPosition += 1;
				continue;
			}
			break;
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

}
