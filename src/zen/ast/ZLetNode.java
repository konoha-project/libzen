package zen.ast;

import zen.deps.Field;
import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZType;

public class ZLetNode extends ZNode {
	public final static int _InitValue = 0;

	@Field public String Symbol = null;
	@Field public ZToken SymbolToken;
	@Field public ZType  SymbolType = ZType.VarType;
	@Field public String GlobalName = null;
	@Field public boolean IsExport = false;

	public ZLetNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}
	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.Symbol = Name;
		this.SymbolToken = NameToken;
	}
	@Override public void SetTypeInfo(ZToken TypeToken, ZType Type) {
		this.SymbolType = Type;
	}
	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitLetNode(this);
	}

	public ZGlobalNameNode ToGlobalNameNode() {
		return new ZGlobalNameNode(null, this.SymbolToken, this.GetAstType(ZLetNode._InitValue), this.GlobalName, false);
	}

}
