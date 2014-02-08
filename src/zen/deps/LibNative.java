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

// LangBase is a language-dependent code used in Zen.java

package zen.deps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import zen.ast.ZNode;
import zen.codegen.jvm.JavaTypeTable;
import zen.lang.ZFunc;
import zen.lang.ZenEngine;
import zen.parser.ZGenerator;
import zen.parser.ZLogger;
import zen.parser.ZNameSpace;
import zen.parser.ZSourceContext;
import zen.parser.ZSourceGenerator;
import zen.parser.ZTokenContext;
import zen.parser.ZVisitor;
import zen.type.ZFuncType;
import zen.type.ZType;

public class LibNative {

	public final static void print(Object msg) {
		System.out.print(msg);
	}

	public final static void println(Object msg) {
		System.out.println(msg);
	}

	public final static String GetEnv(String Name) {
		return System.getenv(Name);
	}

	private final static String GetStackInfo(int depth) {
		String LineNumber = " ";
		Exception e =  new Exception();
		StackTraceElement[] Elements = e.getStackTrace();
		if(depth < Elements.length) {
			StackTraceElement elem = Elements[depth];
			LineNumber += elem;
		}
		return LineNumber;
	}

	public final static void FixMe(Exception e) {
		System.err.println("FIXME " + LibNative.GetStackInfo(3) + ": " + e);
		e.printStackTrace();
	}

	public final static void Debug(String msg) {
		LibNative.println("DEBUG " + LibNative.GetStackInfo(3) + ": " + msg);
	}

	public final static void Assert(boolean TestResult) {
		if (!TestResult) {
			assert TestResult;
			throw new RuntimeException("ASSERTION FAILED");
		}
	}

	public final static void Exit(int status, String Message) {
		System.err.println(Message);
		System.exit(1);
	}

	public final static String LoadTextFile(String FileName) {
		ZLogger.VerboseLog(ZLogger.VerboseFile, "loading " + FileName);
		InputStream Stream = LibZen.class.getResourceAsStream("/" + FileName);
		if (Stream == null) {
			File f = new File(LibZen.FormatFilePath(FileName));
			try {
				Stream = new FileInputStream(f);
			} catch (FileNotFoundException e) {
				return null;
			}
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(Stream));
		String buffer = "";
		try {
			int buflen = 4096;
			int readed = 0;
			char[] buf = new char[buflen];
			StringBuilder builder = new StringBuilder();
			while ((readed = reader.read(buf, 0, buflen)) >= 0) {
				builder.append(buf, 0, readed);
			}
			buffer = builder.toString();
		} catch (IOException e) {
			return null;
		}
		return buffer;
	}

	// HighLevel Library

	public final static boolean ImportGrammar(ZNameSpace NameSpace, String ClassName) {
		try {
			@Var Class<?> NativeClass =  Class.forName(ClassName);
			Method LoaderMethod = NativeClass.getMethod("ImportGrammar", ZNameSpace.class, Class.class);
			LoaderMethod.invoke(null, NameSpace, NativeClass);
			return true;
		} catch (Exception e) { // naming
			LibNative.FixMe(e);
		}
		return false;
	}

	public final static ZFunc LoadTokenFunc(Class<?> GrammarClass, String FuncName) {
		try {
			Method JavaMethod = GrammarClass.getMethod(FuncName, ZSourceContext.class);
			return LibNative.ConvertToNativeFunc(JavaMethod);
		} catch (NoSuchMethodException e) {
			LibNative.FixMe(e);
		}
		return null;
	}

	public final static ZFunc LoadMatchFunc(Class<?> GrammarClass, String FuncName) {
		try {
			Method JavaMethod = GrammarClass.getMethod(FuncName, ZNode.class, ZTokenContext.class, ZNode.class);
			return LibNative.ConvertToNativeFunc(JavaMethod);
		} catch (NoSuchMethodException e) {
			LibNative.FixMe(e);
		}
		return null;
	}

	public final static boolean ApplyTokenFunc(ZTokenFunction TokenFunc, ZSourceContext SourceContext) {
		return TokenFunc.Invoke(SourceContext);
	}

	public final static ZNode ApplyMatchFunc(ZMatchFunction MatchFunc, ZNode ParentNode, ZTokenContext TokenContext, ZNode LeftNode) {
		return MatchFunc.Invoke(ParentNode, TokenContext, LeftNode);
	}

