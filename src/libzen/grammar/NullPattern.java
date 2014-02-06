package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class NullPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZNullNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
	}

}
