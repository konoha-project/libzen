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
import zen.deps.Field;
import zen.deps.Var;
import zen.lang.ZenTypeSafer;
import zen.parser.ZSourceBuilder;
import zen.parser.ZSourceEngine;
import zen.parser.ZSourceGenerator;

//ifdef JAVA

public class ErlSourceCodeGenerator extends ZSourceGenerator {
	@Field private int LoopNodeNumber;
	@Field private int BreakMark;
	@Field private final VariableManager VarMgr;

	public ErlSourceCodeGenerator/*constructor*/() {
		super("erlang", "5.10.4");
		this.LoopNodeNumber = 0;
		this.BreakMark = -1;
		this.VarMgr = new VariableManager();

		this.HeaderBuilder.Append("-module(generated).");
		this.HeaderBuilder.AppendLineFeed();
	}

	@Override public ZSourceEngine GetEngine() {
		return new ZSourceEngine(new ZenTypeSafer(this), this);
	}

	@Override public void VisitStmtList(ZBlockNode BlockNode) {
		this.VisitStmtList(BlockNode, ",");
	}
	public void VisitStmtList(ZBlockNode BlockNode, String last) {
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
		this.CurrentBuilder.IndentAndAppend("__Arguments__ = " + this.VarMgr.GenVarTupleOnlyUsed(false));
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
	// 	this.GenerateCode(null, Node.AST[ZGroupNode._Expr]);
	// 	this.CurrentBuilder.Append(")");
	// }

	// @Override public void VisitGetIndexNode(ZGetIndexNode Node) {
	// 	this.GenerateCode(null, Node.AST[ZGetIndexNode._Recv]);
	// 	this.CurrentBuilder.Append("[");
	// 	this.GenerateCode(null, Node.AST[ZGetIndexNode._Index]);
	// 	this.CurrentBuilder.Append("]");
	// }

	// @Override public void VisitSetIndexNode(ZSetIndexNode Node) {
	// 	this.GenerateCode(null, Node.AST[ZSetIndexNode._Recv]);
	// 	this.CurrentBuilder.Append("[");
	// 	this.GenerateCode(null, Node.AST[ZSetIndexNode._Index]);
	// 	this.CurrentBuilder.Append("]");
	// 	this.CurrentBuilder.AppendToken("=");
	// 	this.GenerateCode(null, Node.AST[ZSetIndexNode._Expr]);
	// }

	// @Override public void VisitGlobalNameNode(ZGlobalNameNode Node) {
	// 	if(Node.IsUntyped()) {
	// 		ZLogger._LogError(Node.SourceToken, "undefined symbol: " + Node.GlobalName);
	// 	}
	// 	if(Node.IsStaticFuncName) {
	// 		this.CurrentBuilder.Append(Node.Type.StringfySignature(Node.GlobalName));
	// 	}
	// 	else {
	// 		this.CurrentBuilder.Append(Node.GlobalName);
	// 	}
	// }

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		String VarName = this.VarMgr.GenVariableName(Node.VarName);
		this.CurrentBuilder.Append(VarName);
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		int mark = this.GetLazyMark();

		this.GenerateCode(null, Node.AST[ZSetNameNode._Expr]);

		String VarName = Node.VarName;
		this.VarMgr.IncrementVariableNumber(VarName);
		this.AppendLazy(mark, this.VarMgr.GenVariableName(VarName) + " = ");
	}


	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.GenerateSurroundCode(Node.AST[ZGetterNode._Recv]);
		this.CurrentBuilder.Append("#");
		this.CurrentBuilder.Append(this.ToErlangTypeName(Node.AST[ZGetterNode._Recv].Type.ShortName));
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(this.ToErlangTypeName(Node.FieldName));
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		int mark = this.GetLazyMark();

