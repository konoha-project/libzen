package zen.codegen.jvm;


public class ZenVarApi {

	public static Object toObject(boolean x) {
		return x;
	}
	public static Object toObject(long x) {
		return x;
	}
	public static Object toObject(double x) {
		return x;
	}
	public static boolean toboolean(Object x) {
		return ((Boolean)x).booleanValue();
	}
	public static long toint(Object x) {
		return ((Number)x).longValue();
	}
	public static double todouble(Object x) {
		return ((Number)x).doubleValue();
	}
	public static String toString(Object x) {
		return (String)x;
	}
}
