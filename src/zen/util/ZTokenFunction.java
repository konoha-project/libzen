package zen.util;

import zen.parser.ZSourceContext;

public abstract class ZTokenFunction extends ZFunction {
	public ZTokenFunction(int TypeId, String Name) {
		super(TypeId, Name);
	}
	protected ZTokenFunction() {
		super(0,null);
	}
	public abstract boolean Invoke(ZSourceContext SourceContext);
}
