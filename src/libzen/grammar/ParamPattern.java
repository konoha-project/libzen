package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class ParamPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ParamNode = new ZParamNode(ParentNode);
		ParamNode = TokenContext.MatchPattern(ParamNode, ZNode._NameInfo, "$Name$", ZTokenContext.Required);
		ParamNode = TokenContext.MatchPattern(ParamNode, ZNode._TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		return ParamNode;
	}

}
