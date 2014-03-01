package zen.ast;

import zen.parser.ZMacroFunc;
import zen.parser.ZSourceMacro;
import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZFuncType;
import zen.util.Field;
import zen.util.Var;

public class ZMacroNode extends ZListNode {
	@Field public final ZMacroFunc MacroFunc;

	public ZMacroNode(ZNode ParentNode, ZToken SourceToken, ZMacroFunc MacroFunc) {
		super(ParentNode, SourceToken, 0);
		this.MacroFunc = MacroFunc;
		assert(MacroFunc != null);
	}

	public final ZFuncType GetFuncType() {
		return this.MacroFunc.GetFuncType();
	}

	public final String GetMacroText() {
		@Var ZMacroFunc Func = this.MacroFunc;
		if(Func instanceof ZSourceMacro) {
			return ((ZSourceMacro)Func).Macro;
		}
		return "";
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitMacroNode(this);
	}

}