	// Visitor Reflection
	public final static boolean IsSupportedNode(ZVisitor Visitor, ZNode Node) {
		try {
			Visitor.getClass().getMethod(Node.GetVisitName(), Node.getClass());
			return true;
		} catch (NoSuchMethodException e) {
			LibNative.FixMe(e);
		}
		return false;
	}

	public final static void DispatchVisitNode(ZVisitor Visitor, ZNode Node) {
		try {
			Method JavaMethod = Visitor.getClass().getMethod(Node.GetVisitName(), Node.getClass());
			JavaMethod.invoke(Visitor, Node);
		} catch (NoSuchMethodException e) {
			//System.err.println("Visitor:" + Visitor.getClass().getSimpleName() + " do not support for " + Node.getClass().getSimpleName());
			Visitor.VisitExtendedNode(Node);
		} catch (Exception e) {
			LibNative.FixMe(e);
		}
	}

	private final static ZenMap<Class<?>> GenMap = new ZenMap<Class<?>>(null);

	static {
		GenMap.put("python", zen.codegen.jython.PythonSourceGenerator.class);
		GenMap.put("javascript", zen.codegen.javascript.JavaScriptSourceGenerator.class);
		GenMap.put("ruby", zen.codegen.jruby.RubySourceGenerator.class);
		GenMap.put("clisp", zen.codegen.clisp.CommonLispSourceGenerator.class);
		//GenMap.put("c", zen.codegen.c.CSourceGenerator.class);
		GenMap.put("jvm", zen.codegen.jvm.AsmGenerator.class);
		GenMap.put("llvm", zen.codegen.llvm.LLVMSourceGenerator.class);
	}

	public final static ZGenerator LoadGenerator(@Nullable String ClassName, String OutputFile) {
		if(ClassName == null) {
			ClassName = System.getenv("ZENCODE");
		}
		if (ClassName != null) {
			try {
				Class<?> GeneratorClass = GenMap.GetOrNull(ClassName);
				if(GeneratorClass == null) {
					GeneratorClass = Class.forName(ClassName);
				}
				return (ZGenerator) GeneratorClass.newInstance();
			} catch (Exception e) {
				LibNative.FixMe(e);
			}
		}
		return new ZSourceGenerator("zen", "0.1");
	}

	public final static ZenEngine LoadEngine(@Nullable String ClassName, String GrammarClass) {
		@Var ZGenerator Generator = LibNative.LoadGenerator(ClassName, null);
		LibNative.ImportGrammar(Generator.RootNameSpace, GrammarClass);
		Generator.ImportLocalGrammar(Generator.RootNameSpace);
		return Generator.GetEngine();
	}

	//
	public final static ZType GetNativeType(Class<?> NativeClass) {
		return JavaTypeTable.GetZenType(NativeClass);
	}

	public final static ZNativeFunc ConvertToNativeFunc(Method jMethod) {
		@Var ZFuncType FuncType = JavaTypeTable.ConvertToFuncType(jMethod);
		return new ZNativeFunc(0, jMethod.getName(), FuncType, jMethod);
	}



	// Type
	public final static String GetClassName(Object Value) {
		return Value.getClass().getSimpleName();
	}

	public final static Class<?> GetClassOfValue(Object Value) {
		return Value.getClass();
	}


	//	public final static ZType GetNativeType1(Class<?> NativeClass) {
	//		ZType NativeType = ZSystem.LookupTypeTable(NativeClass.getCanonicalName());
	//		if (NativeType == null) { /* create native type */
	//			// DebugP("** creating native class: " + NativeClass.getSimpleName()
	//			// + ", " + NativeClass.getCanonicalName());
	//			NativeType = new ZNativeType(NativeClass);
	//			ZSystem.SetTypeTable(NativeClass.getCanonicalName(), NativeType);
	//			ZLogger.VerboseLog(ZLogger.VerboseNative, "creating native class: " + NativeClass.getSimpleName() + ", " + NativeClass.getCanonicalName());
	//		}
	//		return NativeType;
	//	}

	public static <T> ZenArray<T> NewZenArray(Class<?> NativeClass) {
		ZType ElementType = LibNative.GetNativeType(NativeClass);
		return ZenArray.NewZenArray(ElementType);
	}

