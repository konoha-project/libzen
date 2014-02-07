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

public class RightTypePattern extends ZMatchFunction {

	@Override public ZNode Invoke(ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftTypeNode) {
		@Var ZToken SourceToken = TokenContext.GetToken();
		if(LeftTypeNode.Type.GetParamSize() > 0) {
			if(TokenContext.MatchToken("<")) {  // Generics
				@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
				while(!TokenContext.StartsWithToken(">")) {
					if(TypeList.size() > 0 && !TokenContext.MatchToken(",")) {
						return null;
					}
					@Var ZTypeNode ParamTypeNode = (ZTypeNode) TokenContext.ParsePattern(ParentNode, "$Type$", ZTokenContext.Optional);
					if(ParamTypeNode == null) {
						return LeftTypeNode;
					}
					TypeList.add(ParamTypeNode.Type);
				}
				LeftTypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool.GetGenericType(LeftTypeNode.Type, 0, TypeList, true));
			}
		}
		while(TokenContext.MatchToken("[")) {  // Array
			if(!TokenContext.MatchToken("]")) {
				return null;
			}
			LeftTypeNode = new ZTypeNode(ParentNode, SourceToken, ZTypePool.GetGenericType1(ZType.ArrayType, LeftTypeNode.Type));
		}
		return LeftTypeNode;
	}

}
