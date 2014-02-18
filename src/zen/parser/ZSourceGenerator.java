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
import zen.ast.ZCatchNode;
import zen.ast.ZClassNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZLetNode;
import zen.ast.ZListNode;
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
import zen.ast.ZSetNameNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZArray;
import zen.deps.ZenMap;
import zen.lang.ZenTypeSafer;
import zen.type.ZType;



public class ZSourceGenerator extends ZGenerator {
	@Field public ZenMap<String> NativeTypeMap;
	@Field private final ZArray<ZSourceBuilder> BuilderList;
	@Field protected ZSourceBuilder HeaderBuilder;
	@Field protected ZSourceBuilder CurrentBuilder;

	@Field public String Tab;
	@Field public String LineFeed;
	@Field public String LineComment;
	@Field public String BeginComment;
	@Field public String EndComment;
	@Field public String SemiColon;
	@Field public String Camma;

	@Field public String TrueLiteral;
	@Field public String FalseLiteral;
	@Field public String NullLiteral;

	@Field public String NotOperator;
	@Field public String AndOperator;
	@Field public String OrOperator;

	@Field public String TopType;

	public ZSourceGenerator(String TargetCode, String TargetVersion) {
		super(TargetCode, TargetVersion);
		this.NativeTypeMap = new ZenMap<String>(null);
		this.BuilderList = new ZArray<ZSourceBuilder>(new ZSourceBuilder[4]);
		this.HeaderBuilder = this.NewSourceBuilder();
		this.CurrentBuilder = this.HeaderBuilder;
		this.LineFeed = "\n";
		this.Tab = "   ";
		this.LineComment = "//"; // if not, set null
		this.BeginComment = "/*";
		this.EndComment = "*/";
		this.Camma = ", ";
		this.SemiColon = ";";
		this.TrueLiteral = "true";
		this.FalseLiteral = "false";
		this.NullLiteral = "null";
		this.AndOperator = "&&";
		this.OrOperator = "||";
		this.NotOperator = "!";
		this.TopType = "var";
	}

	@Override public ZScriptEngine GetEngine() {
		return new ZScriptEngine(new ZenTypeSafer(this), this);
	}

	protected ZSourceBuilder NewSourceBuilder() {
		@Var ZSourceBuilder Builder = new ZSourceBuilder(this);
		this.BuilderList.add(Builder);
		return Builder;
	}

	protected void SetNativeType(ZType Type, String TypeName) {
		String Key = "" + Type.TypeId;
		this.NativeTypeMap.put(Key, TypeName);
	}

	protected String GetNativeType(ZType Type) {
		if (Type == null) {
			return this.TopType;
		}
		String Key = "" + Type.TypeId;
		String TypeName = this.NativeTypeMap.GetOrNull(Key);
		if (TypeName == null) {
			return Type.ShortName;
		}
		return TypeName;
	}

	@Override public boolean StartCodeGeneration(ZNode Node, boolean IsInteractive) {
		Node.Accept(this);
		if(IsInteractive) {
			LibZen._PrintLine("---");
			LibZen._PrintLine(this.CurrentBuilder.toString());
			this.CurrentBuilder.Clear();
			LibZen._PrintLine("---");
		}
		return true;
	}

	//	public final void FlushErrorReport() {
	//		@Var ZenSourceBuilder Builder = this.NewSourceBuilder();
	//		@Var String[] Reports = this.Logger.GetReportedErrors();
	//		Builder.AppendLine("");
	//		for(@Var int i = 0; i < Reports.length; i = i + 1) {
	//			Builder.AppendCommentLine(Reports[i]);
	//		}
	//		Builder.AppendLine("");
	//	}


	protected final void GenerateCode(ZNode Node) {
		Node.Accept(this);
	}

	protected boolean IsNeededSurroud(ZNode Node) {
		if(Node instanceof ZBinaryNode) {
			return true;
		}
		return false;
	}

