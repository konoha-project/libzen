package zen.grammar;

import zen.parser.ZSourceContext;
import zen.util.ZTokenFunction;

public class WhiteSpaceTokenFunction extends ZTokenFunction {
	@Override public boolean Invoke(ZSourceContext SourceContext) {
		SourceContext.SkipWhiteSpace();
		return true;
	}
}
