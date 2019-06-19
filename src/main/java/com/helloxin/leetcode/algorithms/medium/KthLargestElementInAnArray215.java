package com.helloxin.leetcode.algorithms.medium;

import java.util.Arrays;

/**
 * Created by nandiexin on 2019/5/24.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Example 1:

 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4
 */
public class KthLargestElementInAnArray215 {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length-k];

    }
}
