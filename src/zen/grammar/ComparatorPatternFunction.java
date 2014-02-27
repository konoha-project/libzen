package zen.grammar;

import zen.ast.ZBinaryNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class ComparatorPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.GetToken(ZTokenContext._MoveNext);
		@Var ZBinaryNode BinaryNode = new ZComparatorNode(ParentNode, Token, LeftNode, TokenContext.GetApplyingSyntax());
		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	}

}
