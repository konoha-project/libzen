package zen.grammar;

import zen.ast.ZIfNode;
import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class IfPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IfNode = new ZIfNode(ParentNode);
		IfNode = TokenContext.MatchToken(IfNode, "if", ZTokenContext._Required);
		IfNode = TokenContext.MatchToken(IfNode, "(", ZTokenContext._Required);
		IfNode = TokenContext.MatchPattern(IfNode, ZIfNode._Cond, "$Expression$", ZTokenContext._Required, ZTokenContext._AllowNewLine);
		IfNode = TokenContext.MatchToken(IfNode, ")", ZTokenContext._Required);
		IfNode = TokenContext.MatchPattern(IfNode, ZIfNode._Then, "$Block$", ZTokenContext._Required);
		if(TokenContext.MatchNewLineToken("else")) {
			if(TokenContext.IsNewLineToken("if")) {
				IfNode = TokenContext.MatchPattern(IfNode, ZIfNode._Else, "if", ZTokenContext._Required);
			}
			else {
				IfNode = TokenContext.MatchPattern(IfNode, ZIfNode._Else, "$Block$", ZTokenContext._Required);
			}
		}
		return IfNode;
	}

}
