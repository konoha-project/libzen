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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import zen.ast.ZBinaryNode;
import zen.ast.ZCastNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZUnaryNode;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.lang.ZenEngine;
import zen.type.ZTypeChecker;

public class JavaReflectionEngine extends ZenEngine {

	JavaReflectionEngine(ZTypeChecker TypeChecker, Java6ByteCodeGenerator Generator) {
		super(TypeChecker, Generator);
	}

	void EvalMethod(ZNode Node, Method jMethod, ZNode RecvNode, ZNode[] Nodes) {
		try {
			Object Recv = null;
			if(RecvNode != null && !Modifier.isStatic(jMethod.getModifiers())) {
				Recv = this.Eval(RecvNode);
			}
			Object Values[] = new Object[Nodes.length];
			for(int i = 0; i < Nodes.length; i++) {
				Values[i] = this.Eval(Nodes[i]);
			}
			if(this.IsVisitable()) {
				this.EvaledValue = jMethod.invoke(Recv, Values);
			}
		} catch (Exception e) {
			this.Logger.ReportInfo(Node.SourceToken, "runtime error: " + e);
			e.printStackTrace();
			this.StopVisitor();
		}
	}

	void EvalStaticMethod(ZNode Node, Method sMethod, ZNode[] Nodes) {
		this.EvalMethod(Node, sMethod, null, Nodes);
	}

	//	@Override public void VisitNullNode(ZNullNode Node) {
	//		this.EvaledValue = null;
	//	}
	//
	//	@Override public void VisitBooleanNode(ZBooleanNode Node) {
	//		this.EvaledValue = Node.BooleanValue;
	//	}
	//
	//	@Override public void VisitIntNode(ZIntNode Node) {
	//		this.EvaledValue = Node.IntValue;
	//	}
	//
	//	@Override public void VisitFloatNode(ZFloatNode Node) {
	//		this.EvaledValue = Node.FloatValue;
	//	}
	//
	//	@Override public void VisitStringNode(ZStringNode Node) {
	//		this.EvaledValue = Node.StringValue;
	//	}
	//
	//	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
	//		this.EvaledValue = Node.ConstValue;
	//	}

	public void VisitJvmFuncNode(JvmFuncNode Node) {
		try {
			Field f = Node.FuncClass.getField("function");
			this.EvaledValue = f.get(null);
		} catch (Exception e) {
			LibNative.FixMe(e);
			this.EvaledValue = null;
		}
	}

