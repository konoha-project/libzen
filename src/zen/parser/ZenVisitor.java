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
import zen.ast.ZenFunctionLiteralNode;
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

public interface ZenVisitor {
	public void VisitEmptyNode(ZenEmptyNode Node);
	public void VisitNullNode(ZenNullNode Node);
	public void VisitBooleanNode(ZenBooleanNode Node);
	public void VisitIntNode(ZenIntNode Node);
	public void VisitFloatNode(ZenFloatNode Node);
	public void VisitStringNode(ZenStringNode Node);
	public void VisitConstPoolNode(ZenConstPoolNode Node);
	public void VisitArrayLiteralNode(ZenArrayLiteralNode Node);
	public void VisitMapLiteralNode(ZenMapLiteralNode Node);
	public void VisitNewArrayNode(ZenNewArrayNode Node);
	public void VisitNewObjectNode(ZenNewObjectNode Node);
	public void VisitSymbolNode(ZenSymbolNode Node);
	public void VisitGetLocalNode(ZenGetLocalNode Node);
	public void VisitSetLocalNode(ZenSetLocalNode Node);
	public void VisitGroupNode(ZenGroupNode Node);
	public void VisitGetterNode(ZenGetterNode Node);
	public void VisitSetterNode(ZenSetterNode Node);
	public void VisitGetIndexNode(ZenGetIndexNode Node);
	public void VisitSetIndexNode(ZenSetIndexNode Node);
	public void VisitMethodCallNode(ZenMethodCallNode Node);
	public void VisitFuncCallNode(ZenFuncCallNode Node);
	public void VisitUnaryNode(ZenUnaryNode Node);
	public void VisitNotNode(ZenNotNode Node);
	public void VisitCastNode(ZenCastNode Node);
	public void VisitInstanceOfNode(ZenInstanceOfNode Node);
	public void VisitBinaryNode(ZenBinaryNode Node);
	public void VisitComparatorNode(ZenComparatorNode Node);
	public void VisitAndNode(ZenAndNode Node);
	public void VisitOrNode(ZenOrNode Node);
	public void VisitBlockNode(ZenBlockNode Node);
	public void VisitVarDeclNode(ZenVarDeclNode Node);
	public void VisitIfNode(ZenIfNode Node);
	public void VisitReturnNode(ZenReturnNode Node);
	public void VisitWhileNode(ZenWhileNode Node);
	public void VisitBreakNode(ZenBreakNode Node);
	public void VisitThrowNode(ZenThrowNode Node);
	public void VisitTryNode(ZenTryNode Node);
	public void VisitCatchNode(ZenCatchNode Node);
	public void VisitParamNode(ZenParamNode Node);
	public void VisitFunctionLiteralNode(ZenFunctionLiteralNode Node);
	public void VisitFuncDeclNode(ZenFuncDeclNode Node);
	public void VisitClassDeclNode(ZenClassDeclNode Node);
	public void VisitErrorNode(ZenErrorNode Node);

	public void EnableVisitor();
	public void StopVisitor();
	public boolean IsVisitable();

	//	public void VisitTrinaryNode(ZenTrinaryNode Node);
	//	public void VisitPrefixInclNode(ZenPrefixInclNode Node);
	//	public void VisitPrefixDeclNode(ZenPrefixDeclNode Node);
	//	public void VisitSuffixInclNode(ZenSuffixInclNode Node);
	//	public void VisitSuffixDeclNode(ZenSuffixDeclNode Node);
	//	public void VisitRegexNode(ZenRegexNode Node);
	//	public void VisitApplyOverridedMethodNode(ZenApplyOverridedMethodNode Node);
	//	public void VisitSliceNode(ZenSliceNode Node);
	//	public void VisitAllocateNode(ZenAllocateNode Node);
	//	public void VisitUsingNode(ZenUsingNode Node);
	//	public void VisitDoWhileNode(ZenDoWhileNode Node);
	//	public void VisitForNode(ZenForNode Node);
	//	public void VisitForEachNode(ZenForEachNode Node);
	//	public void VisitContinueNode(ZenContinueNode Node);
	//	public void VisitStatementNode(ZenStatementNode Node);
	//	public void VisitYieldNode(ZenYieldNode Node);
	//	public void VisitSwitchNode(ZenSwitchNode Node);
	//	public void VisitCaseNode(ZenCaseNode Node);
	//	public void VisitCommandNode(ZenCommandNode Node);
	//	public void VisitClassDeclNode(ZenClassDeclNode ClassDeclNode);
}