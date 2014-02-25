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

import zen.ast.ZListNode;
import zen.ast.ZNode;
import zen.ast.ZSugarNode;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.deps.ZenMethod;
import zen.type.ZFunc;
import zen.type.ZFuncType;
import zen.type.ZPrototype;
import zen.type.ZType;

public abstract class ZGenerator extends ZVisitor {
	@Field private String            GrammarInfo;
	@Field public final String       LanguageExtention;
	@Field public final String       TargetVersion;

	@Field public final ZNameSpace   RootNameSpace;
	@Field private int UniqueNumber = 0;
	@Field public String             OutputFile;
	@Field public ZLogger            Logger;
	@Field private final ZenMap<ZFunc>      DefinedFuncMap = new ZenMap<ZFunc>(null);

	@Field private boolean StoppedVisitor;

	protected ZGenerator(String LanguageExtension, String TargetVersion) {
		super();
		this.RootNameSpace = new ZNameSpace(this, null);
		this.GrammarInfo = "";
		this.LanguageExtention = LanguageExtension;
		this.TargetVersion = TargetVersion;

		this.OutputFile = null;
		this.Logger = new ZLogger();
		this.StoppedVisitor = false;
	}

	public abstract ZSourceEngine GetEngine();

	@ZenMethod public void ImportLocalGrammar(ZNameSpace NameSpace) {
		// TODO Auto-generated method stub
	}

	@ZenMethod public void WriteTo(@Nullable String FileName) {
		// TODO Stub
	}

	@ZenMethod protected String NameOutputFile(String FileName) {
		if(FileName != null) {
			return FileName + "." + this.LanguageExtention;
		}
		return FileName;
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

	public final String GetGrammarInfo() {
		return this.GrammarInfo.trim();
	}

	public final void AppendGrammarInfo(String GrammarInfo) {
		this.GrammarInfo = this.GrammarInfo + GrammarInfo + " ";
	}

	public final String GetTargetLangInfo() {
		return this.LanguageExtention + this.TargetVersion;
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
		return ZType.FuncType;    // undefined and no error
	}

	@ZenMethod public ZFuncType GetMethodFuncType(ZType RecvType, String MethodName, ZListNode List) {
		//return null;              // undefined and undefined error
		return ZType.FuncType;     // undefined and no error
	}

	// Naming

	public final int GetUniqueNumber() {
		@Var int UniqueNumber = this.UniqueNumber;
		this.UniqueNumber = this.UniqueNumber + 1;
		return UniqueNumber;
	}

	public final String NameGlobalSymbol(String Symbol) {
		return Symbol + "_Z" + this.GetUniqueNumber();
	}

	public final String NameClass(ZType ClassType) {
		return ClassType.ShortName + "" + ClassType.TypeId;
	}

	//
	public final void SetDefinedFunc(ZFunc Func) {
		this.DefinedFuncMap.put(Func.GetSignature(), Func);
	}

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
			if(RecvType.IsVarType()) {
				break;
			}
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

	public final String NameConverterFunc(ZType FromType, ZType ToType) {
		return FromType.GetUniqueName() + "T" + ToType.GetUniqueName();
	}

	public final void SetConverterFunc(ZType FromType, ZType ToType, ZFunc Func) {
		this.DefinedFuncMap.put(this.NameConverterFunc(FromType, ToType), Func);
	}

	public final ZFunc LookupConverterFunc(ZType FromType, ZType ToType) {
		while(FromType != null) {
			@Var ZFunc Func = this.DefinedFuncMap.GetOrNull(this.NameConverterFunc(FromType, ToType));
			if(Func != null) {
				return Func;
			}
			FromType = FromType.GetSuperType();
		}
		return null;
	}

	public final ZFunc GetCoercionFunc(ZType FromType, ZType ToType) {
		while(FromType != null) {
			@Var ZFunc Func = this.DefinedFuncMap.GetOrNull(this.NameConverterFunc(FromType, ToType));
			if(Func != null && Func.IsCoercionFunc()) {
				return Func;
			}
			FromType = FromType.GetSuperType();
		}
		return null;
	}

	@Override public void VisitExtendedNode(ZNode Node) {
		@Var ZSugarNode DeNode = Node.DeSugar(this);
		DeNode.Accept(this);
	}

	@Override public void VisitSugarNode(ZSugarNode Node) {
		Node.AST[ZSugarNode._DeSugar].Accept(this);
	}
}
