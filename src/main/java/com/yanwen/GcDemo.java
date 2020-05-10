package com.yanwen;

import java.lang.ref.Cleaner;

/**
 *
 * @ClassName: GcDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/5 9:29 下午
 **/
public class GcDemo {
    public static void main(String[] args) {
        Test test=new Test();
        test=null;
        System.gc();
        System.out.println("执行完毕");

        try(CleaDemoCleaning cleaDemoCleaning
                    =new CleaDemoCleaning()){

        }catch(Exception e){

        }
       // Object
    }
}

class Test {
    public Test(){
        System.out.println("创建一个类");
    }

    @Override
    protected void finalize() throws Throwable {
       System.out.println("销毁");
       throw new Exception("销毁异常");
    }

}

class CleanDemo implements Runnable{
    public CleanDemo(){
        System.out.println("创建一个CleanDemo类");
    }
    @Override
    public void run() {
        System.out.println("销毁对象CleanDemo");
    }
}


class CleaDemoCleaning implements AutoCloseable{
    // A cleaner, preferably one shared within a library
    private static final Cleaner cleaner = Cleaner.create();
    private  CleanDemo cleanDemo;
    private  Cleaner.Cleanable cleanable;
    public  CleaDemoCleaning(){
        cleanDemo=new CleanDemo();
        cleanable=cleaner.register(this,cleanDemo);
    }
    @Override
    public void close() throws Exception {
       cleanable.clean();
    }
}