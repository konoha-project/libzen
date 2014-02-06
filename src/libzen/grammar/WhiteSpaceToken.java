package libzen.grammar;

import zen.deps.ZenTokenFunction;
import zen.parser.ZSourceContext;

public class WhiteSpaceToken extends ZenTokenFunction {
	@Override public boolean Invoke(ZSourceContext SourceContext) {
		SourceContext.SkipWhiteSpace();
		return true;
	}
}
