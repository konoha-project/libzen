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

package zen.obsolete;

import zen.parser.ZNameSpace;
import zen.parser.ZUtils;

@Deprecated
public final class ZenTypeEnv extends ZUtils {
//	@Field public final ZenParserContext    Context;
//	@Field public final ZenGenerator        Generator;
//	@Field public ZenNameSpace	    NameSpace;
//
//	@Field public ArrayList<ZenVariableInfo> LocalStackList;
//	@Field public int StackTopIndex;
//	@Field public ZenFuncBlock	FuncBlock;
//	@Field public boolean FoundUncommonFunc;
	
	public ZenTypeEnv/*constructor*/(ZNameSpace NameSpace) {
//		this.NameSpace = NameSpace;
//		this.Context   = NameSpace.Context;
//		this.Generator = NameSpace.Context.Generator;
//		this.FuncBlock = null;
//		this.FoundUncommonFunc = false;
//		this.LocalStackList = new ArrayList<ZenVariableInfo>();
//		this.StackTopIndex = 0;
	}

//	public final boolean IsStrictMode() {
//		return this.Generator.IsStrictMode();
//	}
//
//	public final boolean IsTopLevel() {
//		return (this.FuncBlock == null);
//	}
//
//	public void AppendRecv(ZenType RecvType) {
//		@Var String ThisName = this.Generator.GetRecvName();
//		this.AppendDeclaredVariable(0, RecvType, ThisName, null, null);
//		this.LocalStackList.get(this.StackTopIndex-1).NativeName = ThisName;
//	}
//
//	public ZenVariableInfo AppendDeclaredVariable(int VarFlag, ZenType Type, String Name, ZenToken NameToken, Object InitValue) {
//		@Var ZenVariableInfo VarInfo = new ZenVariableInfo(this.FuncBlock, VarFlag, Type, Name, NameToken /*InitValue*/);
//		if(this.StackTopIndex < this.LocalStackList.size()) {
//			this.LocalStackList.set(this.StackTopIndex, VarInfo);
//		}
//		else {
//			this.LocalStackList.add(VarInfo);
//		}
//		this.StackTopIndex += 1;
//		return VarInfo;
//	}
//
//	public ZenVariableInfo LookupDeclaredVariable(String Symbol) {
//		@Var int i = this.StackTopIndex - 1;
//		while(i >= 0) {
//			@Var ZenVariableInfo VarInfo = this.LocalStackList.get(i);
//			if(VarInfo.Name.equals(Symbol)) {
//				return VarInfo;
//			}
//			i = i - 1;
//		}
//		return null;
//	}
//
//	public void PushBackStackIndex(int PushBackIndex) {
//		@Var int i = this.StackTopIndex - 1;
//		while(i >= PushBackIndex) {
//			@Var ZenVariableInfo VarInfo = this.LocalStackList.get(i);
//			VarInfo.Check(this.Context);
//			i = i - 1;
//		}
//		this.StackTopIndex = PushBackIndex;
//	}
//	
//	public void CheckFunc(String FuncType, ZenFunc Func, ZenToken SourceToken) {
//		// FIXME
////		if(!this.FoundUncommonFunc && (!Func.Is(CommonFunc))) {
////			this.FoundUncommonFunc = true;
////			if(this.Func != null && this.Func.Is(CommonFunc)) {
////				this.NameSpace.Context.ReportError(ZenConsts.WarningLevel, SourceToken, "using uncommon " + FuncType + ": " + Func.FuncName);
////			}
////		}
//	}
//
//	public final ZenNode ReportTypeResult(ZenSyntaxTree ParsedTree, ZenNode Node, int Level, String Message) {
//		if(Level == ErrorLevel || (this.IsStrictMode() && Level == TypeErrorLevel)) {
//			LibZen.Assert(Node.SourceToken == ParsedTree.KeyToken);
//			this.NameSpace.Context.ReportError_OLD(ZenConsts.ErrorLevel, Node.SourceToken, Message);
//			return this.Generator.CreateErrorNode(ZenSystem.VoidType, ParsedTree);
//		}
//		else {
//			this.NameSpace.Context.ReportError_OLD(Level, Node.SourceToken, Message);
//		}
//		return Node;
//	}
//
//	public final void ReportTypeInference(ZenToken SourceToken, String Name, ZenType InfferedType) {
//		this.Context.ReportError_OLD(ZenConsts.InfoLevel, SourceToken, Name + " has type " + InfferedType);
//	}
//
//	public final ZenNode CreateSyntaxErrorNode(ZenSyntaxTree ParsedTree, String Message) {
//		this.NameSpace.Context.ReportError_OLD(ZenConsts.ErrorLevel, ParsedTree.KeyToken, Message);
//		return this.Generator.CreateErrorNode(ZenSystem.VoidType, ParsedTree);
//	}
//
//	public final ZenNode UnsupportedTopLevelError(ZenSyntaxTree ParsedTree) {
//		return this.CreateSyntaxErrorNode(ParsedTree, "unsupported " + ParsedTree.Pattern.PatternName + " at the top level");
//	}
//
//	public final ZenNode CreateLocalNode(ZenSyntaxTree ParsedTree, String Name) {
//		@Var ZenVariableInfo VariableInfo = this.LookupDeclaredVariable(Name);
//		if(VariableInfo != null) {
//			return this.Generator.CreateGetLocalNode(VariableInfo.Type, ParsedTree, VariableInfo.NativeName);
//		}
//		return this.CreateSyntaxErrorNode(ParsedTree, "unresolved name: " + Name + "; not your fault");
//	}
//
//	public final ZenNode CreateDefaultValue(ZenSyntaxTree ParsedTree, ZenType Type) {
//		return this.Generator.CreateConstNode_OLD(Type, ParsedTree, Type.DefaultNullValue);
//	}
//
//	public final ZenNode TypeCheckSingleNode(ZenSyntaxTree ParsedTree, ZenNode Node, ZenType Type, int TypeCheckPolicy) {
//		LibZen.Assert(Node != null);
//		if(Node.IsErrorNode() || IsFlag(TypeCheckPolicy, NoCheckPolicy)) {
//			return Node;
//		}
//		if(Node.Type.IsUnrevealedType()) {
//			@Var ZenFunc Func = ParsedTree.NameSpace.GetConverterFunc(Node.Type, Node.Type.BaseType, true);
//			Node = this.Generator.CreateCoercionNode(Func.GetReturnType(), ParsedTree.NameSpace, Func, Node);
//		}
//		//System.err.println("**** " + Node.getClass());
//		@Var Object ConstValue = Node.ToConstValue(this.Context, IsFlag(TypeCheckPolicy, OnlyConstPolicy));
//		if(ConstValue != null && !(Node.IsConstNode())) {  // recreated
//			Node = this.Generator.CreateConstNode_OLD(Node.Type, ParsedTree, ConstValue);
//		}
//		if(IsFlag(TypeCheckPolicy, OnlyConstPolicy) && ConstValue == null) {
//			if(IsFlag(TypeCheckPolicy, NullablePolicy) && Node.IsNullNode()) { // OK
//			}
//			else {
//				return this.CreateSyntaxErrorNode(ParsedTree, "value must be const");
//			}
//		}
//		if(IsFlag(TypeCheckPolicy, AllowVoidPolicy) || Type.IsVoidType()) {
//			return Node;
//		}
//		if(Node.Type.IsVarType()) {
//			return this.ReportTypeResult(ParsedTree, Node, TypeErrorLevel, "unspecified type: " + Node.SourceToken.ParsedText);
//		}
//		if(Node.Type == Type || Type.IsVarType() || Type.Accept(Node.Type)) {
//			return Node;
//		}
//		@Var ZenFunc Func1 = ParsedTree.NameSpace.GetConverterFunc(Node.Type, Type, true);
//		if(Func1 != null && (Func1.Is(CoercionFunc) || IsFlag(TypeCheckPolicy, CastPolicy))) {
//			return this.Generator.CreateCoercionNode(Type, ParsedTree.NameSpace, Func1, Node);
//		}
//		
//		//System.err.println("node="+ LibZen.GetClassName(Node) + "type error: requested = " + Type + ", given = " + Node.Type);
//		return this.ReportTypeResult(ParsedTree, Node, TypeErrorLevel, "type error: requested = " + Type + ", given = " + Node.Type);
//	}
//
//	public ZenNode ParseTypedNode(String Text, long FileLine, ZenType ContextType) {
//		@Var ZenNameSpace NameSpace = this.NameSpace;
//		@Var ZenTokenContext LocalContext = new ZenTokenContext(NameSpace, Text, FileLine);
//		@Var ZenSyntaxTree ParsedTree = LocalContext.ParsePattern_OLD(NameSpace, "$Expression$", Required);
//		return ZenUtils.TypeBlock(this, ParsedTree, ContextType);
//	}
}
