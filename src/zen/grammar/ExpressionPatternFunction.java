package zen.grammar;

import zen.ast.ZErrorNode;
import zen.ast.ZNode;
import zen.parser.ZNameSpace;
import zen.parser.ZPatternToken;
import zen.parser.ZSyntax;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.util.Var;
import zen.util.ZMatchFunction;

public class ExpressionPatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return ExpressionPatternFunction._DispatchPattern(ParentNode, TokenContext, LeftNode, false, true);
	}

	public final static ZSyntax _GetRightPattern(ZNameSpace NameSpace, ZTokenContext TokenContext) {
		@Var ZToken Token = TokenContext.GetToken();
		if(Token != ZToken._NullToken) {
			@Var ZSyntax Pattern = NameSpace.GetRightSyntaxPattern(Token.GetText());
			return Pattern;
		}
		return null;
	}

	public final static ZNode _DispatchPattern(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode, boolean AllowStatement, boolean AllowBinary) {
		@Var ZToken Token = TokenContext.GetToken();
		@Var ZSyntax Pattern = null;
		@Var ZNameSpace NameSpace = ParentNode.GetNameSpace();
		if(Token instanceof ZPatternToken) {
			Pattern = ((ZPatternToken)Token).PresetPattern;
		}
		else {
			Pattern = NameSpace.GetSyntaxPattern(Token.GetText());
		}
		//System.out.println("Pattern=" + Pattern + " by '" + Token.GetText() + "'");
		if(Pattern != null) {
			if(Pattern.IsStatement && !AllowStatement) {
				return new ZErrorNode(ParentNode, Token, Token.GetText() + " statement is not here");
			}
			LeftNode = TokenContext.ApplyMatchPattern(ParentNode, LeftNode, Pattern, ZTokenContext._Required);
		}
		else {
			if(Token.IsNameSymbol()) {
				if(AllowStatement) {
					Pattern = NameSpace.GetSyntaxPattern("$SymbolStatement$");
				}
				else {
					Pattern = NameSpace.GetSyntaxPattern("$SymbolExpression$");
				}
				LeftNode = TokenContext.ApplyMatchPattern(ParentNode, LeftNode, Pattern, ZTokenContext._Required);
			}
			else {
				if(AllowStatement) {
					return TokenContext.CreateExpectedErrorNode(Token, "statement");
				}
				else {
					return TokenContext.CreateExpectedErrorNode(Token, "expression");
				}
			}
		}
		if(!Pattern.IsStatement) {
			while(LeftNode != null && !LeftNode.IsErrorNode()) {
				@Var ZSyntax RightPattern = ExpressionPatternFunction._GetRightPattern(NameSpace, TokenContext);
				if(RightPattern == null) {
					break;
				}
				if(!AllowBinary && RightPattern.IsBinaryOperator()) {
					break;
				}
				LeftNode = TokenContext.ApplyMatchPattern(ParentNode, LeftNode, RightPattern, ZTokenContext._Required);
			}
		}
		return LeftNode;
	}

}
