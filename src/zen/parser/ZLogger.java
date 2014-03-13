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

import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZArray;

public final class ZLogger {

	@Field public ZArray<String>  ReportedErrorList = new ZArray<String>(new String[10]);
	//	@Field public ZenMap<ZCounter> StatMap;

	//	public ZLogger() {
	//		if(LibZen._GetEnv("ZENSTAT") != null) {
	//			this.StatMap = new ZenMap<ZCounter>(null);
	//		}
	//		else {
	//		this.StatMap = null;
	//		}
	//	}

	final void Report(String Message) {
		this.ReportedErrorList.add(Message);
	}

	public final static void _LogErrorExit(ZToken Token, String Message) {
		if(Token != null && Token.Source != null) {
			Message = Token.Source.FormatErrorMarker("error", Token.StartIndex, Message);
			Token.Source.Logger.Report(Message);
		}
		else {
			LibZen._Exit(1, Message);
		}
	}

	public final static String _LogError(ZToken Token, String Message) {
		if(Token != null && Token.Source != null) {
			Message = Token.Source.FormatErrorMarker("error", Token.StartIndex, Message);
			Token.Source.Logger.Report(Message);
		}
		return Message;
	}

	public final static void _LogWarning(ZToken Token, String Message) {
		if(Token != null) {
			Message = Token.Source.FormatErrorMarker("warning", Token.StartIndex, Message);
			Token.Source.Logger.Report(Message);
		}
	}

	public final static void _LogInfo(ZToken Token, String Message) {
		if(Token != null && Token.Source != null) {
			Message = Token.Source.FormatErrorMarker("info", Token.StartIndex, Message);
			Token.Source.Logger.Report(Message);
		}
	}

	public final static void _LogDebug(ZToken Token, String Message) {
		if(Token != null && Token.Source != null) {
			Message = Token.Source.FormatErrorMarker("debug", Token.StartIndex, Message);
			Token.Source.Logger.Report(Message);
		}
	}

	public final String[] GetReportedErrors() {
		@Var ZArray<String> List = this.ReportedErrorList;
		this.ReportedErrorList = new ZArray<String>(new String[10]);
		return List.CompactArray();
	}

	public final void OutputErrorsToStdErr() {
		@Var String[] Messages = this.GetReportedErrors();
		@Var int i = 0;
		while(i < Messages.length) {
			LibZen._PrintLine(Messages[i]);
			i = i + 1;
		}
	}

	//	public final void Count(String EventName) {
	//		if(this.StatMap != null) {
	//			@Var ZCounter Counter = this.StatMap.GetOrNull(EventName);
	//			if(Counter == null) {
	//				Counter = new ZCounter();
	//				this.StatMap.put(EventName, Counter);
	//			}
	//			else {
	//				Counter.count = Counter.count + 1;
	//			}
	//		}
	//	}
	//
	//	public final void CountCreation(Object CreatedObject) {
	//		if(this.StatMap != null) {
	//			@Var String EventName = "CreationOf" + LibZen.GetClassName(CreatedObject);
	//			@Var ZCounter Counter = this.StatMap.GetOrNull(EventName);
	//			if(Counter == null) {
	//				Counter = new ZCounter();
	//				this.StatMap.put(EventName, Counter);
	//			}
	//			else {
	//				Counter.count = Counter.count + 1;
	//			}
	//		}
	//	}

}

//class ZCounter {
//	@Field public int count = 1;
//	ZCounter() {
//	}
//}
