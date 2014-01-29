package zen.type;

import java.util.ArrayList;

import zen.deps.Var;

public class ZTypePools {

	private final static ArrayList<ZType>  TypeList = new ArrayList<ZType>();
	private final static ZType[] GreekTypes = ZGreekType.NewGreekTypes(null);

	public final static int NewTypeId(ZType T) {
		@Var int TypeId = TypeList.size();
		TypeList.add(T);
		return TypeId;
	}

	public final static ZType TypeOf(int TypeId) {
		return TypeList.get(TypeId);
	}

	public final static ZGreekType GetGreekType(int GreekId) {
		if(GreekTypes[GreekId] == null) {
			GreekTypes[GreekId] = new ZGreekType(GreekId);
		}
		return null;
	}
}
