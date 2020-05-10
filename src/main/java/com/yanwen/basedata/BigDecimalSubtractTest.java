package com.yanwen.basedata;

import java.math.BigDecimal;

/**
 * 使用 BigDecimal 来定义值，再进行浮点数的运算操作。
 */
public class BigDecimalSubtractTest {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal("0.8");
        BigDecimal b=new BigDecimal("0.7");
        BigDecimal c=new BigDecimal("0.6");

        if(a.subtract(b).equals(b.subtract(c))){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
