package libzen.grammar;

import zen.ast.ZClassDeclNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class ClassPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ClassNode = new ZClassDeclNode(ParentNode);
		ClassNode = TokenContext.MatchToken(ClassNode, "class", ZTokenContext.Required);
		ClassNode = TokenContext.MatchPattern(ClassNode, ZNode._NameInfo, "$Name$", ZTokenContext.Required);
		if(TokenContext.MatchNewLineToken("extends")) {
			ClassNode = TokenContext.MatchPattern(ClassNode, ZNode._TypeInfo, "$Type$", ZTokenContext.Required);
		}
		ClassNode = TokenContext.MatchNtimes(ClassNode, "{", "$FieldDecl$", null, "}");
		return ClassNode;
	}

}
