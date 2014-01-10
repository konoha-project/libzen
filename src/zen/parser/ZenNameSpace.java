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
import java.util.ArrayList;

import zen.ast.ZenNode;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.ZenMap;
import zen.lang.ZenDefiningFunc;
import zen.lang.ZenFunc;
import zen.lang.ZenSystem;
import zen.lang.ZenType;
import zen.lang.ZenTypeCheckerImpl2;

final class ZenSymbolSource {
	/*field*/public ZenToken SourceToken;
	/*field*/public ZenType  Type; // nullable
	/*field*/public Object  Value;
}

public final class ZenNameSpace {
	/*field*/public final ZenNameSpace   ParentNameSpace;
	/*field*/public final ZenGenerator		    Generator;

	/*field*/ZenTokenFunc[] TokenMatrix;
	/*field*/ZenMap<Object>	 SymbolPatternTable;
	/*field*/private ZenDefiningFunc  DefiningFunc;

	public ZenNameSpace(ZenGenerator Generator, ZenNameSpace ParentNameSpace) {
		//		this.Context = Context;
		this.ParentNameSpace = ParentNameSpace;
		this.TokenMatrix = null;
		this.SymbolPatternTable = null;
		this.DefiningFunc = null;
		if(ParentNameSpace == null) {
			this.Generator = Generator;
			ZenSystem.InitNameSpace(this);
		}
		else {
			this.Generator = ParentNameSpace.Generator;
		}
	}

	public ZenNameSpace CreateSubNameSpace() {
		return new ZenNameSpace(null, this);
	}

	//	public final ZenNameSpace Minimum() {
	//		/*local*/ZenNameSpace NameSpace = this;
	//		while(NameSpace.SymbolPatternTable == null) {
	//			NameSpace = NameSpace.ParentNameSpace;
	//		}
	//		return NameSpace;
	//	}
	//
	//	public final ZenNameSpace GetNameSpace(int NameSpaceFlag) {
	//		if(ZenUtils.IsFlag(NameSpaceFlag, ZenParserConst.PublicNameSpace)) {
	//			return this.ParentNameSpace;
	//		}
	//		return this;
	//	}

	// TokenMatrix
	public final ZenTokenFunc GetTokenFunc(int ZenChar) {
		if(this.TokenMatrix == null) {
			return this.ParentNameSpace.GetTokenFunc(ZenChar);
		}
		return this.TokenMatrix[ZenChar];
	}

	private final ZenTokenFunc JoinParentFunc(ZenFunc Func, ZenTokenFunc Parent) {
		if(Parent != null && Parent.Func == Func) {
			return Parent;
		}
		return new ZenTokenFunc(Func, Parent);
	}

	public final void AppendTokenFunc(String keys, ZenFunc TokenFunc) {
		if(this.TokenMatrix == null) {
			this.TokenMatrix = new ZenTokenFunc[ZenParserConst.MaxSizeOfChars];
			if(this.ParentNameSpace != null) {
				for(/*local*/int i = 0; i < ZenParserConst.MaxSizeOfChars; i += 1) {
					this.TokenMatrix[i] = this.ParentNameSpace.GetTokenFunc(i);
				}
			}
		}
		for(/*local*/int i = 0; i < keys.length(); i += 1) {
			/*local*/int kchar = ZenUtils.AsciiToTokenMatrixIndex(LibZen.CharAt(keys, i));
			this.TokenMatrix[kchar] = this.JoinParentFunc(TokenFunc, this.TokenMatrix[kchar]);
		}
	}

	// SymbolTable
	public final Object GetLocalUndefinedSymbol(String Key) {
		if(this.SymbolPatternTable != null) {
			return this.SymbolPatternTable.GetOrNull(Key);
		}
		return null;
	}

	public final Object GetLocalSymbol(String Key) {
		if(this.SymbolPatternTable != null) {
			/*local*/Object Value = this.SymbolPatternTable.GetOrNull(Key);
			if(Value != null) {
				return Value == ZenParserConst.UndefinedSymbol ? null : Value;
			}
		}
		return null;
	}

