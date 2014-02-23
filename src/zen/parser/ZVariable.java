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

package zen.parser;

import zen.ast.ZFunctionNode;
import zen.deps.Field;
import zen.type.ZType;

public final class ZVariable extends ZSymbolEntry {
	@Field public int     VarFlag;
	@Field public ZType	  VarType;
	@Field public String  VarName;
	@Field public int     VarUniqueIndex;
	@Field public ZToken  SourceToken;
	@Field public int     DefCount;
	@Field public int     UsedCount;

	ZVariable(ZSymbolEntry Parent, ZFunctionNode FuncNode, int VarFlag, ZType VarType, String VarName, ZToken SourceToken) {
		super(Parent, FuncNode);
		this.VarFlag = VarFlag;
		this.VarType = VarType;
		this.VarName = VarName;
		this.SourceToken = SourceToken;
		this.VarUniqueIndex = FuncNode.GetVarIndex();
		this.UsedCount = 0;
		this.DefCount  = 1;
	}

	public final boolean IsCaptured(ZFunctionNode CurrentFunctionNode) {
		if(CurrentFunctionNode == this.Node) {
			return false;
		}
		return true;
	}

	public final void Defined() {
		this.DefCount = this.DefCount + 1;
	}

	public final void Used() {
		this.UsedCount = this.UsedCount + 1;
	}

}
