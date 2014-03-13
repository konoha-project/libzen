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

package zen.util;

import java.util.HashMap;

public final class ZObjectMap extends ZObject {
	final HashMap<String, Object>	Map;

	public ZObjectMap(int TypeId, Object[] Literal) {
		super(TypeId);
		this.Map = new HashMap<String, Object>();
		@Var int i = 0;
		while(i < Literal.length) {
			this.Map.put(Literal[i].toString(), Literal[i+1]);
			i = i + 2;
		}
	}

	@Override protected void Stringfy(StringBuilder sb) {
		@Var int i = 0;
		sb.append("{");
		for(String Key : this.Map.keySet()) {
			if(i > 0) {
				sb.append(", ");
			}
			this.AppendStringBuffer(sb, Key, this.Map.get(Key));
			i = i + 1;
		}
		sb.append("}");
	}

	public final Object Remove(String Key) {
		return this.Map.remove(Key);
	}

	public void AddMap(ZObjectMap aMap) {
		throw new RuntimeException("unimplemented !!");
	}

	public final static Object GetIndex(ZObjectMap aMap, String Key) {
		return aMap.Map.get(Key);
	}

	public final static void SetIndex(ZObjectMap aMap, String Key, Object Value) {
		aMap.Map.put(Key, Value);
	}

	public boolean ContainsKey(String Key) {
		return this.Map.containsKey(Key);
	}
}
