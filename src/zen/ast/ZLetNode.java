package zen.ast;

import zen.deps.Field;
import zen.parser.ZVisitor;
import zen.type.ZType;

public class ZLetNode extends ZNode {

	@Field public String PrefixSymbol = null;
	@Field public String Symbol = null;
	@Field public ZType  SymbolType = ZType.VarType;
	@Field public ZNode  ValueNode = null;
	@Field public Object  Value = null;

	@Field public String GlobalName = null;

	public ZLetNode(ZNode ParentNode) {
		super(ParentNode, null);
	}

	@Override public void Append(ZNode Node) {
		if(this.Symbol == null && Node instanceof ZGetNameNode) {
			this.SourceToken = Node.SourceToken;
			if(this.PrefixSymbol == null) {
				this.PrefixSymbol = Node.SourceToken.ParsedText;
			}
			else {
				this.Symbol = Node.SourceToken.ParsedText;
			}
			return;
		}
		if(Node instanceof ZTypeNode) {
			this.SymbolType = Node.Type;
			return;
		}
		if(Node == null) {  // sync
			if(this.Symbol == null) {
				this.Symbol = this.PrefixSymbol;
				this.PrefixSymbol = null;
			}
			return;
		}
		this.ValueNode = this.SetChild(Node);
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitLetNode(this);
	}

}
