package libzen.grammar;

import zen.deps.Var;
import zen.deps.ZenTokenFunction;
import zen.parser.ZSourceContext;

public class NewLineToken extends ZenTokenFunction {

	@Override public boolean Invoke(ZSourceContext SourceContext) {
		@Var int StartIndex = SourceContext.GetPosition() + 1;
		SourceContext.MoveNext();
		SourceContext.SkipWhiteSpace();
		SourceContext.FoundIndent(StartIndex, SourceContext.GetPosition());
		return true;
	}

}
