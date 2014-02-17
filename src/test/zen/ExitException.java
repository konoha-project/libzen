package test.zen;

public class ExitException extends SecurityException {
	public int ExitStatus;
	public ExitException(int status) {
		this.ExitStatus = status;
	}

	private static final long serialVersionUID = 1L;

}
