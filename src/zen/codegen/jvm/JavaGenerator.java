package zen.codegen.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import zen.ast.ZBooleanNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZIntNode;
import zen.ast.ZListNode;
import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.ast.ZStringNode;
import zen.ast.ZTypeNode;
import zen.parser.ZGenerator;
import zen.parser.ZLangInfo;
import zen.parser.ZNameSpace;
import zen.parser.ZSourceContext;
import zen.parser.ZTokenContext;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypePool;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZArray;
import zen.util.ZMatchFunction;
import zen.util.ZTokenFunction;
import zen.util.ZenMap;

public abstract class JavaGenerator extends ZGenerator {
	private final ZenMap<ZNode> LazyNodeMap = new ZenMap<ZNode>(null);
	private final ZenMap<Class<?>> GeneratedClassMap = new ZenMap<Class<?>>(null);

	protected JavaGenerator(String TargetCode, String TargetVersion) {
		super(new ZLangInfo(TargetVersion, TargetCode));
		this.InitFuncClass();
		this.ImportLocalGrammar(this.RootNameSpace);
	}

	private void ImportLocalGrammar(ZNameSpace NameSpace) {
		NameSpace.DefineStatement("import", new JavaImportPattern());
		NameSpace.DefineExpression("$JavaClassPath$", new JavaClassPathPattern());
	}

	protected void LazyBuild(ZFunctionNode Node) {
		this.LazyNodeMap.put(Node.GetSignature(), Node);
	}

	protected void LazyBuild(String Signature) {
		ZNode Node = this.LazyNodeMap.GetOrNull(Signature);
		if(Node != null) {
			LibZen._PrintDebug("LazyBuilding: " + Signature);
			this.LazyNodeMap.remove(Signature);
			Node.Accept(this);
		}
	}

	@Override public boolean StartCodeGeneration(ZNode Node,  boolean IsInteractive) {
		Node.Accept(this);
		return true;
	}

	protected Object GetConstValue(ZNode Node) {
		if(Node instanceof ZNullNode) {
			return null;
		}
		if(Node instanceof ZBooleanNode) {
			return ((ZBooleanNode)Node).BooleanValue;
		}
		if(Node instanceof ZIntNode) {
			return ((ZIntNode)Node).IntValue;
		}
		if(Node instanceof ZFloatNode) {
			return ((ZFloatNode)Node).FloatValue;
		}
		if(Node instanceof ZStringNode) {
			return ((ZStringNode)Node).StringValue;
		}
		if(Node instanceof ZTypeNode) {
			return Node.Type;
		}
		return null;
	}

	public Class<?> GetJavaClass(ZType zType) {
		return JavaTypeTable.GetJavaClass(zType, Object.class);
	}

	@Override public ZType GetFieldType(ZType RecvType, String FieldName) {
		Class<?> NativeClass = this.GetJavaClass(RecvType);
		if(NativeClass != null) {
			try {
				java.lang.reflect.Field NativeField = NativeClass.getField(FieldName);
				if(Modifier.isPublic(NativeField.getModifiers())) {
					return JavaTypeTable.GetZenType(NativeField.getType());
				}
			} catch (SecurityException e) {
			} catch (NoSuchFieldException e) {
			}
			return ZType.VoidType;     // undefined
		}
		return ZType.VarType;     // undefined
	}

	@Override public ZType GetSetterType(ZType RecvType, String FieldName) {
		Class<?> NativeClass = this.GetJavaClass(RecvType);
		if(NativeClass != null) {
			try {
				java.lang.reflect.Field NativeField = NativeClass.getField(FieldName);
				if(Modifier.isPublic(NativeField.getModifiers()) && !Modifier.isFinal(NativeField.getModifiers())) {
					return JavaTypeTable.GetZenType(NativeField.getType());
				}
			} catch (SecurityException e) {
			} catch (NoSuchFieldException e) {
			}
			return ZType.VoidType;     // undefined
		}
		return ZType.VarType;     // undefined
	}

	private boolean MatchParam(Class<?>[] jParams, ZListNode ParamList) {
		if(jParams.length != ParamList.GetListSize()) {
			return false;
		}
		for(int j = 0; j < jParams.length; j++) {
			if(jParams[j] == Object.class) {
				continue; // accepting all types
			}
			@Var ZType jParamType = JavaTypeTable.GetZenType(jParams[j]);
			@Var ZType ParamType = ParamList.GetListAt(j).Type;
			if(jParamType == ParamType || jParamType.Accept(ParamList.GetListAt(j).Type)) {
				continue;
			}
			if(jParamType.IsFloatType() && ParamType.IsIntType()) {
				continue;
			}
			if(jParamType.IsIntType() && ParamType.IsFloatType()) {
				continue;
			}
			return false;
		}
		return true;
	}

