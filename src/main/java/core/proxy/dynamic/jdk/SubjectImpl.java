package core.proxy.dynamic.jdk;

/**
 * @author: wenqiang
 * @date: 2019-05-08 18:06
 */
public class SubjectImpl implements Subject{
    @Override
    public void sayHi() {
        System.out.println("sayHi");
    }

    @Override
    public void sayHello() {
        System.out.println("sayHello");
    }
}
