package com.helloxin.leetcode.algorithms;

import java.util.stream.IntStream;

/**
 * Created by nandiexin on 2019/3/17.
 *Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

 Example 1:

 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75


 Note:

 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].
 *
 */
public class MaximumAverageSubarrayI643 {

    public static double findMaxAverage(int[] nums, int k) {
        int sum = IntStream.range(0, k).map(i -> nums[i]).sum();
        return IntStream.range(k, nums.length).boxed().reduce(
                new int[] {sum - nums[0], sum},
                (arr, i) -> new int[] {arr[0] + nums[i] - nums[i-k+1], Math.max(arr[1], arr[0] + nums[i])},
                (x, y) -> x)[1] / (double)k;

    }

    //这种方式也是把所有的数据算一遍 然后取最大的
    public double findMaxAverage2(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }
}
