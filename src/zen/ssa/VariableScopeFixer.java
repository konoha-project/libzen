package zen.ssa;

import zen.ast.ZBlockNode;
import zen.ast.ZNode;
import zen.ast.ZVarNode;
import zen.util.Var;

public class VariableScopeFixer extends ZASTTransformer {
	private ZBlockNode GetParentBlock(ZVarNode Node) {
		if(Node.ParentNode != null && Node.ParentNode instanceof ZBlockNode) {
			return (ZBlockNode) Node.ParentNode;
		}
		return null;
	}

	/*
	 * var x : A = null; | var x : A = null in {
	 * f(x.a);           |   f(x.a);
	 * z = x.a;          |   z = x.a;
	 *                   | }
	 */
	@Override
	public void VisitVarNode(ZVarNode Node) {
		@Var int Index = 0;
		@Var ZBlockNode Parent = this.GetParentBlock(Node);
		assert(Parent != null);
		for (; Index < Parent.GetListSize(); Index++) {
			if(Node == Parent.GetListAt(Index)) {
				break;
			}
		}
		Node.InitValueNode().Accept(this);
		assert(Index != Parent.GetListSize());
		int i = Index + 1;
		for (; i < Parent.GetListSize(); i++) {
			ZNode NextNode = Parent.GetListAt(i);
			Node.Append(NextNode);
			NextNode.ParentNode = Node;
			NextNode.Accept(this);
		}
		Parent.ClearListAfter(Index + 1);
	}
}