package zen.deps;

import zen.ast.ZNode;
import zen.parser.ZNameSpace;
import zen.parser.ZTokenContext;

public abstract class IMatchFunc {
	public abstract ZNode Invoke(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode);
}

