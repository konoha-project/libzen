package zen.parser;

import java.util.ArrayList;

import zen.ast.ZenAndNode;
import zen.ast.ZenArrayLiteralNode;
import zen.ast.ZenBinaryNode;
import zen.ast.ZenBlockNode;
import zen.ast.ZenBooleanNode;
import zen.ast.ZenBreakNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
import zen.ast.ZenClassDeclNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenConstPoolNode;
import zen.ast.ZenEmptyNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFloatNode;
import zen.ast.ZenFuncCallNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionLiteralNode;
import zen.ast.ZenGetIndexNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenGetterNode;
import zen.ast.ZenGroupNode;
import zen.ast.ZenIfNode;
import zen.ast.ZenInstanceOfNode;
import zen.ast.ZenIntNode;
import zen.ast.ZenMapLiteralNode;
import zen.ast.ZenMethodCallNode;
import zen.ast.ZenNewArrayNode;
import zen.ast.ZenNewObjectNode;
import zen.ast.ZenNode;
import zen.ast.ZenNotNode;
import zen.ast.ZenNullNode;
import zen.ast.ZenOrNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenSetIndexNode;
import zen.ast.ZenSetLocalNode;
import zen.ast.ZenSetterNode;
import zen.ast.ZenStringNode;
import zen.ast.ZenSymbolNode;
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenUnaryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast.ZenWhileNode;
import zen.deps.Field;

public class ZenTransformer implements ZenVisitor {
	@Field public ZenBlockNode BlockNode;
	@Field private ZenNode ReplacedNode;
	@Field private boolean StoppedVisitor;

	public ZenTransformer(ZenBlockNode BlockNode) {
		this.BlockNode = BlockNode;
		this.ReplacedNode = null;
		this.StoppedVisitor = false;
	}

	@Override public final void EnableVisitor() {
		this.StoppedVisitor = false;
	}

	@Override public final void StopVisitor() {
		this.StoppedVisitor = true;
	}

	@Override public final boolean IsVisitable() {
		return !this.StoppedVisitor;
	}

	protected void Transformed(ZenNode Node) {
		this.ReplacedNode = Node;
	}

	ZenNode Transform(ZenNode ParentNode, ZenNode Node) {
		if(this.IsVisitable()) {
			ZenNode ReplacedNode = this.ReplacedNode;
			this.ReplacedNode = Node;
			Node.Accept(this);
			ZenNode ReturnNode = this.ReplacedNode;
			this.ReplacedNode = ReplacedNode;
			return ParentNode.SetChild(ReturnNode);
		}
		return Node;
	}

	protected boolean TransformNodeList(ZenNode ParentNode, ArrayList<ZenNode> NodeList) {
		for(int i = 0; i < NodeList.size(); i = i + 1) {
			ZenNode SubNode = NodeList.get(i);
			NodeList.set(i, this.Transform(ParentNode, SubNode));
			if(!this.IsVisitable()) {
				break;
			}
		}
		return true;
	}

	protected ZenBlockNode GetBlockNode() {
		return this.BlockNode;
	}

	private int FindInBlockStatementIndex(ZenBlockNode BlockNode, ZenNode SubNode) {
		while(SubNode.ParentNode != BlockNode) {
			SubNode = SubNode.ParentNode;
		}
		for(int i = 0; i < BlockNode.StmtList.size(); i = i + 1) {
			if(BlockNode.StmtList.get(i) == SubNode) {
				return i;
			}
		}
		return -1;
	}

	protected void InsertInBlockStatementBefore(ZenBlockNode BlockNode, ZenNode SubNode, ZenNode InsertedNode) {
		int index = this.FindInBlockStatementIndex(BlockNode, SubNode);
		BlockNode.StmtList.add(index, BlockNode.SetChild(InsertedNode));
	}

	protected void ReplaceInBlockStatement(ZenBlockNode BlockNode, ZenNode Node, ZenNode ReplacedNode) {
		int index = this.FindInBlockStatementIndex(BlockNode, Node);
		BlockNode.StmtList.set(index, BlockNode.SetChild(ReplacedNode));
	}

	@Override public void VisitEmptyNode(ZenEmptyNode Node) {
	}

