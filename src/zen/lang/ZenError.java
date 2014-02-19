package zen.lang;

import zen.ast.ZErrorNode;
import zen.ast.ZNode;
import zen.type.ZType;

public class ZenError {

	public static ZNode NoSupport(ZNode Node, String Syntax) {
		return new ZErrorNode(Node, "no support for " + Syntax);
	}

	// import
	public static ZNode UnfoundResource(ZNode Node, String Path) {
		return new ZErrorNode(Node, "unfound resource: " + Path);
	}

	// type checker
	static ZNode ReadOnlyName(ZNode Node, ZType ClassType, String VarName) {
		return new ZErrorNode(Node, "readonly: " + VarName);
	}

	static ZNode ReadOnlyLocalVariable(ZNode Node, String VarName) {
		return new ZErrorNode(Node, "readonly variable: " + VarName);
	}

	static ZNode UndefinedName(ZNode Node, String Name) {
		return new ZErrorNode(Node, "undefined name: " + Name);
	}


	static ZNode TypeErrorMessage(ZType Requested, ZNode Node, String Message) {
		ZErrorNode ErrorNode = new ZErrorNode(Node, Message);
		ErrorNode.Type = Requested;
		return ErrorNode;
	}

	public static ZNode CreateStupidCast(ZType Requested, ZNode Node) {
		return ZenError.TypeErrorMessage(Requested, Node, "type error: requested=" +  Requested + ", given=" + Node.Type);
	}

	public static ZNode NeedFunctionScope(ZNode Node, String Statement) {
		return new ZErrorNode(Node, Statement + " is available only in function scope");
	}
}
