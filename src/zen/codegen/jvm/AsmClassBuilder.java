package zen.codegen.jvm;

import static org.objectweb.asm.Opcodes.V1_6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import zen.type.ZFuncType;
import zen.type.ZType;
import zen.util.LibZen;
import zen.util.Var;

class AsmClassBuilder {
	final AsmJavaGenerator Generator;
	final int ClassQualifer;
	final String SourceFile;
	final String ClassName;
	final String SuperClassName;
	final ArrayList<MethodNode> MethodList = new ArrayList<MethodNode>();
	final ArrayList<FieldNode> FieldList = new ArrayList<FieldNode>();

	AsmClassBuilder(AsmJavaGenerator Generator, int ClassQualifer, String SourceFile, String ClassName, String SuperClass) {
		this.Generator = Generator;
		this.ClassQualifer = ClassQualifer;
		this.SourceFile = SourceFile;
		this.ClassName = ClassName;
		this.SuperClassName = SuperClass;
	}

	void AddField(int acc, String Name, ZType zType, Object Value) {
		@Var FieldNode fn = new FieldNode(acc, Name, Type.getDescriptor(this.Generator.GetJavaClass(zType)), null, Value);
		this.FieldList.add(fn);
	}

	void AddField(int acc, String Name, Class<?> FieldClass, Object Value) {
		@Var FieldNode fn = new FieldNode(acc, Name, Type.getDescriptor(FieldClass), null, Value);
		this.FieldList.add(fn);
	}

	AsmMethodBuilder NewMethod(int acc, String Name, String Desc) {
		@Var AsmMethodBuilder MethodBuilder = new AsmMethodBuilder(acc, Name, Desc, this.Generator);
		this.MethodList.add(MethodBuilder);
		return MethodBuilder;
	}

	AsmMethodBuilder NewMethod(int acc, String Name, ZFuncType FuncType) {
		return this.NewMethod(acc, Name, this.Generator.GetMethodDescriptor(FuncType));
	}



	byte[] GenerateBytecode() {
		@Var ClassWriter Visitor = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
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
			@Var Class<?> DefinedClass = ClassLoader.loadClass(this.ClassName);
			@Var Method[] DefinedMethods = DefinedClass.getMethods();
			for(Method m : DefinedMethods) {
				if(m.getName().equals(FuncName)) {
					return m;
				}
			}
		} catch(Exception e) {
			LibZen._FixMe(e);
		}
		return null;
	}

	void OutputClassFile() {  // This is used for debug
		@Var byte[] ba = this.GenerateBytecode();
		System.err.println("*debug info*: generating " + this.ClassName + ".class");
		System.err.println("*debug info*: check it out with javap -c " + this.ClassName + ".class");
		@Var File file = new File(this.ClassName + ".class");
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