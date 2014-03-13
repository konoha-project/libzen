package zen.ast;

import zen.parser.ZToken;
import zen.util.Field;

public class ZStupidCastErrorNode extends ZErrorNode {
	@Field public ZNode ErrorNode;
	public ZStupidCastErrorNode(ZNode Node, ZToken SourceToken, String ErrorMessage) {
		super(Node.ParentNode, SourceToken, ErrorMessage);
		this.ErrorNode = Node;
	}

}
