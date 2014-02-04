package zen.parser;

import zen.deps.Field;
import zen.deps.Init;
import zen.deps.LibNative;
import zen.deps.Var;
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

	final static int ApplyTokenFunc(ZTokenFunc TokenFunc, ZTokenContext TokenContext, String ScriptSource, int Pos) {
		while(TokenFunc != null) {
			@Var int NextIdx = (int)LibNative.ApplyTokenFunc(TokenFunc.Func, TokenContext, ScriptSource, Pos);
			if(NextIdx > Pos) {
				return NextIdx;
			}
			TokenFunc = TokenFunc.ParentFunc;
		}
		return ZTokenContext.MismatchedPosition;
	}
}