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

import zen.ast.ZImportNode;
import zen.ast.ZListNode;
import zen.ast.ZNode;
import zen.deps.Field;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.type.ZFunc;
import zen.type.ZFuncType;
import zen.type.ZType;


public abstract class ZGenerator extends ZVisitor {
	@Field private String            GrammarInfo;
	@Field public final String       TargetCode;
	@Field public final String       TargetVersion;

	@Field public final ZNameSpace   RootNameSpace;
	@Field private int UniqueNumber = 0;
	@Field public String             OutputFile;
	@Field public ZLogger            Logger;
	@Field private final ZenMap<ZFunc>      DefinedFuncMap = new ZenMap<ZFunc>(null);

	@Field private boolean StoppedVisitor;

	protected ZGenerator(String TargetCode, String TargetVersion) {
		super();
		this.RootNameSpace = new ZNameSpace(this, null);
		this.GrammarInfo = "";
		this.TargetCode = TargetCode;
		this.TargetVersion = TargetVersion;

		this.OutputFile = null;
		this.Logger = new ZLogger();
		this.StoppedVisitor = false;
	}

	public abstract ZScriptEngine GetEngine();

	public void ImportLocalGrammar(ZNameSpace NameSpace) {
		// TODO Auto-generated method stub

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

	public String GetGrammarInfo() {
		return this.GrammarInfo.trim();
	}

	public void AppendGrammarInfo(String GrammarInfo) {
		this.GrammarInfo = this.GrammarInfo + GrammarInfo + " ";
	}

	public String GetTargetLangInfo() {
		return this.TargetCode + this.TargetVersion;
	}

	public abstract boolean StartCodeGeneration(ZNode Node, boolean AllowLazy, boolean IsInteractive);

	public ZImportNode CreateImportNode(ZNode ParentNode) {
		return new ZImportNode(ParentNode);
	}

	public ZType GetFieldType(ZType BaseType, String Name) {
		return ZType.VarType;     // undefined
	}

	public ZType GetSetterType(ZType BaseType, String Name) {
		return ZType.VarType;     // undefined
	}

	public ZFuncType GetConstructorFuncType(ZType ClassType, ZListNode List) {
		return null;     // undefined
	}

	public ZFuncType GetMethodFuncType(ZType RecvType, String MethodName, ZListNode List) {
		return null;     // undefined
	}

	public int GetUniqueNumber() {
		@Var int UniqueNumber = this.UniqueNumber;
		this.UniqueNumber = this.UniqueNumber + 1;
		return UniqueNumber;
	}

	public String NameGlobalSymbol(String Symbol) {
		return Symbol + "_Z" + this.GetUniqueNumber();
	}

	public ZNode SetGlobalValue(String GlobalName, Object Value) {
		return null;
	}

	public Object GetGlobalValue(String GlobalName) {
		return null;
	}

	//

	public final void SetDefinedFunc(ZFunc Func) {
		this.DefinedFuncMap.put(Func.GetSignature(), Func);
	}

	public final ZFunc GetDefinedFunc(String GlobalName) {
		return this.DefinedFuncMap.GetOrNull(GlobalName);
	}

	public final ZFunc GetDefinedFunc(String FuncName, ZFuncType FuncType) {
		return this.GetDefinedFunc(FuncType.StringfySignature(FuncName));
	}

	public final ZFunc GetDefinedFunc(String FuncName, ZType RecvType, int FuncParamSize) {
		return this.GetDefinedFunc(ZFunc._StringfySignature(FuncName, FuncParamSize, RecvType));
	}

	public String NameConverterFunc(ZType FromType, ZType ToType) {
		return FromType.GetUniqueName() + "T" + ToType.GetUniqueName();
	}

	public void SetConverterFunc(ZType FromType, ZType ToType, ZFunc Func) {
		this.DefinedFuncMap.put(this.NameConverterFunc(FromType, ToType), Func);
	}

	public ZFunc GetConverterFunc(ZType FromType, ZType ToType) {
		while(FromType != null) {
			ZFunc Func = this.DefinedFuncMap.GetOrNull(this.NameConverterFunc(FromType, ToType));
			if(Func != null) {
				return Func;
			}
			FromType = FromType.GetSuperType();
		}
		return null;
	}

	public ZFunc GetCoercionFunc(ZType FromType, ZType ToType) {
		while(FromType != null) {
			ZFunc Func = this.DefinedFuncMap.GetOrNull(this.NameConverterFunc(FromType, ToType));
			if(Func != null && Func.IsCoercionFunc()) {
				return Func;
			}
			FromType = FromType.GetSuperType();
		}
		return null;
	}



}
