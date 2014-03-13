//ifdef JAVA

package zen.codegen.erlang;

import zen.util.Field;

//endif VAJA

public class Variable {
	@Field public int Read;
	@Field public int Next;
	@Field public int Flags;

	public Variable/*constructor*/() {
		this.Read = -1;
		this.Next = 0;
		this.Flags = 0;
	}

	void UsedByCurrentScope() {
		this.Flags = this.Flags | 1;
	}
	boolean IsUsedByCurrentScope() {
		return (this.Flags & 1) != 0;
	}
	void UsedByChildScope() {
		this.Flags = this.Flags | (1 << 1);
	}
	boolean IsUsedByChildScope() {
		return (this.Flags & (1 << 1)) != 0;
	}
	boolean IsUsed() {
		return this.IsUsedByCurrentScope() || this.IsUsedByChildScope();
	}
	void CreatedTemporary() {
		this.Flags = this.Flags | (1 << 2);
	}
	boolean IsCreatedTemporary() {
		return (this.Flags & (1 << 2)) != 0;
	}
}
