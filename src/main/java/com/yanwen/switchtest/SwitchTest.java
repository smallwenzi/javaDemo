package com.yanwen.switchtest;

/**
 * 抛出异常
 *
 * switch(param) 调用了String的HashCode方法
 *
 * switch方法只支持int类型的匹配
 * 其他疾病数据类型都是会被语法糖转换为整型来做判断和匹配
 *
 * enum 也是
 * enum会调用其ordinal方法来剥去语法糖，转化为int 类型的比较方式
 * 对String 或enum类型的switch 变量类型，要预先进行null判断，
 * 避免抛出NPE
 */
public class SwitchTest
{
    public static void main(String[] args) {
        String param=null;
        switch (param){
            case "null":
                System.out.print("null");
                break;
            default:
                System.out.print("default");
        }
    }
}
