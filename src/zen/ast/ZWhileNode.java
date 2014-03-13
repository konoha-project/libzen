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

public final class ZWhileNode extends ZNode {
	public final static int _Cond  = 0;
	public final static int _Block = 1;
	public final static int _Next  = 2;   // optional iteration statement

	public ZWhileNode(ZNode ParentNode) {
		super(ParentNode, null, 3);
	}

	public ZWhileNode(ZNode CondNode, ZBlockNode BlockNode) {
		super(null, null, 3);
		this.SetNode(ZWhileNode._Cond, CondNode);
		this.SetNode(ZWhileNode._Block, BlockNode);
		this.Type = ZType.VoidType;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitWhileNode(this);
	}

	public final ZNode CondNode() {
		return this.AST[ZWhileNode._Cond];
	}

	public final ZBlockNode BlockNode() {
		@Var ZNode BlockNode = this.AST[ZWhileNode._Block];
		if(BlockNode instanceof ZBlockNode) {
			return (ZBlockNode)BlockNode;
		}
		assert(BlockNode == null); // this must not happen
		return null;
	}

	public final boolean HasNextNode() {
		return (this.AST[ZWhileNode._Next] != null);
	}

	public final ZNode NextNode() {
		return this.AST[ZWhileNode._Next];
	}


}