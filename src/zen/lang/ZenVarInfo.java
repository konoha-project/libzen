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

import zen.deps.Field;
import zen.parser.ZenNameSpace;
import zen.parser.ZenToken;
import zen.parser.ZenUtils;

public class ZenVarInfo {
	@Field public ZenDefiningFunc  DefiningFunc;
	@Field public int      VarFlag;
	@Field public ZenType	 VarType;
	@Field public String	 VarName;
	@Field public String	 NativeName;
	@Field public ZenToken SourceToken;
	//	@Field public Object   InitValue;
	@Field public int      DefCount;
	@Field public int      UsedCount;

	ZenVarInfo(ZenDefiningFunc DefiningFunc, int VarFlag, ZenType VarType, String VarName, ZenToken SourceToken) {
		this.DefiningFunc    = DefiningFunc;
		this.VarFlag = VarFlag;
		this.VarType = VarType;
		this.VarName = VarName;
		this.SourceToken = SourceToken;
		this.NativeName = ZenUtils.NativeVariableName(VarName, this.DefiningFunc.GetVarIndex());
		//		this.InitValue = null;
		this.UsedCount = 0;
		this.DefCount  = 1;
	}

	public final boolean IsCaptured(ZenNameSpace NameSpace) {
		return (NameSpace.GetDefiningFunc() != this.DefiningFunc);
	}

	public final void Defined() {
		this.DefCount += 1;
	}

	public final void Used() {
		this.UsedCount += 1;
	}

	// for debug
	@Override public String toString() {
		return "(" + this.VarType + " " + this.VarName + ", " + this.NativeName + ")";
	}

}