package zen.parser;

import zen.type.ZFuncType;
import zen.util.Field;

public class ZSourceMacro extends ZMacroFunc {
	@Field public String Macro;

	public ZSourceMacro(String FuncName, ZFuncType FuncType, String Macro) {
		super(FuncName, FuncType);
		this.Macro = Macro;
	}

}
