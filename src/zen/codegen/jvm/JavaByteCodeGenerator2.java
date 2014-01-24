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
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
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
import zen.deps.NativeTypeTable;
import zen.deps.Var;
import zen.deps.ZenMap;
import zen.lang.ZFuncType;
import zen.lang.ZSystem;
import zen.lang.ZType;
import zen.lang.ZenEngine;
import zen.lang.ZenTypeInfer;
import zen.parser.ZGenerator;

public class JavaByteCodeGenerator2 extends ZGenerator {
	JMethodBuilder2 CurrentBuilder;
	JClassLoader ClassLoader = null;
	ArrayList<TryCatchLabel> TryCatchLabel;
	private final ZenMap<Method> FuncMap = new ZenMap<Method>(null);

	public JavaByteCodeGenerator2() {
		super("java", "1.6");
		this.TryCatchLabel = new ArrayList<TryCatchLabel>();
		this.ClassLoader = new JClassLoader(this);
	}

	@Override public ZenEngine GetEngine() {
		return new JavaReflectionEngine(new ZenTypeInfer(this.Logger), this);
	}

	@Override public boolean StartCodeGeneration(ZNode Node,  boolean AllowLazy, boolean IsInteractive) {
		if (AllowLazy && Node.IsVarType()) {
			return false;
		}
		Node.Accept(this);
		return true;
	}


	private String GetTypeDesc(ZType zType) {
		Class<?> JClass = NativeTypeTable.GetJavaClass(zType);
		return Type.getDescriptor(JClass);
	}

	Type GetAsmType(ZType zType) {
		//System.err.println("debug * " + NativeTypeTable.GetJavaClass(zType));
		return Type.getType(NativeTypeTable.GetJavaClass(zType));
	}

	String GetMethodDescriptor(ZFuncType FuncType) {
		@Var Type ReturnType = this.GetAsmType(FuncType.GetReturnType());
		@Var Type[] ArgTypes = new Type[FuncType.GetFuncParamSize()];
		for(int i = 0; i < ArgTypes.length; i++) {
			ZType ParamType = FuncType.GetParamType(i);
			ArgTypes[i] = this.GetAsmType(ParamType);
		}
		String Desc = Type.getMethodDescriptor(ReturnType, ArgTypes);
		//System.err.println("Desc: " + Desc + ", FuncType: " + FuncType);
		return Desc;
	}

	private Object GetConstValue(ZNode Node) {
		if(Node instanceof ZConstNode) {
			return ((ZConstNode)Node).GetValue();
		}
		return null;
	}

	@Override public ZType GetFieldType(ZType RecvType, String FieldName) {
		Class<?> NativeClass = NativeTypeTable.GetJavaClass(RecvType);
		if(NativeClass != null) {
			try {
				java.lang.reflect.Field NativeField = NativeClass.getField(FieldName);
				if(Modifier.isPublic(NativeField.getModifiers())) {
					return NativeTypeTable.GetZenType(NativeField.getType());
				}
			} catch (SecurityException e) {
			} catch (NoSuchFieldException e) {
			}
			return ZSystem.VoidType;     // undefined
		}
		return ZSystem.VarType;     // undefined
	}

	@Override public ZType GetSetterType(ZType RecvType, String FieldName) {
		Class<?> NativeClass = NativeTypeTable.GetJavaClass(RecvType);
		if(NativeClass != null) {
			try {
				java.lang.reflect.Field NativeField = NativeClass.getField(FieldName);
				if(Modifier.isPublic(NativeField.getModifiers()) && !Modifier.isFinal(NativeField.getModifiers())) {
					return NativeTypeTable.GetZenType(NativeField.getType());
				}
			} catch (SecurityException e) {
			} catch (NoSuchFieldException e) {
			}
			return ZSystem.VoidType;     // undefined
		}
		return ZSystem.VarType;     // undefined
	}

	Method GetMethod(ZType RecvType, String MethodName, ArrayList<ZNode> ParamList) {
		Class<?> NativeClass = NativeTypeTable.GetJavaClass(RecvType);
		if(NativeClass != null) {
			try {
				Method[] Methods = NativeClass.getMethods();
				for(int i = 0; i < Methods.length; i++) {
					@Var Method jMethod = Methods[i];
					if(!MethodName.equals(jMethod.getName())) {
						continue;
					}
					if(!Modifier.isPublic(jMethod.getModifiers()) && Modifier.isStatic(jMethod.getModifiers())) {
						continue;
					}
					Class<?>[] JParamClass = jMethod.getParameterTypes();
					if(JParamClass.length != ParamList.size()) {
						continue;
					}
					//this.Debug("searching.. method: " + jMethod);
					for(int j = 0; j < JParamClass.length; j++) {
						if(JParamClass[j] == Object.class) {
							continue; // accepting all types
						}
						@Var ZType JParamType = NativeTypeTable.GetZenType(JParamClass[j]);
						if(!JParamType.Accept(ParamList.get(j).Type)) {
							jMethod = null;
							break;
						}
					}
					if(jMethod != null) {
						return jMethod;
					}
				}
			} catch (SecurityException e) {
			}
		}
		return null;
	}

