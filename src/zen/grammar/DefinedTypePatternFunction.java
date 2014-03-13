package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZTypeNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.type.ZType;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class DefinedTypePatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext._MoveNext);
		@Var ZType Type = ParentNode.GetNameSpace().GetType(Token.GetText(), Token, false/*IsCreation*/);
		if(Type != null) {
			@Var ZTypeNode TypeNode = new ZTypeNode(ParentNode, Token, Type);
			return TokenContext.ParsePatternAfter(ParentNode, TypeNode, "$TypeRight$", ZTokenContext._Optional);
		}
		return null;
	}
}
