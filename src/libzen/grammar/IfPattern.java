package libzen.grammar;

import zen.ast.ZIfNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class IfPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode IfNode = new ZIfNode(ParentNode);
		IfNode = TokenContext.MatchToken(IfNode, "if", ZTokenContext.Required);
		IfNode = TokenContext.MatchToken(IfNode, "(", ZTokenContext.Required);
		IfNode = TokenContext.MatchPattern(IfNode, ZIfNode._Cond, "$Expression$", ZTokenContext.Required, ZTokenContext.AllowNewLine);
		IfNode = TokenContext.MatchToken(IfNode, ")", ZTokenContext.Required);
		IfNode = TokenContext.MatchPattern(IfNode, ZIfNode._Then, "$Block$", ZTokenContext.Required);
		if(TokenContext.MatchNewLineToken("else")) {
			@Var String PatternName = "$Block$";
			if(TokenContext.IsNewLineToken("if")) {
				PatternName = "if";
			}
			IfNode = TokenContext.MatchPattern(IfNode, ZIfNode._Else, PatternName, ZTokenContext.Required);
		}
		return IfNode;
	}

}
