package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import java.util.HashMap;

import zen.ast.ZNode;
import zen.deps.Var;
import zen.lang.ZSystem;
import zen.lang.ZType;
import zen.parser.ZGenerator;

class JClassLoader extends ClassLoader {
	final HashMap<String,JClassBuilder> ByteCodeMap;
	//	final String GlobalStaticClassName;
	//	final String ContextFieldName;
	//	final String GontextDescripter;

	public JClassLoader(ZGenerator Generator) {
		this.ByteCodeMap = new HashMap<String, JClassBuilder>();

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

	private void AddClassBuilder(JClassBuilder ClassBuilder) {
		this.ByteCodeMap.put(ClassBuilder.ClassName, ClassBuilder);
	}

	JClassBuilder NewClass(ZNode Node, String ClassName, ZType SuperType) {
		@Var String SourceFile = ZSystem.GetSourceFileName(Node.SourceToken.FileLine);
		@Var JClassBuilder cb = new JClassBuilder(ACC_PUBLIC, SourceFile, ClassName, "java/lang/Object" /*FIXME*/);
		this.AddClassBuilder(cb);
		return cb;
	}

	JClassBuilder NewFunctionHolderClass(ZNode Node, String FuncName) {
		@Var String SourceFile = ZSystem.GetSourceFileName(Node.SourceToken.FileLine);
		@Var JClassBuilder cb = new JClassBuilder(ACC_PUBLIC|ACC_FINAL, SourceFile, JLib.GetHolderClassName(FuncName), "java/lang/Object");
		this.AddClassBuilder(cb);
		return cb;
	}

	@Override protected Class<?> findClass(String name) {
		JClassBuilder cb = this.ByteCodeMap.get(name);
		if(cb != null) {
			byte[] b = cb.GenerateBytecode();
			this.ByteCodeMap.remove(name);
			return this.defineClass(name, b, 0, b.length);
		}
		return null;
	}

}