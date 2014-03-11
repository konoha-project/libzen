package zen.ast;

import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.parser.ZVisitor;

public abstract class ZTopLevelNode extends ZNode {

	public ZTopLevelNode(ZNode ParentNode, ZToken SourceToken, int Size) {
		super(ParentNode, SourceToken, Size);
	}

	@Override public final void Accept(ZVisitor Visitor) {
		Visitor.VisitTopLevelNode(this);
	}

	public abstract void Perform(ZNameSpace NameSpace);

}
