package other;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * @author: wenqiang
 * @date: 2020-02-08 14:39
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<>(true);
        Thread t1 = new Thread("thread1"){
            @Override
            public void run() {
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        Thread  t2  = new Thread("thread2"){
            @Override
            public void run() {
                try {
                    queue.put(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
         t2.start();

         Thread.sleep(10000);

        System.out.println("1111");

    }

    public String simplifyPath(String path) {
        String[] pathStrs = path.split("/");
        LinkedList<String> retList =  new LinkedList<>();
        for(String pathStr : pathStrs){
            if("".equals(pathStr) || ".".equals(pathStr)){
                continue;
            }
            if("..".equals(pathStr)){
                if(retList.isEmpty()){
                    continue;
                }else{
                    retList.removeLast();
                }

            }else{
                retList.addLast(pathStr);
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(String str : retList){
            sb.append(str).append("/");
        }
        return sb.length() > 1 ? sb.substring(0,sb.length() - 1) : sb.toString();
    }
}
