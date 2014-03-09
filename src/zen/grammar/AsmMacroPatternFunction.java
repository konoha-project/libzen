package zen.grammar;

import zen.ast.ZAsmMacroNode;
import zen.ast.ZNode;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class AsmMacroPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var ZNode AsmNode = new ZAsmMacroNode(ParentNode);
		AsmNode = TokenContext.MatchToken(AsmNode, "asm", ZTokenContext._Required);
		AsmNode = TokenContext.MatchToken(AsmNode, "macro", ZTokenContext._Required);
		AsmNode = TokenContext.MatchPattern(AsmNode, ZAsmMacroNode._NameInfo, "$StringLiteral$", ZTokenContext._Required);
		AsmNode = TokenContext.MatchPattern(AsmNode, ZAsmMacroNode._Macro, "$StringLiteral$", ZTokenContext._Required);
		AsmNode = TokenContext.MatchPattern(AsmNode, ZAsmMacroNode._TypeInfo, "$TypeAnnotation$", ZTokenContext._Required);
		return AsmNode;
	}

}
