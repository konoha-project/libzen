package zen.codegen.jvm;

import zen.ast.ZNode;
import zen.ast.ZTopLevelNode;
import zen.parser.ZLogger;
import zen.parser.ZNameSpace;
import zen.type.ZType;
import zen.util.Var;

public class JavaImportNode extends ZTopLevelNode {
	public final static int _Path  = 0;

	public JavaImportNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
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
		@Var String ResourcePath = this.AST[JavaImportNode._Path].SourceToken.GetTextAsName();
		try {
			Class<?> jClass = Class.forName(ResourcePath);
			ZType Type = JavaTypeTable.GetZenType(jClass);
			String Alias = this.ParseSymbol(ResourcePath);

			NameSpace.SetTypeName(Alias, Type, this.SourceToken);
		} catch (ClassNotFoundException e) {
			ZLogger._LogError(this.GetAstToken(JavaImportNode._Path), "unfound resource: "+ ResourcePath);
		}
	}
}
