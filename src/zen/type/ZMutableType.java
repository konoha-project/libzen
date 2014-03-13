package zen.type;

import zen.parser.ZTypeChecker;

public class ZMutableType extends ZType {

	public ZMutableType(ZType ParamType) {
		super(ZType.UniqueTypeFlag, null, ParamType);
	}

	@Override public final boolean IsMutableType(ZTypeChecker Gamma) {
		return true;
	}

	@Override public final String GetName() {
		if(this.ShortName == null) {
			this.ShortName =  "mutable " + this.RefType.GetName();
		}
		return this.ShortName;
	}
}
