// ***************************************************************************
// Copyright (c) 2013-2014, Konoha project authors. All rights reserved.
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

//ifdef JAVA
package zen.lang;
import java.util.ArrayList;

import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.deps.ZenTypedObject;
import zen.parser.ZLogger;
import zen.parser.ZNameSpace;
import zen.type.ZFuncType;

public class ZSystem {
	public final static ZenMap<Integer>     SourceMap = new ZenMap<Integer>(null);
	public final static ArrayList<String>   SourceList = new ArrayList<String>();

	public final static ZenMap<Object>		ClassNameMap = new ZenMap<Object>(null);
	public final static ArrayList<ZType>  TypePools = new ArrayList<ZType>();
	public final static ArrayList<ZFunc>  FuncPools = new ArrayList<ZFunc>();

	public final static ZType		TopType = new ZType(ZTypeFlag.UniqueType, "var", null);
	public final static ZType		VarType = TopType;
	public final static ZType		VoidType = new ZType(ZTypeFlag.UniqueType, "void", null);
	public final static ZType		BooleanType = new ZType(ZTypeFlag.UniqueType, "boolean", TopType);
	public final static ZType		IntType = new ZType(ZTypeFlag.UniqueType, "int", TopType);
	public final static ZType     FloatType = new ZType(ZTypeFlag.UniqueType, "float", TopType);
	public final static ZType		StringType = new ZType(ZTypeFlag.UniqueType, "String", TopType);
	//	public final static ZenType		AnyType = new ZenType(UniqueType|DynamicType, "any", TopType);
	public final static ZType     TypeType = new ZType(ZTypeFlag.UniqueType, "Type", TopType);
	public final static ZType		ArrayType = new ZGeneric1Type(ZTypeFlag.UniqueType, "Array", null, VarType);
	public final static ZType		MapType = new ZGeneric1Type(ZTypeFlag.UniqueType, "Map", null, VarType);

	public final static ZType		FuncType  = new ZFuncType("Func", null);

	public final static long GetFileLine(String FileName, int Line) {
		@Var Object IdOrNull = ZSystem.SourceMap.GetOrNull(FileName);
		@Var Integer Id = IdOrNull == null ? -1 : (Integer)IdOrNull;
		if(IdOrNull == null) {
			ZSystem.SourceList.add(FileName);
			Id = ZSystem.SourceList.size();
			ZSystem.SourceMap.put(FileName, Id);
		}
		return LibZen.JoinIntId(Id, Line);
	}

	public final static String GetSourceFileName(long FileLine) {
		@Var int FileId = LibZen.UpperId(FileLine);
		return (FileId == 0) ? null : ZSystem.SourceList.get(FileId - 1);
	}

	public final static int GetFileLineNumber(long FileLine) {
		return LibZen.LowerId(FileLine);
	}

	public final static String FormatFileLineNumber(long FileLine) {
		@Var int FileId = LibZen.UpperId(FileLine);
		@Var int Line = LibZen.LowerId(FileLine);
		@Var String FileName = (FileId == 0) ? "eval" : ZSystem.SourceList.get(FileId - 1);
		return "(" + FileName + ":" + Line + ")";
	}

	private static boolean IsInit = false;

