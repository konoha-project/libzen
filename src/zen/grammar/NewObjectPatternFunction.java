package zen.grammar;

import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class NewObjectPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZNewObjectNode(ParentNode);
		LiteralNode = TokenContext.MatchToken(LiteralNode, "new", ZTokenContext._Required);
		LiteralNode = TokenContext.MatchPattern(LiteralNode, ZNode._TypeInfo, "$Type$", ZTokenContext._Optional);
		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "(", "$Expression$", ",", ")");
		return LiteralNode;
	}

}
