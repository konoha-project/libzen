package zen.codegen.jvm;

import java.lang.reflect.Field;
import java.util.List;

import zen.deps.Var;
import zen.deps.ZenMap;

public class ZenVarApi {

	private static String t(Object x) {
		return JavaTypeTable.GetZenType(x.getClass()).toString();
	}

	public static Object Plus(Object x) {
		if(x instanceof Number) {
			return x;
		}
		throw new RuntimeException("unsupported operator + " + t(x));
	}
	public static Object Minus(Object x) {
		if(x instanceof Double) {
			return -((Long)x).doubleValue();
		}
		if(x instanceof Number) {
			return -((Number)x).longValue();
		}
		throw new RuntimeException("unsupported operator - " + t(x));
	}
	public static Object BitwiseNot(Object x) {
		if(x instanceof Number && !(x instanceof Double)) {
			return ~((Number)x).longValue();
		}
		throw new RuntimeException("unsupported operator ~ " + t(x));
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

	public static Object GetIndex(Object x, Object y) {
		if(x instanceof String && y instanceof Number) {
			@Var String s = (String)x;
			return String.valueOf(s.charAt(((Number)y).intValue()));
		}
		if(x instanceof List && y instanceof Number) {
			@Var List<?> a = (List<?>)x;
			return a.get(((Number)y).intValue());
		}
		if(x instanceof ZenMap && y instanceof String) {
			@Var ZenMap<?> m = (ZenMap<?>)x;
			return m.GetOrNull(y.toString());
		}
		throw new RuntimeException("unsupported operator: " + t(x) + "[" + t(y) + "]");
	}
	public static void SetIndex(Object x, Object y, Object z) {
		//		if(x instanceof ArrayList && y instanceof Number) {
		//			@Var ArrayList<?> a = (ArrayList<?>)x;
		//			return a.set(((Number)y).intValue(), z);
		//		}
		//		if(x instanceof ZenMap && y instanceof String) {
		//			@Var ZenMap<?> m = (ZenMap<?>)x;
		//			return m.put(y.toString(), z);
		//		}
		throw new RuntimeException("unsupported operator: " + t(x) + "[" + t(y) + "]");
	}

	public static Object GetField(Object x, String name) {
		try {
			Field f = x.getClass().getField(name);
			return f.get(x);
		}
		catch(Exception e) {
			throw new SoftwareFaultException(e.toString());
		}
	}

	public static void SetField(Object x, String name, Object y) {
		try {
			Field f = x.getClass().getField(name);
			f.set(x,y);
		}
		catch(Exception e) {
			throw new SoftwareFaultException(e.toString());
		}
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
