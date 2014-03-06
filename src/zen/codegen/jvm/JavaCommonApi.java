package zen.codegen.jvm;

import java.lang.reflect.Method;

import zen.type.ZFunc;
import zen.type.ZFuncType;
import zen.util.LibZen;
import zen.util.SoftwareFaultException;
import zen.util.Var;
import zen.util.ZArray;

public class JavaCommonApi {

	public final static void Assert(boolean x, String Location) {
		if(!x) {
			Exception e = new SoftwareFaultException("failed: " + Location);
			e.printStackTrace();
			System.err.println("REC assert 0 @" + Location);
			System.exit(1);
		}
		//		else {
		//			System.err.println("REC assert 1 @" + Location);
		//		}
	}

	public final static void Print(String o) {
		System.out.print(o);
	}

	public final static void PrintLine(String o) {
		System.out.println(o);
	}

	//	// converter
	//	asm macro _ "zen/codegen/jvm/JavaCommonApi.IntToFloat($[0])" : Func<int,float>;
	//	asm macro _ "zen/codegen/jvm/JavaCommonApi.FloatToInt($[0])" : Func<float,int>;
	//	asm macro _ "zen/codegen/jvm/JavaCommonApi.ToString($[0])" : Func<boolean,String>;
	//	asm macro _ "zen/codegen/jvm/JavaCommonApi.ToString($[0])" : Func<int,String>;
	//	asm macro _ "zen/codegen/jvm/JavaCommonApi.ToString($[0])" : Func<float,String>;
	//

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

	//	// Array
	//	asm macro size "zen/codegen/jvm/JavaCommonApi.ArraySize($[0])" : Func<α[],int>;
	//	asm macro clear "zen/codegen/jvm/JavaCommonApi.ArrayClear($[0],$[1])" : Func<α[],int,void>;
	//	asm macro add "zen/codegen/jvm/JavaCommonApi.ArrayAdd($[0],$[1])" : Func<α[],α,void>;
	//	asm macro add "zen/codegen/jvm/JavaCommonApi.ArrayInsert($[0],$[1],$[2])" : Func<α[],int,α,void>;


	public final static long StringSize(String x) {
		return x.length();
	}

	public final static String SubString(String x, long y) {
		return x.substring((int)y);
	}

	public final static String SubString(String x, long y, long z) {
		return x.substring((int)y, (int)z);
	}

	public final static long IndexOf(String x, String y) {
		return x.indexOf(y);
	}

	public final static long IndexOf(String x, String y, long z) {
		return x.indexOf(y, (int)z);
	}

	public final static boolean Equals(String x, String z) {
		return x.equals(z);
	}

	public final static boolean StartsWith(String x, String z) {
		return x.startsWith(z);
	}

	public final static boolean EndsWith(String x, String z) {
		return x.endsWith(z);
	}

	// Array
	public final static <T> long ArraySize(ZArray<T> x) {
		return x.size();
	}

	public final static <T> long ArrayClear(ZArray<T> x) {
		return x.size();
	}

	public final static <T> void ArrayAdd(ZArray<T> x, T z) {
		x.add(z);
	}

	public final static <T> void ArrayInsert(ZArray<T> x, long y, T z) {
		x.add((int)y, z);
	}

	public final static JavaStaticFunc ConvertToNativeFunc(Method jMethod) {
		@Var ZFuncType FuncType = JavaTypeTable.ConvertToFuncType(jMethod);
		return new JavaStaticFunc(jMethod.getName(), FuncType, jMethod);
	}

	static ZFunc LoadFunc(String Name, Class<?> ... classes) {
		try {
			return ConvertToNativeFunc(JavaCommonApi.class.getMethod(Name, classes));
		} catch (Exception e) {
			LibZen._Exit(1, "FIXME: " + e);
		}
		return null;
	}

	//	static void LoadCommonApi(ZGenerator Generator) {
	//		Generator.SetDefinedFunc(LoadFunc("Assert", boolean.class));
	//		Generator.SetDefinedFunc(LoadFunc("Assert", boolean.class, String.class));
	//		Generator.SetConverterFunc(ZType.FloatType, ZType.IntType, LoadFunc("FloatToInt", double.class));
	//		Generator.SetConverterFunc(ZType.IntType, ZType.FloatType, LoadFunc("IntToFloat", long.class));
	//		Generator.SetConverterFunc(ZType.VarType, ZType.StringType, LoadFunc("ToString", Object.class));
	//		Generator.SetConverterFunc(ZType.BooleanType, ZType.StringType, LoadFunc("ToString", boolean.class));
	//		Generator.SetConverterFunc(ZType.IntType, ZType.StringType, LoadFunc("ToString", long.class));
	//		Generator.SetConverterFunc(ZType.FloatType, ZType.StringType, LoadFunc("ToString", double.class));
	//		Generator.SetDefinedFunc(LoadFunc("Size", String.class));
	//	}
}
