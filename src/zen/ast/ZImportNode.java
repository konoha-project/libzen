package zen.ast;

import zen.parser.ZToken;
import zen.util.Field;

public abstract class ZImportNode extends ZNode {
	@Field public String ResourcePath = null;
	@Field public String Alias = null;
	@Field public ZToken ResourceToken = null;

	public ZImportNode(ZNode ParentNode) {
		super(ParentNode, null, 0);
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		if(this.ResourcePath == null) {
			this.ResourcePath = Name;
			this.ResourceToken = NameToken;
		}
		else {
			this.Alias = Name;
		}
	}

	public abstract ZNode Import();

}
