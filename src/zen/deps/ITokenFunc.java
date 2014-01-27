package zen.deps;

import zen.parser.ZTokenContext;

public interface ITokenFunc {
	public long Invoke(ZTokenContext TokenContext, String SourceText, long pos);
}
