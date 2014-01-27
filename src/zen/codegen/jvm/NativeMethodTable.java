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

import zen.deps.NativeTypeTable;
import zen.lang.ZSystem;
import zen.lang.ZType;

public class NativeMethodTable {
	static HashMap<String, Method> MethodMap = new HashMap<String,Method>();
	static {
		Import("!", ZSystem.VarType, OpApi.class, "Not");
		Import("+", ZSystem.VarType, OpApi.class, "Plus");
		Import("-", ZSystem.VarType, OpApi.class, "Minus");
		Import("~", ZSystem.VarType, OpApi.class, "BitwiseNot");
		Import(ZSystem.VarType, "+", ZSystem.VarType, OpApi.class, "Add");
		Import(ZSystem.VarType, "-", ZSystem.VarType, OpApi.class, "Sub");
		Import(ZSystem.VarType, "*", ZSystem.VarType, OpApi.class, "Mul");
		Import(ZSystem.VarType, "/", ZSystem.VarType, OpApi.class, "Div");
		Import(ZSystem.VarType, "%", ZSystem.VarType, OpApi.class, "Mod");
		Import(ZSystem.VarType, "==", ZSystem.VarType, OpApi.class, "Equals");
		Import(ZSystem.VarType, "!=", ZSystem.VarType, OpApi.class, "NotEquals");
		Import(ZSystem.VarType, "<", ZSystem.VarType, OpApi.class, "LessThan");
		Import(ZSystem.VarType, "<=", ZSystem.VarType, OpApi.class, "LessThanEquals");
		Import(ZSystem.VarType, ">", ZSystem.VarType, OpApi.class, "GreaterThan");
		Import(ZSystem.VarType, ">=", ZSystem.VarType, OpApi.class, "GreaterThanEquals");
		Import(ZSystem.VarType, "&", ZSystem.VarType, OpApi.class, "BitwiseAnd");
		Import(ZSystem.VarType, "|", ZSystem.VarType, OpApi.class, "BitwiseOr");
		Import(ZSystem.VarType, "^", ZSystem.VarType, OpApi.class, "BitwiseXor");
		Import(ZSystem.VarType, "<<", ZSystem.VarType, OpApi.class, "LeftShift");
		Import(ZSystem.VarType, ">>", ZSystem.VarType, OpApi.class, "RightShift");

		Import("!", ZSystem.BooleanType, OpApi.class, "Not");
		Import("+", ZSystem.IntType, OpApi.class, "Plus");
		Import("-", ZSystem.IntType, OpApi.class, "Minus");
		Import("~", ZSystem.IntType, OpApi.class, "BitwiseNot");
		Import(ZSystem.IntType, "+", ZSystem.IntType, OpApi.class, "Add");
		Import(ZSystem.IntType, "-", ZSystem.IntType, OpApi.class, "Sub");
		Import(ZSystem.IntType, "*", ZSystem.IntType, OpApi.class, "Mul");
		Import(ZSystem.IntType, "/", ZSystem.IntType, OpApi.class, "Div");
		Import(ZSystem.IntType, "%", ZSystem.IntType, OpApi.class, "Mod");
		Import(ZSystem.IntType, "==", ZSystem.IntType, OpApi.class, "Equals");
		Import(ZSystem.IntType, "!=", ZSystem.IntType, OpApi.class, "NotEquals");
		Import(ZSystem.IntType, "<", ZSystem.IntType, OpApi.class, "LessThan");
		Import(ZSystem.IntType, "<=", ZSystem.IntType, OpApi.class, "LessThanEquals");
		Import(ZSystem.IntType, ">", ZSystem.IntType, OpApi.class, "GreaterThan");
		Import(ZSystem.IntType, ">=", ZSystem.IntType, OpApi.class, "GreaterThanEquals");
		Import(ZSystem.IntType, "&", ZSystem.IntType, OpApi.class, "BitwiseAnd");
		Import(ZSystem.IntType, "|", ZSystem.IntType, OpApi.class, "BitwiseOr");
		Import(ZSystem.IntType, "^", ZSystem.IntType, OpApi.class, "BitwiseXor");
		Import(ZSystem.IntType, "<<", ZSystem.IntType, OpApi.class, "LeftShift");
		Import(ZSystem.IntType, ">>", ZSystem.IntType, OpApi.class, "RightShift");

		Import("+", ZSystem.FloatType, OpApi.class, "Plus");
		Import("-", ZSystem.FloatType, OpApi.class, "Minus");
		Import(ZSystem.FloatType, "+", ZSystem.FloatType, OpApi.class, "Add");
		Import(ZSystem.FloatType, "-", ZSystem.FloatType, OpApi.class, "Sub");
		Import(ZSystem.FloatType, "*", ZSystem.FloatType, OpApi.class, "Mul");
		Import(ZSystem.FloatType, "/", ZSystem.FloatType, OpApi.class, "Div");
		Import(ZSystem.FloatType, "%", ZSystem.FloatType, OpApi.class, "Mod");
		Import(ZSystem.FloatType, "==", ZSystem.FloatType, OpApi.class, "Equals");
		Import(ZSystem.FloatType, "!=", ZSystem.FloatType, OpApi.class, "NotEquals");
		Import(ZSystem.FloatType, "<", ZSystem.FloatType, OpApi.class, "LessThan");
		Import(ZSystem.FloatType, "<=", ZSystem.FloatType, OpApi.class, "LessThanEquals");
		Import(ZSystem.FloatType, ">", ZSystem.FloatType, OpApi.class, "GreaterThan");
		Import(ZSystem.FloatType, ">=", ZSystem.FloatType, OpApi.class, "GreaterThanEquals");

		Import(ZSystem.StringType, "+", ZSystem.StringType, OpApi.class, "Add");
		Import(ZSystem.StringType, "==", ZSystem.StringType, OpApi.class, "Equals");
		Import(ZSystem.StringType, "!=", ZSystem.StringType, OpApi.class, "NotEquals");

		Import(boolean.class, CastApi.class, "toObject");
		Import(byte.class, CastApi.class, "toObject");
		Import(short.class, CastApi.class, "toObject");
		Import(int.class, CastApi.class, "toObject");
		Import(long.class, CastApi.class, "toObject");
		Import(float.class, CastApi.class, "toObject");
		Import(double.class, CastApi.class, "toObject");

		Import(Object.class, CastApi.class, "toboolean");
		Import(Boolean.class, CastApi.class, "toboolean");
		Import(Object.class, CastApi.class, "tobyte");
		Import(long.class, CastApi.class, "tobyte");
		Import(Object.class, CastApi.class, "toshort");
		Import(long.class, CastApi.class, "toshort");
		Import(Object.class, CastApi.class, "toint");
		Import(long.class, CastApi.class, "toint");
		Import(Object.class, CastApi.class, "tolong");
		Import(byte.class, CastApi.class,  "tolong");
		Import(short.class, CastApi.class, "tolong");
		Import(int.class, CastApi.class, "tolong");
		Import(double.class, CastApi.class, "tolong");
		Import(Byte.class, CastApi.class,  "tolong");
		Import(Short.class, CastApi.class, "tolong");
		Import(Integer.class, CastApi.class, "tolong");
		Import(Long.class, CastApi.class, "tolong");
		Import(Object.class, CastApi.class, "tofloat");
		Import(double.class, CastApi.class, "tofloat");
		Import(Object.class, CastApi.class, "todouble");
		Import(long.class, CastApi.class, "todouble");
		Import(float.class, CastApi.class, "todouble");
		Import(Float.class, CastApi.class, "todouble");
		Import(Double.class, CastApi.class, "todouble");

		Import(Object.class, CastApi.class, "toBoolean");
		Import(boolean.class, CastApi.class, "toBoolean");
		Import(Object.class, CastApi.class, "toByte");
		Import(long.class, CastApi.class, "toByte");
		Import(Object.class, CastApi.class, "toShort");
		Import(long.class, CastApi.class, "toShort");
		Import(Object.class, CastApi.class, "toInteger");
		Import(long.class, CastApi.class, "toInteger");
		Import(Object.class, CastApi.class, "toLong");
		Import(byte.class, CastApi.class,  "toLong");
		Import(short.class, CastApi.class, "toLong");
		Import(int.class, CastApi.class, "toLong");
		Import(long.class, CastApi.class, "toLong");
		Import(Object.class, CastApi.class, "toFloat");
		Import(double.class, CastApi.class, "toFloat");
		Import(Object.class, CastApi.class, "toDouble");
		Import(double.class, CastApi.class, "toDouble");

		Import(OpApi.class, "ThrowError", String.class);
		Import(OpApi.class, "GetField", Object.class, String.class);
		Import(OpApi.class, "SetField", Object.class, String.class, Object.class);
		Import(OpApi.class, "InvokeUnresolvedMethod", Object.class, String.class, Object[].class);
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
			Method sMethod = BaseClass.getMethod(Name, NativeTypeTable.GetJavaClass(T1), NativeTypeTable.GetJavaClass(T2));
			MethodMap.put(BinaryKey(T1, Op, T2), sMethod);
		} catch (Exception e) {
			System.err.println("FIXME:" + e);
		}
	}
	static void Import(String Op, ZType T1, Class<?> BaseClass, String Name) {
		try {
			Method sMethod = BaseClass.getMethod(Name, NativeTypeTable.GetJavaClass(T1));
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
			sMethod = MethodMap.get(BinaryKey(ZSystem.VarType, Op, ZSystem.VarType));
		}
		return sMethod;
	}

	public static Method GetUnaryStaticMethod(String Op, ZType T2) {
		Method sMethod = MethodMap.get(UnaryKey(Op, T2));
		if(sMethod == null) {
			// if undefined Object "op" Object must be default
			sMethod = MethodMap.get(UnaryKey(Op, ZSystem.VarType));
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
