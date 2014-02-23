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

package zen.parser;

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZClassNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGlobalNameNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZImportNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZLetNode;
import zen.ast.ZMacroNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZPrototypeNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZSugarNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZTypeNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypeChecker;

public class ZSourceEngine extends ZVisitor {
	protected final ZTypeChecker TypeChecker;
	public final ZGenerator Generator;
	public final ZLogger Logger;

	private boolean InteractiveContext = false;
	private boolean IsVisitable = true;

	public ZSourceEngine(ZTypeChecker TypeChecker, ZGenerator Generator) {
		this.TypeChecker = TypeChecker;
		this.Generator = Generator;
		this.Logger = Generator.Logger;
	}

	@Override public final boolean IsVisitable() {
		return this.IsVisitable;
	}

	@Override public void EnableVisitor() {
		this.IsVisitable = true;
	}

	@Override public void StopVisitor() {
		this.IsVisitable = false;
	}

	protected Object Eval(ZNode Node) {
		if(this.IsVisitable()) {
			Node.Accept(this);
		}
		return ZEmptyValue.TrueEmpty;
	}

	public final Object Exec(ZNode Node, boolean IsInteractive) {
		this.InteractiveContext = IsInteractive;
		this.EnableVisitor();
		Node = this.TypeChecker.CheckType(Node, ZType.VoidType);
		@Var Object ResultValue = this.Eval(Node);
		return ResultValue;
	}

	public final Object Eval(ZNameSpace NameSpace, String ScriptText, String FileName, int LineNumber, boolean IsInteractive) {
		@Var Object ResultValue = ZEmptyValue.TrueEmpty;
		@Var ZBlockNode TopBlockNode = new ZBlockNode(NameSpace);
		@Var ZTokenContext TokenContext = new ZTokenContext(this.Generator, NameSpace, FileName, LineNumber, ScriptText);
		TokenContext.SkipEmptyStatement();
		@Var ZToken SkipToken = TokenContext.GetToken();
		while(TokenContext.HasNext()) {
			TokenContext.SetParseFlag(ZTokenContext.NotAllowSkipIndent);
			TopBlockNode.ClearListAfter(0);
			SkipToken = TokenContext.GetToken();
			@Var ZNode ParsedNode = TokenContext.ParsePattern(TopBlockNode, "$Statement$", ZTokenContext.Required);
			if(ParsedNode.IsErrorNode()) {
				TokenContext.SkipError(SkipToken);
			}
			ResultValue = this.Exec(ParsedNode, IsInteractive);
			if(ResultValue == ZEmptyValue.FalseEmpty) {
				break;
			}
			TokenContext.SkipEmptyStatement();
			TokenContext.Vacume();
		}
		if(TokenContext.HasNext() && !IsInteractive) {
			ZLogger._LogInfo(SkipToken, "stopped script at this line");
		}
		return ResultValue;
	}

	public final Object Eval(String ScriptText, String FileName, int LineNumber, boolean IsInteractive) {
		return this.Eval(this.Generator.RootNameSpace, ScriptText, FileName, LineNumber, IsInteractive);
	}

	public boolean Load(String FileName) {
		@Var String ScriptText = LibZen.LoadTextFile(FileName);
		if(ScriptText == null) {
			LibZen._Exit(1, "file not found: " + FileName);
			return false;
		}
		Object ResultValue = this.Eval(ScriptText, FileName, 1, false);
		this.Logger.ShowErrors();
		if(ResultValue == ZEmptyValue.FalseEmpty) {
			return false;
		}
		return true;
	}

	//	public final boolean Load(ZNameSpace NameSpace, String ScriptText, long FileLine) {
	//		@Var Object Token = this.Eval(NameSpace, ScriptText, FileLine, false);
	//		this.Logger.ShowReportedErrors();
	//		if(Token == ZEmptyValue.FalseEmpty) {
	//			return false;
	//		}
	//		return true;
	//	}
	//
	//	public final boolean Load(String ScriptText, long FileLine) {
	//		return this.Load(this.Generator.RootNameSpace, ScriptText, FileLine);
	//	}


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
	//		@Var String Key = ZParserConst.NativeNameRight + "L" + LibName.toLowerCase();
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

