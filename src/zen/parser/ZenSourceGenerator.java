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
import zen.ast.ZenApplyNode;
import zen.ast.ZenArrayLiteralNode;
import zen.ast.ZenBinaryNode;
import zen.ast.ZenBlockNode;
import zen.ast.ZenBooleanNode;
import zen.ast.ZenBreakNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
import zen.ast.ZenConstPoolNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFloatNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionLiteralNode;
import zen.ast.ZenGetCapturedNode;
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
import zen.ast.ZenNullNode;
import zen.ast.ZenOrNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenSetCapturedNode;
import zen.ast.ZenSetIndexNode;
import zen.ast.ZenSetLocalNode;
import zen.ast.ZenSetterNode;
import zen.ast.ZenStringNode;
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenUnaryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast.ZenWhileNode;
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

	/* field */public String NotOperator;
	/* field */public String AndOperator;
	/* field */public String OrOperator;

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
		this.AndOperator = "&&";
		this.OrOperator = "||";
		this.NotOperator = "!";
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

//	public final void FlushErrorReport() {
//		/*local*/ZenSourceBuilder Builder = this.NewSourceBuilder();
//		/*local*/String[] Reports = this.Logger.GetReportedErrors();
//		Builder.AppendLine("");
//		for(/*local*/int i = 0; i < Reports.length; i = i + 1) {
//			Builder.AppendCommentLine(Reports[i]);
//		}
//		Builder.AppendLine("");
//	}

	public void GenerateCode(ZenNode Node) {
		if (Node == null) {
			this.CurrentBuilder.AppendCommentLine("empty");
		}
		Node.Accept(this);
	}

	@Override
	public void VisitBlockNode(ZenBlockNode Node) {
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
	public void VisitNullNode(ZenNullNode Node) {
		this.CurrentBuilder.Append(this.NullLiteral);
	}

	@Override
	public void VisitBooleanNode(ZenBooleanNode Node) {
		if (Node.Value) {
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
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitGetLocalNode(ZenGetLocalNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
	}

	@Override
	public void VisitSetLocalNode(ZenSetLocalNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitGetCapturedNode(ZenGetCapturedNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
	}

	@Override
	public void VisitSetCapturedNode(ZenSetCapturedNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitGetterNode(ZenGetterNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.NativeName);
	}

	@Override
	public void VisitSetterNode(ZenSetterNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitMethodCallNode(ZenMethodCallNode Node) {
		this.GenerateCode(Node.RecvNode);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.MethodName);
		this.VisitParamList("(", Node.ParamList, ")");
	}

	@Override
	public void VisitApplyNode(ZenApplyNode Node) {
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
		//		this.CurrentBuilder.Append("(");
		this.GenerateCode(Node.RecvNode);
		//		this.CurrentBuilder.Append(")");
	}

	@Override
	public void VisitCastNode(ZenCastNode Node) {
		this.CurrentBuilder.Append("(");
		this.VisitType(Node.Type);
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.ExprNode);
	}

	@Override
	public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken("instanceof");
		this.VisitType(Node.RightNode.Type);
	}

	@Override
	public void VisitBinaryNode(ZenBinaryNode Node) {
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

	@Override
	public void VisitComparatorNode(ZenComparatorNode Node) {
		this.GenerateCode(Node.LeftNode);
		this.CurrentBuilder.AppendToken(Node.SourceToken.ParsedText);
		this.GenerateCode(Node.RightNode);
	}

	@Override
	public void VisitAndNode(ZenAndNode Node) {
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
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.ThenNode);
		if (Node.ElseNode != null) {
			this.CurrentBuilder.AppendToken("else");
			this.GenerateCode(Node.ElseNode);
		}
	}

	@Override
	public void VisitReturnNode(ZenReturnNode Node) {
		this.CurrentBuilder.Append("return");
		if (Node.ValueNode != null) {
			this.CurrentBuilder.Append(" ");
			this.GenerateCode(Node.ValueNode);
		}
	}

	@Override
	public void VisitWhileNode(ZenWhileNode Node) {
		this.CurrentBuilder.Append("while (");
		this.GenerateCode(Node.CondNode);
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitBreakNode(ZenBreakNode Node) {
		this.CurrentBuilder.Append("break");
	}

	@Override
	public void VisitThrowNode(ZenThrowNode Node) {
		this.CurrentBuilder.Append("throw ");
		this.GenerateCode(Node.ValueNode);
	}

	@Override
	public void VisitTryNode(ZenTryNode Node) {
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
	public void VisitCatchNode(ZenCatchNode Node) {
		this.CurrentBuilder.Append("catch (");
		this.CurrentBuilder.Append(Node.ExceptionName);
		this.VisitTypeAnnotation(Node.ExceptionType);
		this.CurrentBuilder.Append(") ");
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitVarDeclNode(ZenVarDeclNode Node) {
		this.CurrentBuilder.Append("var ");
		this.CurrentBuilder.Append(Node.NativeName);
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(Node.InitNode);
	}

	protected void VisitTypeAnnotation(ZenType Type) {
		this.CurrentBuilder.Append(" :");
		this.VisitType(Type);
	}

	@Override
	public void VisitParamNode(ZenParamNode Node) {
		this.CurrentBuilder.Append(Node.Name);
		this.VisitTypeAnnotation(Node.Type);
	}

	@Override
	public void VisitFunctionLiteralNode(ZenFunctionLiteralNode Node) {
		this.CurrentBuilder.Append("function ");
		this.VisitParamList("(", Node.ArgumentList, ")");
		this.VisitTypeAnnotation(Node.ReturnType);
		this.GenerateCode(Node.BodyNode);
	}

	@Override
	public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
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
	public void VisitErrorNode(ZenErrorNode Node) {
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


	// @Override public void FlushBuffer() {
	// LibZen.WriteSource(this.OutputFile, this.BuilderList);
	// this.BuilderList.clear();
	// this.HeaderBuilder.SourceList.clear();
	// }

}
