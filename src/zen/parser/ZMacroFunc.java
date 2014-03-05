package zen.parser;

import zen.type.ZFunc;
import zen.type.ZFuncType;
import zen.util.Field;

public class ZMacroFunc extends ZFunc {
	@Field String RequiredLibrary = null;
	@Field public String MacroText;
	public ZMacroFunc(String FuncName, ZFuncType FuncType, String MacroText) {
		super(0, FuncName, FuncType);
		this.MacroText = MacroText;
	}
}
