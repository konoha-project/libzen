package zen.grammar;

import zen.ast.ZInstanceOfNode;
import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class InstanceOfPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BinaryNode = new ZInstanceOfNode(ParentNode, TokenContext.GetToken(ZTokenContext._MoveNext), LeftNode);
		BinaryNode = TokenContext.MatchPattern(BinaryNode, ZInstanceOfNode._TypeInfo, "$OpenType$", ZTokenContext._Required);
		return BinaryNode;
	}

}