	public final Object GetSymbol(String Key) {
		/*local*/ZenNameSpace NameSpace = this;
		while(NameSpace != null) {
			if(NameSpace.SymbolPatternTable != null) {
				/*local*/Object Value = NameSpace.SymbolPatternTable.GetOrNull(Key);
				if(Value != null) {
					return Value == ZenParserConst.UndefinedSymbol ? null : Value;
				}
			}
			NameSpace = NameSpace.ParentNameSpace;
		}
		return null;
	}

	public final boolean HasSymbol(String Key) {
		return (this.GetSymbol(Key) != null);
	}

	public final void SetSymbol(String Key, Object Value, ZenToken SourceToken) {
		if(this.SymbolPatternTable == null) {
			this.SymbolPatternTable = new ZenMap<Object>(null);
		}
		if(SourceToken != null) {
			/*local*/Object OldValue = this.SymbolPatternTable.GetOrNull(Key);
			if(OldValue != null && OldValue != ZenParserConst.UndefinedSymbol) {
				if(LibZen.DebugMode) {
					this.Generator.Logger.ReportWarning(SourceToken, "duplicated symbol: " + SourceToken + " old, new =" + OldValue + ", " + Value);
				}
				else {
					if(!LibZen.EqualsString(Key, "_")) {
						this.Generator.Logger.ReportWarning(SourceToken, "duplicated symbol: " + SourceToken);
					}
				}
			}
		}
		this.SymbolPatternTable.put(Key, Value);
		ZenLogger.VerboseLog(ZenLogger.VerboseSymbol, "symbol: " + Key + ", " + Value);
	}

	public final void SetUndefinedSymbol(String Symbol, ZenToken SourceToken) {
		this.SetSymbol(Symbol, ZenParserConst.UndefinedSymbol, SourceToken);
	}

	public final String GetSymbolText(String Key) {
		/*local*/Object Body = this.GetSymbol(Key);
		if(Body instanceof String) {
			return (/*cast*/String)Body;
		}
		return null;
	}

	public final ZenType GetSymbolType(String Symbol) {
		return ZenSystem.VarType;
	}

	// Pattern
	public ZenSyntaxPattern GetSyntaxPattern(String PatternName) {
		/*local*/Object Body = this.GetSymbol(PatternName);
		if(Body instanceof ZenSyntaxPattern) {
			return (/*cast*/ZenSyntaxPattern)Body;
		}
		return null;
	}

	public ZenSyntaxPattern GetExtendedSyntaxPattern(String PatternName) {
		/*local*/Object Body = this.GetSymbol(ZenNameSpace.SuffixPatternSymbol(PatternName));
		if(Body instanceof ZenSyntaxPattern) {
			return (/*cast*/ZenSyntaxPattern)Body;
		}
		return null;
	}

	private void AppendSyntaxPattern(String PatternName, ZenSyntaxPattern NewPattern, ZenToken SourceToken) {
		LibNative.Assert(NewPattern.ParentPattern == null);
		/*local*/ZenSyntaxPattern ParentPattern = this.GetSyntaxPattern(PatternName);
		NewPattern.ParentPattern = ParentPattern;
		this.SetSymbol(PatternName, NewPattern, SourceToken);
	}

	public void AppendSyntax(String PatternName, ZenFunc MatchFunc) {
		/*local*/int Alias = PatternName.indexOf(" ");
		/*local*/String Name = (Alias == -1) ? PatternName : PatternName.substring(0, Alias);
		/*local*/ZenSyntaxPattern Pattern = new ZenSyntaxPattern(this, Name, MatchFunc);
		this.AppendSyntaxPattern(Name, Pattern, null);
		if(Alias != -1) {
			this.AppendSyntax(PatternName.substring(Alias+1), MatchFunc);
		}
	}

