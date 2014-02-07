package libzen.grammar;

import zen.ast.ZGetIndexNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class GetIndexPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IndexerNode = new ZGetIndexNode(ParentNode, LeftNode);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "[", ZTokenContext.Required);
		IndexerNode = TokenContext.MatchPattern(IndexerNode, ZGetIndexNode.Index, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowSkipIndent);
		IndexerNode = TokenContext.MatchToken(IndexerNode, "]", ZTokenContext.Required);
		return IndexerNode;
	}

}
