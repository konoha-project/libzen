package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZReturnNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class ReturnPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ReturnNode = new ZReturnNode(ParentNode);
		ReturnNode = TokenContext.MatchToken(ReturnNode, "return", ZTokenContext._Required);
		ReturnNode = TokenContext.MatchPattern(ReturnNode, ZReturnNode._Expr, "$Expression$", ZTokenContext._Optional);
		return ReturnNode;
	}

}
