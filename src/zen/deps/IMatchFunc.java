package zen.deps;

import zen.ast.ZNode;
import zen.parser.ZNameSpace;
import zen.parser.ZTokenContext;

public abstract class IMatchFunc extends ZenFunction {
	public IMatchFunc(String Name) {
		super(Name);
	}
	public abstract ZNode Invoke(ZNameSpace NameSpace, ZTokenContext TokenContext, ZNode LeftNode);
}

