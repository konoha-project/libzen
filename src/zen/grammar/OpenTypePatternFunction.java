package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZTypeNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.parser.ZTypeChecker;
import zen.type.ZType;
import zen.type.ZTypePool;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class OpenTypePatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken MaybeToken   = null;
		@Var ZToken MutableToken = null;
		if(TokenContext.IsToken("maybe")) {
			MaybeToken   = TokenContext.GetToken(ZTokenContext._MoveNext);
		}
		if(TokenContext.MatchToken("mutable")) {
			MutableToken   = TokenContext.GetToken(ZTokenContext._MoveNext);
		}
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext._MoveNext);
		@Var ZType Type = ParentNode.GetNameSpace().GetType(Token.GetText(), Token, true/*IsCreation*/);
		if(Type != null) {
			@Var ZTypeNode TypeNode = new ZTypeNode(ParentNode, Token, Type);
			@Var ZNode Node = TokenContext.ParsePatternAfter(ParentNode, TypeNode, "$TypeRight$", ZTokenContext._Optional);
			if(Node instanceof ZTypeNode) {
				@Var ZTypeChecker Gamma = ParentNode.GetNameSpace().Generator.TypeChecker;
				if(MutableToken != null) {
					Node.Type = ZTypePool._LookupMutableType(Gamma, Node.Type, MutableToken);
				}
				if(MaybeToken != null) {
					Node.Type = ZTypePool._LookupNullableType(Gamma, Node.Type, MaybeToken);
				}
			}
			return Node;
		}
		return null; // Not Matched
	}

}
