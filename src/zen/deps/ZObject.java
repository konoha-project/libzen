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
package zen.deps;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import zen.type.ZType;
import zen.type.ZTypePool;


public class ZObject implements ZTypedObject {
	protected ZType ZenType;

	protected ZObject(int TypeId) {
		this.ZenType = ZTypePool.TypeOf(TypeId);
	}
	@Override public final ZType GetZenType() {
		return this.ZenType;
	}

	private void AppendStringBuffer(StringBuilder sb, String Name) {
		if(Name != null) {
			sb.append(LibZen._QuoteString(Name));
			sb.append(": ");
		}
	}

	public void AppendStringBuffer(StringBuilder sb, Object Value) {
		this.AppendStringBuffer(sb, null, Value);
	}

	public void AppendStringBuffer(StringBuilder sb, String Key, Object Value) {
		if(Value instanceof ZObject) {
			this.AppendStringBuffer(sb, Key);
			((ZObject)Value).Stringfy(sb);
		}
		else if(Value instanceof String) {
			this.AppendStringBuffer(sb, Key);
			sb.append(LibZen._QuoteString(Value.toString()));
		}
		else if(Value instanceof Number || Value instanceof Boolean || Value == null) {
			this.AppendStringBuffer(sb, Key);
			sb.append(Value);
		}
	}

	protected void Stringfy(StringBuilder sb) {
		sb.append("{");
		Field[] Fields = this.getClass().getFields();
		for(int i = 0; i < Fields.length; i++) {
			if(Modifier.isPublic(Fields[i].getModifiers())) {
				if(i > 0) {
					sb.append(", ");
				}
				try {
					Object Value =  Fields[i].get(this);
					if(ZFunction.class.isAssignableFrom(Fields[i].getType())) {
						//						sb.append(Fields[i].getName());
						//						sb.append(": ");
						//						sb.append(Value);
						//						continue;
					}
					this.AppendStringBuffer(sb, Fields[i].getName(), Value);
				} catch (Exception e) {
					break;
				}
			}
		}
		sb.append("}");
	}

	@Override public final String toString() {
		@Var StringBuilder sb = new StringBuilder();
		this.Stringfy(sb);
		return sb.toString();
	}
}
