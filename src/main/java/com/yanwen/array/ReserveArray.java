package com.yanwen.array;

import java.util.Random;

public class ReserveArray {
    public static  void main(String[] args){
        int max=10;
        for(int i=1;i<=max;i++) {
            int[] array = createArray(i, 50);
            //reserveArray(array);
            reserveArray3(array);

        }
    }

    public static void reserveArray(int[] array){

        int[] temp=new int[array.length];
        int length=array.length-1;
        for(int index=0;index<array.length;index++){
            temp[length--]=array[index];
        }
        array=temp;
        System.out.print("定义临时数组 反转数组：");
        print(array);
    }

    public static void reserveArray2(int[] array){
        //int[] temp=new int[array.length];
        int length=array.length;
        for(int index=0;index<length/2;index++){
           int temp=array[length-1-index];
           array[length-1-index]=array[index];
           array[index]=temp;
        }
        System.out.print("定义变量 反转数组：");
        print(array);
    }

    public static void reserveArray3(int[] array){
        //int[] temp=new int[array.length];
        int length=array.length;
        for(int index=0;index<length/2;index++){
            array[index]=array[index]^array[length-1-index];
            array[length-1-index]=array[index]^array[length-1-index];
            array[index]=array[index]^array[length-1-index];
        }
        System.out.print("不定义变量 反转数组：");
        print(array);
    }



    /**
     * 创建一个数组
     * @param length
     * @param max
     * @return
     */
    public static int[] createArray(int length,int max){
        int[] array=new int[length];
        Random random=new Random();
        for(int i=0;i<length;i++){
            array[i]=random.nextInt(max);
        }
        System.out.print("源数组：");
        print(array);
        return array;
    }

    public static void print(int[] array){
        for(int temp:array){
            System.out.print(temp+" ");
        }
        System.out.println();
    }
}
