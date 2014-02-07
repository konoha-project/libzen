package libzen.grammar;

import zen.ast.ZInstanceOfNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class InstanceOfPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BinaryNode = new ZInstanceOfNode(ParentNode, TokenContext.GetToken(ZTokenContext.MoveNext), LeftNode);
		BinaryNode = TokenContext.MatchPattern(BinaryNode, ZNode.TypeInfo, "$Type$", ZTokenContext.Required);
		return BinaryNode;
	}

}
