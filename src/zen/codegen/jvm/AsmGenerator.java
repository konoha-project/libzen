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
import zen.ast.ZThrowNode;
import zen.ast.ZTryNode;
import zen.ast.ZUnaryNode;
import zen.ast.ZVarDeclNode;
import zen.ast.ZWhileNode;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.deps.ZObject;
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

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		Class<?> ArrayClass = LibAsm.AsArrayClass(Node.Type);
		String Owner = Type.getInternalName(ArrayClass);
		this.CurrentBuilder.visitTypeInsn(NEW, Owner);
		this.CurrentBuilder.visitInsn(DUP);
		this.CurrentBuilder.PushInt(Node.Type.TypeId);
		this.CurrentBuilder.PushNodeListAsArray(LibAsm.AsElementClass(Node.Type), 0, Node);
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
			Constructor<?> jMethod = this.GetConstructor(Node.Type, Node);
			if(jMethod != null) {
				Class<?>[] P = jMethod.getParameterTypes();
				for(int i = 0; i < P.length; i++) {
					this.CurrentBuilder.PushNode(P[i], Node.GetListAt(i));
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

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		Class<?> DeclClass = this.GetJavaClass(Node.DeclType);
		this.CurrentBuilder.AddLocal(DeclClass, Node.NativeName);
		this.CurrentBuilder.PushNode(DeclClass, Node.AST[ZVarDeclNode.InitValue]);
		this.CurrentBuilder.StoreLocal(Node.NativeName);
		this.VisitBlockNode(Node);
		this.CurrentBuilder.RemoveLocal(DeclClass, Node.NativeName);
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		this.CurrentBuilder.LoadLocal(Node.VarName);
		this.CurrentBuilder.CheckReturnCast(Node, this.CurrentBuilder.GetLocalType(Node.VarName));
	}

	@Override public void VisitSetNameNode(ZSetNameNode Node) {
		this.CurrentBuilder.PushNode(this.CurrentBuilder.GetLocalType(Node.VarName), Node.AST[ZSetNameNode.Expr]);
		this.CurrentBuilder.StoreLocal(Node.VarName);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		Node.AST[ZGetterNode.Recv].Accept(this);
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
		if(Node.HasUntypedNode()) {
			Method sMethod = JavaMethodTable.GetStaticMethod("GetField");
			ZNode NameNode = new ZStringNode(Node, null, Node.FieldName);
			this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZGetterNode.Recv], NameNode});
		}
		else {
			Class<?> RecvClass = this.GetJavaClass(Node.AST[ZGetterNode.Recv].Type);
			Field jField = this.GetField(RecvClass, Node.FieldName);
			String Owner = Type.getType(RecvClass).getInternalName();
			String Desc = Type.getType(jField.getType()).getDescriptor();
			if(Modifier.isStatic(jField.getModifiers())) {
				this.CurrentBuilder.visitFieldInsn(Opcodes.GETSTATIC, Owner, Node.FieldName, Desc);
			}
			else {
				this.CurrentBuilder.PushNode(null, Node.AST[ZGetterNode.Recv]);
				this.CurrentBuilder.visitFieldInsn(GETFIELD, Owner, Node.FieldName, Desc);
			}
			this.CurrentBuilder.CheckReturnCast(Node, jField.getType());
		}
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		if(Node.HasUntypedNode()) {
			Method sMethod = JavaMethodTable.GetStaticMethod("SetField");
			ZNode NameNode = new ZStringNode(Node, null, Node.FieldName);
			this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZGetterNode.Recv], NameNode, Node.AST[ZSetterNode.Expr]});
		}
		else {
			Class<?> RecvClass = this.GetJavaClass(Node.AST[ZGetterNode.Recv].Type);
			Field jField = this.GetField(RecvClass, Node.FieldName);
			String Owner = Type.getType(RecvClass).getInternalName();
			String Desc = Type.getType(jField.getType()).getDescriptor();
			if(Modifier.isStatic(jField.getModifiers())) {
				this.CurrentBuilder.PushNode(jField.getType(), Node.AST[ZSetterNode.Expr]);
				this.CurrentBuilder.visitFieldInsn(Opcodes.PUTSTATIC, Owner, Node.FieldName, Desc);
			}
			else {
				this.CurrentBuilder.PushNode(null, Node.AST[ZGetterNode.Recv]);
				this.CurrentBuilder.PushNode(jField.getType(), Node.AST[ZSetterNode.Expr]);
				this.CurrentBuilder.visitFieldInsn(PUTFIELD, Owner, Node.FieldName, Desc);
			}
		}
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.AST[ZGetterNode.Recv].Type, "[]", Node.AST[ZGetIndexNode.Index].Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZGetterNode.Recv], Node.AST[ZGetIndexNode.Index]});
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.AST[ZGetterNode.Recv].Type, "[]=", Node.AST[ZSetIndexNode.Index].Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZGetterNode.Recv], Node.AST[ZSetIndexNode.Index], Node.AST[ZSetIndexNode.Expr]});
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
		Method jMethod = this.GetMethod(Node.AST[ZGetterNode.Recv].Type, Node.MethodName, Node);
		if(jMethod != null) {
			if(!Modifier.isStatic(jMethod.getModifiers())) {
				this.CurrentBuilder.PushNode(null, Node.AST[ZGetterNode.Recv]);
			}
			Class<?>[] P = jMethod.getParameterTypes();
			for(int i = 0; i < P.length; i++) {
				this.CurrentBuilder.PushNode(P[i], Node.GetListAt(i));
			}
			int inst = this.GetInvokeType(jMethod);
			String owner = Type.getInternalName(jMethod.getDeclaringClass());
			this.CurrentBuilder.visitMethodInsn(inst, owner, jMethod.getName(), Type.getMethodDescriptor(jMethod));
			this.CurrentBuilder.CheckReturnCast(Node, jMethod.getReturnType());
		}
		else {
			jMethod = JavaMethodTable.GetStaticMethod("InvokeUnresolvedMethod");
			this.CurrentBuilder.PushNode(Object.class, Node.AST[ZGetterNode.Recv]);
			this.CurrentBuilder.PushConst(Node.MethodName);
			this.CurrentBuilder.PushNodeListAsArray(Object.class, 0, Node);
			this.CurrentBuilder.ApplyStaticMethod(Node, jMethod, null);
		}
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		this.CurrentBuilder.SetLineNumber(Node);
		if(Node.ResolvedFuncName != null) {
			ZNode[] Nodes = this.PackNodes(null, Node);
			this.CurrentBuilder.ApplyFuncName(Node, Node.ResolvedFuncName, Node.ResolvedFuncType, Nodes);
		}
		else {
			if(Node.AST[ZFuncCallNode.Func].Type.IsFuncType()) {
				ZFuncType FuncType = (ZFuncType)Node.AST[ZFuncCallNode.Func].Type;
				Class<?> FuncClass = this.ClassLoader.LoadFuncClass(FuncType);
				ZNode[] Nodes = this.PackNodes(null, Node);
				this.CurrentBuilder.ApplyFuncObject(Node, FuncClass, Node.AST[ZFuncCallNode.Func], FuncType, Nodes);
			}
			else {

			}
		}
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		Method sMethod = JavaMethodTable.GetUnaryStaticMethod(Node.SourceToken.GetText(), Node.AST[ZGetterNode.Recv].Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZGetterNode.Recv]});
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		Method sMethod = JavaMethodTable.GetUnaryStaticMethod(Node.SourceToken.GetText(), Node.AST[ZGetterNode.Recv].Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZGetterNode.Recv]});
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		if(Node.Type.IsVoidType()) {
			Node.AST[ZCastNode.Expr].Accept(this);
			this.CurrentBuilder.Pop(Node.AST[ZCastNode.Expr].Type);
		}
		else {
			Class<?> C1 = this.GetJavaClass(Node.Type);
			Class<?> C2 = this.GetJavaClass(Node.AST[ZCastNode.Expr].Type);
			Method sMethod = JavaMethodTable.GetCastMethod(C1, C2);
			if(sMethod != null) {
				this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZCastNode.Expr]});
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
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.AST[ZBinaryNode.Left].Type, Node.SourceToken.GetText(), Node.AST[ZBinaryNode.Right].Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZBinaryNode.Left], Node.AST[ZBinaryNode.Right]});
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.AST[ZBinaryNode.Left].Type, Node.SourceToken.GetText(), Node.AST[ZBinaryNode.Right].Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZBinaryNode.Left], Node.AST[ZBinaryNode.Right]});
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		Label elseLabel = new Label();
		Label mergeLabel = new Label();
		this.CurrentBuilder.PushNode(boolean.class, Node.AST[ZBinaryNode.Left]);
		this.CurrentBuilder.visitJumpInsn(IFEQ, elseLabel);

		this.CurrentBuilder.PushNode(boolean.class, Node.AST[ZBinaryNode.Right]);
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
		this.CurrentBuilder.PushNode(boolean.class, Node.AST[ZBinaryNode.Left]);
		this.CurrentBuilder.visitJumpInsn(IFNE, thenLabel);

		this.CurrentBuilder.visitLdcInsn(true);
		this.CurrentBuilder.PushNode(boolean.class, Node.AST[ZBinaryNode.Right]);
		this.CurrentBuilder.visitJumpInsn(IFNE, thenLabel);

		this.CurrentBuilder.visitLdcInsn(false);
		this.CurrentBuilder.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.visitLabel(thenLabel);
		this.CurrentBuilder.visitLdcInsn(true);
		this.CurrentBuilder.visitJumpInsn(GOTO, mergeLabel);

		this.CurrentBuilder.visitLabel(mergeLabel);
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		for (int i = 0; i < Node.GetListSize(); i++) {
			Node.GetListAt(i).Accept(this);

		}
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Label ElseLabel = new Label();
		Label EndLabel = new Label();
		this.CurrentBuilder.PushNode(boolean.class, Node.AST[ZIfNode.Cond]);
		this.CurrentBuilder.visitJumpInsn(IFEQ, ElseLabel);
		// Then
		Node.AST[ZIfNode.Then].Accept(this);
		this.CurrentBuilder.visitJumpInsn(GOTO, EndLabel);
		// Else
		this.CurrentBuilder.visitLabel(ElseLabel);
		if(Node.AST[ZIfNode.Else] != null) {
			Node.AST[ZIfNode.Else].Accept(this);
			this.CurrentBuilder.visitJumpInsn(GOTO, EndLabel);
		}
		// End
		this.CurrentBuilder.visitLabel(EndLabel);
	}

	@Override public void VisitReturnNode(ZReturnNode Node) {
		if(Node.AST[ZReturnNode.Expr] != null) {
			Node.AST[ZReturnNode.Expr].Accept(this);
			Type type = this.AsmType(Node.AST[ZReturnNode.Expr].Type);
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
		this.CurrentBuilder.PushNode(boolean.class, Node.AST[ZWhileNode.Cond]);
		this.CurrentBuilder.visitJumpInsn(IFEQ, breakLabel); // condition
		Node.AST[ZWhileNode.Block].Accept(this);
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
		Node.AST[ZTryNode.Try].Accept(this);
		mv.visitLabel(Label.endTryLabel);
		mv.visitJumpInsn(GOTO, Label.finallyLabel);

		// finally block
		mv.visitLabel(Label.finallyLabel);
		if(Node.AST[ZTryNode.Finally] != null) {
			Node.AST[ZTryNode.Finally].Accept(this);
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
		Node.AST[ZCatchNode.Block].Accept(this);
		mv.visitJumpInsn(GOTO, Label.finallyLabel);

		this.CurrentBuilder.RemoveLocal(this.GetJavaClass(Node.ExceptionType), Node.ExceptionName);
	}

	public void VisitStaticField(StaticFieldNode Node) {
		String FieldDesc = Type.getDescriptor(this.GetJavaClass(Node.Type));
		this.CurrentBuilder.visitFieldInsn(Opcodes.GETSTATIC, Type.getInternalName(Node.StaticClass), Node.FieldName, FieldDesc);
	}

	@Override public void VisitLetNode(ZLetNode Node) {
		if(!(Node.AST[ZLetNode.InitValue] instanceof ZConstNode)) {
			String ClassName = "Symbol" + Node.GlobalName;
			@Var String SourceFile = Node.SourceToken.GetFileName();
			@Var AsmClassBuilder cb = new AsmClassBuilder(ACC_PUBLIC|Opcodes.ACC_FINAL, SourceFile, ClassName, "java/lang/Object");
			this.ClassLoader.AddClassBuilder(cb);
			Class<?> ValueClass = this.GetJavaClass(Node.AST[ZLetNode.InitValue].Type);
			@Var FieldNode fn = new FieldNode(ACC_PUBLIC|ACC_STATIC, "_", Type.getDescriptor(ValueClass), null, null);
			cb.AddField(fn);
			this.CurrentBuilder = new AsmMethodBuilder(ACC_PUBLIC | ACC_STATIC, "<clinit>", "()V", this, this.CurrentBuilder);
			this.CurrentBuilder.PushNode(ValueClass, Node.AST[ZLetNode.InitValue]);
			this.CurrentBuilder.visitFieldInsn(Opcodes.PUTSTATIC, ClassName, "_",  Type.getDescriptor(ValueClass));
			this.CurrentBuilder.visitInsn(RETURN);
			cb.AddMethod(this.CurrentBuilder);
			this.CurrentBuilder = this.CurrentBuilder.Parent;
			try {
				Class<?> StaticClass = this.ClassLoader.loadClass(ClassName);
				Node.AST[ZLetNode.InitValue] = new StaticFieldNode(null, StaticClass, Node.AST[ZLetNode.InitValue].Type, "_");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Node.GetNameSpace().SetLocalSymbol(Node.Symbol, Node.AST[ZLetNode.InitValue]);
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
		for(int i = 0; i < Node.GetListSize(); i++) {
			ZParamNode ParamNode = Node.GetParamNode(i);
			Class<?> DeclClass = this.GetJavaClass(ParamNode.Type);
			this.CurrentBuilder.AddLocal(DeclClass, ParamNode.Name);
		}
		Node.AST[ZFunctionNode.Block].Accept(this);
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
		for(@Var int i = 0; i < Node.GetListSize(); i++) {
			@Var ZFieldNode Field = Node.GetFieldNode(i);
			if(Field.ClassType.Equals(Node.ClassType)) {
				@Var FieldNode fn = new FieldNode(ACC_PUBLIC, Field.FieldName, this.GetTypeDesc(Field.DeclType), null, this.GetConstValue(Field.AST[ZFieldNode.InitValue]));
				ClassBuilder.AddField(fn);
			}
		}
		for(@Var int i = 0; i < Node.GetListSize(); i++) {
			@Var ZFieldNode Field = Node.GetFieldNode(i);
			if(Field.DeclType.IsFuncType()) {
				System.out.println("ClassMethodName(Node.ClassType, Field.FieldName)"+ClassMethodName(Node.ClassType, Field.FieldName));
				@Var FieldNode fn = new FieldNode(ACC_PUBLIC|ACC_STATIC, ClassMethodName(Node.ClassType, Field.FieldName), this.GetTypeDesc(Field.DeclType), null, null);
				ClassBuilder.AddField(fn);
			}
		}
		this.CurrentBuilder = new AsmMethodBuilder(ACC_PUBLIC, "<init>", "(I)V", this, this.CurrentBuilder);
		this.CurrentBuilder.visitVarInsn(Opcodes.ALOAD, 0);
		this.CurrentBuilder.visitVarInsn(Opcodes.ILOAD, 1);
		@Var Class<?> SuperClass = null;
		if(Node.SuperType != null) {
			SuperClass = this.GetJavaClass(Node.SuperType);
		}
		else {
			SuperClass = ZObject.class;
		}
		this.CurrentBuilder.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(SuperClass), "<init>", "(I)V");
		for(@Var int i = 0; i < Node.GetListSize(); i++) {
			@Var ZFieldNode Field = Node.GetFieldNode(i);
			if(Field.DeclType.IsFuncType()) {
				String FieldDesc = Type.getDescriptor(this.GetJavaClass(Field.DeclType));
				this.CurrentBuilder.visitFieldInsn(Opcodes.GETSTATIC, Node.ClassName, ClassMethodName(Node.ClassType, Field.FieldName), FieldDesc);
				this.CurrentBuilder.visitFieldInsn(Opcodes.PUTFIELD, Type.getInternalName(this.GetJavaClass(Field.ClassType)), Field.FieldName, FieldDesc);
			}
			else if(Field.ClassType.Equals(Node.ClassType) && !(Field.AST[ZFieldNode.InitValue] instanceof ZConstNode)) {
				this.CurrentBuilder.PushNode(this.GetJavaClass(Field.DeclType), Field.AST[ZFieldNode.InitValue]);
				this.CurrentBuilder.visitFieldInsn(PUTFIELD, Node.ClassName, Field.FieldName, Type.getDescriptor(this.GetJavaClass(Field.DeclType)));
			}
		}
		this.CurrentBuilder.visitInsn(RETURN);
		ClassBuilder.AddMethod(this.CurrentBuilder);
		this.CurrentBuilder = this.CurrentBuilder.Parent;
		try {
			Class<?> c = this.ClassLoader.loadClass(Node.ClassName);
			JavaTypeTable.SetTypeTable(Node.ClassType, c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

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


