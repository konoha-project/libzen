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
import java.lang.reflect.Modifier;
import java.util.HashMap;

import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZArray;
import zen.deps.ZFloatArray;
import zen.deps.ZFunction;
import zen.deps.ZIntArray;
import zen.deps.ZNativeType;
import zen.deps.ZObjectArray;
import zen.deps.ZStringArray;
import zen.deps.ZenMap;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypePool;

public class JavaTypeTable {
	static HashMap<String, Class<?>> ClassMap = new HashMap<String,Class<?>>();
	static HashMap<String, ZType> TypeMap = new HashMap<String,ZType>();

	static {
		JavaTypeTable.SetTypeTable(ZType.VarType, Object.class);
		JavaTypeTable.SetTypeTable(ZType.VoidType, void.class);
		JavaTypeTable.SetTypeTable(ZType.BooleanType, boolean.class);
		JavaTypeTable.SetTypeTable(ZType.IntType, long.class);
		JavaTypeTable.SetTypeTable(ZType.FloatType, double.class);
		JavaTypeTable.SetTypeTable(ZType.StringType, String.class);
		JavaTypeTable.SetTypeTable(ZType.FuncType, ZFunction.class);
		JavaTypeTable.SetTypeTable(ZType.ArrayType, ZObjectArray.class);
		JavaTypeTable.SetTypeTable(ZType.MapType, ZenMap.class);

		ZType IntArrayType = ZTypePool.GetGenericType1(ZType.ArrayType, ZType.IntType);
		ZType FloatArrayType = ZTypePool.GetGenericType1(ZType.ArrayType, ZType.FloatType);
		ZType StringArrayType = ZTypePool.GetGenericType1(ZType.ArrayType, ZType.StringType);
		JavaTypeTable.SetTypeTable(IntArrayType, ZIntArray.class);
		JavaTypeTable.SetTypeTable(FloatArrayType, ZFloatArray.class);
		JavaTypeTable.SetTypeTable(StringArrayType, ZStringArray.class);

		JavaTypeTable.SetTypeTable(ZType.BooleanType, Boolean.class);
		JavaTypeTable.SetTypeTable(ZType.IntType, Long.class);
		JavaTypeTable.SetTypeTable(ZType.FloatType, Double.class);
		JavaTypeTable.SetTypeTable(ZType.IntType, int.class);
		JavaTypeTable.SetTypeTable(ZType.IntType, Integer.class);
		JavaTypeTable.SetTypeTable(ZType.IntType, short.class);
		JavaTypeTable.SetTypeTable(ZType.IntType, Short.class);
		JavaTypeTable.SetTypeTable(ZType.IntType, byte.class);
		JavaTypeTable.SetTypeTable(ZType.IntType, Byte.class);
		JavaTypeTable.SetTypeTable(ZType.FloatType, float.class);
		JavaTypeTable.SetTypeTable(ZType.FloatType, Float.class);
		JavaTypeTable.SetTypeTable(ZType.StringType, char.class);
		JavaTypeTable.SetTypeTable(ZType.StringType, Character.class);
	}

	public static void SetTypeTable(ZType zType, Class<?> c) {
		if(JavaTypeTable.ClassMap.get(zType.GetUniqueName()) == null) {
			JavaTypeTable.ClassMap.put(zType.GetUniqueName(), c);
		}
		JavaTypeTable.TypeMap.put(c.getCanonicalName(), zType);
	}

	public static Class<?> GetJavaClass(ZType zType, Class<?> Default) {
		Class<?> jClass = JavaTypeTable.ClassMap.get(zType.GetUniqueName());
		if(jClass == null) {
			jClass = JavaTypeTable.ClassMap.get(zType.GetBaseType().GetUniqueName());
			if(jClass == null) {
				jClass = Default;
			}
		}
		return jClass;
	}

	public static ZType GetZenType(Class<?> JavaClass) {
		ZType NativeType = JavaTypeTable.TypeMap.get(JavaClass.getCanonicalName());
		if (NativeType == null) {
			NativeType = new ZNativeType(JavaClass);
			JavaTypeTable.SetTypeTable(NativeType, JavaClass);
		}
		return NativeType;
	}

	public final static ZFuncType ConvertToFuncType(Method JMethod) {
		@Var Class<?>[] ParamTypes = JMethod.getParameterTypes();
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[LibZen._Size(ParamTypes) + 2]);
		TypeList.add(JavaTypeTable.GetZenType(JMethod.getReturnType()));
		if (!Modifier.isStatic(JMethod.getModifiers())) {
			TypeList.add(JavaTypeTable.GetZenType(JMethod.getDeclaringClass()));
		}
		if (ParamTypes != null) {
			@Var int j = 0;
			while(j < ParamTypes.length) {
				TypeList.add(JavaTypeTable.GetZenType(ParamTypes[j]));
				j = j + 1;
			}
		}
		return ZTypePool.LookupFuncType(TypeList);
	}

	public final static ZFuncType FuncType(Class<?> ReturnT, Class<?> ... paramsT) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[10]);
		TypeList.add(JavaTypeTable.GetZenType(ReturnT));
		for(Class<?> C : paramsT) {
			TypeList.add(JavaTypeTable.GetZenType(C));
		}
		return ZTypePool.LookupFuncType(TypeList);
	}

}
