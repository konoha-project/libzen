package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZPrototypeNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class PrototypePattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode FuncNode = new ZPrototypeNode(ParentNode);
		FuncNode = TokenContext.MatchToken(FuncNode, "function", ZTokenContext._Required);
		FuncNode = TokenContext.MatchPattern(FuncNode, ZNode._NameInfo, "$Name$", ZTokenContext._Required);
		FuncNode = TokenContext.MatchNtimes(FuncNode, "(", "$Param$", ",", ")");
		FuncNode = TokenContext.MatchPattern(FuncNode, ZNode._TypeInfo, "$TypeAnnotation$", ZTokenContext._Required);
		return FuncNode;
	}
}


