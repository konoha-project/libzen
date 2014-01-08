package zen.codegen.jython;

import zen.ast.GtBlockNode;
import zen.ast.GtErrorNode;
import zen.ast.GtFuncDeclNode;
import zen.ast.GtFunctionLiteralNode;
import zen.ast.GtGetLocalNode;
import zen.ast.GtReturnNode;
import zen.parser.ZenTransformer;

public class PythonTransformer extends ZenTransformer {

	public PythonTransformer(GtBlockNode BlockNode) {
		super(BlockNode);
		// TODO Auto-generated constructor stub
	}
	@Override public void VisitFunctionLiteralNode(GtFunctionLiteralNode Node) {
		GtReturnNode ReturnNode = Node.BodyNode.ToReturnNode();
		if(ReturnNode != null && ReturnNode.ValueNode != null) {
			Node.BodyNode = Node.SetChild(ReturnNode);
		}
		else {
			String FuncName = "lambda" + 1;
			GtFuncDeclNode FuncDeclNode = new GtFuncDeclNode(Node.SourceToken, this.BlockNode.NameSpace, FuncName);
			//			this.CurrentBuilder.Append("def");
			//			this.CurrentBuilder.AppendToken("lambda");
			//			this.VisitParamList("(", Node.ArgumentList, ")");
			//			this.GenerateCode(Node.BodyNode);
			this.InsertInBlockStatementBefore(this.GetBlockNode(), Node, FuncDeclNode);
			this.Transformed(new GtGetLocalNode(null, FuncName));
		}

	}
	@Override public void VisitErrorNode(GtErrorNode Node) {
		this.ReplaceInBlockStatement(this.GetBlockNode(), Node, Node);
		this.StopVisitor();

	}

}
