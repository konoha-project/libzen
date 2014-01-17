//// ***************************************************************************
//// Copyright (c) 2013, JST/CREST DEOS project authors. All rights reserved.
//// Redistribution and use in source and binary forms, with or without
//// modification, are permitted provided that the following conditions are met:
////
//// *  Redistributions of source code must retain the above copyright notice,
////    this list of conditions and the following disclaimer.
//// *  Redistributions in binary form must reproduce the above copyright
////    notice, this list of conditions and the following disclaimer in the
////    documentation and/or other materials provided with the distribution.
////
//// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
//// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
//// TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
//// PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
//// CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
//// EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
//// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
//// OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
//// WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
//// OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
//// ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//// **************************************************************************
//
//package zen.codegen.jvm;
//import java.lang.reflect.Array;
//import java.util.Iterator;
//
//import zen.deps.LibNative;
//import zen.deps.ZenArray;
//import zen.lang.ZenSystem;
//import zen.lang.ZenType;
//
//public class ArrayApi {
//	public final static long GetSize(ZenArray self) {
//		return self.ArrayBody.size();
//	}
//	public final static Object Get(ZenArray self, long Index) {
//		return self.ArrayBody.get((int)Index);
//	}
//	public final static void Set(ZenArray self, long Index, Object Value) {
//		self.ArrayBody.set((int)Index, Value);
//	}
//	public final static ZenArray Add(ZenArray self, Object Value) {
//		self.ArrayBody.add(Value);
//		return self;
//	}
//	public final static ZenArray Slice(ZenArray self, long BIndex) {
//		int bindex = (BIndex < 0) ? self.ArrayBody.size() - (int)BIndex : (int)BIndex;
//		return self.SubArray(bindex, self.ArrayBody.size());
//	}
//	public final static ZenArray Slice(ZenArray self, long BIndex, long EIndex) {
//		int bindex = (BIndex < 0) ? self.ArrayBody.size() - (int)BIndex : (int)BIndex;
//		int eindex = (EIndex < 0) ? self.ArrayBody.size() - (int)EIndex : (int)EIndex;
//		return self.SubArray(bindex, eindex);
//	}
//	public final static ZenArray ObjectArrayToGreenArray(Object ObjectArray) {
//		LibNative.Assert(ObjectArray.getClass().isArray());
//		Class<?> ComponentType = ObjectArray.getClass().getComponentType();
//		//		ZenType ElementType = ZenSystem.StringType;
//		if(ComponentType.isPrimitive()) {
//			if(ComponentType == int.class) {
//				ZenType ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ZenSystem.IntType, true);
//				ZenArray ArrayObject = new ZenArray(ArrayType);
//				for(int i = 0; i < Array.getLength(ObjectArray); i++) {
//					ArrayObject.ArrayBody.add(new Long(Array.getInt(ObjectArray, i)));
//				}
//				return ArrayObject;
//			}
//			if(ComponentType == long.class) {
//				ZenType ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ZenSystem.IntType, true);
//				ZenArray ArrayObject = new ZenArray(ArrayType);
//				for(int i = 0; i < Array.getLength(ObjectArray); i++) {
//					ArrayObject.ArrayBody.add(new Long(Array.getLong(ObjectArray, i)));
//				}
//				return ArrayObject;
//			}
//		}
//		ZenType ElementType = LibNative.GetNativeType(ComponentType);
//		ZenType ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ElementType, true);
//		ZenArray ArrayObject = new ZenArray(ArrayType);
//		for(int i = 0; i < Array.getLength(ObjectArray); i++) {
//			ArrayObject.ArrayBody.add(Array.get(ObjectArray, i));
//		}
//		return ArrayObject;
//	}
//
//	public final static Object GreenArrayToObjectArray(ZenArray ArrayObject) {
//		ZenType ElementType = ArrayObject.GetGreenType();
//		int Size = ArrayObject.ArrayBody.size();
//		if(ElementType.IsIntType()) {
//			long[] Values = new long[Size];
//			for(int i = 0; i < Size; i++) {
//				Object Value = ArrayObject.ArrayBody.get(i);
//				Values[i] = (Long)Value;
//			}
//			return Values;
//		}
//		if(ElementType.IsFloatType()) {
//			double[] Values = new double[Size];
//			for(int i = 0; i < Size; i++) {
//				Object Value = ArrayObject.ArrayBody.get(i);
//				Values[i] = (Long)Value;
//			}
//			return Values;
//		}
//		if(ElementType.IsBooleanType()) {
//			boolean[] Values = new boolean[Size];
//			for(int i = 0; i < Size; i++) {
//				Object Value = ArrayObject.ArrayBody.get(i);
//				Values[i] = (Boolean)Value;
//			}
//			return Values;
//		}
//		Object ObjectArray = Array.newInstance(ElementType.GetNativeType(false), Size);
//		for(int i = 0; i < Size; i++) {
//			Array.set(ObjectArray, i, ArrayObject.ArrayBody.get(i));
//		}
//		return ObjectArray;
//	}
//
//	public final static ZenArray StringArrayToGreenArray(String[] Values) {
//		ZenType ArrayType = ZenSystem.GetGenericType1(ZenSystem.ArrayType, ZenSystem.StringType, true);
//		ZenArray ArrayObject = new ZenArray(ArrayType);
//		for(int i = 0; i < Values.length; i++) {
//			ArrayObject.ArrayBody.add(Values[i]);
//		}
//		return ArrayObject;
//	}
//
//	public final static String[] GreenArrayToStringArray(ZenArray ArrayObject) {
//		String[] Values = new String[ArrayObject.ArrayBody.size()];
//		for(int i = 0; i < Values.length; i++) {
//			Object Value = ArrayObject.ArrayBody.get(i);
//			Values[i] = (String)Value;
//		}
//		return Values;
//	}
//
//	public final static Iterator<Object> ToIterator(ZenArray self) {
//		return self.ArrayBody.iterator();
//	}
//
//
//}
//
//
////public final static ZenArray NewArray1(ZenType Type, int InitSize) {
////	ZenType ArrayType = Type.Context.GetGenericType1(Type.Context.ArrayType, Type, true);
//////	if(Type.BaseType.IsIntType()) {
//////		return new ZenIntArray(ArrayType, InitSize);
//////	}
//////	else {
////	ZenArray ArrayObject =  new ZenArray(ArrayType);
////	for(int i = 0; i < InitSize; i++) {
////		ArrayObject.ArrayBody.add(Type.DefaultNullValue);
////	}
////	return ArrayObject;
//////	}
////}
////public final static ZenArray NewNewArray(ZenType ArrayType, Object[] Values) {
//////	if(ArrayType.TypeParams[0].BaseType.IsIntType()) {
//////		ZenIntArray ArrayObject =  new ZenIntArray(ArrayType, Values.length);
//////		for(int i = 0; i < Values.length; i++) {
//////			ArrayObject.Add(Values[i] == null ? 0 : ((Number)Values[i]).longValue());
//////		}
//////		return ArrayObject;
//////	}
//////	else {
////	ZenArray ArrayObject =  new ZenArray(ArrayType);
////	for(int i = 0; i < Values.length; i++) {
////		ArrayObject.ArrayBody.add(Values[i]);
////	}
////	return ArrayObject;
//////	}
////}
////public final static long GetSizeI(ZenIntArray self) {
////return self.Size;
////}
////public final static long GetI(ZenIntArray self, long Index) {
////	if(!((int)Index < self.Size)) {
////		throw new ArrayIndexOutOfBoundsException(""+Index);
////	}
////	return self.ArrayBody[(int)Index];
////}
////public final static void SetI(ZenIntArray self, long Index, long Value) {
////	if(!((int)Index < self.Size)) {
////		throw new ArrayIndexOutOfBoundsException(""+Index);
////	}
////	self.ArrayBody[(int)Index] = Value;
////}
////public final static ZenIntArray AddI(ZenIntArray self, long Value) {
////	self.Add(Value);
////	return self;
////}
////public final static ZenIntArray SliceI(ZenIntArray self, long BIndex) {
////	int bindex = (BIndex < 0) ? self.Size - (int)BIndex : (int)BIndex;
////	return self.SubArray(bindex, self.Size);
////}
////public final static ZenIntArray SliceI(ZenIntArray self, long BIndex, long EIndex) {
////	int bindex = (BIndex < 0) ? self.Size - (int)BIndex : (int)BIndex;
////	int eindex = (EIndex < 0) ? self.Size - (int)EIndex : (int)EIndex;
////	return self.SubArray(bindex, eindex);
////}
////// Converter
////public final static ZenArray<?> AnyToGreenArray(ZenType Type, Object Value) {
////	if(Value.getClass().isArray()) {
////		Class<?> ComponentClass = Value.getClass().getComponentType();
////		LibNative.GetNativeType(Type.Context, ComponentClass);
////	}
////	//return ArrayObject;
////}
////public final static String[] GreenArrayToAny(ZenType Type, ZenArray<String> ArrayObject) {
////	String[] Values = new String[ArrayObject.ArrayBody.size()];
////	for(int i = 0; i < Values.length; i++) {
////		Object Value = ArrayObject.ArrayBody.get(i);
////		Values[i] = (String)Value;
////	}
////	return Values;
////}
////class ZenIntArray extends ZenTopObject {
////	public long[] ArrayBody;
////	public int Size;
////	public ZenIntArray/*constructor*/(ZenType GreenType, int InitCapacity) {
////		super(GreenType);
////		this.ArrayBody = new long[InitCapacity < 8 ? 8 : InitCapacity];
////		this.Size = 0;
////	}
////	public void Add(long Value) {
////		if(!(this.Size < this.ArrayBody.length)) {
////			long[] NewArray = new long[this.ArrayBody.length * 2];
////			System.arraycopy(this.ArrayBody, 0, NewArray, 0, this.Size);
////			this.ArrayBody = NewArray;
////		}
////		this.ArrayBody[this.Size] = Value;
////		this.Size += 1;
////	}
////
////	public ZenIntArray SubArray(int bindex, int eindex) {
////		ZenIntArray ArrayObject = new ZenIntArray(this.GreenType, eindex-bindex);
////		for(int i = bindex; i < eindex; i++) {
////			this.Add(this.ArrayBody[i]);
////		}
////		return ArrayObject;
////	}
////	@Override public String toString() {
////		String s = "[";
////		for(int i = 0; i < this.Size; i++) {
////			Object Value = this.ArrayBody[i];
////			if(i > 0) {
////				s += ", " + Value;
////			}
////			else {
////				s += Value;
////			}
////		}
////		return s + "]";
////	}
////}
