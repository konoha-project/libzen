package zen.codegen.jvm;

import zen.ast.ZArrayLiteralNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGlobalNameNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZLetNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZParamNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZVarNode;
import zen.lang.ZenTypeSafer;
import zen.parser.ZLogger;
import zen.parser.ZSourceEngine;
import zen.parser.ZSourceGenerator;
import zen.type.ZClassField;
import zen.type.ZClassType;
import zen.type.ZFuncType;
import zen.type.ZGenericType;
import zen.type.ZType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZArray;
import zen.util.ZenMap;
import zen.util.ZenMethod;

public class JavaSourceGenerator extends ZSourceGenerator {

	@Field private ZFunctionNode MainFuncNode = null;
	@Field private final ZArray<ZFunctionNode> ExportFunctionList = new ZArray<ZFunctionNode>(new ZFunctionNode[4]);

	public JavaSourceGenerator() {
		super("java", "1.6");

		this.TopType = "Object";
		this.SetNativeType(ZType.BooleanType, "boolean");
		this.SetNativeType(ZType.IntType, "long");
		this.SetNativeType(ZType.FloatType, "double");
		this.SetNativeType(ZType.StringType, "String");

		this.SetMacro("assert", "assert($[0])", ZType.VoidType, ZType.BooleanType, ZType.StringType);
		this.SetMacro("print", "System.out.print($[0])", ZType.VoidType, ZType.StringType);
		this.SetMacro("println", "System.out.println($[0])", ZType.VoidType, ZType.StringType);

		// Converter
		this.SetConverterMacro("(double)($[0])", ZType.FloatType, ZType.IntType);
		this.SetConverterMacro("(long)($[0])", ZType.IntType, ZType.FloatType);
		this.SetConverterMacro("String.valueOf($[0])", ZType.StringType, ZType.BooleanType);
		this.SetConverterMacro("String.valueOf($[0])", ZType.StringType, ZType.IntType);
		this.SetConverterMacro("String.valueOf($[0])", ZType.StringType, ZType.FloatType);

		// String
		this.SetMacro("==", "$[0].equals($[1])", ZType.StringType, ZType.StringType, ZType.StringType);
		this.SetMacro("size", "($[0]).length()", ZType.IntType, ZType.StringType);
		this.SetMacro("substring", "$[0].substring($[1])", ZType.StringType, ZType.StringType, ZType.IntType);
		this.SetMacro("substring", "$[0].sunstring($[1], $[2])", ZType.StringType, ZType.StringType, ZType.IntType, ZType.IntType);
		this.SetMacro("indexOf", "$[0].indexOf($[1])", ZType.IntType, ZType.StringType, ZType.StringType);
		this.SetMacro("indexOf", "$[0].indexOf($[1], $[2])", ZType.IntType, ZType.StringType, ZType.StringType, ZType.IntType);
		this.SetMacro("equals", "$[0].equals($[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);
		this.SetMacro("startsWith", "$[0].startsWith($[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);
		this.SetMacro("endsWith", "$[0].endsWith($[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);

		// Array
		this.SetMacro("size", "LibZen_ArraySize($[0])", ZType.IntType, ZGenericType._ArrayType);
		this.SetMacro("clear", "LibZen_ArrayClear($[0], $[1])", ZType.VoidType, ZGenericType._ArrayType, ZType.IntType);
		this.SetMacro("add", "LibZen_ArrayAdd($[0], $[1])", ZType.VoidType, ZGenericType._ArrayType, ZType.VarType);
		this.SetMacro("add", "LibZen_ArrayAdd2($[0], $[1], $[2])", ZType.VoidType, ZGenericType._ArrayType, ZType.IntType, ZType.VarType);

		this.HeaderBuilder.Append("import java.lang.*\n");
		//		this.HeaderBuilder.Append("#include<stdlib.h>\n");
		//		this.HeaderBuilder.Append("#include<assert.h>\n", "\n");
	}


	@Override public ZSourceEngine GetEngine() {
		return new ZSourceEngine(new ZenTypeSafer(this), this);
	}

	@Override @ZenMethod protected void Finish() {
		this.GenerateClass("public final", "ZenCommand", ZType.VarType);
		this.CurrentBuilder.OpenIndent(" {");
		if(this.MainFuncNode != null) {
			this.CurrentBuilder.AppendNewLine("public final static void main(String[] a)");
			this.CurrentBuilder.OpenIndent(" {");
			this.CurrentBuilder.AppendNewLine("F", this.MainFuncNode.GetSignature(this), ".f();");
			this.CurrentBuilder.CloseIndent("}");
		}
		this.CurrentBuilder.CloseIndent("}");
		this.CurrentBuilder.AppendLineFeed();
	}


	@Override protected void GenerateCode(ZType ContextType, ZNode Node) {
		if(Node.IsUntyped() && !Node.IsErrorNode() && !(Node instanceof ZGlobalNameNode)) {
			this.CurrentBuilder.Append("/*untyped*/" + this.NullLiteral);
			ZLogger._LogError(Node.SourceToken, "untyped error: " + Node);
		}
		else {
			if(ContextType != null && Node.Type != ContextType) {
				this.CurrentBuilder.Append("(");
				this.GenerateTypeName(ContextType);
				this.CurrentBuilder.Append(")");
			}
			Node.Accept(this);
		}
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		@Var ZType ParamType = Node.Type.GetParamType(0);
		if(ParamType.IsIntType() || ParamType.IsBooleanType()) {
			this.CurrentBuilder.Append("LibZen_NewIntArray(");
		}
		else if(ParamType.IsFloatType()) {
			this.CurrentBuilder.Append("LibZen_NewFloatArray(");
		}
		else if(ParamType.IsStringType()) {
			this.CurrentBuilder.Append("LibZen_NewStringArray(");
		}
		else {
			this.CurrentBuilder.Append("LibZen_NewArray(");
		}
		this.CurrentBuilder.Append(String.valueOf(Node.GetListSize()));
		if(Node.GetListSize() > 0) {
			this.CurrentBuilder.Append(this.Camma);
		}
		this.VisitListNode("", Node, ")");
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		@Var ZType ParamType = Node.Type.GetParamType(0);
		if(ParamType.IsIntType() || ParamType.IsBooleanType()) {
			this.CurrentBuilder.Append("LibZen_NewIntMap(");
		}
		else if(ParamType.IsFloatType()) {
			this.CurrentBuilder.Append("LibZen_NewFloatMap(");
		}
		else if(ParamType.IsStringType()) {
			this.CurrentBuilder.Append("LibZen_NewStringMap(");
		}
		else {
			this.CurrentBuilder.Append("LibZen_NewMap(");
		}
		this.CurrentBuilder.Append(String.valueOf(Node.GetListSize()));
		if(Node.GetListSize() > 0) {
			this.CurrentBuilder.Append(this.Camma);
		}
		this.VisitListNode("", Node, ")");
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.CurrentBuilder.Append("new " + this.NameClass(Node.Type));
		this.VisitListNode("(", Node, ")");
	}

	private String BaseName(ZType RecvType) {
		return RecvType.GetAsciiName(); // FIXME
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.CurrentBuilder.Append(this.BaseName(Node.GetAstType(ZGetIndexNode._Recv)) + "GetIndex");
		this.CurrentBuilder.Append("(");
		this.GenerateCode(null, Node.AST[ZGetIndexNode._Index]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.CurrentBuilder.Append(this.BaseName(Node.GetAstType(ZGetIndexNode._Recv)) + "SetIndex");
		this.CurrentBuilder.Append("(");
		this.GenerateCode(null, Node.AST[ZSetIndexNode._Index]);
		this.CurrentBuilder.Append(this.Camma);
		this.GenerateCode(null, Node.AST[ZSetIndexNode._Expr]);
		this.CurrentBuilder.Append(")");
	}

	//	@Override public void VisitGetNameNode(ZGetNameNode Node) {
	//		this.CurrentBuilder.Append(this.SafeName(Node.VarName, Node.VarIndex));
	//	}
	//
	//	@Override public void VisitSetNameNode(ZSetNameNode Node) {
	//		this.CurrentBuilder.Append(this.SafeName(Node.VarName, Node.VarIndex));
	//		this.CurrentBuilder.AppendToken("=");
	//		this.GenerateCode(null, Node.AST[ZSetNameNode._Expr]);
	//	}
	//
	//	@Override public void VisitGetterNode(ZGetterNode Node) {
	//		this.GenerateSurroundCode(Node.AST[ZGetterNode._Recv]);
	//		this.CurrentBuilder.Append(".");
	//		this.CurrentBuilder.Append(Node.FieldName);
	//	}
	//
	//	@Override public void VisitSetterNode(ZSetterNode Node) {
	//		this.GenerateSurroundCode(Node.AST[ZSetterNode._Recv]);
	//		this.CurrentBuilder.Append(".");
	//		this.CurrentBuilder.Append(Node.FieldName);
	//		this.CurrentBuilder.AppendToken("=");
	//		this.GenerateCode(null, Node.AST[ZSetterNode._Expr]);
	//	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.GenerateSurroundCode(Node.AST[ZMethodCallNode._Recv]);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.MethodName);
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.GenerateCode(null, Node.AST[ZFuncCallNode._Func]);
		this.VisitListNode("(", Node, ")");
	}

	//	@Override public void VisitCastNode(ZCastNode Node) {
	//		this.CurrentBuilder.Append("(");
	//		this.VisitType(Node.Type);
	//		this.CurrentBuilder.Append(")");
	//		this.GenerateSurroundCode(Node.AST[ZCastNode._Expr]);
	//	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.GenerateCode(null, Node.AST[ZThrowNode._Expr]);
		this.CurrentBuilder.Append("longjump(1)"); // FIXME
		this.CurrentBuilder.AppendWhiteSpace();
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		//		this.CurrentBuilder.Append("try");
		//		this.GenerateCode(Node.AST[ZTryNode._Try]);
		//		if(Node.AST[ZTryNode._Catch] != null) {
		//			this.GenerateCode(Node.AST[ZTryNode._Catch]);
		//		}
		//		if (Node.AST[ZTryNode._Finally] != null) {
		//			this.CurrentBuilder.Append("finally");
		//			this.GenerateCode(Node.AST[ZTryNode._Finally]);
		//		}
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		//		this.CurrentBuilder.Append("catch (");
		//		this.CurrentBuilder.Append(Node.ExceptionName);
		//		this.VisitTypeAnnotation(Node.ExceptionType);
		//		this.CurrentBuilder.Append(")");
		//		this.GenerateCode(Node.AST[ZCatchNode._Block]);
	}

	private String ParamTypeName(ZType Type) {
		if(Type.IsArrayType()) {
			return "ArrayOf" + this.ParamTypeName(Type.GetParamType(0)) + "_";
		}
		if(Type.IsMapType()) {
			return "MapOf" + this.ParamTypeName(Type.GetParamType(0)) + "_";
		}
		if(Type.IsFuncType()) {
			@Var String s = "FuncOf";
			@Var int i = 0;
			while(i < Type.GetParamSize()) {
				s = s +  this.ParamTypeName(Type.GetParamType(i));
				i = i + 1;
			}
			return s + "_";
		}
		if(Type.IsIntType()) {
			return "Int";
		}
		if(Type.IsFloatType()) {
			return "Float";
		}
		if(Type.IsVoidType()) {
			return "Void";
		}
		if(Type.IsVarType()) {
			return "Var";
		}
		return Type.ShortName;
	}

	private String GetCTypeName(ZType Type) {
		@Var String TypeName = null;
		if(Type.IsArrayType() || Type.IsMapType()) {
			TypeName = this.ParamTypeName(Type) + " *";
		}
		if(Type instanceof ZClassType) {
			TypeName = this.NameClass(Type);
		}
		if(TypeName == null) {
			TypeName = this.GetNativeTypeName(Type);
		}
		return TypeName;
	}

	@Field private final ZenMap<String> FuncNameMap = new ZenMap<String>(null);

	String GetFuncTypeClass(ZFuncType FuncType) {
		@Var String ClassName = this.FuncNameMap.GetOrNull(FuncType.GetUniqueName());
		if(ClassName == null) {
			ClassName = this.ParamTypeName(FuncType);
			this.FuncNameMap.put(FuncType.GetUniqueName(), ClassName);

			this.CurrentBuilder = this.InsertNewSourceBuilder();
			this.CurrentBuilder.AppendLineFeedIndent();
			this.CurrentBuilder.AppendNewLine("class ", ClassName, " extends zen.deps.ZFunction");
			this.CurrentBuilder.OpenIndent(" {");

			this.CurrentBuilder.AppendNewLine("abstract ");
			this.GenerateTypeName(FuncType.GetReturnType());
			this.CurrentBuilder.Append(" Invoke(");
			@Var int i = 1;
			while(i < FuncType.GetParamSize()) {
				if(i > 1) {
					this.CurrentBuilder.Append(this.Camma);
				}
				this.GenerateTypeName(FuncType.GetReturnType());
				this.CurrentBuilder.Append(" x"+i);
				i = i + 1;
			}
			this.CurrentBuilder.Append(");");

			this.CurrentBuilder.AppendNewLine(ClassName, "(int TypeId, String Name)");
			this.CurrentBuilder.OpenIndent(" {");
			this.CurrentBuilder.AppendNewLine("super(TypeId, Name);");
			this.CurrentBuilder.CloseIndent("}");
			this.CurrentBuilder.CloseIndent("}");
			this.CurrentBuilder.AppendLineFeedIndent();
			this.CurrentBuilder = this.CurrentBuilder.Pop();
		}
		return ClassName;
	}

	@Override protected void GenerateTypeName(ZType Type) {
		if(Type instanceof ZFuncType) {
			this.CurrentBuilder.Append(this.GetFuncTypeClass((ZFuncType)Type));
		}
		else {
			this.CurrentBuilder.Append(this.GetCTypeName(Type.GetRealType()));
		}
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.CurrentBuilder.AppendNewLine("");
		this.GenerateTypeName(Node.DeclType);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(this.SafeName(Node.NativeName, Node.VarIndex));
		this.CurrentBuilder.AppendToken("=");
		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node);
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		if(Node.AST[ZLetNode._InitValue] instanceof ZErrorNode) {
			this.VisitErrorNode((ZErrorNode)Node.AST[ZLetNode._InitValue]);
			return;
		}
		this.CurrentBuilder.Append("static ");
		this.GenerateTypeName(Node.GetAstType(ZLetNode._InitValue));
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(Node.GlobalName);
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(null, Node.AST[ZLetNode._InitValue]);
		this.CurrentBuilder.Append(this.SemiColon);
		this.CurrentBuilder.AppendLineFeed();
		Node.GetNameSpace().SetLocalSymbol(Node.Symbol, Node.ToGlobalNameNode());
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.GenerateTypeName(Node.Type);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(this.SafeName(Node.Name, Node.ParamIndex));
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(!Node.Type.IsVoidType()) {
			if(Node.FuncName == null) {
				Node.FuncName = "f";
			}
			@Var String FuncName = Node.FuncName + this.GetUniqueNumber();
			this.CurrentBuilder = this.InsertNewSourceBuilder();
			FuncName = this.GenerateFunctionAsSymbolField(Node);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder = this.CurrentBuilder.Pop();
			this.CurrentBuilder.Append(FuncName);
		}
		else {
			this.GenerateFunctionAsSymbolField(Node);
			if(Node.IsExport) {
				if(Node.FuncName.equals("main")) {
					this.MainFuncNode = Node;
				}
				else {
					this.ExportFunctionList.add(Node);
				}
			}
			//@Var ZFuncType FuncType = Node.GetFuncType(null);
			//			if(this.IsMethod(Node.FuncName, FuncType)) {
			//				this.HeaderBuilder.Append("#define _" + this.NameMethod(FuncType.GetRecvType(), Node.FuncName));
			//				this.HeaderBuilder.AppendLineFeed();
			//			}
		}
	}


	public String NameFunctionClass(String FuncName, ZFuncType FuncType) {
		return "F" + FuncType.StringfySignature(FuncName);
	}

	private String GenerateFunctionAsSymbolField(ZFunctionNode Node) {
		@Var ZFuncType FuncType = Node.GetFuncType(null);
		@Var String ClassName = this.NameFunctionClass(Node.FuncName, FuncType);
		this.GenerateClass("final class", ClassName, FuncType);
		this.CurrentBuilder.OpenIndent(" {");
		this.CurrentBuilder.AppendNewLine("static ");
		this.GenerateTypeName(Node.ReturnType);
		this.CurrentBuilder.Append(" f");
		this.VisitListNode("(", Node, ")");
		this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);

		this.GenerateClassField("static ", FuncType, "function", "new " + ClassName + "();");
		this.CurrentBuilder.AppendNewLine(ClassName, "()");
		this.CurrentBuilder.OpenIndent(" {");

		this.CurrentBuilder.AppendNewLine("super(", ""+FuncType.TypeId);
		this.CurrentBuilder.Append(LibZen._QuoteString(Node.FuncName), ");");
		this.CurrentBuilder.CloseIndent("}");

		this.CurrentBuilder.AppendNewLine("");
		this.GenerateTypeName(Node.ReturnType);
		this.CurrentBuilder.Append(" Invoke");
		this.VisitListNode("(", Node, ")");
		this.CurrentBuilder.OpenIndent(" {");
		if(!FuncType.GetReturnType().IsVoidType()) {
			this.CurrentBuilder.AppendNewLine("return ", ClassName, ".f");
		}
		else {
			this.CurrentBuilder.AppendNewLine(ClassName, ".f");
		}
		this.GenerateWrapperCall("(", Node, ");");
		this.CurrentBuilder.CloseIndent("}");

		this.CurrentBuilder.CloseIndent("}");
		this.CurrentBuilder.AppendLineFeedIndent();
		return ClassName + ".function";
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.GenerateCode(null, Node.AST[ZInstanceOfNode._Left]);
		this.CurrentBuilder.Append(" instanceof ");
		this.GenerateTypeName(Node.TargetType);
	}