	public final static void InitNameSpace(ZNameSpace NameSpace) {
		//ifdef JAVA
		if(!ZSystem.IsInit) {
			ZSystem.SetTypeTable("org.ZenScript.ZenTopObject", ZSystem.TopType);
			ZSystem.SetTypeTable("void",    ZSystem.VoidType);
			//			ZenSystem.SetTypeTable("java.lang.Object",  ZenSystem.AnyType);
			ZSystem.SetTypeTable("boolean", ZSystem.BooleanType);
			ZSystem.SetTypeTable("java.lang.Boolean", ZSystem.BooleanType);
			ZSystem.SetTypeTable("long",    ZSystem.IntType);
			ZSystem.SetTypeTable("java.lang.Long",    ZSystem.IntType);
			ZSystem.SetTypeTable("java.lang.String",  ZSystem.StringType);
			ZSystem.SetTypeTable("org.ZenScript.ZenType", ZSystem.TypeType);
			//			ZenTypeSystem.SetNativeTypeName("org.ZenScript.ZenEnum", ZenTypeSystem.EnumBaseType);
			ZSystem.SetTypeTable("org.ZenScript.ZenArray", ZSystem.ArrayType);
			ZSystem.SetTypeTable("org.ZenScript.Konoha.ZenIntArray", ZSystem.GetGenericType1(ZSystem.ArrayType, ZSystem.IntType, true));
			ZSystem.SetTypeTable("double",    ZSystem.FloatType);
			ZSystem.SetTypeTable("java.lang.Double",  ZSystem.FloatType);
			//			ZenTypeSystem.SetNativeTypeName("java.util.Iterator",  ZenTypeSystem.IteratorType);
			ZSystem.IsInit = true;
		}
		//		NameSpace.AppendTypeName(ZenSystem.VarType, null);
		NameSpace.AppendTypeName(ZSystem.VoidType,  null);
		NameSpace.AppendTypeName(ZSystem.BooleanType, null);
		NameSpace.AppendTypeName(ZSystem.IntType, null);
		NameSpace.AppendTypeName(ZSystem.FloatType, null);
		NameSpace.AppendTypeName(ZSystem.StringType, null);
		//		NameSpace.AppendTypeName(ZenSystem.AnyType, null);
		NameSpace.AppendTypeName(ZSystem.TypeType, null);
		NameSpace.AppendTypeName(ZSystem.ArrayType, null);
		NameSpace.AppendTypeName(ZSystem.FuncType, null);
		//		NameSpace.AppendTypeName(ZenTypeSystem.IteratorType, null);
		//endif VAJA
	}

	public static int IssueTypeId(ZType Type) {
		@Var int TypeId = ZSystem.TypePools.size();
		ZSystem.TypePools.add(Type);
		return TypeId;
	}

	public final static ZType GetTypeById(int TypeId) {
		return ZSystem.TypePools.get(TypeId);
	}

	public final static ZType LookupTypeTable(String Key) {
		return (ZType) ZSystem.ClassNameMap.GetOrNull(Key);
	}

	public final static void SetTypeTable(String Key, ZType Type) {
		ZSystem.ClassNameMap.put(Key, Type);
		ZLogger.VerboseLog(ZLogger.VerboseSymbol, "global type name: " + Key + ", " + Type);
	}


	public final static ZType GetNativeTypeOfValue(Object Value) {
		return LibNative.GetNativeType(LibNative.GetClassOfValue(Value));
	}

	public final static ZType GuessType (Object Value) {
		if(Value instanceof ZFunc) {
			return ((ZFunc)Value).GetFuncType();
		}
		else if(Value instanceof ZFuncSet) {
			return ZSystem.FuncType;
		}
		else if(Value instanceof ZenTypedObject) {
			// FIXME In typescript, we cannot use ZenObject
			return ((ZenTypedObject)Value).GetObjectType();
		}
		else {
			return ZSystem.GetNativeTypeOfValue(Value);
		}
	}

	public final static String MangleType2(ZType Type1, ZType Type2) {
		return ":" + Type1.TypeId + ":" + Type2.TypeId;
	}

	public final static String MangleTypes(int BaseIdx, ArrayList<ZType> TypeList) {
		@Var String s = "";
		for(@Var int i = BaseIdx; i < LibZen.ListSize(TypeList); i = i + 1) {
			@Var ZType Type = TypeList.get(i);
			s = s + ":" + Type.TypeId;
		}
		return s;
	}

