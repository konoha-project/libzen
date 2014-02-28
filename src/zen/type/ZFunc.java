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

//ifdef JAVA
package zen.type;
import zen.deps.Field;

public abstract class ZFunc {
	public final static String _NativeNameConnector = "__";
	public final static int _ConverterFunc       = 1 << 16;
	public final static int _CoercionFunc        = (1 << 17) | ZFunc._ConverterFunc;  //@Coercion

	@Field public int			  FuncFlag;
	@Field public String		  FuncName;  // NativeReferenceNamr
	@Field public ZFuncType       FuncType;

	public ZFunc(int FuncFlag, String FuncName, ZFuncType FuncType) {
		this.FuncFlag = FuncFlag;
		this.FuncName = FuncName;
		this.FuncType = FuncType;
	}

	public final ZFuncType GetFuncType() {
		return this.FuncType;
	}

	@Override public final String toString() {
		return this.FuncName + ": " + this.FuncType;
	}

	//	public final boolean IsConverterFunc() {
	//		return LibZen._IsFlag(this.FuncFlag, ZFunc._ConverterFunc);
	//	}
	//	public final boolean IsCoercionFunc() {
	//		return LibZen._IsFlag(this.FuncFlag, ZFunc._CoercionFunc);
	//	}
	//
	//	protected final boolean Is(int Flag) {
	//		return LibZen._IsFlag(this.FuncFlag, Flag);
	//	}

	public static String _StringfySignature(String FuncName, int FuncParamSize, ZType RecvType) {
		return FuncName + "__" + FuncParamSize + RecvType.GetUniqueName();
	}

	public final String GetSignature() {
		return this.FuncType.StringfySignature(this.FuncName);
	}
}
