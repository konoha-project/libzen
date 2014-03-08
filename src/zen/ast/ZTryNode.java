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

import zen.parser.ZVisitor;
import zen.type.ZType;
import zen.util.Var;

public final class ZTryNode extends ZGivenNameNode {
	public final static int _Try = 0;
	public final static int _Catch = 1;
	public final static int _Finally = 2;

	public ZTryNode(ZNode ParentNode) {
		super(ParentNode, null, 3);
	}

	public final ZBlockNode TryBlockNode() {
		@Var ZNode BlockNode = this.AST[ZTryNode._Try ];
		if(BlockNode instanceof ZBlockNode) {
			return (ZBlockNode)BlockNode;
		}
		assert(BlockNode == null); // this must not happen
		return null;
	}

	public final String ExceptionName() {
		return this.GivenName;
	}

	public final ZType ExceptionType() {
		return this.GivenType;
	}

	public final boolean HasCatchBlockNode() {
		return (this.GivenName != null && this.AST[ZTryNode._Catch ] != null);
	}

	public final ZBlockNode CatchBlockNode() {
		@Var ZNode BlockNode = this.AST[ZTryNode._Catch ];
		if(BlockNode instanceof ZBlockNode) {
			return (ZBlockNode)BlockNode;
		}
		assert(BlockNode == null); // this must not happen
		return null;
	}

	public final boolean HasFinallyBlockNode() {
		return (this.AST[ZTryNode._Finally ] != null);
	}

	public final ZBlockNode FinallyBlockNode() {
		@Var ZNode BlockNode = this.AST[ZTryNode._Finally ];
		if(BlockNode instanceof ZBlockNode) {
			return (ZBlockNode)BlockNode;
		}
		assert(BlockNode == null); // this must not happen
		return null;
	}


	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitTryNode(this);
	}


}