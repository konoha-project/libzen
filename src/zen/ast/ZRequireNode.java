package zen.ast;

import zen.parser.ZToken;
import zen.util.Field;

public class ZRequireNode extends ZNode {
	@Field public String ResourcePath = null;
	@Field public ZToken ResourceToken = null;

	public ZRequireNode(ZNode ParentNode) {
		super(ParentNode, null, 0);
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.ResourcePath = Name;
		this.ResourceToken = NameToken;
	}

}
