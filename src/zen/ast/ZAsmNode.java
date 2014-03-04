package zen.ast;

import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZType;
import zen.util.Field;

public class ZAsmNode extends ZNode {
	public final static int _Macro = 0;

	@Field public ZType   MacroType = null;
	@Field public ZToken  TypeToken = null;

	public ZAsmNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	@Override public void SetTypeInfo(ZToken TypeToken, ZType Type) {
		this.MacroType = Type;
		this.TypeToken = TypeToken;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitAsmNode(this);
	}

	public final String GetMacroText() {
		ZNode Node = this.AST[ZAsmNode._Macro];
		if(Node instanceof ZStringNode) {
			return ((ZStringNode)Node).StringValue;
		}
		return "";
	}

}
