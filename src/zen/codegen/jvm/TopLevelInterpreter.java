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

package zen.codegen.jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
import zen.ast.ZConstPoolNode;
import zen.ast.ZEmptyNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFuncDeclNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetLocalNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZInstanceOfNode;
import zen.ast.ZIntNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewArrayNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZParamNode;
import zen.ast.ZReturnNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetLocalNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZSymbolNode;
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.deps.LibNative;
import zen.parser.ZVisitor;

public class TopLevelInterpreter extends ZVisitor {
	private boolean IsVisitable = true;
	private Object EvaledValue = null;
	private final JavaByteCodeGenerator2 Generator;

	TopLevelInterpreter(JavaByteCodeGenerator2 Generator) {
		this.Generator = Generator;
	}

	@Override public boolean IsVisitable() {
		return this.IsVisitable;
	}

	@Override public void EnableVisitor() {
		this.EvaledValue = null;
		this.IsVisitable = true;
	}

	@Override public void StopVisitor() {
		this.EvaledValue = null;
		this.IsVisitable = false;
	}

	void FoundError(Object ErrorInfo) {
		this.EvaledValue = ErrorInfo;
		this.IsVisitable = false;
	}

	void Unsupported(ZNode Node) {
		this.Generator.Logger.ReportError(Node.SourceToken, "unsupported (at the top level): " + Node.SourceToken.ParsedText);
		this.EvaledValue = null; //"unsupported node: " + Node.getClass().getSimpleName();
		this.IsVisitable = false;
	}

	public final Object Eval(ZNode Node) {
		if(this.IsVisitable()) {
			//System.err.println("visiting .." + Node.getClass());
			Node.Accept(this);
		}
		return this.EvaledValue;
	}

	void EvalMethod(Method sMethod, ZNode RecvNode, ZNode[] Nodes) {
		try {
			Object Recv = null;
			if(RecvNode != null) {
				Recv = this.Eval(RecvNode);
			}
			Object Values[] = new Object[Nodes.length];
			for(int i = 0; i < Nodes.length; i++) {
				Values[i] = this.Eval(Nodes[i]);
			}
			if(this.IsVisitable()) {
				this.EvaledValue = sMethod.invoke(Recv, Values);
			}
		} catch (Exception e) {
			this.FoundError(e.getMessage());
		}
	}

	void EvalStaticMethod(Method sMethod, ZNode[] Nodes) {
		this.EvalMethod(sMethod, null, Nodes);
	}

