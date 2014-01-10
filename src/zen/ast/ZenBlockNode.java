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

import zen.deps.Field;
import zen.parser.ZenNameSpace;
import zen.parser.ZenToken;
import zen.parser.ZenVisitor;

public class ZenBlockNode extends ZenNode {
	@Field public ArrayList<ZenNode> StatementList;
	@Field public ZenNameSpace NameSpace;
	public ZenBlockNode(ZenToken SourceToken, ZenNameSpace NameSpace) {
		super();
		this.SourceToken = SourceToken;
		this.StatementList = new ArrayList<ZenNode>();
		this.NameSpace = NameSpace;
	}
	@Override public void Append(ZenNode Node) {
		this.StatementList.add(this.SetChild(Node));
	}
	//	@Override public Object Eval(ZenNameSpace NameSpace, boolean EnforceConst)  {
	//		return null;
	//	}
	@Override public void Accept(ZenVisitor Visitor) {
		Visitor.VisitBlockNode(this);
	}

	@Override public ZenReturnNode ToReturnNode() {
		if(this.StatementList.size() == 1) {
			return this.StatementList.get(0).ToReturnNode();
		}
		return null;
	}

}