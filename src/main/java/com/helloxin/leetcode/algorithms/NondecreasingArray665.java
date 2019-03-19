package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/3/18.
 * <p>
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * <p>
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * <p>
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * Note: The n belongs to [1, 10,000].
 */
public class NondecreasingArray665 {

    //按照题目的意思是改变一个数字变成递增数组啊


    //这里的解题逻辑是假设已经调整后的结果 看后续还需要不需要调整
    public static boolean checkPossibility(int[] nums) {

        if (nums.length == 1) {
            return true;
        }
        boolean change = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if(change==true){
                   return false;
                }
                if(i-2>=0){
                    if(nums[i] < nums[i - 2]){
                        nums[i] =nums[i-1];
                    }else{
                        nums[i-1] =nums[i];
                    }
                }else{
                    nums[i-1] =nums[i];
                }
                change = true;
            }
        }
        return true;
    }

    //其他人比我会写的简洁一点
    public boolean checkPossibility2(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return cnt<=1;
    }


    public static void main(String[] args) {


        int nums[]={4,2,3};
        System.out.println(checkPossibility(nums));

        //测试一下 版本1
    }
}
