package zen.util;


public class ZIntArray extends ZObject {
	@Field private int    Size;
	@Field public long[] ArrayValues;

	public ZIntArray(int TypeId, long[] Values) {
		super(TypeId);
		if(Values == null || Values.length == 0) {
			this.ArrayValues = new long[1];
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
			sb.append(this.ArrayValues[i]);
		}
		sb.append("]");
	}

	public final long Size() {
		return this.Size;
	}

	public final void Clear(long Index) {
		this.Size = (int) Index;
	}

	public final static long GetIndex(ZIntArray a, long Index) {
		if(Index < a.Size) {
			return a.ArrayValues[(int)Index];
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
		return 0;
	}

	public final static void SetIndex(ZIntArray a, long Index, long Value) {
		if(Index < a.Size) {
			a.ArrayValues[(int)Index] = Value;
			return;
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
	}

	public final void Add(long Value) {
		if(this.Size == this.ArrayValues.length) {
			long[] newValues = new long[this.ArrayValues.length * 2];
			System.arraycopy(this.ArrayValues, 0, newValues, 0, this.Size);
			this.ArrayValues = newValues;
		}
		this.ArrayValues[this.Size] = Value;
		this.Size = this.Size + 1;
	}

	public final void Insert(long Index, long Value) {
		int index = (int) Index;
		if(this.Size == this.ArrayValues.length) {
			long[] NewValues = new long[this.ArrayValues.length * 2];
			System.arraycopy(this.ArrayValues, 0, NewValues, 0, this.Size);
			this.ArrayValues = NewValues;
		}
		System.arraycopy(this.ArrayValues, index, this.ArrayValues, index + 1, this.Size - index);
		this.ArrayValues[index] = Value;
		this.Size = this.Size + 1;
	}

}
