package zen.grammar;

import zen.ast.ZGetNameNode;
import zen.ast.ZNode;
import zen.ast.ZSetNameNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class SymbolStatementPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken NameToken = TokenContext.GetToken(ZTokenContext._MoveNext);
		if(TokenContext.MatchToken("=")) {
			@Var ZNode AssignedNode = new ZSetNameNode(ParentNode, NameToken, NameToken.GetText());
			AssignedNode = TokenContext.MatchPattern(AssignedNode, ZSetNameNode._Expr, "$Expression$", ZTokenContext._Required);
			return AssignedNode;
		}
		else {
			return new ZGetNameNode(ParentNode, NameToken, NameToken.GetText());
		}
	}

}
