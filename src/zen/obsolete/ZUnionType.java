package zen.obsolete;

import zen.type.ZType;
import zen.util.Field;
import zen.util.ZArray;

public class ZUnionType extends ZType {

	@Field public final ZArray<ZType> UnionList = null;

	public ZUnionType() {
		super(0, "union", ZType.VarType);
		this.TypeId = this.RefType.TypeId;
	}

}
