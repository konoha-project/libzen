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

import java.util.ArrayList;

import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMap;

public final class ZLogger {
	public final static int	_ErrorLevel						= 0;
	public final static int _TypeErrorLevel                 = 1;
	public final static int	_WarningLevel					= 2;
	public final static int	_InfoLevel					    = 3;
	public final static int	_DebugLevel					    = 4;

	@Field public ArrayList<String>  ReportedErrorList = new ArrayList<String>();
	@Field public ZenMap<ZCounter> StatMap;

	public ZLogger() {
		if(LibZen._GetEnv("ZENSTAT") != null) {
			this.StatMap = new ZenMap<ZCounter>(null);
		}
		else {
			this.StatMap = null;
		}
	}

	public final void Report(String Message) {
		this.ReportedErrorList.add(Message);
	}

	public final String Report(int Level, ZToken Token, String Message) {
		if(Token != null && !Token.IsNull()) {
			if(Level == ZLogger._ErrorLevel) {
				Message = Token.Source.MakeBody("error", Token.StartIndex, Message);
			}
			else if(Level == ZLogger._TypeErrorLevel) {
				Message = Token.Source.MakeBody("error", Token.StartIndex, Message);
			}
			else if(Level == ZLogger._WarningLevel) {
				Message = Token.Source.MakeBody("warning", Token.StartIndex, Message);
			}
			else if(Level == ZLogger._InfoLevel) {
				Message = Token.Source.MakeBody("info", Token.StartIndex, Message);
			}
			else {
				Message = Token.Source.MakeBody("debug", Token.StartIndex, Message);
			}
			this.ReportedErrorList.add(Message);
		}
		else {
			LibZen.DebugP("unknown source error:" + Message);
		}
		return Message;
	}

	public final String ReportError(ZToken Token, String Message) {
		return this.Report(ZLogger._ErrorLevel, Token, Message);
	}

	public final String ReportWarning(ZToken Token, String Message) {
		return this.Report(ZLogger._WarningLevel, Token, Message);
	}

	public final String ReportInfo(ZToken Token, String Message) {
		return this.Report(ZLogger._InfoLevel, Token, Message);
	}

	public final String ReportDebug(ZToken Token, String Message) {
		return this.Report(ZLogger._DebugLevel, Token, Message);
	}

	public final String[] GetReportedErrors() {
		@Var ArrayList<String> List = this.ReportedErrorList;
		this.ReportedErrorList = new ArrayList<String>();
		return LibZen.CompactStringList(List);
	}

	public final void ShowErrors() {
		@Var String[] Messages = this.GetReportedErrors();
		for(@Var int i = 0; i < Messages.length; i = i + 1) {
			LibZen._PrintLine(Messages[i]);
		}
	}

	public final void Count(String EventName) {
		if(this.StatMap != null) {
			ZCounter Counter = this.StatMap.GetOrNull(EventName);
			if(Counter == null) {
				Counter = new ZCounter();
				this.StatMap.put(EventName, Counter);
			}
			else {
				Counter.count = Counter.count + 1;
			}
		}
	}

	public final void CountCreation(Object CreatedObject) {
		if(this.StatMap != null) {
			@Var String EventName = "CreationOf" + LibZen.GetClassName(CreatedObject);
			@Var ZCounter Counter = this.StatMap.GetOrNull(EventName);
			if(Counter == null) {
				Counter = new ZCounter();
				this.StatMap.put(EventName, Counter);
			}
			else {
				Counter.count = Counter.count + 1;
			}
		}
	}

	public static void ParseVerboseOption() {

	}

}

class ZCounter {
	@Field public int count = 1;
	ZCounter() {
	}
}
