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

package zen.codegen;
import static org.objectweb.asm.Opcodes.AASTORE;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACONST_NULL;
import static org.objectweb.asm.Opcodes.ANEWARRAY;
import static org.objectweb.asm.Opcodes.ATHROW;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INSTANCEOF;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.ISTORE;
import static org.objectweb.asm.Opcodes.L2I;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.POP;
import static org.objectweb.asm.Opcodes.POP2;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.PUTSTATIC;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import zen.ast.ZenAndNode;
import zen.ast.ZenApplyNode;
import zen.ast.ZenBooleanNode;
import zen.ast.ZenConstPoolNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFloatNode;
import zen.ast.ZenFunctionLiteralNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenGetterNode;
import zen.ast.ZenIfNode;
import zen.ast.ZenIntNode;
import zen.ast.ZenNode;
import zen.ast.ZenNullNode;
import zen.ast.ZenOrNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenSetLocalNode;
import zen.ast.ZenSetterNode;
import zen.ast.ZenStringNode;
import zen.ast.ZenTrinaryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast2.ZenAllocateNode;
import zen.ast2.ZenApplyOverridedMethodNode;
import zen.ast2.ZenArrayLiteralNode;
import zen.ast2.ZenBreakNode;
import zen.ast2.ZenCatchNode;
import zen.ast2.ZenCommandNode;
import zen.ast2.ZenConstructorNode;
import zen.ast2.ZenContinueNode;
import zen.ast2.ZenDoWhileNode;
import zen.ast2.ZenForEachNode;
import zen.ast2.ZenForNode;
import zen.ast2.ZenGetIndexNode;
import zen.ast2.ZenInstanceOfNode;
import zen.ast2.ZenNewArrayNode;
import zen.ast2.ZenSetIndexNode;
import zen.ast2.ZenSwitchNode;
import zen.ast2.ZenThrowNode;
import zen.ast2.ZenTryNode;
import zen.ast2.ZenWhileNode;
import zen.deps.ZenArray;
import zen.deps.LibZen;
import zen.deps.LibNative;
import zen.parser.ZenFunc;
import zen.parser.ZenGenerator;
import zen.parser.ZenNameSpace;
import zen.parser.ZenSystem;
import zen.parser.ZenType;

// Zen Generator should be written in each language.


public class JavaByteCodeGenerator extends ZenGenerator {
	ZenClassLoader ClassGenerator;
	JMethodBuilder CurrentVisitor;
	ArrayList<ZenType> StackFrame;

	public JavaByteCodeGenerator(String TargetCode, String OutputFile, int GeneratorFlag) {
		super("java", OutputFile, GeneratorFlag);
		this.StackFrame = new ArrayList<ZenType>();
	}

	private void PushStack(ZenType Type) {
		if(!Type.IsVoidType()) {
			StackFrame.add(Type);
		}
		//System.out.println(StackFrame.size());
	}

	private void PopStack() {
		assert(StackFrame.size() > 0);
		ZenType LastType = StackFrame.remove(StackFrame.size() - 1);
		CurrentVisitor.PopValue(LastType.IsIntType());
		//System.out.println(StackFrame.size());
	}

	private void RemoveStack(int VariableSize) {
		assert(StackFrame.size() - VariableSize >= 0);
		for (int i = 0; i < VariableSize; i++) {
			StackFrame.remove(StackFrame.size() - 1);
		}
		//System.out.println(StackFrame.size());
	}

	@Override
	public void VisitBlock(ZenNode Node) {
		int CurrentStackIndex = this.StackFrame.size();
		@Var ZenNode CurrentNode = Node;
		while(CurrentNode != null) {
			CurrentNode.Accept(this);
			CurrentNode = CurrentNode.NextNode;
		}
		while(CurrentStackIndex != this.StackFrame.size()) {
			this.PopStack();
		}
	}

	@Override public void InitContext(ZenNameSpace Context) {
		super.InitContext(Context);
		this.ClassGenerator = new ZenClassLoader(Context);
	}

