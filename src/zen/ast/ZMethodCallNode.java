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

import zen.deps.Field;
import zen.deps.Var;
import zen.parser.ZMacroFunc;
import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZFunc;

public final class ZMethodCallNode extends ZListNode {
	public final static int _Recv = 0;
	@Field public String MethodName = null;
	@Field public ZToken MethodToken = null;

	public ZMethodCallNode(ZNode ParentNode, ZNode RecvNode) {
		super(ParentNode, null, 1);
		this.Set(ZMethodCallNode._Recv, RecvNode);
	}

	@Override public void SetNameInfo(ZToken NameToken, String Name) {
		this.MethodName = Name;
		this.MethodToken = NameToken;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitMethodCallNode(this);
	}

	public final ZFuncCallNode ToGetterFuncCall() {
		ZGetterNode Getter = new ZGetterNode(null, this.AST[ZMethodCallNode._Recv]);
		Getter.SetNameInfo(this.MethodToken, this.MethodName);
		ZFuncCallNode FuncNode = new ZFuncCallNode(this.ParentNode, Getter);
		FuncNode.SourceToken = this.SourceToken;
		FuncNode.Append(this.AST[ZMethodCallNode._Recv]);
		@Var int i = 0;
		while(i < this.GetListSize()) {
			FuncNode.Append(this.GetListAt(i));
			i = i + 1;
		}
		return FuncNode;
	}

	public final ZListNode ToFuncCallNode(ZFunc Func) {
		if(Func instanceof ZMacroFunc) {
			ZMacroNode MacroNode = new ZMacroNode(this.ParentNode, this.MethodToken, (ZMacroFunc)Func);
			MacroNode.Append(this.AST[ZMethodCallNode._Recv]);
			@Var int i = 0;
			while(i < this.GetListSize()) {
				MacroNode.Append(this.GetListAt(i));
				i = i + 1;
			}
			return MacroNode;
		}
		else {
			ZFuncCallNode FuncNode = new ZFuncCallNode(this.ParentNode, Func.FuncName, Func.GetFuncType());
			FuncNode.SourceToken = this.MethodToken;
			FuncNode.Append(this.AST[ZMethodCallNode._Recv]);
			@Var int i = 0;
			while(i < this.GetListSize()) {
				FuncNode.Append(this.GetListAt(i));
				i = i + 1;
			}
			return FuncNode;
		}
	}

}