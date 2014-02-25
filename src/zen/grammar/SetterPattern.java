package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZSetterNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class SetterPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode SetterNode = new ZSetterNode(ParentNode, LeftNode);
		SetterNode = TokenContext.MatchToken(SetterNode, ".", ZTokenContext._Required);
		SetterNode = TokenContext.MatchPattern(SetterNode, ZNode._NameInfo, "$Name$", ZTokenContext._Required);
		SetterNode = TokenContext.MatchToken(SetterNode, "=", ZTokenContext._Required);
		SetterNode = TokenContext.MatchPattern(SetterNode, ZSetterNode._Expr, "$Expression$", ZTokenContext._Required);
		return SetterNode;
	}

}
