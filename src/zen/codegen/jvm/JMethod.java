package zen.codegen.jvm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import zen.ast.ZBinaryNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZUnaryNode;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.lang.ZFuncSet;
import zen.lang.ZSystem;
import zen.lang.ZType;
import zen.parser.ZLogger;

public class JMethod {
	public Method Body;
	private final ZType ReturnType;
	private final ZType[] TypeParams;
	public JMethod(ZType ReturnType, String Name, ZType ThisType, String MethodName) {
		this.TypeParams = new ZType[1];
		this.TypeParams[0] = ThisType;
		this.ReturnType = ReturnType;
		this.Body = LibNative.ImportMethod(this.TypeParams, MethodName, true);
	}

	public JMethod(ZType ReturnType, String Name, ZType ThisType, ZType Arg1Type, String MethodName) {
		this.TypeParams = new ZType[2];
		this.TypeParams[0] = ThisType;
		this.TypeParams[1] = Arg1Type;
		this.ReturnType = ReturnType;
		this.Body = LibNative.ImportMethod(this.TypeParams, MethodName, true);
	}

	static {
		ImportMethod(ZSystem.IntType, "+", ZSystem.IntType, "IntApi.Plus");
		ImportMethod(ZSystem.IntType, "-", ZSystem.IntType, "IntApi.Minus");
		ImportMethod(ZSystem.IntType, "~", ZSystem.IntType, "IntApi.BitwiseNot");
		ImportMethod(ZSystem.IntType, "+", ZSystem.IntType, ZSystem.IntType, "IntApi.Add");
		ImportMethod(ZSystem.IntType, "-", ZSystem.IntType, ZSystem.IntType, "IntApi.Sub");
		ImportMethod(ZSystem.IntType, "*", ZSystem.IntType, ZSystem.IntType, "IntApi.Mul");
		ImportMethod(ZSystem.IntType, "/", ZSystem.IntType, ZSystem.IntType, "IntApi.Div");
		ImportMethod(ZSystem.IntType, "%", ZSystem.IntType, ZSystem.IntType, "IntApi.Mod");
		ImportMethod(ZSystem.IntType, "<<", ZSystem.IntType, ZSystem.IntType, "IntApi.LeftShift");
		ImportMethod(ZSystem.IntType, ">>", ZSystem.IntType, ZSystem.IntType, "IntApi.RightShift");
		ImportMethod(ZSystem.IntType, "^", ZSystem.IntType, ZSystem.IntType, "IntApi.BitwiseAnd");
		ImportMethod(ZSystem.IntType, "|", ZSystem.IntType, ZSystem.IntType, "IntApi.BitwiseOr");
		ImportMethod(ZSystem.IntType, "&", ZSystem.IntType, ZSystem.IntType, "IntApi.BitwiseXor");
		ImportMethod(ZSystem.BooleanType, "<", ZSystem.IntType,  ZSystem.IntType, "IntApi.LessThan");
		ImportMethod(ZSystem.BooleanType, "<=", ZSystem.IntType, ZSystem.IntType, "IntApi.LessThanEquals");
		ImportMethod(ZSystem.BooleanType, ">", ZSystem.IntType, ZSystem.IntType, "IntApi.GreaterThan");
		ImportMethod(ZSystem.BooleanType, ">=", ZSystem.IntType, ZSystem.IntType, "IntApi.GreaterThanEquals");
		ImportMethod(ZSystem.BooleanType, "==", ZSystem.IntType, ZSystem.IntType, "IntApi.Equals");
		ImportMethod(ZSystem.BooleanType, "!=", ZSystem.IntType, ZSystem.IntType, "IntApi.NotEquals");
	}

	static private final HashMap<String, HashMap<ZType[], JMethod>> MethodTable = new HashMap<String, HashMap<ZType[],JMethod>>();;

	private static void PutMethodTable(JMethod Method, String MethodName) {
		HashMap<ZType[], JMethod> Table = MethodTable.get(MethodName);
		if(Table == null) {
			Table = new HashMap<ZType[], JMethod>();
			MethodTable.put(MethodName, Table);
		}
		Table.put(Method.TypeParams, Method);
	}

	private static JMethod GetMethodFromMethodTable(String MethodName, ZType[] TypeParams) {
		HashMap<ZType[], JMethod> Table = MethodTable.get(MethodName);
		if(Table == null) {
			return null;
		}
		return Table.get(TypeParams);
	}