	@Override public void GenerateFunc(ZenFunc Func, ArrayList<String> NameList, ZenNode Body) {
		//this.Context.ShowReportedErrors();
		String MethodName = Func.GetNativeFuncName();
		String MethodDesc = JLib.GetMethodDescriptor(Func);
		MethodNode AsmMethodNode = new MethodNode(ACC_PUBLIC | ACC_STATIC, MethodName, MethodDesc, null, null);
		JClassBuilder ClassHolder = this.ClassGenerator.GenerateMethodHolderClass(ZenSystem.GetSourceFileName(Body.Token.FileLine), MethodName, AsmMethodNode);

		JMethodBuilder LocalBuilder = new JMethodBuilder(this, this.ClassGenerator, AsmMethodNode);
		JMethodBuilder PushedBuilder = this.CurrentVisitor;

		for(int i = 0; i < NameList.size(); i++) {
			String Name = NameList.get(i);
			LocalBuilder.AddLocal(Func.GetFuncParamType(i), Name);
		}
		this.CurrentVisitor = LocalBuilder;
		this.VisitBlock(Body);
		this.CurrentVisitor = PushedBuilder;
		if(Func.GetReturnType().IsVoidType()) {
			// JVM always needs return;
			LocalBuilder.AsmVisitor.visitInsn(RETURN);
		}
		try {
			if(LibZen.DebugMode) {
				ClassHolder.OutputClassFile(ClassHolder.ClassName, ".");
			}
			Class<?> DefinedClass = this.ClassGenerator.loadClass(ClassHolder.ClassName);
			Method[] DefinedMethods = DefinedClass.getMethods();
			for(Method m : DefinedMethods) {
				if(m.getName().equals(Func.GetNativeFuncName())) {
					Func.SetNativeMethod(0, m);
					break;
				}
			}
		} catch(Exception e) {
			LibZen.VerboseException(e);
		}
	}

//	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType ClassType, ZenClassField ClassField) {
//		String ClassName = ClassType.GetNativeName();
//		String superClassName = ClassType.SuperType.GetNativeName();
//		//System.err.println("class name = " + ClassName + " extends " + superClassName);
//		JClassBuilder ClassBuilder = this.ClassGenerator.NewBuilder(ZenSystem.GetSourceFileName(ParsedTree.KeyToken.FileLine), ClassName, superClassName);
//		// generate field
//		for(ZenFieldInfo field : ClassField.FieldList) {
//			if(field.FieldIndex >= ClassField.ThisClassIndex) {
//				String fieldName = field.NativeName;
//				Type fieldType = JLib.GetAsmType(field.Type);
//				FieldNode node = new FieldNode(ACC_PUBLIC, fieldName, fieldType.getDescriptor(), null, null);
//				ClassBuilder.AddField(node);
//			}
//		}
//		// generate default constructor (for jvm)
//		MethodNode constructor = new MethodNode(ACC_PUBLIC, "<init>", "(Lorg/ZenScript/ZenType;)V", null, null);
//		constructor.visitVarInsn(ALOAD, 0);
//		constructor.visitVarInsn(ALOAD, 1);
//		constructor.visitMethodInsn(INVOKESPECIAL, superClassName, "<init>", "(Lorg/ZenScript/ZenType;)V");
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
//		try {
//			ClassType.TypeBody = this.ClassGenerator.loadClass(ClassName);
//			LibNative.Assert(ClassType.TypeBody != null);
//		}
//		catch (Exception e) {
//			LibZen.VerboseException(e);
//		}
//	}

	//-----------------------------------------------------

	//FIXME Need to Implement
//	@Override public void VisitRegexNode(ZenRegexNode Node) {
//		this.CurrentVisitor.Append("");
//	}

