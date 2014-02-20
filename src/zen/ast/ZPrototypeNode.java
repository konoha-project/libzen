package zen.ast;

import zen.deps.Field;
import zen.deps.Var;
import zen.deps.ZArray;
import zen.parser.ZToken;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypePool;

public class ZPrototypeNode extends ZListNode {
	@Field public ZType ReturnType = ZType.VarType;

	@Field public String FuncName = null;
	@Field public ZToken  NameToken = null;

	public ZPrototypeNode(ZNode ParentNode) {
		super(ParentNode, null, 0);
	}

	@Override public final void SetTypeInfo(ZToken TypeToken, ZType Type) {
		this.ReturnType = Type;
	}

	@Override public final void SetNameInfo(ZToken NameToken, String Name) {
		this.FuncName = Name;
		this.NameToken = NameToken;
	}

	public final ZParamNode GetParamNode(int Index) {
		@Var ZNode Node = this.GetListAt(Index);
		if(Node instanceof ZParamNode) {
			return (ZParamNode)Node;
		}
		return null;
	}

	public final ZFuncType GetFuncType() {
		@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[this.GetListSize()+1]);
		TypeList.add(this.ReturnType.GetRealType());
		@Var int i = 0;
		while(i < this.GetListSize()) {
			@Var ZParamNode Node = this.GetParamNode(i);
			@Var ZType ParamType = Node.Type.GetRealType();
			TypeList.add(ParamType);
			i = i + 1;
		}
		return ZTypePool._LookupFuncType(TypeList);
	}
}