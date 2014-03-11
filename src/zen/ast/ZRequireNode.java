package zen.ast;

import zen.codegen.jvm.JavaImportNode;
import zen.parser.ZNameSpace;
import zen.util.Var;

public class ZRequireNode extends ZTopLevelNode {
	public final static int _Path = 0;

	public ZRequireNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	@Override public final void Perform(ZNameSpace NameSpace) {
		@Var String ResourcePath = this.AST[JavaImportNode._Path].SourceToken.GetTextAsName();
		NameSpace.Generator.RequireLibrary(ResourcePath, this.GetAstToken(JavaImportNode._Path));
	}

}
