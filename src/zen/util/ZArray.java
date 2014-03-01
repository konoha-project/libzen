package zen.util;

import java.lang.reflect.Array;

public class ZArray<T> {
	@Field private int    Size;
	@Field public T[] ArrayValues;

	public ZArray(T[] Values) {
		//super(0);
		this.ArrayValues = Values;
		this.Size = 0;
	}

	//	@Override protected void Stringfy(StringBuilder sb) {
	//		sb.append("[");
	//		for(int i = 0; i < this.Size; i++) {
	//			if(i > 0) {
	//				sb.append(", ");
	//			}
	//			this.AppendStringBuffer(sb, this.ArrayValues[i]);
	//		}
	//		sb.append("]");
	//	}

	public final int size() {
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

	private T[] NewArray(int CopySize, int NewSize) {
		@SuppressWarnings("unchecked")
		T[] newValues = (T[])Array.newInstance(this.ArrayValues.getClass().getComponentType(), NewSize);
		System.arraycopy(this.ArrayValues, 0, newValues, 0, CopySize);
		return newValues;
	}

	public final void add(T Value) {
		if(this.Size == this.ArrayValues.length) {
			this.ArrayValues = this.NewArray(this.Size, this.ArrayValues.length * 2);
		}
		this.ArrayValues[this.Size] = Value;
		this.Size = this.Size + 1;
	}

	public final void add(int Index, T Value) {
		if(this.Size == this.ArrayValues.length) {
			this.ArrayValues = this.NewArray(this.Size, this.ArrayValues.length * 2);
		}
		System.arraycopy(this.ArrayValues, Index, this.ArrayValues, Index+1, this.Size - Index);
		this.ArrayValues[Index] = Value;
		this.Size = this.Size + 1;
	}

	public void clear(int Index) {
		this.Size = Index;
	}

	public T[] CompactArray() {
		if(this.Size == this.ArrayValues.length) {
			return this.ArrayValues;
		}
		else {
			@SuppressWarnings("unchecked")
			T[] newValues = (T[])Array.newInstance(this.ArrayValues.getClass().getComponentType(), this.Size);
			System.arraycopy(this.ArrayValues, 0, newValues, 0, this.Size);
			return newValues;
		}
	}

	public static void ThrowOutOfArrayIndex(int Size, long Index) {
		throw new RuntimeException("out of array index " + Index + " < " + Size);
	}



}
