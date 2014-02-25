package zen.lang;

import zen.ast.ZBooleanNode;
import zen.ast.ZFloatNode;
import zen.ast.ZIntNode;
import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.parser.ZNameSpace;
import zen.type.ZType;

public class ZenGamma {

	static ZType GetIndexType(ZNameSpace NameSpace, ZType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsStringType()) {
			return ZType.IntType;
		}
		if(RecvType.IsMapType()) {
			return ZType.StringType;
		}
		return ZType.VarType;
	}

	static ZType GetElementType(ZNameSpace NameSpace, ZType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsMapType()) {
			return RecvType.GetParamType(0);
		}
		if(RecvType.IsStringType()) {
			return ZType.StringType;
		}
		return ZType.VarType;
	}

	static protected ZNode CreateDefaultValueNode(ZNode ParentNode, ZType Type, String FieldName) {
		if(Type.IsIntType()) {
			return new ZIntNode(ParentNode, null, 0);
		}
		else if(Type.IsBooleanType()) {
			return new ZBooleanNode(ParentNode, null, false);
		}
		else if(Type.IsFloatType()) {
			return new ZFloatNode(ParentNode, null, 0.0);
		}
		return new ZNullNode(ParentNode, null);
	}

}
