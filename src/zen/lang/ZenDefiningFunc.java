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


public class ZenDefiningFunc extends ZenFunc {

	//	/*field*/public ZenNameSpace       NameSpace;
	//	/*field*/public ArrayList<String>  NameList;
	//	/*field*/public ArrayList<ZenType> TypeList;
	//	/*field*/public ZenNode            FuncBlock;
	//	/*field*/public boolean IsVarArgument;
	/*field*/public int VarIndex;
	//	/*field*/public ZenDefiningFunc DefinedFunc;

	public ZenDefiningFunc(int FuncFlag, String FuncName, ZenFuncType FuncType) {
		super(FuncFlag, FuncName, FuncType);
		this.VarIndex = 0;
		// TODO Auto-generated constructor stub
	}

	//	public ZenDefiningFunc(ZenNameSpace NameSpace, ArrayList<ZenType> TypeList) {
	//		this.NameSpace = NameSpace;
	//		this.TypeList = TypeList;
	//		this.NameList = new ArrayList<String>();
	//		this.FuncBlock = null;
	//		this.IsVarArgument = false;
	//		this.DefinedFunc = null;
	//		this.VariableIndex = 0;
	//	}

	//	public void SetThisIfInClass(ZenType Type) {
	//		if(Type != null) {
	//			this.TypeList.add(Type);
	//			this.NameList.add(this.NameSpace.Generator.GetRecvName());
	//		}
	//	}

	//	public void AddParameter(ZenType Type, String Name) {
	//		this.TypeList.add(Type);
	//		if(Type.IsVarType()) {
	//			this.IsVarArgument = true;
	//		}
	//		this.NameList.add(Name);
	//	}

	public int GetVarIndex() {
		int Index = this.VarIndex;
		this.VarIndex = this.VarIndex + 1;
		return Index;
	}
}