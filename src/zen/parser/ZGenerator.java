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
package zen.parser;

import zen.ast.ZAsmMacroNode;
import zen.ast.ZAsmNode;
import zen.ast.ZBlockNode;
import zen.ast.ZClassNode;
import zen.ast.ZDefaultValueNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZLetNode;
import zen.ast.ZListNode;
import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.ast.ZStringNode;
import zen.ast.sugar.ZDesugarNode;
import zen.ast.sugar.ZSyntaxSugarNode;
import zen.ast.sugar.ZTopLevelNode;
import zen.type.ZFunc;
import zen.type.ZFuncType;
import zen.type.ZPrototype;
import zen.type.ZType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Nullable;
import zen.util.Var;
import zen.util.ZenMap;
import zen.util.ZenMethod;

public abstract class ZGenerator extends ZVisitor {
	@Field public ZenMap<String>        ImportedLibraryMap = new ZenMap<String>(null);
	@Field private final ZenMap<ZFunc>  DefinedFuncMap = new ZenMap<ZFunc>(null);

	@Field public final ZNameSpace      RootNameSpace;
	@Field public ZLogger               Logger;
	@Field public ZTypeChecker          TypeChecker;
	@Field public ZLangInfo             LangInfo;
	@Field protected String             TopLevelSymbol = null;
	@Field private int                  UniqueNumber = 0;
	@Field private boolean              StoppedVisitor;

	protected ZGenerator(ZLangInfo LangInfo) {
		this.RootNameSpace = new ZNameSpace(this, null);
		this.Logger        = new ZLogger();
		this.LangInfo      = LangInfo;
		this.TypeChecker   = null;
		this.StoppedVisitor = false;
	}

	public final void SetTypeChecker(ZTypeChecker TypeChecker) {
		this.TypeChecker = TypeChecker;
	}

	@Override public final void EnableVisitor() {
		this.StoppedVisitor = false;
	}

	@Override public final void StopVisitor() {
		this.StoppedVisitor = true;
	}

	@Override public final boolean IsVisitable() {
		return !this.StoppedVisitor;
	}

	@ZenMethod protected void GenerateImportLibrary(String LibName) {
		//	this.HeaderBuilder.AppendNewLine("require ", LibName, this.LineFeed);
	}

	public final void ImportLibrary(String LibName) {
		@Var String Imported = this.ImportedLibraryMap.GetOrNull(LibName);
		if(Imported == null) {
			this.GenerateImportLibrary(LibName);
			this.ImportedLibraryMap.put(LibName, LibName);
		}
	}

	public final void SetDefinedFunc(ZFunc Func) {
		this.DefinedFuncMap.put(Func.GetSignature(), Func);
	}

	public final void SetAsmMacro(ZNameSpace NameSpace, String Symbol, ZFuncType MacroType, String MacroText) {
		@Var ZMacroFunc MacroFunc = null;
		@Var int loc = MacroText.indexOf("~");
		if(loc > 0) {
			@Var String LibName = MacroText.substring(0, loc);
			MacroText = MacroText.substring(loc+1);
			MacroFunc = new ZMacroFunc(Symbol, MacroType, MacroText);
			MacroFunc.RequiredLibrary = LibName;
		}
		else {
			MacroFunc = new ZMacroFunc(Symbol, MacroType, MacroText);
		}
		if(Symbol.equals("_")) {
			this.SetConverterFunc(MacroType.GetRecvType(), MacroType.GetReturnType(), MacroFunc);
		}
		else {
			this.SetDefinedFunc(MacroFunc);
		}
	}

	private String NameConverterFunc(ZType FromType, ZType ToType) {
		return FromType.GetUniqueName() + "T" + ToType.GetUniqueName();
	}

	public final void SetConverterFunc(ZType FromType, ZType ToType, ZFunc Func) {
		//System.out.println("set " + this.NameConverterFunc(FromType, ToType));
		this.DefinedFuncMap.put(this.NameConverterFunc(FromType, ToType), Func);
	}

