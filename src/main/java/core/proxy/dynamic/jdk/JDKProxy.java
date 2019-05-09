package core.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: wenqiang
 * @date: 2019-05-08 18:08
 */
public class JDKProxy implements InvocationHandler {

    private Object targetObject;

    public <T> T newProxy(Object targetObject){
        this.targetObject = targetObject;
        return (T) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(targetObject,args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }
}
