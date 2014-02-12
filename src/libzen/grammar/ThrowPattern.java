package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZThrowNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class ThrowPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ThrowNode = new ZThrowNode(ParentNode);
		ThrowNode = TokenContext.MatchToken(ThrowNode, "throw", ZTokenContext.Required);
		ThrowNode = TokenContext.MatchPattern(ThrowNode, ZThrowNode._Expr, "$Expression$", ZTokenContext.Required);
		return ThrowNode;
	}

}
