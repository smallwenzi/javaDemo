package com.yanwen.thead;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.function.Consumer;

/**
 *
 * @ClassName: SubAddThreadDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/4 3:18 下午
 **/
public class SubAddThreadDemo {
    static  int max=Integer.MAX_VALUE;
    public static void main(String args[]){
        Resource resource=new Resource();
        AddThread addThread=new AddThread(resource);
        SubThread subThread=new SubThread(resource);
       Thread a= new Thread(addThread,"A");
       a.start();
        Thread b=new Thread(addThread,"B");
       // b.start();
        new Thread(subThread,"X").start();
      // new Thread(subThread,"Y").start();
        //StringBuffer
      //  FileOutputStream
    }
}

class Resource {
    public volatile  int num=0;
    public volatile boolean flag=true; //加减切换
    //flag ==true表示可以进行加法操作，但是无法进行减法操作
    //flag=false 表示在减法操作，但是无法进行加法操作
    Consumer<Object> consumer=System.out::println;
    public synchronized void add() throws InterruptedException {

        while (this.flag == false) { //在减法操作 加法请等待
                super.wait();
            }
            Thread.sleep(100);
            this.num++;
            System.out.println("加法操作：" + Thread.currentThread().getName() + " number=" + this.num);
            this.flag = false;

                super.notifyAll();

    }

    public synchronized void sub() throws InterruptedException {
        while (this.flag == true) { //在加法操作 减法请等待
                super.wait();
            }
            Thread.sleep(200);
            this.num--;
            System.out.println("减法操作：" + Thread.currentThread().getName() + " number=" + this.num);
            this.flag = true;
            super.notifyAll();
    }
}

class AddThread implements Runnable{

    Resource resource;
    public AddThread(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run() {
            try {
               for(int i=1;i<SubAddThreadDemo.max;i++){
                    this.resource.add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

class SubThread  implements Runnable{

    Resource resource;
    public SubThread (Resource resource){
        this.resource=resource;
    }
    @Override
    public void run() {
            try {
                for(int i=1;i<SubAddThreadDemo.max;i++){
                    this.resource.sub();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}