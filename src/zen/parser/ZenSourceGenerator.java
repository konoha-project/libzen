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

import zen.ast.ZenAndNode;
import zen.ast.ZenArrayLiteralNode;
import zen.ast.ZenBinaryNode;
import zen.ast.ZenBlockNode;
import zen.ast.ZenBooleanNode;
import zen.ast.ZenBreakNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenConstPoolNode;
import zen.ast.ZenEmptyNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFloatNode;
import zen.ast.ZenFuncCallNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionLiteralNode;
import zen.ast.ZenGetIndexNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenGetterNode;
import zen.ast.ZenGroupNode;
import zen.ast.ZenIfNode;
import zen.ast.ZenInstanceOfNode;
import zen.ast.ZenIntNode;
import zen.ast.ZenMapLiteralNode;
import zen.ast.ZenMethodCallNode;
import zen.ast.ZenNewArrayNode;
import zen.ast.ZenNewObjectNode;
import zen.ast.ZenNode;
import zen.ast.ZenNotNode;
import zen.ast.ZenNullNode;
import zen.ast.ZenOrNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenSetIndexNode;
import zen.ast.ZenSetLocalNode;
import zen.ast.ZenSetterNode;
import zen.ast.ZenStringNode;
import zen.ast.ZenStupidCastNode;
import zen.ast.ZenSymbolNode;
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenUnaryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast.ZenWhileNode;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.lang.ZenType;

//endif VAJA

public class ZenSourceGenerator extends ZenGenerator {
	@Field public ZenMap<String> NativeTypeMap;
	@Field private final ArrayList<ZenSourceBuilder> BuilderList;
	@Field protected ZenSourceBuilder HeaderBuilder;
	@Field protected ZenSourceBuilder CurrentBuilder;

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

