package com.yanwen;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 * 非公平锁
 *
 *
 * 阻塞式
 *
 * 在使用阻塞等待获取锁的方式中，必须在 try 代码块之外，并且在加锁方法与 try 代
 * 码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在 finally 中无法解锁。
 * 说明一：如果在 lock 方法与 try 代码块之间的方法调用抛出异常，那么无法解锁，造成其它线程无法成功
 * 获取锁。
 * 说明二：如果 lock 方法在 try 代码块之内，可能由于其它方法抛出异常，导致在 finally 代码块中，
 * unlock 对未加锁的对象解锁，它会调用 AQS 的 tryRelease 方法（取决于具体实现类），抛出
 * IllegalMonitorStateException 异常。
 * 说明三：在 Lock 对象的 lock 方法实现中可能抛出 unchecked 异常，产生的后果与说明二相同。
 */
public class LockTest {
    private final static Lock lock=new ReentrantLock();

    public static void main(String[] args) {
        try{
            lock.tryLock();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //有可能抛出异常
            lock.unlock();
        }
    }
}
