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
import zen.ast.ZFunctionNode;
import zen.ast.ZNode;
import zen.ast.ZTypeNode;
import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.lang.ZFunc;
import zen.lang.ZenClassType;
import zen.type.ZType;

public final class ZNameSpace {
	private static int SerialNumber = 0;
	@Field public final ZNameSpace   ParentNameSpace;
	@Field public final ZGenerator   Generator;
	@Field private int SerialId = 0;
	@Field ZTokenFunc[]   TokenMatrix = null;
	@Field ZenMap<Object> SymbolPatternTable = null;
	@Field ZenMap<ZSyntaxPattern> SyntaxTable = null;
	@Field ZenMap<ZSymbol> SymbolTable = null;
	//	@Field private ZNode  FuncNode = null;

	public ZNameSpace(ZGenerator Generator, ZNameSpace ParentNameSpace) {
		this.ParentNameSpace = ParentNameSpace;
		if(ParentNameSpace == null) {
			this.Generator = Generator;
		}
		else {
			this.Generator = ParentNameSpace.Generator;
		}
		this.SerialId = SerialNumber;
		SerialNumber = SerialNumber + 1;
	}

	@Override public String toString() {
		return "NS["+this.SerialId+"]";
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

	// Pattern
	public final ZSyntaxPattern GetSyntaxPattern(String PatternName) {
		@Var ZNameSpace NameSpace = this;
		while(NameSpace != null) {
			if(NameSpace.SyntaxTable != null) {
				return NameSpace.SyntaxTable.GetOrNull(PatternName);
			}
			NameSpace = NameSpace.ParentNameSpace;
		}
		return null;
	}

	public final void SetSyntaxPattern(String PatternName, ZSyntaxPattern Syntax) {
		if(this.SyntaxTable == null) {
			this.SyntaxTable = new ZenMap<ZSyntaxPattern>(null);
		}
		this.SyntaxTable.put(PatternName, Syntax);
	}

	public final static String SuffixPatternSymbol(String PatternName) {
		return "\t" + PatternName;
	}

	public ZSyntaxPattern GetSuffixSyntaxPattern(String PatternName) {
		return this.GetSyntaxPattern(ZNameSpace.SuffixPatternSymbol(PatternName));
	}

	private void AppendSyntaxPattern(String PatternName, ZSyntaxPattern NewPattern) {
		LibNative.Assert(NewPattern.ParentPattern == null);
		@Var ZSyntaxPattern ParentPattern = this.GetSyntaxPattern(PatternName);
		NewPattern.ParentPattern = ParentPattern;
		this.SetSyntaxPattern(PatternName, NewPattern);
	}

	public void DefineStatement(String PatternName, ZFunc MatchFunc) {
		@Var int Alias = PatternName.indexOf(" ");
		@Var String Name = (Alias == -1) ? PatternName : PatternName.substring(0, Alias);
		@Var ZSyntaxPattern Pattern = new ZSyntaxPattern(this, Name, MatchFunc);
		Pattern.IsStatement = true;
		this.AppendSyntaxPattern(Name, Pattern);
		if(Alias != -1) {
			this.DefineStatement(PatternName.substring(Alias+1), MatchFunc);
		}
	}

	public void DefineSyntax(String PatternName, ZFunc MatchFunc) {
		@Var int Alias = PatternName.indexOf(" ");
		@Var String Name = (Alias == -1) ? PatternName : PatternName.substring(0, Alias);
		@Var ZSyntaxPattern Pattern = new ZSyntaxPattern(this, Name, MatchFunc);
		this.AppendSyntaxPattern(Name, Pattern);
		if(Alias != -1) {
			this.DefineSyntax(PatternName.substring(Alias+1), MatchFunc);
		}
	}

	public void DefineSuffixSyntax(String PatternName, int SyntaxFlag, ZFunc MatchFunc) {
		@Var int Alias = PatternName.indexOf(" ");
		@Var String Name = (Alias == -1) ? PatternName : PatternName.substring(0, Alias);
		@Var ZSyntaxPattern Pattern = new ZSyntaxPattern(this, Name, MatchFunc);
		Pattern.SyntaxFlag = SyntaxFlag;
		this.AppendSyntaxPattern(ZNameSpace.SuffixPatternSymbol(Name), Pattern);
		if(Alias != -1) {
			this.DefineSuffixSyntax(PatternName.substring(Alias+1), SyntaxFlag, MatchFunc);
		}
	}

	public final ZSymbol GetSymbol(String Symbol) {
		@Var ZNameSpace NameSpace = this;
		while(NameSpace != null) {
			if(NameSpace.SymbolTable != null) {
				@Var ZSymbol Entry = NameSpace.SymbolTable.GetOrNull(Symbol);
				if(Entry != null) {
					if(Entry.IsDisabled) {
						return null;
					}
					return Entry;
				}
			}
			NameSpace = NameSpace.ParentNameSpace;
		}
		return null;
	}

	public final ZNode GetSymbolNode(String Symbol) {
		ZSymbol Entry = this.GetSymbol(Symbol);
		if(Entry != null) {
			return Entry.Node;
		}
		return null;
	}

	private void SetLocalSymbolEntry(String Symbol, ZSymbol Entry) {
		if(this.SymbolTable == null) {
			this.SymbolTable = new ZenMap<ZSymbol>(null);
		}
		this.SymbolTable.put(Symbol, Entry);
	}

	public final ZSymbol SetLocalSymbol(String Symbol, ZNode Node) {
		@Var ZSymbol Parent = this.GetSymbol(Symbol);
		Node.ParentNode = null; // kill links
		this.SetLocalSymbolEntry(Symbol, new ZSymbol(Parent, Node));
		return Parent;
	}

	public final ZSymbol SetGlobalSymbol(String Symbol, ZNode Node) {
		return this.GetRootNameSpace().SetLocalSymbol(Symbol, Node);
	}

	public ZVariable GetLocalVariable(String VarName) {
		ZSymbol Entry = this.GetSymbol(VarName);
		if(Entry instanceof ZVariable) {
			return (ZVariable)Entry;
		}
		return null;
	}

	public void SetLocalVariable(ZFunctionNode FunctionNode, ZType VarType, String VarName, ZToken SourceToken) {
		@Var ZSymbol Parent = this.GetSymbol(VarName);
		@Var ZVariable VarInfo = new ZVariable(Parent, FunctionNode, 0, VarType, VarName, SourceToken);
		this.SetLocalSymbolEntry(VarName, VarInfo);
	}

	// Type

	public final void SetTypeName(String Name, ZType Type, @Nullable ZToken SourceToken) {
		ZTypeNode Node = new ZTypeNode(null, SourceToken, Type);
		this.SetLocalSymbol(Name, Node);
	}

	public final void SetTypeName(ZType Type, @Nullable ZToken SourceToken) {
		this.SetTypeName(Type.ShortName, Type, SourceToken);
	}

	public ZTypeNode GetTypeNode(String TypeName, ZToken SourceToken) {
		@Var ZNode Node = this.GetSymbolNode(TypeName);
		if(Node instanceof ZTypeNode) {
			return (ZTypeNode)Node;
		}
		if(Node == null && SourceToken != null) {
			@Var ZType Type = new ZenClassType(TypeName, ZType.VarType);
			this.GetRootNameSpace().SetTypeName(TypeName, Type, SourceToken);
			return this.GetTypeNode(TypeName, null/*don't create again*/);
		}
		return null;
	}

	public ZType GetType(String TypeName, ZToken SourceToken) {
		@Var ZTypeNode TypeNode = this.GetTypeNode(TypeName, SourceToken);
		if(TypeNode != null) {
			return TypeNode.Type;
		}
		return null;
	}

}
