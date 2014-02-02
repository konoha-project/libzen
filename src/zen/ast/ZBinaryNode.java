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
import zen.deps.Init;
import zen.deps.Var;
import zen.parser.ZSyntaxPattern;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.parser.ZVisitor;

public class ZBinaryNode extends ZNode {
	@Field @Init public ZNode  LeftNode;
	@Field public ZNode	 RightNode = null;
	@Field @Init public ZSyntaxPattern Pattern;
	public ZBinaryNode(ZNode ParentNode, ZToken SourceToken, ZNode Left, ZSyntaxPattern Pattern) {
		super(ParentNode, SourceToken);
		this.LeftNode  = this.SetChild(Left);
		assert(Pattern != null);
		this.Pattern = Pattern;
	}

	@Override public final void Append(ZNode Node) {
		this.RightNode = this.SetChild(Node);
	}

	private final boolean IsRightJoin(ZNode Node) {
		if(Node instanceof ZBinaryNode) {
			return this.Pattern.IsRightJoin(((ZBinaryNode)Node).Pattern);
		}
		return false;
	}

	private final ZNode RightJoin(ZNode ParentNode, ZBinaryNode RightNode) {
		@Var ZNode RightLeftNode = RightNode.LeftNode;
		//		if(RightLeftNode instanceof ZenBinaryNode && this.Pattern.IsRightJoin(((ZenBinaryNode)RightLeftNode).Pattern)) {
		if(this.IsRightJoin(RightLeftNode)) {
			RightNode.LeftNode = this.RightJoin(ParentNode, (ZBinaryNode) RightLeftNode);
		}
		else {
			RightNode.LeftNode = RightNode.SetChild(this);
			this.Append(RightLeftNode);
		}
		return RightNode;
	}

	public final ZNode AppendParsedRightNode(ZNode ParentNode, ZTokenContext TokenContext) {
		@Var ZNode RightNode = TokenContext.ParsePattern(ParentNode, "$Expression$", ZTokenContext.Required2);
		if(RightNode.IsErrorNode()) {
			return RightNode;
		}
		if(this.IsRightJoin(RightNode)) {
			return this.RightJoin(ParentNode, (ZBinaryNode) RightNode);
		}
		// LeftJoin
		this.Append(RightNode);
		return this;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitBinaryNode(this);
	}
}