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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

import zen.ast.ZNode;
import zen.parser.ZLogger;
import zen.parser.ZSourceBuilder;
import zen.parser.ZUtils;
import zen.type.ZType;

public abstract class LibZen {
	public final static String GetPlatform() {
		return "Java JVM-" + System.getProperty("java.version");
	}

	public static boolean DebugMode = false;

	public final static String GetStackInfo(int depth) {
		String LineNumber = " ";
		Exception e =  new Exception();
		StackTraceElement[] Elements = e.getStackTrace();
		if(depth < Elements.length) {
			StackTraceElement elem = Elements[depth];
			LineNumber += elem;
		}
		return LineNumber;
	}

	public final static void DebugP(String msg) {
		//if(LibZen.DebugMode) {
		LibNative.println("DEBUG " + LibZen.GetStackInfo(2) + ": " + msg);
		//}
	}

	public final static boolean IsLetter(char ch) {
		return Character.isLetter(ch);
	}

	public final static boolean IsDigit(char ch) {
		return Character.isDigit(ch);
	}

	public final static boolean IsSymbol(char ch) {
		return Character.isLetter(ch) || ch == '_' || ch > 255;
	}




	public final static char CharAt(String Text, long Pos) {
		if(Pos < Text.length()) {
			return Text.charAt((int)Pos);
		}
		return 0;
	}

	public final static String SubString(String Text, long StartIdx, long EndIdx) {
		return Text.substring((int)StartIdx, (int)EndIdx);
	}

	public final static boolean IsWhitespace(String Text, long Pos) {
		char ch = LibZen.CharAt(Text, Pos);
		return Character.isWhitespace(ch);
	}

	public final static boolean IsLetter(String Text, long Pos) {
		char ch = LibZen.CharAt(Text, Pos);
		return Character.isLetter(ch);
	}

	public final static boolean IsDigit(String Text, long Pos) {
		char ch = LibZen.CharAt(Text, Pos);
		return Character.isDigit(ch);
	}

	public final static boolean IsVariableName(String Text, long Pos) {
		char ch = LibZen.CharAt(Text, Pos);
		return Character.isLetter(ch) || ch == '_' || ch > 255;
	}

	public final static int CheckBraceLevel(String Text) {
		@Var int level = 0;
		@Var int i = 0;
		while(i < Text.length()) {
			@Var char ch = Text.charAt(i);
			if(ch == '{' || ch == '[') {
				level = level + 1;
			}
			if(ch == '}' || ch == ']') {
				level = level - 1;
			}
			i = i + 1;
		}
		return level;
	}

	public final static String CharToString(char code) {
		return Character.toString(code);
	}

	public static final String UnquoteString(String Text) {
		StringBuilder sb = new StringBuilder();
		@Var char quote = LibZen.CharAt(Text, 0);
		@Var int i = 0;
		@Var int Length = Text.length();
		if(quote == '"' || quote == '\'') {
			i = 1;
			Length -= 1;
		}
		else {
			quote = '\0';
		}
		for(; i < Length; i += 1) {
			@Var char ch = LibZen.CharAt(Text, i);
			if(ch == '\\') {
				i = i + 1;
				char next = LibZen.CharAt(Text, i);
				switch (next) {
				case 't':
					ch = '\t';
					break;
				case 'n':
					ch = '\n';
					break;
				case '"':
					ch = '"';
					break;
				case '\'':
					ch = '\'';
					break;
				case '\\':
					ch = '\\';
					break;
				default:
					ch = next;
					break;
				}
				i = i + 1;
			}
			sb.append(ch);
		}
		return sb.toString();
	}

	public static final String QuoteString(String Text) {
		StringBuilder sb = new StringBuilder();
		sb.append('"');
		for(@Var int i = 0; i < Text.length(); i = i + 1) {
			@Var char ch = LibZen.CharAt(Text, i);
			if(ch == '\n') {
				sb.append("\\n");
			}
			else if(ch == '\t') {
				sb.append("\\t");
			}
			else if(ch == '"') {
				sb.append("\\\"");
			}
			else if(ch == '\\') {
				sb.append("\\\\");
			}
			else {
				sb.append(ch);
			}
		}
		sb.append('"');
		return sb.toString();
	}

