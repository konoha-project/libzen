package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZVarNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class VarPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode VarNode = new ZVarNode(ParentNode);
		VarNode = TokenContext.MatchToken(VarNode, "var", ZTokenContext._Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZVarNode._NameInfo, "$Name$", ZTokenContext._Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZVarNode._TypeInfo, "$TypeAnnotation$", ZTokenContext._Optional);
		VarNode = TokenContext.MatchToken(VarNode, "=", ZTokenContext._Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZVarNode._InitValue, "$Expression$", ZTokenContext._Required);
		return VarNode;
	}

}