	@Override public void VisitAllocateNode(ZenAllocateNode Node) {
		Type type = JLib.GetAsmType(Node.Type);
		String owner = type.getInternalName();
		this.CurrentVisitor.AsmVisitor.visitTypeInsn(NEW, owner);
		this.CurrentVisitor.AsmVisitor.visitInsn(DUP);
		if(!Node.Type.IsNativeType()) {
			this.CurrentVisitor.LoadConst(Node.Type);
			this.CurrentVisitor.AsmVisitor.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "(Lorg/ZenScript/ZenType;)V");
		} else {
			this.CurrentVisitor.AsmVisitor.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "()V");
		}
		this.PushStack(Node.Type);
	}

	@Override public void VisitConstructorNode(ZenConstructorNode Node) {
		if(Node.Type.TypeBody instanceof Class<?>) {
			// native class
			Class<?> klass = (Class<?>) Node.Type.TypeBody;
//			Type type = Type.getType(klass);
			this.CurrentVisitor.AsmVisitor.visitTypeInsn(NEW, Type.getInternalName(klass));
			this.CurrentVisitor.AsmVisitor.visitInsn(DUP);
			for(int i = 0; i<Node.ParamList.size(); i++) {
				ZenNode ParamNode = Node.ParamList.get(i);
				this.CurrentVisitor.PushEvaluatedNode(Node.Func.GetFuncParamType(i), ParamNode);
//				ParamNode.Accept(this);
//				this.CurrentVisitor.CheckCast(Node.Func.GetFuncParamType(i), ParamNode.Type);
			}
			this.RemoveStack(Node.ParamList.size());
			this.CurrentVisitor.Call((Constructor<?>) Node.Func.FuncBody);
		} else {
			LibZen.TODO("TypeBody is not Class<?>");
		}
		this.PushStack(Node.Type);
	}


//	@Override public void VisitMethodCallNode(ZenMethodCall Node) {
//		ZenFunc Func = Node.ResolvedFunc;
//		this.CurrentVisitor.SetLineNumber(Node);
//		for(int i = 0; i < Node.ParamList.size(); i++) {
//			ZenNode ParamNode = Node.ParamList.get(i);
//			this.CurrentVisitor.PushEvaluatedNode(Func.GetFuncParamType(i), ParamNode);
////			ParamNode.Accept(this);
////			this.CurrentVisitor.CheckCast(Func.GetFuncParamType(i), ParamNode.Type);
//		}
//		if(Func.FuncBody instanceof Method) {
//			this.CurrentVisitor.InvokeMethodCall(Node.Type, (Method) Func.FuncBody);
//		}
//		else {
//			String MethodName = Func.GetNativeFuncName(); 
//			String Owner = JLib.GetHolderClassName(this.Context, MethodName);
//			String MethodDescriptor = JLib.GetMethodDescriptor(Func);
//			this.CurrentVisitor.AsmVisitor.visitMethodInsn(INVOKESTATIC, Owner, MethodName, MethodDescriptor);
//		}
//		this.RemoveStack(Node.ParamList.size());
//		this.PushStack(Node.Type);
//	}

	@Override public void VisitFuncCallNode(ZenApplyNode Node) {
		Node.FuncNode.Accept(this);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.ParamList);
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.InvokeFunc);
		this.RemoveStack(Node.ParamList.size());
		PushStack(Node.Type);
	}

	@Override public void VisitApplyOverridedMethodNode(ZenApplyOverridedMethodNode Node) {
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Node.SourceToken.FileLine);
		this.CurrentVisitor.LoadConst(Node.NameSpace);
		this.CurrentVisitor.LoadConst(Node.Func);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.ParamList);
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.InvokeOverridedFunc);		
		this.RemoveStack(Node.ParamList.size());
		PushStack(Node.Type);
	}
	
//	@Override public void VisitApplyDynamicFuncNode(ZenApplyDynamicFuncNode Node) {
//		this.CurrentVisitor.AsmVisitor.visitLdcInsn((long)Node.SourceToken.FileLine);
//		this.CurrentVisitor.LoadConst(Node.Type);
//		this.CurrentVisitor.LoadConst(Node.NameSpace);
//		this.CurrentVisitor.LoadConst(Node.FuncName);		
//		this.CurrentVisitor.LoadNewArray(this, 0, Node.ParamList);
//		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.InvokeDynamicFunc);				
//		this.CurrentVisitor.CheckReturn(Node.Type, ZenSystem.AnyType);
//	}
//
//	@Override public void VisitApplyDynamicMethodNode(ZenApplyDynamicMethodNode Node) {
//		this.CurrentVisitor.AsmVisitor.visitLdcInsn((long)Node.SourceToken.FileLine);
//		this.CurrentVisitor.LoadConst(Node.Type);
//		this.CurrentVisitor.LoadConst(Node.NameSpace);
//		this.CurrentVisitor.LoadConst(Node.FuncName);		
//		this.CurrentVisitor.LoadNewArray(this, 0, Node.ParamList);
//		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.InvokeDynamicMethod);				
//		this.CurrentVisitor.CheckReturn(Node.Type, ZenSystem.AnyType);
//	}
	
