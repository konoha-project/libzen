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

	public final long size() {
		return this.Size;
	}

	public final static Object GetIndex(ZenObjectArray a, int Index) {
		if(Index < a.Size) {
			return a.Values[Index];
		}
		throw new RuntimeException("out of array index");
	}

	public final static void SetIndex(ZenObjectArray a, int Index, Object Value) {
		if(Index < a.Size) {
			a.Values[Index] = Value;
		}
		throw new RuntimeException("out of array index");
	}

	public final void add(Object Value) {
		if(this.Size == this.Values.length) {
			Object[] newValues = new Object[this.Values.length];
			System.arraycopy(this.Values, 0, newValues, 0, this.Size);
			this.Values = newValues;
		}
		this.Values[this.Size] = Value;
		this.Size = this.Size + 1;
	}

}
