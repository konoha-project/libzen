package zen.grammar;

import zen.ast.ZCatchNode;
import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class CatchPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode CatchNode = new ZCatchNode(ParentNode);
		CatchNode = TokenContext.MatchToken(CatchNode, "catch", ZTokenContext._Required);
		CatchNode = TokenContext.MatchToken(CatchNode, "(", ZTokenContext._Required);
		CatchNode = TokenContext.MatchPattern(CatchNode, ZNode._NameInfo, "$Name$", ZTokenContext._Required);
		CatchNode = TokenContext.MatchToken(CatchNode, ")", ZTokenContext._Required);
		CatchNode = TokenContext.MatchPattern(CatchNode, ZCatchNode._Block, "$Block$", ZTokenContext._Required);
		return CatchNode;
	}

}
