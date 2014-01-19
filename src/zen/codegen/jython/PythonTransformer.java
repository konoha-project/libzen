package zen.codegen.jython;

import zen.ast.ZenBlockNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenReturnNode;
import zen.parser.ZenTransformer;

public class PythonTransformer extends ZenTransformer {

	public PythonTransformer(ZenBlockNode BlockNode) {
		super(BlockNode);
		// TODO Auto-generated constructor stub
	}
	@Override public void VisitFunctionNode(ZenFunctionNode Node) {
		ZenReturnNode ReturnNode = Node.BodyNode.ToReturnNode();
		if(ReturnNode != null && ReturnNode.ValueNode != null) {
			Node.BodyNode = Node.SetChild(ReturnNode);
		}
		else {
			String FuncName = "lambda" + 1;
			ZenFuncDeclNode FuncDeclNode = new ZenFuncDeclNode(Node.SourceToken, this.BlockNode.NameSpace, FuncName);
			//			this.CurrentBuilder.Append("def");
			//			this.CurrentBuilder.AppendToken("lambda");
			//			this.VisitParamList("(", Node.ArgumentList, ")");
			//			this.GenerateCode(Node.BodyNode);
			this.InsertInBlockStatementBefore(this.GetBlockNode(), Node, FuncDeclNode);
			this.Transformed(new ZenGetLocalNode(null, FuncName));
		}

	}
	@Override public void VisitErrorNode(ZenErrorNode Node) {
		this.ReplaceInBlockStatement(this.GetBlockNode(), Node, Node);
		this.StopVisitor();

	}

}
