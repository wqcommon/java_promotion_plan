package kaikeba.zhibo0704;

/**
 * @author: wenqiang
 * @date: 2020-07-03 23:05
 */
public class SHA256Demo {

    public static void main(String[] args) {
        String info = HashFuncUtil.sha256("abc");
        System.out.println("sha msg:" + info);
    }
}
