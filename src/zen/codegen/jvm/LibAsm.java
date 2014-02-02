package zen.codegen.jvm;

import org.objectweb.asm.Type;

import zen.deps.ZenFloatArray;
import zen.deps.ZenIntArray;
import zen.deps.ZenObjectArray;
import zen.deps.ZenStringArray;
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
		if(zParamType.IsFloatType()) {
			return ZenFloatArray.class;
		}
		if(zParamType.IsStringType()) {
			return ZenStringArray.class;
		}
		return ZenObjectArray.class;
	}

	static Class<?> AsElementClass(ZType zType) {
		ZType zParamType = zType.GetParamType(0);
		if(zParamType.IsIntType()) {
			return long.class;
		}
		if(zParamType.IsFloatType()) {
			return double.class;
		}
		if(zParamType.IsStringType()) {
			return String.class;
		}
		return Object.class;
	}

	static String NewArrayDescriptor(ZType ArrayType) {
		ZType zParamType = ArrayType.GetParamType(0);
		if(zParamType.IsIntType()) {
			return Type.getMethodDescriptor(AsmType(void.class), new Type[] {AsmType(int.class), AsmType(long[].class)});
		}
		if(zParamType.IsFloatType()) {
			return Type.getMethodDescriptor(AsmType(void.class), new Type[] {AsmType(int.class), AsmType(double[].class)});
		}
		if(zParamType.IsStringType()) {
			return Type.getMethodDescriptor(AsmType(void.class), new Type[] {AsmType(int.class), AsmType(String[].class)});
		}

		return Type.getMethodDescriptor(AsmType(void.class), new Type[] {AsmType(int.class), AsmType(Object[].class)});
	}

}
