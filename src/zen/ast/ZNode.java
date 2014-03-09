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
package zen.ast;

import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZenMethod;

public abstract class ZNode {
	public final static int _Nop =      -1;
	public final static int _NameInfo = -2;
	public final static int _TypeInfo = -3;
	public final static int _AppendIndex = -4;
	public final static int _NestedAppendIndex = -5;

	@Field public ZNode ParentNode;
	@Field public ZToken SourceToken;
	@Field public ZNode  AST[];
	@Field public ZType	Type = ZType.VarType;
	@Field public boolean HasUntypedNode = true;

	public ZNode(ZNode ParentNode, ZToken SourceToken, int Size) {
		assert(this != ParentNode);
		this.ParentNode = ParentNode;
		this.SourceToken = SourceToken;
		if(Size > 0) {
			this.AST = LibZen._NewNodeArray(Size);
		}
		else {
			this.AST = null;
		}
	}

	public final ZNode SetChild(ZNode Node) {
		assert(this != Node);
		Node.ParentNode = this;
		return Node;
	}

	@ZenMethod public void SetNameInfo(ZToken NameToken, String Name) {
		assert(Name == null);  // Set SetName in a sub class property
	}

	@ZenMethod public void SetTypeInfo(ZToken TypeToken, ZType Type) {
		this.Type = Type;  // default behavior
	}

	public final void SetNode(int Index, ZNode Node) {
		if(Index >= 0) {
			this.AST[Index] = this.SetChild(Node);
		}
		else if(Index == ZNode._AppendIndex) {
			@Var ZNode ListNode = this;
			if(ListNode instanceof ZListNode) {
				((ZListNode)ListNode).Append(Node);
			}
			else {
				assert(ListNode instanceof ZListNode);
			}
		}
		else if(Index == ZNode._NameInfo) {
			this.SetNameInfo(Node.SourceToken, Node.SourceToken.GetText());
			this.SourceToken = Node.SourceToken;
			return;
		}
		else if(Index == ZNode._TypeInfo) {
			this.SetTypeInfo(Node.SourceToken, Node.Type);
			return;
		}
	}

	public final int GetAstSize() {
		if(this.AST == null) {
			return 0;
		}
		return this.AST.length;
	}

	public final ZToken GetAstToken(int Index) {
		if(this.AST[Index] != null) {
			return this.AST[Index].SourceToken;
		}
		return null;
	}

	public final ZType GetAstType(int Index) {
		return this.AST[Index].Type.GetRealType();
	}

	public final String GetSourceLocation() {
		if(this.SourceToken != null) {
			return "(" + this.SourceToken.GetFileName() + ":" + this.SourceToken.GetLineNumber() + ")";
		}
		return null;
	}

	@Override public String toString() {
		@Var String Self = "#" + LibZen._GetClassName(this);
		if(!this.Type.IsVarType()) {
			Self = Self + ":" + this.Type;
		}
		else {
			Self = Self + ":?";
		}
		if(this.AST != null) {
			@Var int i = 0;
			Self = Self + "[";
			while(i < this.AST.length) {
				if(i > 0) {
					Self = Self + ",";
				}
				if(this.AST[i] == null) {
					Self = Self + "null";
				}
				else {
					if(this.AST[i].ParentNode == this) {
						Self = Self + this.AST[i].toString();
					}
					else {
						Self = Self + "*" + LibZen._GetClassName(this.AST[i])+"*";
					}
				}
				i = i + 1;
			}
			Self = Self + "]";
		}
		return Self;
	}

	public final ZBlockNode GetScopeBlockNode() {
		@Var int SafeCount = 0;
		@Var ZNode Node = this;
		while(Node != null) {
			if(Node instanceof ZBlockNode) {
				return (ZBlockNode)Node;
			}
			assert(!(Node == Node.ParentNode));
			//System.out.println("node: " + Node.getClass() + ", " + Node.hashCode() + ", " + SafeCount);
			Node = Node.ParentNode;
			SafeCount = SafeCount + 1;
			assert(SafeCount < 10);
		}
		return null;
	}

	public final ZNameSpace GetNameSpace() {
		@Var int SafeCount = 0;
		@Var ZBlockNode BlockNode = this.GetScopeBlockNode();
		while(BlockNode.NullableNameSpace == null) {
			@Var ZBlockNode ParentBlockNode = BlockNode.ParentNode.GetScopeBlockNode();
			assert(!(BlockNode == ParentBlockNode));
			//System.out.println("pnode: " + ParentBlockNode.getClass() + ", " + ParentBlockNode.hashCode() + ", " + SafeCount);
			//System.out.println("node: " + BlockNode.getClass() + ", " + BlockNode.hashCode() + ", " + SafeCount);
			BlockNode = ParentBlockNode;
			//			System.out.println("node:" + BlockNode);
			SafeCount = SafeCount + 1;
			assert(SafeCount < 100);
		}
		return BlockNode.NullableNameSpace;
	}

	public final boolean IsErrorNode() {
		return (this instanceof ZErrorNode);
	}

	@ZenMethod public boolean IsBreakingBlock() {
		return false;
	}

	public abstract void Accept(ZVisitor Visitor);

	public final boolean IsUntyped() {
		return !(this.Type instanceof ZFuncType) && this.Type.IsVarType();
	}

	public final boolean HasUntypedNode() {
		if(this.HasUntypedNode) {
			if(!this.IsUntyped()) {
				@Var int i = 0;
				while(i < this.GetAstSize()) {
					if(this.AST[i] != null && this.AST[i].HasUntypedNode()) {
						return true;
					}
					i = i + 1;
				}
				this.HasUntypedNode = false;
				return false;
			}
		}
		return this.HasUntypedNode;
	}

	public ZReturnNode ToReturnNode() {
		return null;
	}

	//	@Deprecated public final ZNode GetPrevNode() {
	//		if(this.ParentNode == null) {
	//			return null;
	//		}
	//		if(this.ParentNode instanceof ZBlockNode) {
	//			@Var ZBlockNode Block = (ZBlockNode) this.ParentNode;
	//			for (int i = 1; i < Block.GetListSize(); i++) {
	//				if(Block.GetListAt(i) == this) {
	//					return Block.GetListAt(i-1);
	//				}
	//			}
	//		}
	//		return null;
	//	}
	//
	//	@Deprecated public ZNode GetNextNode() {
	//		if(this.ParentNode == null) {
	//			return null;
	//		}
	//		if(this.ParentNode instanceof ZBlockNode) {
	//			@Var ZBlockNode Block = (ZBlockNode) this.ParentNode;
	//			for (int i = 0; i < Block.GetListSize() - 1; i++) {
	//				if(Block.GetListAt(i) == this) {
	//					return Block.GetListAt(i+1);
	//				}
	//			}
	//		}
	//		return null;
	//	}

}

