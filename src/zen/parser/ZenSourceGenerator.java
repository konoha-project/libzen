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

import zen.ast.GtAndNode;
import zen.ast.GtApplyNode;
import zen.ast.GtArrayLiteralNode;
import zen.ast.GtBinaryNode;
import zen.ast.GtBlockNode;
import zen.ast.GtBooleanNode;
import zen.ast.GtBreakNode;
import zen.ast.GtCastNode;
import zen.ast.GtCatchNode;
import zen.ast.GtConstPoolNode;
import zen.ast.GtErrorNode;
import zen.ast.GtFloatNode;
import zen.ast.GtFuncDeclNode;
import zen.ast.GtFunctionLiteralNode;
import zen.ast.GtGetCapturedNode;
import zen.ast.GtGetIndexNode;
import zen.ast.GtGetLocalNode;
import zen.ast.GtGetterNode;
import zen.ast.GtGroupNode;
import zen.ast.GtIfNode;
import zen.ast.GtInstanceOfNode;
import zen.ast.GtIntNode;
import zen.ast.GtMapLiteralNode;
import zen.ast.GtMethodCallNode;
import zen.ast.GtNewArrayNode;
import zen.ast.GtNewObjectNode;
import zen.ast.GtNullNode;
import zen.ast.GtOrNode;
import zen.ast.GtParamNode;
import zen.ast.GtReturnNode;
import zen.ast.GtSetCapturedNode;
import zen.ast.GtSetIndexNode;
import zen.ast.GtSetLocalNode;
import zen.ast.GtSetterNode;
import zen.ast.GtStringNode;
import zen.ast.GtThrowNode;
import zen.ast.GtTryNode;
import zen.ast.GtUnaryNode;
import zen.ast.GtVarDeclNode;
import zen.ast.GtWhileNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenNode;
import zen.ast.ZenNotNode;
import zen.deps.LibZen;
import zen.deps.ZenMap;
import zen.lang.ZenType;

//endif VAJA

public class ZenSourceGenerator extends ZenGenerator {
	/* field */public ZenMap<String> NativeTypeMap;
	/* field */private final ArrayList<ZenSourceBuilder> BuilderList;
	/* field */protected ZenSourceBuilder HeaderBuilder;
	/* field */protected ZenSourceBuilder CurrentBuilder;

	/* field */public String Tab;
	/* field */public String LineFeed;
	/* field */public String LineComment;
	/* field */public String BeginComment;
	/* field */public String EndComment;
	/* field */public String SemiColon;
	/* field */public String Camma;

