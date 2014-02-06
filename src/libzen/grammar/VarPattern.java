package libzen.grammar;

import zen.ast.ZNode;
import zen.ast.ZVarDeclNode;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class VarPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode VarNode = new ZVarDeclNode(ParentNode);
		VarNode = TokenContext.MatchToken(VarNode, "var", ZTokenContext.Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		VarNode = TokenContext.MatchToken(VarNode, "=", ZTokenContext.Required);
		VarNode = TokenContext.MatchPattern(VarNode, ZVarDeclNode.InitValue, "$Expression$", ZTokenContext.Required);
		return VarNode;
	}

}