	protected Constructor<?> GetConstructor(ZType RecvType, ZListNode ParamList) {
		Class<?> NativeClass = this.GetJavaClass(RecvType);
		if(NativeClass != null) {
			try {
				Constructor<?>[] Methods = NativeClass.getConstructors();
				for(int i = 0; i < Methods.length; i++) {
					@Var Constructor<?> jMethod = Methods[i];
					if(!Modifier.isPublic(jMethod.getModifiers())) {
						continue;
					}
					if(this.MatchParam(jMethod.getParameterTypes(), ParamList)) {
						return jMethod;
					}
				}
			} catch (SecurityException e) {
			}
		}
		return null;
	}

	protected Method GetMethod(ZType RecvType, String MethodName, ZListNode ParamList) {
		Class<?> NativeClass = this.GetJavaClass(RecvType);
		if(NativeClass != null) {
			try {
				Method[] Methods = NativeClass.getMethods();
				for(int i = 0; i < Methods.length; i++) {
					@Var Method jMethod = Methods[i];
					if(!MethodName.equals(jMethod.getName())) {
						continue;
					}
					if(!Modifier.isPublic(jMethod.getModifiers())) {
						continue;
					}
					if(this.MatchParam(jMethod.getParameterTypes(), ParamList)) {
						return jMethod;
					}
				}
			} catch (SecurityException e) {
			}
		}
		return null;
	}

	@Override public ZFuncType GetMethodFuncType(ZType RecvType, String MethodName, ZListNode ParamList) {
		if(MethodName == null) {
			Constructor<?> jMethod = this.GetConstructor(RecvType, ParamList);
			if(jMethod != null) {
				@Var Class<?>[] ParamTypes = jMethod.getParameterTypes();
				@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[ParamTypes.length + 2]);
				if (ParamTypes != null) {
					@Var int j = 0;
					while(j < LibZen._Size(ParamTypes)) {
						TypeList.add(JavaTypeTable.GetZenType(ParamTypes[j]));
						j = j + 1;
					}
				}
				TypeList.add(RecvType);
				return ZTypePool._LookupFuncType2(TypeList);
			}
		}
		else {
			Method jMethod = this.GetMethod(RecvType, MethodName, ParamList);
			if(jMethod != null) {
				return JavaTypeTable.ConvertToFuncType(jMethod);
			}
		}
		return null;
	}

	// generated class

	public static String NameFuncClass(ZFuncType FuncType) {
		return "ZFunc"+ FuncType.TypeId;
	}

	private void InitFuncClass() {
		ZFuncType FuncType = JavaTypeTable.FuncType(boolean.class, ZSourceContext.class);
		this.SetGeneratedClass(NameFuncClass(FuncType), ZTokenFunction.class);
		FuncType = JavaTypeTable.FuncType(ZNode.class, ZNode.class, ZTokenContext.class, ZNode.class);
		this.SetGeneratedClass(NameFuncClass(FuncType), ZMatchFunction.class);
	}

	protected final void SetGeneratedClass(String Key, Class<?> C) {
		this.GeneratedClassMap.put(Key, C);
	}

	protected final Class<?> GetGeneratedClass(String Key, Class<?> DefaultClass) {
		Class<?> C = this.GeneratedClassMap.GetOrNull(Key);
		if(C != null) {
			return C;
		}
		return DefaultClass;
	}

	public String NameFunctionClass(String FuncName, ZFuncType FuncType) {
		return "F" + FuncType.StringfySignature(FuncName);
	}

	public Class<?> GetDefinedFunctionClass(String FuncName, ZFuncType FuncType) {
		return this.GeneratedClassMap.GetOrNull(this.NameFunctionClass(FuncName, FuncType));
	}

	//	// generated method
	//
	//	protected  Method LoadDefinedFunc(String FuncName, ZFuncType FuncType) {
	//		return this.FuncMap.GetOrNull(FuncType.StringfySignature(FuncName));
	//	}
	//
	//	protected void SetStaticFuncMethod(String FuncName, Method jMethod) {
	//		//	this.Debug(FuncName + ", " + jMethod);
	//		this.FuncMap.put(FuncName, jMethod);
	//	}
	//
	//	public Method GetStaticFuncMethod(String FuncName) {
	//		Method jMethod = this.FuncMap.GetOrNull(FuncName);
	//		//	this.Debug(FuncName + ", " + jMethod);
	//		return jMethod;
	//	}
	//

	public void Debug(String Message) {
		LibZen._PrintDebug(Message);
	}

}
