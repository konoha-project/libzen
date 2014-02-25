package zen.grammar;

import zen.ast.ZAssertNode;
import zen.ast.ZNode;
import zen.ast.ZThrowNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;


public class AssertPattern extends ZMatchFunction {
	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode AssertNode = new ZAssertNode(ParentNode);
		AssertNode = TokenContext.MatchToken(AssertNode, "assert", ZTokenContext._Required);
		AssertNode = TokenContext.MatchToken(AssertNode, "(", ZTokenContext._Required);
		AssertNode = TokenContext.MatchPattern(AssertNode, ZThrowNode._Expr, "$Expression$", ZTokenContext._Required, ZTokenContext._AllowSkipIndent);
		AssertNode = TokenContext.MatchToken(AssertNode, ")", ZTokenContext._Required);
		return AssertNode;
	}

}
