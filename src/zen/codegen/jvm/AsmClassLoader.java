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
import zen.deps.IMatchFunc;
import zen.deps.ITokenFunc;
import zen.deps.NativeTypeTable;
import zen.deps.Var;
import zen.deps.ZenFunction;
import zen.lang.ZSystem;
import zen.parser.ZGenerator;
import zen.parser.ZNameSpace;
import zen.parser.ZTokenContext;
import zen.type.ZFuncType;
import zen.type.ZType;

class AsmClassLoader extends ClassLoader {
	final HashMap<String,AsmClassBuilder> ByteCodeMap;
	//	final String GlobalStaticClassName;
	//	final String ContextFieldName;
	//	final String GontextDescripter;

	public AsmClassLoader(ZGenerator Generator) {
		this.ByteCodeMap = new HashMap<String, AsmClassBuilder>();
		this.InitFuncClass();

		//		this.GlobalStaticClassName = "Global$" + 0/*Context.ParserId*/;
		//		JClassBuilder GlobalClass = new JClassBuilder(ACC_PUBLIC|ACC_FINAL, null, this.GlobalStaticClassName, "java/lang/Object");
		//		FieldNode fn = new FieldNode(ACC_STATIC, "ParserContext", Type.getDescriptor(ZNameSpace.class), null, null);
		//		this.ContextFieldName = fn.name;
		//		this.GontextDescripter = fn.desc;
		//		GlobalClass.AddField(fn);
		//		// static init
		//		MethodNode mn = new MethodNode(ACC_PUBLIC | ACC_STATIC, "<clinit>", "()V", null, null);
		//		JMethodBuilder MethodBuilder = new JMethodBuilder(Generator, this, mn);
		//		MethodBuilder.LoadConst(NameSpace);
		//		MethodBuilder.AsmVisitor.visitFieldInsn(PUTSTATIC, this.GlobalStaticClassName, this.ContextFieldName, this.GontextDescripter);
		//		MethodBuilder.AsmVisitor.visitInsn(RETURN);
		//		GlobalClass.AddMethod(mn);
		//		byte[] b = GlobalClass.GenerateBytecode();
		//		this.defineClass(this.GlobalStaticClassName, b, 0, b.length);
	}



	private void AddClassBuilder(AsmClassBuilder ClassBuilder) {
		this.ByteCodeMap.put(ClassBuilder.ClassName, ClassBuilder);
	}

	private final HashMap<String, Class<?>> FuncClassMap = new HashMap<String, Class<?>>();
	private static String FuncClassName(ZFuncType FuncType) {
		return "ZFunc"+ FuncType.TypeId;
	}

	private void InitFuncClass() {
		ArrayList<ZType> TypeList = new ArrayList<ZType>();
		TypeList.add(ZSystem.IntType);
		TypeList.add(NativeTypeTable.GetZenType(ZTokenContext.class));
		TypeList.add(ZSystem.StringType);
		TypeList.add(ZSystem.IntType);
		ZFuncType FuncType = ZSystem.LookupFuncType(TypeList);
		this.FuncClassMap.put(FuncClassName(FuncType), ITokenFunc.class);
		TypeList.clear();
		TypeList.add(NativeTypeTable.GetZenType(ZNode.class));
		TypeList.add(NativeTypeTable.GetZenType(ZNameSpace.class));
		TypeList.add(NativeTypeTable.GetZenType(ZTokenContext.class));
		TypeList.add(NativeTypeTable.GetZenType(ZNode.class));
		FuncType = ZSystem.LookupFuncType(TypeList);
		this.FuncClassMap.put(FuncClassName(FuncType), IMatchFunc.class);
	}

