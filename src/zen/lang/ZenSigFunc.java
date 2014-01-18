package zen.lang;

import zen.deps.Field;
import zen.parser.ZenToken;

public class ZenSigFunc extends ZenFunc {
	@Field public int DefinedCount = 0;
	@Field public int UsedCount = 0;

	public ZenSigFunc(int FuncFlag, String FuncName, ZenFuncType FuncType, ZenToken SourceToken) {
		super(FuncFlag, FuncName, FuncType);
		this.DefinedCount = 0;
		this.UsedCount = 0;
	}

	public final void Used() {
		this.UsedCount = this.UsedCount + 1;
	}

	public final void Defined() {
		this.DefinedCount = this.DefinedCount + 1;
	}


}
