package zen.deps;

import zen.ast.ZNode;
import zen.parser.ZTokenContext;

public abstract class ZenMatchFunction extends ZenFunction {
	public ZenMatchFunction(int TypeId, String Name) {
		super(TypeId, Name);
	}
	protected ZenMatchFunction() {
		super(0, null);
	}
	public abstract ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode);
}

