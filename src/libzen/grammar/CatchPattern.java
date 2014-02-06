package libzen.grammar;

import zen.ast.ZCatchNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class CatchPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode CatchNode = new ZCatchNode(ParentNode);
		CatchNode = TokenContext.MatchToken(CatchNode, "catch", ZTokenContext.Required);
		CatchNode = TokenContext.MatchToken(CatchNode, "(", ZTokenContext.Required);
		CatchNode = TokenContext.MatchPattern(CatchNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		CatchNode = TokenContext.MatchToken(CatchNode, ")", ZTokenContext.Required);
		CatchNode = TokenContext.MatchPattern(CatchNode, ZCatchNode.Block, "$Block$", ZTokenContext.Required);
		return CatchNode;
	}

}
