package zen.codegen.jvm;

import zen.ast.ZNode;
import zen.type.ZType;

public class StaticFieldNode extends ZNode {
	Class<?> StaticClass;
	String FieldName;
	StaticFieldNode(ZNode ParentNode, Class<?> StaticClass, ZType FieldType, String FieldName) {
		super(ParentNode, null, 0);
		this.StaticClass = StaticClass;
		this.Type = FieldType;
		this.FieldName = FieldName;
	}

	@Override public final String GetVisitName() {
		return "VisitStaticFieldNode";
	}
}
