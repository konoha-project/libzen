package zen.lang.konoha;

import zen.ast.ZNode;
import zen.ast.sugar.ZContinueNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class ContinuePatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ContinueNode = new ZContinueNode(ParentNode);
		ContinueNode = TokenContext.MatchToken(ContinueNode, "continue", ZTokenContext._Required);
		return ContinueNode;
	}

}
