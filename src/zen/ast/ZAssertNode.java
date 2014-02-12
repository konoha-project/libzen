package zen.ast;

import zen.parser.ZGenerator;
import zen.type.ZFunc;
import zen.type.ZType;
import zen.type.ZTypeChecker;


public class ZAssertNode extends ZNode {
	public final static int _Expr = 0;
	public ZAssertNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	@Override public String GetVisitName() {
		return "VisitAssertNode";
	}

	@Override public ZNode VisitTypeChecker(ZTypeChecker TypeChecker, ZType ContextType) {
		TypeChecker.CheckTypeAt(this, ZAssertNode._Expr, ZType.BooleanType);
		this.Type = ZType.VoidType;
		return this;
	}

	@Override public ZNode DeSugar(ZGenerator Generator) {
		ZFunc Func = Generator.GetDefinedFunc("Assert", ZType.BooleanType, 1);
		ZFuncCallNode FuncNode = new ZFuncCallNode(this.ParentNode, this.SourceToken, Func);
		FuncNode.Append(this.AST[ZAssertNode._Expr]);
		return FuncNode;
	}

}
