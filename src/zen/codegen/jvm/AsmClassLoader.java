package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.PUTSTATIC;
import static org.objectweb.asm.Opcodes.RETURN;

import java.util.ArrayList;
import java.util.HashMap;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import zen.ast.ZNode;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.deps.ZFunction;
import zen.deps.ZMatchFunction;
import zen.deps.ZTokenFunction;
import zen.parser.ZSourceContext;
import zen.parser.ZTokenContext;
import zen.type.ZFuncType;
import zen.type.ZType;
import zen.type.ZTypePool;

class AsmClassLoader extends ClassLoader {
	private final HashMap<String,AsmClassBuilder> ClassBuilderMap = new HashMap<String, AsmClassBuilder>();
	private final HashMap<String, Class<?>> FuncClassMap = new HashMap<String, Class<?>>();
	private final JavaAsmGenerator Generator;

	public AsmClassLoader(JavaAsmGenerator Generator) {
		this.Generator = Generator;
		this.InitFuncClass();
	}

	void AddClassBuilder(AsmClassBuilder ClassBuilder) {
		this.ClassBuilderMap.put(ClassBuilder.ClassName, ClassBuilder);
	}

	private static String NameFuncClass(ZFuncType FuncType) {
		return "ZFunc"+ FuncType.TypeId;
	}

	private void InitFuncClass() {
		ArrayList<ZType> TypeList = new ArrayList<ZType>();
		TypeList.add(ZType.BooleanType);
		TypeList.add(JavaTypeTable.GetZenType(ZSourceContext.class));
		ZFuncType FuncType = ZTypePool.LookupFuncType(TypeList);
		this.FuncClassMap.put(NameFuncClass(FuncType), ZTokenFunction.class);
		TypeList.clear();
		TypeList.add(JavaTypeTable.GetZenType(ZNode.class));
		TypeList.add(JavaTypeTable.GetZenType(ZNode.class));
		TypeList.add(JavaTypeTable.GetZenType(ZTokenContext.class));
		TypeList.add(JavaTypeTable.GetZenType(ZNode.class));
		FuncType = ZTypePool.LookupFuncType(TypeList);
		this.FuncClassMap.put(NameFuncClass(FuncType), ZMatchFunction.class);
	}

	Class<?> LoadFuncClass(ZFuncType FuncType) {
		String ClassName = NameFuncClass(FuncType);
		Class<?> FuncClass = this.FuncClassMap.get(ClassName);
		if(FuncClass == null) {
			@Var String SuperClassName = Type.getInternalName(ZFunction.class);
			@Var AsmClassBuilder cb = new AsmClassBuilder(ACC_PUBLIC| ACC_ABSTRACT, null, ClassName, SuperClassName);
			String Desc = this.Generator.GetMethodDescriptor(FuncType);
			MethodNode InvokeMethod = new MethodNode(ACC_PUBLIC | ACC_ABSTRACT, "Invoke", Desc, null, null);
			cb.AddMethod(InvokeMethod);

			MethodNode InitMethod = new MethodNode(ACC_PUBLIC, "<init>", "(ILjava/lang/String;)V", null, null);
			InitMethod.visitVarInsn(ALOAD, 0);
			InitMethod.visitVarInsn(ILOAD, 1);
			InitMethod.visitVarInsn(ALOAD, 2);
			InitMethod.visitMethodInsn(INVOKESPECIAL, SuperClassName, "<init>", "(ILjava/lang/String;)V");
			InitMethod.visitInsn(RETURN);
			cb.AddMethod(InitMethod);
			this.AddClassBuilder(cb);
			FuncClass = this.findClass(ClassName);
			this.FuncClassMap.put(ClassName, FuncClass);
		}
		return FuncClass;
	}

