package zen.type;

import zen.parser.ZTypeChecker;

public class ZNullableType extends ZType {

	public ZNullableType(ZType ParamType) {
		super(ZType.UniqueTypeFlag, null, ParamType);
	}

	@Override public boolean IsNullableType(ZTypeChecker Gamma) {
		return true;
	}

	@Override public boolean IsMutableType(ZTypeChecker Gamma) {
		return this.RefType.IsMutableType(Gamma);
	}

	@Override public final String GetName() {
		if(this.ShortName == null) {
			this.ShortName =  "maybe " + this.RefType.GetName();
		}
		return this.ShortName;
	}


}
