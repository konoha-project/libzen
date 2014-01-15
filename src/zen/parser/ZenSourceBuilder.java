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

import java.util.ArrayList;

import zen.ast.ZenNode;
import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;

//endif VAJA

public class ZenSourceBuilder {
	@Field public ArrayList<String> SourceList;
	@Field ZenSourceGenerator Template;
	@Field int IndentLevel = 0;
	@Field String CurrentIndentString;
	@Field String BufferedLineComment;

	public ZenSourceBuilder(ZenSourceGenerator Template) {
		this.Template = Template;
		this.SourceList = new ArrayList<String>();
		this.IndentLevel = 0;
		this.CurrentIndentString = "";
		this.BufferedLineComment = "";
	}

	public void Clear() {
		this.SourceList.clear();
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
			@Var String Last = this.SourceList.get(this.SourceList.size()-1);
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
		this.IndentLevel += 1;
		this.CurrentIndentString = null;
	}

	public final void UnIndent() {
		this.IndentLevel -= 1;
		this.CurrentIndentString = null;
		LibNative.Assert(this.IndentLevel >= 0);
	}

	private final String GetIndentString() {
		if (this.CurrentIndentString == null) {
			this.CurrentIndentString = ZenUtils.JoinStrings(this.Template.Tab,
					this.IndentLevel);
		}
		return this.CurrentIndentString;
	}

	public void AppendIndent() {
		this.SourceList.add(this.GetIndentString());
	}

	public void IndentAndAppend(String Text) {
		this.SourceList.add(this.GetIndentString());
		this.SourceList.add(Text);
	}

	public void AppendParamList(ArrayList<ZenNode> ParamList, int BeginIdx, int EndIdx) {
		for(@Var int i = BeginIdx; i < EndIdx; i = i + 1) {
			if (i > BeginIdx) {
				this.Append(this.Template.Camma);
			}
			ParamList.get(i).Accept(this.Template);
		}
	}

	@Override
	public String toString() {
		return LibZen.SourceBuilderToString(this);
	}

	@Deprecated
	public void AppendLine(String Text) {
		this.Append(Text);
		this.AppendLineFeed();
	}
}
