package libzen.grammar;

import java.util.ArrayList;

import zen.ast.ZNode;
import zen.ast.ZTypeNode;
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.type.ZType;
import zen.type.ZTypePool;

public class TypeSuffixPattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode TypeNode) {
		@Var ZToken SourceToken = TokenContext.GetToken();
		if(TypeNode.Type.GetParamSize() > 0) {
			if(TokenContext.MatchToken("<")) {  // Generics
				@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
				while(!TokenContext.StartsWithToken(">")) {
					if(TypeList.size() > 0 && !TokenContext.MatchToken(",")) {
						return null;
					}
					@Var ZTypeNode ParamTypeNode = (ZTypeNode) TokenContext.ParsePattern(ParentNode, "$Type$", ZTokenContext.Optional);
					if(ParamTypeNode == null) {
						return TypeNode;
					}
					TypeList.add(ParamTypeNode.Type);
				}
				TypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool.GetGenericType(TypeNode.Type, 0, TypeList, true));
			}
		}
		while(TokenContext.MatchToken("[")) {  // Array
			if(!TokenContext.MatchToken("]")) {
				return null;
			}
			TypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool.GetGenericType1(ZType.ArrayType, TypeNode.Type));
		}
		return TypeNode;
	}

}
