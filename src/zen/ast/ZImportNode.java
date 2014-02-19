package zen.ast;

import zen.deps.Field;
import zen.lang.ZenError;
import zen.parser.ZToken;

public class ZImportNode extends ZNode {
	@Field public String ResourcePath = null;
	@Field public String Alias = null;

	public ZImportNode(ZNode ParentNode) {
		super(ParentNode, null, 0);
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		if(this.ResourcePath == null) {
			this.ResourcePath = Name;
		}
		else {
			this.Alias = Name;
		}
	}

	public ZNode Import() {
		return ZenError.UnfoundResource(this, this.ResourcePath);
	}

}