	private void GenerateClass(String Qualifier, String ClassName, ZType SuperType) {
		this.CurrentBuilder.AppendLineFeedIndent();
		this.CurrentBuilder.Append(Qualifier);
		this.CurrentBuilder.AppendWhiteSpace(ClassName, " extends ");
		if(SuperType.IsVarType()) {
			this.CurrentBuilder.Append("Object");
		}
		else {
			this.GenerateTypeName(SuperType);
		}
	}

	private void GenerateClassField(String Qualifier, ZType FieldType, String FieldName, String Value) {
		this.CurrentBuilder.AppendLineFeedIndent();
		this.CurrentBuilder.Append(Qualifier);
		this.GenerateTypeName(FieldType);
		this.CurrentBuilder.Append(" ", FieldName);
		if(Value != null) {
			this.CurrentBuilder.Append(" = ", Value);
		}
		this.CurrentBuilder.Append(this.SemiColon);
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		@Var ZType SuperType = Node.ClassType.GetSuperType();
		@Var String ClassName = this.NameClass(Node.ClassType);
		this.GenerateClass("", ClassName, SuperType);
		this.CurrentBuilder.OpenIndent(" {");
		@Var int i = 0;
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.GenerateClassField("", FieldNode.DeclType, FieldNode.FieldName, null);
			i = i + 1;
		}
		this.CurrentBuilder.AppendLineFeedIndent();

