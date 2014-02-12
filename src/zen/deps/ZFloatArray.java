package zen.deps;


public class ZFloatArray extends ZObject {
	@Field private int    Size;
	@Field private double[] Values;

	public ZFloatArray(int TypeId, double[] Values) {
		super(TypeId);
		if(Values != null) {
			this.Values = Values;
			this.Size = Values.length;
		}
		else {
			this.Values = new double[1];
			this.Size = 0;
		}
	}

	@Override protected void Stringfy(StringBuilder sb) {
		sb.append("[");
		for(int i = 0; i < this.Size; i++) {
			if(i > 0) {
				sb.append(", ");
			}
			sb.append(this.Values[i]);
		}
		sb.append("]");
	}

	public final long Size() {
		return this.Size;
	}

	public final static double GetIndex(ZFloatArray a, long Index) {
		if(Index < a.Size) {
			return a.Values[(int)Index];
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
		return 0;
	}

	public final static void SetIndex(ZFloatArray a, long Index, double Value) {
		if(Index < a.Size) {
			a.Values[(int)Index] = Value;
		}
		ZObjectArray.ThrowOutOfArrayIndex(a.Size, Index);
	}

	public final void Add(double Value) {
		if(this.Size == this.Values.length) {
			double[] newValues = new double[this.Values.length*2];
			System.arraycopy(this.Values, 0, newValues, 0, this.Size);
			this.Values = newValues;
		}
		this.Values[this.Size] = Value;
		this.Size = this.Size + 1;
	}



}
