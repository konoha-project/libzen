package zen.deps;

import java.lang.reflect.Array;

public class ZArray<T> extends ZObject {
	@Field private int    Size;
	@Field public T[] ArrayValues;

	public ZArray(T[] Values) {
		super(0);
		this.ArrayValues = Values;
		this.Size = 0;
	}

	@Override protected void Stringfy(StringBuilder sb) {
		sb.append("[");
		for(int i = 0; i < this.Size; i++) {
			if(i > 0) {
				sb.append(", ");
			}
			this.AppendStringBuffer(sb, this.ArrayValues[i]);
		}
		sb.append("]");
	}

	public final long size() {
		return this.Size;
	}

	public final static<T> T GetIndex(ZArray<T> a, long Index) {
		if(Index < a.Size) {
			return a.ArrayValues[(int)Index];
		}
		ZArray.ThrowOutOfArrayIndex(a.Size, Index);
		return null;
	}

	public final static<T> void SetIndex(ZArray<T> a, long Index, T Value) {
		if(Index < a.Size) {
			a.ArrayValues[(int)Index] = Value;
		}
		ZArray.ThrowOutOfArrayIndex(a.Size, Index);
	}

	public final void add(T Value) {
		if(this.Size == this.ArrayValues.length) {
			@SuppressWarnings("unchecked")
			T[] newValues = (T[])Array.newInstance(this.ArrayValues.getClass().getComponentType(), this.ArrayValues.length * 2);
			System.arraycopy(this.ArrayValues, 0, newValues, 0, this.Size);
			this.ArrayValues = newValues;
		}
		this.ArrayValues[this.Size] = Value;
		this.Size = this.Size + 1;
	}

	public static void ThrowOutOfArrayIndex(int Size, long Index) {
		throw new RuntimeException("out of array index " + Index + " < " + Size);
	}

}
