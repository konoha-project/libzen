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
import zen.parser.ZenLogger;
import zen.parser.ZenNameSpace;

public class ZenSystem implements ZenTypeConst {
	public final static ZenMap<Integer>     SourceMap = new ZenMap<Integer>(null);
	public final static ArrayList<String>   SourceList = new ArrayList<String>();

	public final static ZenMap<Object>		ClassNameMap = new ZenMap<Object>(null);
	public final static ArrayList<ZenType>  TypePools = new ArrayList<ZenType>();
	public final static ArrayList<ZenFunc>  FuncPools = new ArrayList<ZenFunc>();

	public final static ZenType		TopType = new ZenType(UniqueType, "var", null);
	public final static ZenType		VarType = TopType;
	public final static ZenType		VoidType = new ZenType(UniqueType, "void", null);
	public final static ZenType		BooleanType = new ZenType(UniqueType|UnboxType, "boolean", TopType);
	public final static ZenType		IntType = new ZenType(UniqueType|UnboxType, "int", TopType);
	public final static ZenType     FloatType = new ZenType(UniqueType|UnboxType, "float", TopType);
	public final static ZenType		StringType = new ZenType(UniqueType, "String", TopType);
	public final static ZenType		AnyType = new ZenType(UniqueType|DynamicType, "any", TopType);
	public final static ZenType     TypeType = new ZenType(UniqueType, "Type", TopType);
	public final static ZenType		ArrayType = new ZenGeneric1Type(UniqueType, "Array", null, VarType);
	public final static ZenType		MapType = new ZenGeneric1Type(UniqueType, "Map", null, VarType);

	public final static ZenType		FuncType  = new ZenFuncType("Func", null);

	public final static long GetFileLine(String FileName, int Line) {
		@Var Object IdOrNull = ZenSystem.SourceMap.GetOrNull(FileName);
		@Var Integer Id = IdOrNull == null ? -1 : (/*cast*/Integer)IdOrNull;
		if(IdOrNull == null) {
			ZenSystem.SourceList.add(FileName);
			Id = ZenSystem.SourceList.size();
			ZenSystem.SourceMap.put(FileName, Id);
		}
		return LibZen.JoinIntId(Id, Line);
	}

	public final static String GetSourceFileName(long FileLine) {
		@Var int FileId = LibZen.UpperId(FileLine);
		return (FileId == 0) ? null : ZenSystem.SourceList.get(FileId - 1);
	}

	public final static int GetFileLineNumber(long FileLine) {
		return LibZen.LowerId(FileLine);
	}

	public final static String FormatFileLineNumber(long FileLine) {
		@Var int FileId = LibZen.UpperId(FileLine);
		@Var int Line = LibZen.LowerId(FileLine);
		@Var String FileName = (FileId == 0) ? "eval" : ZenSystem.SourceList.get(FileId - 1);
		return "(" + FileName + ":" + Line + ")";
	}

	private static boolean IsInit = false;

	public final static void InitNameSpace(ZenNameSpace NameSpace) {
		//ifdef JAVA
		if(!ZenSystem.IsInit) {
			ZenSystem.SetTypeTable("org.ZenScript.ZenTopObject", ZenSystem.TopType);
			ZenSystem.SetTypeTable("void",    ZenSystem.VoidType);
			ZenSystem.SetTypeTable("java.lang.Object",  ZenSystem.AnyType);
			ZenSystem.SetTypeTable("boolean", ZenSystem.BooleanType);
			ZenSystem.SetTypeTable("java.lang.Boolean", ZenSystem.BooleanType);
			ZenSystem.SetTypeTable("long",    ZenSystem.IntType);
			ZenSystem.SetTypeTable("java.lang.Long",    ZenSystem.IntType);
			ZenSystem.SetTypeTable("java.lang.String",  ZenSystem.StringType);
			ZenSystem.SetTypeTable("org.ZenScript.ZenType", ZenSystem.TypeType);
			//			ZenTypeSystem.SetNativeTypeName("org.ZenScript.ZenEnum", ZenTypeSystem.EnumBaseType);
			ZenSystem.SetTypeTable("org.ZenScript.ZenArray", ZenSystem.ArrayType);
			ZenSystem.SetTypeTable("org.ZenScript.Konoha.ZenIntArray", ZenSystem.GetGenericType1(ZenSystem.ArrayType, ZenSystem.IntType, true));
			ZenSystem.SetTypeTable("double",    ZenSystem.FloatType);
			ZenSystem.SetTypeTable("java.lang.Double",  ZenSystem.FloatType);
			//			ZenTypeSystem.SetNativeTypeName("java.util.Iterator",  ZenTypeSystem.IteratorType);
			ZenSystem.IsInit = true;
		}
		NameSpace.AppendTypeName(ZenSystem.VarType, null);
		NameSpace.AppendTypeName(ZenSystem.VoidType,  null);
		NameSpace.AppendTypeName(ZenSystem.BooleanType, null);
		NameSpace.AppendTypeName(ZenSystem.IntType, null);
		NameSpace.AppendTypeName(ZenSystem.FloatType, null);
		NameSpace.AppendTypeName(ZenSystem.StringType, null);
		NameSpace.AppendTypeName(ZenSystem.AnyType, null);
		NameSpace.AppendTypeName(ZenSystem.TypeType, null);
		NameSpace.AppendTypeName(ZenSystem.ArrayType, null);
		NameSpace.AppendTypeName(ZenSystem.FuncType, null);
		//		NameSpace.AppendTypeName(ZenTypeSystem.IteratorType, null);
		//endif VAJA
	}

