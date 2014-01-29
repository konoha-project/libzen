// ***************************************************************************
// Copyright (c) 2013-2014, Konoha project authors. All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// *  Redistributions of source code must retain the above copyright notice,
//    this list of conditions and the following disclaimer.
// *  Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
// PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
// CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
// OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
// WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
// OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
// ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// **************************************************************************

//ifdef JAVA

package zen.lang;

import java.util.ArrayList;

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassDeclNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZConstPoolNode;
import zen.ast.ZEmptyNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFuncDeclNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetLocalNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewArrayNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetLocalNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZSymbolNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.deps.Var;
import zen.parser.ZGenerator;
import zen.parser.ZLogger;
import zen.parser.ZParserConst;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.parser.ZVisitor;
import zen.type.ZTypeChecker;

public class ZenEngine extends ZVisitor {
	private boolean IsVisitable = true;
	protected Object EvaledValue = null;
	protected ZTypeChecker TypeChecker;
	public final ZGenerator Generator;

	private final ArrayList<ZNode> LazyNodeList = new ArrayList<ZNode>();
	public ZLogger Logger;
	private boolean IsInteractive;

	public ZenEngine(ZTypeChecker TypeChecker, ZGenerator Generator) {
		this.TypeChecker = TypeChecker;
		this.Generator = Generator;
		this.Logger = Generator.Logger;
	}

	public final void LazyNode(ZNode Node) {
		this.LazyNodeList.add(Node);
	}

	public final void Sync() {
		@Var int i = 0;
		while(i < this.LazyNodeList.size()) {
			@Var ZNode Node = this.LazyNodeList.get(i);
			this.Generator.StartCodeGeneration(Node, false, this.IsInteractive);
		}
	}

	@Override public final boolean IsVisitable() {
		return this.IsVisitable;
	}

	@Override public final void EnableVisitor() {
		this.EvaledValue = null;
		this.IsVisitable = true;
	}

	@Override public final void StopVisitor() {
		this.EvaledValue = null;
		this.IsVisitable = false;
	}

	protected void Unsupported(ZNode Node, String Message) {
		this.Logger.ReportError(Node.SourceToken, "unsupported " + Message + " (at the top level)");
		this.EvaledValue = null; //"unsupported node: " + Node.getClass().getSimpleName();
		this.IsVisitable = false;
	}

	protected final Object Eval(ZNode Node) {
		if(this.IsVisitable()) {
			Node.Accept(this);
		}
		return this.EvaledValue;
	}

	@Override public void VisitEmptyNode(ZEmptyNode Node) {
		this.StopVisitor();
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.EvaledValue = null;
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.EvaledValue = Node.BooleanValue;
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.EvaledValue = Node.IntValue;
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.EvaledValue = Node.FloatValue;
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.EvaledValue = Node.StringValue;
	}

	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
		this.EvaledValue = Node.ConstValue;
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.Unsupported(Node, "array literal");
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.Unsupported(Node, "map literal");
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		this.Unsupported(Node, "new");
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.Unsupported(Node, "new");
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {
		this.Unsupported(Node, "symbol " + Node.ReferenceName);
	}

	@Override public void VisitGetLocalNode(ZGetLocalNode Node) {
		this.Unsupported(Node, "local variable");
	}

	@Override public void VisitSetLocalNode(ZSetLocalNode Node) {
		this.Unsupported(Node, "local variable");
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.EvaledValue = this.Eval(Node.RecvNode);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.Unsupported(Node, "field accessor");
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		this.Unsupported(Node, "field accessor");
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.Unsupported(Node, "indexer");
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.Unsupported(Node, "indexer");
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.Unsupported(Node, "method call");
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.Unsupported(Node, "function call");
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.Unsupported(Node, "unary " + Node.SourceToken.ParsedText);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		this.Unsupported(Node, "unary " + Node.SourceToken.ParsedText);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		if(Node.Type.IsVoidType()) {
			this.EvaledValue = this.Eval(Node.ExprNode);
			Node.Type = Node.ExprNode.Type;
		}
		else {
			this.Unsupported(Node, "cast");
		}
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.Unsupported(Node, "<:");
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		this.Unsupported(Node, "binary " + Node.SourceToken.ParsedText);
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.Unsupported(Node, "binary " + Node.SourceToken.ParsedText);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		@Var Object BooleanValue = this.Eval(Node.LeftNode);
		if(BooleanValue instanceof Boolean) {
			if((Boolean)BooleanValue) {
				this.EvaledValue = this.Eval(Node.RightNode);
			}
			else {
				this.EvaledValue = false;
			}
		}
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		@Var Object BooleanValue = this.Eval(Node.LeftNode);
		if(BooleanValue instanceof Boolean) {
			if(!(Boolean)BooleanValue) {
				this.EvaledValue = this.Eval(Node.RightNode);
			}
			else {
				this.EvaledValue = true;
			}
		}
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		@Var int i = 1;
		while(i < Node.StmtList.size() && this.IsVisitable()) {
			ZNode StmtNode = Node.StmtList.get(i).GetStatementNode();
			this.Eval(StmtNode);
			if(StmtNode.IsBreakingBlock()) {
				break;
			}
		}
		this.EvaledValue = null;
	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		this.Unsupported(Node, "variable declaration");
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Object BooleanValue = this.Eval(Node.CondNode);
		if(BooleanValue instanceof Boolean) {
			if((Boolean)BooleanValue) {
				this.Eval(Node.ThenNode);
			}
			else if(Node.ElseNode != null) {
				this.Eval(Node.ThenNode);
			}
		}
		this.EvaledValue = null;
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.Unsupported(Node, "return");
		throw new RuntimeException();
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.Unsupported(Node, "while");
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.Unsupported(Node, "break");
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.Unsupported(Node, "throw");
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.Unsupported(Node, "try");
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		this.Unsupported(Node, "catch");
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		this.Unsupported(Node, "function");
	}

