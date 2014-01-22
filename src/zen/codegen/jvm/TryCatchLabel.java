package zen.codegen.jvm;

import org.objectweb.asm.Label;

class TryCatchLabel {
	public Label beginTryLabel;
	public Label endTryLabel;
	public Label finallyLabel;
	public TryCatchLabel() {
		this.beginTryLabel = new Label();
		this.endTryLabel = new Label();
		this.finallyLabel = new Label();
	}
}