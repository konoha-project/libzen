package zen.deps;

import zen.parser.ZSourceContext;

public abstract class ZenTokenFunction extends ZenFunction {
	public ZenTokenFunction(int TypeId, String Name) {
		super(TypeId, Name);
	}
	protected ZenTokenFunction() {
		super(0,null);
	}
	public abstract boolean Invoke(ZSourceContext SourceContext);
}
