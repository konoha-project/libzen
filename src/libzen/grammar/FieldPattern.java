package libzen.grammar;

import zen.ast.ZFieldNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZTokenContext;

public class FieldPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var boolean Rememberd = TokenContext.SetParseFlag(false);
		@Var ZNode FieldNode = new ZFieldNode(ParentNode);
		FieldNode = TokenContext.MatchToken(FieldNode, "field", ZTokenContext.Required);
		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode.NameInfo, "$Name$", ZTokenContext.Required);
		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode.TypeInfo, "$TypeAnnotation$", ZTokenContext.Optional);
		if(TokenContext.MatchToken("=")) {
			FieldNode = TokenContext.MatchPattern(FieldNode, ZFieldNode.InitValue, "$Expression$", ZTokenContext.Required);
		}
		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode.Nop, ";", ZTokenContext.Required);
		TokenContext.SetParseFlag(Rememberd);
		return FieldNode;
	}

}