	public Class<?> LoadFuncClass(ZFuncType FuncType) {
		String ClassName = FuncClassName(FuncType);
		Class<?> FuncClass = this.FuncClassMap.get(ClassName);
		if(FuncClass == null) {
			@Var String SuperClassName = Type.getInternalName(ZenFunction.class);
			@Var AsmClassBuilder cb = new AsmClassBuilder(ACC_PUBLIC| ACC_ABSTRACT, null, ClassName, SuperClassName);
			String Desc = AsmClassLoader.GetMethodDescriptor(FuncType);
			MethodNode InvokeMethod = new MethodNode(ACC_PUBLIC | ACC_ABSTRACT, "Invoke", Desc, null, null);
			cb.AddMethod(InvokeMethod);

			MethodNode InitMethod = new MethodNode(ACC_PUBLIC, "<init>", "(Ljava/lang/String;)V", null, null);
			InitMethod.visitVarInsn(ALOAD, 0);
			InitMethod.visitVarInsn(ALOAD, 1);
			InitMethod.visitMethodInsn(INVOKESPECIAL, SuperClassName, "<init>", "(Ljava/lang/String;)V");
			InitMethod.visitInsn(RETURN);
			cb.AddMethod(InitMethod);
			this.AddClassBuilder(cb);
			FuncClass = this.findClass(ClassName);
			this.FuncClassMap.put(ClassName, FuncClass);
		}
		return FuncClass;
	}

	AsmClassBuilder NewFunctionHolderClass(ZNode Node, JvmFuncNode FuncNode, ZFuncType FuncType) {
		@Var String SourceFile = ZSystem.GetSourceFileName(Node.SourceToken.FileLine);
		Class<?> FuncClass = this.LoadFuncClass(FuncType);
		@Var AsmClassBuilder cb = new AsmClassBuilder(ACC_PUBLIC|ACC_FINAL, SourceFile, FuncNode.ClassName, Type.getInternalName(FuncClass));
		this.AddClassBuilder(cb);
		String FuncTypeDesc = AsmClassLoader.GetMethodDescriptor(FuncType);
		MethodNode InvokeMethod = new MethodNode(ACC_PUBLIC | ACC_FINAL, "Invoke", FuncTypeDesc, null, null);
		int index = 1;
		for(int i = 0; i < FuncType.GetFuncParamSize(); i++) {
			Type AsmType = GetAsmType(FuncType.GetFuncParamType(i));
			InvokeMethod.visitVarInsn(AsmType.getOpcode(ILOAD), index);
			index += AsmType.getSize();
		}
		//		String owner = "C" + FuncType.StringfySignature(FuncName);
		InvokeMethod.visitMethodInsn(INVOKESTATIC, FuncNode.ClassName, FuncNode.FuncName, FuncTypeDesc);
		if(FuncType.GetReturnType().IsVoidType()) {
			InvokeMethod.visitInsn(RETURN);
		}
		else {
			Type type = AsmClassLoader.GetAsmType(FuncType.GetReturnType());
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
		InitMethod.visitLdcInsn(FuncNode.FuncName + ": " + FuncType);
		InitMethod.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(FuncClass), "<init>", "(Ljava/lang/String;)V");
		InitMethod.visitInsn(RETURN);
		cb.AddMethod(InitMethod);
		return cb;
	}


	AsmClassBuilder NewClass(ZNode Node, String ClassName, ZType SuperType) {
		@Var String SourceFile = ZSystem.GetSourceFileName(Node.SourceToken.FileLine);
		@Var AsmClassBuilder cb = new AsmClassBuilder(ACC_PUBLIC, SourceFile, ClassName, "java/lang/Object" /*FIXME*/);
		this.AddClassBuilder(cb);
		return cb;
	}


	@Override protected Class<?> findClass(String name) {
		AsmClassBuilder cb = this.ByteCodeMap.get(name);
		if(cb != null) {
			byte[] b = cb.GenerateBytecode();
			this.ByteCodeMap.remove(name);
			return this.defineClass(name, b, 0, b.length);
		}
		return null;
	}

	static String GetTypeDesc(ZType zType) {
		Class<?> JClass = NativeTypeTable.GetJavaClass(zType);
		return Type.getDescriptor(JClass);
	}

	static String GetMethodDescriptor(ZFuncType FuncType) {
		@Var Type ReturnType = GetAsmType(FuncType.GetReturnType());
		@Var Type[] ArgTypes = new Type[FuncType.GetFuncParamSize()];
		for(int i = 0; i < ArgTypes.length; i++) {
			ZType ParamType = FuncType.GetParamType(i);
			ArgTypes[i] = GetAsmType(ParamType);
		}
		String Desc = Type.getMethodDescriptor(ReturnType, ArgTypes);
		//this.Debug("Desc: " + Desc + ", FuncType: " + FuncType);
		return Desc;
	}

	static Type GetAsmType(ZType zType) {
		return Type.getType(NativeTypeTable.GetJavaClass(zType));
	}


}