		i = 0;
		while(i < Node.ClassType.GetFieldSize()) {
			@Var ZClassField Field = Node.ClassType.GetFieldAt(i);
			if(Field.FieldType.IsFuncType()) {
				this.GenerateClassField("static", Field.FieldType, this.NameMethod(Node.ClassType, Field.FieldName), "null");
			}
			i = i + 1;
		}

		this.CurrentBuilder.OpenIndent(this.NameClass(Node.ClassType) + "() {");
		this.CurrentBuilder.AppendNewLine("super();");
		while (i < Node.GetListSize()) {
			@Var ZFieldNode FieldNode = Node.GetFieldNode(i);
			this.CurrentBuilder.AppendNewLine("this.", FieldNode.FieldName, "=");
			this.GenerateCode(null, FieldNode.AST[ZFieldNode._InitValue]);
			this.CurrentBuilder.Append(this.SemiColon);
			i = i + 1;
		}
		i = 0;
		while(i < Node.ClassType.GetFieldSize()) {
			@Var ZClassField Field = Node.ClassType.GetFieldAt(i);
			if(Field.FieldType.IsFuncType()) {
				this.CurrentBuilder.AppendNewLine("if(", this.NameMethod(Node.ClassType, Field.FieldName), " != null) ");
				this.CurrentBuilder.OpenIndent("{");
				this.CurrentBuilder.AppendNewLine("this.", Field.FieldName, "=");
				this.CurrentBuilder.Append(this.NameMethod(Node.ClassType, Field.FieldName), ";", this.LineFeed);
				this.CurrentBuilder.CloseIndent("}");
			}
			i = i + 1;
		}

		this.CurrentBuilder.CloseIndent("}"); /* end of constructor*/
		this.CurrentBuilder.CloseIndent("}");  /* end of class */
		this.CurrentBuilder.AppendLineFeed();
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		ZLogger._LogError(Node.SourceToken, Node.ErrorMessage);
		this.CurrentBuilder.Append("ThrowError(");
		this.CurrentBuilder.Append(LibZen._QuoteString(Node.ErrorMessage));
		this.CurrentBuilder.Append(")");
	}

	//	@Override public void VisitExtendedNode(ZNode Node) {
	//
	//	}


}
