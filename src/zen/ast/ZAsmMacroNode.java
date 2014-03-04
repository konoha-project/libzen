package zen.ast;

import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.util.Field;

public class ZAsmMacroNode extends ZAsmNode {
	@Field public String  Symbol = null;
	@Field public ZToken  SymbolToken = null;

	public ZAsmMacroNode(ZNode ParentNode) {
		super(ParentNode);
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.Symbol      = Name;
		this.SymbolToken = NameToken;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitExtendedNode(this);
	}

}
