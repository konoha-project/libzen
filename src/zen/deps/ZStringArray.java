package zen.deps;

public class ZStringArray extends ZObject {
	@Field private int    Size;
	@Field public String[] ArrayValues;

	public ZStringArray() {
		this(0, null);
	}

	public ZStringArray(int TypeId, String[] Values) {
		super(TypeId);
		if(Values != null) {
			this.ArrayValues = Values;
			this.Size = Values.length;
		}
		else {
			this.ArrayValues = new String[1];
			this.Size = 0;
		}
	}

	@Override protected void Stringfy(StringBuilder sb) {
		sb.append("[");
		for(int i = 0; i < this.Size; i++) {
			if(i > 0) {
				sb.append(", ");
			}
			sb.append(LibZen._QuoteString(this.ArrayValues[i]));
		}
		sb.append("]");
	}

	public final long Size() {
		return this.Size;
	}

	public final static String GetIndex(ZStringArray a, long Index) {
		if(Index < a.Size) {
			return a.ArrayValues[(int)Index];
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
		return null;
	}

	public final static void SetIndex(ZStringArray a, long Index, String Value) {
		if(Index < a.Size) {
			a.ArrayValues[(int)Index] = Value;
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
	}

	public final void Add(String Value) {
		if(this.Size == this.ArrayValues.length) {
			String[] newValues = new String[this.ArrayValues.length*2];
			System.arraycopy(this.ArrayValues, 0, newValues, 0, this.Size);
			this.ArrayValues = newValues;
		}
		this.ArrayValues[this.Size] = Value;
		this.Size = this.Size + 1;
	}



}
