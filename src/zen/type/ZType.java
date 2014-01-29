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
import zen.parser.ZUtils;

public class ZType  {
	@Field public int		  TypeFlag = 0;
	@Field public int         TypeId = 0;
	@Field public String      ShortName = null;
	@Field public ZType		  RefType = null;

	public ZType(int TypeFlag, String ShortName, ZType RefType) {
		this.TypeFlag = TypeFlag;
		this.ShortName = ShortName;
		this.RefType = RefType;
		if(ZUtils.IsFlag(TypeFlag, ZTypeFlag.UniqueType)) {
			this.TypeId = ZTypePools.NewTypeId(this);
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
		return (this.GetRealType() == ZSystem.VoidType);
	}

	public boolean IsVarType() {
		return (this.GetRealType() == ZSystem.VarType);
	}

	public final boolean IsInferrableType() {
		return (!this.IsVarType() && !this.IsVoidType());
	}

	public final boolean IsTypeType() {
		return (this.GetRealType() == ZSystem.TypeType);
	}

	public final boolean IsBooleanType() {
		return (this.GetRealType() == ZSystem.BooleanType);
	}

	public final boolean IsIntType() {
		return (this.GetRealType() == ZSystem.IntType);
	}

	public final boolean IsFloatType() {
		return (this.GetRealType() == ZSystem.FloatType);
	}

	public final boolean IsNumberType() {
		return (this.IsIntType() || this.IsFloatType());
	}

	public final boolean IsStringType() {
		return (this.GetRealType() == ZSystem.StringType);
	}

	public final boolean IsArrayType() {
		return (this.GetBaseType() == ZSystem.ArrayType);
	}

	public final boolean IsMapType() {
		return (this.GetBaseType() == ZSystem.MapType);
	}

	//	public final boolean IsEnumType() {
	//		return ZenUtils.IsFlag(this.TypeFlag, EnumType);
	//	}

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
		//		if(ZenUtils.IsFlag(this.TypeFlag, ExportType)) {
		//			return this.ShortName;
		//		}
		//		else {
		//			return this.GetBaseType().ShortName + NativeNameSuffix + this.TypeId;
		//		}
		return this.GetBaseType().ShortName + ZTypeFlag.NativeNameSuffix + this.TypeId;
	}

	//	public final String GetUniqueName() {
	//		//		if(ZenUtils.IsFlag(this.TypeFlag, TypeVariable)) {
	//		//			return this.ShortName;
	//		//		}
	//		//		else {
	//		//			if(LibZen.DebugMode) {
	//		return this.GetBaseType().ShortName + NativeNameSuffix + this.TypeId;
	//		//			}
	//		//			else {
	//		//				return NativeNameSuffix + this.TypeId;
	//		//			}
	//		//		}
	//	}

	//	public final boolean Accept(ZenType Type) {
	//		boolean b = this.Accept_(Type);
	//		System.err.println("" + this + " accepts " + Type + " ? " + b);
	//		return b;
	//	}

	public final boolean AcceptValue(Object Value) {
		return (Value != null) ? this.Accept(ZSystem.GuessType(Value)) : true;
	}

	public boolean IsFuncType() {
		return false;
	}

	//	public boolean HasCallableSignature() {
	//		return false;
	//	}

	public String StringfySignature(String FuncName) {
		return FuncName;
	}




