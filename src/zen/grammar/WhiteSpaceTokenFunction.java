package zen.grammar;

import zen.deps.ZTokenFunction;
import zen.parser.ZSourceContext;

public class WhiteSpaceTokenFunction extends ZTokenFunction {
	@Override public boolean Invoke(ZSourceContext SourceContext) {
		SourceContext.SkipWhiteSpace();
		return true;
	}
}
