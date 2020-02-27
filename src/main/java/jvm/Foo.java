package jvm;

/**
 * @author: wenqiang
 * @date: 2019-10-23 11:25
 */
public class Foo {

    public static void main(String[] args) {
        boolean flag = true;
        if (flag) System.out.println("Hello, Java!");
        if (flag == true) System.out.println("Hello, JVM!");
    }
}
