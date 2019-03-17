package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by nandiexin on 2019/3/17.
 * <p>
 * 581. Shortest Unsorted Continuous Subarray
 * Easy
 * <p>
 * 1291
 * <p>
 * 63
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray581 {

    public static int findUnsortedSubarray(int[] nums) {

        int nums2[] = nums.clone();
        Arrays.sort(nums2);
        int begin = Integer.MAX_VALUE;
        for(int i =0;i<nums2.length;i++){
            if(begin == Integer.MAX_VALUE && (nums2[i] != nums[i])){
                begin = i;
                break;
            }
        }

        int end = Integer.MAX_VALUE;
        for(int j =nums.length-1;j>=0;j--){
            if(end == Integer.MAX_VALUE && (nums2[j] != nums[j])){
                end = j;
                break;
            }

        }
        if (begin == Integer.MAX_VALUE || end == Integer.MAX_VALUE) {
            return 0;
        }
        return end-begin+1;

    }


    public static void main(String[] args) {


        int candies[] = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(candies));
    }
}
