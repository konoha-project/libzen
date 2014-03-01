package zen.grammar;

import zen.ast.ZFloatNode;
import zen.ast.ZNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class FloatLiteralPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext._MoveNext);
		return new ZFloatNode(ParentNode, Token, LibZen._ParseFloat(Token.GetText()));
	}

}
