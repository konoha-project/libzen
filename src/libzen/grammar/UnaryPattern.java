package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZUnaryNode;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class UnaryPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode UnaryNode = new ZUnaryNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
		return TokenContext.MatchPattern(UnaryNode, ZUnaryNode.Recv, "$SuffixExpression$", ZTokenContext.Required);
	}

}
