package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZRequireNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class RequirePatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode RequireNode = new ZRequireNode(ParentNode);
		RequireNode = TokenContext.MatchToken(RequireNode, "require", ZTokenContext._Required);
		RequireNode = TokenContext.MatchPattern(RequireNode, ZRequireNode._Path, "$StringLiteral$", ZTokenContext._Required);
		return RequireNode;
	}

}
