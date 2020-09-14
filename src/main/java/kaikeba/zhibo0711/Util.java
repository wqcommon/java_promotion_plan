package kaikeba.zhibo0711;

/**
 * @author: wenqiang
 * @date: 2020-07-11 22:14
 */
public class Util {

    //线程副本
    private final static ThreadLocal<String> reqIdThreadLocal = new ThreadLocal<>();

    public static void set(String val){
        reqIdThreadLocal.set(val);
    }

    public static String get(){
        return reqIdThreadLocal.get();
    }
}
