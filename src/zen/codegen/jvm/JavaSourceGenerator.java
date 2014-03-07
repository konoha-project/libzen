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
		this.IntLiteralSuffix="";
		this.TopType = "Object";
		this.SetNativeType(ZType.BooleanType, "boolean");
		this.SetNativeType(ZType.IntType, "int");  // for beautiful code
		this.SetNativeType(ZType.FloatType, "double");
		this.SetNativeType(ZType.StringType, "String");

		this.SetReservedName("this", "self");

		//this.HeaderBuilder.AppendNewLine("import zen.util.*;");
		this.CurrentBuilder.AppendNewLine("/* end of header */", this.LineFeed);
	}


	@Override public ZSourceEngine GetEngine() {
		return new ZSourceEngine(new ZenTypeSafer(this), this);
	}

	@Override protected void GenerateImportLibrary(String LibName) {
		this.HeaderBuilder.AppendNewLine("import ", LibName, this.SemiColon);
	}

	@Override @ZenMethod protected void Finish(String FileName) {
		if(FileName == null) {
			FileName = "ZenMain";
		}
		else {
			@Var int loc = FileName.lastIndexOf('/');
			if(loc != -1) {
				FileName = FileName.substring(loc+1);
			}
		}
		this.GenerateClass("public final", FileName, ZType.VarType);
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
			ZLogger._LogError(Node.SourceToken, "untyped error: " + Node);
			Node.Accept(this);
			this.CurrentBuilder.Append("/*untyped*/");
		}
		else {
			if(ContextType != null && Node.Type != ContextType && !ContextType.IsGreekType()) {
				this.CurrentBuilder.Append("(");
				this.GenerateTypeName(ContextType);
				this.CurrentBuilder.Append(")");
			}
			Node.Accept(this);
		}
	}

	@Override public void VisitGlobalNameNode(ZGlobalNameNode Node) {
		if(Node.IsStaticFuncName) {
			this.CurrentBuilder.Append(this.NameFunctionClass(Node.GlobalName, (ZFuncType)Node.Type), ".f");
		}
		else {
			if(Node.IsUntyped()) {
				ZLogger._LogError(Node.SourceToken, "undefined symbol: " + Node.GlobalName);
				this.CurrentBuilder.Append(this.NullLiteral,"/*"+Node.GlobalName+"*/");
			}
			else {
				this.CurrentBuilder.Append(Node.GlobalName);
			}
		}
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		if(Node.GetListSize() == 0) {
			this.CurrentBuilder.Append("new ", this.GetJavaTypeName(Node.Type, false), "()");
		}
		else {
			@Var ZType ParamType = Node.Type.GetParamType(0);
			this.ImportLibrary("java.util.Arrays");
			this.CurrentBuilder.Append("new ", this.GetJavaTypeName(Node.Type, false), "(");
			this.CurrentBuilder.Append("Arrays.asList(new ", this.GetJavaTypeName(ParamType, true), "[]");
			this.VisitListNode("{", Node, "}))");
		}
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

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		@Var ZType RecvType = Node.GetAstType(ZGetIndexNode._Recv);
		if(RecvType.IsStringType()) {
			this.GenerateCode(null, "String.valueOf((", Node.AST[ZGetIndexNode._Recv], ")");
			this.GenerateCode(null, ".charAt(", Node.AST[ZGetIndexNode._Index], "))");
		}
		else {
			this.GenerateCode(null, Node.AST[ZGetIndexNode._Recv]);
			this.GenerateCode(null, ".get(", Node.AST[ZGetIndexNode._Index], ")");
		}
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		@Var ZType RecvType = Node.GetAstType(ZGetIndexNode._Recv);
		this.GenerateCode(null, Node.AST[ZGetIndexNode._Recv]);
		if(RecvType.IsMapType()) {
			this.CurrentBuilder.Append(".put(");
		}
		else {
			this.CurrentBuilder.Append(".set(");
		}
		this.GenerateCode(null, Node.AST[ZSetIndexNode._Index]);
		this.CurrentBuilder.Append(this.Camma);
		this.GenerateCode(null, Node.AST[ZSetIndexNode._Expr]);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.GenerateSurroundCode(Node.AST[ZMethodCallNode._Recv]);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.MethodName);
		this.VisitListNode("(", Node, ")");
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		if(Node.IsStaticFuncCall()) {
			this.GenerateCode(null, Node.AST[ZFuncCallNode._Func]);
			this.VisitListNode("(", Node, ")");
		}
		else {
			this.GenerateCode(null, Node.AST[ZFuncCallNode._Func]);
			this.CurrentBuilder.Append(".Invoke");
			this.VisitListNode("(", Node, ")");
		}
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

	private String GetJavaTypeName(ZType Type, boolean Boxing) {
		if(Type.IsArrayType()) {
			this.ImportLibrary("java.util.ArrayList");
			return "ArrayList<" + this.GetJavaTypeName(Type.GetParamType(0), true) + ">";
		}
		if(Type.IsMapType()) {
			this.ImportLibrary("java.util.HashMap");
			return "HashMap<String," + this.GetJavaTypeName(Type.GetParamType(0), true) + ">";
		}
		if(Type instanceof ZFuncType) {
			return this.GetFuncTypeClass((ZFuncType)Type);
		}
		if(Type instanceof ZClassType) {
			return this.NameClass(Type);
		}
		if(Boxing) {
			if(Type.IsIntType()) {
				return "Integer";
			}
			if(Type.IsFloatType()) {
				return "Double";
			}
			if(Type.IsBooleanType()) {
				return "Boolean";
			}
		}
		return this.GetNativeTypeName(Type);
	}

	private String ParamFuncTypeName(ZType Type) {
		if(Type.IsArrayType()) {
			return "ArrayOf" + this.ParamFuncTypeName(Type.GetParamType(0)) + "_";
		}
		if(Type.IsMapType()) {
			return "MapOf" + this.ParamFuncTypeName(Type.GetParamType(0)) + "_";
		}
		if(Type.IsFuncType()) {
			@Var String s = "FuncOf";
			@Var int i = 0;
			while(i < Type.GetParamSize()) {
				s = s +  this.ParamFuncTypeName(Type.GetParamType(i));
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
		return Type.GetName();
	}

	@Field private final ZenMap<String> FuncNameMap = new ZenMap<String>(null);

	String GetFuncTypeClass(ZFuncType FuncType) {
		@Var String ClassName = this.FuncNameMap.GetOrNull(FuncType.GetUniqueName());
		if(ClassName == null) {
			ClassName = this.ParamFuncTypeName(FuncType);
			this.FuncNameMap.put(FuncType.GetUniqueName(), ClassName);

			this.CurrentBuilder = this.InsertNewSourceBuilder();
			this.CurrentBuilder.AppendNewLine("abstract class ", ClassName, "");
			this.CurrentBuilder.OpenIndent(" {");
			this.CurrentBuilder.AppendNewLine("abstract ");
			this.GenerateTypeName(FuncType.GetReturnType());
			this.CurrentBuilder.Append(" Invoke(");
			@Var int i = 0;
			while(i < FuncType.GetFuncParamSize()) {
				if(i > 0) {
					this.CurrentBuilder.Append(this.Camma);
				}
				this.GenerateTypeName(FuncType.GetFuncParamType(i));
				this.CurrentBuilder.Append(" x"+i);
				i = i + 1;
			}
			this.CurrentBuilder.Append(");");

			this.CurrentBuilder.AppendNewLine(ClassName, "(int TypeId, String Name)");
			this.CurrentBuilder.OpenIndent(" {");
			this.CurrentBuilder.AppendNewLine("//super(TypeId, Name);");
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
			this.CurrentBuilder.Append(this.GetJavaTypeName(Type.GetRealType(), false));
		}
	}

	@Override public void VisitVarNode(ZVarNode Node) {
		this.GenerateTypeName(Node.DeclType);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.NativeName, Node.VarIndex));
		this.CurrentBuilder.Append(" = ");
		this.GenerateCode(null, Node.AST[ZVarNode._InitValue]);
		this.CurrentBuilder.Append(this.SemiColon);
		this.VisitStmtList(Node);
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		if(Node.AST[ZLetNode._InitValue] instanceof ZErrorNode) {
			this.VisitErrorNode((ZErrorNode)Node.AST[ZLetNode._InitValue]);
			return;
		}
		if(!Node.IsConstValue()) {
			@Var String ClassName = "Symbol" + Node.GlobalName;
			this.CurrentBuilder = this.InsertNewSourceBuilder();
			this.CurrentBuilder.AppendNewLine("final class ", ClassName, "");
			this.CurrentBuilder.OpenIndent(" {");
			this.GenerateClassField("static", Node.GetAstType(ZLetNode._InitValue), "_", null);
			this.GenerateCode(null, " = ", Node.AST[ZLetNode._InitValue], this.SemiColon);
			this.CurrentBuilder.CloseIndent("}");
			this.CurrentBuilder = this.CurrentBuilder.Pop();
			Node.GlobalName = ClassName + "._";
			Node.GetNameSpace().SetLocalSymbol(Node.Symbol, Node.ToGlobalNameNode());
		}
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		this.GenerateTypeName(Node.Type);
		this.CurrentBuilder.Append(" ");
		this.CurrentBuilder.Append(this.NameLocalVariable(Node.Name, Node.ParamIndex));
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(!Node.Type.IsVoidType()) {
			if(Node.FuncName == null) {
				Node.FuncName = "f";
			}
			@Var String FuncName = Node.FuncName + this.GetUniqueNumber();
			this.CurrentBuilder = this.InsertNewSourceBuilder();
			FuncName = this.GenerateFunctionAsClass(Node);
			this.CurrentBuilder.AppendLineFeed();
			this.CurrentBuilder = this.CurrentBuilder.Pop();
			this.CurrentBuilder.Append(FuncName);
		}
		else {
			this.GenerateFunctionAsClass(Node);
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

	private String GenerateFunctionAsClass(ZFunctionNode Node) {
		@Var ZFuncType FuncType = Node.GetFuncType(null);
		@Var String ClassName = this.NameFunctionClass(Node.FuncName, FuncType);
		this.GenerateClass("final", ClassName, FuncType);
		this.CurrentBuilder.OpenIndent(" {");
		this.CurrentBuilder.AppendNewLine("static ");
		this.GenerateTypeName(Node.ReturnType);
		this.CurrentBuilder.Append(" f");
		this.VisitListNode("(", Node, ")");
		this.GenerateCode(null, Node.AST[ZFunctionNode._Block]);

		this.GenerateClassField("static ", FuncType, "function", "new " + ClassName + "();");
		this.CurrentBuilder.AppendNewLine(ClassName, "()");
		this.CurrentBuilder.OpenIndent(" {");

		this.CurrentBuilder.AppendNewLine("super(", ""+FuncType.TypeId, this.Camma);
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
		if(Qualifier != null && Qualifier.length() > 0) {
			this.CurrentBuilder.AppendNewLine(Qualifier);
			this.CurrentBuilder.AppendWhiteSpace("class ", ClassName, " extends ");
		}
		else {
			this.CurrentBuilder.AppendNewLine("class ", ClassName, " extends ");
		}
		if(SuperType.IsVarType()) {
			this.CurrentBuilder.Append("Object");
		}
		else {
			this.GenerateTypeName(SuperType);
		}
	}

	private void GenerateClassField(String Qualifier, ZType FieldType, String FieldName, String Value) {
		this.CurrentBuilder.AppendNewLine(Qualifier);
		this.CurrentBuilder.AppendWhiteSpace();
		this.GenerateTypeName(FieldType);
		this.CurrentBuilder.Append(" ", FieldName);
		if(Value != null) {
			this.CurrentBuilder.Append(" = ", Value);
			this.CurrentBuilder.Append(this.SemiColon);
		}
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

		this.CurrentBuilder.AppendNewLine(this.NameClass(Node.ClassType), "()");
		this.CurrentBuilder.OpenIndent(" {");
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
