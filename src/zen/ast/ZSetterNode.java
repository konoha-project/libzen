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
import zen.parser.ZToken;
import zen.parser.ZVisitor;

public final class ZSetterNode extends ZNode {
	public final static int _Recv = 0;
	public final static int _Expr = 1;

	@Field public String  FieldName = null;
	@Field public ZToken  NameToken = null;

	public ZSetterNode(ZNode ParentNode, ZNode RecvNode) {
		super(ParentNode, null, 2);
		this.Set(ZSetterNode._Recv, RecvNode);
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.FieldName = Name;
		this.NameToken = NameToken;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitSetterNode(this);
	}
	public final boolean IsStaticField() {
		return this.AST[ZSetterNode._Recv] instanceof ZTypeNode;
	}
}