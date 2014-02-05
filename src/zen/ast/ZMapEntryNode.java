package zen.ast;

import zen.deps.Field;

public class ZMapEntryNode extends ZNode {
	public final static int Key = 0;
	public final static int Value = 1;
	@Field public String  Name = null;

	@Deprecated public ZNode KeyNode = null;
	@Deprecated public ZNode MapValueNode = null;

	public ZMapEntryNode(ZNode ParentNode) {
		super(ParentNode, null, 2);
	}
	@Override public String GetVisitName() {
		return "VisitMapEntryNode"; // override this if you want to use additional node
	}
}
