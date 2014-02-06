package libzen.grammar;

import zen.ast.ZBooleanNode;
import zen.ast.ZNode;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class TruePattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return new ZBooleanNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), true);
	}

}
