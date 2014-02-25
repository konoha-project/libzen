package libzen.grammar;

import zen.ast.ZCatchNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class CatchPattern extends ZMatchFunction {

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
