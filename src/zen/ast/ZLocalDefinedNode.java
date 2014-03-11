package zen.ast;

import zen.parser.ZToken;
import zen.parser.ZVisitor;


public abstract class ZLocalDefinedNode extends ZNode {


	public ZLocalDefinedNode(ZNode ParentNode, ZToken SourceToken, int Size) {
		super(ParentNode, SourceToken, Size);
	}

	@Override public final void Accept(ZVisitor Visitor) {
		Visitor.VisitLocalDefinedNode(this);
	}

	//	@Field public ZType   GivenType = null;
	//	@Field public String  GivenName = null;
	//	@Field public ZToken  GivenNameToken = null;
	//	@Field public ZToken  GivenTypeToken = null;
	//	@Override public void SetTypeInfo(ZToken TypeToken, ZType Type) {
	//		this.GivenTypeToken = TypeToken;
	//		this.GivenType = Type;
	//	}
	//
	//	@Override public void SetNameInfo(ZToken NameToken, String Name) {
	//		this.GivenName = Name;
	//		this.GivenNameToken = NameToken;
	//	}

}
