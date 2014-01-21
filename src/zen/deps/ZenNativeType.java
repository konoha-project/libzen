package zen.deps;

import zen.lang.ZenType;
import zen.lang.ZTypeFlag;

public class ZenNativeType extends ZenType {
	@Field public Class<?>          JClass;

	ZenNativeType(Class<?> JType) {
		super(ZTypeFlag.UniqueType, JType.getSimpleName(), null);
		this.JClass = JType;
	}

	@Override public ZenType GetSuperType() {
		return LibNative.GetNativeType(this.JClass.getSuperclass());
	}

}