	public final ZFunc LookupConverterFunc(ZType FromType, ZType ToType) {
		while(FromType != null) {
			@Var ZFunc Func = this.DefinedFuncMap.GetOrNull(this.NameConverterFunc(FromType, ToType));
			//System.out.println("get " + this.NameConverterFunc(FromType, ToType) + ", func="+ Func);
			if(Func != null) {
				return Func;
			}
			FromType = FromType.GetSuperType();
		}
		return null;
	}

	public final void SetAsmSymbol(ZNameSpace NameSpace, ZAsmMacroNode Node) {
		@Var String MacroText = Node.GetMacroText();
		@Var int loc = MacroText.indexOf("~");
		if(loc > 0) {
			@Var String LibName = MacroText.substring(0, loc);
			this.ImportLibrary(LibName);
			Node.SetNode(ZAsmNode._Macro, new ZStringNode(Node, Node.GetAstToken(ZAsmMacroNode._Macro), MacroText.substring(loc+1)));
		}
		@Var ZAsmNode AsmNode = new ZAsmNode(null);
		AsmNode.SourceToken = Node.GetAstToken(ZAsmMacroNode._NameInfo);
		AsmNode.SetNode(ZAsmNode._Macro, Node.AST[ZAsmNode._Macro]);
		AsmNode.Type = Node.MacroType();
		NameSpace.SetLocalSymbol(Node.GetName(), AsmNode);
	}

	@ZenMethod public void WriteTo(@Nullable String FileName) {
		// TODO Stub
	}

	@ZenMethod public String GetSourceText() {
		return null;
	}

	public abstract boolean StartCodeGeneration(ZNode Node, boolean IsInteractive);

	@ZenMethod public ZType GetFieldType(ZType BaseType, String Name) {
		return ZType.VarType;     // undefined
	}

	@ZenMethod public ZType GetSetterType(ZType BaseType, String Name) {
		return ZType.VarType;     // undefined
	}

	@ZenMethod public ZFuncType GetConstructorFuncType(ZType ClassType, ZListNode List) {
		//return null;              // undefined and undefined error
		return ZFuncType._FuncType;    // undefined and no error
	}

	@ZenMethod public ZFuncType GetMethodFuncType(ZType RecvType, String MethodName, ZListNode List) {
		//return null;              // undefined and undefined error
		return ZFuncType._FuncType;     // undefined and no error
	}

	// Naming

	public final int GetUniqueNumber() {
		@Var int UniqueNumber = this.UniqueNumber;
		this.UniqueNumber = this.UniqueNumber + 1;
		return UniqueNumber;
	}

	public final String NameUniqueSymbol(String Symbol) {
		return Symbol + "Z" + this.GetUniqueNumber();
	}

	public final String NameClass(ZType ClassType) {
		return ClassType.ShortName + "" + ClassType.TypeId;
	}

	//

	public final ZPrototype SetPrototype(ZNode Node, String FuncName, ZFuncType FuncType) {
		@Var ZFunc Func = this.GetDefinedFunc(FuncName, FuncType);
		if(Func != null) {
			if(!FuncType.Equals(Func.GetFuncType())) {
				ZLogger._LogError(Node.SourceToken, "function has been defined diffrently: " + Func.GetFuncType());
				return null;
			}
			if(Func instanceof ZPrototype) {
				return (ZPrototype)Func;
			}
			ZLogger._LogError(Node.SourceToken, "function has been defined as macro" + Func);
			return null;
		}
		@Var ZPrototype	Proto= new ZPrototype(0, FuncName, FuncType, Node.SourceToken);
		this.DefinedFuncMap.put(Proto.GetSignature(), Proto);
		return Proto;
	}

