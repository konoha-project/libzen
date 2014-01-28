package zen.deps;

public class ZenFunction {
	@Field final String FUNCTION;
	public ZenFunction(String f) {
		this.FUNCTION = f;
	}
	@Override
	public String toString() {
		return this.FUNCTION;
	}
}
