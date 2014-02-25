package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZVarNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class VarPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode VarNode = new ZVarNode(ParentNode);
		VarNode = TokenContext.MatchToken(VarNode, "var", ZTokenContext._Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZNode._NameInfo, "$Name$", ZTokenContext._Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZNode._TypeInfo, "$TypeAnnotation$", ZTokenContext._Optional);
		VarNode = TokenContext.MatchToken(VarNode, "=", ZTokenContext._Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZVarNode._InitValue, "$Expression$", ZTokenContext._Required);
		return VarNode;
	}

}
