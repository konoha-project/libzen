package zen.deps;

import zen.ast.ZNode;
import zen.parser.ZNameSpace;
import zen.parser.ZTokenContext;

public interface IMatchFunc {
	public ZNode Invoke(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode);
}

