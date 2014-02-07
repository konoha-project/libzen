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

import java.util.ArrayList;

import zen.deps.Field;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.parser.ZVisitor;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypePool;

public class ZFunctionNode extends ZListNode {
	public final static int Block = 0;

	@Field public ZType ReturnType = ZType.VarType;
	@Field public String FuncName = null;

	@Field public ZFunctionNode ParentFunctionNode = null;
	@Field public ZFuncType ResolvedFuncType = null;
	@Field public String GlobalName = null;
	@Field public int VarIndex = 0;

	public ZFunctionNode(ZNode ParentNode) {
		super(ParentNode, null, 1);
	}

	@Override public void SetType(ZType Type) {
		this.ReturnType = Type;
	}
	@Override public void SetName(String Name) {
		this.FuncName = Name;
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

	public final ZFuncType GetFuncType(@Nullable ZType ContextType) {
		if(this.ResolvedFuncType == null) {
			@Var ZFuncType FuncType = null;
			if(ContextType instanceof ZFuncType) {
				FuncType = (ZFuncType)ContextType;
			}
			@Var ArrayList<ZType> TypeList = new ArrayList<ZType>();
			if(this.ReturnType.IsVarType() && FuncType != null) {
				this.ReturnType = FuncType.GetParamType(0);
			}
			TypeList.add(this.ReturnType.GetRealType());
			@Var int i = 0;
			while(i < this.GetListSize()) {
				@Var ZParamNode Node = this.GetParamNode(i);
				@Var ZType ParamType = Node.Type.GetRealType();
				if(ParamType.IsVarType() && FuncType != null) {
					ParamType = FuncType.GetParamType(i+1);
				}
				TypeList.add(ParamType);
				i = i + 1;
			}
			FuncType = ZTypePool.LookupFuncType(TypeList);
			if(!FuncType.IsVarType()) {
				this.ResolvedFuncType = FuncType;
			}
			return FuncType;
		}
		return this.ResolvedFuncType;
	}

	public final ZFunctionNode Push(ZFunctionNode Parent) {
		this.ParentFunctionNode = Parent;
		return this;
	}

	public final ZFunctionNode Pop() {
		return this.ParentFunctionNode;
	}

	public final int GetVarIndex() {
		@Var int Index = this.VarIndex;
		this.VarIndex = this.VarIndex + 1;
		return Index;
	}
}