package zen.ast;

import zen.util.Field;

public class ZMapEntryNode extends ZLocalDefinedNode {
	public final static int _Key = 0;
	public final static int _Value = 1;
	@Field public String  Name = null;

	public ZMapEntryNode(ZNode ParentNode) {
		super(ParentNode, null, 2);
	}

	public final ZNode KeyNode() {
		return this.AST[ZMapEntryNode._Key];
	}

	public final ZNode ValueNode() {
		return this.AST[ZMapEntryNode._Value];
	}
}
