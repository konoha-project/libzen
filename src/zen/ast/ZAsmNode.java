package zen.ast;

import zen.parser.ZVisitor;
import zen.type.ZType;
import zen.util.Var;

public class ZAsmNode extends ZNode {
	public final static int _Macro = 0;
	public static final int _TypeInfo = 1;

	public ZAsmNode(ZNode ParentNode) {
		super(ParentNode, null, 2);
	}

	public final ZType MacroType() {
		return this.AST[ZAsmMacroNode._TypeInfo].Type;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitAsmNode(this);
	}

	public final String GetMacroText() {
		@Var ZNode Node = this.AST[ZAsmNode._Macro];
		if(Node instanceof ZStringNode) {
			return ((ZStringNode)Node).StringValue;
		}
		return "";
	}

}
