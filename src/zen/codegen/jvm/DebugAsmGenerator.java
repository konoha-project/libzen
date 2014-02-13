package zen.codegen.jvm;

import zen.deps.LibZen;

public class DebugAsmGenerator extends JavaAsmGenerator {
	public DebugAsmGenerator() {
		LibZen.DebugMode = true;
	}
}
