package com.yanwen;/**
 * @author tanyanwen
 * @since 2020/5/5 10:15 下午
 */

/**
 *
 * @ClassName: MathUtil
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/5 10:15 下午
 **/
public class MathUtil {
    private MathUtil(){};

    /**
     * 自定义四舍五入
     * @param num
     * @param scale
     * @return
     */
    public static double round(double num,int scale){
        return Math.round(num* Math.pow(10,scale))/Math.pow(10,scale);
    }

    public static void main(String[] args) {
        System.out.println(round(19.8673,2));
        System.out.println(round(19.8673,3));
        System.out.println(round(19.8673,1));
    }
}
