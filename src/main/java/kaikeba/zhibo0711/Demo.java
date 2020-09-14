package kaikeba.zhibo0711;

/**
 * @author: wenqiang
 * @date: 2020-07-11 21:28
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        new Syn().test();
    }

    public void demo() throws InterruptedException {
        Object o = new Object();
        o.wait();
    }

    static class Syn{

        public synchronized void test() throws InterruptedException {
            this.wait();
            System.out.println("ddddddd");
        }
    }
}
