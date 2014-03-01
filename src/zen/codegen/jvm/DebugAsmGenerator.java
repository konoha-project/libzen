package zen.codegen.jvm;

import zen.util.LibZen;

public class DebugAsmGenerator extends JavaAsmGenerator {
	public DebugAsmGenerator() {
		LibZen.DebugMode = true;
	}
}