	protected void GenerateSurroundCode(ZNode Node) {
		if(this.IsNeededSurroud(Node)) {
			this.CurrentBuilder.Append("(");
			this.GenerateCode(Node);
			this.CurrentBuilder.Append(")");
		}
		else {
			this.GenerateCode(Node);
		}
	}

	public void AppendCode(String RawSource) {
		this.CurrentBuilder.Append(RawSource);
	}

	public void VisitStmtList(ZBlockNode BlockNode) {
		@Var int i = 0;
		while (i < BlockNode.GetListSize()) {
			@Var ZNode SubNode = BlockNode.GetListAt(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.GenerateCode(SubNode);
			i = i + 1;
			if(i  < BlockNode.GetListSize()) {
				this.CurrentBuilder.Append(this.SemiColon);
			}
		}
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node);
		if(Node.GetListSize()>0) {
			this.CurrentBuilder.Append(this.SemiColon);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("}");
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.CurrentBuilder.Append(this.NullLiteral);
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		if (Node.BooleanValue) {
			this.CurrentBuilder.Append(this.TrueLiteral);
		} else {
			this.CurrentBuilder.Append(this.FalseLiteral);
		}
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.CurrentBuilder.Append(String.valueOf(Node.IntValue));
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.CurrentBuilder.Append(String.valueOf(Node.FloatValue));
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.CurrentBuilder.Append(LibZen._QuoteString(Node.StringValue));
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.VisitListNode("[", Node, "]");
		// TODO Auto-generated method stub
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.CurrentBuilder.Append("new");
		this.CurrentBuilder.AppendWhiteSpace();
		this.VisitType(Node.Type);
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.CurrentBuilder.Append("(");
		this.GenerateCode(Node.AST[ZGroupNode._Expr]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.GenerateCode(Node.AST[ZGetIndexNode._Recv]);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(Node.AST[ZGetIndexNode._Index]);
		this.CurrentBuilder.Append("]");
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.GenerateCode(Node.AST[ZSetIndexNode._Recv]);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(Node.AST[ZSetIndexNode._Index]);
		this.CurrentBuilder.Append("]");
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZSetIndexNode._Expr]);
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZSetNameNode._Expr]);
	}


	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.GenerateSurroundCode(Node.AST[ZGetterNode._Recv]);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.FieldName);
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		this.GenerateSurroundCode(Node.AST[ZSetterNode._Recv]);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.FieldName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZSetterNode._Expr]);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.GenerateSurroundCode(Node.AST[ZMethodCallNode._Recv]);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.MethodName);
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.GenerateCode(Node.AST[ZFuncCallNode._Func]);
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		this.GenerateCode(Node.AST[ZUnaryNode._Recv]);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		this.CurrentBuilder.Append(this.NotOperator);
		this.GenerateSurroundCode(Node.AST[ZUnaryNode._Recv]);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.CurrentBuilder.Append("(");
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(")");
		this.GenerateSurroundCode(Node.AST[ZCastNode._Expr]);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken("instanceof");
		this.VisitType(Node.AST[ZBinaryNode._Right].Type);
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append("(");
		}
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken(Node.SourceToken.GetText());
		this.GenerateCode(Node.AST[ZBinaryNode._Right]);
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append(")");
		}
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken(Node.SourceToken.GetText());
		this.GenerateCode(Node.AST[ZBinaryNode._Right]);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken(this.AndOperator);
		this.GenerateCode(Node.AST[ZBinaryNode._Right]);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		this.GenerateCode(Node.AST[ZBinaryNode._Left]);
		this.CurrentBuilder.AppendToken(this.OrOperator);
		this.GenerateCode(Node.AST[ZBinaryNode._Right]);
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		this.CurrentBuilder.Append("if (");
		this.GenerateCode(Node.AST[ZIfNode._Cond]);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(Node.AST[ZIfNode._Then]);
		if (Node.AST[ZIfNode._Else] != null) {
			this.CurrentBuilder.AppendToken("else");
			this.GenerateCode(Node.AST[ZIfNode._Else]);
		}
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.CurrentBuilder.Append("return");
		if (Node.AST[ZReturnNode._Expr] != null) {
			this.CurrentBuilder.AppendWhiteSpace();
			this.GenerateCode(Node.AST[ZReturnNode._Expr]);
		}
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.CurrentBuilder.Append("while (");
		this.GenerateCode(Node.AST[ZWhileNode._Cond]);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(Node.AST[ZWhileNode._Block]);
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.CurrentBuilder.Append("break");
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("throw");
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateCode(Node.AST[ZThrowNode._Expr]);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(Node.AST[ZTryNode._Try]);
		if(Node.AST[ZTryNode._Catch] != null) {
			this.GenerateCode(Node.AST[ZTryNode._Catch]);
		}
		if (Node.AST[ZTryNode._Finally] != null) {
			this.CurrentBuilder.Append("finally");
			this.GenerateCode(Node.AST[ZTryNode._Finally]);
		}
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("catch (");
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.VisitTypeAnnotation(Node.ExceptionType);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(Node.AST[ZCatchNode._Block]);
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.Append("var");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.NativeName);
		this.VisitTypeAnnotation(Node.DeclType);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node);
	}

	protected void VisitTypeAnnotation(ZType Type) {
		this.CurrentBuilder.Append(": ");
		this.VisitType(Type);
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		this.CurrentBuilder.Append("let");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.GlobalName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.AST[ZLetNode._InitValue]);
	}

	public void VisitParamNode(ZParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
		this.VisitTypeAnnotation(Node.Type);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		this.CurrentBuilder.Append("function");
		this.CurrentBuilder.AppendWhiteSpace();
		if(Node.FuncName != null) {
			this.CurrentBuilder.Append(Node.FuncName);
		}
		this.VisitListNode("(", Node, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		this.GenerateCode(Node.AST[ZFunctionNode._Block]);
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		this.CurrentBuilder.Append("class");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.ClassName);
		if(Node.SuperType != null) {
			this.CurrentBuilder.AppendToken("extends");
			this.VisitType(Node.SuperType);
		}
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Indent();
		@Var int i = 0;
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("field");
			this.CurrentBuilder.AppendWhiteSpace();
			this.CurrentBuilder.Append(FieldNode.FieldName);
			this.VisitTypeAnnotation(FieldNode.DeclType);
			this.CurrentBuilder.AppendToken("=");
			this.GenerateCode(FieldNode.AST[ZFieldNode._InitValue]);
			this.CurrentBuilder.Append(this.SemiColon);
			i = i + 1;
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("}");
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.Logger.ReportError(Node.SourceToken, Node.ErrorMessage);
		this.CurrentBuilder.Append("ThrowError(");
		this.CurrentBuilder.Append(LibZen._QuoteString(Node.ErrorMessage));
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitExtendedNode(ZNode Node) {

	}


	// Utils
	protected void VisitType(ZType Type) {
		this.CurrentBuilder.Append(this.GetNativeType(Type.GetRealType()));
	}

	protected void VisitListNode(String OpenToken, ZListNode VargNode, String DelimToken, String CloseToken) {
		this.CurrentBuilder.Append(OpenToken);
		@Var int i = 0;
		while(i < VargNode.GetListSize()) {
			@Var ZNode ParamNode = VargNode.GetListAt(i);
			if (i > 0) {
				this.CurrentBuilder.Append(DelimToken);
			}
			this.GenerateCode(ParamNode);
			i = i + 1;
		}
		this.CurrentBuilder.Append(CloseToken);
	}

	protected void VisitListNode(String OpenToken, ZListNode VargNode, String CloseToken) {
		this.VisitListNode(OpenToken, VargNode, ", ", CloseToken);
	}

}
