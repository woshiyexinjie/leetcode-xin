package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/5/8.
 * <p>
 * 我们把符合下列属性的数组 A 称作山脉：
 * <p>
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,0]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 */
public class PeakIndexInAMountainArray852 {

    //居然有这么一道题
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1; // no peak.
    }

    public int peakIndexInMountainArray2(int[] A) {
        for (int i = 1; i + 1 < A.length; ++i) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }
        return 0;
    }

}
