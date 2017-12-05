package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {

        int nums[] = {2,7,11,15};
        int target = 9;
        int result[] = twoSum(nums,target);
        Arrays.stream(result).forEach(x-> System.out.println(x));
    }
}
