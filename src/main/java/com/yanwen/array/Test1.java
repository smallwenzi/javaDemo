package com.yanwen.array;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(5,new int[]{10,4,8,7,3}));
        System.out.println(Solution.solution(7,new int[]{10,4,8,7,6,4,3}));
        System.out.println(Solution.solution(5,new int[]{5,4,3,2,1}));
    }
}
class Solution {
    /**
     * 找到数组中的 最长非递增子序列
     *
     * 思路很简单，定义一个 count
     *
     * 遍历一遍数组，如果 后一个数 比 前一个数 小，那么 count + 1，如果 后一个数 比 前一个数 大，那么 count 重置为 0
     * @param n
     * @param nums
     * @return
     */
    public  static int solution(int n, int[] nums) {
        if(n==0){
            return 0;
        }
        if(nums==null){
            return n;
        }
        if(n>nums.length||n<nums.length){
            n=nums.length;
        }
        int maxCount=0;
        int count =0;
        for(int i = 1; i < n; i++){
            if(nums[i - 1] >= nums[i]){
                count++;
                maxCount = Math.max(count, maxCount);
            }else{
                count = 0;
            }
         }
        return maxCount;
    }
}
