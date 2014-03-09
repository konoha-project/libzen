package zen.codegen.jvm;

import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class JavaImportPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ImportNode = new JavaImportNode(ParentNode);
		ImportNode = TokenContext.MatchToken(ImportNode, "import", ZTokenContext._Required);
		ImportNode = TokenContext.MatchPattern(ImportNode, JavaImportNode._Path, "$JavaClassPath$", ZTokenContext._Required);
		return ImportNode;
	}

}
