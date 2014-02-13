package zen.type;

import zen.deps.Field;
import zen.deps.ZArray;

public class ZUnionType extends ZType {

	@Field public final ZArray<ZType> UnionList = null;

	public ZUnionType() {
		super(0, "union", ZType.VarType);
		this.TypeId = this.RefType.TypeId;
	}

}
