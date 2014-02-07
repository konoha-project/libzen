package libzen.grammar;

import zen.ast.ZMethodCallNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class MethodCallPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode MethodCallNode = new ZMethodCallNode(ParentNode, LeftNode);
		MethodCallNode = TokenContext.MatchToken(MethodCallNode, ".", TokenContext.Required);
		MethodCallNode = TokenContext.MatchPattern(MethodCallNode, ZNode.NameInfo, "$Name$", TokenContext.Required);
		MethodCallNode = TokenContext.MatchNtimes(MethodCallNode, "(", "$Expression$", ",", ")");
		return MethodCallNode;
	}

}
