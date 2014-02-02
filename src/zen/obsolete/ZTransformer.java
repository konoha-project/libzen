package zen.obsolete;

import java.util.ArrayList;

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassDeclNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZLetNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewArrayNode;
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
import zen.ast.ZSymbolNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.deps.Field;
import zen.parser.ZVisitor;

public class ZTransformer extends ZVisitor {
	@Field public ZBlockNode BlockNode;
	@Field private ZNode ReplacedNode;
	@Field private boolean StoppedVisitor;

	public ZTransformer(ZBlockNode BlockNode) {
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

	protected void Transformed(ZNode Node) {
		this.ReplacedNode = Node;
	}

	ZNode Transform(ZNode ParentNode, ZNode Node) {
		if(this.IsVisitable()) {
			ZNode ReplacedNode = this.ReplacedNode;
			this.ReplacedNode = Node;
			Node.Accept(this);
			ZNode ReturnNode = this.ReplacedNode;
			this.ReplacedNode = ReplacedNode;
			return ParentNode.SetChild(ReturnNode);
		}
		return Node;
	}

	protected boolean TransformNodeList(ZNode ParentNode, ArrayList<ZNode> NodeList) {
		for(int i = 0; i < NodeList.size(); i = i + 1) {
			ZNode SubNode = NodeList.get(i);
			NodeList.set(i, this.Transform(ParentNode, SubNode));
			if(!this.IsVisitable()) {
				break;
			}
		}
		return true;
	}

	protected ZBlockNode GetBlockNode() {
		return this.BlockNode;
	}

	private int FindInBlockStatementIndex(ZBlockNode BlockNode, ZNode SubNode) {
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

	protected void InsertInBlockStatementBefore(ZBlockNode BlockNode, ZNode SubNode, ZNode InsertedNode) {
		int index = this.FindInBlockStatementIndex(BlockNode, SubNode);
		BlockNode.StmtList.add(index, BlockNode.SetChild(InsertedNode));
	}

	protected void ReplaceInBlockStatement(ZBlockNode BlockNode, ZNode Node, ZNode ReplacedNode) {
		int index = this.FindInBlockStatementIndex(BlockNode, Node);
		BlockNode.StmtList.set(index, BlockNode.SetChild(ReplacedNode));
	}

	@Override public void VisitNullNode(ZNullNode Node) {
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
	}

	@Override public void VisitIntNode(ZIntNode Node) {
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
	}

	@Override public void VisitStringNode(ZStringNode Node) {
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.TransformNodeList(Node, Node.NodeList);
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.TransformNodeList(Node, Node.NodeList);
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		//TODO
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		//TODO
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {

	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		Node.IndexNode = this.Transform(Node, Node.IndexNode);
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		Node.IndexNode = this.Transform(Node, Node.IndexNode);
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
		this.TransformNodeList(Node, Node.ParamList);
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		Node.FuncNode = this.Transform(Node, Node.FuncNode);
		this.TransformNodeList(Node, Node.ParamList);
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		Node.RecvNode = this.Transform(Node, Node.RecvNode);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		Node.ExprNode = this.Transform(Node, Node.ExprNode);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		Node.LeftNode = this.Transform(Node, Node.LeftNode);
		Node.RightNode = this.Transform(Node, Node.RightNode);
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		this.TransformNodeList(Node, Node.StmtList);
	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		Node.InitNode = this.Transform(Node, Node.InitNode);
		this.TransformNodeList(Node, Node.StmtList);
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Node.CondNode = this.Transform(Node, Node.CondNode);
		Node.ThenNode = this.Transform(Node, Node.ThenNode);
		if(Node.ElseNode != null) {
			Node.ElseNode = this.Transform(Node, Node.ElseNode);
		}
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		if(Node.ValueNode != null) {
			Node.ValueNode = this.Transform(Node, Node.ValueNode);
		}
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		Node.CondNode = this.Transform(Node, Node.CondNode);
		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		Node.ValueNode = this.Transform(Node, Node.ValueNode);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		Node.TryNode = this.Transform(Node, Node.TryNode);
		if(Node.CatchNode != null) {
			Node.CatchNode = this.Transform(Node, Node.CatchNode);
		}
		if(Node.FinallyNode != null) {
			Node.FinallyNode = this.Transform(Node, Node.FinallyNode);
		}
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	}


	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		//		Node.BodyNode = this.Transform(Node, Node.BodyNode);
	}

	//	public void VisitFuncDeclNode(ZFunctionNode/*Decl*/ Node) {
	//		this.TransformNodeList(Node, Node.ParamList);
	//		if(Node.BodyNode != null) {
	//			Node.BodyNode = this.Transform(Node, Node.BodyNode);
	//		}
	//	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
		for (int i = 0; i < Node.FieldList.size(); i++) {
			Node.FieldList.set(i, (ZFieldNode) this.Transform(Node, Node.FieldList.get(i)));
		}
	}


	@Override public void VisitErrorNode(ZErrorNode Node) {
	}

	@Override public void VisitExtendedNode(ZNode Node) {
	}

	@Override
	public void VisitLetNode(ZLetNode Node) {
		// TODO Auto-generated method stub

	}





}
