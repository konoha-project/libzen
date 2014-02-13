package zen.type;

import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZArray;
import zen.deps.ZenMap;

public class ZTypePool {

	private final static ZArray<ZType> _TypeList = new ZArray<ZType>(new ZType[128]);
	private final static ZType[] _GreekTypes = ZGreekType.NewGreekTypes(null);

	public final static int _NewTypeId(ZType T) {
		@Var int TypeId = _TypeList.size();
		_TypeList.add(T);
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

	public final static ZType GetGreekType(int GreekId) {
		if(ZTypePool._GreekTypes[GreekId] == null) {
			ZTypePool._GreekTypes[GreekId] = new ZGreekType(GreekId);
		}
		return ZTypePool._GreekTypes[GreekId];
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
		@Var String MangleName = "[]" + _MangleTypes(TypeList);
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
			GenericType = new ZGeneric1Type(ZTypeFlag._UniqueType, Name, BaseType, ParamType);
			ZTypePool._ClassNameMap.put(MangleName, GenericType);
		}
		return GenericType;
	}

	public final static ZType _GetGenericType(ZType BaseType, ZArray<ZType> TypeList, boolean IsCreation) {
		assert(BaseType.GetParamSize() > 0);
		if(TypeList.size() == 1 && !BaseType.IsFuncType()) {
			return ZTypePool._GetGenericType1(BaseType, TypeList.ArrayValues[0]);
		}
		@Var String MangleName = ":" + BaseType.TypeId + _MangleTypes(TypeList);
		@Var ZType GenericType = ZTypePool._ClassNameMap.GetOrNull(MangleName);
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
				GenericType = new ZFuncType(ShortName, _UniqueTypes(TypeList));
			}
			else {
				// TODO;
			}
			ZTypePool._ClassNameMap.put(MangleName, GenericType);
		}
		return GenericType;
	}

	public static ZFuncType _LookupFuncType(ZArray<ZType> TypeList) {
		ZType FuncType = _GetGenericType(ZType.FuncType, TypeList, true);
		if(FuncType instanceof ZFuncType) {
			return (ZFuncType)FuncType;
		}
		return null;
	}

}
