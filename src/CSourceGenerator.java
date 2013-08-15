// ***************************************************************************
// Copyright (c) 2013, JST/CREST DEOS project authors. All rights reserved.
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

//ifdef  JAVA
import java.util.ArrayList;
//endif VAJA

//GreenTea Generator should be written in each language.

public class CSourceGenerator extends SourceGenerator {
	/*field*/public final String[] DefaultTypes = {"void", "int", "boolean", "float", "double", "String", "Object", "Array", "Func", "var", "any"};
	/*field*/public final GtMap DefinedClass;
	
	CSourceGenerator/*constructor*/() {
		super("C");
		this.DefinedClass = new GtMap();
	}

	public void VisitBlockEachStatementWithIndent(GtNode Node, boolean NeedBlock) {
		/*local*/String Code = "";
		if(NeedBlock) {
			Code += "{\n";
			this.Indent();
		}
		/*local*/GtNode CurrentNode = Node;
		while(CurrentNode != null) {
			CurrentNode.Evaluate(this);
			Code += this.GetIndentString() + this.PopSourceCode() + ";\n";
			CurrentNode = CurrentNode.NextNode;
		}
		if(NeedBlock) {
			this.UnIndent();
			Code += this.GetIndentString() + "}";
		}
		this.PushSourceCode(Code);
	}

	@Override public void VisitEmptyNode(GtNode Node) {
		this.PushSourceCode("");
	}

	@Override public void VisitSuffixNode(SuffixNode Node) {
		/*local*/String MethodName = Node.Token.ParsedText;
		Node.Expr.Evaluate(this);
		this.PushSourceCode(this.PopSourceCode() + MethodName);
	}

	@Override public void VisitUnaryNode(UnaryNode Node) {
		/*local*/String MethodName = Node.Token.ParsedText;
		Node.Expr.Evaluate(this);
		this.PushSourceCode(MethodName + this.PopSourceCode());
	}

	@Override public void VisitIndexerNode(IndexerNode Node) {
		Node.IndexAt.Evaluate(this);
		Node.Expr.Evaluate(this);
		this.PushSourceCode(this.PopSourceCode() + "[" + this.PopSourceCode() + "]");
	}

