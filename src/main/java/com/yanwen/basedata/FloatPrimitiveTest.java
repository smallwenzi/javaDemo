package com.yanwen.basedata;

/**
 * false
 */
public class FloatPrimitiveTest {
    public static void main(String[] args) {
        float a=1.0f-0.9f;
        float b=0.9f-0.8f;
        System.out.println("a="+a+",b="+b);
        if(a==b){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        System.out.println("i =" + Integer.toBinaryString(Float.floatToIntBits(a)));
        System.out.println("i =" + Integer.toBinaryString(Float.floatToIntBits(b)));
    }
}
