package test.zen;

import zen.deps.Field;

public class ExitException extends SecurityException {
	@Field public int ExitStatus;
	public ExitException(int status) {
		this.ExitStatus = status;
	}

	private static final long serialVersionUID = 1L;

}
