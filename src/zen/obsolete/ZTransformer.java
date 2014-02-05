package zen.obsolete;

import zen.parser.ZVisitor;

public abstract class ZTransformer extends ZVisitor {
	//	@Field public ZBlockNode BlockNode;
	//	@Field private ZNode ReplacedNode;
	//	@Field private boolean StoppedVisitor;
	//
	//	public ZTransformer(ZBlockNode BlockNode) {
	//		this.BlockNode = BlockNode;
	//		this.ReplacedNode = null;
	//		this.StoppedVisitor = false;
	//	}
	//
	//	@Override public final void EnableVisitor() {
	//		this.StoppedVisitor = false;
	//	}
	//
	//	@Override public final void StopVisitor() {
	//		this.StoppedVisitor = true;
	//	}
	//
	//	@Override public final boolean IsVisitable() {
	//		return !this.StoppedVisitor;
	//	}
	//
	//	protected void Transformed(ZNode Node) {
	//		this.ReplacedNode = Node;
	//	}
	//
	//	ZNode Transform(ZNode ParentNode, ZNode Node) {
	//		if(this.IsVisitable()) {
	//			ZNode ReplacedNode = this.ReplacedNode;
	//			this.ReplacedNode = Node;
	//			Node.Accept(this);
	//			ZNode ReturnNode = this.ReplacedNode;
	//			this.ReplacedNode = ReplacedNode;
	//			return ParentNode.SetChild(ReturnNode);
	//		}
	//		return Node;
	//	}
	//
	//	protected boolean TransformNodeList(ZNode ParentNode, ArrayList<ZNode> NodeList) {
	//		for(int i = 0; i < NodeList.size(); i = i + 1) {
	//			ZNode SubNode = NodeList.get(i);
	//			NodeList.set(i, this.Transform(ParentNode, SubNode));
	//			if(!this.IsVisitable()) {
	//				break;
	//			}
	//		}
	//		return true;
	//	}
	//
	//	protected ZBlockNode GetBlockNode() {
	//		return this.BlockNode;
	//	}
	//
	//	private int FindInBlockStatementIndex(ZBlockNode BlockNode, ZNode SubNode) {
	//		while(SubNode.ParentNode != BlockNode) {
	//			SubNode = SubNode.ParentNode;
	//		}
	//		for(int i = 0; i < BlockNode.GetParamSize(); i = i + 1) {
	//			if(BlockNode.GetParam(i) == SubNode) {
	//				return i;
	//			}
	//		}
	//		return -1;
	//	}
	//
	//	protected void InsertInBlockStatementBefore(ZBlockNode BlockNode, ZNode SubNode, ZNode InsertedNode) {
	//		int index = this.FindInBlockStatementIndex(BlockNode, SubNode);
	//		BlockNode.StmtList.add(index, BlockNode.SetChild(InsertedNode));
	//	}
	//
	//	protected void ReplaceInBlockStatement(ZBlockNode BlockNode, ZNode Node, ZNode ReplacedNode) {
	//		int index = this.FindInBlockStatementIndex(BlockNode, Node);
	//		BlockNode.StmtList.set(index, BlockNode.SetChild(ReplacedNode));
	//	}
	//
	//	@Override public void VisitNullNode(ZNullNode Node) {
	//	}
	//
	//	@Override public void VisitBooleanNode(ZBooleanNode Node) {
	//	}
	//
	//	@Override public void VisitIntNode(ZIntNode Node) {
	//	}
	//
	//	@Override public void VisitFloatNode(ZFloatNode Node) {
	//	}
	//
	//	@Override public void VisitStringNode(ZStringNode Node) {
	//	}
	//
	//	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
	//		this.TransformNodeList(Node, Node.NodeList);
	//	}
	//
	//	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
	//		this.TransformNodeList(Node, Node.NodeList);
	//	}
	//
	//	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
	//		//TODO
	//	}
	//
	//	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
	//		//TODO
	//	}
	//
	//	@Override public void VisitSymbolNode(ZSymbolNode Node) {
	//
	//	}
	//
	//	@Override public void VisitGetNameNode(ZGetNameNode Node) {
	//	}
	//
	//	@Override public void VisitSetNameNode(ZSetNameNode Node) {
	//		Node.AST[ZSetNameNode.Expr] = this.Transform(Node, Node.AST[ZSetNameNode.Expr]);
	//	}
	//
	//	@Override public void VisitGroupNode(ZGroupNode Node) {
	//		Node.AST[ZGetterNode.Recv] = this.Transform(Node, Node.AST[ZGetterNode.Recv]);
	//	}
	//
	//	@Override public void VisitGetterNode(ZGetterNode Node) {
	//		Node.AST[ZGetterNode.Recv] = this.Transform(Node, Node.AST[ZGetterNode.Recv]);
	//	}
	//
	//	@Override public void VisitSetterNode(ZSetterNode Node) {
	//		Node.AST[ZGetterNode.Recv] = this.Transform(Node, Node.AST[ZGetterNode.Recv]);
	//		Node.AST[ZSetterNode.Expr] = this.Transform(Node, Node.AST[ZSetterNode.Expr]);
	//	}
	//
	//	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
	//		Node.AST[ZGetterNode.Recv] = this.Transform(Node, Node.AST[ZGetterNode.Recv]);
	//		Node.AST[ZGetIndexNode.Index] = this.Transform(Node, Node.AST[ZGetIndexNode.Index]);
	//	}
	//
	//	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
	//		Node.AST[ZGetterNode.Recv] = this.Transform(Node, Node.AST[ZGetterNode.Recv]);
	//		Node.AST[ZSetIndexNode.Index] = this.Transform(Node, Node.AST[ZSetIndexNode.Index]);
	//		Node.AST[ZSetIndexNode.Expr] = this.Transform(Node, Node.AST[ZSetIndexNode.Expr]);
	//	}
	//
	//	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
	//		Node.AST[ZGetterNode.Recv] = this.Transform(Node, Node.AST[ZGetterNode.Recv]);
	//		this.TransformNodeList(Node, Node.ParamList);
	//	}
	//
	//	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
	//		Node.AST[ZFuncCallNode.Func] = this.Transform(Node, Node.AST[ZFuncCallNode.Func]);
	//		this.TransformNodeList(Node, Node.ParamList);
	//	}
	//
	//	@Override public void VisitUnaryNode(ZUnaryNode Node) {
	//		Node.AST[ZGetterNode.Recv] = this.Transform(Node, Node.AST[ZGetterNode.Recv]);
	//	}
	//
	//	@Override public void VisitNotNode(ZNotNode Node) {
	//		Node.AST[ZGetterNode.Recv] = this.Transform(Node, Node.AST[ZGetterNode.Recv]);
	//	}
	//
	//	@Override public void VisitCastNode(ZCastNode Node) {
	//		Node.AST[ZCastNode.Expr] = this.Transform(Node, Node.AST[ZCastNode.Expr]);
	//	}
	//
	//	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
	//		Node.AST[ZBinaryNode.Left] = this.Transform(Node, Node.AST[ZBinaryNode.Left]);
	//	}
	//
	//	@Override public void VisitAndNode(ZAndNode Node) {
	//		Node.AST[ZBinaryNode.Left] = this.Transform(Node, Node.AST[ZBinaryNode.Left]);
	//		Node.AST[ZBinaryNode.Right] = this.Transform(Node, Node.AST[ZBinaryNode.Right]);
	//	}
	//
	//	@Override public void VisitOrNode(ZOrNode Node) {
	//		Node.AST[ZBinaryNode.Left] = this.Transform(Node, Node.AST[ZBinaryNode.Left]);
	//		Node.AST[ZBinaryNode.Right] = this.Transform(Node, Node.AST[ZBinaryNode.Right]);
	//	}
	//
	//	@Override public void VisitBinaryNode(ZBinaryNode Node) {
	//		Node.AST[ZBinaryNode.Left] = this.Transform(Node, Node.AST[ZBinaryNode.Left]);
	//		Node.AST[ZBinaryNode.Right] = this.Transform(Node, Node.AST[ZBinaryNode.Right]);
	//	}
	//
	//	@Override public void VisitComparatorNode(ZComparatorNode Node) {
	//		Node.AST[ZBinaryNode.Left] = this.Transform(Node, Node.AST[ZBinaryNode.Left]);
	//		Node.AST[ZBinaryNode.Right] = this.Transform(Node, Node.AST[ZBinaryNode.Right]);
	//	}
	//
	//	@Override public void VisitBlockNode(ZBlockNode Node) {
	//		this.TransformNodeList(Node, Node.StmtList);
	//	}
	//
	//	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
	//		Node.AST[ZVarDeclNode.InitValue] = this.Transform(Node, Node.AST[ZVarDeclNode.InitValue]);
	//		this.TransformNodeList(Node, Node.StmtList);
	//	}
	//
	//	@Override public void VisitIfNode(ZIfNode Node) {
	//		Node.AST[ZIfNode.Cond] = this.Transform(Node, Node.AST[ZIfNode.Cond]);
	//		Node.AST[ZIfNode.Then] = this.Transform(Node, Node.AST[ZIfNode.Then]);
	//		if(Node.AST[ZIfNode.Else] != null) {
	//			Node.AST[ZIfNode.Else] = this.Transform(Node, Node.AST[ZIfNode.Else]);
	//		}
	//	}
	//
	//	@Override public void VisitReturnNode(ZReturnNode Node) {
	//		if(Node.AST[ZReturnNode.Expr] != null) {
	//			Node.AST[ZReturnNode.Expr] = this.Transform(Node, Node.AST[ZReturnNode.Expr]);
	//		}
	//	}
	//
	//	@Override public void VisitWhileNode(ZWhileNode Node) {
	//		Node.AST[ZWhileNode.Cond] = this.Transform(Node, Node.AST[ZWhileNode.Cond]);
	//		Node.AST[ZWhileNode.Block] = this.Transform(Node, Node.AST[ZWhileNode.Block]);
	//	}
	//
	//	@Override public void VisitBreakNode(ZBreakNode Node) {
	//	}
	//
	//	@Override public void VisitThrowNode(ZThrowNode Node) {
	//		Node.AST[ZThrowNode.Expr] = this.Transform(Node, Node.AST[ZThrowNode.Expr]);
	//	}
	//
	//	@Override public void VisitTryNode(ZTryNode Node) {
	//		Node.AST[ZTryNode.Try] = this.Transform(Node, Node.AST[ZTryNode.Try]);
	//		if(Node.AST[ZTryNode.Catch] != null) {
	//			Node.AST[ZTryNode.Catch] = this.Transform(Node, Node.AST[ZTryNode.Catch]);
	//		}
	//		if(Node.AST[ZTryNode.Finally] != null) {
	//			Node.AST[ZTryNode.Finally] = this.Transform(Node, Node.AST[ZTryNode.Finally]);
	//		}
	//	}
	//
	//	@Override public void VisitCatchNode(ZCatchNode Node) {
	//		Node.AST[ZCatchNode.Block] = this.Transform(Node, Node.AST[ZCatchNode.Block]);
	//	}
	//
	//
	//	@Override public void VisitFunctionNode(ZFunctionNode Node) {
	//		//		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	//	}
	//
	//	//	public void VisitFuncDeclNode(ZFunctionNode/*Decl*/ Node) {
	//	//		this.TransformNodeList(Node, Node.ParamList);
	//	//		if(Node.BodyNode != null) {
	//	//			Node.BodyNode = this.Transform(Node, Node.BodyNode);
	//	//		}
	//	//	}
	//
	//	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
	//		for (int i = 0; i < Node.GetParamSize(); i++) {
	//			Node.FieldList.set(i, (ZFieldNode) this.Transform(Node, Node.GetFieldNode(i)));
	//		}
	//	}
	//
	//
	//	@Override public void VisitErrorNode(ZErrorNode Node) {
	//	}
	//
	//	@Override public void VisitExtendedNode(ZNode Node) {
	//	}
	//
	//	@Override
	//	public void VisitLetNode(ZLetNode Node) {
	//		// TODO Auto-generated method stub
	//
	//	}
	//
	//
	//
	//

}
