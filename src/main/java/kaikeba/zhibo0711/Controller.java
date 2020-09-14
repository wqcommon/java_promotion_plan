package kaikeba.zhibo0711;

/**
 * @author: wenqiang
 * @date: 2020-07-11 22:07
 */
public class Controller {

    public static void main(String[] args) throws InterruptedException {

        final Controller controller = new Controller();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                controller.accReq("1","wq001",100);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                controller.accReq("2","wq002",110);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private Service service = new Service();


    public void accReq(String reqId,String name,int age){
        System.out.println("accReq"+"," + reqId  + "，" + name + "," + age);
        Util.set(reqId);
        service.doOne(name);
    }
}
