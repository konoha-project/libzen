package libzen.grammar;

import zen.ast.ZMapEntryNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class MapEntryPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZMapEntryNode(ParentNode);
		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZMapEntryNode.Key, "$Expression$", ZTokenContext.Required);
		LiteralNode = TokenContext.MatchToken(LiteralNode, ":", ZTokenContext.Required);
		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZMapEntryNode.Value, "$Expression$", ZTokenContext.Required);
		return LiteralNode;
	}

}
