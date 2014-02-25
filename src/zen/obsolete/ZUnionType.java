package zen.obsolete;

import zen.deps.Field;
import zen.deps.ZArray;
import zen.type.ZType;

public class ZUnionType extends ZType {

	@Field public final ZArray<ZType> UnionList = null;

	public ZUnionType() {
		super(0, "union", ZType.VarType);
		this.TypeId = this.RefType.TypeId;
	}

}
