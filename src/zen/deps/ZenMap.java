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

package zen.deps;

import java.util.HashMap;
import java.util.Iterator;

import zen.type.ZType;

public final class ZenMap <T> implements ZenTypedObject {
	final ZType ElementType;
	final HashMap<String, T>	Map;

	public ZenMap(ZType ElementType) {
		this.Map = new HashMap<String, T>();
		//JavaTypeTable.GetZenType(T.class);
		this.ElementType = ElementType;
	}

	public final void put(String Key, T Value) {
		this.Map.put(Key, Value);
	}

	public final T GetOrNull(String Key) {
		return this.Map.get(Key);
	}

	public Iterator<String> key_iterator() { // FIXME
		return this.Map.keySet().iterator();
	}

	@Override public ZType GetZenType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void AddMap(ZenMap<Object> aMap) {
		throw new RuntimeException("unimplemented !!");
	}
}
//endif VAJA