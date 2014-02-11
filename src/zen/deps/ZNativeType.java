package zen.deps;

import zen.codegen.jvm.JavaTypeTable;
import zen.type.ZType;
import zen.type.ZTypeFlag;

public class ZNativeType extends ZType {
	@Field public Class<?>          JClass;

	public ZNativeType(Class<?> JType) {
		super(ZTypeFlag._UniqueType, JType.getSimpleName(), null);
		this.JClass = JType;
	}

	@Override public ZType GetSuperType() {
		return JavaTypeTable.GetZenType(this.JClass.getSuperclass());
	}

}
