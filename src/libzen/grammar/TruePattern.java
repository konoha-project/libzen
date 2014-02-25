package libzen.grammar;

import zen.ast.ZBooleanNode;
import zen.ast.ZNode;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class TruePattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZBooleanNode(ParentNode, TokenContext.GetToken(ZTokenContext._MoveNext), true);
	}

}
