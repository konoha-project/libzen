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
import java.util.ArrayList;

import zen.type.ZType;
import zen.type.ZTypePool;

public class ZenArray<T> extends ArrayList<T> implements ZTypedObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4931064639290182147L;
	private final ZType ObjectType;
	private ZenArray(ZType ZType) {
		super();
		this.ObjectType = ZType == null ? zen.type.ZType.ArrayType : ZType;
	}

	public static <T> ZenArray<T> NewZenArray(ZType ElementType) {
		return new ZenArray<T>(ZTypePool.GetGenericType1(ZType.ArrayType, ElementType));
	}

	@Override public ZType GetZenType() {
		return this.ObjectType;
	}

	public ZenArray<T> SubArray(int BeginIndex, int EndIndex) {
		@Var ZenArray<T> ArrayObject = new ZenArray<T>(this.ObjectType);
		@Var int i = BeginIndex;
		while(i < EndIndex) {
			@Var T Value = this.get(i);
			ArrayObject.add(Value);
			i = i + 1;
		}
		return ArrayObject;
	}
	@Override public String toString() {
		@Var String s = "[";
		@Var int i = 0;
		while(i < this.size()) {
			@Var T Value = this.get(i);
			if(i > 0) {
				s += ", ";
			}
			s += LibZen.Stringify(Value);
			i = i + 1;
		}
		return s + "]";
	}
	//	public final static ZenArray<T> NewArray1(ZenType Type, int InitSize) {
	//		@Var ZenType ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, Type, true);
	//		@Var ZenArray ArrayObject =  new ZenArray(ArrayType);
	//		for(@Var int i = 0; i < InitSize; i++) {
	//			ArrayObject.add(null /*Type.DefaultNullValue*/);
	//		}
	//		return ArrayObject;
	//	}
	//	// new int[2][3]
	//	public final static ZenArray<T> NewArray2(ZenType Type, int InitSize, int InitSize2) {
	//		@Var ZenType ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, Type, true);
	//		ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ArrayType, true);
	//		@Var ZenArray<T> ArrayObject =  new ZenArray<T>(ArrayType);
	//		for(@Var int i = 0; i < InitSize2; i++) {
	//			ArrayObject.add(ZenArray.NewArray1(Type, InitSize));
	//		}
	//		return ArrayObject;
	//	}
	//	public final static ZenArray NewArray3(ZenType Type, int InitSize, int InitSize2, int InitSize3) {
	//		@Var ZenType ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, Type, true);
	//		ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ArrayType, true);
	//		ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ArrayType, true);
	//		@Var ZenArray ArrayObject =  new ZenArray(ArrayType);
	//		for(@Var int i = 0; i < InitSize2; i++) {
	//			ArrayObject.add(ZenArray.NewArray2(Type, InitSize, InitSize2));
	//		}
	//		return ArrayObject;
	//	}
	public final static <T> ZenArray<T> NewNewArray(ZType ArrayType, T[] Values) {
		@Var ZenArray<T> ArrayObject =  new ZenArray<T>(ArrayType);
		for(@Var int i = 0; i < Values.length; i++) {
			ArrayObject.add(Values[i]);
		}
		return ArrayObject;
	}
}


