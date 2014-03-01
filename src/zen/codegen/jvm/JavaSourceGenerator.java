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
import zen.deps.LibZen;
import zen.deps.Var;
import zen.lang.ZenTypeSafer;
import zen.parser.ZLogger;
import zen.parser.ZSourceEngine;
import zen.parser.ZSourceGenerator;
import zen.type.ZClassField;
import zen.type.ZClassType;
import zen.type.ZFuncType;
import zen.type.ZGenericType;
import zen.type.ZType;

public class JavaSourceGenerator extends ZSourceGenerator {

	public JavaSourceGenerator() {
		super("java", "1.6");

		this.TopType = "ZObject";
		this.SetNativeType(ZType.BooleanType, "boolean");
		//		this.SetNativeType(ZType.IntType, "long long int");
		this.SetNativeType(ZType.IntType, "long");
		this.SetNativeType(ZType.FloatType, "double");
		this.SetNativeType(ZType.StringType, "String");

		this.SetMacro("assert", "assert($[0])", ZType.VoidType, ZType.BooleanType, ZType.StringType);
		this.SetMacro("print", "System.out.print($[0])", ZType.VoidType, ZType.StringType);
		this.SetMacro("println", "System.out.println($[0]);", ZType.VoidType, ZType.StringType);

		// Converter
		this.SetConverterMacro("(double)($[0])", ZType.FloatType, ZType.IntType);
		this.SetConverterMacro("(long)($[0])", ZType.IntType, ZType.FloatType);
		this.SetConverterMacro("LibZen_BooleanToString($[0])", ZType.StringType, ZType.BooleanType);
		this.SetConverterMacro("LibZen_IntToString($[0])", ZType.StringType, ZType.IntType);
		this.SetConverterMacro("LibZen_FloatToString($[0])", ZType.StringType, ZType.FloatType);

		// String
		this.SetMacro("+", "LibZen_StrCat($[0], $[1])", ZType.StringType, ZType.StringType, ZType.StringType);
		this.SetMacro("size", "strlen($[0])", ZType.IntType, ZType.StringType);
		this.SetMacro("substring", "LibZen_SubString($[0], $[1])", ZType.StringType, ZType.StringType, ZType.IntType);
		this.SetMacro("substring", "LibZen_SubString2($[0], $[1], $[2])", ZType.StringType, ZType.StringType, ZType.IntType, ZType.IntType);
		this.SetMacro("indexOf", "LibZen_IndexOf($[0], $[1])", ZType.IntType, ZType.StringType, ZType.StringType);
		this.SetMacro("indexOf", "LibZen_IndexOf2($[0], $[1], $[2])", ZType.IntType, ZType.StringType, ZType.StringType, ZType.IntType);
		this.SetMacro("equals", "LibZen_EqualsString($[0], $[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);
		this.SetMacro("startsWith", "LibZen_StartsWith($[0], $[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);
		this.SetMacro("endsWith", "LibZen_EndWidth($[0], $[1])", ZType.BooleanType, ZType.StringType, ZType.StringType);

		// Array
		this.SetMacro("size", "LibZen_ArraySize($[0])", ZType.IntType, ZGenericType._ArrayType);
		this.SetMacro("clear", "LibZen_ArrayClear($[0], $[1])", ZType.VoidType, ZGenericType._ArrayType, ZType.IntType);
		this.SetMacro("add", "LibZen_ArrayAdd($[0], $[1])", ZType.VoidType, ZGenericType._ArrayType, ZType.VarType);
		this.SetMacro("add", "LibZen_ArrayAdd2($[0], $[1], $[2])", ZType.VoidType, ZGenericType._ArrayType, ZType.IntType, ZType.VarType);

		this.HeaderBuilder.Append("#include<stdio.h>\n");
		this.HeaderBuilder.Append("#include<stdlib.h>\n");
		this.HeaderBuilder.Append("#include<assert.h>\n", "\n");
	}


	@Override public ZSourceEngine GetEngine() {
		return new ZSourceEngine(new ZenTypeSafer(this), this);
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
			return "ArrayOf" + this.ParamTypeName(Type.GetParamType(0));
		}
		if(Type.IsMapType()) {
			return "MapOf" + this.ParamTypeName(Type.GetParamType(0));
		}
		if(Type.IsFuncType()) {
			@Var String s = "FuncOf" + this.ParamTypeName(Type.GetParamType(0))+"Of";
			@Var int i = 0;
			while(i < Type.GetParamSize()) {
				s = s +  this.ParamTypeName(Type.GetParamType(i));
				i = i + 1;
			}
			return s;
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
			TypeName = "struct " + this.NameClass(Type) + " *";
		}
		if(TypeName == null) {
			TypeName = this.GetNativeTypeName(Type);
		}
		return TypeName;
	}

	protected void GenerateFuncTypeName(ZType Type, String FuncName) {
		this.GenerateTypeName(Type.GetParamType(0));
		this.CurrentBuilder.Append(" (*" + FuncName + ")");
		@Var int i = 1;
		this.CurrentBuilder.Append("(");
		while(i < Type.GetParamSize()) {
			if(i > 1) {
				this.CurrentBuilder.Append(",");
			}
			this.GenerateTypeName(Type.GetParamType(i));
			i = i + 1;
		}
		this.CurrentBuilder.Append(")");
	}

	@Override protected void GenerateTypeName(ZType Type) {
		if(Type.IsFuncType()) {
			this.GenerateFuncTypeName(Type, "");
		}
		else {
			this.CurrentBuilder.Append(this.GetCTypeName(Type.GetRealType()));
		}
	}

	@Override public void VisitVarNode(ZVarNode Node) {
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
		if(Node.Type.IsFuncType()) {
			this.GenerateFuncTypeName(Node.Type, this.SafeName(Node.Name, Node.ParamIndex));
		}
		else {
			this.GenerateTypeName(Node.Type);
			this.CurrentBuilder.Append(" ");
			this.CurrentBuilder.Append(this.SafeName(Node.Name, Node.ParamIndex));
		}
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
			//@Var ZFuncType FuncType = Node.GetFuncType(null);
			//			if(Node.FuncName.equals("main")) {
			//				this.MainFuncNode = FuncNode;
			//			}
			//			if(Node.IsExport) {
			//				this.GenerateExportFunction(Node);
			//			}
			//			if(this.IsMethod(Node.FuncName, FuncType)) {
			//				this.HeaderBuilder.Append("#define _" + this.NameMethod(FuncType.GetRecvType(), Node.FuncName));
			//				this.HeaderBuilder.AppendLineFeed();
			//			}
		}
	}

