package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZThrowNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;


public class AssertPattern extends ZMatchFunction {
	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode AssertNode = new ZThrowNode(ParentNode);
		AssertNode = TokenContext.MatchToken(AssertNode, "assert", ZTokenContext.Required);
		AssertNode = TokenContext.MatchToken(AssertNode, "(", ZTokenContext.Required);
		AssertNode = TokenContext.MatchPattern(AssertNode, ZThrowNode.Expr, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
		AssertNode = TokenContext.MatchToken(AssertNode, ")", ZTokenContext.Required);
		return AssertNode;
	}

}
