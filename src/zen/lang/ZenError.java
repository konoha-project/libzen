package zen.lang;

import zen.ast.ZErrorNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZNode;
import zen.type.ZType;

public class ZenError {

	static ZNode TypeErrorMessage(ZType Requested, ZNode Node, String Message) {
		ZErrorNode ErrorNode = new ZErrorNode(Node.SourceToken, Message);
		ErrorNode.Type = Requested;
		return ErrorNode;
	}

	static ZNode ReadOnlyName(ZNode Node, ZType ClassType, String VarName) {
		return new ZErrorNode(Node.SourceToken, "readonly: " + VarName);
	}

	static ZNode UndefinedName(ZNode Node, String Name) {
		return new ZErrorNode(Node.SourceToken, "undefined name: " + Name);
	}

	public static ZNode FuncCallTypeError(ZType Requested, ZFuncCallNode FuncNode, int ArgumentIndex, ZType GivenType) {
		String Fname = "function";
		if(FuncNode.ResolvedFuncName != null) {
			Fname = FuncNode.ResolvedFuncName;
		}
		return ZenError.TypeErrorMessage(Requested, FuncNode, "type error: " + Fname+"("+ArgumentIndex+") required=" + Requested + ", given=" + GivenType);
	}
}
