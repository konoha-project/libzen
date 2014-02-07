package libzen.grammar;

import zen.ast.ZNode;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class RightExpressionPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return ExpressionPattern.DispatchPattern(ParentNode, TokenContext, LeftNode, false, false);
	}

}
