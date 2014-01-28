package zen.deps;

import zen.parser.ZTokenContext;

public abstract class ITokenFunc extends ZenFunction {
	public ITokenFunc(String Name) {
		super(Name);
	}
	public abstract long Invoke(ZTokenContext TokenContext, String SourceText, long pos);
}