	@Override public ZType GetMethodFuncType(ZType RecvType, String MethodName, ArrayList<ZNode> ParamList) {
		Method jMethod = this.GetMethod(RecvType, MethodName, ParamList);
		if(jMethod != null) {
			//this.Debug("matched: " + jMethod);
			return NativeTypeTable.ConvertToFuncType(jMethod);
		}
		return ZSystem.VarType;
	}

	//	@Override public void DoCodeGeneration(ZNode Node) {
	//		if(this.CurrentBuilder == null && !(Node instanceof ZFuncDeclNode) && !(Node instanceof ZClassDeclNode)) {
	//			this.Interpreter.EnableVisitor();
	//			Object Value = this.Interpreter.Exec(Node, true);
	//			if(this.Interpreter.IsVisitable()) {
	//				LibNative.println(" (" + Node.Type + ") " + LibZen.Stringify(Value));
	//			}
	//			else if(Value != null) {
	//				LibNative.println(" Error: " + Value);
	//			}
	//		}
	//		else {
	//			Node.Accept(this);
	//		}
	//	}

	@Override public void VisitEmptyNode(ZEmptyNode Node) {
		/* do nothing */
	}

	@Override public void VisitNullNode(ZNullNode Node) {
		this.CurrentBuilder.visitInsn(ACONST_NULL);
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.CurrentBuilder.visitLdcInsn(Node.BooleanValue);
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.CurrentBuilder.visitLdcInsn(Node.IntValue);
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.CurrentBuilder.visitLdcInsn(Node.FloatValue);
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.CurrentBuilder.visitLdcInsn(Node.StringValue);
	}

