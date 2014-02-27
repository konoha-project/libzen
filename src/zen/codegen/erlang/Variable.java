//ifdef JAVA

package zen.codegen.erlang;

import zen.deps.Field;

//endif VAJA

public class Variable {
	@Field public int Read;
	@Field public int Next;
	@Field public int UsedFlag;
	public Variable/*constructor*/() {
		this.Read = -1;
		this.Next = 0;
		this.UsedFlag = 0;
	}

	void UsedByCurrentScope() {
		this.UsedFlag = this.UsedFlag | 1;
	}
	boolean IsUsedByCurrentScope() {
		return (this.UsedFlag & 1) != 0;
	}
	void UsedByChildScope() {
		this.UsedFlag = this.UsedFlag | (1 << 1);
	}
	boolean IsUsedByChildScope() {
		return (this.UsedFlag & (1 << 1)) != 0;
	}
	boolean IsUsed() {
		return this.IsUsedByCurrentScope() || this.IsUsedByChildScope();
	}
}
