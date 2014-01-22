package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.V1_6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

class JClassBuilder /*implements Opcodes */{
	final int ClassQualifer;
	final String SourceFile;
	final String ClassName;
	final String SuperClassName;
	final ArrayList<MethodNode> MethodList = new ArrayList<MethodNode>();
	final ArrayList<FieldNode> FieldList = new ArrayList<FieldNode>();

	JClassBuilder(int ClassQualifer, String SourceFile, String ClassName, String SuperClass) {
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

	void OutputClassFile(String className, String dir) {
		byte[] ba = this.GenerateBytecode();
		File file = new File(dir, this.ClassName + ".class");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(ba);
			fos.close();
		}
		catch(IOException e) {
			//LibZen.VerboseException(e);
		}
	}

}