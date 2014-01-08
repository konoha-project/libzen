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
import zen.deps.LibNative;
import zen.lang.ZenType;
import zen.parser.ZenNameSpace;
import zen.parser.ZenToken;
import zen.parser.ZenVisitor;

public abstract class ZenNode {
	/*field*/public ZenNode	ParentNode;
	/*field*/public ZenType	Type;
	/*field*/public ZenToken	SourceToken;

	public ZenNode() {
		this.Type = null;
		this.SourceToken = null;
		this.ParentNode = null;
	}

	public final boolean IsErrorNode() {
		return (this instanceof GtErrorNode);
	}

	public final ZenNode SetChild(ZenNode Node) {
		assert(Node != null);
		if(Node != null) {
			assert(this != Node);
			Node.ParentNode = this;
		}
		return Node;
	}

	public void Append(ZenNode Node) {

	}

	public final ZenNode Done() {
		return new GtBlockNode(this.SourceToken, null);
	}

	public String GetVisitName() {
		return "VisitNode"; // override this if you want to use additional node
	}

	//	public abstract boolean Accept(GtVisitor Visitor);
	public void Accept(ZenVisitor Visitor) {
		LibNative.DispatchVisitNode(Visitor, this);
	}

	public GtConstNode ToConstNode(boolean EnforceConst) {
		if(EnforceConst) {
			return new GtErrorNode(this.SourceToken, "value must be constant");
		}
		return null;
	}
	public Object Eval(ZenNameSpace NameSpace, boolean EnforceConst)  {
		return null;
		//return this.ToNullValue(NameSpace, EnforceConst);
	}


	public GtReturnNode ToReturnNode() {
		return null;
	}

}

