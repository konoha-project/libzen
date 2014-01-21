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

import zen.ast.ZenAndNode;
import zen.ast.ZenArrayLiteralNode;
import zen.ast.ZenBinaryNode;
import zen.ast.ZenBlockNode;
import zen.ast.ZenBooleanNode;
import zen.ast.ZenBreakNode;
import zen.ast.ZenCastNode;
import zen.ast.ZenCatchNode;
import zen.ast.ZenClassDeclNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenConstPoolNode;
import zen.ast.ZenEmptyNode;
import zen.ast.ZenErrorNode;
import zen.ast.ZenFloatNode;
import zen.ast.ZenFuncCallNode;
import zen.ast.ZenFuncDeclNode;
import zen.ast.ZenFunctionNode;
import zen.ast.ZenGetIndexNode;
import zen.ast.ZenGetLocalNode;
import zen.ast.ZenGetterNode;
import zen.ast.ZenGroupNode;
import zen.ast.ZenIfNode;
import zen.ast.ZenInstanceOfNode;
import zen.ast.ZenIntNode;
import zen.ast.ZenMapLiteralNode;
import zen.ast.ZenMethodCallNode;
import zen.ast.ZenNewArrayNode;
import zen.ast.ZenNewObjectNode;
import zen.ast.ZenNotNode;
import zen.ast.ZenNullNode;
import zen.ast.ZenOrNode;
import zen.ast.ZenParamNode;
import zen.ast.ZenReturnNode;
import zen.ast.ZenSetIndexNode;
import zen.ast.ZenSetLocalNode;
import zen.ast.ZenSetterNode;
import zen.ast.ZenStringNode;
import zen.ast.ZenSymbolNode;
import zen.ast.ZenThrowNode;
import zen.ast.ZenTryNode;
import zen.ast.ZenUnaryNode;
import zen.ast.ZenVarDeclNode;
import zen.ast.ZenWhileNode;
import zen.deps.LibNative;
import zen.lang.ZTypeFlag;
import zen.lang.ZSystem;
import zen.parser.ZGenerator;


class TryCatchLabel {
	public Label beginTryLabel;
	public Label endTryLabel;
	public Label finallyLabel;
	public TryCatchLabel() {
		this.beginTryLabel = new Label();
		this.endTryLabel = new Label();
		this.finallyLabel = new Label();
	}
}


public class JavaByteCodeGenerator extends ZGenerator {
	JMethodBuilder CurrentVisitor;
	ZenClassLoader ClassGenerator;
	ArrayList<TryCatchLabel> TryCatchLabel;
	public JavaByteCodeGenerator() {
		super("java", "1.6");
		this.TryCatchLabel = new ArrayList<TryCatchLabel>();
	}

	@Override
	public void VisitEmptyNode(ZenEmptyNode Node) {
		/* do nothing */
	}

	@Override
	public void VisitNullNode(ZenNullNode Node) {
		this.CurrentVisitor.AsmVisitor.visitInsn(ACONST_NULL);
	}

