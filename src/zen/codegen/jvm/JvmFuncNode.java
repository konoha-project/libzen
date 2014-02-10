package zen.codegen.jvm;

import zen.ast.ZNode;
import zen.deps.Field;
import zen.type.ZFuncType;

class JvmFuncNode extends ZNode {
	@Field String FuncName;
	@Field String ReferenceName;
	@Field String ClassName;
	@Field String FieldDesc;
	@Field Class<?> FuncClass;

	JvmFuncNode(ZNode ParentNode, ZFuncType FuncType, String FuncName) {
		super(ParentNode, null, 0);
		this.Type = FuncType;
		this.FuncName = FuncName;
		this.ReferenceName = FuncType.StringfySignature(FuncName);
		this.ClassName = "C" + this.ReferenceName;
		this.FieldDesc = "L" + this.ClassName + ";";
		this.FuncClass = null;
	}

	@Override public final String GetVisitName() {
		return "VisitJvmFuncNode";
	}


}
