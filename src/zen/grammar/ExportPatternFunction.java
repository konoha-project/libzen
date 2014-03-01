package zen.grammar;

import zen.ast.ZClassNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZLetNode;
import zen.ast.ZNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class ExportPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZToken NameToken = TokenContext.GetToken(ZTokenContext._MoveNext);
		@Var ZNode Node = TokenContext.ParsePattern(ParentNode, "function", ZTokenContext._Optional);
		if(Node instanceof ZFunctionNode) {
			((ZFunctionNode)Node).IsExport = true;
			return Node;
		}
		Node = TokenContext.ParsePattern(ParentNode, "let", ZTokenContext._Optional);
		if(Node instanceof ZLetNode) {
			((ZLetNode)Node).IsExport = true;
			return Node;
		}
		Node = TokenContext.ParsePattern(ParentNode, "class", ZTokenContext._Optional);
		if(Node instanceof ZClassNode) {
			((ZClassNode)Node).IsExport = true;
			return Node;
		}

		return new ZErrorNode(ParentNode, NameToken, "export function, class, or let");
	}


}
