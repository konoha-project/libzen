package zen.type;

import java.util.ArrayList;

import zen.deps.Field;
import zen.deps.Var;
import zen.lang.ZFunc;
import zen.lang.ZSystem;

public final class ZFuncType extends ZType {
	@Field public ZType[]  TypeParams;
	@Field private boolean HasUnknownType = false;
	@Field private boolean HasGreekType = false;

	public ZFuncType(String ShortName, ZType[] UniqueTypeParams) {
		super(ZTypeFlag.UniqueType, ShortName, ZSystem.VarType);
		if(UniqueTypeParams == null) {
			this.TypeParams = new ZType[1];
			this.TypeParams[0] = ZSystem.VarType;
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
			return ZSystem.LookupFuncType(TypeList);
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


	//	@Override public final boolean IsVarType(boolean IgnoreReturn) {
	//		@Var int i = 0;
	//		if(IgnoreReturn) {
	//			i = 1;
	//		}
	//		while(i < this.TypeParams.length) {
	//			if(this.TypeParams[i].IsVarType()) {
	//				return false;
	//			}
	//			i = i + 1;
	//		}
	//		return true;
	//	}
	//
	//	@Override public boolean HasCallableSignature() {
	//		return !(this.GetRecvType().IsVarType());
	//	}

	@Override public String StringfySignature(String FuncName) {
		return ZFunc.StringfySignature(FuncName, this.GetFuncParamSize(), this.GetRecvType());
	}

	@Override public ZType GetBaseType() {
		return ZSystem.FuncType;
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
			return ZSystem.VoidType;
		}
		return this.TypeParams[1];
	}

	public final ZType GetFuncParamType(int Index) {
		return this.TypeParams[Index+1];
	}

	public boolean MatchFunc(ZFuncType ContextFuncType) {
		@Var int i = 0;
		if(this.TypeParams[0].IsVarType() && !ContextFuncType.TypeParams[0].IsVarType()) {
			i = 1;
		}
		while(i < this.TypeParams.length) {
			@Var ZType ParamType =  ContextFuncType.TypeParams[i];
			if(this.TypeParams[i] != ParamType && !ParamType.IsVarType()) {
				return false;
			}
			i = i + 1;
		}
		return true;
	}


}