	@Override public void VisitConstPoolNode(ZConstPoolNode Node) {
		//		Object constValue = Node.ConstValue;
		//		LibNative.Assert(Node.ConstValue != null);
		//		this.CurrentBuilder.LoadConst(constValue);
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		//		this.CurrentBuilder.LoadConst(Node.Type);
		//		this.CurrentBuilder.LoadNewArray(this, 0, Node.NodeList);
		//		this.CurrentBuilder.InvokeMethodCall(Node.Type, JLib.NewNewArray);
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitNewArrayNode(ZNewArrayNode Node) {
		//		this.CurrentBuilder.LoadConst(Node.Type);
		//		this.CurrentBuilder.LoadNewArray(this, 0, Node.NodeList);
		//		this.CurrentBuilder.InvokeMethodCall(Node.Type, JLib.NewArray);
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		//		Type type = this.GetAsmType(Node.Type);
		//		String owner = type.getInternalName();
		//		this.CurrentBuilder.visitTypeInsn(NEW, owner);
		//		this.CurrentBuilder.visitInsn(DUP);
		//		if(!((Node.Type.TypeFlag & ZTypeFlag.UniqueType) == ZTypeFlag.UniqueType)) {
		//			this.CurrentBuilder.LoadConst(Node.Type);
		//			this.CurrentBuilder.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "(Lorg/ZenScript/ZenType;)V");
		//		} else {
		//			this.CurrentBuilder.visitMethodInsn(INVOKESPECIAL, owner, "<init>", "()V");
		//		}
	}

	@Override public void VisitSymbolNode(ZSymbolNode Node) {
		// TODO Auto-generated method stub
	}

	@Override public void VisitGetLocalNode(ZGetLocalNode Node) {
		this.CurrentBuilder.LoadLocal(Node.VarName);
		this.CurrentBuilder.CheckReturnCast(Node, this.CurrentBuilder.GetLocalType(Node.VarName));
	}

	@Override public void VisitSetLocalNode(ZSetLocalNode Node) {
		this.CurrentBuilder.PushNode(this.CurrentBuilder.GetLocalType(Node.VarName), Node.ValueNode);
		this.CurrentBuilder.StoreLocal(Node.VarName);
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		Node.RecvNode.Accept(this);
	}

	private Class<?> GetFieldType(Class<?> RecvClass, String Name) {
		try {
			return RecvClass.getField(Name).getType();
		} catch (Exception e) {
			LibNative.FixMe(e);
		}
		return null;
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		if(Node.IsUntyped()) {
			Method sMethod = NativeMethodTable.GetStaticMethod("GetField");
			ZNode NameNode = new ZStringNode(null, Node.FieldName);
			this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, NameNode});
		}
		else {
			Class<?> RecvClass = NativeTypeTable.GetJavaClass(Node.RecvNode.Type);
			Class<?> FieldClass = this.GetFieldType(RecvClass, Node.FieldName);
			Type FieldType = Type.getType(FieldClass);
			Type OwnerType = Type.getType(RecvClass);
			Node.RecvNode.Accept(this);
			this.CurrentBuilder.visitFieldInsn(GETFIELD, OwnerType.getInternalName(), Node.FieldName, FieldType.getDescriptor());
			this.CurrentBuilder.CheckReturnCast(Node, FieldClass);
		}
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		if(Node.IsUntyped()) {
			Method sMethod = NativeMethodTable.GetStaticMethod("SetField");
			ZNode NameNode = new ZStringNode(null, Node.FieldName);
			this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, NameNode, Node.ValueNode});
		}
		else {
			Class<?> RecvClass = NativeTypeTable.GetJavaClass(Node.RecvNode.Type);
			Class<?> FieldClass = this.GetFieldType(RecvClass, Node.FieldName);
			Type FieldType = Type.getType(FieldClass);
			Type OwnerType = Type.getType(RecvClass);
			Node.RecvNode.Accept(this);
			this.CurrentBuilder.PushNode(FieldClass, Node.ValueNode);
			this.CurrentBuilder.visitFieldInsn(PUTFIELD, OwnerType.getInternalName(), Node.FieldName, FieldType.getDescriptor());
		}
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		//		JMethod Method = JMethod.FindMethod(Node);
		//		Node.RecvNode.Accept(this);
		//		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(1), Node.IndexNode);
		//		this.CurrentBuilder.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		//		JMethod Method = JMethod.FindMethod(Node);
		//		Node.RecvNode.Accept(this);
		//		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(1), Node.IndexNode);
		//		this.CurrentBuilder.PushEvaluatedNode(Method.GetType(2), Node.ValueNode);
		//		this.CurrentBuilder.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		Method jMethod = this.GetMethod(Node.RecvNode.Type, Node.MethodName, Node.ParamList);
		if(jMethod != null) {
			Node.RecvNode.Accept(this);
			Class<?>[] P = jMethod.getParameterTypes();
			for(int i = 0; i < P.length; i++) {
				this.CurrentBuilder.PushNode(P[i], Node.ParamList.get(i));
			}
			int inst;
			if(Modifier.isInterface(jMethod.getModifiers())) {
				inst = INVOKEINTERFACE;
			}
			else {
				inst = INVOKEVIRTUAL;
			}
			String owner = Type.getInternalName(jMethod.getDeclaringClass());
			this.CurrentBuilder.visitMethodInsn(inst, owner, jMethod.getName(), Type.getMethodDescriptor(jMethod));
			this.CurrentBuilder.CheckReturnCast(Node, jMethod.getReturnType());
		}
		else {
			jMethod = NativeMethodTable.GetStaticMethod("InvokeUnresolvedMethod");
			this.CurrentBuilder.PushNode(Object.class, Node.RecvNode);
			this.CurrentBuilder.LoadConst(Node.MethodName);
			this.CurrentBuilder.PushNodeListAsArray(Object.class, 0, Node.ParamList);
			this.CurrentBuilder.ApplyStaticMethod(Node, jMethod, null);
		}
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		//		Node.FuncNode.Accept(this);
		//this.CurrentBuilder.LoadNewArray(this, 0, Node.ParamList);
		//		this.CurrentBuilder.InvokeMethodCall(Node.Type, JLib.InvokeFunc);
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		Method sMethod = NativeMethodTable.GetUnaryStaticMethod(Node.SourceToken.ParsedText, Node.RecvNode.Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		Method sMethod = NativeMethodTable.GetUnaryStaticMethod(Node.SourceToken.ParsedText, Node.RecvNode.Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitInstanceOfNode(ZInstanceOfNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		Method sMethod = NativeMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.ParsedText, Node.RightNode.Type);
		this.CurrentBuilder.ApplyStaticMethod(Node, sMethod, new ZNode[] {Node.LeftNode, Node.RightNode});
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		Method sMethod = NativeMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.ParsedText, Node.RightNode.Type);
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

	@Override public void VisitVarDeclNode(ZVarDeclNode Node) {
		Class<?> DeclClass = NativeTypeTable.GetJavaClass(Node.DeclType);
		this.CurrentBuilder.AddLocal(DeclClass, Node.NativeName);
		this.CurrentBuilder.PushNode(DeclClass, Node.InitNode);
		this.CurrentBuilder.StoreLocal(Node.NativeName);
		this.VisitBlockNode(Node);
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
			Type type = this.GetAsmType(Node.ValueNode.Type);
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

	//@Override public void VisitContinueNode(ZenContinueNode Node) {
	//	Label l = this.CurrentVisitor.ContinueLabelStack.peek();
	//	this.CurrentVisitor.visitJumpInsn(GOTO, l);
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
		MethodVisitor mv = this.CurrentBuilder;
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
		MethodVisitor mv = this.CurrentBuilder;
		Label catchLabel = new Label();
		TryCatchLabel Label = this.TryCatchLabel.get(this.TryCatchLabel.size() - 1);

		// prepare
		//TODO: add exception class name
		String throwType = this.GetAsmType(Node.ExceptionType).getInternalName();
		mv.visitTryCatchBlock(Label.beginTryLabel, Label.endTryLabel, catchLabel, throwType);

		// catch block
		JLocalVarStack local = this.CurrentBuilder.AddLocal(NativeTypeTable.GetJavaClass(Node.ExceptionType), Node.ExceptionName);
		mv.visitLabel(catchLabel);
		this.CurrentBuilder.StoreLocal(Node.ExceptionName);
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

	public Method LoadDefinedFunc(String FuncName, ZFuncType FuncType) {
		return this.FuncMap.GetOrNull(FuncType.StringfySignature(FuncName));
	}

	@Override public void VisitFuncDeclNode(ZFuncDeclNode Node) {
		@Var String FuncName = Node.ReferenceName;
		@Var JClassBuilder  HolderClass = this.ClassLoader.NewFunctionHolderClass(Node, FuncName);
		@Var ZFuncType FuncType = Node.GetFuncType(null);
		@Var String MethodDesc = this.GetMethodDescriptor(FuncType);
		//System.out.println("*** " + MethodDesc);
		this.CurrentBuilder = new JMethodBuilder2(ACC_PUBLIC | ACC_STATIC, Node.FuncName, MethodDesc, this, this.CurrentBuilder);
		HolderClass.AddMethod(this.CurrentBuilder);
		for(int i = 0; i < Node.ArgumentList.size(); i++) {
			ZParamNode ParamNode =(ZParamNode)Node.ArgumentList.get(i);
			this.CurrentBuilder.AddLocal(NativeTypeTable.GetJavaClass(ParamNode.Type), ParamNode.Name);
		}
		Node.BodyNode.Accept(this);
		if(Node.ReturnType.IsVoidType()) {
			// JVM always needs return;
			this.CurrentBuilder.visitInsn(RETURN);
		}
		try {
			Method FuncMethod = HolderClass.GetDefinedMethod(this.ClassLoader, Node.FuncName);
			this.FuncMap.put(Node.ReferenceName, FuncMethod);
		}
		catch(Error e) {
			e.printStackTrace();
		}
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
		this.CurrentBuilder.visitTypeInsn(NEW, name);
		this.CurrentBuilder.visitInsn(DUP);
		this.CurrentBuilder.LoadConst(Node.ErrorMessage);
		this.CurrentBuilder.visitMethodInsn(INVOKESPECIAL, name, "<init>", "(Ljava/lang/Object;)V");
		this.CurrentBuilder.visitInsn(ATHROW);
	}

	public Method GetStaticFuncMethod(ZNode FuncNode) {
		if(FuncNode.Type.IsFuncType()) {
			if(FuncNode instanceof ZSymbolNode) {
				return this.FuncMap.GetOrNull(((ZSymbolNode)FuncNode).ReferenceName);
			}
		}
		return null;
	}

	ZNode[] PackNodes(ZNode Node, ArrayList<ZNode> List) {
		int Start = 0;
		ZNode[] Nodes = new ZNode[List.size() + Start];
		if(Node != null) {
			Start = 1;
			Nodes[0] = Node;
		}
		for(int i = 0; i < Nodes.length; i++) {
			Nodes[i+Start] = List.get(i);
		}
		return Nodes;
	}

	public void Debug(String Message) {
		LibNative.Debug(Message);
	}

}