	@Override public void VisitFuncDeclNode(ZFuncDeclNode Node) {
		if(!this.Generator.StartCodeGeneration(Node, true, this.IsInteractive)) {
			this.LazyNode(Node);
		}
	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
		if(!this.Generator.StartCodeGeneration(Node, true, this.IsInteractive)) {
			this.LazyNode(Node);
		}
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.Logger.ReportError(Node.SourceToken, Node.ErrorMessage);
		//this.FoundError(Node.ErrorMessage);
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		// TODO Auto-generated method stub

	}

	public final Object Exec(ZNode Node, boolean IsInteractive) {
		this.IsInteractive = IsInteractive;
		this.EnableVisitor();
		System.err.println("Before: " +Node);
		Node = this.TypeChecker.CheckType(Node, this.Generator.RootNameSpace, ZSystem.VoidType);
		System.err.println("After:" + Node);
		@Var Object ResultValue = this.Eval(Node);
		return ResultValue;
	}

	public final Object Eval(String ScriptText, long FileLine, boolean IsInteractive) {
		@Var Object ResultValue = ZParserConst.UndefinedSymbol;
		//ZenLogger.VerboseLog(ZenLogger.VerboseEval, "eval: " + ScriptText);
		@Var ZTokenContext TokenContext = new ZTokenContext(this.Generator.RootNameSpace, ScriptText, FileLine);
		TokenContext.SkipEmptyStatement();
		while(TokenContext.HasNext()) {
			TokenContext.SetParseFlag(0); // init
			@Var ZNode TopLevelNode = TokenContext.ParsePattern(this.Generator.RootNameSpace, "$Statement$", ZTokenContext.Required);
			System.out.println("interprinting .." + TopLevelNode.getClass().getSimpleName());
			ResultValue = this.Exec(TopLevelNode, IsInteractive);
			if(TopLevelNode.IsErrorNode() && TokenContext.HasNext()) {
				@Var ZToken Token = TokenContext.GetToken();
				this.Generator.Logger.ReportInfo(Token, "stopped script at this line");
				return TopLevelNode;
			}
			TokenContext.SkipEmptyStatement();
			TokenContext.Vacume();
		}
		return ResultValue;
	}


	public final boolean Load(String ScriptText, long FileLine) {
		@Var Object Token = this.Eval(ScriptText, FileLine, false);
		this.Logger.ShowReportedErrors();
		if(Token instanceof ZToken && ((ZToken)Token).IsError()) {
			return false;
		}
		return true;
	}
	//
	//	public final boolean LoadFile(String FileName) {
	//		@Var String ScriptText = LibNative.LoadTextFile(FileName);
	//		if(ScriptText != null) {
	//			@Var long FileLine = ZSystem.GetFileLine(FileName, 1);
	//			return this.Load(ScriptText, FileLine);
	//		}
	//		return false;
	//	}
	//
	//	public final boolean LoadRequiredLib(String LibName) {
	//		@Var String Key = ZParserConst.NativeNameSuffix + "L" + LibName.toLowerCase();
	//		if(!this.HasSymbol(Key)) {
	//			@Var String Path = LibZen.GetLibPath(this.Generator.TargetCode, LibName);
	//			@Var String Script = LibNative.LoadTextFile(Path);
	//			if(Script != null) {
	//				@Var long FileLine = ZSystem.GetFileLine(Path, 1);
	//				if(this.Load(Script, FileLine)) {
	//					this.SetSymbol(Key, Path, null);
	//					return true;
	//				}
	//			}
	//			return false;
	//		}
	//		return true;
	//	}


}