	public final static String Stringify(Object Value) {
		if(Value == null) {
			return "null";
		}
		else if(Value instanceof String) {
			return LibZen.QuoteString(Value.toString());
		}
		else {
			return Value.toString();
		}
	}

	public final static String StringifyField(Object Value) {
		@Var String s = "{";
		Field[] Fields = Value.getClass().getFields();
		for(int i = 0; i < Fields.length; i++) {
			if(Modifier.isPublic(Fields[i].getModifiers())) {
				if(i > 0) {
					s += ", ";
				}
				try {
					s += Fields[i].getName() + ": ";
					s += LibZen.Stringify(Fields[i].get(Value));
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				}
			}
		}
		return s + "}";
	}

	public final static String AnotherName(String s) {
		@Var char ch = s.charAt(0);
		if(Character.isUpperCase(ch)) {
			ch = Character.toLowerCase(ch);
		}
		else {
			ch = Character.toLowerCase(ch);
		}
		return String.valueOf(ch) + s.substring(1);
	}

	public final static boolean EqualsString(String s, String s2) {
		return s.equals(s2);
	}


	public final static long ParseInt(String Text) {
		try {
			return Long.parseLong(Text);
		}
		catch(NumberFormatException e) {
			ZLogger.VerboseException(e);
		}
		return 0L;
	}

	public final static double ParseFloat(String Text) {
		try {
			return Double.parseDouble(Text);
		}
		catch(NumberFormatException e) {
			ZLogger.VerboseException(e);
		}
		return 0.0;
	}

	public final static void ArrayCopy(Object src, int srcPos, Object dest, int destPos, int length) {
		System.arraycopy(src, srcPos, dest, destPos, length);
	}

	//	public final static ZenFunc SetNativeMethod(ZenFunc NativeFunc, Method JavaMethod) {
	//		@Var int FuncFlag = ZenUtils.NativeFunc;
	//		if(!Modifier.isStatic(JavaMethod.getModifiers())) {
	//			FuncFlag |= ZenUtils.NativeMethodFunc;
	//		}
	//		NativeFunc.SetNativeMethod(FuncFlag, JavaMethod);
	//		return NativeFunc;
	//	}
	//

	//	public final static void LoadNativeConstructors(ZenSourceContext Context, ZenType ClassType, ArrayList<ZenFunc> FuncList) {
	//		LibNative.LoadNativeConstructors(Context, ClassType, FuncList);
	//	}
	//
	//	public final static ZenFunc LoadNativeField(ZenSourceContext Context, ZenType ClassType, String FieldName, boolean GetSetter) {
	//		return LibNative.LoadNativeField(Context, ClassType, FieldName, GetSetter);
	//	}
	//
	//	public final static void LoadNativeMethods(ZenSourceContext Context, ZenType ClassType, String FuncName, ArrayList<ZenFunc> FuncList) {
	//		LibNative.LoadNativeMethods(Context, ClassType, FuncName, FuncList);
	//	}

