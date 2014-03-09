package zen.grammar;

import zen.ast.ZFieldNode;
import zen.ast.ZNode;
import zen.ast.ZVarNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class FieldPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var boolean Rememberd = TokenContext.SetParseFlag(false);
		@Var ZNode FieldNode = new ZFieldNode(ParentNode);
		FieldNode = TokenContext.MatchToken(FieldNode, "var", ZTokenContext._Required);
		FieldNode = TokenContext.MatchPattern(FieldNode, ZVarNode._NameInfo, "$Name$", ZTokenContext._Required);
		FieldNode = TokenContext.MatchPattern(FieldNode, ZVarNode._TypeInfo, "$TypeAnnotation$", ZTokenContext._Optional);
		if(TokenContext.MatchToken("=")) {
			FieldNode = TokenContext.MatchPattern(FieldNode, ZFieldNode._InitValue, "$Expression$", ZTokenContext._Required);
		}
		FieldNode = TokenContext.MatchPattern(FieldNode, ZNode._Nop, ";", ZTokenContext._Required);
		TokenContext.SetParseFlag(Rememberd);
		return FieldNode;
	}

}
