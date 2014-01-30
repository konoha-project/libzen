package zen.type;

import java.util.ArrayList;

import zen.deps.Field;

public class ZUnionType extends ZType {

	@Field public final ArrayList<ZType> UnionList = null;

	public ZUnionType() {
		super(0, "union", ZType.VarType);
		this.TypeId = this.RefType.TypeId;
	}

}
