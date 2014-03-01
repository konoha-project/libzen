package zen.ast;

import zen.util.Field;

public class ZStupidCastErrorNode extends ZErrorNode {
	@Field public ZNode ErrorNode;
	public ZStupidCastErrorNode(ZNode Node, String ErrorMessage) {
		super(Node, ErrorMessage);
		this.ErrorNode = Node;
	}

}
