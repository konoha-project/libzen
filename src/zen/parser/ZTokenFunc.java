package zen.parser;

import zen.deps.Constructor;
import zen.deps.Field;
import zen.deps.Init;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.deps.Zen;
import zen.lang.ZenFunc;

@Zen final class ZTokenFunc {
	@Field @Init public ZenFunc      Func;
	@Field @Init public ZTokenFunc	ParentFunc;

	@Constructor ZTokenFunc(ZenFunc Func, ZTokenFunc Parent) {
		this.Func = Func;
		this.ParentFunc = Parent;
	}

	@Override public String toString() {
		return this.Func.toString();
	}

	final static int ApplyTokenFunc(ZTokenFunc TokenFunc, ZenTokenContext TokenContext, String ScriptSource, int Pos) {
		while(TokenFunc != null) {
			@Var int NextIdx = (int)LibNative.ApplyTokenFunc(TokenFunc.Func, TokenContext, ScriptSource, Pos);
			if(NextIdx > Pos) {
				return NextIdx;
			}
			TokenFunc = TokenFunc.ParentFunc;
		}
		return ZenTokenContext.MismatchedPosition;
	}
}