	@Override public void VisitNullNode(ZenNullNode Node) {
	}

	@Override public void VisitBooleanNode(ZenBooleanNode Node) {
	}

	@Override public void VisitIntNode(ZenIntNode Node) {
	}

	@Override public void VisitFloatNode(ZenFloatNode Node) {
	}

	@Override public void VisitStringNode(ZenStringNode Node) {
	}

	@Override public void VisitConstPoolNode(ZenConstPoolNode Node) {
	}

	@Override public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
		this.TransformNodeList(Node, Node.NodeList);
	}

	@Override public void VisitMapLiteralNode(ZenMapLiteralNode Node) {
		this.TransformNodeList(Node, Node.NodeList);
	}

	@Override public void VisitNewArrayNode(ZenNewArrayNode Node) {
		//TODO
	}

	@Override public void VisitNewObjectNode(ZenNewObjectNode Node) {
		//TODO
	}

	@Override public void VisitSymbolNode(ZenSymbolNode Node) {

	}

	@Override public void VisitGetLocalNode(ZenGetLocalNode Node) {
	}

	@Override public void VisitSetLocalNode(ZenSetLocalNode Node) {
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitGroupNode(ZenGroupNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitGetterNode(ZenGetterNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitSetterNode(ZenSetterNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitGetIndexNode(ZenGetIndexNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		Node.IndexNode = this.Transform(Node, Node.IndexNode);
	}

	@Override public void VisitSetIndexNode(ZenSetIndexNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		Node.IndexNode = this.Transform(Node, Node.IndexNode);
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitMethodCallNode(ZenMethodCallNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		this.TransformNodeList(Node, Node.ParamList);
	}

	@Override public void VisitFuncCallNode(ZenFuncCallNode Node) {
		Node.FuncNode = this.Transform(Node, Node.FuncNode);
		this.TransformNodeList(Node, Node.ParamList);
	}

	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitNotNode(ZenNotNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitCastNode(ZenCastNode Node) {
		Node.ExprNode = this.Transform(Node, Node.ExprNode);
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitOrNode(ZenOrNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitComparatorNode(ZenComparatorNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitBlockNode(ZenBlockNode Node) {
		this.TransformNodeList(Node, Node.StmtList);
	}

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		Node.InitNode = this.Transform(Node, Node.InitNode);
		this.TransformNodeList(Node, Node.StmtList);
	}

	@Override public void VisitIfNode(ZenIfNode Node) {
		Node.CondNode = this.Transform(Node, Node.CondNode);
		Node.ThenNode = this.Transform(Node, Node.ThenNode);
		if(Node.ElseNode != null) {
			Node.ElseNode = this.Transform(Node, Node.ElseNode);
		}
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		if(Node.ValueNode != null) {
			Node.ValueNode = this.Transform(Node, Node.ValueNode);
		}
	}

	@Override public void VisitWhileNode(ZenWhileNode Node) {
		Node.CondNode = this.Transform(Node, Node.CondNode);
		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	}

	@Override public void VisitBreakNode(ZenBreakNode Node) {
	}

	@Override public void VisitThrowNode(ZenThrowNode Node) {
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitTryNode(ZenTryNode Node) {
		Node.TryNode = this.Transform(Node, Node.TryNode);
		if(Node.CatchNode != null) {
			Node.CatchNode = this.Transform(Node, Node.CatchNode);
		}
		if(Node.FinallyNode != null) {
			Node.FinallyNode = this.Transform(Node, Node.FinallyNode);
		}
	}

	@Override public void VisitCatchNode(ZenCatchNode Node) {
		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	}

	@Override public void VisitParamNode(ZenParamNode Node) {
	}

	@Override public void VisitFunctionLiteralNode(ZenFunctionLiteralNode Node) {
		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	}

	@Override public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
		this.TransformNodeList(Node, Node.ArgumentList);
		if(Node.BodyNode != null) {
			Node.BodyNode = this.Transform(Node, Node.BodyNode);
		}
	}

	@Override public void VisitClassDeclNode(ZenClassDeclNode Node) {

	}


	@Override public void VisitErrorNode(ZenErrorNode Node) {
	}





}
