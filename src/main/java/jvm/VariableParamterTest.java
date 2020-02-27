package jvm;

/**
 * @author: wenqiang
 * @date: 2019-10-28 10:29
 *
 * 可变参数重载
 */
public class VariableParamterTest {

    public static void main(String[] args) {

        VariableParamterTest t = new VariableParamterTest();
        t.invoke(null,1);
        t.invoke(null,1,2);
        t.invoke(null,new Object[]{1});
    }

    public void invoke(Object obj,Object... args){
        System.out.println("invoke1");
    }

    public void invoke(String obj1,Object obj,Object... args){
        System.out.println("invoke2");
    }
}
