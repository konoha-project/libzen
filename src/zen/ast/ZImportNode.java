package zen.ast;

import zen.deps.Field;
import zen.lang.ZenError;

public class ZImportNode extends ZNode {
	@Field public String ResourcePath = null;
	@Field public String Alias = null;

	public ZImportNode(ZNode ParentNode) {
		super(ParentNode, null, 0);
	}

	@Override public void SetNameInfo(String Name) {
		if(this.ResourcePath == null) {
			this.ResourcePath = Name;
		}
		else {
			this.Alias = Name;
		}
	}

	@Override public String GetVisitName() {
		return "VisitImportNode"; // override this if you want to use additional node
	}

	public ZNode Import() {
		return ZenError.UnfoundResource(this, this.ResourcePath);
	}

}
