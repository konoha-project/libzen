package libzen.grammar;

import zen.ast.ZIntNode;
import zen.ast.ZNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class IntLiteralPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		return new ZIntNode(ParentNode, Token, LibZen.ParseInt(Token.GetText()));
	}

}
