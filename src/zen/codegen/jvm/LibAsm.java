package zen.codegen.jvm;

import org.objectweb.asm.Type;

import zen.deps.NativeTypeTable;
import zen.deps.Var;
import zen.type.ZFuncType;
import zen.type.ZType;

public class LibAsm {

	static Type GetAsmType(ZType zType) {
		return Type.getType(NativeTypeTable.GetJavaClass(zType));
	}

	static String GetMethodDescriptor(ZFuncType FuncType) {
		@Var Type ReturnType = GetAsmType(FuncType.GetReturnType());
		@Var Type[] ArgTypes = new Type[FuncType.GetFuncParamSize()];
		for(int i = 0; i < ArgTypes.length; i++) {
			ZType ParamType = FuncType.GetFuncParamType(i);
			ArgTypes[i] = GetAsmType(ParamType);
		}
		String Desc = Type.getMethodDescriptor(ReturnType, ArgTypes);
		//System.out.println(" ** Desc: " + Desc + ", FuncType: " + FuncType);
		return Desc;
	}

	static String GetTypeDesc(ZType zType) {
		Class<?> JClass = NativeTypeTable.GetJavaClass(zType);
		return Type.getDescriptor(JClass);
	}

}
