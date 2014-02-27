package zen.grammar;

import zen.ast.ZMapLiteralNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class MapLiteralPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZMapLiteralNode(ParentNode);
		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "{", "$MapEntry$", ",", "}");
		return LiteralNode;
	}

}
