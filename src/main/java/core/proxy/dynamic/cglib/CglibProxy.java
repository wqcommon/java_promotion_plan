package core.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: wenqiang
 * @date: 2019-05-09 17:40
 *
 */
public class CglibProxy implements MethodInterceptor {

    private Object targetObj;

    public <T> T getInstance(Object targetObj){
        this.targetObj = targetObj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetObj.getClass());
        enhancer.setCallback(this);
        return (T)enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
//        Object o = proxy.invoke(targetObj, args);
//        Object o = method.invoke(targetObj, args);
        Object o = proxy.invokeSuper(obj,args);
        after();
        return o;
    }

    private void before(){
        System.out.println("before.......");
    }

    private void after(){
        System.out.println("after.......");
    }
}
