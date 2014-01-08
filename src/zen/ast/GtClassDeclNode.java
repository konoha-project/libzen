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
import zen.parser.ZenNameSpace;
import zen.parser.ZenToken;

final public class GtClassDeclNode extends ZenNode {
	/*field*/public ZenType ClassType;
	/*field*/public ZenNameSpace NameSpace;
	/*field*/public ArrayList<ZenNode>  FieldList;
	/*field*/public ArrayList<ZenNode>  MemberList;
	public GtClassDeclNode/*constructor*/(ZenToken SourceToken, ZenNameSpace NameSpace, ZenType ClassType) {
		super(); this.SourceToken = SourceToken; // TODO
		this.NameSpace = NameSpace;
		this.ClassType = ClassType;
		this.FieldList = new ArrayList<ZenNode>();
		this.MemberList = new ArrayList<ZenNode>();
	}
	@Override public void Append(ZenNode Node) {
		if(Node instanceof GtFuncDeclNode) {
			this.MemberList.add(Node);
		}
		if(Node instanceof GtFieldNode) {
			this.FieldList.add(Node);
		}
	}
//	@Override public boolean Accept(GtVisitor Visitor) {
//		Visitor.VisitClassDeclNode(this);
//	}
}