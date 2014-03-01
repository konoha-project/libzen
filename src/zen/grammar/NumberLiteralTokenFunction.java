package zen.grammar;

import zen.parser.ZSourceContext;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZTokenFunction;

public class NumberLiteralTokenFunction extends ZTokenFunction {

	public final static char _ParseDigit(ZSourceContext SourceContext) {
		@Var char ch = '\0';
		while(SourceContext.HasChar()) {
			ch = SourceContext.GetCurrentChar();
			if(!LibZen._IsDigit(ch)) {
				break;
			}
			SourceContext.MoveNext();
		}
		return ch;
	}

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition();
		@Var char ch = NumberLiteralTokenFunction._ParseDigit(SourceContext);
		if(ch == '.') {
			SourceContext.MoveNext();
			ch = NumberLiteralTokenFunction._ParseDigit(SourceContext);
			if(ch == 'e' || ch == 'E') {
				SourceContext.MoveNext();
				if(SourceContext.HasChar()) {
					ch = SourceContext.GetCurrentChar();
					if(ch == '+' || ch == '-') {
						SourceContext.MoveNext();
					}
				}
				NumberLiteralTokenFunction._ParseDigit(SourceContext);
			}
			SourceContext.Tokenize("$FloatLiteral$", StartIndex, SourceContext.GetPosition());
		}
		else {
			SourceContext.Tokenize("$IntegerLiteral$", StartIndex, SourceContext.GetPosition());
		}
		return true;
	}

}
