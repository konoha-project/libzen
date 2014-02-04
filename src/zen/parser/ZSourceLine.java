package zen.parser;

import zen.deps.Field;

public class ZSourceLine {
	@Field String FileName;
	@Field int LineNumber;
	@Field String LineText;
	public ZSourceLine(String FileName, int LineNumber, String LineText) {
		this.FileName = FileName;
		this.LineNumber = LineNumber;
		this.LineText = LineText;
	}
}
