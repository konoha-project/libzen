package zen.ssa;

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZAsmNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZClassNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZDefaultValueNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGlobalNameNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZLetNode;
import zen.ast.ZListNode;
import zen.ast.ZLocalDefinedNode;
import zen.ast.ZMacroNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZSugarNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTopLevelNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.parser.ZVisitor;

public class ZASTTransformer extends ZVisitor {
	private ZNode TransformedValue;
	public ZASTTransformer() {
		this.TransformedValue = null;
	}

	protected void VisitBefore(ZNode Node, int Index) {
	}

	protected void VisitAfter(ZNode Node, int Index) {
	}

	protected void Transform(ZNode Node, int Index) {
		ZNode LastTransformed = this.TransformedValue;
		this.TransformedValue = Node.AST[Index];
		this.VisitBefore(Node, Index);
		Node.AST[Index].Accept(this);
		//		if(Node != this.TransformedValue) {
		//			Node.ParentNode.SetChild(this.TransformedValue);
		//		}
		Node.SetNode(Index, this.TransformedValue);
		this.VisitAfter(Node, Index);
		this.TransformedValue = LastTransformed;
	}

	protected void VisitListNode(ZListNode Node) {
		for (int i = 0; i < Node.GetListSize(); i++) {
			this.Transform(Node, i);
		}
	}

	@Override
	public void VisitNullNode(ZNullNode Node) {
		/* do nothing */
	}

	@Override
	public void VisitBooleanNode(ZBooleanNode Node) {
		/* do nothing */
	}

	@Override
	public void VisitIntNode(ZIntNode Node) {
		/* do nothing */
	}

	@Override
	public void VisitFloatNode(ZFloatNode Node) {
		/* do nothing */
	}

	@Override
	public void VisitStringNode(ZStringNode Node) {
		/* do nothing */
	}

	@Override
	public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.VisitListNode(Node);
	}

	@Override
	public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.VisitListNode(Node);
	}

	//	@Override
	//	public void VisitNewArrayNode(ZNewArrayNode Node) {
	//		this.VisitListNode(Node);
	//	}

	@Override
	public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.VisitListNode(Node);
	}

	@Override
	public void VisitGlobalNameNode(ZGlobalNameNode Node) {
		/* do nothing */
	}

	@Override
	public void VisitGetNameNode(ZGetNameNode Node) {
		/* do nothing */
	}

	@Override
	public void VisitSetNameNode(ZSetNameNode Node) {
		this.Transform(Node, ZSetNameNode._Expr);
	}

	@Override
	public void VisitGroupNode(ZGroupNode Node) {
		this.Transform(Node, ZGroupNode._Expr);
	}

	@Override
	public void VisitGetterNode(ZGetterNode Node) {
		this.Transform(Node, ZGetterNode._Recv);
	}

	@Override
	public void VisitSetterNode(ZSetterNode Node) {
		this.Transform(Node, ZSetterNode._Recv);
		this.Transform(Node, ZSetterNode._Expr);
	}

	@Override
	public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.Transform(Node, ZGetIndexNode._Recv);
		this.Transform(Node, ZGetIndexNode._Index);
	}

	@Override
	public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.Transform(Node, ZSetIndexNode._Recv);
		this.Transform(Node, ZSetIndexNode._Index);
		this.Transform(Node, ZSetIndexNode._Expr);
	}

	@Override
	public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.Transform(Node, ZMethodCallNode._Recv);
		this.VisitListNode(Node);
	}

	@Override
	public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.Transform(Node, ZFuncCallNode._Func);
		this.VisitListNode(Node);
	}

	@Override
	public void VisitUnaryNode(ZUnaryNode Node) {
		this.Transform(Node, ZUnaryNode._Recv);
	}

	@Override
	public void VisitNotNode(ZNotNode Node) {
		this.Transform(Node, ZNotNode._Recv);
	}

	@Override
	public void VisitCastNode(ZCastNode Node) {
		this.Transform(Node, ZCastNode._Expr);
	}

	@Override
	public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.Transform(Node, ZInstanceOfNode._Left);
	}

	@Override
	public void VisitBinaryNode(ZBinaryNode Node) {
		this.Transform(Node, ZBinaryNode._Left);
		this.Transform(Node, ZBinaryNode._Right);
	}

	@Override
	public void VisitComparatorNode(ZComparatorNode Node) {
		this.Transform(Node, ZComparatorNode._Left);
		this.Transform(Node, ZComparatorNode._Right);
	}

	@Override
	public void VisitAndNode(ZAndNode Node) {
		this.Transform(Node, ZAndNode._Left);
		this.Transform(Node, ZAndNode._Right);
	}

	@Override
	public void VisitOrNode(ZOrNode Node) {
		this.Transform(Node, ZOrNode._Left);
		this.Transform(Node, ZOrNode._Right);
	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		this.VisitListNode(Node);
	}

	@Override
	public void VisitVarNode(ZVarNode Node) {
		this.Transform(Node, ZVarNode._InitValue);
		this.VisitListNode(Node);
	}

	@Override
	public void VisitIfNode(ZIfNode Node) {
		this.Transform(Node, ZIfNode._Cond);
		this.Transform(Node, ZIfNode._Then);
		this.Transform(Node, ZIfNode._Else);
	}

	@Override
	public void VisitReturnNode(ZReturnNode Node) {
		this.Transform(Node, ZReturnNode._Expr);
	}

	@Override
	public void VisitWhileNode(ZWhileNode Node) {
		this.Transform(Node, ZWhileNode._Cond);
		this.Transform(Node, ZWhileNode._Block);
	}

	@Override
	public void VisitBreakNode(ZBreakNode Node) {
		/* do nothing */
	}

	@Override
	public void VisitThrowNode(ZThrowNode Node) {
		this.Transform(Node, ZThrowNode._Expr);
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		this.Transform(Node, ZTryNode._Try);
		this.Transform(Node, ZTryNode._Catch);
		this.Transform(Node, ZTryNode._Finally);
	}

	//	public void VisitCatchNode(ZCatchNode Node) {
	//		this.Transform(Node, ZCatchNode._Block);
	//	}

	@Override
	public void VisitLetNode(ZLetNode Node) {
		this.Transform(Node, ZLetNode._InitValue);
	}

	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		this.Transform(Node, ZFunctionNode._Block);
	}

	@Override
	public void VisitClassNode(ZClassNode Node) {
		this.VisitListNode(Node);
	}

	@Override
	public void VisitErrorNode(ZErrorNode Node) {
		/* do nothing */
	}



	@Override
	public void EnableVisitor() {
		/* do nothing */
	}

	@Override
	public void StopVisitor() {
		/* do nothing */
	}

	@Override
	public boolean IsVisitable() {
		return false;
	}

	@Override
	public void VisitMacroNode(ZMacroNode FuncNode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitAsmNode(ZAsmNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitTopLevelNode(ZTopLevelNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitSugarNode(ZSugarNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitLocalDefinedNode(ZLocalDefinedNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitDefaultValueNode(ZDefaultValueNode Node) {
		// TODO Auto-generated method stub

	}

}
