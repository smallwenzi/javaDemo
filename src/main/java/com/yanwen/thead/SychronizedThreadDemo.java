package com.yanwen.thead;

import java.util.function.Consumer;

/**
 *  资源共享同步问题
 * @ClassName: SychronizedThreadDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/4 3:09 下午
 **/
public class SychronizedThreadDemo {
    public static void main(String args[]){
        SellTicket sellTicket=new SellTicket();
        new Thread(sellTicket,"A").start();
        new Thread(sellTicket,"B").start();
        new Thread(sellTicket,"C").start();
    }
}


class SellTicket implements Runnable{
    private  volatile int ticket=100;


    @Override
    public void run() {
        Consumer<Object> consumer=System.out::println;
        while(true){
        synchronized (this) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumer.accept("售票员" + Thread.currentThread().getName() + ",票剩余" + (ticket--));
            } else {
                consumer.accept("票卖光了");
                break;
            }
        }
        }
    }
}