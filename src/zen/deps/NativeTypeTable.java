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

package zen.deps;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;

import zen.lang.ZFunc;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypePool;

public class NativeTypeTable {
	static HashMap<String, Class<?>> ClassMap = new HashMap<String,Class<?>>();
	static HashMap<String, ZType> TypeMap = new HashMap<String,ZType>();
	static {
		NativeTypeTable.SetTypeTable(ZType.VarType, Object.class);
		NativeTypeTable.SetTypeTable(ZType.VoidType, void.class);
		NativeTypeTable.SetTypeTable(ZType.BooleanType, boolean.class);
		NativeTypeTable.SetTypeTable(ZType.IntType, long.class);
		NativeTypeTable.SetTypeTable(ZType.FloatType, double.class);
		NativeTypeTable.SetTypeTable(ZType.StringType, String.class);
		NativeTypeTable.SetTypeTable(ZType.FuncType, ZFunc.class);
		NativeTypeTable.SetTypeTable(ZType.ArrayType, ZenArray.class);
		NativeTypeTable.SetTypeTable(ZType.MapType, ZenMap.class);

		NativeTypeTable.SetTypeTable(ZType.BooleanType, Boolean.class);
		NativeTypeTable.SetTypeTable(ZType.IntType, Long.class);
		NativeTypeTable.SetTypeTable(ZType.FloatType, Double.class);
		NativeTypeTable.SetTypeTable(ZType.IntType, int.class);
		NativeTypeTable.SetTypeTable(ZType.IntType, Integer.class);
		NativeTypeTable.SetTypeTable(ZType.IntType, short.class);
		NativeTypeTable.SetTypeTable(ZType.IntType, Short.class);
		NativeTypeTable.SetTypeTable(ZType.IntType, byte.class);
		NativeTypeTable.SetTypeTable(ZType.IntType, Byte.class);
		NativeTypeTable.SetTypeTable(ZType.FloatType, float.class);
		NativeTypeTable.SetTypeTable(ZType.FloatType, Float.class);
		NativeTypeTable.SetTypeTable(ZType.StringType, char.class);
		NativeTypeTable.SetTypeTable(ZType.StringType, Character.class);
	}

	public static void SetTypeTable(ZType zType, Class<?> c) {
		if(NativeTypeTable.GetJavaClass(zType) == null) {
			NativeTypeTable.ClassMap.put(zType.GetUniqueName(), c);
		}
		NativeTypeTable.TypeMap.put(c.getCanonicalName(), zType);
	}

	public static Class<?> GetJavaClass(ZType zType) {
		return NativeTypeTable.ClassMap.get(zType.GetUniqueName());
	}

	public static ZType GetZenType(Class<?> JavaClass) {
		ZType NativeType = NativeTypeTable.TypeMap.get(JavaClass.getCanonicalName());
		if (NativeType == null) {
			NativeType = new ZNativeType(JavaClass);
			NativeTypeTable.SetTypeTable(NativeType, JavaClass);
		}
		return NativeType;
	}

	public final static ZFuncType ConvertToFuncType(Method JMethod) {
		@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
		TypeList.add(NativeTypeTable.GetZenType(JMethod.getReturnType()));
		if (!Modifier.isStatic(JMethod.getModifiers())) {
			TypeList.add(NativeTypeTable.GetZenType(JMethod.getDeclaringClass()));
		}
		@Var Class<?>[] ParamTypes = JMethod.getParameterTypes();
		if (ParamTypes != null) {
			@Var int j = 0;
			while(j < ParamTypes.length) {
				TypeList.add(NativeTypeTable.GetZenType(ParamTypes[j]));
				j = j + 1;
			}
		}
		return ZTypePool.LookupFuncType(TypeList);
	}

}
