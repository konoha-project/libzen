package zen.grammar;

import zen.ast.ZNode;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class RightExpressionPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return ExpressionPatternFunction._DispatchPattern(ParentNode, TokenContext, LeftNode, false, false);
	}

}
