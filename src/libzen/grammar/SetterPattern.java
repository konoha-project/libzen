package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZSetterNode;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class SetterPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		ZNode SetterNode = new ZSetterNode(ParentNode, LeftNode);
		SetterNode = TokenContext.MatchToken(SetterNode, ".", ZTokenContext.Required);
		SetterNode = TokenContext.MatchPattern(SetterNode, ZNode._NameInfo, "$Name$", ZTokenContext.Required);
		SetterNode = TokenContext.MatchToken(SetterNode, "=", ZTokenContext.Required);
		SetterNode = TokenContext.MatchPattern(SetterNode, ZSetterNode._Expr, "$Expression$", ZTokenContext.Required);
		return SetterNode;
	}

}
