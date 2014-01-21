package zen.deps;

import zen.lang.ZType;
import zen.lang.ZTypeFlag;

public class ZenNativeType extends ZType {
	@Field public Class<?>          JClass;

	ZenNativeType(Class<?> JType) {
		super(ZTypeFlag.UniqueType, JType.getSimpleName(), null);
		this.JClass = JType;
	}

	@Override public ZType GetSuperType() {
		return LibNative.GetNativeType(this.JClass.getSuperclass());
	}

}
