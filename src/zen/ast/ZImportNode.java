package zen.ast;

import zen.deps.Field;
import zen.parser.ZNameSpace;

public class ZImportNode extends ZNode {
	@Field public ZNameSpace NameSpace;
	@Field public String ResourcePath = null;
	public ZImportNode(ZNameSpace NameSpace) {
		super();
		this.NameSpace = NameSpace.GetRootNameSpace();
	}
	@Override public void Append(ZNode Node) {
		if(this.ResourcePath == null) {
			this.ResourcePath = Node.SourceToken.ParsedText;
			this.SourceToken = Node.SourceToken;
		}
	}
	@Override public String GetVisitName() {
		return "VisitImportNode"; // override this if you want to use additional node
	}

}
