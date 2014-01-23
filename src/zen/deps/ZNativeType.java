package zen.deps;

import zen.lang.ZType;
import zen.lang.ZTypeFlag;

public class ZNativeType extends ZType {
	@Field public Class<?>          JClass;

	public ZNativeType(Class<?> JType) {
		super(ZTypeFlag.UniqueType, JType.getSimpleName(), null);
		this.JClass = JType;
	}

	@Override public ZType GetSuperType() {
		return NativeTypeTable.GetZenType(this.JClass.getSuperclass());
	}

}
