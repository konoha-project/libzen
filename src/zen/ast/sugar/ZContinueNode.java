package zen.ast.sugar;

import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZErrorNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.parser.ZGenerator;
import zen.type.ZType;
import zen.util.LibZen;
import zen.util.Var;

public class ZContinueNode extends ZSyntaxSugarNode {

	public ZContinueNode(ZNode ParentNode) {
		super(ParentNode, null, 0);
	}

	/**
	while(EXPR) {
        A;
        continue;
	}
	==
	var continue = true;
	while(continue) {
	        continue = false;
	        while($EXPR) {
	                A;
	                continue = true;
	                break;
	        }
	}
	 **/

	private ZWhileNode LookupWhileNode() {
		@Var ZNode Node = this;
		while(Node != null) {
			if(Node instanceof ZWhileNode) {
				return (ZWhileNode)Node;
			}
			Node = Node.ParentNode;
		}
		return null;
	}

	private ZDesugarNode ReplaceContinue(ZNode Node, ZContinueNode FirstNode, ZNode[] NodeList, ZDesugarNode FirstDesugarNode) {
		@Var int i = 0;
		while(i < Node.GetAstSize()) {
			@Var ZNode SubNode = Node.AST[i];
			if(SubNode instanceof ZContinueNode) {
				@Var ZDesugarNode DesugarNode = new ZDesugarNode(SubNode, NodeList);
				if(SubNode == FirstNode) {
					FirstDesugarNode = DesugarNode;
				}
				else {
					Node.SetNode(i, DesugarNode);
				}
				break;
			}
			if(SubNode != null) {
				FirstDesugarNode = this.ReplaceContinue(SubNode, FirstNode, NodeList, FirstDesugarNode);
			}
			i = i + 1;
		}
		return FirstDesugarNode;
	}

	@Override public ZDesugarNode DeSugar(ZGenerator Generator) {
		@Var ZWhileNode WhileNode = this.LookupWhileNode();
		if(WhileNode == null) {
			return new ZDesugarNode(this, new ZErrorNode(this.ParentNode, this.SourceToken, "must be inside while statement"));
		}
		@Var String VarName = Generator.NameUniqueSymbol("continue");
		@Var ZBlockNode ParentBlockNode = WhileNode.GetScopeBlockNode();
		@Var ZVarNode VarNode = new ZVarNode(VarName, ZType.BooleanType, new ZBooleanNode(true));
		@Var ZBlockNode WhileBlockNode = new ZBlockNode(null);
		@Var ZWhileNode ContinueWhile = new ZWhileNode(new ZGetNameNode(VarName, ZType.BooleanType), WhileBlockNode);
		VarNode.Append(ContinueWhile);
		WhileBlockNode.Append(new ZSetNameNode(VarName, new ZBooleanNode(false)));
		WhileBlockNode.Append(WhileNode);
		@Var ZNode[] Nodes = LibZen._NewNodeArray(2);
		Nodes[0] = new ZSetNameNode(VarName, new ZBooleanNode(true));
		Nodes[1] = new ZBreakNode(null);
		ParentBlockNode.ReplaceWith(WhileNode, VarNode);
		return this.ReplaceContinue(WhileNode, this, Nodes, null);
	}

}
