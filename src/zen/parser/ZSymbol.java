package zen.parser;

import zen.ast.ZNode;
import zen.deps.Field;

public class ZSymbol {
	@Field public ZSymbol Parent;
	@Field public ZNode Node;
	@Field public boolean IsDisabled = false;
	public ZSymbol(ZSymbol Parent, ZNode Node) {
		this.Parent = Parent;
		this.Node = Node;
	}
}
