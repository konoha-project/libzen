package zen.util;

public class ZStringArray extends ZObject {
	@Field private int    Size;
	@Field public String[] ArrayValues;

	public ZStringArray() {
		this(0, null);
	}

	public ZStringArray(int TypeId, String[] Values) {
		super(TypeId);
		if(Values == null || Values.length == 0) {
			this.ArrayValues = new String[1];
			this.Size = 0;
		}
		else {
			this.ArrayValues = Values;
			this.Size = Values.length;
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

	public final void Clear(long Index) {
		this.Size = (int) Index;
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
			return;
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

	public final void Insert(long Index, String Value) {
		int index = (int) Index;
		if(this.Size == this.ArrayValues.length) {
			String[] NewValues = new String[this.Size * 2];
			System.arraycopy(this.ArrayValues, 0, NewValues, 0, this.Size);
			this.ArrayValues = NewValues;
		}
		System.arraycopy(this.ArrayValues, index, this.ArrayValues, index + 1, this.Size - index);
		this.ArrayValues[index] = Value;
		this.Size = this.Size + 1;
	}

}
