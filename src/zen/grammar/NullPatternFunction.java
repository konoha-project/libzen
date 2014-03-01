package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.parser.ZTokenContext;
import zen.util.ZMatchFunction;

public class NullPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZNullNode(ParentNode, TokenContext.GetToken(ZTokenContext._MoveNext));
	}

}
