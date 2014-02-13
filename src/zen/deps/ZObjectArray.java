package zen.deps;

public final class ZObjectArray extends ZObject {
	@Field private int    Size;
	@Field private Object[] Values;

	public ZObjectArray(int TypeId, Object[] Values) {
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

	@Override protected void Stringfy(StringBuilder sb) {
		sb.append("[");
		for(int i = 0; i < this.Size; i++) {
			if(i > 0) {
				sb.append(", ");
			}
			this.AppendStringBuffer(sb, this.Values[i]);
		}
		sb.append("]");
	}

	public final long Size() {
		return this.Size;
	}

	public final static Object GetIndex(ZObjectArray a, long Index) {
		if(Index < a.Size) {
			return a.Values[(int)Index];
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
		return null;
	}

	public final static void SetIndex(ZObjectArray a, long Index, Object Value) {
		if(Index < a.Size) {
			a.Values[(int)Index] = Value;
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
	}

	public final void Add(Object Value) {
		if(this.Size == this.Values.length) {
			Object[] newValues = new Object[this.Values.length*2];
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