	public final ZFunc GetDefinedFunc(String GlobalName) {
		@Var ZFunc Func = this.DefinedFuncMap.GetOrNull(GlobalName);
		if(Func == null && LibZen._IsLetter(LibZen._GetChar(GlobalName, 0))) {
			//			System.out.println("AnotherName = " + GlobalName + ", " + LibZen._AnotherName(GlobalName));
			Func = this.DefinedFuncMap.GetOrNull(LibZen._AnotherName(GlobalName));
		}
		//System.out.println("sinature="+GlobalName+", func="+Func);
		return Func;
	}

	public final ZFunc GetDefinedFunc(String FuncName, ZFuncType FuncType) {
		return this.GetDefinedFunc(FuncType.StringfySignature(FuncName));
	}

	public final ZFunc GetDefinedFunc(String FuncName, ZType RecvType, int FuncParamSize) {
		return this.GetDefinedFunc(ZFunc._StringfySignature(FuncName, FuncParamSize, RecvType));
	}

	public final ZFunc LookupFunc(String FuncName, ZType RecvType, int FuncParamSize) {
		@Var ZFunc Func = this.GetDefinedFunc(ZFunc._StringfySignature(FuncName, FuncParamSize, RecvType));
		while(Func == null) {
			RecvType = RecvType.GetSuperType();
			if(RecvType == null) {
				break;
			}
			Func = this.GetDefinedFunc(ZFunc._StringfySignature(FuncName, FuncParamSize, RecvType));
			//			if(RecvType.IsVarType()) {
			//				break;
			//			}
		}
		return Func;
	}

	public final ZMacroFunc GetMacroFunc(String FuncName, ZType RecvType, int FuncParamSize) {
		@Var ZFunc Func = this.GetDefinedFunc(ZFunc._StringfySignature(FuncName, FuncParamSize, RecvType));
		if(Func instanceof ZMacroFunc) {
			return ((ZMacroFunc)Func);
		}
		return null;
	}

	public final void VisitUndefinedNode(ZNode Node) {
		ZErrorNode ErrorNode = new ZErrorNode(Node.ParentNode, Node.SourceToken, "undefined node:" + Node.toString());
		this.VisitErrorNode(ErrorNode);
	}

	@Override public final void VisitDefaultValueNode(ZDefaultValueNode Node) {
		this.VisitNullNode(new ZNullNode(Node.ParentNode, null));
	}

	@Override public void VisitSyntaxSugarNode(ZSyntaxSugarNode Node) {
		@Var ZDesugarNode DeNode = Node.DeSugar(this);
		@Var int i = 0;
		while(i < DeNode.GetAstSize()) {
			DeNode.AST[i].Accept(this);  // FIXME
			i = i + 1;
		}
	}

	@ZenMethod protected void GenerateCode(ZType ContextType, ZNode Node) {
		Node.Accept(this);
	}

	@ZenMethod public void GenerateStatement(ZNode Node) {
		Node.Accept(this);
	}

	private boolean ExecStatement(ZNode Node, boolean IsInteractive) {
		//this.InteractiveContext = IsInteractive;
		this.EnableVisitor();
		this.TopLevelSymbol = null;
		if(Node instanceof ZTopLevelNode) {
			((ZTopLevelNode)Node).Perform(this.RootNameSpace);
		}
		else {
			if(this.TypeChecker != null) {
				Node = this.TypeChecker.CheckType(Node, ZType.VarType);
			}
			if(this.IsVisitable()) {
				if(Node instanceof ZFunctionNode || Node instanceof ZClassNode || Node instanceof ZLetNode) {
					Node.Type = ZType.VoidType;
					this.GenerateStatement(Node);
				}
				else {
					if(!this.LangInfo.AllowTopLevelScript) {
						@Var String FuncName = this.NameUniqueSymbol("Main");
						Node = this.TypeChecker.CreateFunctionNode(Node.ParentNode, FuncName, Node);
						this.TopLevelSymbol = FuncName;
					}
					this.GenerateStatement(Node);
				}
			}
		}
		return this.IsVisitable();
	}

