package test.zen.generated;
import org.junit.Test;
import zen.main.ZenMain;
public class EscapedStringLiteralTest {
    @Test
    public void test() {
        ZenMain.ExecCommand(new String[] {"-l", "jvm", "test/zen/Assign.zen"});
    }
}
