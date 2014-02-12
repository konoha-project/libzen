package libzen.grammar;

import zen.ast.ZImportNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class ImportPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode ImportNode = TokenContext.Generator.CreateImportNode(ParentNode);
		ImportNode = TokenContext.MatchToken(ImportNode, "import", ZTokenContext.Required);
		ImportNode = TokenContext.MatchPattern(ImportNode, ZNode._NameInfo, "$Path$", ZTokenContext.Required);
		if(ImportNode instanceof ZImportNode) {
			return ((ZImportNode)ImportNode).Import();
		}
		return ImportNode;
	}

}
