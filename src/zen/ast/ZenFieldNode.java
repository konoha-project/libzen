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

import zen.deps.Constructor;
import zen.deps.Field;
import zen.lang.ZenSystem;
import zen.lang.ZenType;

final public class ZenFieldNode extends ZenNode {
	@Field public ZenType  ClassType;
	@Field public ZenType  DeclType;
	@Field public String   FieldName;
	@Field public ZenNode  InitNode;
	@Constructor public ZenFieldNode(ZenType ClassType) {
		super(); // TODO
		this.ClassType = ClassType;
		this.DeclType = ZenSystem.VarType;
		this.FieldName = null;
		this.InitNode  = null;
	}
	@Override public void Append(ZenNode Node) {
		if(Node instanceof ZenTypeNode) {
			this.DeclType = Node.Type;
		}
		else if(this.FieldName == null) {
			this.FieldName = Node.SourceToken.ParsedText;
			this.SourceToken = Node.SourceToken;
		}
		else {
			this.InitNode = this.SetChild(Node);
		}
	}

	public ZenNode CheckFieldType() {
		if(this.DeclType.IsVarType()) {
			return new ZenErrorNode(this.SourceToken, "field " + this.FieldName + " is ambigious");
		}
		return null;
	}
}