package libzen.grammar;

import zen.ast.ZBlockNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class BlockPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode BlockNode = new ZBlockNode(ParentNode, 0);
		@Var ZToken SkipToken = TokenContext.GetToken();
		BlockNode = TokenContext.MatchToken(BlockNode, "{", ZTokenContext.Required);
		if(!BlockNode.IsErrorNode()) {
			@Var boolean Remembered = TokenContext.SetParseFlag(ZTokenContext.AllowSkipIndent); // init
			@Var ZNode NestedBlockNode = BlockNode;
			while(TokenContext.HasNext()) {
				//System.out.println("Token :" + TokenContext.GetToken());
				if(TokenContext.MatchToken("}")) {
					break;
				}
				@Var ZNode StmtNode = TokenContext.MatchPattern(NestedBlockNode, ZNode.AppendIndex, "$Statement$", ZTokenContext.Required);
				if(StmtNode.IsErrorNode()) {
					NestedBlockNode.Set(ZNode.AppendIndex, StmtNode);
					TokenContext.SkipError(SkipToken);
					TokenContext.MatchToken("}");
					break;
				}
				/* VarDecl is defined as BlockNode to speficy its scope */
				if(StmtNode instanceof ZBlockNode) {
					//System.out.println("nesting scope " + ParsedNode);
					NestedBlockNode = StmtNode;
				}
			}
			TokenContext.SetParseFlag(Remembered);
		}
		return BlockNode;
	}

}
