package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.ANEWARRAY;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.ISTORE;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

import zen.ast.ZListNode;
import zen.ast.ZNode;
import zen.deps.ZNativeFunc;
import zen.lang.ZFunc;
import zen.lang.ZSystem;
import zen.type.ZFuncType;
import zen.type.ZType;

class AsmMethodBuilder extends MethodNode {

	final AsmMethodBuilder          Parent;
	final AsmGenerator   Generator;
	ArrayList<JLocalVarStack>     LocalVals  = new ArrayList<JLocalVarStack>();
	int UsedStack = 0;
	Stack<Label>                  BreakLabelStack = new Stack<Label>();
	Stack<Label>                  ContinueLabelStack = new Stack<Label>();
	int PreviousLine = 0;

	public AsmMethodBuilder(int acc, String Name, String Desc, AsmGenerator Generator, AsmMethodBuilder Parent) {
		super(acc, Name, Desc, null, null);
		this.Parent = Parent;
		this.Generator = Generator;
	}

	void SetLineNumber(long FileLine) {
		if(FileLine != 0) {
			int Line = ZSystem.GetFileLineNumber(FileLine);
			if(Line != this.PreviousLine) {
				Label LineLabel = new Label();
				this.visitLineNumber(Line, LineLabel);
				this.PreviousLine = Line;
			}
		}
	}

	void SetLineNumber(ZNode Node) {
		if(Node.SourceToken != null) {
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

	JLocalVarStack AddLocal(Class<?> jClass, String Name) {
		Type AsmType =  Type.getType(jClass);
		JLocalVarStack local = new JLocalVarStack(this.UsedStack, jClass, AsmType, Name);
		this.UsedStack = this.UsedStack + AsmType.getSize();
		this.LocalVals.add(local);
		return local;
	}

	void RemoveLocal(Class<?> JType, String Name) {
		for(int i = this.LocalVals.size() - 1; i >= 0; i--) {
			JLocalVarStack Local = this.LocalVals.get(i);
			if(Local.Name.equals(Name)) {
				this.LocalVals.remove(i);
				return;
			}
		}
	}

	JLocalVarStack FindLocalVariable(String Name) {
		for(int i = 0; i < this.LocalVals.size(); i++) {
			JLocalVarStack l = this.LocalVals.get(i);
			if(l.Name.equals(Name)) {
				return l;
			}
		}
		return null;
	}

	Class<?> GetLocalType(String Name) {
		JLocalVarStack local = this.FindLocalVariable(Name);
		return local.JavaType;
	}

	void LoadLocal(String Name) {
		JLocalVarStack local = this.FindLocalVariable(Name);
		Type type = local.AsmType;
		this.visitVarInsn(type.getOpcode(ILOAD), local.Index);
	}

	void StoreLocal(String Name) {
		JLocalVarStack local = this.FindLocalVariable(Name);
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

	void ApplyStaticMethod(ZNode Node, Method sMethod, ZNode[] Nodes) {
		if(Nodes != null) {
			Class<?>[] P = sMethod.getParameterTypes();
			for(int i = 0; i < P.length; i++) {
				this.PushNode(P[i], Nodes[i]);
			}
		}
		String owner = Type.getInternalName(sMethod.getDeclaringClass());
		this.SetLineNumber(Node);
		this.visitMethodInsn(INVOKESTATIC, owner, sMethod.getName(), Type.getMethodDescriptor(sMethod));
		this.CheckReturnCast(Node, sMethod.getReturnType());
	}

	void ApplyFuncName(ZNode Node, ZFunc Func, ZNode[] Nodes) {
		if(Func instanceof ZNativeFunc) {
			this.ApplyStaticMethod(Node, ((ZNativeFunc)Func).jMethod, Nodes);
		}
		else {
			ZFuncType FuncType = Func.GetFuncType();
			if(Nodes != null) {
				for(int i = 0; i < Nodes.length; i++) {
					this.PushNode(null, Nodes[i]);
				}
			}
			String owner = "C" + FuncType.StringfySignature(Func.FuncName);
			this.SetLineNumber(Node);
			this.visitMethodInsn(INVOKESTATIC, owner, Func.FuncName, this.Generator.GetMethodDescriptor(FuncType));
		}
	}

	void ApplyFuncObject(ZNode Node, Class<?> FuncClass, ZNode FuncNode, ZFuncType FuncType, ZNode[] Nodes) {
		this.PushNode(FuncClass, FuncNode);
		if(Nodes != null) {
			for(int i = 0; i < Nodes.length; i++) {
				this.PushNode(null, Nodes[i]);
			}
		}
		String owner = Type.getInternalName(FuncClass);
		this.visitMethodInsn(INVOKEVIRTUAL, owner, "Invoke", this.Generator.GetMethodDescriptor(FuncType));
		//this.CheckReturnCast(Node, FuncType.GetReturnType());
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

}
