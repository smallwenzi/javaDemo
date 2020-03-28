package com.yanwen.array;

import java.util.Random;

public class ArraySort1 {
    public static void main(String[] args) {

        for (int i = 2; i <= 10; i++) {
            int[] array = createArray(i, 50);
            // 冒泡排序
            //bubbleSortAsc(array);
            insertionSortAsc(array);
        }

        //选择排序
        // selectionSortAsc(array);
        //插入排序
        // insertionSortAsc(array);
    }

    public static int fn(int n) {

        return n * (n - 1) / 2;


    }

    /**
     * 创建一个数组
     *
     * @param length
     * @param max
     * @return
     */
    public static int[] createArray(int length, int max) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(max);
        }
        System.out.print("源数组：");
        print(array);
        return array;
    }

    public static void print(int[] array) {
        for (int temp : array) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static void selectionSortAsc(int[] array){
        for(int index=0;index<array.length;index++){
            int minIndex=index;
            for(int index_j=index;index_j<array.length;index_j++){
                if(array[minIndex]> array[index_j]){
                    minIndex=index_j;
                }
            }
            int temp=array[minIndex];
            array[minIndex]=array[index];
            array[index]=temp;
        }
        System.out.print("排序后数组：");
        print(array);
    }

    public static void insertionSortAsc(int[] array){
        //int current=0;
        for(int index=0;index<array.length-1;index++){
            int current=array[index+1];
            int index_j=index;
            for(;index_j>=0&& current<array[index_j];index_j--){
                    array[index_j+1]=array[index_j];
            }
            array[index_j+1]=current;
        }
        System.out.print("排序后数组：");
        print(array);
    }
}