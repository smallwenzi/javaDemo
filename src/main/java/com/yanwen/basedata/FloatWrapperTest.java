package com.yanwen.basedata;

/**
 *
 * false
 */
public class FloatWrapperTest {
    public static void main(String[] args) {
        Float a=Float.valueOf(1.0f-0.9f);
        Float b=Float.valueOf(0.9f-0.8f);
        System.out.println("a="+a+",b="+b);
        if(a.equals(b)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        System.out.println("i =" + Integer.toBinaryString(Float.floatToIntBits(a)));
        System.out.println("i =" + Integer.toBinaryString(Float.floatToIntBits(b)));
    }
}
