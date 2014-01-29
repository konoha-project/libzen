package zen.type;

import java.util.ArrayList;

import zen.deps.Field;
import zen.lang.ZSystem;

public class ZUnionType extends ZType {

	@Field public final ArrayList<ZType> UnionList = null;

	public ZUnionType() {
		super(0, "union", ZSystem.VarType);
		this.TypeId = this.RefType.TypeId;
	}

}
