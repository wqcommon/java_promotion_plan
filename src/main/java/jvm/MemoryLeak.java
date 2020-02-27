package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-11-19 11:49
 *
 * 内存泄漏
 */
public class MemoryLeak {

    static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            Object o = new Object();
            list.add(o);
            o = null;
        }
       list.forEach(o -> {
           System.out.println(o);
       });
    }
}
