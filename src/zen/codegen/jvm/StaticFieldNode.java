package zen.codegen.jvm;

import zen.ast.ZNode;
import zen.type.ZType;

public class StaticFieldNode extends ZNode {
	String ClassName;
	String FieldName;
	StaticFieldNode(ZNode ParentNode, String ClassName, ZType FieldType, String FieldName) {
		super(ParentNode, null);
		this.ClassName = ClassName;
		this.Type = FieldType;
		this.FieldName = FieldName;
	}

	@Override public final String GetVisitName() {
		return "VisitStaticFieldNode";
	}
}
