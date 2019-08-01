package com.helloxin.leetcode.algorithms;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1]
 * Output: false
 * Example 2:
 * <p>
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 * <p>
 * Input: [0,3,2,1]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */

import java.util.Arrays;

/**
 * @author: xjye  @create: 2019-08-01
 **/
public class ValidMountainArray941 {

    public boolean validMountainArray(int[] A) {

        //如果是有效的，那么存在一个制高点，两边都是单调递增的 所以就弄两只蚂蚁 让他们走 看汇合不
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) {
            i++;
        }
        while (j > 0 && A[j - 1] > A[j]) {
            j--;
        }
        return i > 0 && i == j && j < n - 1;

    }
}
