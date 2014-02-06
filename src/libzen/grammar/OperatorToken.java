package libzen.grammar;

import zen.deps.ZenTokenFunction;
import zen.parser.ZSourceContext;

public class OperatorToken extends ZenTokenFunction {

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		SourceContext.TokenizeDefinedSymbol(SourceContext.GetPosition());
		return true;
	}

}