	//	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override public void VisitSymbolNode(ZSymbolNode Node) {
	//		this.Unsupported(Node);
	//	}
	//

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		@Var ZNode Node1 = this.Generator.RootNameSpace.GetSymbolNode(Node.VarName);
		if(Node1 != null) {
			this.EvaledValue = this.Eval(Node1);
		}
		else {
			this.Unsupported(Node, "undefined symbol: " + Node.VarName);
		}
	}

	//
	//	@Override public void VisitSetNameNode(ZSetLocalNode Node) {
	//		this.Unsupported(Node);
	//	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.EvaledValue = this.Eval(Node.RecvNode);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		Method sMethod = NativeMethodTable.GetStaticMethod("GetField");
		ZNode NameNode = new ZStringNode(null, Node.FieldName);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, NameNode});
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		Method sMethod = NativeMethodTable.GetStaticMethod("SetField");
		ZNode NameNode = new ZStringNode(null, Node.FieldName);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, NameNode, Node.ValueNode});
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		Method sMethod = NativeMethodTable.GetBinaryStaticMethod(Node.RecvNode.Type, "[]", Node.IndexNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, Node.IndexNode});
	}

	//
	//	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
	//		this.Unsupported(Node);
	//	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		Method jMethod = ((Java6ByteCodeGenerator)this.Generator).GetMethod(Node.RecvNode.Type, Node.MethodName, Node.ParamList);
		if(jMethod != null) {
			this.EvalMethod(Node, jMethod, Node.RecvNode, ((Java6ByteCodeGenerator)this.Generator).PackNodes(null, Node.ParamList));
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
					this.Logger.ReportWarning(Node.SourceToken, "runtime error: " + e1);
				}
			}
		}
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		if(Node.ResolvedFuncName != null) {
			if(Node.ResolvedFuncType == null) {

			}
			Method sMethod = ((Java6ByteCodeGenerator)this.Generator).GetStaticFuncMethod(Node.ResolvedFuncType.StringfySignature(Node.ResolvedFuncName));
			this.EvalStaticMethod(Node, sMethod, ((Java6ByteCodeGenerator)this.Generator).PackNodes(null, Node.ParamList));
		}
		else {
			Method sMethod = NativeMethodTable.GetStaticMethod("InvokeFunc");
			this.EvalStaticMethod(Node, sMethod, ((Java6ByteCodeGenerator)this.Generator).PackNodes(Node.FuncNode, Node.ParamList));
		}
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		Method sMethod = NativeMethodTable.GetUnaryStaticMethod(Node.SourceToken.ParsedText, Node.RecvNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		Method sMethod = NativeMethodTable.GetUnaryStaticMethod(Node.SourceToken.ParsedText, Node.RecvNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.EvaledValue = this.Eval(Node.ExprNode);
		if(!Node.Type.IsVoidType()) {

		}
	}

	//	@Override
	//	public void VisitInstanceOfNode(ZInstanceOfNode Node) {
	//		this.Unsupported(Node);
	//
	//	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		Method sMethod = NativeMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.ParsedText, Node.RightNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.LeftNode, Node.RightNode});
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		Method sMethod = NativeMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.ParsedText, Node.RightNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.LeftNode, Node.RightNode});
	}

	//	@Override public void VisitAndNode(ZAndNode Node) {
	//		Object BooleanValue = this.Eval(Node.LeftNode);
	//		if(BooleanValue instanceof Boolean) {
	//			if((Boolean)BooleanValue) {
	//				this.EvaledValue = this.Eval(Node.RightNode);
	//			}
	//			else {
	//				this.EvaledValue = false;
	//			}
	//		}
	//	}
	//
	//	@Override public void VisitOrNode(ZOrNode Node) {
	//		Object BooleanValue = this.Eval(Node.LeftNode);
	//		if(BooleanValue instanceof Boolean) {
	//			if(!(Boolean)BooleanValue) {
	//				this.EvaledValue = this.Eval(Node.RightNode);
	//			}
	//			else {
	//				this.EvaledValue = true;
	//			}
	//		}
	//	}
	//
	//	@Override
	//	public void VisitBlockNode(ZBlockNode Node) {
	//		this.Unsupported(Node);
	//
	//	}
	//
	//	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override
	//	public void VisitIfNode(ZIfNode Node) {
	//		Object BooleanValue = this.Eval(Node.CondNode);
	//		if(BooleanValue instanceof Boolean) {
	//			if((Boolean)BooleanValue) {
	//				this.Eval(Node.ThenNode);
	//			}
	//			else if(Node.ElseNode != null) {
	//				this.Eval(Node.ThenNode);
	//			}
	//		}
	//	}
	//
	//	@Override public void VisitReturnNode(ZReturnNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override public void VisitWhileNode(ZWhileNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override public void VisitBreakNode(ZBreakNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override public void VisitThrowNode(ZThrowNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override
	//	public void VisitTryNode(ZTryNode Node) {
	//		this.Unsupported(Node);
	//
	//	}
	//
	//	@Override
	//	public void VisitCatchNode(ZCatchNode Node) {
	//		this.Unsupported(Node);
	//
	//	}
	//
	//	@Override
	//	public void VisitParamNode(ZParamNode Node) {
	//		this.Unsupported(Node);
	//
	//	}
	//
	//	@Override
	//	public void VisitFunctionNode(ZFunctionNode Node) {
	//		this.Unsupported(Node);
	//
	//	}
	//
	//	@Override public void VisitFuncDeclNode(ZFunctionNode/*Decl*/ Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
	//		this.Unsupported(Node);
	//	}
	//
	//	@Override public void VisitErrorNode(ZErrorNode Node) {
	//
	//		this.FoundError(Node.ErrorMessage);
	//	}


}
