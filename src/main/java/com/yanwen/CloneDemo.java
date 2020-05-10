package com.yanwen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @ClassName: CloneDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/5 9:48 下午
 **/
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Member member=new Member("A");
        Member member1= (Member) member.clone();
        System.out.println(member);
        member.setName("C");
        System.out.println(member1);
        //Arrays.sort(new Object[],(obj1,obj2)->{});
    }
}


class Member implements Cloneable{
    private String name;
    public Member(String name){
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return super.toString()+":name="+this.name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}