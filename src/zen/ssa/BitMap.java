package zen.ssa;

public class BitMap {
	private final int[]	List;

	public BitMap(int w) {
		this.List = new int[w];
	}

	public void clear(int init) {
		for(int i = 0; i < this.List.length; i++) {
			this.List[i] = init;
		}
	}

	public static final int	BITS	= 32;

	public int get(int Index) {
		return this.List[Index];
	}

	public int GetAll(int Index) {
		return this.List[Index];
	}

	public void SetAll(int Index, int Value) {
		this.List[Index] = Value;
	}

	public void add(int Entry) {
		this.List[Entry / BitMap.BITS] |= (1 << (Entry % BitMap.BITS));

	}

	public void Remove(int Entry) {
		this.List[(Entry) / BitMap.BITS] &= ~(1 << ((Entry) % BitMap.BITS));
	}

	public static int highestbit(int i) {
		if(i == 0) {
			return -1;
		}

		int highest = 0;
		if((i & 0xffff0000) != 0) {
			highest += 16;
			i >>= 16;
		}
		if((i & 0xff00) != 0) {
			highest += 8;
			i >>= 8;
		}
		if((i & 0xf0) != 0) {
			highest += 4;
			i >>= 4;
		}
		if((i & 0xc) != 0) {
			highest += 2;
			i >>= 2;
		}
		if((i & 0x2) != 0) {
			highest += 1;
		}

		return highest;
	}
}