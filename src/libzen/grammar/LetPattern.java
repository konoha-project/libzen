package libzen.grammar;

import zen.ast.ZLetNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class LetPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode LetNode = new ZLetNode(ParentNode);
		LetNode = TokenContext.MatchToken(LetNode, "let", ZTokenContext.Required);
		LetNode = TokenContext.MatchPattern(LetNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		//		if(TokenContext.MatchToken(".")) {
		//			LetNode = TokenContext.MatchPattern(LetNode, "$Name$", ZTokenContext.Required);
		//		}
		LetNode = TokenContext.MatchPattern(LetNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		LetNode = TokenContext.MatchToken(LetNode, "=", ZTokenContext.Required);
		LetNode = TokenContext.MatchPattern(LetNode, ZLetNode._InitValue, "$Expression$", ZTokenContext.Required);
		return LetNode;
	}

}
