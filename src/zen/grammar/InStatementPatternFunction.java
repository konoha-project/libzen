package zen.grammar;

import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.ZMatchFunction;

public class InStatementPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		TokenContext.SetParseFlag(ZTokenContext._AllowSkipIndent);
		return ExpressionPatternFunction._DispatchPattern(ParentNode, TokenContext, null, true, true);
	}

}
