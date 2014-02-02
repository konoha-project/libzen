package zen.ast;

import zen.deps.Field;
import zen.lang.ZenError;

public class ZImportNode extends ZNode {
	@Field public String ResourcePath = null;
	@Field public String Alias = null;
	public ZImportNode(ZNode ParentNode) {
		super(ParentNode, null);
	}
	@Override public void Append(ZNode Node) {
		if(this.ResourcePath == null) {
			this.ResourcePath = Node.SourceToken.ParsedText;
			this.SourceToken = Node.SourceToken;
		}
		else {
			this.Alias = Node.SourceToken.ParsedText;
		}
	}
	@Override public String GetVisitName() {
		return "VisitImportNode"; // override this if you want to use additional node
	}

	public ZNode Import() {
		return ZenError.UnfoundResource(this, this.ResourcePath);
	}

}
