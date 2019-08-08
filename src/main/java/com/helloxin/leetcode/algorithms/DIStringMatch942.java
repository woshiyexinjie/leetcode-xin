package com.helloxin.leetcode.algorithms;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * <p>
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * <p>
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 * <p>
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 * <p>
 * Input: "DDI"
 * Output: [3,2,0,1]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 */


import java.util.Arrays;

/**
 * @author: xjye  @create: 2019-08-02
 **/
public class DIStringMatch942 {

    //思考了很久 没有什么思路 因为我总是纠结在峰值和低谷的地方
    //看了大神的思路 就是其实满足其中一个要求的数据 没必要全盘考虑
    //这题可以让上下浮动这种事情来让 S中的字符来决定
    public static int[] diStringMatch(String S) {

        int n = S.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            res[i] = S.charAt(i) == 'I' ? left++ : right--;
        }
        res[n] = left;
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(diStringMatch("IDDD")));

    }
}
