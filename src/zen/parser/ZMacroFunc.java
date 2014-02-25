package zen.parser;

import zen.type.ZFunc;
import zen.type.ZFuncType;

public abstract class ZMacroFunc extends ZFunc {

	public ZMacroFunc(String FuncName, ZFuncType FuncType) {
		super(0, FuncName, FuncType);
	}
}
