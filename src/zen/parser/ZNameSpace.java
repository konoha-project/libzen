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
import zen.ast.ZBooleanNode;
import zen.ast.ZFloatNode;
import zen.ast.ZIntNode;
import zen.ast.ZNode;
import zen.ast.ZStringNode;
import zen.ast.ZTypeNode;
import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.lang.ZFunc;
import zen.lang.ZSystem;
import zen.lang.ZenClassType;
import zen.type.ZType;

public final class ZNameSpace {
	@Field public final ZNameSpace   ParentNameSpace;
	@Field public final ZGenerator   Generator;

	@Field ZTokenFunc[]   TokenMatrix;
	@Field ZenMap<Object> SymbolPatternTable;
	@Field private ZNode  FuncNode;

	public ZNameSpace(ZGenerator Generator, ZNameSpace ParentNameSpace) {
		this.ParentNameSpace = ParentNameSpace;
		this.TokenMatrix = null;
		this.SymbolPatternTable = null;
		this.FuncNode = null;
		if(ParentNameSpace == null) {
			this.Generator = Generator;
			ZSystem.InitNameSpace(this);
		}
		else {
			this.Generator = ParentNameSpace.Generator;
		}

	}

	public ZNameSpace CreateSubNameSpace() {
		return new ZNameSpace(null, this);
	}

	public ZNameSpace GetRootNameSpace() {
		return this.Generator.RootNameSpace;
	}

	// TokenMatrix
	public final ZTokenFunc GetTokenFunc(int ZenChar) {
		if(this.TokenMatrix == null) {
			return this.ParentNameSpace.GetTokenFunc(ZenChar);
		}
		return this.TokenMatrix[ZenChar];
	}

	private final ZTokenFunc JoinParentFunc(ZFunc Func, ZTokenFunc Parent) {
		if(Parent != null && Parent.Func == Func) {
			return Parent;
		}
		return new ZTokenFunc(Func, Parent);
	}

	public final void AppendTokenFunc(String keys, ZFunc TokenFunc) {
		if(this.TokenMatrix == null) {
			this.TokenMatrix = new ZTokenFunc[ZParserConst.MaxSizeOfChars];
			if(this.ParentNameSpace != null) {
				for(@Var int i = 0; i < ZParserConst.MaxSizeOfChars; i += 1) {
					this.TokenMatrix[i] = this.ParentNameSpace.GetTokenFunc(i);
				}
			}
		}
		for(@Var int i = 0; i < keys.length(); i += 1) {
			@Var int kchar = ZUtils.AsciiToTokenMatrixIndex(LibZen.CharAt(keys, i));
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
			@Var Object Value = this.SymbolPatternTable.GetOrNull(Key);
			if(Value != null) {
				return Value == ZParserConst.UndefinedSymbol ? null : Value;
			}
		}
		return null;
	}

	public final Object GetSymbol(String Key) {
		@Var ZNameSpace NameSpace = this;
		while(NameSpace != null) {
			if(NameSpace.SymbolPatternTable != null) {
				@Var Object Value = NameSpace.SymbolPatternTable.GetOrNull(Key);
				if(Value != null) {
					return Value == ZParserConst.UndefinedSymbol ? null : Value;
				}
			}
			NameSpace = NameSpace.ParentNameSpace;
		}
		return null;
	}

	public final boolean HasSymbol(String Key) {
		return (this.GetSymbol(Key) != null);
	}

