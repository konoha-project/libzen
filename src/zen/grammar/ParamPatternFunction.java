package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class ParamPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ParamNode = new ZParamNode(ParentNode);
		ParamNode = TokenContext.MatchPattern(ParamNode, ZParamNode._NameInfo, "$Name$", ZTokenContext._Required);
		ParamNode = TokenContext.MatchPattern(ParamNode, ZParamNode._TypeInfo, "$TypeAnnotation$", ZTokenContext._Optional);
		return ParamNode;
	}

}
