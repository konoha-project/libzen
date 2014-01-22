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
import java.util.HashMap;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
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
import zen.ast.ZConstNode;
import zen.ast.ZConstPoolNode;
import zen.ast.ZEmptyNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
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
import zen.deps.Var;
import zen.deps.ZenArray;
import zen.deps.ZenMap;
import zen.lang.ZFunc;
import zen.lang.ZSystem;
import zen.lang.ZType;
import zen.lang.ZTypeFlag;
import zen.lang.ZenFuncType;
import zen.parser.ZGenerator;

public class JavaByteCodeGenerator extends ZGenerator {
	HashMap<String, Class<?>> ClassMap = new HashMap<String,Class<?>>();
	HashMap<String, ZType> TypeMap = new HashMap<String,ZType>();
	JMethodBuilder CurrentBuilder;
	JClassLoader ClassLoader = null;
	ArrayList<TryCatchLabel> TryCatchLabel;

	public JavaByteCodeGenerator() {
		super("java", "1.6");
		this.TryCatchLabel = new ArrayList<TryCatchLabel>();
		this.ClassLoader = new JClassLoader(this);

		this.SetTypeTable(ZSystem.VarType, Object.class);
		this.SetTypeTable(ZSystem.VoidType, void.class);
		this.SetTypeTable(ZSystem.BooleanType, boolean.class);
		this.SetTypeTable(ZSystem.IntType, long.class);
		this.SetTypeTable(ZSystem.FloatType, double.class);
		this.SetTypeTable(ZSystem.StringType, String.class);
		this.SetTypeTable(ZSystem.FuncType, ZFunc.class);
		this.SetTypeTable(ZSystem.ArrayType, ZenArray.class);
		this.SetTypeTable(ZSystem.MapType, ZenMap.class);

		this.SetTypeTable(ZSystem.BooleanType, Boolean.class);
		this.SetTypeTable(ZSystem.IntType, Long.class);
		this.SetTypeTable(ZSystem.FloatType, Double.class);
		this.SetTypeTable(ZSystem.IntType, int.class);
		this.SetTypeTable(ZSystem.IntType, Integer.class);
		this.SetTypeTable(ZSystem.FloatType, float.class);
		this.SetTypeTable(ZSystem.FloatType, Float.class);
	}

	void SetTypeTable(ZType zType, Class<?> c) {
		if(this.GetJClass(zType) == null) {
			this.ClassMap.put(zType.GetUniqueName(), c);
		}
		this.TypeMap.put(c.getCanonicalName(), zType);
	}

	private Class<?> GetJClass(ZType zType) {
		return this.ClassMap.get(zType.GetUniqueName());
	}

	private String GetTypeDesc(ZType zType) {
		Class<?> JClass = this.GetJClass(zType);
		return Type.getDescriptor(JClass);
	}

	Type GetAsmType(ZType zType) {
		return Type.getType(this.GetJClass(zType));
	}

	String GetMethodDescriptor(ZenFuncType FuncType) {
		@Var Type ReturnType = this.GetAsmType(FuncType.GetReturnType());
		@Var Type[] ArgTypes = new Type[FuncType.GetFuncParamSize()];
		for(int i = 0; i < ArgTypes.length; i++) {
			ZType ParamType = FuncType.GetParamType(i);
			ArgTypes[i] = this.GetAsmType(ParamType);
		}
		return Type.getMethodDescriptor(ReturnType, ArgTypes);
	}

	private Object GetConstValue(ZNode Node) {
		if(Node instanceof ZConstNode) {
			return ((ZConstNode)Node).GetValue();
		}
		return null;
	}

