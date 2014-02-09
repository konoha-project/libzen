package zen.codegen.jvm;

import zen.ast.ZImportNode;
import zen.ast.ZNode;
import zen.deps.Var;
import zen.lang.ZenError;
import zen.type.ZType;

public class JavaImportNode extends ZImportNode {

	public JavaImportNode(ZNode ParentNode) {
		super(ParentNode);
	}

	private String ParsePath(String Path) {
		@Var int loc = Path.lastIndexOf('.');
		if(loc != -1) {
			return Path.substring(0, loc);
		}
		return Path;
	}

	private String ParseSymbol(String Path) {
		@Var int loc = Path.lastIndexOf('.');
		if(loc != -1) {
			return Path.substring(loc+1);
		}
		return Path;
	}

	@Override public ZNode Import() {
		try {
			Class<?> jClass = Class.forName(this.ResourcePath);
			ZType Type = JavaTypeTable.GetZenType(jClass);
			if(this.Alias == null) {
				this.Alias = this.ParseSymbol(this.ResourcePath);
			}
			this.GetNameSpace().SetTypeName(this.Alias, Type, this.SourceToken);
			return this;
		} catch (ClassNotFoundException e) {
		}
		return ZenError.UnfoundResource(this, this.ResourcePath);
	}
}
