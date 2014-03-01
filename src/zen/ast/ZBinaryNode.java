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

import zen.parser.ZGenerator;
import zen.parser.ZMacroFunc;
import zen.parser.ZSyntax;
import zen.parser.ZToken;
import zen.parser.ZTokenContext;
import zen.parser.ZVisitor;
import zen.type.ZFunc;
import zen.util.Field;
import zen.util.Var;

public class ZBinaryNode extends ZNode {
	public final static int _Left = 0;
	public final static int _Right = 1;
	@Field public ZSyntax Pattern;

	public ZBinaryNode(ZNode ParentNode, ZToken SourceToken, ZNode Left, ZSyntax Pattern) {
		super(ParentNode, SourceToken, 2);
		this.Set(ZBinaryNode._Left, Left);
		assert(Pattern != null);
		this.Pattern = Pattern;
	}

	private final boolean IsRightJoin(ZNode Node) {
		if(Node instanceof ZBinaryNode) {
			return this.Pattern.IsRightJoin(((ZBinaryNode)Node).Pattern);
		}
		return false;
	}

	private final ZNode RightJoin(ZNode ParentNode, ZBinaryNode RightNode) {
		@Var ZNode RightLeftNode = RightNode.AST[ZBinaryNode._Left];
		if(this.IsRightJoin(RightLeftNode)) {
			RightNode.Set(ZBinaryNode._Left, this.RightJoin(ParentNode, (ZBinaryNode) RightLeftNode));
		}
		else {
			RightNode.Set(ZBinaryNode._Left, this);
			this.Set(ZBinaryNode._Right, RightLeftNode);
		}
		return RightNode;
	}

	public final ZNode AppendParsedRightNode(ZNode ParentNode, ZTokenContext TokenContext) {
		@Var ZNode RightNode = TokenContext.ParsePattern(ParentNode, "$Expression$", ZTokenContext._Required);
		if(RightNode.IsErrorNode()) {
			return RightNode;
		}
		if(this.IsRightJoin(RightNode)) {
			return this.RightJoin(ParentNode, (ZBinaryNode) RightNode);
		}
		this.Set(ZBinaryNode._Right, RightNode);
		return this;
	}

	public final ZNode TryMacroNode(ZGenerator Generator) {
		if(!this.GetAstType(ZBinaryNode._Left).IsVarType() && !this.GetAstType(ZBinaryNode._Right).IsVarType()) {
			@Var String Op = this.SourceToken.GetText();
			@Var ZFunc Func = Generator.GetDefinedFunc(Op, this.GetAstType(ZBinaryNode._Left), 2);
			if(Func instanceof ZMacroFunc) {
				@Var ZMacroNode MacroNode = new ZMacroNode(this.ParentNode, this.SourceToken, (ZMacroFunc)Func);
				MacroNode.Append(this.AST[ZBinaryNode._Left]);
				MacroNode.Append(this.AST[ZBinaryNode._Right]);
				return MacroNode;
			}
		}
		return this;
	}

	@Override public void Accept(ZVisitor Visitor) {
		Visitor.VisitBinaryNode(this);
	}

}