package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZStringNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class StringLiteralPattern extends ZenMatchFunction {
	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		return new ZStringNode(ParentNode, Token, LibZen.UnquoteString(Token.GetText()));
	}
}
