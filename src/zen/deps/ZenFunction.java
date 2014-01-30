package zen.deps;

import zen.type.ZType;
import zen.type.ZTypePool;

public abstract class ZenFunction implements ZenTypedObject {
	@Field final ZType  ZenType;
	@Field final String FUNCTION;
	public ZenFunction(int TypeId, String f) {
		this.ZenType  = ZTypePool.TypeOf(TypeId);
		this.FUNCTION = f;
	}
	@Override public final ZType GetZenType() {
		return this.ZenType;
	}
	@Override public String toString() {
		return this.FUNCTION;
	}
}
