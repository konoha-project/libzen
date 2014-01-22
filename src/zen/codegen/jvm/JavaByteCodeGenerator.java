// ***************************************************************************
// Copyright (c) 2013, JST/CREST DEOS project authors. All rights reserved.
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

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACONST_NULL;
import static org.objectweb.asm.Opcodes.ATHROW;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;

import java.util.ArrayList;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

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
import zen.lang.ZSystem;
import zen.lang.ZTypeFlag;
import zen.parser.ZGenerator;

public class JavaByteCodeGenerator extends ZGenerator {

	JMethodBuilder CurrentVisitor;
	ZClassLoader ClassGenerator;
	ArrayList<TryCatchLabel> TryCatchLabel;

	public JavaByteCodeGenerator() {
		super("java", "1.6");
		this.TryCatchLabel = new ArrayList<TryCatchLabel>();
	}

	@Override public void VisitEmptyNode(ZEmptyNode Node) {
		/* do nothing */
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.CurrentVisitor.AsmVisitor.visitInsn(ACONST_NULL);
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Node.BooleanValue);
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Node.FloatValue);
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Node.FloatValue);
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Node.StringValue);
	}

	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
		Object constValue = Node.ConstValue;
		LibNative.Assert(Node.ConstValue != null);
		this.CurrentVisitor.LoadConst(constValue);
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.CurrentVisitor.LoadConst(Node.Type);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.NodeList);
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.NewNewArray);
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		this.CurrentVisitor.LoadConst(Node.Type);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.NodeList);
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.NewArray);
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		Type type = JLib.GetAsmType(Node.Type);
		String owner = type.getInternalName();
		this.CurrentVisitor.AsmVisitor.visitTypeInsn(NEW, owner);
		this.CurrentVisitor.AsmVisitor.visitInsn(DUP);
		if(!((Node.Type.TypeFlag & ZTypeFlag.UniqueType) == ZTypeFlag.UniqueType)) {
			this.CurrentVisitor.LoadConst(Node.Type);
			this.CurrentVisitor.AsmVisitor.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "(Lorg/ZenScript/ZenType;)V");
		} else {
			this.CurrentVisitor.AsmVisitor.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "()V");
		}
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitGetLocalNode(ZGetLocalNode Node) {
		JLocalVarStack local = this.CurrentVisitor.FindLocalVariable(Node.VarName);
		this.CurrentVisitor.LoadLocal(local);
	}

	@Override public void VisitSetLocalNode(ZSetLocalNode Node) {
		JLocalVarStack local = this.CurrentVisitor.FindLocalVariable(Node.VarName);
		this.CurrentVisitor.PushEvaluatedNode(Node.ValueNode.Type, Node.ValueNode);
		this.CurrentVisitor.StoreLocal(local);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		Node.RecvNode.Accept(this);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		String Name = Node.FieldName;
		Type FieldType = JLib.GetAsmType(Node.Type);
		Type OwnerType = JLib.GetAsmType(Node.RecvNode.Type);
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.AsmVisitor.visitFieldInsn(GETFIELD, OwnerType.getInternalName(), Name, FieldType.getDescriptor());
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		String Name = Node.FieldName;
		Type FieldType = JLib.GetAsmType(Node.Type);
		Type OwnerType = JLib.GetAsmType(Node.RecvNode.Type);
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.PushEvaluatedNode(Node.Type, Node.ValueNode);
		this.CurrentVisitor.AsmVisitor.visitFieldInsn(PUTFIELD, OwnerType.getInternalName(), Name, FieldType.getDescriptor());
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(1), Node.IndexNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(1), Node.IndexNode);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(2), Node.ValueNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.ParamList);
		// FIXME Find method and invoke it.
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.InvokeFunc);
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		Node.FuncNode.Accept(this);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.ParamList);
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.InvokeFunc);
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(0), Node.RecvNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(0), Node.RecvNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override
	public void VisitCastNode(ZCastNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(0), Node.LeftNode);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(1), Node.RightNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(0), Node.LeftNode);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(1), Node.RightNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		Label elseLabel = new Label();
		Label mergeLabel = new Label();
		this.CurrentVisitor.PushEvaluatedNode(ZSystem.BooleanType, Node.LeftNode);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(IFEQ, elseLabel);

		this.CurrentVisitor.PushEvaluatedNode(ZSystem.BooleanType, Node.RightNode);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(IFEQ, elseLabel);

		this.CurrentVisitor.AsmVisitor.visitLdcInsn(true);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentVisitor.AsmVisitor.visitLabel(elseLabel);
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(false);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentVisitor.AsmVisitor.visitLabel(mergeLabel);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		Label thenLabel = new Label();
		Label mergeLabel = new Label();
		this.CurrentVisitor.PushEvaluatedNode(ZSystem.BooleanType, Node.LeftNode);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(IFNE, thenLabel);

		this.CurrentVisitor.PushEvaluatedNode(ZSystem.BooleanType, Node.RightNode);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(IFNE, thenLabel);

		this.CurrentVisitor.AsmVisitor.visitLdcInsn(false);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentVisitor.AsmVisitor.visitLabel(thenLabel);
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(true);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentVisitor.AsmVisitor.visitLabel(mergeLabel);
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		JLocalVarStack local = this.CurrentVisitor.AddLocal(Node.Type, Node.NativeName);
		this.CurrentVisitor.PushEvaluatedNode(Node.DeclType, Node.InitNode);
		this.CurrentVisitor.StoreLocal(local);
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Label ElseLabel = new Label();
		Label EndLabel = new Label();
		this.CurrentVisitor.PushEvaluatedNode(ZSystem.BooleanType, Node.CondNode);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(IFEQ, ElseLabel);

		// Then
		Node.ThenNode.Accept(this);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, EndLabel);
		// Else
		this.CurrentVisitor.AsmVisitor.visitLabel(ElseLabel);
		if(Node.ElseNode != null) {
			Node.ElseNode.Accept(this);
			this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, EndLabel);
		}
		// End
		this.CurrentVisitor.AsmVisitor.visitLabel(EndLabel);
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		if(Node.ValueNode != null) {
			Node.ValueNode.Accept(this);
			Type type = JLib.GetAsmType(Node.ValueNode.Type);
			this.CurrentVisitor.AsmVisitor.visitInsn(type.getOpcode(IRETURN));
		}
		else {
			this.CurrentVisitor.AsmVisitor.visitInsn(RETURN);
		}
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		Label continueLabel = new Label();
		Label breakLabel = new Label();
		this.CurrentVisitor.BreakLabelStack.push(breakLabel);
		this.CurrentVisitor.ContinueLabelStack.push(continueLabel);

		this.CurrentVisitor.AsmVisitor.visitLabel(continueLabel);
		this.CurrentVisitor.PushEvaluatedNode(ZSystem.BooleanType, Node.CondNode);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(IFEQ, breakLabel); // condition
		Node.BodyNode.Accept(this);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, continueLabel);
		this.CurrentVisitor.AsmVisitor.visitLabel(breakLabel);

		this.CurrentVisitor.BreakLabelStack.pop();
		this.CurrentVisitor.ContinueLabelStack.pop();
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		Label l = this.CurrentVisitor.BreakLabelStack.peek();
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, l);
	}

	//@Override public void VisitContinueNode(ZenContinueNode Node) {
	//	Label l = this.CurrentVisitor.ContinueLabelStack.peek();
	//	this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, l);
	//}

	@Override public void VisitThrowNode(ZThrowNode Node) {
		// use wrapper
		//String name = Type.getInternalName(ZenThrowableWrapper.class);
		//this.CurrentVisitor.MethodVisitor.visitTypeInsn(NEW, name);
		//this.CurrentVisitor.MethodVisitor.visitInsn(DUP);
		//Node.Expr.Accept(this);
		//this.box();
		//this.CurrentVisitor.typeStack.pop();
		//this.CurrentVisitor.MethodVisitor.visitMethodInsn(INVOKESPECIAL, name, "<init>", "(Ljava/lang/Object;)V");
		//this.CurrentVisitor.MethodVisitor.visitInsn(ATHROW);
	}

	@Override public void VisitTryNode(ZTryNode Node) {
		MethodVisitor mv = this.CurrentVisitor.AsmVisitor;
		TryCatchLabel Label = new TryCatchLabel();
		this.TryCatchLabel.add(Label); // push

		// try block
		mv.visitLabel(Label.beginTryLabel);
		Node.TryNode.Accept(this);
		mv.visitLabel(Label.endTryLabel);
		mv.visitJumpInsn(GOTO, Label.finallyLabel);

		// finally block
		mv.visitLabel(Label.finallyLabel);
		if(Node.FinallyNode != null) {
			Node.FinallyNode.Accept(this);
		}
		this.TryCatchLabel.remove(this.TryCatchLabel.size() - 1); // pop
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		MethodVisitor mv = this.CurrentVisitor.AsmVisitor;
		Label catchLabel = new Label();
		TryCatchLabel Label = this.TryCatchLabel.get(this.TryCatchLabel.size() - 1);

		// prepare
		//TODO: add exception class name
		String throwType = JLib.GetAsmType(Node.ExceptionType).getInternalName();
		mv.visitTryCatchBlock(Label.beginTryLabel, Label.endTryLabel, catchLabel, throwType);

		// catch block
		JLocalVarStack local = this.CurrentVisitor.AddLocal(Node.ExceptionType, Node.ExceptionName);
		mv.visitLabel(catchLabel);
		this.CurrentVisitor.StoreLocal(local);
		Node.BodyNode.Accept(this);
		mv.visitJumpInsn(GOTO, Label.finallyLabel);
		//FIXME: remove local
	}

	@Override public void VisitParamNode(ZParamNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitFuncDeclNode(ZFuncDeclNode Node) {
		if(this.ClassGenerator == null) {
			this.ClassGenerator = new ZClassLoader(Node.NameSpace);
		}

		String MethodName = Node.FuncName;
		String MethodDesc = JLib.GetMethodDescriptor(Node);
		MethodNode AsmMethodNode = new MethodNode(ACC_PUBLIC | ACC_STATIC, MethodName, MethodDesc, null, null);
		JClassBuilder ClassHolder = this.ClassGenerator.GenerateMethodHolderClass(ZSystem.GetSourceFileName(Node.SourceToken.FileLine), MethodName, AsmMethodNode);

		JMethodBuilder LocalBuilder = new JMethodBuilder(this, this.ClassGenerator, AsmMethodNode);
		JMethodBuilder PushedBuilder = this.CurrentVisitor;

		for(int i = 0; i < Node.ArgumentList.size(); i++) {
			//String Name = Node.ArgumentList.get(i);
			//LocalBuilder.AddLocal(Func.GetFuncParamType(i), Name);
		}
		this.CurrentVisitor = LocalBuilder;
		Node.BodyNode.Accept(this);
		this.CurrentVisitor = PushedBuilder;
	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
		//TODO
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		String name = Type.getInternalName(SoftwareFaultException.class);
		this.CurrentVisitor.SetLineNumber(Node);
		this.CurrentVisitor.AsmVisitor.visitTypeInsn(NEW, name);
		this.CurrentVisitor.AsmVisitor.visitInsn(DUP);
		this.CurrentVisitor.LoadConst(Node.ErrorMessage);
		this.CurrentVisitor.AsmVisitor.visitMethodInsn(INVOKESPECIAL, name, "<init>", "(Ljava/lang/Object;)V");
		this.CurrentVisitor.AsmVisitor.visitInsn(ATHROW);
	}


}


