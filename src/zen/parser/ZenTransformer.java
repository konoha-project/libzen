package zen.parser;

import java.util.ArrayList;

import zen.ast.GtAndNode;
import zen.ast.GtApplyNode;
import zen.ast.GtArrayLiteralNode;
import zen.ast.GtBinaryNode;
import zen.ast.GtBlockNode;
import zen.ast.GtBooleanNode;
import zen.ast.GtBreakNode;
import zen.ast.GtCastNode;
import zen.ast.GtCatchNode;
import zen.ast.GtConstPoolNode;
import zen.ast.GtErrorNode;
import zen.ast.GtFloatNode;
import zen.ast.GtFuncDeclNode;
import zen.ast.GtFunctionLiteralNode;
import zen.ast.GtGetCapturedNode;
import zen.ast.GtGetIndexNode;
import zen.ast.GtGetLocalNode;
import zen.ast.GtGetterNode;
import zen.ast.GtGroupNode;
import zen.ast.GtIfNode;
import zen.ast.GtInstanceOfNode;
import zen.ast.GtIntNode;
import zen.ast.GtMapLiteralNode;
import zen.ast.GtMethodCallNode;
import zen.ast.GtNewArrayNode;
import zen.ast.GtNewObjectNode;
import zen.ast.GtNullNode;
import zen.ast.GtOrNode;
import zen.ast.GtParamNode;
import zen.ast.GtReturnNode;
import zen.ast.GtSetCapturedNode;
import zen.ast.GtSetIndexNode;
import zen.ast.GtSetLocalNode;
import zen.ast.GtSetterNode;
import zen.ast.GtStringNode;
import zen.ast.GtThrowNode;
import zen.ast.GtTryNode;
import zen.ast.GtUnaryNode;
import zen.ast.GtVarDeclNode;
import zen.ast.GtWhileNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenNode;
import zen.ast.ZenNotNode;

public class ZenTransformer implements ZenVisitor {
	/*field*/public GtBlockNode BlockNode;
	/*field*/private ZenNode ReplacedNode;
	/*field*/private boolean StoppedVisitor;

	public ZenTransformer(GtBlockNode BlockNode) {
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
		int i = 0;
		while (i < NodeList.size()) {
			ZenNode SubNode = NodeList.get(i);
			NodeList.set(i, this.Transform(ParentNode, SubNode));
			if(!this.IsVisitable()) {
				break;
			}
			i = i + 1;
		}
		return true;
	}

	protected GtBlockNode GetBlockNode() {
		return this.BlockNode;
	}

	private int FindInBlockStatementIndex(GtBlockNode BlockNode, ZenNode SubNode) {
		while(SubNode.ParentNode != BlockNode) {
			SubNode = SubNode.ParentNode;
		}
		int i = 0;
		while(i < BlockNode.StatementList.size()) {
			if(BlockNode.StatementList.get(i) == SubNode) {
				return i;
			}
			i = i + 1;
		}
		return -1;
	}

	protected void InsertInBlockStatementBefore(GtBlockNode BlockNode, ZenNode SubNode, ZenNode InsertedNode) {
		int index = this.FindInBlockStatementIndex(BlockNode, SubNode);
		BlockNode.StatementList.add(index, BlockNode.SetChild(InsertedNode));
	}

	protected void ReplaceInBlockStatement(GtBlockNode BlockNode, ZenNode Node, ZenNode ReplacedNode) {
		int index = this.FindInBlockStatementIndex(BlockNode, Node);
		BlockNode.StatementList.set(index, BlockNode.SetChild(ReplacedNode));
	}

	@Override public void VisitNullNode(GtNullNode Node) {
	}

	@Override public void VisitBooleanNode(GtBooleanNode Node) {
	}

	@Override public void VisitIntNode(GtIntNode Node) {
	}

	@Override public void VisitFloatNode(GtFloatNode Node) {
	}

	@Override public void VisitStringNode(GtStringNode Node) {
	}

	@Override public void VisitConstPoolNode(GtConstPoolNode Node) {
	}

