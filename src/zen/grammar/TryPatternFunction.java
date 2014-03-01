package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZTryNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class TryPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode TryNode = new ZTryNode(ParentNode);
		TryNode = TokenContext.MatchToken(TryNode, "try", ZTokenContext._Required);
		TryNode = TokenContext.MatchPattern(TryNode, ZTryNode._Try, "$Block$", ZTokenContext._Required);
		@Var int count = 0;
		if(TokenContext.IsNewLineToken("catch")) {
			TryNode = TokenContext.MatchPattern(TryNode, ZTryNode._Catch, "$Catch$", ZTokenContext._Required);
			count = count + 1;
		}
		if(TokenContext.MatchNewLineToken("finally")) {
			TryNode = TokenContext.MatchPattern(TryNode, ZTryNode._Finally, "$Block$", ZTokenContext._Required);
			count = count + 1;
		}
		if(count == 0 && !TryNode.IsErrorNode()) {
			return TryNode.AST[ZTryNode._Try]; // no catch and finally
		}
		return TryNode;
	}

}
