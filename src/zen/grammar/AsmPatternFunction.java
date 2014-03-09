package zen.grammar;

import zen.ast.ZAsmMacroNode;
import zen.ast.ZAsmNode;
import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class AsmPatternFunction extends ZMatchFunction {
	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode AsmNode = new ZAsmNode(ParentNode);
		AsmNode = TokenContext.MatchToken(AsmNode, "asm", ZTokenContext._Required);
		AsmNode = TokenContext.MatchToken(AsmNode, "(", ZTokenContext._Required);
		AsmNode = TokenContext.MatchPattern(AsmNode, ZAsmMacroNode._Macro, "$StringLiteral$", ZTokenContext._Required);
		AsmNode = TokenContext.MatchToken(AsmNode, ")", ZTokenContext._Required);
		AsmNode = TokenContext.MatchPattern(AsmNode, ZAsmNode._TypeInfo, "$TypeAnnotation$", ZTokenContext._Optional);
		return AsmNode;
	}
}
