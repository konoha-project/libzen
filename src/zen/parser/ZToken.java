package zen.parser;

import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;

public class ZToken {
	public final static ZToken NullToken = new ZToken(null, 0, 0);

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

	public final char GetChar() {
		if(this.Source != null) {
			return this.Source.SourceText.charAt(this.StartIndex);
		}
		return '\0';
	}

	public final String GetText() {
		if(this.Source != null) {
			return this.Source.SourceText.substring(this.StartIndex, this.EndIndex);
		}
		return "";
	}

	@Override public String toString() {
		char ch = this.Source.SourceAt(this.StartIndex-1);
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
		char ch = this.Source.SourceAt(this.EndIndex);
		if(ch == ' ' || ch == '\t' || ch == '\n') {
			return true;
		}
		return false;
	}

	public final boolean IsNameSymbol() {
		char ch = this.Source.SourceAt(this.StartIndex);
		return LibZen._IsSymbol(ch);
	}

	public int GetIndentSize() {
		if(this.Source != null) {
			return this.Source.CountIndentSize(this.Source.GetLineHeadPosition(this.StartIndex));
		}
		return 0;
	}

}
