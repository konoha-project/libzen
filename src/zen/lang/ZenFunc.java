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
package zen.lang;
import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.parser.ZenUtils;

public class ZenFunc implements ZenFuncFlag {
	@Field public int             FuncId;
	@Field public int			  FuncFlag;
	@Field public String		  FuncName;  // NativeReferenceNamr
	@Field public ZenFuncType     FuncType;

	public ZenFunc(int FuncFlag, String FuncName, ZenFuncType FuncType) {
		this.FuncFlag = FuncFlag;
		this.FuncName = FuncName;
		this.FuncType = FuncType;
		//				this.FuncId = ZenTypeSystem.FuncPools.size();
		//				ZenTypeSystem.FuncPools.add(this);
	}

	public final ZenType GetFuncType() {
		return this.FuncType;
	}

	@Override public String toString() {
		return this.FuncName + ": " + this.FuncType;
	}

	protected boolean Is(int Flag) {
		return ZenUtils.IsFlag(this.FuncFlag, Flag);
	}

	public final ZenType GetReturnType() {
		return this.FuncType.TypeParams[0];
	}

	public final void SetReturnType(ZenType ReturnType) {
		LibNative.Assert(this.GetReturnType().IsVarType());
		this.FuncType.TypeParams[0] = ReturnType;
	}

	public final ZenType GetRecvType() {
		if(this.FuncType.TypeParams.length == 1) {
			return ZenSystem.VoidType;
		}
		return this.FuncType.TypeParams[1];
	}

	public final int GetFuncParamSize() {
		return this.FuncType.TypeParams.length - 1;
	}

	public final ZenType GetFuncParamType(int ParamIdx) {
		return this.FuncType.TypeParams[ParamIdx+1];
	}

	public final int GetMethodParamSize() {
		return this.FuncType.TypeParams.length - 2;
	}

	//	public final ZenType GetVargType() {
	//		if(this.FuncType.TypeParams.length > 0) {
	//			@Var ZenType VargType = this.FuncType.TypeParams[this.FuncType.TypeParams.length - 1];
	//			if(VargType.IsArrayType()) {
	//				return VargType.GetParamType(0);
	//			}
	//		}
	//		return null;
	//	}

	public Object Invoke(Object[] Params) {
		LibZen.DebugP("not native method");
		return null;
	}

	public boolean IsLazyDef() {
		return false;
	}

	public final boolean IsConverterFunc() {
		return ZenUtils.IsFlag(this.FuncFlag, ZenFuncFlag.ConverterFunc);
	}
	public final boolean IsCoercionFunc() {
		return ZenUtils.IsFlag(this.FuncFlag, ZenFuncFlag.CoercionFunc);
	}

	//	public void GenerateNativeFunc() {
	//		if(this.HasStaticBlock()) {
	//			@Var ZenFuncBlock FuncBlock = (/*cast*/ZenFuncBlock)this.FuncBody;
	//			@Var ZenTypeEnv Gamma = new ZenTypeEnv(FuncBlock.NameSpace);
	//			@Var int i = 0;
	//			@Var ArrayList<String> NameList = new ArrayList<String>();
	//			while(i <  FuncBlock.NameList.size()) {
	//				@Var ZenVariableInfo VarInfo = Gamma.AppendDeclaredVariable(0, FuncBlock.DefinedFunc.Types[i+1], FuncBlock.NameList.get(i), null, null);
	//				NameList.add(VarInfo.NativeName);
	//				i = i + 1;
	//			}
	//			Gamma.FuncBlock = FuncBlock;
	//			@Var ZenNode BodyNode = ZenUtils.TypeBlock(Gamma, FuncBlock.FuncBlock, ZenSystem.VoidType);
	//			if(Gamma.FoundUncommonFunc) {
	//				Gamma.FuncBlock.DefinedFunc.FuncFlag = UnsetFlag(Gamma.FuncBlock.DefinedFunc.FuncFlag, CommonFunc);
	//			}
	//			@Var String FuncName = FuncBlock.DefinedFunc.GetNativeFuncName();
	//			Gamma.Generator.GenerateFunc(FuncBlock.DefinedFunc, NameList, BodyNode);
	//			if(FuncName.equals("main")) {
	//				Gamma.Generator.InvokeMainFunc(FuncName);
	//			}
	//		}
	//	}
	//
	//	public boolean HasLazyBlock() {
	//		if(this.FuncBody instanceof ZenFuncBlock) {
	//			@Var ZenFuncBlock FuncBlock = (/*cast*/ZenFuncBlock)this.FuncBody;
	//			return FuncBlock.IsVarArgument;
	//		}
	//		return false;
	//	}
	//
	//	public ZenFunc GenerateLazyFunc(ArrayList<ZenNode> NodeList) {
	//		return null; // TODO
	//	}
	//
	//	public final ZenNameSpace GetGenericNameSpace(ZenNameSpace NameSpace, ArrayList<ZenNode> NodeList, int MaxSize) {
	//		if(this.Is(GenericFunc)) {
	//			@Var ZenNameSpace GenericNameSpace = NameSpace.CreateSubNameSpace();
	//			@Var int i = 0;
	//			while(i < this.Types.length) {
	//				this.Types[i].AppendTypeVariable(GenericNameSpace, 0);
	//				i = i + 1;
	//			}
	//			i = 0;
	//			while(i < MaxSize) {
	//				this.Types[i+1].Match(GenericNameSpace, NodeList.get(i).Type);
	//				i = i + 1;
	//			}
	//			return GenericNameSpace;
	//		}
	//		return NameSpace;
	//	}
	//
	//	public final ZenNameSpace GetGenericNameSpaceT(ZenNameSpace NameSpace, ArrayList<ZenType> NodeList, int MaxSize) {
	//		if(this.Is(GenericFunc)) {
	//			@Var ZenNameSpace GenericNameSpace = NameSpace.CreateSubNameSpace();
	//			@Var int i = 0;
	//			while(i < this.Types.length) {
	//				this.Types[i].AppendTypeVariable(GenericNameSpace, 0);
	//				i = i + 1;
	//			}
	//			i = 0;
	//			while(i < MaxSize) {
	//				this.Types[i+1].Match(GenericNameSpace, NodeList.get(i));
	//				i = i + 1;
	//			}
	//			return GenericNameSpace;
	//		}
	//		return NameSpace;
	//	}
}