	@Override public void VisitEmptyNode(ZEmptyNode Node) {
		/* do nothing */
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.CurrentBuilder.AsmVisitor.visitInsn(ACONST_NULL);
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.CurrentBuilder.AsmVisitor.visitLdcInsn(Node.BooleanValue);
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.CurrentBuilder.AsmVisitor.visitLdcInsn(Node.FloatValue);
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.CurrentBuilder.AsmVisitor.visitLdcInsn(Node.FloatValue);
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.CurrentBuilder.AsmVisitor.visitLdcInsn(Node.StringValue);
	}

	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
		Object constValue = Node.ConstValue;
		LibNative.Assert(Node.ConstValue != null);
		this.CurrentBuilder.LoadConst(constValue);
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		this.CurrentBuilder.LoadConst(Node.Type);
		this.CurrentBuilder.LoadNewArray(this, 0, Node.NodeList);
		this.CurrentBuilder.InvokeMethodCall(Node.Type, JLib.NewNewArray);
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		this.CurrentBuilder.LoadConst(Node.Type);
		this.CurrentBuilder.LoadNewArray(this, 0, Node.NodeList);
		this.CurrentBuilder.InvokeMethodCall(Node.Type, JLib.NewArray);
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		Type type = this.GetAsmType(Node.Type);
		String owner = type.getInternalName();
		this.CurrentBuilder.AsmVisitor.visitTypeInsn(NEW, owner);
		this.CurrentBuilder.AsmVisitor.visitInsn(DUP);
		if(!((Node.Type.TypeFlag & ZTypeFlag.UniqueType) == ZTypeFlag.UniqueType)) {
			this.CurrentBuilder.LoadConst(Node.Type);
			this.CurrentBuilder.AsmVisitor.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "(Lorg/ZenScript/ZenType;)V");
		} else {
			this.CurrentBuilder.AsmVisitor.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "()V");
		}
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitGetLocalNode(ZGetLocalNode Node) {
		JLocalVarStack local = this.CurrentBuilder.FindLocalVariable(Node.VarName);
		this.CurrentBuilder.LoadLocal(local);
	}

	@Override public void VisitSetLocalNode(ZSetLocalNode Node) {
		JLocalVarStack local = this.CurrentBuilder.FindLocalVariable(Node.VarName);
		this.CurrentBuilder.PushEvaluatedNode(Node.ValueNode.Type, Node.ValueNode);
		this.CurrentBuilder.StoreLocal(local);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		Node.RecvNode.Accept(this);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		String Name = Node.FieldName;
		Type FieldType = this.GetAsmType(Node.Type);
		Type OwnerType = this.GetAsmType(Node.RecvNode.Type);
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.AsmVisitor.visitFieldInsn(GETFIELD, OwnerType.getInternalName(), Name, FieldType.getDescriptor());
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		String Name = Node.FieldName;
		Type FieldType = this.GetAsmType(Node.Type);
		Type OwnerType = this.GetAsmType(Node.RecvNode.Type);
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.PushEvaluatedNode(Node.Type, Node.ValueNode);
		this.CurrentBuilder.AsmVisitor.visitFieldInsn(PUTFIELD, OwnerType.getInternalName(), Name, FieldType.getDescriptor());
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(1), Node.IndexNode);
		this.CurrentBuilder.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(1), Node.IndexNode);
		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(2), Node.ValueNode);
		this.CurrentBuilder.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.LoadNewArray(this, 0, Node.ParamList);
		// FIXME Find method and invoke it.
		this.CurrentBuilder.InvokeMethodCall(Node.Type, JLib.InvokeFunc);
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		Node.FuncNode.Accept(this);
		this.CurrentBuilder.LoadNewArray(this, 0, Node.ParamList);
		this.CurrentBuilder.InvokeMethodCall(Node.Type, JLib.InvokeFunc);
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(0), Node.RecvNode);
		this.CurrentBuilder.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(0), Node.RecvNode);
		this.CurrentBuilder.InvokeMethodCall(Method.GetReturnType(), Method.Body);
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
		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(0), Node.LeftNode);
		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(1), Node.RightNode);
		this.CurrentBuilder.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(0), Node.LeftNode);
		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(1), Node.RightNode);
		this.CurrentBuilder.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		Label elseLabel = new Label();
		Label mergeLabel = new Label();
		this.CurrentBuilder.PushEvaluatedNode(ZSystem.BooleanType, Node.LeftNode);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(IFEQ, elseLabel);

		this.CurrentBuilder.PushEvaluatedNode(ZSystem.BooleanType, Node.RightNode);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(IFEQ, elseLabel);

		this.CurrentBuilder.AsmVisitor.visitLdcInsn(true);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.AsmVisitor.visitLabel(elseLabel);
		this.CurrentBuilder.AsmVisitor.visitLdcInsn(false);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.AsmVisitor.visitLabel(mergeLabel);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		Label thenLabel = new Label();
		Label mergeLabel = new Label();
		this.CurrentBuilder.PushEvaluatedNode(ZSystem.BooleanType, Node.LeftNode);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(IFNE, thenLabel);

		this.CurrentBuilder.PushEvaluatedNode(ZSystem.BooleanType, Node.RightNode);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(IFNE, thenLabel);

		this.CurrentBuilder.AsmVisitor.visitLdcInsn(false);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.AsmVisitor.visitLabel(thenLabel);
		this.CurrentBuilder.AsmVisitor.visitLdcInsn(true);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.AsmVisitor.visitLabel(mergeLabel);
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		JLocalVarStack local = this.CurrentBuilder.AddLocal(Node.Type, Node.NativeName);
		this.CurrentBuilder.PushEvaluatedNode(Node.DeclType, Node.InitNode);
		this.CurrentBuilder.StoreLocal(local);
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Label ElseLabel = new Label();
		Label EndLabel = new Label();
		this.CurrentBuilder.PushEvaluatedNode(ZSystem.BooleanType, Node.CondNode);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(IFEQ, ElseLabel);

		// Then
		Node.ThenNode.Accept(this);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(GOTO, EndLabel);
		// Else
		this.CurrentBuilder.AsmVisitor.visitLabel(ElseLabel);
		if(Node.ElseNode != null) {
			Node.ElseNode.Accept(this);
			this.CurrentBuilder.AsmVisitor.visitJumpInsn(GOTO, EndLabel);
		}
		// End
		this.CurrentBuilder.AsmVisitor.visitLabel(EndLabel);
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		if(Node.ValueNode != null) {
			Node.ValueNode.Accept(this);
			Type type = this.GetAsmType(Node.ValueNode.Type);
			this.CurrentBuilder.AsmVisitor.visitInsn(type.getOpcode(IRETURN));
		}
		else {
			this.CurrentBuilder.AsmVisitor.visitInsn(RETURN);
		}
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		Label continueLabel = new Label();
		Label breakLabel = new Label();
		this.CurrentBuilder.BreakLabelStack.push(breakLabel);
		this.CurrentBuilder.ContinueLabelStack.push(continueLabel);

		this.CurrentBuilder.AsmVisitor.visitLabel(continueLabel);
		this.CurrentBuilder.PushEvaluatedNode(ZSystem.BooleanType, Node.CondNode);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(IFEQ, breakLabel); // condition
		Node.BodyNode.Accept(this);
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(GOTO, continueLabel);
		this.CurrentBuilder.AsmVisitor.visitLabel(breakLabel);

		this.CurrentBuilder.BreakLabelStack.pop();
		this.CurrentBuilder.ContinueLabelStack.pop();
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		Label l = this.CurrentBuilder.BreakLabelStack.peek();
		this.CurrentBuilder.AsmVisitor.visitJumpInsn(GOTO, l);
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
		MethodVisitor mv = this.CurrentBuilder.AsmVisitor;
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
		MethodVisitor mv = this.CurrentBuilder.AsmVisitor;
		Label catchLabel = new Label();
		TryCatchLabel Label = this.TryCatchLabel.get(this.TryCatchLabel.size() - 1);

		// prepare
		//TODO: add exception class name
		String throwType = this.GetAsmType(Node.ExceptionType).getInternalName();
		mv.visitTryCatchBlock(Label.beginTryLabel, Label.endTryLabel, catchLabel, throwType);

		// catch block
		JLocalVarStack local = this.CurrentBuilder.AddLocal(Node.ExceptionType, Node.ExceptionName);
		mv.visitLabel(catchLabel);
		this.CurrentBuilder.StoreLocal(local);
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
		String FuncName = Node.ReferenceName;
		JClassBuilder  HolderClass = this.ClassLoader.NewFunctionHolderClass(Node, FuncName);
		String MethodDesc = this.GetMethodDescriptor(Node.GetFuncType(null));
		MethodNode AsmMethodNode = new MethodNode(ACC_PUBLIC | ACC_STATIC, FuncName, MethodDesc, null, null);
		HolderClass.AddMethod(AsmMethodNode);
		this.CurrentBuilder = new JMethodBuilder(this, AsmMethodNode, this.CurrentBuilder);
		for(int i = 0; i < Node.ArgumentList.size(); i++) {
			ZParamNode ParamNode =(ZParamNode)Node.ArgumentList.get(i);
			this.CurrentBuilder.AddLocal(ParamNode.Type, ParamNode.Name);
		}
		Node.BodyNode.Accept(this);
		this.CurrentBuilder = this.CurrentBuilder.Parent;
	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
		@Var JClassBuilder ClassBuilder = this.ClassLoader.NewClass(Node, Node.ClassName, Node.SuperType);
		for(@Var int i = 0; i < Node.FieldList.size(); i++) {
			@Var ZFieldNode Field = Node.FieldList.get(i);
			if(Field.ClassType.Equals(Node.ClassType)) {
				@Var FieldNode fn = new FieldNode(ACC_PUBLIC, Field.FieldName, this.GetTypeDesc(Field.DeclType), null, this.GetConstValue(Field.InitNode));
				ClassBuilder.AddField(fn);
			}
		}

	}


	@Override public void VisitErrorNode(ZErrorNode Node) {
		String name = Type.getInternalName(SoftwareFaultException.class);
		this.CurrentBuilder.SetLineNumber(Node);
		this.CurrentBuilder.AsmVisitor.visitTypeInsn(NEW, name);
		this.CurrentBuilder.AsmVisitor.visitInsn(DUP);
		this.CurrentBuilder.LoadConst(Node.ErrorMessage);
		this.CurrentBuilder.AsmVisitor.visitMethodInsn(INVOKESPECIAL, name, "<init>", "(Ljava/lang/Object;)V");
		this.CurrentBuilder.AsmVisitor.visitInsn(ATHROW);
	}


}


