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
import zen.lang.ZenType;

final public class ZenToken extends ZenUtils {
	/*field*/public int		        TokenFlag;
	/*field*/public String	        ParsedText;
	/*field*/public long		    FileLine;
	/*field*/public ZenSyntaxPattern	PresetPattern;
	/*field*/public final static ZenToken NullToken = new ZenToken(0, "/**/", 0);

	public ZenToken(int TokenFlag, String Text, long FileLine) {
		this.TokenFlag = TokenFlag;
		this.ParsedText = Text;
		this.FileLine = FileLine;
		this.PresetPattern = null;
	}

	public boolean IsSource() {
		return ZenUtils.IsFlag(this.TokenFlag, ZenParserConst.SourceTokenFlag);
	}

	public boolean IsError() {
		return ZenUtils.IsFlag(this.TokenFlag, ZenParserConst.ErrorTokenFlag);
	}

	public boolean IsIndent() {
		return ZenUtils.IsFlag(this.TokenFlag, ZenParserConst.IndentTokenFlag);
	}

	public boolean IsDelim() {
		return ZenUtils.IsFlag(this.TokenFlag, ZenParserConst.DelimTokenFlag);
	}

	public final boolean IsNextWhiteSpace() {
		return ZenUtils.IsFlag(this.TokenFlag, ZenParserConst.WhiteSpaceTokenFlag);
	}

	public boolean IsQuoted() {
		return ZenUtils.IsFlag(this.TokenFlag, ZenParserConst.QuotedTokenFlag);
	}

	public boolean IsNameSymbol() {
		return ZenUtils.IsFlag(this.TokenFlag, ZenParserConst.NameSymbolTokenFlag);
	}

	public boolean EqualsText(String text) {
		return this.ParsedText.equals(text);
	}

	public int CompareIndent(ZenToken IndentToken) {
		if(IndentToken == null) {
			if(this.EqualsText("")) {
				return 0;
			}
			return this.ParsedText.length();
		}
		else {
			if(this.EqualsText(IndentToken.ParsedText)) {
				return 0;
			}
			return this.ParsedText.length() - IndentToken.ParsedText.length();
		}
	}

	@Override public String toString() {
		/*local*/String TokenText = "";
		if(this.PresetPattern != null) {
			TokenText = "(" + this.PresetPattern.PatternName + ") ";
		}
		return TokenText + this.ParsedText;
	}

	public void SetError(ZenSyntaxPattern ErrorPattern) {
		if(this.ParsedText.length() > 0) {  // skip null token
			this.TokenFlag = ZenParserConst.ErrorTokenFlag;
			this.PresetPattern = ErrorPattern;
		}
	}

	public final ZenToken AddTypeInfoToErrorMessage(ZenType ClassType) {
		this.ParsedText += " of " + ClassType.ShortName;
		return this;
	}

	public final boolean IsNull() {
		return (this == ZenToken.NullToken);
	}

}

