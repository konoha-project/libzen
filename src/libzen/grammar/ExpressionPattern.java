package libzen.grammar;

import zen.ast.ZErrorNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.deps.ZenMatchFunction;
import zen.parser.ZNameSpace;
import zen.parser.ZPatternToken;
import zen.parser.ZSyntaxPattern;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;

public class ExpressionPattern extends ZenMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return ExpressionPattern.DispatchPattern(ParentNode, TokenContext, LeftNode, false, true);
	}

	static ZSyntaxPattern GetSuffixPattern(ZNameSpace NameSpace, ZTokenContext TokenContext) {
		@Var ZToken Token = TokenContext.GetToken();
		if(Token != ZToken.NullToken) {
			@Var ZSyntaxPattern Pattern = NameSpace.GetSuffixSyntaxPattern(Token.GetText());
			return Pattern;
		}
		return null;
	}

	public static ZNode DispatchPattern(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode, boolean AllowStatement, boolean AllowBinary) {
		@Var ZToken Token = TokenContext.GetToken();
		@Var ZSyntaxPattern Pattern = null;
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
			LeftNode = TokenContext.ApplyMatchPattern(ParentNode, LeftNode, Pattern, ZTokenContext.Required);
		}
		else {
			if(Token.IsNameSymbol()) {
				if(AllowStatement) {
					Pattern = NameSpace.GetSyntaxPattern("$SymbolStatement$");
				}
				else {
					Pattern = NameSpace.GetSyntaxPattern("$SymbolExpression$");
				}
				LeftNode = TokenContext.ApplyMatchPattern(ParentNode, LeftNode, Pattern, ZTokenContext.Required);
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
				@Var ZSyntaxPattern SuffixPattern = ExpressionPattern.GetSuffixPattern(NameSpace, TokenContext);
				if(SuffixPattern == null) {
					break;
				}
				if(!AllowBinary && SuffixPattern.IsBinaryOperator()) {
					break;
				}
				LeftNode = TokenContext.ApplyMatchPattern(ParentNode, LeftNode, SuffixPattern, ZTokenContext.Required);
			}
		}
		return LeftNode;
	}

}
