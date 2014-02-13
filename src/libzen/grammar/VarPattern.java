package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZVarNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class VarPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode VarNode = new ZVarNode(ParentNode);
		VarNode = TokenContext.MatchToken(VarNode, "var", ZTokenContext.Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZNode._NameInfo, "$Name$", ZTokenContext.Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZNode._TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		VarNode = TokenContext.MatchToken(VarNode, "=", ZTokenContext.Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZVarNode._InitValue, "$Expression$", ZTokenContext.Required);
		return VarNode;
	}

}
