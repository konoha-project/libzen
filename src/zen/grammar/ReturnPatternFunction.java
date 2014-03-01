package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZReturnNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class ReturnPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ReturnNode = new ZReturnNode(ParentNode);
		ReturnNode = TokenContext.MatchToken(ReturnNode, "return", ZTokenContext._Required);
		ReturnNode = TokenContext.MatchPattern(ReturnNode, ZReturnNode._Expr, "$Expression$", ZTokenContext._Optional);
		return ReturnNode;
	}

}