	public String Perform() {
		if(this.TopLevelSymbol != null) {
			System.out.println("TODO: " + this.TopLevelSymbol);
		}
		return null;
	}


	public final boolean LoadScript(String ScriptText, String FileName, int LineNumber, boolean IsInteractive) {
		@Var boolean Result = true;
		@Var ZBlockNode TopBlockNode = new ZBlockNode(null, this.RootNameSpace);
		@Var ZTokenContext TokenContext = new ZTokenContext(this, this.RootNameSpace, FileName, LineNumber, ScriptText);
		TokenContext.SkipEmptyStatement();
		@Var ZToken SkipToken = TokenContext.GetToken();
		while(TokenContext.HasNext()) {
			TokenContext.SetParseFlag(ZTokenContext._NotAllowSkipIndent);
			TopBlockNode.ClearListAfter(0);
			SkipToken = TokenContext.GetToken();
			@Var ZNode StmtNode = TokenContext.ParsePattern(TopBlockNode, "$Statement$", ZTokenContext._Required);
			if(StmtNode.IsErrorNode()) {
				TokenContext.SkipError(SkipToken);
			}
			if(!this.ExecStatement(StmtNode, IsInteractive)) {
				Result = false;
				break;
			}
			TokenContext.SkipEmptyStatement();
			TokenContext.Vacume();
		}
		this.Logger.OutputErrorsToStdErr();
		return Result;
	}


	public final boolean LoadFile(String FileName, @Nullable ZToken SourceToken) {
		@Var String ScriptText = LibZen._LoadTextFile(FileName);
		if(ScriptText == null) {
			ZLogger._LogErrorExit(SourceToken, "file not found: " + FileName);
			return false;
		}
		return this.LoadScript(ScriptText, FileName, 1, false);
	}

	public final boolean RequireLibrary(String LibName, @Nullable ZToken SourceToken) {
		@Var String Key = "_Z" + LibName.toLowerCase();
		@Var String Value = this.ImportedLibraryMap.GetOrNull(Key);
		if(Value == null) {
			@Var String Path = this.LangInfo.GetLibPath(LibName);
			@Var String Script = LibZen._LoadTextFile(Path);
			if(Script == null) {
				ZLogger._LogErrorExit(SourceToken, "library not found: " + LibName + " as " + Path);
				return false;
			}
			@Var boolean Result = this.LoadScript(Script, Path, 1, false);
			this.ImportedLibraryMap.put(Key, Path);
			return Result;
		}
		return true;
	}

	@ZenMethod public void ExecMain() {
		this.Logger.OutputErrorsToStdErr();
	}


	//	public final String Translate(String ScriptText, String FileName, int LineNumber) {
	//		@Var ZBlockNode TopBlockNode = new ZBlockNode(this.Generator.RootNameSpace);
	//		@Var ZTokenContext TokenContext = new ZTokenContext(this.Generator, this.Generator.RootNameSpace, FileName, LineNumber, ScriptText);
	//		TokenContext.SkipEmptyStatement();
	//		@Var ZToken SkipToken = TokenContext.GetToken();
	//		while(TokenContext.HasNext()) {
	//			TokenContext.SetParseFlag(ZTokenContext._NotAllowSkipIndent);
	//			TopBlockNode.ClearListAfter(0);
	//			SkipToken = TokenContext.GetToken();
	//			@Var ZNode ParsedNode = TokenContext.ParsePattern(TopBlockNode, "$Statement$", ZTokenContext._Required);
	//			if(ParsedNode.IsErrorNode()) {
	//				TokenContext.SkipError(SkipToken);
	//			}
	//			this.Exec2(ParsedNode, false);
	//			TokenContext.SkipEmptyStatement();
	//			TokenContext.Vacume();
	//		}
	//		return this.Generator.GetSourceText();
	//	}



}
