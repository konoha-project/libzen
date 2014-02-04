package zen.parser;

import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;

public class ZToken {
	@Field public final static ZToken NullToken = new ZToken(null, 0, 0);

	@Field public ZSource Source;
	@Field public int  StartIndex;
	@Field public int  EndIndex;

	public ZToken(ZSource Source, int StartIndex, int EndIndex) {
		this.Source = Source;
		this.StartIndex = StartIndex;
		this.EndIndex = EndIndex;
	}

	public final String GetFileName() {
		return this.Source.FileName;
	}

	public final int GetLineNumber() {
		return this.Source.GetLineNumber(this.StartIndex);
	}

	public final String GetText() {
		if(this.Source != null) {
			return this.Source.SourceText.substring(this.StartIndex, this.EndIndex);
		}
		return "null";
	}

	@Override public String toString() {
		char ch = this.Source.GetChar(this.StartIndex-1);
		if(ch == '\"') {
			return "\"" + this.GetText() + "\"";
		}
		return this.GetText();
	}

	public final boolean EqualsText(char ch) {
		if(this.EndIndex - this.StartIndex == 1) {
			if(this.Source.SourceText.charAt(this.StartIndex) == ch) {
				return true;
			}
		}
		return false;
	}

	public final boolean EqualsText(String Text) {
		if(Text.length() == this.EndIndex - this.StartIndex) {
			@Var String s = this.Source.SourceText;
			@Var int i = 0;
			while(i < Text.length()) {
				if(s.charAt(this.StartIndex+i) != Text.charAt(i)) {
					return false;
				}
				i = i + 1;
			}
			return true;
		}
		return false;
	}

	public final boolean StartsWith(String Text) {
		if(Text.length() <= this.EndIndex - this.StartIndex) {
			@Var String s = this.Source.SourceText;
			@Var int i = 0;
			while(i < Text.length()) {
				if(s.charAt(this.StartIndex+i) != Text.charAt(i)) {
					return false;
				}
				i = i + 1;
			}
			return true;
		}
		return false;
	}

	public final boolean IsNull() {
		return (this == ZToken.NullToken);
	}

	public final boolean IsIndent() {
		return this instanceof ZIndentToken;
	}

	public final boolean IsNextWhiteSpace() {
		char ch = this.Source.GetChar(this.EndIndex+1);
		if(ch == ' ' || ch == '\t' || ch == '\n') {
			return true;
		}
		return false;
	}

	public final boolean IsNameSymbol() {
		char ch = this.Source.GetChar(this.StartIndex);
		return LibZen.IsSymbol(ch);
	}


	//	public final boolean IsQuoted() {
	//		return ZUtils.IsFlag(this.TokenFlag, ZParserConst.QuotedTokenFlag);
	//	}

	//
	//
	//
	//	public final boolean IsSource() {
	//		return ZUtils.IsFlag(this.TokenFlag, ZParserConst.SourceTokenFlag);
	//	}
	//
	//	public final boolean IsIndent() {
	//		return ZUtils.IsFlag(this.TokenFlag, ZParserConst.IndentTokenFlag);
	//	}
	//
	//	public final boolean IsNextWhiteSpace() {
	//		return ZUtils.IsFlag(this.TokenFlag, ZParserConst.WhiteSpaceTokenFlag);
	//	}
	//
	//	public final boolean IsQuoted() {
	//		return ZUtils.IsFlag(this.TokenFlag, ZParserConst.QuotedTokenFlag);
	//	}
	//
	//	public final boolean IsNameSymbol() {
	//		return ZUtils.IsFlag(this.TokenFlag, ZParserConst.NameSymbolTokenFlag);
	//	}
	//
	//
	//	public final int CompareIndent(ZToken IndentToken) {
	//		if(IndentToken == null) {
	//			if(this.EqualsText("")) {
	//				return 0;
	//			}
	//			return this.GetText().length();
	//		}
	//		else {
	//			if(this.EqualsText(IndentToken.GetText())) {
	//				return 0;
	//			}
	//			return this.GetText().length() - IndentToken.GetText().length();
	//		}
	//	}
	//
	//
	//	//	public final boolean IsError() {
	//	//		return ZUtils.IsFlag(this.TokenFlag, ZParserConst.ErrorTokenFlag);
	//	//	}
	//
	//	//	public void SetError(ZSyntaxPattern ErrorPattern) {
	//	//		if(this.GetText().length() > 0) {  // skip null token
	//	//			this.TokenFlag = ZParserConst.ErrorTokenFlag;
	//	//			this.PresetPattern = ErrorPattern;
	//	//		}
	//	//	}
	//	//
	//	//	public final ZToken AddTypeInfoToErrorMessage(ZType ClassType) {
	//	//		this.GetText() = this.GetText() + " of " + ClassType.ShortName;
	//	//		return this;
	//	//	}
	//
	//	public final boolean IsNull() {
	//		return (this == ZToken.NullToken);
	//	}
	//
	//}

}
