package zen.parser;

import zen.ast.ZBlockNode;
import zen.ast.ZBreakNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZIfNode;
import zen.ast.ZNode;
import zen.ast.ZReturnNode;
import zen.ast.ZThrowNode;
import zen.util.Var;

public class ZNodeUtils {

	//	private boolean HasReturnStatement(ZNode Node) {
	//		if(Node instanceof ZBlockNode) {
	//			@Var ZBlockNode BlockNode = (ZBlockNode)Node;
	//			@Var int i = 0;
	//			@Var ZNode StmtNode = null;
	//			while(i < BlockNode.GetListSize()) {
	//				StmtNode = BlockNode.GetListAt(i);
	//				//System.out.println("i="+i +", "+ StmtNode.getClass().getSimpleName());
	//				if(ZNodeUtils._IsBreakBlock(StmtNode)) {
	//					return true;
	//				}
	//				i = i + 1;
	//			}
	//			Node = StmtNode;
	//		}
	//		if(Node instanceof ZIfNode) {
	//			@Var ZIfNode IfNode = (ZIfNode)Node;
	//			if(IfNode.HasElseNode()) {
	//				return this.HasReturnStatement(IfNode.ThenNode()) && this.HasReturnStatement(IfNode.ElseNode());
	//			}
	//			return false;
	//		}
	//		return ZNodeUtils._IsBreakBlock(Node);
	//	}

	public final static boolean _IsBlockBreak(ZNode Node) {
		if(Node instanceof ZReturnNode || Node instanceof ZThrowNode || Node instanceof ZBreakNode) {
			return true;
		}
		//System.out.println("@HasReturn"+ Node.getClass().getSimpleName());
		return false;
	}

	public final static boolean _HasFunctionBreak(ZNode Node) {
		if(Node instanceof ZReturnNode || Node instanceof ZThrowNode) {
			return true;
		}
		if(Node instanceof ZIfNode) {
			@Var ZIfNode IfNode = (ZIfNode)Node;
			if(IfNode.HasElseNode()) {
				return ZNodeUtils._HasFunctionBreak(IfNode.ThenNode()) && ZNodeUtils._HasFunctionBreak(IfNode.ElseNode());
			}
			return false;
		}
		if(Node instanceof ZBlockNode) {
			@Var ZBlockNode BlockNode = (ZBlockNode)Node;
			@Var int i = 0;
			while(i < BlockNode.GetListSize()) {
				@Var ZNode StmtNode = BlockNode.GetListAt(i);
				//System.out.println("i="+i +", "+ StmtNode.getClass().getSimpleName());
				if(ZNodeUtils._HasFunctionBreak(StmtNode)) {
					return true;
				}
				i = i + 1;
			}
		}
		//System.out.println("@HasReturn"+ Node.getClass().getSimpleName());
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
