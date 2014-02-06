package libzen.grammar;

import zen.ast.ZBreakNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class BreakPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BreakNode = new ZBreakNode(ParentNode);
		BreakNode = TokenContext.MatchToken(BreakNode, "break", ZTokenContext.Required);
		return BreakNode;
	}

}
