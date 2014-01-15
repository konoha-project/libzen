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
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import zen.ast.ZenNode;
import zen.lang.ZenFunc;
import zen.lang.ZenSystem;
import zen.lang.ZenType;
import zen.parser.ZenGenerator;
import zen.parser.ZenLogger;
import zen.parser.ZenNameSpace;
import zen.parser.ZenSourceGenerator;
import zen.parser.ZenTokenContext;
import zen.parser.ZenVisitor;

public class LibNative {

	public final static String GetEnv(String Name) {
		return System.getenv(Name);
	}

	// Type
	public final static String GetClassName(Object Value) {
		return Value.getClass().getSimpleName();
	}

	public final static Class<?> GetClassOfValue(Object Value) {
		return Value.getClass();
	}

	public final static ZenType GetNativeType(Class<?> NativeClass) {
		ZenType NativeType = ZenSystem.LookupTypeTable(NativeClass.getCanonicalName());
		if (NativeType == null) { /* create native type */
			// DebugP("** creating native class: " + NativeClass.getSimpleName()
			// + ", " + NativeClass.getCanonicalName());
			NativeType = new ZenNativeType(NativeClass);
			ZenSystem.SetTypeTable(NativeClass.getCanonicalName(), NativeType);
			ZenLogger.VerboseLog(ZenLogger.VerboseNative,
					"creating native class: " + NativeClass.getSimpleName()
					+ ", " + NativeClass.getCanonicalName());
		}
		return NativeType;
	}

	private static boolean AcceptJavaType(ZenType GreenType, Class<?> NativeType) {
		if (GreenType.IsVarType() /* || GreenType.IsTypeVariable() */) {
			return true;
		}
		if (GreenType.IsTopType()) {
			return (NativeType == Object.class);
		}
		@Var ZenType JavaType = LibNative.GetNativeType(NativeType);
		if (GreenType != JavaType) {
			//			LibNative.DebugP("*** " + JavaType + ", " + GreenType
			//					+ ", equals? "
			//					+ (GreenType.GetBaseType() == JavaType.GetBaseType()));
			// if(GreenType.IsGenericType() && GreenType.HasTypeVariable()) {
			// return GreenType.BaseType == JavaType.BaseType;
			// }
			// if(JavaType.IsGenericType() && JavaType.HasTypeVariable()) {
			// return GreenType.BaseType == JavaType.BaseType;
			// }
			return false;
		}
		return true;
	}

	//	private final static boolean MatchNativeMethod(ZenType[] GreenTypeParams, Method JavaMethod) {
	//		if (!LibNative.AcceptJavaType(GreenTypeParams[0], JavaMethod.getReturnType())) {
	//			LibNative.DebugP("return mismatched: " + GreenTypeParams[0] + ", " + JavaMethod.getReturnType() + " of " + JavaMethod);
	//			return false;
	//		}
	//		@Var int StartIndex = 2;
	//		if (Modifier.isStatic(JavaMethod.getModifiers())) {
	//			StartIndex = 1;
	//		} else {
	//			if ((GreenTypeParams.length == 1)
	//					|| !LibNative.AcceptJavaType(GreenTypeParams[1],
	//							JavaMethod.getDeclaringClass())) {
	//				LibNative.DebugP("recv mismatched: " + GreenTypeParams[1]
	//						+ ", " + JavaMethod.getDeclaringClass() + " of "
	//						+ JavaMethod);
	//				return false;
	//			}
	//			StartIndex = 2;
	//		}
	//		@Var int ParamSize = GreenTypeParams.length - StartIndex;
	//		@Var Class<?>[] ParamTypes = JavaMethod.getParameterTypes();
	//		if (ParamTypes != null) {
	//			if (ParamTypes.length != ParamSize) {
	//				LibNative.DebugP("param.length mismatched: " + ParamSize
	//						+ " != " + ParamTypes.length + " of " + JavaMethod);
	//				return false;
	//			}
	//			for (int j = 0; j < ParamTypes.length; j++) {
	//				if (!LibNative.AcceptJavaType(GreenTypeParams[StartIndex + j],
	//						ParamTypes[j])) {
	//					LibNative.DebugP("param mismatched: "
	//							+ GreenTypeParams[StartIndex + j] + " != "
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