	public void AppendSuffixSyntax(String PatternName, int SyntaxFlag, ZenFunc MatchFunc) {
		/*local*/int Alias = PatternName.indexOf(" ");
		/*local*/String Name = (Alias == -1) ? PatternName : PatternName.substring(0, Alias);
		/*local*/ZenSyntaxPattern Pattern = new ZenSyntaxPattern(this, Name, MatchFunc);
		Pattern.SyntaxFlag = SyntaxFlag;
		this.AppendSyntaxPattern(ZenNameSpace.SuffixPatternSymbol(Name), Pattern, null);
		if(Alias != -1) {
			this.AppendSuffixSyntax(PatternName.substring(Alias+1), SyntaxFlag, MatchFunc);
		}
	}

	public final ZenType GetType(String TypeName) {
		/*local*/Object TypeInfo = this.GetSymbol(TypeName);
		if(TypeInfo instanceof ZenType) {
			return (/*cast*/ZenType)TypeInfo;
		}
		return null;
	}

	public final ZenType AppendTypeName(ZenType Type, ZenToken SourceToken) {
		if(Type.GetBaseType() == Type) {
			this.SetSymbol(Type.ShortName, Type, SourceToken);
		}
		return Type;
	}

	// DefiningFunc

	public void SetDefiningFunc(ZenFunc Func) {
		this.DefiningFunc = new ZenDefiningFunc(Func.FuncFlag, Func.FuncName, Func.ZenType);
	}

	public ZenDefiningFunc GetDefiningFunc() {
		/*local*/ZenNameSpace NameSpace = this;
		while(NameSpace != null) {
			if(NameSpace.DefiningFunc != null) {
				return NameSpace.DefiningFunc;
			}
		}
		return null;
	}


	//	public final ZenType AppendTypeVariable(String Name, ZenType ParamBaseType, ZenToken SourceToken, ArrayList<Object> RevertList) {
	//		this.UpdateRevertList(Name, RevertList);
	//		/*local*/ZenType TypeVar = new ZenType(TypeVariable, Name, ParamBaseType, null);
	//		this.SetSymbol(Name, TypeVar, SourceToken);
	//		return TypeVar;
	//	}

	public final Object GetClassSymbol(ZenType ClassType, String Symbol, boolean RecursiveSearch) {
		while(ClassType != null) {
			/*local*/String Key = ZenNameSpace.ClassSymbol(ClassType, Symbol);
			/*local*/Object Value = this.GetSymbol(Key);
			if(Value != null) {
				return Value;
			}
			//			if(ClassType.IsDynamicNaitiveLoading() & this.Context.RootNameSpace.GetLocalUndefinedSymbol(Key) == null) {
			//				Value = LibZen.LoadNativeStaticFieldValue(ClassType, Symbol.substring(1));
			//				if(Value != null) {
			//					return Value;
			//				}
			//				//LibZen.LoadNativeMethods(ClassType, Symbol, FuncList);
			//			}
			if(!RecursiveSearch) {
				break;
			}
			ClassType = ClassType.GetSuperType();
		}
		return null;
	}

	//	public final Object GetClassStaticSymbol(ZenType StaticClassType, String Symbol, boolean RecursiveSearch) {
	//		/*local*/String Key = null;
	//		/*local*/ZenType ClassType = StaticClassType;
	//		while(ClassType != null) {
	//			Key = ZenNameSpace.ClassStaticSymbol(ClassType, Symbol);
	//			/*local*/Object Value = this.GetSymbol(Key);
	//			if(Value != null) {
	//				return Value;
	//			}
	//			if(!RecursiveSearch) {
	//				break;
	//			}
	//			ClassType = ClassType.SuperType;
	//		}
	//		Key = ZenNameSpace.ClassStaticSymbol(StaticClassType, Symbol);
	//		if(StaticClassType.IsDynamicNaitiveLoading() && this.Context.RootNameSpace.GetLocalUndefinedSymbol(Key) == null) {
	//			/*local*/Object Value = LibNative.ImportStaticFieldValue(this.Context, StaticClassType, Symbol);
	//			if(Value == null) {
	//				this.Context.RootNameSpace.SetUndefinedSymbol(Key, null);
	//			}
	//			else {
	//				this.Context.RootNameSpace.SetSymbol(Key, Value, null);
	//			}
	//			return Value;
	//		}
	//		return null;
	//	}

