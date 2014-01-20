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

import zen.deps.Var;


public class ZUtils {
	public final static boolean IsFlag(int flag, int flag2) {
		return ((flag & flag2) == flag2);
	}

	public final static int UnsetFlag(int flag, int flag2) {
		return (flag & (~flag2));
	}

	public final static String JoinStrings(String Unit, int Times) {
		@Var String s = "";
		@Var int i = 0;
		while(i < Times) {
			s = s + Unit;
			i = i + 1;
		}
		return s;
	}

	public final static int AsciiToTokenMatrixIndex(char c) {
		if(c < 128) {
			return ZParserConst.CharMatrix[c];
		}
		return ZParserConst.UnicodeChar;
	}

	public final static String NativeVariableName(String Name, int Index) {
		return Name + ZParserConst.NativeNameSuffix + Index;
	}

	//	public final static boolean IsMismatchedOrError(ZenSyntaxTree Tree) {
	//		return (Tree == null || Tree.IsMismatchedOrError());
	//	}
	//
	//	public final static boolean IsValidSyntax(ZenSyntaxTree Tree) {
	//		return !(ZenUtils.IsMismatchedOrError(Tree));
	//	}
	//
	//	public final static ZenSyntaxTree TreeHead(ZenSyntaxTree Tree) {
	//		if(Tree != null) {
	//			while(Tree.PrevTree != null) {
	//				Tree = Tree.PrevTree;
	//			}
	//		}
	//		return Tree;
	//	}
	//
	//	public final static ZenSyntaxTree TreeTail(ZenSyntaxTree Tree) {
	//		if(Tree != null) {
	//			while(Tree.NextTree != null) {
	//				Tree = Tree.NextTree;
	//			}
	//		}
	//		return Tree;
	//	}
	//
	//	public final static ZenSyntaxTree LinkTree(ZenSyntaxTree LastNode, ZenSyntaxTree Node) {
	//		Node.PrevTree = LastNode;
	//		if(LastNode != null) {
	//			LastNode.NextTree = Node;
	//		}
	//		return ZenUtils.TreeTail(Node);
	//	}

	//	public final static ZenSyntaxTree ApplySyntaxPattern_OLD(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftNode, ZenSyntaxPattern Pattern) {
	//		@Var int Pos = TokenContext.GetPosition(0);
	//		@Var int ParseFlag = TokenContext.ParseFlag;
	//		@Var ZenSyntaxPattern CurrentPattern = Pattern;
	//		while(CurrentPattern != null) {
	//			@Var ZenFunc delegate = CurrentPattern.MatchFunc;
	//			TokenContext.RollbackPosition(Pos, 0);
	//			if(CurrentPattern.ParentPattern != null) {   // This means it has next patterns
	//				TokenContext.ParseFlag = ParseFlag | BackTrackParseFlag;
	//			}
	//			//LibZen.DebugP("B :" + JoinStrings("  ", TokenContext.IndentLevel) + CurrentPattern + ", next=" + CurrentPattern.ParentPattern);
	//			TokenContext.IndentLevel += 1;
	//			@Var ZenSyntaxTree ParsedTree = LibNative.ApplyParseFunc(delegate, NameSpace, TokenContext, LeftNode, CurrentPattern);
	//			TokenContext.IndentLevel -= 1;
	//			TokenContext.ParseFlag = ParseFlag;
	//			if(ParsedTree != null && ParsedTree.IsMismatched()) {
	//				ParsedTree = null;
	//			}
	//			//LibZen.DebugP("E :" + JoinStrings("  ", TokenContext.IndentLevel) + CurrentPattern + " => " + ParsedTree);
	//			if(ParsedTree != null) {
	//				return ParsedTree;
	//			}
	//			CurrentPattern = CurrentPattern.ParentPattern;
	//		}
	//		if(TokenContext.IsAllowedBackTrack()) {
	//			TokenContext.RollbackPosition(Pos, 0);
	//		}
	//		else {
	//			TokenContext.SkipErrorStatement();
	//		}
	//		if(Pattern == null) {
	//			LibZen.VerboseLog(VerboseUndefined, "undefined syntax pattern: " + Pattern);
	//		}
	//		return TokenContext.ReportExpectedPattern_OLD(Pattern);
	//	}

	//
	//	// typing
	//	public final static ZenNode ApplyTypeFunc(ZenFunc TypeFunc, ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType Type) {
	//		if(TypeFunc != null) {
	//			Gamma.NameSpace = ParsedTree.NameSpace;
	//			return LibNative.ApplyTypeFunc(TypeFunc, Gamma, ParsedTree, Type);
	//		}
	//		return Gamma.Generator.CreateEmptyNode(ZenSystem.VoidType);
	//	}
}