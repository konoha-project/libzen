package zen.codegen.jvm;

import org.objectweb.asm.Type;

import zen.deps.NativeTypeTable;
import zen.deps.Var;
import zen.type.ZFuncType;
import zen.type.ZType;

public class LibAsm {

	static Type AsmType(ZType zType) {
		return Type.getType(NativeTypeTable.GetJavaClass(zType));
	}

	static Type AsmType(Class<?> jClass) {
		return Type.getType(jClass);
	}

	static String GetTypeDesc(ZType zType) {
		Class<?> JClass = NativeTypeTable.GetJavaClass(zType);
		return Type.getDescriptor(JClass);
	}

	static String GetMethodDescriptor(ZFuncType FuncType) {
		@Var Type ReturnType = AsmType(FuncType.GetReturnType());
		@Var Type[] ArgTypes = new Type[FuncType.GetFuncParamSize()];
		for(int i = 0; i < ArgTypes.length; i++) {
			ZType ParamType = FuncType.GetFuncParamType(i);
			ArgTypes[i] = AsmType(ParamType);
		}
		String Desc = Type.getMethodDescriptor(ReturnType, ArgTypes);
		//System.out.println(" ** Desc: " + Desc + ", FuncType: " + FuncType);
		return Desc;
	}

	static String NewArrayDescriptor(ZType ArrayType) {
		ZType zParamType = ArrayType.GetParamType(0);
		if(zParamType.IsIntType()) {

		}
		return Type.getMethodDescriptor(AsmType(void.class), new Type[] {AsmType(int.class), AsmType(Object[].class)});
	}

}
