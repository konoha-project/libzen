package zen.codegen.jvm;

import java.util.HashMap;

import org.objectweb.asm.Type;

import zen.ast.ZNode;
import zen.util.LibZen;
import zen.util.Var;

class AsmClassLoader extends ClassLoader {
	private final HashMap<String,AsmClassBuilder> ClassBuilderMap = new HashMap<String, AsmClassBuilder>();
	private final AsmJavaGenerator Generator;

	public AsmClassLoader(AsmJavaGenerator Generator) {
		this.Generator = Generator;
	}

	AsmClassBuilder NewClass(int ClassQualifer, ZNode Node, String ClassName, String SuperClass) {
		@Var String SourceFile = null;
		if(Node != null && Node.SourceToken != null) {
			SourceFile = Node.SourceToken.GetFileName();
		}
		AsmClassBuilder ClassBuilder = new AsmClassBuilder(this.Generator, ClassQualifer, SourceFile, ClassName, SuperClass);
		this.ClassBuilderMap.put(ClassName, ClassBuilder);
		return ClassBuilder;
	}

	AsmClassBuilder NewClass(int ClassQualifer, ZNode Node, String ClassName, Class<?> SuperClass) {
		return this.NewClass(ClassQualifer, Node, ClassName, Type.getInternalName(SuperClass));
	}

	@Override protected Class<?> findClass(String name) {
		//System.err.println("loading .. " + name);
		AsmClassBuilder ClassBuilder = this.ClassBuilderMap.get(name);
		if(ClassBuilder != null) {
			byte[] b = ClassBuilder.GenerateBytecode();
			if(LibZen.DebugMode) {
				ClassBuilder.OutputClassFile();
			}
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
			LibZen._Exit(1, "generation failed: " + ClassName);
		}
		return null;
	}

}