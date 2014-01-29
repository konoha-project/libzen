package zen.codegen.jython;

import zen.ast.ZBlockNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFunctionNode;
import zen.parser.ZTransformer;

public class PythonTransformer extends ZTransformer {

	public PythonTransformer(ZBlockNode BlockNode) {
		super(BlockNode);
		// TODO Auto-generated constructor stub
	}
	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		//		ZReturnNode ReturnNode = Node.BodyNode.ToReturnNode();
		//		if(ReturnNode != null && ReturnNode.ValueNode != null) {
		//			Node.BodyNode = Node.SetChild(ReturnNode);
		//		}
		//		else {
		//			String FuncName = "lambda" + 1;
		//			ZFunctionNode/*Decl*/ FuncDeclNode = new ZFunctionNode/*Decl*/(Node.SourceToken, this.BlockNode.NameSpace, FuncName);
		//			//			this.CurrentBuilder.Append("def");
		//			//			this.CurrentBuilder.AppendToken("lambda");
		//			//			this.VisitParamList("(", Node.ArgumentList, ")");
		//			//			this.GenerateCode(Node.BodyNode);
		//			this.InsertInBlockStatementBefore(this.GetBlockNode(), Node, FuncDeclNode);
		//			this.Transformed(new ZGetLocalNode(null, FuncName));
		//		}
		//
	}
	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.ReplaceInBlockStatement(this.GetBlockNode(), Node, Node);
		this.StopVisitor();

	}

}
