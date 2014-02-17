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
import java.lang.reflect.Method;
import java.util.HashMap;

import zen.type.ZType;
import zen.type.ZTypePool;

public class JavaMethodTable {

	static HashMap<String, Method> MethodMap = new HashMap<String,Method>();

	static {

		Import("!", ZType.VarType, JavaOperatorApi.class, "Not");
		Import("+", ZType.VarType, JavaOperatorApi.class, "Plus");
		Import("-", ZType.VarType, JavaOperatorApi.class, "Minus");
		Import("~", ZType.VarType, JavaOperatorApi.class, "BitwiseNot");
		Import(ZType.VarType, "+", ZType.VarType, JavaOperatorApi.class, "Add");
		Import(ZType.VarType, "-", ZType.VarType, JavaOperatorApi.class, "Sub");
		Import(ZType.VarType, "*", ZType.VarType, JavaOperatorApi.class, "Mul");
		Import(ZType.VarType, "/", ZType.VarType, JavaOperatorApi.class, "Div");
		Import(ZType.VarType, "%", ZType.VarType, JavaOperatorApi.class, "Mod");
		Import(ZType.VarType, "==", ZType.VarType, JavaOperatorApi.class, "Equals");
		Import(ZType.VarType, "!=", ZType.VarType, JavaOperatorApi.class, "NotEquals");
		Import(ZType.VarType, "<", ZType.VarType, JavaOperatorApi.class, "LessThan");
		Import(ZType.VarType, "<=", ZType.VarType, JavaOperatorApi.class, "LessThanEquals");
		Import(ZType.VarType, ">", ZType.VarType, JavaOperatorApi.class, "GreaterThan");
		Import(ZType.VarType, ">=", ZType.VarType, JavaOperatorApi.class, "GreaterThanEquals");
		Import(ZType.VarType, "&", ZType.VarType, JavaOperatorApi.class, "BitwiseAnd");
		Import(ZType.VarType, "|", ZType.VarType, JavaOperatorApi.class, "BitwiseOr");
		Import(ZType.VarType, "^", ZType.VarType, JavaOperatorApi.class, "BitwiseXor");
		Import(ZType.VarType, "<<", ZType.VarType, JavaOperatorApi.class, "LeftShift");
		Import(ZType.VarType, ">>", ZType.VarType, JavaOperatorApi.class, "RightShift");

		Import("!", ZType.BooleanType, JavaOperatorApi.class, "Not");
		Import("+", ZType.IntType, JavaOperatorApi.class, "Plus");
		Import("-", ZType.IntType, JavaOperatorApi.class, "Minus");
		Import("~", ZType.IntType, JavaOperatorApi.class, "BitwiseNot");
		Import(ZType.IntType, "+", ZType.IntType, JavaOperatorApi.class, "Add");
		Import(ZType.IntType, "-", ZType.IntType, JavaOperatorApi.class, "Sub");
		Import(ZType.IntType, "*", ZType.IntType, JavaOperatorApi.class, "Mul");
		Import(ZType.IntType, "/", ZType.IntType, JavaOperatorApi.class, "Div");
		Import(ZType.IntType, "%", ZType.IntType, JavaOperatorApi.class, "Mod");
		Import(ZType.IntType, "==", ZType.IntType, JavaOperatorApi.class, "Equals");
		Import(ZType.IntType, "!=", ZType.IntType, JavaOperatorApi.class, "NotEquals");
		Import(ZType.IntType, "<", ZType.IntType, JavaOperatorApi.class, "LessThan");
		Import(ZType.IntType, "<=", ZType.IntType, JavaOperatorApi.class, "LessThanEquals");
		Import(ZType.IntType, ">", ZType.IntType, JavaOperatorApi.class, "GreaterThan");
		Import(ZType.IntType, ">=", ZType.IntType, JavaOperatorApi.class, "GreaterThanEquals");
		Import(ZType.IntType, "&", ZType.IntType, JavaOperatorApi.class, "BitwiseAnd");
		Import(ZType.IntType, "|", ZType.IntType, JavaOperatorApi.class, "BitwiseOr");
		Import(ZType.IntType, "^", ZType.IntType, JavaOperatorApi.class, "BitwiseXor");
		Import(ZType.IntType, "<<", ZType.IntType, JavaOperatorApi.class, "LeftShift");
		Import(ZType.IntType, ">>", ZType.IntType, JavaOperatorApi.class, "RightShift");

		Import("+", ZType.FloatType, JavaOperatorApi.class, "Plus");
		Import("-", ZType.FloatType, JavaOperatorApi.class, "Minus");
		Import(ZType.FloatType, "+", ZType.FloatType, JavaOperatorApi.class, "Add");
		Import(ZType.FloatType, "-", ZType.FloatType, JavaOperatorApi.class, "Sub");
		Import(ZType.FloatType, "*", ZType.FloatType, JavaOperatorApi.class, "Mul");
		Import(ZType.FloatType, "/", ZType.FloatType, JavaOperatorApi.class, "Div");
		Import(ZType.FloatType, "%", ZType.FloatType, JavaOperatorApi.class, "Mod");
		Import(ZType.FloatType, "==", ZType.FloatType, JavaOperatorApi.class, "Equals");
		Import(ZType.FloatType, "!=", ZType.FloatType, JavaOperatorApi.class, "NotEquals");
		Import(ZType.FloatType, "<", ZType.FloatType, JavaOperatorApi.class, "LessThan");
		Import(ZType.FloatType, "<=", ZType.FloatType, JavaOperatorApi.class, "LessThanEquals");
		Import(ZType.FloatType, ">", ZType.FloatType, JavaOperatorApi.class, "GreaterThan");
		Import(ZType.FloatType, ">=", ZType.FloatType, JavaOperatorApi.class, "GreaterThanEquals");

		Import(ZType.StringType, "+", ZType.StringType, JavaOperatorApi.class, "Add");
		Import(ZType.StringType, "==", ZType.StringType, JavaOperatorApi.class, "Equals");
		Import(ZType.StringType, "!=", ZType.StringType, JavaOperatorApi.class, "NotEquals");
		Import(ZType.StringType, "[]", ZType.IntType, JavaOperatorApi.class, "GetIndex");

		ZType IntArrayType = ZTypePool._GetGenericType1(ZType.ArrayType, ZType.IntType);
		ZType FloatArrayType = ZTypePool._GetGenericType1(ZType.ArrayType, ZType.FloatType);
		ZType StringArrayType = ZTypePool._GetGenericType1(ZType.ArrayType, ZType.StringType);

		Import(ZType.ArrayType, "[]", ZType.IntType, zen.deps.ZObjectArray.class, "GetIndex");
		Import(ZType.ArrayType, "[]=", ZType.IntType, zen.deps.ZObjectArray.class, "SetIndex", Object.class);
		Import(IntArrayType, "[]", ZType.IntType, zen.deps.ZIntArray.class, "GetIndex");
		Import(IntArrayType, "[]=", ZType.IntType, zen.deps.ZIntArray.class, "SetIndex", long.class);
		Import(FloatArrayType, "[]", ZType.IntType, zen.deps.ZFloatArray.class, "GetIndex");
		Import(FloatArrayType, "[]=", ZType.IntType, zen.deps.ZFloatArray.class, "SetIndex", double.class);
		Import(StringArrayType, "[]", ZType.IntType, zen.deps.ZStringArray.class, "GetIndex");
		Import(StringArrayType, "[]=", ZType.IntType, zen.deps.ZStringArray.class, "SetIndex", String.class);

		Import(boolean.class, JavaCastApi.class, "toObject");
		Import(byte.class, JavaCastApi.class, "toObject");
		Import(short.class, JavaCastApi.class, "toObject");
		Import(int.class, JavaCastApi.class, "toObject");
		Import(long.class, JavaCastApi.class, "toObject");
		Import(float.class, JavaCastApi.class, "toObject");
		Import(double.class, JavaCastApi.class, "toObject");

		Import(Object.class, JavaCastApi.class, "toboolean");
		Import(Boolean.class, JavaCastApi.class, "toboolean");
		Import(Object.class, JavaCastApi.class, "tobyte");
		Import(long.class, JavaCastApi.class, "tobyte");
		Import(Object.class, JavaCastApi.class, "toshort");
		Import(long.class, JavaCastApi.class, "toshort");
		Import(Object.class, JavaCastApi.class, "toint");
		Import(long.class, JavaCastApi.class, "toint");
		Import(Object.class, JavaCastApi.class, "tolong");
		Import(byte.class, JavaCastApi.class,  "tolong");
		Import(short.class, JavaCastApi.class, "tolong");
		Import(int.class, JavaCastApi.class, "tolong");
		Import(double.class, JavaCastApi.class, "tolong");
		Import(Byte.class, JavaCastApi.class,  "tolong");
		Import(Short.class, JavaCastApi.class, "tolong");
		Import(Integer.class, JavaCastApi.class, "tolong");
		Import(Long.class, JavaCastApi.class, "tolong");
		Import(Object.class, JavaCastApi.class, "tofloat");
		Import(double.class, JavaCastApi.class, "tofloat");
		Import(Object.class, JavaCastApi.class, "todouble");
		Import(long.class, JavaCastApi.class, "todouble");
		Import(float.class, JavaCastApi.class, "todouble");
		Import(Float.class, JavaCastApi.class, "todouble");
		Import(Double.class, JavaCastApi.class, "todouble");

		Import(Object.class, JavaCastApi.class, "toBoolean");
		Import(boolean.class, JavaCastApi.class, "toBoolean");
		Import(Object.class, JavaCastApi.class, "toByte");
		Import(long.class, JavaCastApi.class, "toByte");
		Import(Object.class, JavaCastApi.class, "toShort");
		Import(long.class, JavaCastApi.class, "toShort");
		Import(Object.class, JavaCastApi.class, "toInteger");
		Import(long.class, JavaCastApi.class, "toInteger");
		Import(Object.class, JavaCastApi.class, "toLong");
		Import(byte.class, JavaCastApi.class,  "toLong");
		Import(short.class, JavaCastApi.class, "toLong");
		Import(int.class, JavaCastApi.class, "toLong");
		Import(long.class, JavaCastApi.class, "toLong");
		Import(Object.class, JavaCastApi.class, "toFloat");
		Import(double.class, JavaCastApi.class, "toFloat");
		Import(Object.class, JavaCastApi.class, "toDouble");
		Import(double.class, JavaCastApi.class, "toDouble");

		Import(boolean.class, JavaCastApi.class, "toString");
		Import(Boolean.class, JavaCastApi.class, "toString");
		Import(long.class, JavaCastApi.class, "toString");
		Import(Long.class, JavaCastApi.class, "toString");
		Import(double.class, JavaCastApi.class, "toString");
		Import(Double.class, JavaCastApi.class, "toString");

		Import(JavaOperatorApi.class, "ThrowError", String.class);
		Import(JavaOperatorApi.class, "GetField", Object.class, String.class);
		Import(JavaOperatorApi.class, "SetField", Object.class, String.class, Object.class);
		Import(JavaOperatorApi.class, "InvokeUnresolvedMethod", Object.class, String.class, Object[].class);
	}

