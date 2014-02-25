package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZTypeNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class TypePattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext._MoveNext);
		@Var ZTypeNode TypeNode = ParentNode.GetNameSpace().GetTypeNode(Token.GetText(), Token);
		if(TypeNode != null) {
			return TokenContext.ParsePatternAfter(ParentNode, TypeNode, "$TypeRight$", ZTokenContext._Optional);
		}
		return null; // Not Matched
	}

}
