package test.zen.generated;
import org.junit.Test;
import test.zen.NoExitSecurityManager;
import zen.main.ZenMain;
public class ArrayLiteralTest {
    @Test
    public void test() {
        System.setSecurityManager(new NoExitSecurityManager());
        ZenMain.ExecCommand(new String[] {"-l", "jvm", "test/zen/ArrayLiteral.zen"});
    }
}
