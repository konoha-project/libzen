package zen.util;

import zen.codegen.jvm.JavaTypeTable;
import zen.type.ZType;

public class ZNativeType extends ZType {
	@Field public Class<?>          JClass;

	public ZNativeType(Class<?> JType) {
		super(ZType.UniqueTypeFlag, JType.getSimpleName(), null);
		this.JClass = JType;
	}

	@Override public ZType GetSuperType() {
		return JavaTypeTable.GetZenType(this.JClass.getSuperclass());
	}

}
