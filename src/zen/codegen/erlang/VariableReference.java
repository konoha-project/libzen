//ifdef JAVA

package zen.codegen.erlang;

import zen.util.Field;

//endif VAJA

public class VariableReference {
	@Field public VariableDefinition SelfDef;
	@Field public VariableReference ParentRef;
	@Field public int UniqueID;
	@Field public int ScopeLevel;
	@Field public int Flag;

	public VariableReference/*constructor*/(VariableDefinition SelfDef, VariableReference ParentRef, int UniqueID, int ScopeLevel) {
		this.SelfDef = SelfDef;
		this.UniqueID = UniqueID;
		this.ParentRef = ParentRef;
		this.ScopeLevel = ScopeLevel;
		this.Flag = VarFlag.None;
	}
}
