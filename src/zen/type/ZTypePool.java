package zen.type;

import zen.parser.ZToken;
import zen.parser.ZTypeChecker;
import zen.util.Nullable;
import zen.util.Var;
import zen.util.ZArray;
import zen.util.ZMap;

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

	private final static ZMap<ZType>     _ClassNameMap = new ZMap<ZType>(null);
	private final static ZMap<ZType[]>   _UniqueTypeSetMap = new ZMap<ZType[]>(null);

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
			GenericType = new ZGenericType(ZType.UniqueTypeFlag, BaseType, ParamType);
			ZTypePool._ClassNameMap.put(MangleName, GenericType);
		}
		return GenericType;
	}

	final static void _SetBaseGenericType(ZGenericType Type) {
		@Var String MangleName = ZTypePool._MangleType2(Type.BaseType, Type.ParamType);
		ZTypePool._ClassNameMap.put(MangleName, Type);
	}

	public final static ZType _GetGenericType(ZType BaseType, ZArray<ZType> TypeList, boolean IsCreation) {
		assert(BaseType.GetParamSize() > 0);
		if(TypeList.size() == 1 && !BaseType.IsFuncType()) {
			return ZTypePool._GetGenericType1(BaseType, TypeList.ArrayValues[0]);
		}
		@Var String MangleName = ":" + BaseType.TypeId + ZTypePool._MangleTypes(TypeList);
		@Var ZType GenericType = ZTypePool._ClassNameMap.GetOrNull(MangleName);
		if((GenericType == null) && IsCreation) {
			if(BaseType.IsFuncType()) {
				GenericType = new ZFuncType(ZTypePool._UniqueTypes(TypeList));
			}
			else {
				// TODO;
			}
			ZTypePool._ClassNameMap.put(MangleName, GenericType);
		}
		return GenericType;
	}

	public final static ZFuncType _LookupFuncType2(ZArray<ZType> TypeList) {
		@Var ZType FuncType = ZTypePool._GetGenericType(ZFuncType._FuncType, TypeList, true);
		if(FuncType instanceof ZFuncType) {
			return (ZFuncType)FuncType;
		}
		return null;
	}

	public final static ZFuncType _LookupFuncType2(ZType R) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[2]);
		TypeList.add(R);
		return ZTypePool._LookupFuncType2(TypeList);
	}

	public final static ZFuncType _LookupFuncType2(ZType P1, ZType R) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[2]);
		TypeList.add(P1);
		TypeList.add(R);
		return ZTypePool._LookupFuncType2(TypeList);
	}

	public final static ZFuncType _LookupFuncType2(ZType P1, ZType P2, ZType R) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[3]);
		TypeList.add(P1);
		TypeList.add(P2);
		TypeList.add(R);
		return ZTypePool._LookupFuncType2(TypeList);
	}

	public final static ZFuncType _LookupFuncType2(ZType P1, ZType P2, ZType P3, ZType R) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[3]);
		TypeList.add(P1);
		TypeList.add(P2);
		TypeList.add(P3);
		TypeList.add(R);
		return ZTypePool._LookupFuncType2(TypeList);
	}

	public static ZType _LookupMutableType(ZTypeChecker Gamma, ZType Type, @Nullable ZToken MutableToken) {
		if(Gamma.IsSupportMutable) {
			@Var String MangleName = "M:"+Type.TypeId;
			@Var ZType MutableType = ZTypePool._ClassNameMap.GetOrNull(MangleName);
			if(MutableType == null) {
				MutableType = new ZMutableType(Type);
				ZTypePool._ClassNameMap.put(MangleName, MutableType);
			}
			return MutableType;
		}
		return Type;
	}

	public static ZType _LookupNullableType(ZTypeChecker Gamma, ZType Type, @Nullable ZToken MaybeToken) {
		if(Gamma.IsSupportNullable) {
			@Var String MangleName = "N:"+Type.TypeId;
			@Var ZType NullableType = ZTypePool._ClassNameMap.GetOrNull(MangleName);
			if(NullableType == null) {
				NullableType = new ZMutableType(Type);
				ZTypePool._ClassNameMap.put(MangleName, NullableType);
			}
			return NullableType;
		}
		return Type;
	}

}
