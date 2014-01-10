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

import zen.ast.ZenBooleanNode;
import zen.ast.ZenConstPoolNode;
import zen.ast.ZenFloatNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenIntNode;
import zen.ast.ZenNode;
import zen.ast.ZenSetLocalNode;
import zen.ast.ZenStringNode;
import zen.lang.ZenType;

public abstract class ZenNodeUtils {
	//	public final ZenNode CreateUnsupportedNode(ZenType Type, ZenSyntaxTree ParsedTree) {
	//		@Var ZenToken Token = ParsedTree.KeyToken;
	//		this.Context.ReportError(GreenTeaConsts.ErrorLevel, Token, this.TargetCode + " has no language support for " + Token.ParsedText);
	//		return new ZenErrorNode(ZenStaticTable.VoidType, ParsedTree.KeyToken);
	//	}

	public final static ZenNode CreateConstNode(ZenToken SourceToken, Object Value) {
		if(Value instanceof Boolean) {
			return new ZenBooleanNode(SourceToken, (Boolean) Value);
		}
		if((Value instanceof Long) || (Value instanceof Integer)) {
			return new ZenIntNode(SourceToken, ((Number)Value).longValue());
		}
		if((Value instanceof Double) || (Value instanceof Float)) {
			return new ZenFloatNode(SourceToken, ((Number)Value).doubleValue());
		}
		if(Value instanceof String) {
			return new ZenStringNode(SourceToken, Value.toString());
		}
		return new ZenConstPoolNode(SourceToken, Value);
	}

	public final ZenNode CreateSymbolNode(ZenToken SourceToken, ZenType Type, String NativeName, ZenNode AssignedNode) {
		if(AssignedNode != null) {
			return new ZenSetLocalNode(SourceToken, NativeName, AssignedNode);
		}
		else {
			return new ZenGetLocalNode(SourceToken, NativeName);
		}
	}
}