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
import zen.ast.ZBlockNode;
import zen.ast.ZEmptyNode;
import zen.ast.ZErrorNode;
import zen.ast.ZNode;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZArray;

public final class ZTokenContext {
	public final static boolean     _Required          = true;
	public final static boolean     _Optional          = false;
	public final static boolean     _AllowSkipIndent   = true;
	public final static boolean     _NotAllowSkipIndent   = false;
	public final static boolean     _AllowNewLine   = true;
	public final static boolean     _MoveNext       = true;

	@Field public ZGenerator Generator;
	@Field public ZNameSpace NameSpace;
	@Field public ZSourceContext Source;
	@Field public ZArray<ZToken> TokenList = new ZArray<ZToken>(new ZToken[128]);

	@Field private int CurrentPosition = 0;
	@Field private boolean IsAllowSkipIndent = false;
	@Field public ZToken LatestToken = null;
	@Field private ZSyntax ApplyingPattern = null;

	public ZTokenContext(ZGenerator Generator, ZNameSpace NameSpace, String FileName, int LineNumber, String SourceText) {
		this.Generator = Generator;
		this.NameSpace = NameSpace;
		this.Source = new ZSourceContext(FileName, LineNumber, SourceText, this);
	}

	public boolean SetParseFlag(boolean AllowSkipIndent) {
		@Var boolean OldFlag = this.IsAllowSkipIndent;
		this.IsAllowSkipIndent = AllowSkipIndent;
		return OldFlag;
	}

	private ZToken GetBeforeToken() {
		@Var int MovingPos = this.CurrentPosition - 1;
		while(MovingPos >= 0 && MovingPos < this.TokenList.size()) {
			@Var ZToken Token = this.TokenList.ArrayValues[MovingPos];
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
				if(!this.Source.DoTokenize()) {
					break;
				}
			}
			@Var ZToken Token = this.TokenList.ArrayValues[this.CurrentPosition];
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
		return ZToken._NullToken;
	}

	public ZToken GetToken() {
		return this.GetToken(false);
	}

	public boolean HasNext() {
		return (this.GetToken() != ZToken._NullToken);
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
			LibZen._PrintDebug("StartIdx="+StartIndex+", EndIndex="+EndIndex);
			LibZen._PrintDebug("skipped: \t" + ErrorToken.Source.SourceText.substring(StartIndex, EndIndex));
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
		@Var ZToken Token = this.GetToken(ZTokenContext._MoveNext);
		if(Token.EqualsText(TokenText)) {
			return true;
		}
		this.CurrentPosition = RollbackPos;
		return false;
	}

	public final boolean MatchNewLineToken(String TokenText) {
		@Var int RollbackPos = this.CurrentPosition;
		this.SkipIndent();
		@Var ZToken Token = this.GetToken(ZTokenContext._MoveNext);
		if(Token.EqualsText(TokenText)) {
			return true;
		}
		this.CurrentPosition = RollbackPos;
		return false;
	}

