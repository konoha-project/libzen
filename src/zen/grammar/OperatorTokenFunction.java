package zen.grammar;

import zen.parser.ZSourceContext;
import zen.util.ZTokenFunction;

public class OperatorTokenFunction extends ZTokenFunction {

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		SourceContext.TokenizeDefinedSymbol(SourceContext.GetPosition());
		return true;
	}

}
