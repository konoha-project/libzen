package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class NullPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZNullNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
	}

}
