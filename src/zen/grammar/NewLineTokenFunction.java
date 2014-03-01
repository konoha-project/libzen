package zen.grammar;

import zen.parser.ZSourceContext;
import zen.util.Var;
import zen.util.ZTokenFunction;

public class NewLineTokenFunction extends ZTokenFunction {

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition() + 1;
		SourceContext.MoveNext();
		SourceContext.SkipWhiteSpace();
		SourceContext.FoundIndent(StartIndex, SourceContext.GetPosition());
		return true;
	}

}
