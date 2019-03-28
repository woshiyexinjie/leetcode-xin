package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/3/27.
 * <p>
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * <p>
 * Note:
 * <p>
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */
public class BinarySearch704 {


    //1.定义起始与结束位置，2.循环判断是否结束，3.计算mid值，比较与target的大小来改变查询策略 mid-1或者mid+1
    public int search(int[] nums, int target) {

        int pre = 0;
        int las = nums.length;
        while (pre <= las) {
            int mid = (pre + las) >>> 1;
            if (nums[mid] < target) {
                pre = mid + 1;
            } else if (nums[mid] > target) {
                las = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
