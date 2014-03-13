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
import zen.parser.ZToken;
import zen.parser.ZTypeChecker;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZenMethod;

public class ZType  {
	public final static int     UniqueTypeFlag         = 1 << 16;
	@Deprecated public final static int     UnboxTypeFlag          = 1 << 10;
	public final static int     OpenTypeFlag           = 1 << 9;  // @Open for the future

	public final static ZType		VarType = new ZType(ZType.UniqueTypeFlag, "var", null);
	public final static ZType		VoidType = new ZType(ZType.UniqueTypeFlag, "void", null);
	public final static ZType		BooleanType = new ZType(ZType.UniqueTypeFlag, "boolean", ZType.VarType);
	public final static ZType		IntType = new ZType(ZType.UniqueTypeFlag, "int", ZType.VarType);
	public final static ZType       FloatType = new ZType(ZType.UniqueTypeFlag, "float", ZType.VarType);
	public final static ZType		StringType = new ZType(ZType.UniqueTypeFlag, "String", ZType.VarType);
	public final static ZType       TypeType = new ZType(ZType.UniqueTypeFlag, "Type", ZType.VarType);

	@Field public int		  TypeFlag = 0;
	@Field public int         TypeId = 0;
	@Field public String      ShortName = null;
	@Field public ZType		  RefType = null;

	public ZType(int TypeFlag, String ShortName, ZType RefType) {
		this.TypeFlag = TypeFlag;
		this.ShortName = ShortName;
		this.RefType = RefType;
		if(LibZen._IsFlag(TypeFlag, ZType.UniqueTypeFlag)) {
			this.TypeId = ZTypePool._NewTypeId(this);
		}
	}

	@Override public String toString() {
		return this.GetName();
	}

	@ZenMethod public String GetName() {
		return this.ShortName;
	}

	@ZenMethod public ZType GetRealType() {
		return this;
	}

	@ZenMethod public ZType GetSuperType() {
		return this.RefType;
	}

	@ZenMethod public ZType GetBaseType() {
		return this;
	}

	@ZenMethod public int GetParamSize() {
		return 0;
	}

	@ZenMethod public ZType GetParamType(int Index) {
		return ZType.VarType;  // for safety, it is used in Array
	}

	public final boolean Equals(ZType Type) {
		return (this.GetRealType() == Type.GetRealType());
	}

	public final boolean Accept(ZType Type) {
		@Var ZType ThisType = this.GetRealType();
		if(ThisType == Type.GetRealType()) {
			return true;
		}
		if(Type.GetParamSize() == 0) {
			@Var ZType SuperClass = Type.GetSuperType();
			while(SuperClass != null) {
				if(SuperClass == ThisType) {
					return true;
				}
				SuperClass = SuperClass.GetSuperType();
			}
		}
		return false;
	}

	@ZenMethod public boolean IsGreekType() {
		return false;
	}

	@ZenMethod public ZType GetGreekRealType(ZType[] Greek) {
		return this.GetRealType();
	}

	@ZenMethod public boolean AcceptValueType(ZType ValueType, boolean ExactMatch, ZType[] Greek) {
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

	@ZenMethod public boolean IsVarType() {
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
		return (this.GetBaseType() == ZGenericType._ArrayType);
	}

	public final boolean IsMapType() {
		return (this.GetBaseType() == ZGenericType._MapType);
	}

	public final boolean IsOpenType() {
		return LibZen._IsFlag(this.TypeFlag, ZType.OpenTypeFlag);
	}

	@ZenMethod public boolean IsMutableType(ZTypeChecker Gamma) {
		//		if(Gamma.IsSupportMutable) {
		//			return false;
		//		}
		//		return true;
		return !Gamma.IsSupportMutable;
	}

	@ZenMethod public boolean IsNullableType(ZTypeChecker Gamma) {
		//		if(Gamma.IsSupportMutable) {
		//			return false;
		//		}
		//		return true;
		return !Gamma.IsSupportNullable;
	}

	public final String StringfyClassMember(String Name) {
		return Name + " of " + this.ShortName;
	}

	public final String GetUniqueName() {
		return LibZen._Stringfy(this.TypeId);
	}

	//	public final boolean AcceptValue(Object Value) {
	//		return (Value != null) ? this.Accept(ZSystem.GuessType(Value)) : true;
	//	}

	public boolean IsFuncType() {
		return (this.GetRealType() instanceof ZFuncType);
	}

	public String StringfySignature(String FuncName) {
		return FuncName;
	}

	public void Maybe(ZType T, ZToken SourceToken) {
	}


}