	//	Class<?> LoadFuncClass(ZFuncType FuncType) {
	//		String ClassName = NameFuncClass(FuncType);
	//		Class<?> FuncClass = this.GetGeneratedClass(ClassName, null);
	//		if(FuncClass == null) {
	//			this.CurrentBuilder.Append("class ", ClassName, " extends zen.deps.ZFunction {");
	//			this.CurrentBuilder.Indent();
	//
	//
	//
	//			@Var String SuperClassName = Type.getInternalName(ZFunction.class);
	//
	//			@Var AsmClassBuilder ClassBuilder = this.AsmLoader.NewClass(ACC_PUBLIC| ACC_ABSTRACT, null, ClassName, ZFunction.class);
	//			AsmMethodBuilder InvokeMethod = ClassBuilder.NewMethod(ACC_PUBLIC | ACC_ABSTRACT, "Invoke", FuncType);
	//			InvokeMethod.Finish();
	//
	//			AsmMethodBuilder InitMethod = ClassBuilder.NewMethod(ACC_PUBLIC, "<init>", "(ILjava/lang/String;)V");
	//			InitMethod.visitVarInsn(ALOAD, 0);
	//			InitMethod.visitVarInsn(ILOAD, 1);
	//			InitMethod.visitVarInsn(ALOAD, 2);
	//			InitMethod.visitMethodInsn(INVOKESPECIAL, SuperClassName, "<init>", "(ILjava/lang/String;)V");
	//			InitMethod.visitInsn(RETURN);
	//			InitMethod.Finish();
	//
	//			FuncClass = this.AsmLoader.LoadGeneratedClass(ClassName);
	//			this.SetGeneratedClass(ClassName, FuncClass);
	//		}
	//		return FuncClass;
	//	}

	public String NameFunctionClass(String FuncName, ZFuncType FuncType) {
		return "F" + FuncType.StringfySignature(FuncName);
	}

