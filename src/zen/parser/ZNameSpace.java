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
import zen.type.ZClassType;
import zen.type.ZType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Nullable;
import zen.util.Var;
import zen.util.ZMatchFunction;
import zen.util.ZTokenFunction;
import zen.util.ZenMap;

public final class ZNameSpace {
	//	private static int SerialNumber = 0;

	@Field public final ZNameSpace   ParentNameSpace;
	@Field public final ZGenerator   Generator;
	@Field private int SerialId = 0;
	@Field ZTokenFunc[]   TokenMatrix = null;
	@Field ZenMap<ZSyntax> SyntaxTable = null;
	@Field ZenMap<ZSymbolEntry> SymbolTable = null;

	//	@Field private ZNode  FuncNode = null;

	public ZNameSpace(ZGenerator Generator, ZNameSpace ParentNameSpace) {
		this.ParentNameSpace = ParentNameSpace;
		if(ParentNameSpace == null) {
			this.Generator = Generator;
		}
		else {
			this.Generator = ParentNameSpace.Generator;
		}
		this.SerialId = 0;//SerialNumber;
		//		SerialNumber = SerialNumber + 1;
	}

	@Override public String toString() {
		return "NS["+this.SerialId+"]";
	}

	public final ZNameSpace CreateSubNameSpace() {
		return new ZNameSpace(null, this);
	}

	public final ZNameSpace GetRootNameSpace() {
		return this.Generator.RootNameSpace;
	}

	// TokenMatrix
	public final ZTokenFunc GetTokenFunc(int ZenChar) {
		if(this.TokenMatrix == null) {
			return this.ParentNameSpace.GetTokenFunc(ZenChar);
		}
		return this.TokenMatrix[ZenChar];
	}

	private final ZTokenFunc JoinParentFunc(ZTokenFunction Func, ZTokenFunc Parent) {
		if(Parent != null && Parent.Func == Func) {
			return Parent;
		}
		return new ZTokenFunc(Func, Parent);
	}

	public final void AppendTokenFunc(String keys, ZTokenFunction TokenFunc) {
		if(this.TokenMatrix == null) {
			this.TokenMatrix = LibZen._NewTokenMatrix();
			if(this.ParentNameSpace != null) {
				@Var int i = 0;
				while(i < this.TokenMatrix.length) {
					this.TokenMatrix[i] = this.ParentNameSpace.GetTokenFunc(i);
					i = i + 1;
				}
			}
		}
		@Var int i = 0;
		while(i < keys.length()) {
			@Var int kchar = LibZen._GetTokenMatrixIndex(LibZen._GetChar(keys, i));
			this.TokenMatrix[kchar] = this.JoinParentFunc(TokenFunc, this.TokenMatrix[kchar]);
			i = i + 1;
		}
	}

	// Pattern
	public final ZSyntax GetSyntaxPattern(String PatternName) {
		@Var ZNameSpace NameSpace = this;
		while(NameSpace != null) {
			if(NameSpace.SyntaxTable != null) {
				return NameSpace.SyntaxTable.GetOrNull(PatternName);
			}
			NameSpace = NameSpace.ParentNameSpace;
		}
		return null;
	}

	public final void SetSyntaxPattern(String PatternName, ZSyntax Syntax) {
		if(this.SyntaxTable == null) {
			this.SyntaxTable = new ZenMap<ZSyntax>(null);
		}
		this.SyntaxTable.put(PatternName, Syntax);
	}

	public final static String _RightPatternSymbol(String PatternName) {
		return "\t" + PatternName;
	}

	public final ZSyntax GetRightSyntaxPattern(String PatternName) {
		return this.GetSyntaxPattern(ZNameSpace._RightPatternSymbol(PatternName));
	}

	private void AppendSyntaxPattern(String PatternName, ZSyntax NewPattern) {
		LibZen._Assert(NewPattern.ParentPattern == null);
		@Var ZSyntax ParentPattern = this.GetSyntaxPattern(PatternName);
		NewPattern.ParentPattern = ParentPattern;
		this.SetSyntaxPattern(PatternName, NewPattern);
	}

	public final void DefineStatement(String PatternName, ZMatchFunction MatchFunc) {
		@Var int Alias = PatternName.indexOf(" ");
		@Var String Name = PatternName;
		if(Alias != -1) {
			Name = PatternName.substring(0, Alias);
		}
		@Var ZSyntax Pattern = new ZSyntax(this, Name, MatchFunc);
		Pattern.IsStatement = true;
		this.AppendSyntaxPattern(Name, Pattern);
		if(Alias != -1) {
			this.DefineStatement(PatternName.substring(Alias+1), MatchFunc);
		}
	}

