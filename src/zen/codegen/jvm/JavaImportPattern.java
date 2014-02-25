package zen.codegen.jvm;

import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class JavaImportPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ImportNode = new JavaImportNode(ParentNode);
		ImportNode = TokenContext.MatchToken(ImportNode, "import", ZTokenContext._Required);
		ImportNode = TokenContext.MatchPattern(ImportNode, ZNode._NameInfo, "$JavaClassPath$", ZTokenContext._Required);
		return ImportNode;
	}

}
