package zen.parser;

import zen.deps.Field;

public class ZPatternToken extends ZToken {
	@Field public ZSyntaxPattern	PresetPattern;
	public ZPatternToken(ZSource Source, int StartIndex, int EndIndex, ZSyntaxPattern	PresetPattern) {
		super(Source, StartIndex, EndIndex);
		this.PresetPattern = PresetPattern;
	}

}
