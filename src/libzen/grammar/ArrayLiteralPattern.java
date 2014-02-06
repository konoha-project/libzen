package libzen.grammar;

import zen.ast.ZArrayLiteralNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class ArrayLiteralPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LiteralNode = new ZArrayLiteralNode(ParentNode);
		LiteralNode = TokenContext.MatchNtimes(LiteralNode, "[", "$Expression$", ",", "]");
		return LiteralNode;
	}

}
