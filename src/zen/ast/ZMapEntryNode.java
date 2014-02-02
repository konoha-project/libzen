package zen.ast;

import zen.deps.Field;

public class ZMapEntryNode extends ZNode {
	@Field public String  Name = null;
	@Field public ZNode KeyNode = null;
	@Field public ZNode ValueNode = null;
	public ZMapEntryNode(ZNode ParentNode) {
		super(ParentNode, null);
	}

	@Override public String GetVisitName() {
		return "VisitMapEntryNode"; // override this if you want to use additional node
	}

	@Override public void Append(ZNode Node) {
		if(this.KeyNode == null) {
			this.KeyNode = this.SetChild(Node);
			if(Node instanceof ZGetNameNode) {
				this.Name = Node.SourceToken.ParsedText;
			}
			if(Node instanceof ZStringNode) {
				this.Name = ((ZStringNode) Node).StringValue;
			}
		}
		else {
			this.ValueNode = this.SetChild(Node);
		}
	}
}
