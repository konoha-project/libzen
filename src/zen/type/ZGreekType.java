package zen.type;

import zen.deps.Field;
import zen.deps.Var;
import zen.lang.ZSystem;

public class ZGreekType extends ZType {
	private final static String[] GreekNames = {
		"\u03B1", "\u03B2", "\u03B3",
	};

	@Field public final int GreekId;
	public ZGreekType(int GreekId) {
		super(ZTypeFlag.UniqueType, GreekNames[GreekId], ZSystem.VarType);
		this.GreekId = GreekId;
	}

	public final static ZType[] NewGreekTypes(ZType[] GreekTypes) {
		if(GreekTypes == null) {
			return new ZType[GreekNames.length];
		}
		else {
			@Var int i = 0;
			while(i < GreekTypes.length) {
				GreekTypes[i] = null;
				i = i + 1;
			}
			return GreekTypes;
		}
	}

	@Override public boolean IsGreekType() {
		return true;
	}

	@Override public ZType GetRealType(ZType[] Greek) {
		if(Greek[this.GreekId] == null) {
			return ZSystem.VarType;
		}
		return Greek[this.GreekId];
	}

	@Override public final boolean AcceptValueType(ZType ValueType, boolean ExactMatch, ZType[] Greek) {
		if(Greek[this.GreekId] == null) {
			if(ValueType.IsVarType()) {
				return true;
			}
			Greek[this.GreekId] = ValueType;
			return true;
		}
		else {
			return Greek[this.GreekId].AcceptValueType(ValueType, ExactMatch, Greek);
		}
	}
}
