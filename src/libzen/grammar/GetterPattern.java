package libzen.grammar;

import zen.ast.ZGetterNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNode;
import zen.ast.ZSetterNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class GetterPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		TokenContext.MatchToken(".");
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext.MoveNext);
		if(!Token.IsNameSymbol()) {
			return TokenContext.CreateExpectedErrorNode(Token, "field name");
		}
		if(TokenContext.IsToken("(")) {  // method call
			@Var ZNode MethodCallNode = new ZMethodCallNode(ParentNode, Token, LeftNode, Token.GetText());
			MethodCallNode = TokenContext.MatchNtimes(MethodCallNode, "(", "$Expression$", ",", ")");
			return MethodCallNode;
		}
		if(TokenContext.MatchToken("=")) {
			ZNode SetterNode = new ZSetterNode(ParentNode, Token, LeftNode, Token.GetText());
			SetterNode = TokenContext.MatchPattern(SetterNode, ZSetterNode.Expr, "$Expression$", ZTokenContext.Required);
			return SetterNode;
		}
		else {
			return new ZGetterNode(ParentNode, Token, LeftNode, Token.GetText());
		}
	}

}
