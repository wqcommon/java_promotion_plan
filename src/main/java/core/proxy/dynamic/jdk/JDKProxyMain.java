package core.proxy.dynamic.jdk;

/**
 * @author: wenqiang
 * @date: 2019-05-08 18:18
 */
public class JDKProxyMain {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Subject subject = new SubjectImpl();
        JDKProxy jdkProxy = new JDKProxy();
        Subject proxy = jdkProxy.newProxy(subject);
        proxy.sayHi();
    }
}
