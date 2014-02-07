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

import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZType;

public abstract class ZNode {
	public final static int Nop =      -1;
	public final static int NameInfo = -2;
	public final static int TypeInfo = -3;
	public final static int AppendIndex = -4;
	public final static int NestedAppendIndex = -5;

	@Field public ZNode ParentNode;
	@Field public ZToken SourceToken;
	@Field public ZType	Type = ZType.VarType;
	@Field public ZNode  AST[];

	public ZNode(ZNode ParentNode, ZToken SourceToken, int Size) {
		assert(this != ParentNode);
		this.ParentNode = ParentNode;
		this.SourceToken = SourceToken;
		if(Size > 0) {
			this.AST = new ZNode[Size];
		}
		else {
			this.AST = null;
		}
	}

	public final ZNode SetChild(ZNode Node) {
		assert(Node != null);
		if(Node != null) {
			assert(this != Node);
			Node.ParentNode = this;
		}
		return Node;
	}

	public void SetName(String Name) {
		assert(Name == null);  // Set SetName in a sub class property
	}

	public void SetType(ZType Type) {
		this.Type = Type;  // default behavior
	}

	public final void Set(int Index, ZNode Node) {
		if(Index >= 0) {
			this.AST[Index] = Node;
		}
		else if(Index == ZNode.AppendIndex) {
			@Var ZNode ListNode = this;
			if(ListNode instanceof ZListNode) {
				((ZListNode)ListNode).Append(Node);
			}
			else {
				System.out.println("parent=" + ListNode + ", node=" + Node);
				assert(ListNode instanceof ZListNode);
			}
		}
		else if(Index == ZNode.NameInfo) {
			this.SetName(Node.SourceToken.GetText());
			this.SourceToken = Node.SourceToken;
		}
		else if(Index == ZNode.TypeInfo) {
			this.SetType(Node.Type);
		}
	}

	@Override public String toString() {
		@Var String Self = "#" + this.getClass().getSimpleName();
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
					Self = Self + this.AST[i].toString();
				}
				i = i + 1;
			}
			Self = Self + "]";
		}
		return Self;

	}

	public boolean IsErrorNode() {
		return (this instanceof ZErrorNode);
	}

	public boolean IsBreakingBlock() {
		return false;
	}

	public String GetVisitName() {
		return "VisitExtendedNode"; // override this if you want to use additional node
	}

	//	public abstract boolean Accept(ZenVisitor Visitor);
	public void Accept(ZVisitor Visitor) {
		LibNative.DispatchVisitNode(Visitor, this);
	}

	public final boolean IsVarType() {
		return this.Type.IsVarType();
	}

	public boolean IsUntyped() {
		return this.Type.IsVarType();
	}

	public ZReturnNode ToReturnNode() {
		return null;
	}

	public final ZBlockNode GetScopeBlockNode() {
		ZNode Node = this;
		while(Node != null) {
			if(Node instanceof ZBlockNode) {
				return (ZBlockNode)Node;
			}
			if(Node == Node.ParentNode) {
				throw new RuntimeException("serious error: parent node is same: " + Node);
			}
			Node = Node.ParentNode;
		}
		return null;
	}

	public final ZNameSpace GetNameSpace() {
		ZBlockNode BlockNode = this.GetScopeBlockNode();
		return BlockNode.NameSpace;
	}

	public final ZNode GetPrevNode() {
		if(this.ParentNode == null) {
			return null;
		}
		if(this.ParentNode instanceof ZBlockNode) {
			ZBlockNode Block = (ZBlockNode) this.ParentNode;
			for (int i = 1; i < Block.GetListSize(); i++) {
				if(Block.GetListAt(i) == this) {
					return Block.GetListAt(i-1);
				}
			}
		}
		return null;
	}

	public ZNode GetNextNode() {
		if(this.ParentNode == null) {
			return null;
		}
		if(this.ParentNode instanceof ZBlockNode) {
			ZBlockNode Block = (ZBlockNode) this.ParentNode;
			for (int i = 0; i < Block.GetListSize() - 1; i++) {
				if(Block.GetListAt(i) == this) {
					return Block.GetListAt(i+1);
				}
			}
		}
		return null;
	}

}