	public final static ZType[] UniqueTypes(int BaseIdx, ArrayList<ZType> TypeList) {
		@Var String MangleName = "[]" + ZSystem.MangleTypes(BaseIdx, TypeList);
		@Var ZType[] Types = (ZType[])ZSystem.ClassNameMap.GetOrNull(MangleName);
		if(Types == null) {
			Types = LibZen.CompactTypeList(BaseIdx, TypeList);
			ZSystem.ClassNameMap.put(MangleName, Types);
		}
		return Types;
	}

	public final static ZType GetGenericType1(ZType BaseType, ZType ParamType, boolean IsCreation) {
		@Var String MangleName = ZSystem.MangleType2(BaseType, ParamType);
		@Var ZType GenericType = (ZType)ZSystem.ClassNameMap.GetOrNull(MangleName);
		if((GenericType == null) && IsCreation) {
			@Var String Name = BaseType.ShortName + "<" + ParamType + ">";
			if(BaseType.IsArrayType()) {
				Name = BaseType.ShortName + "<" + ParamType + ">";
			}
			GenericType = new ZGeneric1Type(ZTypeFlag.UniqueType, Name, BaseType, ParamType);
			ZSystem.SetTypeTable(MangleName, GenericType);
		}
		return GenericType;
	}

	public final static ZType GetGenericType(ZType BaseType, int BaseIdx, ArrayList<ZType> TypeList, boolean IsCreation) {
		assert(BaseType.GetParamSize() > 0);
		if(TypeList.size() - BaseIdx == 1 && !BaseType.IsFuncType()) {
			return ZSystem.GetGenericType1(BaseType, TypeList.get(BaseIdx), IsCreation);
		}
		@Var String MangleName = ":" + BaseType.TypeId + ZSystem.MangleTypes(BaseIdx, TypeList);
		@Var ZType GenericType = (ZType)ZSystem.ClassNameMap.GetOrNull(MangleName);
		if((GenericType == null) && IsCreation) {
			@Var String ShortName = BaseType.ShortName + "<";
			for(@Var int i = BaseIdx; i < LibZen.ListSize(TypeList); i += 1) {
				ShortName = ShortName + TypeList.get(i).GetRealType().ShortName;
				if(i + 1 == LibZen.ListSize(TypeList)) {
					ShortName = ShortName + ">";
				}
				else {
					ShortName = ShortName + ",";
				}
			}
			if(BaseType.IsFuncType()) {
				GenericType = new ZFuncType(ShortName, ZSystem.UniqueTypes(BaseIdx, TypeList));
			}
			else {
				throw new RuntimeException("TODO: Make ZenGenericType");
			}
			ZSystem.SetTypeTable(MangleName, GenericType);
		}
		return GenericType;
	}

	//	private final String SubtypeKey(ZenType FromType, ZenType ToType) {
	//		return FromType.GetUniqueName() + "<" + ToType.GetUniqueName();
	//	}

	public final static boolean CheckSubType(ZType SubType, ZType SuperType) {
		// TODO: Structual Typing database
		return false;
	}

	public final static ZFunc GetFuncById(int FuncId) {
		return ZSystem.FuncPools.get(FuncId);
	}

	public static ZFunc GetConverterFunc(ZType ValueType, ZType CastType, boolean SearchRecursive) {
		// TODO Auto-generated method stub
		return null;
	}

	// ConstPool
	private static final ArrayList<Object> ConstPoolList = new ArrayList<Object>();

	public static int AddConstPool(Object o) {
		@Var int PooledId = ZSystem.ConstPoolList.indexOf(o);
		if(PooledId != -1) {
			return PooledId;
		}
		else {
			ZSystem.ConstPoolList.add(o);
			return ZSystem.ConstPoolList.size() - 1;
		}
	}

	public static Object GetConstPool(int PooledId) {
		return ZSystem.ConstPoolList.get(PooledId);
	}


	public static ZFuncType LookupFuncType(ArrayList<ZType> TypeList) {
		return (ZFuncType)ZSystem.GetGenericType(ZSystem.FuncType, 0, TypeList, true);
	}


}
