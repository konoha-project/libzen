package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZUnaryNode;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class NotPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode UnaryNode = new ZNotNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext));
		UnaryNode = TokenContext.MatchPattern(UnaryNode, ZUnaryNode.Recv, "$SuffixExpression$", ZTokenContext.Required);
		return UnaryNode;
	}

}
