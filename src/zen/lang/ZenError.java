package zen.lang;

import zen.ast.ZErrorNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZNode;
import zen.ast.ZReturnNode;
import zen.type.ZType;

public class ZenError {

	public static ZNode NoSupport(ZNode Node, String Syntax) {
		return new ZErrorNode(Node.SourceToken, "no support for " + Syntax);
	}

	// import
	public static ZNode UnfoundResource(ZNode Node, String Path) {
		return new ZErrorNode(Node.SourceToken, "unfound resource: " + Path);
	}

	// type checker
	static ZNode ReadOnlyName(ZNode Node, ZType ClassType, String VarName) {
		return new ZErrorNode(Node.SourceToken, "readonly: " + VarName);
	}

	static ZNode ReadOnlyLocalVariable(ZNode Node, String VarName) {
		return new ZErrorNode(Node.SourceToken, "readonly variable: " + VarName);
	}

	static ZNode UndefinedName(ZNode Node, String Name) {
		return new ZErrorNode(Node.SourceToken, "undefined name: " + Name);
	}


	static ZNode TypeErrorMessage(ZType Requested, ZNode Node, String Message) {
		ZErrorNode ErrorNode = new ZErrorNode(Node.SourceToken, Message);
		ErrorNode.Type = Requested;
		return ErrorNode;
	}

	public static ZNode CreateStupidCast(ZType Requested, ZNode Node) {
		return ZenError.TypeErrorMessage(Requested, Node, "type error: requested=" +  Requested + ", given=" + Node.Type);
	}


	public static ZNode FuncCallTypeError(ZType Requested, ZFuncCallNode FuncNode, int ArgumentIndex, ZType GivenType) {
		String Fname = "function";
		if(FuncNode.ResolvedFuncName != null) {
			Fname = FuncNode.ResolvedFuncName;
		}
		return ZenError.TypeErrorMessage(Requested, FuncNode, "type error: " + Fname+"("+ArgumentIndex+") required=" + Requested + ", given=" + GivenType);
	}

	public static ZNode NeedFunctionScope(ZReturnNode Node, String Statement) {
		return new ZErrorNode(Node.SourceToken, Statement + " is available only in function scope");
	}
}
