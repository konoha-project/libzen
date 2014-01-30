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

package zen.parser;

import zen.ast.ZBooleanNode;
import zen.ast.ZConstPoolNode;
import zen.ast.ZFloatNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZIntNode;
import zen.ast.ZNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZStringNode;
import zen.type.ZType;

public abstract class ZNodeUtils {
	//	public final ZenNode CreateUnsupportedNode(ZenType Type, ZenSyntaxTree ParsedTree) {
	//		@Var ZenToken Token = ParsedTree.KeyToken;
	//		this.Context.ReportError(ZenConsts.ErrorLevel, Token, this.TargetCode + " has no language support for " + Token.ParsedText);
	//		return new ZenErrorNode(ZenSystem.VoidType, ParsedTree.KeyToken);
	//	}

	public final static ZNode CreateConstNode(ZToken SourceToken, Object Value) {
		if(Value instanceof Boolean) {
			return new ZBooleanNode(SourceToken, (Boolean) Value);
		}
		if((Value instanceof Long) || (Value instanceof Integer)) {
			return new ZIntNode(SourceToken, ((Number)Value).longValue());
		}
		if((Value instanceof Double) || (Value instanceof Float)) {
			return new ZFloatNode(SourceToken, ((Number)Value).doubleValue());
		}
		if(Value instanceof String) {
			return new ZStringNode(SourceToken, Value.toString());
		}
		return new ZConstPoolNode(SourceToken, Value);
	}

	public final static ZNode CreateSymbolNode(ZToken SourceToken, ZType Type, String NativeName, ZNode AssignedNode) {
		if(AssignedNode != null) {
			return new ZSetNameNode(SourceToken, NativeName, AssignedNode);
		}
		else {
			return new ZGetNameNode(SourceToken, NativeName);
		}
	}
}