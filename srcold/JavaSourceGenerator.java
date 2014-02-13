// ***************************************************************************
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
package org.ZenScript;
import java.util.ArrayList;


import parser.ZenClassField;
import parser.ZenFunc;
import parser.ZenSourceBuilder;
import parser.ZenSourceGenerator;
import parser.ZenSyntaxTree;
import parser.ZenType;
import parser.ast.ZenAllocateNode;
import parser.ast.ZenAndNode;
import parser.ast.ZenApplySymbolNode;
import parser.ast.ZenArrayLiteralNode;
import parser.ast.ZenBinaryNode;
import parser.ast.ZenBreakNode;
import parser.ast.ZenCastNode;
import parser.ast.ZenCommandNode;
import parser.ast.ZenConstPoolNode;
import parser.ast.ZenConstructorNode;
import parser.ast.ZenContinueNode;
import parser.ast.ZenDoWhileNode;
import parser.ast.ZenErrorNode;
import parser.ast.ZenForEachNode;
import parser.ast.ZenForNode;
import parser.ast.ZenFunctionNode;
import parser.ast.ZenGetLocalNode;
import parser.ast.ZenGetterNode;
import parser.ast.ZenIfNode;
import parser.ast.ZenInstanceOfNode;
import parser.ast.ZenNewArrayNode;
import parser.ast.ZenNode;
import parser.ast.ZenNullNode;
import parser.ast.ZenOrNode;
import parser.ast.ZenReturnNode;
import parser.ast.ZenSetLocalNode;
import parser.ast.ZenSetterNode;
import parser.ast.ZenSwitchNode;
import parser.ast.ZenThrowNode;
import parser.ast.ZenTrinaryNode;
import parser.ast.ZenTryNode;
import parser.ast.ZenUnaryNode;
import parser.ast.ZenVarNode;
import parser.ast.ZenWhileNode;
import parser.deps.LibZen;
import parser.deps.LibNative;

public class JavaSourceGenerator extends ZenSourceGenerator {

	public JavaSourceGenerator(String TargetCode, String OutputFile, int GeneratorFlag) {
		super("java", OutputFile, GeneratorFlag);
	}

	String HolderClassName(String NativeName) {
		return "Func" + NativeName;
	}
	
	@Override public void GenerateFunc(ZenFunc Func, ArrayList<String> NameList, ZenNode Body) {
		String MethodName = Func.GetNativeFuncName();
		ZenSourceBuilder Builder = new ZenSourceBuilder(this);
		Builder.Append("class");
		Builder.AppendToken(HolderClassName(MethodName));
		Builder.AppendLine("{");
		Builder.Indent();
		Builder.IndentAndAppend("final static ");
		Builder.AppendToken(MethodName);
		Builder.Append("(");

		Builder.Append(")");
		ZenSourceBuilder PushedBuilder = this.CurrentBuilder;
		this.CurrentBuilder = Builder;
		this.VisitIndentBlock("{", Body, "}");
		this.CurrentBuilder = PushedBuilder;
		Builder.AppendLine("");
		Builder.UnIndent();
		Builder.AppendLine("}");
	}

	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType ClassType, ZenClassField ClassField) {
//		String ClassName = ClassType.GetNativeName();
//		String superClassName = ClassType.SuperType.GetNativeName();
//		JClassBuilder ClassBuilder = this.ClassGenerator.NewBuilder(ClassName, superClassName);
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
//		}
//		catch (Exception e) {
//			LibZen.VerboseException(e);
//		}
	}

	//-----------------------------------------------------

	@Override public void VisitConstPoolNode(ZenConstPoolNode Node) {
//		Object constValue = Node.ConstValue;
//		LibZen.Assert(Node.ConstValue != null);  // Added by kimio
//		this.VisitingBuilder.LoadConst(constValue);
	}

	@Override public void VisitAllocateNode(ZenAllocateNode Node) {
//		Type type = JLib.GetAsmType(Node.Type);
//		String owner = type.getInternalName();
//		this.VisitingBuilder.MethodVisitor.visitTypeInsn(NEW, owner);
//		this.VisitingBuilder.MethodVisitor.visitInsn(DUP);
//		if(!Node.Type.IsNative()) {
//			this.VisitingBuilder.LoadConst(Node.Type);
//			this.VisitingBuilder.MethodVisitor.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "(Lorg/ZenScript/ZenType;)V");
//		} else {
//			this.VisitingBuilder.MethodVisitor.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "()V");
//		}
	}

	@Override public void VisitNullNode(ZenNullNode Node) {
		this.CurrentBuilder.Append(this.NullLiteral);
	}

	@Override public void VisitGetNameNode(ZenGetLocalNode Node) {
		this.CurrentBuilder.Append(Node.NativeName);
	}

	@Override public void VisitConstructorNode(ZenConstructorNode Node) {
//		if(Node.Type.TypeBody instanceof Class<?>) {
//			// native class
//			Class<?> klass = (Class<?>) Node.Type.TypeBody;
//			Type type = Type.getType(klass);
//			this.VisitingBuilder.MethodVisitor.visitTypeInsn(NEW, Type.getInternalName(klass));
//			this.VisitingBuilder.MethodVisitor.visitInsn(DUP);
//			for(int i = 0; i<Node.GetParamSize(); i++) {
//				ZenNode ParamNode = Node.GetParam(i);
//				ParamNode.Accept(this);
//				this.VisitingBuilder.BoxIfUnboxed(ParamNode.Type, Node.Func.GetFuncParamType(i));
//			}
//			this.VisitingBuilder.Call((Constructor<?>) Node.Func.FuncBody);
//		} else {
//			LibZen.TODO("TypeBody is not Class<?>");
//		}
	}

	@Override public void VisitGetterNode(ZenGetterNode Node) {
		Node.AST[ZGetterNode.Recv].Accept(this);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.ResolvedFunc.FuncName);
	}
	
	@Override public void VisitSetterNode(ZenSetterNode Node) {
		Node.AST[ZGetterNode.Recv].Accept(this);
		this.CurrentBuilder.Append(".");
		this.CurrentBuilder.Append(Node.ResolvedFunc.FuncName);
		this.CurrentBuilder.Append("=");
		Node.ValueNode.Accept(this);
	}

