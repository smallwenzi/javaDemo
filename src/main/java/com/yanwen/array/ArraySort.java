package com.yanwen.array;

import java.util.Arrays;
import java.util.Random;

/**
 *
 */
public class ArraySort {

    public static void main(String[] args){
      int max=10;
        for(int i=1;i<=max;i++) {
            int[] array = createArray(i, 50);
            // 冒泡排序
            //bubbleSortAsc(array);
          //  insertionSortAsc(array);
            System.out.print("jdk 自带排序:");
            //jdk 自带排序
            Arrays.sort(array);
            print(array);
        }


       //选择排序
       // selectionSortAsc(array);
        //插入排序
      // insertionSortAsc(array);
    }

    public static int fn(int n){

            return n*(n-1)/2;


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
    /**
     * 整型数组 冒泡排序（按从小到大排序）
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     *
     比较相邻的元素。如果第一个比第二个大，就交换他们两个。

                 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。

                 针对所有的元素重复以上的步骤，除了最后一个。

                 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

     *
     *  冒泡排序一共要进行(n-1)次循环,每一次循环都要进行当前n-1次比较
     * 所以一共的比较次数是:
     * (n-1) + (n-2) + (n-3) + … + 1 = n*(n-1)/2;
     *  所以冒泡排序的时间复杂度是 O(n2)
     *
     *      冒泡排序的临时变量所占空间不随处理数据n的大小改变而改变，则空间复杂度为O(1)
     *
     * @param array
     */
    public static void bubbleSortAsc(int[] array){
        if(array==null){
            return;
        }
        int cycle=0;
        for(int i=0;i<array.length;i++){
            for(int x=0;x<array.length-i-1;x++){
                if(array[x]>array[x+1]){
                    int temp=array[x];
                    array[x]=array[x+1];
                    array[x+1]=temp;
                }
                cycle++;
            }


        }
        System.out.println("length:"+array.length+":cycle="+cycle+":时间复杂度"+(array.length*(array.length-1)/2));
        System.out.print("排序后数组：");
        print(array);
    }


    /**
     * 选择排序（按从小到大排序）
     * 最佳情况：T(n) = O(n2) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
     *  假设待排序的序列有 N 个元素，
     *  则比较次数永远都是N (N - 1) / 2。
     *  而移动次数与序列的初始排序有关。
     *  当序列正序时，移动次数最少，为 0。
     *  当序列反序时，移动次数最多，为3N (N - 1) /  2。
     *
     *  选择排序的基本思想：给定数组：int[] arr={里面n个数据}；
     *  第1趟排序，在待排序数据arr[1]~arr[n]中选出最小的数据，将它与arrr[1]交换；
     *  第2趟，在待排序数据arr[2]~arr[n]中选出最小的数据，将它与r[2]交换；
     *  以此类推，第i趟在待排序数据arr[i]~arr[n]中选出最小的数据，将它与r[i]交换，直到全部排序完成。
     */
    public static void selectionSortAsc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.print("排序后数组：");
   print(array);
    }



    /**
     * 插入排序（按从小到大排序）
     * 最佳情况：T(n) = O(n) 最坏情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
     *
     * 插入排序（英语：Insertion Sort）是一种简单直观的排序算法。
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     */

    public static void insertionSortAsc(int[] array) {
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        System.out.print("排序后数组：");
       print(array);
    }



}
