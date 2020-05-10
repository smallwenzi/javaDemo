package com.yanwen.thead;/**
 * @author tanyanwen
 * @since 2020/5/2 8:43 下午
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @ClassName: ThreadDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/2 8:43 下午
 **/
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable=new RunnableImpl();
        //未设置名字
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        //设置名字
        new Thread(runnable,"测试Runnable").start();
        FutureTask<String> futureTask=new FutureTask<String>(new CallableImpl());
        new Thread(futureTask,"测试futureTask").start();
        System.out.println(futureTask.get());
       // Object
    }
}

class RunnableImpl implements  Runnable{

    @Override
    public void run() {
        System.out.println("执行线程"+Thread.currentThread().getName());
    }
}

class CallableImpl implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("执行线程"+Thread.currentThread().getName());
        return "线程执行完毕";
    }
}