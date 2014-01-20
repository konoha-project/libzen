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
package zen.obsolete;

import zen.deps.Field;
import zen.lang.ZenFunc;
import zen.lang.ZenType;
import zen.parser.ZUtils;


public class ZenFieldInfo extends ZUtils {
	@Field public int     FieldFlag;
	@Field public int     FieldIndex;
	@Field public ZenType	Type;
	@Field public String	Name;
	@Field public String	NativeName;
	@Field public Object  InitValue;
	@Field public ZenFunc	GetterFunc;
	@Field public ZenFunc	SetterFunc;

	ZenFieldInfo/*constructor*/(int FieldFlag, ZenType Type, String Name, int FieldIndex, Object InitValue) {
		this.FieldFlag = FieldFlag;
		this.Type = Type;
		this.Name = Name;
		this.NativeName = Name; // use this in a generator
		this.FieldIndex = FieldIndex;
		this.InitValue = InitValue;
		this.GetterFunc = null;
		this.SetterFunc = null;
	}
}
