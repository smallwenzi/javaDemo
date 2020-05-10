package com.yanwen.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @ClassName: ConsumerTest
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/2 8:06 下午
 **/
public class ConsumerTest {
    public static void main(String args[]){
        Consumer<Object> consumer=System.out::println;
        consumer.accept("2222");
        Supplier supplier="msdn"::toUpperCase;
        consumer.accept(supplier.get());
        Function<String,Boolean> function="HelloWorld"::startsWith;
        consumer.accept(function.apply("H"));
        Predicate<String> predicate="Hello"::equals;
        consumer.accept(predicate.test("Hello"));
    }
}
