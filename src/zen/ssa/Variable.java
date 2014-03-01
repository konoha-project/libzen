package zen.ssa;

import java.util.ArrayList;

import zen.ast.ZNode;
import zen.util.Field;

public class Variable {
	@Field public String Name;
	@Field public int Index;
	@Field private final ArrayList<ZNode> Defs;
	@Field private final ArrayList<ZNode> Uses;
	@Field public final ZNode Node;
	public Variable(String Name, ZNode Node) {
		this.Name = Name;
		this.Node = Node;
		this.Index = -1;
		this.Defs = new ArrayList<ZNode>();
		this.Uses = new ArrayList<ZNode>();
	}

	public void Use(ZNode Node) {
		this.Uses.add(Node);
	}

	public void Def(ZNode Node) {
		this.Defs.add(Node);
	}
}