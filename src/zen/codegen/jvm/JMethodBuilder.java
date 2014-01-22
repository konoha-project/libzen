package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.AASTORE;
import static org.objectweb.asm.Opcodes.ANEWARRAY;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.ISTORE;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Stack;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import zen.ast.ZNode;
import zen.lang.ZSystem;
import zen.lang.ZType;
import zen.parser.ZGenerator;

class JMethodBuilder {
	final MethodVisitor           AsmVisitor;
	final JavaByteCodeGenerator   Generator;
	final JMethodBuilder          Parent;
	ArrayList<JLocalVarStack>     LocalVals;
	int                           LocalSize;
	Stack<Label>                  BreakLabelStack;
	Stack<Label>                  ContinueLabelStack;
	int PreviousLine;

	JMethodBuilder(JavaByteCodeGenerator Generator, MethodVisitor AsmVisitor, JMethodBuilder Parent) {
		this.Generator = Generator;
		this.AsmVisitor = AsmVisitor;
		this.Parent = Parent;
		this.LocalVals = new ArrayList<JLocalVarStack>();
		this.LocalSize = 0;
		this.BreakLabelStack = new Stack<Label>();
		this.ContinueLabelStack = new Stack<Label>();
		this.PreviousLine = 0;
	}

	void SetLineNumber(long FileLine) {
		if(FileLine != 0) {
			int Line = ZSystem.GetFileLineNumber(FileLine);
			if(Line != this.PreviousLine) {
				Label LineLabel = new Label();
				this.AsmVisitor.visitLineNumber(Line, LineLabel);
				this.PreviousLine = Line;
			}
		}
	}

	void SetLineNumber(ZNode Node) {
		this.SetLineNumber(Node.SourceToken.FileLine);
	}

	void LoadLocal(JLocalVarStack local) {
		Type type = local.AsmType;
		this.AsmVisitor.visitVarInsn(type.getOpcode(ILOAD), local.Index);
	}

	void StoreLocal(JLocalVarStack local) {
		Type type = local.AsmType;
		this.AsmVisitor.visitVarInsn(type.getOpcode(ISTORE), local.Index);
	}

	public JLocalVarStack FindLocalVariable(String Name) {
		for(int i = 0; i < this.LocalVals.size(); i++) {
			JLocalVarStack l = this.LocalVals.get(i);
			if(l.Name.equals(Name)) {
				return l;
			}
		}
		return null;
	}

	JLocalVarStack AddLocal(ZType GreenType, String Name) {
		Type LocalType =  this.Generator.GetAsmType(GreenType);
		JLocalVarStack local = new JLocalVarStack(this.LocalSize, null, LocalType, Name);
		this.LocalVals.add(local);
		this.LocalSize += LocalType.getSize();
		return local;
	}

	void LoadConst(Object Value) {
		if(Value instanceof Boolean || Value instanceof Long || Value instanceof Double || Value instanceof String) {
			this.AsmVisitor.visitLdcInsn(Value);
			return;
		}
		if(Value instanceof ZType) {
			int id = ((ZType)Value).TypeId;
			this.AsmVisitor.visitLdcInsn(id);
			this.InvokeMethodCall(ZType.class, JLib.GetTypeById);
			return;
		}
		int id = ZSystem.AddConstPool(Value);
		this.AsmVisitor.visitLdcInsn(id);
		this.InvokeMethodCall(Value.getClass(), JLib.GetConstPool);
	}

	void LoadNewArray(ZGenerator Visitor, int StartIdx, ArrayList<ZNode> NodeList) {
		this.AsmVisitor.visitLdcInsn(NodeList.size() - StartIdx);
		this.AsmVisitor.visitTypeInsn(ANEWARRAY, Type.getInternalName(Object.class));
		//System.err.println("** arraysize = " + (NodeList.size() - StartIdx));
		for(int i = StartIdx; i < NodeList.size(); i++) {
			this.AsmVisitor.visitInsn(DUP);
			this.AsmVisitor.visitLdcInsn(i);
			NodeList.get(i).Accept(Visitor);
			this.CheckCast(Object.class, NodeList.get(i).Type);
			this.AsmVisitor.visitInsn(AASTORE);
		}
	}