	@Override public void VisitMessageNode(MessageNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitWhileNode(WhileNode Node) {
		Node.CondExpr.Evaluate(this);
		/*local*/String Program = "while(" + this.PopSourceCode() + ")";
		this.VisitBlockEachStatementWithIndent(Node.LoopBody, true);
		Program += this.PopSourceCode();
		this.PushSourceCode(Program);
	}

	@Override public void VisitDoWhileNode(DoWhileNode Node) {
		/*local*/String Program = "do";
		this.VisitBlockEachStatementWithIndent(Node.LoopBody, true);
		Node.CondExpr.Evaluate(this);
		Program += " while(" + this.PopSourceCode() + ")";
		this.PushSourceCode(Program);
	}

	@Override public void VisitForNode(ForNode Node) {
		Node.IterExpr.Evaluate(this);
		Node.CondExpr.Evaluate(this);
		/*local*/String Cond = this.PopSourceCode();
		/*local*/String Iter = this.PopSourceCode();
		/*local*/String Program = "for(; " + Cond  + "; " + Iter + ")";
		Node.LoopBody.Evaluate(this);
		Program += this.PopSourceCode();
		this.PushSourceCode(Program);
	}

	@Override public void VisitForEachNode(ForEachNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitConstNode(ConstNode Node) {
		/*local*/String Code = "NULL";
		if(Node.ConstValue != null) {
			Code = this.StringfyConstValue(Node.ConstValue);
		}
		this.PushSourceCode(Code);
	}

	@Override public void VisitNewNode(NewNode Node) {
		/*local*/String Type = Node.Type.ShortClassName;
		this.PushSourceCode("new " + Type + "()");
	}

	@Override public void VisitNullNode(NullNode Node) {
		this.PushSourceCode("NULL");
	}

	@Override public void VisitLocalNode(LocalNode Node) {
		this.PushSourceCode(Node.LocalName);
	}

	@Override public void VisitGetterNode(GetterNode Node) {
		Node.Expr.Evaluate(this);
		this.PushSourceCode(this.PopSourceCode() + "->" + Node.Method.MethodName);
	}

	@Override public void VisitApplyNode(ApplyNode Node) {
		/*local*/String Program = this.GenerateMacro(Node);
		/*local*/int i = 0;
		while(i < GtStatic.ListSize(Node.Params)) {
			Node.Params.get(i).Evaluate(this);
			Program = Program.replace("$" + i, this.PopSourceCode());
			i = i + 1;
		}
		this.PushSourceCode(Program);
	}

	private String GenerateMacro(ApplyNode Node) {
		if(Node.Method.SourceMacro != null) {
			return Node.Method.SourceMacro;
		}
		/*local*/String Template = Node.Method.GetNativeFuncName() + "(";
		/*local*/int i = 0;
		/*local*/int ParamSize = Node.Params.size();
		while(i < ParamSize) {
			if(i != 0) {
				Template += " ,";
			}
			Template += "$" + i;
			i = i + 1;
		}
		Template += ")";
		return Template;
	}

	@Override public void VisitBinaryNode(BinaryNode Node) {
		/*local*/String MethodName = Node.Token.ParsedText;
		Node.RightNode.Evaluate(this);
		Node.LeftNode.Evaluate(this);
		this.PushSourceCode(this.PopSourceCode() + " " + MethodName + " " + this.PopSourceCode());
	}

	@Override public void VisitAndNode(AndNode Node) {
		Node.RightNode.Evaluate(this);
		Node.LeftNode.Evaluate(this);
		this.PushSourceCode(this.PopSourceCode() + " && " + this.PopSourceCode());
	}

	@Override public void VisitOrNode(OrNode Node) {
		Node.RightNode.Evaluate(this);
		Node.LeftNode.Evaluate(this);
		this.PushSourceCode(this.PopSourceCode() + " || " + this.PopSourceCode());
	}

	@Override public void VisitAssignNode(AssignNode Node) {
		Node.RightNode.Evaluate(this);
		Node.LeftNode.Evaluate(this);
		this.PushSourceCode(this.PopSourceCode() + " = " + this.PopSourceCode());
	}

	@Override public void VisitLetNode(LetNode Node) {
		/*local*/String Type = Node.DeclType.ShortClassName;
		/*local*/String VarName = Node.VariableName;
		/*local*/String Code = Type + " " + VarName;
		if(Node.InitNode != null) {
			Node.InitNode.Evaluate(this);
			Code += " = " + this.PopSourceCode();
		}
		Code +=  ";\n";
		this.VisitBlockEachStatementWithIndent(Node.BlockNode, true);
		this.PushSourceCode(Code + this.GetIndentString() + this.PopSourceCode());
	}

	@Override public void VisitIfNode(IfNode Node) {
		Node.CondExpr.Evaluate(this);
		this.VisitBlockEachStatementWithIndent(Node.ThenNode, true);
		this.VisitBlockEachStatementWithIndent(Node.ElseNode, true);
		/*local*/String ElseBlock = this.PopSourceCode();
		/*local*/String ThenBlock = this.PopSourceCode();
		/*local*/String CondExpr = this.PopSourceCode();
		/*local*/String Code = "if(" + CondExpr + ") " + ThenBlock;
		if(Node.ElseNode != null) {
			Code += " else " + ElseBlock;
		}
		this.PushSourceCode(Code);

	}

	@Override public void VisitSwitchNode(SwitchNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitReturnNode(ReturnNode Node) {
		/*local*/String Code = "return";
		if(Node.Expr != null) {
			Node.Expr.Evaluate(this);
			Code += " " + this.PopSourceCode();
		}
		this.PushSourceCode(Code);
	}

	@Override public void VisitLabelNode(LabelNode Node) {
		/*local*/String Label = Node.Label;
		this.PushSourceCode(Label + ":");
	}

	@Override public void VisitJumpNode(JumpNode Node) {
		/*local*/String Label = Node.Label;
		this.PushSourceCode("goto " + Label);
	}

	@Override public void VisitBreakNode(BreakNode Node) {
		/*local*/String Code = "break";
		/*local*/String Label = Node.Label;
		if(Label != null) {
			Code += " " + Label;
		}
		this.PushSourceCode(Code);
	}

	@Override public void VisitContinueNode(ContinueNode Node) {
		/*local*/String Code = "continue";
		/*local*/String Label = Node.Label;
		if(Label != null) {
			Code += " " + Label;
		}
		this.PushSourceCode(Code);
	}

	@Override public void VisitTryNode(TryNode Node) {
		/*local*/String Code = "try ";
		this.VisitBlockEachStatementWithIndent(Node.TryBlock, true);
		Code += this.PopSourceCode();
		/*local*/LetNode Val = (/*cast*/LetNode) Node.CatchExpr;
		Code += " catch (" + Val.Type.toString() + " " + Val.VariableName + ") ";
		this.VisitBlockEachStatementWithIndent(Node.CatchBlock, true);
		Code += this.PopSourceCode();
		if(Node.FinallyBlock != null) {
			this.VisitBlockEachStatementWithIndent(Node.FinallyBlock, true);
			Code += " finally " + this.PopSourceCode();
		}
		this.PushSourceCode(Code);
	}

	@Override public void VisitThrowNode(ThrowNode Node) {
		Node.Expr.Evaluate(this);
		/*local*/String Code = "throw " + this.PopSourceCode();
		this.PushSourceCode(Code);
	}

	@Override public void VisitFunctionNode(FunctionNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitErrorNode(ErrorNode Node) {
		/*local*/String Code = "throw Error(\"" + Node.Token.ParsedText + "\")";
		this.PushSourceCode(Code);
	}

	@Override public void VisitCommandNode(CommandNode Node) {
		/*local*/String Code = "system(";
		/*local*/int i = 0;
		/*local*/String Command = "String __Command = ";
		while(i < GtStatic.ListSize(Node.Params)) {
			GtNode Param = Node.Params.get(i);
			if(i != 0) {
				Command += " + ";
			}
			Param.Evaluate(this);
			Command += "(" + this.PopSourceCode() + ")";
			i = i + 1;
		}
		Code = Command + ";\n" + this.GetIndentString() + Code + "__Command)";
		this.PushSourceCode(Code);
	}

	public String LocalTypeName(GtType Type) {
		return Type.ShortClassName;
	}

	@Override public void GenerateMethod(GtMethod Method, ArrayList<String> ParamNameList, GtNode Body) {
		/*local*/String Code = "";
		if(!Method.Is(ExportMethod)) {
			Code = "static ";
		}
		/*local*/String RetTy = this.LocalTypeName(Method.GetReturnType());
		Code += RetTy + " " + Method.GetNativeFuncName() + "(";
		/*local*/int i = 0;
		while(i < ParamNameList.size()) {
			String ParamTy = this.LocalTypeName(Method.GetFuncParamType(i));
			if(i > 0) {
				Code += ", ";
			}
			Code += ParamTy + " " + ParamNameList.get(i);
			i = i + 1;
		}
		Code += ")";
		this.VisitBlockEachStatementWithIndent(Body, true);
		Code += this.PopSourceCode();
		this.WriteTranslatedCode(Code);
	}

	@Override public Object Eval(GtNode Node) {
		this.VisitBlockEachStatementWithIndent(Node, false);
		/*local*/String Code = this.PopSourceCode();
		if(Code.equals(";\n")) {
			return "";
		}
		this.WriteTranslatedCode(Code);
		return Code;
	}

	protected boolean IsDefiendType(String TypeName) {
		/*local*/int i = 0;
		while(i < this.DefaultTypes.length) {
			if(this.DefaultTypes[i].equals(TypeName)) {
				return true;
			}
			i = i + 1;
		}
		// FIXME care about "var", "any"
		
		return false;
	}

	@Override public void GenerateClassField(GtNameSpace NameSpace, GtType Type, ArrayList<GtVariableInfo> FieldList) {
		/*local*/int i = 0;
		/*local*/String Program = this.GetIndentString() + "struct " + Type.ShortClassName + "{\n";
		this.Indent();
		if(Type.SuperClass != null) {
			Program += this.GetIndentString() + Type.SuperClass.ShortClassName + " __base;\n";
		}
		while (i < FieldList.size()) {
			/*local*/GtVariableInfo VarInfo = FieldList.get(i);
			/*local*/GtType VarType = VarInfo.Type;
			/*local*/String VarName = VarInfo.Name;
			Program += this.GetIndentString() + VarType.ShortClassName + " " + VarName + ";\n";
			this.DefinedClass.put(Type.ShortClassName, Program);
			ArrayList<GtType> ParamList = new ArrayList<GtType>();
			ParamList.add(VarType);
			ParamList.add(Type);
			GtMethod GetterMethod = new GtMethod(0, VarName, 0, ParamList, null);
			NameSpace.Context.DefineGetterMethod(GetterMethod);
			i = i + 1;
		}
		this.UnIndent();
		Program += this.GetIndentString() + "};";
		this.WriteTranslatedCode(Program);
	}

//	@Override public void DefineClassMethod(GtNameSpace NameSpace, GtType Type, GtMethod Method) {
//		/*local*/String Program = (/*cast*/String) this.DefinedClass.get(Type.ShortClassName);
//		this.Indent();
//		Program += this.GetIndentString() + Method.GetFuncType().ShortClassName + " " + Method.MangledName + ";\n";
//		this.UnIndent();
//		this.DefinedClass.put(Type.ShortClassName, Program);
//	}

	@Override public void AddClass(GtType Type) {
		/*local*/String TypeName = Type.ShortClassName;
		if(this.IsDefiendType(TypeName) == true) {
			return;
		}
		/*local*/String Program = this.GetIndentString() + "typedef struct " + TypeName;
		this.WriteTranslatedCode(Program + " " + TypeName + ";");
	}

	@Override public void SetLanguageContext(GtClassContext Context) {
		Context.Eval(LangDeps.LoadFile("lib/c/common.green"), 1);
	}
}