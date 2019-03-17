package com.helloxin.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nandiexin on 2019/3/17.
 * <p>
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * <p>
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 */
public class SetMismatch645 {

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n+1)) / 2;
        for(int i : nums) {
            if(set.contains(i)) {
                duplicate = i;
            }
            sum -= i;
            set.add(i);
        }
        return new int[] {duplicate, (int)sum + duplicate};
    }

    public static int[] findErrorNums2(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                res[0] = Math.abs(i);
            } else {
                nums[Math.abs(i) - 1] *= -1;
            }
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) {
                res[1] = i+1;
            }
        }
        return res;
    }


}
