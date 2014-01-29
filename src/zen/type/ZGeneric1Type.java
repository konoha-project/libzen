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

package zen.type;

import zen.deps.Field;
import zen.deps.Nullable;
import zen.lang.ZSystem;

public class ZGeneric1Type extends ZType {
	@Field public ZType			BaseType;
	@Field public ZType         ParamType;

	public ZGeneric1Type(int TypeFlag, String ShortName, @Nullable ZType BaseType, ZType ParamType) {
		super(TypeFlag, ShortName, ZSystem.TopType);
		this.BaseType = BaseType;
		if(this.BaseType == null) {
			this.BaseType = this;
		}
		this.ParamType = ParamType;
	}

	@Override public ZType GetSuperType() {
		return this.BaseType == this ? this.RefType : this.BaseType;
	}

	@Override public ZType GetBaseType() {
		return this.BaseType;
	}

	@Override public int GetParamSize() {
		return 1;
	}

	@Override public ZType GetParamType(int Index) {
		if(Index == 0) {
			return this.ParamType;
		}
		return null;
	}

	@Override public boolean IsGreekType() {
		return (this.ParamType.IsGreekType());
	}

	@Override public final ZType GetRealType(ZType[] Greek) {
		if(this.ParamType.IsGreekType()) {
			return ZSystem.GetGenericType1(this.BaseType, this.ParamType.GetRealType(Greek), true);
		}
		return this.GetRealType();
	}

	@Override public final boolean AcceptValueType(ZType ValueType, boolean ExactMatch, ZType[] Greek) {
		if(this.BaseType == ValueType.GetBaseType() && ValueType.GetParamSize() == 1) {
			return this.ParamType.AcceptValueType(ValueType.GetParamType(0), true, Greek);
		}
		return false;
	}

}
