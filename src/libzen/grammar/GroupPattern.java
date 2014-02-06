package libzen.grammar;

import zen.ast.ZGroupNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class GroupPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode GroupNode = new ZGroupNode(ParentNode);
		GroupNode = TokenContext.MatchToken(GroupNode, "(", ZTokenContext.Required);
		GroupNode = TokenContext.MatchPattern(GroupNode, ZGroupNode.Expr, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
		GroupNode = TokenContext.MatchToken(GroupNode, ")", ZTokenContext.Required);
		return GroupNode;
	}

}
