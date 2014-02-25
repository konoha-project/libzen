package zen.grammar;

import zen.ast.ZMethodCallNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class MethodCallPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode MethodCallNode = new ZMethodCallNode(ParentNode, LeftNode);
		MethodCallNode = TokenContext.MatchToken(MethodCallNode, ".", ZTokenContext._Required);
		MethodCallNode = TokenContext.MatchPattern(MethodCallNode, ZNode._NameInfo, "$Name$", ZTokenContext._Required);
		MethodCallNode = TokenContext.MatchNtimes(MethodCallNode, "(", "$Expression$", ",", ")");
		return MethodCallNode;
	}

}