	//	private static boolean AcceptJavaType(ZType GreenType, Class<?> NativeType) {
	//		if (GreenType.IsVarType() /* || GreenType.IsTypeVariable() */) {
	//			return true;
	//		}
	//		if (GreenType.IsTopType()) {
	//			return (NativeType == Object.class);
	//		}
	//		@Var ZType JavaType = LibNative.GetNativeType(NativeType);
	//		if (GreenType != JavaType) {
	//			//			LibNative.DebugP("*** " + JavaType + ", " + GreenType
	//			//					+ ", equals? "
	//			//					+ (GreenType.GetBaseType() == JavaType.GetBaseType()));
	//			// if(GreenType.IsGenericType() && GreenType.HasTypeVariable()) {
	//			// return GreenType.BaseType == JavaType.BaseType;
	//			// }
	//			// if(JavaType.IsGenericType() && JavaType.HasTypeVariable()) {
	//			// return GreenType.BaseType == JavaType.BaseType;
	//			// }
	//			return false;
	//		}
	//		return true;
	//	}
	//
	//	private final static boolean MatchNativeMethod(ZType[] TypeParams, Method JavaMethod) {
	//		if (!LibNative.AcceptJavaType(TypeParams[0], JavaMethod.getReturnType())) {
	//			ZLogger.VerboseLog(ZLogger.DebugLevel, "return mismatched: " + TypeParams[0] + ", " + JavaMethod.getReturnType() + " of " + JavaMethod);
	//			return false;
	//		}
	//		@Var int StartIndex = 2;
	//		if (Modifier.isStatic(JavaMethod.getModifiers())) {
	//			StartIndex = 1;
	//		} else {
	//			if ((TypeParams.length == 1)
	//					|| !LibNative.AcceptJavaType(TypeParams[1],
	//							JavaMethod.getDeclaringClass())) {
	//				ZLogger.VerboseLog(ZLogger.DebugLevel, "recv mismatched: " + TypeParams[1]
	//						+ ", " + JavaMethod.getDeclaringClass() + " of "
	//						+ JavaMethod);
	//				return false;
	//			}
	//			StartIndex = 2;
	//		}
	//		@Var int ParamSize = TypeParams.length - StartIndex;
	//		@Var Class<?>[] ParamTypes = JavaMethod.getParameterTypes();
	//		if (ParamTypes != null) {
	//			if (ParamTypes.length != ParamSize) {
	//				ZLogger.VerboseLog(ZLogger.DebugLevel, "param.length mismatched: " + ParamSize
	//						+ " != " + ParamTypes.length + " of " + JavaMethod);
	//				return false;
	//			}
	//			for (int j = 0; j < ParamTypes.length; j++) {
	//				if (!LibNative.AcceptJavaType(TypeParams[StartIndex + j],
	//						ParamTypes[j])) {
	//					ZLogger.VerboseLog(ZLogger.DebugLevel, "param mismatched: "
	//							+ TypeParams[StartIndex + j] + " != "
	//							+ ParamTypes[j] + " at index " + j + " of "
	//							+ JavaMethod);
	//					return false;
	//				}
	//			}
	//			return true;
	//		}
	//		return (ParamSize == 0);
	//	}

	private final static Class<?> LoadClass(String ClassName) throws ClassNotFoundException {
		try {
			return Class.forName(ClassName);
		}
		catch (ClassNotFoundException e) {
		}
		return Class.forName(ClassName);
	}

