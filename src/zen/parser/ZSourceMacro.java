package zen.parser;

import zen.deps.Field;
import zen.type.ZFuncType;

public class ZSourceMacro extends ZMacroFunc {
	@Field public String Macro;

	public ZSourceMacro(String FuncName, ZFuncType FuncType, String Macro) {
		super(FuncName, FuncType);
		this.Macro = Macro;
	}

}
