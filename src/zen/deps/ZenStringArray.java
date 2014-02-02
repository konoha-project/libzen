package zen.deps;

public class ZenStringArray extends ZenObject {
	@Field private int    Size;
	@Field private String[] Values;

	public ZenStringArray(int TypeId, String[] Values) {
		super(TypeId);
		if(Values != null) {
			this.Values = Values;
			this.Size = Values.length;
		}
		else {
			this.Values = new String[1];
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
			s += LibZen.QuoteString(this.Values[i]);
			i = i + 1;
		}
		return s + "]";
	}

	public final long Size() {
		return this.Size;
	}

	public final static String GetIndex(ZenStringArray a, long Index) {
		if(Index < a.Size) {
			return a.Values[(int)Index];
		}
		ZenObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
		return null;
	}

	public final static void SetIndex(ZenStringArray a, long Index, String Value) {
		if(Index < a.Size) {
			a.Values[(int)Index] = Value;
		}
		ZenObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
	}

	public final void Add(String Value) {
		if(this.Size == this.Values.length) {
			String[] newValues = new String[this.Values.length*2];
			System.arraycopy(this.Values, 0, newValues, 0, this.Size);
			this.Values = newValues;
		}
		this.Values[this.Size] = Value;
		this.Size = this.Size + 1;
	}



}
