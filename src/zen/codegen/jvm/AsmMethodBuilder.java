package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.ANEWARRAY;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.ISTORE;
import static org.objectweb.asm.Opcodes.RETURN;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

import zen.ast.ZListNode;
import zen.ast.ZNode;
import zen.lang.ZFunc;
import zen.type.ZFuncType;
import zen.type.ZType;

class AsmMethodBuilder extends MethodNode {

	final AsmMethodBuilder          Parent;
	final JavaAsmGenerator   Generator;
	ArrayList<JavaLocalStack>     LocalVals  = new ArrayList<JavaLocalStack>();
	int UsedStack = 0;
	Stack<Label>                  BreakLabelStack = new Stack<Label>();
	Stack<Label>                  ContinueLabelStack = new Stack<Label>();
	int PreviousLine = 0;

	public AsmMethodBuilder(int acc, String Name, String Desc, JavaAsmGenerator Generator) {
		super(acc, Name, Desc, null, null);
		this.Generator = Generator;
		this.Parent = Generator.AsmBuilder;
		Generator.AsmBuilder = this;
	}

	public void Finish() {
		assert(this.Generator.AsmBuilder == this);
		this.Generator.AsmBuilder = this.Parent;
	}

	void SetLineNumber(int Line) {
		if(Line != 0 && Line != this.PreviousLine) {
			Label LineLabel = new Label();
			this.visitLineNumber(Line, LineLabel);
			this.PreviousLine = Line;
		}
	}

	void SetLineNumber(ZNode Node) {
		if(Node != null && Node.SourceToken != null) {
			this.SetLineNumber(Node.SourceToken.GetLineNumber());
		}
	}

	void PushBoolean(boolean b) {
		if(b) {
			this.visitInsn(Opcodes.ICONST_1);
		}
		else {
			this.visitInsn(Opcodes.ICONST_0);
		}
	}

	void PushInt(int n) {
		switch(n) {
		case -1: this.visitInsn(Opcodes.ICONST_M1); return;
		case 0: this.visitInsn(Opcodes.ICONST_0); return;
		case 1: this.visitInsn(Opcodes.ICONST_1); return;
		case 2: this.visitInsn(Opcodes.ICONST_2); return;
		case 3: this.visitInsn(Opcodes.ICONST_3); return;
		case 4: this.visitInsn(Opcodes.ICONST_4); return;
		case 5: this.visitInsn(Opcodes.ICONST_5); return;
		default:
			if(n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
				this.visitIntInsn(Opcodes.BIPUSH, n);
			}
			else if(n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
				this.visitIntInsn(Opcodes.SIPUSH, n);
			}
			else {
				this.visitLdcInsn(n);
			}
		}
	}

	void PushLong(long n) {
		if(n == 0) {
			this.visitInsn(Opcodes.LCONST_0);
		}
		else if(n == 1) {
			this.visitInsn(Opcodes.LCONST_1);
		}
		else if(n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
			this.PushInt((int)n);
			this.visitInsn(Opcodes.I2L);
		}
		else {
			this.visitLdcInsn(n);
		}
	}

	void PushDouble(double n) {
		if(n == 0.0) {
			this.visitInsn(Opcodes.DCONST_0);
		}
		else if(n == 1.0) {
			this.visitInsn(Opcodes.DCONST_1);
		}
		else {
			this.visitLdcInsn(n);
		}
	}


	void PushConst(Object Value) {
		if(Value instanceof Boolean) {
			this.PushBoolean((Boolean)Value);
		}
		else if(Value instanceof Long) {
			this.PushLong((Long)Value);
		}
		else if(Value instanceof Double) {
			this.PushDouble((Double)Value);
		}
		else {
			this.visitLdcInsn(Value);
			return;
		}
	}

	void Pop(ZType T) {
		if(T.IsFloatType() || T.IsIntType()) {
			this.visitInsn(Opcodes.POP2);
		}
		else if(!T.IsVoidType()) {
			this.visitInsn(Opcodes.POP);
		}
	}

