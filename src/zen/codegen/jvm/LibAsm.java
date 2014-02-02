package zen.codegen.jvm;

import org.objectweb.asm.Type;

import zen.deps.ZenIntArray;
import zen.deps.ZenObjectArray;
import zen.type.ZType;

public class LibAsm {


	static Type AsmType(Class<?> jClass) {
		return Type.getType(jClass);
	}

	static Class<?> AsArrayClass(ZType zType) {
		ZType zParamType = zType.GetParamType(0);
		if(zParamType.IsIntType()) {
			return ZenIntArray.class;
		}
		return ZenObjectArray.class;
	}

	static Class<?> AsElementClass(ZType zType) {
		ZType zParamType = zType.GetParamType(0);
		if(zParamType.IsIntType()) {
			return long.class;
		}
		return Object.class;
	}

	static String NewArrayDescriptor(ZType ArrayType) {
		ZType zParamType = ArrayType.GetParamType(0);
		if(zParamType.IsIntType()) {
			return Type.getMethodDescriptor(AsmType(void.class), new Type[] {AsmType(int.class), AsmType(long[].class)});
		}
		return Type.getMethodDescriptor(AsmType(void.class), new Type[] {AsmType(int.class), AsmType(Object[].class)});
	}

}