	//	public void SetClassField(ZenClassField ClassField) {
	//		this.TypeBody = ClassField;
	//	}
	//
	//	public boolean IsDynamicNaitiveLoading() {
	//		return this.IsNativeType() /*&& !ZenUtils.IsFlag(this.TypeFlag, CommonType)*/;
	//	}
	//
	//	public final boolean IsTypeVariable() {   // T
	//		return ZenUtils.IsFlag(this.TypeFlag, TypeVariable);
	//	}
	//
	//	public final boolean HasTypeVariable() {
	//		return ZenUtils.IsFlag(this.TypeFlag, TypeVariable) || ZenUtils.IsFlag(this.TypeFlag, GenericVariable);
	//	}
	//
	//	public int AppendTypeVariable(ZenNameSpace GenericNameSpace, int Count) {
	//		if(ZenUtils.IsFlag(this.TypeFlag, TypeVariable)) {
	//			@Var ZenType TypeVar = GenericNameSpace.GetType(this.ShortName);
	//			if(TypeVar != null && TypeVar.IsTypeVariable()) {
	//				return Count;
	//			}
	//			GenericNameSpace.SetSymbol(this.ShortName, this, null);
	//			return Count + 1;
	//		}
	//		if(ZenUtils.IsFlag(this.TypeFlag, GenericVariable)) {
	//			for(@Var int i = 0; i < this.TypeParams.length; i += 1) {
	//				Count = this.TypeParams[i].AppendTypeVariable(GenericNameSpace, Count);
	//			}
	//		}
	//		return Count;
	//	}
	//
	//	private ZenType GivenParamType(ZenType GivenType, int ParamIndex) {
	//		if(GivenType.BaseType == this.BaseType && GivenType.TypeParams.length == this.TypeParams.length) {
	//			return GivenType.TypeParams[ParamIndex];
	//		}
	//		return GivenType;
	//	}
	//
	//	public ZenType RealType(ZenNameSpace GenericNameSpace, ZenType GivenType) {
	//		if(ZenUtils.IsFlag(this.TypeFlag, TypeVariable)) {
	//			@Var ZenType TypeVar = GenericNameSpace.GetType(this.ShortName);
	//			//System.err.println("TypeVar="+this.ShortName + ", " + TypeVar);
	//			if(TypeVar != null && TypeVar.IsTypeVariable()) {
	//				GenericNameSpace.SetSymbol(this.ShortName, GivenType, null);
	//				return GivenType;
	//			}
	//			else {
	//				return TypeVar;
	//			}
	//		}
	//		if(ZenUtils.IsFlag(this.TypeFlag, GenericVariable)) {
	//			@Var ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
	//			for(@Var int i = 0; i < this.TypeParams.length; i += 1) {
	//				@Var ZenType RealParamType = this.TypeParams[i].RealType(GenericNameSpace, this.GivenParamType(GivenType, i));
	//				TypeList.add(RealParamType);
	//			}
	//			return ZenTypeSystem.GetGenericType(this.BaseType, 0, TypeList, true);
	//		}
	//		return this;
	//	}
	//
	//	public boolean Match(ZenNameSpace GenericNameSpace, ZenType GivenType) {
	//
	//		if(ZenUtils.IsFlag(this.TypeFlag, TypeVariable)) {
	//			@Var ZenType TypeVar = GenericNameSpace.GetType(this.ShortName);
	//			if(TypeVar.IsTypeVariable()) {
	//				//System.err.println("updating "+ this.ShortName + " " + GivenType);
	//				GenericNameSpace.SetSymbol(this.ShortName, GivenType, null);
	//				return true;
	//			}
	//			return TypeVar.Accept(GivenType);
	//		}
	//		if(ZenUtils.IsFlag(this.TypeFlag, GenericVariable)) {
	//			if(GivenType.BaseType == this.BaseType && GivenType.TypeParams.length == this.TypeParams.length) {
	//				for(@Var int i = 0; i < this.TypeParams.length; i += 1) {
	//					if(!this.TypeParams[i].Match(GenericNameSpace, GivenType.TypeParams[i])) {
	//						return false;
	//					}
	//				}
	//				return true;
	//			}
	//			return false;
	//		}
	//		return this.Accept(GivenType);
	//	}
	//
	////	public boolean Match(ZenNameSpace GenericNameSpace, ZenType GivenType) {
	////		boolean b = this.Match_(GenericNameSpace, GivenType);
	////		System.err.println("matching.. " + this + ", given = " + GivenType + ", results=" + b);
	////		return b;
	////	}

}