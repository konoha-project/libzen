package zen.grammar;

import zen.ast.ZBlockNode;
import zen.ast.ZNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class BlockPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BlockNode = new ZBlockNode(ParentNode, null);
		@Var ZToken SkipToken = TokenContext.GetToken();
		BlockNode = TokenContext.MatchToken(BlockNode, "{", ZTokenContext._Required);
		if(!BlockNode.IsErrorNode()) {
			@Var boolean Remembered = TokenContext.SetParseFlag(ZTokenContext._AllowSkipIndent); // init
			@Var ZNode NestedBlockNode = BlockNode;
			while(TokenContext.HasNext()) {
				//System.out.println("Token :" + TokenContext.GetToken());
				if(TokenContext.MatchToken("}")) {
					break;
				}
				NestedBlockNode = TokenContext.MatchPattern(NestedBlockNode, ZNode._NestedAppendIndex, "$Statement$", ZTokenContext._Required);
				if(NestedBlockNode.IsErrorNode()) {
					TokenContext.SkipError(SkipToken);
					TokenContext.MatchToken("}");
					break;
				}
			}
			TokenContext.SetParseFlag(Remembered);
		}
		return BlockNode;
	}

}
