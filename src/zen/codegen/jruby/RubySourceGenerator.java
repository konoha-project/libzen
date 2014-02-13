package zen.codegen.jruby;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import zen.ast.ZBlockNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZParamNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarDeclNode;
import zen.parser.ZSourceGenerator;
import zen.type.ZType;

public class RubySourceGenerator extends ZSourceGenerator {

	private final ScriptEngineManager EngineManager;
	private final ScriptEngine Engine;

	public RubySourceGenerator() {
		super("ruby", "1.9.3");
		this.LineFeed = "\n";
		this.Tab = "\t";
		this.LineComment = "#"; // if not, set null
		this.BeginComment = "=begin";
		this.EndComment = "=end";
		this.Camma = ", ";
		this.SemiColon = "";

		this.TrueLiteral = "true";
		this.FalseLiteral = "false";
		this.NullLiteral = "nil";
		this.TopType = "Object";
		this.SetNativeType(ZType.BooleanType, "Object"); // No boolean type in Ruby.
		this.SetNativeType(ZType.IntType, "Fixnum");
		this.SetNativeType(ZType.FloatType, "Float");
		this.SetNativeType(ZType.StringType, "String");

		this.EngineManager = new ScriptEngineManager();
		this.Engine = this.EngineManager.getEngineByName("jruby");

	}

	//	@Override
	//	public Object EvalTopLevelNode(ZNode Node) {
	//		String Code = this.CurrentBuilder.toString();
	//		System.out.println(Code);
	//		this.CurrentBuilder.Clear();
	//		try {
	//			return ((Compilable)this.Engine).compile(Code).eval();
	//		} catch (ScriptException ex) {
	//			ex.printStackTrace();
	//		}
	//		return null;
	//	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.Append("do");
		this.CurrentBuilder.Indent();
		throw new RuntimeException("FIXME: don't use for statement");
		//		for(ZNode SubNode : Node.StmtList) {
		//			this.CurrentBuilder.AppendLineFeed();
		//			this.CurrentBuilder.AppendIndent();
		//			this.GenerateCode(SubNode);
		//			this.CurrentBuilder.Append(this.SemiColon);
		//		}
		//		this.CurrentBuilder.UnIndent();
		//		this.CurrentBuilder.AppendLineFeed();
		//		this.CurrentBuilder.AppendIndent();
		//		this.CurrentBuilder.Append("end");
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		// Use method (like 1.to_s) in Ruby.
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		// Use method (like "a".is_a?(Object)) in Ruby.
	}

	@Override
	public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("raise ");
		this.GenerateCode(Node.AST[ZThrowNode._Expr]);
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("begin");
		this.GenerateCode(Node.AST[ZTryNode._Try]);
		if (Node.AST[ZTryNode._Catch] != null) {
			this.GenerateCode(Node.AST[ZTryNode._Catch]);
		}
		if (Node.AST[ZTryNode._Finally] != null) {
			this.CurrentBuilder.Append("ensure");
			this.GenerateCode(Node.AST[ZTryNode._Finally]);
		}
	}

	@Override
	public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("rescue => ");
		//this.VisitType(Node.ExceptionType);
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.GenerateCode(Node.AST[ZCatchNode._Block]);
	}

	@Override
	public void VisitVarDeclNode(ZVarDeclNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZVarDeclNode._InitValue]);
	}

	@Override
	public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
	}

	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		this.CurrentBuilder.Append("->");
		this.VisitListNode("(", Node, ")");
		this.GenerateCode(Node.AST[ZFunctionNode._Block]);
	}

	public void VisitFuncDeclNode(ZFunctionNode/*Decl*/ Node) {
		this.CurrentBuilder.Append("def ");
		this.CurrentBuilder.Append(Node.FuncName);
		this.VisitListNode("(", Node, ")");
		if (Node.AST[ZFunctionNode._Block] != null) {
			this.GenerateCode(Node.AST[ZFunctionNode._Block]);
		}
	}
}
