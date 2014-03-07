package zen.ast.sugar;

import zen.ast.ZNode;
import zen.parser.ZGenerator;
import zen.util.Field;

public class ZDesugarNode extends ZSyntaxSugarNode {
	public final static int _NewNode = 0;
	@Field ZNode OriginalNode;

	public ZDesugarNode(ZNode OriginalNode, ZNode DesugaredNode) {
		super(OriginalNode.ParentNode, null, 1);
		this.OriginalNode = OriginalNode;
		OriginalNode.ParentNode = this;
		this.Set(ZDesugarNode._NewNode, DesugaredNode);
		DesugaredNode.ParentNode = this;
	}

	@Override public ZDesugarNode DeSugar(ZGenerator Generator) {
		return this;
	}

}