	@Override public void VisitEmptyNode(ZEmptyNode Node) {
		this.StopVisitor();
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.EvaledValue = null;
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.EvaledValue = Node.BooleanValue;
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.EvaledValue = Node.IntValue;
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.EvaledValue = Node.FloatValue;
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.EvaledValue = Node.StringValue;
	}

	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
		this.EvaledValue = Node.ConstValue;
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitGetLocalNode(ZGetLocalNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitSetLocalNode(ZSetLocalNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.EvaledValue = this.Eval(Node.RecvNode);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		Method sMethod = NativeMethodTable.GetStaticMethod("GetField");
		ZNode NameNode = new ZStringNode(null, Node.FieldName);
		this.EvalStaticMethod(sMethod, new ZNode[] {Node.RecvNode, NameNode});
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		Method sMethod = NativeMethodTable.GetStaticMethod("SetField");
		ZNode NameNode = new ZStringNode(null, Node.FieldName);
		this.EvalStaticMethod(sMethod, new ZNode[] {Node.RecvNode, NameNode, Node.ValueNode});
	}

	@Override
	public void VisitGetIndexNode(ZGetIndexNode Node) {
		this.Unsupported(Node);

	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		Method jMethod = this.Generator.GetMethod(Node.RecvNode.Type, Node.MethodName, Node.ParamList);
		if(jMethod != null) {
			this.EvalMethod(jMethod, Node.RecvNode, this.Generator.PackNodes(null, Node.ParamList));
		}
		else {
			jMethod = NativeMethodTable.GetStaticMethod("InvokeUnresolvedMethod");
			Object Recv = this.Eval(Node.RecvNode);
			Object Values[] = new Object[Node.ParamList.size()];
			for(int i = 0; i < Node.ParamList.size(); i++) {
				Values[i] = this.Eval(Node.ParamList.get(i));
			}
			if(this.IsVisitable()) {
				try {
					this.EvaledValue = jMethod.invoke(null, Recv, Node.MethodName, Values);
				} catch (IllegalArgumentException e1) {
					LibNative.FixMe(e1);
				} catch (IllegalAccessException e1) {
					LibNative.FixMe(e1);
				} catch (InvocationTargetException e1) {
					this.FoundError(e1.getMessage());
				}
			}
		}
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		Method sMethod = this.Generator.GetStaticFuncMethod(Node.FuncNode);
		if(sMethod != null) {
			this.EvalStaticMethod(sMethod, this.Generator.PackNodes(null, Node.ParamList));
		}
		else if(Node.Type.IsFuncType()) {
			sMethod = NativeMethodTable.GetStaticMethod("ApplyFunc");
			this.EvalStaticMethod(sMethod, this.Generator.PackNodes(Node.FuncNode, Node.ParamList));
		}
		else {

		}
		this.Unsupported(Node);
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		Method sMethod = NativeMethodTable.GetUnaryStaticMethod(Node.SourceToken.ParsedText, Node.RecvNode.Type);
		this.EvalStaticMethod(sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		Method sMethod = NativeMethodTable.GetUnaryStaticMethod(Node.SourceToken.ParsedText, Node.RecvNode.Type);
		this.EvalStaticMethod(sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.EvaledValue = this.Eval(Node.ExprNode);
		if(!Node.Type.IsVoidType()) {

		}
	}

	@Override
	public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		this.Unsupported(Node);

	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		Method sMethod = NativeMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.ParsedText, Node.RightNode.Type);
		this.EvalStaticMethod(sMethod, new ZNode[] {Node.LeftNode, Node.RightNode});
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		Method sMethod = NativeMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.ParsedText, Node.RightNode.Type);
		this.EvalStaticMethod(sMethod, new ZNode[] {Node.LeftNode, Node.RightNode});
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		Object BooleanValue = this.Eval(Node.LeftNode);
		if(BooleanValue instanceof Boolean) {
			if((Boolean)BooleanValue) {
				this.EvaledValue = this.Eval(Node.RightNode);
			}
			else {
				this.EvaledValue = false;
			}
		}
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		Object BooleanValue = this.Eval(Node.LeftNode);
		if(BooleanValue instanceof Boolean) {
			if(!(Boolean)BooleanValue) {
				this.EvaledValue = this.Eval(Node.RightNode);
			}
			else {
				this.EvaledValue = true;
			}
		}
	}

	@Override
	public void VisitBlockNode(ZBlockNode Node) {
		this.Unsupported(Node);

	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		this.Unsupported(Node);
	}

	@Override
	public void VisitIfNode(ZIfNode Node) {
		Object BooleanValue = this.Eval(Node.CondNode);
		if(BooleanValue instanceof Boolean) {
			if((Boolean)BooleanValue) {
				this.Eval(Node.ThenNode);
			}
			else if(Node.ElseNode != null) {
				this.Eval(Node.ThenNode);
			}
		}
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		this.Unsupported(Node);
	}

	@Override
	public void VisitTryNode(ZTryNode Node) {
		this.Unsupported(Node);

	}

	@Override
	public void VisitCatchNode(ZCatchNode Node) {
		this.Unsupported(Node);

	}

	@Override
	public void VisitParamNode(ZParamNode Node) {
		this.Unsupported(Node);

	}

	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		this.Unsupported(Node);

	}

	@Override public void VisitFuncDeclNode(ZFuncDeclNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
		this.Unsupported(Node);
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		this.FoundError(Node.ErrorMessage);
	}


}
