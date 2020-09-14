package jdk8;

import java.util.function.Consumer;

/**
 * @author: wenqiang
 * @date: 2020-08-24 11:02
 */
public class MethodRefence {

    public static void main(String[] args) {

        Consumer<String> consumer = System.out::println;
        consumer = consumer.andThen(Utils::convertStr);
        consumer.accept("wenqiang");
    }
}
