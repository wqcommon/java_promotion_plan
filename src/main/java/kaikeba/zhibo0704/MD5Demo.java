package kaikeba.zhibo0704;

/**
 * @author: wenqiang
 * @date: 2020-07-03 22:57
 */
public class MD5Demo {

    public static void main(String[] args) {
        String info = HashFuncUtil.md5("abc");
        System.out.println("md5 msg:" + info);
    }

}
