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
import zen.lang.ZType;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.parser.ZVisitor;

public abstract class ZenNode {
	@Field public ZenNode	ParentNode;
	@Field public ZType	Type;
	@Field public ZToken	SourceToken;

	public ZenNode() {
		this.Type = ZSystem.VarType;
		this.SourceToken = null;
		this.ParentNode = null;
	}

	public final ZenNode SetChild(ZenNode Node) {
		assert(Node != null);
		if(Node != null) {
			assert(this != Node);
			Node.ParentNode = this;
		}
		return Node;
	}

	public boolean IsErrorNode() {
		return (this instanceof ZenErrorNode);
	}

	public boolean IsBreakingBlock() {
		return false;
	}

	public ZenNode GetStatementNode() {
		return this;  // ZenAnnotationNode should return AnnotatedNode;
	}

	public void Append(ZenNode Node) {

	}

	public final ZenNode Done() {
		return new ZenEmptyNode(null);
	}

	public String GetVisitName() {
		return "VisitNode"; // override this if you want to use additional node
	}

	//	public abstract boolean Accept(ZenVisitor Visitor);
	public void Accept(ZVisitor Visitor) {
		LibNative.DispatchVisitNode(Visitor, this);
	}

	public boolean IsUntyped() {
		return this.Type.IsVarType();
	}

	public ZenConstNode ToConstNode(boolean EnforceConst) {
		if(EnforceConst) {
			return new ZenErrorNode(this.SourceToken, "value must be constant");
		}
		return null;
	}
	public Object Eval(ZNameSpace NameSpace, boolean EnforceConst)  {
		return null;
		//return this.ToNullValue(NameSpace, EnforceConst);
	}


	public ZenReturnNode ToReturnNode() {
		return null;
	}


}

