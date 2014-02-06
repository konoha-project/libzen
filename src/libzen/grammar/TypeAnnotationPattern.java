package libzen.grammar;

import zen.ast.ZNode;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class TypeAnnotationPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		if(TokenContext.MatchToken(":")) {
			return TokenContext.ParsePattern(ParentNode, "$Type$", ZTokenContext.Required);
		}
		return null;
	}

}
