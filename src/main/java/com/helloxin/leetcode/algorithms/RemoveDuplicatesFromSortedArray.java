package com.helloxin.leetcode.algorithms;


/**
 * Given a sorted array, remove the duplicates in-place
 * such that each element appear only once and return the new length.

   Do not allocate extra space for another array,
   you must do this by modifying the input array in-place with O(1) extra memory.

 Example:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */

import java.util.Arrays;

/**
 * create by nandiexin on 2017/12/15
 **/
public class RemoveDuplicatesFromSortedArray {


    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
                //nums[++i] = nums[j];  以上改成这样也是可以的
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates2(nums));
    }
}
