package zen.grammar;

import zen.deps.ZTokenFunction;
import zen.parser.ZSourceContext;

public class OperatorTokenFunction extends ZTokenFunction {

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		SourceContext.TokenizeDefinedSymbol(SourceContext.GetPosition());
		return true;
	}

}
