package zen.codegen.jruby;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import zen.ast.ZBlockNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarDeclNode;
import zen.lang.ZSystem;
import zen.parser.ZSourceGenerator;

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
		this.SetNativeType(ZSystem.BooleanType, "Object"); // No boolean type in Ruby.
		this.SetNativeType(ZSystem.IntType, "Fixnum");
		this.SetNativeType(ZSystem.FloatType, "Float");
		this.SetNativeType(ZSystem.StringType, "String");

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
		for(ZNode SubNode : Node.StmtList) {
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

	@Override public void VisitCastNode(ZCastNode Node) {
		// Use method (like 1.to_s) in Ruby.
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		// Use method (like "a".is_a?(Object)) in Ruby.
	}

	@Override
	public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("raise ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
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
	public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("rescue => ");
		//this.VisitType(Node.ExceptionType);
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitVarDeclNode(ZVarDeclNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.InitNode);
	}

	@Override
	public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
	}

	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		ZReturnNode ReturnNode = Node.BodyNode.ToReturnNode();
		this.CurrentBuilder.Append("->");
		this.VisitParamList("(", Node.ParamList, ")");
		this.GenerateCode(Node.BodyNode);
	}

	public void VisitFuncDeclNode(ZFunctionNode/*Decl*/ Node) {
		this.CurrentBuilder.Append("def ");
		this.CurrentBuilder.Append(Node.FuncName);
		this.VisitParamList("(", Node.ParamList, ")");
		if (Node.BodyNode != null) {
			this.GenerateCode(Node.BodyNode);
		}
	}
}
