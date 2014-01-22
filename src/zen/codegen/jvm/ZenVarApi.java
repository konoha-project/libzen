package zen.codegen.jvm;

public class ZenVarApi {
	public static Object Plus(Object x) {
		if(x instanceof Number) {
			return x;
		}
		throw new RuntimeException("unsupported operator + " + JavaTypeTable.GetZenType(x.getClass()));
	}
	public static Object Minus(Object x) {
		if(x instanceof Double) {
			return -((Long)x).doubleValue();
		}
		if(x instanceof Number) {
			return -((Number)x).longValue();
		}
		throw new RuntimeException("unsupported operator - " + JavaTypeTable.GetZenType(x.getClass()));
	}
	public static Object BitwiseNot(Object x) {
		if(x instanceof Number && !(x instanceof Double)) {
			return ~((Number)x).longValue();
		}
		throw new RuntimeException("unsupported operator ~ " + JavaTypeTable.GetZenType(x.getClass()));
	}
	public static Object Add(Object x, Object y) {
		if(x instanceof String || y instanceof String) {
			return "" + x + y;
		}
		if(x instanceof Double || y instanceof Double) {
			return ((Double)x).doubleValue() + ((Double)y).doubleValue();
		}
		return ((Number)x).longValue() + ((Number)y).longValue();
	}
	public static Object Sub(Object x, Object y) {
		if(x instanceof Double || y instanceof Double) {
			return ((Double)x).doubleValue() - ((Double)y).doubleValue();
		}
		return ((Number)x).longValue() - ((Number)y).longValue();
	}
	public static Object Mul(Object x, Object y) {
		if(x instanceof Double || y instanceof Double) {
			return ((Double)x).doubleValue() * ((Double)y).doubleValue();
		}
		return ((Number)x).longValue() * ((Number)y).longValue();
	}
	public static Object Div(Object x, Object y) {
		if(x instanceof Double || y instanceof Double) {
			return ((Double)x).doubleValue() / ((Double)y).doubleValue();
		}
		return ((Number)x).longValue() / ((Number)y).longValue();
	}
	public static Object Mod(Object x, Object y) {
		if(x instanceof Double || y instanceof Double) {
			return ((Double)x).doubleValue() % ((Double)y).doubleValue();
		}
		return ((Number)x).longValue() / ((Number)y).longValue();
	}
	public static Object LeftShift(Object x, Object y) {
		return ((Number)x).longValue() << ((Number)y).longValue();
	}
	public static Object RightShift(Object x, Object y) {
		return ((Number)x).longValue() >> ((Number)y).longValue();
	}
	public static Object BitwiseAnd(Object x, Object y) {
		return ((Number)x).longValue() & ((Number)y).longValue();
	}
	public static Object BitwiseOr(Object x, Object y) {
		return ((Number)x).longValue() | ((Number)y).longValue();
	}
	public static Object BitwiseXor(Object x, Object y) {
		return ((Number)x).longValue() ^ ((Number)y).longValue();
	}
	public static boolean LessThan(Object x, Object y) {
		return ((Number)x).doubleValue() < ((Number)y).doubleValue();
	}
	public static boolean LessThanEquals(Object x, Object y) {
		return ((Number)x).doubleValue() <= ((Number)y).doubleValue();
	}
	public static boolean GreaterThan(Object x, Object y) {
		return ((Number)x).doubleValue() > ((Number)y).doubleValue();
	}
	public static boolean GreaterThanEquals(Object x, Object y) {
		return ((Number)x).doubleValue() >= ((Number)y).doubleValue();
	}
	public static boolean Equals(Object x, Object y) {
		if(x instanceof Number && y instanceof Number) {
			return ((Number)x).doubleValue() == ((Number)y).doubleValue();
		}
		return x == y;
	}
	public static boolean NotEquals(Object x, Object y) {
		if(x instanceof Number && y instanceof Number) {
			return ((Number)x).doubleValue() != ((Number)y).doubleValue();
		}
		return x != y;
	}
	public static Object toObject(boolean x) {
		return x;
	}
	public static Object toObject(long x) {
		return x;
	}
	public static Object toObject(double x) {
		return x;
	}
}
