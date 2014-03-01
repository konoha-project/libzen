package zen.codegen.jvm;

import zen.ast.ZGetNameNode;
import zen.ast.ZNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class JavaClassPathPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken Token = TokenContext.ParseLargeToken();
		return new ZGetNameNode(ParentNode, Token, Token.GetText());
	}

}
