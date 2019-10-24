package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by yexin on 2019/10/24.
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
 * <p>
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * Example 2:
 * <p>
 * Input: [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 * Example 3:
 * <p>
 * Input: [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * <p>
 * <p>
 * Note:
 * <p>
 * 3 <= A.length <= 50000
 * -10000 <= A[i] <= 10000
 */
public class PartitionArrayIntoThreePartsWithEqualSum1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum(), part = 0, cnt = 0;
        if (sum % 3 != 0) {
            return false;
        }
        for (int a : A) {
            part += a;
            if (part != sum / 3) {
                continue;
            }
            if (++cnt == 3) {
                return true;
            }
            part = 0;
        }
        return false;
    }
}
