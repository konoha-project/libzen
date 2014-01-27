package zen.deps;

import zen.parser.ZTokenContext;

public abstract class ITokenFunc {
	public abstract long Invoke(ZTokenContext TokenContext, String SourceText, long pos);
}
