package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.AASTORE;
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
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

import zen.ast.ZNode;
import zen.deps.NativeTypeTable;
import zen.lang.ZFuncType;
import zen.lang.ZSystem;

public class AsmMethodBuilder extends MethodNode {

	final AsmMethodBuilder          Parent;
	final Java6ByteCodeGenerator   Generator;
	ArrayList<JLocalVarStack>     LocalVals;
	Stack<Label>                  BreakLabelStack;
	Stack<Label>                  ContinueLabelStack;
	int PreviousLine;

	public AsmMethodBuilder(int acc, String Name, String Desc, Java6ByteCodeGenerator Generator, AsmMethodBuilder Parent) {
		super(acc, Name, Desc, null, null);
		this.Parent = Parent;
		this.Generator = Generator;
		this.LocalVals = new ArrayList<JLocalVarStack>();
		this.BreakLabelStack = new Stack<Label>();
		this.ContinueLabelStack = new Stack<Label>();
		this.PreviousLine = 0;
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
		this.SetLineNumber(Node.SourceToken.FileLine);
	}

	void LoadConst(Object Value) {
		if(Value instanceof Boolean || Value instanceof Long || Value instanceof Double || Value instanceof String) {
			this.visitLdcInsn(Value);
			return;
		}

		//		if(Value instanceof ZType) {
		//			int id = ((ZType)Value).TypeId;
		//			this.visitLdcInsn(id);
		//			this.InvokeMethodCall(ZType.class, JLib.GetTypeById);
		//			return;
		//		}
		//		int id = ZSystem.AddConstPool(Value);
		//		this.AsmVisitor.visitLdcInsn(id);
		//		this.InvokeMethodCall(Value.getClass(), JLib.GetConstPool);
	}

	JLocalVarStack AddLocal(Class<?> JType, String Name) {
		Type LocalType =  Type.getType(JType);
		JLocalVarStack local = new JLocalVarStack(this.LocalVals.size(), JType, LocalType, Name);
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
		Method sMethod = NativeMethodTable.GetCastMethod(C1, C2);
		this.Generator.Debug("C1="+C1.getSimpleName()+ ", C2="+C2.getSimpleName()+", CastMethod="+sMethod);
		if(sMethod != null) {
			String owner = Type.getInternalName(sMethod.getDeclaringClass());
			this.visitMethodInsn(INVOKESTATIC, owner, sMethod.getName(), Type.getMethodDescriptor(sMethod));
			this.CheckCast(C1, sMethod.getReturnType());
		}
		else {
			this.visitTypeInsn(CHECKCAST, Type.getInternalName(C1));
		}
	}

	void CheckParamCast(Class<?> C1, ZNode Node) {
		Class<?> C2 = NativeTypeTable.GetJavaClass(Node.Type);
		if(C1 != C2) {
			this.Generator.Debug("C2="+Node.getClass().getSimpleName() + ": " + Node.Type);
			this.CheckCast(C1, C2);
		}
	}

	void CheckReturnCast(ZNode Node, Class<?> C2) {
		Class<?> C1 = NativeTypeTable.GetJavaClass(Node.Type);
		if(C1 != C2) {
			this.Generator.Debug("C1"+Node.getClass().getSimpleName() + ": " + Node.Type);
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
		this.visitMethodInsn(INVOKESTATIC, owner, sMethod.getName(), Type.getMethodDescriptor(sMethod));
		this.CheckReturnCast(Node, sMethod.getReturnType());
	}

	void ApplyFuncName(ZNode Node, String FuncName, ZFuncType FuncType, ZNode[] Nodes) {
		if(Nodes != null) {
			//			Class<?>[] P = sMethod.getParameterTypes();
			for(int i = 0; i < Nodes.length; i++) {
				this.PushNode(null, Nodes[i]);
			}
		}
		String owner = "C" + FuncType.StringfySignature(FuncName);
		this.visitMethodInsn(INVOKESTATIC, owner, FuncName, AsmClassLoader.GetMethodDescriptor(FuncType));
		//this.CheckReturnCast(Node, FuncType.GetReturnType());
	}

	void ApplyFuncObject(ZNode Node, Class<?> FuncClass, ZNode FuncNode, ZFuncType FuncType, ZNode[] Nodes) {
		this.PushNode(FuncClass, FuncNode);
		if(Nodes != null) {
			for(int i = 0; i < Nodes.length; i++) {
				this.PushNode(null, Nodes[i]);
			}
		}
		String owner = Type.getInternalName(FuncClass);
		this.visitMethodInsn(INVOKEVIRTUAL, owner, "Invoke", AsmClassLoader.GetMethodDescriptor(FuncType));
		//this.CheckReturnCast(Node, FuncType.GetReturnType());
	}

	void PushNodeListAsArray(Class<?> T, int StartIdx, ArrayList<ZNode> NodeList) {
		this.visitLdcInsn(NodeList.size() - StartIdx);
		this.visitTypeInsn(ANEWARRAY, Type.getInternalName(T));
		//System.err.println("** arraysize = " + (NodeList.size() - StartIdx));
		for(int i = StartIdx; i < NodeList.size(); i++) {
			this.visitInsn(DUP);
			this.visitLdcInsn(i);
			this.PushNode(T, NodeList.get(i));
			this.visitInsn(AASTORE);
		}
	}

}
