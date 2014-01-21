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

package zen.sugar;

import zen.ast.ZNode;
import zen.deps.Field;
import zen.lang.ZType;
import zen.parser.ZToken;

//E.g., "for" "(" ";" $CondNode ";" $IterNode ")" $LoopNode
public final class ZenForNode extends ZNode {
	@Field public ZNode	CondNode;
	@Field public ZNode	IterNode;
	@Field public ZNode	BodyNode;
	public ZenForNode(ZType Type, ZToken Token, ZNode CondNode, ZNode IterNode, ZNode BodyNode) {
		super();
		this.CondNode = CondNode;
		this.BodyNode = BodyNode;
		this.IterNode = IterNode;
		//		this.SetChild3(CondNode, BodyNode, IterNode);
	}
	//	@Override public boolean Accept(ZenVisitor Visitor) {
	//		Visitor.VisitForNode(this);
	//	}
}