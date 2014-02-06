package libzen.grammar;

import zen.ast.ZNode;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class SuffixExpressionPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return ExpressionPattern.DispatchPattern(ParentNode, TokenContext, LeftNode, false, false);
	}

}
