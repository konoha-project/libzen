package zen.parser;

public class ZEmptyValue {
	public final static ZEmptyValue TrueEmpty = new ZEmptyValue();
	public final static ZEmptyValue FalseEmpty = new ZEmptyValue();
	@Override public String toString() { return ""; }
}
