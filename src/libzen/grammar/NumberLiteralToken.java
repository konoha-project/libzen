package libzen.grammar;

import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZTokenFunction;
import zen.parser.ZSourceContext;

public class NumberLiteralToken extends ZTokenFunction {

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition();
		@Var char ch = 0;
		while(SourceContext.HasChar()) {
			ch = SourceContext.ParseChar();
			if(!LibZen._IsDigit(ch)) {
				break;
			}
			SourceContext.MoveNext();
		}
		if(ch == '.') {
			while(SourceContext.HasChar()) {
				ch = SourceContext.ParseChar();
				if(!LibZen._IsDigit(ch)) {
					break;
				}
				SourceContext.MoveNext();
			}
			SourceContext.Tokenize("$FloatLiteral$", StartIndex, SourceContext.GetPosition());
		}
		else {
			SourceContext.Tokenize("$IntegerLiteral$", StartIndex, SourceContext.GetPosition());
		}
		return true;
	}

}
