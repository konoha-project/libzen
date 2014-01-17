package zen.codegen.jvm;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.objectweb.asm.Type;

import zen.ast.ZenFuncDeclNode;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.ZenArray;
import zen.lang.ZenFunc;
import zen.lang.ZenSystem;
import zen.lang.ZenType;
import zen.parser.ZenNameSpace;

class JLib {
	static HashMap<String, Type> TypeMap = new HashMap<String, Type>();
	static Method GetConstPool;
	static Method GetTypeById;
	static Method GetFuncById;
	static Method GetNameSpaceById;
	static Method DynamicGetter;
	static Method DynamicSetter;
	static Method BoxBooleanValue;
	static Method BoxIntValue;
	static Method BoxFloatValue;
	static Method UnboxBooleanValue;
	static Method UnboxIntValue;
	static Method UnboxFloatValue;
	static Method GreenCastOperator;
	static Method GreenInstanceOfOperator;
	static Method NewNewArray;
	static Method NewArray;
	static Method InvokeFunc;
	static Method InvokeOverridedFunc;
	static Method InvokeDynamicFunc;
	static Method InvokeDynamicMethod;

	static Method ExecCommandVoid;
	static Method ExecCommandBool;
	static Method ExecCommandString;
	static Method ExecCommandTask;

	static {
		TypeMap.put("void", Type.VOID_TYPE);
		TypeMap.put("boolean", Type.BOOLEAN_TYPE);
		TypeMap.put("int", Type.LONG_TYPE);
		TypeMap.put("float", Type.DOUBLE_TYPE);
		TypeMap.put("any", Type.getType(Object.class));
		TypeMap.put("String", Type.getType(String.class));
		TypeMap.put("Array", Type.getType(ZenArray.class));
		TypeMap.put("Func", Type.getType(ZenFunc.class));

		try {
			GetConstPool = ZenSystem.class.getMethod("GetConstPool", int.class);
			GetTypeById = ZenSystem.class.getMethod("GetTypeById", int.class);
			GetFuncById = ZenSystem.class.getMethod("GetFuncById", int.class);
			DynamicGetter = LibZen.class.getMethod("DynamicGetter", Object.class, String.class);
			DynamicSetter = LibZen.class.getMethod("DynamicSetter", Object.class, String.class, Object.class);
			InvokeFunc = LibZen.class.getMethod("InvokeFunc", ZenFunc.class, Object[].class);
			InvokeOverridedFunc = LibZen.class.getMethod("InvokeOverridedMethod", long.class, ZenNameSpace.class, ZenFunc.class, Object[].class);
			InvokeDynamicFunc = LibZen.class.getMethod("InvokeDynamicFunc", long.class, ZenType.class, ZenNameSpace.class, String.class, Object[].class);
			InvokeDynamicMethod = LibZen.class.getMethod("InvokeDynamicMethod", long.class, ZenType.class, ZenNameSpace.class, String.class, Object[].class);

			BoxBooleanValue = Boolean.class.getMethod("valueOf", boolean.class);
			BoxIntValue = Long.class.getMethod("valueOf", long.class);
			BoxFloatValue = Double.class.getMethod("valueOf", double.class);
			UnboxBooleanValue = Boolean.class.getMethod("booleanValue");
			UnboxIntValue = Long.class.getMethod("longValue");
			UnboxFloatValue = Double.class.getMethod("doubleValue");

			GreenCastOperator = LibZen.class.getMethod("DynamicCast", ZenType.class, Object.class);
			GreenInstanceOfOperator = LibZen.class.getMethod("DynamicInstanceOf", Object.class, ZenType.class);
			NewNewArray = LibZen.class.getMethod("NewNewArray", ZenType.class, Object[].class);
			NewArray = LibZen.class.getMethod("NewArray", ZenType.class, Object[].class);
			//			ExecCommandVoid = DShellProcess.class.getMethod("ExecCommandVoid", String[][].class);
			//			ExecCommandBool = DShellProcess.class.getMethod("ExecCommandBool", String[][].class);
			//			ExecCommandString = DShellProcess.class.getMethod("ExecCommandString", String[][].class);
			//			ExecCommandTask = DShellProcess.class.getMethod("ExecCommandTask", String[][].class);
		}
		catch(Exception e) {
			e.printStackTrace();
			LibNative.Exit(1, "load error");
		}
	}

	public static String GetHolderClassName(ZenNameSpace NameSpace, String FuncName) {
		return "FuncHolder" + FuncName + "$" + 0; //Context.ParserId;
	}

	static Type GetAsmType(ZenType GreenType) {
		Type type = TypeMap.get(GreenType.ShortName);
		if(type != null) {
			return type;
		}
		//		if(GreenType.TypeBody != null && GreenType.TypeBody instanceof Class<?>) {
		//			return Type.getType((Class<?>) GreenType.TypeBody);
		//		}
		//		if(GreenType.IsTypeVariable()) {
		//			return Type.getType(Object.class);
		//		}
		//		if(GreenType.IsGenericType()) {
		//			return GetAsmType(GreenType.BaseType);
		//		}
		return Type.getType("L" + GreenType.GetNativeName() + ";");
	}

	static String GetMethodDescriptor(ZenFuncDeclNode Func) {
		Type ReturnType = GetAsmType(Func.ReturnType);
		Type[] argTypes = new Type[Func.ArgumentList.size()];
		for(int i = 0; i < argTypes.length; i++) {
			ZenType ParamType = Func.ArgumentList.get(i).Type;
			argTypes[i] = GetAsmType(ParamType);
		}
		return Type.getMethodDescriptor(ReturnType, argTypes);
	}
}