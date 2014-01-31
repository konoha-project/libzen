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
import zen.ast.ZSymbolNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.lang.ZenEngine;
import zen.lang.ZenTypeSafer;
import zen.type.ZType;

//endif VAJA

public class ZSourceGenerator extends ZGenerator {
	@Field public ZenMap<String> NativeTypeMap;
	@Field private final ArrayList<ZSourceBuilder> BuilderList;
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
		this.BuilderList = new ArrayList<ZSourceBuilder>();
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

	@Override public ZenEngine GetEngine() {
		return new ZenEngine(new ZenTypeSafer(this.Logger), this);
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

	@Override public boolean StartCodeGeneration(ZNode Node, boolean AllowLazy, boolean IsInteractive) {
		if (AllowLazy && Node.IsUntyped()) {
			if(IsInteractive) {
				Node.Accept(this);
				LibNative.println("---");
				LibNative.println(this.CurrentBuilder.toString());
				this.CurrentBuilder.Clear();
				LibNative.println("---");
			}
			return false;
		}
		Node.Accept(this);
		if(IsInteractive) {
			LibNative.println("---");
			LibNative.println(this.CurrentBuilder.toString());
			this.CurrentBuilder.Clear();
			LibNative.println("---");
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

	public void VisitStmtList(ArrayList<ZNode> StmtList) {
		@Var int i = 0;
		while (i < StmtList.size()) {
			@Var ZNode SubNode = StmtList.get(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.GenerateCode(SubNode);
			i = i + 1;
			if(i  < StmtList.size()) {
				this.CurrentBuilder.Append(this.SemiColon);
			}
		}
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Indent();
		this.VisitStmtList(Node.StmtList);
		if(Node.StmtList.size()>0) {
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
		this.CurrentBuilder.Append(LibZen.QuoteString(Node.StringValue));
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.VisitNodeList("[", Node.NodeList, "]");
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
		this.VisitNodeList("(", Node.ParamList, ")");
	}

	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.CurrentBuilder.Append("(");
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(Node.IndexNode);
		this.CurrentBuilder.Append("]");
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(Node.IndexNode);
		this.CurrentBuilder.Append("]");
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.ValueNode);
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {
		//		if(Node.GivenName.equals(Node.ReferenceName) && Node.Type.IsFuncType()) {
		//			Node.ReferenceName = Node.Type.StringfySignature(Node.GivenName); // FIXME
		//		}
		this.CurrentBuilder.Append(Node.ReferenceName);
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.ValueNode);
	}


	@Override public void VisitGetterNode(ZGetterNode Node) {
		this.GenerateSurroundCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.FieldName);
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		this.GenerateSurroundCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.FieldName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.ValueNode);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.GenerateSurroundCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.MethodName);
		this.VisitNodeList("(", Node.ParamList, ")");
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.GenerateCode(Node.FuncNode);
		this.VisitNodeList("(", Node.ParamList, ")");
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RecvNode);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		this.CurrentBuilder.Append(this.NotOperator);
		this.GenerateSurroundCode(Node.RecvNode);
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.CurrentBuilder.Append("(");
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(")");
		this.GenerateSurroundCode(Node.ExprNode);
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken("instanceof");
		this.VisitType(Node.RightNode.Type);
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append("(");
		}
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RightNode);
		if (Node.ParentNode instanceof ZBinaryNode) {
			this.CurrentBuilder.Append(")");
		}
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RightNode);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(this.AndOperator);
		this.GenerateCode(Node.RightNode);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(this.OrOperator);
		this.GenerateCode(Node.RightNode);
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		this.CurrentBuilder.Append("if (");
		this.GenerateCode(Node.CondNode);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(Node.ThenNode);
		if (Node.ElseNode != null) {
			this.CurrentBuilder.AppendToken("else");
			this.GenerateCode(Node.ElseNode);
		}
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.CurrentBuilder.Append("return");
		if (Node.ValueNode != null) {
			this.CurrentBuilder.AppendWhiteSpace();
			this.GenerateCode(Node.ValueNode);
		}
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.CurrentBuilder.Append("while (");
		this.GenerateCode(Node.CondNode);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(Node.BodyNode);
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.CurrentBuilder.Append("break");
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.CurrentBuilder.Append("throw");
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateCode(Node.ValueNode);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		this.CurrentBuilder.Append("try");
		this.GenerateCode(Node.TryNode);
		if(Node.CatchNode != null) {
			this.GenerateCode(Node.CatchNode);
		}
		if (Node.FinallyNode != null) {
			this.CurrentBuilder.Append("finally");
			this.GenerateCode(Node.FinallyNode);
		}
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		this.CurrentBuilder.Append("catch (");
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.VisitTypeAnnotation(Node.ExceptionType);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(Node.BodyNode);
	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		this.CurrentBuilder.Append("var");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.NativeName);
		this.VisitTypeAnnotation(Node.DeclType);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.InitNode);
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node.StmtList);
	}

	protected void VisitTypeAnnotation(ZType Type) {
		this.CurrentBuilder.Append(": ");
		this.VisitType(Type);
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
		this.VisitParamList("(", Node.ParamList, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		this.GenerateCode(Node.FuncBlock);
	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
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
		while (i < Node.FieldList.size()) {
			@Var ZFieldNode FieldNode = Node.FieldList.get(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.CurrentBuilder.Append("field");
			this.CurrentBuilder.AppendWhiteSpace();
			this.CurrentBuilder.Append(FieldNode.FieldName);
			this.VisitTypeAnnotation(FieldNode.DeclType);
			this.CurrentBuilder.AppendToken("=");
			this.GenerateCode(FieldNode.InitNode);
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
		this.CurrentBuilder.Append(LibZen.QuoteString(Node.ErrorMessage));
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitExtendedNode(ZNode Node) {

	}


	// Utils
	protected void VisitType(ZType Type) {
		this.CurrentBuilder.Append(this.GetNativeType(Type.GetRealType()));
	}

	protected void VisitNodeList(String OpenToken, ArrayList<ZNode> NodeList, String CloseToken) {
		this.CurrentBuilder.Append(OpenToken);
		@Var int i = 0;
		while(i < NodeList.size()) {
			@Var ZNode ParamNode = NodeList.get(i);
			if (i > 0) {
				this.CurrentBuilder.Append(", ");
			}
			this.GenerateCode(ParamNode);
			i = i + 1;
		}
		this.CurrentBuilder.Append(CloseToken);
	}

	protected void VisitParamList(String OpenToken, ArrayList<ZParamNode> ParamList, String CloseToken) {
		this.CurrentBuilder.Append(OpenToken);
		@Var int i = 0;
		while(i < ParamList.size()) {
			@Var ZNode ParamNode = ParamList.get(i);
			if (i > 0) {
				this.CurrentBuilder.Append(", ");
			}
			this.GenerateCode(ParamNode);
			i = i + 1;
		}
		this.CurrentBuilder.Append(CloseToken);
	}




}
