package libzen.grammar;

import zen.ast.ZGetNameNode;
import zen.ast.ZNode;
import zen.ast.ZSetNameNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class SymbolStatementPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken NameToken = TokenContext.GetToken(ZTokenContext.MoveNext);
		if(TokenContext.MatchToken("=")) {
			@Var ZNode AssignedNode = new ZSetNameNode(ParentNode, NameToken, NameToken.GetText());
			AssignedNode = TokenContext.MatchPattern(AssignedNode, ZSetNameNode._Expr, "$Expression$", ZTokenContext.Required);
			return AssignedNode;
		}
		else {
			return new ZGetNameNode(ParentNode, NameToken, NameToken.GetText());
		}
	}

}
