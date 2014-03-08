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
import zen.type.ZFunc;
import zen.type.ZType;
import zen.util.Field;

public class ZGetNameNode extends ZNode {
	@Field public boolean IsCaptured = false;
	@Field public String  VarName;
	@Field public int VarIndex = 0;

	public ZGetNameNode(ZNode ParentNode, ZToken Token, String NativeName) {
		super(ParentNode, Token, 0);
		this.VarName = NativeName;
	}

	public ZGetNameNode(ZNode ParentNode, ZFunc ResolvedFunc) {
		super(ParentNode, null, 0);
		this.VarName = ResolvedFunc.FuncName;
		this.Type = ResolvedFunc.GetFuncType();
	}

	public ZGetNameNode(String Name, ZType Type) {
		super(null, null, 0);
		this.VarName = Name;
		this.Type = Type;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitGetNameNode(this);
	}

	public final ZNode ToGlobalNameNode() {
		return new ZGlobalNameNode(this.ParentNode, this.SourceToken, this.Type, this.VarName, false);
	}
}