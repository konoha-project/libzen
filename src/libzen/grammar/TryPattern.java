package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZTryNode;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class TryPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode TryNode = new ZTryNode(ParentNode);
		TryNode = TokenContext.MatchToken(TryNode, "try", ZTokenContext.Required);
		TryNode = TokenContext.MatchPattern(TryNode, ZTryNode.Try, "$Block$", ZTokenContext.Required);
		int count = 0;
		if(TokenContext.IsNewLineToken("catch")) {
			TryNode = TokenContext.MatchPattern(TryNode, ZTryNode.Catch, "$Catch$", ZTokenContext.Required);
			count = count + 1;
		}
		if(TokenContext.MatchNewLineToken("finally")) {
			TryNode = TokenContext.MatchPattern(TryNode, ZTryNode.Finally, "$Block$", ZTokenContext.Required);
			count = count + 1;
		}
		if(count == 0 && !TryNode.IsErrorNode()) {
			return TryNode.AST[ZTryNode.Try]; // no catch and finally
		}
		return TryNode;
	}

}
