package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.PUTSTATIC;
import static org.objectweb.asm.Opcodes.RETURN;

import java.util.HashMap;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import zen.parser.ZNameSpace;

class ZenClassLoader extends ClassLoader {
	final ZNameSpace NameSpace;
	final HashMap<String,JClassBuilder> ByteCodeMap;
	final String GlobalStaticClassName;
	final String ContextFieldName;
	final String GontextDescripter;

	public ZenClassLoader(ZNameSpace NameSpace) {
		this.NameSpace = NameSpace;
		this.ByteCodeMap = new HashMap<String,JClassBuilder>();

		this.GlobalStaticClassName = "Global$" + 0/*Context.ParserId*/;
		JClassBuilder GlobalClass = new JClassBuilder(ACC_PUBLIC|ACC_FINAL, null, this.GlobalStaticClassName, "java/lang/Object");
		FieldNode fn = new FieldNode(ACC_STATIC, "ParserContext", Type.getDescriptor(ZNameSpace.class), null, null);
		this.ContextFieldName = fn.name;
		this.GontextDescripter = fn.desc;
		GlobalClass.AddField(fn);

		// static init
		MethodNode mn = new MethodNode(ACC_PUBLIC | ACC_STATIC, "<clinit>", "()V", null, null);
		JMethodBuilder MethodBuilder = new JMethodBuilder(NameSpace.Generator, this, mn);
		MethodBuilder.LoadConst(NameSpace);
		MethodBuilder.AsmVisitor.visitFieldInsn(PUTSTATIC, this.GlobalStaticClassName, this.ContextFieldName, this.GontextDescripter);
		MethodBuilder.AsmVisitor.visitInsn(RETURN);
		GlobalClass.AddMethod(mn);
		byte[] b = GlobalClass.GenerateBytecode();
		this.defineClass(this.GlobalStaticClassName, b, 0, b.length);
	}

	private void AddClassBuilder(JClassBuilder ClassBuilder) {
		this.ByteCodeMap.put(ClassBuilder.ClassName, ClassBuilder);
	}

	JClassBuilder NewBuilder(String SourceFile, String ClassName, String SuperClassName) {
		JClassBuilder cb = new JClassBuilder(ACC_PUBLIC, SourceFile, ClassName, SuperClassName);
		this.AddClassBuilder(cb);
		return cb;
	}

	JClassBuilder GenerateMethodHolderClass(String SourceFile, String FuncName, MethodNode AsmMethodNode) {
		JClassBuilder HolderClass = new JClassBuilder(ACC_PUBLIC|ACC_FINAL, SourceFile, JLib.GetHolderClassName(this.NameSpace, FuncName), "java/lang/Object");
		this.AddClassBuilder(HolderClass);
		HolderClass.AddMethod(AsmMethodNode);
		return HolderClass;
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