package zen.type;

import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZArray;

public final class ZFuncType extends ZType {
	public final static ZFuncType _FuncType  = new ZFuncType("Func", null);

	@Field public ZType[]  TypeParams;
	@Field private boolean HasUnknownType = false;
	@Field private boolean HasGreekType = false;

	public ZFuncType(String ShortName, ZType[] UniqueTypeParams) {
		super(ZType.UniqueTypeFlag, ShortName, ZType.VarType);
		if(UniqueTypeParams == null) {
			this.TypeParams = LibZen._NewTypeArray(1);
			this.TypeParams[0] = ZType.VarType;
		}
		else {
			this.TypeParams = UniqueTypeParams;
		}
		@Var int i = 0;
		while(i < this.TypeParams.length) {
			if(this.TypeParams[i].IsVarType()) {
				this.HasUnknownType = true;
			}
			if(this.TypeParams[i].IsGreekType()) {
				this.HasGreekType = true;
			}
			i = i + 1;
		}
	}

	@Override public final boolean IsFuncType() {
		return true;
	}

	@Override public final boolean IsVarType() {
		return this.HasUnknownType;
	}

	@Override public boolean IsGreekType() {
		return this.HasGreekType;
	}

	@Override public final ZType GetGreekRealType(ZType[] Greek) {
		if(this.HasGreekType) {
			@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[this.TypeParams.length]);
			@Var int i = 0;
			while(i < this.TypeParams.length) {
				TypeList.add(this.TypeParams[i].GetGreekRealType(Greek));
				i = i + 1;
			}
			return ZTypePool._LookupFuncType(TypeList);
		}
		return this;
	}

	@Override public final boolean AcceptValueType(ZType ValueType, boolean ExactMatch, ZType[] Greek) {
		if(ValueType.IsFuncType() && ValueType.GetParamSize() == this.GetParamSize()) {
			@Var int i = 0;
			while(i < this.TypeParams.length) {
				if(!this.TypeParams[i].AcceptValueType(ValueType.GetParamType(i), true, Greek)) {
					return false;
				}
				i = i + 1;
			}
			return true;
		}
		return false;
	}

	@Override public String StringfySignature(String FuncName) {
		return ZFunc._StringfySignature(FuncName, this.GetFuncParamSize(), this.GetRecvType());
	}

	@Override public ZType GetBaseType() {
		return ZFuncType._FuncType;
	}

	@Override public int GetParamSize() {
		return this.TypeParams.length;
	}

	@Override public ZType GetParamType(int Index) {
		return this.TypeParams[Index];
	}

	public final ZType GetReturnType() {
		return this.TypeParams[0];
	}

	public final int GetFuncParamSize() {
		return this.TypeParams.length - 1;
	}

	public final ZType GetRecvType() {
		if(this.TypeParams.length == 1) {
			return ZType.VoidType;
		}
		return this.TypeParams[1];
	}

	public final ZType GetFuncParamType(int Index) {
		return this.TypeParams[Index+1];
	}

	public final ZFuncType NewMethodFuncType(ZType RecvType) {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[this.GetFuncParamSize()+2]);
		TypeList.add(this.GetReturnType());
		TypeList.add(RecvType);
		@Var int i = 0;
		while(i < this.GetFuncParamSize()) {
			TypeList.add(this.GetFuncParamType(i));
			i = i + 1;
		}
		return ZTypePool._LookupFuncType(TypeList);
	}

	public final boolean AcceptAsFieldFunc(ZFuncType FuncType) {
		if(FuncType.GetFuncParamSize() == this.GetFuncParamSize() && FuncType.GetReturnType().Equals(this.GetReturnType())) {
			@Var int i = 1;
			while(i < FuncType.GetFuncParamSize()) {
				if(!FuncType.GetFuncParamType(i).Equals(this.GetFuncParamType(i))) {
					return false;
				}
				i = i + 1;
			}
		}
		return true;
	}
}