	JavaLocalStack AddLocal(Class<?> jClass, String Name) {
		Type AsmType =  Type.getType(jClass);
		JavaLocalStack local = new JavaLocalStack(this.UsedStack, jClass, AsmType, Name);
		this.UsedStack = this.UsedStack + AsmType.getSize();
		this.LocalVals.add(local);
		return local;
	}

	void RemoveLocal(Class<?> JType, String Name) {
		for(int i = this.LocalVals.size() - 1; i >= 0; i--) {
			JavaLocalStack Local = this.LocalVals.get(i);
			if(Local.Name.equals(Name)) {
				this.LocalVals.remove(i);
				return;
			}
		}
	}

	JavaLocalStack FindLocalVariable(String Name) {
		for(int i = 0; i < this.LocalVals.size(); i++) {
			JavaLocalStack l = this.LocalVals.get(i);
			if(l.Name.equals(Name)) {
				return l;
			}
		}
		return null;
	}

	Class<?> GetLocalType(String Name) {
		JavaLocalStack local = this.FindLocalVariable(Name);
		return local.JavaType;
	}

	void LoadLocal(String Name) {
		JavaLocalStack local = this.FindLocalVariable(Name);
		Type type = local.AsmType;
		this.visitVarInsn(type.getOpcode(ILOAD), local.Index);
	}

	void StoreLocal(String Name) {
		JavaLocalStack local = this.FindLocalVariable(Name);
		Type type = local.AsmType;
		this.visitVarInsn(type.getOpcode(ISTORE), local.Index);
	}

	void CheckCast(Class<?> C1, Class<?> C2) {
		if(C1.equals(C2)) {
			return;
		}
		Method sMethod = JavaMethodTable.GetCastMethod(C1, C2);
		this.Generator.Debug("C1="+C1.getSimpleName()+ ", C2="+C2.getSimpleName()+", CastMethod="+sMethod);
		if(sMethod != null) {
			String owner = Type.getInternalName(sMethod.getDeclaringClass());
			this.visitMethodInsn(INVOKESTATIC, owner, sMethod.getName(), Type.getMethodDescriptor(sMethod));
			this.CheckCast(C1, sMethod.getReturnType());
		}
		else if (!C1.isAssignableFrom(C2)) {
			// c1 instanceof C2  C2.
			this.Generator.Debug("CHECKCAST C1="+C1.getSimpleName()+ ", given C2="+C2.getSimpleName());
			this.visitTypeInsn(CHECKCAST, Type.getInternalName(C1));
		}
	}

	void CheckParamCast(Class<?> C1, ZNode Node) {
		Class<?> C2 = this.Generator.GetJavaClass(Node.Type);
		if(C1 != C2) {
			this.Generator.Debug("C2="+Node + ": " + Node.Type);
			this.CheckCast(C1, C2);
		}
	}

	void CheckReturnCast(ZNode Node, Class<?> C2) {
		Class<?> C1 = this.Generator.GetJavaClass(Node.Type);
		if(C1 != C2) {
			this.Generator.Debug("C1"+Node + ": " + Node.Type);
			this.CheckCast(C1, C2);
		}
	}

	void PushNode(Class<?> T, ZNode Node) {
		Node.Accept(this.Generator);
		if(T != null) {
			this.CheckParamCast(T, Node);
		}
	}

	void ApplyStaticMethod(ZNode Node, Method sMethod) {
		String owner = Type.getInternalName(sMethod.getDeclaringClass());
		this.SetLineNumber(Node);
		this.visitMethodInsn(INVOKESTATIC, owner, sMethod.getName(), Type.getMethodDescriptor(sMethod));
		this.CheckReturnCast(Node, sMethod.getReturnType());
	}

