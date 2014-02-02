package zen.deps;

public final class ZenObjectArray extends ZenObject {
	@Field private int    Size;
	@Field private Object[] Values;

	public ZenObjectArray(int TypeId, Object[] Values) {
		super(TypeId);
		if(Values != null) {
			this.Values = Values;
			this.Size = Values.length;
		}
		else {
			this.Values = new Object[1];
			this.Size = 0;
		}
	}

	@Override public String toString() {
		@Var String s = "[";
		@Var int i = 0;
		while(i < this.Size) {
			@Var Object Value = this.Values[i];
			if(i > 0) {
				s += ", ";
			}
			s += LibZen.Stringify(Value);
			i = i + 1;
		}
		return s + "]";
	}

	public final long Size() {
		return this.Size;
	}

	public final static Object GetIndex(ZenObjectArray a, long Index) {
		if(Index < a.Size) {
			return a.Values[(int)Index];
		}
		ZenObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
		return null;
	}

	public final static void SetIndex(ZenObjectArray a, long Index, Object Value) {
		if(Index < a.Size) {
			a.Values[(int)Index] = Value;
		}
		ZenObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
	}

	public final void Add(Object Value) {
		if(this.Size == this.Values.length) {
			Object[] newValues = new Object[this.Values.length];
			System.arraycopy(this.Values, 0, newValues, 0, this.Size);
			this.Values = newValues;
		}
		this.Values[this.Size] = Value;
		this.Size = this.Size + 1;
	}


	public static void ThrowOutOfArrayIndex(int Size, long Index) {
		throw new RuntimeException("out of array index " + Index + " < " + Size);
	}

}
