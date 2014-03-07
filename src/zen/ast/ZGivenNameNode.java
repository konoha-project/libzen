package zen.ast;

import zen.parser.ZToken;
import zen.type.ZType;
import zen.util.Field;

public abstract class ZGivenNameNode extends ZNode {

	@Field public ZType   GivenType = null;
	@Field public String  GivenName = null;
	@Field public ZToken  GivenNameToken = null;
	@Field public ZToken  GivenTypeToken = null;

	public ZGivenNameNode(ZNode ParentNode, ZToken SourceToken, int Size) {
		super(ParentNode, SourceToken, Size);
	}

	@Override public void SetTypeInfo(ZToken TypeToken, ZType Type) {
		this.GivenTypeToken = TypeToken;
		this.GivenType = Type;
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.GivenName = Name;
		this.GivenNameToken = NameToken;
	}

}
