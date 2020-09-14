package kaikeba.zhibo0711;

/**
 * @author: wenqiang
 * @date: 2020-07-11 22:08
 */
public class Service {

    private Service2 service2 = new Service2();

    public void doOne(String name){
        System.out.println("doone"+"," + Util.get() + "," + name);
        //dosoming
        service2.doSecond(name);
    }
}
