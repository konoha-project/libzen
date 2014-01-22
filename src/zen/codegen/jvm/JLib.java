package zen.codegen.jvm;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.objectweb.asm.Type;

import zen.deps.LibNative;
import zen.deps.ZenArray;
import zen.lang.ZFunc;
import zen.lang.ZSystem;

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
		TypeMap.put("Func", Type.getType(ZFunc.class));

		try {
			GetConstPool = ZSystem.class.getMethod("GetConstPool", int.class);
			GetTypeById = ZSystem.class.getMethod("GetTypeById", int.class);
			GetFuncById = ZSystem.class.getMethod("GetFuncById", int.class);
			DynamicGetter = JMethod.class.getMethod("DynamicGetter", Object.class, String.class);
			DynamicSetter = JMethod.class.getMethod("DynamicSetter", Object.class, String.class, Object.class);
			InvokeFunc = JMethod.class.getMethod("InvokeFunc", JMethod.class, Object[].class);
			//InvokeOverridedFunc = JMethod.class.getMethod("InvokeOverridedMethod", long.class, ZenNameSpace.class, ZenFunc.class, Object[].class);
			//InvokeDynamicFunc = JMethod.class.getMethod("InvokeDynamicFunc", long.class, ZenType.class, ZenNameSpace.class, String.class, Object[].class);
			//InvokeDynamicMethod = JMethod.class.getMethod("InvokeDynamicMethod", long.class, ZenType.class, ZenNameSpace.class, String.class, Object[].class);

			BoxBooleanValue = Boolean.class.getMethod("valueOf", boolean.class);
			BoxIntValue = Long.class.getMethod("valueOf", long.class);
			BoxFloatValue = Double.class.getMethod("valueOf", double.class);
			UnboxBooleanValue = Boolean.class.getMethod("booleanValue");
			UnboxIntValue = Long.class.getMethod("longValue");
			UnboxFloatValue = Double.class.getMethod("doubleValue");

			//GreenCastOperator = LibZen.class.getMethod("DynamicCast", ZenType.class, Object.class);
			//GreenInstanceOfOperator = LibZen.class.getMethod("DynamicInstanceOf", Object.class, ZenType.class);
			//NewNewArray = LibZen.class.getMethod("NewNewArray", ZenType.class, Object[].class);
			//NewArray = LibZen.class.getMethod("NewArray", ZenType.class, Object[].class);
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

	public static String GetHolderClassName(String FuncName) {
		return "FuncHolder" + FuncName + "$" + 0; //Context.ParserId;
	}


}