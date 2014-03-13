package zen.grammar;

import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class NewObjectPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZNewObjectNode(ParentNode);
		LiteralNode = TokenContext.MatchToken(LiteralNode, "new", ZTokenContext._Required);
		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZNewObjectNode._TypeInfo, "$OpenType$", ZTokenContext._Optional);
		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "(", "$Expression$", ",", ")");
		return LiteralNode;
	}

}
