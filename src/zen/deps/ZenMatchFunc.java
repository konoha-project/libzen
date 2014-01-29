package zen.deps;

import zen.ast.ZNode;
import zen.parser.ZNameSpace;
import zen.parser.ZTokenContext;

public abstract class ZenMatchFunc extends ZenFunction {
	public ZenMatchFunc(int TypeId, String Name) {
		super(TypeId, Name);
	}
	public abstract ZNode Invoke(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode);
}

