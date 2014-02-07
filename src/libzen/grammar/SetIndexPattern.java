package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZSetIndexNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class SetIndexPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IndexerNode = new ZSetIndexNode(ParentNode, LeftNode);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "[", ZTokenContext.Required);
		IndexerNode = TokenContext.MatchPattern(IndexerNode, ZSetIndexNode.Index, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "]", ZTokenContext.Required);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "=", ZTokenContext.Required);
		IndexerNode = TokenContext.MatchPattern(IndexerNode, ZSetIndexNode.Expr, "$Expression$", ZTokenContext.Required);
		return IndexerNode;
	}

}
