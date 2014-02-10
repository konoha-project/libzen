package zen.ast;

import zen.deps.Field;
import zen.parser.ZVisitor;
import zen.type.ZType;

public class ZLetNode extends ZNode {
	public final static int InitValue = 0;

	@Field public String Symbol = null;
	@Field public ZType  SymbolType = ZType.VarType;
	@Field public String GlobalName = null;

	public ZLetNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}
	@Override public void SetNameInfo(String Name) {
		this.Symbol = Name;
	}
	@Override public void SetTypeInfo(ZType Type) {
		this.SymbolType = Type;
	}
	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitLetNode(this);
	}

}
