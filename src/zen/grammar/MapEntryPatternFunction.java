package zen.grammar;

import zen.ast.ZMapEntryNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class MapEntryPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZMapEntryNode(ParentNode);
		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZMapEntryNode._Key, "$Expression$", ZTokenContext._Required);
		LiteralNode = TokenContext.MatchToken(LiteralNode, ":", ZTokenContext._Required);
		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZMapEntryNode._Value, "$Expression$", ZTokenContext._Required);
		return LiteralNode;
	}

}