	static void Import(Class<?> BaseClass, String Name, Class<?> ... T1) {
		try {
			Method sMethod = BaseClass.getMethod(Name, T1);
			MethodMap.put(Name, sMethod);
		} catch (Exception e) {
			System.err.println("FIXME:" + e);
		}
	}

	static String BinaryKey(ZType T1, String Op, ZType T2) {
		return T1.GetUniqueName()+Op+T2.GetUniqueName();
	}
	static String UnaryKey(String Op, ZType T2) {
		return Op+T2.GetUniqueName();
	}
	static String CastKey(Class<?> T1, Class<?> T2) {
		return T1.getCanonicalName() + ":" + T2.getCanonicalName();
	}
	static void Import(ZType T1, String Op, ZType T2, Class<?> BaseClass, String Name) {
		try {
			Method sMethod = BaseClass.getMethod(Name, JavaTypeTable.GetJavaClass(T1, null), JavaTypeTable.GetJavaClass(T2, null));
			MethodMap.put(BinaryKey(T1, Op, T2), sMethod);
		} catch (Exception e) {
			System.err.println("FIXME:" + e);
		}
	}
	static void Import(ZType T1, String Op, ZType T2, Class<?> BaseClass, String Name, Class<?> T3) {
		try {
			Method sMethod = BaseClass.getMethod(Name, JavaTypeTable.GetJavaClass(T1, null), JavaTypeTable.GetJavaClass(T2, null), T3);
			MethodMap.put(BinaryKey(T1, Op, T2), sMethod);
		} catch (Exception e) {
			System.err.println("FIXME:" + e);
		}
	}
	static void Import(String Op, ZType T1, Class<?> BaseClass, String Name) {
		try {
			Method sMethod = BaseClass.getMethod(Name, JavaTypeTable.GetJavaClass(T1, null));
			MethodMap.put(UnaryKey(Op, T1), sMethod);
		} catch (Exception e) {
			System.err.println("FIXME:" + e);
		}
	}
	static void Import(Class<?> T1, Class<?> BaseClass, String Name) {
		try {
			Method sMethod = BaseClass.getMethod(Name, T1);
			MethodMap.put(CastKey(sMethod.getReturnType(), T1), sMethod);
		} catch (Exception e) {
			System.err.println("FIXME:" + e);
		}
	}

	public static Method GetStaticMethod(String Name) {
		return MethodMap.get(Name);
	}

	public static Method GetBinaryStaticMethod(ZType T1, String Op, ZType T2) {
		Method sMethod = MethodMap.get(BinaryKey(T1, Op, T2));
		if(sMethod == null) {
			// if undefined Object "op" Object must be default
			sMethod = MethodMap.get(BinaryKey(ZType.VarType, Op, ZType.VarType));
		}
		return sMethod;
	}

	public static Method GetUnaryStaticMethod(String Op, ZType T2) {
		Method sMethod = MethodMap.get(UnaryKey(Op, T2));
		if(sMethod == null) {
			// if undefined Object "op" Object must be default
			sMethod = MethodMap.get(UnaryKey(Op, ZType.VarType));
		}
		return sMethod;
	}

	public static Method GetCastMethod(Class<?> T1, Class<?> T2) {
		Method sMethod = MethodMap.get(CastKey(T1, T2));
		if(sMethod == null) {
			// if undefined Object "op" Object must be default
			sMethod = MethodMap.get(CastKey(Object.class, T2));
		}
		return sMethod;
	}
}