	//	public static Object NativeFieldGetter(Object ObjectValue, Field NativeField) {
	//		try {
	//			//			Class<?> NativeType = NativeField.getType();
	//			return NativeField.get(ObjectValue);
	//		} catch (IllegalAccessException e) {
	//			ZLogger.VerboseException(e);
	//		} catch (SecurityException e) {
	//			ZLogger.VerboseException(e);
	//		}
	//		return null;
	//	}
	//
	//	public static Object NativeFieldSetter(Object ObjectValue, Field NativeField, Object Value) {
	//		try {
	//			NativeField.set(ObjectValue, Value);
	//		} catch (IllegalAccessException e) {
	//			ZLogger.VerboseException(e);
	//		} catch (SecurityException e) {
	//			ZLogger.VerboseException(e);
	//		}
	//		return Value;
	//	}
	//
	//
	//	public final static Method LookupNativeMethod(Object Callee, String FuncName) {
	//		if(FuncName != null) {
	//			// LibZen.DebugP("looking up method : " + Callee.getClass().getSimpleName() + "." + FuncName);
	//			Method[] methods = Callee.getClass().getMethods();
	//			for(int i = 0; i < methods.length; i++) {
	//				if(FuncName.equals(methods[i].getName())) {
	//					return methods[i];
	//				}
	//			}
	//			ZLogger.VerboseLog(ZLogger.VerboseUndefined, "undefined method: " + Callee.getClass().getSimpleName() + "." + FuncName);
	//		}
	//		return null;
	//	}

	public final static int ListSize(ArrayList<?> List) {
		if(List == null) {
			return 0;
		}
		return List.size();
	}

	public final static ZType[] CompactTypeList(int BaseIndex, ArrayList<ZType> TypeList) {
		ZType[] Tuple = new ZType[TypeList.size() - BaseIndex];
		for(int i = BaseIndex; i < TypeList.size(); i++) {
			Tuple[i] = TypeList.get(i).GetRealType();
		}
		return Tuple;
	}

	public final static String[] CompactStringList(ArrayList<String> List) {
		if(List == null) {
			return null;
		}
		String[] Tuple = new String[List.size()];
		for(int i = 0; i < List.size(); i++) {
			Tuple[i] = List.get(i);
		}
		return Tuple;
	}

	public static void RetrieveMapKeys(ZenMap<?> Map, String Prefix, ArrayList<String> List) {
		@Var Iterator<String> itr = Map.key_iterator();
		@Var int i = 0;
		while(itr.hasNext()) {
			String Key = itr.next();
			if(Prefix != null && !Key.startsWith(Prefix)) {
				continue;
			}
			List.add(Key);
			i = i + 1;
		}
	}

	@Deprecated public final static void WriteCode(String OutputFile, String SourceCode) {
		if(OutputFile == null) {
			//LibZen.Eval(SourceCode);
		}
		if(OutputFile.equals("-")) {
			System.out.println(SourceCode);
			System.out.flush();
		}
		else {
			Writer out = null;
			try {
				out = new FileWriter(OutputFile);
				out.write(SourceCode);
				out.flush();
				out.close();
			} catch (IOException e) {
				System.err.println("Cannot write: " + OutputFile);
				System.exit(1);
			}
		}
	}

	public final static void WriteSource(String OutputFile, ArrayList<ZSourceBuilder> SourceList) {
		try {
			PrintStream Stream = null;
			if(OutputFile.equals("-")) {
				Stream = System.out;
				Stream.flush();
			}
			else {
				Stream = new PrintStream(OutputFile);
			}
			for(ZSourceBuilder Builder : SourceList) {
				for(String Source : Builder.SourceList) {
					Stream.print(Source);
				}
				Stream.println();
			}
			Stream.flush();
			if(Stream != System.out) {
				Stream.close();
			}
		} catch (IOException e) {
			System.err.println("Cannot write: " + OutputFile);
			System.exit(1);
		}
	}

	private static java.io.Console Console = null;
	private static java.io.BufferedReader Reader = null;
	private static boolean ConsoleInitialized = false;

