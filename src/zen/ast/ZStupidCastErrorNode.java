package zen.ast;

import zen.deps.Field;

public class ZStupidCastErrorNode extends ZErrorNode {
	@Field public ZNode ErrorNode;
	public ZStupidCastErrorNode(ZNode Node, String ErrorMessage) {
		super(Node, ErrorMessage);
		this.ErrorNode = Node;
	}

}
