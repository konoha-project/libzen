package test.zen;

import java.security.Permission;

public class NoExitSecurityManager extends SecurityManager  {
	@Override
	public void checkPermission(Permission perm) {
		/* do nothing */
	}

	@Override
	public void checkPermission(Permission perm, Object context) {
		/* do nothing */
	}

	@Override
	public void checkExit(int status) {
		super.checkExit(status);
		throw new ExitException(status);
	}
}