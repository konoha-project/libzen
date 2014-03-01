package zen.grammar;

import zen.parser.ZSourceContext;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZTokenFunction;

public class NameTokenFunction extends ZTokenFunction {

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition();
		while(SourceContext.HasChar()) {
			@Var char ch = SourceContext.GetCurrentChar();
			if(!LibZen._IsSymbol(ch) && !LibZen._IsDigit(ch)) {
				break;
			}
			SourceContext.MoveNext();
		}
		SourceContext.Tokenize(StartIndex, SourceContext.GetPosition());
		return true;
	}

}
