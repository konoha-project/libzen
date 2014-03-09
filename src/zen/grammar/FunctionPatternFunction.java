package zen.grammar;

import zen.ast.ZFunctionNode;
import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class FunctionPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode FuncNode = new ZFunctionNode(ParentNode);
		FuncNode = TokenContext.MatchToken(FuncNode, "function", ZTokenContext._Required);
		FuncNode = TokenContext.MatchPattern(FuncNode, ZFunctionNode._NameInfo, "$Name$", ZTokenContext._Optional);
		FuncNode = TokenContext.MatchNtimes(FuncNode, "(", "$Param$", ",", ")");
		FuncNode = TokenContext.MatchPattern(FuncNode, ZFunctionNode._TypeInfo, "$TypeAnnotation$", ZTokenContext._Optional);
		FuncNode = TokenContext.MatchPattern(FuncNode, ZFunctionNode._Block, "$Block$", ZTokenContext._Required);
		return FuncNode;
	}

}
