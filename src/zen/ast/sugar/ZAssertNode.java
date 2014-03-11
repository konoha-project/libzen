package zen.ast.sugar;

import zen.ast.ZDesugarNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZMacroNode;
import zen.ast.ZNode;
import zen.ast.ZStringNode;
import zen.ast.ZSyntaxSugarNode;
import zen.parser.ZGenerator;
import zen.parser.ZMacroFunc;
import zen.type.ZType;
import zen.util.Var;

public class ZAssertNode extends ZSyntaxSugarNode {
	public final static int _Expr = 0;

	public ZAssertNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	@Override public ZDesugarNode DeSugar(ZGenerator Generator) {
		@Var ZMacroFunc Func = Generator.GetMacroFunc("assert", ZType.BooleanType, 2);
		if(Func != null) {
			@Var ZMacroNode MacroNode = new ZMacroNode(this.ParentNode, this.SourceToken, Func);
			MacroNode.Append(this.AST[ZAssertNode._Expr]);
			MacroNode.Append(new ZStringNode(MacroNode, null, this.GetSourceLocation()));
			return new ZDesugarNode(this, MacroNode);
		}
		else {
			@Var ZFuncCallNode MacroNode = new ZFuncCallNode(this.ParentNode, "assert", ZType.VarType);
			MacroNode.Append(this.AST[ZAssertNode._Expr]);
			//MacroNode.Append(new ZStringNode(MacroNode, null, this.GetSourceLocation()));
			return new ZDesugarNode(this, MacroNode);
		}
	}

}
