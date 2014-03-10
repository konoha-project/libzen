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

package zen.ast;

import zen.parser.ZGenerator;
import zen.parser.ZVisitor;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypePool;
import zen.util.Field;
import zen.util.Var;
import zen.util.ZArray;

public class ZFunctionNode extends ZListNode {
	public static final int _NameInfo = 0;
	public static final int _TypeInfo = 1;
	public final static int _Block    = 2;

	@Field public ZType  GivenType = null;
	@Field public String GivenName = null;

	@Field public boolean       IsExport = false;
	@Field public ZFunctionNode ParentFunctionNode = null;
	@Field public ZFuncType     ResolvedFuncType = null;

	public ZFunctionNode(ZNode ParentNode) {
		super(ParentNode, null, 3);
	}

	public final ZType ReturnType() {
		if(this.GivenType == null) {
			if(this.AST[ZFunctionNode._TypeInfo] != null) {
				this.GivenType = this.AST[ZFunctionNode._TypeInfo].Type;
			}
			else {
				this.GivenType = ZType.VarType;
			}
		}
		return this.GivenType;
	}

	public final void SetReturnType(ZType Type) {
		this.GivenType = Type;
	}

	public final String FuncName() {
		if(this.GivenName == null && this.AST[ZFunctionNode._NameInfo] != null) {
			this.GivenName = this.AST[ZFunctionNode._NameInfo].SourceToken.GetTextAsName();
		}
		return this.GivenName;
	}

	public final String GetUniqueName(ZGenerator Generator) {
		@Var String FuncName = this.FuncName();
		if(FuncName == null) {
			FuncName = "f";
		}
		return Generator.NameUniqueSymbol("f");
	}

	public final ZBlockNode BlockNode() {
		@Var ZNode BlockNode = this.AST[ZFunctionNode._Block];
		if(BlockNode instanceof ZBlockNode) {
			return (ZBlockNode)BlockNode;
		}
		assert(BlockNode == null); // this must not happen
		return null;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitFunctionNode(this);
	}

	public final ZParamNode GetParamNode(int Index) {
		@Var ZNode Node = this.GetListAt(Index);
		if(Node instanceof ZParamNode) {
			return (ZParamNode)Node;
		}
		return null;
	}

	public final ZFuncType GetFuncType() {
		if(this.ResolvedFuncType == null) {
			@Var ZArray<ZType> TypeList = new ZArray<ZType>(new ZType[this.GetListSize()+2]);
			@Var int i = 0;
			while(i < this.GetListSize()) {
				@Var ZParamNode Node = this.GetParamNode(i);
				@Var ZType ParamType = Node.DeclType().GetRealType();
				TypeList.add(ParamType);
				i = i + 1;
			}
			TypeList.add(this.ReturnType().GetRealType());
			@Var ZFuncType FuncType = ZTypePool._LookupFuncType2(TypeList);
			if(!FuncType.IsVarType()) {
				this.ResolvedFuncType = FuncType;
			}
			return FuncType;
		}
		return this.ResolvedFuncType;
	}

	public final String GetSignature() {
		@Var ZFuncType FuncType = this.GetFuncType();
		return FuncType.StringfySignature(this.FuncName());
	}

	public final ZFunctionNode Push(ZFunctionNode Parent) {
		this.ParentFunctionNode = Parent;
		return this;
	}

	public final ZFunctionNode Pop() {
		return this.ParentFunctionNode;
	}

	public final boolean IsTopLevel() {
		return this.ParentFunctionNode == null;
	}
	//
	//	public final int GetVarIndex() {
	//		@Var int Index = this.VarIndex;
	//		this.VarIndex = this.VarIndex + 1;
	//		return Index;
	//	}
}