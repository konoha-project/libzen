package zen.grammar;

import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.ZMatchFunction;

public class TypeAnnotationPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		if(TokenContext.MatchToken(":")) {
			return TokenContext.ParsePattern(ParentNode, "$OpenType$", ZTokenContext._Required);
		}
		return null;
	}

}