	void CheckCast(Class<?> RequiredType, Class<?> GivenType) {
		//System.err.println("casting .. giventype = " + GivenType + ", requested = " + RequiredType);
		if(RequiredType == void.class || RequiredType == GivenType ) {
			return;
		}
		if(RequiredType == long.class) {
			if(GivenType == Object.class) {
				this.AsmVisitor.visitTypeInsn(CHECKCAST, Type.getInternalName(Long.class));
				this.InvokeMethodCall(long.class, JLib.UnboxIntValue);
				return;
			}
		}
		if(RequiredType == double.class) {
			if(GivenType == Object.class) {
				this.AsmVisitor.visitTypeInsn(CHECKCAST, Type.getInternalName(Double.class));
				this.InvokeMethodCall(double.class, JLib.UnboxFloatValue);
				return;
			}
		}
		if(RequiredType == boolean.class) {
			if(GivenType == Object.class) {
				this.AsmVisitor.visitTypeInsn(CHECKCAST, Type.getInternalName(Long.class));
				this.InvokeMethodCall(boolean.class, JLib.UnboxBooleanValue);
				return;
			}
		}
		if(GivenType == long.class) {
			if(RequiredType == Object.class) {
				this.InvokeMethodCall(Long.class, JLib.BoxIntValue);
				return;
			}
		}
		if(GivenType == double.class) {
			if(RequiredType == Object.class) {
				this.InvokeMethodCall(Double.class, JLib.BoxFloatValue);
				return;
			}
		}
		if(GivenType == boolean.class) {
			if(RequiredType == Object.class) {
				this.InvokeMethodCall(Boolean.class, JLib.BoxBooleanValue);
				return;
			}
		}
		if(GivenType.isArray()) {
			return;//FIXME
		}
		if(GivenType.isPrimitive() && RequiredType.isPrimitive()) {
			return;//FIXME
		}
		//System.err.println("CHECKCAST (" + RequiredType + ") " + GivenType);
		this.AsmVisitor.visitTypeInsn(CHECKCAST, Type.getInternalName(RequiredType));
	}

	void CheckCast(Class<?> RequiredType, ZType GivenType) {
		//		if(GivenType != null) {
		//			this.CheckCast(RequiredType, GivenType.GetNativeType(false));
		//		}
		//		//		else {
		//		//			System.err.println("cannot check cast given = " + GivenType + " RequiredType="+RequiredType);
		//		//		}
	}

	void CheckCast(ZType RequiredType, ZType GivenType) {
		//		this.CheckCast(RequiredType.GetNativeType(false), GivenType);
	}

	void Call(Constructor<?> method) {
		String owner = Type.getInternalName(method.getDeclaringClass());
		this.AsmVisitor.visitMethodInsn(INVOKESPECIAL, owner, "<init>", Type.getConstructorDescriptor(method));
	}

	void InvokeMethodCall(Method method) {
		//		System.err.println("giventype = " + method);
		this.InvokeMethodCall(void.class, method);
	}

	void InvokeMethodCall(ZType RequiredType, Method method) {
		Class<?> RequiredNativeType = Object.class;
		//		if(RequiredType != null) {
		//			RequiredNativeType = RequiredType.GetNativeType(false);
		//		}
		this.InvokeMethodCall(RequiredNativeType, method);
	}

	void InvokeMethodCall(Class<?> RequiredType, Method method) {
		int inst;
		if(Modifier.isStatic(method.getModifiers())) {
			inst = INVOKESTATIC;
		}
		else if(Modifier.isInterface(method.getModifiers())) {
			inst = INVOKEINTERFACE;
		}
		else {
			inst = INVOKEVIRTUAL;
		}
		String owner = Type.getInternalName(method.getDeclaringClass());
		this.AsmVisitor.visitMethodInsn(inst, owner, method.getName(), Type.getMethodDescriptor(method));
		//System.err.println("\tRequiredType="+RequiredType+", " + method);
		this.CheckCast(RequiredType, method.getReturnType());
	}

	public void PushEvaluatedNode(ZType RequestedType, ZNode ParamNode) {
		//System.err.println("requested=" + RequestedType + ", given="+ParamNode.Type);
		ParamNode.Accept(this.Generator);
		this.CheckCast(RequestedType, ParamNode.Type);
	}

}