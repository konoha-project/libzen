package libzen.grammar;

import zen.deps.Var;
import zen.deps.ZTokenFunction;
import zen.parser.ZSourceContext;

public class StringLiteralToken extends ZTokenFunction {
	@Override public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition();
		SourceContext.MoveNext();
		while(SourceContext.HasChar()) {
			@Var char ch = SourceContext.ParseChar();
			if(ch == '\"') {
				SourceContext.MoveNext(); // eat '"'
				SourceContext.Tokenize("$StringLiteral$", StartIndex, SourceContext.GetPosition());
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
		SourceContext.Warning(StartIndex, "unclosed \"");
		SourceContext.Tokenize("$StringLiteral$", StartIndex, SourceContext.GetPosition());
		return false;
	}
}
