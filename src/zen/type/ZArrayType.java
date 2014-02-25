package zen.type;

public class ZArrayType extends ZGenericType {

	public ZArrayType(int TypeFlag, ZType ParamType) {
		super(TypeFlag, ParamType+"[]", ZGenericType.ArrayType, ParamType);
	}

}