	public ZenSourceGenerator(String TargetCode, String TargetVersion) {
		super(TargetCode, TargetVersion);
		this.NativeTypeMap = new ZenMap<String>(null);
		this.BuilderList = new ArrayList<ZenSourceBuilder>();
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

	protected ZenSourceBuilder NewSourceBuilder() {
		@Var ZenSourceBuilder Builder = new ZenSourceBuilder(this);
		this.BuilderList.add(Builder);
		return Builder;
	}

	protected void SetNativeType(ZenType Type, String TypeName) {
		String Key = "" + Type.TypeId;
		this.NativeTypeMap.put(Key, TypeName);
	}

	protected String GetNativeType(ZenType Type) {
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

	@Override public Object EvalTopLevelNode(ZenNode Node) {
		String Code = this.CurrentBuilder.toString();
		System.out.println(Code);
		this.CurrentBuilder.Clear();
		return null;
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

	public void GenerateCode(ZenNode Node) {
		Node.Accept(this);
	}

	protected boolean IsNeededSurroud(ZenNode Node) {
		if(Node instanceof ZenBinaryNode) {
			return true;
		}
		return false;
	}

	protected void GenerateSurroundCode(ZenNode Node) {
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

	public void VisitStmtList(ArrayList<ZenNode> StmtList) {
		int i = 0;
		while (i < StmtList.size()) {
			ZenNode SubNode = StmtList.get(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.GenerateCode(SubNode);
			i = i + 1;
			if(i  < StmtList.size()) {
				this.CurrentBuilder.Append(this.SemiColon);
			}
		}
	}

	@Override public void VisitBlockNode(ZenBlockNode Node) {
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

	@Override
	public void VisitEmptyNode(ZenEmptyNode Node) {
	}

	@Override
	public void VisitNullNode(ZenNullNode Node) {
		this.CurrentBuilder.Append(this.NullLiteral);
	}

	@Override
	public void VisitBooleanNode(ZenBooleanNode Node) {
		if (Node.BooleanValue) {
			this.CurrentBuilder.Append(this.TrueLiteral);
		} else {
			this.CurrentBuilder.Append(this.FalseLiteral);
		}
	}

	@Override
	public void VisitIntNode(ZenIntNode Node) {
		this.CurrentBuilder.Append("" + Node.Value);
	}

	@Override
	public void VisitFloatNode(ZenFloatNode Node) {
		this.CurrentBuilder.Append("" + Node.Value);
	}

	@Override
	public void VisitStringNode(ZenStringNode Node) {
		this.CurrentBuilder.Append(LibZen.QuoteString(Node.Value));
	}

	@Override
	public void VisitConstPoolNode(ZenConstPoolNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitGroupNode(ZenGroupNode Node) {
		this.CurrentBuilder.Append("(");
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitGetIndexNode(ZenGetIndexNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(Node.IndexNode);
		this.CurrentBuilder.Append("]");
	}

	@Override
	public void VisitSetIndexNode(ZenSetIndexNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(Node.IndexNode);
		this.CurrentBuilder.Append("]");
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.ValueNode);
	}

	@Override public void VisitSymbolNode(ZenSymbolNode Node) {
		this.CurrentBuilder.Append(Node.ResourceName);
	}

	@Override
	public void VisitGetLocalNode(ZenGetLocalNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
	}

	@Override
	public void VisitSetLocalNode(ZenSetLocalNode Node) {
		this.CurrentBuilder.Append(Node.VarName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.ValueNode);
	}


	@Override public void VisitGetterNode(ZenGetterNode Node) {
		this.GenerateSurroundCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.NativeName);
	}

	@Override
	public void VisitSetterNode(ZenSetterNode Node) {
		this.GenerateSurroundCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitMethodCallNode(ZenMethodCallNode Node) {
		this.GenerateSurroundCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.MethodName);
		this.VisitParamList("(", Node.ParamList, ")");
	}

	@Override
	public void VisitFuncCallNode(ZenFuncCallNode Node) {
		this.GenerateCode(Node.FuncNode);
		this.VisitParamList("(", Node.ParamList, ")");
	}

	@Override
	public void VisitUnaryNode(ZenUnaryNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RecvNode);
	}

	@Override
	public void VisitNotNode(ZenNotNode Node) {
		this.CurrentBuilder.Append(this.NotOperator);
		this.GenerateSurroundCode(Node.RecvNode);
	}

	@Override
	public void VisitCastNode(ZenCastNode Node) {
		this.CurrentBuilder.Append("(");
		if(Node instanceof ZenStupidCastNode) {
			this.CurrentBuilder.AppendBlockComment("stupid");
		}
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(")");
		this.GenerateSurroundCode(Node.ExprNode);
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken("instanceof");
		this.VisitType(Node.RightNode.Type);
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		if (Node.ParentNode instanceof ZenBinaryNode) {
			this.CurrentBuilder.Append("(");
		}
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RightNode);
		if (Node.ParentNode instanceof ZenBinaryNode) {
			this.CurrentBuilder.Append(")");
		}
	}

	@Override public void VisitComparatorNode(ZenComparatorNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RightNode);
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(this.AndOperator);
		this.GenerateCode(Node.RightNode);
	}

	@Override
	public void VisitOrNode(ZenOrNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(this.OrOperator);
		this.GenerateCode(Node.RightNode);
	}

	@Override
	public void VisitIfNode(ZenIfNode Node) {
		this.CurrentBuilder.Append("if (");
		this.GenerateCode(Node.CondNode);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(Node.ThenNode);
		if (Node.ElseNode != null) {
			this.CurrentBuilder.AppendToken("else");
			this.GenerateCode(Node.ElseNode);
		}
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		this.CurrentBuilder.Append("return");
		if (Node.ValueNode != null) {
			this.CurrentBuilder.AppendWhiteSpace();
			this.GenerateCode(Node.ValueNode);
		}
	}

	@Override public void VisitWhileNode(ZenWhileNode Node) {
		this.CurrentBuilder.Append("while (");
		this.GenerateCode(Node.CondNode);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(Node.BodyNode);
	}

	@Override public void VisitBreakNode(ZenBreakNode Node) {
		this.CurrentBuilder.Append("break");
	}

	@Override public void VisitThrowNode(ZenThrowNode Node) {
		this.CurrentBuilder.Append("throw");
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateCode(Node.ValueNode);
	}

	@Override public void VisitTryNode(ZenTryNode Node) {
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

	@Override public void VisitCatchNode(ZenCatchNode Node) {
		this.CurrentBuilder.Append("catch (");
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.VisitTypeAnnotation(Node.ExceptionType);
		this.CurrentBuilder.Append(")");
		this.GenerateCode(Node.BodyNode);
	}

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		this.CurrentBuilder.Append("var");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.NativeName);
		this.VisitTypeAnnotation(Node.DeclType);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.InitNode);
	}

	protected void VisitTypeAnnotation(ZenType Type) {
		this.CurrentBuilder.Append(": ");
		this.VisitType(Type);
	}

	@Override public void VisitParamNode(ZenParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
		this.VisitTypeAnnotation(Node.Type);
	}

	@Override public void VisitFunctionLiteralNode(ZenFunctionLiteralNode Node) {
		this.CurrentBuilder.Append("function");
		this.CurrentBuilder.AppendWhiteSpace();
		this.VisitParamList("(", Node.ArgumentList, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		this.GenerateCode(Node.BodyNode);
	}

	@Override public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
		this.CurrentBuilder.Append("function");
		this.CurrentBuilder.AppendWhiteSpace();
		this.CurrentBuilder.Append(Node.FuncName);
		this.VisitParamList("(", Node.ArgumentList, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		if (Node.BodyNode == null) {
			this.CurrentBuilder.Append(this.SemiColon);
		} else {
			this.GenerateCode(Node.BodyNode);
		}
	}

	@Override public void VisitErrorNode(ZenErrorNode Node) {
		this.Logger.ReportError(Node.SourceToken, Node.ErrorMessage);
	}

	// Utils
	protected void VisitType(ZenType Type) {
		this.CurrentBuilder.Append(this.GetNativeType(Type.GetRealType()));
	}

	protected void VisitParamList(String OpenToken, ArrayList<ZenNode> ParamList, String CloseToken) {
		this.CurrentBuilder.Append(OpenToken);
		for (int i = 0; i < ParamList.size(); i++) {
			ZenNode ParamNode = ParamList.get(i);
			if (i > 0) {
				this.CurrentBuilder.Append(", ");
			}
			this.GenerateCode(ParamNode);
		}
		this.CurrentBuilder.Append(CloseToken);
	}

	@Override
	public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitMapLiteralNode(ZenMapLiteralNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitNewArrayNode(ZenNewArrayNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitNewObjectNode(ZenNewObjectNode Node) {
		// TODO Auto-generated method stub
	}


}
