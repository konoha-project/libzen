package zen.codegen.jvm;

import zen.ast.ZNode;
import zen.ast.sugar.ZTopLevelNode;
import zen.parser.ZLogger;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.type.ZType;
import zen.util.Field;
import zen.util.Var;

public class JavaImportNode extends ZTopLevelNode {
	@Field public String ResourcePath = null;
	@Field public String Alias = null;
	@Field public ZToken ResourceToken = null;

	public JavaImportNode(ZNode ParentNode) {
		super(ParentNode, null, 0);
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		if(this.ResourcePath == null) {
			this.ResourcePath = Name;
			this.ResourceToken = NameToken;
		}
		else {
			this.Alias = Name;
		}
	}

	//	private String ParsePath(String Path) {
	//		@Var int loc = Path.lastIndexOf('.');
	//		if(loc != -1) {
	//			return Path.substring(0, loc);
	//		}
	//		return Path;
	//	}

	private String ParseSymbol(String Path) {
		@Var int loc = Path.lastIndexOf('.');
		if(loc != -1) {
			return Path.substring(loc+1);
		}
		return Path;
	}

	@Override public void Perform(ZNameSpace NameSpace) {
		try {
			Class<?> jClass = Class.forName(this.ResourcePath);
			ZType Type = JavaTypeTable.GetZenType(jClass);
			if(this.Alias == null) {
				this.Alias = this.ParseSymbol(this.ResourcePath);
			}
			NameSpace.SetTypeName(this.Alias, Type, this.SourceToken);
		} catch (ClassNotFoundException e) {
			ZLogger._LogError(this.ResourceToken, "unfound resource: "+ this.ResourcePath);
		}
	}
}
