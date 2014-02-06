package libzen.grammar;

import zen.ast.ZFloatNode;
import zen.ast.ZNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class FloatLiteralPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		return new ZFloatNode(ParentNode, Token, LibZen.ParseFloat(Token.GetText()));
	}

}
