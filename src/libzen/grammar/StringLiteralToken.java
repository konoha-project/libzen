package libzen.grammar;

import zen.deps.Var;
import zen.deps.ZenTokenFunction;
import zen.parser.ZSourceContext;

public class StringLiteralToken extends ZenTokenFunction {
	@Override public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition() + 1;
		SourceContext.MoveNext();
		while(SourceContext.HasChar()) {
			@Var char ch = SourceContext.ParseChar();
			if(ch == '\"') {
				SourceContext.Tokenize("$StringLiteral$", StartIndex, SourceContext.GetPosition());
				SourceContext.MoveNext();
				return true;
			}
			if(ch == '\n') {
				break;
			}
			if(ch == '\\') {
				SourceContext.MoveNext();
			}
			SourceContext.MoveNext();
		}
		SourceContext.Warning(StartIndex-1, "unclosed \"");
		SourceContext.Tokenize("$StringLiteral$", StartIndex, SourceContext.GetPosition());
		return false;
	}
}
