package zen.parser;

import zen.deps.Field;
import zen.deps.Init;
import zen.deps.ZenTokenFunction;

final class ZTokenFunc {
	@Field @Init public ZenTokenFunction      Func;
	@Field @Init public ZTokenFunc	ParentFunc;

	ZTokenFunc(ZenTokenFunction Func, ZTokenFunc Parent) {
		this.Func = Func;
		this.ParentFunc = Parent;
	}

	@Override public String toString() {
		return this.Func.toString();
	}

}