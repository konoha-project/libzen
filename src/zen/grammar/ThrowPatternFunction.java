package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZThrowNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class ThrowPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ThrowNode = new ZThrowNode(ParentNode);
		ThrowNode = TokenContext.MatchToken(ThrowNode, "throw", ZTokenContext._Required);
		ThrowNode = TokenContext.MatchPattern(ThrowNode, ZThrowNode._Expr, "$Expression$", ZTokenContext._Required);
		return ThrowNode;
	}

}
