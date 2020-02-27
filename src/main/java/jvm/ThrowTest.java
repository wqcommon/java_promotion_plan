package jvm;

/**
 * @author: wenqiang
 * @date: 2019-10-30 16:48
 */
public class ThrowTest {

    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        for (int i = 0; i < 100; i++) {
            try {
                tryBlock = 0;
                if (i < 50) {
                    continue;
                } else if (i < 80) {
                    break;
                } else {
                    return;
                }
            } catch (Exception e) {
                catchBlock = 1;
            } finally {
                finallyBlock = 2;
            }
        }
        methodExit = 3;
    }
}