		ZGetNameNode GetNameNode = (ZGetNameNode)Node.AST[ZSetterNode._Recv];
		this.GenerateSurroundCode(GetNameNode);
		this.CurrentBuilder.Append("#");
		this.CurrentBuilder.Append(this.ToErlangTypeName(Node.AST[ZSetterNode._Recv].Type.ShortName));
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Append(Node.FieldName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZSetterNode._Expr]);
		this.CurrentBuilder.Append("}");
		this.VarMgr.IncrementVariableNumber(GetNameNode.VarName);
		ZSourceBuilder LazyBuilder = new ZSourceBuilder(this, this.CurrentBuilder);
		ZSourceBuilder BodyBuilder = this.CurrentBuilder;
		this.CurrentBuilder = LazyBuilder;
		this.GenerateCode(null, Node.AST[ZSetterNode._Recv]);
		this.CurrentBuilder.AppendToken("=");
		this.CurrentBuilder = BodyBuilder;
		this.AppendLazy(mark, LazyBuilder.toString());
	}

	// @Override public void VisitMethodCallNode(ZMethodCallNode Node) {
	// 	this.GenerateSurroundCode(Node.AST[ZMethodCallNode._Recv]);
	// 	this.CurrentBuilder.Append(".");
	// 	this.CurrentBuilder.Append(Node.MethodName);
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
		String FuncName = ((ZGlobalNameNode)Node.AST[ZFuncCallNode._Func]).GlobalName;
		FuncName = this.ToErlangFuncName(FuncName);
		this.CurrentBuilder.Append(FuncName);
		//this.GenerateCode(null, Node.AST[ZFuncCallNode._Func]);
		this.VisitListNode("(", Node, ")");
	}

	// @Override public void VisitUnaryNode(ZUnaryNode Node) {
	// 	this.CurrentBuilder.Append(Node.SourceToken.GetText());
	// 	this.GenerateCode(null, Node.AST[ZUnaryNode._Recv]);
	// }

	// @Override public void VisitNotNode(ZNotNode Node) {
	// 	this.CurrentBuilder.Append(this.NotOperator);
	// 	this.GenerateSurroundCode(Node.AST[ZUnaryNode._Recv]);
	// }

	@Override public void VisitCastNode(ZCastNode Node) {
		// this.CurrentBuilder.Append("(");
		// this.GenerateTypeName(Node.Type);
		// this.CurrentBuilder.Append(")");
		this.GenerateSurroundCode(Node.AST[ZCastNode._Expr]);
	}

	// @Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
	// 	this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
	// 	this.CurrentBuilder.AppendToken("instanceof");
	// 	this.GenerateTypeName(Node.AST[ZBinaryNode._Right].Type);
	// }

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append("(");
		}
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		//		this.CurrentBuilder.AppendToken(Node.SourceToken.GetText());
		String Operator = Node.SourceToken.GetText();
		if (Operator == null) {
			//FIXME!! error handling
		} else {
			switch(Operator) {
			case "<<":
				Operator = "bsl";
				break;
			case ">>":
				Operator = "bsr";
				break;
			case "%":
				Operator = "rem";
				break;
			default:
				//pass
			}
		}
		this.CurrentBuilder.AppendToken(Operator);
		this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append(")");
		}
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
		String Operator = Node.SourceToken.GetText();
		if (Operator == null) {
			//FIXME!! error handling
		} else {
			switch(Operator) {
			case "<=":
				Operator = "=<";
				break;
			default:
				//pass
			}
		}
		this.CurrentBuilder.AppendToken(Operator);
		this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
	}

	// @Override public void VisitAndNode(ZAndNode Node) {
	// 	this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
	// 	this.CurrentBuilder.AppendToken(this.AndOperator);
	// 	this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
	// }

	// @Override public void VisitOrNode(ZOrNode Node) {
	// 	this.GenerateCode(null, Node.AST[ZBinaryNode._Left]);
	// 	this.CurrentBuilder.AppendToken(this.OrOperator);
	// 	this.GenerateCode(null, Node.AST[ZBinaryNode._Right]);
	// }

	@Override public void VisitIfNode(ZIfNode Node) {
		int mark = this.GetLazyMark();

		this.CurrentBuilder.Append("if");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.GenerateCode(null, Node.AST[ZIfNode._Cond]);
		this.CurrentBuilder.Append(" ->");
		this.VisitBlockNode((ZBlockNode)Node.AST[ZIfNode._Then], ";");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("true ->");
		if (Node.AST[ZIfNode._Else] != null) {
			this.VisitBlockNode((ZBlockNode)Node.AST[ZIfNode._Else], "");
		} else {
			this.CurrentBuilder.Indent();
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.IndentAndAppend(this.VarMgr.GenVarTupleOnlyUsedByChildScope(false));
			this.CurrentBuilder.UnIndent();
		}
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("end");

		this.AppendLazy(mark, this.VarMgr.GenVarTupleOnlyUsed(true) + " = ");
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.CurrentBuilder.Append("throw({return, ");
		if (Node.AST[ZReturnNode._Expr] != null) {
			this.GenerateCode(null, Node.AST[ZReturnNode._Expr]);
		} else {
			this.CurrentBuilder.Append("void");
		}
		this.CurrentBuilder.Append("})");
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.LoopNodeNumber += 1;
		String WhileNodeName = "Loop" + Integer.toString(this.LoopNodeNumber);

		int mark1 = this.GetLazyMark();

		this.VarMgr.StartUsingFilter(false);
		this.VisitBlockNode((ZBlockNode)Node.AST[ZWhileNode._Block], ",");
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.IndentAndAppend(WhileNodeName + "(" + WhileNodeName + ", __Arguments__);");
		this.CurrentBuilder.UnIndent();

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("(_, Args) ->");
		this.CurrentBuilder.Indent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("Args");
		this.CurrentBuilder.UnIndent();

		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.IndentAndAppend("end,");

		this.VarMgr.StopUsingFilter();
		this.VarMgr.ContinueUsingFilter(true);
		ZSourceBuilder LazyBuilder = new ZSourceBuilder(this, this.CurrentBuilder);
		ZSourceBuilder BodyBuilder = this.CurrentBuilder;
		this.CurrentBuilder = LazyBuilder;
		this.GenerateCode(null, Node.AST[ZWhileNode._Cond]);
		this.CurrentBuilder = BodyBuilder;
		this.AppendLazy(mark1, ""
				+ WhileNodeName
				+ " = fun(" + WhileNodeName + ", "
				+ this.VarMgr.GenVarTupleOnlyUsedByChildScope(false)
				+ ") when "
				+ LazyBuilder.toString()
				+ " -> ");

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
	// 	this.GenerateCode(null, Node.AST[ZThrowNode._Expr]);
	// }

	// @Override public void VisitTryNode(ZTryNode Node) {
	// 	this.CurrentBuilder.Append("try");
	// 	this.GenerateCode(null, Node.AST[ZTryNode._Try]);
	// 	if(Node.AST[ZTryNode._Catch] != null) {
	// 		this.GenerateCode(null, Node.AST[ZTryNode._Catch]);
	// 	}
	// 	if (Node.AST[ZTryNode._Finally] != null) {
	// 		this.CurrentBuilder.Append("finally");
	// 		this.GenerateCode(null, Node.AST[ZTryNode._Finally]);
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

		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);

		@Var String VarName = Node.NativeName;
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

	// @Override public void VisitLetNode(ZLetNode Node) {
	// 	this.CurrentBuilder.Append("let");
	// 	this.CurrentBuilder.AppendWhiteSpace();
	// 	this.CurrentBuilder.Append(Node.GlobalName);
	// 	this.CurrentBuilder.AppendToken("=");
	// 	this.GenerateCode(null, Node.AST[ZLetNode._InitValue]);
	// }

	@Override
	public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(this.ToErlangVarName(Node.Name));
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		this.VarMgr.PushScope();
		this.CreateVariables(Node);

		String FuncName = this.ToErlangFuncName(Node.FuncName);
		this.HeaderBuilder.Append("-export([" + FuncName + "/" + Node.GetListSize() + "]).");
		this.HeaderBuilder.AppendLineFeed();

		this.CurrentBuilder.Append(FuncName + "_inner");
		this.VisitListNode("(", Node, ")");
		this.CurrentBuilder.Append("->");
		if (Node.AST[ZFunctionNode._Block] == null) {
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("pass.");
		} else {
			this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);
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
		this.CurrentBuilder.Append(this.ToErlangTypeName(Node.ClassName));
		if(Node.SuperType != null) {
			throw new RuntimeException("\"extends\" is not supported yet");
		}
		this.CurrentBuilder.Append(", {");
		@Var int i = 0;
		@Var int size = Node.GetListSize();
		while (i < size) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.CurrentBuilder.Append(this.ToErlangTypeName(FieldNode.FieldName));
			if(FieldNode.HasAst(ZFieldNode._InitValue)) {
				this.CurrentBuilder.AppendToken("=");
				this.GenerateCode(null, FieldNode.AST[ZFieldNode._InitValue]);
			}
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

	private void AppendWrapperFuncDecl(ZFunctionNode Node){
		String FuncName = this.ToErlangFuncName(Node.FuncName);
		this.CurrentBuilder.Append(FuncName);
		this.VisitListNode("(", Node, ")");
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
			this.VarMgr.CreateVariable(ParamNode.Name);
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
