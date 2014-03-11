package zen.ast.sugar;

import zen.ast.ZDesugarNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZListNode;
import zen.ast.ZNode;
import zen.ast.ZStringNode;
import zen.ast.ZSugarNode;
import zen.parser.ZGenerator;
import zen.parser.ZMacroFunc;
import zen.parser.ZTypeChecker;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.util.Var;

public class ZAssertNode extends ZSugarNode {
	public final static int _Expr = 0;

	public ZAssertNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	@Override public ZDesugarNode DeSugar(ZGenerator Generator, ZTypeChecker TypeChecker) {
		@Var ZMacroFunc Func = Generator.GetMacroFunc("assert", ZType.BooleanType, 2);
		if(Func != null) {
			@Var ZListNode FuncNode = TypeChecker.CreateDefinedFuncCallNode(this.ParentNode, this.SourceToken, Func);
			FuncNode.Append(this.AST[ZAssertNode._Expr]);
			FuncNode.Append(new ZStringNode(FuncNode, null, this.GetSourceLocation()));
			return new ZDesugarNode(this, FuncNode);
		}
		else {
			@Var ZFuncCallNode MacroNode = TypeChecker.CreateFuncCallNode(this.ParentNode, this.SourceToken, "assert", ZFuncType._FuncType);
			MacroNode.Append(this.AST[ZAssertNode._Expr]);
			return new ZDesugarNode(this, MacroNode);
		}
	}

}
