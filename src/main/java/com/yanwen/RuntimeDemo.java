package com.yanwen;/**
 * @author tanyanwen
 * @since 2020/5/5 8:52 下午
 */

import javax.management.relation.RoleUnresolved;

/**
 *
 * @ClassName: RuntimeDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/5 8:52 下午
 **/
public class RuntimeDemo {
    public static void main(String args[]){
        Runtime runtime=Runtime.getRuntime();
        System.out.println((runtime.maxMemory()/1024/1024)+"："+ Runtime.version().toString()
                +"："+runtime.availableProcessors()+":"+(runtime.freeMemory()/1024/1024)
        +":"+(runtime.totalMemory()/1024/1024));
        long start=System.currentTimeMillis();
        for(int i=0;i<Integer.MAX_VALUE;i++){

        }
        System.gc();
        System.out.println((System.currentTimeMillis()-start));
    }
}