	//	public final static Method ImportMethod(ZType[] TypeParams, String FullName, boolean StaticMethodOnly) {
	//		@Var Method FoundMethod = null;
	//		int Index = FullName.lastIndexOf(".");
	//		if(Index == -1) {
	//			return null;
	//		}
	//		try {
	//			@Var String FuncName = FullName.substring(Index+1);
	//			@Var Class<?> NativeClass = LibNative.LoadClass(FullName.substring(0, Index));
	//			Method[] Methods = NativeClass.getDeclaredMethods();
	//			assert(Methods != null);
	//			for(int i = 0; i < Methods.length; i++) {
	//				if(LibZen.EqualsString(FuncName, Methods[i].getName())) {
	//					if(!Modifier.isPublic(Methods[i].getModifiers())) {
	//						continue;
	//					}
	//					if(StaticMethodOnly && !Modifier.isStatic(Methods[i].getModifiers())) {
	//						continue;
	//					}
	//					if(!LibNative.MatchNativeMethod(TypeParams, Methods[i])) {
	//						continue;
	//					}
	//					if(FoundMethod != null) {
	//						ZLogger.VerboseLog(ZLogger.VerboseUndefined, "overloaded method: " + FullName);
	//						return FoundMethod; // return the first one
	//					}
	//					FoundMethod = Methods[i];
	//				}
	//			}
	//			if(FoundMethod == null) {
	//				ZLogger.VerboseLog(ZLogger.VerboseUndefined, "undefined method: " + FullName + " for " + TypeParams);
	//			}
	//		} catch (ClassNotFoundException e) {
	//			ZLogger.VerboseLog(ZLogger.VerboseException, e.toString());
	//		}
	//		return FoundMethod;
	//	}
	//
	// public static Object GetNativeFieldValue(Object ObjectValue, Field
	// NativeField) {
	// try {
	// Class<?> NativeType = NativeField.getType();
	// if((NativeType == long.class) || (NativeType == int.class) || (NativeType
	// == short.class) || (NativeType == byte.class)) {
	// return NativeField.getLong(ObjectValue);
	// }
	// if((NativeType == double.class) || (NativeType == float.class)) {
	// return NativeField.getDouble(ObjectValue);
	// }
	// if(NativeType == boolean.class) {
	// return NativeField.getBoolean(ObjectValue);
	// }
	// if(NativeType == char.class) {
	// return String.valueOf(NativeField.getChar(ObjectValue));
	// }
	// return NativeField.get(ObjectValue);
	// } catch (IllegalAccessException e) {
	// LibZen.VerboseException(e);
	// } catch (SecurityException e) {
	// LibZen.VerboseException(e);
	// }
	// return null;
	// }
	//
	// public static Object LoadStaticClassObject(Class<?> NativeClass, String
	// Symbol) {
	// try {
	// Field NativeField = NativeClass.getField(Symbol);
	// if(Modifier.isStatic(NativeField.getModifiers())) {
	// return LibNative.GetNativeFieldValue(null, NativeField);
	// }
	// } catch (NoSuchFieldException e) {
	// // LibZen.VerboseException(e);
	// }
	// ZenFuncSet FuncSet = new ZenFuncSet(null, null);
	// Method[] Methods = NativeClass.getMethods();
	// for(int i = 0; i < Methods.length; i++) {
	// if(Methods[i].getName().equals(Symbol) &&
	// Modifier.isStatic(Methods[i].getModifiers())) {
	// FuncSet.Append(LibNative.ConvertNativeMethodToFunc(Methods[i]), null);
	// }
	// }
	// if(FuncSet.FuncList.size() == 1) {
	// return FuncSet.FuncList.get(0);
	// }
	// else if(FuncSet.FuncList.size() != 0) {
	// return FuncSet;
	// }
	// return null;
	// }
	//
	// public static Object ImportStaticFieldValue(ZenType ClassType, String
	// Symbol) {
	// return LibNative.LoadStaticClassObject((Class<?>)ClassType.TypeBody,
	// Symbol);
	// }


	// public final static Object ImportNativeObject(ZenNameSpace NameSpace,
	// String PackageName) {
	// LibZen.VerboseLog(ZenUtils.VerboseNative, "importing " + PackageName);
	// try {
	// @Var Class<?> NativeClass = LibNative.LoadClass(PackageName);
	// try {
	// Method LoaderMethod = NativeClass.getMethod("ImportGrammar",
	// ZenNameSpace.class, Class.class);
	// LoaderMethod.invoke(null, NameSpace, NativeClass);
	// } catch (Exception e) { // naming
	// }
	// return LibNative.GetNativeType(NativeClass);
	// } catch (ClassNotFoundException e) {
	// }
	// int Index = PackageName.lastIndexOf(".");
	// if(Index == -1) {
	// return null;
	// }
	// try {
	// @Var Class<?> NativeClass =
	// LibNative.LoadClass(PackageName.substring(0, Index));
	// return LibNative.LoadStaticClassObject(NativeClass,
	// PackageName.substring(Index+1));
	// } catch (ClassNotFoundException e) {
	// }
	// return null;
	// }

