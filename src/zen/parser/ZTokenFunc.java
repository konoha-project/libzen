package zen.parser;

import zen.deps.Field;
import zen.deps.Init;
import zen.lang.ZFunc;

final class ZTokenFunc {
	@Field @Init public ZFunc      Func;
	@Field @Init public ZTokenFunc	ParentFunc;

	ZTokenFunc(ZFunc Func, ZTokenFunc Parent) {
		this.Func = Func;
		this.ParentFunc = Parent;
	}

	@Override public String toString() {
		return this.Func.toString();
	}

}