package zen.grammar;

import zen.ast.ZLetNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class LetPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LetNode = new ZLetNode(ParentNode);
		LetNode = TokenContext.MatchToken(LetNode, "let", ZTokenContext._Required);
		LetNode = TokenContext.MatchPattern(LetNode, ZNode._NameInfo, "$Name$", ZTokenContext._Required);
		//		if(TokenContext.MatchToken(".")) {
		//			LetNode = TokenContext.MatchPattern(LetNode, "$Name$", ZTokenContext.Required);
		//		}
		LetNode = TokenContext.MatchPattern(LetNode, ZNode._TypeInfo, "$TypeAnnotation$", ZTokenContext._Optional);
		LetNode = TokenContext.MatchToken(LetNode, "=", ZTokenContext._Required);
		LetNode = TokenContext.MatchPattern(LetNode, ZLetNode._InitValue, "$Expression$", ZTokenContext._Required);
		return LetNode;
	}

}