	// public final static Method ImportMethod(ZenType ContextType, String
	// FullName, boolean StaticMethodOnly) {
	// @Var Method FoundMethod = null;
	// int Index = FullName.lastIndexOf(".");
	// if(Index == -1) {
	// return null;
	// }
	// try {
	// @Var String FuncName = FullName.substring(Index+1);
	// @Var Class<?> NativeClass = LibNative.LoadClass(FullName.substring(0,
	// Index));
	// Method[] Methods = NativeClass.getDeclaredMethods();
	// assert(Methods != null);
	// for(int i = 0; i < Methods.length; i++) {
	// if(LibZen.EqualsString(FuncName, Methods[i].getName())) {
	// if(!Modifier.isPublic(Methods[i].getModifiers())) {
	// continue;
	// }
	// if(StaticMethodOnly && !Modifier.isStatic(Methods[i].getModifiers())) {
	// continue;
	// }
	// if(ContextType.IsFuncType() &&
	// !LibNative.MatchNativeMethod(ContextType.TypeParams, Methods[i])) {
	// continue;
	// }
	// if(FoundMethod != null) {
	// LibZen.VerboseLog(ZenUtils.VerboseUndefined, "overloaded method: " +
	// FullName);
	// return FoundMethod; // return the first one
	// }
	// FoundMethod = Methods[i];
	// }
	// }
	// if(FoundMethod == null) {
	// LibZen.VerboseLog(ZenUtils.VerboseUndefined, "undefined method: " +
	// FullName + " for " + ContextType);
	// }
	// } catch (ClassNotFoundException e) {
	// LibZen.VerboseLog(ZenUtils.VerboseException, e.toString());
	// }
	// return FoundMethod;
	// }
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

	public final static boolean ImportGrammar(ZenNameSpace NameSpace,
			String PackageName) {
		try {
			@Var Class<?> NativeClass = LibNative.LoadClass(PackageName);
			Method LoaderMethod = NativeClass.getMethod("ImportGrammar",
					ZenNameSpace.class, Class.class);
			LoaderMethod.invoke(null, NameSpace, NativeClass);
			return true;
		} catch (Exception e) { // naming
		}
		return false;
	}

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

	// public final static void LoadNativeConstructors(ZenParserContext Context,
	// ZenType ClassType, ArrayList<ZenFunc> FuncList) {
	// @Var boolean TransformedResult = false;
	// Class<?> NativeClass = (Class<?>)ClassType.TypeBody;
	// // ZenParserContext Context = ClassType.Context;
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

	// public final static ZenFunc LoadNativeField(ZenParserContext Context,
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

	// public final static void LoadNativeMethods(ZenParserContext Context,
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

	// // Method
	// public final static Object ApplyMethod(ZenFunc Func, Object Self,
	// Object[] Params) {
	// try {
	// // System.err.println("** debug: " + Func.FuncBody);
	// // System.err.println("** debug: " + Self + ", Params.length=" +
	// Params.length);
	// return ((Method)Func.FuncBody).invoke(Self, Params);
	// }
	// catch (InvocationTargetException e) {
	// LibZen.VerboseException(e);
	// }
	// catch (IllegalArgumentException e) {
	// LibZen.VerboseException(e);
	// }
	// catch (IllegalAccessException e) {
	// LibZen.VerboseException(e);
	// }
	// return null;
	// }

	public final static long ApplyTokenFunc(ZenFunc TokenFunc, Object TokenContext, String Text, long pos) {
		Object[] Argvs = new Object[3];
		Argvs[0] = TokenContext;
		Argvs[1] = Text;
		Argvs[2] = pos;
		return (Long) TokenFunc.Invoke(Argvs);
	}

	public final static ZenNode ApplyMatchFunc(ZenFunc MatchFunc, ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenNode LeftNode) {
		Object[] Argvs = new Object[3];
		Argvs[0] = NameSpace;
		Argvs[1] = TokenContext;
		Argvs[2] = LeftNode;
		return (ZenNode) MatchFunc.Invoke(Argvs);
	}

