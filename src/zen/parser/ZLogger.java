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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import zen.deps.Field;
import zen.deps.Init;
import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMap;

public final class ZLogger {
	public final static int	ErrorLevel						= 0;
	public final static int TypeErrorLevel                  = 1;
	public final static int	WarningLevel					= 2;
	public final static int	InfoLevel					    = 3;
	public final static int	DebugLevel					    = 4;

	public final static int VerboseRuntime   = (1 << 9);
	public final static int VerboseException = (1 << 8);
	public final static int VerboseFile      = (1 << 7);
	public final static int VerboseNative    = (1 << 6);
	public final static int VerboseUndefined   = (1 << 5);
	public final static int VerboseToken     = (1 << 4);
	public final static int VerboseEval      = (1 << 3);
	public final static int VerboseFunc      = (1 << 2);
	public final static int VerboseType      = (1 << 1);
	public final static int VerboseSymbol    = 1;

	@Field public ArrayList<String>  ReportedErrorList = new ArrayList<String>();
	@Field public ZenMap<ZCounter> StatMap;

	public ZLogger() {
		if(LibNative.GetEnv("ZENSTAT") != null) {
			this.StatMap = new ZenMap<ZCounter>(null);
		}
		else {
			this.StatMap = null;
		}
	}

	public final void Report(String Message) {
		this.ReportedErrorList.add(Message);
		LibNative.println(Message);
	}

	public final String Report(int Level, ZToken Token, String Message) {
		//		if(Token != null && !Token.IsNull()) {
		//			Token.Source
		//			if(Level == ZLogger.ErrorLevel) {
		//				Message = "(error) " + ZSystem.FormatFileLineNumber(Token.FileLine) + " " + Message;
		//			}
		//			else if(Level == ZLogger.TypeErrorLevel) {
		//				Message = "(error) " + ZSystem.FormatFileLineNumber(Token.FileLine) + " " + Message;
		//			}
		//			else if(Level == ZLogger.WarningLevel) {
		//				Message = "(warning) " + ZSystem.FormatFileLineNumber(Token.FileLine) + " " + Message;
		//			}
		//			else if(Level == ZLogger.InfoLevel) {
		//				Message = "(info) " + ZSystem.FormatFileLineNumber(Token.FileLine) + " " + Message;
		//			}
		//			else {
		//				Message = "(debug) " + ZSystem.FormatFileLineNumber(Token.FileLine) + " " + Message;
		//			}
		//			this.ReportedErrorList.add(Message);
		//		}
		//		else {
		//			LibZen.DebugP("unknown source error:" + Message);
		//		}
		return Message;
	}

	public final String ReportError(ZToken Token, String Message) {
		return this.Report(ErrorLevel, Token, Message);
	}

	public final String ReportWarning(ZToken Token, String Message) {
		return this.Report(WarningLevel, Token, Message);
	}

	public final String ReportInfo(ZToken Token, String Message) {
		return this.Report(InfoLevel, Token, Message);
	}

	public final String ReportDebug(ZToken Token, String Message) {
		return this.Report(DebugLevel, Token, Message);
	}

	public final String[] GetReportedErrors() {
		@Var ArrayList<String> List = this.ReportedErrorList;
		this.ReportedErrorList = new ArrayList<String>();
		return LibZen.CompactStringList(List);
	}

	public final void ShowReportedErrors() {
		@Var String[] Messages = this.GetReportedErrors();
		for(@Var int i = 0; i < Messages.length; i = i + 1) {
			LibNative.println(Messages[i]);
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
			@Var String EventName = "CreationOf" + LibNative.GetClassName(CreatedObject);
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

	public static int VerboseMask = ZLogger.VerboseUndefined | ZLogger.VerboseException;

	public final static void TODO(String msg) {
		LibNative.println("TODO" + LibZen.GetStackInfo(2) + ": " + msg);
	}

	public final static void VerboseException(Throwable e) {
		if(e instanceof InvocationTargetException) {
			Throwable cause = e.getCause();
			e = cause;
			if(cause instanceof RuntimeException) {
				throw (RuntimeException)cause;
			}
			if(cause instanceof Error) {
				throw (Error)cause;
			}
		}
		VerboseLog(VerboseException, e.toString());
		e.printStackTrace();
		if(e instanceof IllegalArgumentException) {
			LibNative.Exit(1, e.toString());
		}

	}

	public final static void VerboseLog(int VerboseFlag, String Message) {
		if((VerboseMask & VerboseFlag) == VerboseFlag) {
			LibNative.println("LibZen: " + Message);
		}
	}

	public static void ParseVerboseOption() {

	}

}

class ZCounter {
	@Field @Init public int count = 1;
	ZCounter() {
	}
}
