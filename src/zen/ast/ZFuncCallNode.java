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

import zen.parser.ZMacroFunc;
import zen.parser.ZVisitor;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.util.Var;

public final class ZFuncCallNode extends ZListNode {
	public final static int _Func = 0;

	public ZFuncCallNode(ZNode ParentNode, ZNode FuncNode) {
		super(ParentNode, null, 1);
		this.Set(ZFuncCallNode._Func, FuncNode);
	}

	public ZFuncCallNode(ZNode ParentNode, String FuncName, ZType FuncType) {
		super(ParentNode, null, 1);
		@Var ZGlobalNameNode FuncNode = new ZGlobalNameNode(this, null, FuncType, FuncName, true);
		this.Set(ZFuncCallNode._Func, FuncNode);
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitFuncCallNode(this);
	}

	public final ZType GetRecvType() {
		if(this.GetListSize() > 0) {
			return this.GetListAt(0).Type.GetRealType();
		}
		return ZType.VoidType;
	}

	public final String GetFuncName() {
		@Var ZNode FNode = this.AST[ZFuncCallNode._Func];
		if(FNode instanceof ZGlobalNameNode) {
			return ((ZGlobalNameNode)FNode).GlobalName;
		}
		return null;
	}

	public final ZFuncType GetFuncType() {
		@Var ZType FType = this.AST[ZFuncCallNode._Func].Type;
		if(FType instanceof ZFuncType) {
			return (ZFuncType)FType;
		}
		return null;
	}


	public ZMacroNode ToMacroNode(ZMacroFunc MacroFunc) {
		@Var ZMacroNode MacroNode = new ZMacroNode(this.ParentNode, this.AST[ZFuncCallNode._Func].SourceToken, MacroFunc);
		@Var int i = 0;
		while(i < this.GetListSize()) {
			MacroNode.Append(this.GetListAt(i));
			i = i + 1;
		}
		return MacroNode;
	}


}