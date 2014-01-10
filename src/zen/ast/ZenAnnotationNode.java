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
import zen.deps.ZenMap;
import zen.parser.ZenToken;
import zen.parser.ZenVisitor;

public final class ZenAnnotationNode extends ZenNode {
	public ZenMap<Object> Annotation;
	public ZenNode AnnotatedNode;

	public ZenAnnotationNode/*constructor*/(ZenToken Token, ZenMap<Object> Anno) {
		this.SourceToken = Token;
		this.Annotation = Anno;
		this.AnnotatedNode = null;
	}

	@Override public void Append(ZenNode Node) {
		if(Node instanceof ZenAnnotationNode) {
			ZenAnnotationNode AnnoNode = (ZenAnnotationNode)Node;
			this.Annotation.AddMap(AnnoNode.Annotation);
			Node = AnnoNode.AnnotatedNode;
		}
		this.AnnotatedNode = this.SetChild(Node);
	}

	@Override public boolean IsBreakingBlock() {
		return this.AnnotatedNode.IsBreakingBlock();
	}

	@Override public boolean IsErrorNode() {
		return this.AnnotatedNode.IsErrorNode();
	}

	@Override public ZenNode GetStatementNode() {
		return this.AnnotatedNode;
	}

	@Override public void Accept(ZenVisitor Visitor) {
		this.AnnotatedNode.Accept(Visitor);
	}
}