//	@Override public void VisitFuncCallNode(ZenApplyNode Node) {
//		ZenFunc Func = Node.Func;
//		for(int i = 1; i < Node.NodeList.size(); i++) {
//			ZenNode ParamNode = Node.NodeList.get(i);
//			ParamNode.Accept(this);
//			this.VisitingBuilder.BoxIfUnboxed(ParamNode.Type, Func.GetFuncParamType(i - 1));
//		}
//		Method m = null;
//		if(Func.FuncBody instanceof Method) {
//			m = (Method) Func.FuncBody;
//		}
//		if(m != null) {
//			this.VisitingBuilder.InvokeMethodCall(Node.Type, m);
//		}
//		else {
//			String MethodName = Func.GetNativeFuncName(); 
//			String Owner = JLib.GetHolderClassName(Node.Type.Context, MethodName);
//			String MethodDescriptor = JLib.GetMethodDescriptor(Func);
//			this.VisitingBuilder.MethodVisitor.visitMethodInsn(INVOKESTATIC, Owner, MethodName, MethodDescriptor);
//			this.VisitingBuilder.UnboxIfUnboxed(Func.GetReturnType(), Node.Type);
//		}
//	}

	@Override public void VisitApplySymbolNode(ZenApplySymbolNode ApplyNode) {
//		ZenFunc Func = ApplyNode.Func;
//		for(int i = 0; i < ApplyNode.GetParamSize(); i++) {
//			ZenNode ParamNode = ApplyNode.GetParam(i);
//			ParamNode.Accept(this);
//			this.VisitingBuilder.BoxIfUnboxed(ParamNode.Type, Func.GetFuncParamType(i));
//		}
//		if(Func.FuncBody instanceof Method) {
//			this.VisitingBuilder.InvokeMethodCall(ApplyNode.Type, (Method) Func.FuncBody);
//		}
//		else {
//			String MethodName = Func.GetNativeFuncName(); 
//			String Owner = JLib.GetHolderClassName(ApplyNode.Type.Context, MethodName);
//			String MethodDescriptor = JLib.GetMethodDescriptor(Func);
//			this.VisitingBuilder.MethodVisitor.visitMethodInsn(INVOKESTATIC, Owner, MethodName, MethodDescriptor);
//			this.VisitingBuilder.UnboxIfUnboxed(Func.GetReturnType(), ApplyNode.Type);
//		}
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		//if(Node.Func.FuncBody instanceof Method) {
		this.CurrentBuilder.Append("(");
		Node.AST[ZBinaryNode.Left].Accept(this);
		this.CurrentBuilder.AppendToken(Node.SourceToken.GetText());
		Node.AST[ZBinaryNode.Right].Accept(this);
		this.CurrentBuilder.Append(")");
		//}
	}

	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