	//	public final void ImportClassSymbol(ZenNameSpace NameSpace, String Prefix, ZenType ClassType, ZenToken SourceToken) {
	//		/*local*/String ClassPrefix = ClassSymbol(ClassType, ClassStaticName(""));
	//		/*local*/ArrayList<String> KeyList = new ArrayList<String>();
	//		/*local*/ZenNameSpace ns = NameSpace;
	//		while(ns != null) {
	//			if(ns.SymbolPatternTable != null) {
	//				LibZen.RetrieveMapKeys(ns.SymbolPatternTable, ClassPrefix, KeyList);
	//			}
	//			ns = ns.ParentNameSpace;
	//		}
	//		for(/*local*/int i = 0; i < KeyList.size(); i = i + 1) {
	//			/*local*/String Key = KeyList.get(i);
	//			/*local*/Object Value = NameSpace.GetSymbol(Key);
	//			Key = Key.replace(ClassPrefix, Prefix);
	//			if(SourceToken != null) {
	//				SourceToken.ParsedText = Key;
	//			}
	//			this.SetSymbol(Key, Value, SourceToken);
	//		}
	//	}

	//	public final ZenFunc GetGetterFunc(ZenType ClassType, String Symbol, boolean RecursiveSearch) {
	//		/*local*/Object Func = this.Context.RootNameSpace.GetClassSymbol(ClassType, ZenNameSpace.GetterSymbol(Symbol), RecursiveSearch);
	//		if(Func instanceof ZenFunc) {
	//			return (/*cast*/ZenFunc)Func;
	//		}
	//		Func = this.Context.RootNameSpace.GetLocalUndefinedSymbol(ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.GetterSymbol(Symbol)));
	//		if(ClassType.IsDynamicNaitiveLoading() && Func == null) {
	//			return LibZen.LoadNativeField(this.Context, ClassType, Symbol, false);
	//		}
	//		return null;
	//	}
	//
	//	public final ZenFunc GetSetterFunc(ZenType ClassType, String Symbol, boolean RecursiveSearch) {
	//		/*local*/Object Func = this.Context.RootNameSpace.GetClassSymbol(ClassType, ZenNameSpace.SetterSymbol(Symbol), RecursiveSearch);
	//		if(Func instanceof ZenFunc) {
	//			return (/*cast*/ZenFunc)Func;
	//		}
	//		Func = this.Context.RootNameSpace.GetLocalUndefinedSymbol(ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.SetterSymbol(Symbol)));
	//		if(ClassType.IsDynamicNaitiveLoading() && Func == null) {
	//			return LibZen.LoadNativeField(this.Context, ClassType, Symbol, true);
	//		}
	//		return null;
	//	}
	//
	//	public final ZenFunc GetConverterFunc(ZenType FromType, ZenType ToType, boolean RecursiveSearch) {
	//		/*local*/Object Func = this.GetClassSymbol(FromType, ZenNameSpace.ConverterSymbol(ToType), RecursiveSearch);
	//		if(Func instanceof ZenFunc) {
	//			return (/*cast*/ZenFunc)Func;
	//		}
	//		return null;
	//	}
	//
	//	public final ZenPolyFunc GetMethod(ZenType ClassType, String Symbol, boolean RecursiveSearch) {
	//		/*local*/ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
	//		while(ClassType != null) {
	//			/*local*/String Key = ZenNameSpace.ClassSymbol(ClassType, Symbol);
	//			/*local*/Object RootValue = this.RetrieveFuncList(Key, FuncList);
	//			if(RootValue == null && ClassType.IsDynamicNaitiveLoading()) {
	//				if(LibZen.EqualsString(Symbol, ZenNameSpace.ConstructorSymbol())) {
	//					LibZen.LoadNativeConstructors(this.Context, ClassType, FuncList);
	//				}
	//				else {
	//					LibZen.LoadNativeMethods(this.Context, ClassType, Symbol, FuncList);
	//				}
	//			}
	//			if(!RecursiveSearch) {
	//				break;
	//			}
	//			//System.err.println("** " + ClassType + ", " + ClassType.ParentMethodSearch);
	//			ClassType = ClassType.ParentMethodSearch;
	//		}
	//		return new ZenPolyFunc(FuncList);
	//	}
	//
	//	public final ZenPolyFunc GetConstructorFunc(ZenType ClassType) {
	//		return this.Context.RootNameSpace.GetMethod(ClassType, ZenNameSpace.ConstructorSymbol(), false);
	//	}
	//
	//	public final ZenFunc GetOverridedMethod(ZenType ClassType, ZenFunc GivenFunc) {
	//		/*local*/String Symbol = ZenNameSpace.FuncSymbol(GivenFunc.FuncName);
	//		/*local*/ZenType GivenClassType = GivenFunc.GetRecvType();
	//		if(ClassType != GivenClassType) {
	//			/*local*/ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
	//			while(ClassType != null) {
	//				/*local*/String Key = ZenNameSpace.ClassSymbol(ClassType, Symbol);
	//				this.RetrieveFuncList(Key, FuncList);
	//				for(/*local*/int i = 0; i < FuncList.size(); i+= 1) {
	//					/*local*/ZenFunc Func = FuncList.get(i);
	//					if(Func.EqualsOverridedMethod(GivenFunc)) {
	//						return Func;
	//					}
	//				}
	//				FuncList.clear();
	//				ClassType = ClassType.ParentMethodSearch;
	//			}
	//		}
	//		return GivenFunc;
	//	}
	//
	//	public final Object RetrieveFuncList(String FuncName, ArrayList<ZenFunc> FuncList) {
	//		/*local*/Object FuncValue = this.GetLocalSymbol(FuncName);
	//		if(FuncValue instanceof ZenFunc) {
	//			/*local*/ZenFunc Func = (/*cast*/ZenFunc)FuncValue;
	//			FuncList.add(Func);
	//		}
	//		else if(FuncValue instanceof ZenPolyFunc) {
	//			/*local*/ZenPolyFunc PolyFunc = (/*cast*/ZenPolyFunc)FuncValue;
	//			/*local*/int i = PolyFunc.FuncList.size() - 1;
	//			while(i >= 0) {
	//				FuncList.add(PolyFunc.FuncList.get(i));
	//				i = i - 1;
	//			}
	//		}
	//		if(this.ParentNameSpace != null) {
	//			return this.ParentNameSpace.RetrieveFuncList(FuncName, FuncList);
	//		}
	//		return FuncValue;
	//	}

