package zen.deps;

import zen.ast.ZNode;
import zen.parser.ZTokenContext;

public abstract class ZenMatchFunc extends ZenFunction {
	public ZenMatchFunc(int TypeId, String Name) {
		super(TypeId, Name);
	}
	public abstract ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode);
}

