package zen.codegen.jvm;

import java.lang.reflect.Method;

import zen.deps.LibZen;
import zen.deps.SoftwareFaultException;
import zen.deps.Var;
import zen.parser.ZGenerator;
import zen.type.ZFunc;
import zen.type.ZFuncType;
import zen.type.ZType;

public class JavaCommonApi {

	public final static void Assert(boolean x) {
		if(!x) {
			Exception e = new SoftwareFaultException("assertion failed");
			e.printStackTrace();
			StackTraceElement[] Elements = e.getStackTrace();
			String LineNumber = "";
			int depth = 4;
			if(depth < Elements.length) {
				StackTraceElement elem = Elements[depth];
				LineNumber += elem;
			}
			System.err.println("EXIT: " + LineNumber + " assertion failed");
			System.exit(1);
		}
	}

	public final static void Assert(boolean x, String Location) {
		if(!x) {
			Exception e = new SoftwareFaultException("failed: " + Location);
			e.printStackTrace();
			System.err.println("REC assert 0 @" + Location);
			System.exit(1);
		}
		else {
			System.err.println("REC assert 1 @" + Location);
		}
	}

	public final static long FloatToInt(double x) {
		return Math.round(x);
	}

	public final static double IntToFloat(long x) {
		return x;
	}

	public final static String ToString(Object x) {
		if(x == null) {
			return "null";
		}
		return x.toString();
	}

	public final static String ToString(boolean x) {
		return String.valueOf(x);
	}

	public final static String ToString(long x) {
		return String.valueOf(x);
	}

	public final static String ToString(double x) {
		return String.valueOf(x);
	}

	public final static long Size(String x) {
		return x.length();
	}

	public final static JavaStaticFunc ConvertToNativeFunc(Method jMethod) {
		@Var ZFuncType FuncType = JavaTypeTable.ConvertToFuncType(jMethod);
		return new JavaStaticFunc(0, jMethod.getName(), FuncType, jMethod);
	}

	static ZFunc LoadFunc(String Name, Class<?> ... classes) {
		try {
			return ConvertToNativeFunc(JavaCommonApi.class.getMethod(Name, classes));
		} catch (Exception e) {
			LibZen._Exit(1, "FIXME: " + e);
		}
		return null;
	}

	static void LoadCommonApi(ZGenerator Generator) {
		Generator.SetDefinedFunc(LoadFunc("Assert", boolean.class));
		Generator.SetDefinedFunc(LoadFunc("Assert", boolean.class, String.class));
		ZFunc Func = LoadFunc("FloatToInt", double.class);
		Generator.SetConverterFunc(ZType.FloatType, ZType.IntType, Func);
		Func = LoadFunc("IntToFloat", long.class);
		Generator.SetConverterFunc(ZType.IntType, ZType.FloatType, Func);
		Func = LoadFunc("ToString", Object.class);
		Generator.SetConverterFunc(ZType.VarType, ZType.StringType, Func);
		Func = LoadFunc("ToString", boolean.class);
		Generator.SetConverterFunc(ZType.BooleanType, ZType.StringType, Func);
		Func = LoadFunc("ToString", long.class);
		Generator.SetConverterFunc(ZType.IntType, ZType.StringType, Func);
		Func = LoadFunc("ToString", double.class);
		Generator.SetConverterFunc(ZType.FloatType, ZType.StringType, Func);
		Generator.SetDefinedFunc(LoadFunc("Size", String.class));
	}
}