	static private String ReadLine(String format, Object... args) {
		if(!ConsoleInitialized){
			Console = System.console();
			if (Console == null) {
				Reader = new BufferedReader(new InputStreamReader(System.in));
			}
			ConsoleInitialized = true;
		}
		if (Console != null) {
			return System.console().readLine(format, args);
		}
		System.out.print(String.format(format, args));
		try {
			return Reader.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public final static String ReadLine(String Prompt, String Prompt2) {
		String Line = LibZen.ReadLine(Prompt);
		if(Line == null) {
			System.exit(0);
		}
		if(Prompt2 != null) {
			int level = 0;
			while((level = LibZen.CheckBraceLevel(Line)) > 0) {
				String Line2 = LibZen.ReadLine(Prompt2 + ZUtils.JoinStrings("  ", level));
				Line += "\n" + Line2;
			}
			if(level < 0) {
				Line = "";
				LibNative.println(" .. canceled");
			}
		}
		return Line;
	}


	public final static boolean HasFile(String Path) {
		if(LibZen.class.getResource(Path) != null) {
			return true;
		}
		return new File(Path).exists();
	}

	public final static boolean IsSupportedTarget(String TargetCode) {
		return HasFile(GetLibPath(TargetCode, "common"));
	}

	public final static String GetLibPath(String TargetCode, String LibName) {
		return "lib/" + TargetCode + "/" + LibName + ".green";
	}

	final static String FormatFilePath(String FileName) {
		String Path = FileName;
		if(HasFile(Path)) {
			return Path;
		}
		String Home = System.getProperty("GREENTEA_HOME");
		if(Home != null) {
			Path = Home + FileName;
		}
		if(HasFile(Path)) {
			return Path;
		}
		return FileName;
	}

	public static long JoinIntId(int UpperId, int LowerId) {
		long id = UpperId;
		id = (id << 32) + LowerId;
		return id;
	}

	public static int UpperId(long FileLine) {
		return (int)(FileLine >> 32);
	}

	public static int LowerId(long FileLine) {
		return (int)FileLine;
	}

	public static boolean booleanValue(Object Value) {
		return ((Boolean)Value).booleanValue();
	}

	//	public static boolean ImportMethodToFunc(ZenFunc Func, String FullName) {
	//		Method JavaMethod = LibNative.ImportMethod(Func.GetFuncType(), FullName, false);
	//		if(JavaMethod != null) {
	//			LibZen.SetNativeMethod(Func, JavaMethod);
	//			if(Func.GetReturnType().IsVarType()) {
	//				Func.SetReturnType(LibNative.GetNativeType(JavaMethod.getReturnType()));
	//			}
	//			int StartIdx = Func.Is(ZenUtils.NativeMethodFunc) ? 2 : 1;
	//			Class<?>[] p = JavaMethod.getParameterTypes();
	//			for(int i = 0; i < p.length; i++) {
	//				if(Func.Types[StartIdx + i].IsVarType()) {
	//					Func.Types[StartIdx + i] = LibNative.GetNativeType(p[i]);
	//					Func.FuncType = null; // reset
	//				}
	//			}
	//			return true;
	//		}
	//		return false;
	//	}

	public static String StringfyObject(Object This) {
		@Var String s = "{";
		Field[] Fields = This.getClass().getFields();
		for(int i = 0; i < Fields.length; i++) {
			if(Modifier.isPublic(Fields[i].getModifiers())) {
				if(i > 0) {
					s += ", ";
				}
				try {
					Object Value =  Fields[i].get(This);
					if(!(Value instanceof ZNode)) {
						s += Fields[i].getName() + ": " + Fields[i].get(This);
					}
					else {
						s += Fields[i].getName() + ": ...";
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return s + "}";
	}

	public static void PrintStackTrace(Exception e, int linenum) {
		@Var StackTraceElement[] elements = e.getStackTrace();
		@Var int size = elements.length + 1;
		@Var StackTraceElement[] newElements = new StackTraceElement[size];
		for(@Var int i = 0; i < size; i++) {
			if(i == size - 1) {
				newElements[i] = new StackTraceElement("<TopLevel>", "TopLevelEval", "stdin", linenum);
				break;
			}
			newElements[i] = elements[i];
		}
		e.setStackTrace(newElements);
		e.printStackTrace();
	}

	public static String SourceBuilderToString(ZSourceBuilder Builder) {
		StringBuilder builder = new StringBuilder();
		for(String s : Builder.SourceList){
			builder.append(s);
		}
		return builder.toString();
	}
	//	public static Object EvalGetter(ZenType Type, Object Value, String FieldName) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

}
