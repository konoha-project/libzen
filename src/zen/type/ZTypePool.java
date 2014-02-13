package zen.type;

import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZArray;
import zen.deps.ZenMap;

public class ZTypePool {

	private final static ZArray<ZType>  TypeList = new ZArray<ZType>(new ZType[128]);
	private final static ZType[] GreekTypes = ZGreekType.NewGreekTypes(null);

	public final static int NewTypeId(ZType T) {
		@Var int TypeId = TypeList.size();
		TypeList.add(T);
		return TypeId;
	}

	public final static ZType TypeOf(int TypeId) {
		if(TypeId < ZTypePool.TypeList.size()) {
			return ZTypePool.TypeList.ArrayValues[TypeId];
		}
		return ZType.VarType;
	}

	public final static ZType GetGreekType(int GreekId) {
		if(ZTypePool.GreekTypes[GreekId] == null) {
			ZTypePool.GreekTypes[GreekId] = new ZGreekType(GreekId);
		}
		return ZTypePool.GreekTypes[GreekId];
	}

	private final static ZenMap<ZType>     ClassNameMap = new ZenMap<ZType>(null);
	private final static ZenMap<ZType[]>   UniqueTypeSetMap = new ZenMap<ZType[]>(null);

	private final static String MangleType2(ZType Type1, ZType Type2) {
		return ":" + Type1.TypeId + ":" + Type2.TypeId;
	}

	private final static String MangleTypes(ZArray<ZType> TypeList) {
		@Var String s = "";
		@Var int i = 0;
		while(i < TypeList.size()) {
			@Var ZType Type = TypeList.ArrayValues[i];
			s = s + ":" + Type.TypeId;
			i = i + 1;
		}
		return s;
	}

	private final static ZType[] UniqueTypes(ZArray<ZType> TypeList) {
		@Var String MangleName = "[]" + MangleTypes(TypeList);
		@Var ZType[] Types = ZTypePool.UniqueTypeSetMap.GetOrNull(MangleName);
		if(Types == null) {
			Types = TypeList.CompactArray();
			ZTypePool.UniqueTypeSetMap.put(MangleName, Types);
		}
		return Types;
	}

	//	private final static String MangleTypes(int BaseIdx, ArrayList<ZType> TypeList) {
	//		@Var String s = "";
	//		for(@Var int i = BaseIdx; i < LibZen._Size(TypeList); i = i + 1) {
	//			@Var ZType Type = TypeList.get(i);
	//			s = s + ":" + Type.TypeId;
	//		}
	//		return s;
	//	}
	//
	//	private final static ZType[] UniqueTypes(int BaseIdx, ArrayList<ZType> TypeList) {
	//		@Var String MangleName = "[]" + MangleTypes(BaseIdx, TypeList);
	//		@Var ZType[] Types = ZTypePool.UniqueTypeSetMap.GetOrNull(MangleName);
	//		if(Types == null) {
	//			Types = LibZen.CompactTypeList(BaseIdx, TypeList);
	//			ZTypePool.UniqueTypeSetMap.put(MangleName, Types);
	//		}
	//		return Types;
	//	}

	public final static ZType GetGenericType1(ZType BaseType, ZType ParamType) {
		@Var String MangleName = ZTypePool.MangleType2(BaseType, ParamType);
		@Var ZType GenericType = ZTypePool.ClassNameMap.GetOrNull(MangleName);
		if(GenericType == null) {
			@Var String Name = BaseType.ShortName + "<" + ParamType + ">";
			if(BaseType.IsArrayType()) {
				Name = BaseType.ShortName + "<" + ParamType + ">";
			}
			GenericType = new ZGeneric1Type(ZTypeFlag._UniqueType, Name, BaseType, ParamType);
			ZTypePool.ClassNameMap.put(MangleName, GenericType);
		}
		return GenericType;
	}

	//	public final static ZType GetGenericType(ZType BaseType, int BaseIdx, ArrayList<ZType> TypeList, boolean IsCreation) {
	//		assert(BaseType.GetParamSize() > 0);
	//		if(TypeList.size() - BaseIdx == 1 && !BaseType.IsFuncType()) {
	//			return ZTypePool.GetGenericType1(BaseType, TypeList.get(BaseIdx));
	//		}
	//		@Var String MangleName = ":" + BaseType.TypeId + MangleTypes(BaseIdx, TypeList);
	//		@Var ZType GenericType = ZTypePool.ClassNameMap.GetOrNull(MangleName);
	//		if((GenericType == null) && IsCreation) {
	//			@Var String ShortName = BaseType.ShortName + "<";
	//			for(@Var int i = BaseIdx; i < LibZen._Size(TypeList); i += 1) {
	//				ShortName = ShortName + TypeList.get(i).GetRealType().ShortName;
	//				if(i + 1 == LibZen._Size(TypeList)) {
	//					ShortName = ShortName + ">";
	//				}
	//				else {
	//					ShortName = ShortName + ",";
	//				}
	//			}
	//			if(BaseType.IsFuncType()) {
	//				GenericType = new ZFuncType(ShortName, UniqueTypes(BaseIdx, TypeList));
	//			}
	//			else {
	//				throw new RuntimeException("TODO: Make ZenGenericType");
	//			}
	//			ZTypePool.ClassNameMap.put(MangleName, GenericType);
	//		}
	//		return GenericType;
	//	}
	//
	//	public static ZFuncType LookupFuncType(ArrayList<ZType> TypeList) {
	//		return (ZFuncType)GetGenericType(ZType.FuncType, 0, TypeList, true);
	//	}

	public final static ZType GetGenericType(ZType BaseType, ZArray<ZType> TypeList, boolean IsCreation) {
		assert(BaseType.GetParamSize() > 0);
		if(TypeList.size() == 1 && !BaseType.IsFuncType()) {
			return ZTypePool.GetGenericType1(BaseType, TypeList.ArrayValues[0]);
		}
		@Var String MangleName = ":" + BaseType.TypeId + MangleTypes(TypeList);
		@Var ZType GenericType = ZTypePool.ClassNameMap.GetOrNull(MangleName);
		if((GenericType == null) && IsCreation) {
			@Var String ShortName = BaseType.ShortName + "<";
			for(@Var int i = 0; i < LibZen._Size(TypeList); i += 1) {
				ShortName = ShortName + TypeList.ArrayValues[i].GetRealType().ShortName;
				if(i + 1 == LibZen._Size(TypeList)) {
					ShortName = ShortName + ">";
				}
				else {
					ShortName = ShortName + ",";
				}
			}
			if(BaseType.IsFuncType()) {
				GenericType = new ZFuncType(ShortName, UniqueTypes(TypeList));
			}
			else {
				// TODO;
			}
			ZTypePool.ClassNameMap.put(MangleName, GenericType);
		}
		return GenericType;
	}

	public static ZFuncType LookupFuncType(ZArray<ZType> TypeList) {
		ZType FuncType = GetGenericType(ZType.FuncType, TypeList, true);
		if(FuncType instanceof ZFuncType) {
			return (ZFuncType)FuncType;
		}
		return null;
	}

}
