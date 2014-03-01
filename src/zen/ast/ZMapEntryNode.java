package zen.ast;

import zen.util.Field;

public class ZMapEntryNode extends ZNode {
	public final static int _Key = 0;
	public final static int _Value = 1;
	@Field public String  Name = null;

	public ZMapEntryNode(ZNode ParentNode) {
		super(ParentNode, null, 2);
	}
}
