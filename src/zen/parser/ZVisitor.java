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

import zen.ast.ZenAndNode;
import zen.ast.ZenArrayLiteralNode;
import zen.ast.ZenBinaryNode;
import zen.ast.ZenBlockNode;
import zen.ast.ZenBooleanNode;
import zen.ast.ZenBreakNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
import zen.ast.ZenClassDeclNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenConstPoolNode;
import zen.ast.ZenEmptyNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFloatNode;
import zen.ast.ZenFuncCallNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionNode;
import zen.ast.ZenGetIndexNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenGetterNode;
import zen.ast.ZenGroupNode;
import zen.ast.ZenIfNode;
import zen.ast.ZenInstanceOfNode;
import zen.ast.ZenIntNode;
import zen.ast.ZenMapLiteralNode;
import zen.ast.ZenMethodCallNode;
import zen.ast.ZenNewArrayNode;
import zen.ast.ZenNewObjectNode;
import zen.ast.ZenNotNode;
import zen.ast.ZenNullNode;
import zen.ast.ZenOrNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenSetIndexNode;
import zen.ast.ZenSetLocalNode;
import zen.ast.ZenSetterNode;
import zen.ast.ZenStringNode;
import zen.ast.ZenSymbolNode;
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenUnaryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast.ZenWhileNode;

public abstract class ZVisitor {
	public abstract void VisitEmptyNode(ZenEmptyNode Node);
	public abstract void VisitNullNode(ZenNullNode Node);
	public abstract void VisitBooleanNode(ZenBooleanNode Node);
	public abstract void VisitIntNode(ZenIntNode Node);
	public abstract void VisitFloatNode(ZenFloatNode Node);
	public abstract void VisitStringNode(ZenStringNode Node);
	public abstract void VisitConstPoolNode(ZenConstPoolNode Node);
	public abstract void VisitArrayLiteralNode(ZenArrayLiteralNode Node);
	public abstract void VisitMapLiteralNode(ZenMapLiteralNode Node);
	public abstract void VisitNewArrayNode(ZenNewArrayNode Node);
	public abstract void VisitNewObjectNode(ZenNewObjectNode Node);
	public abstract void VisitSymbolNode(ZenSymbolNode Node);
	public abstract void VisitGetLocalNode(ZenGetLocalNode Node);
	public abstract void VisitSetLocalNode(ZenSetLocalNode Node);
	public abstract void VisitGroupNode(ZenGroupNode Node);
	public abstract void VisitGetterNode(ZenGetterNode Node);
	public abstract void VisitSetterNode(ZenSetterNode Node);
	public abstract void VisitGetIndexNode(ZenGetIndexNode Node);
	public abstract void VisitSetIndexNode(ZenSetIndexNode Node);
	public abstract void VisitMethodCallNode(ZenMethodCallNode Node);
	public abstract void VisitFuncCallNode(ZenFuncCallNode Node);
	public abstract void VisitUnaryNode(ZenUnaryNode Node);
	public abstract void VisitNotNode(ZenNotNode Node);
	public abstract void VisitCastNode(ZenCastNode Node);
	public abstract void VisitInstanceOfNode(ZenInstanceOfNode Node);
	public abstract void VisitBinaryNode(ZenBinaryNode Node);
	public abstract void VisitComparatorNode(ZenComparatorNode Node);
	public abstract void VisitAndNode(ZenAndNode Node);
	public abstract void VisitOrNode(ZenOrNode Node);
	public abstract void VisitBlockNode(ZenBlockNode Node);
	public abstract void VisitVarDeclNode(ZenVarDeclNode Node);
	public abstract void VisitIfNode(ZenIfNode Node);
	public abstract void VisitReturnNode(ZenReturnNode Node);
	public abstract void VisitWhileNode(ZenWhileNode Node);
	public abstract void VisitBreakNode(ZenBreakNode Node);
	public abstract void VisitThrowNode(ZenThrowNode Node);
	public abstract void VisitTryNode(ZenTryNode Node);
	public abstract void VisitCatchNode(ZenCatchNode Node);
	public abstract void VisitParamNode(ZenParamNode Node);
	public abstract void VisitFunctionNode(ZenFunctionNode Node);
	public abstract void VisitFuncDeclNode(ZenFuncDeclNode Node);
	public abstract void VisitClassDeclNode(ZenClassDeclNode Node);
	public abstract void VisitErrorNode(ZenErrorNode Node);

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