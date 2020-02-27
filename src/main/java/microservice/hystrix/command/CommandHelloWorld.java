package microservice.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author: wenqiang
 * @date: 2019-10-14 11:07
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private String name;

    public CommandHelloWorld(String name){
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        System.out.println("Hello" + name + "!");
        return "Hello" + name + "!";
    }

}