	void ApplyStaticMethod(ZNode Node, Method sMethod, ZNode[] Nodes) {
		Class<?>[] P = sMethod.getParameterTypes();
		for(int i = 0; i < P.length; i++) {
			this.PushNode(P[i], Nodes[i]);
		}
		this.ApplyStaticMethod(Node, sMethod);
	}

	void ApplyStaticMethod(ZNode Node, Method sMethod, ZListNode ListNode) {
		Class<?>[] P = sMethod.getParameterTypes();
		for(int i = 0; i < P.length; i++) {
			this.PushNode(P[i], ListNode.GetListAt(i));
		}
		this.ApplyStaticMethod(Node, sMethod);
	}

	void ApplyFuncName(ZNode Node, ZFunc Func, ZListNode ListNode) {
		if(Func instanceof JavaStaticFunc) {
			this.ApplyStaticMethod(Node, ((JavaStaticFunc)Func).StaticFunc, ListNode);
		}
		else {
			ZFuncType FuncType = Func.GetFuncType();
			if(ListNode != null) {
				for(int i = 0; i < ListNode.GetListSize(); i++) {
					this.PushNode(null, ListNode.GetListAt(i));
				}
			}
			Class<?> FuncClass = this.Generator.GetDefinedFunctionClass(Func.FuncName, FuncType);
			this.SetLineNumber(Node);
			this.visitMethodInsn(INVOKESTATIC, FuncClass, "f", FuncType);
		}
	}

	void ApplyFuncObject(ZNode Node, Class<?> FuncClass, ZNode FuncNode, ZFuncType FuncType, ZListNode ListNode) {
		this.PushNode(FuncClass, FuncNode);
		for(int i = 0; i < ListNode.GetListSize(); i++) {
			this.PushNode(null, ListNode.GetListAt(i));
		}
		this.SetLineNumber(Node);
		this.visitMethodInsn(INVOKEVIRTUAL, FuncClass, "Invoke", FuncType);
	}

	void PushNodeListAsArray(Class<?> T, int StartIdx, ZListNode NodeList) {
		this.PushInt(NodeList.GetListSize() - StartIdx);
		if(T == long.class) {
			this.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_LONG);
		}
		else if(T == double.class) {
			this.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_DOUBLE);
		}
		else {
			this.visitTypeInsn(ANEWARRAY, Type.getInternalName(T));
		}
		for(int i = StartIdx; i < NodeList.GetListSize() ; i++) {
			this.visitInsn(DUP);
			this.PushInt(i - StartIdx);
			this.PushNode(T, NodeList.GetListAt(i));
			if(T == long.class) {
				this.visitInsn(Opcodes.LASTORE);
			}
			else if(T == double.class) {
				this.visitInsn(Opcodes.DASTORE);
			}
			else {
				this.visitInsn(Opcodes.AASTORE);
			}
		}
	}

	public void visitReturn(ZType ReturnType) {
		if(ReturnType.IsVoidType()) {
			this.visitInsn(RETURN);
		}
		else {
			Type type = this.Generator.AsmType(ReturnType);
			this.visitInsn(type.getOpcode(IRETURN));
		}
	}

	public void visitMethodInsn(int acc, String ClassName, String FuncName, ZFuncType FuncType) {
		this.visitMethodInsn(acc, ClassName, FuncName, this.Generator.GetMethodDescriptor(FuncType));
	}

	public void visitMethodInsn(int acc, Class<?> jClass, String FuncName, ZFuncType FuncType) {
		this.visitMethodInsn(acc, Type.getInternalName(jClass), FuncName, this.Generator.GetMethodDescriptor(FuncType));
	}

	public void visitFieldInsn(int opcode, String ClassName, String Name, Class<?> jClass) {
		this.visitFieldInsn(opcode, ClassName, Name, Type.getDescriptor(jClass));
	}

	public void visitTypeInsn(int opcode, Class<?> C) {
		this.visitTypeInsn(opcode, Type.getInternalName(C));
	}



}