	private String GenerateFunctionAsSymbolField(ZFunctionNode Node) {
		@Var ZFuncType FuncType = Node.GetFuncType(null);
		@Var String ClassName = this.NameFunctionClass(Node.FuncName, FuncType);
		this.GenerateClass("final class", ClassName, FuncType);
		this.CurrentBuilder.OpenIndent(" {");

		this.CurrentBuilder.AppendNewLine("final ");
		this.GenerateTypeName(Node.ReturnType);
		this.CurrentBuilder.Append(" Invoke");
		this.VisitListNode("(", Node, ")");
		this.CurrentBuilder.OpenIndent(" {");
		this.CurrentBuilder.Indent();
		if(FuncType.GetReturnType().IsVoidType()) {
			this.CurrentBuilder.Append("return ");
		}
		this.CurrentBuilder.Append(ClassName, ".f");
		this.GenerateWrapperCall("(", Node, ");");
		this.CurrentBuilder.CloseIndent("}");

		this.GenerateClassField("static ", FuncType, "function", "null");

		// static init
		this.CurrentBuilder.AppendNewLine("static");
		this.CurrentBuilder.OpenIndent(" {");
		this.CurrentBuilder.AppendNewLine("function = new ", ClassName, "();");
		this.CurrentBuilder.CloseIndent("}");

		this.CurrentBuilder.AppendLineFeedIndent();
		this.CurrentBuilder.AppendNewLine(ClassName, "()");
		this.CurrentBuilder.OpenIndent(" {");

		this.CurrentBuilder.AppendNewLine("super(", ""+FuncType.TypeId);
		this.CurrentBuilder.Append(LibZen._QuoteString(Node.FuncName), ");");
		this.CurrentBuilder.CloseIndent("}");

		this.CurrentBuilder.CloseIndent("}");

		this.CurrentBuilder.AppendNewLine("static ");
		this.GenerateTypeName(Node.ReturnType);
		this.CurrentBuilder.Append(" f");
		this.VisitListNode("(", Node, ")");
		this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);

		this.CurrentBuilder.CloseIndent("}");
		this.CurrentBuilder.AppendLineFeedIndent();
		return ClassName + ".function";
	}

	//	private void GenerateExportFunction(ZFunctionNode Node) {
	//		if(Node.FuncName.equals("main")) {
	//			this.CurrentBuilder.Append("int");
	//		}
	//		else {
	//			this.GenerateTypeName(Node.ReturnType);
	//		}
	//		this.CurrentBuilder.Append(" ", Node.FuncName);
	//		this.VisitListNode("(", Node, ")");
	//		this.CurrentBuilder.AppendLineFeed();
	//		this.CurrentBuilder.Append("{");
	//		this.CurrentBuilder.Indent();
	//		this.CurrentBuilder.AppendLineFeedIndent();
	//		if(!Node.ReturnType.IsVoidType()) {
	//			this.CurrentBuilder.Append("return ");
	//		}
	//		this.CurrentBuilder.Append(Node.GetSignature(this));
	//		this.VisitListNode("(", Node, ")");
	//		this.CurrentBuilder.Append(this.SemiColon);
	//		if(Node.FuncName.equals("main")) {
	//			this.CurrentBuilder.AppendLineFeed();
	//			this.CurrentBuilder.Append("return 0;");
	//		}
	//		this.CurrentBuilder.UnIndent();
	//		this.CurrentBuilder.AppendLineFeed();
	//		this.CurrentBuilder.Append("}");
	//		this.CurrentBuilder.AppendLineFeed();
	//		this.CurrentBuilder.AppendLineFeed();
	//	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.GenerateCode(null, Node.AST[ZInstanceOfNode._Left]);
		this.CurrentBuilder.Append(" instanceof ");
		this.GenerateTypeName(Node.TargetType);
	}

	private void GenerateClass(String Qualifier, String ClassName, ZType SuperType) {
		this.CurrentBuilder.AppendLineFeedIndent();
		this.CurrentBuilder.Append(Qualifier);
		this.CurrentBuilder.AppendWhiteSpace(ClassName, " extends ");
		this.GenerateTypeName(SuperType);
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
				this.CurrentBuilder.AppendLineFeedIndent();
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