	@Override public void VisitArrayLiteralNode(GtArrayLiteralNode Node) {
		this.TransformNodeList(Node, Node.NodeList);
	}

	@Override public void VisitMapLiteralNode(GtMapLiteralNode Node) {
		this.TransformNodeList(Node, Node.NodeList);
	}

	@Override public void VisitNewArrayNode(GtNewArrayNode Node) {
		//TODO
	}

	@Override public void VisitNewObjectNode(GtNewObjectNode Node) {
		//TODO
	}

	@Override public void VisitGetLocalNode(GtGetLocalNode Node) {
	}

	@Override public void VisitSetLocalNode(GtSetLocalNode Node) {
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitGetCapturedNode(GtGetCapturedNode Node) {
	}

	@Override public void VisitSetCapturedNode(GtSetCapturedNode Node) {
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitGroupNode(GtGroupNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitGetterNode(GtGetterNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitSetterNode(GtSetterNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitGetIndexNode(GtGetIndexNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		Node.IndexNode = this.Transform(Node, Node.IndexNode);
	}

	@Override public void VisitSetIndexNode(GtSetIndexNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		Node.IndexNode = this.Transform(Node, Node.IndexNode);
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitMethodCallNode(GtMethodCallNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		this.TransformNodeList(Node, Node.ParamList);
	}

	@Override public void VisitApplyNode(GtApplyNode Node) {
		Node.FuncNode = this.Transform(Node, Node.FuncNode);
		this.TransformNodeList(Node, Node.ParamList);
	}

	@Override public void VisitUnaryNode(GtUnaryNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitNotNode(ZenNotNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitCastNode(GtCastNode Node) {
		Node.ExprNode = this.Transform(Node, Node.ExprNode);
	}

	@Override public void VisitInstanceOfNode(GtInstanceOfNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
	}

	@Override public void VisitAndNode(GtAndNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitOrNode(GtOrNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitBinaryNode(GtBinaryNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitComparatorNode(ZenComparatorNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitBlockNode(GtBlockNode Node) {
		this.TransformNodeList(Node, Node.StatementList);
	}

	@Override public void VisitVarDeclNode(GtVarDeclNode Node) {
		Node.InitNode = this.Transform(Node, Node.InitNode);
		this.TransformNodeList(Node, Node.StatementList);
	}

	@Override public void VisitIfNode(GtIfNode Node) {
		Node.CondNode = this.Transform(Node, Node.CondNode);
		Node.ThenNode = this.Transform(Node, Node.ThenNode);
		if(Node.ElseNode != null) {
			Node.ElseNode = this.Transform(Node, Node.ElseNode);
		}
	}

	@Override public void VisitReturnNode(GtReturnNode Node) {
		if(Node.ValueNode != null) {
			Node.ValueNode = this.Transform(Node, Node.ValueNode);
		}
	}

	@Override public void VisitWhileNode(GtWhileNode Node) {
		Node.CondNode = this.Transform(Node, Node.CondNode);
		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	}

	@Override public void VisitBreakNode(GtBreakNode Node) {
	}

	@Override public void VisitThrowNode(GtThrowNode Node) {
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitTryNode(GtTryNode Node) {
		Node.TryNode = this.Transform(Node, Node.TryNode);
		if(Node.CatchNode != null) {
			Node.CatchNode = this.Transform(Node, Node.CatchNode);
		}
		if(Node.FinallyNode != null) {
			Node.FinallyNode = this.Transform(Node, Node.FinallyNode);
		}
	}

	@Override public void VisitCatchNode(GtCatchNode Node) {
		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	}

	@Override public void VisitParamNode(GtParamNode Node) {
	}

	@Override public void VisitFunctionLiteralNode(GtFunctionLiteralNode Node) {
		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	}

	@Override public void VisitFuncDeclNode(GtFuncDeclNode Node) {
		this.TransformNodeList(Node, Node.ArgumentList);
		if(Node.BodyNode != null) {
			Node.BodyNode = this.Transform(Node, Node.BodyNode);
		}
	}

	@Override public void VisitErrorNode(GtErrorNode Node) {
	}





}
