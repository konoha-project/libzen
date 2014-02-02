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
package zen.lang;
import java.util.ArrayList;

import zen.deps.LibNative;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.deps.ZenTypedObject;
import zen.obsolete.ZFuncSet;
import zen.type.ZType;

public class ZSystem {
	public final static ZenMap<Integer>     SourceMap = new ZenMap<Integer>(null);
	public final static ArrayList<String>   SourceList = new ArrayList<String>();

	public final static long GetFileLine(String FileName, int Line) {
		@Var Object IdOrNull = ZSystem.SourceMap.GetOrNull(FileName);
		@Var Integer Id = IdOrNull == null ? -1 : (Integer)IdOrNull;
		if(IdOrNull == null) {
			ZSystem.SourceList.add(FileName);
			Id = ZSystem.SourceList.size();
			ZSystem.SourceMap.put(FileName, Id);
		}
		return LibZen.JoinIntId(Id, Line);
	}

	public final static String GetSourceFileName(long FileLine) {
		@Var int FileId = LibZen.UpperId(FileLine);
		return (FileId == 0) ? null : ZSystem.SourceList.get(FileId - 1);
	}

	public final static int GetFileLineNumber(long FileLine) {
		return LibZen.LowerId(FileLine);
	}

	public final static String FormatFileLineNumber(long FileLine) {
		@Var int FileId = LibZen.UpperId(FileLine);
		@Var int Line = LibZen.LowerId(FileLine);
		@Var String FileName = (FileId == 0) ? "eval" : ZSystem.SourceList.get(FileId - 1);
		return "(" + FileName + ":" + Line + ")";
	}


	//	public final static ZType LookupTypeTable(String Key) {
	//		return ZTypePool.ClassNameMap.GetOrNull(Key);
	//	}
	//
	//	public final static void SetTypeTable(String Key, ZType Type) {
	//		ZTypePool.ClassNameMap.put(Key, Type);
	//		ZLogger.VerboseLog(ZLogger.VerboseSymbol, "global type name: " + Key + ", " + Type);
	//	}

	public final static ZType GetNativeTypeOfValue(Object Value) {
		return LibNative.GetNativeType(LibNative.GetClassOfValue(Value));
	}

	public final static ZType GuessType (Object Value) {
		if(Value instanceof ZFunc) {
			return ((ZFunc)Value).GetFuncType();
		}
		else if(Value instanceof ZFuncSet) {
			return ZType.FuncType;
		}
		else if(Value instanceof ZenTypedObject) {
			return ((ZenTypedObject)Value).GetZenType();
		}
		else {
			return ZSystem.GetNativeTypeOfValue(Value);
		}
	}

	public final static boolean CheckSubType(ZType SubType, ZType SuperType) {
		// TODO: Structual Typing database
		return false;
	}

	public static ZFunc GetConverterFunc(ZType ValueType, ZType CastType, boolean SearchRecursive) {
		// TODO Auto-generated method stub
		return null;
	}


}