	public final static ZenFunc ConvertNativeMethodToFunc(Method JMethod) {
		@Var ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
		TypeList.add(LibNative.GetNativeType(JMethod.getReturnType()));
		if (!Modifier.isStatic(JMethod.getModifiers())) {
			TypeList.add(LibNative.GetNativeType(JMethod.getDeclaringClass()));
		}
		@Var Class<?>[] ParamTypes = JMethod.getParameterTypes();
		if (ParamTypes != null) {
			for (int j = 0; j < ParamTypes.length; j++) {
				TypeList.add(LibNative.GetNativeType(ParamTypes[j]));
			}
		}
		return new ZenNativeFunc(0, JMethod.getName(), ZenSystem.LookupFuncType(TypeList), null, JMethod);
	}

	public final static ZenFunc LoadTokenFunc(Class<?> GrammarClass,
			String FuncName) {
		try {
			Method JavaMethod = GrammarClass.getMethod(FuncName,
					ZenTokenContext.class, String.class, long.class);
			return LibNative.ConvertNativeMethodToFunc(JavaMethod);
		} catch (NoSuchMethodException e) {
			ZenLogger.VerboseException(e);
			LibNative.Exit(1, e.toString());
		}
		return null;
	}

	public final static ZenFunc LoadMatchFunc(Class<?> GrammarClass,
			String FuncName) {
		try {
			Method JavaMethod = GrammarClass.getMethod(FuncName,
					ZenNameSpace.class, ZenTokenContext.class, ZenNode.class);
			return LibNative.ConvertNativeMethodToFunc(JavaMethod);
		} catch (NoSuchMethodException e) {
			ZenLogger.VerboseException(e);
			LibNative.Exit(1, e.toString());
		}
		return null;
	}

	public final static boolean IsSupportedNode(ZenVisitor Visitor, ZenNode Node) {
		try {
			Visitor.getClass().getMethod(Node.GetVisitName(), Node.getClass());
			return true;
		} catch (NoSuchMethodException e) {
		}
		return false;
	}

	public final static void DispatchVisitNode(ZenVisitor Visitor, ZenNode Node) {
		try {
			Method JavaMethod = Visitor.getClass().getMethod(Node.GetVisitName(), Node.getClass());
			JavaMethod.invoke(Visitor, Node);
		} catch (Exception e) {
		}
		LibNative.println("unsupported syntax: " + Node.SourceToken.ParsedText
				+ " " + Node.getClass());
		// Visitor.ReportError(ZenConsts.ErrorLevel, Node.SourceToken,
		// "unsupported syntax: " + Node.SourceToken.ParsedText + " " +
		// Node.getClass());
	}

	// LibZen KonohaApi
	public final static void print(Object msg) {
		System.out.print(msg);
	}

	public final static void println(Object msg) {
		System.out.println(msg);
	}

	public final static void Assert(boolean TestResult) {
		if (!TestResult) {
			assert TestResult;
			LibNative.Exit(1, "Assertion Failed");
		}
	}

	public final static void Exit(int status, String Message) {
		System.err.println(Message);
		System.exit(1);
	}

	public final static String LoadScript(String FileName) {
		ZenLogger.VerboseLog(ZenLogger.VerboseFile, "loading " + FileName);
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



	private final static ZenMap<Class<?>> GenMap = new ZenMap<Class<?>>(null);
	static {
		GenMap.put("python", zen.codegen.jython.PythonSourceGenerator.class);
		GenMap.put("javascript", zen.codegen.javascript.JavaScriptSourceGenerator.class);
		GenMap.put("ruby", zen.codegen.jruby.RubySourceGenerator.class);
		GenMap.put("clisp", zen.codegen.clisp.CommonLispSourceGenerator.class);
	}

	public final static ZenGenerator LoadGenerator(@Nullable String ClassName, String OutputFile) {
		if(ClassName == null) {
			ClassName = System.getenv("ZENCODE");
		}
		if (ClassName != null) {
			try {
				Class<?> GeneratorClass = GenMap.GetOrNull(ClassName);
				if(GeneratorClass == null) {
					GeneratorClass = Class.forName(ClassName);
				}
				return (ZenGenerator) GeneratorClass.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ZenSourceGenerator("zen", "0.1");
	}

}
