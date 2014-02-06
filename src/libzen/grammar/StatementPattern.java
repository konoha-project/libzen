package libzen.grammar;

import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZTokenContext;

public class StatementPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		@Var boolean Rememberd = TokenContext.SetParseFlag(ZTokenContext.AllowSkipIndent);
		//		@Var ZAnnotationNode AnnotationNode = (ZAnnotationNode)TokenContext.ParsePattern(ParentNode, "$Annotation$", ZTokenContext.Optional2);
		TokenContext.SetParseFlag(ZTokenContext.NotAllowSkipIndent);
		@Var ZNode StmtNode = ExpressionPattern.DispatchPattern(ParentNode, TokenContext, null, true, true);
		StmtNode = TokenContext.MatchPattern(StmtNode, ZNode.Nop, ";", ZTokenContext.Required);
		//		if(AnnotationNode != null) {
		//			AnnotationNode.Append(StmtNode);
		//			StmtNode = AnnotationNode;
		//		}
		TokenContext.SetParseFlag(Rememberd);
		return StmtNode;
	}

}
