package kaikeba.zhibo06;

import java.util.concurrent.*;

/**
 * @author: wenqiang
 * @date: 2020-06-04 12:17
 */
public class Ques1 {

    /**
     *
     *  常见的线程池有哪些
     *  1、单个线程的线程池
     *  2、固定线程数的线程池
     *  3、缓存线程池
     *  4、定时线程池
     *  5、自定义线程池
     *
     */

    public static void main(String[] args) {

        //单个线程的线程池
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

        //固定线程数线程池
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(10);

        //缓存线程池
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();

        //定时线程池
        ExecutorService scheduledExecutor = Executors.newScheduledThreadPool(10);

        //自定义线程池
        ExecutorService customizedExecutor = new ThreadPoolExecutor(10,20,3000L, TimeUnit.MICROSECONDS,new LinkedBlockingQueue<>(100));

    }
}
