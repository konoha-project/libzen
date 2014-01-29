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
import zen.lang.ZSystem;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZType;

public abstract class ZNode {
	@Field public ZNode	ParentNode = null;
	@Field public ZType	Type = ZSystem.VarType;
	@Field public ZToken	SourceToken = null;

	public final ZNode SetChild(ZNode Node) {
		assert(Node != null);
		if(Node != null) {
			assert(this != Node);
			Node.ParentNode = this;
		}
		return Node;
	}

	@Override public String toString() {
		return "#" + this.getClass().getSimpleName() + ", Source=" + this.SourceToken;
	}

	public boolean IsErrorNode() {
		return (this instanceof ZErrorNode);
	}

	public boolean IsBreakingBlock() {
		return false;
	}

	public ZNode GetStatementNode() {
		return this;  // ZenAnnotationNode should return AnnotatedNode;
	}

	public void Append(ZNode Node) {

	}

	public final ZNode Done() {
		return new ZEmptyNode(null);
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

	public ZConstNode ToConstNode(boolean EnforceConst) {
		if(EnforceConst) {
			return new ZErrorNode(this.SourceToken, "value must be constant");
		}
		return null;
	}
	public Object Eval(ZNameSpace NameSpace, boolean EnforceConst)  {
		return null;
		//return this.ToNullValue(NameSpace, EnforceConst);
	}

	public ZReturnNode ToReturnNode() {
		return null;
	}

	public ZNode GetPrevNode() {
		if(this.ParentNode == null) {
			return null;
		}
		if(this.ParentNode instanceof ZBlockNode) {
			ZBlockNode Block = (ZBlockNode) this.ParentNode;
			for (int i = 1; i < Block.StmtList.size(); i++) {
				if(Block.StmtList.get(i) == this) {
					return Block.StmtList.get(i-1);
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
			for (int i = 0; i < Block.StmtList.size() - 1; i++) {
				if(Block.StmtList.get(i) == this) {
					return Block.StmtList.get(i+1);
				}
			}
		}
		return null;
	}

}

