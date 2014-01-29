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
import zen.lang.ZSystem;
import zen.parser.ZNameSpace;
import zen.parser.ZVisitor;
import zen.type.ZFuncType;
import zen.type.ZType;

public class ZFunctionNode extends ZNode {
	@Field public ZType ReturnType = ZSystem.VarType;
	@Field public String FuncName = null;
	@Field public ArrayList<ZParamNode> ParamList = new ArrayList<ZParamNode>();
	@Field public ZNode BodyNode = null;
	@Field public ZNameSpace NameSpace;

	@Field public ZFunctionNode ParentFunctionNode = null;
	@Field public ZFuncType ResolvedFuncType = null;
	@Field public String ReferenceName = null;
	@Field public int VarIndex = 0;

	public ZFunctionNode(ZNameSpace NameSpace) {
		super();
		this.NameSpace = NameSpace;
	}

	@Override public void Append(ZNode Node) {
		if(Node instanceof ZParamNode) {
			this.ParamList.add((ZParamNode)Node);
		}
		else if(this.FuncName == null) {
			this.FuncName = Node.SourceToken.ParsedText;
			this.SourceToken = Node.SourceToken;
		}
		else if(Node instanceof ZTypeNode) {
			this.ReturnType = Node.Type;
		}
		else if(Node instanceof ZBlockNode) {
			this.BodyNode = Node;
		}
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitFunctionNode(this);
	}

	@Override public final boolean IsUntyped() {
		return this.IsVarType() || this.BodyNode.IsVarType();
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
			while(i < this.ParamList.size()) {
				@Var ZParamNode Node = this.ParamList.get(i);
				@Var ZType ParamType = Node.Type.GetRealType();
				if(ParamType.IsVarType() && FuncType != null) {
					ParamType = FuncType.GetParamType(i+1);
				}
				TypeList.add(ParamType);
				i = i + 1;
			}
			FuncType = ZSystem.LookupFuncType(TypeList);
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