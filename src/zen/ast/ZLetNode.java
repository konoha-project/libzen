package zen.ast;

import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZType;
import zen.util.Field;

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

	public final ZNode InitValueNode() {
		if(this.AST[ZLetNode._InitValue] == null) {
			this.Set(ZLetNode._InitValue, new ZDefaultValueNode());
		}
		return this.AST[ZLetNode._InitValue];
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

	public final boolean IsConstValue() {
		return this.InitValueNode() instanceof ZConstNode;
	}

	public final ZGlobalNameNode ToGlobalNameNode() {
		return new ZGlobalNameNode(null, this.SymbolToken, this.GetAstType(ZLetNode._InitValue), this.GlobalName, false);
	}

}
