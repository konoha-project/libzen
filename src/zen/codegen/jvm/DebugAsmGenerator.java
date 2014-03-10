package zen.codegen.jvm;

import zen.util.LibZen;

public class DebugAsmGenerator extends AsmJavaGenerator {
	public DebugAsmGenerator() {
		LibZen.DebugMode = true;
	}
}
