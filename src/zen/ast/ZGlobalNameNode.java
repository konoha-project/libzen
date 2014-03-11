package zen.ast;

import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZFuncType;
import zen.util.Field;

public class ZGlobalNameNode extends ZNode {

	@Field public final String GlobalName;
	@Field public ZFuncType FuncType = null;

	public ZGlobalNameNode(ZNode ParentNode, ZToken SourceToken, String GlobalName, ZFuncType FuncType) {
		super(ParentNode, SourceToken, 0);
		this.GlobalName = GlobalName;
		if(FuncType != null) {
			this.SetFuncType(FuncType);
		}
	}

	public final boolean IsFuncNameNode() {
		return this.FuncType != null;
	}

	public final void SetFuncType(ZFuncType FuncType) {
		this.FuncType = FuncType;
		this.Type = FuncType;
	}

	@Override public final void Accept(ZVisitor Visitor) {
		Visitor.VisitGlobalNameNode(this);
	}

}