	//	public final ZenPolyFunc GetPolyFunc(String FuncName) {
	//		/*local*/ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
	//		this.RetrieveFuncList(FuncName, FuncList);
	//		return new ZenPolyFunc(null, FuncList);
	//	}
	//
	//	public final ZenFunc GetFunc(String FuncName, int BaseIndex, ArrayList<ZenType> TypeList) {
	//		/*local*/ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
	//		this.RetrieveFuncList(FuncName, FuncList);
	//		/*local*/int i = 0;
	//		while(i < FuncList.size()) {
	//			/*local*/ZenFunc Func = FuncList.get(i);
	//			if(Func.Types.length == TypeList.size() - BaseIndex) {
	//				/*local*/int j = 0;
	//				while(j < Func.Types.length) {
	//					if(TypeList.get(BaseIndex + j) != Func.Types[j]) {
	//						Func = null;
	//						break;
	//					}
	//					j = j + 1;
	//				}
	//				if(Func != null) {
	//					return Func;
	//				}
	//			}
	//			i = i + 1;
	//		}
	//		return null;
	//	}

	//	public final Object AppendFuncName(String Key, ZenFunc Func, ZenToken SourceToken) {
	//		/*local*/Object OldValue = this.GetLocalSymbol(Key);
	//		if(OldValue instanceof ZenSyntaxPattern) {
	//			return OldValue;
	//		}
	//		if(OldValue instanceof ZenFunc) {
	//			/*local*/ZenFunc OldFunc = (/*cast*/ZenFunc)OldValue;
	//			if(!OldFunc.EqualsType(Func)) {
	//				/*local*/ZenPolyFunc PolyFunc = new ZenPolyFunc(null);
	//				PolyFunc.Append(this.Context, OldFunc, SourceToken);
	//				PolyFunc.Append(this.Context, Func, SourceToken);
	//				this.SetSymbol(Key, PolyFunc, null);
	//				return PolyFunc;
	//			}
	//			// error
	//		}
	//		else if(OldValue instanceof ZenPolyFunc) {
	//			/*local*/ZenPolyFunc PolyFunc = (/*cast*/ZenPolyFunc)OldValue;
	//			PolyFunc.Append(this.Context, Func, SourceToken);
	//			return PolyFunc;
	//		}
	//		this.SetSymbol(Key, Func, SourceToken);
	//		return OldValue;
	//	}
	//
	//	public final Object AppendFunc(ZenFunc Func, ZenToken SourceToken) {
	//		return this.AppendFuncName(Func.FuncName, Func, SourceToken);
	//	}
	//
	//	public final Object AppendStaticFunc(ZenType StaticType, ZenFunc Func, ZenToken SourceToken) {
	//		/*local*/int loc = Func.FuncName.lastIndexOf(".");
	//		return this.AppendFuncName(ZenNameSpace.ClassStaticSymbol(StaticType, Func.FuncName.substring(loc+1)), Func, SourceToken);
	//	}
	//
	//	public final Object AppendMethod(ZenFunc Func, ZenToken SourceToken) {
	//		/*local*/ZenType ClassType = Func.GetRecvType();
	//		if(ClassType.IsGenericType() && ClassType.HasTypeVariable()) {
	//			ClassType = ClassType.BaseType;
	//		}
	//		/*local*/String Key = ZenNameSpace.ClassSymbol(ClassType, Func.FuncName);
	//		return this.AppendFuncName(Key, Func, SourceToken);
	//	}
	//
	//	public final void AppendConstructor(ZenType ClassType, ZenFunc Func, ZenToken SourceToken) {
	//		/*local*/String Key = ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.ConstructorSymbol());
	//		LibNative.Assert(Func.Is(ConstructorFunc));
	//		this.Context.RootNameSpace.AppendFuncName(Key, Func, SourceToken);  // @Public
	//	}
	//
	//	public final void SetGetterFunc(ZenType ClassType, String Name, ZenFunc Func, ZenToken SourceToken) {
	//		/*local*/String Key = ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.GetterSymbol(Name));
	//		LibNative.Assert(Func.Is(GetterFunc));
	//		this.Context.RootNameSpace.SetSymbol(Key, Func, SourceToken);  // @Public
	//	}
	//
	//	public final void SetSetterFunc(ZenType ClassType, String Name, ZenFunc Func, ZenToken SourceToken) {
	//		/*local*/String Key = ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.SetterSymbol(Name));
	//		LibNative.Assert(Func.Is(SetterFunc));
	//		this.Context.RootNameSpace.SetSymbol(Key, Func, SourceToken);  // @Public
	//	}
	//
	//	public final void SetConverterFunc(ZenType ClassType, ZenType ToType, ZenFunc Func, ZenToken SourceToken) {
	//		if(ClassType == null) {
	//			ClassType = Func.GetFuncParamType(0);
	//		}
	//		if(ToType == null) {
	//			ToType = Func.GetReturnType();
	//		}
	//		/*local*/String Key = ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.ConverterSymbol(ToType));
	//		LibNative.Assert(Func.Is(ConverterFunc));
	//		this.SetSymbol(Key, Func, SourceToken);
	//	}

