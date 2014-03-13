//ifdef JAVA
package zen.codegen.erlang;

import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZClassNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGlobalNameNode;
import zen.ast.ZIfNode;
import zen.ast.ZListNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZSetterNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.ast.ZLetNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZNotNode;
import zen.ast.ZAndNode;
import zen.ast.ZOrNode;
import zen.parser.ZSourceBuilder;
import zen.parser.ZSourceGenerator;
import zen.parser.ZToken;
import zen.type.ZClassType;
import zen.type.ZType;
import zen.util.Field;
import zen.util.Var;
import zen.util.ZenMethod;

//ifdef JAVA

public class ErlSourceCodeGenerator extends ZSourceGenerator {
	@Field private int LoopNodeNumber;
	@Field private int BreakMark;
	@Field private final VariableManager VarMgr;

	public ErlSourceCodeGenerator/*constructor*/() {
		super("erl", "5.10.4");
		this.NotOperator = "not";
		this.AndOperator = "and";
		this.OrOperator = "or";

		this.LoopNodeNumber = 0;
		this.BreakMark = -1;
		this.VarMgr = new VariableManager();

		this.HeaderBuilder.Append("-module(generated).");
		this.HeaderBuilder.AppendLineFeed();
	}

	@Override @ZenMethod protected void Finish(String FileName) {
		this.AppendAssertDecl();
		this.AppendDigitsDecl();
		this.AppendZStrDecl();
	}

	@Override public void VisitStmtList(ZListNode BlockNode) {
		this.VisitStmtList(BlockNode, ",");
	}

	public void VisitStmtList(ZListNode BlockNode, String last) {
		@Var int i = 0;
		@Var int size = BlockNode.GetListSize();
		while (i < size) {
			@Var ZNode SubNode = BlockNode.GetListAt(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.GenerateCode(null, SubNode);
			if (i == size - 1) {
				this.CurrentBuilder.Append(last);
			}
			else {
				this.CurrentBuilder.Append(",");
			}
			i = i + 1;
		}
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node, ".");
		this.CurrentBuilder.UnIndent();
	}
	public void VisitBlockNode(ZBlockNode Node, String last) {
		this.VarMgr.PushScope();
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("__Arguments__ = " + this.VarMgr.GenVarTupleOnlyUsedDefinedByParentScope(false));
		this.CurrentBuilder.Append(last);
		this.CurrentBuilder.UnIndent();
		this.VarMgr.PopScope(false);
	}

	// @Override public void VisitNullNode(ZNullNode Node) {
	// 	this.CurrentBuilder.Append(this.NullLiteral);
	// }

	// @Override public void VisitBooleanNode(ZBooleanNode Node) {
	// 	if (Node.BooleanValue) {
	// 		this.CurrentBuilder.Append(this.TrueLiteral);
	// 	} else {
	// 		this.CurrentBuilder.Append(this.FalseLiteral);
	// 	}
	// }

	// @Override public void VisitIntNode(ZIntNode Node) {
	// 	this.CurrentBuilder.Append(String.valueOf(Node.IntValue));
	// }

	// @Override public void VisitFloatNode(ZFloatNode Node) {
	// 	this.CurrentBuilder.Append(String.valueOf(Node.FloatValue));
	// }

	// @Override public void VisitStringNode(ZStringNode Node) {
	// 	this.CurrentBuilder.Append(LibZen._QuoteString(Node.StringValue));
	// }

	// @Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
	// 	this.VisitListNode("[", Node, "]");
	// 	// TODO Auto-generated method stub
	// }

