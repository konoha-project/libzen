package zen.lang;

import zen.deps.Constructor;
import zen.deps.Field;
import zen.deps.Var;

public final class ZenFuncType extends ZenType {

	@Field public ZenType[]		TypeParams;
	@Constructor public ZenFuncType(String ShortName, ZenType[] UniqueTypeParams) {
		super(UniqueType, ShortName, ZenSystem.TopType);
		if(UniqueTypeParams == null) {
			this.TypeParams = new ZenType[1];
			this.TypeParams[0] = ZenSystem.VarType;
		}
		else {
			this.TypeParams = UniqueTypeParams;
		}
	}

	@Override public boolean IsFuncType() {
		return true;
	}

	@Override public boolean HasCallableSignature() {
		return !(this.GetRecvType().IsVarType());
	}

	@Override public String StringfySignature(String FuncName) {
		return ZenFunc.StringfySignature(FuncName, this.GetFuncParamSize(), this.GetRecvType());
	}

	@Override public ZenType GetBaseType() {
		return ZenSystem.FuncType;
	}

	@Override public int GetParamSize() {
		return this.TypeParams.length;
	}

	@Override public ZenType GetParamType(int Index) {
		return this.TypeParams[Index];
	}

	public ZenType GetReturnType() {
		return this.TypeParams[0];
	}

	public final int GetFuncParamSize() {
		return this.TypeParams.length - 1;
	}

	public final ZenType GetRecvType() {
		if(this.TypeParams.length == 1) {
			return ZenSystem.VoidType;
		}
		return this.TypeParams[1];
	}

	public final boolean IsCompleteType() {
		@Var int i = 0;
		while(i < this.TypeParams.length) {
			if(this.TypeParams[i].IsVarType()) {
				return false;
			}
			i = i + 1;
		}
		return true;
	}

}
