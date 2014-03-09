package zen.grammar;

import zen.ast.ZCastNode;
import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.type.ZType;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class CastPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode CastNode = new ZCastNode(ParentNode, ZType.VarType, null);
		CastNode = TokenContext.MatchToken(CastNode, "(", ZTokenContext._Required);
		CastNode = TokenContext.MatchPattern(CastNode, ZCastNode._TypeInfo, "$Type$", ZTokenContext._Required);
		CastNode = TokenContext.MatchToken(CastNode, ")", ZTokenContext._Required);
		CastNode = TokenContext.MatchPattern(CastNode, ZCastNode._Expr, "$RightExpression$", ZTokenContext._Required);
		if(CastNode instanceof ZCastNode) {
			((ZCastNode)CastNode).CastType();  // due to old implementation that cannot be fixed easily.
		}
		return CastNode;
	}

}
