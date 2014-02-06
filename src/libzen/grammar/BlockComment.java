package libzen.grammar;

import zen.deps.Var;
import zen.deps.ZenTokenFunction;
import zen.parser.ZSourceContext;

public class BlockComment extends ZenTokenFunction {

	@Override
	public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition();
		@Var char NextChar = SourceContext.ParseChar(+1);
		if(NextChar != '/' && NextChar != '*') {
			return false;  // another tokenizer
		}
		if(NextChar == '/') { // SingleLineComment
			while(SourceContext.HasChar()) {
				@Var char ch = SourceContext.ParseChar();
				if(ch == '\n') {
					break;
				}
				SourceContext.MoveNext();
			}
			return true;
		}
		@Var int Level = 1;
		@Var char PrevChar = '\0';
		while(SourceContext.HasChar()) {
			NextChar = SourceContext.ParseChar();
			if(NextChar == '/' && PrevChar == '*') {
				if(Level == 1) {
					SourceContext.MoveNext();
					return true;
				}
				Level = Level - 1;
			}
			if(Level > 0) {
				if(NextChar == '*' && PrevChar == '/') {
					Level = Level + 1;
				}
			}
			SourceContext.MoveNext();
			PrevChar = NextChar;
		}
		SourceContext.Warning(StartIndex, "unfound */");
		return true;
	}

}
