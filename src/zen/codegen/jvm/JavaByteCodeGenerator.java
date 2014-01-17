package zen.codegen.jvm;



import zen.ast.ZenAndNode;
import zen.ast.ZenArrayLiteralNode;
import zen.ast.ZenBinaryNode;
import zen.ast.ZenBlockNode;
import zen.ast.ZenBooleanNode;
import zen.ast.ZenBreakNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
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
import zen.parser.ZenGenerator;

public class JavaByteCodeGenerator extends ZenGenerator {

	protected JavaByteCodeGenerator() {
		super("java", "1.6");
	}

	@Override
	public void VisitEmptyNode(ZenEmptyNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitNullNode(ZenNullNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitBooleanNode(ZenBooleanNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitIntNode(ZenIntNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitFloatNode(ZenFloatNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitStringNode(ZenStringNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitConstPoolNode(ZenConstPoolNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitMapLiteralNode(ZenMapLiteralNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitNewArrayNode(ZenNewArrayNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitNewObjectNode(ZenNewObjectNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitGetLocalNode(ZenGetLocalNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitSetLocalNode(ZenSetLocalNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitGroupNode(ZenGroupNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitGetterNode(ZenGetterNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitSetterNode(ZenSetterNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitGetIndexNode(ZenGetIndexNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitSetIndexNode(ZenSetIndexNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitMethodCallNode(ZenMethodCallNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitFuncCallNode(ZenFuncCallNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitUnaryNode(ZenUnaryNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitNotNode(ZenNotNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitCastNode(ZenCastNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitBinaryNode(ZenBinaryNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitComparatorNode(ZenComparatorNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitAndNode(ZenAndNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitOrNode(ZenOrNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitBlockNode(ZenBlockNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitVarDeclNode(ZenVarDeclNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitIfNode(ZenIfNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitReturnNode(ZenReturnNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitWhileNode(ZenWhileNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitBreakNode(ZenBreakNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitThrowNode(ZenThrowNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitTryNode(ZenTryNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitCatchNode(ZenCatchNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitParamNode(ZenParamNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitFunctionLiteralNode(ZenFunctionLiteralNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitErrorNode(ZenErrorNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitSymbolNode(ZenSymbolNode Node) {
		// TODO Auto-generated method stub

	}

}


