package zen.grammar;

import zen.ast.ZBinaryNode;
import zen.ast.ZNode;
import zen.ast.ZOrNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class OrPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZBinaryNode BinaryNode = new ZOrNode(ParentNode, TokenContext.GetToken(ZTokenContext._MoveNext), LeftNode, TokenContext.GetApplyingSyntax());
		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	}

}
