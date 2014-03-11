// ***************************************************************************
// Copyright (c) 2013, JST/CREST DEOS project authors. All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// *  Redistributions of source code must retain the above copyright notice,
//    this list of conditions and the following disclaimer.
// *  Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
// PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
// CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
// OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
// WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
// OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
// ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// **************************************************************************

package zen.codegen.jvm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import zen.type.ZType;
import zen.util.SoftwareFaultException;
import zen.util.Var;
import zen.util.ZMap;

public final class JavaOperatorApi {

	private static String t(Object x) {
		return JavaTypeTable.GetZenType(x.getClass()).toString();
	}

	public static boolean Not(Object x) {
		return ((Boolean)x).booleanValue();
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
		return -((Number)x).longValue();
	}
	public static long BitwiseNot(Object x) {
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
			return ((Number)x).doubleValue() + ((Number)y).doubleValue();
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
			return ((Number)x).doubleValue() * ((Number)y).doubleValue();
		}
		return ((Number)x).longValue() * ((Number)y).longValue();
	}
	public static Object Div(Object x, Object y) {
		if(x instanceof Double || y instanceof Double) {
			return ((Number)x).doubleValue() / ((Number)y).doubleValue();
		}
		return ((Number)x).longValue() / ((Number)y).longValue();
	}
	public static Object Mod(Object x, Object y) {
		if(x instanceof Double || y instanceof Double) {
			return ((Number)x).doubleValue() % ((Number)y).doubleValue();
		}
		return ((Number)x).longValue() / ((Number)y).longValue();
	}
	public static long LeftShift(Object x, Object y) {
		return ((Number)x).longValue() << ((Number)y).longValue();
	}
	public static long RightShift(Object x, Object y) {
		return ((Number)x).longValue() >> ((Number)y).longValue();
	}
	public static long BitwiseAnd(Object x, Object y) {
		return ((Number)x).longValue() & ((Number)y).longValue();
	}
	public static long BitwiseOr(Object x, Object y) {
		return ((Number)x).longValue() | ((Number)y).longValue();
	}
	public static long BitwiseXor(Object x, Object y) {
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

	public static boolean Not(boolean b) {
		return !b;
	}
	public static boolean Equals(boolean x, boolean y) {
		return x == y;
	}
	public static boolean NotEquals(boolean x, boolean y) {
		return x != y;
	}
	//
	public static long Plus(long n) {
		return +n;
	}
	public static long Minus(long n) {
		return -n;
	}
	public static long BitwiseNot(long n) {
		return ~n;
	}
	public static long Add(long x, long y) {
		return x + y;
	}
	public static long Sub(long x, long y) {
		return x - y;
	}
	public static long Mul(long x, long y) {
		return x * y;
	}
	public static long Div(long x, long y) {
		return x / y;
	}
	public static long Mod(long x, long y) {
		return x % y;
	}
	public static long LeftShift(long x, long y) {
		return x << y;
	}
	public static long RightShift(long x, long y) {
		return x >> y;
	}
	public static long BitwiseAnd(long x, long y) {
		return x & y;
	}
	public static long BitwiseOr(long x, long y) {
		return x | y;
	}
	public static long BitwiseXor(long x, long y) {
		return x ^ y;
	}
	public static boolean LessThan(long x, long y) {
		return x < y;
	}
	public static boolean LessThanEquals(long x, long y) {
		return x <= y;
	}
	public static boolean GreaterThan(long x, long y) {
		return x > y;
	}
	public static boolean GreaterThanEquals(long x, long y) {
		return x >= y;
	}
	public static boolean Equals(long x, long y) {
		return x == y;
	}
	public static boolean NotEquals(long x, long y) {
		return x != y;
	}
	//
	public static double Plus(double n) {
		return +n;
	}
	public static double Minus(double n) {
		return -n;
	}
	public static double Add(double x, double y) {
		return x + y;
	}
	public static double Sub(double x, double y) {
		return x - y;
	}
	public static double Mul(double x, double y) {
		return x * y;
	}
	public static double Div(double x, double y) {
		return x / y;
	}
	public static double Mod(double x, double y) {
		return x % y;
	}
	public static boolean LessThan(double x, double y) {
		return x < y;
	}
	public static boolean LessThanEquals(double x, double y) {
		return x <= y;
	}
	public static boolean GreaterThan(double x, double y) {
		return x > y;
	}
	public static boolean GreaterThanEquals(double x, double y) {
		return x >= y;
	}
	public static boolean Equals(double x, double y) {
		return x == y;
	}
	public static boolean NotEquals(double x, double y) {
		return x != y;
	}
	//
	public static String Add(String x, String y) {
		return x + y;
	}
	public static boolean Equals(String x, String y) {
		if(x == null || y == null) {
			return x == y;
		}
		else {
			return x.equals(y);
		}
	}
	public static boolean NotEquals(String x, String y) {
		return !Equals(x, y);
	}

	public static String GetIndex(String x, long y) {
		return String.valueOf(x.charAt((int)y));
	}

	public static Object ThrowError(String Message) {
		throw new SoftwareFaultException("SoftwareFault: " + Message);
	}

	//	public static <T> T GetIndex(ZenArray<T> x, long y) {
	//		return x.get((int)y);
	//	}
	//
	//	public static <T> void SetIndex(ZenArray<T> x, long y, T z) {
	//		x.set((int)y, z);
	//	}

	public static <T> T GetIndex(ArrayList<T> x, long y) {
		return x.get((int)y);
	}

	public static <T> void SetIndex(ArrayList<T> x, long y, T z) {
		x.set((int)y, z);
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
		if(x instanceof ZMap && y instanceof String) {
			@Var ZMap<?> m = (ZMap<?>)x;
			return m.GetOrNull(y.toString());
		}
		throw new RuntimeException("unsupported operator: " + t(x) + "[" + t(y) + "]");
	}

	@SuppressWarnings("unchecked")
	public static <T> void SetIndex(Object x, Object y, T z) {
		if(x instanceof ArrayList && y instanceof Number) {
			@Var ArrayList<T> a = (ArrayList<T>)x;
			a.set(((Number)y).intValue(), z);
		}
		if(x instanceof ZMap && y instanceof String) {
			@Var ZMap<T> m = (ZMap<T>)x;
			m.put(y.toString(), z);
		}
		throw new RuntimeException("unsupported operator: " + t(x) + "[" + t(y) + "]");
	}

	public static Object GetField(Object x, String name) {
		//System.out.println("name="+name+", x="+x);
		try {
			if(x instanceof ZType) {
				Field f = JavaTypeTable.GetJavaClass((ZType)x, null).getField(name);
				return f.get(null);	  // static field
			}
			else {
				Field f = x.getClass().getField(name);
				//System.out.println("f="+f+", x="+x);
				return f.get(x);
			}
		}
		catch(Exception e) {
			throw new SoftwareFaultException("undefined field: " + name);
		}
	}

	public static void SetField(Object x, String name, Object y) {
		try {
			if(x instanceof ZType) {
				Field f = JavaTypeTable.GetJavaClass((ZType)x, null).getField(name);
				f.set(null,y); // static field
			}
			else {
				Field f = x.getClass().getField(name);
				f.set(x,y);
			}
		}
		catch(Exception e) {
			throw new SoftwareFaultException("undefined field: " + name);
		}
	}

	public static Object InvokeUnresolvedMethod(Object x, String name, Object[] y) {
		try {
			Method[] ms = x.getClass().getMethods();
			for(int i = 0; i < ms.length; i++) {
				if(ms[i].getName().equals(name) && ms[i].getParameterTypes().length == y.length) {
					return ms[i].invoke(x, y);
				}
			}
			throw new SoftwareFaultException("undefined method " + name + " of " + x.getClass().getSimpleName());
		}
		catch(Exception e) {
			throw new SoftwareFaultException("mismatched method " + name + " of " + x.getClass().getSimpleName());
		}
	}



}
