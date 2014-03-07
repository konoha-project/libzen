package zen.ast;

import zen.ast.sugar.ZTopLevelNode;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.util.Field;
import zen.util.Var;

public class ZAsmMacroNode extends ZTopLevelNode {
	public final static int _Macro = 0;

	@Field public String  Symbol = null;
	@Field public ZToken  SymbolToken = null;

	@Field public ZType   MacroType = null;
	@Field public ZToken  TypeToken = null;

	public ZAsmMacroNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	@Override public void SetTypeInfo(ZToken TypeToken, ZType Type) {
		this.MacroType = Type;
		this.TypeToken = TypeToken;
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.Symbol      = Name;
		this.SymbolToken = NameToken;
	}

	public final String GetMacroText() {
		ZNode Node = this.AST[ZAsmNode._Macro];
		if(Node instanceof ZStringNode) {
			return ((ZStringNode)Node).StringValue;
		}
		return "";
	}

	@Override public final void Perform(ZNameSpace NameSpace) {
		@Var String MacroText = this.GetMacroText();
		@Var ZType MacroType = this.MacroType;
		if(MacroType instanceof ZFuncType) {
			NameSpace.Generator.SetAsmMacro(NameSpace, this.Symbol, (ZFuncType)MacroType, MacroText);
		}
		else {
			NameSpace.Generator.SetAsmSymbol(NameSpace, this);
		}
	}


}
