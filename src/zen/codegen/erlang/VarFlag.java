//ifdef JAVA

package zen.codegen.erlang;

import zen.util.Field;

//endif VAJA

public class VarFlag {
	@Field public static final int None = 0;
	@Field public static final int All = -1;
	@Field public static final int Assigned = 1;//this means AssingedByCurrentScope OR AssingedByChildScope
	@Field public static final int AssignedByCurrentScope = 1 << 1;
	@Field public static final int AssignedByChildScope = 1 << 2;
	@Field public static final int NotAssigned = 1 << 3;//this means NotAssingedByCurrentScope AND NotAssingedByChildScope
	@Field public static final int NotAssignedByCurrentScope = 1 << 4;
	@Field public static final int NotAssignedByChildScope = 1 << 5;
	@Field public static final int Defined = 1 << 8;//this means DefinedByCurrentScope OR DefinedByParentScope
	@Field public static final int DefinedByCurrentScope = 1 << 9;
	@Field public static final int DefinedByParentScope = 1 << 10;
	@Field public static final int NotDefined = 1 << 11;//this means NotDefinedByCurrentScope AND NotDefinedByParentScope
	@Field public static final int NotDefinedByCurrentScope = 1 << 12;
	@Field public static final int NotDefinedByParentScope = 1 << 13;
	@Field public static final int Read = 1 << 16;//this means ReadByCurrentScope OR ReadByParentScope
	@Field public static final int ReadByCurrentScope = 1 << 17;
	@Field public static final int ReadByChildScope = 1 << 18;
	@Field public static final int NotRead = 1 << 19;//this means NotReadByCurrentScope AND NotReadByParentScope
	@Field public static final int NotReadByCurrentScope = 1 << 20;
	@Field public static final int NotReadByChildScope = 1 << 21;

	private VarFlag/*constructor*/() {
	}

	private static void ValidateArg(int Flag) {
		if (Flag < 0) {
			throw new RuntimeException("Validation Error, Invalid Flag : " + Integer.toString(Flag));
		} else {
			while (Flag > 0) {
				int Masked = Flag & 0xFF;
				if (Integer.bitCount(Masked) > 1) {
					throw new RuntimeException("Validation Error, Invalid Flag : " + Integer.toString(Flag));
				} else {
					Flag = Flag >> 8;
				}
			}
		}
	}

	public static int Update(int Base, int Arg) {
		VarFlag.ValidateArg(Arg);
		return Base | Arg;
	}

	public static boolean Check(int Base, int Arg) {
		VarFlag.ValidateArg(Arg);

		boolean ret = true;
		if ((Arg & Assigned) != 0) {
			ret &= (Base & AssignedByCurrentScope) != 0 || (Base & AssignedByChildScope) != 0;
		} else {
			int Mask = Arg & (AssignedByCurrentScope | AssignedByChildScope);
			ret &= ((Base & Mask) == Mask);
		}
		if ((Arg & Defined) != 0) {
			ret &= (Base & DefinedByCurrentScope) != 0 || (Base & DefinedByParentScope) != 0;
		} else {
			int Mask = Arg & (DefinedByCurrentScope | DefinedByParentScope);
			ret &= ((Base & Mask) == Mask);
		}
		if ((Arg & Read) != 0) {
			ret &= (Base & ReadByCurrentScope) != 0 || (Base & ReadByChildScope) != 0;
		} else {
			int Mask = Arg & (ReadByCurrentScope | ReadByChildScope);
			ret &= ((Base & Mask) == Mask);
		}
		return ret;
	}
}