	private static void ImportMethod(ZType ReturnType, String MethodName, ZType ThisType, String ClassName) {
		JMethod Method = new JMethod(ReturnType, MethodName, ThisType, ClassName);
		PutMethodTable(Method, MethodName);
	}

	private static void ImportMethod(ZType ReturnType, String MethodName, ZType ThisType, ZType Arg1Type, String ClassName) {
		JMethod Method = new JMethod(ReturnType, MethodName, ThisType, Arg1Type, ClassName);
		PutMethodTable(Method, MethodName);
	}

	public ZType GetType(int Index) {
		return this.TypeParams[Index];
	}

	public ZType GetReturnType() {
		return this.ReturnType;
	}

	public static JMethod FindMethod(ZBinaryNode Node) {
		ZType[] TypeParams = new ZType[2];
		TypeParams[0] = Node.LeftNode.Type;
		TypeParams[1] = Node.RightNode.Type;
		return GetMethodFromMethodTable(Node.SourceToken.ParsedText, TypeParams);
	}

	public static JMethod FindMethod(ZUnaryNode Node) {
		ZType[] TypeParams = new ZType[1];
		TypeParams[0] = Node.RecvNode.Type;
		return GetMethodFromMethodTable(Node.SourceToken.ParsedText, TypeParams);
	}
	public static JMethod FindMethod(ZGetIndexNode Node) {
		ZType[] TypeParams = new ZType[2];
		TypeParams[0] = Node.RecvNode.Type;
		TypeParams[1] = Node.IndexNode.Type;
		return GetMethodFromMethodTable(Node.SourceToken.ParsedText, TypeParams);
	}

	public static JMethod FindMethod(ZSetIndexNode Node) {
		ZType[] TypeParams = new ZType[3];
		TypeParams[0] = Node.RecvNode.Type;
		TypeParams[1] = Node.IndexNode.Type;
		TypeParams[2] = Node.ValueNode.Type;
		return GetMethodFromMethodTable(Node.SourceToken.ParsedText, TypeParams);
	}


	public static String FormatTypeErrorMessage(ZFuncSet Set, String FuncType, ZType ClassType, String MethodName) {
		if(ClassType != null) {
			if(LibZen.EqualsString(MethodName, "")) {
				MethodName = ClassType.toString();
			}
			else {
				MethodName = MethodName + " of " + ClassType;
			}
		}
		if(Set.FuncList.size() == 0) {
			return "undefined " + FuncType + ": " + MethodName;
		}
		else {
			return "mismatched " + FuncType + "s: " + Set;
		}
	}

	//	public final static ZenArray NewArray(ZenType Type, Object[] InitSizes) {
	//		if(InitSizes.length == 1) {
	//			return ZenArray.NewArray1(Type.GetParamType(0), ((Number)InitSizes[0]).intValue());
	//		}
	//		else if(InitSizes.length == 2) {
	//			return ZenArray.NewArray2(Type.GetParamType(0).GetParamType(0), ((Number)InitSizes[0]).intValue(), ((Number)InitSizes[1]).intValue());
	//		}
	//		else {
	//			return ZenArray.NewArray3(Type.GetParamType(0).GetParamType(0).GetParamType(0), ((Number)InitSizes[0]).intValue(), ((Number)InitSizes[1]).intValue(), ((Number)InitSizes[2]).intValue());
	//		}
	//	}
	//
	//	public final static ZenArray NewNewArray(ZenType ArrayType, Object[] Values) {
	//		return ZenArray.NewNewArray(ArrayType, Values);
	//	}

	public final static Object ApplyMethod(JMethod Func, Object Self, Object[] Params) {
		try {
			// System.err.println("** debug: " + Func.FuncBody);
			// System.err.println("** debug: " + Self + ", Params.length=" + Params.length);
			return Func.Body.invoke(Self, Params);
		}
		catch (InvocationTargetException e) {
			ZLogger.VerboseException(e);
		}
		catch (IllegalArgumentException e) {
			ZLogger.VerboseException(e);
		}
		catch (IllegalAccessException e) {
			ZLogger.VerboseException(e);
		}
		return null;
	}

