package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZUnaryNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class NotPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode UnaryNode = new ZNotNode(ParentNode, TokenContext.GetToken(ZTokenContext._MoveNext));
		UnaryNode = TokenContext.MatchPattern(UnaryNode, ZUnaryNode._Recv, "$RightExpression$", ZTokenContext._Required);
		return UnaryNode;
	}

}
