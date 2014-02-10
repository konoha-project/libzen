package zen.deps;

public final class SoftwareFaultException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SoftwareFaultException(String Message) {
		super(Message);
	}
}