package zen.parser;

import zen.ast.ZNode;
import zen.util.Field;

public class ZSymbolEntry {
	@Field public ZSymbolEntry Parent;
	@Field public ZNode Node;
	@Field public boolean IsDisabled = false;
	
	public ZSymbolEntry(ZSymbolEntry Parent, ZNode Node) {
		this.Parent = Parent;
		this.Node = Node;
	}
}
