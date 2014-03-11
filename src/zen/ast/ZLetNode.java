package zen.ast;

import zen.parser.ZVisitor;
import zen.type.ZType;
import zen.util.Field;

public class ZLetNode extends ZNode {
	public static final int _NameInfo = 0;
	public static final int _TypeInfo = 1;
	public final static int _InitValue = 2;

	@Field public ZType   GivenType = null;
	@Field public String  GivenName = null;

	@Field public String GlobalName = null;
	@Field public boolean IsExport = false;

	public ZLetNode(ZNode ParentNode) {
		super(ParentNode, null, 3);
	}

	public final ZType DeclType() {
		if(this.GivenType == null) {
			if(this.AST[ZLetNode._TypeInfo] != null) {
				this.GivenType = this.AST[ZLetNode._TypeInfo].Type;
			}
			else {
				this.GivenType = ZType.VarType;
			}
		}
		return this.GivenType;
	}

	public final void SetDeclType(ZType Type) {
		this.GivenType = Type;
	}


	public final String GetName() {
		if(this.GivenName == null) {
			this.GivenName = this.AST[ZLetNode._NameInfo].SourceToken.GetTextAsName();
		}
		return this.GivenName;
	}

	public final ZNode InitValueNode() {
		if(this.AST[ZLetNode._InitValue] == null) {
			this.SetNode(ZLetNode._InitValue, new ZDefaultValueNode());
		}
		return this.AST[ZLetNode._InitValue];
	}

	@Override public final void Accept(ZVisitor Visitor) {
		Visitor.VisitLetNode(this);
	}

	public final boolean IsConstValue() {
		return this.InitValueNode() instanceof ZConstNode;
	}

	//	public final ZGlobalNameNode ToGlobalNameNode() {
	//		return new ZGlobalNameNode(null, this.GetAstToken(ZLetNode._NameInfo), this.GetAstType(ZLetNode._InitValue), this.GlobalName, false);
	//	}

}
