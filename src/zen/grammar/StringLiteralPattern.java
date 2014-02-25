package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZStringNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class StringLiteralPattern extends ZMatchFunction {
	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext._MoveNext);
		return new ZStringNode(ParentNode, Token, LibZen._UnquoteString(Token.GetText()));
	}
}
