package zen.ast;

import zen.ast.sugar.ZTopLevelNode;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.util.Field;

public class ZRequireNode extends ZTopLevelNode {
	@Field public String ResourcePath = null;
	@Field public ZToken ResourceToken = null;

	public ZRequireNode(ZNode ParentNode) {
		super(ParentNode, null, 0);
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.ResourcePath = Name;
		this.ResourceToken = NameToken;
	}

	@Override public final void Perform(ZNameSpace NameSpace) {
		NameSpace.Generator.RequireLibrary(this.ResourcePath);
	}

}
