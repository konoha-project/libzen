package zen.parser;

import zen.util.Field;

public class ZPatternToken extends ZToken {
	@Field public ZSyntax	PresetPattern;
	public ZPatternToken(ZSource Source, int StartIndex, int EndIndex, ZSyntax	PresetPattern) {
		super(Source, StartIndex, EndIndex);
		this.PresetPattern = PresetPattern;
	}

}
