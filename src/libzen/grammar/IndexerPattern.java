package libzen.grammar;

import zen.ast.ZGetIndexNode;
import zen.ast.ZNode;
import zen.ast.ZSetIndexNode;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class IndexerPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IndexerNode = new ZGetIndexNode(ParentNode, LeftNode);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "[", ZTokenContext.Required);
		IndexerNode = TokenContext.MatchPattern(IndexerNode, ZGetIndexNode.Index, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "]", ZTokenContext.Required);
		if(TokenContext.MatchToken("=") && !IndexerNode.IsErrorNode()) {
			IndexerNode = new ZSetIndexNode((ZGetIndexNode)IndexerNode);
			IndexerNode = TokenContext.MatchPattern(IndexerNode, ZSetIndexNode.Expr, "$Expression$", ZTokenContext.Required);
		}
		return IndexerNode;
	}

}
