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
import zen.lang.ZFunc;
import zen.parser.ZToken;
import zen.parser.ZVisitor;
import zen.type.ZType;

public final class ZMethodCallNode extends ZApplyNode {
	@Field public ZNode RecvNode;
	@Field public String MethodName;
	public ZMethodCallNode(ZToken SourceToken, ZNode RecvNode, String MethodName) {
		super(); this.SourceToken = SourceToken;
		this.RecvNode = this.SetChild(RecvNode);
		this.MethodName = MethodName;
	}
	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitMethodCallNode(this);
	}
	public ZType[] GetParamType() {

		return null;
	}

	public final ZFuncCallNode ToGetterFuncCall() {
		ZGetterNode Getter = new ZGetterNode(this.SourceToken, this.RecvNode, this.MethodName);
		ZFuncCallNode FuncNode = new ZFuncCallNode(Getter);
		FuncNode.SourceToken = this.SourceToken;
		@Var int i = 0;
		while(i < this.ParamList.size()) {
			FuncNode.Append(this.ParamList.get(i));
			i = i + 1;
		}
		return FuncNode;
	}

	public final ZFuncCallNode ToStaticFuncCall(ZFunc Func) {
		ZGetLocalNode Dummy = new ZGetLocalNode(this.SourceToken, Func.FuncName);
		ZFuncCallNode FuncNode = new ZFuncCallNode(Dummy);
		FuncNode.SourceToken = this.SourceToken;
		FuncNode.Append(this.RecvNode);
		@Var int i = 0;
		while(i < this.ParamList.size()) {
			FuncNode.Append(this.ParamList.get(i));
			i = i + 1;
		}
		FuncNode.ResolvedFuncName = Func.FuncName;
		FuncNode.ResolvedFuncType = Func.GetFuncType();
		return FuncNode;
	}

}