	@Override public void VisitBooleanNode(ZenBooleanNode Node) {
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Node.BooleanValue);
	}

	@Override public void VisitIntNode(ZenIntNode Node) {
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Node.Value);
	}

	@Override public void VisitFloatNode(ZenFloatNode Node) {
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Node.Value);
	}

	@Override public void VisitStringNode(ZenStringNode Node) {
		this.CurrentVisitor.AsmVisitor.visitLdcInsn(Node.Value);
	}

	@Override public void VisitConstPoolNode(ZenConstPoolNode Node) {
		Object constValue = Node.ConstValue;
		LibNative.Assert(Node.ConstValue != null);
		this.CurrentVisitor.LoadConst(constValue);
	}

	@Override public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
		this.CurrentVisitor.LoadConst(Node.Type);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.NodeList);
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.NewNewArray);
	}

	@Override
	public void VisitMapLiteralNode(ZenMapLiteralNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitNewArrayNode(ZenNewArrayNode Node) {
		this.CurrentVisitor.LoadConst(Node.Type);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.NodeList);
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.NewArray);
	}

	@Override
	public void VisitNewObjectNode(ZenNewObjectNode Node) {
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

	@Override public void VisitGetLocalNode(ZenGetLocalNode Node) {
		JLocalVarStack local = this.CurrentVisitor.FindLocalVariable(Node.VarName);
		this.CurrentVisitor.LoadLocal(local);
	}

	@Override public void VisitSetLocalNode(ZenSetLocalNode Node) {
		JLocalVarStack local = this.CurrentVisitor.FindLocalVariable(Node.VarName);
		this.CurrentVisitor.PushEvaluatedNode(Node.ValueNode.Type, Node.ValueNode);
		this.CurrentVisitor.StoreLocal(local);
	}

	@Override
	public void VisitGroupNode(ZenGroupNode Node) {
		Node.RecvNode.Accept(this);
	}

	@Override public void VisitGetterNode(ZenGetterNode Node) {
		String Name = Node.NativeName;
		Type FieldType = JLib.GetAsmType(Node.Type);
		Type OwnerType = JLib.GetAsmType(Node.RecvNode.Type);
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.AsmVisitor.visitFieldInsn(GETFIELD, OwnerType.getInternalName(), Name, FieldType.getDescriptor());
	}

	@Override public void VisitSetterNode(ZenSetterNode Node) {
		String Name = Node.NativeName;
		Type FieldType = JLib.GetAsmType(Node.Type);
		Type OwnerType = JLib.GetAsmType(Node.RecvNode.Type);
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.PushEvaluatedNode(Node.Type, Node.ValueNode);
		this.CurrentVisitor.AsmVisitor.visitFieldInsn(PUTFIELD, OwnerType.getInternalName(), Name, FieldType.getDescriptor());
	}

	@Override public void VisitGetIndexNode(ZenGetIndexNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(1), Node.IndexNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitSetIndexNode(ZenSetIndexNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(1), Node.IndexNode);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(2), Node.ValueNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override
	public void VisitMethodCallNode(ZenMethodCallNode Node) {
		Node.RecvNode.Accept(this);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.ParamList);
		// FIXME Find method and invoke it.
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.InvokeFunc);
	}

	@Override
	public void VisitFuncCallNode(ZenFuncCallNode Node) {
		Node.FuncNode.Accept(this);
		this.CurrentVisitor.LoadNewArray(this, 0, Node.ParamList);
		this.CurrentVisitor.InvokeMethodCall(Node.Type, JLib.InvokeFunc);
	}

	@Override
	public void VisitUnaryNode(ZenUnaryNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(0), Node.RecvNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override
	public void VisitNotNode(ZenNotNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(0), Node.RecvNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override
	public void VisitCastNode(ZenCastNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(0), Node.LeftNode);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(1), Node.RightNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override
	public void VisitComparatorNode(ZenComparatorNode Node) {
		JMethod Method = JMethod.FindMethod(Node);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(0), Node.LeftNode);
		this.CurrentVisitor.PushEvaluatedNode(Method.GetType(1), Node.RightNode);
		this.CurrentVisitor.InvokeMethodCall(Method.GetReturnType(), Method.Body);
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
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

	@Override public void VisitOrNode(ZenOrNode Node) {
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

	@Override
	public void VisitBlockNode(ZenBlockNode Node) {
		// TODO Auto-generated method stub

	}

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		JLocalVarStack local = this.CurrentVisitor.AddLocal(Node.Type, Node.NativeName);
		this.CurrentVisitor.PushEvaluatedNode(Node.DeclType, Node.InitNode);
		this.CurrentVisitor.StoreLocal(local);
	}

	@Override public void VisitIfNode(ZenIfNode Node) {
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

	@Override
	public void VisitReturnNode(ZenReturnNode Node) {
		if(Node.ValueNode != null) {
			Node.ValueNode.Accept(this);
			Type type = JLib.GetAsmType(Node.ValueNode.Type);
			this.CurrentVisitor.AsmVisitor.visitInsn(type.getOpcode(IRETURN));
		}
		else {
			this.CurrentVisitor.AsmVisitor.visitInsn(RETURN);
		}
	}

	@Override public void VisitWhileNode(ZenWhileNode Node) {
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

	@Override public void VisitBreakNode(ZenBreakNode Node) {
		Label l = this.CurrentVisitor.BreakLabelStack.peek();
		this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, l);
	}

	//@Override public void VisitContinueNode(ZenContinueNode Node) {
	//	Label l = this.CurrentVisitor.ContinueLabelStack.peek();
	//	this.CurrentVisitor.AsmVisitor.visitJumpInsn(GOTO, l);
	//}

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

	@Override public void VisitTryNode(ZenTryNode Node) {
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

	@Override
	public void VisitCatchNode(ZenCatchNode Node) {
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

	@Override
	public void VisitParamNode(ZenParamNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitFunctionNode(ZenFunctionNode Node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void VisitFuncDeclNode(ZenFuncDeclNode Node) {
		if(this.ClassGenerator == null) {
			this.ClassGenerator = new ZenClassLoader(Node.NameSpace);
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

	@Override public void VisitClassDeclNode(ZenClassDeclNode Node) {
		//TODO
	}

	@Override public void VisitErrorNode(ZenErrorNode Node) {
		String name = Type.getInternalName(SoftwareFaultException.class);
		this.CurrentVisitor.SetLineNumber(Node);
		this.CurrentVisitor.AsmVisitor.visitTypeInsn(NEW, name);
		this.CurrentVisitor.AsmVisitor.visitInsn(DUP);
		this.CurrentVisitor.LoadConst(Node.ErrorMessage);
		this.CurrentVisitor.AsmVisitor.visitMethodInsn(INVOKESPECIAL, name, "<init>", "(Ljava/lang/Object;)V");
		this.CurrentVisitor.AsmVisitor.visitInsn(ATHROW);
	}

	@Override
	public void VisitSymbolNode(ZenSymbolNode Node) {
		// TODO Auto-generated method stub

	}

}


