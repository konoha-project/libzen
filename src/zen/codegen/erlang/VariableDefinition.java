//ifdef JAVA

package zen.codegen.erlang;

import zen.util.Field;

//endif VAJA

public class VariableDefinition {
	@Field public String Name;
	@Field public int AssignedCount;
	@Field public VariableReference CurrentRef;

	public VariableDefinition/*constructor*/(String Name) {
		this.Name = Name;
		this.AssignedCount = 0;
		this.CurrentRef = null;
	}
}
