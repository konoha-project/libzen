package zen.ast;

import zen.parser.ZVisitor;


public class ZDefaultValueNode extends ZNode {

	public ZDefaultValueNode() {
		super(null, null, 0);
	}

	@Override public final void Accept(ZVisitor Visitor) {
		Visitor.VisitDefaultValueNode(this);
	}

}
