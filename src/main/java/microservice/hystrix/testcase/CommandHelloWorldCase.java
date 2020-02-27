package microservice.hystrix.testcase;

import microservice.hystrix.command.CommandHelloWorld;
import rx.Observable;

import java.util.concurrent.Future;

/**
 * @author: wenqiang
 * @date: 2019-10-14 11:18
 */
public class CommandHelloWorldCase {

    public static void main(String[] args) {
        CommandHelloWorld command = new CommandHelloWorld("WQ");
        command.execute();
    }


    private static void testFuture(){
        Future<String> s = new CommandHelloWorld("Bob").queue();
    }

    private static void testObservable(){
        Observable<String> s = new CommandHelloWorld("Bob").observe();
    }
}
