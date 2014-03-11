package zen.parser;

import zen.ast.ZBlockNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZNode;
import zen.ast.ZReturnNode;
import zen.ast.ZThrowNode;
import zen.util.Var;

public class ZNodeUtils {
	public final static boolean _IsBreakBlock(ZNode Node) {
		if(Node instanceof ZReturnNode || Node instanceof ZThrowNode) {
			return true;
		}
		return false;
	}

	public final static ZReturnNode _CheckIfSingleReturnNode(ZFunctionNode Node) {
		@Var ZBlockNode BlockNode = Node.BlockNode();
		if(BlockNode.GetListSize() == 1) {
			@Var ZNode ReturnNode= BlockNode.AST[0];
			if(ReturnNode instanceof ZReturnNode) {
				return (ZReturnNode)ReturnNode;
			}
		}
		return null;
	}
}
