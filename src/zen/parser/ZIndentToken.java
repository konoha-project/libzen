package zen.parser;


public final class ZIndentToken extends ZToken {
	public ZIndentToken(ZSource Source, int StartIndex, int EndIndex) {
		super(Source, StartIndex, EndIndex);
	}

	@Override
	public final int GetIndentSize() {
		return this.Source.CountIndentSize(this.StartIndex);
	}

}
