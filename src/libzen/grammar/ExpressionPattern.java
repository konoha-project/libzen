package libzen.grammar;

import zen.ast.ZNode;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class ExpressionPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return ZenGrammar.DispatchPattern(ParentNode, TokenContext, LeftNode, false, true);
	}

}
