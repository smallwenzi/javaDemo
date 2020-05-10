package com.yanwen.function;

/**
 * @author tanyanwen
 * @since 2020/5/2 7:59 下午
 */
@FunctionalInterface
 interface IFunction{
    public int send();
}

public class  FunctionImpl{
    public static void main(String[] args) {
      final int a=10;
        IFunction function=()-> {
            System.out.println("问问");

            System.out.println("seee"+a);
            return a+1;
        };
        int b=function.send();
        System.out.println("seee"+b);
    }
}

