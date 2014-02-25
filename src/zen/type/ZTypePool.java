package zen.type;

import zen.deps.Var;
import zen.deps.ZArray;
import zen.deps.ZenMap;

public class ZTypePool {

	private final static ZArray<ZType> _TypeList = new ZArray<ZType>(new ZType[128]);

	public final static int _NewTypeId(ZType T) {
		@Var int TypeId = ZTypePool._TypeList.size();
		ZTypePool._TypeList.add(T);
		return TypeId;
	}

	public final static ZType TypeOf(int TypeId) {
		if(TypeId == 0) {
			return ZType.VarType;
		}
		if(TypeId < ZTypePool._TypeList.size()) {
			return ZTypePool._TypeList.ArrayValues[TypeId];
		}
		return ZType.VarType;
	}

	private final static ZenMap<ZType>     _ClassNameMap = new ZenMap<ZType>(null);
	private final static ZenMap<ZType[]>   _UniqueTypeSetMap = new ZenMap<ZType[]>(null);

	private final static String _MangleType2(ZType Type1, ZType Type2) {
		return ":" + Type1.TypeId + ":" + Type2.TypeId;
	}

	private final static String _MangleTypes(ZArray<ZType> TypeList) {
		@Var String s = "";
		@Var int i = 0;
		while(i < TypeList.size()) {
			@Var ZType Type = TypeList.ArrayValues[i];
			s = s + ":" + Type.TypeId;
			i = i + 1;
		}
		return s;
	}

	private final static ZType[] _UniqueTypes(ZArray<ZType> TypeList) {
		@Var String MangleName = "[]" + ZTypePool._MangleTypes(TypeList);
		@Var ZType[] Types = ZTypePool._UniqueTypeSetMap.GetOrNull(MangleName);
		if(Types == null) {
			Types = TypeList.CompactArray();
			ZTypePool._UniqueTypeSetMap.put(MangleName, Types);
		}
		return Types;
	}

	public final static ZType _GetGenericType1(ZType BaseType, ZType ParamType) {
		@Var String MangleName = ZTypePool._MangleType2(BaseType, ParamType);
		@Var ZType GenericType = ZTypePool._ClassNameMap.GetOrNull(MangleName);
		if(GenericType == null) {
			@Var String Name = BaseType.ShortName + "<" + ParamType + ">";
			if(BaseType.IsArrayType()) {
				Name = BaseType.ShortName + "<" + ParamType + ">";
			}
			GenericType = new ZGenericType(ZType.UniqueTypeFlag, Name, BaseType, ParamType);
			ZTypePool._ClassNameMap.put(MangleName, GenericType);
		}
		return GenericType;
	}

	public final static ZType _GetGenericType(ZType BaseType, ZArray<ZType> TypeList, boolean IsCreation) {
		assert(BaseType.GetParamSize() > 0);
		if(TypeList.size() == 1 && !BaseType.IsFuncType()) {
			return ZTypePool._GetGenericType1(BaseType, TypeList.ArrayValues[0]);
		}
		@Var String MangleName = ":" + BaseType.TypeId + ZTypePool._MangleTypes(TypeList);
		@Var ZType GenericType = ZTypePool._ClassNameMap.GetOrNull(MangleName);
		if((GenericType == null) && IsCreation) {
			@Var String ShortName = BaseType.ShortName + "<";
			@Var int i = 0;
			while(i < TypeList.size()) {
				ShortName = ShortName + TypeList.ArrayValues[i].GetRealType().ShortName;
				if(i + 1 == TypeList.size()) {
					ShortName = ShortName + ">";
				}
				else {
					ShortName = ShortName + ",";
				}
				i = i + 1;
			}
			if(BaseType.IsFuncType()) {
				GenericType = new ZFuncType(ShortName, ZTypePool._UniqueTypes(TypeList));
			}
			else {
				// TODO;
			}
			ZTypePool._ClassNameMap.put(MangleName, GenericType);
		}
		return GenericType;
	}

	public final static ZFuncType _LookupFuncType(ZArray<ZType> TypeList) {
		@Var ZType FuncType = ZTypePool._GetGenericType(ZFuncType._FuncType, TypeList, true);
		if(FuncType instanceof ZFuncType) {
			return (ZFuncType)FuncType;
		}
		return null;
	}

	public final static ZFuncType _LookupFuncType(ZType R) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[2]);
		TypeList.add(R);
		return ZTypePool._LookupFuncType(TypeList);
	}

	public final static ZFuncType _LookupFuncType(ZType R, ZType P1) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[2]);
		TypeList.add(R);
		TypeList.add(P1);
		return ZTypePool._LookupFuncType(TypeList);
	}

	public final static ZFuncType _LookupFuncType(ZType R, ZType P1, ZType P2) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[3]);
		TypeList.add(R);
		TypeList.add(P1);
		TypeList.add(P2);
		return ZTypePool._LookupFuncType(TypeList);
	}

	public final static ZFuncType _LookupFuncType(ZType R, ZType P1, ZType P2, ZType P3) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[3]);
		TypeList.add(R);
		TypeList.add(P1);
		TypeList.add(P2);
		TypeList.add(P3);
		return ZTypePool._LookupFuncType(TypeList);
	}

}
