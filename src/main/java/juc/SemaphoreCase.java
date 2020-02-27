package juc;

import java.util.concurrent.Semaphore;

/**
 * @author: wenqiang
 * @date: 2019-07-10 18:13
 */
public class SemaphoreCase {

    private final static Semaphore limit = new Semaphore(4);

    public static void main(String[] args) {

        Thread A = ThreadFactory.createThread("A",new OrderTask(limit,20000));
        Thread B = ThreadFactory.createThread("B",new OrderTask(limit,30000));
        Thread C = ThreadFactory.createThread("C",new OrderTask(limit,10000));
        Thread D = ThreadFactory.createThread("D",new OrderTask(limit,15000));
        Thread E = ThreadFactory.createThread("E",new OrderTask(limit,18000));
        Thread F = ThreadFactory.createThread("F",new OrderTask(limit,21000));

        A.start();
        B.start();
        C.start();
        D.start();
        E.start();
        F.start();

        while (true){
        }
    }

    private static class OrderTask implements Runnable{

        private Semaphore semaphore;

        private long handleTime;

        public OrderTask(Semaphore semaphore,long handleTime){
            this.semaphore = semaphore;
            this.handleTime = handleTime;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "正在处理任务");
                Thread.sleep(handleTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
    }


    private static class ThreadFactory{

        public static Thread createThread(String threadName,Runnable task){
            Thread t = new Thread(task,threadName);
            return t;
        }
    }


}
