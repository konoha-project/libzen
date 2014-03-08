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

import zen.ast.sugar.ZLocalDefinedNode;
import zen.parser.ZToken;
import zen.type.ZClassType;
import zen.type.ZType;
import zen.util.Field;

public final class ZFieldNode extends ZLocalDefinedNode {
	public final static int    _InitValue = 0;

	@Field public  ZClassType  ClassType;
	@Field public ZType  DeclType = ZType.VarType;

	@Field public String FieldName = null;
	@Field public ZToken NameToken = null;

	public ZFieldNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	public final ZNode InitValueNode() {
		if(this.AST[ZFieldNode._InitValue] == null) {
			this.Set(ZFieldNode._InitValue, new ZDefaultValueNode());
		}
		return this.AST[ZFieldNode._InitValue];
	}


	@Override public void SetTypeInfo(ZToken TypeToken, ZType Type) {
		this.DeclType = Type;
	}
	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.FieldName = Name;
		this.NameToken = NameToken;
	}
}