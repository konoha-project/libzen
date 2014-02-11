package zen.codegen.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import zen.ast.ZConstNode;
import zen.ast.ZImportNode;
import zen.ast.ZListNode;
import zen.ast.ZNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.lang.ZenEngine;
import zen.lang.ZenTypeSafer;
import zen.parser.ZGenerator;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypePool;

public abstract class JavaSolution extends ZGenerator {
	private final ZenMap<Method> FuncMap = new ZenMap<Method>(null);

	protected JavaSolution(String TargetCode, String TargetVersion) {
		super(TargetCode, TargetVersion);
	}

	@Override public ZenEngine GetEngine() {
		return new JavaEngine(new ZenTypeSafer(this), this);
	}

	@Override public boolean StartCodeGeneration(ZNode Node,  boolean AllowLazy, boolean IsInteractive) {
		if (AllowLazy && Node.HasUntypedNode()) {
			return false;
		}
		Node.Accept(this);
		return true;
	}

	protected Object GetConstValue(ZNode Node) {
		if(Node instanceof ZConstNode) {
			return ((ZConstNode)Node).GetValue();
		}
		return null;
	}

	@Override public ZImportNode CreateImportNode(ZNode ParentNode) {
		return new JavaImportNode(ParentNode);
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
				@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
				TypeList.add(RecvType);
				@Var Class<?>[] ParamTypes = jMethod.getParameterTypes();
				if (ParamTypes != null) {
					@Var int j = 0;
					while(j < ParamTypes.length) {
						TypeList.add(JavaTypeTable.GetZenType(ParamTypes[j]));
						j = j + 1;
					}
				}
				return ZTypePool.LookupFuncType(TypeList);
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

	protected  Method LoadDefinedFunc(String FuncName, ZFuncType FuncType) {
		return this.FuncMap.GetOrNull(FuncType.StringfySignature(FuncName));
	}

	protected void SetStaticFuncMethod(String FuncName, Method jMethod) {
		//	this.Debug(FuncName + ", " + jMethod);
		this.FuncMap.put(FuncName, jMethod);
	}

	public Method GetStaticFuncMethod(String FuncName) {
		Method jMethod = this.FuncMap.GetOrNull(FuncName);
		//	this.Debug(FuncName + ", " + jMethod);
		return jMethod;
	}

	public void Debug(String Message) {
		LibZen._PrintDebug(Message);
	}

}
