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

//ifdef JAVA
package zen.parser;

import zen.ast.ZListNode;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZArray;



public final class ZSourceBuilder {
	@Field public ZArray<String> SourceList = new ZArray<String>(new String[128]);
	@Field ZSourceGenerator Template;
	@Field int IndentLevel = 0;
	@Field String CurrentIndentString = "";
	@Field String BufferedLineComment = "";

	public ZSourceBuilder(ZSourceGenerator Template) {
		this.Template = Template;
	}

	public void Clear() {
		this.SourceList.clear(0);
	}

	public void Append(String Text) {
		this.SourceList.add(Text);
	}

	public final void AppendLineFeed() {
		if (this.BufferedLineComment.length() > 0) {
			this.SourceList.add(this.BufferedLineComment);
			this.BufferedLineComment = "";
		}
		this.SourceList.add(this.Template.LineFeed);
	}

	public final void AppendWhiteSpace() {
		if(this.SourceList.size() > 0) {
			@Var String Last = this.SourceList.ArrayValues[this.SourceList.size()-1];
			if(Last.endsWith(" ") || Last.endsWith("\n") || Last.endsWith("\t")) {
				return;
			}
		}
		this.SourceList.add(" ");
	}

	public void AppendToken(String Text) {
		this.AppendWhiteSpace();
		this.SourceList.add(Text);
		this.AppendWhiteSpace();
	}

	public final void AppendBlockComment(String Text) {
		if (this.Template.BeginComment != null) {
			this.SourceList.add(this.Template.BeginComment);
			this.SourceList.add(Text);
			this.SourceList.add(this.Template.EndComment);
		} else if (this.Template.LineComment != null) {
			this.BufferedLineComment = this.BufferedLineComment + this.Template.LineComment + Text;
		}
	}

	public final void AppendCommentLine(String Text) {
		if (this.Template.LineComment == null) {
			this.SourceList.add(this.Template.BeginComment);
			this.SourceList.add(Text);
			this.SourceList.add(this.Template.EndComment);
		} else {
			this.SourceList.add(this.Template.LineComment);
			this.SourceList.add(Text);
		}
		this.SourceList.add(this.Template.LineFeed);
	}

	public final void Indent() {
		this.IndentLevel = this.IndentLevel + 1;
		this.CurrentIndentString = null;
	}

	public final void UnIndent() {
		this.IndentLevel = this.IndentLevel - 1;
		this.CurrentIndentString = null;
		LibZen._Assert(this.IndentLevel >= 0);
	}

	private final String GetIndentString() {
		if (this.CurrentIndentString == null) {
			this.CurrentIndentString = LibZen._JoinStrings(this.Template.Tab, this.IndentLevel);
		}
		return this.CurrentIndentString;
	}

	public final void AppendIndent() {
		this.SourceList.add(this.GetIndentString());
	}

	public final void IndentAndAppend(String Text) {
		this.SourceList.add(this.GetIndentString());
		this.SourceList.add(Text);
	}

	public final void AppendParamList(ZListNode ParamList, int BeginIdx, int EndIdx) {
		@Var int i = BeginIdx;
		while(i < EndIdx) {
			if (i > BeginIdx) {
				this.Append(this.Template.Camma);
			}
			ParamList.GetListAt(i).Accept(this.Template);
			i = i + 1;
		}
	}

	@Override public String toString() {
		return LibZen._SourceBuilderToString(this);
	}

	@Deprecated public void AppendLine(String Text) {
		this.Append(Text);
		this.AppendLineFeed();
	}
}
