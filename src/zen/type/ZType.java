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
import zen.deps.Var;
import zen.lang.ZSystem;
import zen.parser.ZToken;
import zen.parser.ZUtils;

public class ZType  {
	public final static ZType		VarType = new ZType(ZTypeFlag.UniqueType, "var", null);
	public final static ZType		VoidType = new ZType(ZTypeFlag.UniqueType, "void", null);
	public final static ZType		BooleanType = new ZType(ZTypeFlag.UniqueType, "boolean", VarType);
	public final static ZType		IntType = new ZType(ZTypeFlag.UniqueType, "int", VarType);
	public final static ZType       FloatType = new ZType(ZTypeFlag.UniqueType, "float", VarType);
	public final static ZType		StringType = new ZType(ZTypeFlag.UniqueType, "String", VarType);
	public final static ZType       TypeType = new ZType(ZTypeFlag.UniqueType, "Type", VarType);
	public final static ZType		ArrayType = new ZGeneric1Type(ZTypeFlag.UniqueType, "Array", null, VarType);
	public final static ZType		MapType = new ZGeneric1Type(ZTypeFlag.UniqueType, "Map", null, VarType);
	public final static ZType		FuncType  = new ZFuncType("Func", null);


	@Field public int		  TypeFlag = 0;
	@Field public int         TypeId = 0;
	@Field public String      ShortName = null;
	@Field public ZType		  RefType = null;

	public ZType(int TypeFlag, String ShortName, ZType RefType) {
		this.TypeFlag = TypeFlag;
		this.ShortName = ShortName;
		this.RefType = RefType;
		if(ZUtils.IsFlag(TypeFlag, ZTypeFlag.UniqueType)) {
			this.TypeId = ZTypePool.NewTypeId(this);
		}
	}

	public ZType GetRealType() {
		return this;
	}

	public ZType GetSuperType() {
		return this.RefType;
	}

	public ZType GetBaseType() {
		return this;
	}

	public int GetParamSize() {
		return 0;
	}

	public ZType GetParamType(int Index) {
		return null;
	}

	public final boolean Equals(ZType Type) {
		return (this.GetRealType() == Type.GetRealType());
	}

	public boolean Accept(ZType Type) {
		@Var ZType ThisType = this.GetRealType();
		if(ThisType == Type.GetRealType() /*|| ThisType == ZenSystem.AnyType*/) {
			return true;
		}
		@Var ZType SuperClass = Type.GetSuperType();
		while(SuperClass != null) {
			if(SuperClass == ThisType) {
				return true;
			}
			SuperClass = SuperClass.GetSuperType();
		}
		return ZSystem.CheckSubType(Type, this);
	}

	public boolean IsGreekType() {
		return false;
	}

	public ZType GetRealType(ZType[] Greek) {
		return this.GetRealType();
	}

	public boolean AcceptValueType(ZType ValueType, boolean ExactMatch, ZType[] Greek) {
		if(this.GetRealType() != ValueType && !ValueType.IsVarType()) {
			if(ExactMatch && !this.Accept(ValueType)) {
				return false;
			}
		}
		return true;
	}

	public final boolean IsVoidType() {
		return (this.GetRealType() == ZType.VoidType);
	}

	public boolean IsVarType() {
		return (this.GetRealType() == ZType.VarType);
	}

	public final boolean IsInferrableType() {
		return (!this.IsVarType() && !this.IsVoidType());
	}

	public final boolean IsTypeType() {
		return (this.GetRealType() == ZType.TypeType);
	}

	public final boolean IsBooleanType() {
		return (this.GetRealType() == ZType.BooleanType);
	}

	public final boolean IsIntType() {
		return (this.GetRealType() == ZType.IntType);
	}

	public final boolean IsFloatType() {
		return (this.GetRealType() == ZType.FloatType);
	}

	public final boolean IsNumberType() {
		return (this.IsIntType() || this.IsFloatType());
	}

	public final boolean IsStringType() {
		return (this.GetRealType() == ZType.StringType);
	}

	public final boolean IsArrayType() {
		return (this.GetBaseType() == ZType.ArrayType);
	}

	public final boolean IsMapType() {
		return (this.GetBaseType() == ZType.MapType);
	}

	public ZType CreateSubType(int ClassFlag, String ClassName) {
		@Var ZType SubType = new ZType(ClassFlag, ClassName, this);
		return SubType;
	}

	public boolean IsOpenType() {
		return ZUtils.IsFlag(this.TypeFlag, ZTypeFlag.OpenType);
	}

	public boolean IsImmutableType() {
		return false;
	}

	public boolean IsNullableType() {
		return true;
	}

	@Override public String toString() {
		return this.ShortName;
	}

	public final String StringfyClassMember(String Name) {
		return Name + " of " + this.ShortName;
	}

	private final static String[] Matrix = {
		"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "0", "4",
		"a", "s", "d", "f", "g", "h", "j", "k", "l", "9", "1", "6",
		"z", "x", "c", "v", "b", "n", "m", "7", "5", "3", "2", "8",
	};

	public final String GetUniqueName() {
		int number = this.TypeId;
		int d = number % Matrix.length;
		number = number / Matrix.length;
		int c = number % Matrix.length;
		number = number / Matrix.length;
		return Matrix[number] + Matrix[c] + Matrix[d];
	}

	public final String GetNativeName() {
		return this.GetBaseType().ShortName + ZTypeFlag.NativeNameSuffix + this.TypeId;
	}

	public final boolean AcceptValue(Object Value) {
		return (Value != null) ? this.Accept(ZSystem.GuessType(Value)) : true;
	}

	public boolean IsFuncType() {
		return false;
	}

	public String StringfySignature(String FuncName) {
		return FuncName;
	}

	public void Maybe(ZType T, ZToken SourceToken) {
	}

}