//		if(Node.Func.FuncBody instanceof Method) {
		this.CurrentBuilder.Append("(");
		this.CurrentBuilder.Append(Node.SourceToken.GetText());
		Node.AST[ZGetterNode.Recv].Accept(this);
		this.CurrentBuilder.Append(")");
//		}
	}

//	@Override public void VisitIndexerNode(ZenIndexerNode Node) {
//		ArrayList<ZenNode> NodeList = Node.NodeList;
//		Node.Expr.Accept(this);
//		for(int i=0; i<NodeList.size(); i++) {
//			NodeList.get(i).Accept(this);
//		}
//		this.VisitingBuilder.InvokeMethodCall(Node.Type, (Method) Node.Func.FuncBody);
//	}

	@Override public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
//		ArrayList<ZenNode> NodeList = Node.NodeList;
//		this.VisitingBuilder.LoadConst(Node.Type);
//		this.VisitingBuilder.MethodVisitor.visitLdcInsn(NodeList.size());
//		this.VisitingBuilder.MethodVisitor.visitTypeInsn(ANEWARRAY, Type.getInternalName(Object.class));
//		for(int i=0; i<NodeList.size(); i++) {
//			this.VisitingBuilder.MethodVisitor.visitInsn(DUP);
//			this.VisitingBuilder.MethodVisitor.visitLdcInsn(i);
//			NodeList.get(i).Accept(this);
//			this.VisitingBuilder.BoxIfUnboxed(NodeList.get(i).Type, Node.Type.TypeParams[0]);
//			this.VisitingBuilder.MethodVisitor.visitInsn(AASTORE);
//		}
//		this.VisitingBuilder.InvokeMethodCall(Node.Type, JLib.NewNewArray);
	}

	public void VisitNewArrayNode(ZenNewArrayNode Node) {
//		this.VisitingBuilder.LoadConst(Node.Type);
//		this.VisitingBuilder.MethodVisitor.visitLdcInsn(Node.NodeList.size());
//		this.VisitingBuilder.MethodVisitor.visitTypeInsn(ANEWARRAY, Type.getInternalName(Object.class));
//		for(int i=0; i<Node.NodeList.size(); i++) {
//			this.VisitingBuilder.MethodVisitor.visitInsn(DUP);
//			this.VisitingBuilder.MethodVisitor.visitLdcInsn(i);
//			Node.NodeList.get(i).Accept(this);
//			this.VisitingBuilder.BoxIfUnboxed(Node.NodeList.get(i).Type, this.Context.AnyType);
//			this.VisitingBuilder.MethodVisitor.visitInsn(AASTORE);
//		}
//		this.VisitingBuilder.InvokeMethodCall(Node.Type, JLib.NewArray);
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		this.CurrentBuilder.Append("(");
		Node.AST[ZBinaryNode.Left].Accept(this);
		this.CurrentBuilder.Append(" && ");
		Node.AST[ZBinaryNode.Right].Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitOrNode(ZenOrNode Node) {
		this.CurrentBuilder.Append("(");
		Node.AST[ZBinaryNode.Left].Accept(this);
		this.CurrentBuilder.Append(" || ");
		Node.AST[ZBinaryNode.Right].Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitSetNameNode(ZenSetLocalNode Node) {
//		assert (Node.AST[ZBinaryNode.Left] instanceof ZenLocalNode);
//		ZenLocalNode Left = (ZenLocalNode) Node.AST[ZBinaryNode.Left];
//		JLocalVarStack local = this.VisitingBuilder.FindLocalVariable(Left.NativeName);
//		Node.AST[ZBinaryNode.Right].Accept(this);
//		this.VisitingBuilder.StoreLocal(local);
	}

//	@Override public void VisitSelfAssignNode(ZenSelfAssignNode Node) {
//		if(Node.AST[ZBinaryNode.Left] instanceof ZenLocalNode) {
//			ZenLocalNode Left = (ZenLocalNode)Node.AST[ZBinaryNode.Left];
//			JLocalVarStack local = this.VisitingBuilder.FindLocalVariable(Left.NativeName);
//			Node.AST[ZBinaryNode.Left].Accept(this);
//			Node.AST[ZBinaryNode.Right].Accept(this);
//			this.VisitingBuilder.InvokeMethodCall((Method)Node.Func.FuncBody);
//			this.VisitingBuilder.StoreLocal(local);
//		}
//		else {
//			LibZen.TODO("selfAssign");
//		}
//	}

	@Override public void VisitVarNode(ZenVarNode Node) {
//		JLocalVarStack local = this.VisitingBuilder.AddLocal(Node.Type, Node.NativeName);
//		Node.InitNode.Accept(this);
//		this.VisitingBuilder.StoreLocal(local);
//		this.VisitBlock(Node.BlockNode);
	}

	@Override public void VisitIfNode(ZenIfNode Node) {
		this.CurrentBuilder.Append("if");
		this.CurrentBuilder.Append("(");
		Node.AST[ZIfNode.Cond].Accept(this);
		this.CurrentBuilder.Append(") ");
		this.VisitIndentBlock("{", Node.AST[ZIfNode.Then], "}");
		if(Node.AST[ZIfNode.Else] != null) {
			this.CurrentBuilder.Append(" else ");			
			this.VisitIndentBlock("{", Node.AST[ZIfNode.Else], "}");
		}
	}

	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
		this.CurrentBuilder.Append("(");
		Node.AST[ZIfNode.Cond].Accept(this);
		this.CurrentBuilder.Append(" ? ");
		Node.AST[ZIfNode.Then].Accept(this);
		this.CurrentBuilder.Append(" : ");
		Node.AST[ZIfNode.Else].Accept(this);
		this.CurrentBuilder.Append(")");
	}

	@Override public void VisitSwitchNode(ZenSwitchNode Node) {
//		int cases = Node.CaseList.size() / 2;
//		int[] keys = new int[cases];
//		Label[] caseLabels = new Label[cases];
//		Label defaultLabel = new Label();
//		Label breakLabel = new Label();
//		for(int i=0; i<cases; i++) {
//			keys[i] = ((Number)((ZenConstNode)Node.CaseList.get(i*2)).ConstValue).intValue();
//			caseLabels[i] = new Label();
//		}
//		Node.MatchNode.Accept(this);
//		this.VisitingBuilder.MethodVisitor.visitInsn(L2I);
//		this.VisitingBuilder.MethodVisitor.visitLookupSwitchInsn(defaultLabel, keys, caseLabels);
//		for(int i=0; i<cases; i++) {
//			this.VisitingBuilder.BreakLabelStack.push(breakLabel);
//			this.VisitingBuilder.MethodVisitor.visitLabel(caseLabels[i]);
//			this.VisitBlock(Node.CaseList.get(i*2+1));
//			this.VisitingBuilder.BreakLabelStack.pop();
//		}
//		this.VisitingBuilder.MethodVisitor.visitLabel(defaultLabel);
//		this.VisitBlock(Node.DefaultBlock);
//		this.VisitingBuilder.MethodVisitor.visitLabel(breakLabel);
	}

	@Override public void VisitWhileNode(ZenWhileNode Node) {
//		Label continueLabel = new Label();
//		Label breakLabel = new Label();
//		this.VisitingBuilder.BreakLabelStack.push(breakLabel);
//		this.VisitingBuilder.ContinueLabelStack.push(continueLabel);
//
//		this.VisitingBuilder.MethodVisitor.visitLabel(continueLabel);
//		Node.CondExpr.Accept(this);
//		this.VisitingBuilder.MethodVisitor.visitJumpInsn(IFEQ, breakLabel); // condition
//		this.VisitBlock(Node.LoopBody);
//		this.VisitingBuilder.MethodVisitor.visitJumpInsn(GOTO, continueLabel);
//		this.VisitingBuilder.MethodVisitor.visitLabel(breakLabel);
//
//		this.VisitingBuilder.BreakLabelStack.pop();
//		this.VisitingBuilder.ContinueLabelStack.pop();
	}

	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
//		Label headLabel = new Label();
//		Label continueLabel = new Label();
//		Label breakLabel = new Label();
//		this.VisitingBuilder.BreakLabelStack.push(breakLabel);
//		this.VisitingBuilder.ContinueLabelStack.push(continueLabel);
//
//		this.VisitingBuilder.MethodVisitor.visitLabel(headLabel);
//		this.VisitBlock(Node.LoopBody);
//		this.VisitingBuilder.MethodVisitor.visitLabel(continueLabel);
//		Node.CondExpr.Accept(this);
//		this.VisitingBuilder.MethodVisitor.visitJumpInsn(IFEQ, breakLabel); // condition
//		this.VisitingBuilder.MethodVisitor.visitJumpInsn(GOTO, headLabel);
//		this.VisitingBuilder.MethodVisitor.visitLabel(breakLabel);
//
//		this.VisitingBuilder.BreakLabelStack.pop();
//		this.VisitingBuilder.ContinueLabelStack.pop();
	}

	@Override public void VisitForNode(ZenForNode Node) {
//		Label headLabel = new Label();
//		Label continueLabel = new Label();
//		Label breakLabel = new Label();
//		this.VisitingBuilder.BreakLabelStack.push(breakLabel);
//		this.VisitingBuilder.ContinueLabelStack.push(continueLabel);
//
//		this.VisitingBuilder.MethodVisitor.visitLabel(headLabel);
//		Node.CondExpr.Accept(this);
//		this.VisitingBuilder.MethodVisitor.visitJumpInsn(IFEQ, breakLabel); // condition
//		this.VisitBlock(Node.LoopBody);
//		this.VisitingBuilder.MethodVisitor.visitLabel(continueLabel);
//		Node.IterExpr.Accept(this);
//		this.VisitingBuilder.MethodVisitor.visitJumpInsn(GOTO, headLabel);
//		this.VisitingBuilder.MethodVisitor.visitLabel(breakLabel);
//
//		this.VisitingBuilder.BreakLabelStack.pop();
//		this.VisitingBuilder.ContinueLabelStack.pop();
	}

	@Override public void VisitForEachNode(ZenForEachNode Node) {
		LibZen.TODO("ForEach");
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		this.CurrentBuilder.Append("return");
		if(Node.ValueNode != null) {
			this.CurrentBuilder.Append(" ");
			Node.ValueNode.Accept(this);
		}
	}

	@Override public void VisitBreakNode(ZenBreakNode Node) {
		this.CurrentBuilder.Append("break");
	}

	@Override public void VisitContinueNode(ZenContinueNode Node) {
		this.CurrentBuilder.Append("continue");
	}

	@Override public void VisitTryNode(ZenTryNode Node) { //FIXME
//		int catchSize = Node.CatchBlock != null ? 1 : 0;
//		MethodVisitor mv = this.VisitingBuilder.MethodVisitor;
//		Label beginTryLabel = new Label();
//		Label endTryLabel = new Label();
//		Label finallyLabel = new Label();
//		Label catchLabel[] = new Label[catchSize];
//
//		// try block
//		mv.visitLabel(beginTryLabel);
//		this.VisitBlock(Node.TryBlock);
//		mv.visitLabel(endTryLabel);
//		mv.visitJumpInsn(GOTO, finallyLabel);
//
//		// prepare
//		for(int i = 0; i < catchSize; i++) { //TODO: add exception class name
//			catchLabel[i] = new Label();
//			String throwType = JLib.GetAsmType(Node.CatchExpr.Type).getInternalName();
//			mv.visitTryCatchBlock(beginTryLabel, endTryLabel, catchLabel[i], throwType);
//		}
//
//		// catch block
//		for(int i = 0; i < catchSize; i++) { //TODO: add exception class name
//			ZenNode block = Node.CatchBlock;
//			mv.visitLabel(catchLabel[i]);
//			this.VisitBlock(block);
//			mv.visitJumpInsn(GOTO, finallyLabel);
//		}
//
//		// finally block
//		mv.visitLabel(finallyLabel);
//		this.VisitBlock(Node.FinallyBlock);
	}

	@Override public void VisitThrowNode(ZenThrowNode Node) {
//		// use wrapper
//		String name = Type.getInternalName(ZenThrowableWrapper.class);
//		this.VisitingBuilder.MethodVisitor.visitTypeInsn(NEW, name);
//		this.VisitingBuilder.MethodVisitor.visitInsn(DUP);
//		Node.Expr.Accept(this);
//		//this.box();
////		this.VisitingBuilder.typeStack.pop();
//		this.VisitingBuilder.MethodVisitor.visitMethodInsn(INVOKESPECIAL, name, "<init>", "(Ljava/lang/Object;)V");
//		this.VisitingBuilder.MethodVisitor.visitInsn(ATHROW);
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
//		Node.ExprNode.Accept(this);
//		this.VisitingBuilder.BoxIfUnboxed(Node.ExprNode.Type, this.Context.AnyType);
//		this.VisitingBuilder.LoadConst(Node.TypeInfo);
//		this.VisitingBuilder.InvokeMethodCall(JLib.GreenInstanceOfOperator);
	}

	@Override public void VisitCastNode(ZenCastNode Node) {
//		this.VisitingBuilder.LoadConst(Node.CastType);
//		Node.Expr.Accept(this);
//		this.VisitingBuilder.BoxIfUnboxed(Node.Expr.Type, this.Context.AnyType);
//		this.VisitingBuilder.InvokeMethodCall(Node.CastType, JLib.GreenCastOperator);
	}

	@Override public void VisitFunctionNode(ZenFunctionNode Node) {
		LibZen.TODO("FunctionNode");
	}

	@Override public void VisitErrorNode(ZenErrorNode Node) {
//		this.Builder.AsmMethodVisitor.visitLdcInsn("(ErrorNode)");
//		this.Builder.Call(this.methodMap.get("error_node"));
		LibNative.Exit(1, "ErrorNode found in JavaByteCodeGenerator");
	}

	@Override public void VisitCommandNode(ZenCommandNode Node) {
//		ArrayList<ArrayList<ZenNode>> Args = new ArrayList<ArrayList<ZenNode>>();
//		ZenCommandNode node = Node;
//		while(node != null) {
//			Args.add(node.ArgumentList);
//			node = (ZenCommandNode) node.PipedNextNode;
//		}
//		// new String[][n]
//		this.VisitingBuilder.MethodVisitor.visitLdcInsn(Args.size());
//		this.VisitingBuilder.MethodVisitor.visitTypeInsn(ANEWARRAY, Type.getInternalName(String[].class));
//		for(int i=0; i<Args.size(); i++) {
//			// new String[m];
//			ArrayList<ZenNode> Arg = Args.get(i);
//			this.VisitingBuilder.MethodVisitor.visitInsn(DUP);
//			this.VisitingBuilder.MethodVisitor.visitLdcInsn(i);
//			this.VisitingBuilder.MethodVisitor.visitLdcInsn(Arg.size());
//			this.VisitingBuilder.MethodVisitor.visitTypeInsn(ANEWARRAY, Type.getInternalName(String.class));
//			for(int j=0; j<Arg.size(); j++) {
//				this.VisitingBuilder.MethodVisitor.visitInsn(DUP);
//				this.VisitingBuilder.MethodVisitor.visitLdcInsn(j);
//				Arg.get(j).Accept(this);
//				this.VisitingBuilder.MethodVisitor.visitInsn(AASTORE);
//			}
//			this.VisitingBuilder.MethodVisitor.visitInsn(AASTORE);
//		}
//		if(Node.Type.IsBooleanType()) {
//			this.VisitingBuilder.InvokeMethodCall(Node.Type, JLib.ExecCommandBool);
//		}
//		else if(Node.Type.IsStringType()) {
//			this.VisitingBuilder.InvokeMethodCall(Node.Type, JLib.ExecCommandString);
//		}
//		else {
//			this.VisitingBuilder.InvokeMethodCall(Node.Type, JLib.ExecCommandVoid);
//		}
	}

	@Override public void InvokeMainFunc(String MainFuncName) {
//		try {
//			Class<?> MainClass = Class.forName(JLib.GetHolderClassName(this.Context, MainFuncName), false, this.ClassGenerator);
//			Method m = MainClass.getMethod(MainFuncName);
//			if(m != null) {
//				m.invoke(null);
//			}
//		} catch(ClassNotFoundException e) {
//			LibZen.VerboseException(e);
//		} catch(InvocationTargetException e) {
//			LibZen.VerboseException(e);
//		} catch(IllegalAccessException e) {
//			LibZen.VerboseException(e);
//		} catch(NoSuchMethodException e) {
//			LibZen.VerboseException(e);
//		}
	}
}
