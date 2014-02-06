package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZThrowNode;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class ThrowPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ThrowNode = new ZThrowNode(ParentNode);
		ThrowNode = TokenContext.MatchToken(ThrowNode, "throw", ZTokenContext.Required);
		ThrowNode = TokenContext.MatchPattern(ThrowNode, ZThrowNode.Expr, "$Expression$", ZTokenContext.Required);
		return ThrowNode;
	}

}
