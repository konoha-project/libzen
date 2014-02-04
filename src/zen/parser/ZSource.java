package zen.parser;

import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;

public class ZSource {

	@Field String FileName;
	@Field int    LineNumber;
	@Field String  SourceText;
	@Field private final ZTokenContext TokenContext;
	@Field private final ZLogger Logger;
	@Field int CurrentPosition = 0;

	public ZSource(String FileName, int LineNumber, String Source, ZTokenContext TokenContext) {
		this.FileName = FileName;
		this.LineNumber = LineNumber;
		this.TokenContext = TokenContext;
		this.SourceText = Source;
		this.Logger = TokenContext.Generator.Logger;
	}

	public final int GetLineNumber(int Position) {
		@Var int LineNumber = this.LineNumber;
		@Var int i = 0;
		while(i < Position) {
			char ch = this.SourceText.charAt(i);
			if(ch == '\n') {
				LineNumber = LineNumber + 1;
			}
			i = i + 1;
		}
		return LineNumber;
	}
	public final String GetLineText(int Position) {
		@Var String s = this.SourceText;
		@Var int StartIndex = 0;
		@Var int EndIndex = s.length();
		@Var int i = Position;
		while(i >= 0) {
			char ch = s.charAt(i);
			if(ch == '\n') {
				StartIndex = i + 1;
				break;
			}
			i = i - 1;
		}
		i = Position;
		while(i < s.length()) {
			char ch = s.charAt(i);
			if(ch == '\n') {
				EndIndex = i;
				break;
			}
			i = i + 1;
		}
		return s.substring(StartIndex, EndIndex);
	}
	public final String GetLineMarker(int Position) {
		@Var String s = this.SourceText;
		@Var int StartIndex = 0;
		@Var int i = Position;
		while(i >= 0) {
			char ch = s.charAt(i);
			if(ch == '\n') {
				StartIndex = i + 1;
				break;
			}
			i = i - 1;
		}
		@Var String Line = "";
		i = StartIndex;
		while(i < Position) {
			char ch = s.charAt(i);
			if(ch == '\n') {
				break;
			}
			if(ch == '\t') {
				Line = Line + "\t";
			}
			else {
				Line = Line + " ";
			}
			i = i + 1;
		}
		return Line + "^";
	}

	public String MakeHeader(String Error, int Position, String Message) {
		return "[" + Error +"] (" + this.FileName + ":" + this.GetLineNumber(Position) + ") " + Message;
	}

	public String MakeBody(String Error, int Position, String Message) {
		return this.MakeHeader(Error, Position, Message) + "\n\t" + this.GetLineText(Position) + "\n\t" + this.GetLineMarker(Position);
	}

	public void Warning(int Position, String Message) {
		this.Logger.Report(this.MakeBody("warning", Position, Message));
	}

	public final int GetCharCode() {
		return ZUtils.AsciiToTokenMatrixIndex(LibZen.CharAt(this.SourceText, this.CurrentPosition));
	}

	public final int GetPosition() {
		return this.CurrentPosition;
	}

	public final boolean HasChar() {
		return this.SourceText.length() - this.CurrentPosition > 0;
	}

	public final char GetChar() {
		return this.SourceText.charAt(this.CurrentPosition);
	}

	public final char GetChar(int n) {
		if(this.CurrentPosition+n < this.SourceText.length()) {
			return this.SourceText.charAt(this.CurrentPosition+n);
		}
		return '\0';
	}

	public final void MoveNext() {
		this.CurrentPosition = this.CurrentPosition + 1;
	}

	public final void SkipWhiteSpace() {
		while(this.HasChar()) {
			@Var char ch = this.GetChar();
			if(ch != ' ' && ch != '\t') {
				break;
			}
			this.MoveNext();
		}
	}

	public void FoundIndent(int StartIndex, int EndIndex) {
		@Var ZToken Token = new ZIndentToken(this, StartIndex, EndIndex);
		this.CurrentPosition = EndIndex;
		this.TokenContext.TokenList.add(Token);
	}

	public void Tokenize(int StartIndex, int EndIndex) {
		@Var ZToken Token = new ZToken(this, StartIndex, EndIndex);
		this.CurrentPosition = EndIndex;
		this.TokenContext.TokenList.add(Token);
	}

	public void Tokenize(String PatternName, int StartIndex, int EndIndex) {
		@Var ZToken Token = new ZPatternToken(this, StartIndex, EndIndex, this.TokenContext.NameSpace.GetSyntaxPattern(PatternName));
		this.CurrentPosition = EndIndex;
		this.TokenContext.TokenList.add(Token);
	}

	public boolean IsDefinedSyntax(int StartIndex, int EndIndex) {
		if(EndIndex < this.SourceText.length()) {
			@Var ZNameSpace NameSpace = this.TokenContext.NameSpace;
			@Var String Token = this.SourceText.substring(StartIndex, EndIndex);
			@Var ZSyntaxPattern Pattern = NameSpace.GetSuffixSyntaxPattern(Token);
			if(Pattern != null) {
				return true;
			}
		}
		return false;
	}

	public final void Tokenize() {
		@Var int StartIndex = this.CurrentPosition;
		@Var int EndIndex = StartIndex + 2;
		while(this.IsDefinedSyntax(StartIndex, EndIndex)) {
			EndIndex = EndIndex + 1;
		}
		this.Tokenize(StartIndex, EndIndex-1);
	}

	public final void ApplyTokenFunc(ZTokenFunc TokenFunc) {
		@Var int RollbackPosition = this.CurrentPosition;
		while(TokenFunc != null) {
			this.CurrentPosition = RollbackPosition;
			if(LibNative.ApplyTokenFunc(TokenFunc.Func, this)) {
				return;
			}
			TokenFunc = TokenFunc.ParentFunc;
		}
		this.Tokenize();
	}



}
