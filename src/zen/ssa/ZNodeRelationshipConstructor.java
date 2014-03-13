package zen.ssa;

import zen.ast.ZNode;

public class ZNodeRelationshipConstructor extends ZASTTransformer {
	@Override
	protected void VisitAfter(ZNode Node, int Index) {
		Node.SetChild(Node.AST[Index], false/*FIXME*/);
	}
}
