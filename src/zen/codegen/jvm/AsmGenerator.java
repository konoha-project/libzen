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
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Stack;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;

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
import zen.ast.ZErrorNode;
import zen.ast.ZFieldNode;
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
import zen.ast.ZParamNode;
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
import zen.deps.LibNative;
import zen.deps.Var;
import zen.lang.ZSystem;
import zen.lang.ZenClassType;
import zen.type.ZFuncType;
import zen.type.ZType;

public class AsmGenerator extends JavaSolution {
	AsmMethodBuilder CurrentBuilder;
	AsmClassLoader ClassLoader = null;
	Stack<TryCatchLabel> TryCatchLabel;
	private int LambdaMethodId = 0;

	public AsmGenerator() {
		super("java", "1.6");
		this.TryCatchLabel = new Stack<TryCatchLabel>();
		this.ClassLoader = new AsmClassLoader(this);
	}

	@Override
	public final Class<?> GetJavaClass(ZType zType) {
		if(zType instanceof ZFuncType) {
			return this.ClassLoader.LoadFuncClass((ZFuncType)zType);
		}
		else if(zType instanceof ZenClassType) {
			return null;
		}
		else {
			return JavaTypeTable.GetJavaClass(zType, Object.class);
		}
	}

	final Type AsmType(ZType zType) {
		return Type.getType(this.GetJavaClass(zType));
	}

	final String GetTypeDesc(ZType zType) {
		Class<?> JClass = this.GetJavaClass(zType);
		return Type.getDescriptor(JClass);
	}

	final String GetMethodDescriptor(ZFuncType FuncType) {
		@Var Type ReturnType = this.AsmType(FuncType.GetReturnType());
		@Var Type[] ArgTypes = new Type[FuncType.GetFuncParamSize()];
		for(int i = 0; i < ArgTypes.length; i++) {
			ZType ParamType = FuncType.GetFuncParamType(i);
			ArgTypes[i] = this.AsmType(ParamType);
		}
		String Desc = Type.getMethodDescriptor(ReturnType, ArgTypes);
		//System.out.println(" ** Desc: " + Desc + ", FuncType: " + FuncType);
		return Desc;
	}


	@Override public void VisitNullNode(ZNullNode Node) {
		this.CurrentBuilder.visitInsn(Opcodes.ACONST_NULL);
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.CurrentBuilder.PushBoolean(Node.BooleanValue);
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.CurrentBuilder.PushLong(Node.IntValue);
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.CurrentBuilder.PushDouble(Node.FloatValue);
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.CurrentBuilder.visitLdcInsn(Node.StringValue);
	}

	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
		this.Debug("TODO");
		this.CurrentBuilder.visitInsn(Opcodes.ACONST_NULL);

