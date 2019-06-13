package aop.aspectj;

/**
 * @author: wenqiang
 * @date: 2019-05-13 11:04
 *
 */
public aspect HelloAspect {

    pointcut helloworldPointcut(): call(* aop.aspectj.MyService.sayHello());

    before():helloworldPointcut(){
        System.out.println("before");
    }

    after():helloworldPointcut(){
        System.out.println("end");
    }
}
