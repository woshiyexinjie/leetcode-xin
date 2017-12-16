package com.helloxin.leetcode.algorithms;


/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this

 by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:

 Given nums = [3,2,2,3], val = 3,

 Your function should return length = 2, with the first two elements of nums being 2.

 */


/**
 * create by nandiexin on 2017/12/16
 **/
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                //这种感觉和for循环 从后面开始的感觉差不多
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int [] nums = {3,3,3,3,2,3,3,3,3,3};
        System.out.println(removeElement2(nums,3));
    }
}
