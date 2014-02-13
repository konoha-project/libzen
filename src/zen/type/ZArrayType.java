package zen.type;

public class ZArrayType extends ZGeneric1Type {

	public ZArrayType(int TypeFlag, ZType ParamType) {
		super(TypeFlag, ParamType+"[]", ZType.ArrayType, ParamType);
	}

}