	final Object EvalWithErrorInfo(String ScriptText, long FileLine) {
		/*local*/Object ResultValue = null;
		ZenLogger.VerboseLog(ZenLogger.VerboseEval, "eval: " + ScriptText);
		/*local*/ZenTokenContext TokenContext = new ZenTokenContext(this, ScriptText, FileLine);
		/*local*/ZenTypeCheckerImpl2 TypeChecker = new ZenTypeCheckerImpl2(this.Generator.Logger);
		TokenContext.SkipEmptyStatement();
		while(TokenContext.HasNext()) {
			TokenContext.SetParseFlag(0); // init
			/*local*/ZenNode TopLevelNode = TokenContext.ParsePattern(this, "$Statement$", ZenParserConst.Required);
			//			TypeChecker.EnableVisitor();
			//			TopLevelNode = TypeChecker.TypeCheck(TopLevelNode, this, ZenSystem.VoidType, 0);
			this.Generator.DoCodeGeneration(this, TopLevelNode);
			if(TopLevelNode.IsErrorNode() && TokenContext.HasNext()) {
				/*local*/ZenToken Token = TokenContext.GetToken();
				this.Generator.Logger.ReportInfo(Token, "stopped script at this line");
				return null;
			}
			//			if(!TopLevelNode.Type.IsVoidType()) {
			ResultValue = this.Generator.EvalTopLevelNode(TopLevelNode);
			//			}
			TokenContext.SkipEmptyStatement();
			TokenContext.Vacume();
		}
		return ResultValue;
	}