	protected void Unsupported(ZNode Node) {
		if(this.InteractiveContext) {
			this.Generator.StartCodeGeneration(Node, this.InteractiveContext);
		}
		else {
			ZLogger._LogError(Node.SourceToken, "unsupported at top level");
			this.StopVisitor();
		}
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.Unsupported(Node);
	}

	//	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
	//		this.Unsupported(Node);
	//	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitGlobalNameNode(ZGlobalNameNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.Eval(Node.AST[ZGroupNode._Expr]);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitMacroNode(ZMacroNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		if(Node.Type.IsVoidType()) {
			this.Eval(Node.AST[ZCastNode._Expr]);
			Node.Type = Node.AST[ZCastNode._Expr].Type;
		}
		else {
			this.Unsupported(Node);
		}
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		@Var int i = 1;
		while(i < Node.GetListSize() && this.IsVisitable()) {
			ZNode StmtNode = Node.GetListAt(i);
			this.Eval(StmtNode);
			if(StmtNode.IsBreakingBlock()) {
				break;
			}
		}
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Object BooleanValue = this.Eval(Node.AST[ZIfNode._Cond]);
		if(BooleanValue instanceof Boolean) {
			if((Boolean)BooleanValue) {
				this.Eval(Node.AST[ZIfNode._Then]);
			}
			else if(Node.AST[ZIfNode._Else] != null) {
				this.Eval(Node.AST[ZIfNode._Then]);
			}
		}
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.Unsupported(Node);
	}

	//	@Override public void VisitCatchNode(ZCatchNode Node) {
	//		this.Unsupported(Node);
	//	}

	@Override public void VisitLetNode(ZLetNode Node) {
		if(Node.HasUntypedNode()) {
			LibZen._PrintDebug("HasUntypedNode: " + Node.HasUntypedNode() + "\n" + Node);
		}
		this.Generator.StartCodeGeneration(Node, this.InteractiveContext);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(Node.HasUntypedNode()) {
			LibZen._PrintDebug("HasUntypedNode: " + Node.HasUntypedNode() + "\nLAZY: " + Node);
		}
		this.Generator.StartCodeGeneration(Node, this.InteractiveContext);
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		if(Node.HasUntypedNode()) {
			LibZen._PrintDebug("HasUntypedNode: " + Node.HasUntypedNode() + "\n" + Node);
		}
		this.Generator.StartCodeGeneration(Node, this.InteractiveContext);
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		ZLogger._LogError(Node.SourceToken, Node.ErrorMessage);
		this.StopVisitor();
	}

	public void VisitPrototypeNode(ZPrototypeNode Node) {
		@Var ZFuncType FuncType = Node.GetFuncType();
		this.Generator.SetPrototype(Node, Node.FuncName, FuncType);
	}

	public void VisitImportNode(ZImportNode Node) {
		Node.Import();
	}

	public void VisitTypeNode(ZTypeNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitExtendedNode(ZNode Node) {
		if(Node instanceof ZPrototypeNode) {
			this.VisitPrototypeNode((ZPrototypeNode)Node);
		}
		else if(Node instanceof ZImportNode) {
			this.VisitImportNode((ZImportNode)Node);
		}
		else if(Node instanceof ZTypeNode) {
			this.VisitTypeNode((ZTypeNode)Node);
		}
		else {
			@Var ZNode SugarNode = Node.DeSugar(this.Generator);
			SugarNode.Accept(this);
		}
	}

	@Override public void VisitSugarNode(ZSugarNode Node) {
		this.Eval(Node.AST[ZSugarNode._DeSugar]);
	}

	public void WriteTo(String OutputFile) {
		this.Generator.WriteTo(OutputFile);
		this.Generator.Logger.ShowErrors();
	}

}