	public static Object InvokeFunc(JMethod Func, Object[] Params) {
		if(Func == null || Modifier.isAbstract(Func.Body.getModifiers())) {
			ZLogger.VerboseLog(ZLogger.VerboseRuntime, "applying abstract function: " + Func);
			return null; //Func.FuncType.GetReturnType().DefaultNullValue;
		}
		else if(Modifier.isStatic(Func.Body.getModifiers())) {
			@Var Object[] MethodArguments = new Object[Params.length-1];
			LibZen.ArrayCopy(Params, 1, MethodArguments, 0, MethodArguments.length);
			return JMethod.ApplyMethod(Func, Params[0], MethodArguments);
		}
		return JMethod.ApplyMethod(Func, null, Params);
	}

	//	public static Object InvokeOverridedMethod(long FileLine, ZenNameSpace NameSpace, ZenFunc Func, Object[] Arguments) {
	//		@Var ZenType ClassType = ZenSystem.GuessType(Arguments[0]);
	//		Func = NameSpace.GetOverridedMethod(ClassType, Func);
	//		return JMethod.InvokeFunc(Func, Arguments);
	//	}

	//	public static Object InvokeDynamicFunc(long FileLine, ZenType ContextType, ZenNameSpace NameSpace, String FuncName, Object[] Arguments) {
	//		@Var ZenFuncSet FuncSet = NameSpace.GetFuncSet(FuncName);
	//		@Var ZenFunc Func = FuncSet.GetMatchedFunc(NameSpace, Arguments);
	//		@Var Object Value = ContextType.DefaultNullValue;
	//		if(Func != null) {
	//			Value = JMethod.InvokeFunc(Func, Arguments);
	//			return JMethod.DynamicCast(ContextType, Value);
	//		}
	//		ZLogger.VerboseLog(ZLogger.VerboseRuntime, FormatTypeErrorMessage(FuncSet, "function", null, FuncName));
	//		return Value;
	//	}
	//
	//	public static final Object InvokeDynamicMethod(long FileLine, ZenType ContextType, ZenNameSpace NameSpace, String FuncName, Object[] Arguments) {
	//		@Var ZenType ClassType = ZenSystem.GuessType(Arguments[0]);
	//		@Var ZenFuncSet FuncSet = NameSpace.GetMethod(ClassType, FuncName, true);
	//		@Var ZenFunc Func = FuncSet.GetMatchedFunc(NameSpace, Arguments);
	//		@Var Object Value = ContextType.DefaultNullValue;
	//		if(Func != null) {
	//			Value = JMethod.InvokeFunc(Func, Arguments);
	//			return JMethod.DynamicCast(ContextType, Value);
	//		}
	//		ZLogger.VerboseLog(ZLogger.VerboseRuntime, FormatTypeErrorMessage(FuncSet, "method", ClassType, FuncName));
	//		return Value;
	//	}

	public static Object DynamicGetter(Object RecvObject, String FieldName) {
		try {
			Field JavaField = RecvObject.getClass().getField(FieldName);
			return JavaField.get(RecvObject);
		} catch (Exception e) {
			ZLogger.VerboseException(e);
		}
		return null;
	}

	public static Object DynamicSetter(Object RecvObject, String FieldName, Object Value) {
		try {
			Field JavaField = RecvObject.getClass().getField(FieldName);
			JavaField.set(RecvObject, Value);
			return JavaField.get(RecvObject);
		} catch (Exception e) {
			ZLogger.VerboseException(e);
		}
		return null;
	}

	public static Object DynamicCast(ZType CastType, Object Value) {
		if(Value != null) {
			ZType FromType = ZSystem.GuessType(Value);
			if(CastType == FromType || CastType.Accept(FromType)) {
				return Value;
			}
		}
		return null;
	}

	public static boolean DynamicInstanceOf(Object Value, ZType Type) {
		if(Value != null) {
			ZType ValueType = ZSystem.GuessType(Value);
			if(ValueType == Type || Type.Accept(ValueType)) {
				return true;
			}
		}
		return false;
	}

	//	public final static Object DynamicConvertTo(ZenType CastType, Object Value) {
	//		if(Value != null) {
	//			ZenType ValueType = ZenTypeSystem.GuessType(Value);
	//			if(ValueType == CastType || CastType.Accept(ValueType)) {
	//				return Value;
	//			}
	//			JMethod Func = ZenTypeSystem.GetConverterFunc(ValueType, CastType, true);
	//			if(Func != null) {
	//				Object[] Argvs = new Object[2];
	//				Argvs[0] = CastType;
	//				Argvs[1] = Value;
	//				return JMethod.ApplyMethod(Func, null, Argvs);
	//			}
	//		}
	//		return null;
	//	}

}