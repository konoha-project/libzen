package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZStringNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class StringLiteralPatternFunction extends ZMatchFunction {
	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext._MoveNext);
		return new ZStringNode(ParentNode, Token, LibZen._UnquoteString(Token.GetText()));
	}
}
