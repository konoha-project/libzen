package zen.grammar;

import zen.ast.ZErrorNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class SymbolExpressionPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken NameToken = TokenContext.GetToken(ZTokenContext._MoveNext);
		if(TokenContext.IsToken("=")) {
			return new ZErrorNode(ParentNode, TokenContext.GetToken(), "assignment is not en expression");
		}
		else {
			return new ZGetNameNode(ParentNode, NameToken, NameToken.GetText());
		}
	}

}
