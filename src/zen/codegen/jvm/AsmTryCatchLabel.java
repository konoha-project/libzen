package zen.codegen.jvm;

import org.objectweb.asm.Label;

class AsmTryCatchLabel {
	public Label BeginTryLabel;
	public Label EndTryLabel;
	public Label FinallyLabel;
	public AsmTryCatchLabel() {
		this.BeginTryLabel = new Label();
		this.EndTryLabel = new Label();
		this.FinallyLabel = new Label();
	}
}