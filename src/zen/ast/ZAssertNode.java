package zen.ast;

import zen.parser.ZGenerator;
import zen.parser.ZMacroFunc;
import zen.type.ZType;


public class ZAssertNode extends ZNode {
	public final static int _Expr = 0;

	public ZAssertNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	@Override public ZSugarNode DeSugar(ZGenerator Generator) {
		ZMacroFunc Func = Generator.GetMacroFunc("assert", ZType.BooleanType, 2);
		ZMacroNode MacroNode = new ZMacroNode(this.ParentNode, this.SourceToken, Func);
		MacroNode.Append(this.AST[ZAssertNode._Expr]);
		MacroNode.Append(new ZStringNode(MacroNode, null, this.GetSourceLocation()));
		return new ZSugarNode(this, MacroNode);
	}

}
