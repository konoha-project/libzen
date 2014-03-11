package zen.ssa;

import java.util.ArrayList;

import zen.ast.ZBlockNode;
import zen.ast.ZLocalDefinedNode;
import zen.ast.ZNode;

public class PHINode extends ZLocalDefinedNode {
	public ArrayList<ZNode> Args;
	public ArrayList<ZBlockNode> Blocks;
	public ZNode Value;
	public PHINode(ZNode Value) {
		super(Value.ParentNode, Value.SourceToken, 0);
		this.Value = Value;
		this.Args = new ArrayList<ZNode>();
		this.Blocks = new ArrayList<ZBlockNode>();
	}
	public void AddIncoming(ZBlockNode block, ZNode node) {
		this.Blocks.add(block);
		this.Args.add(node);
	}
}