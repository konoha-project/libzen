package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZTypeNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class TypePatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext._MoveNext);
		@Var ZTypeNode TypeNode = ParentNode.GetNameSpace().GetTypeNode(Token.GetText(), Token);
		if(TypeNode != null) {
			return TokenContext.ParsePatternAfter(ParentNode, TypeNode, "$TypeRight$", ZTokenContext._Optional);
		}
		return null; // Not Matched
	}

}
