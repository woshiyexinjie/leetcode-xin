package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by nandiexin on 2018/12/12.
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1:

 Input: [3,0,1]
 Output: 2
 Example 2:

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8
 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity
 */
public class MissingNumber268 {

    //正常思维就会想到 正常数据该有的样子减去已有数据
    public static int missingNumber(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int assumeSum = nums.length*(nums.length+1)/2;
            return assumeSum-sum;
    }

    //别人写的代码 就是一下看不懂的
    public static int missingNumber2(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    public static void main(String[] args) {
        int nums[] = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

}
