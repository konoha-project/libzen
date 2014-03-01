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

//ifdef JAVA
package zen.main;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import zen.lang.ZenGrammar;
import zen.parser.ZEmptyValue;
import zen.parser.ZParserConst;
import zen.parser.ZSourceBuilder;
import zen.parser.ZSourceEngine;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZStringArray;

public class ZenMain {
	private static jline.ConsoleReader ConsoleReader = null;

	private final static String ReadLine2(String Prompt, String Prompt2) {
		if(ConsoleReader == null) {
			try {
				ConsoleReader = new jline.ConsoleReader();
				//ConsoleReader.setExpandEvents(false);
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		@Var String Line;
		try {
			Line = ConsoleReader.readLine(Prompt);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		if(Line == null) {
			System.exit(0);
		}
		if(Prompt2 != null) {
			@Var int level = 0;
			while((level = ZenMain.CheckBraceLevel(Line)) > 0) {
				String Line2;
				try {
					Line2 = ConsoleReader.readLine(Prompt2);
					//Line2 = ConsoleReader.readLine(Prompt2 + ZenUtils.JoinStrings("  ", level));
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
				Line += "\n" + Line2;
			}
			if(level < 0) {
				Line = "";
				LibZen._PrintLine(" .. canceled");
			}
		}
		ConsoleReader.getHistory().addToHistory(Line);
		return Line;
	}

	public final static void ExecCommand(String[] Args) {
		@Var String TargetCode = null; // self executable
		@Var String OneLiner = null;
		@Var String OutputFile = null; // stdout
		@Var int Index = 0;
		@Var boolean ShellMode = false;
		while (Index < Args.length) {
			@Var String Argu = Args[Index];
			if (!Argu.startsWith("-")) {
				break;
			}
			Index += 1;
			if ((Argu.equals("-e") || Argu.equals("--eval")) && (Index < Args.length)) {
				OneLiner = Args[Index];
				Index += 1;
				continue;
			}
			if ((Argu.equals("-o") || Argu.equals("--out")) && (Index < Args.length)) {
				if (!Args[Index].endsWith(".green")) { // for safety
					OutputFile = Args[Index];
					Index += 1;
					continue;
				}
			}
			if ((Argu.equals("-l") || Argu.equals("--lang")) && (Index < Args.length)) {
				if (!Args[Index].endsWith(".green")) { // for safety
					TargetCode = Args[Index];
					Index += 1;
					continue;
				}
			}
			if (Argu.equals("-i")) {
				ShellMode = true;
				continue;
			}
		}
		@Var ZSourceEngine ScriptEngine = LibZen._LoadEngine(TargetCode, ZenGrammar.class.getName());
		if (!(Index < Args.length)) {
			ShellMode = true;
		}
		@Var ZStringArray ARGV = new ZStringArray();
		while (Index < Args.length) {
			ARGV.Add(Args[Index]);
			Index += 1;
		}
		//ScriptEngine.SetSymbol("ARGV", ARGV, null);
		if (ARGV.Size() > 0) {
			@Var String FileName = ARGV.ArrayValues[0];
			@Var boolean Success = ScriptEngine.Load(FileName);
			if (!Success) {
				LibZen._Exit(1, "abort loading: " + FileName);
			}
		}
		if (ShellMode) {
			LibZen._PrintLine(ZParserConst.ProgName + ZParserConst.Version + " (" + ZParserConst.CodeName + ") on " + LibZen._GetPlatform());
			LibZen._PrintLine(ZParserConst.Copyright);
			LibZen._PrintLine("Accept: " + ScriptEngine.Generator.GetGrammarInfo());
			LibZen._PrintLine("Produce: " + ScriptEngine.Generator.GetTargetLangInfo());
			ScriptEngine.Generator.Logger.ShowErrors();
			@Var int linenum = 1;
			@Var String Line = null;
			while ((Line = ZenMain.ReadLine2(">>> ", "    ")) != null) {
				try {
					@Var Object EvaledValue = ScriptEngine.Eval(Line, "(stdin)", linenum, true);
					ScriptEngine.Generator.Logger.ShowErrors();
					if (!(EvaledValue instanceof ZEmptyValue)) {
						if(EvaledValue == null) {
							LibZen._PrintLine(" null");
						}
						else {
							LibZen._PrintLine(" (" +/* ZSystem.GuessType(EvaledValue) + ":" +*/ LibZen._GetClassName(EvaledValue) + ") " + LibZen._Stringify(EvaledValue));
						}
					}
					linenum = linenum + 1;
				} catch (Exception e) {
					ZenMain.PrintStackTrace(e, linenum);
					linenum = linenum + 1;
				}
			}
			LibZen._PrintLine("");
		}
		else {
			ScriptEngine.WriteTo(OutputFile);
			// Generator.FlushBuffer();
		}
	}

	public final static void Usage(String Message) {
		System.out.println("greentea usage :");
		System.out.println("  --lang|-l LANG        Set Target Language");
		System.out.println("      bash                Bash");
		System.out.println("      C C99               C99");
		System.out.println("      CSharp              CSharp");
		System.out.println("      java java7 java8    Java");
		System.out.println("      javascript js       JavaScript");
		System.out.println("      lua                 Lua");
		System.out.println("      haxe                Haxe");
		System.out.println("      ocaml               OCaml");
		System.out.println("      perl                Perl");
		System.out.println("      python              Python");
		System.out.println("      R                   R");
		System.out.println("      ruby                Ruby");
		System.out.println("      typescript ts       TypeScript");
		System.out.println("");
		System.out.println("  --out|-o  FILE        Output filename");
		System.out.println("  --eval|-e EXPR        Program passed in as string");
		System.out.println("  --require|-r LIBRARY     Load the library");
		System.out.println("  --verbose             Printing Debug infomation");
		System.out.println("     --verbose:token      adding token info");
		System.out.println("     --verbose:type       adding type info");
		System.out.println("     --verbose:symbol     adding symbol info");
		System.out.println("     --verbose:native     adding native class info");
		System.out.println("     --verbose:all        adding all info");
		System.out.println("     --verbose:no         no log");
		LibZen._Exit(0, Message);
	}

	public final static void main(String[] Args) {
		ZenMain.ExecCommand(Args);
	}



	public static void PrintStackTrace(Exception e, int linenum) {
		@Var StackTraceElement[] elements = e.getStackTrace();
		@Var int size = elements.length + 1;
		@Var StackTraceElement[] newElements = new StackTraceElement[size];
		@Var int i = 0;
		for(; i < size; i++) {
			if(i == size - 1) {
				newElements[i] = new StackTraceElement("<TopLevel>", "TopLevelEval", "stdin", linenum);
				break;
			}
			newElements[i] = elements[i];
		}
		e.setStackTrace(newElements);
		e.printStackTrace();
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



	private final static void WriteSource(String OutputFile, ArrayList<ZSourceBuilder> SourceList) {
		try {
			@Var PrintStream Stream = null;
			if(OutputFile.equals("-")) {
				Stream = System.out;
				Stream.flush();
			}
			else {
				Stream = new PrintStream(OutputFile);
			}
			for(ZSourceBuilder Builder : SourceList) {
				for(String Source : Builder.SourceList.ArrayValues) {
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

	private final static String ReadLine(String Prompt, String Prompt2) {
		@Var String Line = ReadLine(Prompt);
		if(Line == null) {
			System.exit(0);
		}
		if(Prompt2 != null) {
			@Var int level = 0;
			while((level = ZenMain.CheckBraceLevel(Line)) > 0) {
				@Var String Line2 = ReadLine(Prompt2 + LibZen._JoinStrings("  ", level));
				Line += "\n" + Line2;
			}
			if(level < 0) {
				Line = "";
				LibZen._PrintLine(" .. canceled");
			}
		}
		return Line;
	}




}
