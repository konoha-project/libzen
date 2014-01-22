package zen.codegen.jvm;

final class SoftwareFaultException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SoftwareFaultException(String Message) {
		super(Message);
	}
}