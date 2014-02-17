package zen.ast;

import zen.deps.Field;
import zen.parser.ZVisitor;

public class ZSugarNode extends ZNode {
	public final static int _DeSugar = 0;
	@Field ZNode SugarNode;

	public ZSugarNode(ZNode SugarNode, ZNode DeSugarNode) {
		super(SugarNode.ParentNode, null, 1);
		this.SugarNode = SugarNode;
		SugarNode.ParentNode = this;
		this.Set(ZSugarNode._DeSugar, DeSugarNode);
		DeSugarNode.ParentNode = this;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitSugarNode(this);
	}

}