	public final void SetSymbol(String Key, Object Value, ZToken SourceToken) {
		if(this.SymbolPatternTable == null) {
			this.SymbolPatternTable = new ZenMap<Object>(null);
		}
		if(SourceToken != null) {
			@Var Object OldValue = this.SymbolPatternTable.GetOrNull(Key);
			if(OldValue != null && OldValue != ZParserConst.UndefinedSymbol) {
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
		ZLogger.VerboseLog(ZLogger.VerboseSymbol, "symbol: " + Key + ", " + Value);
	}

	public final void SetUndefinedSymbol(String Symbol, ZToken SourceToken) {
		this.SetSymbol(Symbol, ZParserConst.UndefinedSymbol, SourceToken);
	}

	public final String GetSymbolText(String Key) {
		@Var Object Body = this.GetSymbol(Key);
		if(Body instanceof String) {
			return (String)Body;
		}
		return null;
	}

	// Pattern
	public ZSyntaxPattern GetSyntaxPattern(String PatternName) {
		@Var Object Body = this.GetSymbol(PatternName);
		if(Body instanceof ZSyntaxPattern) {
			return (ZSyntaxPattern)Body;
		}
		return null;
	}

	public final static String SuffixPatternSymbol(String PatternName) {
		return "\t" + PatternName;
	}

	public ZSyntaxPattern GetExtendedSyntaxPattern(String PatternName) {
		@Var Object Body = this.GetSymbol(ZNameSpace.SuffixPatternSymbol(PatternName));
		if(Body instanceof ZSyntaxPattern) {
			return (ZSyntaxPattern)Body;
		}
		return null;
	}

	private void AppendSyntaxPattern(String PatternName, ZSyntaxPattern NewPattern, ZToken SourceToken) {
		LibNative.Assert(NewPattern.ParentPattern == null);
		@Var ZSyntaxPattern ParentPattern = this.GetSyntaxPattern(PatternName);
		NewPattern.ParentPattern = ParentPattern;
		this.SetSymbol(PatternName, NewPattern, SourceToken);
	}

	public void AppendSyntax(String PatternName, ZFunc MatchFunc) {
		@Var int Alias = PatternName.indexOf(" ");
		@Var String Name = (Alias == -1) ? PatternName : PatternName.substring(0, Alias);
		@Var ZSyntaxPattern Pattern = new ZSyntaxPattern(this, Name, MatchFunc);
		this.AppendSyntaxPattern(Name, Pattern, null);
		if(Alias != -1) {
			this.AppendSyntax(PatternName.substring(Alias+1), MatchFunc);
		}
	}

	public void AppendSuffixSyntax(String PatternName, int SyntaxFlag, ZFunc MatchFunc) {
		@Var int Alias = PatternName.indexOf(" ");
		@Var String Name = (Alias == -1) ? PatternName : PatternName.substring(0, Alias);
		@Var ZSyntaxPattern Pattern = new ZSyntaxPattern(this, Name, MatchFunc);
		Pattern.SyntaxFlag = SyntaxFlag;
		this.AppendSyntaxPattern(ZNameSpace.SuffixPatternSymbol(Name), Pattern, null);
		if(Alias != -1) {
			this.AppendSuffixSyntax(PatternName.substring(Alias+1), SyntaxFlag, MatchFunc);
		}
	}

	// Type
	public final ZType GetType(String TypeName, @Nullable ZToken SourceToken) {
		@Var Object TypeInfo = this.GetSymbol(TypeName);
		if(TypeInfo instanceof ZType) {
			return (ZType)TypeInfo;
		}
		if(SourceToken != null && TypeInfo == null) {
			ZType Type = new ZenClassType(TypeName, ZSystem.VarType);
			//			this.Generator.Logger.ReportInfo(SourceToken, "implicit definition of type " + TypeName);
			this.GetRootNameSpace().SetSymbol(TypeName, Type, SourceToken);
			return Type;
		}
		return null;
	}

	public final ZType AppendTypeName(ZType Type, ZToken SourceToken) {
		if(Type.GetBaseType() == Type) {
			this.SetSymbol(Type.ShortName, Type, SourceToken);
		}
		return Type;
	}

	// DefiningFunc
	public final ZNode GetDefiningFuncNode() {
		@Var ZNameSpace NameSpace = this;
		while(NameSpace != null) {
			if(NameSpace.FuncNode != null) {
				return NameSpace.FuncNode;
			}
			NameSpace = NameSpace.ParentNameSpace;
		}
		return null;
	}

	public final void SetDefiningFunc(ZNode FuncNode) {
		this.FuncNode = FuncNode;
	}




	//	// Function
	//	public final void AppendFuncName(ZFunc Func, ZToken SourceToken) {
	//		@Var Object OldValue = this.GetLocalSymbol(Func.FuncName);
	//		assert(!(OldValue instanceof ZSyntaxPattern));
	//		@Var ZFuncSet FuncSet = null;
	//		if(OldValue instanceof ZFunc) {
	//			@Var ZFunc OldFunc = (ZFunc)OldValue;
	//			if(OldFunc.FuncType != Func.FuncType) {
	//				FuncSet = new ZFuncSet(OldFunc);
	//			}
	//		}
	//		else if(OldValue instanceof ZFuncSet) {
	//			FuncSet = (ZFuncSet)OldValue;
	//		}
	//		if(FuncSet != null) {
	//			FuncSet.Append(Func, this.Generator.Logger, SourceToken);
	//		}
	//		else {
	//			this.SetSymbol(Func.FuncName, Func, SourceToken);
	//		}
	//	}
	//
	//	public void RetrieveFuncList(ArrayList<ZFunc> FuncList, ZType ClassType, String FuncName, int FuncParamSize) {
	//		@Var ZNameSpace NameSpace = this;
	//		while(NameSpace != null) {
	//			@Var Object FuncValue = NameSpace.GetLocalSymbol(FuncName);
	//			if(FuncValue instanceof ZFunc) {
	//				@Var ZFunc Func = (ZFunc)FuncValue;
	//				if(FuncParamSize == Func.FuncType.GetFuncParamSize()) {
	//					if(ClassType == null || Func.FuncType.GetRecvType() == ClassType) {
	//						FuncList.add(Func);
	//					}
	//				}
	//			}
	//			else if(FuncValue instanceof ZFuncSet) {
	//				@Var ZFuncSet FuncSet = (ZFuncSet)FuncValue;
	//				@Var int i = FuncSet.FuncList.size() - 1;
	//				while(i >= 0) {
	//					@Var ZFunc Func = FuncSet.FuncList.get(i);
	//					if(FuncParamSize == Func.FuncType.GetFuncParamSize()) {
	//						if(ClassType == null || Func.FuncType.GetRecvType() == ClassType) {
	//							FuncList.add(Func);
	//						}
	//					}
	//					i = i - 1;
	//				}
	//			}
	//			NameSpace = NameSpace.ParentNameSpace;
	//		}
	//	}

	//	public final ZenType AppendTypeVariable(String Name, ZenType ParamBaseType, ZenToken SourceToken, ArrayList<Object> RevertList) {
	//		this.UpdateRevertList(Name, RevertList);
	//		@Var ZenType TypeVar = new ZenType(TypeVariable, Name, ParamBaseType, null);
	//		this.SetSymbol(Name, TypeVar, SourceToken);
	//		return TypeVar;
	//	}

	public final static String StringfyClassSymbol(ZType ClassType, String Symbol) {
		return ClassType.GetUniqueName() + "." + Symbol;
	}

	public final Object GetClassSymbol(ZType ClassType, String Symbol, boolean RecursiveSearch) {
		while(ClassType != null) {
			@Var String Key = ZNameSpace.StringfyClassSymbol(ClassType, Symbol);
			@Var Object Value = this.GetSymbol(Key);
			if(Value != null) {
				return Value;
			}
			if(!RecursiveSearch) {
				break;
			}
			ClassType = ClassType.GetSuperType();
		}
		return null;
	}

	public ZFunc GetCoercionFunc(ZType FromType, ZType ToType) {
		Object Func = this.GetClassSymbol(FromType, ToType.GetUniqueName(), true);
		if(Func instanceof ZFunc && ((ZFunc)Func).IsCoercionFunc()) {
			return (ZFunc)Func;
		}
		return null;
	}

	//	public final Object GetClassStaticSymbol(ZenType StaticClassType, String Symbol, boolean RecursiveSearch) {
	//		@Var String Key = null;
	//		@Var ZenType ClassType = StaticClassType;
	//		while(ClassType != null) {
	//			Key = ZenNameSpace.ClassStaticSymbol(ClassType, Symbol);
	//			@Var Object Value = this.GetSymbol(Key);
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
	//			@Var Object Value = LibNative.ImportStaticFieldValue(this.Context, StaticClassType, Symbol);
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
	//		@Var String ClassPrefix = ClassSymbol(ClassType, ClassStaticName(""));
	//		@Var ArrayList<String> KeyList = new ArrayList<String>();
	//		@Var ZenNameSpace ns = NameSpace;
	//		while(ns != null) {
	//			if(ns.SymbolPatternTable != null) {
	//				LibZen.RetrieveMapKeys(ns.SymbolPatternTable, ClassPrefix, KeyList);
	//			}
	//			ns = ns.ParentNameSpace;
	//		}
	//		for(@Var int i = 0; i < KeyList.size(); i = i + 1) {
	//			@Var String Key = KeyList.get(i);
	//			@Var Object Value = NameSpace.GetSymbol(Key);
	//			Key = Key.replace(ClassPrefix, Prefix);
	//			if(SourceToken != null) {
	//				SourceToken.ParsedText = Key;
	//			}
	//			this.SetSymbol(Key, Value, SourceToken);
	//		}
	//	}

	//	public final ZenFunc GetGetterFunc(ZenType ClassType, String Symbol, boolean RecursiveSearch) {
	//		@Var Object Func = this.Context.RootNameSpace.GetClassSymbol(ClassType, ZenNameSpace.GetterSymbol(Symbol), RecursiveSearch);
	//		if(Func instanceof ZenFunc) {
	//			return (ZenFunc)Func;
	//		}
	//		Func = this.Context.RootNameSpace.GetLocalUndefinedSymbol(ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.GetterSymbol(Symbol)));
	//		if(ClassType.IsDynamicNaitiveLoading() && Func == null) {
	//			return LibZen.LoadNativeField(this.Context, ClassType, Symbol, false);
	//		}
	//		return null;
	//	}
	//
	//	public final ZenFunc GetSetterFunc(ZenType ClassType, String Symbol, boolean RecursiveSearch) {
	//		@Var Object Func = this.Context.RootNameSpace.GetClassSymbol(ClassType, ZenNameSpace.SetterSymbol(Symbol), RecursiveSearch);
	//		if(Func instanceof ZenFunc) {
	//			return (ZenFunc)Func;
	//		}
	//		Func = this.Context.RootNameSpace.GetLocalUndefinedSymbol(ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.SetterSymbol(Symbol)));
	//		if(ClassType.IsDynamicNaitiveLoading() && Func == null) {
	//			return LibZen.LoadNativeField(this.Context, ClassType, Symbol, true);
	//		}
	//		return null;
	//	}
	//
	//	public final ZenFunc GetConverterFunc(ZenType FromType, ZenType ToType, boolean RecursiveSearch) {
	//		@Var Object Func = this.GetClassSymbol(FromType, ZenNameSpace.ConverterSymbol(ToType), RecursiveSearch);
	//		if(Func instanceof ZenFunc) {
	//			return (ZenFunc)Func;
	//		}
	//		return null;
	//	}
	//
	//	public final ZenFuncSet GetMethod(ZenType ClassType, String Symbol, boolean RecursiveSearch) {
	//		@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
	//		while(ClassType != null) {
	//			@Var String Key = ZenNameSpace.ClassSymbol(ClassType, Symbol);
	//			@Var Object RootValue = this.RetrieveFuncList(Key, FuncList);
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
	//		return new ZenFuncSet(FuncList);
	//	}
	//
	//	public final ZenFuncSet GetConstructorFunc(ZenType ClassType) {
	//		return this.Context.RootNameSpace.GetMethod(ClassType, ZenNameSpace.ConstructorSymbol(), false);
	//	}
	//
	//	public final ZenFunc GetOverridedMethod(ZenType ClassType, ZenFunc GivenFunc) {
	//		@Var String Symbol = ZenNameSpace.FuncSymbol(GivenFunc.FuncName);
	//		@Var ZenType GivenClassType = GivenFunc.GetRecvType();
	//		if(ClassType != GivenClassType) {
	//			@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
	//			while(ClassType != null) {
	//				@Var String Key = ZenNameSpace.ClassSymbol(ClassType, Symbol);
	//				this.RetrieveFuncList(Key, FuncList);
	//				for(@Var int i = 0; i < FuncList.size(); i+= 1) {
	//					@Var ZenFunc Func = FuncList.get(i);
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

	//	public final ZenFuncSet GetFuncSet(String FuncName) {
	//		@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
	//		this.RetrieveFuncList(FuncName, FuncList);
	//		return new ZenFuncSet(null, FuncList);
	//	}
	//
	//	public final ZenFunc GetFunc(String FuncName, int BaseIndex, ArrayList<ZenType> TypeList) {
	//		@Var ArrayList<ZenFunc> FuncList = new ArrayList<ZenFunc>();
	//		this.RetrieveFuncList(FuncName, FuncList);
	//		@Var int i = 0;
	//		while(i < FuncList.size()) {
	//			@Var ZenFunc Func = FuncList.get(i);
	//			if(Func.Types.length == TypeList.size() - BaseIndex) {
	//				@Var int j = 0;
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

	//
	//	public final Object AppendFunc(ZenFunc Func, ZenToken SourceToken) {
	//		return this.AppendFuncName(Func.FuncName, Func, SourceToken);
	//	}
	//
	//	public final Object AppendStaticFunc(ZenType StaticType, ZenFunc Func, ZenToken SourceToken) {
	//		@Var int loc = Func.FuncName.lastIndexOf(".");
	//		return this.AppendFuncName(ZenNameSpace.ClassStaticSymbol(StaticType, Func.FuncName.substring(loc+1)), Func, SourceToken);
	//	}
	//
	//	public final Object AppendMethod(ZenFunc Func, ZenToken SourceToken) {
	//		@Var ZenType ClassType = Func.GetRecvType();
	//		if(ClassType.IsGenericType() && ClassType.HasTypeVariable()) {
	//			ClassType = ClassType.BaseType;
	//		}
	//		@Var String Key = ZenNameSpace.ClassSymbol(ClassType, Func.FuncName);
	//		return this.AppendFuncName(Key, Func, SourceToken);
	//	}
	//
	//	public final void AppendConstructor(ZenType ClassType, ZenFunc Func, ZenToken SourceToken) {
	//		@Var String Key = ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.ConstructorSymbol());
	//		LibNative.Assert(Func.Is(ConstructorFunc));
	//		this.Context.RootNameSpace.AppendFuncName(Key, Func, SourceToken);  // @Public
	//	}
	//
	//	public final void SetGetterFunc(ZenType ClassType, String Name, ZenFunc Func, ZenToken SourceToken) {
	//		@Var String Key = ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.GetterSymbol(Name));
	//		LibNative.Assert(Func.Is(GetterFunc));
	//		this.Context.RootNameSpace.SetSymbol(Key, Func, SourceToken);  // @Public
	//	}
	//
	//	public final void SetSetterFunc(ZenType ClassType, String Name, ZenFunc Func, ZenToken SourceToken) {
	//		@Var String Key = ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.SetterSymbol(Name));
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
	//		@Var String Key = ZenNameSpace.ClassSymbol(ClassType, ZenNameSpace.ConverterSymbol(ToType));
	//		LibNative.Assert(Func.Is(ConverterFunc));
	//		this.SetSymbol(Key, Func, SourceToken);
	//	}
	//
	//	private ZNode TypeCheck(ZNode Node, ZType ContextType) {
	//		this.Generator.TypeChecker.EnableVisitor();
	//		return this.Generator.TypeChecker.TypeCheck(Node, this, ContextType, 0);
	//	}
	//
	//	public final Object Eval(String ScriptText, long FileLine, boolean IsInteractive) {
	//		@Var Object ResultValue = ZParserConst.UndefinedSymbol;
	//		//ZenLogger.VerboseLog(ZenLogger.VerboseEval, "eval: " + ScriptText);
	//		@Var ZTokenContext TokenContext = new ZTokenContext(this, ScriptText, FileLine);
	//		TokenContext.SkipEmptyStatement();
	//		while(TokenContext.HasNext()) {
	//			TokenContext.SetParseFlag(0); // init
	//			@Var ZNode TopLevelNode = TokenContext.ParsePattern(this, "$Statement$", ZTokenContext.Required);
	//			TopLevelNode = this.TypeCheck(TopLevelNode, ZSystem.VoidType);
	//			this.Generator.DoCodeGeneration(this, TopLevelNode);
	//			if(TopLevelNode.IsErrorNode() && TokenContext.HasNext()) {
	//				@Var ZToken Token = TokenContext.GetToken();
	//				this.Generator.Logger.ReportInfo(Token, "stopped script at this line");
	//				return TopLevelNode;
	//			}
	//			//			if(!TopLevelNode.Type.IsVoidType()) {
	//			ResultValue = this.Generator.EvalTopLevelNode(TopLevelNode);
	//			//			}
	//			TokenContext.SkipEmptyStatement();
	//			TokenContext.Vacume();
	//		}
	//		return ResultValue;
	//	}

	//	private void UpdateRevertList(String Key, ArrayList<Object> RevertList) {
	//		@Var Object Value = this.GetLocalSymbol(Key);
	//		RevertList.add(Key);
	//		if(Value != null) {
	//			RevertList.add(Value);
	//		}
	//		else {
	//			RevertList.add(ZenParserConst.UndefinedSymbol);
	//		}
	//	}
	//
	//	public void Revert(ArrayList<Object> RevertList) {
	//		for(@Var int i = 0; i < RevertList.size(); i += 2) {
	//			@Var String Key = (String)RevertList.get(i);
	//			@Var Object Value = RevertList.get(i+1);
	//			this.SetSymbol(Key, Value, null);
	//		}
	//	}

	//	public final static String FuncSymbol(String Symbol) {
	//		return LibZen.IsVariableName(Symbol, 0) ? Symbol : "__" + Symbol;
	//	}
	//
	//	public final static String ConverterSymbol(ZenType ClassType) {
	//		return ClassType.GetUniqueName();
	//	}
	//
	//	public final static String ConstructorSymbol() {
	//		return "";
	//	}
	//
	//	public final static String SetterSymbol(String Symbol) {
	//		return Symbol + "=";
	//	}
	//
	//	public final static String GetterSymbol(String Symbol) {
	//		return Symbol + "+";
	//	}
	//

	public final static String StringfyClassStaticSymbol(ZType ClassType, String Symbol) {
		return ClassType.GetUniqueName() + ".@" + Symbol;
	}

	public void SetTypedNode(String Symbol, ZNode Node) {
		this.GetRootNameSpace().SetSymbol(Symbol, Node, null);
	}

	public ZNode GetSymbolNode(String Symbol, ZToken SourceToken) {
		Object SymbolNode = this.GetSymbol(Symbol);
		if(SymbolNode instanceof ZNode) {
			return (ZNode)SymbolNode;
		}
		if(SymbolNode instanceof String) {
			return new ZStringNode(SourceToken, (String)SymbolNode);
		}
		if(SymbolNode instanceof ZType) {
			return new ZTypeNode(SourceToken, (ZType)SymbolNode);
		}
		if(SymbolNode instanceof Double) {
			return new ZFloatNode(SourceToken, ((Double)SymbolNode));
		}
		if(SymbolNode instanceof Number) {
			return new ZIntNode(SourceToken, ((Number)SymbolNode).longValue());
		}
		if(SymbolNode instanceof Boolean) {
			return new ZBooleanNode(SourceToken, (Boolean)SymbolNode);
		}
		return null;
	}

}
