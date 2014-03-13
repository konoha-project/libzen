package zen.grammar;

import zen.ast.ZNode;
import zen.ast.ZTypeNode;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.type.ZGenericType;
import zen.type.ZType;
import zen.type.ZTypePool;
import zen.util.Var;
import zen.util.ZArray;
import zen.util.ZMatchFunction;

public class RightTypePatternFunction extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftTypeNode) {
		@Var ZToken SourceToken = TokenContext.GetToken();
		if(LeftTypeNode.Type.GetParamSize() > 0) {
			if(TokenContext.MatchToken("<")) {  // Generics
				@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[4]);
				while(!TokenContext.StartsWithToken(">")) {
					if(TypeList.size() > 0 && !TokenContext.MatchToken(",")) {
						return null;
					}
					@Var ZTypeNode ParamTypeNode = (ZTypeNode) TokenContext.ParsePattern(ParentNode, "$OpenType$", ZTokenContext._Optional);
					if(ParamTypeNode == null) {
						return LeftTypeNode;
					}
					TypeList.add(ParamTypeNode.Type);
				}
				LeftTypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool._GetGenericType(LeftTypeNode.Type, TypeList, true));
			}
		}
		while(TokenContext.MatchToken("[")) {  // Array
			if(!TokenContext.MatchToken("]")) {
				return null;
			}
			LeftTypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool._GetGenericType1(ZGenericType._ArrayType, LeftTypeNode.Type));
		}
		return LeftTypeNode;
	}

}
