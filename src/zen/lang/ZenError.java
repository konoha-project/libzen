package zen.lang;

import zen.ast.ZErrorNode;
import zen.ast.ZNode;

public class ZenError {
	static ZNode ReadOnlyName(ZNode Node, ZType ClassType, String VarName) {
		return new ZErrorNode(Node.SourceToken, "readonly: " + VarName);
	}

	static ZNode UndefinedName(ZNode Node, String Name) {
		return new ZErrorNode(Node.SourceToken, "undefined name: " + Name);
	}
}
