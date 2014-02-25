package libzen.grammar;

import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZTokenFunction;
import zen.parser.ZSourceContext;

public class NameToken extends ZTokenFunction {

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
