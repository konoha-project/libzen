package zen.util;

import zen.type.ZType;
import zen.type.ZTypePool;

public abstract class ZFunction implements ZTypedObject {
	@Field final ZType  ZenType;
	@Field final String FUNCTION;
	public ZFunction(int TypeId, String f) {
		this.ZenType  = ZTypePool.TypeOf(TypeId);
		if(f == null) {
			f= this.getClass().getSimpleName();
		}
		this.FUNCTION = f;
	}
	@Override public final ZType GetZenType() {
		return this.ZenType;
	}
	@Override public String toString() {
		return this.FUNCTION;
	}
}
