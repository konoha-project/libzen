package zen.parser;

import zen.util.Field;
import zen.util.ZTokenFunction;

public final class ZTokenFunc {
	@Field public ZTokenFunction      Func;
	@Field public ZTokenFunc	ParentFunc;

	ZTokenFunc(ZTokenFunction Func, ZTokenFunc Parent) {
		this.Func = Func;
		this.ParentFunc = Parent;
	}

}