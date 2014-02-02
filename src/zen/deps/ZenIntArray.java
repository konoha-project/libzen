package zen.deps;

public class ZenIntArray {
	@Field private int    Size;
	@Field private long[] Values;

	public ZenIntArray(long[] Values) {
		if(Values != null) {
			this.Values = Values;
			this.Size = Values.length;
		}
		else {
			this.Values = new long[1];
			this.Size = 0;
		}
	}

	public final static long Size(ZenIntArray a) {
		return a.Size;
	}

	public final static long GetAt(ZenIntArray a, int Index) {
		if(Index < a.Size) {
			return a.Values[Index];
		}
		throw new RuntimeException("out of array index");
	}

	public final static void SetAt(ZenIntArray a, int Index, long Value) {
		if(Index < a.Size) {
			a.Values[Index] = Value;
		}
		throw new RuntimeException("out of array index");
	}

	public final static void Add(ZenIntArray a, long Value) {
		if(a.Size == a.Values.length) {
			long[] newValues = new long[a.Values.length];
			System.arraycopy(a.Values, 0, newValues, 0, a.Size);
			a.Values = newValues;
		}
		a.Values[a.Size] = Value;
		a.Size = a.Size + 1;
	}



}
