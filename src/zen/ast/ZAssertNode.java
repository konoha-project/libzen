package zen.ast;

import zen.parser.ZGenerator;
import zen.type.ZFunc;
import zen.type.ZType;


public class ZAssertNode extends ZNode {
	public final static int _Expr = 0;
	public ZAssertNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	@Override public ZSugarNode DeSugar(ZGenerator Generator) {
		ZFunc Func = Generator.GetDefinedFunc("Assert", ZType.BooleanType, 2);
		ZFuncCallNode FuncNode = new ZFuncCallNode(this.ParentNode, this.SourceToken, Func);
		FuncNode.Append(this.AST[ZAssertNode._Expr]);
		FuncNode.Append(new ZStringNode(FuncNode, null, this.GetSourceLocation()));
		return new ZSugarNode(this, FuncNode);
	}

}