		//		Object constValue = Node.ConstValue;
		//		LibNative.Assert(Node.ConstValue != null);
		//		this.CurrentBuilder.LoadConst(constValue);
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		Class<?> ArrayClass = LibAsm.AsArrayClass(Node.Type);
		String Owner = Type.getInternalName(ArrayClass);
		this.CurrentBuilder.visitTypeInsn(NEW, Owner);
		this.CurrentBuilder.visitInsn(DUP);
		this.CurrentBuilder.PushInt(Node.Type.TypeId);
		this.CurrentBuilder.PushNodeListAsArray(LibAsm.AsElementClass(Node.Type), 0, Node.NodeList);
		this.CurrentBuilder.SetLineNumber(Node);
		this.CurrentBuilder.visitMethodInsn(INVOKESPECIAL, Owner, "<init>", LibAsm.NewArrayDescriptor(Node.Type));
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		this.Debug("TODO");
		this.CurrentBuilder.visitInsn(Opcodes.ACONST_NULL);
		// TODO Auto-generated method stub
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		this.Debug("TODO");
		this.CurrentBuilder.visitInsn(Opcodes.ACONST_NULL);
		//		this.CurrentBuilder.LoadConst(Node.Type);
		//		this.CurrentBuilder.LoadNewArray(this, 0, Node.NodeList);
		//		this.CurrentBuilder.InvokeMethodCall(Node.Type, JLib.NewArray);
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		if(Node.Type.IsVarType()) {
			this.Logger.ReportError(Node.SourceToken, "no class for new operator");
			this.CurrentBuilder.visitInsn(Opcodes.ACONST_NULL);
		}
		else {
			String ClassName = Type.getInternalName(this.GetJavaClass(Node.Type));
			this.CurrentBuilder.visitTypeInsn(NEW, ClassName);
			this.CurrentBuilder.visitInsn(DUP);
			Constructor<?> jMethod = this.GetConstructor(Node.Type, Node.ParamList);
			if(jMethod != null) {
				Class<?>[] P = jMethod.getParameterTypes();
				for(int i = 0; i < P.length; i++) {
					this.CurrentBuilder.PushNode(P[i], Node.ParamList.get(i));
				}
				this.CurrentBuilder.SetLineNumber(Node);
				this.CurrentBuilder.visitMethodInsn(INVOKESPECIAL, ClassName, "<init>", Type.getConstructorDescriptor(jMethod));
			}
			else {
				this.CurrentBuilder.PushInt(Node.Type.TypeId);
				this.CurrentBuilder.SetLineNumber(Node);
				this.CurrentBuilder.visitMethodInsn(INVOKESPECIAL, ClassName, "<init>", "(I)V");
			}
		}
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {
		this.Debug("TODO");
		this.CurrentBuilder.visitInsn(Opcodes.ACONST_NULL);
		// TODO Auto-generated method stub
	}

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		Class<?> DeclClass = this.GetJavaClass(Node.DeclType);
		this.CurrentBuilder.AddLocal(DeclClass, Node.NativeName);
		this.CurrentBuilder.PushNode(DeclClass, Node.InitNode);
		this.CurrentBuilder.StoreLocal(Node.NativeName);
		this.VisitBlockNode(Node);
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.LoadLocal(Node.VarName);
		this.CurrentBuilder.CheckReturnCast(Node, this.CurrentBuilder.GetLocalType(Node.VarName));
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.PushNode(this.CurrentBuilder.GetLocalType(Node.VarName), Node.ValueNode);
		this.CurrentBuilder.StoreLocal(Node.VarName);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		Node.RecvNode.Accept(this);
	}

	private Field GetField(Class<?> RecvClass, String Name) {
		try {
			return RecvClass.getField(Name);
		} catch (Exception e) {
			LibNative.FixMe(e);
		}
		return null;  // type checker guarantees field exists
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		if(Node.IsUntyped()) {
			Method sMethod = JavaMethodTable.GetStaticMethod("GetField");
			ZNode NameNode = new ZStringNode(Node, null, Node.FieldName);
			this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, NameNode});
		}
		else {
			Class<?> RecvClass = this.GetJavaClass(Node.RecvNode.Type);
			Field jField = this.GetField(RecvClass, Node.FieldName);
			String Owner = Type.getType(RecvClass).getInternalName();
			String Desc = Type.getType(jField.getType()).getDescriptor();
			if(Modifier.isStatic(jField.getModifiers())) {
				this.CurrentBuilder.visitFieldInsn(Opcodes.GETSTATIC, Owner, Node.FieldName, Desc);
			}
			else {
				this.CurrentBuilder.PushNode(null, Node.RecvNode);
				this.CurrentBuilder.visitFieldInsn(GETFIELD, Owner, Node.FieldName, Desc);
			}
			this.CurrentBuilder.CheckReturnCast(Node, jField.getType());
		}
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		if(Node.IsUntyped()) {
			Method sMethod = JavaMethodTable.GetStaticMethod("SetField");
			ZNode NameNode = new ZStringNode(Node, null, Node.FieldName);
			this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, NameNode, Node.ValueNode});
		}
		else {
			Class<?> RecvClass = this.GetJavaClass(Node.RecvNode.Type);
			Field jField = this.GetField(RecvClass, Node.FieldName);
			String Owner = Type.getType(RecvClass).getInternalName();
			String Desc = Type.getType(jField.getType()).getDescriptor();
			if(Modifier.isStatic(jField.getModifiers())) {
				this.CurrentBuilder.PushNode(jField.getType(), Node.ValueNode);
				this.CurrentBuilder.visitFieldInsn(Opcodes.PUTSTATIC, Owner, Node.FieldName, Desc);
			}
			else {
				this.CurrentBuilder.PushNode(null, Node.RecvNode);
				this.CurrentBuilder.PushNode(jField.getType(), Node.ValueNode);
				this.CurrentBuilder.visitFieldInsn(PUTFIELD, Owner, Node.FieldName, Desc);
			}
		}
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.RecvNode.Type, "[]", Node.IndexNode.Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, Node.IndexNode});
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.RecvNode.Type, "[]=", Node.IndexNode.Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, Node.IndexNode, Node.ValueNode});
	}

	private int GetInvokeType(Method jMethod) {
		if(Modifier.isStatic(jMethod.getModifiers())) {
			return INVOKESTATIC;
		}
		if(Modifier.isInterface(jMethod.getModifiers())) {
			return INVOKEINTERFACE;
		}
		return INVOKEVIRTUAL;
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		this.CurrentBuilder.SetLineNumber(Node);
		Method jMethod = this.GetMethod(Node.RecvNode.Type, Node.MethodName, Node.ParamList);
		if(jMethod != null) {
			if(!Modifier.isStatic(jMethod.getModifiers())) {
				this.CurrentBuilder.PushNode(null, Node.RecvNode);
			}
			Class<?>[] P = jMethod.getParameterTypes();
			for(int i = 0; i < P.length; i++) {
				this.CurrentBuilder.PushNode(P[i], Node.ParamList.get(i));
			}
			int inst = this.GetInvokeType(jMethod);
			String owner = Type.getInternalName(jMethod.getDeclaringClass());
			this.CurrentBuilder.visitMethodInsn(inst, owner, jMethod.getName(), Type.getMethodDescriptor(jMethod));
			this.CurrentBuilder.CheckReturnCast(Node, jMethod.getReturnType());
		}
		else {
			jMethod = JavaMethodTable.GetStaticMethod("InvokeUnresolvedMethod");
			this.CurrentBuilder.PushNode(Object.class, Node.RecvNode);
			this.CurrentBuilder.PushConst(Node.MethodName);
			this.CurrentBuilder.PushNodeListAsArray(Object.class, 0, Node.ParamList);
			this.CurrentBuilder.ApplyStaticMethod(Node, jMethod, null);
		}
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.CurrentBuilder.SetLineNumber(Node);
		if(Node.ResolvedFuncName != null) {
			ZNode[] Nodes = this.PackNodes(null, Node.ParamList);
			this.CurrentBuilder.ApplyFuncName(Node, Node.ResolvedFuncName, Node.ResolvedFuncType, Nodes);
		}
		else {
			if(Node.FuncNode.Type.IsFuncType()) {
				ZFuncType FuncType = (ZFuncType)Node.FuncNode.Type;
				Class<?> FuncClass = this.ClassLoader.LoadFuncClass(FuncType);
				ZNode[] Nodes = this.PackNodes(null, Node.ParamList);
				this.CurrentBuilder.ApplyFuncObject(Node, FuncClass, Node.FuncNode, FuncType, Nodes);
			}
			else {

			}
		}
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		Method sMethod = JavaMethodTable.GetUnaryStaticMethod(Node.SourceToken.ParsedText, Node.RecvNode.Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		Method sMethod = JavaMethodTable.GetUnaryStaticMethod(Node.SourceToken.ParsedText, Node.RecvNode.Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		if(Node.Type.IsVoidType()) {
			this.CurrentBuilder.Pop(Node.ExprNode.Type);
		}
		else {
			Class<?> C1 = this.GetJavaClass(Node.Type);
			Class<?> C2 = this.GetJavaClass(Node.ExprNode.Type);
			Method sMethod = JavaMethodTable.GetCastMethod(C1, C2);
			if(sMethod != null) {
				this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.ExprNode});
			}
			else if(!C1.isAssignableFrom(C2)) {
				this.CurrentBuilder.visitTypeInsn(Opcodes.CHECKCAST, Type.getInternalName(C1));
			}
		}
	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.ParsedText, Node.RightNode.Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.LeftNode, Node.RightNode});
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.ParsedText, Node.RightNode.Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.LeftNode, Node.RightNode});
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		Label elseLabel = new Label();
		Label mergeLabel = new Label();
		this.CurrentBuilder.PushNode(boolean.class, Node.LeftNode);
		this.CurrentBuilder.visitJumpInsn(IFEQ, elseLabel);

		this.CurrentBuilder.PushNode(boolean.class, Node.RightNode);
		this.CurrentBuilder.visitJumpInsn(IFEQ, elseLabel);

		this.CurrentBuilder.visitLdcInsn(true);
		this.CurrentBuilder.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.visitLabel(elseLabel);
		this.CurrentBuilder.visitLdcInsn(false);
		this.CurrentBuilder.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.visitLabel(mergeLabel);
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		Label thenLabel = new Label();
		Label mergeLabel = new Label();
		this.CurrentBuilder.PushNode(boolean.class, Node.LeftNode);
		this.CurrentBuilder.visitJumpInsn(IFNE, thenLabel);

		this.CurrentBuilder.visitLdcInsn(true);
		this.CurrentBuilder.PushNode(boolean.class, Node.RightNode);
		this.CurrentBuilder.visitJumpInsn(IFNE, thenLabel);

		this.CurrentBuilder.visitLdcInsn(false);
		this.CurrentBuilder.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.visitLabel(thenLabel);
		this.CurrentBuilder.visitLdcInsn(true);
		this.CurrentBuilder.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.visitLabel(mergeLabel);
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		for (int i = 0; i < Node.StmtList.size(); i++) {
			Node.StmtList.get(i).Accept(this);

		}
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Label ElseLabel = new Label();
		Label EndLabel = new Label();
		this.CurrentBuilder.PushNode(boolean.class, Node.CondNode);
		this.CurrentBuilder.visitJumpInsn(IFEQ, ElseLabel);
		// Then
		Node.ThenNode.Accept(this);
		this.CurrentBuilder.visitJumpInsn(GOTO, EndLabel);
		// Else
		this.CurrentBuilder.visitLabel(ElseLabel);
		if(Node.ElseNode != null) {
			Node.ElseNode.Accept(this);
			this.CurrentBuilder.visitJumpInsn(GOTO, EndLabel);
		}
		// End
		this.CurrentBuilder.visitLabel(EndLabel);
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		if(Node.ValueNode != null) {
			Node.ValueNode.Accept(this);
			Type type = this.AsmType(Node.ValueNode.Type);
			this.CurrentBuilder.visitInsn(type.getOpcode(IRETURN));
		}
		else {
			this.CurrentBuilder.visitInsn(RETURN);
		}
	}

	@Override public void VisitWhileNode(ZWhileNode Node) {
		Label continueLabel = new Label();
		Label breakLabel = new Label();
		this.CurrentBuilder.BreakLabelStack.push(breakLabel);
		this.CurrentBuilder.ContinueLabelStack.push(continueLabel);

		this.CurrentBuilder.visitLabel(continueLabel);
		this.CurrentBuilder.PushNode(boolean.class, Node.CondNode);
		this.CurrentBuilder.visitJumpInsn(IFEQ, breakLabel); // condition
		Node.BodyNode.Accept(this);
		this.CurrentBuilder.visitJumpInsn(GOTO, continueLabel);
		this.CurrentBuilder.visitLabel(breakLabel);

		this.CurrentBuilder.BreakLabelStack.pop();
		this.CurrentBuilder.ContinueLabelStack.pop();
	}

	@Override public void VisitBreakNode(ZBreakNode Node) {
		Label l = this.CurrentBuilder.BreakLabelStack.peek();
		this.CurrentBuilder.visitJumpInsn(GOTO, l);
	}

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
		MethodVisitor mv = this.CurrentBuilder;
		TryCatchLabel Label = new TryCatchLabel();
		this.TryCatchLabel.push(Label); // push

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
		this.TryCatchLabel.pop();
	}

	@Override public void VisitCatchNode(ZCatchNode Node) {
		MethodVisitor mv = this.CurrentBuilder;
		Label catchLabel = new Label();
		TryCatchLabel Label = this.TryCatchLabel.peek();

		// prepare
		//TODO: add exception class name
		String throwType = this.AsmType(Node.ExceptionType).getInternalName();
		mv.visitTryCatchBlock(Label.beginTryLabel, Label.endTryLabel, catchLabel, throwType);

		// catch block
		this.CurrentBuilder.AddLocal(this.GetJavaClass(Node.ExceptionType), Node.ExceptionName);
		mv.visitLabel(catchLabel);
		this.CurrentBuilder.StoreLocal(Node.ExceptionName);
		Node.BodyNode.Accept(this);
		mv.visitJumpInsn(GOTO, Label.finallyLabel);
		//FIXME: remove local
		this.CurrentBuilder.RemoveLocal(this.GetJavaClass(Node.ExceptionType), Node.ExceptionName);
	}

	public void VisitStaticField(StaticFieldNode Node) {
		String FieldDesc = Type.getDescriptor(this.GetJavaClass(Node.Type));
		this.CurrentBuilder.visitFieldInsn(Opcodes.GETSTATIC, Type.getInternalName(Node.StaticClass), Node.FieldName, FieldDesc);
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		if(!(Node.ValueNode instanceof ZConstNode)) {
			String ClassName = "Symbol" + Node.GlobalName;
			@Var String SourceFile = ZSystem.GetSourceFileName(Node.SourceToken.FileLine);
			@Var AsmClassBuilder cb = new AsmClassBuilder(ACC_PUBLIC|Opcodes.ACC_FINAL, SourceFile, ClassName, "java/lang/Object");
			this.ClassLoader.AddClassBuilder(cb);
			Class<?> ValueClass = this.GetJavaClass(Node.ValueNode.Type);
			@Var FieldNode fn = new FieldNode(ACC_PUBLIC|ACC_STATIC, "_", Type.getDescriptor(ValueClass), null, null);
			cb.AddField(fn);
			this.CurrentBuilder = new AsmMethodBuilder(ACC_PUBLIC | ACC_STATIC, "<clinit>", "()V", this, this.CurrentBuilder);
			this.CurrentBuilder.PushNode(ValueClass, Node.ValueNode);
			this.CurrentBuilder.visitFieldInsn(Opcodes.PUTSTATIC, ClassName, "_",  Type.getDescriptor(ValueClass));
			this.CurrentBuilder.visitInsn(RETURN);
			cb.AddMethod(this.CurrentBuilder);
			this.CurrentBuilder = this.CurrentBuilder.Parent;
			Class<?> StaticClass;
			try {
				StaticClass = this.ClassLoader.loadClass(ClassName);
				Node.ValueNode = new StaticFieldNode(null, StaticClass, Node.ValueNode.Type, "_");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Node.GetNameSpace().SetLocalSymbol(Node.Symbol, Node.ValueNode);
	}

	public void VisitJvmFuncNode(JvmFuncNode Node) {
		this.CurrentBuilder.visitFieldInsn(Opcodes.GETSTATIC, Node.ClassName, "FUNCTION", Node.FieldDesc);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(Node.FuncName == null) {
			Node.FuncName = "labmda" + this.LambdaMethodId;
			this.LambdaMethodId += 1;
		}
		@Var ZFuncType FuncType = Node.GetFuncType(null);
		@Var JvmFuncNode FuncNode = new JvmFuncNode(Node, FuncType, Node.FuncName);
		@Var AsmClassBuilder  HolderClass = this.ClassLoader.NewFunctionHolderClass(Node, FuncNode, FuncType);
		@Var String MethodDesc = this.GetMethodDescriptor(FuncType);
		//System.out.println("*** " + MethodDesc);
		this.CurrentBuilder = new AsmMethodBuilder(ACC_PUBLIC | ACC_STATIC, Node.FuncName, MethodDesc, this, this.CurrentBuilder);
		HolderClass.AddMethod(this.CurrentBuilder);
		for(int i = 0; i < Node.ParamList.size(); i++) {
			ZParamNode ParamNode = Node.ParamList.get(i);
			Class<?> DeclClass = this.GetJavaClass(ParamNode.Type);
			this.CurrentBuilder.AddLocal(DeclClass, ParamNode.Name);
		}
		Node.FuncBlock.Accept(this);
		//		if(Node.ReturnType.IsVoidType()) {
		//			// JVM always needs return;
		//			this.CurrentBuilder.visitInsn(RETURN);
		//		}
		try {
			Method FuncMethod = HolderClass.GetDefinedMethod(this.ClassLoader, Node.FuncName);
			//this.Debug("InteranalName: " +Type.getInternalName(FuncMethod.getDeclaringClass()));
			this.SetStaticFuncMethod(FuncType.StringfySignature(Node.FuncName), FuncMethod);
			FuncNode.FuncClass = FuncMethod.getDeclaringClass();
			Node.GetNameSpace().SetLocalSymbol(Node.FuncName, FuncNode);
		}
		catch(Error e) {
			e.printStackTrace();
		}
		this.CurrentBuilder = this.CurrentBuilder.Parent;
	}

	private final static String ClassMethodName(ZType ClassType, String FieldName) {
		return FieldName+ ClassType.TypeId;
	}

	@Override public void VisitClassDeclNode(ZClassDeclNode Node) {
		@Var AsmClassBuilder ClassBuilder = this.ClassLoader.NewClass(Node, Node.ClassName, Node.SuperType);
		for(@Var int i = 0; i < Node.FieldList.size(); i++) {
			@Var ZFieldNode Field = Node.FieldList.get(i);
			if(Field.ClassType.Equals(Node.ClassType)) {
				@Var FieldNode fn = new FieldNode(ACC_PUBLIC, Field.FieldName, this.GetTypeDesc(Field.DeclType), null, this.GetConstValue(Field.InitNode));
				ClassBuilder.AddField(fn);
			}
		}
		for(@Var int i = 0; i < Node.FieldList.size(); i++) {
			@Var ZFieldNode Field = Node.FieldList.get(i);
			if(Field.Type.IsFuncType()) {
				@Var FieldNode fn = new FieldNode(ACC_PUBLIC|ACC_STATIC, ClassMethodName(Node.ClassType, Field.FieldName), this.GetTypeDesc(Field.DeclType), null, this.GetConstValue(Field.InitNode));
				ClassBuilder.AddField(fn);
			}
		}
		//		AsmMethodBuilder constructor = new AsmMethodBuilder(ACC_PUBLIC, "<init>", MethodDesc, "(I)V", this, this.CurrentBuilder);
		//		constructor.visitVarInsn(ALOAD, 0);
		//		constructor.visitVarInsn(ILOAD, 1);
		//		constructor.visitMethodInsn(INVOKESPECIAL, superClassName, "<init>", "(I)V");
		//		for(@Var int i = 0; i < Node.FieldList.size(); i++) {
		//			@Var ZFieldNode Field = Node.FieldList.get(i);
		//			if(Field.ClassType.Equals(Node.ClassType)) {
		//				this.CurrentBuilder.PushNode(JavaTypeTable.GetJavaClass(Field.Type), Node);
		//				constructor.visitFieldInsn(PUTFIELD, ClassName, Field.FieldName, desc);
		//
		//				@Var FieldNode fn = new FieldNode(ACC_PUBLIC, Field.FieldName, AsmClassLoader.GetTypeDesc(Field.DeclType), null, this.GetConstValue(Field.InitNode));
		//				ClassBuilder.AddField(fn);
		//			}
		//		}
		//
		//		for(ZenFieldInfo field : ClassField.FieldList) {
		//			if(field.FieldIndex >= ClassField.ThisClassIndex && field.InitValue != null) {
		//				String name = field.NativeName;
		//				String desc = JLib.GetAsmType(field.Type).getDescriptor();
		//				constructor.visitVarInsn(ALOAD, 0);
		//				constructor.visitLdcInsn(field.InitValue);
		//				constructor.visitFieldInsn(PUTFIELD, ClassName, name, desc);
		//			}
		//		}
		//		constructor.visitInsn(RETURN);
		//		ClassBuilder.AddMethod(constructor);
	}

	@Override public void VisitErrorNode(ZErrorNode Node) {
		String Message = this.Logger.ReportError(Node.SourceToken, Node.ErrorMessage);
		this.CurrentBuilder.PushConst(Message);
		Method sMethod = JavaMethodTable.GetStaticMethod("ThrowError");
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, null);
	}

	@Override public void VisitExtendedNode(ZNode Node) {
	}

}


