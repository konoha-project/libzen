package zen.type;

import java.util.ArrayList;

import zen.deps.Field;
import zen.deps.Var;
import zen.lang.ZFunc;

public final class ZFuncType extends ZType {
	@Field public ZType[]  TypeParams;
	@Field private boolean HasUnknownType = false;
	@Field private boolean HasGreekType = false;

	public ZFuncType(String ShortName, ZType[] UniqueTypeParams) {
		super(ZTypeFlag.UniqueType, ShortName, ZType.VarType);
		if(UniqueTypeParams == null) {
			this.TypeParams = new ZType[1];
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

	@Override public final ZType GetRealType(ZType[] Greek) {
		if(this.HasGreekType) {
			@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
			@Var int i = 0;
			while(i < this.TypeParams.length) {
				TypeList.add(this.TypeParams[i].GetRealType(Greek));
			}
			return ZTypePool.LookupFuncType(TypeList);
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
		return ZFunc.StringfySignature(FuncName, this.GetFuncParamSize(), this.GetRecvType());
	}

	@Override public ZType GetBaseType() {
		return ZType.FuncType;
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

	public ZFuncType NewMethodFuncType(ZType RecvType) {
		@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
		TypeList.add(this.GetReturnType());
		TypeList.add(RecvType);
		@Var int i = 0;
		while(i < this.GetFuncParamSize()) {
			TypeList.add(this.GetFuncParamType(i));
			i = i + 1;
		}
		return ZTypePool.LookupFuncType(TypeList);
	}

}
