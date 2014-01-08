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

import zen.ast.GtAndNode;
import zen.ast.GtApplyNode;
import zen.ast.GtArrayLiteralNode;
import zen.ast.GtBinaryNode;
import zen.ast.GtBlockNode;
import zen.ast.GtBooleanNode;
import zen.ast.GtBreakNode;
import zen.ast.GtCastNode;
import zen.ast.GtCatchNode;
import zen.ast.GtConstPoolNode;
import zen.ast.GtErrorNode;
import zen.ast.GtFloatNode;
import zen.ast.GtFuncDeclNode;
import zen.ast.GtFunctionLiteralNode;
import zen.ast.GtGetCapturedNode;
import zen.ast.GtGetIndexNode;
import zen.ast.GtGetLocalNode;
import zen.ast.GtGetterNode;
import zen.ast.GtGroupNode;
import zen.ast.GtIfNode;
import zen.ast.GtInstanceOfNode;
import zen.ast.GtIntNode;
import zen.ast.GtMapLiteralNode;
import zen.ast.GtMethodCallNode;
import zen.ast.GtNewArrayNode;
import zen.ast.GtNewObjectNode;
import zen.ast.GtNullNode;
import zen.ast.GtOrNode;
import zen.ast.GtParamNode;
import zen.ast.GtReturnNode;
import zen.ast.GtSetCapturedNode;
import zen.ast.GtSetIndexNode;
import zen.ast.GtSetLocalNode;
import zen.ast.GtSetterNode;
import zen.ast.GtStringNode;
import zen.ast.GtThrowNode;
import zen.ast.GtTryNode;
import zen.ast.GtUnaryNode;
import zen.ast.GtVarDeclNode;
import zen.ast.GtWhileNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenNotNode;

public interface ZenVisitor {
	public void VisitNullNode(GtNullNode Node);
	public void VisitBooleanNode(GtBooleanNode Node);
	public void VisitIntNode(GtIntNode Node);
	public void VisitFloatNode(GtFloatNode Node);
	public void VisitStringNode(GtStringNode Node);
	public void VisitConstPoolNode(GtConstPoolNode Node);
	public void VisitArrayLiteralNode(GtArrayLiteralNode Node);
	public void VisitMapLiteralNode(GtMapLiteralNode Node);
	public void VisitNewArrayNode(GtNewArrayNode Node);
	public void VisitNewObjectNode(GtNewObjectNode Node);
	public void VisitGetLocalNode(GtGetLocalNode Node);
	public void VisitSetLocalNode(GtSetLocalNode Node);
	public void VisitGetCapturedNode(GtGetCapturedNode Node);
	public void VisitSetCapturedNode(GtSetCapturedNode Node);
	public void VisitGroupNode(GtGroupNode Node);
	public void VisitGetterNode(GtGetterNode Node);
	public void VisitSetterNode(GtSetterNode Node);
	public void VisitGetIndexNode(GtGetIndexNode Node);
	public void VisitSetIndexNode(GtSetIndexNode Node);
	public void VisitMethodCallNode(GtMethodCallNode Node);
	public void VisitApplyNode(GtApplyNode Node);
	public void VisitUnaryNode(GtUnaryNode Node);
	public void VisitNotNode(ZenNotNode Node);
	public void VisitCastNode(GtCastNode Node);
	public void VisitInstanceOfNode(GtInstanceOfNode Node);
	public void VisitBinaryNode(GtBinaryNode Node);
	public void VisitComparatorNode(ZenComparatorNode Node);
	public void VisitAndNode(GtAndNode Node);
	public void VisitOrNode(GtOrNode Node);
	public void VisitBlockNode(GtBlockNode Node);
	public void VisitVarDeclNode(GtVarDeclNode Node);
	public void VisitIfNode(GtIfNode Node);
	public void VisitReturnNode(GtReturnNode Node);
	public void VisitWhileNode(GtWhileNode Node);
	public void VisitBreakNode(GtBreakNode Node);
	public void VisitThrowNode(GtThrowNode Node);
	public void VisitTryNode(GtTryNode Node);
	public void VisitCatchNode(GtCatchNode Node);
	public void VisitParamNode(GtParamNode Node);
	public void VisitFunctionLiteralNode(GtFunctionLiteralNode Node);
	public void VisitFuncDeclNode(GtFuncDeclNode Node);
	public void VisitErrorNode(GtErrorNode Node);

	public void EnableVisitor();
	public void StopVisitor();
	public boolean IsVisitable();

	//	public void VisitTrinaryNode(GtTrinaryNode Node);
	//	public void VisitPrefixInclNode(GtPrefixInclNode Node);
	//	public void VisitPrefixDeclNode(GtPrefixDeclNode Node);
	//	public void VisitSuffixInclNode(GtSuffixInclNode Node);
	//	public void VisitSuffixDeclNode(GtSuffixDeclNode Node);
	//	public void VisitRegexNode(GtRegexNode Node);
	//	public void VisitApplyOverridedMethodNode(GtApplyOverridedMethodNode Node);
	//	public void VisitSliceNode(GtSliceNode Node);
	//	public void VisitAllocateNode(GtAllocateNode Node);
	//	public void VisitUsingNode(GtUsingNode Node);
	//	public void VisitDoWhileNode(GtDoWhileNode Node);
	//	public void VisitForNode(GtForNode Node);
	//	public void VisitForEachNode(GtForEachNode Node);
	//	public void VisitContinueNode(GtContinueNode Node);
	//	public void VisitStatementNode(GtStatementNode Node);
	//	public void VisitYieldNode(GtYieldNode Node);
	//	public void VisitSwitchNode(GtSwitchNode Node);
	//	public void VisitCaseNode(GtCaseNode Node);
	//	public void VisitCommandNode(GtCommandNode Node);
	//	public void VisitClassDeclNode(GtClassDeclNode ClassDeclNode);
}