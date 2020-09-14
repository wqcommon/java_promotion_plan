package other;

/**
 * @author: wenqiang
 * @date: 2020-04-26 15:28
 */
public class B {

    public static A a = new A();

    public static int cst = 5;
    static {
        System.out.println("bb==" + a);
        System.out.println("bbbbb");
    }

    public B(){
        System.out.println(cst);
        System.out.println("B");
    }
}