	/* field */public String TrueLiteral;
	/* field */public String FalseLiteral;
	/* field */public String NullLiteral;
	/* field */public String TopType;

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
		this.TopType = "var";
	}

	protected ZenSourceBuilder NewSourceBuilder() {
		/* local */ZenSourceBuilder Builder = new ZenSourceBuilder(this);
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

	@Override
	public Object EvalTopLevelNode(ZenNode Node) {
		String Code = this.CurrentBuilder.toString();
		System.out.println(Code);
		this.CurrentBuilder.Clear();
		return null;
	}

	// public final void FlushErrorReport() {
	// /*local*/GtSourceBuilder Builder = this.NewSourceBuilder();
	// /*local*/String[] Reports = this.Logger.GetReportedErrors();
	// /*local*/int i = 0;
	// Builder.AppendLine("");
	// while(i < Reports.length) {
	// Builder.AppendCommentLine(Reports[i]);
	// i = i + 1;
	// }
	// Builder.AppendLine("");
	// }

	public void GenerateCode(ZenNode Node) {
		if (Node == null) {
			this.CurrentBuilder.AppendCommentLine("empty");
		}
		Node.Accept(this);
	}

	@Override
	public void VisitBlockNode(GtBlockNode Node) {
		this.CurrentBuilder.Append("{");
		this.CurrentBuilder.Indent();
		for (int i = 0; i < Node.StatementList.size(); i++) {
			ZenNode SubNode = Node.StatementList.get(i);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder.AppendIndent();
			this.GenerateCode(SubNode);
			this.CurrentBuilder.Append(this.SemiColon);
		}
		this.CurrentBuilder.UnIndent();
		this.CurrentBuilder.AppendLineFeed();
		this.CurrentBuilder.AppendIndent();
		this.CurrentBuilder.Append("}");
	}

	@Override
	public void VisitNullNode(GtNullNode Node) {
		this.CurrentBuilder.Append(this.NullLiteral);
	}

	@Override
	public void VisitBooleanNode(GtBooleanNode Node) {
		if (Node.Value) {
			this.CurrentBuilder.Append(this.TrueLiteral);
		} else {
			this.CurrentBuilder.Append(this.FalseLiteral);
		}
	}

	@Override
	public void VisitIntNode(GtIntNode Node) {
		this.CurrentBuilder.Append("" + Node.Value);
	}

	@Override
	public void VisitFloatNode(GtFloatNode Node) {
		this.CurrentBuilder.Append("" + Node.Value);
	}

	@Override
	public void VisitStringNode(GtStringNode Node) {
		this.CurrentBuilder.Append(LibZen.QuoteString(Node.Value));
	}

	@Override
	public void VisitConstPoolNode(GtConstPoolNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitGroupNode(GtGroupNode Node) {
		this.CurrentBuilder.Append("(");
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitGetIndexNode(GtGetIndexNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(Node.IndexNode);
		this.CurrentBuilder.Append("]");
	}

	@Override
	public void VisitSetIndexNode(GtSetIndexNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append("[");
		this.GenerateCode(Node.IndexNode);
		this.CurrentBuilder.Append("]");
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitGetLocalNode(GtGetLocalNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
	}

	@Override
	public void VisitSetLocalNode(GtSetLocalNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitGetCapturedNode(GtGetCapturedNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
	}

	@Override
	public void VisitSetCapturedNode(GtSetCapturedNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitGetterNode(GtGetterNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.NativeName);
	}

	@Override
	public void VisitSetterNode(GtSetterNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitMethodCallNode(GtMethodCallNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.MethodName);
		this.VisitParamList("(", Node.ParamList, ")");
	}

	@Override
	public void VisitApplyNode(GtApplyNode Node) {
		this.GenerateCode(Node.FuncNode);
		this.VisitParamList("(", Node.ParamList, ")");
	}

	@Override
	public void VisitUnaryNode(GtUnaryNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RecvNode);
	}

	@Override
	public void VisitNotNode(ZenNotNode Node) {
		this.CurrentBuilder.Append(Node.SourceToken.ParsedText);
		//		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append("!");
		//		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitCastNode(GtCastNode Node) {
		this.CurrentBuilder.Append("(");
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.ExprNode);
	}

	@Override
	public void VisitInstanceOfNode(GtInstanceOfNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken("instanceof");
		this.VisitType(Node.RightNode.Type);
	}

	@Override
	public void VisitBinaryNode(GtBinaryNode Node) {
		if (Node.ParentNode instanceof GtBinaryNode) {
			this.CurrentBuilder.Append("(");
		}
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RightNode);
		if (Node.ParentNode instanceof GtBinaryNode) {
			this.CurrentBuilder.Append(")");
		}
	}

	@Override
	public void VisitComparatorNode(ZenComparatorNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RightNode);
	}

	@Override
	public void VisitAndNode(GtAndNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken("&&");
		this.GenerateCode(Node.RightNode);
	}

	@Override
	public void VisitOrNode(GtOrNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken("||");
		this.GenerateCode(Node.RightNode);
	}

	@Override
	public void VisitIfNode(GtIfNode Node) {
		this.CurrentBuilder.Append("if (");
		this.GenerateCode(Node.CondNode);
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.ThenNode);
		if (Node.ElseNode != null) {
			this.CurrentBuilder.AppendToken("else");
			this.GenerateCode(Node.ElseNode);
		}
	}

	@Override
	public void VisitReturnNode(GtReturnNode Node) {
		this.CurrentBuilder.Append("return");
		if (Node.ValueNode != null) {
			this.CurrentBuilder.Append(" ");
			this.GenerateCode(Node.ValueNode);
		}
	}

	@Override
	public void VisitWhileNode(GtWhileNode Node) {
		this.CurrentBuilder.Append("while (");
		this.GenerateCode(Node.CondNode);
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitBreakNode(GtBreakNode Node) {
		this.CurrentBuilder.Append("break");
	}

	@Override
	public void VisitThrowNode(GtThrowNode Node) {
		this.CurrentBuilder.Append("throw ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitTryNode(GtTryNode Node) {
		this.CurrentBuilder.Append("try ");
		this.GenerateCode(Node.TryNode);
		if(Node.CatchNode != null) {
			this.GenerateCode(Node.CatchNode);
		}
		if (Node.FinallyNode != null) {
			this.CurrentBuilder.Append("finally ");
			this.GenerateCode(Node.FinallyNode);
		}
	}

	@Override
	public void VisitCatchNode(GtCatchNode Node) {
		this.CurrentBuilder.Append("catch (");
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.VisitTypeAnnotation(Node.ExceptionType);
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitVarDeclNode(GtVarDeclNode Node) {
		this.CurrentBuilder.Append("var ");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.InitNode);
	}

	protected void VisitTypeAnnotation(ZenType Type) {
		this.CurrentBuilder.Append(" :");
		this.CurrentBuilder.Append(Type.GetNativeName());
	}

	@Override
	public void VisitParamNode(GtParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
		this.VisitTypeAnnotation(Node.Type);
	}

	@Override
	public void VisitFunctionLiteralNode(GtFunctionLiteralNode Node) {
		this.CurrentBuilder.Append("function ");
		this.VisitParamList("(", Node.ArgumentList, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitFuncDeclNode(GtFuncDeclNode Node) {
		this.CurrentBuilder.Append("function ");
		this.CurrentBuilder.Append(Node.FuncName);
		this.VisitParamList("(", Node.ArgumentList, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		if (Node.BodyNode == null) {
			this.CurrentBuilder.Append(this.SemiColon);
		} else {
			this.GenerateCode(Node.BodyNode);
		}
	}

	@Override
	public void VisitErrorNode(GtErrorNode Node) {
		this.Logger.ReportError(Node.SourceToken, Node.ErrorMessage);
		// this.BreakGeneration();
	}

	// Utils
	protected void VisitType(ZenType Type) {
		this.CurrentBuilder.Append(this.GetNativeType(Type));
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
	public void VisitArrayLiteralNode(GtArrayLiteralNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitMapLiteralNode(GtMapLiteralNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitNewArrayNode(GtNewArrayNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitNewObjectNode(GtNewObjectNode Node) {
		// TODO Auto-generated method stub
	}


	// @Override public void FlushBuffer() {
	// LibZen.WriteSource(this.OutputFile, this.BuilderList);
	// this.BuilderList.clear();
	// this.HeaderBuilder.SourceList.clear();
	// }

}
