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

import java.util.ArrayList;

import zen.ast.ZNode;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.type.ZType;
import zen.type.ZTypeFlag;

public class ZenClassType extends ZType {
	@Field ArrayList<ZenField> FieldList = null;
	public ZenClassType(String ShortName, ZType RefType) {
		super(ZTypeFlag.OpenType|ZTypeFlag.UniqueType, ShortName, RefType);
		if(RefType instanceof ZenClassType) {
			this.ResetSuperType((ZenClassType)RefType);
		}
	}

	public void ResetSuperType(ZenClassType SuperClass) {
		this.RefType = SuperClass;
		if(SuperClass.FieldList != null) {
			this.FieldList = new ArrayList<ZenField>();
			@Var int i = 0;
			while(i < SuperClass.FieldList.size()) {
				@Var ZenField Field = SuperClass.FieldList.get(i);
				this.FieldList.add(Field);
				i = i + 1;
			}
		}
	}

	public boolean HasField(String FieldName) {
		if(this.FieldList != null) {
			@Var int i = 0;
			while(i < this.FieldList.size()) {
				if(LibZen.EqualsString(FieldName, this.FieldList.get(i).FieldName)) {
					return true;
				}
				i = i + 1;
			}
		}
		return false;
	}

	public ZType GetFieldType(String FieldName, ZType Type) {
		if(this.FieldList != null) {
			@Var int i = 0;
			while(i < this.FieldList.size()) {
				@Var ZenField Field = this.FieldList.get(i);
				if(LibZen.EqualsString(FieldName, Field.FieldName)) {
					return Field.FieldType;
				}
				i = i + 1;
			}
		}
		return Type;
	}

	public ZenField AppendField(ZType FieldType, String FieldName, ZToken SourceToken) {
		if(this.FieldList == null) {
			this.FieldList = new ArrayList<ZenField>();
		}
		@Var int i = 0;
		while(i < this.FieldList.size()) {
			@Var ZenField Field = this.FieldList.get(i);
			if(LibZen.EqualsString(FieldName, Field.FieldName)) {
				if(FieldType.Equals(Field.FieldType)) {
					return null;
				}
				return Field; // failed
			}
			i = i + 1;
		}
		this.FieldList.add(new ZenField(this, FieldName, FieldType, SourceToken));
		return null;
	}

	public ZNode CheckAllFields(ZNameSpace NameSpace) {
		// TODO Auto-generated method stub

		return null;  // if no error
	}


}