	public final Object Eval(String ScriptText, long FileLine) {
		/*local*/Object ResultValue = this.EvalWithErrorInfo(ScriptText, FileLine);
		if(ResultValue instanceof ZenToken && ((/*cast*/ZenToken)ResultValue).IsError()) {
			return null;
		}
		return ResultValue;
	}

	public final boolean Load(String ScriptText, long FileLine) {
		/*local*/Object Token = this.EvalWithErrorInfo(ScriptText, FileLine);
		if(Token instanceof ZenToken && ((/*cast*/ZenToken)Token).IsError()) {
			return false;
		}
		return true;
	}

	public final boolean LoadFile(String FileName) {
		/*local*/String ScriptText = LibNative.LoadScript(FileName);
		if(ScriptText != null) {
			/*local*/long FileLine = ZenSystem.GetFileLine(FileName, 1);
			return this.Load(ScriptText, FileLine);
		}
		return false;
	}

	public final boolean LoadRequiredLib(String LibName) {
		/*local*/String Key = ZenParserConst.NativeNameSuffix + "L" + LibName.toLowerCase();
		if(!this.HasSymbol(Key)) {
			/*local*/String Path = LibZen.GetLibPath(this.Generator.TargetCode, LibName);
			/*local*/String Script = LibNative.LoadScript(Path);
			if(Script != null) {
				/*local*/long FileLine = ZenSystem.GetFileLine(Path, 1);
				if(this.Load(Script, FileLine)) {
					this.SetSymbol(Key, Path, null);
					return true;
				}
			}
			return false;
		}
		return true;
	}

	private void UpdateRevertList(String Key, ArrayList<Object> RevertList) {
		/*local*/Object Value = this.GetLocalSymbol(Key);
		RevertList.add(Key);
		if(Value != null) {
			RevertList.add(Value);
		}
		else {
			RevertList.add(ZenParserConst.UndefinedSymbol);
		}
	}

	public void Revert(ArrayList<Object> RevertList) {
		for(/*local*/int i = 0; i < RevertList.size(); i += 2) {
			/*local*/String Key = (/*cast*/String)RevertList.get(i);
			/*local*/Object Value = RevertList.get(i+1);
			this.SetSymbol(Key, Value, null);
		}
	}

	public final static String FuncSymbol(String Symbol) {
		return LibZen.IsVariableName(Symbol, 0) ? Symbol : "__" + Symbol;
	}

	public final static String ConverterSymbol(ZenType ClassType) {
		return ClassType.GetUniqueName();
	}

	public final static String ConstructorSymbol() {
		return "";
	}

	public final static String SetterSymbol(String Symbol) {
		return Symbol + "=";
	}

	public final static String GetterSymbol(String Symbol) {
		return Symbol + "+";
	}

	public final static String ClassSymbol(ZenType ClassType, String Symbol) {
		return ClassType.GetUniqueName() + "." + Symbol;
	}

	public final static String ClassStaticSymbol(ZenType ClassType, String Symbol) {
		return ClassType.GetUniqueName() + ".@" + Symbol;
	}

	public final static String SuffixPatternSymbol(String PatternName) {
		return "\t" + PatternName;
	}


}
