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

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZBreakNode;
import zen.ast.ZCastNode;
import zen.ast.ZCatchNode;
import zen.ast.ZClassDeclNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZLetNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewArrayNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZSymbolNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;

public abstract class ZVisitor {
	//	public abstract void VisitEmptyNode(ZEmptyNode Node);
	public abstract void VisitNullNode(ZNullNode Node);
	public abstract void VisitBooleanNode(ZBooleanNode Node);
	public abstract void VisitIntNode(ZIntNode Node);
	public abstract void VisitFloatNode(ZFloatNode Node);
	public abstract void VisitStringNode(ZStringNode Node);
	public abstract void VisitArrayLiteralNode(ZArrayLiteralNode Node);
	public abstract void VisitMapLiteralNode(ZMapLiteralNode Node);
	public abstract void VisitNewArrayNode(ZNewArrayNode Node);
	public abstract void VisitNewObjectNode(ZNewObjectNode Node);
	public abstract void VisitSymbolNode(ZSymbolNode Node);
	public abstract void VisitGetNameNode(ZGetNameNode Node);
	public abstract void VisitSetNameNode(ZSetNameNode Node);
	public abstract void VisitGroupNode(ZGroupNode Node);
	public abstract void VisitGetterNode(ZGetterNode Node);
	public abstract void VisitSetterNode(ZSetterNode Node);
	public abstract void VisitGetIndexNode(ZGetIndexNode Node);
	public abstract void VisitSetIndexNode(ZSetIndexNode Node);
	public abstract void VisitMethodCallNode(ZMethodCallNode Node);
	public abstract void VisitFuncCallNode(ZFuncCallNode Node);
	public abstract void VisitUnaryNode(ZUnaryNode Node);
	public abstract void VisitNotNode(ZNotNode Node);
	public abstract void VisitCastNode(ZCastNode Node);
	public abstract void VisitInstanceOfNode(ZInstanceOfNode Node);
	public abstract void VisitBinaryNode(ZBinaryNode Node);
	public abstract void VisitComparatorNode(ZComparatorNode Node);
	public abstract void VisitAndNode(ZAndNode Node);
	public abstract void VisitOrNode(ZOrNode Node);
	public abstract void VisitBlockNode(ZBlockNode Node);
	public abstract void VisitVarDeclNode(ZVarDeclNode Node);
	public abstract void VisitIfNode(ZIfNode Node);
	public abstract void VisitReturnNode(ZReturnNode Node);
	public abstract void VisitWhileNode(ZWhileNode Node);
	public abstract void VisitBreakNode(ZBreakNode Node);
	public abstract void VisitThrowNode(ZThrowNode Node);
	public abstract void VisitTryNode(ZTryNode Node);
	public abstract void VisitCatchNode(ZCatchNode Node);
	//	public abstract void VisitParamNode(ZParamNode Node);
	public abstract void VisitLetNode(ZLetNode Node);
	public abstract void VisitFunctionNode(ZFunctionNode Node);
	//	public abstract void VisitFuncDeclNode(ZFunctionNode/*Decl*/ Node);
	public abstract void VisitClassDeclNode(ZClassDeclNode Node);
	public abstract void VisitErrorNode(ZErrorNode Node);
	public abstract void VisitExtendedNode(ZNode Node);


	public abstract void EnableVisitor();
	public abstract void StopVisitor();
	public abstract boolean IsVisitable();

	//	public abstract void VisitTrinaryNode(ZenTrinaryNode Node);
	//	public abstract void VisitPrefixInclNode(ZenPrefixInclNode Node);
	//	public abstract void VisitPrefixDeclNode(ZenPrefixDeclNode Node);
	//	public abstract void VisitSuffixInclNode(ZenSuffixInclNode Node);
	//	public abstract void VisitSuffixDeclNode(ZenSuffixDeclNode Node);
	//	public abstract void VisitRegexNode(ZenRegexNode Node);
	//	public abstract void VisitApplyOverridedMethodNode(ZenApplyOverridedMethodNode Node);
	//	public abstract void VisitSliceNode(ZenSliceNode Node);
	//	public abstract void VisitAllocateNode(ZenAllocateNode Node);
	//	public abstract void VisitUsingNode(ZenUsingNode Node);
	//	public abstract void VisitDoWhileNode(ZenDoWhileNode Node);
	//	public abstract void VisitForNode(ZenForNode Node);
	//	public abstract void VisitForEachNode(ZenForEachNode Node);
	//	public abstract void VisitContinueNode(ZenContinueNode Node);
	//	public abstract void VisitStatementNode(ZenStatementNode Node);
	//	public abstract void VisitYieldNode(ZenYieldNode Node);
	//	public abstract void VisitSwitchNode(ZenSwitchNode Node);
	//	public abstract void VisitCaseNode(ZenCaseNode Node);
	//	public abstract void VisitCommandNode(ZenCommandNode Node);
	//	public abstract void VisitClassDeclNode(ZenClassDeclNode ClassDeclNode);
}