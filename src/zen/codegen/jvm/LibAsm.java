package zen.codegen.jvm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

import zen.type.ZType;
import zen.util.ZBooleanArray;
import zen.util.ZFloatArray;
import zen.util.ZIntArray;
import zen.util.ZObjectArray;
import zen.util.ZStringArray;

public class LibAsm {


	static Type AsmType(Class<?> jClass) {
		return Type.getType(jClass);
	}

	static Class<?> AsArrayClass(ZType zType) {
		ZType zParamType = zType.GetParamType(0);
		if(zParamType.IsBooleanType()) {
			return ZBooleanArray.class;
		}
		if(zParamType.IsIntType()) {
			return ZIntArray.class;
		}
		if(zParamType.IsFloatType()) {
			return ZFloatArray.class;
		}
		if(zParamType.IsStringType()) {
			return ZStringArray.class;
		}
		return ZObjectArray.class;
	}

	static Class<?> AsElementClass(ZType zType) {
		ZType zParamType = zType.GetParamType(0);
		if(zParamType.IsBooleanType()) {
			return boolean.class;
		}
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
		if(zParamType.IsBooleanType()) {
			return Type.getMethodDescriptor(AsmType(void.class), new Type[] {AsmType(int.class), AsmType(boolean[].class)});
		}
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

	static void PushInt(MethodNode Asm, int n) {
		switch(n) {
		case -1: Asm.visitInsn(Opcodes.ICONST_M1); return;
		case 0: Asm.visitInsn(Opcodes.ICONST_0); return;
		case 1: Asm.visitInsn(Opcodes.ICONST_1); return;
		case 2: Asm.visitInsn(Opcodes.ICONST_2); return;
		case 3: Asm.visitInsn(Opcodes.ICONST_3); return;
		case 4: Asm.visitInsn(Opcodes.ICONST_4); return;
		case 5: Asm.visitInsn(Opcodes.ICONST_5); return;
		default:
			if(n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
				Asm.visitIntInsn(Opcodes.BIPUSH, n);
			}
			else if(n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
				Asm.visitIntInsn(Opcodes.SIPUSH, n);
			}
			else {
				Asm.visitLdcInsn(n);
			}
		}
	}


}