	// public final static void LoadNativeConstructors(ZenSourceContext Context,
	// ZenType ClassType, ArrayList<ZenFunc> FuncList) {
	// @Var boolean TransformedResult = false;
	// Class<?> NativeClass = (Class<?>)ClassType.TypeBody;
	// // ZenSourceContext Context = ClassType.Context;
	// Constructor<?>[] Constructors = NativeClass.getDeclaredConstructors();
	// if(Constructors != null) {
	// for(int i = 0; i < Constructors.length; i++) {
	// if(!Modifier.isPublic(Constructors[i].getModifiers())) {
	// continue;
	// }
	// @Var ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
	// TypeList.add(ClassType);
	// @Var Class<?>[] ParamTypes = Constructors[i].getParameterTypes();
	// if(ParamTypes != null) {
	// for(int j = 0; j < ParamTypes.length; j++) {
	// TypeList.add(LibNative.GetNativeType(ParamTypes[j]));
	// }
	// }
	// ZenFunc Func = new ZenFunc(ZenConsts.ConstructorFunc,
	// ClassType.ShortName, 0, TypeList);
	// Func.SetNativeMethod(0, Constructors[i]);
	// Context.RootNameSpace.AppendConstructor(ClassType, Func, null);
	// FuncList.add(Func);
	// TransformedResult = true;
	// }
	// }
	// if(!TransformedResult) {
	// Context.RootNameSpace.SetUndefinedSymbol(ZenNameSpace.ClassSymbol(ClassType,
	// ZenNameSpace.ConstructorSymbol()), null);
	// }
	// }

	// public final static ZenFunc LoadNativeField(ZenSourceContext Context,
	// ZenType ClassType, String FieldName, boolean GetSetter) {
	// try {
	// Class<?> NativeClass = (Class<?>)ClassType.TypeBody;
	// Field NativeField = NativeClass.getField(FieldName);
	// if(Modifier.isPublic(NativeField.getModifiers())) {
	// ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
	// TypeList.add(LibNative.GetNativeType(NativeField.getType()));
	// TypeList.add(ClassType);
	// ZenFunc GetterNativeFunc = new ZenFunc(ZenConsts.GetterFunc,
	// FieldName, 0, TypeList);
	// GetterNativeFunc.SetNativeMethod(0, NativeField);
	// Context.RootNameSpace.SetGetterFunc(ClassType, FieldName,
	// GetterNativeFunc, null);
	// TypeList.clear();
	// TypeList.add(ZenSystem.VoidType);
	// TypeList.add(ClassType);
	// TypeList.add(LibNative.GetNativeType(NativeField.getType()));
	// ZenFunc SetterNativeFunc = new ZenFunc(ZenConsts.SetterFunc,
	// FieldName, 0, TypeList);
	// SetterNativeFunc.SetNativeMethod(0, NativeField);
	// Context.RootNameSpace.SetSetterFunc(ClassType, FieldName,
	// SetterNativeFunc, null);
	// return GetSetter ? SetterNativeFunc : GetterNativeFunc;
	// }
	// } catch (SecurityException e) {
	// LibZen.VerboseException(e);
	// } catch (NoSuchFieldException e) {
	// }
	// Context.RootNameSpace.SetUndefinedSymbol(ZenNameSpace.ClassSymbol(ClassType,
	// ZenNameSpace.GetterSymbol(FieldName)), null);
	// Context.RootNameSpace.SetUndefinedSymbol(ZenNameSpace.ClassSymbol(ClassType,
	// ZenNameSpace.SetterSymbol(FieldName)), null); // for setter
	// return null;
	// }

	// public final static void LoadNativeMethods(ZenSourceContext Context,
	// ZenType ClassType, String FuncName, ArrayList<ZenFunc> FuncList) {
	// Class<?> NativeClass = (Class<?>)ClassType.TypeBody;
	// Method[] Methods = NativeClass.getDeclaredMethods();
	// @Var boolean FoundMethod = false;
	// if(Methods != null) {
	// for(int i = 0; i < Methods.length; i++) {
	// if(LibZen.EqualsString(FuncName, Methods[i].getName())) {
	// if(!Modifier.isPublic(Methods[i].getModifiers())) {
	// continue;
	// }
	// ZenFunc NativeFunc = LibZen.ConvertNativeMethodToFunc(Methods[i]);
	// Context.RootNameSpace.AppendMethod(NativeFunc, null);
	// FuncList.add(NativeFunc);
	// FoundMethod = true;
	// }
	// }
	// }
	// if(!FoundMethod) {
	// Context.RootNameSpace.SetUndefinedSymbol(ZenNameSpace.ClassSymbol(ClassType,
	// FuncName), null);
	// }
	// }


	// LibZen KonohaApi



}
