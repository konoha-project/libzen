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

import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZType;
import zen.util.Field;

public final class ZVarNode extends ZBlockNode {
	public final static int _InitValue = 0;

	@Field public ZType   DeclType = ZType.VarType;
	@Field public String  NativeName = null;
	@Field public int VarIndex = -1;

	@Field public ZToken  TypeToken = null;
	@Field public ZToken  NameToken = null;

	public ZVarNode(ZNode ParentNode) {
		super(ParentNode, 1);
	}

	public ZVarNode(String Name, ZType DeclType, ZNode InitNode) {
		super(null, 1);
		this.NativeName = Name;
		this.DeclType = DeclType;
		this.SetNode(ZVarNode._InitValue, InitNode);
	}

	public final ZNode InitValueNode() {
		if(this.AST[ZVarNode._InitValue] == null) {
			this.SetNode(ZVarNode._InitValue, new ZDefaultValueNode());
		}
		return this.AST[ZVarNode._InitValue];
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.NativeName = Name;
		this.NameToken = NameToken;
	}

	@Override public void SetTypeInfo(ZToken TypeToken, ZType Type) {
		this.DeclType  = Type;
		this.TypeToken = TypeToken;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitVarNode(this);
	}

}