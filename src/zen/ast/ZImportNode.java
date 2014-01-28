package zen.ast;

import zen.deps.Field;
import zen.parser.ZNameSpace;

public class ZImportNode extends ZNode {
	@Field public ZNameSpace NameSpace;
	@Field public String ResourcePath = null;
	public ZImportNode(ZNameSpace NameSpace) {
		super();
		this.NameSpace = NameSpace.GetRootNameSpace();
	}

}
