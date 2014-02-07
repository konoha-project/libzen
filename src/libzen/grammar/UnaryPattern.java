package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZUnaryNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class UnaryPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode UnaryNode = new ZUnaryNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
		return TokenContext.MatchPattern(UnaryNode, ZUnaryNode.Recv, "$RightExpression$", ZTokenContext.Required);
	}

}
