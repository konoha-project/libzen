package zen.grammar;

import zen.ast.ZErrorNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class NamePattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext._MoveNext);
		if(LibZen._IsSymbol(Token.GetChar())) {
			return new ZGetNameNode(ParentNode, Token, Token.GetText());
		}
		return new ZErrorNode(ParentNode, Token, "illegal name: \'" + Token.GetText() + "\'");
	}

}
