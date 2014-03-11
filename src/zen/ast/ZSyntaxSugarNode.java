package zen.ast;

import zen.parser.ZGenerator;
import zen.parser.ZToken;
import zen.parser.ZTypeChecker;
import zen.parser.ZVisitor;


public abstract class ZSyntaxSugarNode extends ZNode {

	public ZSyntaxSugarNode(ZNode ParentNode, ZToken SourceToken, int Size) {
		super(ParentNode, SourceToken, Size);
	}

	@Override public final void Accept(ZVisitor Visitor) {
		Visitor.VisitSyntaxSugarNode(this);
	}

	public abstract ZDesugarNode DeSugar(ZGenerator Generator, ZTypeChecker TypeChekcer);



}
