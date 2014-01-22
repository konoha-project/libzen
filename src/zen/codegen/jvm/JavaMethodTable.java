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

import zen.lang.ZSystem;
import zen.lang.ZType;

public class JavaMethodTable {
	static HashMap<String, Method> MethodMap = new HashMap<String,Method>();
	static {
		Import("+", ZSystem.VarType, ZenVarApi.class, "Plus");
		Import("-", ZSystem.VarType, ZenVarApi.class, "Minus");
		Import("*", ZSystem.VarType, ZenVarApi.class, "BitwiseNot");
		Import(ZSystem.VarType, "+", ZSystem.VarType, ZenVarApi.class, "Add");
		Import(ZSystem.VarType, "-", ZSystem.VarType, ZenVarApi.class, "Sub");
		Import(ZSystem.VarType, "*", ZSystem.VarType, ZenVarApi.class, "Mul");
		Import(ZSystem.VarType, "/", ZSystem.VarType, ZenVarApi.class, "Div");
		Import(ZSystem.VarType, "%", ZSystem.VarType, ZenVarApi.class, "Mod");
		Import(ZSystem.VarType, "==", ZSystem.VarType, ZenVarApi.class, "Equals");
		Import(ZSystem.VarType, "!=", ZSystem.VarType, ZenVarApi.class, "NotEquals");
		Import(ZSystem.VarType, "<", ZSystem.VarType, ZenVarApi.class, "LessThan");
		Import(ZSystem.VarType, "<=", ZSystem.VarType, ZenVarApi.class, "LessThanEquals");
		Import(ZSystem.VarType, ">", ZSystem.VarType, ZenVarApi.class, "GreaterThan");
		Import(ZSystem.VarType, ">=", ZSystem.VarType, ZenVarApi.class, "GreaterThanEquals");
		Import(ZSystem.VarType, "&", ZSystem.VarType, ZenVarApi.class, "BitwiseAnd");
		Import(ZSystem.VarType, "|", ZSystem.VarType, ZenVarApi.class, "BitwiseOr");
		Import(ZSystem.VarType, "^", ZSystem.VarType, ZenVarApi.class, "BitwiseXor");
		Import(ZSystem.VarType, "<<", ZSystem.VarType, ZenVarApi.class, "LeftShift");
		Import(ZSystem.VarType, ">>", ZSystem.VarType, ZenVarApi.class, "RightShift");
		Import(boolean.class, ZenVarApi.class, "toObject");
		Import(long.class, ZenVarApi.class, "toObject");
		Import(double.class, ZenVarApi.class, "toObject");
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
			Method sMethod = BaseClass.getMethod(Name, JavaTypeTable.GetJClass(T1), JavaTypeTable.GetJClass(T2));
			MethodMap.put(BinaryKey(T1, Op, T2), sMethod);
		} catch (Exception e) {
			System.err.println("FIXME:" + e);
		}
	}
	static void Import(String Op, ZType T1, Class<?> BaseClass, String Name) {
		try {
			Method sMethod = BaseClass.getMethod(Name, JavaTypeTable.GetJClass(T1));
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

	static Method GetBinaryStaticMethod(ZType T1, String Op, ZType T2) {
		Method sMethod = MethodMap.get(BinaryKey(T1, Op, T2));
		if(sMethod != null) {
			// if undefined Object "op" Object must be default
			sMethod = MethodMap.get(BinaryKey(ZSystem.VarType, Op, ZSystem.VarType));
		}
		return sMethod;
	}

	static Method GetUnaryStaticMethod(String Op, ZType T2) {
		Method sMethod = MethodMap.get(UnaryKey(Op, T2));
		if(sMethod != null) {
			// if undefined Object "op" Object must be default
			sMethod = MethodMap.get(UnaryKey(Op, ZSystem.VarType));
		}
		return sMethod;
	}

	static Method GetCastMethod(Class<?> T1, Class<?> T2) {
		Method sMethod = MethodMap.get(CastKey(T1, T2));
		if(sMethod != null) {
			// if undefined Object "op" Object must be default
			sMethod = MethodMap.get(CastKey(Object.class, T2));
		}
		return sMethod;
	}


}
