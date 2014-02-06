package libzen.grammar;

import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenTokenFunction;
import zen.parser.ZSourceContext;

public class NameToken extends ZenTokenFunction {

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition();
		while(SourceContext.HasChar()) {
			@Var char ch = SourceContext.ParseChar();
			if(!LibZen.IsSymbol(ch) && !LibZen.IsDigit(ch)) {
				break;
			}
			SourceContext.MoveNext();
		}
		SourceContext.Tokenize(StartIndex, SourceContext.GetPosition());
		return true;
	}

}
