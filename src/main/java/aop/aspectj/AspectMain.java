package aop.aspectj;

/**
 * @author: wenqiang
 * @date: 2019-05-13 11:03
 */
public class AspectMain {

    public static void main(String[] args) {
        MyService myService = new MyService();
        myService.sayHello();
    }
}