	public ZToken ParseLargeToken() {
		@Var ZToken Token = this.GetToken(ZTokenContext._MoveNext);
		if(Token.IsNextWhiteSpace()) {
			return Token;
		}
		@Var int StartIndex = Token.StartIndex;
		@Var int EndIndex = Token.EndIndex;
		while(this.HasNext() && !Token.IsNextWhiteSpace()) {
			@Var int RollbackPosition = this.CurrentPosition;
			Token = this.GetToken(ZTokenContext._MoveNext);
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
			@Var ZToken Token = this.GetToken(ZTokenContext._MoveNext);
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

	public final ZSyntax GetApplyingSyntax() {
		return this.ApplyingPattern;
	}

	public final ZNode ApplyMatchPattern(ZNode ParentNode, ZNode LeftNode, ZSyntax Pattern, boolean IsRequired) {
		@Var int RollbackPosition = this.CurrentPosition;
		@Var ZSyntax CurrentPattern = Pattern;
		@Var ZToken TopToken = this.GetToken();
		@Var ZNode ParsedNode = null;
		while(CurrentPattern != null) {
			@Var boolean Remembered = this.IsAllowSkipIndent;
			this.CurrentPosition = RollbackPosition;
			this.ApplyingPattern  = CurrentPattern;
			//			System.out.println("B "+Pattern + "," + ParentNode);
			ParsedNode = LibZen._ApplyMatchFunc(CurrentPattern.MatchFunc, ParentNode, this, LeftNode);
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
		if(this.CurrentPosition == RollbackPosition) {
			LibZen._PrintLine("DEBUG infinite looping" + RollbackPosition + " Token=" + TopToken + " ParsedNode=" + ParsedNode);
			assert(this.CurrentPosition != RollbackPosition);
		}
		if(ParsedNode == null) {
			ParsedNode = this.CreateExpectedErrorNode(TopToken, Pattern.PatternName);
		}
		return ParsedNode;
	}

	public final ZNode ParsePatternAfter(ZNode ParentNode, ZNode LeftNode, String PatternName, boolean IsRequired) {
		@Var ZSyntax Pattern = this.NameSpace.GetSyntaxPattern(PatternName);
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
				if(Index == ZNode._NestedAppendIndex) {
					if(!(ParsedNode instanceof ZEmptyNode)) {
						ParentNode.Set(ZNode._AppendIndex, ParsedNode);
					}
					if(ParsedNode instanceof ZBlockNode || ParsedNode.IsErrorNode()) {
						return ParsedNode;
					}
				}
				if(ParsedNode.IsErrorNode()) {
					return ParsedNode;
				}
				else {
					if(!(ParsedNode instanceof ZEmptyNode)) {
						ParentNode.Set(Index, ParsedNode);
					}
				}
			}
		}
		return ParentNode;
	}

	public ZNode MatchPattern(ZNode ParentNode, int Index, String PatternName, boolean IsRequired) {
		return this.MatchPattern(ParentNode, Index, PatternName, IsRequired, ZTokenContext._NotAllowSkipIndent);
	}

	public ZNode MatchOptionaPattern(ZNode ParentNode, int Index, boolean AllowNewLine, String TokenText, String PatternName) {
		if(!ParentNode.IsErrorNode()) {
			if(this.MatchToken(TokenText)) {
				return this.MatchPattern(ParentNode, Index, PatternName, ZTokenContext._Optional, ZTokenContext._NotAllowSkipIndent);
			}
		}
		return ParentNode;
	}

	public ZNode MatchNtimes(ZNode ParentNode, String StartToken, String PatternName, String DelimToken, String StopToken) {
		@Var boolean Rememberd = this.SetParseFlag(true);
		@Var boolean IsRequired =   ZTokenContext._Optional;
		if(StartToken != null) {
			ParentNode = this.MatchToken(ParentNode, StartToken, ZTokenContext._Required);
		}
		while(!ParentNode.IsErrorNode()) {
			if(StopToken != null) {
				@Var ZToken Token = this.GetToken();
				if(Token.EqualsText(StopToken)) {
					break;
				}
				IsRequired = ZTokenContext._Required;
			}
			@Var ZNode ParsedNode = this.ParsePattern(ParentNode, PatternName, IsRequired);
			if(ParsedNode == null) {
				break;
			}
			if(ParsedNode.IsErrorNode()) {
				return ParsedNode;
			}
			if(!(ParsedNode instanceof ZEmptyNode)) {
				ParentNode.Set(ZNode._AppendIndex, ParsedNode);
			}
			if(DelimToken != null) {
				if(!this.MatchToken(DelimToken)) {
					break;
				}
			}
		}
		if(StopToken != null) {
			ParentNode = this.MatchToken(ParentNode, StopToken, ZTokenContext._Required);
		}
		this.SetParseFlag(Rememberd);
		return ParentNode;
	}

	public final boolean StartsWithToken(String TokenText) {
		@Var ZToken Token = this.GetToken();
		if(Token.EqualsText(TokenText)) {
			this.CurrentPosition = this.CurrentPosition + 1;
			return true;
		}
		if(Token.StartsWith(TokenText)) {
			Token = new ZToken(Token.Source, Token.StartIndex + TokenText.length(), Token.EndIndex);
			this.CurrentPosition = this.CurrentPosition + 1;
			this.TokenList.add(this.CurrentPosition, Token);
			return true;
		}
		return false;
	}

	public final void SkipEmptyStatement() {
		while(this.HasNext()) {
			@Var ZToken Token = this.GetToken();
			if(Token.IsIndent() || Token.EqualsText(';')) {
				this.CurrentPosition = this.CurrentPosition + 1;
			}
			else {
				break;
			}
		}
	}

	public final void Dump() {
		@Var int Position = this.CurrentPosition;
		while(Position < this.TokenList.size()) {
			@Var ZToken Token = this.TokenList.ArrayValues[Position];
			@Var String DumpedToken = "[";
			DumpedToken = DumpedToken + Position+"] " + Token.toString();
			LibZen._PrintDebug(DumpedToken);
			Position = Position + 1;
			//			ZenLogger.VerboseLog(ZenLogger.VerboseToken,  DumpedToken);
		}
	}

}
