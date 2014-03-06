package zen.type;

import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZArray;

public final class ZFuncType extends ZType {
	public final static ZFuncType _FuncType  = new ZFuncType();

	@Field public ZType[]  TypeParams;
	@Field private boolean HasUnknownType = false;
	@Field private boolean HasGreekType = false;

	private ZFuncType() {
		super(ZType.UniqueTypeFlag, "Func", ZType.VarType);
		this.TypeParams = LibZen._NewTypeArray(1);
		this.TypeParams[0] = ZType.VarType;
		this.HasUnknownType = true;
	}

	public ZFuncType(ZType[] UniqueTypeParams) {
		super(ZType.UniqueTypeFlag, null, ZType.VarType);
		this.TypeParams = UniqueTypeParams;
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

	@Override public final String GetName() {
		if(this.ShortName == null) {
			@Var String s = "Func<";
			@Var int i = 0;
			while(i < this.TypeParams.length) {
				if(i > 0) {
					s = s + ",";
				}
				s = s + this.TypeParams[i].GetName();
				i = i + 1;
			}
			this.ShortName =  s + ">";
		}
		return this.ShortName;
	}

	@Override public final boolean IsFuncType() {
		return true;
	}

	@Override public final boolean IsVarType() {
		return this.HasUnknownType;
	}

	@Override public final boolean IsGreekType() {
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
			return ZTypePool._LookupFuncType2(TypeList);
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

	@Override public final String StringfySignature(String FuncName) {
		return ZFunc._StringfySignature(FuncName, this.GetFuncParamSize(), this.GetRecvType());
	}

	@Override public final ZType GetBaseType() {
		return ZFuncType._FuncType;
	}

	@Override public final int GetParamSize() {
		return this.TypeParams.length;
	}

	@Override public final ZType GetParamType(int Index) {
		return this.TypeParams[Index];
	}

	public final ZType GetReturnType() {
		return this.TypeParams[this.TypeParams.length - 1];
	}

	public final ZType GetRecvType() {
		if(this.TypeParams.length == 1) {
			return ZType.VoidType;
		}
		return this.TypeParams[0];
	}

	public final int GetFuncParamSize() {
		return this.TypeParams.length - 1;
	}


	public final ZType GetFuncParamType(int Index) {
		return this.TypeParams[Index];
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
