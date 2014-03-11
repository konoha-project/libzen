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

import zen.type.ZType;
import zen.util.Field;

public class ZParamNode extends ZLocalDefinedNode {
	public static final int _NameInfo = 0;
	public static final int _TypeInfo = 1;

	@Field public ZType   GivenType = null;
	@Field public String  GivenName = null;
	@Field public int     ParamIndex    = -1;

	public ZParamNode(ZNode ParentNode) {
		super(ParentNode, null, 2);
	}

	public ZParamNode(String Name, ZType DeclType) {
		super(null, null, 2);
		this.GivenName   = Name;
		this.GivenType   = DeclType;
	}

	public final ZType DeclType() {
		if(this.GivenType == null) {
			if(this.AST[ZParamNode._TypeInfo] != null) {
				this.GivenType = this.AST[ZParamNode._TypeInfo].Type;
			}
			else {
				this.GivenType = ZType.VarType;
			}
		}
		return this.GivenType;
	}

	public final void SetDeclType(ZType Type) {
		this.GivenType = Type;
	}

	public final String GetName() {
		if(this.GivenName == null) {
			this.GivenName = this.AST[ZParamNode._NameInfo].SourceToken.GetTextAsName();
		}
		return this.GivenName;
	}
}