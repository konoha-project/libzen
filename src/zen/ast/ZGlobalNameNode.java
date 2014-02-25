package zen.ast;

import zen.deps.Field;
import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZType;

public class ZGlobalNameNode extends ZNode {

	@Field public final String GlobalName;
	@Field public  boolean IsStaticFuncName;

	public ZGlobalNameNode(ZNode ParentNode, ZToken SourceToken, ZType Type, String GlobalName, boolean IsStaticFuncName) {
		super(ParentNode, SourceToken, 0);
		this.GlobalName = GlobalName;
		this.Type = Type;
		this.IsStaticFuncName = IsStaticFuncName;
	}

	public final boolean IsGivenName() {
		return (!this.IsStaticFuncName);
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitGlobalNameNode(this);
	}


}
