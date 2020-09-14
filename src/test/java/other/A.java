package other;

/**
 * @author: wenqiang
 * @date: 2020-04-26 15:27
 */
public class A {

    public static B b = new B();
    static {
        System.out.println("aa==" + b);
        System.out.println("aaaaaa");
    }

    public A(){
        System.out.println("A");
    }
}