	public final void DefineExpression(String PatternName, ZMatchFunction MatchFunc) {
		@Var int Alias = PatternName.indexOf(" ");
		@Var String Name = PatternName;
		if(Alias != -1) {
			Name = PatternName.substring(0, Alias);
		}
		@Var ZSyntax Pattern = new ZSyntax(this, Name, MatchFunc);
		this.AppendSyntaxPattern(Name, Pattern);
		if(Alias != -1) {
			this.DefineExpression(PatternName.substring(Alias+1), MatchFunc);
		}
	}

	public final void DefineRightExpression(String PatternName, int SyntaxFlag, ZMatchFunction MatchFunc) {
		@Var int Alias = PatternName.indexOf(" ");
		@Var String Name = PatternName;
		if(Alias != -1) {
			Name = PatternName.substring(0, Alias);
		}
		@Var ZSyntax Pattern = new ZSyntax(this, Name, MatchFunc);
		Pattern.SyntaxFlag = SyntaxFlag;
		this.AppendSyntaxPattern(ZNameSpace._RightPatternSymbol(Name), Pattern);
		if(Alias != -1) {
			this.DefineRightExpression(PatternName.substring(Alias+1), SyntaxFlag, MatchFunc);
		}
	}

	public final ZSymbolEntry GetSymbol(String Symbol) {
		@Var ZNameSpace NameSpace = this;
		while(NameSpace != null) {
			if(NameSpace.SymbolTable != null) {
				@Var ZSymbolEntry Entry = NameSpace.SymbolTable.GetOrNull(Symbol);
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
		@Var ZSymbolEntry Entry = this.GetSymbol(Symbol);
		if(Entry != null) {
			return Entry.Node;
		}
		return null;
	}

	private void SetLocalSymbolEntry(String Symbol, ZSymbolEntry Entry) {
		if(this.SymbolTable == null) {
			this.SymbolTable = new ZenMap<ZSymbolEntry>(null);
		}
		this.SymbolTable.put(Symbol, Entry);
	}

	public final ZSymbolEntry SetLocalSymbol(String Symbol, ZNode Node) {
		@Var ZSymbolEntry Parent = this.GetSymbol(Symbol);
		Node.ParentNode = null; // kill links
		this.SetLocalSymbolEntry(Symbol, new ZSymbolEntry(Parent, Node));
		return Parent;
	}

	public final ZSymbolEntry SetGlobalSymbol(String Symbol, ZNode Node) {
		return this.GetRootNameSpace().SetLocalSymbol(Symbol, Node);
	}

	public final ZVariable GetLocalVariable(String VarName) {
		@Var ZSymbolEntry Entry = this.GetSymbol(VarName);
		//System.out.println("var " + VarName + ", entry=" + Entry + ", NameSpace=" + this);
		if(Entry instanceof ZVariable) {
			return (ZVariable)Entry;
		}
		return null;
	}

	public final int SetLocalVariable(ZFunctionNode FunctionNode, ZType VarType, String VarName, ZToken SourceToken) {
		@Var ZSymbolEntry Parent = this.GetSymbol(VarName);
		@Var ZVariable VarInfo = new ZVariable(Parent, FunctionNode, 0, VarType, VarName, SourceToken);
		//System.out.println("set var " + VarName + ", entry=" + VarInfo + ", NameSpace=" + this);
		this.SetLocalSymbolEntry(VarName, VarInfo);
		return VarInfo.VarUniqueIndex;
	}

	// Type

	public final void SetTypeName(String Name, ZType Type, @Nullable ZToken SourceToken) {
		@Var ZTypeNode Node = new ZTypeNode(null, SourceToken, Type);
		this.SetLocalSymbol(Name, Node);
	}

	public final void SetTypeName(ZType Type, @Nullable ZToken SourceToken) {
		this.SetTypeName(Type.ShortName, Type, SourceToken);
	}

	public final ZTypeNode GetTypeNode(String TypeName, ZToken SourceToken) {
		@Var ZNode Node = this.GetSymbolNode(TypeName);
		if(Node instanceof ZTypeNode) {
			return (ZTypeNode)Node;
		}
		if(Node == null && SourceToken != null) {
			@Var ZType Type = new ZClassType(TypeName, ZType.VarType);
			this.GetRootNameSpace().SetTypeName(TypeName, Type, SourceToken);
			return this.GetTypeNode(TypeName, null/*don't create again*/);
		}
		return null;
	}

	public final ZType GetType(String TypeName, ZToken SourceToken) {
		@Var ZTypeNode TypeNode = this.GetTypeNode(TypeName, SourceToken);
		if(TypeNode != null) {
			return TypeNode.Type;
		}
		return null;
	}

}