//	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
//		LibNative.Assert(Node.ResolvedFunc.FuncBody instanceof Method);
//		this.CurrentVisitor.PushEvaluatedNode(Node.ResolvedFunc.GetFuncParamType(0), Node.RecvNode);
//		this.CurrentVisitor.InvokeMethodCall(Node.Type, (Method)Node.ResolvedFunc.FuncBody);
//		this.RemoveStack(1);
//		PushStack(Node.Type);
//	}
//
//	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
//		LibNative.Assert(Node.ResolvedFunc.FuncBody instanceof Method);
//		this.CurrentVisitor.PushEvaluatedNode(Node.ResolvedFunc.GetFuncParamType(0), Node.LeftNode);
//		this.CurrentVisitor.PushEvaluatedNode(Node.ResolvedFunc.GetFuncParamType(1), Node.RightNode);
//		this.CurrentVisitor.InvokeMethodCall(Node.Type, (Method)Node.ResolvedFunc.FuncBody);
//		this.RemoveStack(2);
//		PushStack(Node.Type);
//	}


//	@Override public void VisitSelfAssignNode(ZenSelfAssignNode Node) {
//		if(Node.LeftNode instanceof ZenGetLocalNode) {
//			ZenGetLocalNode Left = (ZenGetLocalNode)Node.LeftNode;
//			JLocalVarStack local = this.CurrentVisitor.FindLocalVariable(Left.NativeName);
//			Node.LeftNode.Accept(this);
//			Node.RightNode.Accept(this);
//			this.CurrentVisitor.InvokeMethodCall((Method)Node.Func.FuncBody);
//			this.CurrentVisitor.StoreLocal(local);
//		}
//		else {
//			LibZen.TODO("selfAssign");
//		}
//	}


	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
		Label ElseLabel = new Label();
		Label EndLabel = new Label();
		this.CurrentVisitor.PushEvaluatedNode(ZenSystem.BooleanType, Node.CondNode);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(IFEQ, ElseLabel);
		// Then
		this.VisitBlock(Node.ThenNode);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, EndLabel);
		// Else
		this.CurrentVisitor.AsmVisitor.visitLabel(ElseLabel);
		this.VisitBlock(Node.ElseNode);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, EndLabel);
		// End
		this.CurrentVisitor.AsmVisitor.visitLabel(EndLabel);
		this.PushStack(Node.Type);
	}

	@Override public void VisitSwitchNode(ZenSwitchNode Node) {
		int cases = Node.CaseList.size() / 2;
		int[] keys = new int[cases];
		Label[] caseLabels = new Label[cases];
		Label defaultLabel = new Label();
		Label breakLabel = new Label();
		for(int i=0; i<cases; i++) {
			keys[i] = ((Number)((ZenConstPoolNode)Node.CaseList.get(i*2)).ConstValue).intValue();
			caseLabels[i] = new Label();
		}
		Node.MatchNode.Accept(this);
		this.CurrentVisitor.AsmVisitor.visitInsn(L2I);
		this.CurrentVisitor.AsmVisitor.visitLookupSwitchInsn(defaultLabel, keys, caseLabels);
		for(int i=0; i<cases; i++) {
			this.CurrentVisitor.BreakLabelStack.push(breakLabel);
			this.CurrentVisitor.AsmVisitor.visitLabel(caseLabels[i]);
			this.VisitBlock(Node.CaseList.get(i*2+1));
			this.CurrentVisitor.BreakLabelStack.pop();
		}
		this.CurrentVisitor.AsmVisitor.visitLabel(defaultLabel);
		this.VisitBlock(Node.DefaultBlock);
		this.CurrentVisitor.AsmVisitor.visitLabel(breakLabel);
	}


	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
		Label headLabel = new Label();
		Label continueLabel = new Label();
		Label breakLabel = new Label();
		this.CurrentVisitor.BreakLabelStack.push(breakLabel);
		this.CurrentVisitor.ContinueLabelStack.push(continueLabel);

		this.CurrentVisitor.AsmVisitor.visitLabel(headLabel);
		this.VisitBlock(Node.BodyNode);
		this.CurrentVisitor.AsmVisitor.visitLabel(continueLabel);
		Node.CondNode.Accept(this);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(IFEQ, breakLabel); // condition
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, headLabel);
		this.CurrentVisitor.AsmVisitor.visitLabel(breakLabel);

		this.CurrentVisitor.BreakLabelStack.pop();
		this.CurrentVisitor.ContinueLabelStack.pop();
	}

	@Override public void VisitForNode(ZenForNode Node) {
		Label headLabel = new Label();
		Label continueLabel = new Label();
		Label breakLabel = new Label();
		this.CurrentVisitor.BreakLabelStack.push(breakLabel);
		this.CurrentVisitor.ContinueLabelStack.push(continueLabel);

		this.CurrentVisitor.AsmVisitor.visitLabel(headLabel);
		Node.CondNode.Accept(this);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(IFEQ, breakLabel); // condition
		this.VisitBlock(Node.BodyNode);
		this.CurrentVisitor.AsmVisitor.visitLabel(continueLabel);
		Node.IterNode.Accept(this);
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, headLabel);
		this.CurrentVisitor.AsmVisitor.visitLabel(breakLabel);

		this.CurrentVisitor.BreakLabelStack.pop();
		this.CurrentVisitor.ContinueLabelStack.pop();
	}

	@Override public void VisitForEachNode(ZenForEachNode Node) {
		LibZen.TODO("ForEach");
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		if(Node.ValueNode != null) {
			Node.ValueNode.Accept(this);
			Type type = JLib.GetAsmType(Node.ValueNode.Type);
			this.CurrentVisitor.AsmVisitor.visitInsn(type.getOpcode(IRETURN));
		}
		else {
			this.CurrentVisitor.AsmVisitor.visitInsn(RETURN);
		}
	}

	@Override public void VisitTryNode(ZenTryNode Node) {
		int catchSize = LibZen.ListSize(Node.CatchList);
		MethodVisitor mv = this.CurrentVisitor.AsmVisitor;
		Label beginTryLabel = new Label();
		Label endTryLabel = new Label();
		Label finallyLabel = new Label();
		Label catchLabel[] = new Label[catchSize];

		// try block
		mv.visitLabel(beginTryLabel);
		this.VisitBlock(Node.TryNode);
		mv.visitLabel(endTryLabel);
		mv.visitJumpInsn(GOTO, finallyLabel);

		// prepare
		for(int i = 0; i < catchSize; i++) { //TODO: add exception class name
			catchLabel[i] = new Label();
			ZenCatchNode Catch = (/*cast*/ZenCatchNode) Node.CatchList.get(i);
			String throwType = JLib.GetAsmType(Catch.ExceptionType).getInternalName();
			mv.visitTryCatchBlock(beginTryLabel, endTryLabel, catchLabel[i], throwType);
		}

		// catch block
		for(int i = 0; i < catchSize; i++) { //TODO: add exception class name
			ZenCatchNode Catch = (/*cast*/ZenCatchNode) Node.CatchList.get(i);
			JLocalVarStack local = this.CurrentVisitor.AddLocal(Catch.ExceptionType, Catch.ExceptionName);
			mv.visitLabel(catchLabel[i]);
			this.CurrentVisitor.StoreLocal(local);
			this.VisitBlock(Catch.BodyNode);
			mv.visitJumpInsn(GOTO, finallyLabel);
			//FIXME: remove local
		}

		// finally block
		mv.visitLabel(finallyLabel);
		this.VisitBlock(Node.FinallyNode);
	}

	@Override public void VisitThrowNode(ZenThrowNode Node) {
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

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		if(Node.TypeInfo.IsGenericType() || Node.TypeInfo.IsVirtualType()) {
			Node.ExprNode.Accept(this);
			this.CurrentVisitor.LoadConst(Node.TypeInfo);
			this.CurrentVisitor.InvokeMethodCall(boolean.class, JLib.GreenInstanceOfOperator);
		}
		else {
			Node.ExprNode.Accept(this);
			this.CurrentVisitor.CheckCast(Object.class, Node.ExprNode.Type);
			Class<?> NativeType = Node.TypeInfo.GetNativeType(true);
			this.CurrentVisitor.AsmVisitor.visitTypeInsn(INSTANCEOF, Type.getInternalName(NativeType));
		}
		this.PushStack(Node.Type);
	}

