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

package zen.lang;

import zen.ast.ZenNode;
import zen.deps.Field;

public class ZenVarType extends ZenType {
	@Field public ZenNode SourceNode; // to remember
	@Field private boolean FoundTypeError;

	public ZenVarType(String ShortName) {
		super(0, ShortName, ZenSystem.VarType);
		this.FoundTypeError = false;
	}

	@Override public final ZenType GetRealType() {
		return this.RefType;
	}

	public void TypeCheckNode(ZenNode SourceNode) {
		if(!SourceNode.Type.IsVarType()) {
			if(this.SourceNode == null) {
				this.RefType = SourceNode.Type;
				this.SourceNode = SourceNode;
			}
			else {
				if(!this.Accept(SourceNode.Type)) {
					this.FoundTypeError = true;
				}
			}
		}
	}

	@Override public boolean IsFoundTypeError() {
		return this.FoundTypeError;
	}

	@Override public int GetParamSize() {
		return this.RefType.GetParamSize();
	}

	@Override
	public ZenType GetParamType(int Index) {
		return this.RefType.GetParamType(Index);
	}

	@Override
	public boolean IsFuncType() {
		return this.RefType.IsFuncType();
	}

}
