package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/2/22.
 Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000
 *
 *
 *
 */
public class MaxConsecutiveOnes485 {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int maximumConse = 0;
        int mumConse = 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==1){
                mumConse++;
            }else{
                if(maximumConse < mumConse){
                    maximumConse= mumConse;
                }
                mumConse =0;
            }
            if(maximumConse < mumConse){
                maximumConse= mumConse;
            }
        }
        return maximumConse;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums) {
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        }
        return max;
    }

    public static void main(String[] args) {

        int nums[] ={1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }
}
