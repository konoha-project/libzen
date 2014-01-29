package zen.deps;

import zen.parser.ZTokenContext;

public abstract class ZenTokenFunc extends ZenFunction {
	public ZenTokenFunc(int TypeId, String Name) {
		super(TypeId, Name);
	}
	public abstract long Invoke(ZTokenContext TokenContext, String SourceText, long pos);
}