//	@Override public void VisitCastNode(ZenCastNode Node) {
//		this.CurrentVisitor.LoadConst(Node.CastType);
//		Node.Expr.Accept(this);
//		this.CurrentVisitor.CheckCast(Object.class, Node.Expr.Type);
//		this.CurrentVisitor.InvokeMethodCall(Node.CastType, JLib.GreenCastOperator);
//		this.PushStack(Node.CastType);
//	}

	@Override public void VisitFunctionLiteralNode(ZenFunctionLiteralNode Node) {
		LibZen.TODO("FunctionNode");
	}

	@Override public void VisitCommandNode(ZenCommandNode Node) {
		ArrayList<ArrayList<ZenNode>> Args = new ArrayList<ArrayList<ZenNode>>();
		ZenCommandNode node = Node;
		while(node != null) {
			Args.add(node.ArgumentList);
			node = (ZenCommandNode) node.PipedNextNode;
		}
		// new String[][n]
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Args.size());
		this.CurrentVisitor.AsmVisitor.visitTypeInsn(ANEWARRAY, Type.getInternalName(String[].class));
		for(int i=0; i<Args.size(); i++) {
			// new String[m];
			ArrayList<ZenNode> Arg = Args.get(i);
			this.CurrentVisitor.AsmVisitor.visitInsn(DUP);
			this.CurrentVisitor.AsmVisitor.visitLdcInsn(i);
			this.CurrentVisitor.AsmVisitor.visitLdcInsn(Arg.size());
			this.CurrentVisitor.AsmVisitor.visitTypeInsn(ANEWARRAY, Type.getInternalName(String.class));
			for(int j=0; j<Arg.size(); j++) {
				this.CurrentVisitor.AsmVisitor.visitInsn(DUP);
				this.CurrentVisitor.AsmVisitor.visitLdcInsn(j);
				Arg.get(j).Accept(this);
				this.CurrentVisitor.AsmVisitor.visitInsn(AASTORE);
			}
			this.CurrentVisitor.AsmVisitor.visitInsn(AASTORE);
		}
		if(Node.Type.IsBooleanType()) {
			this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.ExecCommandBool);
		}
		else if(Node.Type.IsStringType()) {
			this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.ExecCommandString);
		}
		else if(LibZen.EqualsString(Node.Type.toString(), "Task")) {
			this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.ExecCommandTask);
		}
		else {
			this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.ExecCommandVoid);
		}
		this.PushStack(Node.Type);
	}

	@Override public void InvokeMainFunc(String MainFuncName) {
		try {
			Class<?> MainClass = Class.forName(JLib.GetHolderClassName(this.RootNameSpace, MainFuncName), false, this.ClassGenerator);
			Method m = MainClass.getMethod(MainFuncName);
			if(m != null) {
				m.invoke(null);
			}
		} catch(ClassNotFoundException e) {
			LibZen.VerboseException(e);
		} catch(InvocationTargetException e) {
			LibZen.VerboseException(e);
		} catch(IllegalAccessException e) {
			LibZen.VerboseException(e);
		} catch(NoSuchMethodException e) {
			LibZen.VerboseException(e);
		}
	}
}
