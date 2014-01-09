package zen.codegen.jruby;

import javax.script.Compilable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import zen.ast.GtBlockNode;
import zen.ast.GtCastNode;
import zen.ast.GtCatchNode;
import zen.ast.GtFuncDeclNode;
import zen.ast.GtFunctionLiteralNode;
import zen.ast.GtInstanceOfNode;
import zen.ast.GtParamNode;
import zen.ast.GtReturnNode;
import zen.ast.GtThrowNode;
import zen.ast.GtTryNode;
import zen.ast.GtVarDeclNode;
import zen.ast.ZenNode;
import zen.lang.ZenSystem;
import zen.parser.ZenSourceGenerator;

public class RubySourceGenerator extends ZenSourceGenerator {

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
		this.SetNativeType(ZenSystem.BooleanType, "Object"); // No boolean type in Ruby.
		this.SetNativeType(ZenSystem.IntType, "Fixnum");
		this.SetNativeType(ZenSystem.FloatType, "Float");
		this.SetNativeType(ZenSystem.StringType, "String");

		this.EngineManager = new ScriptEngineManager();
		this.Engine = this.EngineManager.getEngineByName("jruby");

	}

	@Override
	public Object EvalTopLevelNode(ZenNode Node) {
		String Code = this.CurrentBuilder.toString();
		System.out.println(Code);
		this.CurrentBuilder.Clear();
		try {
			return ((Compilable)this.Engine).compile(Code).eval();
		} catch (ScriptException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void VisitBlockNode(GtBlockNode Node) {
		this.CurrentBuilder.Append("do");
		this.CurrentBuilder.Indent();
		for(ZenNode SubNode : Node.StatementList) {
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.GenerateCode(SubNode);
			this.CurrentBuilder.Append(this.SemiColon);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("end");
	}

	@Override public void VisitCastNode(GtCastNode Node) {
		// Use method (like 1.to_s) in Ruby.
	}

	@Override public void VisitInstanceOfNode(GtInstanceOfNode Node) {
		// Use method (like "a".is_a?(Object)) in Ruby.
	}

	@Override
	public void VisitThrowNode(GtThrowNode Node) {
		this.CurrentBuilder.Append("raise ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitTryNode(GtTryNode Node) {
		this.CurrentBuilder.Append("begin");
		this.GenerateCode(Node.TryNode);
		if (Node.CatchNode != null) {
			this.GenerateCode(Node.CatchNode);
		}
		if (Node.FinallyNode != null) {
			this.CurrentBuilder.Append("ensure");
			this.GenerateCode(Node.FinallyNode);
		}
	}

	@Override
	public void VisitCatchNode(GtCatchNode Node) {
		this.CurrentBuilder.Append("rescue => ");
		//this.VisitType(Node.ExceptionType);
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitVarDeclNode(GtVarDeclNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.InitNode);
	}

	@Override
	public void VisitParamNode(GtParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
	}

	@Override
	public void VisitFunctionLiteralNode(GtFunctionLiteralNode Node) {
		GtReturnNode ReturnNode = Node.BodyNode.ToReturnNode();
		this.CurrentBuilder.Append("->");
		this.VisitParamList("(", Node.ArgumentList, ")");
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitFuncDeclNode(GtFuncDeclNode Node) {
		this.CurrentBuilder.Append("def ");
		this.CurrentBuilder.Append(Node.FuncName);
		this.VisitParamList("(", Node.ArgumentList, ")");
		if (Node.BodyNode != null) {
			this.GenerateCode(Node.BodyNode);
		}
	}
}