	public static int IssueTypeId(ZenType Type) {
		@Var int TypeId = ZenSystem.TypePools.size();
		ZenSystem.TypePools.add(Type);
		return TypeId;
	}

	public final static ZenType GetTypeById(int TypeId) {
		return ZenSystem.TypePools.get(TypeId);
	}

	public final static ZenType LookupTypeTable(String Key) {
		return (/*cast*/ZenType) ZenSystem.ClassNameMap.GetOrNull(Key);
	}

	public final static void SetTypeTable(String Key, ZenType Type) {
		ZenSystem.ClassNameMap.put(Key, Type);
		ZenLogger.VerboseLog(ZenLogger.VerboseSymbol, "global type name: " + Key + ", " + Type);
	}


	public final static ZenType GetNativeTypeOfValue(Object Value) {
		return LibNative.GetNativeType(LibNative.GetClassOfValue(Value));
	}

	public final static ZenType GuessType (Object Value) {
		if(Value instanceof ZenFunc) {
			return ((/*cast*/ZenFunc)Value).GetFuncType();
		}
		else if(Value instanceof ZenFuncSet) {
			return ZenSystem.FuncType;
		}
		else if(Value instanceof ZenTypedObject) {
			// FIXME In typescript, we cannot use ZenObject
			return ((/*cast*/ZenTypedObject)Value).GetObjectType();
		}
		else {
			return ZenSystem.GetNativeTypeOfValue(Value);
		}
	}

	public final static String MangleType2(ZenType Type1, ZenType Type2) {
		return ":" + Type1.TypeId + ":" + Type2.TypeId;
	}

	public final static String MangleTypes(int BaseIdx, ArrayList<ZenType> TypeList) {
		@Var String s = "";
		for(@Var int i = BaseIdx; i < LibZen.ListSize(TypeList); i = i + 1) {
			@Var ZenType Type = TypeList.get(i);
			s = s + ":" + Type.TypeId;
		}
		return s;
	}

	public final static ZenType[] UniqueTypes(int BaseIdx, ArrayList<ZenType> TypeList) {
		@Var String MangleName = "[]" + ZenSystem.MangleTypes(BaseIdx, TypeList);
		@Var ZenType[] Types = (/*cast*/ZenType[])ZenSystem.ClassNameMap.GetOrNull(MangleName);
		if(Types == null) {
			Types = LibZen.CompactTypeList(BaseIdx, TypeList);
			ZenSystem.ClassNameMap.put(MangleName, Types);
		}
		return Types;
	}

	public final static ZenType GetGenericType1(ZenType BaseType, ZenType ParamType, boolean IsCreation) {
		@Var String MangleName = ZenSystem.MangleType2(BaseType, ParamType);
		@Var ZenType GenericType = (/*cast*/ZenType)ZenSystem.ClassNameMap.GetOrNull(MangleName);
		if((GenericType == null) && IsCreation) {
			@Var String Name = BaseType.ShortName + "<" + ParamType + ">";
			if(BaseType.IsArrayType()) {
				Name = BaseType.ShortName + "<" + ParamType + ">";
			}
			GenericType = new ZenGeneric1Type(UniqueType, Name, BaseType, ParamType);
			ZenSystem.SetTypeTable(MangleName, GenericType);
		}
		return GenericType;
	}

	public final static ZenType GetGenericType(ZenType BaseType, int BaseIdx, ArrayList<ZenType> TypeList, boolean IsCreation) {
		assert(BaseType.GetParamSize() > 0);
		if(TypeList.size() - BaseIdx == 1 && !BaseType.IsFuncType()) {
			return ZenSystem.GetGenericType1(BaseType, TypeList.get(BaseIdx), IsCreation);
		}
		@Var String MangleName = ":" + BaseType.TypeId + ZenSystem.MangleTypes(BaseIdx, TypeList);
		@Var ZenType GenericType = (/*cast*/ZenType)ZenSystem.ClassNameMap.GetOrNull(MangleName);
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
				GenericType = new ZenFuncType(ShortName, ZenSystem.UniqueTypes(BaseIdx, TypeList));
			}
			else {
				throw new RuntimeException("TODO: Make ZenGenericType");
			}
			ZenSystem.SetTypeTable(MangleName, GenericType);
		}
		return GenericType;
	}

	//	private final String SubtypeKey(ZenType FromType, ZenType ToType) {
	//		return FromType.GetUniqueName() + "<" + ToType.GetUniqueName();
	//	}

	public final static boolean CheckSubType(ZenType SubType, ZenType SuperType) {
		// TODO: Structual Typing database
		return false;
	}

	public final static ZenFunc GetFuncById(int FuncId) {
		return ZenSystem.FuncPools.get(FuncId);
	}

	public static ZenFunc GetConverterFunc(ZenType ValueType, ZenType CastType, boolean SearchRecursive) {
		// TODO Auto-generated method stub
		return null;
	}

	// ConstPool
	private static final ArrayList<Object> ConstPoolList = new ArrayList<Object>();

	public static int AddConstPool(Object o) {
		@Var int PooledId = ZenSystem.ConstPoolList.indexOf(o);
		if(PooledId != -1) {
			return PooledId;
		}
		else {
			ZenSystem.ConstPoolList.add(o);
			return ZenSystem.ConstPoolList.size() - 1;
		}
	}

	public static Object GetConstPool(int PooledId) {
		return ZenSystem.ConstPoolList.get(PooledId);
	}


	public static ZenFuncType LookupFuncType(ArrayList<ZenType> TypeList) {
		return (ZenFuncType)ZenSystem.GetGenericType(ZenSystem.FuncType, 0, TypeList, true);
	}


}
