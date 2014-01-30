package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.V1_6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import zen.deps.LibNative;

class AsmClassBuilder {
	final int ClassQualifer;
	final String SourceFile;
	final String ClassName;
	final String SuperClassName;
	final ArrayList<MethodNode> MethodList = new ArrayList<MethodNode>();
	final ArrayList<FieldNode> FieldList = new ArrayList<FieldNode>();

	AsmClassBuilder(int ClassQualifer, String SourceFile, String ClassName, String SuperClass) {
		this.ClassQualifer = ClassQualifer;
		this.SourceFile = SourceFile;
		this.ClassName = ClassName;
		this.SuperClassName = SuperClass;
	}

	void AddMethod(MethodNode m) {
		for(int i=0; i<this.MethodList.size(); i++) {
			MethodNode node = this.MethodList.get(i);
			if(node.name.equals(m.name) && node.desc.equals(m.desc)) {
				this.MethodList.set(i, m);
				return;
			}
		}
		this.MethodList.add(m);
	}

	void AddField(FieldNode m) {
		this.FieldList.add(m);
	}

	byte[] GenerateBytecode() {
		ClassWriter Visitor = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		Visitor.visit(V1_6, this.ClassQualifer, this.ClassName, null, this.SuperClassName, null);
		Visitor.visitSource(this.SourceFile, null);
		for(FieldNode f : this.FieldList) {
			f.accept(Visitor);
		}
		for(MethodNode m : this.MethodList) {
			m.accept(Visitor);
		}
		Visitor.visitEnd();
		return Visitor.toByteArray();
	}


	Method GetDefinedMethod(ClassLoader ClassLoader, String FuncName) {
		try {
			Class<?> DefinedClass = ClassLoader.loadClass(this.ClassName);
			Method[] DefinedMethods = DefinedClass.getMethods();
			for(Method m : DefinedMethods) {
				if(m.getName().equals(FuncName)) {
					return m;
				}
			}
		} catch(Exception e) {
			LibNative.FixMe(e);
		}
		return null;
	}

	void OutputClassFile() {  // This is used for debug
		byte[] ba = this.GenerateBytecode();
		System.out.println("*debug info*: generating" + this.ClassName + ".class");
		System.out.println("*debug info*: check it out with javap -c " + this.ClassName + ".class");
		File file = new File(this.ClassName + ".class");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(ba);
			fos.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

}