	AsmClassBuilder NewFunctionHolderClass(ZNode Node, JvmFuncNode FuncNode, ZFuncType FuncType) {
		@Var String SourceFile = Node.SourceToken.GetFileName();
		Class<?> FuncClass = this.LoadFuncClass(FuncType);
		@Var AsmClassBuilder cb = new AsmClassBuilder(ACC_PUBLIC|ACC_FINAL, SourceFile, FuncNode.ClassName, Type.getInternalName(FuncClass));
		this.AddClassBuilder(cb);
		String FuncTypeDesc = this.Generator.GetMethodDescriptor(FuncType);
		MethodNode InvokeMethod = new MethodNode(ACC_PUBLIC | ACC_FINAL, "Invoke", FuncTypeDesc, null, null);
		int index = 1;
		for(int i = 0; i < FuncType.GetFuncParamSize(); i++) {
			Type AsmType = this.Generator.AsmType(FuncType.GetFuncParamType(i));
			InvokeMethod.visitVarInsn(AsmType.getOpcode(ILOAD), index);
			index += AsmType.getSize();
		}
		//		String owner = "C" + FuncType.StringfySignature(FuncName);
		InvokeMethod.visitMethodInsn(INVOKESTATIC, FuncNode.ClassName, FuncNode.FuncName, FuncTypeDesc);
		if(FuncType.GetReturnType().IsVoidType()) {
			InvokeMethod.visitInsn(RETURN);
		}
		else {
			Type type = this.Generator.AsmType(FuncType.GetReturnType());
			InvokeMethod.visitInsn(type.getOpcode(IRETURN));
		}
		cb.AddMethod(InvokeMethod);
		FuncNode.FieldDesc = Type.getDescriptor(FuncClass);
		FieldNode StaticField = new FieldNode(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "function", FuncNode.FieldDesc, null, null);
		cb.AddField(StaticField);

		// static init
		MethodNode StaticInitMethod = new MethodNode(ACC_PUBLIC | ACC_STATIC , "<clinit>", "()V", null, null);
		StaticInitMethod.visitTypeInsn(NEW, FuncNode.ClassName);
		StaticInitMethod.visitInsn(DUP);
		StaticInitMethod.visitMethodInsn(INVOKESPECIAL, FuncNode.ClassName, "<init>", "()V");
		StaticInitMethod.visitFieldInsn(PUTSTATIC, FuncNode.ClassName, "function",  FuncNode.FieldDesc);
		StaticInitMethod.visitInsn(RETURN);
		cb.AddMethod(StaticInitMethod);

		MethodNode InitMethod = new MethodNode(ACC_PRIVATE, "<init>", "()V", null, null);
		InitMethod.visitVarInsn(ALOAD, 0);
		InitMethod.visitLdcInsn(FuncType.TypeId);
		InitMethod.visitLdcInsn(FuncNode.FuncName);
		InitMethod.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(FuncClass), "<init>", "(ILjava/lang/String;)V");
		InitMethod.visitInsn(RETURN);
		cb.AddMethod(InitMethod);
		return cb;
	}

	AsmClassBuilder NewClass(ZNode Node, String ClassName, Class<?> SuperClass) {
		@Var String SourceFile = Node.SourceToken.GetFileName();
		@Var AsmClassBuilder ClassBuilder = new AsmClassBuilder(ACC_PUBLIC, SourceFile, ClassName, Type.getInternalName(SuperClass));
		this.AddClassBuilder(ClassBuilder);
		return ClassBuilder;
	}

	@Override protected Class<?> findClass(String name) {
		//System.err.println("loading .. " + name);
		AsmClassBuilder ClassBuilder = this.ClassBuilderMap.get(name);
		if(ClassBuilder != null) {
			byte[] b = ClassBuilder.GenerateBytecode();
			ClassBuilder.OutputClassFile();
			this.ClassBuilderMap.remove(name);
			try {
				return this.defineClass(name, b, 0, b.length);
			}
			catch(Error e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return null;
	}

	public Class<?> LoadGeneratedClass(String ClassName) {
		try {
			return this.loadClass(ClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LibNative.Exit(1, "generation failed: " + ClassName);
		}
		return null;
	}

}