package zen.deps;

public class ZIntArray extends ZObject {
	@Field private int    Size;
	@Field private long[] Values;

	public ZIntArray(int TypeId, long[] Values) {
		super(TypeId);
		if(Values != null) {
			this.Values = Values;
			this.Size = Values.length;
		}
		else {
			this.Values = new long[1];
			this.Size = 0;
		}
	}

	@Override public String toString() {
		@Var String s = "[";
		@Var int i = 0;
		while(i < this.Size) {
			if(i > 0) {
				s += ", ";
			}
			s += String.valueOf(this.Values[i]);
			i = i + 1;
		}
		return s + "]";
	}

	public final long Size() {
		return this.Size;
	}

	public final static long GetIndex(ZIntArray a, long Index) {
		if(Index < a.Size) {
			return a.Values[(int)Index];
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
		return 0;
	}

	public final static void SetIndex(ZIntArray a, long Index, long Value) {
		if(Index < a.Size) {
			a.Values[(int)Index] = Value;
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
	}

	public final void Add(long Value) {
		if(this.Size == this.Values.length) {
			long[] newValues = new long[this.Values.length*2];
			System.arraycopy(this.Values, 0, newValues, 0, this.Size);
			this.Values = newValues;
		}
		this.Values[this.Size] = Value;
		this.Size = this.Size + 1;
	}



}