	// @Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
	// 	// TODO Auto-generated method stub
	// }

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.CurrentBuilder.Append("#");
		this.CurrentBuilder.Append(this.ToErlangTypeName(Node.Type.ShortName));
		this.VisitListNode("{", Node, "}");
	}

	// @Override public void VisitGroupNode(ZGroupNode Node) {
	// 	this.CurrentBuilder.Append("(");
	// 	this.GenerateCode(null, Node.ExprNode());
	// 	this.CurrentBuilder.Append(")");
	// }

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		if (Node.Type.Equals(ZType.StringType)) {
			this.CurrentBuilder.Append("string:substr(");
			this.GenerateCode(null, Node.RecvNode());
			this.CurrentBuilder.Append(", ");
			this.GenerateCode(null, Node.IndexNode());
			this.CurrentBuilder.Append(" + 1, 1)");
		} else {
			throw new RuntimeException("GetIndex of this Type is not supported yet");
		}
	}

	// @Override public void VisitSetIndexNode(ZSetIndexNode Node) {
	// 	this.GenerateCode(null, Node.RecvNode());
	// 	this.CurrentBuilder.Append("[");
	// 	this.GenerateCode(null, Node.IndexNode());
	// 	this.CurrentBuilder.Append("]");
	// 	this.CurrentBuilder.AppendToken("=");
	// 	this.GenerateCode(null, Node.ExprNode());
	// }

	// @Override public void VisitGlobalNameNode(ZGlobalNameNode Node) {
	// 	if(Node.IsUntyped()) {
	// 		ZLogger._LogError(Node.SourceToken, "undefined symbol: " + Node.GlobalName);
	// 	}
	// 	if(Node.IsFuncNameNode()) {
	// 		this.CurrentBuilder.Append(Node.Type.StringfySignature(Node.GlobalName));
	// 	}
	// 	else {
	// 		this.CurrentBuilder.Append(Node.GlobalName);
	// 	}
	// }

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		String VarName = this.VarMgr.GenVariableName(Node.GetName());
		this.CurrentBuilder.Append(VarName);
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		int mark = this.GetLazyMark();

		this.GenerateCode(null, Node.ExprNode());

		String VarName = Node.GetName();
		this.VarMgr.IncrementVariableNumber(VarName);
		this.AppendLazy(mark, this.VarMgr.GenVariableName(VarName) + " = ");
	}


	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.GenerateSurroundCode(Node.RecvNode());
		this.CurrentBuilder.Append("#");
		this.CurrentBuilder.Append(this.ToErlangTypeName(Node.RecvNode().Type.ShortName));
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(this.ToErlangTypeName(Node.GetName()));
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		int mark = this.GetLazyMark();

		ZGetNameNode GetNameNode = (ZGetNameNode)Node.RecvNode();
		this.GenerateSurroundCode(GetNameNode);
		this.CurrentBuilder.Append("#");
		this.CurrentBuilder.Append(this.ToErlangTypeName(Node.RecvNode().Type.ShortName));
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Append(Node.GetName());
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.ExprNode());
		this.CurrentBuilder.Append("}");
		this.VarMgr.IncrementVariableNumber(GetNameNode.GetName());
		ZSourceBuilder LazyBuilder = new ZSourceBuilder(this, this.CurrentBuilder);
		ZSourceBuilder BodyBuilder = this.CurrentBuilder;
		this.CurrentBuilder = LazyBuilder;
		this.GenerateCode(null, Node.RecvNode());
		this.CurrentBuilder.AppendToken("=");
		this.CurrentBuilder = BodyBuilder;
		this.AppendLazy(mark, LazyBuilder.toString());
	}

	// @Override public void VisitMethodCallNode(ZMethodCallNode Node) {
	// 	this.GenerateSurroundCode(Node.RecvNode());
	// 	this.CurrentBuilder.Append(".");
	// 	this.CurrentBuilder.Append(Node.MethodName());
	// 	this.VisitListNode("(", Node, ")");
	// }

	// @Override public void VisitMacroNode(ZMacroNode Node) {
	// 	@Var String Macro = Node.GetMacroText();
	// 	@Var ZFuncType FuncType = Node.GetFuncType();
	// 	@Var int fromIndex = 0;
	// 	@Var int BeginNum = Macro.indexOf("$[", fromIndex);
	// 	while(BeginNum != -1) {
	// 		@Var int EndNum = Macro.indexOf("]", BeginNum + 2);
	// 		if(EndNum == -1) {
	// 			break;
	// 		}
	// 		this.CurrentBuilder.Append(Macro.substring(fromIndex, BeginNum));
	// 		@Var int Index = (int)LibZen._ParseInt(Macro.substring(BeginNum+2, EndNum));
	// 		if(Node.HasAst(Index)) {
	// 			this.GenerateCode(FuncType.GetFuncParamType(Index), Node.AST[Index]);
	// 		}
	// 		fromIndex = EndNum + 1;
	// 		BeginNum = Macro.indexOf("$[", fromIndex);
	// 	}
	// 	this.CurrentBuilder.Append(Macro.substring(fromIndex));
	// }

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		String FuncName = ((ZGlobalNameNode)Node.FunctionNode()).GlobalName;
		FuncName = this.ToErlangFuncName(FuncName);
		this.CurrentBuilder.Append(FuncName);
		//this.GenerateCode(null, Node.FuncNameNode());
		this.VisitListNode("(", Node, ")");
	}

	// @Override public void VisitUnaryNode(ZUnaryNode Node) {
	// 	this.CurrentBuilder.Append(Node.SourceToken.GetText());
	// 	this.GenerateCode(null, Node.RecvNode());
	// }

	@Override public void VisitNotNode(ZNotNode Node) {
		this.CurrentBuilder.AppendToken(this.NotOperator);
		this.GenerateSurroundCode(Node.RecvNode());
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		// this.CurrentBuilder.Append("(");
		// this.GenerateTypeName(Node.Type);
		// this.CurrentBuilder.Append(")");
		this.GenerateSurroundCode(Node.ExprNode());
	}

	// @Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
	// 	this.GenerateCode(null, Node.LeftNode());
	// 	this.CurrentBuilder.AppendToken("instanceof");
	// 	this.GenerateTypeName(Node.RightNode().Type);
	// }

	@Override protected String GetBinaryOperator(ZType Type, ZToken Token) {
		if(Token.EqualsText("<=")) {
			return "=<";
		}
		if(Token.EqualsText("==")) {
			return "=:=";
		}
		if(Token.EqualsText("!=")) {
			return "=/=";
		}
		if(Token.EqualsText("<<")) {
			return "bsl";
		}
		if(Token.EqualsText(">>")) {
			return "bsr";
		}
		if(Token.EqualsText('%')) {
			return "rem";
		}
		if(Token.EqualsText('/') && Type.Equals(ZType.IntType)) {
			return "div";
		}
		return Token.GetText();
	}


	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append("(");
		}
		this.GenerateCode(null, Node.LeftNode());
		//		this.CurrentBuilder.AppendToken(Node.SourceToken.GetText());
		@Var String Operator = this.GetBinaryOperator(Node.Type, Node.SourceToken);
		this.CurrentBuilder.AppendToken(Operator);
		this.GenerateCode(null, Node.RightNode());
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append(")");
		}
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.GenerateCode(null, Node.LeftNode());
		@Var String Operator = this.GetBinaryOperator(Node.Type, Node.SourceToken);
		this.CurrentBuilder.AppendToken(Operator);
		this.GenerateCode(null, Node.RightNode());
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.GenerateSurroundCode(Node.LeftNode());
		this.CurrentBuilder.AppendToken(this.AndOperator);
		this.GenerateSurroundCode(Node.RightNode());
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		this.GenerateSurroundCode(Node.LeftNode());
		this.CurrentBuilder.AppendToken(this.OrOperator);
		this.GenerateSurroundCode(Node.RightNode());
	}

	public void AppendGuardAndBlock(ZNode Node) {
		if (Node instanceof ZIfNode) {
			ZIfNode IfNode = (ZIfNode)Node;
			this.CurrentBuilder.AppendIndent();
			this.GenerateSurroundCode(IfNode.CondNode());
			this.CurrentBuilder.Append(" ->");
			this.VisitBlockNode((ZBlockNode)IfNode.ThenNode(), ";");
			this.CurrentBuilder.AppendLineFeed();
			if (IfNode.HasElseNode()) {
				AppendGuardAndBlock(IfNode.ElseNode());
			} else {
				AppendGuardAndBlock(null);
			}
		} else {
			this.CurrentBuilder.IndentAndAppend("true ->");
			if (Node != null) {
				this.VisitBlockNode((ZBlockNode)Node, "");
			} else {
				this.CurrentBuilder.Indent();
				this.CurrentBuilder.AppendLineFeed();
				this.CurrentBuilder.IndentAndAppend(this.VarMgr.GenVarTupleOnlyUsedByChildScope(false));
				this.CurrentBuilder.UnIndent();
			}
		}
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		int mark = this.GetLazyMark();

		this.CurrentBuilder.Append("if");
		this.CurrentBuilder.AppendLineFeed();
		this.AppendGuardAndBlock(Node);
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("end");

		this.AppendLazy(mark, this.VarMgr.GenVarTupleOnlyUsed(true) + " = ");
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.CurrentBuilder.Append("throw({return, ");
		if (Node.HasReturnExpr()) {
			this.GenerateCode(null, Node.ExprNode());
		} else {
			this.CurrentBuilder.Append("void");
		}
		this.CurrentBuilder.Append("})");
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.LoopNodeNumber += 1;
		String WhileNodeName = "Loop" + Integer.toString(this.LoopNodeNumber);

		int mark1 = this.GetLazyMark();

		//Generate WhileBlock
		this.VarMgr.StartUsingFilter(false);
		this.VisitBlockNode(Node.BlockNode(), ",");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.IndentAndAppend(WhileNodeName + "(" + WhileNodeName + ", __Arguments__);");
		this.CurrentBuilder.UnIndent();

		//Generate Else Guard and Block
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("(_, Args) ->");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("Args");
		this.CurrentBuilder.UnIndent();

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("end,");

		//Generate While Guard
		this.VarMgr.StopUsingFilter();
		this.VarMgr.ContinueUsingFilter(true);
		ZSourceBuilder LazyBuilder = new ZSourceBuilder(this, this.CurrentBuilder);
		ZSourceBuilder BodyBuilder = this.CurrentBuilder;
		this.CurrentBuilder = LazyBuilder;
		this.GenerateCode(null, Node.CondNode());
		this.CurrentBuilder = BodyBuilder;
		this.AppendLazy(mark1, ""
				+ WhileNodeName
				+ " = fun(" + WhileNodeName + ", "
				+ this.VarMgr.GenVarTupleOnlyUsedByChildScope(false)
				+ ") when "
				+ LazyBuilder.toString()
				+ " -> ");

		//Generate Loop Function Call
		this.VarMgr.FinishUsingFilter();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		int mark2 = this.GetLazyMark();
		this.CurrentBuilder.Append(" = " + WhileNodeName + "(" + WhileNodeName + ", ");
		this.CurrentBuilder.Append(this.VarMgr.GenVarTupleOnlyUsedByChildScope(false) + ")");
		this.AppendLazy(mark2, this.VarMgr.GenVarTupleOnlyUsedByChildScope(true));
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.CurrentBuilder.Append("throw({break, ");
		//this.VarMgr.GenVarTupleOnlyUsed(false);
		this.BreakMark = this.GetLazyMark();
		this.CurrentBuilder.Append("})");
	}

	// @Override public void VisitThrowNode(ZThrowNode Node) {
	// 	this.CurrentBuilder.Append("throw");
	// 	this.CurrentBuilder.AppendWhiteSpace();
	// 	this.GenerateCode(null, Node.ExprNode());
	// }

	// @Override public void VisitTryNode(ZTryNode Node) {
	// 	this.CurrentBuilder.Append("try");
	// 	this.GenerateCode(null, Node.TryNode());
	// 	if(Node.CatchNode() != null) {
	// 		this.GenerateCode(null, Node.CatchNode());
	// 	}
	// 	if (Node.FinallyNode() != null) {
	// 		this.CurrentBuilder.Append("finally");
	// 		this.GenerateCode(null, Node.FinallyNode());
	// 	}
	// }

	// public void VisitCatchNode(ZCatchNode Node) {
	// 	this.CurrentBuilder.Append("catch (");
	// 	this.CurrentBuilder.Append(Node.ExceptionName);
	// 	this.VisitTypeAnnotation(Node.ExceptionType);
	// 	this.CurrentBuilder.Append(")");
	// 	this.GenerateCode(null, Node.AST[ZCatchNode._Block]);
	// }

	@Override public void VisitVarNode(ZVarNode Node) {
		@Var int mark = this.GetLazyMark();

		this.GenerateCode(null, Node.InitValueNode());

		@Var String VarName = Node.GetName();
		this.VarMgr.CreateVariable(VarName);
		this.AppendLazy(mark, this.VarMgr.GenVariableName(VarName) + " = ");

		this.CurrentBuilder.Append(",");
		if (Node.GetListSize() > 0) {
			this.VisitStmtList(Node);
		}
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("pad");
	}

	// protected void VisitTypeAnnotation(ZType Type) {
	// 	this.CurrentBuilder.Append(": ");
	// 	this.GenerateTypeName(Type);
	// }

	@Override public void VisitLetNode(ZLetNode Node) {
		this.CurrentBuilder.Append("put(");
		this.CurrentBuilder.Append(Node.GlobalName);
		this.CurrentBuilder.Append(", ");
		this.GenerateCode(null, Node.InitValueNode());
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(this.ToErlangVarName(Node.GetName()));
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		this.VarMgr.PushScope();
		this.CreateVariables(Node);

		String FuncName = this.ToErlangFuncName(Node.FuncName());
		if (FuncName.equals("main")) {
			this.HeaderBuilder.Append("-export([main/1]).");
		} else {
			this.HeaderBuilder.Append("-export([" + FuncName + "/" + Node.GetListSize() + "]).");
		}
		this.HeaderBuilder.AppendLineFeed();

		this.CurrentBuilder.Append(FuncName + "_inner");
		this.VisitListNode("(", Node, ")");
		this.CurrentBuilder.Append("->");
		if (Node.BlockNode() == null) {
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("pass.");
		} else {
			this.GenerateCode(null, Node.BlockNode());
		}

		this.CurrentBuilder.AppendLineFeed();
		this.AppendWrapperFuncDecl(Node);
		this.CurrentBuilder.AppendLineFeed();

		this.VarMgr.PopScope(true);
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		ZSourceBuilder BodyBuilder = this.CurrentBuilder;
		this.CurrentBuilder = this.HeaderBuilder;

		this.CurrentBuilder.Append("-record(");
		this.CurrentBuilder.Append(this.ToErlangTypeName(Node.ClassName()));
		if(!Node.SuperType().Equals(ZClassType._ObjectType)) {
			throw new RuntimeException("\"extends\" is not supported yet");
		}
		this.CurrentBuilder.Append(", {");
		@Var int i = 0;
		@Var int size = Node.GetListSize();
		while (i < size) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.CurrentBuilder.Append(this.ToErlangTypeName(FieldNode.GetName()));
			this.CurrentBuilder.AppendToken("=");
			this.GenerateCode(null, FieldNode.InitValueNode());
			if (i < size - 1) {
				this.CurrentBuilder.AppendWhiteSpace();
				this.CurrentBuilder.Append(",");
			}
			i = i + 1;
		}
		this.CurrentBuilder.Append("}).");
		this.CurrentBuilder.AppendLineFeed();

		this.CurrentBuilder = BodyBuilder;
	}

	// @Override public void VisitErrorNode(ZErrorNode Node) {
	// 	ZLogger._LogError(Node.SourceToken, Node.ErrorMessage);
	// 	this.CurrentBuilder.Append("ThrowError(");
	// 	this.CurrentBuilder.Append(LibZen._QuoteString(Node.ErrorMessage));
	// 	this.CurrentBuilder.Append(")");
	// }

	// @Override public void VisitExtendedNode(ZNode Node) {
	// 	if(Node instanceof ZParamNode) {
	// 		this.VisitParamNode((ZParamNode)Node);
	// 	}
	// 	else {
	// 		@Var ZSugarNode SugarNode = Node.DeSugar(this);
	// 		this.VisitSugarNode(SugarNode);
	// 	}
	// }

	// @Override public void VisitSugarNode(ZSugarNode Node) {
	// 	this.GenerateCode(null, Node.AST[ZSugarNode._DeSugar]);
	// }

	// // Utils
	// protected void GenerateTypeName(ZType Type) {
	// 	this.CurrentBuilder.Append(this.GetNativeTypeName(Type.GetRealType()));
	// }

	@Override
	protected void VisitListNode(String OpenToken, ZListNode VargNode, String DelimToken, String CloseToken) {
		this.CurrentBuilder.Append(OpenToken);
		@Var int i = 0;
		while(i < VargNode.GetListSize()) {
			@Var ZNode ParamNode = VargNode.GetListAt(i);
			if (i > 0) {
				this.CurrentBuilder.Append(DelimToken);
			}
			this.GenerateCode(null, ParamNode);
			i = i + 1;
		}
		this.CurrentBuilder.Append(CloseToken);
	}
	@Override
	protected void VisitListNode(String OpenToken, ZListNode VargNode, String CloseToken) {
		this.VisitListNode(OpenToken, VargNode, ", ", CloseToken);
	}

	private void AppendAssertDecl() {
		// this.HeaderBuilder.Append("assert(_Expr) when _Expr =:= false ->");
		// this.HeaderBuilder.AppendLineFeed();
		// this.HeaderBuilder.Indent();
		// this.HeaderBuilder.IndentAndAppend("exit(\"Assertion Failed\");");
		// this.HeaderBuilder.UnIndent();
		// this.HeaderBuilder.AppendLineFeed();
		// this.HeaderBuilder.Append("assert(_Expr) when _Expr =:= true ->");
		// this.HeaderBuilder.AppendLineFeed();
		// this.HeaderBuilder.Indent();
		// this.HeaderBuilder.IndentAndAppend("do_nothing;");
		// this.HeaderBuilder.UnIndent();
		// this.HeaderBuilder.AppendLineFeed();
		// this.HeaderBuilder.Append("assert(_Expr) ->");
		// this.HeaderBuilder.AppendLineFeed();
		// this.HeaderBuilder.Indent();
		// this.HeaderBuilder.IndentAndAppend("exit(\"Assertion Failed (Expr is not true or false)\").");
		// this.HeaderBuilder.UnIndent();
		// this.HeaderBuilder.AppendLineFeed();

		this.HeaderBuilder.Append("assert(_Expr) when _Expr =:= false -> exit(\"Assertion Failed\");");
		this.HeaderBuilder.AppendLineFeed();
		this.HeaderBuilder.Append("assert(_Expr) when _Expr =:= true -> do_nothing;");
		this.HeaderBuilder.AppendLineFeed();
		this.HeaderBuilder.Append("assert(_Expr) -> exit(\"Assertion Failed (Expr is not true or false)\").");
		this.HeaderBuilder.AppendLineFeed();
	}

	private void AppendDigitsDecl() {
		this.HeaderBuilder.Append("digits(N) when is_integer(N) -> integer_to_list(N);");
		this.HeaderBuilder.AppendLineFeed();
		this.HeaderBuilder.Append("digits(0.0) -> \"0.0\";");
		this.HeaderBuilder.AppendLineFeed();
		this.HeaderBuilder.Append("digits(Float) -> float_to_list(Float).");
		this.HeaderBuilder.AppendLineFeed();
	}

	private void AppendZStrDecl() {
		this.HeaderBuilder.Append("zstr(Str) when Str =:= null -> \"null\";");
		this.HeaderBuilder.AppendLineFeed();
		this.HeaderBuilder.Append("zstr(Str) -> Str.");
		this.HeaderBuilder.AppendLineFeed();
	}

	private void AppendWrapperFuncDecl(ZFunctionNode Node) {
		String FuncName = this.ToErlangFuncName(Node.FuncName());
		this.CurrentBuilder.Append(FuncName);
		if (FuncName.equals("main")) { //FIX ME!!
			this.CurrentBuilder.Append("(_)");
		} else {
			this.VisitListNode("(", Node, ")");
		}
		this.CurrentBuilder.Append(" ->");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.IndentAndAppend("try "+ FuncName + "_inner");
		this.VisitListNode("(", Node, ")");
		this.CurrentBuilder.Append(" of");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.IndentAndAppend("_ -> void");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.IndentAndAppend("catch");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.IndentAndAppend("throw:{return, Ret} -> Ret;");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("throw:UnKnown -> throw(UnKnown)");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.IndentAndAppend("end.");

		this.CurrentBuilder.UnIndent();
	}


	private int GetLazyMark() {
		this.CurrentBuilder.Append(null);
		return this.CurrentBuilder.SourceList.size() - 1;
	}
	private void AppendLazy(int mark, String Code) {
		this.CurrentBuilder.SourceList.ArrayValues[mark] = Code;
	}
	private void CreateVariables(ZListNode VargNode) {
		@Var int i = 0;
		while(i < VargNode.GetListSize()) {
			@Var ZParamNode ParamNode = (ZParamNode)VargNode.GetListAt(i);
			this.VarMgr.CreateVariable(ParamNode.GetName());
			i += 1;
		}
	}
	private String ToErlangFuncName(String FuncName) {
		return FuncName.toLowerCase();
	}
	private String ToErlangTypeName(String TypeName) {
		return TypeName.toLowerCase();
	}
	private String ToErlangVarName(String VarName) {
		return VarName.toUpperCase();
	}
}
