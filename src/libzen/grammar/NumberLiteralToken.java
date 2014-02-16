package libzen.grammar;

import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZTokenFunction;
import zen.parser.ZSourceContext;

public class NumberLiteralToken extends ZTokenFunction {
	private char ParseDigit(ZSourceContext SourceContext) {
		@Var char ch = 0;
		while(SourceContext.HasChar()) {
			ch = SourceContext.ParseChar();
			if(!LibZen._IsDigit(ch)) {
				break;
			}
			SourceContext.MoveNext();
		}
		return ch;
	}

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition();
		@Var char ch = this.ParseDigit(SourceContext);
		if(ch == '.') {
			SourceContext.MoveNext();
			ch = this.ParseDigit(SourceContext);
			if(ch == 'e' || ch == 'E') {
				SourceContext.MoveNext();
				if(SourceContext.HasChar()) {
					ch = SourceContext.ParseChar();
					if(ch == '+' || ch == '-') {
						SourceContext.MoveNext();
					}
				}
				this.ParseDigit(SourceContext);
			}
			SourceContext.Tokenize("$FloatLiteral$", StartIndex, SourceContext.GetPosition());
		}
		else {
			SourceContext.Tokenize("$IntegerLiteral$", StartIndex, SourceContext.GetPosition());
		}
		return true;
	}

}
