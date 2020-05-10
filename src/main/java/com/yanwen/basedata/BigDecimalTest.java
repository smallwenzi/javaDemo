package com.yanwen.basedata;

import java.math.BigDecimal;

/**
 * 推荐 字符串赋值 BigDecimal
 *    BigDecimal b=new BigDecimal("0.1");
 *         System.out.println(b);
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b=new BigDecimal("0.1");
        System.out.println(b);
    }
}
