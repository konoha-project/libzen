package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZSetIndexNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class SetIndexPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IndexerNode = new ZSetIndexNode(ParentNode, LeftNode);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "[", ZTokenContext._Required);
		IndexerNode = TokenContext.MatchPattern(IndexerNode, ZSetIndexNode._Index, "$Expression$", ZTokenContext._Required, ZTokenContext._AllowSkipIndent);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "]", ZTokenContext._Required);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "=", ZTokenContext._Required);
		IndexerNode = TokenContext.MatchPattern(IndexerNode, ZSetIndexNode._Expr, "$Expression$", ZTokenContext._Required);
		return IndexerNode;
	}

}
