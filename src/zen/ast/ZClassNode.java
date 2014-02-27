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

import zen.deps.Field;
import zen.deps.Var;
import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZClassType;
import zen.type.ZType;

public final class ZClassNode extends ZListNode {

	@Field public boolean IsExport = false;
	@Field public String ClassName = null;
	@Field public ZClassType ClassType = null;
	@Field public ZType SuperType = null;
	@Field public ZToken NameToken = null;
	@Field public ZToken SuperToken = null;

	public ZClassNode(ZNode ParentNode) {
		super(ParentNode, null, 0);
	}

	@Override public void SetTypeInfo(ZToken TypeToken, ZType Type) {
		this.SuperType = Type;
		this.SuperToken = TypeToken;
	}
	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.ClassName = Name;
		this.NameToken = NameToken;
	}
	public final ZFieldNode GetFieldNode(int Index) {
		@Var ZNode Node = this.GetListAt(Index);
		if(Node instanceof ZFieldNode) {
			return (ZFieldNode)Node;
		}
		return null;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitClassNode(this);
	}
}