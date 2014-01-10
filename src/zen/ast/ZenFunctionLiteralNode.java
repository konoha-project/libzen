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

package zen.ast;

import java.util.ArrayList;

import zen.lang.ZenType;
import zen.lang.ZenSystem;
import zen.parser.ZenToken;
import zen.parser.ZenVisitor;

public class ZenFunctionLiteralNode extends ZenNode {
	/*field*/public ZenType ReturnType;
	/*field*/public ArrayList<ZenNode>  ArgumentList;  // list of ParamNode
	/*field*/public ZenNode BodyNode;
	public ZenFunctionLiteralNode/*constructor*/(ZenToken Token) {
		super();
		this.SourceToken = Token;
		this.ReturnType = ZenSystem.VarType;
		this.ArgumentList = new ArrayList<ZenNode>();
		this.BodyNode = null;
	}
	@Override public void Append(ZenNode Node) {
		if(Node instanceof ZenParamNode) {
			this.ArgumentList.add(Node);
		}
		else if(Node instanceof ZenTypeNode) {
			this.ReturnType = Node.Type;
		}		
		else if(Node instanceof ZenBlockNode) {
			this.BodyNode = Node;
		}
		/*return this;*/
	}
	@Override public void Accept(ZenVisitor Visitor) {
		Visitor.VisitFunctionLiteralNode(this);
	}
}